package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.LinearLayoutCompat;
/* compiled from: ScrollingTabContainerView.java */
/* loaded from: classes.dex */
public class q0 extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    Runnable f1292a;

    /* renamed from: b  reason: collision with root package name */
    private c f1293b;

    /* renamed from: c  reason: collision with root package name */
    LinearLayoutCompat f1294c;

    /* renamed from: d  reason: collision with root package name */
    private Spinner f1295d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1296e;

    /* renamed from: f  reason: collision with root package name */
    int f1297f;

    /* renamed from: g  reason: collision with root package name */
    int f1298g;

    /* renamed from: h  reason: collision with root package name */
    private int f1299h;

    /* renamed from: i  reason: collision with root package name */
    private int f1300i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScrollingTabContainerView.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f1301a;

        a(View view) {
            this.f1301a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            q0.this.smoothScrollTo(this.f1301a.getLeft() - ((q0.this.getWidth() - this.f1301a.getWidth()) / 2), 0);
            q0.this.f1292a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ScrollingTabContainerView.java */
    /* loaded from: classes.dex */
    public class b extends BaseAdapter {
        b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return q0.this.f1294c.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            return ((d) q0.this.f1294c.getChildAt(i10)).b();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                return q0.this.c((a.c) getItem(i10), true);
            }
            ((d) view).a((a.c) getItem(i10));
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ScrollingTabContainerView.java */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((d) view).b().e();
            int childCount = q0.this.f1294c.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = q0.this.f1294c.getChildAt(i10);
                childAt.setSelected(childAt == view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ScrollingTabContainerView.java */
    /* loaded from: classes.dex */
    public class d extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        private final int[] f1305a;

        /* renamed from: b  reason: collision with root package name */
        private a.c f1306b;

        /* renamed from: c  reason: collision with root package name */
        private TextView f1307c;

        /* renamed from: d  reason: collision with root package name */
        private ImageView f1308d;

        /* renamed from: e  reason: collision with root package name */
        private View f1309e;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public d(Context context, a.c cVar, boolean z10) {
            super(context, null, r5);
            int i10 = d.a.f24716d;
            int[] iArr = {16842964};
            this.f1305a = iArr;
            this.f1306b = cVar;
            x0 v10 = x0.v(context, null, iArr, i10, 0);
            if (v10.s(0)) {
                setBackgroundDrawable(v10.g(0));
            }
            v10.w();
            if (z10) {
                setGravity(8388627);
            }
            c();
        }

        public void a(a.c cVar) {
            this.f1306b = cVar;
            c();
        }

        public a.c b() {
            return this.f1306b;
        }

        public void c() {
            a.c cVar = this.f1306b;
            View b10 = cVar.b();
            CharSequence charSequence = null;
            if (b10 != null) {
                ViewParent parent = b10.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(b10);
                    }
                    addView(b10);
                }
                this.f1309e = b10;
                TextView textView = this.f1307c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f1308d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f1308d.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f1309e;
            if (view != null) {
                removeView(view);
                this.f1309e = null;
            }
            Drawable c10 = cVar.c();
            CharSequence d10 = cVar.d();
            if (c10 != null) {
                if (this.f1308d == null) {
                    q qVar = new q(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    qVar.setLayoutParams(layoutParams);
                    addView(qVar, 0);
                    this.f1308d = qVar;
                }
                this.f1308d.setImageDrawable(c10);
                this.f1308d.setVisibility(0);
            } else {
                ImageView imageView2 = this.f1308d;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f1308d.setImageDrawable(null);
                }
            }
            boolean z10 = !TextUtils.isEmpty(d10);
            if (z10) {
                if (this.f1307c == null) {
                    b0 b0Var = new b0(getContext(), null, d.a.f24717e);
                    b0Var.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    b0Var.setLayoutParams(layoutParams2);
                    addView(b0Var);
                    this.f1307c = b0Var;
                }
                this.f1307c.setText(d10);
                this.f1307c.setVisibility(0);
            } else {
                TextView textView2 = this.f1307c;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f1307c.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f1308d;
            if (imageView3 != null) {
                imageView3.setContentDescription(cVar.a());
            }
            if (!z10) {
                charSequence = cVar.a();
            }
            a1.a(this, charSequence);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            super.onMeasure(i10, i11);
            if (q0.this.f1297f > 0) {
                int measuredWidth = getMeasuredWidth();
                int i12 = q0.this.f1297f;
                if (measuredWidth > i12) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), i11);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z10) {
            boolean z11 = isSelected() != z10;
            super.setSelected(z10);
            if (z11 && z10) {
                sendAccessibilityEvent(4);
            }
        }
    }

    static {
        new DecelerateInterpolator();
    }

    private Spinner b() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, d.a.f24720h);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.a(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    private boolean d() {
        Spinner spinner = this.f1295d;
        return spinner != null && spinner.getParent() == this;
    }

    private void e() {
        if (!d()) {
            if (this.f1295d == null) {
                this.f1295d = b();
            }
            removeView(this.f1294c);
            addView(this.f1295d, new ViewGroup.LayoutParams(-2, -1));
            if (this.f1295d.getAdapter() == null) {
                this.f1295d.setAdapter((SpinnerAdapter) new b());
            }
            Runnable runnable = this.f1292a;
            if (runnable != null) {
                removeCallbacks(runnable);
                this.f1292a = null;
            }
            this.f1295d.setSelection(this.f1300i);
        }
    }

    private boolean f() {
        if (!d()) {
            return false;
        }
        removeView(this.f1295d);
        addView(this.f1294c, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f1295d.getSelectedItemPosition());
        return false;
    }

    public void a(int i10) {
        View childAt = this.f1294c.getChildAt(i10);
        Runnable runnable = this.f1292a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        a aVar = new a(childAt);
        this.f1292a = aVar;
        post(aVar);
    }

    d c(a.c cVar, boolean z10) {
        d dVar = new d(getContext(), cVar, z10);
        if (z10) {
            dVar.setBackgroundDrawable(null);
            dVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.f1299h));
        } else {
            dVar.setFocusable(true);
            if (this.f1293b == null) {
                this.f1293b = new c();
            }
            dVar.setOnClickListener(this.f1293b);
        }
        return dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f1292a;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        i.a b10 = i.a.b(getContext());
        setContentHeight(b10.f());
        this.f1298g = b10.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f1292a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
        ((d) view).b().e();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        boolean z10 = true;
        boolean z11 = mode == 1073741824;
        setFillViewport(z11);
        int childCount = this.f1294c.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f1297f = -1;
        } else {
            if (childCount > 2) {
                this.f1297f = (int) (View.MeasureSpec.getSize(i10) * 0.4f);
            } else {
                this.f1297f = View.MeasureSpec.getSize(i10) / 2;
            }
            this.f1297f = Math.min(this.f1297f, this.f1298g);
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f1299h, 1073741824);
        if (z11 || !this.f1296e) {
            z10 = false;
        }
        if (z10) {
            this.f1294c.measure(0, makeMeasureSpec);
            if (this.f1294c.getMeasuredWidth() > View.MeasureSpec.getSize(i10)) {
                e();
            } else {
                f();
            }
        } else {
            f();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i10, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (z11 && measuredWidth != measuredWidth2) {
            setTabSelected(this.f1300i);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z10) {
        this.f1296e = z10;
    }

    public void setContentHeight(int i10) {
        this.f1299h = i10;
        requestLayout();
    }

    public void setTabSelected(int i10) {
        this.f1300i = i10;
        int childCount = this.f1294c.getChildCount();
        int i11 = 0;
        while (i11 < childCount) {
            View childAt = this.f1294c.getChildAt(i11);
            boolean z10 = i11 == i10;
            childAt.setSelected(z10);
            if (z10) {
                a(i10);
            }
            i11++;
        }
        Spinner spinner = this.f1295d;
        if (spinner != null && i10 >= 0) {
            spinner.setSelection(i10);
        }
    }
}
