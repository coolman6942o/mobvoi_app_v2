package org.checkerframework.checker.formatter;

import java.util.IllegalFormatConversionException;
import org.checkerframework.checker.formatter.qual.ConversionCategory;
/* loaded from: classes3.dex */
public class FormatUtil$IllegalFormatConversionCategoryException extends IllegalFormatConversionException {
    private static final long serialVersionUID = 17000126;
    private final ConversionCategory expected;
    private final ConversionCategory found;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FormatUtil$IllegalFormatConversionCategoryException(ConversionCategory conversionCategory, ConversionCategory conversionCategory2) {
        super(r0, r2 == null ? Object.class : r2[0]);
        String str = conversionCategory.chars;
        char charAt = (str == null || str.length() == 0) ? '-' : conversionCategory.chars.charAt(0);
        Class<?>[] clsArr = conversionCategory2.types;
        this.expected = conversionCategory;
        this.found = conversionCategory2;
    }

    public ConversionCategory getExpected() {
        return this.expected;
    }

    public ConversionCategory getFound() {
        return this.found;
    }

    @Override // java.util.IllegalFormatConversionException, java.lang.Throwable
    public String getMessage() {
        return String.format("Expected category %s but found %s.", this.expected, this.found);
    }
}
