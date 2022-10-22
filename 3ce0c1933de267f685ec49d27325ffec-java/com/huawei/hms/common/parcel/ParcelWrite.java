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
import java.util.List;
/* loaded from: classes.dex */
public class ParcelWrite {

    /* renamed from: a  reason: collision with root package name */
    private static final int f13720a = 65262;

    /* renamed from: b  reason: collision with root package name */
    private Parcel f13721b;

    public ParcelWrite(Parcel parcel) {
        this.f13721b = parcel;
    }

    private int a(int i10) {
        this.f13721b.writeInt(i10 | (-65536));
        this.f13721b.writeInt(0);
        return this.f13721b.dataPosition();
    }

    private void a(int i10, int i11) {
        if (i11 >= 65535) {
            this.f13721b.writeInt(i10 | (-65536));
            this.f13721b.writeInt(i11);
            return;
        }
        this.f13721b.writeInt(i10 | (i11 << 16));
    }

    private <T extends Parcelable> void a(T t10, int i10) {
        int dataPosition = this.f13721b.dataPosition();
        this.f13721b.writeInt(1);
        int dataPosition2 = this.f13721b.dataPosition();
        t10.writeToParcel(this.f13721b, i10);
        int dataPosition3 = this.f13721b.dataPosition();
        this.f13721b.setDataPosition(dataPosition);
        this.f13721b.writeInt(dataPosition3 - dataPosition2);
        this.f13721b.setDataPosition(dataPosition3);
    }

    private void b(int i10) {
        int dataPosition = this.f13721b.dataPosition();
        this.f13721b.setDataPosition(i10 - 4);
        this.f13721b.writeInt(dataPosition - i10);
        this.f13721b.setDataPosition(dataPosition);
    }

    public int beginObjectHeader() {
        return a(f13720a);
    }

    public void finishObjectHeader(int i10) {
        b(i10);
    }

