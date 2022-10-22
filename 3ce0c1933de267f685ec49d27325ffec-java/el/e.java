package el;

import android.os.ParcelUuid;
import android.util.ArrayMap;
import android.util.SparseArray;
import com.mobvoi.wear.lpa.LpaConstants;
import fl.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jl.a;
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final int f26114a;

    /* renamed from: b  reason: collision with root package name */
    public final List<ParcelUuid> f26115b;

    /* renamed from: c  reason: collision with root package name */
    public final SparseArray<byte[]> f26116c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<ParcelUuid, byte[]> f26117d;

    /* renamed from: e  reason: collision with root package name */
    public final int f26118e;

    /* renamed from: f  reason: collision with root package name */
    public final String f26119f;

    public e(List<ParcelUuid> list, SparseArray<byte[]> sparseArray, Map<ParcelUuid, byte[]> map, int i10, int i11, String str, byte[] bArr) {
        this.f26115b = list;
        this.f26116c = sparseArray;
        this.f26117d = map;
        this.f26119f = str;
        this.f26114a = i10;
        this.f26118e = i11;
    }

    public static int a(byte[] bArr, int i10, int i11, int i12, List<ParcelUuid> list) {
        while (i11 > 0) {
            list.add(b.f(b(bArr, i10, i12)));
            i11 -= i12;
            i10 += i12;
        }
        return i10;
    }

    public static byte[] b(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        return bArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static e e(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int i10 = 0;
        int i11 = -1;
        ArrayList arrayList = new ArrayList();
        byte b10 = -2147483648;
        SparseArray sparseArray = new SparseArray();
        ArrayMap arrayMap = new ArrayMap();
        String str = null;
        while (i10 < bArr.length) {
            try {
                int i12 = i10 + 1;
                int i13 = bArr[i10] & 255;
                if (i13 == 0) {
                    return new e(!arrayList.isEmpty() ? null : arrayList, sparseArray, arrayMap, i11, b10, str, bArr);
                }
                int i14 = i13 - 1;
                int i15 = i12 + 1;
                int i16 = bArr[i12] & 255;
                int i17 = 16;
                if (i16 != 22) {
                    if (i16 == 255) {
                        sparseArray.put(((bArr[i15 + 1] & 255) << 8) + (bArr[i15] & 255), b(bArr, i15 + 2, i14 - 2));
                    } else if (!(i16 == 32 || i16 == 33)) {
                        switch (i16) {
                            case 1:
                                i11 = bArr[i15] & 255;
                                continue;
                            case 2:
                            case 3:
                                a(bArr, i15, i14, 2, arrayList);
                                continue;
                            case 4:
                            case 5:
                                a(bArr, i15, i14, 4, arrayList);
                                continue;
                            case 6:
                            case 7:
                                a(bArr, i15, i14, 16, arrayList);
                                continue;
                            case 8:
                            case 9:
                                str = new String(b(bArr, i15, i14));
                                continue;
                            case 10:
                                b10 = bArr[i15];
                                continue;
                            default:
                                continue;
                        }
                    }
                    i10 = i14 + i15;
                }
                i17 = 4;
                if (!(i16 == 32 || i16 == 33)) {
                    i17 = 2;
                }
                arrayMap.put(b.f(b(bArr, i15, i17)), b(bArr, i15 + i17, i14 - i17));
                i10 = i14 + i15;
            } catch (Exception unused) {
                il.b.e("unable to parse scan record: " + Arrays.toString(bArr));
                return new e(null, null, null, -1, Integer.MIN_VALUE, null, bArr);
            }
        }
        return new e(!arrayList.isEmpty() ? null : arrayList, sparseArray, arrayMap, i11, b10, str, bArr);
    }

    public byte[] c(int i10) {
        SparseArray<byte[]> sparseArray = this.f26116c;
        if (sparseArray != null) {
            return sparseArray.get(i10);
        }
        return null;
    }

    public List<ParcelUuid> d() {
        return this.f26115b;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ScanRecord [mAdvertiseFlags=");
        sb2.append(this.f26114a);
        sb2.append(", mServiceUuids=");
        sb2.append(this.f26115b);
        sb2.append("\n, mManufacturerSpecificData=");
        SparseArray<byte[]> sparseArray = this.f26116c;
        String str2 = "{}";
        if (sparseArray == null) {
            str = LpaConstants.VALUE_NULL;
        } else if (sparseArray.size() == 0) {
            str = str2;
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append('{');
            for (int i10 = 0; i10 < sparseArray.size(); i10++) {
                byte[] valueAt = sparseArray.valueAt(i10);
                int length = valueAt != null ? valueAt.length : 0;
                sb3.append(sparseArray.keyAt(i10));
                sb3.append("=(");
                sb3.append(length);
                sb3.append(")");
                sb3.append(a.b(valueAt));
            }
            sb3.append('}');
            str = sb3.toString();
        }
        sb2.append(str);
        sb2.append(", mServiceData=");
        Map<ParcelUuid, byte[]> map = this.f26117d;
        if (map == null) {
            str2 = LpaConstants.VALUE_NULL;
        } else if (!map.isEmpty()) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append('{');
            Iterator<Map.Entry<ParcelUuid, byte[]>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                ParcelUuid key = it.next().getKey();
                byte[] bArr = map.get(key);
                int length2 = bArr != null ? bArr.length : 0;
                sb4.append(key);
                sb4.append("=(");
                sb4.append(length2);
                sb4.append(")");
                sb4.append(a.b(bArr));
                if (it.hasNext()) {
                    sb4.append(", ");
                }
            }
            sb4.append('}');
            str2 = sb4.toString();
        }
        sb2.append(str2);
        sb2.append(", mTxPowerLevel=");
        sb2.append(this.f26118e);
        sb2.append(", mDeviceName=");
        sb2.append(this.f26119f);
        sb2.append("]");
        return sb2.toString();
    }
}
