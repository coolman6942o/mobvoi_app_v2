package com.realsil.sdk.dfu.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;
/* loaded from: classes2.dex */
public class Throughput implements Parcelable {
    public static final Parcelable.Creator<Throughput> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public long f22281a;

    /* renamed from: b  reason: collision with root package name */
    public long f22282b;

    /* renamed from: c  reason: collision with root package name */
    public long f22283c;

    /* renamed from: d  reason: collision with root package name */
    public float f22284d;

    /* renamed from: e  reason: collision with root package name */
    public float f22285e;

    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<Throughput> {
        /* renamed from: a */
        public Throughput createFromParcel(Parcel parcel) {
            return new Throughput(parcel);
        }

        /* renamed from: b */
        public Throughput[] newArray(int i10) {
            return new Throughput[i10];
        }
    }

    public Throughput(long j10, long j11) {
        this(j10, j11, 0L, 0.0f);
    }

    public Throughput(long j10, long j11, long j12, float f10) {
        this(j10, j11, j12, f10, 0.0f);
    }

    public Throughput(long j10, long j11, long j12, float f10, float f11) {
        this.f22281a = j10;
        this.f22282b = j11;
        this.f22283c = j12;
        this.f22284d = f10;
        this.f22285e = f11;
    }

    public Throughput(Parcel parcel) {
        this.f22281a = parcel.readLong();
        this.f22282b = parcel.readLong();
        this.f22283c = parcel.readLong();
        this.f22284d = parcel.readFloat();
        this.f22285e = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format(Locale.US, "packetSize=%d, deltaTime=%d ms, speed=%f, realSpeed=%f", Long.valueOf(this.f22281a), Long.valueOf(this.f22283c), Float.valueOf(this.f22284d), Float.valueOf(this.f22285e));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f22281a);
        parcel.writeLong(this.f22282b);
        parcel.writeLong(this.f22283c);
        parcel.writeFloat(this.f22284d);
        parcel.writeFloat(this.f22285e);
    }
}
