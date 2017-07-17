package com.github.fedorchuck.jsqlb.postgresql.datatypes;

import com.github.fedorchuck.jsqlb.postgresql.PGDataTypes;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Variable-length character string
 *
 * @author <a href="http://vl-fedorchuck.rhcloud.com/">Volodymyr Fedorchuk</a>.
 */
@Getter
@EqualsAndHashCode
public class TEXT implements PGDataTypes {

    private final String name = "TEXT";

    private final int capacity = 0;
}
