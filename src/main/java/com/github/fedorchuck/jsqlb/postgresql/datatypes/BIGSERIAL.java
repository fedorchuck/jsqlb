package com.github.fedorchuck.jsqlb.postgresql.datatypes;

import com.github.fedorchuck.jsqlb.postgresql.PGDataTypes;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Autoincrementing eight-byte integer
 *
 * @author <a href="http://vl-fedorchuck.rhcloud.com/">Volodymyr Fedorchuk</a>.
 */
@Getter
@EqualsAndHashCode
public class BIGSERIAL implements PGDataTypes {

    private final String name = "BIGSERIAL";

    private final int capacity = 0;
}
