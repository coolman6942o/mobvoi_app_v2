package u0;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.emoji2.text.d;
/* compiled from: EmojiKeyListener.java */
/* loaded from: classes.dex */
final class e implements KeyListener {

    /* renamed from: a  reason: collision with root package name */
    private final KeyListener f35250a;

    /* renamed from: b  reason: collision with root package name */
    private final a f35251b;

    /* compiled from: EmojiKeyListener.java */
    /* loaded from: classes.dex */
    public static class a {
        public boolean a(Editable editable, int i10, KeyEvent keyEvent) {
            return d.f(editable, i10, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(KeyListener keyListener) {
        this(keyListener, new a());
    }

    @Override // android.text.method.KeyListener
    public void clearMetaKeyState(View view, Editable editable, int i10) {
        this.f35250a.clearMetaKeyState(view, editable, i10);
    }

    @Override // android.text.method.KeyListener
    public int getInputType() {
        return this.f35250a.getInputType();
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyDown(View view, Editable editable, int i10, KeyEvent keyEvent) {
        return this.f35251b.a(editable, i10, keyEvent) || this.f35250a.onKeyDown(view, editable, i10, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f35250a.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyUp(View view, Editable editable, int i10, KeyEvent keyEvent) {
        return this.f35250a.onKeyUp(view, editable, i10, keyEvent);
    }

    e(KeyListener keyListener, a aVar) {
        this.f35250a = keyListener;
        this.f35251b = aVar;
    }
}
