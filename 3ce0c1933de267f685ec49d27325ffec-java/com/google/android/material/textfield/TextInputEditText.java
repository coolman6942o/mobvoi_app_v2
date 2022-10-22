package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.k;
import com.google.android.material.internal.e;
import d7.b;
import d7.d;
import d7.f;
import d7.l;
import x7.a;
/* loaded from: classes.dex */
public class TextInputEditText extends k {

    /* renamed from: f  reason: collision with root package name */
    private final Rect f11421f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f11422g;

    public TextInputEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.f25162r);
    }

    private String b(TextInputLayout textInputLayout) {
        Editable text = getText();
        CharSequence hint = textInputLayout.getHint();
        boolean z10 = !TextUtils.isEmpty(text);
        boolean z11 = !TextUtils.isEmpty(hint);
        if (Build.VERSION.SDK_INT >= 17) {
            setLabelFor(f.f25257h0);
        }
        String str = "";
        String charSequence = z11 ? hint.toString() : str;
        if (!z10) {
            return !TextUtils.isEmpty(charSequence) ? charSequence : str;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) text);
        if (!TextUtils.isEmpty(charSequence)) {
            str = ", " + charSequence;
        }
        sb2.append(str);
        return sb2.toString();
    }

    private CharSequence getHintFromLayout() {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null) {
            return textInputLayout.getHint();
        }
        return null;
    }

    private TextInputLayout getTextInputLayout() {
        for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect rect) {
        super.getFocusedRect(rect);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && this.f11422g && rect != null) {
            textInputLayout.getFocusedRect(this.f11421f);
            rect.bottom = this.f11421f.bottom;
        }
    }

    @Override // android.view.View
    public boolean getGlobalVisibleRect(Rect rect, Point point) {
        boolean globalVisibleRect = super.getGlobalVisibleRect(rect, point);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (!(textInputLayout == null || !this.f11422g || rect == null)) {
            textInputLayout.getGlobalVisibleRect(this.f11421f, point);
            rect.bottom = this.f11421f.bottom;
        }
        return globalVisibleRect;
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout == null || !textInputLayout.P()) {
            return super.getHint();
        }
        return textInputLayout.getHint();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && textInputLayout.P() && super.getHint() == null && e.c()) {
            setHint("");
        }
    }

    @Override // androidx.appcompat.widget.k, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection != null && editorInfo.hintText == null) {
            editorInfo.hintText = getHintFromLayout();
        }
        return onCreateInputConnection;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (Build.VERSION.SDK_INT < 23 && textInputLayout != null) {
            accessibilityNodeInfo.setText(b(textInputLayout));
        }
    }

    @Override // android.view.View
    public boolean requestRectangleOnScreen(Rect rect) {
        boolean requestRectangleOnScreen = super.requestRectangleOnScreen(rect);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && this.f11422g) {
            this.f11421f.set(0, textInputLayout.getHeight() - getResources().getDimensionPixelOffset(d.f25201j0), textInputLayout.getWidth(), textInputLayout.getHeight());
            textInputLayout.requestRectangleOnScreen(this.f11421f, true);
        }
        return requestRectangleOnScreen;
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean z10) {
        this.f11422g = z10;
    }

    public TextInputEditText(Context context, AttributeSet attributeSet, int i10) {
        super(a.c(context, attributeSet, i10, 0), attributeSet, i10);
        this.f11421f = new Rect();
        TypedArray h10 = com.google.android.material.internal.k.h(context, attributeSet, l.C5, i10, d7.k.f25348m, new int[0]);
        setTextInputLayoutFocusedRectEnabled(h10.getBoolean(l.D5, false));
        h10.recycle();
    }
}
