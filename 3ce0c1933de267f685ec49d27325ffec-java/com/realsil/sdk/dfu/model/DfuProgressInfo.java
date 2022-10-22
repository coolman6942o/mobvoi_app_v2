package com.realsil.sdk.dfu.model;

import android.os.Parcel;
import android.os.Parcelable;
import il.b;
import java.util.Locale;
/* loaded from: classes2.dex */
public class DfuProgressInfo implements Parcelable {
    public static final Parcelable.Creator<DfuProgressInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f22258a;

    /* renamed from: b  reason: collision with root package name */
    public int f22259b;

    /* renamed from: c  reason: collision with root package name */
    public int f22260c;

    /* renamed from: d  reason: collision with root package name */
    public int f22261d;

    /* renamed from: e  reason: collision with root package name */
    public int f22262e;

    /* renamed from: f  reason: collision with root package name */
    public int f22263f;

    /* renamed from: g  reason: collision with root package name */
    public int f22264g;

    /* renamed from: h  reason: collision with root package name */
    public int f22265h;

    /* renamed from: i  reason: collision with root package name */
    public int f22266i;

    /* renamed from: j  reason: collision with root package name */
    public int f22267j;

    /* renamed from: k  reason: collision with root package name */
    public int f22268k;

    /* renamed from: l  reason: collision with root package name */
    public int f22269l;

    /* renamed from: m  reason: collision with root package name */
    public long f22270m;

    /* renamed from: n  reason: collision with root package name */
    public long f22271n;

    /* renamed from: o  reason: collision with root package name */
    public long f22272o;

    /* renamed from: p  reason: collision with root package name */
    public long f22273p;

    /* renamed from: q  reason: collision with root package name */
    public Throughput f22274q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f22275r;

    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<DfuProgressInfo> {
        /* renamed from: a */
        public DfuProgressInfo createFromParcel(Parcel parcel) {
            return new DfuProgressInfo(parcel);
        }

        /* renamed from: b */
        public DfuProgressInfo[] newArray(int i10) {
            return new DfuProgressInfo[i10];
        }
    }

    public DfuProgressInfo() {
        this.f22260c = 0;
        this.f22261d = 0;
        this.f22262e = 0;
        this.f22263f = 0;
        this.f22264g = 0;
        this.f22261d = 0;
        this.f22262e = 0;
        this.f22263f = 0;
        this.f22264g = 0;
        this.f22259b = 0;
        this.f22275r = false;
    }

    public DfuProgressInfo(Parcel parcel) {
        boolean z10 = false;
        this.f22260c = 0;
        this.f22261d = 0;
        this.f22262e = 0;
        this.f22263f = 0;
        this.f22264g = 0;
        this.f22258a = parcel.readInt();
        this.f22259b = parcel.readInt();
        this.f22260c = parcel.readInt();
        this.f22261d = parcel.readInt();
        this.f22262e = parcel.readInt();
        this.f22263f = parcel.readInt();
        this.f22264g = parcel.readInt();
        this.f22266i = parcel.readInt();
        this.f22267j = parcel.readInt();
        this.f22268k = parcel.readInt();
        this.f22269l = parcel.readInt();
        this.f22270m = parcel.readLong();
        this.f22271n = parcel.readLong();
        this.f22272o = parcel.readLong();
        this.f22273p = parcel.readLong();
        this.f22274q = (Throughput) parcel.readParcelable(Throughput.class.getClassLoader());
        this.f22275r = parcel.readByte() != 0 ? true : z10;
    }

    public void A(int i10) {
        this.f22258a = i10;
    }

    public void B(int i10) {
        this.f22261d = i10;
    }

    public void C(int i10) {
        this.f22264g = i10;
    }

