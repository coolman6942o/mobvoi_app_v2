package com.paypal.android.sdk;
/* loaded from: classes2.dex */
public abstract class j3 extends q1 {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public j3(dc dcVar, s1 s1Var, z zVar, String str) {
        super(r0, s1Var, zVar, "Bearer " + str);
        x1 x1Var = new x1(dcVar);
        e("Content-Type", "application/json");
        e("Accept", "application/json");
    }
}
