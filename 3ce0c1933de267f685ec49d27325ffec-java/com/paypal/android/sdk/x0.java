package com.paypal.android.sdk;
/* loaded from: classes2.dex */
public class x0 extends w0 {
    public x0(by byVar, Exception exc) {
        this(byVar.toString(), exc);
    }

    public x0(String str) {
        super("RequestError", str);
    }

    public x0(String str, String str2, String str3) {
        super("RequestError", str, str2, str3);
    }

    public x0(String str, Throwable th2) {
        super(th2.getClass().toString(), str, th2.toString(), th2.getMessage());
    }
}
