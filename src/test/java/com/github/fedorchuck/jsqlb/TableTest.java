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

package com.github.fedorchuck.jsqlb;

import com.github.fedorchuck.jsqlb.postgresql.PostgreSQLDataTypes;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href="http://vl-fedorchuck.rhcloud.com/">Volodymyr Fedorchuk</a>.
 */
public class TableTest {

    @Test
    public void addColumn() {
        Table table = new Table("table");
        Column column1 = new Column("column1", PostgreSQLDataTypes.TEXT);
        Column column2 = new Column("column2", PostgreSQLDataTypes.DATETIME);

        table.addColumn(column1);
        Assert.assertEquals(true, table.exist(column1));

        table.addColumn("column2", PostgreSQLDataTypes.DATETIME);
        Assert.assertEquals(true, table.exist(column2));

        try {
            table.addColumn(column1);
            Assert.fail("Should be exception 'IllegalArgumentException' with message 'Column exist.'");
        } catch (IllegalArgumentException expectedException) {
            if (expectedException.getMessage().contains("Column exist."))
                Assert.assertTrue(true);
            else
                Assert.fail("Should be exception 'IllegalArgumentException' with message 'Column exist.'" +
                        " current message: " + expectedException.getMessage());
        }
    }

    @Test
    public void removeColumn() {
        Table table = new Table("table");
        Column column1 = new Column("column1", PostgreSQLDataTypes.TEXT);
        Column column2 = new Column("column2", PostgreSQLDataTypes.DATETIME);

        table.addColumn(column1);
        table.addColumn(column2);

        Assert.assertEquals(false, table.removeColumn(column1).exist(column1));
        Assert.assertEquals(false, table.removeColumn("column2").exist(column2));
    }

    @Test
    public void getColumn() {
        Table table = new Table("table");
        Column column1 = new Column("column1", PostgreSQLDataTypes.TEXT);
        Column column2 = new Column("column2", PostgreSQLDataTypes.DATETIME);

        table.addColumn(column1);
        table.addColumn(column2);

        Assert.assertEquals(column1, table.getColumn("column1"));
        Assert.assertEquals(column1, table.getColumn("table.column1"));
        Assert.assertEquals(null, table.getColumn("column3"));
    }

    @Test
    public void getInsertColumns() {
        Table table = new Table("table");
        Column column1 = new Column("column1", PostgreSQLDataTypes.TEXT);
        Column column2 = new Column("column2", PostgreSQLDataTypes.DATETIME);

        table.addColumn(column1);
        table.addColumn(column2);

        Assert.assertArrayEquals(new Column[]{column1, column2}, table.getColumns());
    }

    @Test
    public void getInsertColumnsExcept() {
        Table table = new Table("table");
        Column column1 = new Column("column1", PostgreSQLDataTypes.TEXT);
        Column column2 = new Column("column2", PostgreSQLDataTypes.DATETIME);
        Column column3 = new Column("column3", PostgreSQLDataTypes.DATETIME);
        Column column4 = new Column("column4", PostgreSQLDataTypes.NUMBER);

        table.addColumn(column1);
        table.addColumn(column2);
        table.addColumn(column3);
        table.addColumn(column4);

        Assert.assertArrayEquals(new Column[]{column1, column2}, table.getColumnsExcept(column3, column4));
    }
}