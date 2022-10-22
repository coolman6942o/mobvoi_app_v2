package com.google.android.gms.internal.measurement;

import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c7 extends v6<Double> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c7(f7 f7Var, String str, Double d10) {
        super(f7Var, str, d10, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public final Double p(String str) {
        try {
            return Double.valueOf(Double.parseDouble(str));
        } catch (NumberFormatException unused) {
            String str2 = this.f9759b;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 27 + String.valueOf(str).length());
            sb2.append("Invalid double value for ");
            sb2.append(str2);
            sb2.append(": ");
            sb2.append(str);
            Log.e("PhenotypeFlag", sb2.toString());
            return null;
        }
    }
}
