package com.unionpay.utils;

import java.util.Locale;
/* loaded from: classes2.dex */
public class k {

    /* renamed from: g  reason: collision with root package name */
    private static k f24585g;

    /* renamed from: a  reason: collision with root package name */
    public String f24586a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f24587b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f24588c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f24589d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f24590e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f24591f = "";

    public static k a() {
        if (f24585g == null) {
            f24585g = Locale.getDefault().toString().startsWith("zh") ? new l() : new m();
        }
        return f24585g;
    }
}
