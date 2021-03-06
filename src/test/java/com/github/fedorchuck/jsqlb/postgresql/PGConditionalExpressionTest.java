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
import com.github.fedorchuck.jsqlb.postgresql.datatypes.TEXT;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="http://vl-fedorchuck.rhcloud.com/">Volodymyr Fedorchuk</a>.
 */
public class PGConditionalExpressionTest {
    private Column column1;
    private Column column2;
    private PGConditionalExpression conditionalExpression;

    @Before
    public void setUp() {
        column1 = new Column("column1", new TEXT());
        column2 = new Column("column2", new TEXT());
        conditionalExpression = new PGConditionalExpression(column1);
    }

    @Test
    public void moreThen() {
        String expected;
        String actual;

        try {
            new PGConditionalExpression(null);
            Assert.fail("Should be exception 'IllegalArgumentException' with message 'Column can not be 'null'.'");
        } catch (IllegalArgumentException expectedException) {
            if (expectedException.getMessage().contains("Column can not be 'null'."))
                Assert.assertTrue(true);
            else
                Assert.fail("Should be exception 'IllegalArgumentException' with message 'Column can not be 'null'.'" +
                        " current message: " + expectedException.getMessage());
        }

        expected = "sql: column1 > ? ";
        actual = new PGConditionalExpression(column1).moreThen().toString();
        Assert.assertEquals(expected, actual);

        expected = "sql: column1 > '5' ";
        actual = new PGConditionalExpression(column1).moreThen("5").toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void lessThen() {
        String expected;
        String actual;

        expected = "sql: column1 < ? ";
        actual = new PGConditionalExpression(column1).lessThen().toString();
        Assert.assertEquals(expected, actual);

        expected = "sql: column1 < '5' ";
        actual = new PGConditionalExpression(column1).lessThen("5").toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void equal() {
        String expected;
        String actual;

        expected = "sql: column1 = ? ";
        actual = new PGConditionalExpression(column1).equal().toString();
        Assert.assertEquals(expected, actual);

        expected = "sql: column1 = '5' ";
        actual = new PGConditionalExpression(column1).equal("5").toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void and() {
        String expected;
        String actual;

        conditionalExpression.bufferCleanup();
        expected = "sql: AND column2 ";
        actual = conditionalExpression.and(column2).toString();
        Assert.assertEquals(expected, actual);
        conditionalExpression.bufferCleanup();
    }

    @Test
    public void or() {
        String expected;
        String actual;

        conditionalExpression.bufferCleanup();
        expected = "sql: OR column2 ";
        actual = conditionalExpression.or(column2).toString();
        Assert.assertEquals(expected, actual);
        conditionalExpression.bufferCleanup();
    }

}