package com.javarush.task.task25.task2503;

import java.util.LinkedList;
import java.util.List;

public enum Column implements Columnable {
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    private Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns() {
        List<Column> result = new LinkedList<>();
        Column[] columns = Column.values();

        int numberOfHiddenColumns = 0;
        for (int i = 0; i < realOrder.length; i++)
            if (realOrder[i] == -1) numberOfHiddenColumns++;

        for (int i = 0; i < realOrder.length - numberOfHiddenColumns; i++) {
            boolean isFound = false;
            int prevResultSize = result.size();

            for (int j = 0; j < realOrder.length; j++) {
                if (realOrder[j] == i) {
                    if (isFound) {
                        throw new RuntimeException("More than one column with position " + i);
                    }
                    result.add(columns[j]);
                    isFound = true;
                }
            }
            if(prevResultSize == result.size())
                throw new RuntimeException("There is no column with position " + i);
        }

        return result;
    }

    @Override
    public String getColumnName() {
        return columnName;
    }

    @Override
    public boolean isShown() {
        return (0 <= realOrder[ordinal()]) && (realOrder[ordinal()] < realOrder.length);
    }

    @Override
    public void hide() {
        int hiddenColumnPosition = realOrder[ordinal()];
        if (hiddenColumnPosition == -1) return; // already hidden
        realOrder[ordinal()] = -1;

        for (int i = 0; i < realOrder.length; i++)
            if (realOrder[i] > hiddenColumnPosition)
                realOrder[i]--;
    }
}
