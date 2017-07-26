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

import com.github.fedorchuck.jsqlb.*;
import com.github.fedorchuck.jsqlb.postgresql.datatypes.*;
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
    private Table table3;

    @Before
    public void setUp() {
        manager = new PostgreSQL();

        table1 = new Table("table1");
        table1.addColumn("column1", new TEXT());
        table1.addColumn("column2", new BOOLEAN());
        table1.addColumn("column3", new INT());
        table1.addColumn("column4", new INT());
        table1.addColumn("column5", new INT());

        table2 = new Table("table2");
        table2.addColumn("column1", new BOOLEAN());
        table2.addColumn("column2", new INT());
        table2.addColumn("column3", new DATE());
        table2.addColumn(new Column("column4", new BOOLEAN()));
        table2.addColumn("column5", new INT());

        table3 = new Table("table3");
        table3.addColumn("column1", new BOOLEAN());
        table3.addColumn("column2", new INT());
        table3.addColumn(new Column("column4", new BIGINT()));
        table3.addColumn(new Column("column5", new BIGSERIAL()));
    }

    @Test
    public void create() {
        String expected;
        String actual;

        try {
            manager.insert(table1, new Column[]{}).getSQL();
            Assert.fail("Should be exception 'IllegalArgumentException' with message 'Column does not exist in this table. " +
                    "Please check column name, table, configuration of JSQLBuilder.'");
        } catch (IllegalArgumentException expectedException) {
            if (expectedException.getMessage().contains("Column does not exist in this table. " +
                    "Please check column name, table, configuration of JSQLBuilder."))
                Assert.assertTrue(true);
            else
                Assert.fail("Should be exception 'IllegalArgumentException' with message 'Column does not exist in this table. " +
                        "Please check column name, table, configuration of JSQLBuilder.'" +
                        " current message: " + expectedException.getMessage());
        }

        expected = "INSERT INTO table1 ( column1 ) VALUES ( ? ) ";
        actual = manager
                .insert(table1, table1.getColumn("column1")).getSQL();
        Assert.assertEquals(expected, actual);
        expected = "INSERT INTO table1 ( column1, column2, column3, column4, column5 ) VALUES ( ?, ?, ?, ?, ? ) ";
        actual = manager
                .insert(table1, table1.getColumns()).getSQL();
        Assert.assertEquals(expected, actual);
        expected = "INSERT INTO table1 ( column1, column3, column4, column5 ) VALUES ( ?, ?, ?, ? ) ";
        actual = manager
                .insert(table1, table1.getColumnsExcept(table1.getColumn("column2"))).getSQL();
        Assert.assertEquals(expected, actual);
        expected = "INSERT INTO table1 ( column1, column3, column4, column5 ) VALUES ( ?, ?, ?, ? ) RETURNING * ";
        actual = manager
                .insert(table1, table1.getColumnsExcept(table1.getColumn("column2"))).returning().getSQL();
        Assert.assertEquals(expected, actual);
        expected = "INSERT INTO table1 ( column1, column2, column3, column4, column5 ) VALUES ( ?, ?, ?, ?, ? ) RETURNING table1.column1 ";
        actual = manager
                .insert(table1, table1.getColumns()).returning(table1.getColumn("column1")).getSQL();
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

        expected = "SELECT table1.column1, table1.column2, table2.column3 FROM table1, table2 WHERE table2.column3 > '5' ";
        actual = manager
                .select(table1.getColumn("column1"),
                        table1.getColumn("column2"),
                        table2.getColumn("column3"))
                .from(table1, table2)
                .where(new PGConditionalExpression(table2.getColumn("column3")).moreThen("5"))
                .getSQL();
        Assert.assertEquals(expected, actual);

        expected = "SELECT table1.column1, table1.column2, table2.column3, table3.column5 " +
                "FROM table1 " +
                "INNER JOIN table2 ON table1.column4 = table2.column5 AND table2.column2 = ? OR table2.column2 = ? AND table2.column1 = true " +
                "LEFT OUTER JOIN table3 ON table1.column5 = table3.column2 AND table3.column1 = true " +
                "WHERE table1.column3 = ? ";
        actual = manager
                .select(table1.getColumn("column1"),
                        table1.getColumn("column2"),
                        table2.getColumn("column3"),
                        table3.getColumn("column5"))
                .from(table1)
                .innerJoin(table2).on(
                        new PGConditionalExpression(table1.getColumn("column4")).equal(table2.getColumn("column5"))
                        .and(table2.getColumn("column2")).equal()
                        .or(table2.getColumn("column2")).equal()
                        .and(table2.getColumn("column1")).equal(true)
                )
                .leftOuterJoin(table3).on(
                        new PGConditionalExpression(table1.getColumn("column5")).equal(table3.getColumn("column2"))
                        .and(table3.getColumn("column1")).equal(true)
                )
                .where(new PGConditionalExpression(table1.getColumn("column3")).equal())
                .getSQL();
        Assert.assertEquals(expected, actual);

        expected = "SELECT * FROM table1 ORDER BY table1.column3 ASC ";
        actual = manager
                .select()
                .from(table1)
                .orderBy(new Order(table1.getColumn("column3")))
                .getSQL();
        Assert.assertEquals(expected, actual);

        expected = "SELECT * FROM table1 ORDER BY table1.column3, table1.column5 ASC, table1.column4 DESC ";
        actual = manager
                .select()
                .from(table1)
                .orderBy(
                        new Order(Order.Sort.ASC, table1.getColumn("column3"), table1.getColumn("column5")),
                        new Order(Order.Sort.DESC, table1.getColumn("column4"))
                )
                .getSQL();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void update() {
        String expected;
        String actual;

        expected = "UPDATE table1 SET table1.column1 = value1, column2 = value2 WHERE table1.column2 > '5' ";
        actual = manager
                .update(table1,
                        new SET(table1.getColumn("column1"), "value1"),
                        new SET("column2", "value2"))
                .where(new PGConditionalExpression(table1.getColumn("column2")).moreThen("5"))
                .getSQL();
        Assert.assertEquals(expected, actual);

        expected = "UPDATE table1 SET column1 = ?, column2 = ?, column3 = ?, column4 = ?, column5 = ? WHERE table1.column2 > '5' ";
        actual = manager
                .update(table1, table1.getColumns())
                .where(new PGConditionalExpression(table1.getColumn("column2")).moreThen("5"))
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