package com.google.android.gms.maps.model;
/* loaded from: classes.dex */
public final class Gap extends PatternItem {

    /* renamed from: c  reason: collision with root package name */
    public final float f10039c;

    @Override // com.google.android.gms.maps.model.PatternItem
    public final String toString() {
        float f10 = this.f10039c;
        StringBuilder sb2 = new StringBuilder(29);
        sb2.append("[Gap: length=");
        sb2.append(f10);
        sb2.append("]");
        return sb2.toString();
    }
}
