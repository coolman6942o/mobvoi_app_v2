package com.unionpay.mobile.android.widgets;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class w implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ u f24462a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.f24462a = uVar;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        ImageView imageView;
        ImageView imageView2;
        int i13;
        EditText editText;
        imageView = this.f24462a.f24450c;
        if (imageView != null) {
            if (u.b(this.f24462a)) {
                editText = this.f24462a.f24449b;
                if (editText.isFocused()) {
                    imageView2 = this.f24462a.f24450c;
                    i13 = 0;
                    imageView2.setVisibility(i13);
                }
            }
            imageView2 = this.f24462a.f24450c;
            i13 = 8;
            imageView2.setVisibility(i13);
        }
    }
}
