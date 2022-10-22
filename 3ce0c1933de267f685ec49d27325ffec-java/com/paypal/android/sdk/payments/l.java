package com.paypal.android.sdk.payments;

import android.text.Editable;
import android.text.TextWatcher;
/* loaded from: classes2.dex */
final class l implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ LoginActivity f21770a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LoginActivity loginActivity) {
        this.f21770a = loginActivity;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.f21770a.D();
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }
}
