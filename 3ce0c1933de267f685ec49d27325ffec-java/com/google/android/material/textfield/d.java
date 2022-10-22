package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.core.view.d0;
import com.google.android.material.textfield.TextInputLayout;
import w7.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DropdownMenuEndIconDelegate.java */
/* loaded from: classes.dex */
public class d extends com.google.android.material.textfield.e {

    /* renamed from: r  reason: collision with root package name */
    private static final boolean f11494r;

    /* renamed from: e  reason: collision with root package name */
    private final TextWatcher f11495e = new a();

    /* renamed from: f  reason: collision with root package name */
    private final View.OnFocusChangeListener f11496f = new c();

    /* renamed from: g  reason: collision with root package name */
    private final TextInputLayout.e f11497g = new C0134d(this.f11523a);

    /* renamed from: h  reason: collision with root package name */
    private final TextInputLayout.f f11498h = new e();
    @SuppressLint({"ClickableViewAccessibility"})

    /* renamed from: i  reason: collision with root package name */
    private final TextInputLayout.g f11499i = new f();

    /* renamed from: j  reason: collision with root package name */
    private boolean f11500j = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f11501k = false;

    /* renamed from: l  reason: collision with root package name */
    private long f11502l = Long.MAX_VALUE;

    /* renamed from: m  reason: collision with root package name */
    private StateListDrawable f11503m;

    /* renamed from: n  reason: collision with root package name */
    private w7.g f11504n;

    /* renamed from: o  reason: collision with root package name */
    private AccessibilityManager f11505o;

    /* renamed from: p  reason: collision with root package name */
    private ValueAnimator f11506p;

    /* renamed from: q  reason: collision with root package name */
    private ValueAnimator f11507q;

    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes.dex */
    class a extends com.google.android.material.internal.j {

