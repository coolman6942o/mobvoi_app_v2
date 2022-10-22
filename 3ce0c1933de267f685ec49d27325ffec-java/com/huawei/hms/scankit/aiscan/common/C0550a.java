package com.huawei.hms.scankit.aiscan.common;
/* compiled from: AIScanException.java */
/* renamed from: com.huawei.hms.scankit.aiscan.common.a  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0550a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    protected static final boolean f14166a;

    /* renamed from: b  reason: collision with root package name */
    protected static final StackTraceElement[] f14167b;

    /* renamed from: c  reason: collision with root package name */
    private static final C0550a f14168c;

    static {
        f14166a = System.getProperty("surefire.test.class.path") != null;
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[0];
        f14167b = stackTraceElementArr;
        C0550a aVar = new C0550a();
        f14168c = aVar;
        aVar.setStackTrace(stackTraceElementArr);
    }

    private C0550a() {
    }

    public static C0550a a() {
        return f14166a ? new C0550a() : f14168c;
    }

    private C0550a(String str) {
        super(str);
    }

    public static C0550a a(String str) {
        return new C0550a(str);
    }
}
