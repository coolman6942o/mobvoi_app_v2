package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.core.view.b0;
import androidx.core.widget.j;
import androidx.core.widget.l;
import d.a;
/* compiled from: AppCompatCheckedTextView.java */
/* loaded from: classes.dex */
public class g extends CheckedTextView implements l, b0 {

    /* renamed from: a  reason: collision with root package name */
    private final h f1155a;

    /* renamed from: b  reason: collision with root package name */
    private final d f1156b;

    /* renamed from: c  reason: collision with root package name */
    private final a0 f1157c;

    /* renamed from: d  reason: collision with root package name */
    private m f1158d;

    public g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.f24731s);
    }

    private m getEmojiTextViewHelper() {
        if (this.f1158d == null) {
            this.f1158d = new m(this);
        }
        return this.f1158d;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        a0 a0Var = this.f1157c;
        if (a0Var != null) {
            a0Var.b();
        }
        d dVar = this.f1156b;
        if (dVar != null) {
            dVar.b();
        }
        h hVar = this.f1155a;
        if (hVar != null) {
            hVar.a();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return j.s(super.getCustomSelectionActionModeCallback());
    }

    @Override // androidx.core.view.b0
    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f1156b;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.b0
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1156b;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        h hVar = this.f1155a;
        if (hVar != null) {
            return hVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        h hVar = this.f1155a;
        if (hVar != null) {
            return hVar.c();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return n.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().d(z10);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1156b;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        d dVar = this.f1156b;
        if (dVar != null) {
            dVar.g(i10);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        h hVar = this.f1155a;
        if (hVar != null) {
            hVar.e();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(j.t(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().e(z10);
    }

    @Override // androidx.core.view.b0
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f1156b;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.b0
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f1156b;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    @Override // androidx.core.widget.l
    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        h hVar = this.f1155a;
        if (hVar != null) {
            hVar.f(colorStateList);
        }
    }

    @Override // androidx.core.widget.l
    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        h hVar = this.f1155a;
        if (hVar != null) {
            hVar.g(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        a0 a0Var = this.f1157c;
        if (a0Var != null) {
            a0Var.q(context, i10);
        }
    }

    public g(Context context, AttributeSet attributeSet, int i10) {
        super(u0.b(context), attributeSet, i10);
        s0.a(this, getContext());
        a0 a0Var = new a0(this);
        this.f1157c = a0Var;
        a0Var.m(attributeSet, i10);
        a0Var.b();
        d dVar = new d(this);
        this.f1156b = dVar;
        dVar.e(attributeSet, i10);
        h hVar = new h(this);
        this.f1155a = hVar;
        hVar.d(attributeSet, i10);
        getEmojiTextViewHelper().c(attributeSet, i10);
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i10) {
        setCheckMarkDrawable(e.a.b(getContext(), i10));
    }
}
