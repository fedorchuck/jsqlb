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
import lombok.EqualsAndHashCode;

/**
 * @author <a href="http://vl-fedorchuck.rhcloud.com/">Volodymyr Fedorchuk</a>.
 */
@EqualsAndHashCode(callSuper = true)
public class PostgreSQL extends JSQLBuilder {
    private StringBuilder sql = new StringBuilder();

    @Override
    public JSQLBuilder select(Column... columns) {
        this.sql.append("SELECT");
        if (columns.length == 0) {
            this.sql.append(" *");
        } else {
            addSelectStatement(columns);
            this.sql.deleteCharAt(this.sql.length()-1);
        }
        this.sql.append(' ');
        return this;
    }

    @Override
    public JSQLBuilder from(Table... tables) {
        if (tables.length == 0)
            throw new IllegalArgumentException("Table's name missed.");
        this.sql.append("FROM");
        for (Table table : tables) {
            this.sql
                    .append(" ")
                    .append(table.getTableName())
                    .append(",");
        }
        this.sql.deleteCharAt(this.sql.length()-1);
        this.sql.append(' ');
        return this;
    }

    @Override
    public JSQLBuilder where(String conditional) {
        this.sql.append("WHERE ");
        this.sql.append(conditional).append(" ");
        return this;
    }

    @Override
    public JSQLBuilder where(ConditionalExpression conditionalExpression) {
        this.sql.append("WHERE ");
        this.sql.append(conditionalExpression.getSQL());
        return this;
    }

    @Override
    public JSQLBuilder insert(Table table, Column... columns) {
        if ( (columns == null) || (columns.length == 0) )
            throw new IllegalArgumentException("Column does not exist in this table. " +
                    "Please check column name, table, configuration of JSQLBuilder.");
        StringBuilder names = new StringBuilder();
        StringBuilder values = new StringBuilder();
        for (Column column : columns) {
            names.append(column.getName()).append(", ");
            values.append("?, ");
        }
        names.deleteCharAt(names.length()-2);
        values.deleteCharAt(values.length()-2);

        this.sql
                .append("INSERT INTO ")
                .append(table.getTableName())
                .append(" ( ")
                .append(names)
                .append(") VALUES ( ")
                .append(values)
                .append(")");
        return this;
    }

    @Override //update with params //UPDATE table1 SET column1 = ?, column2 = ?
    public JSQLBuilder update(Table table, Column... columns) {
        StringBuilder set = new StringBuilder();
        for (Column column : columns)
            set
                    .append(column.getName())
                    .append(" = ")
                    .append("?, ");

        set.deleteCharAt(set.length()-2);
        this.sql
                .append("UPDATE ")
                .append(table.getTableName())
                .append(" SET ")
                .append(set);
        return this;
    }

    @Override //UPDATE table1 SET column1 = value1, column2 = value2
    public JSQLBuilder update(Table table, SET... set) {
        StringBuilder stringSet = new StringBuilder();
        for (SET s : set)
            stringSet
                    .append(s.getColumn())
                    .append(" = ")
                    .append(s.getValue())
                    .append(", ");

        stringSet.deleteCharAt(stringSet.length()-2);
        this.sql
                .append("UPDATE ")
                .append(table.getTableName())
                .append(" SET ")
                .append(stringSet);
        return this;
    }

    @Override
    public JSQLBuilder delete(Table table) {
        this.sql
                .append("DELETE FROM ")
                .append(table.getTableName())
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

    private void addSelectStatement(Column[] columns) {
        for (Column column : columns) {
            if (column == null)
                throw new IllegalArgumentException("Column does not exist in this table. " +
                        "Please check column name, table, configuration of JSQLBuilder.");

//            switch ((PGDataTypes) column.getType()) {
//                case DATE:
//                case TEXT:
//                default:
                    this.sql.append(" ");
                    if (column.getNameWithTablePrefix() == null)
                        this.sql.append(column.getName());
                    else
                        this.sql.append(column.getNameWithTablePrefix());
                    this.sql.append(",");
//                    break;
//                case UUID:
//                    this.sql
//                            .append(" ").append("CONVERT(VARCHAR(36), ")
//                            .append(entry.getKey()).append(" ) as ")
//                            .append(entry.getKey()).append(",");
//                    break;
//            }
        }
    }

    @Override
    public String toString() {
        return "sql: " + sql;
    }
}
