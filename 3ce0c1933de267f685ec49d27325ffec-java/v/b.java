package v;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.d;
import java.util.ArrayList;
import java.util.Arrays;
import w.i;
import w.o;
/* compiled from: HelperWidget.java */
/* loaded from: classes.dex */
public class b extends ConstraintWidget implements a {

    /* renamed from: u0  reason: collision with root package name */
    public ConstraintWidget[] f35551u0 = new ConstraintWidget[4];

    /* renamed from: v0  reason: collision with root package name */
    public int f35552v0 = 0;

    @Override // v.a
    public void a() {
        this.f35552v0 = 0;
        Arrays.fill(this.f35551u0, (Object) null);
    }

    @Override // v.a
    public void b(ConstraintWidget constraintWidget) {
        if (constraintWidget != this && constraintWidget != null) {
            int i10 = this.f35552v0 + 1;
            ConstraintWidget[] constraintWidgetArr = this.f35551u0;
            if (i10 > constraintWidgetArr.length) {
                this.f35551u0 = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
            }
            ConstraintWidget[] constraintWidgetArr2 = this.f35551u0;
            int i11 = this.f35552v0;
            constraintWidgetArr2[i11] = constraintWidget;
            this.f35552v0 = i11 + 1;
        }
    }

    public void c(d dVar) {
    }

    public void i1(ArrayList<o> arrayList, int i10, o oVar) {
        for (int i11 = 0; i11 < this.f35552v0; i11++) {
            oVar.a(this.f35551u0[i11]);
        }
        for (int i12 = 0; i12 < this.f35552v0; i12++) {
            i.a(this.f35551u0[i12], i10, arrayList, oVar);
        }
    }

    public int j1(int i10) {
        int i11;
        int i12;
        for (int i13 = 0; i13 < this.f35552v0; i13++) {
            ConstraintWidget constraintWidget = this.f35551u0[i13];
            if (i10 == 0 && (i12 = constraintWidget.f1620r0) != -1) {
                return i12;
            }
            if (i10 == 1 && (i11 = constraintWidget.f1622s0) != -1) {
                return i11;
            }
        }
        return -1;
    }
}
