package w;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
/* compiled from: WidgetRun.java */
/* loaded from: classes.dex */
public abstract class p implements d {

    /* renamed from: a  reason: collision with root package name */
    public int f35907a;

    /* renamed from: b  reason: collision with root package name */
    ConstraintWidget f35908b;

    /* renamed from: c  reason: collision with root package name */
    m f35909c;

    /* renamed from: d  reason: collision with root package name */
    protected ConstraintWidget.DimensionBehaviour f35910d;

    /* renamed from: e  reason: collision with root package name */
    g f35911e = new g(this);

    /* renamed from: f  reason: collision with root package name */
    public int f35912f = 0;

    /* renamed from: g  reason: collision with root package name */
    boolean f35913g = false;

    /* renamed from: h  reason: collision with root package name */
    public f f35914h = new f(this);

    /* renamed from: i  reason: collision with root package name */
    public f f35915i = new f(this);

    /* renamed from: j  reason: collision with root package name */
    protected b f35916j = b.NONE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WidgetRun.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f35917a;

        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            f35917a = iArr;
            try {
                iArr[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35917a[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35917a[ConstraintAnchor.Type.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35917a[ConstraintAnchor.Type.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f35917a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: WidgetRun.java */
    /* loaded from: classes.dex */
    enum b {
        NONE,
        START,
        END,
        CENTER
    }

    public p(ConstraintWidget constraintWidget) {
        this.f35908b = constraintWidget;
    }

    private void l(int i10, int i11) {
        int i12;
        int i13 = this.f35907a;
        if (i13 == 0) {
            this.f35911e.d(g(i11, i10));
        } else if (i13 == 1) {
            this.f35911e.d(Math.min(g(this.f35911e.f35889m, i10), i11));
        } else if (i13 == 2) {
            ConstraintWidget I = this.f35908b.I();
            if (I != null) {
                g gVar = (i10 == 0 ? I.f1591d : I.f1593e).f35911e;
                if (gVar.f35886j) {
                    ConstraintWidget constraintWidget = this.f35908b;
                    this.f35911e.d(g((int) ((gVar.f35883g * (i10 == 0 ? constraintWidget.f1627x : constraintWidget.A)) + 0.5f), i10));
                }
            }
        } else if (i13 == 3) {
            ConstraintWidget constraintWidget2 = this.f35908b;
            p pVar = constraintWidget2.f1591d;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = pVar.f35910d;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviour == dimensionBehaviour2 && pVar.f35907a == 3) {
                n nVar = constraintWidget2.f1593e;
                if (nVar.f35910d == dimensionBehaviour2 && nVar.f35907a == 3) {
                    return;
                }
            }
            if (i10 == 0) {
                pVar = constraintWidget2.f1593e;
            }
            if (pVar.f35911e.f35886j) {
                float t10 = constraintWidget2.t();
                if (i10 == 1) {
                    i12 = (int) ((pVar.f35911e.f35883g / t10) + 0.5f);
                } else {
                    i12 = (int) ((t10 * pVar.f35911e.f35883g) + 0.5f);
                }
                this.f35911e.d(i12);
            }
        }
    }

    @Override // w.d
    public void a(d dVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(f fVar, f fVar2, int i10) {
        fVar.f35888l.add(fVar2);
        fVar.f35882f = i10;
        fVar2.f35887k.add(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(f fVar, f fVar2, int i10, g gVar) {
        fVar.f35888l.add(fVar2);
        fVar.f35888l.add(this.f35911e);
        fVar.f35884h = i10;
        fVar.f35885i = gVar;
        fVar2.f35887k.add(fVar);
        gVar.f35887k.add(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void e();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void f();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int g(int i10, int i11) {
        int i12;
        if (i11 == 0) {
            ConstraintWidget constraintWidget = this.f35908b;
            int i13 = constraintWidget.f1626w;
            i12 = Math.max(constraintWidget.f1625v, i10);
            if (i13 > 0) {
                i12 = Math.min(i13, i10);
            }
            if (i12 == i10) {
                return i10;
            }
        } else {
            ConstraintWidget constraintWidget2 = this.f35908b;
            int i14 = constraintWidget2.f1629z;
            i12 = Math.max(constraintWidget2.f1628y, i10);
            if (i14 > 0) {
                i12 = Math.min(i14, i10);
            }
            if (i12 == i10) {
                return i10;
            }
        }
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final f h(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f1579f;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.f1577d;
        int i10 = a.f35917a[constraintAnchor2.f1578e.ordinal()];
        if (i10 == 1) {
            return constraintWidget.f1591d.f35914h;
        }
        if (i10 == 2) {
            return constraintWidget.f1591d.f35915i;
        }
        if (i10 == 3) {
            return constraintWidget.f1593e.f35914h;
        }
        if (i10 == 4) {
            return constraintWidget.f1593e.f35898k;
        }
        if (i10 != 5) {
            return null;
        }
        return constraintWidget.f1593e.f35915i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final f i(ConstraintAnchor constraintAnchor, int i10) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f1579f;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.f1577d;
        p pVar = i10 == 0 ? constraintWidget.f1591d : constraintWidget.f1593e;
        int i11 = a.f35917a[constraintAnchor2.f1578e.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 != 5) {
                        return null;
                    }
                }
            }
            return pVar.f35915i;
        }
        return pVar.f35914h;
    }

    public long j() {
        g gVar = this.f35911e;
        if (gVar.f35886j) {
            return gVar.f35883g;
        }
        return 0L;
    }

    public boolean k() {
        return this.f35913g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean m();

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(d dVar, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i10) {
        f h10 = h(constraintAnchor);
        f h11 = h(constraintAnchor2);
        if (h10.f35886j && h11.f35886j) {
            int e10 = h10.f35883g + constraintAnchor.e();
            int e11 = h11.f35883g - constraintAnchor2.e();
            int i11 = e11 - e10;
            if (!this.f35911e.f35886j && this.f35910d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                l(i10, i11);
            }
            g gVar = this.f35911e;
            if (gVar.f35886j) {
                if (gVar.f35883g == i11) {
                    this.f35914h.d(e10);
                    this.f35915i.d(e11);
                    return;
                }
                ConstraintWidget constraintWidget = this.f35908b;
                float w10 = i10 == 0 ? constraintWidget.w() : constraintWidget.M();
                if (h10 == h11) {
                    e10 = h10.f35883g;
                    e11 = h11.f35883g;
                    w10 = 0.5f;
                }
                this.f35914h.d((int) (e10 + 0.5f + (((e11 - e10) - this.f35911e.f35883g) * w10)));
                this.f35915i.d(this.f35914h.f35883g + this.f35911e.f35883g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(d dVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(d dVar) {
    }
}
