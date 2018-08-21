package tech.tablesaw.columns.strings;

import tech.tablesaw.api.ColumnType;
import tech.tablesaw.api.TextColumn;
import tech.tablesaw.columns.AbstractColumnType;
import tech.tablesaw.io.csv.CsvReadOptions;

public class TextColumnType extends AbstractColumnType {

    public static final int BYTE_SIZE = 4;
    public static final StringStringParser DEFAULT_PARSER = new StringStringParser(ColumnType.STRING);

    public static final TextColumnType INSTANCE =
            new TextColumnType(BYTE_SIZE,
                    "TEXT",
                    "Text");

    private TextColumnType(int byteSize, String name, String printerFriendlyName) {
        super(byteSize, name, printerFriendlyName);
    }

    @Override
    public TextColumn create(String name) {
        return TextColumn.create(name);
    }

    @Override
    public StringStringParser customParser(CsvReadOptions options) {
        return new StringStringParser(this, options);
    }

    public static String missingValueIndicator() {
        return "";
    }

}
