package com.mobvoi.wear.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class ParcelableUtils {
    public static byte[] marshall(Parcelable parcelable) {
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    public static <T> byte[] marshallList(List<T> list) {
        Parcel obtain = Parcel.obtain();
        obtain.writeList(list);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    public static boolean readBool(Parcel parcel) {
        return parcel.readByte() == 1;
    }

    public static <T> T readValue(Parcel parcel) {
        if (parcel.readByte() == 1) {
            return (T) parcel.readValue(Thread.currentThread().getContextClassLoader());
        }
        return null;
    }

    public static <T extends Parcelable> T unmarshall(byte[] bArr, Parcelable.Creator<T> creator) {
        return creator.createFromParcel(unmarshall(bArr));
    }

    public static <T> List<T> unmarshallList(byte[] bArr) {
        Parcel unmarshall = unmarshall(bArr);
        ArrayList arrayList = new ArrayList();
        unmarshall.readList(arrayList, Thread.currentThread().getContextClassLoader());
        return arrayList;
    }

    public static void writeBool(Parcel parcel, boolean z10) {
        parcel.writeByte(z10 ? (byte) 1 : (byte) 0);
    }

    public static void writeString(Parcel parcel, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        parcel.writeString(str);
    }

    public static void writeValue(Parcel parcel, Object obj) {
        if (obj == null) {
            parcel.writeByte((byte) 0);
            return;
        }
        parcel.writeByte((byte) 1);
        parcel.writeValue(obj);
    }

    public static Parcel unmarshall(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        if (bArr != null && bArr.length >= 0) {
            obtain.unmarshall(bArr, 0, bArr.length);
        }
        obtain.setDataPosition(0);
        return obtain;
    }
}
