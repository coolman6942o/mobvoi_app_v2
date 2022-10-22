package com.mobvoi.health.companion.ui;

import a0.h;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;
import fg.p;
import fg.r;
import fg.w;
import java.util.List;
import java.util.Locale;
/* loaded from: classes2.dex */
public class DatePicker extends LinearLayout {
    private int A;
    private c B;
    private b C;
    private float D;
    private long E;
    private float F;
    private VelocityTracker G;
    private int H;
    private int I;
    private int J;
    private boolean K;
    private a L;
    private boolean N;
    private int O;
    private int P;

    /* renamed from: a  reason: collision with root package name */
    private int f19053a;

    /* renamed from: b  reason: collision with root package name */
    private int f19054b;

    /* renamed from: d  reason: collision with root package name */
    private final int f19056d;

    /* renamed from: e  reason: collision with root package name */
    protected final boolean f19057e;

    /* renamed from: f  reason: collision with root package name */
    protected final int f19058f;

    /* renamed from: g  reason: collision with root package name */
    protected final int f19059g;

    /* renamed from: h  reason: collision with root package name */
    private String[] f19060h;

    /* renamed from: i  reason: collision with root package name */
    private int f19061i;

    /* renamed from: j  reason: collision with root package name */
    private int f19062j;

    /* renamed from: k  reason: collision with root package name */
    protected int f19063k;

    /* renamed from: l  reason: collision with root package name */
    private f f19064l;

    /* renamed from: m  reason: collision with root package name */
    private e f19065m;

    /* renamed from: n  reason: collision with root package name */
    private d f19066n;

    /* renamed from: q  reason: collision with root package name */
    protected int[] f19069q;

    /* renamed from: r  reason: collision with root package name */
    protected final Paint f19070r;

    /* renamed from: s  reason: collision with root package name */
    protected Paint f19071s;

    /* renamed from: t  reason: collision with root package name */
    protected float f19072t;

    /* renamed from: v  reason: collision with root package name */
    protected int f19074v;

    /* renamed from: x  reason: collision with root package name */
    protected int f19076x;

    /* renamed from: y  reason: collision with root package name */
    private final Scroller f19077y;

    /* renamed from: z  reason: collision with root package name */
    private final Scroller f19078z;

    /* renamed from: c  reason: collision with root package name */
    private boolean f19055c = true;

    /* renamed from: o  reason: collision with root package name */
    private long f19067o = 300;

    /* renamed from: p  reason: collision with root package name */
    protected final SparseArray<String> f19068p = new SparseArray<>();

    /* renamed from: u  reason: collision with root package name */
    private Rect f19073u = new Rect();

    /* renamed from: w  reason: collision with root package name */
    private int f19075w = Integer.MIN_VALUE;
    private int M = 0;
    private int Q = -1;
    private boolean R = false;

    /* loaded from: classes2.dex */
    class a extends AccessibilityNodeProvider {

        /* renamed from: a  reason: collision with root package name */
        private int f19079a = Integer.MIN_VALUE;

        a() {
            new Rect();
        }

