package com.huawei.hms.scankit.aiscan.common;

import java.util.HashMap;
import java.util.Map;
/* compiled from: CharacterSetECI.java */
/* renamed from: com.huawei.hms.scankit.aiscan.common.c  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public enum EnumC0552c {
    Cp437(new int[]{0, 2}, new String[0]),
    ISO8859_1(new int[]{1, 3}, "ISO-8859-1"),
    ISO8859_2(4, "ISO-8859-2"),
    ISO8859_3(5, "ISO-8859-3"),
    ISO8859_4(6, "ISO-8859-4"),
    ISO8859_5(7, "ISO-8859-5"),
    ISO8859_6(8, "ISO-8859-6"),
    ISO8859_7(9, "ISO-8859-7"),
    ISO8859_8(10, "ISO-8859-8"),
    ISO8859_9(11, "ISO-8859-9"),
    ISO8859_10(12, "ISO-8859-10"),
    ISO8859_11(13, "ISO-8859-11"),
    ISO8859_13(15, "ISO-8859-13"),
    ISO8859_14(16, "ISO-8859-14"),
    ISO8859_15(17, "ISO-8859-15"),
    ISO8859_16(18, "ISO-8859-16"),
    SJIS(20, "Shift_JIS"),
    Cp1250(21, "windows-1250"),
    Cp1251(22, "windows-1251"),
    Cp1252(23, "windows-1252"),
    Cp1256(24, "windows-1256"),
    UnicodeBigUnmarked(25, "UTF-16BE", "UnicodeBig"),
    UTF8(26, "UTF-8"),
    ASCII(new int[]{27, 170}, "US-ASCII"),
    Big5(28),
    GB18030(29, "GB2312", "EUC_CN", "GBK"),
    EUC_KR(30, "EUC-KR");
    
    private static final Map<Integer, EnumC0552c> B = new HashMap();
    private static final Map<String, EnumC0552c> C = new HashMap();
    private final int[] E;
    private final String[] F;

    static {
        EnumC0552c[] values;
        for (EnumC0552c cVar : values()) {
            for (int i10 : cVar.E) {
                B.put(Integer.valueOf(i10), cVar);
            }
            C.put(cVar.name(), cVar);
            for (String str : cVar.F) {
                C.put(str, cVar);
            }
        }
    }

    EnumC0552c(int i10) {
        this(new int[]{i10}, new String[0]);
    }

    public int a() {
        return this.E[0];
    }

    EnumC0552c(int i10, String... strArr) {
        this.E = new int[]{i10};
        this.F = strArr;
    }

    public static EnumC0552c a(int i10) throws C0550a {
        if (i10 >= 0 && i10 < 900) {
            return B.get(Integer.valueOf(i10));
        }
        throw C0550a.a();
    }

    public static EnumC0552c a(String str) {
        return C.get(str);
    }

    EnumC0552c(int[] iArr, String... strArr) {
        this.E = iArr;
        this.F = strArr;
    }
}
