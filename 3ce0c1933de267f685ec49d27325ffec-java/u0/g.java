package u0;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.d;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
/* compiled from: EmojiTextWatcher.java */
/* loaded from: classes.dex */
final class g implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    private final EditText f35257a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f35258b;

    /* renamed from: c  reason: collision with root package name */
    private d.e f35259c;

    /* renamed from: d  reason: collision with root package name */
    private int f35260d = Integer.MAX_VALUE;

    /* renamed from: e  reason: collision with root package name */
    private int f35261e = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f35262f = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EmojiTextWatcher.java */
    /* loaded from: classes.dex */
    public static class a extends d.e {

        /* renamed from: a  reason: collision with root package name */
        private final Reference<EditText> f35263a;

        a(EditText editText) {
            this.f35263a = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.d.e
        public void b() {
            super.b();
            g.b(this.f35263a.get(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(EditText editText, boolean z10) {
        this.f35257a = editText;
        this.f35258b = z10;
    }

    private d.e a() {
        if (this.f35259c == null) {
            this.f35259c = new a(this.f35257a);
        }
        return this.f35259c;
    }

    static void b(EditText editText, int i10) {
        if (i10 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            d.b().o(editableText);
            d.b(editableText, selectionStart, selectionEnd);
        }
    }

    private boolean d() {
        return !this.f35262f || (!this.f35258b && !d.h());
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    public void c(boolean z10) {
        if (this.f35262f != z10) {
            if (this.f35259c != null) {
                d.b().t(this.f35259c);
            }
            this.f35262f = z10;
            if (z10) {
                b(this.f35257a, d.b().d());
            }
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        if (!this.f35257a.isInEditMode() && !d() && i11 <= i12 && (charSequence instanceof Spannable)) {
            int d10 = d.b().d();
            if (d10 != 0) {
                if (d10 == 1) {
                    d.b().r((Spannable) charSequence, i10, i10 + i12, this.f35260d, this.f35261e);
                    return;
                } else if (d10 != 3) {
                    return;
                }
            }
            d.b().s(a());
        }
    }
}
