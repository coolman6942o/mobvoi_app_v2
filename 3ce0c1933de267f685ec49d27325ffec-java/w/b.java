package w;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.d;
import androidx.constraintlayout.core.widgets.e;
import androidx.constraintlayout.core.widgets.f;
import androidx.constraintlayout.core.widgets.g;
import java.util.ArrayList;
/* compiled from: BasicMeasure.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<ConstraintWidget> f35851a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private a f35852b = new a();

    /* renamed from: c  reason: collision with root package name */
    private d f35853c;

    /* compiled from: BasicMeasure.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: k  reason: collision with root package name */
        public static int f35854k = 0;

        /* renamed from: l  reason: collision with root package name */
        public static int f35855l = 1;

        /* renamed from: m  reason: collision with root package name */
        public static int f35856m = 2;

        /* renamed from: a  reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f35857a;

        /* renamed from: b  reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f35858b;

        /* renamed from: c  reason: collision with root package name */
        public int f35859c;

        /* renamed from: d  reason: collision with root package name */
        public int f35860d;

        /* renamed from: e  reason: collision with root package name */
        public int f35861e;

        /* renamed from: f  reason: collision with root package name */
        public int f35862f;

        /* renamed from: g  reason: collision with root package name */
        public int f35863g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f35864h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f35865i;

        /* renamed from: j  reason: collision with root package name */
        public int f35866j;
    }

    /* compiled from: BasicMeasure.java */
    /* renamed from: w.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface AbstractC0518b {
        void a();

        void b(ConstraintWidget constraintWidget, a aVar);
    }

    public b(d dVar) {
        this.f35853c = dVar;
    }

    private boolean a(AbstractC0518b bVar, ConstraintWidget constraintWidget, int i10) {
        this.f35852b.f35857a = constraintWidget.y();
        this.f35852b.f35858b = constraintWidget.O();
        this.f35852b.f35859c = constraintWidget.R();
        this.f35852b.f35860d = constraintWidget.v();
        a aVar = this.f35852b;
        aVar.f35865i = false;
        aVar.f35866j = i10;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = aVar.f35857a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z10 = dimensionBehaviour == dimensionBehaviour2;
        boolean z11 = aVar.f35858b == dimensionBehaviour2;
        boolean z12 = z10 && constraintWidget.Z > 0.0f;
        boolean z13 = z11 && constraintWidget.Z > 0.0f;
        if (z12 && constraintWidget.f1624u[0] == 4) {
            aVar.f35857a = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z13 && constraintWidget.f1624u[1] == 4) {
            aVar.f35858b = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        bVar.b(constraintWidget, aVar);
        constraintWidget.b1(this.f35852b.f35861e);
        constraintWidget.C0(this.f35852b.f35862f);
        constraintWidget.B0(this.f35852b.f35864h);
        constraintWidget.r0(this.f35852b.f35863g);
        a aVar2 = this.f35852b;
        aVar2.f35866j = a.f35854k;
        return aVar2.f35865i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x008d, code lost:
        if (r8 != r9) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0094, code lost:
        if (r5.Z <= 0.0f) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(d dVar) {
        l lVar;
        n nVar;
        int size = dVar.f35553u0.size();
        boolean J1 = dVar.J1(64);
        AbstractC0518b z12 = dVar.z1();
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintWidget constraintWidget = dVar.f35553u0.get(i10);
            if (!(constraintWidget instanceof e) && !(constraintWidget instanceof androidx.constraintlayout.core.widgets.a) && !constraintWidget.g0() && (!J1 || (lVar = constraintWidget.f1591d) == null || (nVar = constraintWidget.f1593e) == null || !lVar.f35911e.f35886j || !nVar.f35911e.f35886j)) {
                ConstraintWidget.DimensionBehaviour s10 = constraintWidget.s(0);
                boolean z10 = true;
                ConstraintWidget.DimensionBehaviour s11 = constraintWidget.s(1);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                boolean z11 = s10 == dimensionBehaviour && constraintWidget.f1621s != 1 && s11 == dimensionBehaviour && constraintWidget.f1623t != 1;
                if (!z11 && dVar.J1(1) && !(constraintWidget instanceof g)) {
                    if (s10 == dimensionBehaviour && constraintWidget.f1621s == 0 && s11 != dimensionBehaviour && !constraintWidget.d0()) {
                        z11 = true;
                    }
                    if (s11 == dimensionBehaviour && constraintWidget.f1623t == 0 && s10 != dimensionBehaviour && !constraintWidget.d0()) {
                        z11 = true;
                    }
                    if (s10 != dimensionBehaviour) {
                    }
                }
                z10 = z11;
                if (!z10) {
                    a(z12, constraintWidget, a.f35854k);
                }
            }
        }
        z12.a();
    }

    private void c(d dVar, String str, int i10, int i11, int i12) {
        int G = dVar.G();
        int F = dVar.F();
        dVar.R0(0);
        dVar.Q0(0);
        dVar.b1(i11);
        dVar.C0(i12);
        dVar.R0(G);
        dVar.Q0(F);
        this.f35853c.N1(i10);
        this.f35853c.j1();
    }

    public long d(d dVar, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        int i19;
        boolean z10;
        int i20;
        d dVar2;
        int i21;
        boolean z11;
        int i22;
        b bVar = this;
        AbstractC0518b z12 = dVar.z1();
        int size = dVar.f35553u0.size();
        int R = dVar.R();
        int v10 = dVar.v();
        boolean b10 = f.b(i10, 128);
        boolean z13 = b10 || f.b(i10, 64);
        if (z13) {
            for (int i23 = 0; i23 < size; i23++) {
                ConstraintWidget constraintWidget = dVar.f35553u0.get(i23);
                ConstraintWidget.DimensionBehaviour y10 = constraintWidget.y();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                boolean z14 = (y10 == dimensionBehaviour) && (constraintWidget.O() == dimensionBehaviour) && constraintWidget.t() > 0.0f;
                if ((constraintWidget.d0() && z14) || ((constraintWidget.f0() && z14) || (constraintWidget instanceof g) || constraintWidget.d0() || constraintWidget.f0())) {
                    z13 = false;
                    break;
                }
            }
        }
        if (z13) {
            r.a aVar = androidx.constraintlayout.core.d.f1532x;
        }
        boolean z15 = z13 & ((i13 == 1073741824 && i15 == 1073741824) || b10);
        int i24 = 2;
        if (z15) {
            int min = Math.min(dVar.E(), i14);
            int min2 = Math.min(dVar.D(), i16);
            if (i13 == 1073741824 && dVar.R() != min) {
                dVar.b1(min);
                dVar.C1();
            }
            if (i15 == 1073741824 && dVar.v() != min2) {
                dVar.C0(min2);
                dVar.C1();
            }
            if (i13 == 1073741824 && i15 == 1073741824) {
                z10 = dVar.w1(b10);
                i19 = 2;
            } else {
                boolean x12 = dVar.x1(b10);
                if (i13 == 1073741824) {
                    x12 &= dVar.y1(b10, 0);
                    i19 = 1;
                } else {
                    i19 = 0;
                }
                if (i15 == 1073741824) {
                    z10 = dVar.y1(b10, 1) & x12;
                    i19++;
                } else {
                    z10 = x12;
                }
            }
            if (z10) {
                dVar.g1(i13 == 1073741824, i15 == 1073741824);
            }
        } else {
            z10 = false;
            i19 = 0;
        }
        if (z10 && i19 == 2) {
            return 0L;
        }
        int A1 = dVar.A1();
        if (size > 0) {
            b(dVar);
        }
        e(dVar);
        int size2 = bVar.f35851a.size();
        if (size > 0) {
            c(dVar, "First pass", 0, R, v10);
        }
        if (size2 > 0) {
            ConstraintWidget.DimensionBehaviour y11 = dVar.y();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z16 = y11 == dimensionBehaviour2;
            boolean z17 = dVar.O() == dimensionBehaviour2;
            int max = Math.max(dVar.R(), bVar.f35853c.G());
            int max2 = Math.max(dVar.v(), bVar.f35853c.F());
            int i25 = 0;
            boolean z18 = false;
            while (i25 < size2) {
                ConstraintWidget constraintWidget2 = bVar.f35851a.get(i25);
                if (!(constraintWidget2 instanceof g)) {
                    i22 = A1;
                } else {
                    int R2 = constraintWidget2.R();
                    int v11 = constraintWidget2.v();
                    i22 = A1;
                    boolean z19 = bVar.a(z12, constraintWidget2, a.f35855l) | z18;
                    int R3 = constraintWidget2.R();
                    int v12 = constraintWidget2.v();
                    if (R3 != R2) {
                        constraintWidget2.b1(R3);
                        if (z16 && constraintWidget2.K() > max) {
                            max = Math.max(max, constraintWidget2.K() + constraintWidget2.m(ConstraintAnchor.Type.RIGHT).e());
                        }
                        z19 = true;
                    }
                    if (v12 != v11) {
                        constraintWidget2.C0(v12);
                        if (z17 && constraintWidget2.p() > max2) {
                            max2 = Math.max(max2, constraintWidget2.p() + constraintWidget2.m(ConstraintAnchor.Type.BOTTOM).e());
                        }
                        z19 = true;
                    }
                    z18 = z19 | ((g) constraintWidget2).m1();
                }
                i25++;
                A1 = i22;
                i24 = 2;
            }
            i20 = A1;
            int i26 = i24;
            int i27 = 0;
            while (i27 < i26) {
                int i28 = 0;
                while (i28 < size2) {
                    ConstraintWidget constraintWidget3 = bVar.f35851a.get(i28);
                    if ((!(constraintWidget3 instanceof v.a) || (constraintWidget3 instanceof g)) && !(constraintWidget3 instanceof e) && constraintWidget3.Q() != 8 && ((!z15 || !constraintWidget3.f1591d.f35911e.f35886j || !constraintWidget3.f1593e.f35911e.f35886j) && !(constraintWidget3 instanceof g))) {
                        int R4 = constraintWidget3.R();
                        int v13 = constraintWidget3.v();
                        z11 = z15;
                        int n10 = constraintWidget3.n();
                        int i29 = a.f35855l;
                        i21 = size2;
                        if (i27 == 1) {
                            i29 = a.f35856m;
                        }
                        boolean a10 = bVar.a(z12, constraintWidget3, i29) | z18;
                        int R5 = constraintWidget3.R();
                        int v14 = constraintWidget3.v();
                        if (R5 != R4) {
                            constraintWidget3.b1(R5);
                            if (z16 && constraintWidget3.K() > max) {
                                max = Math.max(max, constraintWidget3.K() + constraintWidget3.m(ConstraintAnchor.Type.RIGHT).e());
                            }
                            a10 = true;
                        }
                        if (v14 != v13) {
                            constraintWidget3.C0(v14);
                            if (z17 && constraintWidget3.p() > max2) {
                                max2 = Math.max(max2, constraintWidget3.p() + constraintWidget3.m(ConstraintAnchor.Type.BOTTOM).e());
                            }
                            a10 = true;
                        }
                        z18 = (!constraintWidget3.U() || n10 == constraintWidget3.n()) ? a10 : true;
                    } else {
                        z11 = z15;
                        i21 = size2;
                    }
                    i28++;
                    bVar = this;
                    z15 = z11;
                    size2 = i21;
                }
                z15 = z15;
                size2 = size2;
                if (!z18) {
                    break;
                }
                i27++;
                c(dVar, "intermediate pass", i27, R, v10);
                bVar = this;
                i26 = 2;
                z18 = false;
            }
            dVar2 = dVar;
        } else {
            dVar2 = dVar;
            i20 = A1;
        }
        dVar2.M1(i20);
        return 0L;
    }

    public void e(d dVar) {
        this.f35851a.clear();
        int size = dVar.f35553u0.size();
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintWidget constraintWidget = dVar.f35553u0.get(i10);
            ConstraintWidget.DimensionBehaviour y10 = constraintWidget.y();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (y10 == dimensionBehaviour || constraintWidget.O() == dimensionBehaviour) {
                this.f35851a.add(constraintWidget);
            }
        }
        dVar.C1();
    }
}
