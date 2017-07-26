package com.github.fedorchuck.jsqlb;

import com.github.fedorchuck.jsqlb.postgresql.datatypes.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href="http://vl-fedorchuck.rhcloud.com/">Volodymyr Fedorchuk</a>.
 */
public class OrderTest {

    @Test
    public void test() {
        String expected;
        String actual;

        Table table1 = new Table("table1");
        table1.addColumn("column1", new JSON());
        table1.addColumn("column2", new JSONB());
        table1.addColumn("column3", new INET());

        expected = " table1.column1 ASC";
        actual = new Order(table1.getColumn("column1")).getSQL();
        Assert.assertEquals(expected, actual);

        expected = " table1.column1, table1.column2, table1.column3 DESC";
        actual = new Order(Order.Sort.DESC,
                table1.getColumn("column1"),
                table1.getColumn("column2"),
                table1.getColumn("column3")
        ).getSQL();
        Assert.assertEquals(expected, actual);
    }
}