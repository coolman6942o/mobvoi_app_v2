package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.core.view.b0;
import androidx.core.widget.b;
import androidx.core.widget.j;
import androidx.core.widget.n;
import d.a;
/* compiled from: AppCompatButton.java */
/* loaded from: classes.dex */
public class e extends Button implements b0, b, n {

    /* renamed from: a  reason: collision with root package name */
    private final d f1147a;

    /* renamed from: b  reason: collision with root package name */
    private final a0 f1148b;

    /* renamed from: c  reason: collision with root package name */
    private m f1149c;

    public e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.f24729q);
    }

    private m getEmojiTextViewHelper() {
        if (this.f1149c == null) {
            this.f1149c = new m(this);
        }
        return this.f1149c;
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f1147a;
        if (dVar != null) {
            dVar.b();
        }
        a0 a0Var = this.f1148b;
        if (a0Var != null) {
            a0Var.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (b.X) {
            return super.getAutoSizeMaxTextSize();
        }
        a0 a0Var = this.f1148b;
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
        a0 a0Var = this.f1148b;
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
        a0 a0Var = this.f1148b;
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
        a0 a0Var = this.f1148b;
        return a0Var != null ? a0Var.h() : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (b.X) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        a0 a0Var = this.f1148b;
        if (a0Var != null) {
            return a0Var.i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return j.s(super.getCustomSelectionActionModeCallback());
    }

    @Override // androidx.core.view.b0
    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f1147a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.b0
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1147a;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1148b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1148b.k();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        a0 a0Var = this.f1148b;
        if (a0Var != null) {
            a0Var.o(z10, i10, i11, i12, i13);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        super.onTextChanged(charSequence, i10, i11, i12);
        a0 a0Var = this.f1148b;
        if (a0Var != null && !b.X && a0Var.l()) {
            this.f1148b.c();
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
        a0 a0Var = this.f1148b;
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
        a0 a0Var = this.f1148b;
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
        a0 a0Var = this.f1148b;
        if (a0Var != null) {
            a0Var.v(i10);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1147a;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        d dVar = this.f1147a;
        if (dVar != null) {
            dVar.g(i10);
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

    public void setSupportAllCaps(boolean z10) {
        a0 a0Var = this.f1148b;
        if (a0Var != null) {
            a0Var.s(z10);
        }
    }

    @Override // androidx.core.view.b0
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f1147a;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.b0
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f1147a;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    @Override // androidx.core.widget.n
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1148b.w(colorStateList);
        this.f1148b.b();
    }

    @Override // androidx.core.widget.n
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1148b.x(mode);
        this.f1148b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        a0 a0Var = this.f1148b;
        if (a0Var != null) {
            a0Var.q(context, i10);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i10, float f10) {
        if (b.X) {
            super.setTextSize(i10, f10);
            return;
        }
        a0 a0Var = this.f1148b;
        if (a0Var != null) {
            a0Var.A(i10, f10);
        }
    }

    public e(Context context, AttributeSet attributeSet, int i10) {
        super(u0.b(context), attributeSet, i10);
        s0.a(this, getContext());
        d dVar = new d(this);
        this.f1147a = dVar;
        dVar.e(attributeSet, i10);
        a0 a0Var = new a0(this);
        this.f1148b = a0Var;
        a0Var.m(attributeSet, i10);
        a0Var.b();
        getEmojiTextViewHelper().c(attributeSet, i10);
    }
}
