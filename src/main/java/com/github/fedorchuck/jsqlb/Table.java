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

import lombok.Getter;

import java.util.LinkedList;

/**
 * @author <a href="http://vl-fedorchuck.rhcloud.com/">Volodymyr Fedorchuk</a>.
 */
public class Table {
    @Getter
    private final String tableName;
    private final LinkedList<Column> allColumns = new LinkedList<>();

    public Table(String tableName) {
        this.tableName = tableName;
    }

    public Table addColumn(String name, DataTypes type) {
        this.addColumn(new Column(name, type));
        return this;
    }

    public Table addColumn(Column column) {
        if (this.exist(column))
            throw new IllegalArgumentException("Column exist.");

        column.setNameWithTablePrefix(this.tableName+'.'+column.getName());
        this.allColumns.add(column);
        return this;
    }

    public Table removeColumn(String name) {
        for (Column column : allColumns) {
            if (column.getName().equals(name)) {
                this.allColumns.remove(column);
                break;
            }
        }
        return this;
    }

    public Table removeColumn(Column column) {
        this.allColumns.remove(column);
        return this;
    }

    public Column getColumn(String name) {
        for (Column column : allColumns) {
            if (column.getNameWithTablePrefix().endsWith(name)) {
                return column;
            }
        }
        return null;
    }

    public Column[] getColumns() {
        return allColumns.toArray(new Column[]{});
    }

    public Column[] getColumnsExcept(Column... columns) {
        for (Column column : columns) {
            if (!this.exist(column))
                throw new IllegalArgumentException("Column does not exist in this table. " +
                        "Please check column name, table, configuration of JSQLBuilder.");
        }

        Column[] result = new Column[allColumns.size()-columns.length];
        int position = 0;
        for (Column column : allColumns) {
            if (!arrayContains(columns, column)) {
                result[position] = column;
                position++;
            }
        }
        return result;
    }

    public boolean exist(Column column) {
        return this.allColumns.contains(column);
    }

    private <T> boolean arrayContains(T[] array, T element) {
        for (T anArray : array)
            if (anArray.equals(element))
                return true;

        return false;
    }
}
