package com.paypal.android.sdk.payments;

import android.text.Editable;
import android.text.TextWatcher;
/* loaded from: classes2.dex */
final class f0 implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ LoginActivity f21722a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f0(LoginActivity loginActivity) {
        this.f21722a = loginActivity;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.f21722a.F();
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }
}
