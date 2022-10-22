package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.appcompat.widget.c;
import androidx.appcompat.widget.k0;
import com.google.android.material.internal.e;
import com.google.android.material.internal.k;
import d7.b;
import d7.l;
/* compiled from: MaterialAutoCompleteTextView.java */
/* loaded from: classes.dex */
public class g extends c {

    /* renamed from: e  reason: collision with root package name */
    private final k0 f11553e;

    /* renamed from: f  reason: collision with root package name */
    private final AccessibilityManager f11554f;

    /* renamed from: g  reason: collision with root package name */
    private final Rect f11555g;

    /* compiled from: MaterialAutoCompleteTextView.java */
    /* loaded from: classes.dex */
    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            g.this.e(i10 < 0 ? g.this.f11553e.v() : g.this.getAdapter().getItem(i10));
            AdapterView.OnItemClickListener onItemClickListener = g.this.getOnItemClickListener();
            if (onItemClickListener != null) {
                if (view == null || i10 < 0) {
                    view = g.this.f11553e.y();
                    i10 = g.this.f11553e.x();
                    j10 = g.this.f11553e.w();
                }
                onItemClickListener.onItemClick(g.this.f11553e.k(), view, i10, j10);
            }
            g.this.f11553e.dismiss();
        }
    }

    public g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.f25147c);
    }

    private TextInputLayout c() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    private int d() {
        ListAdapter adapter = getAdapter();
        TextInputLayout c10 = c();
        int i10 = 0;
        if (adapter == null || c10 == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int min = Math.min(adapter.getCount(), Math.max(0, this.f11553e.x()) + 15);
        View view = null;
        int i11 = 0;
        for (int max = Math.max(0, min - 15); max < min; max++) {
            int itemViewType = adapter.getItemViewType(max);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = adapter.getView(max, view, c10);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i11 = Math.max(i11, view.getMeasuredWidth());
        }
        Drawable i12 = this.f11553e.i();
        if (i12 != null) {
            i12.getPadding(this.f11555g);
            Rect rect = this.f11555g;
            i11 += rect.left + rect.right;
        }
        return i11 + c10.getEndIconView().getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends ListAdapter & Filterable> void e(Object obj) {
        if (Build.VERSION.SDK_INT >= 17) {
            setText(convertSelectionToString(obj), false);
            return;
        }
        ListAdapter adapter = getAdapter();
        setAdapter(null);
        setText(convertSelectionToString(obj));
        setAdapter(adapter);
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout c10 = c();
        if (c10 == null || !c10.P()) {
            return super.getHint();
        }
        return c10.getHint();
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout c10 = c();
        if (c10 != null && c10.P() && super.getHint() == null && e.c()) {
            setHint("");
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (View.MeasureSpec.getMode(i10) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), d()), View.MeasureSpec.getSize(i10)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t10) {
        super.setAdapter(t10);
        this.f11553e.p(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        AccessibilityManager accessibilityManager = this.f11554f;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            super.showDropDown();
        } else {
            this.f11553e.a();
        }
    }

    public g(Context context, AttributeSet attributeSet, int i10) {
        super(x7.a.c(context, attributeSet, i10, 0), attributeSet, i10);
        this.f11555g = new Rect();
        Context context2 = getContext();
        TypedArray h10 = k.h(context2, attributeSet, l.X1, i10, d7.k.f25342g, new int[0]);
        int i11 = l.Y1;
        if (h10.hasValue(i11) && h10.getInt(i11, 0) == 0) {
            setKeyListener(null);
        }
        this.f11554f = (AccessibilityManager) context2.getSystemService("accessibility");
        k0 k0Var = new k0(context2);
        this.f11553e = k0Var;
        k0Var.J(true);
        k0Var.D(this);
        k0Var.I(2);
        k0Var.p(getAdapter());
        k0Var.L(new a());
        h10.recycle();
    }
}