        private AccessibilityNodeInfo a(int i10, int i11, int i12, int i13) {
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
            obtain.setClassName(DatePicker.class.getName());
            obtain.setPackageName(DatePicker.this.getContext().getPackageName());
            obtain.setSource(DatePicker.this);
            obtain.setParent((View) DatePicker.this.getParentForAccessibility());
            obtain.setEnabled(DatePicker.this.isEnabled());
            obtain.setScrollable(true);
            if (this.f19079a != -1) {
                obtain.addAction(64);
            }
            if (this.f19079a == -1) {
                obtain.addAction(128);
            }
            if (DatePicker.this.isEnabled()) {
                if (DatePicker.this.getWrapSelectorWheel() || DatePicker.this.getValue() < DatePicker.this.getMaxValue()) {
                    obtain.addAction(4096);
                }
                if (DatePicker.this.getWrapSelectorWheel() || DatePicker.this.getValue() > DatePicker.this.getMinValue()) {
                    obtain.addAction(8192);
                }
            }
            return obtain;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i10) {
            if (i10 != -1) {
                return super.createAccessibilityNodeInfo(i10);
            }
            return a(DatePicker.this.getScrollX(), DatePicker.this.getScrollY(), DatePicker.this.getScrollX() + (DatePicker.this.getRight() - DatePicker.this.getLeft()), DatePicker.this.getScrollY() + (DatePicker.this.getBottom() - DatePicker.this.getTop()));
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i10) {
            return super.findAccessibilityNodeInfosByText(str, i10);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i10, int i11, Bundle bundle) {
            if (i10 == -1) {
                if (i11 != 64) {
                    if (i11 != 128) {
                        if (i11 != 4096) {
                            if (i11 == 8192) {
                                if (!DatePicker.this.isEnabled() || (!DatePicker.this.getWrapSelectorWheel() && DatePicker.this.getValue() <= DatePicker.this.getMinValue())) {
                                    return false;
                                }
                                DatePicker.this.b(false);
                                return true;
                            }
                        } else if (!DatePicker.this.isEnabled() || (!DatePicker.this.getWrapSelectorWheel() && DatePicker.this.getValue() >= DatePicker.this.getMaxValue())) {
                            return false;
                        } else {
                            DatePicker.this.b(true);
                            return true;
                        }
                    } else if (this.f19079a != i10) {
                        return false;
                    } else {
                        this.f19079a = Integer.MIN_VALUE;
                        return true;
                    }
                } else if (this.f19079a == i10) {
                    return false;
                } else {
                    this.f19079a = i10;
                    return true;
                }
            }
            return super.performAction(i10, i11, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DatePicker.this.performLongClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private boolean f19082a;

        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(boolean z10) {
            this.f19082a = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            DatePicker.this.b(this.f19082a);
            DatePicker datePicker = DatePicker.this;
            datePicker.postDelayed(this, datePicker.f19067o);
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        String format(int i10);
    }

    /* loaded from: classes2.dex */
    public interface e {
        void k(DatePicker datePicker, int i10);
    }

    /* loaded from: classes2.dex */
    public interface f {
        void g(DatePicker datePicker, int i10, int i11);
    }

    public DatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19053a = 3;
        this.f19054b = 3 / 2;
        this.f19069q = new int[this.f19053a];
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, w.f27014d, 0, 0);
        boolean z10 = obtainStyledAttributes.getBoolean(w.f27016f, false);
        this.f19057e = z10;
        int i10 = obtainStyledAttributes.getInt(w.f27020j, 3);
        this.f19053a = i10;
        this.f19054b = i10 / 2;
        this.f19069q = new int[i10];
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.H = viewConfiguration.getScaledTouchSlop();
        this.I = viewConfiguration.getScaledMinimumFlingVelocity();
        this.J = viewConfiguration.getScaledMaximumFlingVelocity() / 8;
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(w.f27019i, getResources().getDimensionPixelSize(p.f26503e));
        this.f19056d = dimensionPixelSize;
        this.f19058f = obtainStyledAttributes.getColor(w.f27017g, -7829368);
        int color = obtainStyledAttributes.getColor(w.f27018h, -1);
        this.f19059g = color;
        Typeface h10 = h.h(context, obtainStyledAttributes.getResourceId(w.f27015e, r.f26645b));
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(dimensionPixelSize);
        paint.setColor(color);
        paint.setTypeface(h10);
        this.f19070r = paint;
        if (z10) {
            this.f19072t = getResources().getDimensionPixelSize(p.f26499c);
            Paint paint2 = new Paint();
            this.f19071s = paint2;
            paint2.setStrokeCap(Paint.Cap.ROUND);
            this.f19071s.setAntiAlias(true);
            this.f19071s.setStyle(Paint.Style.FILL);
            this.f19071s.setStrokeWidth(this.f19072t);
            this.f19071s.setColor(color);
            this.f19071s.getTextBounds(String.valueOf(0), 0, 1, this.f19073u);
        }
        this.f19077y = new Scroller(getContext(), null, true);
        this.f19078z = new Scroller(getContext(), new DecelerateInterpolator(2.5f));
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        obtainStyledAttributes.recycle();
    }

