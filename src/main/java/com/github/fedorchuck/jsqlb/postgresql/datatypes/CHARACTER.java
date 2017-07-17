package com.github.fedorchuck.jsqlb.postgresql.datatypes;

import com.github.fedorchuck.jsqlb.postgresql.PGDataTypes;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Character string. Fixed-length. Same {@link CHAR}.
 *
 * @author <a href="http://vl-fedorchuck.rhcloud.com/">Volodymyr Fedorchuk</a>.
 */
@Getter
@EqualsAndHashCode
public class CHARACTER implements PGDataTypes {

    private final String name = "CHARACTER";

    private final int capacity;

    public CHARACTER(int capacity) {
        this.capacity = capacity;
    }
}
