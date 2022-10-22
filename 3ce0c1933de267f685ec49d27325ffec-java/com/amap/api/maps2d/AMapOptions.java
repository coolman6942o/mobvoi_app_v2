package com.amap.api.maps2d;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps2d.model.CameraPosition;
import l4.a;
/* loaded from: classes.dex */
public class AMapOptions implements Parcelable {
    public static final a CREATOR = new a();

    /* renamed from: f  reason: collision with root package name */
    private CameraPosition f7061f;

    /* renamed from: a  reason: collision with root package name */
    private int f7056a = 1;

    /* renamed from: b  reason: collision with root package name */
    private boolean f7057b = true;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7058c = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7059d = true;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7060e = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f7062g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f7063h = false;

    public AMapOptions a(CameraPosition cameraPosition) {
        this.f7061f = cameraPosition;
        return this;
    }

    public AMapOptions b(boolean z10) {
        this.f7062g = z10;
        return this;
    }

    public AMapOptions c(int i10) {
        this.f7056a = i10;
        return this;
    }

    public AMapOptions d(boolean z10) {
        this.f7063h = z10;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AMapOptions e(boolean z10) {
        this.f7057b = z10;
        return this;
    }

    public AMapOptions f(boolean z10) {
        this.f7060e = z10;
        return this;
    }

    public AMapOptions g(boolean z10) {
        this.f7059d = z10;
        return this;
    }

    public AMapOptions h(boolean z10) {
        this.f7058c = z10;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f7061f, i10);
        parcel.writeInt(this.f7056a);
        parcel.writeBooleanArray(new boolean[]{this.f7057b, this.f7058c, this.f7059d, this.f7060e, this.f7062g, this.f7063h});
    }
}
