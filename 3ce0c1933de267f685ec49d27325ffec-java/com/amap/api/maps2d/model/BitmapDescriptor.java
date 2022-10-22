package com.amap.api.maps2d.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.mapcore2d.a;
/* loaded from: classes.dex */
public final class BitmapDescriptor implements Parcelable, Cloneable {

    /* renamed from: d  reason: collision with root package name */
    static final b f7065d = new b();

    /* renamed from: a  reason: collision with root package name */
    int f7066a;

    /* renamed from: b  reason: collision with root package name */
    int f7067b;

    /* renamed from: c  reason: collision with root package name */
    Bitmap f7068c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BitmapDescriptor(Bitmap bitmap) {
        this.f7066a = 0;
        this.f7067b = 0;
        if (bitmap != null) {
            this.f7066a = bitmap.getWidth();
            this.f7067b = bitmap.getHeight();
            this.f7068c = bitmap;
        }
    }

    /* renamed from: a */
    public BitmapDescriptor clone() {
        try {
            return new BitmapDescriptor(Bitmap.createBitmap(this.f7068c), this.f7066a, this.f7067b);
        } catch (Throwable th2) {
            a.e(th2, "BitmapDescriptor", "clone");
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f7068c, i10);
        parcel.writeInt(this.f7066a);
        parcel.writeInt(this.f7067b);
    }

    private BitmapDescriptor(Bitmap bitmap, int i10, int i11) {
        this.f7066a = 0;
        this.f7067b = 0;
        this.f7066a = i10;
        this.f7067b = i11;
        this.f7068c = bitmap;
    }
}
