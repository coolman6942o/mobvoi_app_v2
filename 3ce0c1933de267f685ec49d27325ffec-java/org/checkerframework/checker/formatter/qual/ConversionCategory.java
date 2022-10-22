package org.checkerframework.checker.formatter.qual;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;
/* loaded from: classes3.dex */
public enum ConversionCategory {
    GENERAL(null, "bBhHsS"),
    CHAR(new Class[]{Character.class, Byte.class, Short.class, Integer.class}, "cC"),
    INT(new Class[]{Byte.class, Short.class, Integer.class, Long.class, BigInteger.class}, "doxX"),
    FLOAT(new Class[]{Float.class, Double.class, BigDecimal.class}, "eEfgGaA"),
    TIME(new Class[]{Long.class, Calendar.class, Date.class}, "tT"),
    CHAR_AND_INT(new Class[]{Byte.class, Short.class, Integer.class}, null),
    INT_AND_TIME(new Class[]{Long.class}, null),
    NULL(new Class[0], null),
    UNUSED(null, null);
    
    public final String chars;
    public final Class<?>[] types;

    ConversionCategory(Class[] clsArr, String str) {
        this.types = clsArr;
        this.chars = str;
    }

    private static <E> Set<E> a(E[] eArr) {
        return new HashSet(Arrays.asList(eArr));
    }

    private String b(Class<?> cls) {
        return cls == Boolean.class ? "boolean" : cls == Character.class ? "char" : cls == Byte.class ? "byte" : cls == Short.class ? "short" : cls == Integer.class ? "int" : cls == Long.class ? "long" : cls == Float.class ? "float" : cls == Double.class ? "double" : cls.getSimpleName();
    }

    public static ConversionCategory fromConversionChar(char c10) {
        ConversionCategory[] conversionCategoryArr = {GENERAL, CHAR, INT, FLOAT, TIME};
        for (int i10 = 0; i10 < 5; i10++) {
            ConversionCategory conversionCategory = conversionCategoryArr[i10];
            if (conversionCategory.chars.contains(String.valueOf(c10))) {
                return conversionCategory;
            }
        }
        throw new IllegalArgumentException("Bad conversion character " + c10);
    }

    public static ConversionCategory intersect(ConversionCategory conversionCategory, ConversionCategory conversionCategory2) {
        ConversionCategory conversionCategory3 = UNUSED;
        if (conversionCategory == conversionCategory3) {
            return conversionCategory2;
        }
        if (conversionCategory2 == conversionCategory3) {
            return conversionCategory;
        }
        ConversionCategory conversionCategory4 = GENERAL;
        if (conversionCategory == conversionCategory4) {
            return conversionCategory2;
        }
        if (conversionCategory2 == conversionCategory4) {
            return conversionCategory;
        }
        Set a10 = a(conversionCategory.types);
        a10.retainAll(a(conversionCategory2.types));
        ConversionCategory[] conversionCategoryArr = {CHAR, INT, FLOAT, TIME, CHAR_AND_INT, INT_AND_TIME, NULL};
        for (int i10 = 0; i10 < 7; i10++) {
            ConversionCategory conversionCategory5 = conversionCategoryArr[i10];
            if (a(conversionCategory5.types).equals(a10)) {
                return conversionCategory5;
            }
        }
        throw new RuntimeException();
    }

    public static boolean isSubsetOf(ConversionCategory conversionCategory, ConversionCategory conversionCategory2) {
        return intersect(conversionCategory, conversionCategory2) == conversionCategory;
    }

    public static ConversionCategory union(ConversionCategory conversionCategory, ConversionCategory conversionCategory2) {
        ConversionCategory conversionCategory3;
        ConversionCategory conversionCategory4 = UNUSED;
        if (conversionCategory == conversionCategory4 || conversionCategory2 == conversionCategory4 || conversionCategory == (conversionCategory4 = GENERAL) || conversionCategory2 == conversionCategory4) {
            return conversionCategory4;
        }
        ConversionCategory conversionCategory5 = CHAR_AND_INT;
        if ((conversionCategory == conversionCategory5 && conversionCategory2 == INT_AND_TIME) || (conversionCategory == (conversionCategory3 = INT_AND_TIME) && conversionCategory2 == conversionCategory5)) {
            return INT;
        }
        Set a10 = a(conversionCategory.types);
        a10.addAll(a(conversionCategory2.types));
        ConversionCategory[] conversionCategoryArr = {NULL, conversionCategory5, conversionCategory3, CHAR, INT, FLOAT, TIME};
        for (int i10 = 0; i10 < 7; i10++) {
            ConversionCategory conversionCategory6 = conversionCategoryArr[i10];
            if (a(conversionCategory6.types).equals(a10)) {
                return conversionCategory6;
            }
        }
        return GENERAL;
    }

    @Override // java.lang.Enum
    public String toString() {
        StringBuilder sb2 = new StringBuilder(name());
        if (!(this == UNUSED || this == GENERAL)) {
            StringJoiner stringJoiner = new StringJoiner(", ", " conversion category (one of: ", ")");
            for (Class<?> cls : this.types) {
                stringJoiner.add(b(cls));
            }
            sb2.append(stringJoiner);
        }
        return sb2.toString();
    }
}
