package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class dt extends m2 implements Parcelable {
    public static final Parcelable.Creator CREATOR = new k2();

    /* renamed from: c  reason: collision with root package name */
    private boolean f21165c;

    /* renamed from: d  reason: collision with root package name */
    private String f21166d;

    public dt(Parcel parcel) {
        super(parcel);
        this.f21166d = parcel.readString();
        this.f21165c = parcel.readByte() != 0;
    }

    public dt(String str, String str2, long j10, boolean z10) {
        this.f21456a = str;
        this.f21457b = j10;
        this.f21166d = str2;
        this.f21165c = z10;
    }

    public final boolean c() {
        return this.f21165c;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return dt.class.getSimpleName() + "(token:" + this.f21456a + ", mGoodUntil:" + this.f21457b + ", isCreatedInternally:" + this.f21165c + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f21456a);
        parcel.writeLong(this.f21457b);
        parcel.writeString(this.f21166d);
        parcel.writeByte(this.f21165c ? (byte) 1 : (byte) 0);
    }
}
