package com.github.fedorchuck.jsqlb.postgresql;

import com.github.fedorchuck.jsqlb.postgresql.datatypes.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href="http://vl-fedorchuck.rhcloud.com/">Volodymyr Fedorchuk</a>.
 */
public class PGDataTypesTest {

    @Test
    public void BIGINT() {
        Assert.assertEquals(0, new BIGINT().getCapacity());
        Assert.assertEquals("BIGINT", new BIGINT().getName());
    }

    @Test
    public void BIGSERIAL() {
        Assert.assertEquals(0, new BIGSERIAL().getCapacity());
        Assert.assertEquals("BIGSERIAL", new BIGSERIAL().getName());
    }

    @Test
    public void BIT() {
        Assert.assertEquals(0, new BIT(0).getCapacity());
        Assert.assertEquals("BIT", new BIT(0).getName());
        Assert.assertEquals(15, new BIT(15).getCapacity());
    }

    @Test
    public void BIT_VARYING() {
        Assert.assertEquals(0, new BIT_VARYING(0).getCapacity());
        Assert.assertEquals("BIT VARYING", new BIT_VARYING(0).getName());
        Assert.assertEquals(15, new BIT_VARYING(15).getCapacity());
    }

    @Test
    public void BOOLEAN() {
        Assert.assertEquals(0, new BOOLEAN().getCapacity());
        Assert.assertEquals("BOOLEAN", new BOOLEAN().getName());
    }

    @Test
    public void BOX() {
        Assert.assertEquals(0, new BOX().getCapacity());
        Assert.assertEquals("BOX", new BOX().getName());
    }

    @Test
    public void BYTEA() {
        Assert.assertEquals(0, new BYTEA().getCapacity());
        Assert.assertEquals("BYTEA", new BYTEA().getName());
    }

    @Test
    public void CHAR() {
        Assert.assertEquals(0, new CHAR(0).getCapacity());
        Assert.assertEquals("CHAR", new CHAR(0).getName());
        Assert.assertEquals(15, new CHAR(15).getCapacity());
    }

    @Test
    public void CHARACTER() {
        Assert.assertEquals(0, new CHARACTER(0).getCapacity());
        Assert.assertEquals("CHARACTER", new CHARACTER(0).getName());
        Assert.assertEquals(15, new CHARACTER(15).getCapacity());
    }

    @Test
    public void CHARACTER_VARYING() {
        Assert.assertEquals(0, new CHARACTER_VARYING(0).getCapacity());
        Assert.assertEquals("CHARACTER VARYING", new CHARACTER_VARYING(0).getName());
        Assert.assertEquals(15, new CHARACTER_VARYING(15).getCapacity());
    }

    @Test
    public void CIDR() {
        Assert.assertEquals(0, new CIDR().getCapacity());
        Assert.assertEquals("CIDR", new CIDR().getName());
    }

    @Test
    public void CIRCLE() {
        Assert.assertEquals(0, new CIRCLE().getCapacity());
        Assert.assertEquals("CIRCLE", new CIRCLE().getName());
    }

    @Test
    public void DATE() {
        Assert.assertEquals(0, new DATE().getCapacity());
        Assert.assertEquals("DATE", new DATE().getName());
    }

    @Test
    public void FLOAT8() {
        Assert.assertEquals(0, new FLOAT8().getCapacity());
        Assert.assertEquals("FLOAT8", new FLOAT8().getName());
    }

    @Test
    public void INET() {
        Assert.assertEquals(0, new INET().getCapacity());
        Assert.assertEquals("INET", new INET().getName());
    }

    @Test
    public void INT() {
        Assert.assertEquals(0, new INT().getCapacity());
        Assert.assertEquals("INT", new INT().getName());
    }

    @Test
    public void JSON() {
        Assert.assertEquals(0, new JSON().getCapacity());
        Assert.assertEquals("JSON", new JSON().getName());
    }

    @Test
    public void JSONB() {
        Assert.assertEquals(0, new JSONB().getCapacity());
        Assert.assertEquals("JSONB", new JSONB().getName());
    }

    @Test
    public void LINE() {
        Assert.assertEquals(0, new LINE().getCapacity());
        Assert.assertEquals("LINE", new LINE().getName());
    }

    @Test
    public void LSEG() {
        Assert.assertEquals(0, new LSEG().getCapacity());
        Assert.assertEquals("LSEG", new LSEG().getName());
    }

