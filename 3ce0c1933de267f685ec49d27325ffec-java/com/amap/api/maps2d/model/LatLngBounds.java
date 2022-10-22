package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.mapcore2d.a;
import com.amap.api.maps2d.AMapException;
/* loaded from: classes.dex */
public final class LatLngBounds implements Parcelable {
    public static final f CREATOR = new f();

    /* renamed from: a  reason: collision with root package name */
    private final int f7096a;

    /* renamed from: b  reason: collision with root package name */
    public final LatLng f7097b;

    /* renamed from: c  reason: collision with root package name */
    public final LatLng f7098c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LatLngBounds(int i10, LatLng latLng, LatLng latLng2) throws AMapException {
        if (latLng == null) {
            throw new AMapException("null southwest");
        } else if (latLng2 == null) {
            throw new AMapException("null northeast");
        } else if (latLng2.f7094a >= latLng.f7094a) {
            this.f7096a = i10;
            this.f7097b = latLng;
            this.f7098c = latLng2;
        } else {
            throw new AMapException("southern latitude exceeds northern latitude (" + latLng.f7094a + " > " + latLng2.f7094a + ")");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f7096a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.f7097b.equals(latLngBounds.f7097b) && this.f7098c.equals(latLngBounds.f7098c);
    }

    public int hashCode() {
        return a.b(new Object[]{this.f7097b, this.f7098c});
    }

    public String toString() {
        return a.d(a.c("southwest", this.f7097b), a.c("northeast", this.f7098c));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        f.b(this, parcel, i10);
    }
}
