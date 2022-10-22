package com.euicc.server.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class EUICCDeviceInfo implements Parcelable {
    public static final Parcelable.Creator<EUICCDeviceInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private int f8264a;

    /* renamed from: b  reason: collision with root package name */
    private int f8265b;

    /* renamed from: c  reason: collision with root package name */
    private String f8266c;

    /* renamed from: d  reason: collision with root package name */
    private String f8267d;

    /* renamed from: e  reason: collision with root package name */
    private String f8268e;

    /* renamed from: f  reason: collision with root package name */
    private String f8269f;

    /* renamed from: g  reason: collision with root package name */
    private List<EUICCInfo> f8270g;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<EUICCDeviceInfo> {
        a() {
        }

        /* renamed from: a */
        public EUICCDeviceInfo createFromParcel(Parcel parcel) {
            return new EUICCDeviceInfo(parcel);
        }

        /* renamed from: b */
        public EUICCDeviceInfo[] newArray(int i10) {
            return new EUICCDeviceInfo[i10];
        }
    }

    public EUICCDeviceInfo() {
        this.f8270g = null;
    }

    public void a(String str) {
        this.f8266c = str;
    }

    public void b(int i10) {
        this.f8265b = i10;
    }

    public void c(String str) {
        this.f8269f = str;
    }

    public void d(int i10) {
        this.f8264a = i10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        List<EUICCInfo> list = this.f8270g;
        if (list != null && !list.isEmpty()) {
            for (EUICCInfo eUICCInfo : this.f8270g) {
                stringBuffer.append(eUICCInfo.toString());
            }
        }
        return "MultiSimDeviceInfo [mDeviceType=" + this.f8265b + ", mDeviceIdentifierm=" + this.f8266c + ", mDeviceSerialNumber=" + this.f8267d + ", mProductName=" + this.f8268e + ", mEID=" + this.f8269f + ", mProfileInfoList=[" + stringBuffer.toString() + "] ]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f8264a);
        parcel.writeInt(this.f8265b);
        parcel.writeString(this.f8266c);
        parcel.writeString(this.f8267d);
        parcel.writeString(this.f8268e);
        parcel.writeString(this.f8269f);
        parcel.writeTypedList(this.f8270g);
    }

    public EUICCDeviceInfo(Parcel parcel) {
        this.f8270g = null;
        this.f8264a = parcel.readInt();
        this.f8265b = parcel.readInt();
        this.f8266c = parcel.readString();
        this.f8267d = parcel.readString();
        this.f8268e = parcel.readString();
        this.f8269f = parcel.readString();
        if (this.f8270g == null) {
            this.f8270g = new ArrayList();
        }
        parcel.readTypedList(this.f8270g, EUICCInfo.CREATOR);
    }
}
