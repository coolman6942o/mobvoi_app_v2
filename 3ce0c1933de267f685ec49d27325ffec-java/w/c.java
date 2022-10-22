package w;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.d;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: ChainRun.java */
/* loaded from: classes.dex */
public class c extends p {

    /* renamed from: k  reason: collision with root package name */
    ArrayList<p> f35867k = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    private int f35868l;

    public c(ConstraintWidget constraintWidget, int i10) {
        super(constraintWidget);
        this.f35912f = i10;
        q();
    }

    private void q() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2 = this.f35908b;
        ConstraintWidget J = constraintWidget2.J(this.f35912f);
        while (true) {
            constraintWidget2 = J;
            constraintWidget = constraintWidget2;
            if (constraintWidget2 == null) {
                break;
            }
            J = constraintWidget2.J(this.f35912f);
        }
        this.f35908b = constraintWidget;
        this.f35867k.add(constraintWidget.L(this.f35912f));
        ConstraintWidget H = constraintWidget.H(this.f35912f);
        while (H != null) {
            this.f35867k.add(H.L(this.f35912f));
            H = H.H(this.f35912f);
        }
        Iterator<p> it = this.f35867k.iterator();
        while (it.hasNext()) {
            p next = it.next();
            int i10 = this.f35912f;
            if (i10 == 0) {
                next.f35908b.f1587b = this;
            } else if (i10 == 1) {
                next.f35908b.f1589c = this;
            }
        }
        if ((this.f35912f == 0 && ((d) this.f35908b.I()).F1()) && this.f35867k.size() > 1) {
            ArrayList<p> arrayList = this.f35867k;
            this.f35908b = arrayList.get(arrayList.size() - 1).f35908b;
        }
        this.f35868l = this.f35912f == 0 ? this.f35908b.x() : this.f35908b.N();
    }

    private ConstraintWidget r() {
        for (int i10 = 0; i10 < this.f35867k.size(); i10++) {
            p pVar = this.f35867k.get(i10);
            if (pVar.f35908b.Q() != 8) {
                return pVar.f35908b;
            }
        }
        return null;
    }

    private ConstraintWidget s() {
        for (int size = this.f35867k.size() - 1; size >= 0; size--) {
            p pVar = this.f35867k.get(size);
            if (pVar.f35908b.Q() != 8) {
                return pVar.f35908b;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:266:0x0400, code lost:
        r7 = r7 - r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e9  */
    @Override // w.p, w.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        float f10;
        int i15;
        boolean z10;
        int i16;
        int i17;
        int i18;
        float f11;
        int i19;
        int i20;
        boolean z11;
        float f12;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        if (this.f35914h.f35886j && this.f35915i.f35886j) {
            ConstraintWidget I = this.f35908b.I();
            boolean F1 = I instanceof d ? ((d) I).F1() : false;
            int i27 = this.f35915i.f35883g - this.f35914h.f35883g;
            int size = this.f35867k.size();
            int i28 = 0;
            while (true) {
                i10 = -1;
                i11 = 8;
                if (i28 >= size) {
                    i28 = -1;
                    break;
                }
                if (this.f35867k.get(i28).f35908b.Q() != 8) {
                    break;
                }
                i28++;
            }
            int i29 = size - 1;
            int i30 = i29;
            while (true) {
                if (i30 < 0) {
                    break;
                }
                if (this.f35867k.get(i30).f35908b.Q() != 8) {
                    i10 = i30;
                    break;
                }
                i30--;
            }
            int i31 = 0;
            while (i31 < 2) {
                int i32 = 0;
                i13 = 0;
                i14 = 0;
                int i33 = 0;
                f10 = 0.0f;
                while (i32 < size) {
                    p pVar = this.f35867k.get(i32);
                    if (pVar.f35908b.Q() != i11) {
                        i33++;
                        if (i32 > 0 && i32 >= i28) {
                            i13 += pVar.f35914h.f35882f;
                        }
                        g gVar = pVar.f35911e;
                        int i34 = gVar.f35883g;
                        boolean z12 = pVar.f35910d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (z12) {
                            int i35 = this.f35912f;
                            if (i35 == 0 && !pVar.f35908b.f1591d.f35911e.f35886j) {
                                return;
                            }
                            if (i35 != 1 || pVar.f35908b.f1593e.f35911e.f35886j) {
                                i26 = i34;
                            } else {
                                return;
                            }
                        } else {
                            i26 = i34;
                            if (pVar.f35907a == 1 && i31 == 0) {
                                i25 = gVar.f35889m;
                                i14++;
                            } else if (gVar.f35886j) {
                                i25 = i26;
                            }
                            z12 = true;
                            if (z12) {
                                i14++;
                                float f13 = pVar.f35908b.f1614o0[this.f35912f];
                                if (f13 >= 0.0f) {
                                    f10 += f13;
                                }
                            } else {
                                i13 += i25;
                            }
                            if (i32 < i29 && i32 < i10) {
                                i13 += -pVar.f35915i.f35882f;
                            }
                        }
                        i25 = i26;
                        if (z12) {
                        }
                        if (i32 < i29) {
                            i13 += -pVar.f35915i.f35882f;
                        }
                    }
                    i32++;
                    i11 = 8;
                }
                if (i13 < i27 || i14 == 0) {
                    i12 = i33;
                    break;
                } else {
                    i31++;
                    i11 = 8;
                }
            }
            i12 = 0;
            i13 = 0;
            i14 = 0;
            f10 = 0.0f;
            int i36 = this.f35914h.f35883g;
            if (F1) {
                i36 = this.f35915i.f35883g;
            }
            if (i13 > i27) {
                i36 = F1 ? i36 + ((int) (((i13 - i27) / 2.0f) + 0.5f)) : i36 - ((int) (((i13 - i27) / 2.0f) + 0.5f));
            }
            if (i14 > 0) {
                float f14 = i27 - i13;
                int i37 = (int) ((f14 / i14) + 0.5f);
                int i38 = 0;
                int i39 = 0;
                while (i38 < size) {
                    p pVar2 = this.f35867k.get(i38);
                    int i40 = i37;
                    i13 = i13;
                    if (pVar2.f35908b.Q() != 8 && pVar2.f35910d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        g gVar2 = pVar2.f35911e;
                        if (!gVar2.f35886j) {
                            if (f10 > 0.0f) {
                                i21 = i36;
                                i22 = (int) (((pVar2.f35908b.f1614o0[this.f35912f] * f14) / f10) + 0.5f);
                            } else {
                                i21 = i36;
                                i22 = i40;
                            }
                            if (this.f35912f == 0) {
                                ConstraintWidget constraintWidget = pVar2.f35908b;
                                f12 = f14;
                                i24 = constraintWidget.f1626w;
                                i23 = constraintWidget.f1625v;
                                z11 = F1;
                            } else {
                                f12 = f14;
                                ConstraintWidget constraintWidget2 = pVar2.f35908b;
                                i24 = constraintWidget2.f1629z;
                                z11 = F1;
                                i23 = constraintWidget2.f1628y;
                            }
                            i20 = i12;
                            int max = Math.max(i23, pVar2.f35907a == 1 ? Math.min(i22, gVar2.f35889m) : i22);
                            if (i24 > 0) {
                                max = Math.min(i24, max);
                            }
                            if (max != i22) {
                                i39++;
                                i22 = max;
                            }
                            pVar2.f35911e.d(i22);
                            i38++;
                            i37 = i40;
                            i36 = i21;
                            f14 = f12;
                            F1 = z11;
                            i12 = i20;
                        }
                    }
                    z11 = F1;
                    i20 = i12;
                    i21 = i36;
                    f12 = f14;
                    i38++;
                    i37 = i40;
                    i36 = i21;
                    f14 = f12;
                    F1 = z11;
                    i12 = i20;
                }
                z10 = F1;
                i15 = i12;
                i16 = i36;
                i13 = i13;
                if (i39 > 0) {
                    i14 -= i39;
                    int i41 = 0;
                    for (int i42 = 0; i42 < size; i42++) {
                        p pVar3 = this.f35867k.get(i42);
                        if (pVar3.f35908b.Q() != 8) {
                            if (i42 > 0 && i42 >= i28) {
                                i41 += pVar3.f35914h.f35882f;
                            }
                            i41 += pVar3.f35911e.f35883g;
                            if (i42 < i29 && i42 < i10) {
                                i41 += -pVar3.f35915i.f35882f;
                            }
                        }
                    }
                    i13 = i41;
                }
                i17 = 2;
                if (this.f35868l == 2 && i39 == 0) {
                    i18 = 0;
                    this.f35868l = 0;
                } else {
                    i18 = 0;
                }
            } else {
                z10 = F1;
                i15 = i12;
                i16 = i36;
                i18 = 0;
                i17 = 2;
            }
            if (i13 > i27) {
                this.f35868l = i17;
            }
            if (i15 > 0 && i14 == 0 && i28 == i10) {
                this.f35868l = i17;
            }
            int i43 = this.f35868l;
            if (i43 == 1) {
                int i44 = i15;
                if (i44 > 1) {
                    i19 = (i27 - i13) / (i44 - 1);
                } else {
                    i19 = i44 == 1 ? (i27 - i13) / 2 : i18;
                }
                if (i14 > 0) {
                    i19 = i18;
                }
                int i45 = i16;
                for (int i46 = i18; i46 < size; i46++) {
                    p pVar4 = this.f35867k.get(z10 ? size - (i46 + 1) : i46);
                    if (pVar4.f35908b.Q() == 8) {
                        pVar4.f35914h.d(i45);
                        pVar4.f35915i.d(i45);
                    } else {
                        if (i46 > 0) {
                            i45 = z10 ? i45 - i19 : i45 + i19;
                        }
                        if (i46 > 0 && i46 >= i28) {
                            if (z10) {
                                i45 -= pVar4.f35914h.f35882f;
                            } else {
                                i45 += pVar4.f35914h.f35882f;
                            }
                        }
                        if (z10) {
                            pVar4.f35915i.d(i45);
                        } else {
                            pVar4.f35914h.d(i45);
                        }
                        g gVar3 = pVar4.f35911e;
                        int i47 = gVar3.f35883g;
                        if (pVar4.f35910d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && pVar4.f35907a == 1) {
                            i47 = gVar3.f35889m;
                        }
                        i45 = z10 ? i45 - i47 : i45 + i47;
                        if (z10) {
                            pVar4.f35914h.d(i45);
                        } else {
                            pVar4.f35915i.d(i45);
                        }
                        pVar4.f35913g = true;
                        if (i46 < i29 && i46 < i10) {
                            if (z10) {
                                i45 -= -pVar4.f35915i.f35882f;
                            } else {
                                i45 += -pVar4.f35915i.f35882f;
                            }
                        }
                    }
                }
                return;
            }
            int i48 = i15;
            if (i43 == 0) {
                int i49 = (i27 - i13) / (i48 + 1);
                if (i14 > 0) {
                    i49 = i18;
                }
                int i50 = i16;
                for (int i51 = i18; i51 < size; i51++) {
                    p pVar5 = this.f35867k.get(z10 ? size - (i51 + 1) : i51);
                    if (pVar5.f35908b.Q() == 8) {
                        pVar5.f35914h.d(i50);
                        pVar5.f35915i.d(i50);
                    } else {
                        int i52 = z10 ? i50 - i49 : i50 + i49;
                        if (i51 > 0 && i51 >= i28) {
                            if (z10) {
                                i52 -= pVar5.f35914h.f35882f;
                            } else {
                                i52 += pVar5.f35914h.f35882f;
                            }
                        }
                        if (z10) {
                            pVar5.f35915i.d(i52);
                        } else {
                            pVar5.f35914h.d(i52);
                        }
                        g gVar4 = pVar5.f35911e;
                        int i53 = gVar4.f35883g;
                        if (pVar5.f35910d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && pVar5.f35907a == 1) {
                            i53 = Math.min(i53, gVar4.f35889m);
                        }
                        i50 = z10 ? i52 - i53 : i52 + i53;
                        if (z10) {
                            pVar5.f35914h.d(i50);
                        } else {
                            pVar5.f35915i.d(i50);
                        }
                        if (i51 < i29 && i51 < i10) {
                            if (z10) {
                                i50 -= -pVar5.f35915i.f35882f;
                            } else {
                                i50 += -pVar5.f35915i.f35882f;
                            }
                        }
                    }
                }
            } else if (i43 == 2) {
                if (this.f35912f == 0) {
                    f11 = this.f35908b.w();
                } else {
                    f11 = this.f35908b.M();
                }
                if (z10) {
                    f11 = 1.0f - f11;
                }
                int i54 = (int) (((i27 - i13) * f11) + 0.5f);
                if (i54 < 0 || i14 > 0) {
                    i54 = i18;
                }
                int i55 = z10 ? i16 - i54 : i16 + i54;
                for (int i56 = i18; i56 < size; i56++) {
                    p pVar6 = this.f35867k.get(z10 ? size - (i56 + 1) : i56);
                    if (pVar6.f35908b.Q() == 8) {
                        pVar6.f35914h.d(i55);
                        pVar6.f35915i.d(i55);
                    } else {
                        if (i56 > 0 && i56 >= i28) {
                            if (z10) {
                                i55 -= pVar6.f35914h.f35882f;
                            } else {
                                i55 += pVar6.f35914h.f35882f;
                            }
                        }
                        if (z10) {
                            pVar6.f35915i.d(i55);
                        } else {
                            pVar6.f35914h.d(i55);
                        }
                        g gVar5 = pVar6.f35911e;
                        int i57 = gVar5.f35883g;
                        if (pVar6.f35910d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && pVar6.f35907a == 1) {
                            i57 = gVar5.f35889m;
                        }
                        i55 += i57;
                        if (z10) {
                            pVar6.f35914h.d(i55);
                        } else {
                            pVar6.f35915i.d(i55);
                        }
                        if (i56 < i29 && i56 < i10) {
                            if (z10) {
                                i55 -= -pVar6.f35915i.f35882f;
                            } else {
                                i55 += -pVar6.f35915i.f35882f;
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // w.p
    public void d() {
        Iterator<p> it = this.f35867k.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        int size = this.f35867k.size();
        if (size >= 1) {
            ConstraintWidget constraintWidget = this.f35867k.get(0).f35908b;
            ConstraintWidget constraintWidget2 = this.f35867k.get(size - 1).f35908b;
            if (this.f35912f == 0) {
                ConstraintAnchor constraintAnchor = constraintWidget.K;
                ConstraintAnchor constraintAnchor2 = constraintWidget2.M;
                f i10 = i(constraintAnchor, 0);
                int e10 = constraintAnchor.e();
                ConstraintWidget r10 = r();
                if (r10 != null) {
                    e10 = r10.K.e();
                }
                if (i10 != null) {
                    b(this.f35914h, i10, e10);
                }
                f i11 = i(constraintAnchor2, 0);
                int e11 = constraintAnchor2.e();
                ConstraintWidget s10 = s();
                if (s10 != null) {
                    e11 = s10.M.e();
                }
                if (i11 != null) {
                    b(this.f35915i, i11, -e11);
                }
            } else {
                ConstraintAnchor constraintAnchor3 = constraintWidget.L;
                ConstraintAnchor constraintAnchor4 = constraintWidget2.N;
                f i12 = i(constraintAnchor3, 1);
                int e12 = constraintAnchor3.e();
                ConstraintWidget r11 = r();
                if (r11 != null) {
                    e12 = r11.L.e();
                }
                if (i12 != null) {
                    b(this.f35914h, i12, e12);
                }
                f i13 = i(constraintAnchor4, 1);
                int e13 = constraintAnchor4.e();
                ConstraintWidget s11 = s();
                if (s11 != null) {
                    e13 = s11.N.e();
                }
                if (i13 != null) {
                    b(this.f35915i, i13, -e13);
                }
            }
            this.f35914h.f35877a = this;
            this.f35915i.f35877a = this;
        }
    }

    @Override // w.p
    public void e() {
        for (int i10 = 0; i10 < this.f35867k.size(); i10++) {
            this.f35867k.get(i10).e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // w.p
    public void f() {
        this.f35909c = null;
        Iterator<p> it = this.f35867k.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
    }

    @Override // w.p
    public long j() {
        int size = this.f35867k.size();
        long j10 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            p pVar = this.f35867k.get(i10);
            j10 = j10 + pVar.f35914h.f35882f + pVar.j() + pVar.f35915i.f35882f;
        }
        return j10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // w.p
    public boolean m() {
        int size = this.f35867k.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!this.f35867k.get(i10).m()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ChainRun ");
        sb2.append(this.f35912f == 0 ? "horizontal : " : "vertical : ");
        Iterator<p> it = this.f35867k.iterator();
        while (it.hasNext()) {
            sb2.append("<");
            sb2.append(it.next());
            sb2.append("> ");
        }
        return sb2.toString();
    }
}
