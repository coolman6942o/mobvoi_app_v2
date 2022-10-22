package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.d;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import w.c;
import w.f;
import w.l;
import w.n;
import w.p;
/* loaded from: classes.dex */
public class ConstraintWidget {

    /* renamed from: t0  reason: collision with root package name */
    public static float f1584t0 = 0.5f;
    private boolean G;
    public ConstraintAnchor R;
    public ConstraintAnchor[] S;
    public DimensionBehaviour[] V;

    /* renamed from: b  reason: collision with root package name */
    public c f1587b;

    /* renamed from: c  reason: collision with root package name */
    public c f1589c;

    /* renamed from: e0  reason: collision with root package name */
    protected int f1594e0;

    /* renamed from: f0  reason: collision with root package name */
    protected int f1596f0;

    /* renamed from: g0  reason: collision with root package name */
    float f1598g0;

    /* renamed from: h0  reason: collision with root package name */
    float f1600h0;

    /* renamed from: i0  reason: collision with root package name */
    private Object f1602i0;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1585a = false;

    /* renamed from: d  reason: collision with root package name */
    public l f1591d = null;

    /* renamed from: e  reason: collision with root package name */
    public n f1593e = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean[] f1595f = {true, true};

    /* renamed from: g  reason: collision with root package name */
    private boolean f1597g = true;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1599h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1601i = true;

    /* renamed from: j  reason: collision with root package name */
    private int f1603j = -1;

    /* renamed from: k  reason: collision with root package name */
    private int f1605k = -1;

    /* renamed from: l  reason: collision with root package name */
    private boolean f1607l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f1609m = false;

    /* renamed from: n  reason: collision with root package name */
    private boolean f1611n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f1613o = false;

    /* renamed from: p  reason: collision with root package name */
    public int f1615p = -1;

    /* renamed from: q  reason: collision with root package name */
    public int f1617q = -1;

    /* renamed from: r  reason: collision with root package name */
    private int f1619r = 0;

    /* renamed from: s  reason: collision with root package name */
    public int f1621s = 0;

    /* renamed from: t  reason: collision with root package name */
    public int f1623t = 0;

    /* renamed from: u  reason: collision with root package name */
    public int[] f1624u = new int[2];

    /* renamed from: v  reason: collision with root package name */
    public int f1625v = 0;

    /* renamed from: w  reason: collision with root package name */
    public int f1626w = 0;

    /* renamed from: x  reason: collision with root package name */
    public float f1627x = 1.0f;

    /* renamed from: y  reason: collision with root package name */
    public int f1628y = 0;

    /* renamed from: z  reason: collision with root package name */
    public int f1629z = 0;
    public float A = 1.0f;
    int B = -1;
    float C = 1.0f;
    private int[] D = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    private float E = 0.0f;
    private boolean F = false;
    private boolean H = false;
    private int I = 0;
    private int J = 0;
    public ConstraintAnchor K = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
    public ConstraintAnchor L = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
    public ConstraintAnchor M = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
    public ConstraintAnchor N = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
    public ConstraintAnchor O = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
    ConstraintAnchor P = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
    ConstraintAnchor Q = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
    protected ArrayList<ConstraintAnchor> T = new ArrayList<>();
    private boolean[] U = new boolean[2];
    public ConstraintWidget W = null;
    int X = 0;
    int Y = 0;
    public float Z = 0.0f;

    /* renamed from: a0  reason: collision with root package name */
    protected int f1586a0 = -1;

    /* renamed from: b0  reason: collision with root package name */
    protected int f1588b0 = 0;

    /* renamed from: c0  reason: collision with root package name */
    protected int f1590c0 = 0;

    /* renamed from: d0  reason: collision with root package name */
    int f1592d0 = 0;

    /* renamed from: j0  reason: collision with root package name */
    private int f1604j0 = 0;

    /* renamed from: k0  reason: collision with root package name */
    private String f1606k0 = null;

    /* renamed from: l0  reason: collision with root package name */
    private String f1608l0 = null;

    /* renamed from: m0  reason: collision with root package name */
    int f1610m0 = 0;

    /* renamed from: n0  reason: collision with root package name */
    int f1612n0 = 0;

    /* renamed from: o0  reason: collision with root package name */
    public float[] f1614o0 = {-1.0f, -1.0f};

    /* renamed from: p0  reason: collision with root package name */
    protected ConstraintWidget[] f1616p0 = {null, null};

    /* renamed from: q0  reason: collision with root package name */
    protected ConstraintWidget[] f1618q0 = {null, null};

    /* renamed from: r0  reason: collision with root package name */
    public int f1620r0 = -1;

    /* renamed from: s0  reason: collision with root package name */
    public int f1622s0 = -1;

    /* loaded from: classes.dex */
    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1630a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f1631b;

