package com.ta.utdid2.a.a;

import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f22420a = Pattern.compile("([\t\r\n])+");

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m22a(String str) {
        return str == null || str.length() <= 0;
    }

    public static int a(String str) {
        if (str.length() <= 0) {
            return 0;
        }
        int i10 = 0;
        for (char c10 : str.toCharArray()) {
            i10 = (i10 * 31) + c10;
        }
        return i10;
    }
}
