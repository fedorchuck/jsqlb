package com.github.fedorchuck.jsqlb.postgresql.datatypes;

import com.github.fedorchuck.jsqlb.postgresql.PGDataTypes;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Fixed-length bit string
 *
 * @author <a href="http://vl-fedorchuck.rhcloud.com/">Volodymyr Fedorchuk</a>.
 */
@Getter
@EqualsAndHashCode
public class BIT implements PGDataTypes {

    private final String name = "BIT";

    private final int capacity;

    public BIT(int capacity) {
        this.capacity = capacity;
    }
}