    public void D() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f22270m = currentTimeMillis;
        this.f22271n = currentTimeMillis;
        this.f22272o = currentTimeMillis;
        this.f22273p = 0L;
        this.f22274q = this.f22275r ? new Throughput(this.f22258a, this.f22259b) : null;
        b.j(toString());
    }

    public final void a() {
        long max = Math.max(0L, this.f22271n - this.f22270m);
        float f10 = 0.0f;
        float f11 = max > 0 ? (this.f22259b * 1000.0f) / ((float) max) : 0.0f;
        long currentTimeMillis = System.currentTimeMillis();
        long j10 = this.f22259b;
        long j11 = j10 - this.f22273p;
        long j12 = currentTimeMillis - this.f22272o;
        if (j12 > 0) {
            f10 = (((float) j11) * 1000.0f) / ((float) j12);
        }
        this.f22272o = currentTimeMillis;
        this.f22273p = j10;
        Throughput throughput = this.f22274q;
        if (throughput != null) {
            throughput.f22283c = max;
            throughput.f22284d = f11;
            throughput.f22285e = f10;
        }
    }

    public void b(int i10) {
        y(this.f22259b + i10);
        this.f22268k += i10;
    }

    public void c(int i10) {
        A(this.f22258a + i10);
    }

    public int d() {
        return this.f22269l;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f22265h;
    }

    public int f() {
        return this.f22259b;
    }

    public int g() {
        return this.f22266i;
    }

    public int h() {
        return this.f22262e;
    }

    public int i() {
        return this.f22258a;
    }

    public int j() {
        return this.f22263f;
    }

    public int k() {
        return this.f22261d;
    }

    public int l() {
        return this.f22264g;
    }

    public int m() {
        return this.f22260c;
    }

    public int o() {
        return this.f22258a - this.f22259b;
    }

    public Throughput p() {
        return this.f22274q;
    }

    public int r() {
        int i10 = this.f22261d;
        if (i10 == 0) {
            return 0;
        }
        double d10 = 100.0f / i10;
        int i11 = this.f22258a;
        double d11 = this.f22262e + (i11 == 0 ? 0.0d : (this.f22259b * 1.0d) / i11);
        if (d11 < i10) {
            return (int) (d11 * d10);
        }
        return 100;
    }

    public void s(int i10, int i11, int i12, int i13, boolean z10) {
        this.f22265h = i10;
        this.f22266i = i11;
        this.f22267j = i12;
        this.f22258a = i13;
        this.f22275r = z10;
        y(0);
    }

    public boolean t() {
        return this.f22259b >= this.f22258a;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        Locale locale = Locale.US;
        sb2.append(String.format(locale, "image: %d/%d", Integer.valueOf(this.f22262e + 1), Integer.valueOf(this.f22261d)));
        sb2.append(String.format(locale, "\t{binId=0x%04X, imageId=0x%04X, version=0x%04X}", Integer.valueOf(this.f22265h), Integer.valueOf(this.f22266i), Integer.valueOf(this.f22267j)));
        sb2.append(String.format(locale, "\tprogress: %d%%(%d/%d)--%d%%", Integer.valueOf(this.f22260c), Integer.valueOf(this.f22259b), Integer.valueOf(this.f22258a), Integer.valueOf(r())));
        return sb2.toString();
    }

    public boolean u() {
        return this.f22264g >= this.f22261d;
    }

    public void v() {
        this.f22270m = System.currentTimeMillis();
        this.f22259b = this.f22258a;
        int i10 = this.f22262e;
        this.f22263f = i10;
        this.f22264g = i10 + 1;
        b.j(toString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f22258a);
        parcel.writeInt(this.f22259b);
        parcel.writeInt(this.f22260c);
        parcel.writeInt(this.f22261d);
        parcel.writeInt(this.f22262e);
        parcel.writeInt(this.f22263f);
        parcel.writeInt(this.f22264g);
        parcel.writeInt(this.f22266i);
        parcel.writeInt(this.f22267j);
        parcel.writeInt(this.f22268k);
        parcel.writeInt(this.f22269l);
        parcel.writeLong(this.f22270m);
        parcel.writeLong(this.f22271n);
        parcel.writeLong(this.f22272o);
        parcel.writeLong(this.f22273p);
        parcel.writeParcelable(this.f22274q, i10);
        parcel.writeByte(this.f22275r ? (byte) 1 : (byte) 0);
    }

    public void x(int i10) {
        this.f22269l = i10;
    }

    public void y(int i10) {
        this.f22259b = i10;
        this.f22260c = (int) ((i10 * 100.0f) / this.f22258a);
        this.f22271n = System.currentTimeMillis();
        if (this.f22275r) {
            a();
        }
    }

    public void z(int i10) {
        this.f22262e = i10;
    }
}
