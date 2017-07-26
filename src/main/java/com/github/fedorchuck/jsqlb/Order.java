package com.github.fedorchuck.jsqlb;

/**
 * @author <a href="http://vl-fedorchuck.rhcloud.com/">Volodymyr Fedorchuk</a>.
 */
public class Order {
    private StringBuilder sql = new StringBuilder();

    public Order(Sort sort, Column... columns) {
        createOrder(sort, columns);
    }

    public Order(Column... columns) {
        createOrder(Sort.ASC, columns);
    }

    public String getSQL() {
        return this.sql.toString();
    }

    public enum Sort {
        ASC,
        DESC
    }

    private void createOrder(Sort sort, Column... columns) {
        if (columns.length == 0)
            throw new IllegalArgumentException("Columns missed (null) .");

        for (Column column: columns) {
            this.sql
                    .append(" ")
                    .append(column.getNameWithTablePrefix())
                    .append(",");
        }
        this.sql
                .deleteCharAt(this.sql.length()-1)
                .append(' ')
                .append(sort.name());
    }
}
