package com.cmcc.server.model;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class SimInfo implements Parcelable {
    public static final Parcelable.Creator<SimInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f8249a;

    /* renamed from: b  reason: collision with root package name */
    private String f8250b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8251c;

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

    protected SimInfo(Parcel parcel) {
        this.f8249a = parcel.readString();
        this.f8250b = parcel.readString();
        this.f8251c = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8249a);
        parcel.writeString(this.f8250b);
        parcel.writeByte(this.f8251c ? (byte) 1 : (byte) 0);
    }
}
