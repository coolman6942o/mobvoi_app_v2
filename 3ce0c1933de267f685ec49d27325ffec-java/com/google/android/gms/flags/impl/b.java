package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import m6.a;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static SharedPreferences f9066a;

    public static SharedPreferences a(Context context) throws Exception {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (f9066a == null) {
                f9066a = (SharedPreferences) a.a(new g(context));
            }
            sharedPreferences = f9066a;
        }
        return sharedPreferences;
    }
}
