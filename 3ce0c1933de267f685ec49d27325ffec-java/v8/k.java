package v8;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.b;
import com.google.zxing.common.a;
import com.google.zxing.g;
import com.google.zxing.h;
import com.google.zxing.i;
import com.huawei.hms.ml.camera.CameraConfig;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
/* compiled from: OneDReader.java */
/* loaded from: classes.dex */
public abstract class k implements g {
    /* JADX WARN: Removed duplicated region for block: B:40:0x007c A[Catch: ReaderException -> 0x00cc, TRY_LEAVE, TryCatch #5 {ReaderException -> 0x00cc, blocks: (B:38:0x0076, B:40:0x007c), top: B:74:0x0076 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00cb A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private h c(b bVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        k kVar;
        int i10;
        Map<DecodeHintType, ?> map2;
        int i11;
        EnumMap enumMap = map;
        int d10 = bVar.d();
        int c10 = bVar.c();
        a aVar = new a(d10);
        int i12 = c10 >> 1;
        int i13 = 0;
        int i14 = 1;
        boolean z10 = enumMap != null && enumMap.containsKey(DecodeHintType.TRY_HARDER);
        int max = Math.max(1, c10 >> (z10 ? 8 : 5));
        int i15 = z10 ? c10 : 15;
        int i16 = 0;
        while (i16 < i15) {
            int i17 = i16 + 1;
            int i18 = i17 / 2;
            if (((i16 & 1) == 0 ? i14 : i13) == 0) {
                i18 = -i18;
            }
            int i19 = (i18 * max) + i12;
            if (i19 < 0 || i19 >= c10) {
                break;
            }
            try {
                aVar = bVar.b(i19, aVar);
                int i20 = i13;
                while (i20 < 2) {
                    try {
                        if (i20 == i14) {
                            aVar.k();
                            if (enumMap != null) {
                                DecodeHintType decodeHintType = DecodeHintType.NEED_RESULT_POINT_CALLBACK;
                                if (enumMap.containsKey(decodeHintType)) {
                                    EnumMap enumMap2 = new EnumMap(DecodeHintType.class);
                                    enumMap2.putAll(enumMap);
                                    enumMap2.remove(decodeHintType);
                                    kVar = this;
                                    enumMap = enumMap2;
                                    h b10 = kVar.b(i19, aVar, enumMap);
                                    if (i20 != i14) {
                                        try {
                                            b10.h(ResultMetadataType.ORIENTATION, Integer.valueOf((int) CameraConfig.CAMERA_THIRD_DEGREE));
                                            i[] e10 = b10.e();
                                            if (e10 != null) {
                                                map2 = enumMap;
                                                float f10 = d10;
                                                try {
                                                    i10 = d10;
                                                } catch (ReaderException unused) {
                                                    i10 = d10;
                                                    i11 = 1;
                                                    i20++;
                                                    i14 = i11;
                                                    enumMap = map2;
                                                    d10 = i10;
                                                    i13 = 0;
                                                }
                                                try {
                                                    e10[0] = new i((f10 - e10[i13].c()) - 1.0f, e10[i13].d());
                                                    i11 = 1;
                                                    try {
                                                        e10[1] = new i((f10 - e10[1].c()) - 1.0f, e10[1].d());
                                                    } catch (ReaderException unused2) {
                                                        continue;
                                                        i20++;
                                                        i14 = i11;
                                                        enumMap = map2;
                                                        d10 = i10;
                                                        i13 = 0;
                                                    }
                                                } catch (ReaderException unused3) {
                                                    i11 = 1;
                                                    i20++;
                                                    i14 = i11;
                                                    enumMap = map2;
                                                    d10 = i10;
                                                    i13 = 0;
                                                }
                                            }
                                        } catch (ReaderException unused4) {
                                            map2 = enumMap;
                                        }
                                    }
                                    return b10;
                                }
                            }
                        }
                        h b102 = kVar.b(i19, aVar, enumMap);
                        if (i20 != i14) {
                        }
                        return b102;
                    } catch (ReaderException unused5) {
                        map2 = enumMap;
                        i10 = d10;
                        i11 = i14;
                    }
                    kVar = this;
                }
                continue;
            } catch (NotFoundException unused6) {
            }
            d10 = d10;
            i14 = i14;
            i16 = i17;
            i13 = 0;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static float d(int[] iArr, int[] iArr2, float f10) {
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            i10 += iArr[i12];
            i11 += iArr2[i12];
        }
        if (i10 < i11) {
            return Float.POSITIVE_INFINITY;
        }
        float f11 = i10;
        float f12 = f11 / i11;
        float f13 = f10 * f12;
        float f14 = 0.0f;
        for (int i13 = 0; i13 < length; i13++) {
            float f15 = iArr2[i13] * f12;
            float f16 = iArr[i13];
            float f17 = f16 > f15 ? f16 - f15 : f15 - f16;
            if (f17 > f13) {
                return Float.POSITIVE_INFINITY;
            }
            f14 += f17;
        }
        return f14 / f11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void e(a aVar, int i10, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i11 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int g10 = aVar.g();
        if (i10 < g10) {
            boolean z10 = !aVar.c(i10);
            while (i10 < g10) {
                if (!(aVar.c(i10) ^ z10)) {
                    i11++;
                    if (i11 == length) {
                        break;
                    }
                    iArr[i11] = 1;
                    z10 = !z10;
                } else {
                    iArr[i11] = iArr[i11] + 1;
                }
                i10++;
            }
            if (i11 == length) {
                return;
            }
            if (i11 != length - 1 || i10 != g10) {
                throw NotFoundException.getNotFoundInstance();
            }
            return;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void f(a aVar, int i10, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        boolean c10 = aVar.c(i10);
        while (i10 > 0 && length >= 0) {
            i10--;
            if (aVar.c(i10) != c10) {
                length--;
                c10 = !c10;
            }
        }
        if (length < 0) {
            e(aVar, i10 + 1, iArr);
            return;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.g
    public h a(b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        try {
            return c(bVar, map);
        } catch (NotFoundException e10) {
            if (!(map != null && map.containsKey(DecodeHintType.TRY_HARDER)) || !bVar.e()) {
                throw e10;
            }
            b f10 = bVar.f();
            h c10 = c(f10, map);
            Map<ResultMetadataType, Object> d10 = c10.d();
            int i10 = 270;
            if (d10 != null) {
                ResultMetadataType resultMetadataType = ResultMetadataType.ORIENTATION;
                if (d10.containsKey(resultMetadataType)) {
                    i10 = (((Integer) d10.get(resultMetadataType)).intValue() + 270) % 360;
                }
            }
            c10.h(ResultMetadataType.ORIENTATION, Integer.valueOf(i10));
            i[] e11 = c10.e();
            if (e11 != null) {
                int c11 = f10.c();
                for (int i11 = 0; i11 < e11.length; i11++) {
                    e11[i11] = new i((c11 - e11[i11].d()) - 1.0f, e11[i11].c());
                }
            }
            return c10;
        }
    }

    public abstract h b(int i10, a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException;
}
