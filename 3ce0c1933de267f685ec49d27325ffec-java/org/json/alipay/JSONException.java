package org.json.alipay;
/* loaded from: classes3.dex */
public class JSONException extends Exception {
    public Throwable cause;

    public JSONException(String str) {
        super(str);
    }

    public JSONException(Throwable th2) {
        super(th2.getMessage());
        this.cause = th2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
