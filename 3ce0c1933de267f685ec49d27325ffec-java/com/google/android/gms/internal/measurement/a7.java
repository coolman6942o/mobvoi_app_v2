package com.google.android.gms.internal.measurement;

import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a7 extends v6<Integer> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a7(f7 f7Var, String str, Integer num) {
        super(f7Var, str, num, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public final Integer p(String str) {
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            String str2 = this.f9759b;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 28 + String.valueOf(str).length());
            sb2.append("Invalid integer value for ");
            sb2.append(str2);
            sb2.append(": ");
            sb2.append(str);
            Log.e("PhenotypeFlag", sb2.toString());
            return null;
        }
    }
}
