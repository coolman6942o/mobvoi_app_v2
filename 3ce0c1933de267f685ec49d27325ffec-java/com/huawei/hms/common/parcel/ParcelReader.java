package com.huawei.hms.common.parcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class ParcelReader {

    /* renamed from: b  reason: collision with root package name */
    private static final int f13714b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static final int f13715c = 1;

    /* renamed from: d  reason: collision with root package name */
    private static final int f13716d = 65262;

    /* renamed from: a  reason: collision with root package name */
    HashMap<Integer, Integer[]> f13717a = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private Parcel f13718e;

    /* loaded from: classes.dex */
    public class ParseException extends RuntimeException {
        public ParseException(String str, Parcel parcel) {
            super(str);
        }
    }

    public ParcelReader(Parcel parcel) {
        this.f13718e = parcel;
        a();
    }

    private int a(int i10) {
        Integer[] numArr = this.f13717a.get(Integer.valueOf(i10));
        if (numArr != null) {
            this.f13718e.setDataPosition(numArr[0].intValue());
            return numArr[1].intValue();
        }
        throw new ParseException("Field is null:".concat(String.valueOf(numArr)), this.f13718e);
    }

    private void a() {
        int readInt = this.f13718e.readInt();
        int i10 = readInt & 65535;
        int readInt2 = (readInt & (-65536)) != -65536 ? (readInt >> 16) & 65535 : this.f13718e.readInt();
        if (i10 == f13716d) {
            int dataPosition = this.f13718e.dataPosition();
            int i11 = readInt2 + dataPosition;
            if (i11 < dataPosition || i11 > this.f13718e.dataSize()) {
                throw new ParseException("invalid size, start=" + dataPosition + " end=" + i11, this.f13718e);
            }
            while (this.f13718e.dataPosition() < i11) {
                int readInt3 = this.f13718e.readInt();
                int i12 = readInt3 & 65535;
                int readInt4 = (readInt3 & (-65536)) != -65536 ? (readInt3 >> 16) & 65535 : this.f13718e.readInt();
                int dataPosition2 = this.f13718e.dataPosition();
                this.f13717a.put(Integer.valueOf(i12), new Integer[]{Integer.valueOf(dataPosition2), Integer.valueOf(readInt4)});
                this.f13718e.setDataPosition(dataPosition2 + readInt4);
            }
            if (this.f13718e.dataPosition() != i11) {
                throw new ParseException("the dataPosition is not".concat(String.valueOf(i11)), this.f13718e);
            }
            return;
        }
        throw new ParseException("Parse header error, not 65262. Got 0x".concat(String.valueOf(Integer.toHexString(i10))), this.f13718e);
    }

    private void a(int i10, int i11) {
        Integer[] numArr = this.f13717a.get(Integer.valueOf(i10));
        if (numArr != null) {
            int intValue = numArr[1].intValue();
            if (intValue != i11) {
                String hexString = Integer.toHexString(intValue);
                throw new ParseException("the field size is not " + i11 + " got " + intValue + " (0x" + hexString + ")", this.f13718e);
            }
            return;
        }
        throw new ParseException("Field is null:".concat(String.valueOf(numArr)), this.f13718e);
    }

    private int b(int i10, int i11) {
        Integer[] numArr = this.f13717a.get(Integer.valueOf(i10));
        if (numArr != null) {
            this.f13718e.setDataPosition(numArr[0].intValue());
            a(i10, i11);
            return i11;
        }
        throw new ParseException("Field is null:".concat(String.valueOf(numArr)), this.f13718e);
    }

    public BigDecimal createBigDecimal(int i10, BigDecimal bigDecimal) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return bigDecimal;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        byte[] createByteArray = this.f13718e.createByteArray();
        int readInt = this.f13718e.readInt();
        this.f13718e.setDataPosition(dataPosition + a10);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    public BigDecimal[] createBigDecimalArray(int i10, BigDecimal[] bigDecimalArr) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return bigDecimalArr;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        int readInt = this.f13718e.readInt();
        BigDecimal[] bigDecimalArr2 = new BigDecimal[readInt];
        for (int i11 = 0; i11 < readInt; i11++) {
            byte[] createByteArray = this.f13718e.createByteArray();
            bigDecimalArr2[i11] = new BigDecimal(new BigInteger(createByteArray), this.f13718e.readInt());
        }
        this.f13718e.setDataPosition(dataPosition + a10);
        return bigDecimalArr2;
    }

    public BigInteger createBigInteger(int i10, BigInteger bigInteger) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return bigInteger;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        byte[] createByteArray = this.f13718e.createByteArray();
        this.f13718e.setDataPosition(dataPosition + a10);
        return new BigInteger(createByteArray);
    }

    public BigInteger[] createBigIntegerArray(int i10, BigInteger[] bigIntegerArr) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return bigIntegerArr;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        int readInt = this.f13718e.readInt();
        BigInteger[] bigIntegerArr2 = new BigInteger[readInt];
        for (int i11 = 0; i11 < readInt; i11++) {
            bigIntegerArr2[i11] = new BigInteger(this.f13718e.createByteArray());
        }
        this.f13718e.setDataPosition(dataPosition + a10);
        return bigIntegerArr2;
    }

    public boolean[] createBooleanArray(int i10, boolean[] zArr) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return zArr;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        boolean[] createBooleanArray = this.f13718e.createBooleanArray();
        this.f13718e.setDataPosition(dataPosition + a10);
        return createBooleanArray;
    }

    public ArrayList<Boolean> createBooleanList(int i10, ArrayList<Boolean> arrayList) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return arrayList;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        ArrayList<Boolean> arrayList2 = new ArrayList<>();
        int readInt = this.f13718e.readInt();
        for (int i11 = 0; i11 < readInt; i11++) {
            arrayList2.add(Boolean.valueOf(this.f13718e.readInt() != 0));
        }
        this.f13718e.setDataPosition(dataPosition + a10);
        return arrayList2;
    }

    public byte[] createByteArray(int i10, byte[] bArr) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return bArr;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        byte[] createByteArray = this.f13718e.createByteArray();
        this.f13718e.setDataPosition(dataPosition + a10);
        return createByteArray;
    }

    public byte[][] createByteArrayArray(int i10, byte[][] bArr) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return bArr;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        int readInt = this.f13718e.readInt();
        byte[][] bArr2 = new byte[readInt];
        for (int i11 = 0; i11 < readInt; i11++) {
            bArr2[i11] = this.f13718e.createByteArray();
        }
        this.f13718e.setDataPosition(dataPosition + a10);
        return bArr2;
    }

    public SparseArray<byte[]> createByteArraySparseArray(int i10, SparseArray<byte[]> sparseArray) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return sparseArray;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        int readInt = this.f13718e.readInt();
        SparseArray<byte[]> sparseArray2 = new SparseArray<>(readInt);
        for (int i11 = 0; i11 < readInt; i11++) {
            sparseArray2.append(this.f13718e.readInt(), this.f13718e.createByteArray());
        }
        this.f13718e.setDataPosition(dataPosition + a10);
        return sparseArray2;
    }

    public char[] createCharArray(int i10, char[] cArr) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return cArr;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        char[] createCharArray = this.f13718e.createCharArray();
        this.f13718e.setDataPosition(dataPosition + a10);
        return createCharArray;
    }

    public double[] createDoubleArray(int i10, double[] dArr) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return dArr;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        double[] createDoubleArray = this.f13718e.createDoubleArray();
        this.f13718e.setDataPosition(dataPosition + a10);
        return createDoubleArray;
    }

    public ArrayList<Double> createDoubleList(int i10, ArrayList<Double> arrayList) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return arrayList;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        ArrayList<Double> arrayList2 = new ArrayList<>();
        int readInt = this.f13718e.readInt();
        for (int i11 = 0; i11 < readInt; i11++) {
            arrayList2.add(Double.valueOf(this.f13718e.readDouble()));
        }
        this.f13718e.setDataPosition(dataPosition + a10);
        return arrayList2;
    }

    public SparseArray<Double> createDoubleSparseArray(int i10, SparseArray<Double> sparseArray) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return sparseArray;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        SparseArray<Double> sparseArray2 = new SparseArray<>();
        int readInt = this.f13718e.readInt();
        for (int i11 = 0; i11 < readInt; i11++) {
            sparseArray2.append(this.f13718e.readInt(), Double.valueOf(this.f13718e.readDouble()));
        }
        this.f13718e.setDataPosition(dataPosition + a10);
        return sparseArray2;
    }

    public float[] createFloatArray(int i10, float[] fArr) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return fArr;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        float[] createFloatArray = this.f13718e.createFloatArray();
        this.f13718e.setDataPosition(dataPosition + a10);
        return createFloatArray;
    }

    public ArrayList<Float> createFloatList(int i10, ArrayList<Float> arrayList) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return arrayList;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        ArrayList<Float> arrayList2 = new ArrayList<>();
        int readInt = this.f13718e.readInt();
        for (int i11 = 0; i11 < readInt; i11++) {
            arrayList2.add(Float.valueOf(this.f13718e.readFloat()));
        }
        this.f13718e.setDataPosition(dataPosition + a10);
        return arrayList2;
    }

    public SparseArray<Float> createFloatSparseArray(int i10, SparseArray<Float> sparseArray) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return sparseArray;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        SparseArray<Float> sparseArray2 = new SparseArray<>();
        int readInt = this.f13718e.readInt();
        for (int i11 = 0; i11 < readInt; i11++) {
            sparseArray2.append(this.f13718e.readInt(), Float.valueOf(this.f13718e.readFloat()));
        }
        this.f13718e.setDataPosition(dataPosition + a10);
        return sparseArray2;
    }

    public IBinder[] createIBinderArray(int i10, IBinder[] iBinderArr) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return iBinderArr;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        IBinder[] createBinderArray = this.f13718e.createBinderArray();
        this.f13718e.setDataPosition(dataPosition + a10);
        return createBinderArray;
    }

    public ArrayList<IBinder> createIBinderList(int i10, ArrayList<IBinder> arrayList) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return arrayList;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        ArrayList<IBinder> createBinderArrayList = this.f13718e.createBinderArrayList();
        this.f13718e.setDataPosition(dataPosition + a10);
        return createBinderArrayList;
    }

    public SparseArray<IBinder> createIBinderSparseArray(int i10, SparseArray<IBinder> sparseArray) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return sparseArray;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        int readInt = this.f13718e.readInt();
        SparseArray<IBinder> sparseArray2 = new SparseArray<>(readInt);
        for (int i11 = 0; i11 < readInt; i11++) {
            sparseArray2.append(this.f13718e.readInt(), this.f13718e.readStrongBinder());
        }
        this.f13718e.setDataPosition(dataPosition + a10);
        return sparseArray2;
    }

    public int[] createIntArray(int i10, int[] iArr) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return iArr;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        int[] createIntArray = this.f13718e.createIntArray();
        this.f13718e.setDataPosition(dataPosition + a10);
        return createIntArray;
    }

    public ArrayList<Integer> createIntegerList(int i10, ArrayList<Integer> arrayList) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return arrayList;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        int readInt = this.f13718e.readInt();
        for (int i11 = 0; i11 < readInt; i11++) {
            arrayList2.add(Integer.valueOf(this.f13718e.readInt()));
        }
        this.f13718e.setDataPosition(dataPosition + a10);
        return arrayList2;
    }

    public long[] createLongArray(int i10, long[] jArr) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return jArr;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        long[] createLongArray = this.f13718e.createLongArray();
        this.f13718e.setDataPosition(dataPosition + a10);
        return createLongArray;
    }

    public ArrayList<Long> createLongList(int i10, ArrayList<Long> arrayList) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return arrayList;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        ArrayList<Long> arrayList2 = new ArrayList<>();
        int readInt = this.f13718e.readInt();
        for (int i11 = 0; i11 < readInt; i11++) {
            arrayList2.add(Long.valueOf(this.f13718e.readLong()));
        }
        this.f13718e.setDataPosition(dataPosition + a10);
        return arrayList2;
    }

    public Parcel createParcel(int i10, Parcel parcel) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return parcel;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(this.f13718e, dataPosition, a10);
        this.f13718e.setDataPosition(dataPosition + a10);
        return obtain;
    }

    public Parcel[] createParcelArray(int i10, Parcel[] parcelArr) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return parcelArr;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        int readInt = this.f13718e.readInt();
        Parcel[] parcelArr2 = new Parcel[readInt];
        for (int i11 = 0; i11 < readInt; i11++) {
            int readInt2 = this.f13718e.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = this.f13718e.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(this.f13718e, dataPosition2, readInt2);
                parcelArr2[i11] = obtain;
                this.f13718e.setDataPosition(dataPosition2 + readInt2);
            } else {
                parcelArr2[i11] = null;
            }
        }
        this.f13718e.setDataPosition(dataPosition + a10);
        return parcelArr2;
    }

    public ArrayList<Parcel> createParcelList(int i10, ArrayList<Parcel> arrayList) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return arrayList;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        int readInt = this.f13718e.readInt();
        ArrayList<Parcel> arrayList2 = new ArrayList<>();
        for (int i11 = 0; i11 < readInt; i11++) {
            int readInt2 = this.f13718e.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = this.f13718e.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(this.f13718e, dataPosition2, readInt2);
                arrayList2.add(obtain);
                this.f13718e.setDataPosition(dataPosition2 + readInt2);
            } else {
                arrayList2.add(null);
            }
        }
        this.f13718e.setDataPosition(dataPosition + a10);
        return arrayList2;
    }

    public SparseArray<Parcel> createParcelSparseArray(int i10, SparseArray<Parcel> sparseArray) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return sparseArray;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        int readInt = this.f13718e.readInt();
        SparseArray<Parcel> sparseArray2 = new SparseArray<>();
        for (int i11 = 0; i11 < readInt; i11++) {
            int readInt2 = this.f13718e.readInt();
            int readInt3 = this.f13718e.readInt();
            if (readInt3 != 0) {
                int dataPosition2 = this.f13718e.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(this.f13718e, dataPosition2, readInt3);
                sparseArray2.append(readInt2, obtain);
                this.f13718e.setDataPosition(dataPosition2 + readInt3);
            } else {
                sparseArray2.append(readInt2, null);
            }
        }
        this.f13718e.setDataPosition(dataPosition + a10);
        return sparseArray2;
    }

    public SparseBooleanArray createSparseBooleanArray(int i10, SparseBooleanArray sparseBooleanArray) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return sparseBooleanArray;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        SparseBooleanArray readSparseBooleanArray = this.f13718e.readSparseBooleanArray();
        this.f13718e.setDataPosition(dataPosition + a10);
        return readSparseBooleanArray;
    }

    public SparseIntArray createSparseIntArray(int i10, SparseIntArray sparseIntArray) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return sparseIntArray;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        int readInt = this.f13718e.readInt();
        for (int i11 = 0; i11 < readInt; i11++) {
            sparseIntArray2.append(this.f13718e.readInt(), this.f13718e.readInt());
        }
        this.f13718e.setDataPosition(dataPosition + a10);
        return sparseIntArray2;
    }

    public SparseLongArray createSparseLongArray(int i10, SparseLongArray sparseLongArray) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return sparseLongArray;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        SparseLongArray sparseLongArray2 = new SparseLongArray();
        int readInt = this.f13718e.readInt();
        for (int i11 = 0; i11 < readInt; i11++) {
            sparseLongArray2.append(this.f13718e.readInt(), this.f13718e.readLong());
        }
        this.f13718e.setDataPosition(dataPosition + a10);
        return sparseLongArray2;
    }

    public String createString(int i10, String str) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return str;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        String readString = this.f13718e.readString();
        this.f13718e.setDataPosition(dataPosition + a10);
        return readString;
    }

    public String[] createStringArray(int i10, String[] strArr) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return strArr;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        String[] createStringArray = this.f13718e.createStringArray();
        this.f13718e.setDataPosition(dataPosition + a10);
        return createStringArray;
    }

    public ArrayList<String> createStringList(int i10, ArrayList<String> arrayList) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return arrayList;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        ArrayList<String> createStringArrayList = this.f13718e.createStringArrayList();
        this.f13718e.setDataPosition(dataPosition + a10);
        return createStringArrayList;
    }

    public SparseArray<String> createStringSparseArray(int i10, SparseArray<String> sparseArray) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return sparseArray;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        int readInt = this.f13718e.readInt();
        for (int i11 = 0; i11 < readInt; i11++) {
            sparseArray2.append(this.f13718e.readInt(), this.f13718e.readString());
        }
        this.f13718e.setDataPosition(dataPosition + a10);
        return sparseArray2;
    }

    public <T> T[] createTypedArray(int i10, Parcelable.Creator<T> creator, T[] tArr) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return tArr;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        T[] tArr2 = (T[]) this.f13718e.createTypedArray(creator);
        this.f13718e.setDataPosition(dataPosition + a10);
        return tArr2;
    }

    public <T> ArrayList<T> createTypedList(int i10, Parcelable.Creator<T> creator, ArrayList<T> arrayList) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return arrayList;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        ArrayList<T> createTypedArrayList = this.f13718e.createTypedArrayList(creator);
        this.f13718e.setDataPosition(dataPosition + a10);
        return createTypedArrayList;
    }

    public <T> SparseArray<T> createTypedSparseArray(int i10, Parcelable.Creator<T> creator, SparseArray<T> sparseArray) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return sparseArray;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        int readInt = this.f13718e.readInt();
        SparseArray<T> sparseArray2 = new SparseArray<>();
        for (int i11 = 0; i11 < readInt; i11++) {
            sparseArray2.append(this.f13718e.readInt(), this.f13718e.readInt() != 0 ? creator.createFromParcel(this.f13718e) : null);
        }
        this.f13718e.setDataPosition(dataPosition + a10);
        return sparseArray2;
    }

    public boolean readBoolean(int i10, boolean z10) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return z10;
        }
        b(i10, 4);
        return this.f13718e.readInt() != 0;
    }

    public Boolean readBooleanObject(int i10, Boolean bool) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return bool;
        }
        if (a(i10) == 0) {
            return null;
        }
        a(i10, 4);
        int readInt = this.f13718e.readInt();
        if (readInt == 0) {
            return Boolean.FALSE;
        }
        if (readInt != 1) {
            return null;
        }
        return Boolean.TRUE;
    }

    public Bundle readBundle(int i10, Bundle bundle) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return bundle;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        Bundle readBundle = this.f13718e.readBundle();
        this.f13718e.setDataPosition(dataPosition + a10);
        return readBundle;
    }

    public byte readByte(int i10, byte b10) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return b10;
        }
        b(i10, 4);
        return (byte) this.f13718e.readInt();
    }

    public char readChar(int i10, char c10) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return c10;
        }
        b(i10, 4);
        return (char) this.f13718e.readInt();
    }

    public double readDouble(int i10, double d10) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return d10;
        }
        b(i10, 8);
        return this.f13718e.readDouble();
    }

    public Double readDoubleObject(int i10, Double d10) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return d10;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        a(a10, 8);
        return Double.valueOf(this.f13718e.readDouble());
    }

    public float readFloat(int i10, float f10) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return f10;
        }
        b(i10, 4);
        return this.f13718e.readFloat();
    }

    public Float readFloatObject(int i10, Float f10) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return f10;
        }
        if (a(i10) == 0) {
            return null;
        }
        a(i10, 4);
        return Float.valueOf(this.f13718e.readFloat());
    }

    public IBinder readIBinder(int i10, IBinder iBinder) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return iBinder;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        IBinder readStrongBinder = this.f13718e.readStrongBinder();
        this.f13718e.setDataPosition(dataPosition + a10);
        return readStrongBinder;
    }

    public int readInt(int i10, int i11) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return i11;
        }
        b(i10, 4);
        return this.f13718e.readInt();
    }

    public Integer readIntegerObject(int i10, Integer num) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return num;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        a(a10, 4);
        return Integer.valueOf(this.f13718e.readInt());
    }

    public void readList(int i10, List list, ClassLoader classLoader) {
        if (this.f13717a.containsKey(Integer.valueOf(i10))) {
            int a10 = a(i10);
            int dataPosition = this.f13718e.dataPosition();
            if (a10 != 0) {
                this.f13718e.readList(list, classLoader);
                this.f13718e.setDataPosition(dataPosition + a10);
            }
        }
    }

    public long readLong(int i10, long j10) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return j10;
        }
        b(i10, 8);
        return this.f13718e.readLong();
    }

    public Long readLongObject(int i10, Long l10) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return l10;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        a(a10, 8);
        return Long.valueOf(this.f13718e.readLong());
    }

    public <T extends Parcelable> T readParcelable(int i10, Parcelable.Creator<T> creator, T t10) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return t10;
        }
        int a10 = a(i10);
        if (a10 == 0) {
            return null;
        }
        int dataPosition = this.f13718e.dataPosition();
        T createFromParcel = creator.createFromParcel(this.f13718e);
        this.f13718e.setDataPosition(dataPosition + a10);
        return createFromParcel;
    }

    public short readShort(int i10, short s10) {
        if (!this.f13717a.containsKey(Integer.valueOf(i10))) {
            return s10;
        }
        b(i10, 4);
        return (short) this.f13718e.readInt();
    }
}
