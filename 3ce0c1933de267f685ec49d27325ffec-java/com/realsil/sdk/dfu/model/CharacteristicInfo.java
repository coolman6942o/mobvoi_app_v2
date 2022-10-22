package com.realsil.sdk.dfu.model;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class CharacteristicInfo implements Parcelable {
    public static final Parcelable.Creator<CharacteristicInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f22222a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f22223b;

    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<CharacteristicInfo> {
        /* renamed from: a */
        public CharacteristicInfo createFromParcel(Parcel parcel) {
            return new CharacteristicInfo(parcel);
        }

        /* renamed from: b */
        public CharacteristicInfo[] newArray(int i10) {
            return new CharacteristicInfo[i10];
        }
    }

    public CharacteristicInfo(int i10, byte[] bArr) {
        this.f22222a = i10;
        this.f22223b = bArr;
    }

    public CharacteristicInfo(Parcel parcel) {
        this.f22222a = parcel.readInt();
        this.f22223b = parcel.createByteArray();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f22222a);
        parcel.writeByteArray(this.f22223b);
    }
}
