package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import d7.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ClearTextEndIconDelegate.java */
/* loaded from: classes.dex */
public class a extends com.google.android.material.textfield.e {

    /* renamed from: e  reason: collision with root package name */
    private final TextWatcher f11476e = new C0131a();

    /* renamed from: f  reason: collision with root package name */
    private final View.OnFocusChangeListener f11477f = new b();

    /* renamed from: g  reason: collision with root package name */
    private final TextInputLayout.f f11478g = new c();

    /* renamed from: h  reason: collision with root package name */
    private final TextInputLayout.g f11479h = new d();

    /* renamed from: i  reason: collision with root package name */
    private AnimatorSet f11480i;

    /* renamed from: j  reason: collision with root package name */
    private ValueAnimator f11481j;

    /* compiled from: ClearTextEndIconDelegate.java */
    /* renamed from: com.google.android.material.textfield.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0131a implements TextWatcher {
        C0131a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (a.this.f11523a.getSuffixText() == null) {
                a aVar = a.this;
                aVar.i(aVar.m());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* compiled from: ClearTextEndIconDelegate.java */
    /* loaded from: classes.dex */
    class b implements View.OnFocusChangeListener {
        b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            a aVar = a.this;
            aVar.i(aVar.m());
        }
    }

    /* compiled from: ClearTextEndIconDelegate.java */
    /* loaded from: classes.dex */
    class c implements TextInputLayout.f {
        c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(a.this.m());
            textInputLayout.setEndIconCheckable(false);
            editText.setOnFocusChangeListener(a.this.f11477f);
            a aVar = a.this;
            aVar.f11525c.setOnFocusChangeListener(aVar.f11477f);
            editText.removeTextChangedListener(a.this.f11476e);
            editText.addTextChangedListener(a.this.f11476e);
        }
    }

    /* compiled from: ClearTextEndIconDelegate.java */
    /* loaded from: classes.dex */
    class d implements TextInputLayout.g {

        /* compiled from: ClearTextEndIconDelegate.java */
        /* renamed from: com.google.android.material.textfield.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0132a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ EditText f11486a;

            RunnableC0132a(EditText editText) {
                this.f11486a = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f11486a.removeTextChangedListener(a.this.f11476e);
            }
        }

        d() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i10) {
            EditText editText = textInputLayout.getEditText();
            if (editText != null && i10 == 2) {
                editText.post(new RunnableC0132a(editText));
                if (editText.getOnFocusChangeListener() == a.this.f11477f) {
                    editText.setOnFocusChangeListener(null);
                }
                if (a.this.f11525c.getOnFocusChangeListener() == a.this.f11477f) {
                    a.this.f11525c.setOnFocusChangeListener(null);
                }
            }
        }
    }

    /* compiled from: ClearTextEndIconDelegate.java */
    /* loaded from: classes.dex */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Editable text = a.this.f11523a.getEditText().getText();
            if (text != null) {
                text.clear();
            }
            a.this.f11523a.X();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ClearTextEndIconDelegate.java */
    /* loaded from: classes.dex */
    public class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.f11523a.setEndIconVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ClearTextEndIconDelegate.java */
    /* loaded from: classes.dex */
    public class g extends AnimatorListenerAdapter {
        g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f11523a.setEndIconVisible(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ClearTextEndIconDelegate.java */
    /* loaded from: classes.dex */
    public class h implements ValueAnimator.AnimatorUpdateListener {
        h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.f11525c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ClearTextEndIconDelegate.java */
    /* loaded from: classes.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.f11525c.setScaleX(floatValue);
            a.this.f11525c.setScaleY(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TextInputLayout textInputLayout, int i10) {
        super(textInputLayout, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z10) {
        boolean z11 = this.f11523a.L() == z10;
        if (z10 && !this.f11480i.isRunning()) {
            this.f11481j.cancel();
            this.f11480i.start();
            if (z11) {
                this.f11480i.end();
            }
        } else if (!z10) {
            this.f11480i.cancel();
            this.f11481j.start();
            if (z11) {
                this.f11481j.end();
            }
        }
    }

    private ValueAnimator j(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(e7.a.f25833a);
        ofFloat.setDuration(100L);
        ofFloat.addUpdateListener(new h());
        return ofFloat;
    }

    private ValueAnimator k() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(e7.a.f25836d);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new i());
        return ofFloat;
    }

    private void l() {
        ValueAnimator k10 = k();
        ValueAnimator j10 = j(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f11480i = animatorSet;
        animatorSet.playTogether(k10, j10);
        this.f11480i.addListener(new f());
        ValueAnimator j11 = j(1.0f, 0.0f);
        this.f11481j = j11;
        j11.addListener(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m() {
        EditText editText = this.f11523a.getEditText();
        return editText != null && (editText.hasFocus() || this.f11525c.hasFocus()) && editText.getText().length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public void a() {
        TextInputLayout textInputLayout = this.f11523a;
        int i10 = this.f11526d;
        if (i10 == 0) {
            i10 = d7.e.f25239f;
        }
        textInputLayout.setEndIconDrawable(i10);
        TextInputLayout textInputLayout2 = this.f11523a;
        textInputLayout2.setEndIconContentDescription(textInputLayout2.getResources().getText(j.f25314e));
        this.f11523a.setEndIconOnClickListener(new e());
        this.f11523a.e(this.f11478g);
        this.f11523a.f(this.f11479h);
        l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public void c(boolean z10) {
        if (this.f11523a.getSuffixText() != null) {
            i(z10);
        }
    }
}
