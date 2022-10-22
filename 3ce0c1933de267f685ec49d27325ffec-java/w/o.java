package w;

import androidx.constraintlayout.core.d;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: WidgetGroup.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: f  reason: collision with root package name */
    static int f35901f;

    /* renamed from: b  reason: collision with root package name */
    int f35903b;

    /* renamed from: c  reason: collision with root package name */
    int f35904c;

    /* renamed from: a  reason: collision with root package name */
    ArrayList<ConstraintWidget> f35902a = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    ArrayList<a> f35905d = null;

    /* renamed from: e  reason: collision with root package name */
    private int f35906e = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WidgetGroup.java */
    /* loaded from: classes.dex */
    public class a {
        public a(o oVar, ConstraintWidget constraintWidget, d dVar, int i10) {
            new WeakReference(constraintWidget);
            dVar.x(constraintWidget.K);
            dVar.x(constraintWidget.L);
            dVar.x(constraintWidget.M);
            dVar.x(constraintWidget.N);
            dVar.x(constraintWidget.O);
        }
    }

    public o(int i10) {
        this.f35903b = -1;
        this.f35904c = 0;
        int i11 = f35901f;
        f35901f = i11 + 1;
        this.f35903b = i11;
        this.f35904c = i10;
    }

    private String e() {
        int i10 = this.f35904c;
        return i10 == 0 ? "Horizontal" : i10 == 1 ? "Vertical" : i10 == 2 ? "Both" : "Unknown";
    }

    private int j(d dVar, ArrayList<ConstraintWidget> arrayList, int i10) {
        int x10;
        int x11;
        androidx.constraintlayout.core.widgets.d dVar2 = (androidx.constraintlayout.core.widgets.d) arrayList.get(0).I();
        dVar.D();
        dVar2.g(dVar, false);
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            arrayList.get(i11).g(dVar, false);
        }
        if (i10 == 0 && dVar2.D0 > 0) {
            b.b(dVar2, dVar, arrayList, 0);
        }
        if (i10 == 1 && dVar2.E0 > 0) {
            b.b(dVar2, dVar, arrayList, 1);
        }
        try {
            dVar.z();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        this.f35905d = new ArrayList<>();
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            this.f35905d.add(new a(this, arrayList.get(i12), dVar, i10));
        }
        if (i10 == 0) {
            x10 = dVar.x(dVar2.K);
            x11 = dVar.x(dVar2.M);
            dVar.D();
        } else {
            x10 = dVar.x(dVar2.L);
            x11 = dVar.x(dVar2.N);
            dVar.D();
        }
        return x11 - x10;
    }

    public boolean a(ConstraintWidget constraintWidget) {
        if (this.f35902a.contains(constraintWidget)) {
            return false;
        }
        this.f35902a.add(constraintWidget);
        return true;
    }

    public void b(ArrayList<o> arrayList) {
        int size = this.f35902a.size();
        if (this.f35906e != -1 && size > 0) {
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                o oVar = arrayList.get(i10);
                if (this.f35906e == oVar.f35903b) {
                    g(this.f35904c, oVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public int c() {
        return this.f35903b;
    }

    public int d() {
        return this.f35904c;
    }

    public int f(d dVar, int i10) {
        if (this.f35902a.size() == 0) {
            return 0;
        }
        return j(dVar, this.f35902a, i10);
    }

    public void g(int i10, o oVar) {
        Iterator<ConstraintWidget> it = this.f35902a.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            oVar.a(next);
            if (i10 == 0) {
                next.f1620r0 = oVar.c();
            } else {
                next.f1622s0 = oVar.c();
            }
        }
        this.f35906e = oVar.f35903b;
    }

    public void h(boolean z10) {
    }

    public void i(int i10) {
        this.f35904c = i10;
    }

    public String toString() {
        Iterator<ConstraintWidget> it;
        String str = e() + " [" + this.f35903b + "] <";
        while (this.f35902a.iterator().hasNext()) {
            str = str + " " + it.next().r();
        }
        return str + " >";
    }
}
