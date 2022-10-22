package v;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
/* compiled from: WidgetContainer.java */
/* loaded from: classes.dex */
public class c extends ConstraintWidget {

    /* renamed from: u0  reason: collision with root package name */
    public ArrayList<ConstraintWidget> f35553u0 = new ArrayList<>();

    public void b(ConstraintWidget constraintWidget) {
        this.f35553u0.add(constraintWidget);
        if (constraintWidget.I() != null) {
            ((c) constraintWidget.I()).k1(constraintWidget);
        }
        constraintWidget.T0(this);
    }

    public ArrayList<ConstraintWidget> i1() {
        return this.f35553u0;
    }

    public void j1() {
        ArrayList<ConstraintWidget> arrayList = this.f35553u0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ConstraintWidget constraintWidget = this.f35553u0.get(i10);
                if (constraintWidget instanceof c) {
                    ((c) constraintWidget).j1();
                }
            }
        }
    }

    public void k1(ConstraintWidget constraintWidget) {
        this.f35553u0.remove(constraintWidget);
        constraintWidget.o0();
    }

    public void l1() {
        this.f35553u0.clear();
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void o0() {
        this.f35553u0.clear();
        super.o0();
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void q0(androidx.constraintlayout.core.c cVar) {
        super.q0(cVar);
        int size = this.f35553u0.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f35553u0.get(i10).q0(cVar);
        }
    }
}
