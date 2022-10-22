package com.mobvoi.mcuwatch.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class SportControlBean implements Parcelable {
    public static final Parcelable.Creator<SportControlBean> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public double f19132a;

    /* renamed from: b  reason: collision with root package name */
    public int f19133b;

    /* renamed from: c  reason: collision with root package name */
    public float f19134c;

    /* renamed from: d  reason: collision with root package name */
    public int f19135d;

    /* renamed from: e  reason: collision with root package name */
    public int f19136e;

    /* renamed from: f  reason: collision with root package name */
    public int f19137f;

    /* renamed from: g  reason: collision with root package name */
    public String f19138g;

    /* renamed from: h  reason: collision with root package name */
    public double f19139h;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SportControlBean> {
        a() {
        }

        /* renamed from: a */
        public SportControlBean createFromParcel(Parcel parcel) {
            return new SportControlBean(parcel);
        }

        /* renamed from: b */
        public SportControlBean[] newArray(int i10) {
            return new SportControlBean[i10];
        }
    }

    public SportControlBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeDouble(this.f19132a);
        parcel.writeInt(this.f19133b);
        parcel.writeFloat(this.f19134c);
        parcel.writeInt(this.f19135d);
        parcel.writeInt(this.f19136e);
        parcel.writeInt(this.f19137f);
        parcel.writeString(this.f19138g);
        parcel.writeDouble(this.f19139h);
    }

    protected SportControlBean(Parcel parcel) {
        this.f19132a = parcel.readDouble();
        this.f19133b = parcel.readInt();
        this.f19134c = parcel.readFloat();
        this.f19135d = parcel.readInt();
        this.f19136e = parcel.readInt();
        this.f19137f = parcel.readInt();
        this.f19138g = parcel.readString();
        this.f19139h = parcel.readDouble();
    }
}
