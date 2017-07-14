/*
 * Copyright 2017 Volodymyr Fedorchuk <vl.fedorchuck@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.fedorchuck.jsqlb.postgresql;

import com.github.fedorchuck.jsqlb.Column;
import com.github.fedorchuck.jsqlb.JSQLBuilder;
import com.github.fedorchuck.jsqlb.SET;
import com.github.fedorchuck.jsqlb.Table;
import com.github.fedorchuck.jsqlb.postgresql.PostgreSQL;
import com.github.fedorchuck.jsqlb.postgresql.PostgreSQLConditionalExpression;
import com.github.fedorchuck.jsqlb.postgresql.PostgreSQLDataTypes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="http://vl-fedorchuck.rhcloud.com/">Volodymyr Fedorchuk</a>.
 */
public class PostgreSQL_CRUD_Test {
    private JSQLBuilder manager;
    private Table table1;
    private Table table2;

    @Before
    public void setUp() {
        manager = new PostgreSQL();

        table1 = new Table("table1");
        table1.addColumn("column1", PostgreSQLDataTypes.TEXT);
        table1.addColumn("column2", PostgreSQLDataTypes.NUMBER);
        table2 = new Table("table2");
        table2.addColumn("column3", PostgreSQLDataTypes.DATETIME);
        table2.addColumn(new Column("column4", PostgreSQLDataTypes.NUMBER));
    }

    @Test
    public void create() {
        String expected;
        String actual;

        expected = "INSERT INTO table1 ( column1 ) VALUES ( ? )";
        actual = manager
                .insert(table1, table1.getColumn("column1")).getSQL();
        Assert.assertEquals(expected, actual);
        expected = "INSERT INTO table1 ( column1, column2 ) VALUES ( ?, ? )";
        actual = manager
                .insert(table1, table1.getColumns()).getSQL();
        Assert.assertEquals(expected, actual);
        expected = "INSERT INTO table1 ( column1 ) VALUES ( ? )";
        actual = manager
                .insert(table1, table1.getColumnsExcept(table1.getColumn("column2"))).getSQL();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void read() {
        String expected;
        String actual;

        expected = "SELECT * FROM table1 WHERE column2 > 5 ";
        actual = manager
                .select().from(table1)
                .where("column2 > 5")
                .getSQL();
        Assert.assertEquals(expected, actual);

        expected = "SELECT table1.column1, table1.column2, table2.column3 FROM table1, table2 WHERE column3 > '5' ";
        actual = manager
                .select(table1.getColumn("column1"),
                        table1.getColumn("column2"),
                        table2.getColumn("column3"))
                .from(table1, table2)
                .where(new PostgreSQLConditionalExpression(table2.getColumn("column3")).moreThen("5"))
                .getSQL();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void update() {
        String expected;
        String actual;

        expected = "UPDATE table1 SET column1 = value1, column2 = value2 WHERE column2 > '5' ";
        actual = manager
                .update(table1,
                        new SET(table1.getColumn("column1"), "value1"),
                        new SET("column2", "value2"))
                .where(new PostgreSQLConditionalExpression(table1.getColumn("column2")).moreThen("5"))
                .getSQL();
        Assert.assertEquals(expected, actual);

        expected = "UPDATE table1 SET column1 = ?, column2 = ? WHERE column2 > '5' ";
        actual = manager
                .update(table1, table1.getColumns())
                .where(new PostgreSQLConditionalExpression(table1.getColumn("column2")).moreThen("5"))
                .getSQL();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void delete() {
        String expected;
        String actual;

        expected = "DELETE FROM table1 ";
        actual = manager.delete(table1).getSQL();
        Assert.assertEquals(expected, actual);
    }

}