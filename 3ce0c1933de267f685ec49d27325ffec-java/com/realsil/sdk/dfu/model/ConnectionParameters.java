package com.realsil.sdk.dfu.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.agconnect.exception.AGCServerException;
import java.util.Locale;
/* loaded from: classes2.dex */
public class ConnectionParameters implements Parcelable {
    public static final Parcelable.Creator<ConnectionParameters> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f22224a;

    /* renamed from: b  reason: collision with root package name */
    public int f22225b;

    /* renamed from: c  reason: collision with root package name */
    public int f22226c;

    /* renamed from: d  reason: collision with root package name */
    public int f22227d;

    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<ConnectionParameters> {
        /* renamed from: a */
        public ConnectionParameters createFromParcel(Parcel parcel) {
            return new ConnectionParameters(parcel);
        }

        /* renamed from: b */
        public ConnectionParameters[] newArray(int i10) {
            return new ConnectionParameters[i10];
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public int f22228a = 17;

        /* renamed from: b  reason: collision with root package name */
        public int f22229b = 6;

        /* renamed from: c  reason: collision with root package name */
        public int f22230c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f22231d = AGCServerException.UNKNOW_EXCEPTION;

        public ConnectionParameters a() {
            il.b.j(String.format(Locale.US, "\tmaxInterval=%d(0x%04X),minInterval=%d(0x%04X),latency=%d(0x%04X),timeout=%d(0x%04X),\n", Integer.valueOf(this.f22228a), Integer.valueOf(this.f22228a), Integer.valueOf(this.f22229b), Integer.valueOf(this.f22229b), Integer.valueOf(this.f22230c), Integer.valueOf(this.f22230c), Integer.valueOf(this.f22231d), Integer.valueOf(this.f22231d)));
            return new ConnectionParameters(this.f22228a, this.f22229b, this.f22230c, this.f22231d);
        }

        public b b(int i10) {
            this.f22230c = i10;
            return this;
        }

        public b c(int i10) {
            this.f22228a = i10;
            return this;
        }

        public b d(int i10) {
            this.f22229b = i10;
            return this;
        }

        public b e(int i10) {
            this.f22231d = i10;
            return this;
        }
    }

    public ConnectionParameters(int i10, int i11, int i12, int i13) {
        this.f22224a = 17;
        this.f22225b = 6;
        this.f22226c = 0;
        this.f22227d = AGCServerException.UNKNOW_EXCEPTION;
        this.f22224a = i10;
        this.f22225b = i11;
        this.f22226c = i12;
        this.f22227d = i13;
    }

    public ConnectionParameters(Parcel parcel) {
        this.f22224a = 17;
        this.f22225b = 6;
        this.f22226c = 0;
        this.f22227d = AGCServerException.UNKNOW_EXCEPTION;
        this.f22224a = parcel.readInt();
        this.f22225b = parcel.readInt();
        this.f22226c = parcel.readInt();
        this.f22227d = parcel.readInt();
    }

    public int a() {
        return this.f22226c;
    }

    public int b() {
        return this.f22224a;
    }

    public int c() {
        return this.f22225b;
    }

    public int d() {
        return this.f22227d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ConnectionParameters{\n" + String.format(Locale.US, "\tmaxInterval=%d(0x%04X),minInterval=%d(0x%04X),latency=%d(0x%04X),timeout=%d(0x%04X),\n", Integer.valueOf(this.f22224a), Integer.valueOf(this.f22224a), Integer.valueOf(this.f22225b), Integer.valueOf(this.f22225b), Integer.valueOf(this.f22226c), Integer.valueOf(this.f22226c), Integer.valueOf(this.f22227d), Integer.valueOf(this.f22227d)) + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f22224a);
        parcel.writeInt(this.f22225b);
        parcel.writeInt(this.f22226c);
        parcel.writeInt(this.f22227d);
    }
}
