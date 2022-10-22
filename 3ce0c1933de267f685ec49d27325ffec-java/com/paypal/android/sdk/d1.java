package com.paypal.android.sdk;

import android.util.Log;
import org.json.JSONException;
/* loaded from: classes2.dex */
public abstract class d1 implements o1 {
    /* JADX INFO: Access modifiers changed from: protected */
    public static void b(r1 r1Var) {
        try {
            r1Var.o();
            r1Var.j();
        } catch (Exception e10) {
            Log.e("paypal.sdk", "Exception parsing server response", e10);
            r1Var.b(new x0(by.PARSE_RESPONSE_ERROR, e10));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void c(r1 r1Var, int i10) {
        r1Var.c(Integer.valueOf(i10));
        try {
            r1Var.o();
            r1Var.l();
        } catch (JSONException e10) {
            Log.e("paypal.sdk", "Exception parsing server response", e10);
            String str = by.INTERNAL_SERVER_ERROR.toString();
            r1Var.f(str, i10 + " http response received.  Response not parsable: " + e10.getMessage(), null);
        }
    }
}
