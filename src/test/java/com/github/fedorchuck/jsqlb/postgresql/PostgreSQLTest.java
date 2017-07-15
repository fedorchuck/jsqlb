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
import com.github.fedorchuck.jsqlb.Table;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="http://vl-fedorchuck.rhcloud.com/">Volodymyr Fedorchuk</a>.
 */
public class PostgreSQLTest {
    private JSQLBuilder manager;
    private Table table1;
    private Table table2;

    @Before
    public void setUp() {
        table1 = new Table("table1");
        table1.addColumn("column1", PGDataTypes.TEXT);
        table1.addColumn("column2", PGDataTypes.BOOLEAN);
        table2 = new Table("table2");
        table2.addColumn("column3", PGDataTypes.DATE);
        table2.addColumn(new Column("column4", PGDataTypes.BOOLEAN));

        manager = new PostgreSQL();
    }

    @Test
    public void select() {
        String expected;
        String actual;

        expected = "sql: SELECT * ";
        actual = manager.select().toString();
        Assert.assertEquals(expected, actual);
        manager.flush();

        expected = "sql: SELECT table1.column2, table2.column3, table2.column4 ";
        actual = manager.select(
                table1.getColumn("column2"),
                table2.getColumn("column3"), table2.getColumn("column4"))
                .toString();
        Assert.assertEquals(expected, actual);
        manager.flush();

        try {
            manager.select(table1.getColumn("column4"));
            Assert.fail("Should be exception 'IllegalArgumentException' with message 'Column does not exist in this table'");
        } catch (IllegalArgumentException expectedException) {
            if (expectedException.getMessage().contains("Column does not exist in this table"))
                Assert.assertTrue(true);
            else
                Assert.fail("Should be exception 'IllegalArgumentException' with message 'Column does not exist in this table'" +
                        " current message: " + expectedException.getMessage());
        }
        manager.flush();
    }

    @Test
    public void from() {
        String expected;
        String actual;

        try {
            manager.from();
            Assert.fail("Should be exception 'IllegalArgumentException' with message 'Table's name missed.'");
        } catch (IllegalArgumentException expectedException) {
            if (expectedException.getMessage().contains("Table's name missed."))
                Assert.assertTrue(true);
            else
                Assert.fail("Should be exception 'IllegalArgumentException' with message 'Table's name missed.'" +
                        " current message: " + expectedException.getMessage());
        }

        expected = "sql: FROM table1 ";
        actual = manager.from(table1).toString();
        Assert.assertEquals(expected, actual);
        manager.flush();

        expected = "sql: FROM table1, table2 ";
        actual = manager.from(table1, table2).toString();
        Assert.assertEquals(expected, actual);
        manager.flush();
    }

    @Test
    public void where() {
        String expected;
        String actual;
        Column column1 = new Column("column1", PGDataTypes.TEXT);
        Column column2 = new Column("column2", PGDataTypes.TEXT);

        expected = "sql: WHERE id = 5 ";
        actual = manager.where("id = 5").toString();
        Assert.assertEquals(expected, actual);
        manager.flush();

        expected = "sql: WHERE column1 > ? ";
        actual = manager.where(new PGConditionalExpression(column1).moreThen()).toString();
        Assert.assertEquals(expected, actual);
        manager.flush();

        expected = "sql: WHERE column1 > ? AND column2 < ? ";
        actual = manager.where(new PGConditionalExpression(column1).moreThen().and(column2).lessThen()).toString();
        Assert.assertEquals(expected, actual);
        manager.flush();
    }
}