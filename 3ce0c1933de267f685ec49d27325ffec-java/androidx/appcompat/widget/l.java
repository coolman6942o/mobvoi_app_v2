package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import d.j;
import u0.a;
/* compiled from: AppCompatEmojiEditTextHelper.java */
/* loaded from: classes.dex */
class l {

    /* renamed from: a  reason: collision with root package name */
    private final EditText f1254a;

    /* renamed from: b  reason: collision with root package name */
    private final a f1255b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(EditText editText) {
        this.f1254a = editText;
        this.f1255b = new a(editText, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public KeyListener a(KeyListener keyListener) {
        return this.f1255b.a(keyListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        boolean isFocusable = this.f1254a.isFocusable();
        int inputType = this.f1254a.getInputType();
        EditText editText = this.f1254a;
        editText.setKeyListener(editText.getKeyListener());
        this.f1254a.setRawInputType(inputType);
        this.f1254a.setFocusable(isFocusable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Finally extract failed */
    public void c(AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = this.f1254a.getContext().obtainStyledAttributes(attributeSet, j.f24870d0, i10, 0);
        try {
            int i11 = j.f24940r0;
            boolean z10 = true;
            if (obtainStyledAttributes.hasValue(i11)) {
                z10 = obtainStyledAttributes.getBoolean(i11, true);
            }
            obtainStyledAttributes.recycle();
            e(z10);
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InputConnection d(InputConnection inputConnection, EditorInfo editorInfo) {
        return this.f1255b.b(inputConnection, editorInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(boolean z10) {
        this.f1255b.c(z10);
    }
}
