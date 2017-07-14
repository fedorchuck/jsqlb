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
import lombok.Setter;
import lombok.ToString;

/**
 * @author <a href="http://vl-fedorchuck.rhcloud.com/">Volodymyr Fedorchuk</a>.
 */
@Getter
@ToString
public class Column {
    private final String name;
    @Setter
    private String nameWithTablePrefix;
    private final DataTypes type;
    private String convert;

    public Column(String name, DataTypes type) {
        this.name = name;
        this.type = type;
    }


    public Column setConvert(DataTypes from, DataTypes to, DataTypes as) {
        this.convert = "";
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Column column = (Column) o;

        if (!name.equals(column.name)) return false;
        if (!type.equals(column.type)) return false;
        return convert != null ? convert.equals(column.convert) : column.convert == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + (convert != null ? convert.hashCode() : 0);
        return result;
    }
}
