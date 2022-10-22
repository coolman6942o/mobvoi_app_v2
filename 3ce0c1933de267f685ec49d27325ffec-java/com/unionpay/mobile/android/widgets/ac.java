package com.unionpay.mobile.android.widgets;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.unionpay.mobile.android.widgets.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ac implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aa f24280a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(aa aaVar) {
        this.f24280a = aaVar;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.f24280a.a(editable);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        if (this.f24280a.f24277b.hasFocus() && TextUtils.isEmpty(this.f24280a.f24277b.b())) {
            this.f24280a.s();
            this.f24280a.d();
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        aa.a aVar;
        aa.a aVar2;
        aVar = this.f24280a.f24278c;
        if (aVar != null) {
            aVar2 = this.f24280a.f24278c;
            aVar2.a(this.f24280a.f24277b, charSequence.toString());
        }
    }
}
