package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import w.i;
import w.o;
/* loaded from: classes.dex */
public class ConstraintAnchor {

    /* renamed from: b  reason: collision with root package name */
    private int f1575b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1576c;

    /* renamed from: d  reason: collision with root package name */
    public final ConstraintWidget f1577d;

    /* renamed from: e  reason: collision with root package name */
    public final Type f1578e;

    /* renamed from: f  reason: collision with root package name */
    public ConstraintAnchor f1579f;

    /* renamed from: i  reason: collision with root package name */
    SolverVariable f1582i;

    /* renamed from: a  reason: collision with root package name */
    private HashSet<ConstraintAnchor> f1574a = null;

    /* renamed from: g  reason: collision with root package name */
    public int f1580g = 0;

    /* renamed from: h  reason: collision with root package name */
    int f1581h = Integer.MIN_VALUE;

    /* loaded from: classes.dex */
    public enum Type {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1583a;

        static {
            int[] iArr = new int[Type.values().length];
            f1583a = iArr;
            try {
                iArr[Type.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1583a[Type.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1583a[Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1583a[Type.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1583a[Type.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1583a[Type.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1583a[Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1583a[Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1583a[Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.f1577d = constraintWidget;
        this.f1578e = type;
    }

    public boolean a(ConstraintAnchor constraintAnchor, int i10, int i11, boolean z10) {
        if (constraintAnchor == null) {
            p();
            return true;
        } else if (!z10 && !o(constraintAnchor)) {
            return false;
        } else {
            this.f1579f = constraintAnchor;
            if (constraintAnchor.f1574a == null) {
                constraintAnchor.f1574a = new HashSet<>();
            }
            HashSet<ConstraintAnchor> hashSet = this.f1579f.f1574a;
            if (hashSet != null) {
                hashSet.add(this);
            }
            this.f1580g = i10;
            this.f1581h = i11;
            return true;
        }
    }

    public void b(int i10, ArrayList<o> arrayList, o oVar) {
        HashSet<ConstraintAnchor> hashSet = this.f1574a;
        if (hashSet != null) {
            Iterator<ConstraintAnchor> it = hashSet.iterator();
            while (it.hasNext()) {
                i.a(it.next().f1577d, i10, arrayList, oVar);
            }
        }
    }

    public HashSet<ConstraintAnchor> c() {
        return this.f1574a;
    }

    public int d() {
        if (!this.f1576c) {
            return 0;
        }
        return this.f1575b;
    }

    public int e() {
        ConstraintAnchor constraintAnchor;
        if (this.f1577d.Q() == 8) {
            return 0;
        }
        if (this.f1581h == Integer.MIN_VALUE || (constraintAnchor = this.f1579f) == null || constraintAnchor.f1577d.Q() != 8) {
            return this.f1580g;
        }
        return this.f1581h;
    }

    public final ConstraintAnchor f() {
        switch (a.f1583a[this.f1578e.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
            case 2:
                return this.f1577d.M;
            case 3:
                return this.f1577d.K;
            case 4:
                return this.f1577d.N;
            case 5:
                return this.f1577d.L;
            default:
                throw new AssertionError(this.f1578e.name());
        }
    }

    public ConstraintWidget g() {
        return this.f1577d;
    }

    public SolverVariable h() {
        return this.f1582i;
    }

    public ConstraintAnchor i() {
        return this.f1579f;
    }

    public Type j() {
        return this.f1578e;
    }

    public boolean k() {
        HashSet<ConstraintAnchor> hashSet = this.f1574a;
        if (hashSet == null) {
            return false;
        }
        Iterator<ConstraintAnchor> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().f().n()) {
                return true;
            }
        }
        return false;
    }

    public boolean l() {
        HashSet<ConstraintAnchor> hashSet = this.f1574a;
        return hashSet != null && hashSet.size() > 0;
    }

    public boolean m() {
        return this.f1576c;
    }

    public boolean n() {
        return this.f1579f != null;
    }

    public boolean o(ConstraintAnchor constraintAnchor) {
        boolean z10 = false;
        if (constraintAnchor == null) {
            return false;
        }
        Type j10 = constraintAnchor.j();
        Type type = this.f1578e;
        if (j10 == type) {
            return type != Type.BASELINE || (constraintAnchor.g().U() && g().U());
        }
        switch (a.f1583a[type.ordinal()]) {
            case 1:
                return (j10 == Type.BASELINE || j10 == Type.CENTER_X || j10 == Type.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z11 = j10 == Type.LEFT || j10 == Type.RIGHT;
                if (!(constraintAnchor.g() instanceof e)) {
                    return z11;
                }
                if (z11 || j10 == Type.CENTER_X) {
                    z10 = true;
                }
                return z10;
            case 4:
            case 5:
                boolean z12 = j10 == Type.TOP || j10 == Type.BOTTOM;
                if (!(constraintAnchor.g() instanceof e)) {
                    return z12;
                }
                if (z12 || j10 == Type.CENTER_Y) {
                    z10 = true;
                }
                return z10;
            case 6:
                return (j10 == Type.LEFT || j10 == Type.RIGHT) ? false : true;
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.f1578e.name());
        }
    }

    public void p() {
        HashSet<ConstraintAnchor> hashSet;
        ConstraintAnchor constraintAnchor = this.f1579f;
        if (!(constraintAnchor == null || (hashSet = constraintAnchor.f1574a) == null)) {
            hashSet.remove(this);
            if (this.f1579f.f1574a.size() == 0) {
                this.f1579f.f1574a = null;
            }
        }
        this.f1574a = null;
        this.f1579f = null;
        this.f1580g = 0;
        this.f1581h = Integer.MIN_VALUE;
        this.f1576c = false;
        this.f1575b = 0;
    }

    public void q() {
        this.f1576c = false;
        this.f1575b = 0;
    }

    public void r(c cVar) {
        SolverVariable solverVariable = this.f1582i;
        if (solverVariable == null) {
            this.f1582i = new SolverVariable(SolverVariable.Type.UNRESTRICTED, null);
        } else {
            solverVariable.e();
        }
    }

    public void s(int i10) {
        this.f1575b = i10;
        this.f1576c = true;
    }

    public String toString() {
        return this.f1577d.r() + ":" + this.f1578e.toString();
    }
}
