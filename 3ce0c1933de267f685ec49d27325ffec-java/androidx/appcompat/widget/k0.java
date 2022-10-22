package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.core.view.d0;
import androidx.core.widget.i;
import d.j;
import java.lang.reflect.Method;
/* compiled from: ListPopupWindow.java */
/* loaded from: classes.dex */
public class k0 implements j.e {
    private static Method F;
    private static Method G;
    private static Method H;
    final Handler A;
    private final Rect B;
    private Rect C;
    private boolean D;
    PopupWindow E;

    /* renamed from: a  reason: collision with root package name */
    private Context f1221a;

    /* renamed from: b  reason: collision with root package name */
    private ListAdapter f1222b;

    /* renamed from: c  reason: collision with root package name */
    h0 f1223c;

    /* renamed from: d  reason: collision with root package name */
    private int f1224d;

    /* renamed from: e  reason: collision with root package name */
    private int f1225e;

    /* renamed from: f  reason: collision with root package name */
    private int f1226f;

    /* renamed from: g  reason: collision with root package name */
    private int f1227g;

    /* renamed from: h  reason: collision with root package name */
    private int f1228h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1229i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f1230j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1231k;

    /* renamed from: l  reason: collision with root package name */
    private int f1232l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f1233m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f1234n;

    /* renamed from: o  reason: collision with root package name */
    int f1235o;

    /* renamed from: p  reason: collision with root package name */
    private View f1236p;

    /* renamed from: q  reason: collision with root package name */
    private int f1237q;

    /* renamed from: r  reason: collision with root package name */
    private DataSetObserver f1238r;

    /* renamed from: s  reason: collision with root package name */
    private View f1239s;

    /* renamed from: t  reason: collision with root package name */
    private Drawable f1240t;

    /* renamed from: u  reason: collision with root package name */
    private AdapterView.OnItemClickListener f1241u;

    /* renamed from: v  reason: collision with root package name */
    private AdapterView.OnItemSelectedListener f1242v;

    /* renamed from: w  reason: collision with root package name */
    final g f1243w;

    /* renamed from: x  reason: collision with root package name */
    private final f f1244x;

    /* renamed from: y  reason: collision with root package name */
    private final e f1245y;

