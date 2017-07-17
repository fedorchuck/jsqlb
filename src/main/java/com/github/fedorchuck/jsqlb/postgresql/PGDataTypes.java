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

import com.github.fedorchuck.jsqlb.DataTypes;

/**
 * This enum hold the data types used in PostgreSQL. While creating table, for each column,
 * you specify a data type, i.e., what kind of data you want to store in the table fields.
 * <p>
 * PostgreSQL supports a wide set of Data Types, but this library not supported it.
 *
 * @author <a href="http://vl-fedorchuck.rhcloud.com/">Volodymyr Fedorchuk</a>.
 * @see <a href="https://www.postgresql.org/docs/9.5/static/datatype.html">https://www.postgresql.org/docs/9.5/static/datatype.html</a>
 * @since 0.1.0
 */
public interface PGDataTypes extends DataTypes {
//    /** Time span. Composed of a number of integer fields, representing a period of time, depending on the type of interval. NOT SUPPORTED */
//    INTERVAL("INTERVAL"),
//    /** Exact numeric of selectable precision. Exact numerical, precision p, scale s. Example: decimal(3, 2) is a number that has 3 digits before the decimal and 2 digits after the decimal. NOT SUPPORTED */
//    NUMERIC("NUMERIC"),
}
