package com.google.android.gms.maps.model;
/* loaded from: classes.dex */
public final class Dash extends PatternItem {

    /* renamed from: c  reason: collision with root package name */
    public final float f10038c;

    @Override // com.google.android.gms.maps.model.PatternItem
    public final String toString() {
        float f10 = this.f10038c;
        StringBuilder sb2 = new StringBuilder(30);
        sb2.append("[Dash: length=");
        sb2.append(f10);
        sb2.append("]");
        return sb2.toString();
    }
}
