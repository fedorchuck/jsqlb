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

/**
 * @author <a href="http://vl-fedorchuck.rhcloud.com/">Volodymyr Fedorchuk</a>.
 */
public abstract class JSQLBuilder {

//    /**
//     * Returning part of SQL string.
//     * @param allFieldsAndTheirTypes should contains name of filed as key and type of this field at a database as value.
//     * @return part of SQL code as string
//     **/
//    public abstract String getFieldsForInsert(LinkedHashMap<String, DataTypes> allFieldsAndTheirTypes);
//
//    /**
//     * Returning part of SQL string.
//     * @param fieldName of fields witch should not be include of the string
//     * @param allFieldsAndTheirTypes should contains name of filed as key and type of this field at a database as value.
//     * @return part of SQL code as string
//     **/
//    public abstract String getFieldsForInsertExcept(String fieldName, LinkedHashMap<String, DataTypes> allFieldsAndTheirTypes);
//
//    /**
//     * Returning part of SQL string.
//     * Converted values: <pre>
//     * <b>datetime</b> as datetime
//     * <b>string</b> as string
//     * <b>number</b> as number
//     * <b>uuid</b> as "CONVERT(VARCHAR(36), uuid ) as uuid, "
//     * </pre>
//     * @param allFieldsAndTheirTypes should contains name of filed as key and type of this field at a database as value.
//     * @return part of SQL code as string
//     **/
//    public abstract String getFieldsForSelect(LinkedHashMap<String, DataTypes> allFieldsAndTheirTypes);
//
//
//    /**
//     * Returning part of SQL string.
//     * Converted values: <pre>
//     * <b>datetime</b> as datetime
//     * <b>string</b> as string
//     * <b>number</b> as number
//     * <b>uuid</b> as "CONVERT(VARCHAR(36), uuid ) as uuid, "
//     * </pre>
//     * @param fieldName  of fields witch should not be include of the string
//     * @param allFieldsAndTheirTypes should contains name of filed as key and type of this field at a database as value.
//     * @return part of SQL code as string
//     **/
//    public abstract String getFieldsForSelectExcept(String fieldName, LinkedHashMap<String, DataTypes> allFieldsAndTheirTypes);

//    public abstract JSQLBuilder select();

    public abstract JSQLBuilder select(Column... columns);

    public abstract JSQLBuilder from(Table... tables);

    public abstract JSQLBuilder where(String conditionalExpression);

    public abstract JSQLBuilder where(ConditionalExpression conditionalExpression);

    public abstract JSQLBuilder insert(Table table, Column... column);

    public abstract JSQLBuilder update(Table table, Column... columns);

    public abstract JSQLBuilder update(Table table, SET... set);

    public abstract JSQLBuilder delete(Table table);

    public abstract String getSQL();

    public abstract void flush();
}
