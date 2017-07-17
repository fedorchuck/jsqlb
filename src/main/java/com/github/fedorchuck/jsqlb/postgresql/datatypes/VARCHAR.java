package com.github.fedorchuck.jsqlb.postgresql.datatypes;

import com.github.fedorchuck.jsqlb.postgresql.PGDataTypes;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Variable-length character string. Same {@link CHARACTER_VARYING}.
 *
 * @author <a href="http://vl-fedorchuck.rhcloud.com/">Volodymyr Fedorchuk</a>.
 */
@Getter
@EqualsAndHashCode
public class VARCHAR implements PGDataTypes {

    private final String name = "VARCHAR";

    private final int capacity;

    public VARCHAR(int capacity) {
        this.capacity = capacity;
    }
}
