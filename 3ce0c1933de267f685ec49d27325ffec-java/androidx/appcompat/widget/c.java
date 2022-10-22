package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import androidx.core.view.b0;
import androidx.core.widget.j;
import d.a;
/* compiled from: AppCompatAutoCompleteTextView.java */
/* loaded from: classes.dex */
public class c extends AutoCompleteTextView implements b0 {

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f1111d = {16843126};

    /* renamed from: a  reason: collision with root package name */
    private final d f1112a;

    /* renamed from: b  reason: collision with root package name */
    private final a0 f1113b;

    /* renamed from: c  reason: collision with root package name */
    private final l f1114c;

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.f24728p);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f1112a;
        if (dVar != null) {
            dVar.b();
        }
        a0 a0Var = this.f1113b;
        if (a0Var != null) {
            a0Var.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return j.s(super.getCustomSelectionActionModeCallback());
    }

    @Override // androidx.core.view.b0
    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f1112a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.b0
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1112a;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.f1114c.d(n.a(super.onCreateInputConnection(editorInfo), editorInfo, this), editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1112a;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        d dVar = this.f1112a;
        if (dVar != null) {
            dVar.g(i10);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(j.t(this, callback));
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i10) {
        setDropDownBackgroundDrawable(e.a.b(getContext(), i10));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        this.f1114c.e(z10);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f1114c.a(keyListener));
    }

    @Override // androidx.core.view.b0
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f1112a;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.b0
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f1112a;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        a0 a0Var = this.f1113b;
        if (a0Var != null) {
            a0Var.q(context, i10);
        }
    }

    public c(Context context, AttributeSet attributeSet, int i10) {
        super(u0.b(context), attributeSet, i10);
        s0.a(this, getContext());
        x0 v10 = x0.v(getContext(), attributeSet, f1111d, i10, 0);
        if (v10.s(0)) {
            setDropDownBackgroundDrawable(v10.g(0));
        }
        v10.w();
        d dVar = new d(this);
        this.f1112a = dVar;
        dVar.e(attributeSet, i10);
        a0 a0Var = new a0(this);
        this.f1113b = a0Var;
        a0Var.m(attributeSet, i10);
        a0Var.b();
        l lVar = new l(this);
        this.f1114c = lVar;
        lVar.c(attributeSet, i10);
        lVar.b();
    }
}
