package com.alipay.sdk.app;
/* loaded from: classes.dex */
public class EnvUtils {

    /* renamed from: a  reason: collision with root package name */
    public static EnvEnum f6861a = EnvEnum.ONLINE;

    /* loaded from: classes.dex */
    public enum EnvEnum {
        ONLINE,
        SANDBOX
    }

    public static boolean a() {
        return f6861a == EnvEnum.SANDBOX;
    }
}
