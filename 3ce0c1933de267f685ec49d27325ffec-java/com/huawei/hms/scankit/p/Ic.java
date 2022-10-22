package com.huawei.hms.scankit.p;

import java.security.SecureRandom;
/* compiled from: RandomUtil.java */
/* loaded from: classes2.dex */
public class Ic {

    /* renamed from: a  reason: collision with root package name */
    private static final SecureRandom f14557a = new SecureRandom();

    public static int a(int i10) {
        return f14557a.nextInt(i10);
    }

    public static float a(float f10) {
        return f14557a.nextFloat() * f10;
    }
}