        static {
            int[] iArr = new int[DimensionBehaviour.values().length];
            f1631b = iArr;
            try {
                iArr[DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1631b[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1631b[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1631b[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ConstraintAnchor.Type.values().length];
            f1630a = iArr2;
            try {
                iArr2[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1630a[ConstraintAnchor.Type.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1630a[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1630a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1630a[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1630a[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1630a[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f1630a[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f1630a[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public ConstraintWidget() {
        new u.a(this);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.R = constraintAnchor;
        this.S = new ConstraintAnchor[]{this.K, this.M, this.L, this.N, this.O, constraintAnchor};
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.V = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        float f10 = f1584t0;
        this.f1598g0 = f10;
        this.f1600h0 = f10;
        d();
    }

    private boolean a0(int i10) {
        int i11 = i10 * 2;
        ConstraintAnchor[] constraintAnchorArr = this.S;
        if (!(constraintAnchorArr[i11].f1579f == null || constraintAnchorArr[i11].f1579f.f1579f == constraintAnchorArr[i11])) {
            int i12 = i11 + 1;
            if (constraintAnchorArr[i12].f1579f != null && constraintAnchorArr[i12].f1579f.f1579f == constraintAnchorArr[i12]) {
                return true;
            }
        }
        return false;
    }

    private void d() {
        this.T.add(this.K);
        this.T.add(this.L);
        this.T.add(this.M);
        this.T.add(this.N);
        this.T.add(this.P);
        this.T.add(this.Q);
        this.T.add(this.R);
        this.T.add(this.O);
    }

    /* JADX WARN: Code restructure failed: missing block: B:263:0x049c, code lost:
        if ((r4 instanceof androidx.constraintlayout.core.widgets.a) != false) goto L265;
     */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01e8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x04be  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x04e2  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x052d  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x053f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:331:0x055b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0592 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:378:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:381:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void i(d dVar, boolean z10, boolean z11, boolean z12, boolean z13, SolverVariable solverVariable, SolverVariable solverVariable2, DimensionBehaviour dimensionBehaviour, boolean z14, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i10, int i11, int i12, int i13, float f10, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19, int i14, int i15, int i16, int i17, float f11, boolean z20) {
        boolean z21;
        int i18;
        int i19;
        int i20;
        SolverVariable solverVariable3;
        int i21;
        boolean z22;
        int i22;
        boolean z23;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        SolverVariable solverVariable6;
        int i23;
        ConstraintAnchor constraintAnchor3;
        boolean z24;
        int i24;
        SolverVariable solverVariable7;
        int i25;
        ConstraintWidget constraintWidget;
        boolean z25;
        boolean z26;
        boolean z27;
        int i26;
        int i27;
        int i28;
        char c10;
        int i29;
        boolean z28;
        SolverVariable solverVariable8;
        char c11;
        boolean z29;
        SolverVariable solverVariable9;
        SolverVariable solverVariable10;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        boolean z30;
        int i30;
        int i31;
        boolean z31;
        SolverVariable solverVariable11;
        ConstraintWidget constraintWidget5;
        ConstraintWidget constraintWidget6;
        int i32;
        int i33;
        ConstraintWidget constraintWidget7;
        int i34;
        int i35;
        int i36;
        SolverVariable solverVariable12;
        int i37;
        boolean z32;
        int i38;
        int i39;
        boolean z33;
        boolean z34;
        boolean z35;
        int i40;
        int i41;
        ConstraintWidget constraintWidget8;
        int i42;
        SolverVariable solverVariable13;
        SolverVariable solverVariable14;
        int i43 = i17;
        SolverVariable q5 = dVar.q(constraintAnchor);
        SolverVariable q10 = dVar.q(constraintAnchor2);
        SolverVariable q11 = dVar.q(constraintAnchor.i());
        SolverVariable q12 = dVar.q(constraintAnchor2.i());
        d.w();
        boolean n10 = constraintAnchor.n();
        boolean n11 = constraintAnchor2.n();
        boolean n12 = this.R.n();
        int i44 = n11 ? (n10 ? 1 : 0) + 1 : n10 ? 1 : 0;
        if (n12) {
            i44++;
        }
        int i45 = z15 ? 3 : i14;
        int i46 = a.f1631b[dimensionBehaviour.ordinal()];
        if (i46 == 1 || i46 == 2 || i46 == 3 || i46 != 4) {
            i18 = i45;
        } else {
            i18 = i45;
            if (i18 != 4) {
                z21 = true;
                i19 = this.f1603j;
                if (i19 != -1 && z10) {
                    this.f1603j = -1;
                    i11 = i19;
                    z21 = false;
                }
                i20 = this.f1605k;
                if (i20 != -1 || z10) {
                    i20 = i11;
                } else {
                    this.f1605k = -1;
                    z21 = false;
                }
                int i47 = i20;
                if (this.f1604j0 != 8) {
                    i47 = 0;
                    z21 = false;
                }
                if (!z20) {
                    if (!n10 && !n11 && !n12) {
                        dVar.f(q5, i10);
                    } else if (n10 && !n11) {
                        solverVariable3 = q12;
                        i21 = 8;
                        dVar.e(q5, q11, constraintAnchor.e(), 8);
                    }
                    solverVariable3 = q12;
                    i21 = 8;
                } else {
                    solverVariable3 = q12;
                    i21 = 8;
                }
                if (z21) {
                    if (z14) {
                        dVar.e(q10, q5, 0, 3);
                        if (i12 > 0) {
                            dVar.h(q10, q5, i12, 8);
                        }
                        if (i13 < Integer.MAX_VALUE) {
                            dVar.j(q10, q5, i13, 8);
                        }
                    } else {
                        dVar.e(q10, q5, i47, i21);
                    }
                    i23 = i44;
                    solverVariable6 = q11;
                    solverVariable5 = q10;
                    z22 = z21;
                    solverVariable4 = solverVariable3;
                    z23 = z13;
                } else if (i44 == 2 || z15 || !(i18 == 1 || i18 == 0)) {
                    int i48 = i16 == -2 ? i47 : i16;
                    int i49 = i43 == -2 ? i47 : i43;
                    if (i47 > 0 && i18 != 1) {
                        i47 = 0;
                    }
                    if (i48 > 0) {
                        dVar.h(q10, q5, i48, 8);
                        i47 = Math.max(i47, i48);
                    }
                    if (i49 > 0) {
                        if (!z11 || i18 != 1) {
                            i42 = 8;
                            dVar.j(q10, q5, i49, 8);
                        } else {
                            i42 = 8;
                        }
                        i47 = Math.min(i47, i49);
                    } else {
                        i42 = 8;
                    }
                    if (i18 == 1) {
                        if (z11) {
                            dVar.e(q10, q5, i47, i42);
                        } else if (z17) {
                            dVar.e(q10, q5, i47, 5);
                            dVar.j(q10, q5, i47, i42);
                        } else {
                            dVar.e(q10, q5, i47, 5);
                            dVar.j(q10, q5, i47, i42);
                        }
                        i43 = i49;
                        i23 = i44;
                        solverVariable5 = q10;
                        z22 = z21;
                        solverVariable4 = solverVariable3;
                        z23 = z13;
                        i22 = i48;
                        solverVariable6 = q11;
                    } else if (i18 == 2) {
                        ConstraintAnchor.Type j10 = constraintAnchor.j();
                        ConstraintAnchor.Type type = ConstraintAnchor.Type.TOP;
                        if (j10 == type || constraintAnchor.j() == ConstraintAnchor.Type.BOTTOM) {
                            solverVariable14 = dVar.q(this.W.m(type));
                            solverVariable13 = dVar.q(this.W.m(ConstraintAnchor.Type.BOTTOM));
                        } else {
                            solverVariable14 = dVar.q(this.W.m(ConstraintAnchor.Type.LEFT));
                            solverVariable13 = dVar.q(this.W.m(ConstraintAnchor.Type.RIGHT));
                        }
                        SolverVariable solverVariable15 = solverVariable13;
                        i43 = i49;
                        i23 = i44;
                        solverVariable4 = solverVariable3;
                        i22 = i48;
                        solverVariable6 = q11;
                        solverVariable5 = q10;
                        dVar.d(dVar.r().k(q10, q5, solverVariable15, solverVariable14, f11));
                        if (z11) {
                            z21 = false;
                        }
                        z22 = z21;
                        z23 = z13;
                    } else {
                        i43 = i49;
                        i22 = i48;
                        i23 = i44;
                        solverVariable6 = q11;
                        solverVariable5 = q10;
                        solverVariable4 = solverVariable3;
                        z22 = z21;
                        z23 = true;
                    }
                    if (!z20 && !z17) {
                        if (n10 || n11 || n12) {
                            if (!n10 || n11) {
                                if (n10 || !n11) {
                                    i24 = 0;
                                    if (!n10 || !n11) {
                                        solverVariable7 = solverVariable4;
                                        i25 = 5;
                                    } else {
                                        ConstraintWidget constraintWidget9 = constraintAnchor.f1579f.f1577d;
                                        ConstraintWidget constraintWidget10 = constraintAnchor2.f1579f.f1577d;
                                        ConstraintWidget I = I();
                                        if (z22) {
                                            if (i18 == 0) {
                                                if (i43 != 0 || i22 != 0) {
                                                    z34 = false;
                                                    i41 = 5;
                                                    i40 = 5;
                                                    z35 = true;
                                                    z33 = true;
                                                } else if (!solverVariable6.f1494g || !solverVariable4.f1494g) {
                                                    i41 = 8;
                                                    i40 = 8;
                                                    z35 = false;
                                                    z33 = false;
                                                    z34 = true;
                                                } else {
                                                    dVar.e(q5, solverVariable6, constraintAnchor.e(), 8);
                                                    dVar.e(solverVariable5, solverVariable4, -constraintAnchor2.e(), 8);
                                                    return;
                                                }
                                                if ((constraintWidget9 instanceof androidx.constraintlayout.core.widgets.a) || (constraintWidget10 instanceof androidx.constraintlayout.core.widgets.a)) {
                                                    solverVariable8 = solverVariable2;
                                                    i28 = 6;
                                                    z26 = z35;
                                                    z25 = z34;
                                                    z27 = z33;
                                                    z28 = true;
                                                    i29 = 8;
                                                    c10 = 5;
                                                    i27 = 4;
                                                } else {
                                                    solverVariable8 = solverVariable2;
                                                    i28 = 6;
                                                    i27 = i40;
                                                    z26 = z35;
                                                    z25 = z34;
                                                    z27 = z33;
                                                    z28 = true;
                                                    i29 = 8;
                                                    c10 = 5;
                                                }
                                                i26 = i41;
                                                c11 = 3;
                                            } else {
                                                i29 = 8;
                                                if (i18 == 2) {
                                                    if ((constraintWidget9 instanceof androidx.constraintlayout.core.widgets.a) || (constraintWidget10 instanceof androidx.constraintlayout.core.widgets.a)) {
                                                        solverVariable8 = solverVariable2;
                                                        z25 = false;
                                                        i28 = 6;
                                                        c11 = 3;
                                                        z28 = true;
                                                        c10 = 5;
                                                        i27 = 4;
                                                    } else {
                                                        solverVariable8 = solverVariable2;
                                                        z25 = false;
                                                        i28 = 6;
                                                        c11 = 3;
                                                        z28 = true;
                                                        c10 = 5;
                                                        i27 = 5;
                                                    }
                                                    i26 = 5;
                                                } else if (i18 == 1) {
                                                    solverVariable8 = solverVariable2;
                                                    z25 = false;
                                                    i28 = 6;
                                                    i26 = 8;
                                                    c11 = 3;
                                                    z28 = true;
                                                    c10 = 5;
                                                    i27 = 4;
                                                } else {
                                                    c11 = 3;
                                                    if (i18 != 3) {
                                                        z28 = true;
                                                        solverVariable8 = solverVariable2;
                                                        i28 = 6;
                                                        c10 = 5;
                                                        i27 = 4;
                                                        i26 = 5;
                                                        z27 = false;
                                                        z26 = false;
                                                    } else if (this.B == -1) {
                                                        if (z18) {
                                                            solverVariable8 = solverVariable2;
                                                            i26 = 8;
                                                            c11 = 3;
                                                            z28 = true;
                                                            c10 = 5;
                                                            i28 = z11 ? 5 : 4;
                                                        } else {
                                                            solverVariable8 = solverVariable2;
                                                            i28 = 8;
                                                            i26 = 8;
                                                            c11 = 3;
                                                            z28 = true;
                                                            c10 = 5;
                                                        }
                                                        i27 = 5;
                                                        z27 = true;
                                                        z26 = true;
                                                        z25 = true;
                                                    } else if (z15) {
                                                        if (i15 != 2) {
                                                            z28 = true;
                                                            if (i15 != 1) {
                                                                z32 = false;
                                                                if (z32) {
                                                                    i39 = 8;
                                                                    i38 = 5;
                                                                } else {
                                                                    i39 = 5;
                                                                    i38 = 4;
                                                                }
                                                                i26 = i39;
                                                                i27 = i38;
                                                                z27 = z28;
                                                                z26 = z27;
                                                                z25 = z26;
                                                                i28 = 6;
                                                                c11 = 3;
                                                                c10 = 5;
                                                                solverVariable8 = solverVariable2;
                                                            }
                                                        } else {
                                                            z28 = true;
                                                        }
                                                        z32 = z28;
                                                        if (z32) {
                                                        }
                                                        i26 = i39;
                                                        i27 = i38;
                                                        z27 = z28;
                                                        z26 = z27;
                                                        z25 = z26;
                                                        i28 = 6;
                                                        c11 = 3;
                                                        c10 = 5;
                                                        solverVariable8 = solverVariable2;
                                                    } else {
                                                        z28 = true;
                                                        if (i43 > 0) {
                                                            solverVariable8 = solverVariable2;
                                                            z27 = true;
                                                            z26 = true;
                                                            z25 = true;
                                                            i28 = 6;
                                                            c11 = 3;
                                                            c10 = 5;
                                                            i27 = 5;
                                                        } else if (i43 != 0 || i22 != 0) {
                                                            solverVariable8 = solverVariable2;
                                                            z27 = true;
                                                            z26 = true;
                                                            z25 = true;
                                                            i28 = 6;
                                                            c11 = 3;
                                                            c10 = 5;
                                                            i27 = 4;
                                                        } else if (!z18) {
                                                            solverVariable8 = solverVariable2;
                                                            z27 = true;
                                                            z26 = true;
                                                            z25 = true;
                                                            i28 = 6;
                                                            i27 = 8;
                                                            c11 = 3;
                                                            c10 = 5;
                                                        } else {
                                                            solverVariable8 = solverVariable2;
                                                            i26 = (constraintWidget9 == I || constraintWidget10 == I) ? 5 : 4;
                                                            z27 = true;
                                                            z26 = true;
                                                            z25 = true;
                                                            i28 = 6;
                                                            c11 = 3;
                                                            c10 = 5;
                                                            i27 = 4;
                                                        }
                                                        i26 = 5;
                                                    }
                                                }
                                                z27 = true;
                                                z26 = true;
                                            }
                                            if (z27 || solverVariable6 != solverVariable4 || constraintWidget9 == I) {
                                                z29 = z28;
                                            } else {
                                                z27 = false;
                                                z29 = false;
                                            }
                                            if (!z26) {
                                                if (z22 || z16 || z18 || solverVariable6 != solverVariable || solverVariable4 != solverVariable8) {
                                                    i36 = i28;
                                                    z24 = z11;
                                                } else {
                                                    i26 = i29;
                                                    i36 = i26;
                                                    z24 = false;
                                                    z29 = false;
                                                }
                                                solverVariable9 = solverVariable6;
                                                i31 = i29;
                                                i30 = 4;
                                                z30 = z28;
                                                constraintWidget4 = I;
                                                constraintWidget3 = constraintWidget10;
                                                constraintWidget2 = constraintWidget9;
                                                solverVariable10 = q5;
                                                dVar.c(q5, solverVariable9, constraintAnchor.e(), f10, solverVariable4, solverVariable5, constraintAnchor2.e(), i36);
                                            } else {
                                                solverVariable9 = solverVariable6;
                                                constraintWidget4 = I;
                                                constraintWidget3 = constraintWidget10;
                                                z30 = z28;
                                                constraintWidget2 = constraintWidget9;
                                                solverVariable10 = q5;
                                                i31 = i29;
                                                i30 = 4;
                                                z24 = z11;
                                            }
                                            z31 = z29;
                                            if (this.f1604j0 == i31 || constraintAnchor2.l()) {
                                                SolverVariable solverVariable16 = solverVariable9;
                                                if (!z27) {
                                                    if (!z24 || solverVariable16 == solverVariable4 || z22) {
                                                        constraintWidget5 = constraintWidget3;
                                                        constraintWidget6 = constraintWidget2;
                                                    } else {
                                                        constraintWidget6 = constraintWidget2;
                                                        if (!(constraintWidget6 instanceof androidx.constraintlayout.core.widgets.a)) {
                                                            constraintWidget5 = constraintWidget3;
                                                        } else {
                                                            constraintWidget5 = constraintWidget3;
                                                        }
                                                        i35 = 6;
                                                        solverVariable11 = solverVariable10;
                                                        dVar.h(solverVariable11, solverVariable16, constraintAnchor.e(), i35);
                                                        dVar.j(solverVariable5, solverVariable4, -constraintAnchor2.e(), i35);
                                                        i26 = i35;
                                                    }
                                                    i35 = i26;
                                                    solverVariable11 = solverVariable10;
                                                    dVar.h(solverVariable11, solverVariable16, constraintAnchor.e(), i35);
                                                    dVar.j(solverVariable5, solverVariable4, -constraintAnchor2.e(), i35);
                                                    i26 = i35;
                                                } else {
                                                    constraintWidget5 = constraintWidget3;
                                                    constraintWidget6 = constraintWidget2;
                                                    solverVariable11 = solverVariable10;
                                                }
                                                if (z24 || !z19 || (constraintWidget6 instanceof androidx.constraintlayout.core.widgets.a) || (constraintWidget5 instanceof androidx.constraintlayout.core.widgets.a)) {
                                                    constraintWidget7 = constraintWidget4;
                                                } else {
                                                    constraintWidget7 = constraintWidget4;
                                                    if (constraintWidget5 != constraintWidget7) {
                                                        i33 = 6;
                                                        i32 = 6;
                                                        z31 = z30;
                                                        if (z31) {
                                                            if (!z25 || (z18 && !z12)) {
                                                                i34 = i33;
                                                            } else {
                                                                int i50 = (constraintWidget6 == constraintWidget7 || constraintWidget5 == constraintWidget7) ? 6 : i33;
                                                                if ((constraintWidget6 instanceof e) || (constraintWidget5 instanceof e)) {
                                                                    i50 = 5;
                                                                }
                                                                if ((constraintWidget6 instanceof androidx.constraintlayout.core.widgets.a) || (constraintWidget5 instanceof androidx.constraintlayout.core.widgets.a)) {
                                                                    i50 = 5;
                                                                }
                                                                if (z18) {
                                                                    i50 = 5;
                                                                }
                                                                i34 = Math.max(i50, i33);
                                                            }
                                                            if (z24) {
                                                                i34 = Math.min(i32, i34);
                                                                if (z15 && !z18 && (constraintWidget6 == constraintWidget7 || constraintWidget5 == constraintWidget7)) {
                                                                    i34 = i30;
                                                                }
                                                            }
                                                            dVar.e(solverVariable11, solverVariable16, constraintAnchor.e(), i34);
                                                            dVar.e(solverVariable5, solverVariable4, -constraintAnchor2.e(), i34);
                                                        }
                                                        if (z24) {
                                                            int e10 = solverVariable == solverVariable16 ? constraintAnchor.e() : 0;
                                                            if (solverVariable16 != solverVariable) {
                                                                i25 = 5;
                                                                dVar.h(solverVariable11, solverVariable, e10, 5);
                                                                if (z24 && z22) {
                                                                    solverVariable7 = solverVariable4;
                                                                    if (i12 == 0 && i22 == 0) {
                                                                        if (z22 || i18 != 3) {
                                                                            i24 = 0;
                                                                            dVar.h(solverVariable5, solverVariable11, 0, i25);
                                                                        } else {
                                                                            i24 = 0;
                                                                            dVar.h(solverVariable5, solverVariable11, 0, i31);
                                                                        }
                                                                        if (!z24 && z23) {
                                                                            if (constraintAnchor2.f1579f != null) {
                                                                                i24 = constraintAnchor2.e();
                                                                            }
                                                                            if (solverVariable7 == solverVariable2) {
                                                                                return;
                                                                            }
                                                                            if (!this.f1599h || !solverVariable5.f1494g || (constraintWidget = this.W) == null) {
                                                                                dVar.h(solverVariable2, solverVariable5, i24, i25);
                                                                                return;
                                                                            }
                                                                            d dVar2 = (d) constraintWidget;
                                                                            if (z10) {
                                                                                dVar2.p1(constraintAnchor2);
                                                                                return;
                                                                            } else {
                                                                                dVar2.u1(constraintAnchor2);
                                                                                return;
                                                                            }
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    }
                                                                    i24 = 0;
                                                                    if (!z24) {
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                            }
                                                        }
                                                        i25 = 5;
                                                        if (z24) {
                                                            solverVariable7 = solverVariable4;
                                                            if (i12 == 0) {
                                                                if (z22) {
                                                                }
                                                                i24 = 0;
                                                                dVar.h(solverVariable5, solverVariable11, 0, i25);
                                                                if (!z24) {
                                                                }
                                                            }
                                                            i24 = 0;
                                                            if (!z24) {
                                                            }
                                                        }
                                                    }
                                                }
                                                i33 = i27;
                                                i32 = i26;
                                                if (z31) {
                                                }
                                                if (z24) {
                                                }
                                                i25 = 5;
                                                if (z24) {
                                                }
                                            } else {
                                                return;
                                            }
                                        } else {
                                            z28 = true;
                                            i29 = 8;
                                            if (!solverVariable6.f1494g || !solverVariable4.f1494g) {
                                                solverVariable8 = solverVariable2;
                                                c11 = 3;
                                                c10 = 5;
                                                z27 = true;
                                                z26 = true;
                                                i28 = 6;
                                                i26 = 5;
                                                i27 = 4;
                                            } else {
                                                dVar.c(q5, solverVariable6, constraintAnchor.e(), f10, solverVariable4, solverVariable5, constraintAnchor2.e(), 8);
                                                if (z11 && z23) {
                                                    if (constraintAnchor2.f1579f != null) {
                                                        i37 = constraintAnchor2.e();
                                                        solverVariable12 = solverVariable2;
                                                    } else {
                                                        solverVariable12 = solverVariable2;
                                                        i37 = 0;
                                                    }
                                                    if (solverVariable4 != solverVariable12) {
                                                        dVar.h(solverVariable12, solverVariable5, i37, 5);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        z25 = false;
                                        if (z27) {
                                        }
                                        z29 = z28;
                                        if (!z26) {
                                        }
                                        z31 = z29;
                                        if (this.f1604j0 == i31) {
                                        }
                                        SolverVariable solverVariable162 = solverVariable9;
                                        if (!z27) {
                                        }
                                        if (z24) {
                                        }
                                        constraintWidget7 = constraintWidget4;
                                        i33 = i27;
                                        i32 = i26;
                                        if (z31) {
                                        }
                                        if (z24) {
                                        }
                                        i25 = 5;
                                        if (z24) {
                                        }
                                    }
                                } else {
                                    dVar.e(solverVariable5, solverVariable4, -constraintAnchor2.e(), 8);
                                    if (z11) {
                                        if (!this.f1599h || !q5.f1494g || (constraintWidget8 = this.W) == null) {
                                            i25 = 5;
                                            i24 = 0;
                                            dVar.h(q5, solverVariable, 0, 5);
                                            solverVariable7 = solverVariable4;
                                        } else {
                                            d dVar3 = (d) constraintWidget8;
                                            if (z10) {
                                                dVar3.q1(constraintAnchor);
                                            } else {
                                                dVar3.v1(constraintAnchor);
                                            }
                                        }
                                    }
                                }
                                z24 = z11;
                                if (!z24) {
                                }
                            } else {
                                z24 = z11;
                                i25 = (!z11 || !(constraintAnchor.f1579f.f1577d instanceof androidx.constraintlayout.core.widgets.a)) ? 5 : 8;
                            }
                            solverVariable7 = solverVariable4;
                            i24 = 0;
                            if (!z24) {
                            }
                        }
                        solverVariable7 = solverVariable4;
                        i25 = 5;
                        i24 = 0;
                        z24 = z11;
                        if (!z24) {
                        }
                    } else if (i23 >= 2 && z11 && z23) {
                        dVar.h(q5, solverVariable, 0, 8);
                        Object[] objArr = (z10 || this.O.f1579f == null) ? 1 : null;
                        if (!z10 && (constraintAnchor3 = this.O.f1579f) != null) {
                            ConstraintWidget constraintWidget11 = constraintAnchor3.f1577d;
                            if (constraintWidget11.Z != 0.0f) {
                                DimensionBehaviour[] dimensionBehaviourArr = constraintWidget11.V;
                                DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[0];
                                DimensionBehaviour dimensionBehaviour3 = DimensionBehaviour.MATCH_CONSTRAINT;
                                if (dimensionBehaviour2 == dimensionBehaviour3 && dimensionBehaviourArr[1] == dimensionBehaviour3) {
                                    objArr = 1;
                                }
                            }
                            objArr = null;
                        }
                        if (objArr != null) {
                            dVar.h(solverVariable2, solverVariable5, 0, 8);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                } else {
                    int max = Math.max(i16, i47);
                    if (i43 > 0) {
                        max = Math.min(i43, max);
                    }
                    dVar.e(q10, q5, max, 8);
                    z23 = z13;
                    i23 = i44;
                    solverVariable6 = q11;
                    solverVariable5 = q10;
                    solverVariable4 = solverVariable3;
                    z22 = false;
                }
                i22 = i16;
                if (!z20) {
                }
                if (i23 >= 2) {
                    return;
                }
                return;
            }
        }
        z21 = false;
        i19 = this.f1603j;
        if (i19 != -1) {
            this.f1603j = -1;
            i11 = i19;
            z21 = false;
        }
        i20 = this.f1605k;
        if (i20 != -1) {
        }
        i20 = i11;
        int i472 = i20;
        if (this.f1604j0 != 8) {
        }
        if (!z20) {
        }
        if (z21) {
        }
        i22 = i16;
        if (!z20) {
        }
        if (i23 >= 2) {
        }
    }

    public int A() {
        return this.I;
    }

    public void A0(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16 = i12 - i10;
        int i17 = i13 - i11;
        this.f1588b0 = i10;
        this.f1590c0 = i11;
        if (this.f1604j0 == 8) {
            this.X = 0;
            this.Y = 0;
            return;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.V;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        if (dimensionBehaviour == dimensionBehaviour2 && i16 < (i15 = this.X)) {
            i16 = i15;
        }
        if (dimensionBehaviourArr[1] == dimensionBehaviour2 && i17 < (i14 = this.Y)) {
            i17 = i14;
        }
        this.X = i16;
        this.Y = i17;
        int i18 = this.f1596f0;
        if (i17 < i18) {
            this.Y = i18;
        }
        int i19 = this.f1594e0;
        if (i16 < i19) {
            this.X = i19;
        }
        int i20 = this.f1626w;
        if (i20 > 0 && dimensionBehaviourArr[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.X = Math.min(this.X, i20);
        }
        int i21 = this.f1629z;
        if (i21 > 0 && this.V[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.Y = Math.min(this.Y, i21);
        }
        int i22 = this.X;
        if (i16 != i22) {
            this.f1603j = i22;
        }
        int i23 = this.Y;
        if (i17 != i23) {
            this.f1605k = i23;
        }
    }

    public int B() {
        return this.J;
    }

    public void B0(boolean z10) {
        this.F = z10;
    }

    public int C(int i10) {
        if (i10 == 0) {
            return R();
        }
        if (i10 == 1) {
            return v();
        }
        return 0;
    }

    public void C0(int i10) {
        this.Y = i10;
        int i11 = this.f1596f0;
        if (i10 < i11) {
            this.Y = i11;
        }
    }

    public int D() {
        return this.D[1];
    }

    public void D0(float f10) {
        this.f1598g0 = f10;
    }

    public int E() {
        return this.D[0];
    }

    public void E0(int i10) {
        this.f1610m0 = i10;
    }

    public int F() {
        return this.f1596f0;
    }

    public void F0(int i10, int i11) {
        this.f1588b0 = i10;
        int i12 = i11 - i10;
        this.X = i12;
        int i13 = this.f1594e0;
        if (i12 < i13) {
            this.X = i13;
        }
    }

    public int G() {
        return this.f1594e0;
    }

    public void G0(DimensionBehaviour dimensionBehaviour) {
        this.V[0] = dimensionBehaviour;
    }

    public ConstraintWidget H(int i10) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i10 == 0) {
            ConstraintAnchor constraintAnchor3 = this.M;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.f1579f;
            if (constraintAnchor4 == null || constraintAnchor4.f1579f != constraintAnchor3) {
                return null;
            }
            return constraintAnchor4.f1577d;
        } else if (i10 == 1 && (constraintAnchor2 = (constraintAnchor = this.N).f1579f) != null && constraintAnchor2.f1579f == constraintAnchor) {
            return constraintAnchor2.f1577d;
        } else {
            return null;
        }
    }

    public void H0(int i10, int i11, int i12, float f10) {
        this.f1621s = i10;
        this.f1625v = i11;
        if (i12 == Integer.MAX_VALUE) {
            i12 = 0;
        }
        this.f1626w = i12;
        this.f1627x = f10;
        if (f10 > 0.0f && f10 < 1.0f && i10 == 0) {
            this.f1621s = 2;
        }
    }

    public ConstraintWidget I() {
        return this.W;
    }

    public void I0(float f10) {
        this.f1614o0[0] = f10;
    }

    public ConstraintWidget J(int i10) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i10 == 0) {
            ConstraintAnchor constraintAnchor3 = this.K;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.f1579f;
            if (constraintAnchor4 == null || constraintAnchor4.f1579f != constraintAnchor3) {
                return null;
            }
            return constraintAnchor4.f1577d;
        } else if (i10 == 1 && (constraintAnchor2 = (constraintAnchor = this.L).f1579f) != null && constraintAnchor2.f1579f == constraintAnchor) {
            return constraintAnchor2.f1577d;
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J0(int i10, boolean z10) {
        this.U[i10] = z10;
    }

    public int K() {
        return S() + this.X;
    }

    public void K0(boolean z10) {
        this.G = z10;
    }

    public p L(int i10) {
        if (i10 == 0) {
            return this.f1591d;
        }
        if (i10 == 1) {
            return this.f1593e;
        }
        return null;
    }

    public void L0(boolean z10) {
        this.H = z10;
    }

    public float M() {
        return this.f1600h0;
    }

    public void M0(int i10, int i11) {
        this.I = i10;
        this.J = i11;
        P0(false);
    }

    public int N() {
        return this.f1612n0;
    }

    public void N0(int i10) {
        this.D[1] = i10;
    }

    public DimensionBehaviour O() {
        return this.V[1];
    }

    public void O0(int i10) {
        this.D[0] = i10;
    }

    public int P() {
        int i10 = 0;
        if (this.K != null) {
            i10 = 0 + this.L.f1580g;
        }
        return this.M != null ? i10 + this.N.f1580g : i10;
    }

    public void P0(boolean z10) {
        this.f1597g = z10;
    }

    public int Q() {
        return this.f1604j0;
    }

    public void Q0(int i10) {
        if (i10 < 0) {
            this.f1596f0 = 0;
        } else {
            this.f1596f0 = i10;
        }
    }

    public int R() {
        if (this.f1604j0 == 8) {
            return 0;
        }
        return this.X;
    }

    public void R0(int i10) {
        if (i10 < 0) {
            this.f1594e0 = 0;
        } else {
            this.f1594e0 = i10;
        }
    }

    public int S() {
        ConstraintWidget constraintWidget = this.W;
        if (constraintWidget == null || !(constraintWidget instanceof d)) {
            return this.f1588b0;
        }
        return ((d) constraintWidget).B0 + this.f1588b0;
    }

    public void S0(int i10, int i11) {
        this.f1588b0 = i10;
        this.f1590c0 = i11;
    }

    public int T() {
        ConstraintWidget constraintWidget = this.W;
        if (constraintWidget == null || !(constraintWidget instanceof d)) {
            return this.f1590c0;
        }
        return ((d) constraintWidget).C0 + this.f1590c0;
    }

    public void T0(ConstraintWidget constraintWidget) {
        this.W = constraintWidget;
    }

    public boolean U() {
        return this.F;
    }

    public void U0(float f10) {
        this.f1600h0 = f10;
    }

    public boolean V(int i10) {
        if (i10 == 0) {
            return (this.K.f1579f != null ? 1 : 0) + (this.M.f1579f != null ? 1 : 0) < 2;
        }
        return ((this.L.f1579f != null ? 1 : 0) + (this.N.f1579f != null ? 1 : 0)) + (this.O.f1579f != null ? 1 : 0) < 2;
    }

    public void V0(int i10) {
        this.f1612n0 = i10;
    }

    public boolean W() {
        int size = this.T.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.T.get(i10).l()) {
                return true;
            }
        }
        return false;
    }

    public void W0(int i10, int i11) {
        this.f1590c0 = i10;
        int i12 = i11 - i10;
        this.Y = i12;
        int i13 = this.f1596f0;
        if (i12 < i13) {
            this.Y = i13;
        }
    }

    public boolean X() {
        return (this.f1603j == -1 && this.f1605k == -1) ? false : true;
    }

    public void X0(DimensionBehaviour dimensionBehaviour) {
        this.V[1] = dimensionBehaviour;
    }

    public boolean Y(int i10, int i11) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i10 == 0) {
            ConstraintAnchor constraintAnchor3 = this.K.f1579f;
            return constraintAnchor3 != null && constraintAnchor3.m() && (constraintAnchor2 = this.M.f1579f) != null && constraintAnchor2.m() && (this.M.f1579f.d() - this.M.e()) - (this.K.f1579f.d() + this.K.e()) >= i11;
        }
        ConstraintAnchor constraintAnchor4 = this.L.f1579f;
        return constraintAnchor4 != null && constraintAnchor4.m() && (constraintAnchor = this.N.f1579f) != null && constraintAnchor.m() && (this.N.f1579f.d() - this.N.e()) - (this.L.f1579f.d() + this.L.e()) >= i11;
        return false;
    }

    public void Y0(int i10, int i11, int i12, float f10) {
        this.f1623t = i10;
        this.f1628y = i11;
        if (i12 == Integer.MAX_VALUE) {
            i12 = 0;
        }
        this.f1629z = i12;
        this.A = f10;
        if (f10 > 0.0f && f10 < 1.0f && i10 == 0) {
            this.f1623t = 2;
        }
    }

    public void Z(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i10, int i11) {
        m(type).a(constraintWidget.m(type2), i10, i11, true);
    }

    public void Z0(float f10) {
        this.f1614o0[1] = f10;
    }

    public void a1(int i10) {
        this.f1604j0 = i10;
    }

    public boolean b0() {
        return this.f1611n;
    }

    public void b1(int i10) {
        this.X = i10;
        int i11 = this.f1594e0;
        if (i10 < i11) {
            this.X = i11;
        }
    }

    public boolean c0(int i10) {
        return this.U[i10];
    }

    public void c1(int i10) {
        if (i10 >= 0 && i10 <= 3) {
            this.f1619r = i10;
        }
    }

    public boolean d0() {
        ConstraintAnchor constraintAnchor = this.K;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f1579f;
        if (constraintAnchor2 != null && constraintAnchor2.f1579f == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.M;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f1579f;
        return constraintAnchor4 != null && constraintAnchor4.f1579f == constraintAnchor3;
    }

    public void d1(int i10) {
        this.f1588b0 = i10;
    }

    public void e(d dVar, d dVar2, HashSet<ConstraintWidget> hashSet, int i10, boolean z10) {
        if (z10) {
            if (hashSet.contains(this)) {
                f.a(dVar, dVar2, this);
                hashSet.remove(this);
                g(dVar2, dVar.J1(64));
            } else {
                return;
            }
        }
        if (i10 == 0) {
            HashSet<ConstraintAnchor> c10 = this.K.c();
            if (c10 != null) {
                Iterator<ConstraintAnchor> it = c10.iterator();
                while (it.hasNext()) {
                    it.next().f1577d.e(dVar, dVar2, hashSet, i10, true);
                }
            }
            HashSet<ConstraintAnchor> c11 = this.M.c();
            if (c11 != null) {
                Iterator<ConstraintAnchor> it2 = c11.iterator();
                while (it2.hasNext()) {
                    it2.next().f1577d.e(dVar, dVar2, hashSet, i10, true);
                }
                return;
            }
            return;
        }
        HashSet<ConstraintAnchor> c12 = this.L.c();
        if (c12 != null) {
            Iterator<ConstraintAnchor> it3 = c12.iterator();
            while (it3.hasNext()) {
                it3.next().f1577d.e(dVar, dVar2, hashSet, i10, true);
            }
        }
        HashSet<ConstraintAnchor> c13 = this.N.c();
        if (c13 != null) {
            Iterator<ConstraintAnchor> it4 = c13.iterator();
            while (it4.hasNext()) {
                it4.next().f1577d.e(dVar, dVar2, hashSet, i10, true);
            }
        }
        HashSet<ConstraintAnchor> c14 = this.O.c();
        if (c14 != null) {
            Iterator<ConstraintAnchor> it5 = c14.iterator();
            while (it5.hasNext()) {
                it5.next().f1577d.e(dVar, dVar2, hashSet, i10, true);
            }
        }
    }

    public boolean e0() {
        return this.G;
    }

    public void e1(int i10) {
        this.f1590c0 = i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return (this instanceof g) || (this instanceof e);
    }

    public boolean f0() {
        ConstraintAnchor constraintAnchor = this.L;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f1579f;
        if (constraintAnchor2 != null && constraintAnchor2.f1579f == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.N;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f1579f;
        return constraintAnchor4 != null && constraintAnchor4.f1579f == constraintAnchor3;
    }

    public void f1(boolean z10, boolean z11, boolean z12, boolean z13) {
        if (this.B == -1) {
            if (z12 && !z13) {
                this.B = 0;
            } else if (!z12 && z13) {
                this.B = 1;
                if (this.f1586a0 == -1) {
                    this.C = 1.0f / this.C;
                }
            }
        }
        if (this.B == 0 && (!this.L.n() || !this.N.n())) {
            this.B = 1;
        } else if (this.B == 1 && (!this.K.n() || !this.M.n())) {
            this.B = 0;
        }
        if (this.B == -1 && (!this.L.n() || !this.N.n() || !this.K.n() || !this.M.n())) {
            if (this.L.n() && this.N.n()) {
                this.B = 0;
            } else if (this.K.n() && this.M.n()) {
                this.C = 1.0f / this.C;
                this.B = 1;
            }
        }
        if (this.B == -1) {
            int i10 = this.f1625v;
            if (i10 > 0 && this.f1628y == 0) {
                this.B = 0;
            } else if (i10 == 0 && this.f1628y > 0) {
                this.C = 1.0f / this.C;
                this.B = 1;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x04a1  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x04ba  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0555  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0558  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x059e  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x05c9  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x05d3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0180  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(d dVar, boolean z10) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        int i10;
        int i11;
        int i12;
        int i13;
        float f10;
        int i14;
        int i15;
        boolean z16;
        int i16;
        SolverVariable solverVariable;
        char c10;
        int i17;
        boolean z17;
        int i18;
        DimensionBehaviour dimensionBehaviour;
        boolean z18;
        int i19;
        boolean z19;
        boolean z20;
        DimensionBehaviour dimensionBehaviour2;
        SolverVariable solverVariable2;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        DimensionBehaviour dimensionBehaviour3;
        boolean z21;
        boolean z22;
        SolverVariable solverVariable5;
        SolverVariable solverVariable6;
        ConstraintWidget constraintWidget;
        d dVar2;
        SolverVariable solverVariable7;
        SolverVariable solverVariable8;
        int i20;
        int i21;
        int i22;
        int i23;
        SolverVariable solverVariable9;
        SolverVariable solverVariable10;
        SolverVariable solverVariable11;
        ConstraintWidget constraintWidget2;
        boolean z23;
        l lVar;
        f fVar;
        int i24;
        int i25;
        boolean z24;
        boolean z25;
        l lVar2;
        n nVar;
        f fVar2;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        boolean[] zArr;
        SolverVariable q5 = dVar.q(this.K);
        SolverVariable q10 = dVar.q(this.M);
        SolverVariable q11 = dVar.q(this.L);
        SolverVariable q12 = dVar.q(this.N);
        SolverVariable q13 = dVar.q(this.O);
        ConstraintWidget constraintWidget5 = this.W;
        if (constraintWidget5 != null) {
            boolean z26 = constraintWidget5 != null && constraintWidget5.V[0] == DimensionBehaviour.WRAP_CONTENT;
            boolean z27 = constraintWidget5 != null && constraintWidget5.V[1] == DimensionBehaviour.WRAP_CONTENT;
            int i26 = this.f1619r;
            if (i26 == 1) {
                z12 = z26;
                z11 = false;
            } else if (i26 == 2) {
                z11 = z27;
                z12 = false;
            } else if (i26 != 3) {
                z11 = z27;
                z12 = z26;
            }
            if (this.f1604j0 == 8 && !W()) {
                zArr = this.U;
                if (!zArr[0] && !zArr[1]) {
                    return;
                }
            }
            z13 = this.f1607l;
            if (!z13 || this.f1609m) {
                if (z13) {
                    dVar.f(q5, this.f1588b0);
                    dVar.f(q10, this.f1588b0 + this.X);
                    if (z12 && (constraintWidget4 = this.W) != null) {
                        if (this.f1601i) {
                            d dVar3 = (d) constraintWidget4;
                            dVar3.q1(this.K);
                            dVar3.p1(this.M);
                        } else {
                            dVar.h(dVar.q(constraintWidget4.M), q10, 0, 5);
                        }
                    }
                }
                if (this.f1609m) {
                    dVar.f(q11, this.f1590c0);
                    dVar.f(q12, this.f1590c0 + this.Y);
                    if (this.O.l()) {
                        dVar.f(q13, this.f1590c0 + this.f1592d0);
                    }
                    if (z11 && (constraintWidget3 = this.W) != null) {
                        if (this.f1601i) {
                            d dVar4 = (d) constraintWidget3;
                            dVar4.v1(this.L);
                            dVar4.u1(this.N);
                        } else {
                            dVar.h(dVar.q(constraintWidget3.N), q12, 0, 5);
                        }
                    }
                }
                if (this.f1607l && this.f1609m) {
                    this.f1607l = false;
                    this.f1609m = false;
                    return;
                }
            }
            r.a aVar = d.f1532x;
            if (!(!z10 || (lVar2 = this.f1591d) == null || (nVar = this.f1593e) == null)) {
                fVar2 = lVar2.f35914h;
                if (fVar2.f35886j && lVar2.f35915i.f35886j && nVar.f35914h.f35886j && nVar.f35915i.f35886j) {
                    dVar.f(q5, fVar2.f35883g);
                    dVar.f(q10, this.f1591d.f35915i.f35883g);
                    dVar.f(q11, this.f1593e.f35914h.f35883g);
                    dVar.f(q12, this.f1593e.f35915i.f35883g);
                    dVar.f(q13, this.f1593e.f35898k.f35883g);
                    if (this.W != null) {
                        if (z12 && this.f1595f[0] && !d0()) {
                            dVar.h(dVar.q(this.W.M), q10, 0, 8);
                        }
                        if (z11 && this.f1595f[1] && !f0()) {
                            dVar.h(dVar.q(this.W.N), q12, 0, 8);
                        }
                    }
                    this.f1607l = false;
                    this.f1609m = false;
                    return;
                }
            }
            if (this.W == null) {
                if (a0(0)) {
                    ((d) this.W).m1(this, 0);
                    z24 = true;
                } else {
                    z24 = d0();
                }
                if (a0(1)) {
                    ((d) this.W).m1(this, 1);
                    z25 = true;
                } else {
                    z25 = f0();
                }
                if (!z24 && z12 && this.f1604j0 != 8 && this.K.f1579f == null && this.M.f1579f == null) {
                    dVar.h(dVar.q(this.W.M), q10, 0, 1);
                }
                if (!z25 && z11 && this.f1604j0 != 8 && this.L.f1579f == null && this.N.f1579f == null && this.O == null) {
                    dVar.h(dVar.q(this.W.N), q12, 0, 1);
                }
                z14 = z24;
                z15 = z25;
            } else {
                z15 = false;
                z14 = false;
            }
            i10 = this.X;
            i11 = this.f1594e0;
            if (i10 >= i11) {
                i11 = i10;
            }
            i12 = this.Y;
            i13 = this.f1596f0;
            if (i12 >= i13) {
                i13 = i12;
            }
            DimensionBehaviour[] dimensionBehaviourArr = this.V;
            DimensionBehaviour dimensionBehaviour4 = dimensionBehaviourArr[0];
            DimensionBehaviour dimensionBehaviour5 = DimensionBehaviour.MATCH_CONSTRAINT;
            int i27 = i11;
            boolean z28 = dimensionBehaviour4 == dimensionBehaviour5;
            int i28 = i13;
            boolean z29 = dimensionBehaviourArr[1] == dimensionBehaviour5;
            int i29 = this.f1586a0;
            this.B = i29;
            f10 = this.Z;
            this.C = f10;
            int i30 = this.f1621s;
            int i31 = this.f1623t;
            if (f10 <= 0.0f) {
                solverVariable = q5;
                if (this.f1604j0 != 8) {
                    if (dimensionBehaviourArr[0] == dimensionBehaviour5 && i30 == 0) {
                        i30 = 3;
                    }
                    if (dimensionBehaviourArr[1] == dimensionBehaviour5 && i31 == 0) {
                        i31 = 3;
                    }
                    if (dimensionBehaviourArr[0] == dimensionBehaviour5 && dimensionBehaviourArr[1] == dimensionBehaviour5) {
                        i25 = 3;
                        if (i30 == 3 && i31 == 3) {
                            f1(z12, z11, z28, z29);
                            c10 = 0;
                            i14 = i30;
                            i15 = i31;
                            i17 = i27;
                            i16 = i28;
                            z16 = true;
                            int[] iArr = this.f1624u;
                            iArr[c10] = i14;
                            iArr[1] = i15;
                            if (!z16) {
                                int i32 = this.B;
                                i18 = -1;
                                if (i32 == 0 || i32 == -1) {
                                    z17 = true;
                                    boolean z30 = !z16 && ((i24 = this.B) == 1 || i24 == i18);
                                    DimensionBehaviour dimensionBehaviour6 = this.V[0];
                                    dimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
                                    z18 = dimensionBehaviour6 != dimensionBehaviour && (this instanceof d);
                                    i19 = z18 ? 0 : i17;
                                    z19 = !this.R.n();
                                    boolean[] zArr2 = this.U;
                                    z20 = zArr2[0];
                                    boolean z31 = zArr2[1];
                                    if (this.f1615p != 2 && !this.f1607l) {
                                        if (z10 && (lVar = this.f1591d) != null) {
                                            fVar = lVar.f35914h;
                                            if (fVar.f35886j && lVar.f35915i.f35886j) {
                                                if (!z10) {
                                                    SolverVariable solverVariable12 = solverVariable;
                                                    dVar.f(solverVariable12, fVar.f35883g);
                                                    dVar.f(q10, this.f1591d.f35915i.f35883g);
                                                    if (this.W != null && z12 && this.f1595f[0] && !d0()) {
                                                        dVar.h(dVar.q(this.W.M), q10, 0, 8);
                                                    }
                                                    z22 = z12;
                                                    z21 = z11;
                                                    dimensionBehaviour3 = dimensionBehaviour5;
                                                    dimensionBehaviour2 = dimensionBehaviour;
                                                    solverVariable4 = q13;
                                                    solverVariable3 = q12;
                                                    solverVariable2 = q11;
                                                    solverVariable6 = q10;
                                                    solverVariable5 = solverVariable12;
                                                    if (!z10) {
                                                        constraintWidget = this;
                                                        n nVar2 = constraintWidget.f1593e;
                                                        if (nVar2 != null) {
                                                            f fVar3 = nVar2.f35914h;
                                                            if (fVar3.f35886j && nVar2.f35915i.f35886j) {
                                                                dVar2 = dVar;
                                                                solverVariable7 = solverVariable2;
                                                                dVar2.f(solverVariable7, fVar3.f35883g);
                                                                solverVariable8 = solverVariable3;
                                                                dVar2.f(solverVariable8, constraintWidget.f1593e.f35915i.f35883g);
                                                                solverVariable9 = solverVariable4;
                                                                dVar2.f(solverVariable9, constraintWidget.f1593e.f35898k.f35883g);
                                                                ConstraintWidget constraintWidget6 = constraintWidget.W;
                                                                if (constraintWidget6 == null || z15 || !z21) {
                                                                    i23 = 8;
                                                                    i21 = 0;
                                                                    i20 = 1;
                                                                } else {
                                                                    i20 = 1;
                                                                    if (constraintWidget.f1595f[1]) {
                                                                        i23 = 8;
                                                                        i21 = 0;
                                                                        dVar2.h(dVar2.q(constraintWidget6.N), solverVariable8, 0, 8);
                                                                    } else {
                                                                        i23 = 8;
                                                                        i21 = 0;
                                                                    }
                                                                }
                                                                i22 = i21;
                                                                if ((constraintWidget.f1617q == 2 ? i21 : i22) != 0 || constraintWidget.f1609m) {
                                                                    solverVariable11 = solverVariable8;
                                                                    solverVariable10 = solverVariable7;
                                                                } else {
                                                                    boolean z32 = (constraintWidget.V[i20] != dimensionBehaviour2 || !(constraintWidget instanceof d)) ? i21 : i20;
                                                                    if (z32) {
                                                                        i16 = i21;
                                                                    }
                                                                    ConstraintWidget constraintWidget7 = constraintWidget.W;
                                                                    SolverVariable q14 = constraintWidget7 != null ? dVar2.q(constraintWidget7.N) : null;
                                                                    ConstraintWidget constraintWidget8 = constraintWidget.W;
                                                                    SolverVariable q15 = constraintWidget8 != null ? dVar2.q(constraintWidget8.L) : null;
                                                                    if (constraintWidget.f1592d0 > 0 || constraintWidget.f1604j0 == i23) {
                                                                        ConstraintAnchor constraintAnchor = constraintWidget.O;
                                                                        if (constraintAnchor.f1579f != null) {
                                                                            dVar2.e(solverVariable9, solverVariable7, n(), i23);
                                                                            dVar2.e(solverVariable9, dVar2.q(constraintWidget.O.f1579f), constraintWidget.O.e(), i23);
                                                                            if (z21) {
                                                                                dVar2.h(q14, dVar2.q(constraintWidget.N), i21, 5);
                                                                            }
                                                                            z23 = i21;
                                                                            boolean z33 = constraintWidget.f1595f[i20];
                                                                            DimensionBehaviour[] dimensionBehaviourArr2 = constraintWidget.V;
                                                                            solverVariable11 = solverVariable8;
                                                                            solverVariable10 = solverVariable7;
                                                                            i(dVar, false, z21, z22, z33, q15, q14, dimensionBehaviourArr2[i20], z32, constraintWidget.L, constraintWidget.N, constraintWidget.f1590c0, i16, constraintWidget.f1596f0, constraintWidget.D[i20], constraintWidget.f1600h0, z30, dimensionBehaviourArr2[0] != dimensionBehaviour3, z15, z14, z31, i15, i14, constraintWidget.f1628y, constraintWidget.f1629z, constraintWidget.A, z23);
                                                                        } else if (constraintWidget.f1604j0 == i23) {
                                                                            dVar2.e(solverVariable9, solverVariable7, constraintAnchor.e(), i23);
                                                                        } else {
                                                                            dVar2.e(solverVariable9, solverVariable7, n(), i23);
                                                                        }
                                                                    }
                                                                    z23 = z19;
                                                                    boolean z332 = constraintWidget.f1595f[i20];
                                                                    DimensionBehaviour[] dimensionBehaviourArr22 = constraintWidget.V;
                                                                    solverVariable11 = solverVariable8;
                                                                    solverVariable10 = solverVariable7;
                                                                    i(dVar, false, z21, z22, z332, q15, q14, dimensionBehaviourArr22[i20], z32, constraintWidget.L, constraintWidget.N, constraintWidget.f1590c0, i16, constraintWidget.f1596f0, constraintWidget.D[i20], constraintWidget.f1600h0, z30, dimensionBehaviourArr22[0] != dimensionBehaviour3, z15, z14, z31, i15, i14, constraintWidget.f1628y, constraintWidget.f1629z, constraintWidget.A, z23);
                                                                }
                                                                if (z16) {
                                                                    constraintWidget2 = this;
                                                                    if (constraintWidget2.B == 1) {
                                                                        dVar.k(solverVariable11, solverVariable10, solverVariable6, solverVariable5, constraintWidget2.C, 8);
                                                                    } else {
                                                                        dVar.k(solverVariable6, solverVariable5, solverVariable11, solverVariable10, constraintWidget2.C, 8);
                                                                    }
                                                                } else {
                                                                    constraintWidget2 = this;
                                                                }
                                                                if (constraintWidget2.R.n()) {
                                                                    dVar.b(constraintWidget2, constraintWidget2.R.i().g(), (float) Math.toRadians(constraintWidget2.E + 90.0f), constraintWidget2.R.e());
                                                                }
                                                                constraintWidget2.f1607l = false;
                                                                constraintWidget2.f1609m = false;
                                                            }
                                                        }
                                                        dVar2 = dVar;
                                                        solverVariable9 = solverVariable4;
                                                        solverVariable8 = solverVariable3;
                                                        solverVariable7 = solverVariable2;
                                                        i23 = 8;
                                                        i21 = 0;
                                                        i20 = 1;
                                                    } else {
                                                        i23 = 8;
                                                        i21 = 0;
                                                        i20 = 1;
                                                        constraintWidget = this;
                                                        dVar2 = dVar;
                                                        solverVariable9 = solverVariable4;
                                                        solverVariable8 = solverVariable3;
                                                        solverVariable7 = solverVariable2;
                                                    }
                                                    i22 = i20;
                                                    if ((constraintWidget.f1617q == 2 ? i21 : i22) != 0) {
                                                    }
                                                    solverVariable11 = solverVariable8;
                                                    solverVariable10 = solverVariable7;
                                                    if (z16) {
                                                    }
                                                    if (constraintWidget2.R.n()) {
                                                    }
                                                    constraintWidget2.f1607l = false;
                                                    constraintWidget2.f1609m = false;
                                                }
                                            }
                                        }
                                        solverVariable5 = solverVariable;
                                        ConstraintWidget constraintWidget9 = this.W;
                                        SolverVariable q16 = constraintWidget9 == null ? dVar.q(constraintWidget9.M) : null;
                                        ConstraintWidget constraintWidget10 = this.W;
                                        SolverVariable q17 = constraintWidget10 == null ? dVar.q(constraintWidget10.K) : null;
                                        boolean z34 = this.f1595f[0];
                                        DimensionBehaviour[] dimensionBehaviourArr3 = this.V;
                                        z22 = z12;
                                        z21 = z11;
                                        dimensionBehaviour3 = dimensionBehaviour5;
                                        solverVariable4 = q13;
                                        solverVariable3 = q12;
                                        solverVariable2 = q11;
                                        solverVariable6 = q10;
                                        dimensionBehaviour2 = dimensionBehaviour;
                                        i(dVar, true, z12, z11, z34, q17, q16, dimensionBehaviourArr3[0], z18, this.K, this.M, this.f1588b0, i19, this.f1594e0, this.D[0], this.f1598g0, z17, dimensionBehaviourArr3[1] != dimensionBehaviour5, z14, z15, z20, i14, i15, this.f1625v, this.f1626w, this.f1627x, z19);
                                        if (!z10) {
                                        }
                                        i22 = i20;
                                        if ((constraintWidget.f1617q == 2 ? i21 : i22) != 0) {
                                        }
                                        solverVariable11 = solverVariable8;
                                        solverVariable10 = solverVariable7;
                                        if (z16) {
                                        }
                                        if (constraintWidget2.R.n()) {
                                        }
                                        constraintWidget2.f1607l = false;
                                        constraintWidget2.f1609m = false;
                                    }
                                    z22 = z12;
                                    z21 = z11;
                                    dimensionBehaviour3 = dimensionBehaviour5;
                                    dimensionBehaviour2 = dimensionBehaviour;
                                    solverVariable4 = q13;
                                    solverVariable3 = q12;
                                    solverVariable2 = q11;
                                    solverVariable6 = q10;
                                    solverVariable5 = solverVariable;
                                    if (!z10) {
                                    }
                                    i22 = i20;
                                    if ((constraintWidget.f1617q == 2 ? i21 : i22) != 0) {
                                    }
                                    solverVariable11 = solverVariable8;
                                    solverVariable10 = solverVariable7;
                                    if (z16) {
                                    }
                                    if (constraintWidget2.R.n()) {
                                    }
                                    constraintWidget2.f1607l = false;
                                    constraintWidget2.f1609m = false;
                                }
                            } else {
                                i18 = -1;
                            }
                            z17 = false;
                            if (!z16) {
                            }
                            DimensionBehaviour dimensionBehaviour62 = this.V[0];
                            dimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
                            if (dimensionBehaviour62 != dimensionBehaviour) {
                            }
                            if (z18) {
                            }
                            z19 = !this.R.n();
                            boolean[] zArr22 = this.U;
                            z20 = zArr22[0];
                            boolean z312 = zArr22[1];
                            if (this.f1615p != 2) {
                                if (z10) {
                                    fVar = lVar.f35914h;
                                    if (fVar.f35886j) {
                                        if (!z10) {
                                        }
                                    }
                                }
                                solverVariable5 = solverVariable;
                                ConstraintWidget constraintWidget92 = this.W;
                                if (constraintWidget92 == null) {
                                }
                                ConstraintWidget constraintWidget102 = this.W;
                                if (constraintWidget102 == null) {
                                }
                                boolean z342 = this.f1595f[0];
                                DimensionBehaviour[] dimensionBehaviourArr32 = this.V;
                                z22 = z12;
                                z21 = z11;
                                dimensionBehaviour3 = dimensionBehaviour5;
                                solverVariable4 = q13;
                                solverVariable3 = q12;
                                solverVariable2 = q11;
                                solverVariable6 = q10;
                                dimensionBehaviour2 = dimensionBehaviour;
                                i(dVar, true, z12, z11, z342, q17, q16, dimensionBehaviourArr32[0], z18, this.K, this.M, this.f1588b0, i19, this.f1594e0, this.D[0], this.f1598g0, z17, dimensionBehaviourArr32[1] != dimensionBehaviour5, z14, z15, z20, i14, i15, this.f1625v, this.f1626w, this.f1627x, z19);
                                if (!z10) {
                                }
                                i22 = i20;
                                if ((constraintWidget.f1617q == 2 ? i21 : i22) != 0) {
                                }
                                solverVariable11 = solverVariable8;
                                solverVariable10 = solverVariable7;
                                if (z16) {
                                }
                                if (constraintWidget2.R.n()) {
                                }
                                constraintWidget2.f1607l = false;
                                constraintWidget2.f1609m = false;
                            }
                            z22 = z12;
                            z21 = z11;
                            dimensionBehaviour3 = dimensionBehaviour5;
                            dimensionBehaviour2 = dimensionBehaviour;
                            solverVariable4 = q13;
                            solverVariable3 = q12;
                            solverVariable2 = q11;
                            solverVariable6 = q10;
                            solverVariable5 = solverVariable;
                            if (!z10) {
                            }
                            i22 = i20;
                            if ((constraintWidget.f1617q == 2 ? i21 : i22) != 0) {
                            }
                            solverVariable11 = solverVariable8;
                            solverVariable10 = solverVariable7;
                            if (z16) {
                            }
                            if (constraintWidget2.R.n()) {
                            }
                            constraintWidget2.f1607l = false;
                            constraintWidget2.f1609m = false;
                        }
                    } else {
                        i25 = 3;
                    }
                    if (dimensionBehaviourArr[0] == dimensionBehaviour5 && i30 == i25) {
                        this.B = 0;
                        i17 = (int) (f10 * i12);
                        if (dimensionBehaviourArr[1] != dimensionBehaviour5) {
                            i15 = i31;
                            i16 = i28;
                            i14 = 4;
                            c10 = 0;
                            z16 = false;
                        } else {
                            z16 = true;
                            i14 = i30;
                            i15 = i31;
                            i16 = i28;
                            c10 = 0;
                        }
                    } else {
                        if (dimensionBehaviourArr[1] == dimensionBehaviour5 && i31 == 3) {
                            this.B = 1;
                            if (i29 == -1) {
                                this.C = 1.0f / f10;
                            }
                            i16 = (int) (this.C * i10);
                            c10 = 0;
                            i14 = i30;
                            if (dimensionBehaviourArr[0] != dimensionBehaviour5) {
                                z16 = false;
                                i17 = i27;
                                i15 = 4;
                            } else {
                                i15 = i31;
                                i17 = i27;
                                z16 = true;
                            }
                        }
                        c10 = 0;
                        i14 = i30;
                        i15 = i31;
                        i17 = i27;
                        i16 = i28;
                        z16 = true;
                    }
                    int[] iArr2 = this.f1624u;
                    iArr2[c10] = i14;
                    iArr2[1] = i15;
                    if (!z16) {
                    }
                    z17 = false;
                    if (!z16) {
                    }
                    DimensionBehaviour dimensionBehaviour622 = this.V[0];
                    dimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
                    if (dimensionBehaviour622 != dimensionBehaviour) {
                    }
                    if (z18) {
                    }
                    z19 = !this.R.n();
                    boolean[] zArr222 = this.U;
                    z20 = zArr222[0];
                    boolean z3122 = zArr222[1];
                    if (this.f1615p != 2) {
                    }
                    z22 = z12;
                    z21 = z11;
                    dimensionBehaviour3 = dimensionBehaviour5;
                    dimensionBehaviour2 = dimensionBehaviour;
                    solverVariable4 = q13;
                    solverVariable3 = q12;
                    solverVariable2 = q11;
                    solverVariable6 = q10;
                    solverVariable5 = solverVariable;
                    if (!z10) {
                    }
                    i22 = i20;
                    if ((constraintWidget.f1617q == 2 ? i21 : i22) != 0) {
                    }
                    solverVariable11 = solverVariable8;
                    solverVariable10 = solverVariable7;
                    if (z16) {
                    }
                    if (constraintWidget2.R.n()) {
                    }
                    constraintWidget2.f1607l = false;
                    constraintWidget2.f1609m = false;
                }
            } else {
                solverVariable = q5;
            }
            c10 = 0;
            i14 = i30;
            i15 = i31;
            z16 = false;
            i17 = i27;
            i16 = i28;
            int[] iArr22 = this.f1624u;
            iArr22[c10] = i14;
            iArr22[1] = i15;
            if (!z16) {
            }
            z17 = false;
            if (!z16) {
            }
            DimensionBehaviour dimensionBehaviour6222 = this.V[0];
            dimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
            if (dimensionBehaviour6222 != dimensionBehaviour) {
            }
            if (z18) {
            }
            z19 = !this.R.n();
            boolean[] zArr2222 = this.U;
            z20 = zArr2222[0];
            boolean z31222 = zArr2222[1];
            if (this.f1615p != 2) {
            }
            z22 = z12;
            z21 = z11;
            dimensionBehaviour3 = dimensionBehaviour5;
            dimensionBehaviour2 = dimensionBehaviour;
            solverVariable4 = q13;
            solverVariable3 = q12;
            solverVariable2 = q11;
            solverVariable6 = q10;
            solverVariable5 = solverVariable;
            if (!z10) {
            }
            i22 = i20;
            if ((constraintWidget.f1617q == 2 ? i21 : i22) != 0) {
            }
            solverVariable11 = solverVariable8;
            solverVariable10 = solverVariable7;
            if (z16) {
            }
            if (constraintWidget2.R.n()) {
            }
            constraintWidget2.f1607l = false;
            constraintWidget2.f1609m = false;
        }
        z12 = false;
        z11 = false;
        if (this.f1604j0 == 8) {
            zArr = this.U;
            if (!zArr[0]) {
                return;
            }
        }
        z13 = this.f1607l;
        if (!z13) {
        }
        if (z13) {
        }
        if (this.f1609m) {
        }
        if (this.f1607l) {
            this.f1607l = false;
            this.f1609m = false;
            return;
        }
        r.a aVar2 = d.f1532x;
        if (!z10) {
            fVar2 = lVar2.f35914h;
            if (fVar2.f35886j) {
                dVar.f(q5, fVar2.f35883g);
                dVar.f(q10, this.f1591d.f35915i.f35883g);
                dVar.f(q11, this.f1593e.f35914h.f35883g);
                dVar.f(q12, this.f1593e.f35915i.f35883g);
                dVar.f(q13, this.f1593e.f35898k.f35883g);
                if (this.W != null) {
                }
                this.f1607l = false;
                this.f1609m = false;
                return;
            }
        }
        if (this.W == null) {
        }
        i10 = this.X;
        i11 = this.f1594e0;
        if (i10 >= i11) {
        }
        i12 = this.Y;
        i13 = this.f1596f0;
        if (i12 >= i13) {
        }
        DimensionBehaviour[] dimensionBehaviourArr4 = this.V;
        DimensionBehaviour dimensionBehaviour42 = dimensionBehaviourArr4[0];
        DimensionBehaviour dimensionBehaviour52 = DimensionBehaviour.MATCH_CONSTRAINT;
        int i272 = i11;
        if (dimensionBehaviour42 == dimensionBehaviour52) {
        }
        int i282 = i13;
        if (dimensionBehaviourArr4[1] == dimensionBehaviour52) {
        }
        int i292 = this.f1586a0;
        this.B = i292;
        f10 = this.Z;
        this.C = f10;
        int i302 = this.f1621s;
        int i312 = this.f1623t;
        if (f10 <= 0.0f) {
        }
        c10 = 0;
        i14 = i302;
        i15 = i312;
        z16 = false;
        i17 = i272;
        i16 = i282;
        int[] iArr222 = this.f1624u;
        iArr222[c10] = i14;
        iArr222[1] = i15;
        if (!z16) {
        }
        z17 = false;
        if (!z16) {
        }
        DimensionBehaviour dimensionBehaviour62222 = this.V[0];
        dimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour62222 != dimensionBehaviour) {
        }
        if (z18) {
        }
        z19 = !this.R.n();
        boolean[] zArr22222 = this.U;
        z20 = zArr22222[0];
        boolean z312222 = zArr22222[1];
        if (this.f1615p != 2) {
        }
        z22 = z12;
        z21 = z11;
        dimensionBehaviour3 = dimensionBehaviour52;
        dimensionBehaviour2 = dimensionBehaviour;
        solverVariable4 = q13;
        solverVariable3 = q12;
        solverVariable2 = q11;
        solverVariable6 = q10;
        solverVariable5 = solverVariable;
        if (!z10) {
        }
        i22 = i20;
        if ((constraintWidget.f1617q == 2 ? i21 : i22) != 0) {
        }
        solverVariable11 = solverVariable8;
        solverVariable10 = solverVariable7;
        if (z16) {
        }
        if (constraintWidget2.R.n()) {
        }
        constraintWidget2.f1607l = false;
        constraintWidget2.f1609m = false;
    }

    public boolean g0() {
        return this.H;
    }

    public void g1(boolean z10, boolean z11) {
        int i10;
        int i11;
        boolean k10 = z10 & this.f1591d.k();
        boolean k11 = z11 & this.f1593e.k();
        l lVar = this.f1591d;
        int i12 = lVar.f35914h.f35883g;
        n nVar = this.f1593e;
        int i13 = nVar.f35914h.f35883g;
        int i14 = lVar.f35915i.f35883g;
        int i15 = nVar.f35915i.f35883g;
        int i16 = i15 - i13;
        if (i14 - i12 < 0 || i16 < 0 || i12 == Integer.MIN_VALUE || i12 == Integer.MAX_VALUE || i13 == Integer.MIN_VALUE || i13 == Integer.MAX_VALUE || i14 == Integer.MIN_VALUE || i14 == Integer.MAX_VALUE || i15 == Integer.MIN_VALUE || i15 == Integer.MAX_VALUE) {
            i14 = 0;
            i12 = 0;
            i15 = 0;
            i13 = 0;
        }
        int i17 = i14 - i12;
        int i18 = i15 - i13;
        if (k10) {
            this.f1588b0 = i12;
        }
        if (k11) {
            this.f1590c0 = i13;
        }
        if (this.f1604j0 == 8) {
            this.X = 0;
            this.Y = 0;
            return;
        }
        if (k10) {
            if (this.V[0] == DimensionBehaviour.FIXED && i17 < (i11 = this.X)) {
                i17 = i11;
            }
            this.X = i17;
            int i19 = this.f1594e0;
            if (i17 < i19) {
                this.X = i19;
            }
        }
        if (k11) {
            if (this.V[1] == DimensionBehaviour.FIXED && i18 < (i10 = this.Y)) {
                i18 = i10;
            }
            this.Y = i18;
            int i20 = this.f1596f0;
            if (i18 < i20) {
                this.Y = i20;
            }
        }
    }

    public boolean h() {
        return this.f1604j0 != 8;
    }

    public boolean h0() {
        return this.f1597g && this.f1604j0 != 8;
    }

    public void h1(d dVar, boolean z10) {
        n nVar;
        l lVar;
        int x10 = dVar.x(this.K);
        int x11 = dVar.x(this.L);
        int x12 = dVar.x(this.M);
        int x13 = dVar.x(this.N);
        if (z10 && (lVar = this.f1591d) != null) {
            f fVar = lVar.f35914h;
            if (fVar.f35886j) {
                f fVar2 = lVar.f35915i;
                if (fVar2.f35886j) {
                    x10 = fVar.f35883g;
                    x12 = fVar2.f35883g;
                }
            }
        }
        if (z10 && (nVar = this.f1593e) != null) {
            f fVar3 = nVar.f35914h;
            if (fVar3.f35886j) {
                f fVar4 = nVar.f35915i;
                if (fVar4.f35886j) {
                    x11 = fVar3.f35883g;
                    x13 = fVar4.f35883g;
                }
            }
        }
        int i10 = x13 - x11;
        x13 = 0;
        if (x12 - x10 < 0 || i10 < 0 || x10 == Integer.MIN_VALUE || x10 == Integer.MAX_VALUE || x11 == Integer.MIN_VALUE || x11 == Integer.MAX_VALUE || x12 == Integer.MIN_VALUE || x12 == Integer.MAX_VALUE || x13 == Integer.MIN_VALUE || x13 == Integer.MAX_VALUE) {
            x10 = 0;
            x11 = 0;
            x12 = 0;
        }
        A0(x10, x11, x12, x13);
    }

    public boolean i0() {
        return this.f1607l || (this.K.m() && this.M.m());
    }

    public void j(ConstraintWidget constraintWidget, float f10, int i10) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
        Z(type, constraintWidget, type, i10, 0);
        this.E = f10;
    }

    public boolean j0() {
        return this.f1609m || (this.L.m() && this.N.m());
    }

    public void k(d dVar) {
        dVar.q(this.K);
        dVar.q(this.L);
        dVar.q(this.M);
        dVar.q(this.N);
        if (this.f1592d0 > 0) {
            dVar.q(this.O);
        }
    }

    public boolean k0() {
        return this.f1613o;
    }

    public void l() {
        if (this.f1591d == null) {
            this.f1591d = new l(this);
        }
        if (this.f1593e == null) {
            this.f1593e = new n(this);
        }
    }

    public void l0() {
        this.f1611n = true;
    }

    public ConstraintAnchor m(ConstraintAnchor.Type type) {
        switch (a.f1630a[type.ordinal()]) {
            case 1:
                return this.K;
            case 2:
                return this.L;
            case 3:
                return this.M;
            case 4:
                return this.N;
            case 5:
                return this.O;
            case 6:
                return this.R;
            case 7:
                return this.P;
            case 8:
                return this.Q;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public void m0() {
        this.f1613o = true;
    }

    public int n() {
        return this.f1592d0;
    }

    public boolean n0() {
        DimensionBehaviour[] dimensionBehaviourArr = this.V;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
        return dimensionBehaviour == dimensionBehaviour2 && dimensionBehaviourArr[1] == dimensionBehaviour2;
    }

    public float o(int i10) {
        if (i10 == 0) {
            return this.f1598g0;
        }
        if (i10 == 1) {
            return this.f1600h0;
        }
        return -1.0f;
    }

    public void o0() {
        this.K.p();
        this.L.p();
        this.M.p();
        this.N.p();
        this.O.p();
        this.P.p();
        this.Q.p();
        this.R.p();
        this.W = null;
        this.E = 0.0f;
        this.X = 0;
        this.Y = 0;
        this.Z = 0.0f;
        this.f1586a0 = -1;
        this.f1588b0 = 0;
        this.f1590c0 = 0;
        this.f1592d0 = 0;
        this.f1594e0 = 0;
        this.f1596f0 = 0;
        float f10 = f1584t0;
        this.f1598g0 = f10;
        this.f1600h0 = f10;
        DimensionBehaviour[] dimensionBehaviourArr = this.V;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.f1602i0 = null;
        this.f1604j0 = 0;
        this.f1608l0 = null;
        this.f1610m0 = 0;
        this.f1612n0 = 0;
        float[] fArr = this.f1614o0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f1615p = -1;
        this.f1617q = -1;
        int[] iArr = this.D;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f1621s = 0;
        this.f1623t = 0;
        this.f1627x = 1.0f;
        this.A = 1.0f;
        this.f1626w = Integer.MAX_VALUE;
        this.f1629z = Integer.MAX_VALUE;
        this.f1625v = 0;
        this.f1628y = 0;
        this.B = -1;
        this.C = 1.0f;
        boolean[] zArr = this.f1595f;
        zArr[0] = true;
        zArr[1] = true;
        this.H = false;
        boolean[] zArr2 = this.U;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f1597g = true;
        int[] iArr2 = this.f1624u;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.f1603j = -1;
        this.f1605k = -1;
    }

    public int p() {
        return T() + this.Y;
    }

    public void p0() {
        this.f1607l = false;
        this.f1609m = false;
        this.f1611n = false;
        this.f1613o = false;
        int size = this.T.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.T.get(i10).q();
        }
    }

    public Object q() {
        return this.f1602i0;
    }

    public void q0(androidx.constraintlayout.core.c cVar) {
        this.K.r(cVar);
        this.L.r(cVar);
        this.M.r(cVar);
        this.N.r(cVar);
        this.O.r(cVar);
        this.R.r(cVar);
        this.P.r(cVar);
        this.Q.r(cVar);
    }

    public String r() {
        return this.f1606k0;
    }

    public void r0(int i10) {
        this.f1592d0 = i10;
        this.F = i10 > 0;
    }

    public DimensionBehaviour s(int i10) {
        if (i10 == 0) {
            return y();
        }
        if (i10 == 1) {
            return O();
        }
        return null;
    }

    public void s0(Object obj) {
        this.f1602i0 = obj;
    }

    public float t() {
        return this.Z;
    }

    public void t0(String str) {
        this.f1606k0 = str;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        String str2 = "";
        if (this.f1608l0 != null) {
            str = "type: " + this.f1608l0 + " ";
        } else {
            str = str2;
        }
        sb2.append(str);
        if (this.f1606k0 != null) {
            str2 = "id: " + this.f1606k0 + " ";
        }
        sb2.append(str2);
        sb2.append("(");
        sb2.append(this.f1588b0);
        sb2.append(", ");
        sb2.append(this.f1590c0);
        sb2.append(") - (");
        sb2.append(this.X);
        sb2.append(" x ");
        sb2.append(this.Y);
        sb2.append(")");
        return sb2.toString();
    }

    public int u() {
        return this.f1586a0;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0084 -> B:36:0x0085). Please submit an issue!!! */
    public void u0(String str) {
        float f10;
        int i10 = 0;
        if (str == null || str.length() == 0) {
            this.Z = 0.0f;
            return;
        }
        int i11 = -1;
        int length = str.length();
        int indexOf = str.indexOf(44);
        int i12 = 0;
        if (indexOf > 0 && indexOf < length - 1) {
            String substring = str.substring(0, indexOf);
            if (substring.equalsIgnoreCase("W")) {
                i11 = 0;
            } else if (substring.equalsIgnoreCase("H")) {
                i11 = 1;
            }
            i12 = indexOf + 1;
        }
        int indexOf2 = str.indexOf(58);
        if (indexOf2 < 0 || indexOf2 >= length - 1) {
            String substring2 = str.substring(i12);
            if (substring2.length() > 0) {
                f10 = Float.parseFloat(substring2);
            }
            f10 = i10;
        } else {
            String substring3 = str.substring(i12, indexOf2);
            String substring4 = str.substring(indexOf2 + 1);
            if (substring3.length() > 0 && substring4.length() > 0) {
                float parseFloat = Float.parseFloat(substring3);
                float parseFloat2 = Float.parseFloat(substring4);
                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                    if (i11 == 1) {
                        f10 = Math.abs(parseFloat2 / parseFloat);
                    } else {
                        f10 = Math.abs(parseFloat / parseFloat2);
                    }
                }
            }
            f10 = i10;
        }
        i10 = (f10 > i10 ? 1 : (f10 == i10 ? 0 : -1));
        if (i10 > 0) {
            this.Z = f10;
            this.f1586a0 = i11;
        }
    }

    public int v() {
        if (this.f1604j0 == 8) {
            return 0;
        }
        return this.Y;
    }

    public void v0(int i10) {
        if (this.F) {
            int i11 = i10 - this.f1592d0;
            int i12 = this.Y + i11;
            this.f1590c0 = i11;
            this.L.s(i11);
            this.N.s(i12);
            this.O.s(i10);
            this.f1609m = true;
        }
    }

    public float w() {
        return this.f1598g0;
    }

    public void w0(int i10, int i11) {
        if (!this.f1607l) {
            this.K.s(i10);
            this.M.s(i11);
            this.f1588b0 = i10;
            this.X = i11 - i10;
            this.f1607l = true;
        }
    }

    public int x() {
        return this.f1610m0;
    }

    public void x0(int i10) {
        this.K.s(i10);
        this.f1588b0 = i10;
    }

    public DimensionBehaviour y() {
        return this.V[0];
    }

    public void y0(int i10) {
        this.L.s(i10);
        this.f1590c0 = i10;
    }

    public int z() {
        ConstraintAnchor constraintAnchor = this.K;
        int i10 = 0;
        if (constraintAnchor != null) {
            i10 = 0 + constraintAnchor.f1580g;
        }
        ConstraintAnchor constraintAnchor2 = this.M;
        return constraintAnchor2 != null ? i10 + constraintAnchor2.f1580g : i10;
    }

    public void z0(int i10, int i11) {
        if (!this.f1609m) {
            this.L.s(i10);
            this.N.s(i11);
            this.f1590c0 = i10;
            this.Y = i11 - i10;
            if (this.F) {
                this.O.s(i10 + this.f1592d0);
            }
            this.f1609m = true;
        }
    }
}
