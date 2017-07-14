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
import com.github.fedorchuck.jsqlb.ConditionalExpression;

/**
 * @author <a href="http://vl-fedorchuck.rhcloud.com/">Volodymyr Fedorchuk</a>.
 */
public class PostgreSQLConditionalExpression extends ConditionalExpression {
    private StringBuilder sql = new StringBuilder();

    public PostgreSQLConditionalExpression(Column column) {
        if (column == null)
            throw new IllegalArgumentException("Column can not be 'null'. " +
                    "Please check column name, table, configuration of JSQLBuilder.");
        this.sql
                .append(column.getName())
                .append(' ');
    }

    @Override
    public ConditionalExpression moreThen() {
        this.sql.append("> ? ");
        return this;
    }

    @Override
    public ConditionalExpression moreThen(String value) {
        this.sql
                .append("> ")
                .append('\'')
                .append(value)
                .append('\'')
                .append(' ');
        return this;
    }

    @Override
    public ConditionalExpression lessThen() {
        this.sql.append("< ? ");
        return this;
    }

    @Override
    public ConditionalExpression lessThen(String value) {
        this.sql
                .append("< ")
                .append('\'')
                .append(value)
                .append('\'')
                .append(' ');
        return this;
    }

    @Override
    public ConditionalExpression equal() {
        this.sql.append("= ? ");
        return this;
    }

    @Override
    public ConditionalExpression equal(String value) {
        this.sql
                .append("= ")
                .append('\'')
                .append(value)
                .append('\'')
                .append(' ');
        return this;
    }

    @Override
    public ConditionalExpression and(Column column) {
        this.sql
                .append("AND ")
                .append(column.getName())
                .append(' ');
        return this;
    }

    @Override
    public ConditionalExpression or(Column column) {
        this.sql
                .append("OR ")
                .append(column.getName())
                .append(' ');
        return this;
    }

    @Override
    public String getSQL() {
        String response = this.sql.toString();
        this.flush();
        return response;
    }

    @Override
    public void flush() {
        this.sql.delete(0, this.sql.length());
    }

    @Override
    public String toString() {
        return "sql: " + sql;
    }
}
