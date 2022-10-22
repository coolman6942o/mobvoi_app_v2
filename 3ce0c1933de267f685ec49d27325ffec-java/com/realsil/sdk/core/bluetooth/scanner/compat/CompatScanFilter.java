package com.realsil.sdk.core.bluetooth.scanner.compat;

import android.bluetooth.BluetoothAdapter;
import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;
/* loaded from: classes2.dex */
public final class CompatScanFilter implements Parcelable {
    public static final Parcelable.Creator<CompatScanFilter> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final String f22137a;

    /* renamed from: b  reason: collision with root package name */
    public final String f22138b;

    /* renamed from: c  reason: collision with root package name */
    public final int f22139c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f22140d;

    /* renamed from: e  reason: collision with root package name */
    public final ParcelUuid f22141e;

    /* renamed from: f  reason: collision with root package name */
    public final ParcelUuid f22142f;

    /* renamed from: g  reason: collision with root package name */
    public final ParcelUuid f22143g;

    /* renamed from: h  reason: collision with root package name */
    public final ParcelUuid f22144h;

    /* renamed from: i  reason: collision with root package name */
    public final ParcelUuid f22145i;

    /* renamed from: j  reason: collision with root package name */
    public final byte[] f22146j;

    /* renamed from: k  reason: collision with root package name */
    public final byte[] f22147k;

    /* renamed from: l  reason: collision with root package name */
    public final int f22148l;

    /* renamed from: m  reason: collision with root package name */
    public final byte[] f22149m;

