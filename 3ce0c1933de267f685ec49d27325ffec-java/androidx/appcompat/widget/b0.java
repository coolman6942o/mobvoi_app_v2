package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.graphics.a;
import androidx.core.widget.b;
import androidx.core.widget.j;
import androidx.core.widget.n;
import i0.d;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
/* compiled from: AppCompatTextView.java */
/* loaded from: classes.dex */
public class b0 extends TextView implements androidx.core.view.b0, n, b {

    /* renamed from: a  reason: collision with root package name */
    private final d f1092a;

    /* renamed from: b  reason: collision with root package name */
    private final a0 f1093b;

    /* renamed from: c  reason: collision with root package name */
    private final z f1094c;

    /* renamed from: d  reason: collision with root package name */
    private m f1095d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1096e;

    /* renamed from: f  reason: collision with root package name */
    private Future<d> f1097f;

    public b0(Context context) {
        this(context, null);
    }

    private void c() {
        Future<d> future = this.f1097f;
        if (future != null) {
            try {
                this.f1097f = null;
                j.p(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    private m getEmojiTextViewHelper() {
        if (this.f1095d == null) {
            this.f1095d = new m(this);
        }
        return this.f1095d;
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f1092a;
        if (dVar != null) {
            dVar.b();
        }
        a0 a0Var = this.f1093b;
        if (a0Var != null) {
            a0Var.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (b.X) {
            return super.getAutoSizeMaxTextSize();
        }
        a0 a0Var = this.f1093b;
        if (a0Var != null) {
            return a0Var.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (b.X) {
            return super.getAutoSizeMinTextSize();
        }
        a0 a0Var = this.f1093b;
        if (a0Var != null) {
            return a0Var.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (b.X) {
            return super.getAutoSizeStepGranularity();
        }
        a0 a0Var = this.f1093b;
        if (a0Var != null) {
            return a0Var.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (b.X) {
            return super.getAutoSizeTextAvailableSizes();
        }
        a0 a0Var = this.f1093b;
        return a0Var != null ? a0Var.h() : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (b.X) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        a0 a0Var = this.f1093b;
        if (a0Var != null) {
            return a0Var.i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return j.s(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return j.b(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return j.c(this);
    }

    @Override // androidx.core.view.b0
    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f1092a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.b0
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1092a;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1093b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1093b.k();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        c();
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        z zVar;
        if (Build.VERSION.SDK_INT >= 28 || (zVar = this.f1094c) == null) {
            return super.getTextClassifier();
        }
        return zVar.a();
    }

    public d.a getTextMetricsParamsCompat() {
        return j.g(this);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f1093b.r(this, onCreateInputConnection, editorInfo);
        return n.a(onCreateInputConnection, editorInfo, this);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        a0 a0Var = this.f1093b;
        if (a0Var != null) {
            a0Var.o(z10, i10, i11, i12, i13);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        c();
        super.onMeasure(i10, i11);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        super.onTextChanged(charSequence, i10, i11, i12);
        a0 a0Var = this.f1093b;
        if (a0Var != null && !b.X && a0Var.l()) {
            this.f1093b.c();
        }
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().d(z10);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i10, int i11, int i12, int i13) throws IllegalArgumentException {
        if (b.X) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i10, i11, i12, i13);
            return;
        }
        a0 a0Var = this.f1093b;
        if (a0Var != null) {
            a0Var.t(i10, i11, i12, i13);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i10) throws IllegalArgumentException {
        if (b.X) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i10);
            return;
        }
        a0 a0Var = this.f1093b;
        if (a0Var != null) {
            a0Var.u(iArr, i10);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i10) {
        if (b.X) {
            super.setAutoSizeTextTypeWithDefaults(i10);
            return;
        }
        a0 a0Var = this.f1093b;
        if (a0Var != null) {
            a0Var.v(i10);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1092a;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        d dVar = this.f1092a;
        if (dVar != null) {
            dVar.g(i10);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        a0 a0Var = this.f1093b;
        if (a0Var != null) {
            a0Var.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        a0 a0Var = this.f1093b;
        if (a0Var != null) {
            a0Var.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        a0 a0Var = this.f1093b;
        if (a0Var != null) {
            a0Var.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        a0 a0Var = this.f1093b;
        if (a0Var != null) {
            a0Var.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(j.t(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().e(z10);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i10) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i10);
        } else {
            j.m(this, i10);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i10) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i10);
        } else {
            j.n(this, i10);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i10) {
        j.o(this, i10);
    }

    public void setPrecomputedText(d dVar) {
        j.p(this, dVar);
    }

    @Override // androidx.core.view.b0
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f1092a;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.b0
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f1092a;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    @Override // androidx.core.widget.n
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1093b.w(colorStateList);
        this.f1093b.b();
    }

    @Override // androidx.core.widget.n
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1093b.x(mode);
        this.f1093b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        a0 a0Var = this.f1093b;
        if (a0Var != null) {
            a0Var.q(context, i10);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        z zVar;
        if (Build.VERSION.SDK_INT >= 28 || (zVar = this.f1094c) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            zVar.b(textClassifier);
        }
    }

    public void setTextFuture(Future<d> future) {
        this.f1097f = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(d.a aVar) {
        j.r(this, aVar);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i10, float f10) {
        if (b.X) {
            super.setTextSize(i10, f10);
            return;
        }
        a0 a0Var = this.f1093b;
        if (a0Var != null) {
            a0Var.A(i10, f10);
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i10) {
        if (!this.f1096e) {
            Typeface typeface2 = null;
            if (typeface != null && i10 > 0) {
                typeface2 = a.a(getContext(), typeface, i10);
            }
            this.f1096e = true;
            if (typeface2 != null) {
                typeface = typeface2;
            }
            try {
                super.setTypeface(typeface, i10);
            } finally {
                this.f1096e = false;
            }
        }
    }

    public b0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public b0(Context context, AttributeSet attributeSet, int i10) {
        super(u0.b(context), attributeSet, i10);
        this.f1096e = false;
        s0.a(this, getContext());
        d dVar = new d(this);
        this.f1092a = dVar;
        dVar.e(attributeSet, i10);
        a0 a0Var = new a0(this);
        this.f1093b = a0Var;
        a0Var.m(attributeSet, i10);
        a0Var.b();
        this.f1094c = new z(this);
        getEmojiTextViewHelper().c(attributeSet, i10);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable b10 = i10 != 0 ? e.a.b(context, i10) : null;
        Drawable b11 = i11 != 0 ? e.a.b(context, i11) : null;
        Drawable b12 = i12 != 0 ? e.a.b(context, i12) : null;
        if (i13 != 0) {
            drawable = e.a.b(context, i13);
        }
        setCompoundDrawablesRelativeWithIntrinsicBounds(b10, b11, b12, drawable);
        a0 a0Var = this.f1093b;
        if (a0Var != null) {
            a0Var.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable b10 = i10 != 0 ? e.a.b(context, i10) : null;
        Drawable b11 = i11 != 0 ? e.a.b(context, i11) : null;
        Drawable b12 = i12 != 0 ? e.a.b(context, i12) : null;
        if (i13 != 0) {
            drawable = e.a.b(context, i13);
        }
        setCompoundDrawablesWithIntrinsicBounds(b10, b11, b12, drawable);
        a0 a0Var = this.f1093b;
        if (a0Var != null) {
            a0Var.p();
        }
    }
}
