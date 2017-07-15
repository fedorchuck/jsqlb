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
import lombok.Getter;

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
public enum PGDataTypes implements DataTypes {
    /**
     * Signed eight-byte integer
     */
    BIGINT("BIGINT"),
    /**
     * Autoincrementing eight-byte integer
     */
    BIGSERIAL("BIGSERIAL"),
    /**
     * Fixed-length bit string. Set capacity {@link PGDataTypes#BIT(int)}
     */
    BIT("BIT"),
    /**
     * Variable-length bit string. Same {@link PGDataTypes#BIT_VARYING}. Set capacity {@link PGDataTypes#VARBIT(int)}
     */
    VARBIT("VARBIT"),
    /**
     * Variable-length bit string. Same {@link PGDataTypes#VARBIT}. Set capacity {@link PGDataTypes#BIT_VARYING(int)}
     */
    BIT_VARYING("BIT VARYING"),
    /**
     * Logical Boolean (true/false)
     */
    BOOLEAN("BOOLEAN"),
    /**
     * Rectangular box on a plane
     */
    BOX("BOX"),
    /**
     * binary data ("byte array")
     */
    BYTEA("BYTEA"),
    /**
     * Fixed-length character string. Same {@link PGDataTypes#CHARACTER}. Set capacity {@link PGDataTypes#CHAR(int)}
     */
    CHAR("CHAR"),
    /**
     * Character string. Fixed-length. Same {@link PGDataTypes#CHAR}. Set capacity {@link PGDataTypes#CHARACTER(int)}
     */
    CHARACTER("CHARACTER"),
    /**
     * Variable-length character string. Same {@link PGDataTypes#CHARACTER_VARYING}. Set capacity {@link PGDataTypes#VARCHAR(int)}
     */
    VARCHAR("VARCHAR"),
    /**
     * Variable-length character string. Same {@link PGDataTypes#VARCHAR}. Set capacity {@link PGDataTypes#CHARACTER_VARYING(int)}
     */
    CHARACTER_VARYING("CHARACTER VARYING"),
    /**
     * IPv4 or IPv6 network address
     */
    CIDR("CIDR"),
    /**
     * Circle on a plane
     */
    CIRCLE("CIRCLE"),
    /**
     * Calendar date (year, month, day)
     */
    DATE("DATE"),
    /**
     * Double precision floating-point number (8 bytes)
     */
    FLOAT8("FLOAT8"),
    /**
     * IPv4 or IPv6 host address
     */
    INET("INET"),
    /**
     * Signed four-byte integer
     */
    INT("INT"),
//    /** Time span. Composed of a number of integer fields, representing a period of time, depending on the type of interval. NOT SUPPORTED */
//    INTERVAL("INTERVAL"),
    /**
     * Textual JSON data
     */
    JSON("JSON"),
    /**
     * Binary JSON data, decomposed
     */
    JSONB("JSONB"),
    /**
     * Infinite line on a plane
     */
    LINE("LINE"),
    /**
     * Line segment on a plane
     */
    LSEG("LSEG"),
    /**
     * MAC (Media Access Control) address
     */
    MACADDR("MACADDR"),
    /**
     * Currency amount
     */
    MONEY("MONEY"),
//    /** Exact numeric of selectable precision. Exact numerical, precision p, scale s. Example: decimal(3, 2) is a number that has 3 digits before the decimal and 2 digits after the decimal. NOT SUPPORTED */
//    NUMERIC("NUMERIC"),
    /**
     * Geometric path on a plane
     */
    PATH("PATH"),
    /**
     * PostgreSQL Log Sequence Number
     */
    PG_LSN("PG_LSN"),
    /**
     * Geometric point on a plane
     */
    POINT("POINT"),
    /**
     * Closed geometric path on a plane
     */
    POLYGON("POLYGON"),
    /**
     * Single precision floating-point number (4 bytes)
     */
    REAL("REAL"),
    /**
     * Signed two-byte integer
     */
    SMALLINT("SMALLINT"),
    /**
     * Autoincrementing two-byte integer
     */
    SMALLSERIAL("SMALLSERIAL"),
    /**
     * Autoincrementing four-byte integer
     */
    SERIAL("SERIAL"),
    /**
     * Variable-length character string
     */
    TEXT("TEXT"),
    /**
     * Time of day (no time zone)
     */
    TIME("TIME"),
    /**
     * Time of day, including time zone
     */
    TIMETZ("TIMETZ"),
    /**
     * Date and time (no time zone)
     */
    TIMESTAMP("TIMESTAMP"),
    /**
     * Date and time, including time zone
     */
    TIMESTAMPTZ("TIMESTAMPTZ"),
    /**
     * Text search query
     */
    TSQUERY("TSQUERY"),
    /**
     * Text search document
     */
    TSVECTOR("TSVECTOR"),
    /**
     * User-level transaction ID snapshot
     */
    TXID_SNAPSHOT("TXID_SNAPSHOT"),
    /**
     * Universally unique identifier
     */
    UUID("{"),
    /**
     * XML data
     */
    XML("XML"),;

    @Getter
    private final String name;
    @Getter
    private int capacity;

    PGDataTypes(String name) {
        this.name = name;
    }

    public static PGDataTypes BIT(int capacity) {
        return BIT.set(capacity);
    }

    public static PGDataTypes BIT_VARYING(int capacity) {
        return BIT_VARYING.set(capacity);
    }

    public static PGDataTypes VARBIT(int capacity) {
        return VARBIT.set(capacity);
    }

    public static PGDataTypes CHAR(int capacity) {
        return CHAR.set(capacity);
    }

    public static PGDataTypes CHARACTER(int capacity) {
        return CHARACTER.set(capacity);
    }

    public static PGDataTypes VARCHAR(int capacity) {
        return VARCHAR.set(capacity);
    }

    public static PGDataTypes CHARACTER_VARYING(int capacity) {
        return CHARACTER_VARYING.set(capacity);
    }

    private PGDataTypes set(int capacity) {
        this.capacity = capacity;
        return this;
    }
}
