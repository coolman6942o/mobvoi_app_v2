package com.cmcc.server.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* loaded from: classes.dex */
public class MultiSimDeviceInfo implements Parcelable {
    public static final Parcelable.Creator<MultiSimDeviceInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private int f8242a;

    /* renamed from: b  reason: collision with root package name */
    private int f8243b;

    /* renamed from: c  reason: collision with root package name */
    private String f8244c;

    /* renamed from: d  reason: collision with root package name */
    private String f8245d;

    /* renamed from: e  reason: collision with root package name */
    private String f8246e;

    /* renamed from: f  reason: collision with root package name */
    private String f8247f;

    /* renamed from: g  reason: collision with root package name */
    private List<SimInfo> f8248g;

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
    }

    public void a(String str) {
        this.f8244c = str;
    }

    public void b(int i10) {
        this.f8243b = i10;
    }

    public void c(String str) {
        this.f8247f = str;
    }

    public void d(int i10) {
        this.f8242a = i10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f8242a);
        parcel.writeInt(this.f8243b);
        parcel.writeString(this.f8244c);
        parcel.writeString(this.f8245d);
        parcel.writeString(this.f8246e);
        parcel.writeString(this.f8247f);
        parcel.writeTypedList(this.f8248g);
    }

    protected MultiSimDeviceInfo(Parcel parcel) {
        this.f8242a = parcel.readInt();
        this.f8243b = parcel.readInt();
        this.f8244c = parcel.readString();
        this.f8245d = parcel.readString();
        this.f8246e = parcel.readString();
        this.f8247f = parcel.readString();
        this.f8248g = parcel.createTypedArrayList(SimInfo.CREATOR);
    }
}