    @Test
    public void MACADDR() {
        Assert.assertEquals(0, new MACADDR().getCapacity());
        Assert.assertEquals("MACADDR", new MACADDR().getName());
    }

    @Test
    public void MONEY() {
        Assert.assertEquals(0, new MONEY().getCapacity());
        Assert.assertEquals("MONEY", new MONEY().getName());
    }

    @Test
    public void PATH() {
        Assert.assertEquals(0, new PATH().getCapacity());
        Assert.assertEquals("PATH", new PATH().getName());
    }

    @Test
    public void PG_LSN() {
        Assert.assertEquals(0, new PG_LSN().getCapacity());
        Assert.assertEquals("PG_LSN", new PG_LSN().getName());
    }

    @Test
    public void POINT() {
        Assert.assertEquals(0, new POINT().getCapacity());
        Assert.assertEquals("POINT", new POINT().getName());
    }

    @Test
    public void POLYGON() {
        Assert.assertEquals(0, new POLYGON().getCapacity());
        Assert.assertEquals("POLYGON", new POLYGON().getName());
    }

    @Test
    public void REAL() {
        Assert.assertEquals(0, new REAL().getCapacity());
        Assert.assertEquals("REAL", new REAL().getName());
    }

    @Test
    public void SERIAL() {
        Assert.assertEquals(0, new SERIAL().getCapacity());
        Assert.assertEquals("SERIAL", new SERIAL().getName());
    }

    @Test
    public void SMALLINT() {
        Assert.assertEquals(0, new SMALLINT().getCapacity());
        Assert.assertEquals("SMALLINT", new SMALLINT().getName());
    }

    @Test
    public void SMALLSERIAL() {
        Assert.assertEquals(0, new SMALLSERIAL().getCapacity());
        Assert.assertEquals("SMALLSERIAL", new SMALLSERIAL().getName());
    }

    @Test
    public void TEXT() {
        Assert.assertEquals(0, new TEXT().getCapacity());
        Assert.assertEquals("TEXT", new TEXT().getName());
    }

    @Test
    public void TIME() {
        Assert.assertEquals(0, new TIME().getCapacity());
        Assert.assertEquals("TIME", new TIME().getName());
    }

    @Test
    public void TIMESTAMP() {
        Assert.assertEquals(0, new TIMESTAMP().getCapacity());
        Assert.assertEquals("TIMESTAMP", new TIMESTAMP().getName());
    }

    @Test
    public void TIMESTAMPTZ() {
        Assert.assertEquals(0, new TIMESTAMPTZ().getCapacity());
        Assert.assertEquals("TIMESTAMPTZ", new TIMESTAMPTZ().getName());
    }

    @Test
    public void TIMETZ() {
        Assert.assertEquals(0, new TIMETZ().getCapacity());
        Assert.assertEquals("TIMETZ", new TIMETZ().getName());
    }

    @Test
    public void TSQUERY() {
        Assert.assertEquals(0, new TSQUERY().getCapacity());
        Assert.assertEquals("TSQUERY", new TSQUERY().getName());
    }

    @Test
    public void TSVECTOR() {
        Assert.assertEquals(0, new TSVECTOR().getCapacity());
        Assert.assertEquals("TSVECTOR", new TSVECTOR().getName());
    }

    @Test
    public void TXID_SNAPSHOT() {
        Assert.assertEquals(0, new TXID_SNAPSHOT().getCapacity());
        Assert.assertEquals("TXID_SNAPSHOT", new TXID_SNAPSHOT().getName());
    }

    @Test
    public void UUID() {
        Assert.assertEquals(0, new UUID().getCapacity());
        Assert.assertEquals("UUID", new UUID().getName());
    }

    @Test
    public void VARBIT() {
        Assert.assertEquals(0, new VARBIT(0).getCapacity());
        Assert.assertEquals("VARBIT", new VARBIT(0).getName());
        Assert.assertEquals(15, new VARBIT(15).getCapacity());
    }

    @Test
    public void VARCHAR() {
        Assert.assertEquals(0, new VARCHAR(0).getCapacity());
        Assert.assertEquals("VARCHAR", new VARCHAR(0).getName());
        Assert.assertEquals(15, new VARCHAR(15).getCapacity());
    }

    @Test
    public void XML() {
        Assert.assertEquals(0, new XML().getCapacity());
        Assert.assertEquals("XML", new XML().getName());
    }
}