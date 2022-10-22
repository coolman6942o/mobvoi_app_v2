package com.google.common.base;
/* compiled from: Ascii.java */
/* loaded from: classes.dex */
public final class c {
    public static boolean a(char c10) {
        return c10 >= 'a' && c10 <= 'z';
    }

    public static boolean b(char c10) {
        return c10 >= 'A' && c10 <= 'Z';
    }

    public static String c(String str) {
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            if (b(str.charAt(i10))) {
                char[] charArray = str.toCharArray();
                while (i10 < length) {
                    char c10 = charArray[i10];
                    if (b(c10)) {
                        charArray[i10] = (char) (c10 ^ ' ');
                    }
                    i10++;
                }
                return String.valueOf(charArray);
            }
            i10++;
        }
        return str;
    }

    public static char d(char c10) {
        return a(c10) ? (char) (c10 ^ ' ') : c10;
    }

    public static String e(String str) {
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            if (a(str.charAt(i10))) {
                char[] charArray = str.toCharArray();
                while (i10 < length) {
                    char c10 = charArray[i10];
                    if (a(c10)) {
                        charArray[i10] = (char) (c10 ^ ' ');
                    }
                    i10++;
                }
                return String.valueOf(charArray);
            }
            i10++;
        }
        return str;
    }
}
