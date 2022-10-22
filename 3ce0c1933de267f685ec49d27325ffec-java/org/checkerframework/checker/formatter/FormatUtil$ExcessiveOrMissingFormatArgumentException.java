package org.checkerframework.checker.formatter;

import java.util.MissingFormatArgumentException;
/* loaded from: classes3.dex */
public class FormatUtil$ExcessiveOrMissingFormatArgumentException extends MissingFormatArgumentException {
    private static final long serialVersionUID = 17000126;
    private final int expected;
    private final int found;

    public FormatUtil$ExcessiveOrMissingFormatArgumentException(int i10, int i11) {
        super("-");
        this.expected = i10;
        this.found = i11;
    }

    public int getExpected() {
        return this.expected;
    }

    public int getFound() {
        return this.found;
    }

    @Override // java.util.MissingFormatArgumentException, java.lang.Throwable
    public String getMessage() {
        return String.format("Expected %d arguments but found %d.", Integer.valueOf(this.expected), Integer.valueOf(this.found));
    }
}
