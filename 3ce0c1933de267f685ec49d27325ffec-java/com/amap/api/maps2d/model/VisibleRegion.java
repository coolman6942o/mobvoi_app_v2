package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.mapcore2d.a;
/* loaded from: classes.dex */
public final class VisibleRegion implements Parcelable {
    public static final m CREATOR = new m();

    /* renamed from: a  reason: collision with root package name */
    private final int f7159a;

    /* renamed from: b  reason: collision with root package name */
    public final LatLng f7160b;

    /* renamed from: c  reason: collision with root package name */
    public final LatLng f7161c;

    /* renamed from: d  reason: collision with root package name */
    public final LatLng f7162d;

    /* renamed from: e  reason: collision with root package name */
    public final LatLng f7163e;

    /* renamed from: f  reason: collision with root package name */
    public final LatLngBounds f7164f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VisibleRegion(int i10, LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds) {
        this.f7159a = i10;
        this.f7160b = latLng;
        this.f7161c = latLng2;
        this.f7162d = latLng3;
        this.f7163e = latLng4;
        this.f7164f = latLngBounds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f7159a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisibleRegion)) {
            return false;
        }
        VisibleRegion visibleRegion = (VisibleRegion) obj;
        return this.f7160b.equals(visibleRegion.f7160b) && this.f7161c.equals(visibleRegion.f7161c) && this.f7162d.equals(visibleRegion.f7162d) && this.f7163e.equals(visibleRegion.f7163e) && this.f7164f.equals(visibleRegion.f7164f);
    }

    public int hashCode() {
        return a.b(new Object[]{this.f7160b, this.f7161c, this.f7162d, this.f7163e, this.f7164f});
    }

    public String toString() {
        return a.d(a.c("nearLeft", this.f7160b), a.c("nearRight", this.f7161c), a.c("farLeft", this.f7162d), a.c("farRight", this.f7163e), a.c("latLngBounds", this.f7164f));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        m.b(this, parcel, i10);
    }
}
