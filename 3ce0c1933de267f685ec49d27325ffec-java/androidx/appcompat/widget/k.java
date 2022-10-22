package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import androidx.core.view.b0;
import androidx.core.view.c;
import androidx.core.view.d0;
import androidx.core.view.x;
import androidx.core.widget.j;
import d.a;
import m0.b;
/* compiled from: AppCompatEditText.java */
/* loaded from: classes.dex */
public class k extends EditText implements b0, x {

    /* renamed from: a  reason: collision with root package name */
    private final d f1216a;

    /* renamed from: b  reason: collision with root package name */
    private final a0 f1217b;

    /* renamed from: c  reason: collision with root package name */
    private final z f1218c;

    /* renamed from: d  reason: collision with root package name */
    private final androidx.core.widget.k f1219d;

    /* renamed from: e  reason: collision with root package name */
    private final l f1220e;

    public k(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.D);
    }

    @Override // androidx.core.view.x
    public c a(c cVar) {
        return this.f1219d.a(this, cVar);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f1216a;
        if (dVar != null) {
            dVar.b();
        }
        a0 a0Var = this.f1217b;
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
        d dVar = this.f1216a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.b0
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1216a;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        z zVar;
        if (Build.VERSION.SDK_INT >= 28 || (zVar = this.f1218c) == null) {
            return super.getTextClassifier();
        }
        return zVar.a();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        String[] H;
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f1217b.r(this, onCreateInputConnection, editorInfo);
        InputConnection a10 = n.a(onCreateInputConnection, editorInfo, this);
        if (!(a10 == null || Build.VERSION.SDK_INT > 30 || (H = d0.H(this)) == null)) {
            m0.a.d(editorInfo, H);
            a10 = b.b(this, a10, editorInfo);
        }
        return this.f1220e.d(a10, editorInfo);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onDragEvent(DragEvent dragEvent) {
        if (w.a(this, dragEvent)) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.TextView
    public boolean onTextContextMenuItem(int i10) {
        if (w.b(this, i10)) {
            return true;
        }
        return super.onTextContextMenuItem(i10);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1216a;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        d dVar = this.f1216a;
        if (dVar != null) {
            dVar.g(i10);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(j.t(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        this.f1220e.e(z10);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f1220e.a(keyListener));
    }

    @Override // androidx.core.view.b0
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f1216a;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.b0
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f1216a;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        a0 a0Var = this.f1217b;
        if (a0Var != null) {
            a0Var.q(context, i10);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        z zVar;
        if (Build.VERSION.SDK_INT >= 28 || (zVar = this.f1218c) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            zVar.b(textClassifier);
        }
    }

    public k(Context context, AttributeSet attributeSet, int i10) {
        super(u0.b(context), attributeSet, i10);
        s0.a(this, getContext());
        d dVar = new d(this);
        this.f1216a = dVar;
        dVar.e(attributeSet, i10);
        a0 a0Var = new a0(this);
        this.f1217b = a0Var;
        a0Var.m(attributeSet, i10);
        a0Var.b();
        this.f1218c = new z(this);
        this.f1219d = new androidx.core.widget.k();
        l lVar = new l(this);
        this.f1220e = lVar;
        lVar.c(attributeSet, i10);
        lVar.b();
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        if (Build.VERSION.SDK_INT >= 28) {
            return super.getText();
        }
        return super.getEditableText();
    }
}