    private void A() {
        h();
    }

    private void B() {
        boolean z10 = true;
        if (!(this.f19062j - this.f19061i >= this.f19069q.length) || !this.f19055c) {
            z10 = false;
        }
        this.K = z10;
    }

    private void d(int[] iArr) {
        for (int length = iArr.length - 1; length > 0; length--) {
            iArr[length] = iArr[length - 1];
        }
        int i10 = iArr[1] - 1;
        if (this.K && i10 < this.f19061i) {
            i10 = this.f19062j;
        }
        iArr[0] = i10;
        e(i10);
    }

    private void e(int i10) {
        String str;
        SparseArray<String> sparseArray = this.f19068p;
        if (sparseArray.get(i10) == null) {
            int i11 = this.f19061i;
            if (i10 < i11 || i10 > this.f19062j) {
                str = "";
            } else {
                int i12 = i10 - i11;
                String[] strArr = this.f19060h;
                if (strArr == null || strArr.length <= i12) {
                    str = i(i10);
                } else {
                    str = strArr[i12];
                }
            }
            sparseArray.put(i10, str);
        }
    }

    private void g(int i10) {
        this.A = 0;
        if (i10 > 0) {
            this.f19077y.fling(0, 0, i10, 0, 0, Integer.MAX_VALUE, 0, 0);
        } else {
            this.f19077y.fling(Integer.MAX_VALUE, 0, i10, 0, 0, Integer.MAX_VALUE, 0, 0);
        }
        invalidate();
    }

    private void h() {
        if (hasFocusable() && !hasFocus()) {
            requestFocus();
        }
    }

    private String i(int i10) {
        d dVar = this.f19066n;
        return dVar != null ? dVar.format(i10) : j(i10);
    }

    private static String j(int i10) {
        return String.format(Locale.getDefault(), "%d", Integer.valueOf(i10));
    }

    private int k(int i10) {
        int i11 = this.f19062j;
        if (i10 > i11) {
            int i12 = this.f19061i;
            return (i12 + ((i10 - i11) % (i11 - i12))) - 1;
        }
        int i13 = this.f19061i;
        return i10 < i13 ? (i11 - ((i13 - i10) % (i11 - i13))) + 1 : i10;
    }

    private void l() {
    }

    private void m(int[] iArr) {
        int i10 = 0;
        while (i10 < iArr.length - 1) {
            int i11 = i10 + 1;
            iArr[i10] = iArr[i11];
            i10 = i11;
        }
        int i12 = iArr[iArr.length - 2] + 1;
        if (this.K && i12 > this.f19062j) {
            i12 = this.f19061i;
        }
        iArr[iArr.length - 1] = i12;
        e(i12);
    }

    private void n() {
        setHorizontalFadingEdgeEnabled(true);
        setFadingEdgeLength(((getRight() - getLeft()) - (this.f19074v / 2)) / 2);
    }

    private void o() {
        p();
        this.f19074v = getWidth() / this.f19069q.length;
        this.f19075w = 0;
        this.f19076x = 0;
    }