        /* compiled from: DropdownMenuEndIconDelegate.java */
        /* renamed from: com.google.android.material.textfield.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0133a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ AutoCompleteTextView f11509a;

            RunnableC0133a(AutoCompleteTextView autoCompleteTextView) {
                this.f11509a = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean isPopupShowing = this.f11509a.isPopupShowing();
                d.this.E(isPopupShowing);
                d.this.f11500j = isPopupShowing;
            }
        }

        a() {
        }

        @Override // com.google.android.material.internal.j, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AutoCompleteTextView y10 = d.y(d.this.f11523a.getEditText());
            if (d.this.f11505o.isTouchExplorationEnabled() && d.D(y10) && !d.this.f11525c.hasFocus()) {
                y10.dismissDropDown();
            }
            y10.post(new RunnableC0133a(y10));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            d.this.f11525c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes.dex */
    class c implements View.OnFocusChangeListener {
        c() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            d.this.f11523a.setEndIconActivated(z10);
            if (!z10) {
                d.this.E(false);
                d.this.f11500j = false;
            }
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* renamed from: com.google.android.material.textfield.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0134d extends TextInputLayout.e {
        C0134d(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        @Override // com.google.android.material.textfield.TextInputLayout.e, androidx.core.view.a
        public void g(View view, k0.c cVar) {
            super.g(view, cVar);
            if (!d.D(d.this.f11523a.getEditText())) {
                cVar.a0(Spinner.class.getName());
            }
            if (cVar.L()) {
                cVar.l0(null);
            }
        }

        @Override // androidx.core.view.a
        public void h(View view, AccessibilityEvent accessibilityEvent) {
            super.h(view, accessibilityEvent);
            AutoCompleteTextView y10 = d.y(d.this.f11523a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && d.this.f11505o.isTouchExplorationEnabled() && !d.D(d.this.f11523a.getEditText())) {
                d.this.H(y10);
            }
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes.dex */
    class e implements TextInputLayout.f {
        e() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            AutoCompleteTextView y10 = d.y(textInputLayout.getEditText());
            d.this.F(y10);
            d.this.v(y10);
            d.this.G(y10);
            y10.setThreshold(0);
            y10.removeTextChangedListener(d.this.f11495e);
            y10.addTextChangedListener(d.this.f11495e);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (!d.D(y10)) {
                d0.E0(d.this.f11525c, 2);
            }
            textInputLayout.setTextInputAccessibilityDelegate(d.this.f11497g);
            textInputLayout.setEndIconVisible(true);
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes.dex */
    class f implements TextInputLayout.g {

        /* compiled from: DropdownMenuEndIconDelegate.java */
        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ AutoCompleteTextView f11516a;

            a(AutoCompleteTextView autoCompleteTextView) {
                this.f11516a = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f11516a.removeTextChangedListener(d.this.f11495e);
            }
        }

        f() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i10) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
            if (autoCompleteTextView != null && i10 == 3) {
                autoCompleteTextView.post(new a(autoCompleteTextView));
                if (autoCompleteTextView.getOnFocusChangeListener() == d.this.f11496f) {
                    autoCompleteTextView.setOnFocusChangeListener(null);
                }
                autoCompleteTextView.setOnTouchListener(null);
                if (d.f11494r) {
                    autoCompleteTextView.setOnDismissListener(null);
                }
            }
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes.dex */
    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.H((AutoCompleteTextView) d.this.f11523a.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes.dex */
    public class h implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AutoCompleteTextView f11519a;

        h(AutoCompleteTextView autoCompleteTextView) {
            this.f11519a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (d.this.C()) {
                    d.this.f11500j = false;
                }
                d.this.H(this.f11519a);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes.dex */
    public class i implements AutoCompleteTextView.OnDismissListener {
        i() {
        }

        @Override // android.widget.AutoCompleteTextView.OnDismissListener
        public void onDismiss() {
            d.this.f11500j = true;
            d.this.f11502l = System.currentTimeMillis();
            d.this.E(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes.dex */
    public class j extends AnimatorListenerAdapter {
        j() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d dVar = d.this;
            dVar.f11525c.setChecked(dVar.f11501k);
            d.this.f11507q.start();
        }
    }

    static {
        f11494r = Build.VERSION.SDK_INT >= 21;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TextInputLayout textInputLayout, int i10) {
        super(textInputLayout, i10);
    }

    private w7.g A(float f10, float f11, float f12, int i10) {
        k m10 = k.a().A(f10).E(f10).s(f11).w(f11).m();
        w7.g m11 = w7.g.m(this.f11524b, f12);
        m11.setShapeAppearanceModel(m10);
        m11.b0(0, i10, 0, i10);
        return m11;
    }

    private void B() {
        this.f11507q = z(67, 0.0f, 1.0f);
        ValueAnimator z10 = z(50, 1.0f, 0.0f);
        this.f11506p = z10;
        z10.addListener(new j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C() {
        long currentTimeMillis = System.currentTimeMillis() - this.f11502l;
        return currentTimeMillis < 0 || currentTimeMillis > 300;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean D(EditText editText) {
        return editText.getKeyListener() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(boolean z10) {
        if (this.f11501k != z10) {
            this.f11501k = z10;
            this.f11507q.cancel();
            this.f11506p.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(AutoCompleteTextView autoCompleteTextView) {
        if (f11494r) {
            int boxBackgroundMode = this.f11523a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.f11504n);
            } else if (boxBackgroundMode == 1) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.f11503m);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void G(AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.setOnTouchListener(new h(autoCompleteTextView));
        autoCompleteTextView.setOnFocusChangeListener(this.f11496f);
        if (f11494r) {
            autoCompleteTextView.setOnDismissListener(new i());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView != null) {
            if (C()) {
                this.f11500j = false;
            }
            if (!this.f11500j) {
                if (f11494r) {
                    E(!this.f11501k);
                } else {
                    this.f11501k = !this.f11501k;
                    this.f11525c.toggle();
                }
                if (this.f11501k) {
                    autoCompleteTextView.requestFocus();
                    autoCompleteTextView.showDropDown();
                    return;
                }
                autoCompleteTextView.dismissDropDown();
                return;
            }
            this.f11500j = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(AutoCompleteTextView autoCompleteTextView) {
        if (!D(autoCompleteTextView)) {
            int boxBackgroundMode = this.f11523a.getBoxBackgroundMode();
            w7.g boxBackground = this.f11523a.getBoxBackground();
            int d10 = j7.a.d(autoCompleteTextView, d7.b.f25157m);
            int[][] iArr = {new int[]{16842919}, new int[0]};
            if (boxBackgroundMode == 2) {
                x(autoCompleteTextView, d10, iArr, boxBackground);
            } else if (boxBackgroundMode == 1) {
                w(autoCompleteTextView, d10, iArr, boxBackground);
            }
        }
    }

    private void w(AutoCompleteTextView autoCompleteTextView, int i10, int[][] iArr, w7.g gVar) {
        int boxBackgroundColor = this.f11523a.getBoxBackgroundColor();
        int[] iArr2 = {j7.a.h(i10, boxBackgroundColor, 0.1f), boxBackgroundColor};
        if (f11494r) {
            d0.x0(autoCompleteTextView, new RippleDrawable(new ColorStateList(iArr, iArr2), gVar, gVar));
            return;
        }
        w7.g gVar2 = new w7.g(gVar.E());
        gVar2.Z(new ColorStateList(iArr, iArr2));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gVar, gVar2});
        int J = d0.J(autoCompleteTextView);
        int paddingTop = autoCompleteTextView.getPaddingTop();
        int I = d0.I(autoCompleteTextView);
        int paddingBottom = autoCompleteTextView.getPaddingBottom();
        d0.x0(autoCompleteTextView, layerDrawable);
        d0.H0(autoCompleteTextView, J, paddingTop, I, paddingBottom);
    }

    private void x(AutoCompleteTextView autoCompleteTextView, int i10, int[][] iArr, w7.g gVar) {
        LayerDrawable layerDrawable;
        int d10 = j7.a.d(autoCompleteTextView, d7.b.f25161q);
        w7.g gVar2 = new w7.g(gVar.E());
        int h10 = j7.a.h(i10, d10, 0.1f);
        gVar2.Z(new ColorStateList(iArr, new int[]{h10, 0}));
        if (f11494r) {
            gVar2.setTint(d10);
            ColorStateList colorStateList = new ColorStateList(iArr, new int[]{h10, d10});
            w7.g gVar3 = new w7.g(gVar.E());
            gVar3.setTint(-1);
            layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, gVar2, gVar3), gVar});
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{gVar2, gVar});
        }
        d0.x0(autoCompleteTextView, layerDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AutoCompleteTextView y(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private ValueAnimator z(int i10, float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(e7.a.f25833a);
        ofFloat.setDuration(i10);
        ofFloat.addUpdateListener(new b());
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public void a() {
        float dimensionPixelOffset = this.f11524b.getResources().getDimensionPixelOffset(d7.d.f25221t0);
        float dimensionPixelOffset2 = this.f11524b.getResources().getDimensionPixelOffset(d7.d.f25203k0);
        int dimensionPixelOffset3 = this.f11524b.getResources().getDimensionPixelOffset(d7.d.f25205l0);
        w7.g A = A(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        w7.g A2 = A(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.f11504n = A;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f11503m = stateListDrawable;
        stateListDrawable.addState(new int[]{16842922}, A);
        this.f11503m.addState(new int[0], A2);
        int i10 = this.f11526d;
        if (i10 == 0) {
            i10 = f11494r ? d7.e.f25237d : d7.e.f25238e;
        }
        this.f11523a.setEndIconDrawable(i10);
        TextInputLayout textInputLayout = this.f11523a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(d7.j.f25316g));
        this.f11523a.setEndIconOnClickListener(new g());
        this.f11523a.e(this.f11498h);
        this.f11523a.f(this.f11499i);
        B();
        this.f11505o = (AccessibilityManager) this.f11524b.getSystemService("accessibility");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public boolean b(int i10) {
        return i10 != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public boolean d() {
        return true;
    }
}
