package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SafeParcelReader {

    /* loaded from: classes.dex */
    public static class ParseException extends RuntimeException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public ParseException(String str, Parcel parcel) {
            super(r2.toString());
            int dataPosition = parcel.dataPosition();
            int dataSize = parcel.dataSize();
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 41);
            sb2.append(str);
            sb2.append(" Parcel: pos=");
            sb2.append(dataPosition);
            sb2.append(" size=");
            sb2.append(dataSize);
        }
    }

    public static Float A(Parcel parcel, int i10) {
        int J = J(parcel, i10);
        if (J == 0) {
            return null;
        }
        N(parcel, i10, J, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static int B(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder C(Parcel parcel, int i10) {
        int J = J(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + J);
        return readStrongBinder;
    }

    public static int D(Parcel parcel, int i10) {
        M(parcel, i10, 4);
        return parcel.readInt();
    }

    public static Integer E(Parcel parcel, int i10) {
        int J = J(parcel, i10);
        if (J == 0) {
            return null;
        }
        N(parcel, i10, J, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static void F(Parcel parcel, int i10, List list, ClassLoader classLoader) {
        int J = J(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (J != 0) {
            parcel.readList(list, classLoader);
            parcel.setDataPosition(dataPosition + J);
        }
    }

    public static long G(Parcel parcel, int i10) {
        M(parcel, i10, 8);
        return parcel.readLong();
    }

    public static Long H(Parcel parcel, int i10) {
        int J = J(parcel, i10);
        if (J == 0) {
            return null;
        }
        N(parcel, i10, J, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static short I(Parcel parcel, int i10) {
        M(parcel, i10, 4);
        return (short) parcel.readInt();
    }

    public static int J(Parcel parcel, int i10) {
        return (i10 & (-65536)) != -65536 ? (i10 >> 16) & 65535 : parcel.readInt();
    }

    public static void K(Parcel parcel, int i10) {
        parcel.setDataPosition(parcel.dataPosition() + J(parcel, i10));
    }

    public static int L(Parcel parcel) {
        int B = B(parcel);
        int J = J(parcel, B);
        int dataPosition = parcel.dataPosition();
        if (u(B) != 20293) {
            String valueOf = String.valueOf(Integer.toHexString(B));
            throw new ParseException(valueOf.length() != 0 ? "Expected object header. Got 0x".concat(valueOf) : new String("Expected object header. Got 0x"), parcel);
        }
        int i10 = J + dataPosition;
        if (i10 >= dataPosition && i10 <= parcel.dataSize()) {
            return i10;
        }
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("Size read is invalid start=");
        sb2.append(dataPosition);
        sb2.append(" end=");
        sb2.append(i10);
        throw new ParseException(sb2.toString(), parcel);
    }

    private static void M(Parcel parcel, int i10, int i11) {
        int J = J(parcel, i10);
        if (J != i11) {
            String hexString = Integer.toHexString(J);
            StringBuilder sb2 = new StringBuilder(String.valueOf(hexString).length() + 46);
            sb2.append("Expected size ");
            sb2.append(i11);
            sb2.append(" got ");
            sb2.append(J);
            sb2.append(" (0x");
            sb2.append(hexString);
            sb2.append(")");
            throw new ParseException(sb2.toString(), parcel);
        }
    }

    private static void N(Parcel parcel, int i10, int i11, int i12) {
        if (i11 != i12) {
            String hexString = Integer.toHexString(i11);
            StringBuilder sb2 = new StringBuilder(String.valueOf(hexString).length() + 46);
            sb2.append("Expected size ");
            sb2.append(i12);
            sb2.append(" got ");
            sb2.append(i11);
            sb2.append(" (0x");
            sb2.append(hexString);
            sb2.append(")");
            throw new ParseException(sb2.toString(), parcel);
        }
    }

    public static BigDecimal a(Parcel parcel, int i10) {
        int J = J(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(dataPosition + J);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    public static BigDecimal[] b(Parcel parcel, int i10) {
        int J = J(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i11 = 0; i11 < readInt; i11++) {
            byte[] createByteArray = parcel.createByteArray();
            bigDecimalArr[i11] = new BigDecimal(new BigInteger(createByteArray), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + J);
        return bigDecimalArr;
    }

    public static BigInteger c(Parcel parcel, int i10) {
        int J = J(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + J);
        return new BigInteger(createByteArray);
    }

    public static BigInteger[] d(Parcel parcel, int i10) {
        int J = J(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[readInt];
        for (int i11 = 0; i11 < readInt; i11++) {
            bigIntegerArr[i11] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + J);
        return bigIntegerArr;
    }

    public static boolean[] e(Parcel parcel, int i10) {
        int J = J(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(dataPosition + J);
        return createBooleanArray;
    }

    public static Bundle f(Parcel parcel, int i10) {
        int J = J(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + J);
        return readBundle;
    }

    public static byte[] g(Parcel parcel, int i10) {
        int J = J(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + J);
        return createByteArray;
    }

    public static double[] h(Parcel parcel, int i10) {
        int J = J(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        double[] createDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(dataPosition + J);
        return createDoubleArray;
    }

    public static float[] i(Parcel parcel, int i10) {
        int J = J(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(dataPosition + J);
        return createFloatArray;
    }

    public static int[] j(Parcel parcel, int i10) {
        int J = J(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + J);
        return createIntArray;
    }

    public static long[] k(Parcel parcel, int i10) {
        int J = J(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(dataPosition + J);
        return createLongArray;
    }

    public static Parcel l(Parcel parcel, int i10) {
        int J = J(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, J);
        parcel.setDataPosition(dataPosition + J);
        return obtain;
    }

    public static Parcel[] m(Parcel parcel, int i10) {
        int J = J(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        Parcel[] parcelArr = new Parcel[readInt];
        for (int i11 = 0; i11 < readInt; i11++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                parcelArr[i11] = obtain;
                parcel.setDataPosition(dataPosition2 + readInt2);
            } else {
                parcelArr[i11] = null;
            }
        }
        parcel.setDataPosition(dataPosition + J);
        return parcelArr;
    }

    public static <T extends Parcelable> T n(Parcel parcel, int i10, Parcelable.Creator<T> creator) {
        int J = J(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        T createFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + J);
        return createFromParcel;
    }

    public static String o(Parcel parcel, int i10) {
        int J = J(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + J);
        return readString;
    }

    public static String[] p(Parcel parcel, int i10) {
        int J = J(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(dataPosition + J);
        return createStringArray;
    }

    public static ArrayList<String> q(Parcel parcel, int i10) {
        int J = J(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + J);
        return createStringArrayList;
    }

    public static <T> T[] r(Parcel parcel, int i10, Parcelable.Creator<T> creator) {
        int J = J(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + J);
        return tArr;
    }

    public static <T> ArrayList<T> s(Parcel parcel, int i10, Parcelable.Creator<T> creator) {
        int J = J(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + J);
        return createTypedArrayList;
    }

    public static void t(Parcel parcel, int i10) {
        if (parcel.dataPosition() != i10) {
            StringBuilder sb2 = new StringBuilder(37);
            sb2.append("Overread allowed size end=");
            sb2.append(i10);
            throw new ParseException(sb2.toString(), parcel);
        }
    }

    public static int u(int i10) {
        return i10 & 65535;
    }

    public static boolean v(Parcel parcel, int i10) {
        M(parcel, i10, 4);
        return parcel.readInt() != 0;
    }

    public static byte w(Parcel parcel, int i10) {
        M(parcel, i10, 4);
        return (byte) parcel.readInt();
    }

    public static double x(Parcel parcel, int i10) {
        M(parcel, i10, 8);
        return parcel.readDouble();
    }

    public static Double y(Parcel parcel, int i10) {
        int J = J(parcel, i10);
        if (J == 0) {
            return null;
        }
        N(parcel, i10, J, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static float z(Parcel parcel, int i10) {
        M(parcel, i10, 4);
        return parcel.readFloat();
    }
}
