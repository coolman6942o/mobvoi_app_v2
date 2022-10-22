package lf;

import com.mobvoi.health.common.data.pojo.HeartRateLevel;
import ef.a0;
import ef.b0;
import ef.d0;
import ef.e0;
import ef.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import xf.h;
/* compiled from: AnalysisUtils.java */
/* loaded from: classes2.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnalysisUtils.java */
    /* renamed from: lf.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C0382a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f30466a;

        static {
            int[] iArr = new int[HeartRateLevel.values().length];
            f30466a = iArr;
            try {
                iArr[HeartRateLevel.DANGEROUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30466a[HeartRateLevel.WARM_UP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30466a[HeartRateLevel.FAT_BURN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f30466a[HeartRateLevel.AEROBIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f30466a[HeartRateLevel.ANAEROBIC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private static void a(h hVar, h hVar2, f fVar) {
        int i10 = C0382a.f30466a[hVar2.f36544c.ordinal()];
        if (i10 == 1) {
            fVar.f25921e += hVar2.f36542a - hVar.f36542a;
        } else if (i10 == 2) {
            fVar.f25917a += hVar2.f36542a - hVar.f36542a;
        } else if (i10 == 3) {
            fVar.f25918b += hVar2.f36542a - hVar.f36542a;
        } else if (i10 == 4) {
            fVar.f25919c += hVar2.f36542a - hVar.f36542a;
        } else if (i10 == 5) {
            fVar.f25920d += hVar2.f36542a - hVar.f36542a;
        }
    }

    public static List<h> b(List<h> list, int i10, f fVar) {
        fVar.f25917a = 0L;
        fVar.f25918b = 0L;
        fVar.f25919c = 0L;
        fVar.f25920d = 0L;
        fVar.f25921e = 0L;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int size = list.size();
        int b10 = list.size() > 1 ? list.get(0).b() : 0;
        h hVar = null;
        int i11 = 0;
        boolean z10 = false;
        int i12 = 0;
        boolean z11 = false;
        int i13 = 0;
        while (i11 < size) {
            h hVar2 = list.get(i11);
            int b11 = hVar2.b();
            HeartRateLevel heartRateLevel = hVar2.f36544c;
            if (b11 > i12) {
                i12 = b11;
                i13 = i11;
            }
            if (b11 < b10) {
                b10 = b11;
            }
            if (z11) {
                if (heartRateLevel != HeartRateLevel.FAT_BURN) {
                    arrayList.add(Integer.valueOf(i11));
                    z11 = false;
                }
            } else if (heartRateLevel == HeartRateLevel.FAT_BURN) {
                arrayList.add(Integer.valueOf(i11));
                z11 = true;
            }
            if (z10) {
                if (heartRateLevel != HeartRateLevel.AEROBIC) {
                    arrayList2.add(Integer.valueOf(i11));
                    z10 = false;
                }
            } else if (heartRateLevel == HeartRateLevel.AEROBIC) {
                arrayList2.add(Integer.valueOf(i11));
                z10 = true;
            }
            if (hVar != null) {
                a(hVar, hVar2, fVar);
            }
            i11++;
            hVar = hVar2;
        }
        if (z10) {
            arrayList2.add(Integer.valueOf(size - 1));
        }
        if (z11) {
            arrayList.add(Integer.valueOf(size - 1));
        }
        fVar.f25923g = i13;
        fVar.f25922f = i12;
        g(list);
        HashSet hashSet = new HashSet();
        hashSet.addAll(arrayList);
        hashSet.addAll(arrayList2);
        ArrayList arrayList3 = new ArrayList(hashSet);
        Collections.sort(arrayList3);
        if (arrayList3.size() < 2) {
            return list;
        }
        int i14 = 0;
        while (i14 < arrayList3.size() && fVar.f25923g >= ((Integer) arrayList3.get(i14)).intValue()) {
            i14++;
        }
        fVar.f25923g += i14;
        for (int size2 = arrayList3.size() - 1; size2 >= 0; size2--) {
            int intValue = ((Integer) arrayList3.get(size2)).intValue();
            if (intValue <= 0) {
                list.add(0, list.get(0));
            } else {
                int i15 = size - 1;
                if (intValue > i15) {
                    list.add(size, list.get(i15));
                } else {
                    list.add(intValue, h(list.get(intValue - 1), list.get(intValue), i10));
                }
            }
        }
        int size3 = arrayList.size();
        int[] iArr = new int[size3];
        for (int i16 = 0; i16 < size3; i16++) {
            iArr[i16] = arrayList3.indexOf(arrayList.get(i16));
        }
        int size4 = arrayList2.size();
        int[] iArr2 = new int[size4];
        for (int i17 = 0; i17 < size4; i17++) {
            iArr2[i17] = arrayList3.indexOf(arrayList2.get(i17));
        }
        for (int i18 = 0; i18 < arrayList3.size(); i18++) {
            arrayList3.set(i18, Integer.valueOf(((Integer) arrayList3.get(i18)).intValue() + i18));
        }
        for (int i19 = 0; i19 < size3; i19++) {
            arrayList.set(i19, (Integer) arrayList3.get(iArr[i19]));
        }
        for (int i20 = 0; i20 < size4; i20++) {
            arrayList2.set(i20, (Integer) arrayList3.get(iArr2[i20]));
        }
        int i21 = size3 - (size3 % 2);
        long j10 = 0;
        for (int i22 = 0; i22 < i21; i22 += 2) {
            j10 += list.get(((Integer) arrayList.get(i22 + 1)).intValue()).f36542a - list.get(((Integer) arrayList.get(i22)).intValue()).f36542a;
        }
        fVar.f25924h = (int) ((j10 / 1000) / 60);
        int i23 = size4 - (size4 % 2);
        long j11 = 0;
        for (int i24 = 0; i24 < i23; i24 += 2) {
            j11 += list.get(((Integer) arrayList2.get(i24 + 1)).intValue()).f36542a - list.get(((Integer) arrayList2.get(i24)).intValue()).f36542a;
        }
        fVar.f25925i = (int) ((j11 / 1000) / 60);
        fVar.f25926j = arrayList;
        fVar.f25927k = arrayList2;
        return list;
    }

    public static void c(List<a0> list, f fVar) {
        float f10 = 0.0f;
        float f11 = Float.MAX_VALUE;
        float f12 = 0.0f;
        float f13 = 0.0f;
        for (a0 a0Var : list) {
            float f14 = a0Var.f25908b;
            f12 += f14;
            if (f14 < f11) {
                f11 = f14;
            }
            if (f14 > f13) {
                f13 = f14;
            }
        }
        if (f11 != Float.MAX_VALUE) {
            f10 = f11;
        }
        fVar.f25933q = f12 / list.size();
        fVar.f25935s = f10;
        fVar.f25934r = f13;
    }

    public static void d(List<b0> list, f fVar) {
        int size = list.size();
        float f10 = 0.0f;
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            float f11 = list.get(i11).f25913b;
            if (f11 > f10) {
                i10 = i11;
                f10 = f11;
            }
        }
        fVar.f25932p = i10;
        fVar.f25931o = f10;
    }

    public static void e(List<e0> list, f fVar) {
        fVar.f25928l = g(list);
    }

    public static void f(List<d0> list, f fVar) {
        int size = list.size();
        float f10 = 0.0f;
        for (int i10 = 0; i10 < size; i10++) {
            float d10 = list.get(i10).d();
            if (d10 > f10) {
                f10 = d10;
            }
        }
        fVar.f25929m = Math.round(g(list));
        Math.round(f10);
    }

    private static float g(List<? extends xf.f> list) {
        int i10 = 0;
        float f10 = 0.0f;
        for (xf.f fVar : list) {
            if (i(fVar)) {
                f10 = (float) (f10 + fVar.getValue());
                i10++;
            }
        }
        if (i10 > 0) {
            return f10 / i10;
        }
        return 0.0f;
    }

    private static h h(h hVar, h hVar2, int i10) {
        int b10 = hVar.b();
        int b11 = hVar2.b();
        int[] iArr = {HeartRateLevel.startHeartRateOf(HeartRateLevel.FAT_BURN, i10), HeartRateLevel.startHeartRateOf(HeartRateLevel.AEROBIC, i10), HeartRateLevel.startHeartRateOf(HeartRateLevel.ANAEROBIC, i10)};
        int i11 = -1;
        for (int i12 = 0; i12 < 3; i12++) {
            int i13 = iArr[i12];
            if ((b10 - i13) * (b11 - i13) <= 0) {
                i11 = i13;
            }
        }
        if (i11 < 0) {
            i11 = (b10 + b11) / 2;
        }
        return new h((hVar.f36542a + hVar2.f36542a) / 2, i11, HeartRateLevel.levelOf(i11, i10));
    }

    private static boolean i(xf.f fVar) {
        return Double.compare(fVar.getValue(), 0.0d) > 0;
    }
}
