package androidx.constraintlayout.core.widgets;

import java.util.HashSet;
import v.b;
import w.b;
/* compiled from: VirtualLayout.java */
/* loaded from: classes.dex */
public class g extends b {

    /* renamed from: w0  reason: collision with root package name */
    private boolean f1669w0 = false;

    public g() {
        new b.a();
    }

    @Override // v.b, v.a
    public void c(d dVar) {
        k1();
    }

    public void k1() {
        for (int i10 = 0; i10 < this.f35552v0; i10++) {
            ConstraintWidget constraintWidget = this.f35551u0[i10];
            if (constraintWidget != null) {
                constraintWidget.L0(true);
            }
        }
    }

    public boolean l1(HashSet<ConstraintWidget> hashSet) {
        for (int i10 = 0; i10 < this.f35552v0; i10++) {
            if (hashSet.contains(this.f35551u0[i10])) {
                return true;
            }
        }
        return false;
    }

    public boolean m1() {
        return this.f1669w0;
    }
}
