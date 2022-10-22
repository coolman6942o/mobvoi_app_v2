package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class DrivePath extends Path {
    public static final Parcelable.Creator<DrivePath> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    private String f7430c;

    /* renamed from: d  reason: collision with root package name */
    private float f7431d;

    /* renamed from: e  reason: collision with root package name */
    private float f7432e;

    /* renamed from: f  reason: collision with root package name */
    private int f7433f;

    /* renamed from: g  reason: collision with root package name */
    private List<DriveStep> f7434g;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<DrivePath> {
        a() {
        }

        /* renamed from: a */
        public DrivePath createFromParcel(Parcel parcel) {
            return new DrivePath(parcel);
        }

        /* renamed from: b */
        public DrivePath[] newArray(int i10) {
            return null;
        }
    }

    public DrivePath(Parcel parcel) {
        super(parcel);
        this.f7434g = new ArrayList();
        this.f7430c = parcel.readString();
        this.f7431d = parcel.readFloat();
        this.f7432e = parcel.readFloat();
        this.f7434g = parcel.createTypedArrayList(DriveStep.CREATOR);
        this.f7433f = parcel.readInt();
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.f7430c);
        parcel.writeFloat(this.f7431d);
        parcel.writeFloat(this.f7432e);
        parcel.writeTypedList(this.f7434g);
        parcel.writeInt(this.f7433f);
    }

    public DrivePath() {
        this.f7434g = new ArrayList();
    }
}
