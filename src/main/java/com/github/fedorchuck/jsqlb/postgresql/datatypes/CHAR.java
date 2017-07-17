package com.github.fedorchuck.jsqlb.postgresql.datatypes;

import com.github.fedorchuck.jsqlb.postgresql.PGDataTypes;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Fixed-length character string. Same {@link CHARACTER}
 *
 * @author <a href="http://vl-fedorchuck.rhcloud.com/">Volodymyr Fedorchuk</a>.
 */
@Getter
@EqualsAndHashCode
public class CHAR implements PGDataTypes {

    private final String name = "CHAR";

    private final int capacity;

    public CHAR(int capacity) {
        this.capacity = capacity;
    }
}
