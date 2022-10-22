package s8;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.e;
import com.google.zxing.i;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
/* compiled from: Detector.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.zxing.common.b f34336a;

    /* renamed from: b  reason: collision with root package name */
    private final p8.b f34337b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Detector.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final i f34338a;

        /* renamed from: b  reason: collision with root package name */
        private final i f34339b;

        /* renamed from: c  reason: collision with root package name */
        private final int f34340c;

        i a() {
            return this.f34338a;
        }

        i b() {
            return this.f34339b;
        }

        int c() {
            return this.f34340c;
        }

        public String toString() {
            return this.f34338a + "/" + this.f34339b + '/' + this.f34340c;
        }

        private b(i iVar, i iVar2, int i10) {
            this.f34338a = iVar;
            this.f34339b = iVar2;
            this.f34340c = i10;
        }
    }

    /* compiled from: Detector.java */
    /* loaded from: classes.dex */
    private static final class c implements Serializable, Comparator<b> {
        private c() {
        }

        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            return bVar.c() - bVar2.c();
        }
    }

    public a(com.google.zxing.common.b bVar) throws NotFoundException {
        this.f34336a = bVar;
        this.f34337b = new p8.b(bVar);
    }

    private i a(i iVar, i iVar2, i iVar3, i iVar4, int i10) {
        float f10 = i10;
        float d10 = d(iVar, iVar2) / f10;
        float d11 = d(iVar3, iVar4);
        i iVar5 = new i(iVar4.c() + (((iVar4.c() - iVar3.c()) / d11) * d10), iVar4.d() + (d10 * ((iVar4.d() - iVar3.d()) / d11)));
        float d12 = d(iVar, iVar3) / f10;
        float d13 = d(iVar2, iVar4);
        i iVar6 = new i(iVar4.c() + (((iVar4.c() - iVar2.c()) / d13) * d12), iVar4.d() + (d12 * ((iVar4.d() - iVar2.d()) / d13)));
        if (f(iVar5)) {
            return (f(iVar6) && Math.abs(h(iVar3, iVar5).c() - h(iVar2, iVar5).c()) > Math.abs(h(iVar3, iVar6).c() - h(iVar2, iVar6).c())) ? iVar6 : iVar5;
        }
        if (f(iVar6)) {
            return iVar6;
        }
        return null;
    }

    private i b(i iVar, i iVar2, i iVar3, i iVar4, int i10, int i11) {
        float d10 = d(iVar, iVar2) / i10;
        float d11 = d(iVar3, iVar4);
        i iVar5 = new i(iVar4.c() + (((iVar4.c() - iVar3.c()) / d11) * d10), iVar4.d() + (d10 * ((iVar4.d() - iVar3.d()) / d11)));
        float d12 = d(iVar, iVar3) / i11;
        float d13 = d(iVar2, iVar4);
        i iVar6 = new i(iVar4.c() + (((iVar4.c() - iVar2.c()) / d13) * d12), iVar4.d() + (d12 * ((iVar4.d() - iVar2.d()) / d13)));
        if (f(iVar5)) {
            return (f(iVar6) && Math.abs(i10 - h(iVar3, iVar5).c()) + Math.abs(i11 - h(iVar2, iVar5).c()) > Math.abs(i10 - h(iVar3, iVar6).c()) + Math.abs(i11 - h(iVar2, iVar6).c())) ? iVar6 : iVar5;
        }
        if (f(iVar6)) {
            return iVar6;
        }
        return null;
    }

    private static int d(i iVar, i iVar2) {
        return p8.a.c(i.b(iVar, iVar2));
    }

    private static void e(Map<i, Integer> map, i iVar) {
        Integer num = map.get(iVar);
        int i10 = 1;
        if (num != null) {
            i10 = 1 + num.intValue();
        }
        map.put(iVar, Integer.valueOf(i10));
    }

    private boolean f(i iVar) {
        return iVar.c() >= 0.0f && iVar.c() < ((float) this.f34336a.k()) && iVar.d() > 0.0f && iVar.d() < ((float) this.f34336a.g());
    }

    private static com.google.zxing.common.b g(com.google.zxing.common.b bVar, i iVar, i iVar2, i iVar3, i iVar4, int i10, int i11) throws NotFoundException {
        float f10 = i10 - 0.5f;
        float f11 = i11 - 0.5f;
        return e.b().c(bVar, i10, i11, 0.5f, 0.5f, f10, 0.5f, f10, f11, 0.5f, f11, iVar.c(), iVar.d(), iVar4.c(), iVar4.d(), iVar3.c(), iVar3.d(), iVar2.c(), iVar2.d());
    }

    private b h(i iVar, i iVar2) {
        int c10 = (int) iVar.c();
        int d10 = (int) iVar.d();
        int c11 = (int) iVar2.c();
        int d11 = (int) iVar2.d();
        int i10 = 0;
        int i11 = 1;
        boolean z10 = Math.abs(d11 - d10) > Math.abs(c11 - c10);
        if (z10) {
            d10 = c10;
            c10 = d10;
            d11 = c11;
            c11 = d11;
        }
        int abs = Math.abs(c11 - c10);
        int abs2 = Math.abs(d11 - d10);
        int i12 = (-abs) / 2;
        int i13 = d10 < d11 ? 1 : -1;
        if (c10 >= c11) {
            i11 = -1;
        }
        boolean d12 = this.f34336a.d(z10 ? d10 : c10, z10 ? c10 : d10);
        while (c10 != c11) {
            boolean d13 = this.f34336a.d(z10 ? d10 : c10, z10 ? c10 : d10);
            if (d13 != d12) {
                i10++;
                d12 = d13;
            }
            i12 += abs2;
            if (i12 > 0) {
                if (d10 == d11) {
                    break;
                }
                d10 += i13;
                i12 -= abs;
            }
            c10 += i11;
        }
        return new b(iVar, iVar2, i10);
    }

    public o8.c c() throws NotFoundException {
        i iVar;
        i iVar2;
        com.google.zxing.common.b bVar;
        i[] c10 = this.f34337b.c();
        i iVar3 = c10[0];
        i iVar4 = c10[1];
        i iVar5 = c10[2];
        i iVar6 = c10[3];
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(h(iVar3, iVar4));
        arrayList.add(h(iVar3, iVar5));
        arrayList.add(h(iVar4, iVar6));
        arrayList.add(h(iVar5, iVar6));
        i iVar7 = null;
        Collections.sort(arrayList, new c());
        b bVar2 = (b) arrayList.get(0);
        b bVar3 = (b) arrayList.get(1);
        HashMap hashMap = new HashMap();
        e(hashMap, bVar2.a());
        e(hashMap, bVar2.b());
        e(hashMap, bVar3.a());
        e(hashMap, bVar3.b());
        i iVar8 = null;
        i iVar9 = null;
        for (Map.Entry entry : hashMap.entrySet()) {
            i iVar10 = (i) entry.getKey();
            if (((Integer) entry.getValue()).intValue() == 2) {
                iVar8 = iVar10;
            } else if (iVar7 == null) {
                iVar7 = iVar10;
            } else {
                iVar9 = iVar10;
            }
        }
        if (iVar7 == null || iVar8 == null || iVar9 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        i[] iVarArr = {iVar7, iVar8, iVar9};
        i.e(iVarArr);
        i iVar11 = iVarArr[0];
        i iVar12 = iVarArr[1];
        i iVar13 = iVarArr[2];
        if (!hashMap.containsKey(iVar3)) {
            iVar = iVar3;
        } else if (!hashMap.containsKey(iVar4)) {
            iVar = iVar4;
        } else {
            iVar = !hashMap.containsKey(iVar5) ? iVar5 : iVar6;
        }
        int c11 = h(iVar13, iVar).c();
        int c12 = h(iVar11, iVar).c();
        if ((c11 & 1) == 1) {
            c11++;
        }
        int i10 = c11 + 2;
        if ((c12 & 1) == 1) {
            c12++;
        }
        int i11 = c12 + 2;
        if (i10 * 4 >= i11 * 7 || i11 * 4 >= i10 * 7) {
            iVar2 = iVar13;
            i b10 = b(iVar12, iVar11, iVar13, iVar, i10, i11);
            if (b10 != null) {
                iVar = b10;
            }
            int c13 = h(iVar2, iVar).c();
            int c14 = h(iVar11, iVar).c();
            if ((c13 & 1) == 1) {
                c13++;
            }
            int i12 = c13;
            if ((c14 & 1) == 1) {
                c14++;
            }
            bVar = g(this.f34336a, iVar2, iVar12, iVar11, iVar, i12, c14);
        } else {
            i a10 = a(iVar12, iVar11, iVar13, iVar, Math.min(i11, i10));
            if (a10 != null) {
                iVar = a10;
            }
            int max = Math.max(h(iVar13, iVar).c(), h(iVar11, iVar).c()) + 1;
            if ((max & 1) == 1) {
                max++;
            }
            int i13 = max;
            bVar = g(this.f34336a, iVar13, iVar12, iVar11, iVar, i13, i13);
            iVar2 = iVar13;
        }
        return new o8.c(bVar, new i[]{iVar2, iVar12, iVar11, iVar});
    }
}
