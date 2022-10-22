package com.chinatelecom.multisimservice.model;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class SimInfo implements Parcelable, Cloneable {
    public static final Parcelable.Creator<SimInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f8223a;

    /* renamed from: b  reason: collision with root package name */
    private String f8224b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8225c;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<SimInfo> {
        a() {
        }

        /* renamed from: a */
        public SimInfo createFromParcel(Parcel parcel) {
            return new SimInfo(parcel);
        }

        /* renamed from: b */
        public SimInfo[] newArray(int i10) {
            return new SimInfo[i10];
        }
    }

    public SimInfo() {
        this.f8223a = null;
        this.f8224b = null;
        this.f8225c = false;
    }

    /* renamed from: a */
    public SimInfo clone() throws CloneNotSupportedException {
        return (SimInfo) super.clone();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "SimInfo [mIMSI=" + this.f8223a + ", mICCID=" + this.f8224b + ", mActive=" + this.f8225c + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8223a);
        parcel.writeString(this.f8224b);
        parcel.writeByte(this.f8225c ? (byte) 1 : (byte) 0);
    }

    public SimInfo(Parcel parcel) {
        this.f8223a = null;
        this.f8224b = null;
        boolean z10 = false;
        this.f8225c = false;
        this.f8223a = parcel.readString();
        this.f8224b = parcel.readString();
        this.f8225c = parcel.readByte() != 0 ? true : z10;
    }
}
