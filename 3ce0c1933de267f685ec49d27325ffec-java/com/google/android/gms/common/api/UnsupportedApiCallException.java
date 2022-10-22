package com.google.android.gms.common.api;

import com.google.android.gms.common.Feature;
/* loaded from: classes.dex */
public final class UnsupportedApiCallException extends UnsupportedOperationException {
    private final Feature zzas;

    public UnsupportedApiCallException(Feature feature) {
        this.zzas = feature;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        String valueOf = String.valueOf(this.zzas);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 8);
        sb2.append("Missing ");
        sb2.append(valueOf);
        return sb2.toString();
    }
}
