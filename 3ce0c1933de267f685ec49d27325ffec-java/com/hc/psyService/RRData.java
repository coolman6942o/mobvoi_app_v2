package com.hc.psyService;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class RRData implements Parcelable {
    public static final Parcelable.Creator<RRData> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private long f13480a;

    /* renamed from: b  reason: collision with root package name */
    private int f13481b;

    /* renamed from: c  reason: collision with root package name */
    private float f13482c;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<RRData> {
        a() {
        }

        /* renamed from: a */
        public RRData createFromParcel(Parcel parcel) {
            return new RRData(parcel);
        }

        /* renamed from: b */
        public RRData[] newArray(int i10) {
            return new RRData[i10];
        }
    }

    protected RRData(Parcel parcel) {
        this.f13480a = parcel.readLong();
        this.f13481b = parcel.readInt();
        this.f13482c = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f13480a);
        parcel.writeInt(this.f13481b);
        parcel.writeFloat(this.f13482c);
    }
}
