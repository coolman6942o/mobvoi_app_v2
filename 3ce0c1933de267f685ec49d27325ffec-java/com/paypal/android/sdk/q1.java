package com.paypal.android.sdk;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public abstract class q1 extends r1 {
    public q1(p1 p1Var, s1 s1Var, z zVar, String str) {
        this(p1Var, s1Var, zVar, str, null);
    }

    public q1(p1 p1Var, s1 s1Var, z zVar, String str, String str2) {
        super(p1Var, s1Var, zVar, str2);
        if (!TextUtils.isEmpty(str)) {
            e("Authorization", str);
        }
    }
}
