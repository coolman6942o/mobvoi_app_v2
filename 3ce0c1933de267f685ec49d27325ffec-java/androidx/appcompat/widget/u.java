package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.core.view.b0;
import androidx.core.widget.m;
import d.a;
/* compiled from: AppCompatRadioButton.java */
/* loaded from: classes.dex */
public class u extends RadioButton implements m, b0 {

    /* renamed from: a  reason: collision with root package name */
    private final i f1346a;

    /* renamed from: b  reason: collision with root package name */
    private final d f1347b;

    /* renamed from: c  reason: collision with root package name */
    private final a0 f1348c;

    /* renamed from: d  reason: collision with root package name */
    private m f1349d;

    public u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.I);
    }

    private m getEmojiTextViewHelper() {
        if (this.f1349d == null) {
            this.f1349d = new m(this);
        }
        return this.f1349d;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f1347b;
        if (dVar != null) {
            dVar.b();
        }
        a0 a0Var = this.f1348c;
        if (a0Var != null) {
            a0Var.b();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        i iVar = this.f1346a;
        return iVar != null ? iVar.b(compoundPaddingLeft) : compoundPaddingLeft;
    }

    @Override // androidx.core.view.b0
    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f1347b;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.b0
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1347b;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    @Override // androidx.core.widget.m
    public ColorStateList getSupportButtonTintList() {
        i iVar = this.f1346a;
        if (iVar != null) {
            return iVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        i iVar = this.f1346a;
        if (iVar != null) {
            return iVar.d();
        }
        return null;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().d(z10);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1347b;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        d dVar = this.f1347b;
        if (dVar != null) {
            dVar.g(i10);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        i iVar = this.f1346a;
        if (iVar != null) {
            iVar.f();
        }
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().e(z10);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    @Override // androidx.core.view.b0
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f1347b;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.b0
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f1347b;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    @Override // androidx.core.widget.m
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        i iVar = this.f1346a;
        if (iVar != null) {
            iVar.g(colorStateList);
        }
    }

    @Override // androidx.core.widget.m
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        i iVar = this.f1346a;
        if (iVar != null) {
            iVar.h(mode);
        }
    }

    public u(Context context, AttributeSet attributeSet, int i10) {
        super(u0.b(context), attributeSet, i10);
        s0.a(this, getContext());
        i iVar = new i(this);
        this.f1346a = iVar;
        iVar.e(attributeSet, i10);
        d dVar = new d(this);
        this.f1347b = dVar;
        dVar.e(attributeSet, i10);
        a0 a0Var = new a0(this);
        this.f1348c = a0Var;
        a0Var.m(attributeSet, i10);
        getEmojiTextViewHelper().c(attributeSet, i10);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i10) {
        setButtonDrawable(e.a.b(getContext(), i10));
    }
}
