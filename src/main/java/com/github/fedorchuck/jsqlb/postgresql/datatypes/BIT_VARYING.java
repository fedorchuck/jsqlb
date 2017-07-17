package com.github.fedorchuck.jsqlb.postgresql.datatypes;

import com.github.fedorchuck.jsqlb.postgresql.PGDataTypes;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Variable-length bit string. Same {@link VARBIT}.
 *
 * @author <a href="http://vl-fedorchuck.rhcloud.com/">Volodymyr Fedorchuk</a>.
 */
@Getter
@EqualsAndHashCode
public class BIT_VARYING implements PGDataTypes {

    private final String name = "BIT VARYING";

    private final int capacity;

    public BIT_VARYING(int capacity) {
        this.capacity = capacity;
    }
}
