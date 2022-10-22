package com.realsil.sdk.dfu.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;
/* loaded from: classes2.dex */
public class ImageVersionInfo implements Parcelable {
    public static final Parcelable.Creator<ImageVersionInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f22276a;

    /* renamed from: b  reason: collision with root package name */
    public int f22277b;

    /* renamed from: c  reason: collision with root package name */
    public int f22278c;

    /* renamed from: d  reason: collision with root package name */
    public int f22279d;

    /* renamed from: e  reason: collision with root package name */
    public int f22280e;

    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<ImageVersionInfo> {
        /* renamed from: a */
        public ImageVersionInfo createFromParcel(Parcel parcel) {
            return new ImageVersionInfo(parcel);
        }

        /* renamed from: b */
        public ImageVersionInfo[] newArray(int i10) {
            return new ImageVersionInfo[i10];
        }
    }

    public ImageVersionInfo(int i10, int i11, int i12, int i13) {
        this.f22279d = -1;
        this.f22276a = i10;
        this.f22278c = i11;
        this.f22279d = i12;
        this.f22280e = i13;
    }

    public ImageVersionInfo(int i10, int i11, int i12, int i13, int i14) {
        this.f22279d = -1;
        this.f22276a = i10;
        this.f22278c = i11;
        this.f22279d = i12;
        this.f22280e = i13;
        this.f22277b = i14;
    }

    public ImageVersionInfo(Parcel parcel) {
        this.f22279d = -1;
        this.f22276a = parcel.readInt();
        this.f22277b = parcel.readInt();
        this.f22278c = parcel.readInt();
        this.f22279d = parcel.readInt();
        this.f22280e = parcel.readInt();
    }

    public int a() {
        return this.f22276a;
    }

    public int b() {
        return this.f22277b;
    }

    public int c() {
        return this.f22280e;
    }

    public int d() {
        return this.f22279d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        Locale locale = Locale.US;
        sb2.append(String.format(locale, "bitNumber=%d, imageId=0x%04X", Integer.valueOf(this.f22276a), Integer.valueOf(this.f22277b)));
        sb2.append(String.format(",indication=0x%02X", Integer.valueOf(this.f22278c)));
        sb2.append(String.format(locale, ", version=0x%08X(%d), sectionSize=0x%08X(%d)", Integer.valueOf(this.f22279d), Integer.valueOf(this.f22279d), Integer.valueOf(this.f22280e), Integer.valueOf(this.f22280e)));
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f22276a);
        parcel.writeInt(this.f22277b);
        parcel.writeInt(this.f22278c);
        parcel.writeInt(this.f22279d);
        parcel.writeInt(this.f22280e);
    }
}
