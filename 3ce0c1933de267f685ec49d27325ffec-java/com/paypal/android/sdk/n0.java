package com.paypal.android.sdk;

import java.util.Arrays;
/* loaded from: classes2.dex */
public final class n0 {
    static {
        Arrays.asList("live", "sandbox", "mock");
    }

    public static boolean a(String str) {
        return str.equals("mock");
    }

    public static boolean b(String str) {
        return str.startsWith("sandbox");
    }

    public static boolean c(String str) {
        return str.equals("live");
    }

    public static boolean d(String str) {
        return !str.equals("live") && !str.startsWith("sandbox") && !str.equals("mock");
    }

    public static boolean e(String str) {
        return str.startsWith("sandbox") || str.equals("mock");
    }
}
