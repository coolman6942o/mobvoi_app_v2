package com.google.android.gms.internal.measurement;

import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b7 extends v6<Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b7(f7 f7Var, String str, Boolean bool) {
        super(f7Var, str, bool, null);
    }

    @Override // com.google.android.gms.internal.measurement.v6
    protected final /* synthetic */ Boolean p(String str) {
        if (q6.f9620c.matcher(str).matches()) {
            return Boolean.TRUE;
        }
        if (q6.f9621d.matcher(str).matches()) {
            return Boolean.FALSE;
        }
        String str2 = this.f9759b;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 28 + String.valueOf(str).length());
        sb2.append("Invalid boolean value for ");
        sb2.append(str2);
        sb2.append(": ");
        sb2.append(str);
        Log.e("PhenotypeFlag", sb2.toString());
        return null;
    }
}
