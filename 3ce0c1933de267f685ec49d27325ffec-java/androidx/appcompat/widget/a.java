package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.d0;
import androidx.core.view.i0;
import androidx.core.view.j0;
import d.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbsActionBarView.java */
/* loaded from: classes.dex */
public abstract class a extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    protected final C0007a f1060a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f1061b;

    /* renamed from: c  reason: collision with root package name */
    protected ActionMenuView f1062c;

    /* renamed from: d  reason: collision with root package name */
    protected ActionMenuPresenter f1063d;

    /* renamed from: e  reason: collision with root package name */
    protected int f1064e;

    /* renamed from: f  reason: collision with root package name */
    protected i0 f1065f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1066g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1067h;

    /* compiled from: AbsActionBarView.java */
    /* renamed from: androidx.appcompat.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    protected class C0007a implements j0 {

        /* renamed from: a  reason: collision with root package name */
        private boolean f1068a = false;

        /* renamed from: b  reason: collision with root package name */
        int f1069b;

        protected C0007a() {
        }

        @Override // androidx.core.view.j0
        public void a(View view) {
            this.f1068a = true;
        }

        @Override // androidx.core.view.j0
        public void b(View view) {
            if (!this.f1068a) {
                a aVar = a.this;
                aVar.f1065f = null;
                a.super.setVisibility(this.f1069b);
            }
        }

        @Override // androidx.core.view.j0
        public void c(View view) {
            a.super.setVisibility(0);
            this.f1068a = false;
        }

        public C0007a d(i0 i0Var, int i10) {
            a.this.f1065f = i0Var;
            this.f1069b = i10;
            return this;
        }
    }

    a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int d(int i10, int i11, boolean z10) {
        return z10 ? i10 - i11 : i10 + i11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c(View view, int i10, int i11, int i12) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i10, Integer.MIN_VALUE), i11);
        return Math.max(0, (i10 - view.getMeasuredWidth()) - i12);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int e(View view, int i10, int i11, int i12, boolean z10) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i13 = i11 + ((i12 - measuredHeight) / 2);
        if (z10) {
            view.layout(i10 - measuredWidth, i13, i10, measuredHeight + i13);
        } else {
            view.layout(i10, i13, i10 + measuredWidth, measuredHeight + i13);
        }
        return z10 ? -measuredWidth : measuredWidth;
    }

    public i0 f(int i10, long j10) {
        i0 i0Var = this.f1065f;
        if (i0Var != null) {
            i0Var.b();
        }
        if (i10 == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            i0 a10 = d0.e(this).a(1.0f);
            a10.d(j10);
            a10.f(this.f1060a.d(a10, i10));
            return a10;
        }
        i0 a11 = d0.e(this).a(0.0f);
        a11.d(j10);
        a11.f(this.f1060a.d(a11, i10));
        return a11;
    }

    public int getAnimatedVisibility() {
        if (this.f1065f != null) {
            return this.f1060a.f1069b;
        }
        return getVisibility();
    }

    public int getContentHeight() {
        return this.f1064e;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, j.f24854a, d.a.f24715c, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(j.f24899j, 0));
        obtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.f1063d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.H(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1067h = false;
        }
        if (!this.f1067h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f1067h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1067h = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1066g = false;
        }
        if (!this.f1066g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f1066g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1066g = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i10);

    @Override // android.view.View
    public void setVisibility(int i10) {
        if (i10 != getVisibility()) {
            i0 i0Var = this.f1065f;
            if (i0Var != null) {
                i0Var.b();
            }
            super.setVisibility(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f1060a = new C0007a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(d.a.f24713a, typedValue, true) || typedValue.resourceId == 0) {
            this.f1061b = context;
        } else {
            this.f1061b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }
}
