package com.google.android.material.textfield;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.b0;
import androidx.appcompat.widget.g0;
import androidx.appcompat.widget.x0;
import androidx.core.view.d0;
import androidx.core.view.i;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.m;
import d7.h;
import d7.j;
import d7.k;
import d7.l;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import n1.o;
import w7.k;
/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {
    private static final int W0 = k.f25349n;
    private CharSequence A;
    private View.OnLongClickListener A0;
    private final TextView B;
    private View.OnLongClickListener B0;
    private boolean C;
    private final CheckableImageButton C0;
    private CharSequence D;
    private ColorStateList D0;
    private boolean E;
    private ColorStateList E0;
    private w7.g F;
    private ColorStateList F0;
    private w7.g G;
    private int G0;
    private w7.k H;
    private int H0;
    private final int I;
    private int I0;
    private int J;
    private ColorStateList J0;
    private int K;
    private int K0;
    private int L;
    private int L0;
    private int M;
    private int M0;
    private int N;
    private int N0;
    private int O;
    private int O0;
    private int P;
    private boolean P0;
    private final Rect Q;
    final com.google.android.material.internal.a Q0;
    private final Rect R;
    private boolean R0;
    private final RectF S;
    private boolean S0;
    private Typeface T;
    private ValueAnimator T0;
    private final CheckableImageButton U;
    private boolean U0;
    private ColorStateList V;
    private boolean V0;
    private boolean W;

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f11423a;

    /* renamed from: b  reason: collision with root package name */
    private final LinearLayout f11424b;

    /* renamed from: c  reason: collision with root package name */
    private final LinearLayout f11425c;

    /* renamed from: d  reason: collision with root package name */
    private final FrameLayout f11426d;

    /* renamed from: e  reason: collision with root package name */
    EditText f11427e;

    /* renamed from: f  reason: collision with root package name */
    private CharSequence f11428f;

    /* renamed from: g  reason: collision with root package name */
    private int f11429g;

    /* renamed from: h  reason: collision with root package name */
    private int f11430h;

    /* renamed from: i  reason: collision with root package name */
    private final com.google.android.material.textfield.f f11431i;

    /* renamed from: j  reason: collision with root package name */
    boolean f11432j;

    /* renamed from: j0  reason: collision with root package name */
    private PorterDuff.Mode f11433j0;

    /* renamed from: k  reason: collision with root package name */
    private int f11434k;

    /* renamed from: k0  reason: collision with root package name */
    private boolean f11435k0;

    /* renamed from: l  reason: collision with root package name */
    private boolean f11436l;

    /* renamed from: l0  reason: collision with root package name */
    private Drawable f11437l0;

    /* renamed from: m  reason: collision with root package name */
    private TextView f11438m;

    /* renamed from: m0  reason: collision with root package name */
    private int f11439m0;

    /* renamed from: n  reason: collision with root package name */
    private int f11440n;

    /* renamed from: n0  reason: collision with root package name */
    private View.OnLongClickListener f11441n0;

    /* renamed from: o  reason: collision with root package name */
    private int f11442o;

    /* renamed from: o0  reason: collision with root package name */
    private final LinkedHashSet<f> f11443o0;

    /* renamed from: p  reason: collision with root package name */
    private CharSequence f11444p;

    /* renamed from: p0  reason: collision with root package name */
    private int f11445p0;

    /* renamed from: q  reason: collision with root package name */
    private boolean f11446q;

    /* renamed from: q0  reason: collision with root package name */
    private final SparseArray<com.google.android.material.textfield.e> f11447q0;

    /* renamed from: r  reason: collision with root package name */
    private TextView f11448r;

    /* renamed from: r0  reason: collision with root package name */
    private final CheckableImageButton f11449r0;

    /* renamed from: s  reason: collision with root package name */
    private ColorStateList f11450s;

    /* renamed from: s0  reason: collision with root package name */
    private final LinkedHashSet<g> f11451s0;

    /* renamed from: t  reason: collision with root package name */
    private int f11452t;

    /* renamed from: t0  reason: collision with root package name */
    private ColorStateList f11453t0;

    /* renamed from: u  reason: collision with root package name */
    private n1.d f11454u;

    /* renamed from: u0  reason: collision with root package name */
    private boolean f11455u0;

    /* renamed from: v  reason: collision with root package name */
    private n1.d f11456v;

    /* renamed from: v0  reason: collision with root package name */
    private PorterDuff.Mode f11457v0;

    /* renamed from: w  reason: collision with root package name */
    private ColorStateList f11458w;

    /* renamed from: w0  reason: collision with root package name */
    private boolean f11459w0;

    /* renamed from: x  reason: collision with root package name */
    private ColorStateList f11460x;

    /* renamed from: x0  reason: collision with root package name */
    private Drawable f11461x0;

    /* renamed from: y  reason: collision with root package name */
    private CharSequence f11462y;

    /* renamed from: y0  reason: collision with root package name */
    private int f11463y0;

    /* renamed from: z  reason: collision with root package name */
    private final TextView f11464z;

    /* renamed from: z0  reason: collision with root package name */
    private Drawable f11465z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        CharSequence f11466c;

        /* renamed from: d  reason: collision with root package name */
        boolean f11467d;

        /* renamed from: e  reason: collision with root package name */
        CharSequence f11468e;

        /* renamed from: f  reason: collision with root package name */
        CharSequence f11469f;

        /* renamed from: g  reason: collision with root package name */
        CharSequence f11470g;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f11466c) + " hint=" + ((Object) this.f11468e) + " helperText=" + ((Object) this.f11469f) + " placeholderText=" + ((Object) this.f11470g) + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            TextUtils.writeToParcel(this.f11466c, parcel, i10);
            parcel.writeInt(this.f11467d ? 1 : 0);
            TextUtils.writeToParcel(this.f11468e, parcel, i10);
            TextUtils.writeToParcel(this.f11469f, parcel, i10);
            TextUtils.writeToParcel(this.f11470g, parcel, i10);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f11466c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f11467d = parcel.readInt() != 1 ? false : true;
            this.f11468e = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f11469f = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f11470g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextInputLayout textInputLayout = TextInputLayout.this;
            textInputLayout.w0(!textInputLayout.V0);
            TextInputLayout textInputLayout2 = TextInputLayout.this;
            if (textInputLayout2.f11432j) {
                textInputLayout2.p0(editable.length());
            }
            if (TextInputLayout.this.f11446q) {
                TextInputLayout.this.A0(editable.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f11449r0.performClick();
            TextInputLayout.this.f11449r0.jumpDrawablesToCurrentState();
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f11427e.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.Q0.Z(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes.dex */
    public static class e extends androidx.core.view.a {

        /* renamed from: d  reason: collision with root package name */
        private final TextInputLayout f11475d;

        public e(TextInputLayout textInputLayout) {
            this.f11475d = textInputLayout;
        }

        @Override // androidx.core.view.a
        public void g(View view, k0.c cVar) {
            super.g(view, cVar);
            EditText editText = this.f11475d.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f11475d.getHint();
            CharSequence error = this.f11475d.getError();
            CharSequence placeholderText = this.f11475d.getPlaceholderText();
            int counterMaxLength = this.f11475d.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f11475d.getCounterOverflowDescription();
            boolean z10 = !TextUtils.isEmpty(text);
            boolean z11 = !TextUtils.isEmpty(hint);
            boolean z12 = !this.f11475d.O();
            boolean z13 = !TextUtils.isEmpty(error);
            boolean z14 = z13 || !TextUtils.isEmpty(counterOverflowDescription);
            String charSequence = z11 ? hint.toString() : "";
            if (z10) {
                cVar.z0(text);
            } else if (!TextUtils.isEmpty(charSequence)) {
                cVar.z0(charSequence);
                if (z12 && placeholderText != null) {
                    cVar.z0(charSequence + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                cVar.z0(placeholderText);
            }
            if (!TextUtils.isEmpty(charSequence)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    cVar.l0(charSequence);
                } else {
                    if (z10) {
                        charSequence = ((Object) text) + ", " + charSequence;
                    }
                    cVar.z0(charSequence);
                }
                cVar.v0(!z10);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            cVar.m0(counterMaxLength);
            if (z14) {
                if (!z13) {
                    error = counterOverflowDescription;
                }
                cVar.h0(error);
            }
            if (Build.VERSION.SDK_INT >= 17 && editText != null) {
                editText.setLabelFor(d7.f.f25257h0);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(TextInputLayout textInputLayout);
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(TextInputLayout textInputLayout, int i10);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d7.b.Z);
    }

    private n1.d A() {
        n1.d dVar = new n1.d();
        dVar.U(87L);
        dVar.W(e7.a.f25833a);
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(int i10) {
        if (i10 != 0 || this.P0) {
            K();
        } else {
            k0();
        }
    }

    private boolean B() {
        return this.C && !TextUtils.isEmpty(this.D) && (this.F instanceof com.google.android.material.textfield.c);
    }

    private void B0() {
        if (this.f11427e != null) {
            d0.H0(this.f11464z, R() ? 0 : d0.J(this.f11427e), this.f11427e.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(d7.d.K), this.f11427e.getCompoundPaddingBottom());
        }
    }

    private void C() {
        Iterator<f> it = this.f11443o0.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    private void C0() {
        this.f11464z.setVisibility((this.f11462y == null || O()) ? 8 : 0);
        s0();
    }

    private void D(int i10) {
        Iterator<g> it = this.f11451s0.iterator();
        while (it.hasNext()) {
            it.next().a(this, i10);
        }
    }

    private void D0(boolean z10, boolean z11) {
        int defaultColor = this.J0.getDefaultColor();
        int colorForState = this.J0.getColorForState(new int[]{16843623, 16842910}, defaultColor);
        int colorForState2 = this.J0.getColorForState(new int[]{16843518, 16842910}, defaultColor);
        if (z10) {
            this.O = colorForState2;
        } else if (z11) {
            this.O = colorForState;
        } else {
            this.O = defaultColor;
        }
    }

    private void E(Canvas canvas) {
        w7.g gVar = this.G;
        if (gVar != null) {
            Rect bounds = gVar.getBounds();
            bounds.top = bounds.bottom - this.L;
            this.G.draw(canvas);
        }
    }

    private void E0() {
        if (this.f11427e != null) {
            d0.H0(this.B, getContext().getResources().getDimensionPixelSize(d7.d.K), this.f11427e.getPaddingTop(), (L() || M()) ? 0 : d0.I(this.f11427e), this.f11427e.getPaddingBottom());
        }
    }

    private void F(Canvas canvas) {
        if (this.C) {
            this.Q0.l(canvas);
        }
    }

    private void F0() {
        int visibility = this.B.getVisibility();
        int i10 = 0;
        boolean z10 = this.A != null && !O();
        TextView textView = this.B;
        if (!z10) {
            i10 = 8;
        }
        textView.setVisibility(i10);
        if (visibility != this.B.getVisibility()) {
            getEndIconDelegate().c(z10);
        }
        s0();
    }

    private void G(boolean z10) {
        ValueAnimator valueAnimator = this.T0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.T0.cancel();
        }
        if (!z10 || !this.S0) {
            this.Q0.Z(0.0f);
        } else {
            i(0.0f);
        }
        if (B() && ((com.google.android.material.textfield.c) this.F).n0()) {
            y();
        }
        this.P0 = true;
        K();
        C0();
        F0();
    }

    private int H(int i10, boolean z10) {
        int compoundPaddingLeft = i10 + this.f11427e.getCompoundPaddingLeft();
        return (this.f11462y == null || z10) ? compoundPaddingLeft : (compoundPaddingLeft - this.f11464z.getMeasuredWidth()) + this.f11464z.getPaddingLeft();
    }

    private int I(int i10, boolean z10) {
        int compoundPaddingRight = i10 - this.f11427e.getCompoundPaddingRight();
        return (this.f11462y == null || !z10) ? compoundPaddingRight : compoundPaddingRight + (this.f11464z.getMeasuredWidth() - this.f11464z.getPaddingRight());
    }

    private boolean J() {
        return this.f11445p0 != 0;
    }

    private void K() {
        TextView textView = this.f11448r;
        if (textView != null && this.f11446q) {
            textView.setText((CharSequence) null);
            o.a(this.f11423a, this.f11456v);
            this.f11448r.setVisibility(4);
        }
    }

    private boolean M() {
        return this.C0.getVisibility() == 0;
    }

    private boolean Q() {
        return this.J == 1 && (Build.VERSION.SDK_INT < 16 || this.f11427e.getMinLines() <= 1);
    }

    private int[] S(CheckableImageButton checkableImageButton) {
        int[] drawableState = getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
        return copyOf;
    }

    private void T() {
        p();
        c0();
        G0();
        m0();
        h();
        if (this.J != 0) {
            v0();
        }
    }

    private void U() {
        if (B()) {
            RectF rectF = this.S;
            this.Q0.o(rectF, this.f11427e.getWidth(), this.f11427e.getGravity());
            l(rectF);
            rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.L);
            ((com.google.android.material.textfield.c) this.F).t0(rectF);
        }
    }

    private void V() {
        if (B() && !this.P0) {
            y();
            U();
        }
    }

    private static void W(ViewGroup viewGroup, boolean z10) {
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            childAt.setEnabled(z10);
            if (childAt instanceof ViewGroup) {
                W((ViewGroup) childAt, z10);
            }
        }
    }

    private void Z(CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() != null && colorStateList != null && colorStateList.isStateful()) {
            int colorForState = colorStateList.getColorForState(S(checkableImageButton), colorStateList.getDefaultColor());
            Drawable mutate = androidx.core.graphics.drawable.a.r(drawable).mutate();
            androidx.core.graphics.drawable.a.o(mutate, ColorStateList.valueOf(colorForState));
            checkableImageButton.setImageDrawable(mutate);
        }
    }

    private void b0() {
        TextView textView = this.f11448r;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void c0() {
        if (j0()) {
            d0.x0(this.f11427e, this.F);
        }
    }

    private static void d0(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean S = d0.S(checkableImageButton);
        boolean z10 = false;
        int i10 = 1;
        boolean z11 = onLongClickListener != null;
        if (S || z11) {
            z10 = true;
        }
        checkableImageButton.setFocusable(z10);
        checkableImageButton.setClickable(S);
        checkableImageButton.setPressable(S);
        checkableImageButton.setLongClickable(z11);
        if (!z10) {
            i10 = 2;
        }
        d0.E0(checkableImageButton, i10);
    }

    private static void e0(CheckableImageButton checkableImageButton, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        d0(checkableImageButton, onLongClickListener);
    }

    private static void f0(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        d0(checkableImageButton, onLongClickListener);
    }

    private void g() {
        TextView textView = this.f11448r;
        if (textView != null) {
            this.f11423a.addView(textView);
            this.f11448r.setVisibility(0);
        }
    }

    private com.google.android.material.textfield.e getEndIconDelegate() {
        com.google.android.material.textfield.e eVar = this.f11447q0.get(this.f11445p0);
        return eVar != null ? eVar : this.f11447q0.get(0);
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.C0.getVisibility() == 0) {
            return this.C0;
        }
        if (!J() || !L()) {
            return null;
        }
        return this.f11449r0;
    }

    private void h() {
        if (this.f11427e != null && this.J == 1) {
            if (t7.c.h(getContext())) {
                EditText editText = this.f11427e;
                d0.H0(editText, d0.J(editText), getResources().getDimensionPixelSize(d7.d.E), d0.I(this.f11427e), getResources().getDimensionPixelSize(d7.d.D));
            } else if (t7.c.g(getContext())) {
                EditText editText2 = this.f11427e;
                d0.H0(editText2, d0.J(editText2), getResources().getDimensionPixelSize(d7.d.C), d0.I(this.f11427e), getResources().getDimensionPixelSize(d7.d.B));
            }
        }
    }

    private boolean h0() {
        return (this.C0.getVisibility() == 0 || ((J() && L()) || this.A != null)) && this.f11425c.getMeasuredWidth() > 0;
    }

    private boolean i0() {
        return !(getStartIconDrawable() == null && this.f11462y == null) && this.f11424b.getMeasuredWidth() > 0;
    }

    private void j() {
        w7.g gVar = this.F;
        if (gVar != null) {
            gVar.setShapeAppearanceModel(this.H);
            if (w()) {
                this.F.g0(this.L, this.O);
            }
            int q5 = q();
            this.P = q5;
            this.F.Z(ColorStateList.valueOf(q5));
            if (this.f11445p0 == 3) {
                this.f11427e.getBackground().invalidateSelf();
            }
            k();
            invalidate();
        }
    }

    private boolean j0() {
        EditText editText = this.f11427e;
        return (editText == null || this.F == null || editText.getBackground() != null || this.J == 0) ? false : true;
    }

    private void k() {
        if (this.G != null) {
            if (x()) {
                this.G.Z(ColorStateList.valueOf(this.O));
            }
            invalidate();
        }
    }

    private void k0() {
        TextView textView = this.f11448r;
        if (textView != null && this.f11446q) {
            textView.setText(this.f11444p);
            o.a(this.f11423a, this.f11454u);
            this.f11448r.setVisibility(0);
            this.f11448r.bringToFront();
        }
    }

    private void l(RectF rectF) {
        float f10 = rectF.left;
        int i10 = this.I;
        rectF.left = f10 - i10;
        rectF.right += i10;
    }

    private void l0(boolean z10) {
        if (!z10 || getEndIconDrawable() == null) {
            m();
            return;
        }
        Drawable mutate = androidx.core.graphics.drawable.a.r(getEndIconDrawable()).mutate();
        androidx.core.graphics.drawable.a.n(mutate, this.f11431i.o());
        this.f11449r0.setImageDrawable(mutate);
    }

    private void m() {
        n(this.f11449r0, this.f11455u0, this.f11453t0, this.f11459w0, this.f11457v0);
    }

    private void m0() {
        if (this.J != 1) {
            return;
        }
        if (t7.c.h(getContext())) {
            this.K = getResources().getDimensionPixelSize(d7.d.G);
        } else if (t7.c.g(getContext())) {
            this.K = getResources().getDimensionPixelSize(d7.d.F);
        }
    }

    private void n(CheckableImageButton checkableImageButton, boolean z10, ColorStateList colorStateList, boolean z11, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z10 || z11)) {
            drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
            if (z10) {
                androidx.core.graphics.drawable.a.o(drawable, colorStateList);
            }
            if (z11) {
                androidx.core.graphics.drawable.a.p(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    private void n0(Rect rect) {
        w7.g gVar = this.G;
        if (gVar != null) {
            int i10 = rect.bottom;
            gVar.setBounds(rect.left, i10 - this.N, rect.right, i10);
        }
    }

    private void o() {
        n(this.U, this.W, this.V, this.f11435k0, this.f11433j0);
    }

    private void o0() {
        if (this.f11438m != null) {
            EditText editText = this.f11427e;
            p0(editText == null ? 0 : editText.getText().length());
        }
    }

    private void p() {
        int i10 = this.J;
        if (i10 == 0) {
            this.F = null;
            this.G = null;
        } else if (i10 == 1) {
            this.F = new w7.g(this.H);
            this.G = new w7.g();
        } else if (i10 == 2) {
            if (!this.C || (this.F instanceof com.google.android.material.textfield.c)) {
                this.F = new w7.g(this.H);
            } else {
                this.F = new com.google.android.material.textfield.c(this.H);
            }
            this.G = null;
        } else {
            throw new IllegalArgumentException(this.J + " is illegal; only @BoxBackgroundMode constants are supported.");
        }
    }

    private int q() {
        return this.J == 1 ? j7.a.g(j7.a.e(this, d7.b.f25161q, 0), this.P) : this.P;
    }

    private static void q0(Context context, TextView textView, int i10, int i11, boolean z10) {
        textView.setContentDescription(context.getString(z10 ? j.f25312c : j.f25311b, Integer.valueOf(i10), Integer.valueOf(i11)));
    }

    private Rect r(Rect rect) {
        if (this.f11427e != null) {
            Rect rect2 = this.R;
            boolean z10 = d0.E(this) == 1;
            rect2.bottom = rect.bottom;
            int i10 = this.J;
            if (i10 == 1) {
                rect2.left = H(rect.left, z10);
                rect2.top = rect.top + this.K;
                rect2.right = I(rect.right, z10);
                return rect2;
            } else if (i10 != 2) {
                rect2.left = H(rect.left, z10);
                rect2.top = getPaddingTop();
                rect2.right = I(rect.right, z10);
                return rect2;
            } else {
                rect2.left = rect.left + this.f11427e.getPaddingLeft();
                rect2.top = rect.top - v();
                rect2.right = rect.right - this.f11427e.getPaddingRight();
                return rect2;
            }
        } else {
            throw new IllegalStateException();
        }
    }

    private void r0() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.f11438m;
        if (textView != null) {
            g0(textView, this.f11436l ? this.f11440n : this.f11442o);
            if (!this.f11436l && (colorStateList2 = this.f11458w) != null) {
                this.f11438m.setTextColor(colorStateList2);
            }
            if (this.f11436l && (colorStateList = this.f11460x) != null) {
                this.f11438m.setTextColor(colorStateList);
            }
        }
    }

    private int s(Rect rect, Rect rect2, float f10) {
        if (Q()) {
            return (int) (rect2.top + f10);
        }
        return rect.bottom - this.f11427e.getCompoundPaddingBottom();
    }

    private boolean s0() {
        boolean z10;
        if (this.f11427e == null) {
            return false;
        }
        boolean z11 = true;
        if (i0()) {
            int measuredWidth = this.f11424b.getMeasuredWidth() - this.f11427e.getPaddingLeft();
            if (this.f11437l0 == null || this.f11439m0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.f11437l0 = colorDrawable;
                this.f11439m0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] a10 = androidx.core.widget.j.a(this.f11427e);
            Drawable drawable = a10[0];
            Drawable drawable2 = this.f11437l0;
            if (drawable != drawable2) {
                androidx.core.widget.j.l(this.f11427e, drawable2, a10[1], a10[2], a10[3]);
                z10 = true;
            }
            z10 = false;
        } else {
            if (this.f11437l0 != null) {
                Drawable[] a11 = androidx.core.widget.j.a(this.f11427e);
                androidx.core.widget.j.l(this.f11427e, null, a11[1], a11[2], a11[3]);
                this.f11437l0 = null;
                z10 = true;
            }
            z10 = false;
        }
        if (h0()) {
            int measuredWidth2 = this.B.getMeasuredWidth() - this.f11427e.getPaddingRight();
            CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
            if (endIconToUpdateDummyDrawable != null) {
                measuredWidth2 = measuredWidth2 + endIconToUpdateDummyDrawable.getMeasuredWidth() + i.b((ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams());
            }
            Drawable[] a12 = androidx.core.widget.j.a(this.f11427e);
            Drawable drawable3 = this.f11461x0;
            if (drawable3 == null || this.f11463y0 == measuredWidth2) {
                if (drawable3 == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.f11461x0 = colorDrawable2;
                    this.f11463y0 = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable4 = a12[2];
                Drawable drawable5 = this.f11461x0;
                if (drawable4 != drawable5) {
                    this.f11465z0 = a12[2];
                    androidx.core.widget.j.l(this.f11427e, a12[0], a12[1], drawable5, a12[3]);
                } else {
                    z11 = z10;
                }
            } else {
                this.f11463y0 = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                androidx.core.widget.j.l(this.f11427e, a12[0], a12[1], this.f11461x0, a12[3]);
            }
        } else if (this.f11461x0 == null) {
            return z10;
        } else {
            Drawable[] a13 = androidx.core.widget.j.a(this.f11427e);
            if (a13[2] == this.f11461x0) {
                androidx.core.widget.j.l(this.f11427e, a13[0], a13[1], this.f11465z0, a13[3]);
            } else {
                z11 = z10;
            }
            this.f11461x0 = null;
        }
        return z11;
    }

    private void setEditText(EditText editText) {
        if (this.f11427e == null) {
            if (this.f11445p0 != 3 && !(editText instanceof TextInputEditText)) {
                Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.f11427e = editText;
            setMinWidth(this.f11429g);
            setMaxWidth(this.f11430h);
            T();
            setTextInputAccessibilityDelegate(new e(this));
            this.Q0.f0(this.f11427e.getTypeface());
            this.Q0.X(this.f11427e.getTextSize());
            int gravity = this.f11427e.getGravity();
            this.Q0.P((gravity & (-113)) | 48);
            this.Q0.W(gravity);
            this.f11427e.addTextChangedListener(new a());
            if (this.E0 == null) {
                this.E0 = this.f11427e.getHintTextColors();
            }
            if (this.C) {
                if (TextUtils.isEmpty(this.D)) {
                    CharSequence hint = this.f11427e.getHint();
                    this.f11428f = hint;
                    setHint(hint);
                    this.f11427e.setHint((CharSequence) null);
                }
                this.E = true;
            }
            if (this.f11438m != null) {
                p0(this.f11427e.getText().length());
            }
            t0();
            this.f11431i.e();
            this.f11424b.bringToFront();
            this.f11425c.bringToFront();
            this.f11426d.bringToFront();
            this.C0.bringToFront();
            C();
            B0();
            E0();
            if (!isEnabled()) {
                editText.setEnabled(false);
            }
            x0(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setErrorIconVisible(boolean z10) {
        int i10 = 0;
        this.C0.setVisibility(z10 ? 0 : 8);
        FrameLayout frameLayout = this.f11426d;
        if (z10) {
            i10 = 8;
        }
        frameLayout.setVisibility(i10);
        E0();
        if (!J()) {
            s0();
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.D)) {
            this.D = charSequence;
            this.Q0.d0(charSequence);
            if (!this.P0) {
                U();
            }
        }
    }

    private void setPlaceholderTextEnabled(boolean z10) {
        if (this.f11446q != z10) {
            if (z10) {
                b0 b0Var = new b0(getContext());
                this.f11448r = b0Var;
                b0Var.setId(d7.f.f25259i0);
                n1.d A = A();
                this.f11454u = A;
                A.Z(67L);
                this.f11456v = A();
                d0.v0(this.f11448r, 1);
                setPlaceholderTextAppearance(this.f11452t);
                setPlaceholderTextColor(this.f11450s);
                g();
            } else {
                b0();
                this.f11448r = null;
            }
            this.f11446q = z10;
        }
    }

    private int t(Rect rect, float f10) {
        if (Q()) {
            return (int) (rect.centerY() - (f10 / 2.0f));
        }
        return rect.top + this.f11427e.getCompoundPaddingTop();
    }

    private Rect u(Rect rect) {
        if (this.f11427e != null) {
            Rect rect2 = this.R;
            float w10 = this.Q0.w();
            rect2.left = rect.left + this.f11427e.getCompoundPaddingLeft();
            rect2.top = t(rect, w10);
            rect2.right = rect.right - this.f11427e.getCompoundPaddingRight();
            rect2.bottom = s(rect, rect2, w10);
            return rect2;
        }
        throw new IllegalStateException();
    }

    private boolean u0() {
        int max;
        if (this.f11427e == null || this.f11427e.getMeasuredHeight() >= (max = Math.max(this.f11425c.getMeasuredHeight(), this.f11424b.getMeasuredHeight()))) {
            return false;
        }
        this.f11427e.setMinimumHeight(max);
        return true;
    }

    private int v() {
        float q5;
        if (!this.C) {
            return 0;
        }
        int i10 = this.J;
        if (i10 == 0 || i10 == 1) {
            q5 = this.Q0.q();
        } else if (i10 != 2) {
            return 0;
        } else {
            q5 = this.Q0.q() / 2.0f;
        }
        return (int) q5;
    }

    private void v0() {
        if (this.J != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f11423a.getLayoutParams();
            int v10 = v();
            if (v10 != layoutParams.topMargin) {
                layoutParams.topMargin = v10;
                this.f11423a.requestLayout();
            }
        }
    }

    private boolean w() {
        return this.J == 2 && x();
    }

    private boolean x() {
        return this.L > -1 && this.O != 0;
    }

    private void x0(boolean z10, boolean z11) {
        ColorStateList colorStateList;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.f11427e;
        boolean z12 = editText != null && !TextUtils.isEmpty(editText.getText());
        EditText editText2 = this.f11427e;
        boolean z13 = editText2 != null && editText2.hasFocus();
        boolean k10 = this.f11431i.k();
        ColorStateList colorStateList2 = this.E0;
        if (colorStateList2 != null) {
            this.Q0.O(colorStateList2);
            this.Q0.V(this.E0);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.E0;
            int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.O0) : this.O0;
            this.Q0.O(ColorStateList.valueOf(colorForState));
            this.Q0.V(ColorStateList.valueOf(colorForState));
        } else if (k10) {
            this.Q0.O(this.f11431i.p());
        } else if (this.f11436l && (textView = this.f11438m) != null) {
            this.Q0.O(textView.getTextColors());
        } else if (z13 && (colorStateList = this.F0) != null) {
            this.Q0.O(colorStateList);
        }
        if (z12 || !this.R0 || (isEnabled() && z13)) {
            if (z11 || this.P0) {
                z(z10);
            }
        } else if (z11 || !this.P0) {
            G(z10);
        }
    }

    private void y() {
        if (B()) {
            ((com.google.android.material.textfield.c) this.F).q0();
        }
    }

    private void y0() {
        EditText editText;
        if (this.f11448r != null && (editText = this.f11427e) != null) {
            this.f11448r.setGravity(editText.getGravity());
            this.f11448r.setPadding(this.f11427e.getCompoundPaddingLeft(), this.f11427e.getCompoundPaddingTop(), this.f11427e.getCompoundPaddingRight(), this.f11427e.getCompoundPaddingBottom());
        }
    }

    private void z(boolean z10) {
        ValueAnimator valueAnimator = this.T0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.T0.cancel();
        }
        if (!z10 || !this.S0) {
            this.Q0.Z(1.0f);
        } else {
            i(1.0f);
        }
        this.P0 = false;
        if (B()) {
            U();
        }
        z0();
        C0();
        F0();
    }

    private void z0() {
        EditText editText = this.f11427e;
        A0(editText == null ? 0 : editText.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G0() {
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.F != null && this.J != 0) {
            boolean z10 = false;
            boolean z11 = isFocused() || ((editText2 = this.f11427e) != null && editText2.hasFocus());
            boolean z12 = isHovered() || ((editText = this.f11427e) != null && editText.isHovered());
            if (!isEnabled()) {
                this.O = this.O0;
            } else if (this.f11431i.k()) {
                if (this.J0 != null) {
                    D0(z11, z12);
                } else {
                    this.O = this.f11431i.o();
                }
            } else if (!this.f11436l || (textView = this.f11438m) == null) {
                if (z11) {
                    this.O = this.I0;
                } else if (z12) {
                    this.O = this.H0;
                } else {
                    this.O = this.G0;
                }
            } else if (this.J0 != null) {
                D0(z11, z12);
            } else {
                this.O = textView.getCurrentTextColor();
            }
            if (getErrorIconDrawable() != null && this.f11431i.x() && this.f11431i.k()) {
                z10 = true;
            }
            setErrorIconVisible(z10);
            Y();
            a0();
            X();
            if (getEndIconDelegate().d()) {
                l0(this.f11431i.k());
            }
            int i10 = this.L;
            if (!z11 || !isEnabled()) {
                this.L = this.M;
            } else {
                this.L = this.N;
            }
            if (this.L != i10 && this.J == 2) {
                V();
            }
            if (this.J == 1) {
                if (!isEnabled()) {
                    this.P = this.L0;
                } else if (z12 && !z11) {
                    this.P = this.N0;
                } else if (z11) {
                    this.P = this.M0;
                } else {
                    this.P = this.K0;
                }
            }
            j();
        }
    }

    public boolean L() {
        return this.f11426d.getVisibility() == 0 && this.f11449r0.getVisibility() == 0;
    }

    public boolean N() {
        return this.f11431i.y();
    }

    final boolean O() {
        return this.P0;
    }

    public boolean P() {
        return this.E;
    }

    public boolean R() {
        return this.U.getVisibility() == 0;
    }

    public void X() {
        Z(this.f11449r0, this.f11453t0);
    }

    public void Y() {
        Z(this.C0, this.D0);
    }

    public void a0() {
        Z(this.U, this.V);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
            this.f11423a.addView(view, layoutParams2);
            this.f11423a.setLayoutParams(layoutParams);
            v0();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i10, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(26)
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i10) {
        EditText editText = this.f11427e;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i10);
            return;
        }
        if (this.f11428f != null) {
            boolean z10 = this.E;
            this.E = false;
            CharSequence hint = editText.getHint();
            this.f11427e.setHint(this.f11428f);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i10);
            } finally {
                this.f11427e.setHint(hint);
                this.E = z10;
            }
        } else {
            viewStructure.setAutofillId(getAutofillId());
            onProvideAutofillStructure(viewStructure, i10);
            onProvideAutofillVirtualStructure(viewStructure, i10);
            viewStructure.setChildCount(this.f11423a.getChildCount());
            for (int i11 = 0; i11 < this.f11423a.getChildCount(); i11++) {
                View childAt = this.f11423a.getChildAt(i11);
                ViewStructure newChild = viewStructure.newChild(i11);
                childAt.dispatchProvideAutofillStructure(newChild, i10);
                if (childAt == this.f11427e) {
                    newChild.setHint(getHint());
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.V0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.V0 = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        F(canvas);
        E(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (!this.U0) {
            boolean z10 = true;
            this.U0 = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            com.google.android.material.internal.a aVar = this.Q0;
            boolean c02 = aVar != null ? aVar.c0(drawableState) | false : false;
            if (this.f11427e != null) {
                if (!d0.X(this) || !isEnabled()) {
                    z10 = false;
                }
                w0(z10);
            }
            t0();
            G0();
            if (c02) {
                invalidate();
            }
            this.U0 = false;
        }
    }

    public void e(f fVar) {
        this.f11443o0.add(fVar);
        if (this.f11427e != null) {
            fVar.a(this);
        }
    }

    public void f(g gVar) {
        this.f11451s0.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (r3.getTextColors().getDefaultColor() == (-65281)) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g0(TextView textView, int i10) {
        boolean z10 = true;
        try {
            androidx.core.widget.j.q(textView, i10);
            if (Build.VERSION.SDK_INT >= 23) {
            }
            z10 = false;
        } catch (Exception unused) {
        }
        if (z10) {
            androidx.core.widget.j.q(textView, k.f25338c);
            textView.setTextColor(androidx.core.content.b.c(getContext(), d7.c.f25172b));
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f11427e;
        if (editText != null) {
            return editText.getBaseline() + getPaddingTop() + v();
        }
        return super.getBaseline();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w7.g getBoxBackground() {
        int i10 = this.J;
        if (i10 == 1 || i10 == 2) {
            return this.F;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.P;
    }

    public int getBoxBackgroundMode() {
        return this.J;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.K;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.F.s();
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.F.t();
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.F.I();
    }

    public float getBoxCornerRadiusTopStart() {
        return this.F.H();
    }

    public int getBoxStrokeColor() {
        return this.I0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.J0;
    }

    public int getBoxStrokeWidth() {
        return this.M;
    }

    public int getBoxStrokeWidthFocused() {
        return this.N;
    }

    public int getCounterMaxLength() {
        return this.f11434k;
    }

    CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (!this.f11432j || !this.f11436l || (textView = this.f11438m) == null) {
            return null;
        }
        return textView.getContentDescription();
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.f11458w;
    }

    public ColorStateList getCounterTextColor() {
        return this.f11458w;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.E0;
    }

    public EditText getEditText() {
        return this.f11427e;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f11449r0.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.f11449r0.getDrawable();
    }

    public int getEndIconMode() {
        return this.f11445p0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CheckableImageButton getEndIconView() {
        return this.f11449r0;
    }

    public CharSequence getError() {
        if (this.f11431i.x()) {
            return this.f11431i.n();
        }
        return null;
    }

    public CharSequence getErrorContentDescription() {
        return this.f11431i.m();
    }

    public int getErrorCurrentTextColors() {
        return this.f11431i.o();
    }

    public Drawable getErrorIconDrawable() {
        return this.C0.getDrawable();
    }

    final int getErrorTextCurrentColor() {
        return this.f11431i.o();
    }

    public CharSequence getHelperText() {
        if (this.f11431i.y()) {
            return this.f11431i.q();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.f11431i.r();
    }

    public CharSequence getHint() {
        if (this.C) {
            return this.D;
        }
        return null;
    }

    final float getHintCollapsedTextHeight() {
        return this.Q0.q();
    }

    final int getHintCurrentCollapsedTextColor() {
        return this.Q0.t();
    }

    public ColorStateList getHintTextColor() {
        return this.F0;
    }

    public int getMaxWidth() {
        return this.f11430h;
    }

    public int getMinWidth() {
        return this.f11429g;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f11449r0.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f11449r0.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.f11446q) {
            return this.f11444p;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.f11452t;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.f11450s;
    }

    public CharSequence getPrefixText() {
        return this.f11462y;
    }

    public ColorStateList getPrefixTextColor() {
        return this.f11464z.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.f11464z;
    }

    public CharSequence getStartIconContentDescription() {
        return this.U.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.U.getDrawable();
    }

    public CharSequence getSuffixText() {
        return this.A;
    }

    public ColorStateList getSuffixTextColor() {
        return this.B.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.B;
    }

    public Typeface getTypeface() {
        return this.T;
    }

    void i(float f10) {
        if (this.Q0.x() != f10) {
            if (this.T0 == null) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.T0 = valueAnimator;
                valueAnimator.setInterpolator(e7.a.f25834b);
                this.T0.setDuration(167L);
                this.T0.addUpdateListener(new d());
            }
            this.T0.setFloatValues(this.Q0.x(), f10);
            this.T0.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        EditText editText = this.f11427e;
        if (editText != null) {
            Rect rect = this.Q;
            com.google.android.material.internal.b.a(this, editText, rect);
            n0(rect);
            if (this.C) {
                this.Q0.X(this.f11427e.getTextSize());
                int gravity = this.f11427e.getGravity();
                this.Q0.P((gravity & (-113)) | 48);
                this.Q0.W(gravity);
                this.Q0.L(r(rect));
                this.Q0.T(u(rect));
                this.Q0.H();
                if (B() && !this.P0) {
                    U();
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        boolean u02 = u0();
        boolean s02 = s0();
        if (u02 || s02) {
            this.f11427e.post(new c());
        }
        y0();
        B0();
        E0();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setError(savedState.f11466c);
        if (savedState.f11467d) {
            this.f11449r0.post(new b());
        }
        setHint(savedState.f11468e);
        setHelperText(savedState.f11469f);
        setPlaceholderText(savedState.f11470g);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.f11431i.k()) {
            savedState.f11466c = getError();
        }
        savedState.f11467d = J() && this.f11449r0.isChecked();
        savedState.f11468e = getHint();
        savedState.f11469f = getHelperText();
        savedState.f11470g = getPlaceholderText();
        return savedState;
    }

    void p0(int i10) {
        boolean z10 = this.f11436l;
        int i11 = this.f11434k;
        if (i11 == -1) {
            this.f11438m.setText(String.valueOf(i10));
            this.f11438m.setContentDescription(null);
            this.f11436l = false;
        } else {
            this.f11436l = i10 > i11;
            q0(getContext(), this.f11438m, i10, this.f11434k, this.f11436l);
            if (z10 != this.f11436l) {
                r0();
            }
            this.f11438m.setText(i0.a.c().j(getContext().getString(j.f25313d, Integer.valueOf(i10), Integer.valueOf(this.f11434k))));
        }
        if (this.f11427e != null && z10 != this.f11436l) {
            w0(false);
            G0();
            t0();
        }
    }

    public void setBoxBackgroundColor(int i10) {
        if (this.P != i10) {
            this.P = i10;
            this.K0 = i10;
            this.M0 = i10;
            this.N0 = i10;
            j();
        }
    }

    public void setBoxBackgroundColorResource(int i10) {
        setBoxBackgroundColor(androidx.core.content.b.c(getContext(), i10));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.K0 = defaultColor;
        this.P = defaultColor;
        this.L0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.M0 = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.N0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        j();
    }

    public void setBoxBackgroundMode(int i10) {
        if (i10 != this.J) {
            this.J = i10;
            if (this.f11427e != null) {
                T();
            }
        }
    }

    public void setBoxCollapsedPaddingTop(int i10) {
        this.K = i10;
    }

    public void setBoxStrokeColor(int i10) {
        if (this.I0 != i10) {
            this.I0 = i10;
            G0();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.G0 = colorStateList.getDefaultColor();
            this.O0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.H0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
            this.I0 = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        } else if (this.I0 != colorStateList.getDefaultColor()) {
            this.I0 = colorStateList.getDefaultColor();
        }
        G0();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.J0 != colorStateList) {
            this.J0 = colorStateList;
            G0();
        }
    }

    public void setBoxStrokeWidth(int i10) {
        this.M = i10;
        G0();
    }

    public void setBoxStrokeWidthFocused(int i10) {
        this.N = i10;
        G0();
    }

    public void setBoxStrokeWidthFocusedResource(int i10) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i10));
    }

    public void setBoxStrokeWidthResource(int i10) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i10));
    }

    public void setCounterEnabled(boolean z10) {
        if (this.f11432j != z10) {
            if (z10) {
                b0 b0Var = new b0(getContext());
                this.f11438m = b0Var;
                b0Var.setId(d7.f.f25253f0);
                Typeface typeface = this.T;
                if (typeface != null) {
                    this.f11438m.setTypeface(typeface);
                }
                this.f11438m.setMaxLines(1);
                this.f11431i.d(this.f11438m, 2);
                i.d((ViewGroup.MarginLayoutParams) this.f11438m.getLayoutParams(), getResources().getDimensionPixelOffset(d7.d.f25233z0));
                r0();
                o0();
            } else {
                this.f11431i.z(this.f11438m, 2);
                this.f11438m = null;
            }
            this.f11432j = z10;
        }
    }

    public void setCounterMaxLength(int i10) {
        if (this.f11434k != i10) {
            if (i10 > 0) {
                this.f11434k = i10;
            } else {
                this.f11434k = -1;
            }
            if (this.f11432j) {
                o0();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i10) {
        if (this.f11440n != i10) {
            this.f11440n = i10;
            r0();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.f11460x != colorStateList) {
            this.f11460x = colorStateList;
            r0();
        }
    }

    public void setCounterTextAppearance(int i10) {
        if (this.f11442o != i10) {
            this.f11442o = i10;
            r0();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.f11458w != colorStateList) {
            this.f11458w = colorStateList;
            r0();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.E0 = colorStateList;
        this.F0 = colorStateList;
        if (this.f11427e != null) {
            w0(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        W(this, z10);
        super.setEnabled(z10);
    }

    public void setEndIconActivated(boolean z10) {
        this.f11449r0.setActivated(z10);
    }

    public void setEndIconCheckable(boolean z10) {
        this.f11449r0.setCheckable(z10);
    }

    public void setEndIconContentDescription(int i10) {
        setEndIconContentDescription(i10 != 0 ? getResources().getText(i10) : null);
    }

    public void setEndIconDrawable(int i10) {
        setEndIconDrawable(i10 != 0 ? e.a.b(getContext(), i10) : null);
    }

    public void setEndIconMode(int i10) {
        int i11 = this.f11445p0;
        this.f11445p0 = i10;
        D(i11);
        setEndIconVisible(i10 != 0);
        if (getEndIconDelegate().b(this.J)) {
            getEndIconDelegate().a();
            m();
            return;
        }
        throw new IllegalStateException("The current box background mode " + this.J + " is not supported by the end icon mode " + i10);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        e0(this.f11449r0, onClickListener, this.A0);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.A0 = onLongClickListener;
        f0(this.f11449r0, onLongClickListener);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        if (this.f11453t0 != colorStateList) {
            this.f11453t0 = colorStateList;
            this.f11455u0 = true;
            m();
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        if (this.f11457v0 != mode) {
            this.f11457v0 = mode;
            this.f11459w0 = true;
            m();
        }
    }

    public void setEndIconVisible(boolean z10) {
        if (L() != z10) {
            this.f11449r0.setVisibility(z10 ? 0 : 8);
            E0();
            s0();
        }
    }

    public void setError(CharSequence charSequence) {
        if (!this.f11431i.x()) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.f11431i.M(charSequence);
        } else {
            this.f11431i.t();
        }
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        this.f11431i.B(charSequence);
    }

    public void setErrorEnabled(boolean z10) {
        this.f11431i.C(z10);
    }

    public void setErrorIconDrawable(int i10) {
        setErrorIconDrawable(i10 != 0 ? e.a.b(getContext(), i10) : null);
        Y();
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        e0(this.C0, onClickListener, this.B0);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.B0 = onLongClickListener;
        f0(this.C0, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        this.D0 = colorStateList;
        Drawable drawable = this.C0.getDrawable();
        if (drawable != null) {
            drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
            androidx.core.graphics.drawable.a.o(drawable, colorStateList);
        }
        if (this.C0.getDrawable() != drawable) {
            this.C0.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.C0.getDrawable();
        if (drawable != null) {
            drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
            androidx.core.graphics.drawable.a.p(drawable, mode);
        }
        if (this.C0.getDrawable() != drawable) {
            this.C0.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(int i10) {
        this.f11431i.D(i10);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.f11431i.E(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z10) {
        if (this.R0 != z10) {
            this.R0 = z10;
            w0(false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (!N()) {
                setHelperTextEnabled(true);
            }
            this.f11431i.N(charSequence);
        } else if (N()) {
            setHelperTextEnabled(false);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.f11431i.H(colorStateList);
    }

    public void setHelperTextEnabled(boolean z10) {
        this.f11431i.G(z10);
    }

    public void setHelperTextTextAppearance(int i10) {
        this.f11431i.F(i10);
    }

    public void setHint(CharSequence charSequence) {
        if (this.C) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z10) {
        this.S0 = z10;
    }

    public void setHintEnabled(boolean z10) {
        if (z10 != this.C) {
            this.C = z10;
            if (!z10) {
                this.E = false;
                if (!TextUtils.isEmpty(this.D) && TextUtils.isEmpty(this.f11427e.getHint())) {
                    this.f11427e.setHint(this.D);
                }
                setHintInternal(null);
            } else {
                CharSequence hint = this.f11427e.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.D)) {
                        setHint(hint);
                    }
                    this.f11427e.setHint((CharSequence) null);
                }
                this.E = true;
            }
            if (this.f11427e != null) {
                v0();
            }
        }
    }

    public void setHintTextAppearance(int i10) {
        this.Q0.M(i10);
        this.F0 = this.Q0.p();
        if (this.f11427e != null) {
            w0(false);
            v0();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.F0 != colorStateList) {
            if (this.E0 == null) {
                this.Q0.O(colorStateList);
            }
            this.F0 = colorStateList;
            if (this.f11427e != null) {
                w0(false);
            }
        }
    }

    public void setMaxWidth(int i10) {
        this.f11430h = i10;
        EditText editText = this.f11427e;
        if (editText != null && i10 != -1) {
            editText.setMaxWidth(i10);
        }
    }

    public void setMaxWidthResource(int i10) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i10));
    }

    public void setMinWidth(int i10) {
        this.f11429g = i10;
        EditText editText = this.f11427e;
        if (editText != null && i10 != -1) {
            editText.setMinWidth(i10);
        }
    }

    public void setMinWidthResource(int i10) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i10));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i10) {
        setPasswordVisibilityToggleContentDescription(i10 != 0 ? getResources().getText(i10) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i10) {
        setPasswordVisibilityToggleDrawable(i10 != 0 ? e.a.b(getContext(), i10) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z10) {
        if (z10 && this.f11445p0 != 1) {
            setEndIconMode(1);
        } else if (!z10) {
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.f11453t0 = colorStateList;
        this.f11455u0 = true;
        m();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.f11457v0 = mode;
        this.f11459w0 = true;
        m();
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (!this.f11446q || !TextUtils.isEmpty(charSequence)) {
            if (!this.f11446q) {
                setPlaceholderTextEnabled(true);
            }
            this.f11444p = charSequence;
        } else {
            setPlaceholderTextEnabled(false);
        }
        z0();
    }

    public void setPlaceholderTextAppearance(int i10) {
        this.f11452t = i10;
        TextView textView = this.f11448r;
        if (textView != null) {
            androidx.core.widget.j.q(textView, i10);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.f11450s != colorStateList) {
            this.f11450s = colorStateList;
            TextView textView = this.f11448r;
            if (textView != null && colorStateList != null) {
                textView.setTextColor(colorStateList);
            }
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        this.f11462y = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f11464z.setText(charSequence);
        C0();
    }

    public void setPrefixTextAppearance(int i10) {
        androidx.core.widget.j.q(this.f11464z, i10);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.f11464z.setTextColor(colorStateList);
    }

    public void setStartIconCheckable(boolean z10) {
        this.U.setCheckable(z10);
    }

    public void setStartIconContentDescription(int i10) {
        setStartIconContentDescription(i10 != 0 ? getResources().getText(i10) : null);
    }

    public void setStartIconDrawable(int i10) {
        setStartIconDrawable(i10 != 0 ? e.a.b(getContext(), i10) : null);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        e0(this.U, onClickListener, this.f11441n0);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f11441n0 = onLongClickListener;
        f0(this.U, onLongClickListener);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        if (this.V != colorStateList) {
            this.V = colorStateList;
            this.W = true;
            o();
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        if (this.f11433j0 != mode) {
            this.f11433j0 = mode;
            this.f11435k0 = true;
            o();
        }
    }

    public void setStartIconVisible(boolean z10) {
        if (R() != z10) {
            this.U.setVisibility(z10 ? 0 : 8);
            B0();
            s0();
        }
    }

    public void setSuffixText(CharSequence charSequence) {
        this.A = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.B.setText(charSequence);
        F0();
    }

    public void setSuffixTextAppearance(int i10) {
        androidx.core.widget.j.q(this.B, i10);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.B.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(e eVar) {
        EditText editText = this.f11427e;
        if (editText != null) {
            d0.t0(editText, eVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.T) {
            this.T = typeface;
            this.Q0.f0(typeface);
            this.f11431i.J(typeface);
            TextView textView = this.f11438m;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t0() {
        Drawable background;
        TextView textView;
        EditText editText = this.f11427e;
        if (editText != null && this.J == 0 && (background = editText.getBackground()) != null) {
            if (g0.a(background)) {
                background = background.mutate();
            }
            if (this.f11431i.k()) {
                background.setColorFilter(androidx.appcompat.widget.j.e(this.f11431i.o(), PorterDuff.Mode.SRC_IN));
            } else if (!this.f11436l || (textView = this.f11438m) == null) {
                androidx.core.graphics.drawable.a.c(background);
                this.f11427e.refreshDrawableState();
            } else {
                background.setColorFilter(androidx.appcompat.widget.j.e(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w0(boolean z10) {
        x0(z10, false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v145 */
    /* JADX WARN: Type inference failed for: r2v146 */
    /* JADX WARN: Type inference failed for: r2v46, types: [int, boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TextInputLayout(Context context, AttributeSet attributeSet, int i10) {
        super(x7.a.c(context, attributeSet, i10, r9), attributeSet, i10);
        int i11;
        ?? r22;
        boolean z10;
        int i12;
        int i13 = W0;
        this.f11429g = -1;
        this.f11430h = -1;
        this.f11431i = new com.google.android.material.textfield.f(this);
        this.Q = new Rect();
        this.R = new Rect();
        this.S = new RectF();
        this.f11443o0 = new LinkedHashSet<>();
        this.f11445p0 = 0;
        SparseArray<com.google.android.material.textfield.e> sparseArray = new SparseArray<>();
        this.f11447q0 = sparseArray;
        this.f11451s0 = new LinkedHashSet<>();
        com.google.android.material.internal.a aVar = new com.google.android.material.internal.a(this);
        this.Q0 = aVar;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f11423a = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        addView(frameLayout);
        LinearLayout linearLayout = new LinearLayout(context2);
        this.f11424b = linearLayout;
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        frameLayout.addView(linearLayout);
        LinearLayout linearLayout2 = new LinearLayout(context2);
        this.f11425c = linearLayout2;
        linearLayout2.setOrientation(0);
        linearLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        frameLayout.addView(linearLayout2);
        FrameLayout frameLayout2 = new FrameLayout(context2);
        this.f11426d = frameLayout2;
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        TimeInterpolator timeInterpolator = e7.a.f25833a;
        aVar.e0(timeInterpolator);
        aVar.b0(timeInterpolator);
        aVar.P(8388659);
        int[] iArr = l.E5;
        int i14 = l.Z5;
        int i15 = l.X5;
        int i16 = l.f25465m6;
        int i17 = l.f25504r6;
        int i18 = l.f25536v6;
        x0 i19 = com.google.android.material.internal.k.i(context2, attributeSet, iArr, i10, i13, i14, i15, i16, i17, i18);
        this.C = i19.a(l.f25528u6, true);
        setHint(i19.p(l.J5));
        this.S0 = i19.a(l.f25520t6, true);
        this.R0 = i19.a(l.f25481o6, true);
        int i20 = l.I5;
        if (i19.s(i20)) {
            i11 = -1;
            setMinWidth(i19.f(i20, -1));
        } else {
            i11 = -1;
        }
        int i21 = l.H5;
        if (i19.s(i21)) {
            setMaxWidth(i19.f(i21, i11));
        }
        this.H = w7.k.e(context2, attributeSet, i10, i13).m();
        this.I = context2.getResources().getDimensionPixelOffset(d7.d.f25227w0);
        this.K = i19.e(l.M5, 0);
        this.M = i19.f(l.T5, context2.getResources().getDimensionPixelSize(d7.d.f25229x0));
        this.N = i19.f(l.U5, context2.getResources().getDimensionPixelSize(d7.d.f25231y0));
        this.L = this.M;
        float d10 = i19.d(l.Q5, -1.0f);
        float d11 = i19.d(l.P5, -1.0f);
        float d12 = i19.d(l.N5, -1.0f);
        float d13 = i19.d(l.O5, -1.0f);
        k.b v10 = this.H.v();
        if (d10 >= 0.0f) {
            v10.A(d10);
        }
        if (d11 >= 0.0f) {
            v10.E(d11);
        }
        if (d12 >= 0.0f) {
            v10.w(d12);
        }
        if (d13 >= 0.0f) {
            v10.s(d13);
        }
        this.H = v10.m();
        ColorStateList b10 = t7.c.b(context2, i19, l.K5);
        if (b10 != null) {
            int defaultColor = b10.getDefaultColor();
            this.K0 = defaultColor;
            this.P = defaultColor;
            if (b10.isStateful()) {
                this.L0 = b10.getColorForState(new int[]{-16842910}, -1);
                this.M0 = b10.getColorForState(new int[]{16842908, 16842910}, -1);
                this.N0 = b10.getColorForState(new int[]{16843623, 16842910}, -1);
            } else {
                this.M0 = this.K0;
                ColorStateList a10 = e.a.a(context2, d7.c.f25178h);
                this.L0 = a10.getColorForState(new int[]{-16842910}, -1);
                this.N0 = a10.getColorForState(new int[]{16843623}, -1);
            }
        } else {
            this.P = 0;
            this.K0 = 0;
            this.L0 = 0;
            this.M0 = 0;
            this.N0 = 0;
        }
        int i22 = l.G5;
        if (i19.s(i22)) {
            ColorStateList c10 = i19.c(i22);
            this.F0 = c10;
            this.E0 = c10;
        }
        int i23 = l.R5;
        ColorStateList b11 = t7.c.b(context2, i19, i23);
        this.I0 = i19.b(i23, 0);
        this.G0 = androidx.core.content.b.c(context2, d7.c.f25179i);
        this.O0 = androidx.core.content.b.c(context2, d7.c.f25180j);
        this.H0 = androidx.core.content.b.c(context2, d7.c.f25181k);
        if (b11 != null) {
            setBoxStrokeColorStateList(b11);
        }
        int i24 = l.S5;
        if (i19.s(i24)) {
            setBoxStrokeErrorColor(t7.c.b(context2, i19, i24));
        }
        if (i19.n(i18, -1) != -1) {
            r22 = 0;
            setHintTextAppearance(i19.n(i18, 0));
        } else {
            r22 = 0;
        }
        int i25 = r22 == true ? 1 : 0;
        int i26 = r22 == true ? 1 : 0;
        int n10 = i19.n(i16, i25);
        CharSequence p10 = i19.p(l.f25425h6);
        boolean a11 = i19.a(l.f25433i6, r22);
        LayoutInflater from = LayoutInflater.from(getContext());
        int i27 = h.f25290h;
        CheckableImageButton checkableImageButton = (CheckableImageButton) from.inflate(i27, linearLayout2, (boolean) r22);
        this.C0 = checkableImageButton;
        checkableImageButton.setId(d7.f.f25251e0);
        checkableImageButton.setVisibility(8);
        if (t7.c.g(context2)) {
            i.d((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), r22);
        }
        int i28 = l.f25441j6;
        if (i19.s(i28)) {
            setErrorIconDrawable(i19.g(i28));
        }
        int i29 = l.f25449k6;
        if (i19.s(i29)) {
            setErrorIconTintList(t7.c.b(context2, i19, i29));
        }
        int i30 = l.f25457l6;
        if (i19.s(i30)) {
            setErrorIconTintMode(m.e(i19.k(i30, -1), null));
        }
        checkableImageButton.setContentDescription(getResources().getText(j.f25315f));
        d0.E0(checkableImageButton, 2);
        checkableImageButton.setClickable(false);
        checkableImageButton.setPressable(false);
        checkableImageButton.setFocusable(false);
        int n11 = i19.n(i17, 0);
        boolean a12 = i19.a(l.f25496q6, false);
        CharSequence p11 = i19.p(l.f25489p6);
        int n12 = i19.n(l.D6, 0);
        CharSequence p12 = i19.p(l.C6);
        int n13 = i19.n(l.G6, 0);
        CharSequence p13 = i19.p(l.F6);
        int n14 = i19.n(l.O6, 0);
        CharSequence p14 = i19.p(l.N6);
        boolean a13 = i19.a(l.V5, false);
        setCounterMaxLength(i19.k(l.W5, -1));
        this.f11442o = i19.n(i14, 0);
        this.f11440n = i19.n(i15, 0);
        CheckableImageButton checkableImageButton2 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(h.f25291i, (ViewGroup) linearLayout, false);
        this.U = checkableImageButton2;
        checkableImageButton2.setVisibility(8);
        if (t7.c.g(context2)) {
            i.c((ViewGroup.MarginLayoutParams) checkableImageButton2.getLayoutParams(), 0);
        }
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        int i31 = l.K6;
        if (i19.s(i31)) {
            setStartIconDrawable(i19.g(i31));
            int i32 = l.J6;
            if (i19.s(i32)) {
                setStartIconContentDescription(i19.p(i32));
            }
            setStartIconCheckable(i19.a(l.I6, true));
        }
        int i33 = l.L6;
        if (i19.s(i33)) {
            setStartIconTintList(t7.c.b(context2, i19, i33));
        }
        int i34 = l.M6;
        if (i19.s(i34)) {
            setStartIconTintMode(m.e(i19.k(i34, -1), null));
        }
        setBoxBackgroundMode(i19.k(l.L5, 0));
        CheckableImageButton checkableImageButton3 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(i27, (ViewGroup) frameLayout2, false);
        this.f11449r0 = checkableImageButton3;
        frameLayout2.addView(checkableImageButton3);
        checkableImageButton3.setVisibility(8);
        if (t7.c.g(context2)) {
            i.d((ViewGroup.MarginLayoutParams) checkableImageButton3.getLayoutParams(), 0);
        }
        int n15 = i19.n(l.f25393d6, 0);
        sparseArray.append(-1, new com.google.android.material.textfield.b(this, n15));
        sparseArray.append(0, new h(this));
        if (n15 == 0) {
            z10 = a11;
            i12 = i19.n(l.f25560y6, 0);
        } else {
            z10 = a11;
            i12 = n15;
        }
        sparseArray.append(1, new i(this, i12));
        sparseArray.append(2, new com.google.android.material.textfield.a(this, n15));
        sparseArray.append(3, new com.google.android.material.textfield.d(this, n15));
        int i35 = l.f25401e6;
        if (i19.s(i35)) {
            setEndIconMode(i19.k(i35, 0));
            int i36 = l.f25385c6;
            if (i19.s(i36)) {
                setEndIconContentDescription(i19.p(i36));
            }
            setEndIconCheckable(i19.a(l.f25377b6, true));
        } else {
            int i37 = l.f25568z6;
            if (i19.s(i37)) {
                setEndIconMode(i19.a(i37, false) ? 1 : 0);
                setEndIconContentDescription(i19.p(l.f25552x6));
                int i38 = l.A6;
                if (i19.s(i38)) {
                    setEndIconTintList(t7.c.b(context2, i19, i38));
                }
                int i39 = l.B6;
                if (i19.s(i39)) {
                    setEndIconTintMode(m.e(i19.k(i39, -1), null));
                }
            }
        }
        if (!i19.s(l.f25568z6)) {
            int i40 = l.f25409f6;
            if (i19.s(i40)) {
                setEndIconTintList(t7.c.b(context2, i19, i40));
            }
            int i41 = l.f25417g6;
            if (i19.s(i41)) {
                setEndIconTintMode(m.e(i19.k(i41, -1), null));
            }
        }
        b0 b0Var = new b0(context2);
        this.f11464z = b0Var;
        b0Var.setId(d7.f.f25261j0);
        b0Var.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        d0.v0(b0Var, 1);
        linearLayout.addView(checkableImageButton2);
        linearLayout.addView(b0Var);
        b0 b0Var2 = new b0(context2);
        this.B = b0Var2;
        b0Var2.setId(d7.f.f25263k0);
        b0Var2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
        d0.v0(b0Var2, 1);
        linearLayout2.addView(b0Var2);
        linearLayout2.addView(checkableImageButton);
        linearLayout2.addView(frameLayout2);
        setHelperTextEnabled(a12);
        setHelperText(p11);
        setHelperTextTextAppearance(n11);
        setErrorEnabled(z10);
        setErrorTextAppearance(n10);
        setErrorContentDescription(p10);
        setCounterTextAppearance(this.f11442o);
        setCounterOverflowTextAppearance(this.f11440n);
        setPlaceholderText(p12);
        setPlaceholderTextAppearance(n12);
        setPrefixText(p13);
        setPrefixTextAppearance(n13);
        setSuffixText(p14);
        setSuffixTextAppearance(n14);
        int i42 = l.f25473n6;
        if (i19.s(i42)) {
            setErrorTextColor(i19.c(i42));
        }
        int i43 = l.f25512s6;
        if (i19.s(i43)) {
            setHelperTextColor(i19.c(i43));
        }
        int i44 = l.f25544w6;
        if (i19.s(i44)) {
            setHintTextColor(i19.c(i44));
        }
        int i45 = l.f25369a6;
        if (i19.s(i45)) {
            setCounterTextColor(i19.c(i45));
        }
        int i46 = l.Y5;
        if (i19.s(i46)) {
            setCounterOverflowTextColor(i19.c(i46));
        }
        int i47 = l.E6;
        if (i19.s(i47)) {
            setPlaceholderTextColor(i19.c(i47));
        }
        int i48 = l.H6;
        if (i19.s(i48)) {
            setPrefixTextColor(i19.c(i48));
        }
        int i49 = l.P6;
        if (i19.s(i49)) {
            setSuffixTextColor(i19.c(i49));
        }
        setCounterEnabled(a13);
        setEnabled(i19.a(l.F5, true));
        i19.w();
        d0.E0(this, 2);
        if (Build.VERSION.SDK_INT >= 26) {
            d0.F0(this, 1);
        }
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.f11449r0.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.f11449r0.setImageDrawable(drawable);
        if (drawable != null) {
            m();
            X();
        }
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.U.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.U.setImageDrawable(drawable);
        if (drawable != null) {
            o();
            setStartIconVisible(true);
            a0();
            return;
        }
        setStartIconVisible(false);
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        setStartIconContentDescription((CharSequence) null);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.C0.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.f11431i.x());
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f11449r0.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f11449r0.setImageDrawable(drawable);
    }

    public void setHint(int i10) {
        setHint(i10 != 0 ? getResources().getText(i10) : null);
    }
}
