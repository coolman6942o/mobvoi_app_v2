package com.amap.api.services.road;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class Crossroad extends Road {
    public static final Parcelable.Creator<Crossroad> CREATOR = new a();

    /* renamed from: g  reason: collision with root package name */
    private float f7400g;

    /* renamed from: h  reason: collision with root package name */
    private String f7401h;

    /* renamed from: i  reason: collision with root package name */
    private String f7402i;

    /* renamed from: j  reason: collision with root package name */
    private String f7403j;

    /* renamed from: k  reason: collision with root package name */
    private String f7404k;

    /* renamed from: l  reason: collision with root package name */
    private String f7405l;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<Crossroad> {
        a() {
        }

        /* renamed from: a */
        public Crossroad createFromParcel(Parcel parcel) {
            return new Crossroad(parcel, null);
        }

        /* renamed from: b */
        public Crossroad[] newArray(int i10) {
            return null;
        }
    }

    /* synthetic */ Crossroad(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.amap.api.services.road.Road, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.road.Road, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeFloat(this.f7400g);
        parcel.writeString(this.f7401h);
        parcel.writeString(this.f7402i);
        parcel.writeString(this.f7403j);
        parcel.writeString(this.f7404k);
        parcel.writeString(this.f7405l);
    }

    public Crossroad() {
    }

    private Crossroad(Parcel parcel) {
        super(parcel);
        this.f7400g = parcel.readFloat();
        this.f7401h = parcel.readString();
        this.f7402i = parcel.readString();
        this.f7403j = parcel.readString();
        this.f7404k = parcel.readString();
        this.f7405l = parcel.readString();
    }
}
