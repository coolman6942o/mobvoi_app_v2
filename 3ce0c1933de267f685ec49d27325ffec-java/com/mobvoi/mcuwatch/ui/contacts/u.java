package com.mobvoi.mcuwatch.ui.contacts;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import kotlin.jvm.internal.i;
/* compiled from: PhoneWatcher.kt */
/* loaded from: classes2.dex */
public final class u implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    private final EditText f19568a;

    public u(EditText view) {
        i.f(view, "view");
        this.f19568a = view;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s10) {
        i.f(s10, "s");
        EditText editText = this.f19568a;
        editText.setSelection(editText.length());
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s10, int i10, int i11, int i12) {
        i.f(s10, "s");
        int length = s10.length();
        if (i12 == 0) {
            if (length == 4) {
                this.f19568a.setText(s10.subSequence(0, 3));
            }
            if (length == 9) {
                this.f19568a.setText(s10.subSequence(0, 8));
            }
        }
        if (i12 == 1) {
            StringBuilder sb2 = new StringBuilder(s10);
            if (length == 4) {
                sb2.insert(3, " ");
                this.f19568a.setText(sb2);
            }
            if (length == 9) {
                sb2.insert(8, " ");
                this.f19568a.setText(sb2);
            }
        }
    }
}
