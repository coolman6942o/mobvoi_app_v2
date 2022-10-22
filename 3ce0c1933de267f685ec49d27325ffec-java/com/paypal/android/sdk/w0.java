package com.paypal.android.sdk;
/* loaded from: classes2.dex */
public abstract class w0 {

    /* renamed from: a  reason: collision with root package name */
    private String f22040a;

    /* renamed from: b  reason: collision with root package name */
    private String f22041b;

    private w0(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public w0(String str, String str2) {
        this(str);
        this.f22040a = str2;
        this.f22041b = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public w0(String str, String str2, String str3, String str4) {
        this(str);
        this.f22040a = str2;
        this.f22041b = str3;
    }

    public final String a() {
        return this.f22041b;
    }

    public final String b() {
        return this.f22040a;
    }

    public String toString() {
        return "ErrorBase[mErrorCode=" + this.f22040a + " mErrorMsgShort=" + this.f22041b + "]";
    }
}
