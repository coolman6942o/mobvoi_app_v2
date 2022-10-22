package com.euicc.server.model;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class EUICCInfo implements Parcelable, Cloneable {
    public static final Parcelable.Creator<EUICCInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f8271a;

    /* renamed from: b  reason: collision with root package name */
    private String f8272b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8273c;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<EUICCInfo> {
        a() {
        }

        /* renamed from: a */
        public EUICCInfo createFromParcel(Parcel parcel) {
            return new EUICCInfo(parcel);
        }

        /* renamed from: b */
        public EUICCInfo[] newArray(int i10) {
            return new EUICCInfo[i10];
        }
    }

    public EUICCInfo() {
        this.f8271a = null;
        this.f8272b = null;
        this.f8273c = false;
    }

    /* renamed from: a */
    public EUICCInfo clone() throws CloneNotSupportedException {
        return (EUICCInfo) super.clone();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "SimInfo [mIMSI=" + this.f8271a + ", mICCID=" + this.f8272b + ", mActive=" + this.f8273c + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8271a);
        parcel.writeString(this.f8272b);
        parcel.writeByte(this.f8273c ? (byte) 1 : (byte) 0);
    }

    public EUICCInfo(Parcel parcel) {
        this.f8271a = null;
        this.f8272b = null;
        boolean z10 = false;
        this.f8273c = false;
        this.f8271a = parcel.readString();
        this.f8272b = parcel.readString();
        this.f8273c = parcel.readByte() != 0 ? true : z10;
    }
}