    public void writeBigDecimal(int i10, BigDecimal bigDecimal, boolean z10) {
        if (bigDecimal != null) {
            int a10 = a(i10);
            this.f13721b.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            this.f13721b.writeInt(bigDecimal.scale());
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeBigDecimalArray(int i10, BigDecimal[] bigDecimalArr, boolean z10) {
        if (bigDecimalArr != null) {
            int a10 = a(i10);
            int length = bigDecimalArr.length;
            this.f13721b.writeInt(length);
            for (int i11 = 0; i11 < length; i11++) {
                this.f13721b.writeByteArray(bigDecimalArr[i11].unscaledValue().toByteArray());
                this.f13721b.writeInt(bigDecimalArr[i11].scale());
            }
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeBigInteger(int i10, BigInteger bigInteger, boolean z10) {
        if (bigInteger != null) {
            int a10 = a(i10);
            this.f13721b.writeByteArray(bigInteger.toByteArray());
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeBigIntegerArray(int i10, BigInteger[] bigIntegerArr, boolean z10) {
        if (bigIntegerArr != null) {
            int a10 = a(i10);
            this.f13721b.writeInt(bigIntegerArr.length);
            for (BigInteger bigInteger : bigIntegerArr) {
                this.f13721b.writeByteArray(bigInteger.toByteArray());
            }
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeBoolean(int i10, boolean z10) {
        a(i10, 4);
        this.f13721b.writeInt(z10 ? 1 : 0);
    }

    public void writeBooleanArray(int i10, boolean[] zArr, boolean z10) {
        if (zArr != null) {
            int a10 = a(i10);
            this.f13721b.writeBooleanArray(zArr);
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeBooleanList(int i10, List<Boolean> list, boolean z10) {
        if (list != null) {
            int a10 = a(i10);
            int size = list.size();
            this.f13721b.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                this.f13721b.writeInt(list.get(i11).booleanValue() ? 1 : 0);
            }
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeBooleanObject(int i10, Boolean bool) {
        writeBooleanObject(i10, bool, false);
    }

    public void writeBooleanObject(int i10, Boolean bool, boolean z10) {
        if (bool != null) {
            a(i10, 4);
            this.f13721b.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeBundle(int i10, Bundle bundle, boolean z10) {
        if (bundle != null) {
            int a10 = a(i10);
            this.f13721b.writeBundle(bundle);
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeByte(int i10, byte b10) {
        a(i10, 4);
        this.f13721b.writeInt(b10);
    }

    public void writeByteArray(int i10, byte[] bArr, boolean z10) {
        if (bArr != null) {
            int a10 = a(i10);
            this.f13721b.writeByteArray(bArr);
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeByteArrayArray(int i10, byte[][] bArr, boolean z10) {
        if (bArr != null) {
            int a10 = a(i10);
            this.f13721b.writeInt(bArr.length);
            for (byte[] bArr2 : bArr) {
                this.f13721b.writeByteArray(bArr2);
            }
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeByteArraySparseArray(int i10, SparseArray<byte[]> sparseArray, boolean z10) {
        if (sparseArray != null) {
            int a10 = a(i10);
            int size = sparseArray.size();
            this.f13721b.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                this.f13721b.writeInt(sparseArray.keyAt(i11));
                this.f13721b.writeByteArray(sparseArray.valueAt(i11));
            }
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeChar(int i10, char c10) {
        a(i10, 4);
        this.f13721b.writeInt(c10);
    }

    public void writeCharArray(int i10, char[] cArr, boolean z10) {
        if (cArr != null) {
            int a10 = a(i10);
            this.f13721b.writeCharArray(cArr);
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeDouble(int i10, double d10) {
        a(i10, 8);
        this.f13721b.writeDouble(d10);
    }

    public void writeDoubleArray(int i10, double[] dArr, boolean z10) {
        if (dArr != null) {
            int a10 = a(i10);
            this.f13721b.writeDoubleArray(dArr);
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeDoubleList(int i10, List<Double> list, boolean z10) {
        if (list != null) {
            int a10 = a(i10);
            int size = list.size();
            this.f13721b.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                this.f13721b.writeDouble(list.get(i11).doubleValue());
            }
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeDoubleObject(int i10, Double d10, boolean z10) {
        if (d10 != null) {
            a(i10, 8);
            this.f13721b.writeDouble(d10.doubleValue());
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeDoubleSparseArray(int i10, SparseArray<Double> sparseArray, boolean z10) {
        if (sparseArray != null) {
            int a10 = a(i10);
            int size = sparseArray.size();
            this.f13721b.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                this.f13721b.writeInt(sparseArray.keyAt(i11));
                this.f13721b.writeDouble(sparseArray.valueAt(i11).doubleValue());
            }
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeFloat(int i10, float f10) {
        a(i10, 4);
        this.f13721b.writeFloat(f10);
    }

    public void writeFloatArray(int i10, float[] fArr, boolean z10) {
        if (fArr != null) {
            int a10 = a(i10);
            this.f13721b.writeFloatArray(fArr);
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeFloatList(int i10, List<Float> list, boolean z10) {
        if (list != null) {
            int a10 = a(i10);
            int size = list.size();
            this.f13721b.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                this.f13721b.writeFloat(list.get(i11).floatValue());
            }
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeFloatObject(int i10, Float f10, boolean z10) {
        if (f10 != null) {
            a(i10, 4);
            this.f13721b.writeFloat(f10.floatValue());
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeFloatSparseArray(int i10, SparseArray<Float> sparseArray, boolean z10) {
        if (sparseArray != null) {
            int a10 = a(i10);
            int size = sparseArray.size();
            this.f13721b.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                this.f13721b.writeInt(sparseArray.keyAt(i11));
                this.f13721b.writeFloat(sparseArray.valueAt(i11).floatValue());
            }
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeIBinder(int i10, IBinder iBinder, boolean z10) {
        if (iBinder != null) {
            int a10 = a(i10);
            this.f13721b.writeStrongBinder(iBinder);
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeIBinderArray(int i10, IBinder[] iBinderArr, boolean z10) {
        if (iBinderArr != null) {
            int a10 = a(i10);
            this.f13721b.writeBinderArray(iBinderArr);
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeIBinderList(int i10, List<IBinder> list, boolean z10) {
        if (list != null) {
            int a10 = a(i10);
            this.f13721b.writeBinderList(list);
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeIBinderSparseArray(int i10, SparseArray<IBinder> sparseArray, boolean z10) {
        if (sparseArray != null) {
            int a10 = a(i10);
            int size = sparseArray.size();
            this.f13721b.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                this.f13721b.writeInt(sparseArray.keyAt(i11));
                this.f13721b.writeStrongBinder(sparseArray.valueAt(i11));
            }
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeInt(int i10, int i11) {
        a(i10, 4);
        this.f13721b.writeInt(i11);
    }

    public void writeIntArray(int i10, int[] iArr, boolean z10) {
        if (iArr != null) {
            int a10 = a(i10);
            this.f13721b.writeIntArray(iArr);
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeIntegerList(int i10, List<Integer> list, boolean z10) {
        if (list != null) {
            int a10 = a(i10);
            int size = list.size();
            this.f13721b.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                this.f13721b.writeInt(list.get(i11).intValue());
            }
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeIntegerObject(int i10, Integer num, boolean z10) {
        if (num != null) {
            a(i10, 4);
            this.f13721b.writeInt(num.intValue());
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeList(int i10, List list, boolean z10) {
        if (list != null) {
            int a10 = a(i10);
            this.f13721b.writeList(list);
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeLong(int i10, long j10) {
        a(i10, 8);
        this.f13721b.writeLong(j10);
    }

    public void writeLongArray(int i10, long[] jArr, boolean z10) {
        if (jArr != null) {
            int a10 = a(i10);
            this.f13721b.writeLongArray(jArr);
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeLongList(int i10, List<Long> list, boolean z10) {
        if (list != null) {
            int a10 = a(i10);
            int size = list.size();
            this.f13721b.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                this.f13721b.writeLong(list.get(i11).longValue());
            }
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeLongObject(int i10, Long l10, boolean z10) {
        if (l10 != null) {
            a(i10, 8);
            this.f13721b.writeLong(l10.longValue());
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeParcel(int i10, Parcel parcel, boolean z10) {
        if (parcel != null) {
            int a10 = a(i10);
            this.f13721b.appendFrom(parcel, 0, parcel.dataSize());
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeParcelArray(int i10, Parcel[] parcelArr, boolean z10) {
        if (parcelArr != null) {
            int a10 = a(i10);
            this.f13721b.writeInt(parcelArr.length);
            for (Parcel parcel : parcelArr) {
                if (parcel != null) {
                    this.f13721b.writeInt(parcel.dataSize());
                    this.f13721b.appendFrom(parcel, 0, parcel.dataSize());
                } else {
                    this.f13721b.writeInt(0);
                }
            }
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeParcelList(int i10, List<Parcel> list, boolean z10) {
        if (list != null) {
            int a10 = a(i10);
            int size = list.size();
            this.f13721b.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                Parcel parcel = list.get(i11);
                if (parcel != null) {
                    this.f13721b.writeInt(parcel.dataSize());
                    this.f13721b.appendFrom(parcel, 0, parcel.dataSize());
                } else {
                    this.f13721b.writeInt(0);
                }
            }
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeParcelSparseArray(int i10, SparseArray<Parcel> sparseArray, boolean z10) {
        if (sparseArray != null) {
            int a10 = a(i10);
            int size = sparseArray.size();
            this.f13721b.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                this.f13721b.writeInt(sparseArray.keyAt(i11));
                Parcel valueAt = sparseArray.valueAt(i11);
                if (valueAt != null) {
                    this.f13721b.writeInt(valueAt.dataSize());
                    this.f13721b.appendFrom(valueAt, 0, valueAt.dataSize());
                } else {
                    this.f13721b.writeInt(0);
                }
            }
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeParcelable(int i10, Parcelable parcelable, int i11, boolean z10) {
        if (parcelable != null) {
            int a10 = a(i10);
            parcelable.writeToParcel(this.f13721b, i11);
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeShort(int i10, short s10) {
        a(i10, 4);
        this.f13721b.writeInt(s10);
    }

    public void writeSparseBooleanArray(int i10, SparseBooleanArray sparseBooleanArray, boolean z10) {
        if (sparseBooleanArray != null) {
            int a10 = a(i10);
            this.f13721b.writeSparseBooleanArray(sparseBooleanArray);
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeSparseIntArray(int i10, SparseIntArray sparseIntArray, boolean z10) {
        if (sparseIntArray != null) {
            int a10 = a(i10);
            int size = sparseIntArray.size();
            this.f13721b.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                this.f13721b.writeInt(sparseIntArray.keyAt(i11));
                this.f13721b.writeInt(sparseIntArray.valueAt(i11));
            }
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeSparseLongArray(int i10, SparseLongArray sparseLongArray, boolean z10) {
        if (sparseLongArray != null) {
            int a10 = a(i10);
            int size = sparseLongArray.size();
            this.f13721b.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                this.f13721b.writeInt(sparseLongArray.keyAt(i11));
                this.f13721b.writeLong(sparseLongArray.valueAt(i11));
            }
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeString(int i10, String str, boolean z10) {
        if (str != null) {
            int a10 = a(i10);
            this.f13721b.writeString(str);
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeStringArray(int i10, String[] strArr, boolean z10) {
        if (strArr != null) {
            int a10 = a(i10);
            this.f13721b.writeStringArray(strArr);
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeStringList(int i10, List<String> list, boolean z10) {
        if (list != null) {
            int a10 = a(i10);
            this.f13721b.writeStringList(list);
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeStringSparseArray(int i10, SparseArray<String> sparseArray, boolean z10) {
        if (sparseArray != null) {
            int a10 = a(i10);
            int size = sparseArray.size();
            this.f13721b.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                this.f13721b.writeInt(sparseArray.keyAt(i11));
                this.f13721b.writeString(sparseArray.valueAt(i11));
            }
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public <T extends Parcelable> void writeTypedArray(int i10, T[] tArr, int i11, boolean z10) {
        if (tArr != null) {
            int a10 = a(i10);
            this.f13721b.writeInt(tArr.length);
            for (T t10 : tArr) {
                if (t10 == null) {
                    this.f13721b.writeInt(0);
                } else {
                    a((ParcelWrite) t10, i11);
                }
            }
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public <T extends Parcelable> void writeTypedList(int i10, List<T> list, boolean z10) {
        if (list != null) {
            int a10 = a(i10);
            int size = list.size();
            this.f13721b.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                T t10 = list.get(i11);
                if (t10 == null) {
                    this.f13721b.writeInt(0);
                } else {
                    a((ParcelWrite) t10, 0);
                }
            }
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public <T extends Parcelable> void writeTypedSparseArray(int i10, SparseArray<T> sparseArray, boolean z10) {
        if (sparseArray != null) {
            int a10 = a(i10);
            int size = sparseArray.size();
            this.f13721b.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                this.f13721b.writeInt(sparseArray.keyAt(i11));
                T valueAt = sparseArray.valueAt(i11);
                if (valueAt == null) {
                    this.f13721b.writeInt(0);
                } else {
                    a((ParcelWrite) valueAt, 0);
                }
            }
            b(a10);
        } else if (z10) {
            a(i10, 0);
        }
    }
}
