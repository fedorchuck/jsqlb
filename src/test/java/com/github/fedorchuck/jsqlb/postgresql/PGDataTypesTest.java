package com.github.fedorchuck.jsqlb.postgresql;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href="http://vl-fedorchuck.rhcloud.com/">Volodymyr Fedorchuk</a>.
 */
public class PGDataTypesTest {

    @Test
    public void BIT() {
        Assert.assertEquals(0, PGDataTypes.BIT.getCapacity());
        Assert.assertEquals("BIT", PGDataTypes.BIT.getName());
        Assert.assertEquals(15, PGDataTypes.BIT(15).getCapacity());
    }

    @Test
    public void BIT_VARYING() {
        Assert.assertEquals(0, PGDataTypes.BIT_VARYING.getCapacity());
        Assert.assertEquals("BIT VARYING", PGDataTypes.BIT_VARYING.getName());
        Assert.assertEquals(15, PGDataTypes.BIT_VARYING(15).getCapacity());
    }

    @Test
    public void VARBIT() {
        Assert.assertEquals(0, PGDataTypes.VARBIT.getCapacity());
        Assert.assertEquals("VARBIT", PGDataTypes.VARBIT.getName());
        Assert.assertEquals(15, PGDataTypes.VARBIT(15).getCapacity());
    }

    @Test
    public void CHAR() {
        Assert.assertEquals(0, PGDataTypes.CHAR.getCapacity());
        Assert.assertEquals("CHAR", PGDataTypes.CHAR.getName());
        Assert.assertEquals(15, PGDataTypes.CHAR(15).getCapacity());
    }

    @Test
    public void CHARACTER() {
        Assert.assertEquals(0, PGDataTypes.CHARACTER.getCapacity());
        Assert.assertEquals("CHARACTER", PGDataTypes.CHARACTER.getName());
        Assert.assertEquals(15, PGDataTypes.CHARACTER(15).getCapacity());
    }

    @Test
    public void VARCHAR() {
        Assert.assertEquals(0, PGDataTypes.VARCHAR.getCapacity());
        Assert.assertEquals("VARCHAR", PGDataTypes.VARCHAR.getName());
        Assert.assertEquals(15, PGDataTypes.VARCHAR(15).getCapacity());
    }

    @Test
    public void CHARACTER_VARYING() {
        Assert.assertEquals(0, PGDataTypes.CHARACTER_VARYING.getCapacity());
        Assert.assertEquals("CHARACTER VARYING", PGDataTypes.CHARACTER_VARYING.getName());
        Assert.assertEquals(15, PGDataTypes.CHARACTER_VARYING(15).getCapacity());
    }

}