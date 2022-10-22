package com.google.android.gms.internal.measurement;

import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z6 extends v6<Long> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public z6(f7 f7Var, String str, Long l10) {
        super(f7Var, str, l10, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public final Long p(String str) {
        try {
            return Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            String str2 = this.f9759b;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 25 + String.valueOf(str).length());
            sb2.append("Invalid long value for ");
            sb2.append(str2);
            sb2.append(": ");
            sb2.append(str);
            Log.e("PhenotypeFlag", sb2.toString());
            return null;
        }
    }
}
