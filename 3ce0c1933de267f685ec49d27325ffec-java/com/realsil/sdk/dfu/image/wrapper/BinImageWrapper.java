package com.realsil.sdk.dfu.image.wrapper;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class BinImageWrapper extends tl.a implements Parcelable {
    public static final Parcelable.Creator<BinImageWrapper> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f22185a;

    /* renamed from: b  reason: collision with root package name */
    public int f22186b;

    /* renamed from: c  reason: collision with root package name */
    public int f22187c;

    /* renamed from: d  reason: collision with root package name */
    public int f22188d;

    /* renamed from: e  reason: collision with root package name */
    public int f22189e;

    /* renamed from: f  reason: collision with root package name */
    public int f22190f;

    /* renamed from: g  reason: collision with root package name */
    public int f22191g;

    /* renamed from: h  reason: collision with root package name */
    public int f22192h;

    /* renamed from: i  reason: collision with root package name */
    public int f22193i;

    /* renamed from: j  reason: collision with root package name */
    public int f22194j;

    /* renamed from: k  reason: collision with root package name */
    public int f22195k;

    /* renamed from: l  reason: collision with root package name */
    public int f22196l;

    /* renamed from: m  reason: collision with root package name */
    public String f22197m;

    /* renamed from: n  reason: collision with root package name */
    public String f22198n;

    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<BinImageWrapper> {
        /* renamed from: a */
        public BinImageWrapper createFromParcel(Parcel parcel) {
            return new BinImageWrapper(parcel);
        }

        /* renamed from: b */
        public BinImageWrapper[] newArray(int i10) {
            return new BinImageWrapper[i10];
        }
    }

    public BinImageWrapper(Parcel parcel) {
        this.f22196l = 0;
        this.f22185a = parcel.readInt();
        this.f22186b = parcel.readInt();
        this.f22187c = parcel.readInt();
        this.f22188d = parcel.readInt();
        this.f22189e = parcel.readInt();
        this.f22190f = parcel.readInt();
        this.f22191g = parcel.readInt();
        this.f22192h = parcel.readInt();
        this.f22193i = parcel.readInt();
        this.f22194j = parcel.readInt();
        this.f22195k = parcel.readInt();
        this.f22196l = parcel.readInt();
        this.f22197m = parcel.readString();
        this.f22198n = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format(Locale.US, "%s, otaVersion=[%d], icType=[%02X]imageVersion=[%08X], \nformat=[%d], formatedVersion=(%d.%d.%d.%d)->[%s]", this.f22198n, Integer.valueOf(this.f22185a), Integer.valueOf(this.f22186b), Integer.valueOf(this.f22189e), Integer.valueOf(this.f22191g), Integer.valueOf(this.f22192h), Integer.valueOf(this.f22193i), Integer.valueOf(this.f22194j), Integer.valueOf(this.f22195k), this.f22197m);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f22185a);
        parcel.writeInt(this.f22186b);
        parcel.writeInt(this.f22187c);
        parcel.writeInt(this.f22188d);
        parcel.writeInt(this.f22189e);
        parcel.writeInt(this.f22190f);
        parcel.writeInt(this.f22191g);
        parcel.writeInt(this.f22192h);
        parcel.writeInt(this.f22193i);
        parcel.writeInt(this.f22194j);
        parcel.writeInt(this.f22195k);
        parcel.writeInt(this.f22196l);
        parcel.writeString(this.f22197m);
        parcel.writeString(this.f22198n);
    }
}
