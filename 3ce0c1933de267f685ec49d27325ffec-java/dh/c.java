package dh;

import com.mobvoi.android.common.utils.k;
import dh.d;
import ef.z;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/* compiled from: RouteBuilder.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    final int[] f25631b;

    /* renamed from: d  reason: collision with root package name */
    private int[] f25633d;

    /* renamed from: e  reason: collision with root package name */
    private List<z> f25634e;

    /* renamed from: f  reason: collision with root package name */
    private int[] f25635f;

    /* renamed from: a  reason: collision with root package name */
    final int[] f25630a = {5, 8, 12};

    /* renamed from: c  reason: collision with root package name */
    final int[] f25632c = {10, 25, 35};

    /* renamed from: g  reason: collision with root package name */
    private int f25636g = 1000;

    /* compiled from: RouteBuilder.java */
    /* loaded from: classes2.dex */
    private static class b implements g {
        private b() {
        }

        @Override // dh.c.g
        public void a(dh.d dVar, List<z> list) {
            if (!list.isEmpty()) {
                z zVar = list.get(0);
                d.e eVar = new d.e();
                eVar.f25655a = zVar.f26024b;
                eVar.f25656b = zVar.f26025c;
                dVar.f25641d = eVar;
            }
        }
    }

    /* compiled from: RouteBuilder.java */
    /* renamed from: dh.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0273c implements g {
        private C0273c() {
        }

        @Override // dh.c.g
        public void a(dh.d dVar, List<z> list) {
            if (!list.isEmpty()) {
                double d10 = list.get(0).f26024b;
                double d11 = list.get(0).f26024b;
                double d12 = list.get(0).f26025c;
                double d13 = list.get(0).f26025c;
                for (z zVar : list) {
                    double d14 = zVar.f26024b;
                    double d15 = zVar.f26025c;
                    if (d15 > d13) {
                        d13 = d15;
                    } else if (d15 < d12) {
                        d12 = d15;
                    }
                    if (d14 > d11) {
                        d11 = d14;
                    } else if (d14 < d10) {
                        d10 = d14;
                    }
                }
                double d16 = d13 - d12;
                double d17 = d11 - d10;
                double d18 = ((d16 / 0.800000011920929d) - d16) / 2.0d;
                double d19 = ((d17 / 0.800000011920929d) - d17) / 2.0d;
                d.b bVar = new d.b();
                dVar.f25638a = bVar;
                bVar.f25645a = d10 - d19;
                bVar.f25646b = d11 + d19;
                bVar.f25647c = d12 - d18;
                bVar.f25648d = d13 + d18;
            }
        }
    }

    /* compiled from: RouteBuilder.java */
    /* loaded from: classes2.dex */
    private static class d implements g {
        private d() {
        }

        @Override // dh.c.g
        public void a(dh.d dVar, List<z> list) {
            if (!list.isEmpty()) {
                z zVar = list.get(list.size() - 1);
                d.a aVar = new d.a();
                aVar.f25643a = zVar.f26024b;
                aVar.f25644b = zVar.f26025c;
                dVar.f25642e = aVar;
            }
        }
    }

    /* compiled from: RouteBuilder.java */
    /* loaded from: classes2.dex */
    private static class e implements g {
        private e() {
        }

        private d.c b(z zVar) {
            if (zVar == null || zVar.f26026d <= 0.0f) {
                return null;
            }
            d.c cVar = new d.c();
            cVar.f25649a = zVar.f26024b;
            cVar.f25650b = zVar.f26025c;
            cVar.f25651c = (int) Math.floor(zVar.f26026d);
            return cVar;
        }

        @Override // dh.c.g
        public void a(dh.d dVar, List<z> list) {
            if (!list.isEmpty()) {
                dVar.f25640c = new ArrayList();
                for (z zVar : list) {
                    d.c b10 = b(zVar);
                    if (b10 != null) {
                        dVar.f25640c.add(b10);
                    }
                }
            }
        }
    }

    /* compiled from: RouteBuilder.java */
    /* loaded from: classes2.dex */
    private class f implements g {
        private f() {
        }

        private void b(List<cd.d> list, z zVar) {
            list.add(new cd.d(zVar.f26024b, zVar.f26025c, 0.0d));
        }

        private void c(List<d.C0274d> list, List<cd.d> list2, int i10, boolean z10) {
            if (list2.size() >= 2) {
                d.C0274d dVar = new d.C0274d();
                dVar.f25652a = new ArrayList(list2);
                dVar.f25653b = i10;
                dVar.f25654c = z10;
                list.add(dVar);
            }
            list2.clear();
        }

        private int d(double d10) {
            int length = c.this.f25635f.length;
            int i10 = 0;
            while (i10 < length && d10 >= c.this.f25635f[i10]) {
                i10++;
            }
            return c.this.f25633d[i10];
        }

        @Override // dh.c.g
        public void a(dh.d dVar, List<z> list) {
            char c10;
            int size = list.size();
            if (size >= 2) {
                dVar.f25639b = new ArrayList();
                int min = Math.min(list.size(), c.this.f25636g);
                float size2 = min / list.size();
                boolean z10 = true;
                k.c("RouteBuilder", "location counts:  %d, sampleRate: %.2f", Integer.valueOf(size), Float.valueOf(size2));
                ArrayList arrayList = new ArrayList(min);
                int i10 = -1;
                int d10 = d(list.get(0).f26027e);
                int i11 = 0;
                z zVar = null;
                while (i11 < size) {
                    z zVar2 = list.get(i11);
                    int i12 = (int) (i11 * size2);
                    if (zVar2.f26028f) {
                        c(dVar.f25639b, arrayList, d10, false);
                        int d11 = d(zVar2.f26027e);
                        if (zVar != null) {
                            b(arrayList, zVar);
                            b(arrayList, zVar2);
                            c(dVar.f25639b, arrayList, d11, z10);
                        }
                        b(arrayList, zVar2);
                        d10 = d11;
                        zVar = zVar2;
                        i10 = i12;
                    } else {
                        int i13 = i11 + 1;
                        z zVar3 = i13 < size ? list.get(i13) : null;
                        if (i12 != i10 || i13 == size || (zVar3 != null && zVar3.f26028f)) {
                            int d12 = d(zVar2.f26027e);
                            if (d12 != d10) {
                                c10 = 2;
                                if (arrayList.size() >= 2) {
                                    c(dVar.f25639b, arrayList, d10, false);
                                    b(arrayList, zVar);
                                }
                            } else {
                                c10 = 2;
                            }
                            b(arrayList, zVar2);
                            d10 = d12;
                            zVar = zVar2;
                            i10 = i12;
                            i11++;
                            z10 = true;
                        }
                    }
                    c10 = 2;
                    i11++;
                    z10 = true;
                }
                c(dVar.f25639b, arrayList, d10, false);
            }
        }
    }

    /* compiled from: RouteBuilder.java */
    /* loaded from: classes2.dex */
    private interface g {
        void a(dh.d dVar, List<z> list);
    }

    public c() {
        int[] iArr = {4, 7, 10};
        this.f25631b = iArr;
        this.f25635f = iArr;
    }

    public dh.d d() {
        Objects.requireNonNull(this.f25633d, "Speed colors not initialed");
        Objects.requireNonNull(this.f25635f, "Speed levels not initialed");
        Objects.requireNonNull(this.f25634e, "Locations not initialed");
        g[] gVarArr = {new C0273c(), new e(), new f(), new b(), new d()};
        dh.d dVar = new dh.d();
        for (int i10 = 0; i10 < 5; i10++) {
            gVarArr[i10].a(dVar, this.f25634e);
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return (this.f25633d == null || this.f25635f == null || this.f25634e == null) ? false : true;
    }

    public c f(List<z> list) {
        this.f25634e = list;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c g(int[] iArr) {
        if (iArr.length >= 4) {
            this.f25633d = iArr;
            return this;
        }
        throw new IllegalArgumentException("Speed colors should have size of 4");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c h(int[] iArr) {
        if (iArr.length >= 3) {
            this.f25635f = iArr;
            return this;
        }
        throw new IllegalArgumentException("Speed levels should have size of 3");
    }
}
