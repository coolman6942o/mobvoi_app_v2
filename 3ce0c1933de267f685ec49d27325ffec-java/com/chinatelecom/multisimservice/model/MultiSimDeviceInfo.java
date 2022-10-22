package com.chinatelecom.multisimservice.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class MultiSimDeviceInfo implements Parcelable {
    public static final Parcelable.Creator<MultiSimDeviceInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private int f8216a;

    /* renamed from: b  reason: collision with root package name */
    private int f8217b;

    /* renamed from: c  reason: collision with root package name */
    private String f8218c;

    /* renamed from: d  reason: collision with root package name */
    private String f8219d;

    /* renamed from: e  reason: collision with root package name */
    private String f8220e;

    /* renamed from: f  reason: collision with root package name */
    private String f8221f;

    /* renamed from: g  reason: collision with root package name */
    private List<SimInfo> f8222g;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<MultiSimDeviceInfo> {
        a() {
        }

        /* renamed from: a */
        public MultiSimDeviceInfo createFromParcel(Parcel parcel) {
            return new MultiSimDeviceInfo(parcel);
        }

        /* renamed from: b */
        public MultiSimDeviceInfo[] newArray(int i10) {
            return new MultiSimDeviceInfo[i10];
        }
    }

    public MultiSimDeviceInfo() {
        this.f8222g = null;
    }

    public void a(String str) {
        this.f8218c = str;
    }

    public void b(int i10) {
        this.f8217b = i10;
    }

    public void c(String str) {
        this.f8221f = str;
    }

    public void d(int i10) {
        this.f8216a = i10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        List<SimInfo> list = this.f8222g;
        if (list != null && !list.isEmpty()) {
            for (SimInfo simInfo : this.f8222g) {
                stringBuffer.append(simInfo.toString());
            }
        }
        return "MultiSimDeviceInfo [mDeviceType=" + this.f8217b + ", mDeviceIdentifierm=" + this.f8218c + ", mDeviceSerialNumber=" + this.f8219d + ", mProductName=" + this.f8220e + ", mEID=" + this.f8221f + ", mProfileInfoList=[" + stringBuffer.toString() + "] ]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f8216a);
        parcel.writeInt(this.f8217b);
        parcel.writeString(this.f8218c);
        parcel.writeString(this.f8219d);
        parcel.writeString(this.f8220e);
        parcel.writeString(this.f8221f);
        parcel.writeTypedList(this.f8222g);
    }

    public MultiSimDeviceInfo(Parcel parcel) {
        this.f8222g = null;
        this.f8216a = parcel.readInt();
        this.f8217b = parcel.readInt();
        this.f8218c = parcel.readString();
        this.f8219d = parcel.readString();
        this.f8220e = parcel.readString();
        this.f8221f = parcel.readString();
        if (this.f8222g == null) {
            this.f8222g = new ArrayList();
        }
        parcel.readTypedList(this.f8222g, SimInfo.CREATOR);
    }
}
