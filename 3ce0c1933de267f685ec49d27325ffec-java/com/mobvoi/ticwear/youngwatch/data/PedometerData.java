package com.mobvoi.ticwear.youngwatch.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;
/* loaded from: classes2.dex */
public class PedometerData implements Parcelable {
    public static final Parcelable.Creator<PedometerData> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private int f20846a;

    /* renamed from: b  reason: collision with root package name */
    private int f20847b;

    /* renamed from: c  reason: collision with root package name */
    private float f20848c;

    /* renamed from: d  reason: collision with root package name */
    private String f20849d;

    /* renamed from: e  reason: collision with root package name */
    private double f20850e;

    /* renamed from: f  reason: collision with root package name */
    private String f20851f;

    /* renamed from: g  reason: collision with root package name */
    private String f20852g;

    /* renamed from: h  reason: collision with root package name */
    private String f20853h;

    /* renamed from: i  reason: collision with root package name */
    private int f20854i;

    /* renamed from: j  reason: collision with root package name */
    private double f20855j;

    /* renamed from: k  reason: collision with root package name */
    private long f20856k;

    /* renamed from: l  reason: collision with root package name */
    private int f20857l;

    /* renamed from: m  reason: collision with root package name */
    private Date f20858m;

    /* renamed from: n  reason: collision with root package name */
    private int f20859n;

    /* renamed from: o  reason: collision with root package name */
    private int f20860o;

    /* renamed from: p  reason: collision with root package name */
    private int f20861p;

    /* renamed from: q  reason: collision with root package name */
    private long f20862q;

    /* renamed from: r  reason: collision with root package name */
    private int f20863r;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<PedometerData> {
        a() {
        }

        /* renamed from: a */
        public PedometerData createFromParcel(Parcel parcel) {
            return new PedometerData(parcel, null);
        }

        /* renamed from: b */
        public PedometerData[] newArray(int i10) {
            return new PedometerData[i10];
        }
    }

    /* synthetic */ PedometerData(Parcel parcel, a aVar) {
        this(parcel);
    }

    public double a() {
        return this.f20850e;
    }

    public int b() {
        return this.f20854i;
    }

    public long c() {
        return this.f20856k;
    }

    public long d() {
        return this.f20862q;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f20863r;
    }

    public void f(double d10) {
        this.f20850e = d10;
    }

    public void g(int i10) {
        this.f20854i = i10;
    }

    public void h(long j10) {
        this.f20856k = j10;
    }

    public void i(long j10) {
        this.f20862q = j10;
        this.f20858m.setTime(j10 * 1000);
    }

    public void j(int i10) {
        this.f20863r = i10;
    }

    public String toString() {
        return "PedometerData [deviceSn=" + this.f20853h + ", broadcastId=" + this.f20849d + ", date=" + this.f20851f + ", deviceId=" + this.f20852g + ", userNo=" + this.f20861p + ", walkSteps=" + this.f20863r + ", runSteps=" + this.f20859n + ", examount=" + this.f20855j + ", calories=" + this.f20850e + ", exerciseTime=" + this.f20856k + ", distance=" + this.f20854i + ", battery=" + this.f20846a + ", sleepStatus=" + this.f20860o + ", intensityLevel=" + this.f20857l + ", utc=" + this.f20862q + ", batteryVoltage=" + this.f20848c + ", measureTime=" + this.f20858m + ", batteryPercent=" + this.f20847b + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f20853h);
        parcel.writeString(this.f20849d);
        parcel.writeString(this.f20851f);
        parcel.writeString(this.f20852g);
        parcel.writeInt(this.f20861p);
        parcel.writeInt(this.f20863r);
        parcel.writeInt(this.f20859n);
        parcel.writeDouble(this.f20855j);
        parcel.writeDouble(this.f20850e);
        parcel.writeLong(this.f20856k);
        parcel.writeInt(this.f20854i);
        parcel.writeInt(this.f20846a);
        parcel.writeInt(this.f20860o);
        parcel.writeInt(this.f20857l);
        parcel.writeLong(this.f20862q);
        parcel.writeFloat(this.f20848c);
        parcel.writeInt(this.f20847b);
    }

    public PedometerData() {
        this.f20858m = new Date();
    }

    private PedometerData(Parcel parcel) {
        this.f20853h = parcel.readString();
        this.f20849d = parcel.readString();
        this.f20851f = parcel.readString();
        this.f20852g = parcel.readString();
        this.f20861p = parcel.readInt();
        this.f20863r = parcel.readInt();
        this.f20859n = parcel.readInt();
        this.f20855j = parcel.readDouble();
        this.f20850e = parcel.readDouble();
        this.f20856k = parcel.readLong();
        this.f20854i = parcel.readInt();
        this.f20846a = parcel.readInt();
        this.f20860o = parcel.readInt();
        this.f20857l = parcel.readInt();
        this.f20862q = parcel.readLong();
        this.f20848c = parcel.readFloat();
        this.f20847b = parcel.readInt();
    }
}
