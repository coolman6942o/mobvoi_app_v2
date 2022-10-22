package com.realsil.sdk.dfu.params;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class QcConfig implements Parcelable {
    public static final Parcelable.Creator<QcConfig> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f22286a;

    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<QcConfig> {
        /* renamed from: a */
        public QcConfig createFromParcel(Parcel parcel) {
            return new QcConfig(parcel);
        }

        /* renamed from: b */
        public QcConfig[] newArray(int i10) {
            return new QcConfig[i10];
        }
    }

    public QcConfig(Parcel parcel) {
        this.f22286a = parcel.readInt();
    }

    public int a() {
        return this.f22286a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("indicator=%b", Integer.valueOf(this.f22286a));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f22286a);
    }
}