    private void p() {
        this.f19068p.clear();
        int[] iArr = this.f19069q;
        int value = getValue();
        for (int i10 = 0; i10 < this.f19069q.length; i10++) {
            int i11 = (i10 - this.f19054b) + value;
            if (this.K) {
                i11 = k(i11);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("selectorIndices=");
            sb2.append(i10);
            sb2.append(",index=");
            sb2.append(i11);
            iArr[i10] = i11;
            e(iArr[i10]);
        }
    }

    private boolean q(Scroller scroller) {
        scroller.forceFinished(true);
        int finalY = scroller.getFinalY() - scroller.getCurrY();
        int i10 = this.f19075w - ((this.f19076x + finalY) % this.f19074v);
        if (i10 == 0) {
            return false;
        }
        int abs = Math.abs(i10);
        int i11 = this.f19074v;
        if (abs > i11 / 2) {
            i10 = i10 > 0 ? i10 - i11 : i10 + i11;
        }
        scrollBy((finalY + i10) % i11, 0);
        return true;
    }

    private void r(int i10, int i11) {
        f fVar = this.f19064l;
        if (fVar != null) {
            fVar.g(this, i10, this.f19063k);
        }
    }

    private void s(int i10) {
        if (this.M != i10) {
            if (i10 == 1 || i10 == 2) {
                h();
            }
            this.M = i10;
            e eVar = this.f19065m;
            if (eVar != null) {
                eVar.k(this, i10);
            }
        }
    }

    private void t(Scroller scroller) {
        if (scroller == this.f19077y) {
            f();
            s(0);
        }
    }

    private void u() {
        b bVar = this.C;
        if (bVar == null) {
            this.C = new b();
        } else {
            removeCallbacks(bVar);
        }
        postDelayed(this.C, ViewConfiguration.getLongPressTimeout());
    }

    private void v(boolean z10, long j10) {
        c cVar = this.B;
        if (cVar == null) {
            this.B = new c();
        } else {
            removeCallbacks(cVar);
        }
        this.B.b(z10);
        postDelayed(this.B, j10);
    }

    private void w() {
        c cVar = this.B;
        if (cVar != null) {
            removeCallbacks(cVar);
        }
        b bVar = this.C;
        if (bVar != null) {
            removeCallbacks(bVar);
        }
    }

    private void x() {
        b bVar = this.C;
        if (bVar != null) {
            removeCallbacks(bVar);
        }
    }

    private void y() {
        c cVar = this.B;
        if (cVar != null) {
            removeCallbacks(cVar);
        }
    }

    private void z(int i10, boolean z10) {
        int i11;
        if (this.f19063k != i10) {
            if (this.K) {
                i11 = k(i10);
            } else {
                i11 = Math.min(Math.max(i10, this.f19061i), this.f19062j);
            }
            int i12 = this.f19063k;
            this.f19063k = i11;
            if (z10) {
                r(i12, i11);
            }
            p();
            invalidate();
        }
    }

    public void b(boolean z10) {
        if (this.f19074v > 0) {
            if (!q(this.f19077y)) {
                q(this.f19078z);
            }
            this.A = 0;
            if (z10) {
                this.f19077y.startScroll(0, 0, -this.f19074v, 0, 300);
            } else {
                this.f19077y.startScroll(0, 0, this.f19074v, 0, 300);
            }
            invalidate();
        }
    }

    public void c(boolean z10, int i10) {
        if (this.f19074v > 0) {
            if (!q(this.f19077y)) {
                q(this.f19078z);
            }
            this.A = 0;
            if (z10) {
                this.f19077y.startScroll(0, 0, (-this.f19074v) * i10, 0, 300);
            } else {
                this.f19077y.startScroll(0, 0, this.f19074v * i10, 0, 300);
            }
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollExtent() {
        return getWidth();
    }

    @Override // android.view.View
    protected int computeHorizontalScrollOffset() {
        return this.f19076x;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return ((this.f19062j - this.f19061i) + 1) * this.f19074v;
    }

    @Override // android.view.View
    public void computeScroll() {
        Scroller scroller = this.f19077y;
        if (scroller.isFinished()) {
            scroller = this.f19078z;
            if (scroller.isFinished()) {
                return;
            }
        }
        scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        if (this.A == 0) {
            this.A = scroller.getStartX();
        }
        scrollBy(currX - this.A, 0);
        this.A = currX;
        if (scroller.isFinished()) {
            t(scroller);
        } else {
            invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 19 || keyCode == 20) {
            int action = keyEvent.getAction();
            if (action == 0) {
                if (!this.K) {
                    if (keyCode == 20) {
                    }
                }
                requestFocus();
                this.Q = keyCode;
                w();
                if (this.f19077y.isFinished()) {
                    b(keyCode == 20);
                }
                return true;
            } else if (action == 1 && this.Q == keyCode) {
                this.Q = -1;
                return true;
            }
        } else if (keyCode == 23 || keyCode == 66) {
            w();
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            w();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            w();
        }
        return super.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getDrawableState();
    }

    public boolean f() {
        int i10 = this.f19075w - this.f19076x;
        if (i10 == 0) {
            return false;
        }
        this.A = 0;
        int abs = Math.abs(i10);
        int i11 = this.f19074v;
        if (abs > i11 / 2) {
            if (i10 > 0) {
                i11 = -i11;
            }
            i10 += i11;
        }
        this.f19078z.startScroll(0, 0, i10, 0, 800);
        invalidate();
        return true;
    }

    @Override // android.view.View
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        if (this.L == null) {
            this.L = new a();
        }
        return this.L;
    }

    public String[] getDisplayedValues() {
        return this.f19060h;
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        return 0.9f;
    }

    public int getMaxValue() {
        return this.f19062j;
    }

    public int getMinValue() {
        return this.f19061i;
    }

    @Override // android.view.View
    protected float getRightFadingEdgeStrength() {
        return 0.9f;
    }

    public int getValue() {
        return this.f19063k;
    }

    public boolean getWrapSelectorWheel() {
        return this.K;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        w();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        float f10 = this.f19076x;
        int[] iArr = this.f19069q;
        this.f19070r.setColor(this.f19059g);
        this.f19070r.setTextAlign(Paint.Align.CENTER);
        for (int i10 : iArr) {
            String str = this.f19068p.get(i10);
            if (this.f19063k != i10) {
                this.f19070r.setColor(this.f19058f);
            } else if (this.f19057e) {
                this.f19070r.setColor(-1);
                canvas.drawPoint((this.f19074v / 2) + f10, getHeight() / 2, this.f19071s);
            } else {
                this.f19070r.setColor(this.f19059g);
            }
            canvas.drawText(str, (this.f19074v / 2) + f10, (getHeight() / 2) - ((this.f19070r.ascent() + this.f19070r.descent()) / 2.0f), this.f19070r);
            f10 += this.f19074v;
        }
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        if (z10) {
            Log.i("DatePicker", "Picker " + this + " focused.");
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(DatePicker.class.getName());
        accessibilityEvent.setScrollable(true);
        accessibilityEvent.setScrollX((this.f19061i + this.f19063k) * this.f19074v);
        accessibilityEvent.setMaxScrollX((this.f19062j - this.f19061i) * this.f19074v);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        w();
        float x10 = motionEvent.getX();
        this.D = x10;
        this.F = x10;
        this.E = motionEvent.getEventTime();
        this.N = false;
        if (!this.f19077y.isFinished()) {
            this.f19077y.forceFinished(true);
            this.f19078z.forceFinished(true);
            s(0);
        } else if (!this.f19078z.isFinished()) {
            this.f19077y.forceFinished(true);
            this.f19078z.forceFinished(true);
        } else {
            float f10 = this.D;
            if (f10 < this.O) {
                Log.d("DatePicker", "mLastDownEventX < mTopSelectionDividerTop");
                l();
                v(false, ViewConfiguration.getLongPressTimeout());
            } else if (f10 > this.P) {
                Log.d("DatePicker", "mLastDownEventX > mBottomSelectionDividerBottom");
                l();
                v(true, ViewConfiguration.getLongPressTimeout());
            } else {
                this.N = true;
                u();
            }
        }
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            o();
            n();
            int width = getWidth();
            int i14 = this.f19074v;
            int i15 = (width - i14) / 2;
            this.O = i15;
            this.P = i15 + i14;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.G == null) {
            this.G = VelocityTracker.obtain();
        }
        this.G.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            x();
            y();
            VelocityTracker velocityTracker = this.G;
            velocityTracker.computeCurrentVelocity(1000, this.J);
            int xVelocity = (int) velocityTracker.getXVelocity();
            Log.d("DatePicker", "ACTION_UP initialVelocity=" + xVelocity + ",mMinimumFlingVelocity=" + this.I);
            if (Math.abs(xVelocity) > this.I) {
                g(xVelocity);
                s(2);
            } else {
                int x10 = (int) motionEvent.getX();
                int abs = (int) Math.abs(x10 - this.D);
                long eventTime = motionEvent.getEventTime() - this.E;
                Log.d("DatePicker", "ACTION_UP deltaMoveX=" + abs + ",mTouchSlop=" + this.H + ",deltaTime=" + eventTime);
                if (abs > this.H || eventTime >= ViewConfiguration.getTapTimeout()) {
                    f();
                } else {
                    Log.d("DatePicker", "deltaMoveX <= mTouchSlop && deltaTime < ViewConfiguration.getTapTimeout()");
                    if (this.N) {
                        this.N = false;
                        performClick();
                    } else {
                        int i10 = (x10 / this.f19074v) - this.f19054b;
                        if (i10 > 0) {
                            b(true);
                        } else if (i10 < 0) {
                            b(false);
                        }
                    }
                }
                s(0);
            }
            this.G.recycle();
            this.G = null;
        } else if (actionMasked == 2) {
            float x11 = motionEvent.getX();
            if (this.M == 1) {
                scrollBy((int) (x11 - this.F), 0);
                invalidate();
            } else if (((int) Math.abs(x11 - this.D)) > this.H) {
                w();
                s(1);
            }
            this.F = x11;
        } else if (actionMasked == 3) {
            f();
        }
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        if (super.performClick() || !this.R) {
            return true;
        }
        A();
        return true;
    }

    @Override // android.view.View
    public boolean performLongClick() {
        return super.performLongClick();
    }

    @Override // android.view.View
    public void scrollBy(int i10, int i11) {
        int[] iArr = this.f19069q;
        boolean z10 = this.K;
        if (!z10 && i10 > 0 && iArr[this.f19054b] <= this.f19061i) {
            this.f19076x = this.f19075w;
        } else if (z10 || i10 >= 0 || iArr[this.f19054b] < this.f19062j) {
            this.f19076x += i10;
            while (true) {
                int i12 = this.f19076x;
                int i13 = this.f19074v;
                if (i12 > i13 / 2) {
                    this.f19076x = i12 - i13;
                    d(iArr);
                    z(iArr[this.f19054b], true);
                    if (!this.K && iArr[this.f19054b] <= this.f19061i) {
                        this.f19076x = this.f19075w;
                    }
                }
            }
            while (true) {
                int i14 = this.f19076x;
                int i15 = this.f19074v;
                if (i14 < (-i15) / 2) {
                    this.f19076x = i14 + i15;
                    m(iArr);
                    z(iArr[this.f19054b], true);
                    if (!this.K && iArr[this.f19054b] >= this.f19062j) {
                        this.f19076x = this.f19075w;
                    }
                } else {
                    return;
                }
            }
        } else {
            this.f19076x = this.f19075w;
        }
    }

    public void setDisplayedValues(String[] strArr) {
        if (this.f19060h != strArr) {
            this.f19060h = strArr;
            p();
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
    }

    public void setFormatter(d dVar) {
        if (dVar != this.f19066n) {
            this.f19066n = dVar;
            p();
        }
    }

    public void setIndecseNumber(int i10) {
        this.f19053a = i10;
        this.f19054b = i10 / 2;
        this.f19069q = new int[i10];
        o();
        B();
        invalidate();
    }

    public void setMaxValue(int i10) {
        if (this.f19062j != i10) {
            if (i10 >= 0) {
                this.f19062j = i10;
                if (i10 < this.f19063k) {
                    this.f19063k = i10;
                }
                B();
                p();
                invalidate();
                return;
            }
            throw new IllegalArgumentException("maxValue must be >= 0");
        }
    }

    public void setMinValue(int i10) {
        if (this.f19061i != i10) {
            if (i10 >= 0) {
                this.f19061i = i10;
                if (i10 > this.f19063k) {
                    this.f19063k = i10;
                }
                B();
                p();
                invalidate();
                return;
            }
            throw new IllegalArgumentException("minValue must be >= 0");
        }
    }

    public void setOnLongPressUpdateInterval(long j10) {
        this.f19067o = j10;
    }

    public void setOnScrollListener(e eVar) {
        this.f19065m = eVar;
    }

    public void setOnValueChangedListener(f fVar) {
        this.f19064l = fVar;
    }

    public void setValue(int i10) {
        z(i10, false);
    }

    public void setWrapSelectorWheel(boolean z10) {
        this.f19055c = z10;
        B();
    }
}
