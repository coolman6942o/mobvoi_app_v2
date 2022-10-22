package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.ToggleButton;
import androidx.core.view.b0;
/* compiled from: AppCompatToggleButton.java */
/* loaded from: classes.dex */
public class d0 extends ToggleButton implements b0 {

    /* renamed from: a  reason: collision with root package name */
    private final d f1142a;

    /* renamed from: b  reason: collision with root package name */
    private final a0 f1143b;

    /* renamed from: c  reason: collision with root package name */
    private m f1144c;

    public d0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842827);
    }

    private m getEmojiTextViewHelper() {
        if (this.f1144c == null) {
            this.f1144c = new m(this);
        }
        return this.f1144c;
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f1142a;
        if (dVar != null) {
            dVar.b();
        }
        a0 a0Var = this.f1143b;
        if (a0Var != null) {
            a0Var.b();
        }
    }

    @Override // androidx.core.view.b0
    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f1142a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.b0
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1142a;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().d(z10);
    }

    @Override // android.widget.ToggleButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1142a;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        d dVar = this.f1142a;
        if (dVar != null) {
            dVar.g(i10);
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
        d dVar = this.f1142a;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.b0
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f1142a;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    public d0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s0.a(this, getContext());
        d dVar = new d(this);
        this.f1142a = dVar;
        dVar.e(attributeSet, i10);
        a0 a0Var = new a0(this);
        this.f1143b = a0Var;
        a0Var.m(attributeSet, i10);
        getEmojiTextViewHelper().c(attributeSet, i10);
    }
}
