package com.github.fedorchuck.jsqlb.postgresql.datatypes;

import com.github.fedorchuck.jsqlb.postgresql.PGDataTypes;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Variable-length bit string. Same {@link BIT_VARYING}.
 *
 * @author <a href="http://vl-fedorchuck.rhcloud.com/">Volodymyr Fedorchuk</a>.
 */
@Getter
@EqualsAndHashCode
public class VARBIT implements PGDataTypes {

    private final String name = "VARBIT";

    private final int capacity;

    public VARBIT(int capacity) {
        this.capacity = capacity;
    }
}
