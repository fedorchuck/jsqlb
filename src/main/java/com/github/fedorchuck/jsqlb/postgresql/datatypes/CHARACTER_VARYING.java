package com.github.fedorchuck.jsqlb.postgresql.datatypes;

import com.github.fedorchuck.jsqlb.postgresql.PGDataTypes;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Variable-length character string. Same {@link VARCHAR}.
 *
 * @author <a href="http://vl-fedorchuck.rhcloud.com/">Volodymyr Fedorchuk</a>.
 */
@Getter
@EqualsAndHashCode
public class CHARACTER_VARYING implements PGDataTypes {

    private final String name = "CHARACTER VARYING";

    private final int capacity;

    public CHARACTER_VARYING(int capacity) {
        this.capacity = capacity;
    }
}
