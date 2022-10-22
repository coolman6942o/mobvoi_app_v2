package com.huawei.hms.mlkit.common.ha;

import android.text.TextUtils;
import android.util.Log;
import java.util.regex.Pattern;
/* compiled from: HaLog.java */
/* loaded from: classes2.dex */
final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f14067a = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");

    private static String a(String str) {
        StringBuilder sb2 = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
        }
        return sb2.toString();
    }

    public static void b(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Log.w(str, a(str2));
        }
    }

    public static void c(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Log.e(str, a(str2));
        }
    }

    public static void a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Log.i(str, a(str2));
        }
    }
}