    /* renamed from: n  reason: collision with root package name */
    public final byte[] f22150n;

    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<CompatScanFilter> {
        /* renamed from: a */
        public CompatScanFilter createFromParcel(Parcel parcel) {
            b bVar = new b();
            if (parcel.readInt() == 1) {
                bVar.e(parcel.readString());
            }
            String str = null;
            if (parcel.readInt() == 1) {
                str = parcel.readString();
            }
            if (parcel.readInt() == 1) {
                ParcelUuid parcelUuid = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
                bVar.l(parcelUuid);
                if (parcel.readInt() == 1) {
                    bVar.m(parcelUuid, (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader()));
                }
            }
            if (parcel.readInt() == 1) {
                ParcelUuid parcelUuid2 = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
                bVar.j(parcelUuid2);
                if (parcel.readInt() == 1) {
                    bVar.k(parcelUuid2, (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader()));
                }
            }
            if (parcel.readInt() == 1) {
                ParcelUuid parcelUuid3 = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
                if (parcel.readInt() == 1) {
                    byte[] bArr = new byte[parcel.readInt()];
                    parcel.readByteArray(bArr);
                    if (parcel.readInt() == 0) {
                        bVar.h(parcelUuid3, bArr);
                    } else {
                        byte[] bArr2 = new byte[parcel.readInt()];
                        parcel.readByteArray(bArr2);
                        bVar.i(parcelUuid3, bArr, bArr2);
                    }
                }
            }
            int readInt = parcel.readInt();
            if (parcel.readInt() == 1) {
                byte[] bArr3 = new byte[parcel.readInt()];
                parcel.readByteArray(bArr3);
                if (parcel.readInt() == 0) {
                    bVar.f(readInt, bArr3);
                } else {
                    byte[] bArr4 = new byte[parcel.readInt()];
                    parcel.readByteArray(bArr4);
                    bVar.g(readInt, bArr3, bArr4);
                }
            }
            if (str != null) {
                int readInt2 = parcel.readInt();
                if (parcel.readInt() == 1) {
                    byte[] bArr5 = new byte[16];
                    parcel.readByteArray(bArr5);
                    bVar.a(str, readInt2, bArr5);
                } else {
                    bVar.d(str, readInt2);
                }
            }
            return bVar.b();
        }

        /* renamed from: b */
        public CompatScanFilter[] newArray(int i10) {
            return new CompatScanFilter[i10];
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public String f22151a;

        /* renamed from: b  reason: collision with root package name */
        public String f22152b;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f22154d;

        /* renamed from: e  reason: collision with root package name */
        public ParcelUuid f22155e;

        /* renamed from: f  reason: collision with root package name */
        public ParcelUuid f22156f;

        /* renamed from: g  reason: collision with root package name */
        public ParcelUuid f22157g;

        /* renamed from: h  reason: collision with root package name */
        public ParcelUuid f22158h;

        /* renamed from: i  reason: collision with root package name */
        public ParcelUuid f22159i;

        /* renamed from: j  reason: collision with root package name */
        public byte[] f22160j;

        /* renamed from: k  reason: collision with root package name */
        public byte[] f22161k;

        /* renamed from: m  reason: collision with root package name */
        public byte[] f22163m;

        /* renamed from: n  reason: collision with root package name */
        public byte[] f22164n;

        /* renamed from: c  reason: collision with root package name */
        public int f22153c = 0;

        /* renamed from: l  reason: collision with root package name */
        public int f22162l = -1;

        public final b a(String str, int i10, byte[] bArr) {
            if (BluetoothAdapter.checkBluetoothAddress(str)) {
                if (i10 >= 0) {
                    boolean z10 = true;
                    if (i10 <= 1) {
                        if (i10 == 1 && bArr != null) {
                            Objects.requireNonNull(str);
                            if (!BluetoothAdapter.checkBluetoothAddress(str) || (Integer.parseInt(str.split(":")[0], 16) & 192) != 192) {
                                z10 = false;
                            }
                            if (!z10) {
                                throw new IllegalArgumentException("Invalid combination: IRK requires either a PUBLIC or RANDOM (STATIC) Address");
                            }
                        }
                        this.f22152b = str;
                        this.f22153c = i10;
                        this.f22154d = bArr;
                        return this;
                    }
                }
                throw new IllegalArgumentException("'addressType' is invalid!");
            }
            throw new IllegalArgumentException("invalid device address " + str);
        }

        public CompatScanFilter b() {
            return new CompatScanFilter(this.f22151a, this.f22152b, this.f22155e, this.f22156f, this.f22157g, this.f22158h, this.f22159i, this.f22160j, this.f22161k, this.f22162l, this.f22163m, this.f22164n, this.f22153c, this.f22154d);
        }

        public b c(String str) {
            if (str != null) {
                return d(str, 0);
            }
            this.f22152b = str;
            return this;
        }

        public b d(String str, int i10) {
            return a(str, i10, null);
        }

        public b e(String str) {
            this.f22151a = str;
            return this;
        }

        public b f(int i10, byte[] bArr) {
            if (bArr == null || i10 >= 0) {
                this.f22162l = i10;
                this.f22163m = bArr;
                this.f22164n = null;
                return this;
            }
            throw new IllegalArgumentException("invalid manufacture id");
        }

        public b g(int i10, byte[] bArr, byte[] bArr2) {
            if (bArr == null || i10 >= 0) {
                byte[] bArr3 = this.f22164n;
                if (bArr3 != null) {
                    byte[] bArr4 = this.f22163m;
                    if (bArr4 == null) {
                        throw new IllegalArgumentException("manufacturerData is null while manufacturerDataMask is not null");
                    } else if (bArr4.length != bArr3.length) {
                        throw new IllegalArgumentException("size mismatch for manufacturerData and manufacturerDataMask");
                    }
                }
                this.f22162l = i10;
                this.f22163m = bArr;
                this.f22164n = bArr2;
                return this;
            }
            throw new IllegalArgumentException("invalid manufacture id");
        }

        public b h(ParcelUuid parcelUuid, byte[] bArr) {
            if (parcelUuid != null) {
                this.f22159i = parcelUuid;
                this.f22160j = bArr;
                this.f22161k = null;
                return this;
            }
            throw new IllegalArgumentException("serviceDataUuid is null");
        }

        public b i(ParcelUuid parcelUuid, byte[] bArr, byte[] bArr2) {
            if (parcelUuid != null) {
                byte[] bArr3 = this.f22161k;
                if (bArr3 != null) {
                    byte[] bArr4 = this.f22160j;
                    if (bArr4 == null) {
                        throw new IllegalArgumentException("serviceData is null while serviceDataMask is not null");
                    } else if (bArr4.length != bArr3.length) {
                        throw new IllegalArgumentException("size mismatch for service data and service data mask");
                    }
                }
                this.f22159i = parcelUuid;
                this.f22160j = bArr;
                this.f22161k = bArr2;
                return this;
            }
            throw new IllegalArgumentException("serviceDataUuid is null");
        }

        public b j(ParcelUuid parcelUuid) {
            this.f22157g = parcelUuid;
            if (parcelUuid == null) {
                this.f22158h = null;
            }
            return this;
        }

        public b k(ParcelUuid parcelUuid, ParcelUuid parcelUuid2) {
            if (parcelUuid2 == null || parcelUuid != null) {
                this.f22157g = parcelUuid;
                this.f22158h = parcelUuid2;
                return this;
            }
            throw new IllegalArgumentException("SolicitationUuid is null while SolicitationUuidMask is not null!");
        }

        public b l(ParcelUuid parcelUuid) {
            this.f22155e = parcelUuid;
            this.f22156f = null;
            return this;
        }

        public b m(ParcelUuid parcelUuid, ParcelUuid parcelUuid2) {
            if (this.f22156f == null || this.f22155e != null) {
                this.f22155e = parcelUuid;
                this.f22156f = parcelUuid2;
                return this;
            }
            throw new IllegalArgumentException("uuid is null while uuidMask is not null!");
        }
    }

    static {
        new b().b();
    }

    public CompatScanFilter(String str, String str2, ParcelUuid parcelUuid, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, ParcelUuid parcelUuid4, ParcelUuid parcelUuid5, byte[] bArr, byte[] bArr2, int i10, byte[] bArr3, byte[] bArr4, int i11, byte[] bArr5) {
        this.f22137a = str;
        this.f22141e = parcelUuid;
        this.f22142f = parcelUuid2;
        this.f22143g = parcelUuid3;
        this.f22144h = parcelUuid4;
        this.f22138b = str2;
        this.f22145i = parcelUuid5;
        this.f22146j = bArr;
        this.f22147k = bArr2;
        this.f22148l = i10;
        this.f22149m = bArr3;
        this.f22150n = bArr4;
        this.f22139c = i11;
        this.f22140d = bArr5;
    }

    public String a() {
        return this.f22138b;
    }

    public String b() {
        return this.f22137a;
    }

    public byte[] c() {
        return this.f22149m;
    }

    public byte[] d() {
        return this.f22150n;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f22148l;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CompatScanFilter.class != obj.getClass()) {
            return false;
        }
        CompatScanFilter compatScanFilter = (CompatScanFilter) obj;
        return Objects.equals(this.f22137a, compatScanFilter.f22137a) && Objects.equals(this.f22138b, compatScanFilter.f22138b) && this.f22148l == compatScanFilter.f22148l && Objects.deepEquals(this.f22149m, compatScanFilter.f22149m) && Objects.deepEquals(this.f22150n, compatScanFilter.f22150n) && Objects.equals(this.f22145i, compatScanFilter.f22145i) && Objects.deepEquals(this.f22146j, compatScanFilter.f22146j) && Objects.deepEquals(this.f22147k, compatScanFilter.f22147k) && Objects.equals(this.f22141e, compatScanFilter.f22141e) && Objects.equals(this.f22142f, compatScanFilter.f22142f) && Objects.equals(this.f22143g, compatScanFilter.f22143g) && Objects.equals(this.f22144h, compatScanFilter.f22144h);
    }

