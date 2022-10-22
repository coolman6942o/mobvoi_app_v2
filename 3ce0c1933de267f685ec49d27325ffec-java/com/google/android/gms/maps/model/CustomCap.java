package com.google.android.gms.maps.model;

import z6.a;
/* loaded from: classes.dex */
public final class CustomCap extends Cap {

    /* renamed from: d  reason: collision with root package name */
    public final a f10036d;

    /* renamed from: e  reason: collision with root package name */
    public final float f10037e;

    @Override // com.google.android.gms.maps.model.Cap
    public final String toString() {
        String valueOf = String.valueOf(this.f10036d);
        float f10 = this.f10037e;
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 55);
        sb2.append("[CustomCap: bitmapDescriptor=");
        sb2.append(valueOf);
        sb2.append(" refWidth=");
        sb2.append(f10);
        sb2.append("]");
        return sb2.toString();
    }
}
