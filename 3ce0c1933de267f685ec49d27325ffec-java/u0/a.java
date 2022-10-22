package u0;

import android.os.Build;
import android.text.method.KeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import j0.h;
/* compiled from: EmojiEditTextHelper.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final b f35238a;

    /* compiled from: EmojiEditTextHelper.java */
    /* renamed from: u0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0510a extends b {

        /* renamed from: a  reason: collision with root package name */
        private final EditText f35239a;

        /* renamed from: b  reason: collision with root package name */
        private final g f35240b;

        C0510a(EditText editText, boolean z10) {
            this.f35239a = editText;
            g gVar = new g(editText, z10);
            this.f35240b = gVar;
            editText.addTextChangedListener(gVar);
            editText.setEditableFactory(u0.b.getInstance());
        }

        @Override // u0.a.b
        KeyListener a(KeyListener keyListener) {
            if (keyListener instanceof e) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return new e(keyListener);
        }

        @Override // u0.a.b
        InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection instanceof c ? inputConnection : new c(this.f35239a, inputConnection, editorInfo);
        }

        @Override // u0.a.b
        void c(boolean z10) {
            this.f35240b.c(z10);
        }
    }

    /* compiled from: EmojiEditTextHelper.java */
    /* loaded from: classes.dex */
    static class b {
        b() {
        }

        KeyListener a(KeyListener keyListener) {
            return keyListener;
        }

        InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection;
        }

        void c(boolean z10) {
        }
    }

    public a(EditText editText, boolean z10) {
        h.h(editText, "editText cannot be null");
        if (Build.VERSION.SDK_INT < 19) {
            this.f35238a = new b();
        } else {
            this.f35238a = new C0510a(editText, z10);
        }
    }

    public KeyListener a(KeyListener keyListener) {
        return this.f35238a.a(keyListener);
    }

    public InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f35238a.b(inputConnection, editorInfo);
    }

    public void c(boolean z10) {
        this.f35238a.c(z10);
    }
}