    public byte[] f() {
        return this.f22146j;
    }

    public ParcelUuid g() {
        return this.f22145i;
    }

    public ParcelUuid h() {
        return this.f22143g;
    }

    public int hashCode() {
        return Objects.hash(this.f22137a, this.f22138b, Integer.valueOf(this.f22148l), Integer.valueOf(Arrays.hashCode(this.f22149m)), Integer.valueOf(Arrays.hashCode(this.f22150n)), this.f22145i, Integer.valueOf(Arrays.hashCode(this.f22146j)), Integer.valueOf(Arrays.hashCode(this.f22147k)), this.f22141e, this.f22142f, this.f22143g, this.f22144h);
    }

    public ParcelUuid i() {
        return this.f22141e;
    }

    public String toString() {
        return "BluetoothLeScanFilter [mDeviceName=" + this.f22137a + ", mDeviceAddress=" + fl.a.c(this.f22138b, true) + ", mUuid=" + this.f22141e + ", mUuidMask=" + this.f22142f + ", mServiceSolicitationUuid=" + this.f22143g + ", mServiceSolicitationUuidMask=" + this.f22144h + ", mServiceDataUuid=" + Objects.toString(this.f22145i) + ", mServiceData=" + Arrays.toString(this.f22146j) + ", mServiceDataMask=" + Arrays.toString(this.f22147k) + ", mManufacturerId=" + this.f22148l + ", mManufacturerData=" + Arrays.toString(this.f22149m) + ", mManufacturerDataMask=" + Arrays.toString(this.f22150n) + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int i11 = 0;
        parcel.writeInt(this.f22137a == null ? 0 : 1);
        String str = this.f22137a;
        if (str != null) {
            parcel.writeString(str);
        }
        parcel.writeInt(this.f22138b == null ? 0 : 1);
        String str2 = this.f22138b;
        if (str2 != null) {
            parcel.writeString(str2);
        }
        parcel.writeInt(this.f22141e == null ? 0 : 1);
        ParcelUuid parcelUuid = this.f22141e;
        if (parcelUuid != null) {
            parcel.writeParcelable(parcelUuid, i10);
            parcel.writeInt(this.f22142f == null ? 0 : 1);
            ParcelUuid parcelUuid2 = this.f22142f;
            if (parcelUuid2 != null) {
                parcel.writeParcelable(parcelUuid2, i10);
            }
        }
        parcel.writeInt(this.f22143g == null ? 0 : 1);
        ParcelUuid parcelUuid3 = this.f22143g;
        if (parcelUuid3 != null) {
            parcel.writeParcelable(parcelUuid3, i10);
            parcel.writeInt(this.f22144h == null ? 0 : 1);
            ParcelUuid parcelUuid4 = this.f22144h;
            if (parcelUuid4 != null) {
                parcel.writeParcelable(parcelUuid4, i10);
            }
        }
        parcel.writeInt(this.f22145i == null ? 0 : 1);
        ParcelUuid parcelUuid5 = this.f22145i;
        if (parcelUuid5 != null) {
            parcel.writeParcelable(parcelUuid5, i10);
            parcel.writeInt(this.f22146j == null ? 0 : 1);
            byte[] bArr = this.f22146j;
            if (bArr != null) {
                parcel.writeInt(bArr.length);
                parcel.writeByteArray(this.f22146j);
                parcel.writeInt(this.f22147k == null ? 0 : 1);
                byte[] bArr2 = this.f22147k;
                if (bArr2 != null) {
                    parcel.writeInt(bArr2.length);
                    parcel.writeByteArray(this.f22147k);
                }
            }
        }
        parcel.writeInt(this.f22148l);
        parcel.writeInt(this.f22149m == null ? 0 : 1);
        byte[] bArr3 = this.f22149m;
        if (bArr3 != null) {
            parcel.writeInt(bArr3.length);
            parcel.writeByteArray(this.f22149m);
            parcel.writeInt(this.f22150n == null ? 0 : 1);
            byte[] bArr4 = this.f22150n;
            if (bArr4 != null) {
                parcel.writeInt(bArr4.length);
                parcel.writeByteArray(this.f22150n);
            }
        }
        if (this.f22138b != null) {
            parcel.writeInt(this.f22139c);
            if (this.f22140d != null) {
                i11 = 1;
            }
            parcel.writeInt(i11);
            byte[] bArr5 = this.f22140d;
            if (bArr5 != null) {
                parcel.writeByteArray(bArr5);
            }
        }
    }
}
