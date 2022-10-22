package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.d;
import androidx.constraintlayout.core.widgets.e;
import androidx.constraintlayout.core.widgets.f;
import androidx.constraintlayout.core.widgets.g;
import com.mobvoi.wear.info.IntentInfo;
import com.realsil.sdk.dfu.DfuException;
import java.util.ArrayList;
import java.util.HashMap;
import w.b;
/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* renamed from: t  reason: collision with root package name */
    private static i f1763t;

    /* renamed from: a  reason: collision with root package name */
    SparseArray<View> f1764a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<androidx.constraintlayout.widget.a> f1765b = new ArrayList<>(4);

    /* renamed from: c  reason: collision with root package name */
    protected d f1766c = new d();

    /* renamed from: d  reason: collision with root package name */
    private int f1767d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f1768e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f1769f = Integer.MAX_VALUE;

    /* renamed from: g  reason: collision with root package name */
    private int f1770g = Integer.MAX_VALUE;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f1771h = true;

    /* renamed from: i  reason: collision with root package name */
    private int f1772i = DfuException.ERROR_FILE_IO_EXCEPTION;

    /* renamed from: j  reason: collision with root package name */
    private androidx.constraintlayout.widget.c f1773j = null;

    /* renamed from: k  reason: collision with root package name */
    protected androidx.constraintlayout.widget.b f1774k = null;

    /* renamed from: l  reason: collision with root package name */
    private int f1775l = -1;

    /* renamed from: m  reason: collision with root package name */
    private HashMap<String, Integer> f1776m = new HashMap<>();

    /* renamed from: n  reason: collision with root package name */
    private int f1777n = -1;

    /* renamed from: o  reason: collision with root package name */
    private int f1778o = -1;

    /* renamed from: p  reason: collision with root package name */
    private SparseArray<ConstraintWidget> f1779p = new SparseArray<>();

    /* renamed from: q  reason: collision with root package name */
    c f1780q = new c(this);

    /* renamed from: r  reason: collision with root package name */
    private int f1781r = 0;

    /* renamed from: s  reason: collision with root package name */
    private int f1782s = 0;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1783a;

        static {
            int[] iArr = new int[ConstraintWidget.DimensionBehaviour.values().length];
            f1783a = iArr;
            try {
                iArr[ConstraintWidget.DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1783a[ConstraintWidget.DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1783a[ConstraintWidget.DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1783a[ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements b.AbstractC0518b {

        /* renamed from: a  reason: collision with root package name */
        ConstraintLayout f1828a;

        /* renamed from: b  reason: collision with root package name */
        int f1829b;

        /* renamed from: c  reason: collision with root package name */
        int f1830c;

        /* renamed from: d  reason: collision with root package name */
        int f1831d;

        /* renamed from: e  reason: collision with root package name */
        int f1832e;

        /* renamed from: f  reason: collision with root package name */
        int f1833f;

        /* renamed from: g  reason: collision with root package name */
        int f1834g;

        public c(ConstraintLayout constraintLayout) {
            this.f1828a = constraintLayout;
        }

        private boolean d(int i10, int i11, int i12) {
            if (i10 == i11) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i10);
            View.MeasureSpec.getSize(i10);
            int mode2 = View.MeasureSpec.getMode(i11);
            int size = View.MeasureSpec.getSize(i11);
            if (mode2 == 1073741824) {
                return (mode == Integer.MIN_VALUE || mode == 0) && i12 == size;
            }
            return false;
        }

        @Override // w.b.AbstractC0518b
        public final void a() {
            int childCount = this.f1828a.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = this.f1828a.getChildAt(i10);
                if (childAt instanceof f) {
                    ((f) childAt).a(this.f1828a);
                }
            }
            int size = this.f1828a.f1765b.size();
            if (size > 0) {
                for (int i11 = 0; i11 < size; i11++) {
                    ((androidx.constraintlayout.widget.a) this.f1828a.f1765b.get(i11)).p(this.f1828a);
                }
            }
        }

        @Override // w.b.AbstractC0518b
        @SuppressLint({"WrongCall"})
        public final void b(ConstraintWidget constraintWidget, b.a aVar) {
            int i10;
            int i11;
            int i12;
            int i13;
            int i14;
            int i15;
            int i16;
            if (constraintWidget != null) {
                if (constraintWidget.Q() == 8 && !constraintWidget.e0()) {
                    aVar.f35861e = 0;
                    aVar.f35862f = 0;
                    aVar.f35863g = 0;
                } else if (constraintWidget.I() != null) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = aVar.f35857a;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = aVar.f35858b;
                    int i17 = aVar.f35859c;
                    int i18 = aVar.f35860d;
                    int i19 = this.f1829b + this.f1830c;
                    int i20 = this.f1831d;
                    View view = (View) constraintWidget.q();
                    int[] iArr = a.f1783a;
                    int i21 = iArr[dimensionBehaviour.ordinal()];
                    if (i21 == 1) {
                        i10 = View.MeasureSpec.makeMeasureSpec(i17, 1073741824);
                    } else if (i21 == 2) {
                        i10 = ViewGroup.getChildMeasureSpec(this.f1833f, i20, -2);
                    } else if (i21 == 3) {
                        i10 = ViewGroup.getChildMeasureSpec(this.f1833f, i20 + constraintWidget.z(), -1);
                    } else if (i21 != 4) {
                        i10 = 0;
                    } else {
                        i10 = ViewGroup.getChildMeasureSpec(this.f1833f, i20, -2);
                        boolean z10 = constraintWidget.f1621s == 1;
                        int i22 = aVar.f35866j;
                        if (i22 == b.a.f35855l || i22 == b.a.f35856m) {
                            if (aVar.f35866j == b.a.f35856m || !z10 || (z10 && (view.getMeasuredHeight() == constraintWidget.v())) || (view instanceof f) || constraintWidget.i0()) {
                                i10 = View.MeasureSpec.makeMeasureSpec(constraintWidget.R(), 1073741824);
                            }
                        }
                    }
                    int i23 = iArr[dimensionBehaviour2.ordinal()];
                    if (i23 == 1) {
                        i11 = View.MeasureSpec.makeMeasureSpec(i18, 1073741824);
                    } else if (i23 == 2) {
                        i11 = ViewGroup.getChildMeasureSpec(this.f1834g, i19, -2);
                    } else if (i23 == 3) {
                        i11 = ViewGroup.getChildMeasureSpec(this.f1834g, i19 + constraintWidget.P(), -1);
                    } else if (i23 != 4) {
                        i11 = 0;
                    } else {
                        i11 = ViewGroup.getChildMeasureSpec(this.f1834g, i19, -2);
                        boolean z11 = constraintWidget.f1623t == 1;
                        int i24 = aVar.f35866j;
                        if (i24 == b.a.f35855l || i24 == b.a.f35856m) {
                            if (aVar.f35866j == b.a.f35856m || !z11 || (z11 && (view.getMeasuredWidth() == constraintWidget.R())) || (view instanceof f) || constraintWidget.j0()) {
                                i11 = View.MeasureSpec.makeMeasureSpec(constraintWidget.v(), 1073741824);
                            }
                        }
                    }
                    d dVar = (d) constraintWidget.I();
                    if (dVar != null && f.b(ConstraintLayout.this.f1772i, 256) && view.getMeasuredWidth() == constraintWidget.R() && view.getMeasuredWidth() < dVar.R() && view.getMeasuredHeight() == constraintWidget.v() && view.getMeasuredHeight() < dVar.v() && view.getBaseline() == constraintWidget.n() && !constraintWidget.h0()) {
                        if (d(constraintWidget.A(), i10, constraintWidget.R()) && d(constraintWidget.B(), i11, constraintWidget.v())) {
                            aVar.f35861e = constraintWidget.R();
                            aVar.f35862f = constraintWidget.v();
                            aVar.f35863g = constraintWidget.n();
                            return;
                        }
                    }
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    boolean z12 = dimensionBehaviour == dimensionBehaviour3;
                    boolean z13 = dimensionBehaviour2 == dimensionBehaviour3;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                    boolean z14 = dimensionBehaviour2 == dimensionBehaviour4 || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.FIXED;
                    boolean z15 = dimensionBehaviour == dimensionBehaviour4 || dimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED;
                    boolean z16 = z12 && constraintWidget.Z > 0.0f;
                    boolean z17 = z13 && constraintWidget.Z > 0.0f;
                    if (view != null) {
                        b bVar = (b) view.getLayoutParams();
                        int i25 = aVar.f35866j;
                        if (i25 == b.a.f35855l || i25 == b.a.f35856m || !z12 || constraintWidget.f1621s != 0 || !z13 || constraintWidget.f1623t != 0) {
                            if (!(view instanceof j) || !(constraintWidget instanceof g)) {
                                view.measure(i10, i11);
                            } else {
                                ((j) view).t((g) constraintWidget, i10, i11);
                            }
                            constraintWidget.M0(i10, i11);
                            int measuredWidth = view.getMeasuredWidth();
                            int measuredHeight = view.getMeasuredHeight();
                            i13 = view.getBaseline();
                            int i26 = constraintWidget.f1625v;
                            i12 = i26 > 0 ? Math.max(i26, measuredWidth) : measuredWidth;
                            int i27 = constraintWidget.f1626w;
                            if (i27 > 0) {
                                i12 = Math.min(i27, i12);
                            }
                            int i28 = constraintWidget.f1628y;
                            if (i28 > 0) {
                                i14 = Math.max(i28, measuredHeight);
                                i16 = i10;
                            } else {
                                i16 = i10;
                                i14 = measuredHeight;
                            }
                            int i29 = constraintWidget.f1629z;
                            if (i29 > 0) {
                                i14 = Math.min(i29, i14);
                            }
                            if (!f.b(ConstraintLayout.this.f1772i, 1)) {
                                if (z16 && z14) {
                                    i12 = (int) ((i14 * constraintWidget.Z) + 0.5f);
                                } else if (z17 && z15) {
                                    i14 = (int) ((i12 / constraintWidget.Z) + 0.5f);
                                }
                            }
                            if (!(measuredWidth == i12 && measuredHeight == i14)) {
                                int makeMeasureSpec = measuredWidth != i12 ? View.MeasureSpec.makeMeasureSpec(i12, 1073741824) : i16;
                                if (measuredHeight != i14) {
                                    i11 = View.MeasureSpec.makeMeasureSpec(i14, 1073741824);
                                }
                                view.measure(makeMeasureSpec, i11);
                                constraintWidget.M0(makeMeasureSpec, i11);
                                i12 = view.getMeasuredWidth();
                                i14 = view.getMeasuredHeight();
                                i13 = view.getBaseline();
                            }
                            i15 = -1;
                        } else {
                            i15 = -1;
                            i14 = 0;
                            i13 = 0;
                            i12 = 0;
                        }
                        boolean z18 = i13 != i15;
                        aVar.f35865i = (i12 == aVar.f35859c && i14 == aVar.f35860d) ? false : true;
                        if (bVar.f1787b0) {
                            z18 = true;
                        }
                        if (!(!z18 || i13 == -1 || constraintWidget.n() == i13)) {
                            aVar.f35865i = true;
                        }
                        aVar.f35861e = i12;
                        aVar.f35862f = i14;
                        aVar.f35864h = z18;
                        aVar.f35863g = i13;
                    }
                }
            }
        }

        public void c(int i10, int i11, int i12, int i13, int i14, int i15) {
            this.f1829b = i12;
            this.f1830c = i13;
            this.f1831d = i14;
            this.f1832e = i15;
            this.f1833f = i10;
            this.f1834g = i11;
        }
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        t(attributeSet, 0, 0);
    }

    private void C(ConstraintWidget constraintWidget, b bVar, SparseArray<ConstraintWidget> sparseArray, int i10, ConstraintAnchor.Type type) {
        View view = this.f1764a.get(i10);
        ConstraintWidget constraintWidget2 = sparseArray.get(i10);
        if (constraintWidget2 != null && view != null && (view.getLayoutParams() instanceof b)) {
            bVar.f1787b0 = true;
            ConstraintAnchor.Type type2 = ConstraintAnchor.Type.BASELINE;
            if (type == type2) {
                b bVar2 = (b) view.getLayoutParams();
                bVar2.f1787b0 = true;
                bVar2.f1817q0.B0(true);
            }
            constraintWidget.m(type2).a(constraintWidget2.m(type), bVar.C, bVar.B, true);
            constraintWidget.B0(true);
            constraintWidget.m(ConstraintAnchor.Type.TOP).p();
            constraintWidget.m(ConstraintAnchor.Type.BOTTOM).p();
        }
    }

    private boolean D() {
        int childCount = getChildCount();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= childCount) {
                break;
            } else if (getChildAt(i10).isLayoutRequested()) {
                z10 = true;
                break;
            } else {
                i10++;
            }
        }
        if (z10) {
            z();
        }
        return z10;
    }

    private int getPaddingWidth() {
        int i10 = 0;
        int max = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        if (Build.VERSION.SDK_INT >= 17) {
            i10 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        }
        return i10 > 0 ? i10 : max;
    }

    public static i getSharedValues() {
        if (f1763t == null) {
            f1763t = new i();
        }
        return f1763t;
    }

    private final ConstraintWidget q(int i10) {
        if (i10 == 0) {
            return this.f1766c;
        }
        View view = this.f1764a.get(i10);
        if (view == null && (view = findViewById(i10)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.f1766c;
        }
        if (view == null) {
            return null;
        }
        return ((b) view.getLayoutParams()).f1817q0;
    }

    private void t(AttributeSet attributeSet, int i10, int i11) {
        this.f1766c.s0(this);
        this.f1766c.L1(this.f1780q);
        this.f1764a.put(getId(), this);
        this.f1773j = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, h.T0, i10, i11);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i12 = 0; i12 < indexCount; i12++) {
                int index = obtainStyledAttributes.getIndex(i12);
                if (index == h.Y0) {
                    this.f1767d = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1767d);
                } else if (index == h.Z0) {
                    this.f1768e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1768e);
                } else if (index == h.W0) {
                    this.f1769f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1769f);
                } else if (index == h.X0) {
                    this.f1770g = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1770g);
                } else if (index == h.f2074m2) {
                    this.f1772i = obtainStyledAttributes.getInt(index, this.f1772i);
                } else if (index == h.f2034h1) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            w(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f1774k = null;
                        }
                    }
                } else if (index == h.f2010e1) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
                        this.f1773j = cVar;
                        cVar.m(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f1773j = null;
                    }
                    this.f1775l = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f1766c.M1(this.f1772i);
    }

    private void v() {
        this.f1771h = true;
        this.f1777n = -1;
        this.f1778o = -1;
    }

    private void z() {
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            ConstraintWidget s10 = s(getChildAt(i10));
            if (s10 != null) {
                s10.o0();
            }
        }
        if (isInEditMode) {
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    A(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    q(childAt.getId()).t0(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.f1775l != -1) {
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2.getId() == this.f1775l && (childAt2 instanceof d)) {
                    this.f1773j = ((d) childAt2).getConstraintSet();
                }
            }
        }
        androidx.constraintlayout.widget.c cVar = this.f1773j;
        if (cVar != null) {
            cVar.d(this, true);
        }
        this.f1766c.l1();
        int size = this.f1765b.size();
        if (size > 0) {
            for (int i13 = 0; i13 < size; i13++) {
                this.f1765b.get(i13).r(this);
            }
        }
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt3 = getChildAt(i14);
            if (childAt3 instanceof f) {
                ((f) childAt3).b(this);
            }
        }
        this.f1779p.clear();
        this.f1779p.put(0, this.f1766c);
        this.f1779p.put(getId(), this.f1766c);
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt4 = getChildAt(i15);
            this.f1779p.put(childAt4.getId(), s(childAt4));
        }
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt5 = getChildAt(i16);
            ConstraintWidget s11 = s(childAt5);
            if (s11 != null) {
                b bVar = (b) childAt5.getLayoutParams();
                this.f1766c.b(s11);
                g(isInEditMode, childAt5, s11, bVar, this.f1779p);
            }
        }
    }

    public void A(int i10, Object obj, Object obj2) {
        if (i10 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.f1776m == null) {
                this.f1776m = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.f1776m.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    protected void B(d dVar, int i10, int i11, int i12, int i13) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        c cVar = this.f1780q;
        int i14 = cVar.f1832e;
        int i15 = cVar.f1831d;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
        int childCount = getChildCount();
        if (i10 == Integer.MIN_VALUE) {
            dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                i11 = Math.max(0, this.f1767d);
            }
        } else if (i10 == 0) {
            dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                i11 = Math.max(0, this.f1767d);
            }
            i11 = 0;
        } else if (i10 != 1073741824) {
            dimensionBehaviour = dimensionBehaviour2;
            i11 = 0;
        } else {
            i11 = Math.min(this.f1769f - i15, i11);
            dimensionBehaviour = dimensionBehaviour2;
        }
        if (i12 == Integer.MIN_VALUE) {
            dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                i13 = Math.max(0, this.f1768e);
            }
        } else if (i12 != 0) {
            if (i12 == 1073741824) {
                i13 = Math.min(this.f1770g - i14, i13);
            }
            i13 = 0;
        } else {
            dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                i13 = Math.max(0, this.f1768e);
            }
            i13 = 0;
        }
        if (!(i11 == dVar.R() && i13 == dVar.v())) {
            dVar.D1();
        }
        dVar.d1(0);
        dVar.e1(0);
        dVar.O0(this.f1769f - i15);
        dVar.N0(this.f1770g - i14);
        dVar.R0(0);
        dVar.Q0(0);
        dVar.G0(dimensionBehaviour);
        dVar.b1(i11);
        dVar.X0(dimensionBehaviour2);
        dVar.C0(i13);
        dVar.R0(this.f1767d - i15);
        dVar.Q0(this.f1768e - i14);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<androidx.constraintlayout.widget.a> arrayList = this.f1765b;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i10 = 0; i10 < size; i10++) {
                this.f1765b.get(i10).q(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                if (!(childAt.getVisibility() == 8 || (tag = childAt.getTag()) == null || !(tag instanceof String))) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i12 = (int) ((parseInt / 1080.0f) * width);
                        int i13 = (int) ((parseInt2 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f10 = i12;
                        float f11 = i13;
                        float f12 = i12 + ((int) ((parseInt3 / 1080.0f) * width));
                        canvas.drawLine(f10, f11, f12, f11, paint);
                        float parseInt4 = i13 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                        canvas.drawLine(f12, f11, f12, parseInt4, paint);
                        canvas.drawLine(f12, parseInt4, f10, parseInt4, paint);
                        canvas.drawLine(f10, parseInt4, f10, f11, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f10, f11, f12, parseInt4, paint);
                        canvas.drawLine(f10, parseInt4, f12, f11, paint);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void forceLayout() {
        v();
        super.forceLayout();
    }

    protected void g(boolean z10, View view, ConstraintWidget constraintWidget, b bVar, SparseArray<ConstraintWidget> sparseArray) {
        float f10;
        int i10;
        int i11;
        int i12;
        int i13;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5;
        bVar.a();
        constraintWidget.a1(view.getVisibility());
        if (bVar.f1793e0) {
            constraintWidget.K0(true);
            constraintWidget.a1(8);
        }
        constraintWidget.s0(view);
        if (view instanceof androidx.constraintlayout.widget.a) {
            ((androidx.constraintlayout.widget.a) view).n(constraintWidget, this.f1766c.F1());
        }
        if (bVar.f1789c0) {
            e eVar = (e) constraintWidget;
            int i14 = bVar.f1811n0;
            int i15 = bVar.f1813o0;
            float f11 = bVar.f1815p0;
            if (Build.VERSION.SDK_INT < 17) {
                i14 = bVar.f1784a;
                i15 = bVar.f1786b;
                f11 = bVar.f1788c;
            }
            if (f11 != -1.0f) {
                eVar.q1(f11);
            } else if (i14 != -1) {
                eVar.o1(i14);
            } else if (i15 != -1) {
                eVar.p1(i15);
            }
        } else {
            int i16 = bVar.f1797g0;
            int i17 = bVar.f1799h0;
            int i18 = bVar.f1801i0;
            int i19 = bVar.f1803j0;
            int i20 = bVar.f1805k0;
            int i21 = bVar.f1807l0;
            float f12 = bVar.f1809m0;
            if (Build.VERSION.SDK_INT < 17) {
                i16 = bVar.f1790d;
                int i22 = bVar.f1792e;
                int i23 = bVar.f1794f;
                int i24 = bVar.f1796g;
                int i25 = bVar.f1822v;
                int i26 = bVar.f1824x;
                float f13 = bVar.D;
                if (i16 == -1 && i22 == -1) {
                    int i27 = bVar.f1819s;
                    if (i27 != -1) {
                        i16 = i27;
                    } else {
                        int i28 = bVar.f1818r;
                        if (i28 != -1) {
                            i22 = i28;
                        }
                    }
                }
                if (i23 == -1 && i24 == -1) {
                    i12 = bVar.f1820t;
                    if (i12 == -1) {
                        int i29 = bVar.f1821u;
                        if (i29 != -1) {
                            i10 = i26;
                            f10 = f13;
                            i20 = i25;
                            i11 = i29;
                            i17 = i22;
                            i12 = i23;
                        }
                    }
                    i10 = i26;
                    f10 = f13;
                    i20 = i25;
                    i11 = i24;
                    i17 = i22;
                }
                i12 = i23;
                i10 = i26;
                f10 = f13;
                i20 = i25;
                i11 = i24;
                i17 = i22;
            } else {
                i10 = i21;
                f10 = f12;
                i12 = i18;
                i11 = i19;
            }
            int i30 = bVar.f1812o;
            if (i30 != -1) {
                ConstraintWidget constraintWidget6 = sparseArray.get(i30);
                if (constraintWidget6 != null) {
                    constraintWidget.j(constraintWidget6, bVar.f1816q, bVar.f1814p);
                }
            } else {
                if (i16 != -1) {
                    ConstraintWidget constraintWidget7 = sparseArray.get(i16);
                    if (constraintWidget7 != null) {
                        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
                        constraintWidget.Z(type, constraintWidget7, type, ((ViewGroup.MarginLayoutParams) bVar).leftMargin, i20);
                    }
                } else if (!(i17 == -1 || (constraintWidget5 = sparseArray.get(i17)) == null)) {
                    constraintWidget.Z(ConstraintAnchor.Type.LEFT, constraintWidget5, ConstraintAnchor.Type.RIGHT, ((ViewGroup.MarginLayoutParams) bVar).leftMargin, i20);
                }
                if (i12 != -1) {
                    ConstraintWidget constraintWidget8 = sparseArray.get(i12);
                    if (constraintWidget8 != null) {
                        constraintWidget.Z(ConstraintAnchor.Type.RIGHT, constraintWidget8, ConstraintAnchor.Type.LEFT, ((ViewGroup.MarginLayoutParams) bVar).rightMargin, i10);
                    }
                } else if (!(i11 == -1 || (constraintWidget4 = sparseArray.get(i11)) == null)) {
                    ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
                    constraintWidget.Z(type2, constraintWidget4, type2, ((ViewGroup.MarginLayoutParams) bVar).rightMargin, i10);
                }
                int i31 = bVar.f1798h;
                if (i31 != -1) {
                    ConstraintWidget constraintWidget9 = sparseArray.get(i31);
                    if (constraintWidget9 != null) {
                        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.TOP;
                        constraintWidget.Z(type3, constraintWidget9, type3, ((ViewGroup.MarginLayoutParams) bVar).topMargin, bVar.f1823w);
                    }
                } else {
                    int i32 = bVar.f1800i;
                    if (!(i32 == -1 || (constraintWidget3 = sparseArray.get(i32)) == null)) {
                        constraintWidget.Z(ConstraintAnchor.Type.TOP, constraintWidget3, ConstraintAnchor.Type.BOTTOM, ((ViewGroup.MarginLayoutParams) bVar).topMargin, bVar.f1823w);
                    }
                }
                int i33 = bVar.f1802j;
                if (i33 != -1) {
                    ConstraintWidget constraintWidget10 = sparseArray.get(i33);
                    if (constraintWidget10 != null) {
                        constraintWidget.Z(ConstraintAnchor.Type.BOTTOM, constraintWidget10, ConstraintAnchor.Type.TOP, ((ViewGroup.MarginLayoutParams) bVar).bottomMargin, bVar.f1825y);
                    }
                } else {
                    int i34 = bVar.f1804k;
                    if (!(i34 == -1 || (constraintWidget2 = sparseArray.get(i34)) == null)) {
                        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
                        constraintWidget.Z(type4, constraintWidget2, type4, ((ViewGroup.MarginLayoutParams) bVar).bottomMargin, bVar.f1825y);
                    }
                }
                int i35 = bVar.f1806l;
                if (i35 != -1) {
                    C(constraintWidget, bVar, sparseArray, i35, ConstraintAnchor.Type.BASELINE);
                } else {
                    int i36 = bVar.f1808m;
                    if (i36 != -1) {
                        C(constraintWidget, bVar, sparseArray, i36, ConstraintAnchor.Type.TOP);
                    } else {
                        int i37 = bVar.f1810n;
                        if (i37 != -1) {
                            C(constraintWidget, bVar, sparseArray, i37, ConstraintAnchor.Type.BOTTOM);
                        }
                    }
                }
                if (f10 >= 0.0f) {
                    constraintWidget.D0(f10);
                }
                float f14 = bVar.E;
                if (f14 >= 0.0f) {
                    constraintWidget.U0(f14);
                }
            }
            if (z10 && !((i13 = bVar.S) == -1 && bVar.T == -1)) {
                constraintWidget.S0(i13, bVar.T);
            }
            if (bVar.Z) {
                constraintWidget.G0(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidget.b1(((ViewGroup.MarginLayoutParams) bVar).width);
                if (((ViewGroup.MarginLayoutParams) bVar).width == -2) {
                    constraintWidget.G0(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                }
            } else if (((ViewGroup.MarginLayoutParams) bVar).width == -1) {
                if (bVar.V) {
                    constraintWidget.G0(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                } else {
                    constraintWidget.G0(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                }
                constraintWidget.m(ConstraintAnchor.Type.LEFT).f1580g = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
                constraintWidget.m(ConstraintAnchor.Type.RIGHT).f1580g = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
            } else {
                constraintWidget.G0(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                constraintWidget.b1(0);
            }
            if (bVar.f1785a0) {
                constraintWidget.X0(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidget.C0(((ViewGroup.MarginLayoutParams) bVar).height);
                if (((ViewGroup.MarginLayoutParams) bVar).height == -2) {
                    constraintWidget.X0(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                }
            } else if (((ViewGroup.MarginLayoutParams) bVar).height == -1) {
                if (bVar.W) {
                    constraintWidget.X0(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                } else {
                    constraintWidget.X0(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                }
                constraintWidget.m(ConstraintAnchor.Type.TOP).f1580g = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
                constraintWidget.m(ConstraintAnchor.Type.BOTTOM).f1580g = ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
            } else {
                constraintWidget.X0(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                constraintWidget.C0(0);
            }
            constraintWidget.u0(bVar.F);
            constraintWidget.I0(bVar.G);
            constraintWidget.Z0(bVar.H);
            constraintWidget.E0(bVar.I);
            constraintWidget.V0(bVar.J);
            constraintWidget.c1(bVar.Y);
            constraintWidget.H0(bVar.K, bVar.M, bVar.O, bVar.Q);
            constraintWidget.Y0(bVar.L, bVar.N, bVar.P, bVar.R);
        }
    }

    public int getMaxHeight() {
        return this.f1770g;
    }

    public int getMaxWidth() {
        return this.f1769f;
    }

    public int getMinHeight() {
        return this.f1768e;
    }

    public int getMinWidth() {
        return this.f1767d;
    }

    public int getOptimizationLevel() {
        return this.f1766c.A1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public b generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    /* renamed from: i */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            b bVar = (b) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = bVar.f1817q0;
            if ((childAt.getVisibility() != 8 || bVar.f1789c0 || bVar.f1791d0 || bVar.f1795f0 || isInEditMode) && !bVar.f1793e0) {
                int S = constraintWidget.S();
                int T = constraintWidget.T();
                int R = constraintWidget.R() + S;
                int v10 = constraintWidget.v() + T;
                childAt.layout(S, T, R, v10);
                if ((childAt instanceof f) && (content = ((f) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(S, T, R, v10);
                }
            }
        }
        int size = this.f1765b.size();
        if (size > 0) {
            for (int i15 = 0; i15 < size; i15++) {
                this.f1765b.get(i15).o(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.f1781r == i10) {
            int i12 = this.f1782s;
        }
        if (!this.f1771h) {
            int childCount = getChildCount();
            int i13 = 0;
            while (true) {
                if (i13 >= childCount) {
                    break;
                } else if (getChildAt(i13).isLayoutRequested()) {
                    this.f1771h = true;
                    break;
                } else {
                    i13++;
                }
            }
        }
        boolean z10 = this.f1771h;
        this.f1781r = i10;
        this.f1782s = i11;
        this.f1766c.O1(u());
        if (this.f1771h) {
            this.f1771h = false;
            if (D()) {
                this.f1766c.Q1();
            }
        }
        y(this.f1766c, this.f1772i, i10, i11);
        x(i10, i11, this.f1766c.R(), this.f1766c.v(), this.f1766c.G1(), this.f1766c.E1());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        ConstraintWidget s10 = s(view);
        if ((view instanceof Guideline) && !(s10 instanceof e)) {
            b bVar = (b) view.getLayoutParams();
            e eVar = new e();
            bVar.f1817q0 = eVar;
            bVar.f1789c0 = true;
            eVar.r1(bVar.U);
        }
        if (view instanceof androidx.constraintlayout.widget.a) {
            androidx.constraintlayout.widget.a aVar = (androidx.constraintlayout.widget.a) view;
            aVar.s();
            ((b) view.getLayoutParams()).f1791d0 = true;
            if (!this.f1765b.contains(aVar)) {
                this.f1765b.add(aVar);
            }
        }
        this.f1764a.put(view.getId(), view);
        this.f1771h = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f1764a.remove(view.getId());
        this.f1766c.k1(s(view));
        this.f1765b.remove(view);
        this.f1771h = true;
    }

    public Object p(int i10, Object obj) {
        if (i10 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> hashMap = this.f1776m;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.f1776m.get(str);
    }

    public View r(int i10) {
        return this.f1764a.get(i10);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        v();
        super.requestLayout();
    }

    public final ConstraintWidget s(View view) {
        if (view == this) {
            return this.f1766c;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof b) {
            return ((b) view.getLayoutParams()).f1817q0;
        }
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof b) {
            return ((b) view.getLayoutParams()).f1817q0;
        }
        return null;
    }

    public void setConstraintSet(androidx.constraintlayout.widget.c cVar) {
        this.f1773j = cVar;
    }

    @Override // android.view.View
    public void setId(int i10) {
        this.f1764a.remove(getId());
        super.setId(i10);
        this.f1764a.put(getId(), this);
    }

    public void setMaxHeight(int i10) {
        if (i10 != this.f1770g) {
            this.f1770g = i10;
            requestLayout();
        }
    }

    public void setMaxWidth(int i10) {
        if (i10 != this.f1769f) {
            this.f1769f = i10;
            requestLayout();
        }
    }

    public void setMinHeight(int i10) {
        if (i10 != this.f1768e) {
            this.f1768e = i10;
            requestLayout();
        }
    }

    public void setMinWidth(int i10) {
        if (i10 != this.f1767d) {
            this.f1767d = i10;
            requestLayout();
        }
    }

    public void setOnConstraintsChanged(e eVar) {
        androidx.constraintlayout.widget.b bVar = this.f1774k;
        if (bVar != null) {
            bVar.c(eVar);
        }
    }

    public void setOptimizationLevel(int i10) {
        this.f1772i = i10;
        this.f1766c.M1(i10);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean u() {
        if (Build.VERSION.SDK_INT < 17) {
            return false;
        }
        return ((getContext().getApplicationInfo().flags & 4194304) != 0) && 1 == getLayoutDirection();
    }

    protected void w(int i10) {
        this.f1774k = new androidx.constraintlayout.widget.b(getContext(), this, i10);
    }

    protected void x(int i10, int i11, int i12, int i13, boolean z10, boolean z11) {
        c cVar = this.f1780q;
        int i14 = cVar.f1832e;
        int resolveSizeAndState = ViewGroup.resolveSizeAndState(i12 + cVar.f1831d, i10, 0);
        int min = Math.min(this.f1769f, resolveSizeAndState & 16777215);
        int min2 = Math.min(this.f1770g, ViewGroup.resolveSizeAndState(i13 + i14, i11, 0) & 16777215);
        if (z10) {
            min |= IntentInfo.FLAG_RECEIVER_INCLUDE_BACKGROUND;
        }
        if (z11) {
            min2 |= IntentInfo.FLAG_RECEIVER_INCLUDE_BACKGROUND;
        }
        setMeasuredDimension(min, min2);
        this.f1777n = min;
        this.f1778o = min2;
    }

    protected void y(d dVar, int i10, int i11, int i12) {
        int i13;
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        int max = Math.max(0, getPaddingTop());
        int max2 = Math.max(0, getPaddingBottom());
        int i14 = max + max2;
        int paddingWidth = getPaddingWidth();
        this.f1780q.c(i11, i12, max, max2, paddingWidth, i14);
        if (Build.VERSION.SDK_INT >= 17) {
            int max3 = Math.max(0, getPaddingStart());
            int max4 = Math.max(0, getPaddingEnd());
            if (max3 <= 0 && max4 <= 0) {
                max3 = Math.max(0, getPaddingLeft());
            } else if (u()) {
                max3 = max4;
            }
            i13 = max3;
        } else {
            i13 = Math.max(0, getPaddingLeft());
        }
        int i15 = size - paddingWidth;
        int i16 = size2 - i14;
        B(dVar, mode, i15, mode2, i16);
        dVar.H1(i10, mode, i15, mode2, i16, this.f1777n, this.f1778o, i13, max);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t(attributeSet, i10, 0);
    }

    /* loaded from: classes.dex */
    public static class b extends ViewGroup.MarginLayoutParams {
        public int A;
        public int B;
        public int C;
        public float D;
        public float E;
        public String F;
        public float G;
        public float H;
        public int I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public int O;
        public int P;
        public float Q;
        public float R;
        public int S;
        public int T;
        public int U;
        public boolean V;
        public boolean W;
        public String X;
        public int Y;
        boolean Z;

        /* renamed from: a  reason: collision with root package name */
        public int f1784a;

        /* renamed from: a0  reason: collision with root package name */
        boolean f1785a0;

        /* renamed from: b  reason: collision with root package name */
        public int f1786b;

        /* renamed from: b0  reason: collision with root package name */
        boolean f1787b0;

        /* renamed from: c  reason: collision with root package name */
        public float f1788c;

        /* renamed from: c0  reason: collision with root package name */
        boolean f1789c0;

        /* renamed from: d  reason: collision with root package name */
        public int f1790d;

        /* renamed from: d0  reason: collision with root package name */
        boolean f1791d0;

        /* renamed from: e  reason: collision with root package name */
        public int f1792e;

        /* renamed from: e0  reason: collision with root package name */
        boolean f1793e0;

        /* renamed from: f  reason: collision with root package name */
        public int f1794f;

        /* renamed from: f0  reason: collision with root package name */
        boolean f1795f0;

        /* renamed from: g  reason: collision with root package name */
        public int f1796g;

        /* renamed from: g0  reason: collision with root package name */
        int f1797g0;

        /* renamed from: h  reason: collision with root package name */
        public int f1798h;

        /* renamed from: h0  reason: collision with root package name */
        int f1799h0;

        /* renamed from: i  reason: collision with root package name */
        public int f1800i;

        /* renamed from: i0  reason: collision with root package name */
        int f1801i0;

        /* renamed from: j  reason: collision with root package name */
        public int f1802j;

        /* renamed from: j0  reason: collision with root package name */
        int f1803j0;

        /* renamed from: k  reason: collision with root package name */
        public int f1804k;

        /* renamed from: k0  reason: collision with root package name */
        int f1805k0;

        /* renamed from: l  reason: collision with root package name */
        public int f1806l;

        /* renamed from: l0  reason: collision with root package name */
        int f1807l0;

        /* renamed from: m  reason: collision with root package name */
        public int f1808m;

        /* renamed from: m0  reason: collision with root package name */
        float f1809m0;

        /* renamed from: n  reason: collision with root package name */
        public int f1810n;

        /* renamed from: n0  reason: collision with root package name */
        int f1811n0;

        /* renamed from: o  reason: collision with root package name */
        public int f1812o;

        /* renamed from: o0  reason: collision with root package name */
        int f1813o0;

        /* renamed from: p  reason: collision with root package name */
        public int f1814p;

        /* renamed from: p0  reason: collision with root package name */
        float f1815p0;

        /* renamed from: q  reason: collision with root package name */
        public float f1816q;

        /* renamed from: q0  reason: collision with root package name */
        ConstraintWidget f1817q0;

        /* renamed from: r  reason: collision with root package name */
        public int f1818r;

        /* renamed from: s  reason: collision with root package name */
        public int f1819s;

        /* renamed from: t  reason: collision with root package name */
        public int f1820t;

        /* renamed from: u  reason: collision with root package name */
        public int f1821u;

        /* renamed from: v  reason: collision with root package name */
        public int f1822v;

        /* renamed from: w  reason: collision with root package name */
        public int f1823w;

        /* renamed from: x  reason: collision with root package name */
        public int f1824x;

        /* renamed from: y  reason: collision with root package name */
        public int f1825y;

        /* renamed from: z  reason: collision with root package name */
        public int f1826z;

        /* loaded from: classes.dex */
        private static class a {

            /* renamed from: a  reason: collision with root package name */
            public static final SparseIntArray f1827a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f1827a = sparseIntArray;
                sparseIntArray.append(h.X1, 64);
                sparseIntArray.append(h.A1, 65);
                sparseIntArray.append(h.J1, 8);
                sparseIntArray.append(h.K1, 9);
                sparseIntArray.append(h.M1, 10);
                sparseIntArray.append(h.N1, 11);
                sparseIntArray.append(h.T1, 12);
                sparseIntArray.append(h.S1, 13);
                sparseIntArray.append(h.f2101q1, 14);
                sparseIntArray.append(h.f2094p1, 15);
                sparseIntArray.append(h.f2066l1, 16);
                sparseIntArray.append(h.f2080n1, 52);
                sparseIntArray.append(h.f2073m1, 53);
                sparseIntArray.append(h.f2107r1, 2);
                sparseIntArray.append(h.f2121t1, 3);
                sparseIntArray.append(h.f2114s1, 4);
                sparseIntArray.append(h.f1995c2, 49);
                sparseIntArray.append(h.f2003d2, 50);
                sparseIntArray.append(h.f2149x1, 5);
                sparseIntArray.append(h.f2156y1, 6);
                sparseIntArray.append(h.f2163z1, 7);
                sparseIntArray.append(h.U0, 1);
                sparseIntArray.append(h.O1, 17);
                sparseIntArray.append(h.P1, 18);
                sparseIntArray.append(h.f2142w1, 19);
                sparseIntArray.append(h.f2135v1, 20);
                sparseIntArray.append(h.f2035h2, 21);
                sparseIntArray.append(h.f2059k2, 22);
                sparseIntArray.append(h.f2043i2, 23);
                sparseIntArray.append(h.f2019f2, 24);
                sparseIntArray.append(h.f2051j2, 25);
                sparseIntArray.append(h.f2027g2, 26);
                sparseIntArray.append(h.f2011e2, 55);
                sparseIntArray.append(h.f2067l2, 54);
                sparseIntArray.append(h.F1, 29);
                sparseIntArray.append(h.U1, 30);
                sparseIntArray.append(h.f2128u1, 44);
                sparseIntArray.append(h.H1, 45);
                sparseIntArray.append(h.W1, 46);
                sparseIntArray.append(h.G1, 47);
                sparseIntArray.append(h.V1, 48);
                sparseIntArray.append(h.f2050j1, 27);
                sparseIntArray.append(h.f2042i1, 28);
                sparseIntArray.append(h.Y1, 31);
                sparseIntArray.append(h.B1, 32);
                sparseIntArray.append(h.f1979a2, 33);
                sparseIntArray.append(h.Z1, 34);
                sparseIntArray.append(h.f1987b2, 35);
                sparseIntArray.append(h.D1, 36);
                sparseIntArray.append(h.C1, 37);
                sparseIntArray.append(h.E1, 38);
                sparseIntArray.append(h.I1, 39);
                sparseIntArray.append(h.R1, 40);
                sparseIntArray.append(h.L1, 41);
                sparseIntArray.append(h.f2087o1, 42);
                sparseIntArray.append(h.f2058k1, 43);
                sparseIntArray.append(h.Q1, 51);
                sparseIntArray.append(h.f2081n2, 66);
            }
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1784a = -1;
            this.f1786b = -1;
            this.f1788c = -1.0f;
            this.f1790d = -1;
            this.f1792e = -1;
            this.f1794f = -1;
            this.f1796g = -1;
            this.f1798h = -1;
            this.f1800i = -1;
            this.f1802j = -1;
            this.f1804k = -1;
            this.f1806l = -1;
            this.f1808m = -1;
            this.f1810n = -1;
            this.f1812o = -1;
            this.f1814p = 0;
            this.f1816q = 0.0f;
            this.f1818r = -1;
            this.f1819s = -1;
            this.f1820t = -1;
            this.f1821u = -1;
            this.f1822v = Integer.MIN_VALUE;
            this.f1823w = Integer.MIN_VALUE;
            this.f1824x = Integer.MIN_VALUE;
            this.f1825y = Integer.MIN_VALUE;
            this.f1826z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = 0;
            this.D = 0.5f;
            this.E = 0.5f;
            this.F = null;
            this.G = -1.0f;
            this.H = -1.0f;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 1.0f;
            this.R = 1.0f;
            this.S = -1;
            this.T = -1;
            this.U = -1;
            this.V = false;
            this.W = false;
            this.X = null;
            this.Y = 0;
            this.Z = true;
            this.f1785a0 = true;
            this.f1787b0 = false;
            this.f1789c0 = false;
            this.f1791d0 = false;
            this.f1793e0 = false;
            this.f1795f0 = false;
            this.f1797g0 = -1;
            this.f1799h0 = -1;
            this.f1801i0 = -1;
            this.f1803j0 = -1;
            this.f1805k0 = Integer.MIN_VALUE;
            this.f1807l0 = Integer.MIN_VALUE;
            this.f1809m0 = 0.5f;
            this.f1817q0 = new ConstraintWidget();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.T0);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                int i11 = a.f1827a.get(index);
                switch (i11) {
                    case 1:
                        this.U = obtainStyledAttributes.getInt(index, this.U);
                        break;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.f1812o);
                        this.f1812o = resourceId;
                        if (resourceId == -1) {
                            this.f1812o = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.f1814p = obtainStyledAttributes.getDimensionPixelSize(index, this.f1814p);
                        break;
                    case 4:
                        float f10 = obtainStyledAttributes.getFloat(index, this.f1816q) % 360.0f;
                        this.f1816q = f10;
                        if (f10 < 0.0f) {
                            this.f1816q = (360.0f - f10) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.f1784a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1784a);
                        break;
                    case 6:
                        this.f1786b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1786b);
                        break;
                    case 7:
                        this.f1788c = obtainStyledAttributes.getFloat(index, this.f1788c);
                        break;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.f1790d);
                        this.f1790d = resourceId2;
                        if (resourceId2 == -1) {
                            this.f1790d = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.f1792e);
                        this.f1792e = resourceId3;
                        if (resourceId3 == -1) {
                            this.f1792e = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.f1794f);
                        this.f1794f = resourceId4;
                        if (resourceId4 == -1) {
                            this.f1794f = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.f1796g);
                        this.f1796g = resourceId5;
                        if (resourceId5 == -1) {
                            this.f1796g = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.f1798h);
                        this.f1798h = resourceId6;
                        if (resourceId6 == -1) {
                            this.f1798h = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.f1800i);
                        this.f1800i = resourceId7;
                        if (resourceId7 == -1) {
                            this.f1800i = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.f1802j);
                        this.f1802j = resourceId8;
                        if (resourceId8 == -1) {
                            this.f1802j = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.f1804k);
                        this.f1804k = resourceId9;
                        if (resourceId9 == -1) {
                            this.f1804k = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.f1806l);
                        this.f1806l = resourceId10;
                        if (resourceId10 == -1) {
                            this.f1806l = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.f1818r);
                        this.f1818r = resourceId11;
                        if (resourceId11 == -1) {
                            this.f1818r = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.f1819s);
                        this.f1819s = resourceId12;
                        if (resourceId12 == -1) {
                            this.f1819s = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.f1820t);
                        this.f1820t = resourceId13;
                        if (resourceId13 == -1) {
                            this.f1820t = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.f1821u);
                        this.f1821u = resourceId14;
                        if (resourceId14 == -1) {
                            this.f1821u = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.f1822v = obtainStyledAttributes.getDimensionPixelSize(index, this.f1822v);
                        break;
                    case 22:
                        this.f1823w = obtainStyledAttributes.getDimensionPixelSize(index, this.f1823w);
                        break;
                    case 23:
                        this.f1824x = obtainStyledAttributes.getDimensionPixelSize(index, this.f1824x);
                        break;
                    case 24:
                        this.f1825y = obtainStyledAttributes.getDimensionPixelSize(index, this.f1825y);
                        break;
                    case 25:
                        this.f1826z = obtainStyledAttributes.getDimensionPixelSize(index, this.f1826z);
                        break;
                    case 26:
                        this.A = obtainStyledAttributes.getDimensionPixelSize(index, this.A);
                        break;
                    case 27:
                        this.V = obtainStyledAttributes.getBoolean(index, this.V);
                        break;
                    case 28:
                        this.W = obtainStyledAttributes.getBoolean(index, this.W);
                        break;
                    case 29:
                        this.D = obtainStyledAttributes.getFloat(index, this.D);
                        break;
                    case 30:
                        this.E = obtainStyledAttributes.getFloat(index, this.E);
                        break;
                    case 31:
                        int i12 = obtainStyledAttributes.getInt(index, 0);
                        this.K = i12;
                        if (i12 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        int i13 = obtainStyledAttributes.getInt(index, 0);
                        this.L = i13;
                        if (i13 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 33:
                        try {
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.M) == -2) {
                                this.M = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.O = obtainStyledAttributes.getDimensionPixelSize(index, this.O);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.O) == -2) {
                                this.O = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.Q = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.Q));
                        this.K = 2;
                        break;
                    case 36:
                        try {
                            this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.N) == -2) {
                                this.N = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.P = obtainStyledAttributes.getDimensionPixelSize(index, this.P);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.P) == -2) {
                                this.P = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.R = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.R));
                        this.L = 2;
                        break;
                    default:
                        switch (i11) {
                            case 44:
                                androidx.constraintlayout.widget.c.r(this, obtainStyledAttributes.getString(index));
                                continue;
                            case 45:
                                this.G = obtainStyledAttributes.getFloat(index, this.G);
                                continue;
                            case 46:
                                this.H = obtainStyledAttributes.getFloat(index, this.H);
                                continue;
                            case 47:
                                this.I = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 48:
                                this.J = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 49:
                                this.S = obtainStyledAttributes.getDimensionPixelOffset(index, this.S);
                                continue;
                            case 50:
                                this.T = obtainStyledAttributes.getDimensionPixelOffset(index, this.T);
                                continue;
                            case 51:
                                this.X = obtainStyledAttributes.getString(index);
                                continue;
                            case 52:
                                int resourceId15 = obtainStyledAttributes.getResourceId(index, this.f1808m);
                                this.f1808m = resourceId15;
                                if (resourceId15 == -1) {
                                    this.f1808m = obtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    continue;
                                }
                            case 53:
                                int resourceId16 = obtainStyledAttributes.getResourceId(index, this.f1810n);
                                this.f1810n = resourceId16;
                                if (resourceId16 == -1) {
                                    this.f1810n = obtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    continue;
                                }
                            case 54:
                                this.C = obtainStyledAttributes.getDimensionPixelSize(index, this.C);
                                continue;
                            case 55:
                                this.B = obtainStyledAttributes.getDimensionPixelSize(index, this.B);
                                continue;
                            default:
                                switch (i11) {
                                    case 64:
                                        androidx.constraintlayout.widget.c.p(this, obtainStyledAttributes, index, 0);
                                        continue;
                                    case 65:
                                        androidx.constraintlayout.widget.c.p(this, obtainStyledAttributes, index, 1);
                                        continue;
                                    case 66:
                                        this.Y = obtainStyledAttributes.getInt(index, this.Y);
                                        continue;
                                        continue;
                                }
                        }
                }
            }
            obtainStyledAttributes.recycle();
            a();
        }

        public void a() {
            this.f1789c0 = false;
            this.Z = true;
            this.f1785a0 = true;
            int i10 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i10 == -2 && this.V) {
                this.Z = false;
                if (this.K == 0) {
                    this.K = 1;
                }
            }
            int i11 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i11 == -2 && this.W) {
                this.f1785a0 = false;
                if (this.L == 0) {
                    this.L = 1;
                }
            }
            if (i10 == 0 || i10 == -1) {
                this.Z = false;
                if (i10 == 0 && this.K == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.V = true;
                }
            }
            if (i11 == 0 || i11 == -1) {
                this.f1785a0 = false;
                if (i11 == 0 && this.L == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.W = true;
                }
            }
            if (this.f1788c != -1.0f || this.f1784a != -1 || this.f1786b != -1) {
                this.f1789c0 = true;
                this.Z = true;
                this.f1785a0 = true;
                if (!(this.f1817q0 instanceof e)) {
                    this.f1817q0 = new e();
                }
                ((e) this.f1817q0).r1(this.U);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0054  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0088  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x009a  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @TargetApi(17)
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void resolveLayoutDirection(int i10) {
            boolean z10;
            int i11;
            int i12;
            int i13;
            int i14;
            int i15 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
            int i16 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
            boolean z11 = false;
            if (Build.VERSION.SDK_INT >= 17) {
                super.resolveLayoutDirection(i10);
                if (1 == getLayoutDirection()) {
                    z10 = true;
                    this.f1801i0 = -1;
                    this.f1803j0 = -1;
                    this.f1797g0 = -1;
                    this.f1799h0 = -1;
                    this.f1805k0 = -1;
                    this.f1807l0 = -1;
                    this.f1805k0 = this.f1822v;
                    this.f1807l0 = this.f1824x;
                    float f10 = this.D;
                    this.f1809m0 = f10;
                    int i17 = this.f1784a;
                    this.f1811n0 = i17;
                    int i18 = this.f1786b;
                    this.f1813o0 = i18;
                    float f11 = this.f1788c;
                    this.f1815p0 = f11;
                    if (!z10) {
                        int i19 = this.f1818r;
                        if (i19 != -1) {
                            this.f1801i0 = i19;
                        } else {
                            int i20 = this.f1819s;
                            if (i20 != -1) {
                                this.f1803j0 = i20;
                            }
                            i11 = this.f1820t;
                            if (i11 != -1) {
                                this.f1799h0 = i11;
                                z11 = true;
                            }
                            i12 = this.f1821u;
                            if (i12 != -1) {
                                this.f1797g0 = i12;
                                z11 = true;
                            }
                            i13 = this.f1826z;
                            if (i13 != Integer.MIN_VALUE) {
                                this.f1807l0 = i13;
                            }
                            i14 = this.A;
                            if (i14 != Integer.MIN_VALUE) {
                                this.f1805k0 = i14;
                            }
                            if (z11) {
                                this.f1809m0 = 1.0f - f10;
                            }
                            if (this.f1789c0 && this.U == 1) {
                                if (f11 == -1.0f) {
                                    this.f1815p0 = 1.0f - f11;
                                    this.f1811n0 = -1;
                                    this.f1813o0 = -1;
                                } else if (i17 != -1) {
                                    this.f1813o0 = i17;
                                    this.f1811n0 = -1;
                                    this.f1815p0 = -1.0f;
                                } else if (i18 != -1) {
                                    this.f1811n0 = i18;
                                    this.f1813o0 = -1;
                                    this.f1815p0 = -1.0f;
                                }
                            }
                        }
                        z11 = true;
                        i11 = this.f1820t;
                        if (i11 != -1) {
                        }
                        i12 = this.f1821u;
                        if (i12 != -1) {
                        }
                        i13 = this.f1826z;
                        if (i13 != Integer.MIN_VALUE) {
                        }
                        i14 = this.A;
                        if (i14 != Integer.MIN_VALUE) {
                        }
                        if (z11) {
                        }
                        if (this.f1789c0) {
                            if (f11 == -1.0f) {
                            }
                        }
                    } else {
                        int i21 = this.f1818r;
                        if (i21 != -1) {
                            this.f1799h0 = i21;
                        }
                        int i22 = this.f1819s;
                        if (i22 != -1) {
                            this.f1797g0 = i22;
                        }
                        int i23 = this.f1820t;
                        if (i23 != -1) {
                            this.f1801i0 = i23;
                        }
                        int i24 = this.f1821u;
                        if (i24 != -1) {
                            this.f1803j0 = i24;
                        }
                        int i25 = this.f1826z;
                        if (i25 != Integer.MIN_VALUE) {
                            this.f1805k0 = i25;
                        }
                        int i26 = this.A;
                        if (i26 != Integer.MIN_VALUE) {
                            this.f1807l0 = i26;
                        }
                    }
                    if (this.f1820t == -1 && this.f1821u == -1 && this.f1819s == -1 && this.f1818r == -1) {
                        int i27 = this.f1794f;
                        if (i27 != -1) {
                            this.f1801i0 = i27;
                            if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i16 > 0) {
                                ((ViewGroup.MarginLayoutParams) this).rightMargin = i16;
                            }
                        } else {
                            int i28 = this.f1796g;
                            if (i28 != -1) {
                                this.f1803j0 = i28;
                                if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i16 > 0) {
                                    ((ViewGroup.MarginLayoutParams) this).rightMargin = i16;
                                }
                            }
                        }
                        int i29 = this.f1790d;
                        if (i29 != -1) {
                            this.f1797g0 = i29;
                            if (((ViewGroup.MarginLayoutParams) this).leftMargin <= 0 && i15 > 0) {
                                ((ViewGroup.MarginLayoutParams) this).leftMargin = i15;
                                return;
                            }
                            return;
                        }
                        int i30 = this.f1792e;
                        if (i30 != -1) {
                            this.f1799h0 = i30;
                            if (((ViewGroup.MarginLayoutParams) this).leftMargin <= 0 && i15 > 0) {
                                ((ViewGroup.MarginLayoutParams) this).leftMargin = i15;
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            z10 = false;
            this.f1801i0 = -1;
            this.f1803j0 = -1;
            this.f1797g0 = -1;
            this.f1799h0 = -1;
            this.f1805k0 = -1;
            this.f1807l0 = -1;
            this.f1805k0 = this.f1822v;
            this.f1807l0 = this.f1824x;
            float f102 = this.D;
            this.f1809m0 = f102;
            int i172 = this.f1784a;
            this.f1811n0 = i172;
            int i182 = this.f1786b;
            this.f1813o0 = i182;
            float f112 = this.f1788c;
            this.f1815p0 = f112;
            if (!z10) {
            }
            if (this.f1820t == -1) {
            }
        }

        public b(int i10, int i11) {
            super(i10, i11);
            this.f1784a = -1;
            this.f1786b = -1;
            this.f1788c = -1.0f;
            this.f1790d = -1;
            this.f1792e = -1;
            this.f1794f = -1;
            this.f1796g = -1;
            this.f1798h = -1;
            this.f1800i = -1;
            this.f1802j = -1;
            this.f1804k = -1;
            this.f1806l = -1;
            this.f1808m = -1;
            this.f1810n = -1;
            this.f1812o = -1;
            this.f1814p = 0;
            this.f1816q = 0.0f;
            this.f1818r = -1;
            this.f1819s = -1;
            this.f1820t = -1;
            this.f1821u = -1;
            this.f1822v = Integer.MIN_VALUE;
            this.f1823w = Integer.MIN_VALUE;
            this.f1824x = Integer.MIN_VALUE;
            this.f1825y = Integer.MIN_VALUE;
            this.f1826z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = 0;
            this.D = 0.5f;
            this.E = 0.5f;
            this.F = null;
            this.G = -1.0f;
            this.H = -1.0f;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 1.0f;
            this.R = 1.0f;
            this.S = -1;
            this.T = -1;
            this.U = -1;
            this.V = false;
            this.W = false;
            this.X = null;
            this.Y = 0;
            this.Z = true;
            this.f1785a0 = true;
            this.f1787b0 = false;
            this.f1789c0 = false;
            this.f1791d0 = false;
            this.f1793e0 = false;
            this.f1795f0 = false;
            this.f1797g0 = -1;
            this.f1799h0 = -1;
            this.f1801i0 = -1;
            this.f1803j0 = -1;
            this.f1805k0 = Integer.MIN_VALUE;
            this.f1807l0 = Integer.MIN_VALUE;
            this.f1809m0 = 0.5f;
            this.f1817q0 = new ConstraintWidget();
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1784a = -1;
            this.f1786b = -1;
            this.f1788c = -1.0f;
            this.f1790d = -1;
            this.f1792e = -1;
            this.f1794f = -1;
            this.f1796g = -1;
            this.f1798h = -1;
            this.f1800i = -1;
            this.f1802j = -1;
            this.f1804k = -1;
            this.f1806l = -1;
            this.f1808m = -1;
            this.f1810n = -1;
            this.f1812o = -1;
            this.f1814p = 0;
            this.f1816q = 0.0f;
            this.f1818r = -1;
            this.f1819s = -1;
            this.f1820t = -1;
            this.f1821u = -1;
            this.f1822v = Integer.MIN_VALUE;
            this.f1823w = Integer.MIN_VALUE;
            this.f1824x = Integer.MIN_VALUE;
            this.f1825y = Integer.MIN_VALUE;
            this.f1826z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = 0;
            this.D = 0.5f;
            this.E = 0.5f;
            this.F = null;
            this.G = -1.0f;
            this.H = -1.0f;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 1.0f;
            this.R = 1.0f;
            this.S = -1;
            this.T = -1;
            this.U = -1;
            this.V = false;
            this.W = false;
            this.X = null;
            this.Y = 0;
            this.Z = true;
            this.f1785a0 = true;
            this.f1787b0 = false;
            this.f1789c0 = false;
            this.f1791d0 = false;
            this.f1793e0 = false;
            this.f1795f0 = false;
            this.f1797g0 = -1;
            this.f1799h0 = -1;
            this.f1801i0 = -1;
            this.f1803j0 = -1;
            this.f1805k0 = Integer.MIN_VALUE;
            this.f1807l0 = Integer.MIN_VALUE;
            this.f1809m0 = 0.5f;
            this.f1817q0 = new ConstraintWidget();
        }
    }
}