    /* renamed from: z  reason: collision with root package name */
    private final c f1246z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ListPopupWindow.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View t10 = k0.this.t();
            if (t10 != null && t10.getWindowToken() != null) {
                k0.this.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ListPopupWindow.java */
    /* loaded from: classes.dex */
    public class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            h0 h0Var;
            if (i10 != -1 && (h0Var = k0.this.f1223c) != null) {
                h0Var.setListSelectionHidden(false);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ListPopupWindow.java */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k0.this.r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ListPopupWindow.java */
    /* loaded from: classes.dex */
    public class d extends DataSetObserver {
        d() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (k0.this.b()) {
                k0.this.a();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            k0.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ListPopupWindow.java */
    /* loaded from: classes.dex */
    public class e implements AbsListView.OnScrollListener {
        e() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i10) {
            if (i10 == 1 && !k0.this.A() && k0.this.E.getContentView() != null) {
                k0 k0Var = k0.this;
                k0Var.A.removeCallbacks(k0Var.f1243w);
                k0.this.f1243w.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ListPopupWindow.java */
    /* loaded from: classes.dex */
    public class f implements View.OnTouchListener {
        f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = k0.this.E) != null && popupWindow.isShowing() && x10 >= 0 && x10 < k0.this.E.getWidth() && y10 >= 0 && y10 < k0.this.E.getHeight()) {
                k0 k0Var = k0.this;
                k0Var.A.postDelayed(k0Var.f1243w, 250L);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                k0 k0Var2 = k0.this;
                k0Var2.A.removeCallbacks(k0Var2.f1243w);
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ListPopupWindow.java */
    /* loaded from: classes.dex */
    public class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h0 h0Var = k0.this.f1223c;
            if (h0Var != null && d0.W(h0Var) && k0.this.f1223c.getCount() > k0.this.f1223c.getChildCount()) {
                int childCount = k0.this.f1223c.getChildCount();
                k0 k0Var = k0.this;
                if (childCount <= k0Var.f1235o) {
                    k0Var.E.setInputMethodMode(2);
                    k0.this.a();
                }
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                F = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                H = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                G = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public k0(Context context) {
        this(context, null, d.a.G);
    }

    private void C() {
        View view = this.f1236p;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1236p);
            }
        }
    }

    private void N(boolean z10) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = F;
            if (method != null) {
                try {
                    method.invoke(this.E, Boolean.valueOf(z10));
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            this.E.setIsClippedToScreen(z10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int q() {
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z10 = true;
        if (this.f1223c == null) {
            Context context = this.f1221a;
            new a();
            h0 s10 = s(context, !this.D);
            this.f1223c = s10;
            Drawable drawable = this.f1240t;
            if (drawable != null) {
                s10.setSelector(drawable);
            }
            this.f1223c.setAdapter(this.f1222b);
            this.f1223c.setOnItemClickListener(this.f1241u);
            this.f1223c.setFocusable(true);
            this.f1223c.setFocusableInTouchMode(true);
            this.f1223c.setOnItemSelectedListener(new b());
            this.f1223c.setOnScrollListener(this.f1245y);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f1242v;
            if (onItemSelectedListener != null) {
                this.f1223c.setOnItemSelectedListener(onItemSelectedListener);
            }
            h0 h0Var = this.f1223c;
            View view = this.f1236p;
            if (view != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i14 = this.f1237q;
                if (i14 == 0) {
                    linearLayout.addView(view);
                    linearLayout.addView(h0Var, layoutParams);
                } else if (i14 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.f1237q);
                } else {
                    linearLayout.addView(h0Var, layoutParams);
                    linearLayout.addView(view);
                }
                int i15 = this.f1225e;
                if (i15 >= 0) {
                    i13 = Integer.MIN_VALUE;
                } else {
                    i15 = 0;
                    i13 = 0;
                }
                view.measure(View.MeasureSpec.makeMeasureSpec(i15, i13), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
                i10 = view.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                h0Var = linearLayout;
            } else {
                i10 = 0;
            }
            this.E.setContentView(h0Var);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.E.getContentView();
            View view2 = this.f1236p;
            if (view2 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i10 = view2.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                i10 = 0;
            }
        }
        Drawable background = this.E.getBackground();
        if (background != null) {
            background.getPadding(this.B);
            Rect rect = this.B;
            int i16 = rect.top;
            i11 = rect.bottom + i16;
            if (!this.f1229i) {
                this.f1227g = -i16;
            }
        } else {
            this.B.setEmpty();
            i11 = 0;
        }
        if (this.E.getInputMethodMode() != 2) {
            z10 = false;
        }
        int u10 = u(t(), this.f1227g, z10);
        if (this.f1233m || this.f1224d == -1) {
            return u10 + i11;
        }
        int i17 = this.f1225e;
        if (i17 == -2) {
            int i18 = this.f1221a.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.B;
            i12 = View.MeasureSpec.makeMeasureSpec(i18 - (rect2.left + rect2.right), Integer.MIN_VALUE);
        } else if (i17 != -1) {
            i12 = View.MeasureSpec.makeMeasureSpec(i17, 1073741824);
        } else {
            int i19 = this.f1221a.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.B;
            i12 = View.MeasureSpec.makeMeasureSpec(i19 - (rect3.left + rect3.right), 1073741824);
        }
        int d10 = this.f1223c.d(i12, 0, -1, u10 - i10, -1);
        if (d10 > 0) {
            i10 += i11 + this.f1223c.getPaddingTop() + this.f1223c.getPaddingBottom();
        }
        return d10 + i10;
    }

    private int u(View view, int i10, boolean z10) {
        if (Build.VERSION.SDK_INT > 23) {
            return this.E.getMaxAvailableHeight(view, i10, z10);
        }
        Method method = G;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.E, view, Integer.valueOf(i10), Boolean.valueOf(z10))).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.E.getMaxAvailableHeight(view, i10);
    }

    public boolean A() {
        return this.E.getInputMethodMode() == 2;
    }

    public boolean B() {
        return this.D;
    }

    public void D(View view) {
        this.f1239s = view;
    }

    public void E(int i10) {
        this.E.setAnimationStyle(i10);
    }

    public void F(int i10) {
        Drawable background = this.E.getBackground();
        if (background != null) {
            background.getPadding(this.B);
            Rect rect = this.B;
            this.f1225e = rect.left + rect.right + i10;
            return;
        }
        Q(i10);
    }

    public void G(int i10) {
        this.f1232l = i10;
    }

    public void H(Rect rect) {
        this.C = rect != null ? new Rect(rect) : null;
    }

    public void I(int i10) {
        this.E.setInputMethodMode(i10);
    }

    public void J(boolean z10) {
        this.D = z10;
        this.E.setFocusable(z10);
    }

    public void K(PopupWindow.OnDismissListener onDismissListener) {
        this.E.setOnDismissListener(onDismissListener);
    }

    public void L(AdapterView.OnItemClickListener onItemClickListener) {
        this.f1241u = onItemClickListener;
    }

    public void M(boolean z10) {
        this.f1231k = true;
        this.f1230j = z10;
    }

    public void O(int i10) {
        this.f1237q = i10;
    }

    public void P(int i10) {
        h0 h0Var = this.f1223c;
        if (b() && h0Var != null) {
            h0Var.setListSelectionHidden(false);
            h0Var.setSelection(i10);
            if (h0Var.getChoiceMode() != 0) {
                h0Var.setItemChecked(i10, true);
            }
        }
    }

    public void Q(int i10) {
        this.f1225e = i10;
    }

    @Override // j.e
    public void a() {
        int q5 = q();
        boolean A = A();
        i.b(this.E, this.f1228h);
        boolean z10 = true;
        if (!this.E.isShowing()) {
            int i10 = this.f1225e;
            if (i10 == -1) {
                i10 = -1;
            } else if (i10 == -2) {
                i10 = t().getWidth();
            }
            int i11 = this.f1224d;
            if (i11 == -1) {
                q5 = -1;
            } else if (i11 != -2) {
                q5 = i11;
            }
            this.E.setWidth(i10);
            this.E.setHeight(q5);
            N(true);
            this.E.setOutsideTouchable(!this.f1234n && !this.f1233m);
            this.E.setTouchInterceptor(this.f1244x);
            if (this.f1231k) {
                i.a(this.E, this.f1230j);
            }
            if (Build.VERSION.SDK_INT <= 28) {
                Method method = H;
                if (method != null) {
                    try {
                        method.invoke(this.E, this.C);
                    } catch (Exception e10) {
                        Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e10);
                    }
                }
            } else {
                this.E.setEpicenterBounds(this.C);
            }
            i.c(this.E, t(), this.f1226f, this.f1227g, this.f1232l);
            this.f1223c.setSelection(-1);
            if (!this.D || this.f1223c.isInTouchMode()) {
                r();
            }
            if (!this.D) {
                this.A.post(this.f1246z);
            }
        } else if (d0.W(t())) {
            int i12 = this.f1225e;
            if (i12 == -1) {
                i12 = -1;
            } else if (i12 == -2) {
                i12 = t().getWidth();
            }
            int i13 = this.f1224d;
            if (i13 == -1) {
                if (!A) {
                    q5 = -1;
                }
                if (A) {
                    this.E.setWidth(this.f1225e == -1 ? -1 : 0);
                    this.E.setHeight(0);
                } else {
                    this.E.setWidth(this.f1225e == -1 ? -1 : 0);
                    this.E.setHeight(-1);
                }
            } else if (i13 != -2) {
                q5 = i13;
            }
            PopupWindow popupWindow = this.E;
            if (this.f1234n || this.f1233m) {
                z10 = false;
            }
            popupWindow.setOutsideTouchable(z10);
            this.E.update(t(), this.f1226f, this.f1227g, i12 < 0 ? -1 : i12, q5 < 0 ? -1 : q5);
        }
    }

    @Override // j.e
    public boolean b() {
        return this.E.isShowing();
    }

    public void c(Drawable drawable) {
        this.E.setBackgroundDrawable(drawable);
    }

    public int d() {
        return this.f1226f;
    }

    @Override // j.e
    public void dismiss() {
        this.E.dismiss();
        C();
        this.E.setContentView(null);
        this.f1223c = null;
        this.A.removeCallbacks(this.f1243w);
    }

    public void f(int i10) {
        this.f1226f = i10;
    }

    public Drawable i() {
        return this.E.getBackground();
    }

    @Override // j.e
    public ListView k() {
        return this.f1223c;
    }

    public void l(int i10) {
        this.f1227g = i10;
        this.f1229i = true;
    }

    public int o() {
        if (!this.f1229i) {
            return 0;
        }
        return this.f1227g;
    }

    public void p(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f1238r;
        if (dataSetObserver == null) {
            this.f1238r = new d();
        } else {
            ListAdapter listAdapter2 = this.f1222b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f1222b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f1238r);
        }
        h0 h0Var = this.f1223c;
        if (h0Var != null) {
            h0Var.setAdapter(this.f1222b);
        }
    }

    public void r() {
        h0 h0Var = this.f1223c;
        if (h0Var != null) {
            h0Var.setListSelectionHidden(true);
            h0Var.requestLayout();
        }
    }

    h0 s(Context context, boolean z10) {
        return new h0(context, z10);
    }

    public View t() {
        return this.f1239s;
    }

    public Object v() {
        if (!b()) {
            return null;
        }
        return this.f1223c.getSelectedItem();
    }

    public long w() {
        if (!b()) {
            return Long.MIN_VALUE;
        }
        return this.f1223c.getSelectedItemId();
    }

    public int x() {
        if (!b()) {
            return -1;
        }
        return this.f1223c.getSelectedItemPosition();
    }

    public View y() {
        if (!b()) {
            return null;
        }
        return this.f1223c.getSelectedView();
    }

    public int z() {
        return this.f1225e;
    }

    public k0(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public k0(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f1224d = -2;
        this.f1225e = -2;
        this.f1228h = 1002;
        this.f1232l = 0;
        this.f1233m = false;
        this.f1234n = false;
        this.f1235o = Integer.MAX_VALUE;
        this.f1237q = 0;
        this.f1243w = new g();
        this.f1244x = new f();
        this.f1245y = new e();
        this.f1246z = new c();
        this.B = new Rect();
        this.f1221a = context;
        this.A = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f24931p1, i10, i11);
        this.f1226f = obtainStyledAttributes.getDimensionPixelOffset(j.f24936q1, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(j.f24941r1, 0);
        this.f1227g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f1229i = true;
        }
        obtainStyledAttributes.recycle();
        s sVar = new s(context, attributeSet, i10, i11);
        this.E = sVar;
        sVar.setInputMethodMode(1);
    }
}
