package com.unionpay;

import com.unionpay.tsmservice.data.Constant;
/* loaded from: classes2.dex */
final class m implements y {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UPPayWapActivity f23308a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(UPPayWapActivity uPPayWapActivity) {
        this.f23308a = uPPayWapActivity;
    }

    @Override // com.unionpay.y
    public final void a(String str, z zVar) {
        String b10;
        String a10 = UPPayAssistEx.a(this.f23308a);
        if (zVar != null) {
            b10 = UPPayWapActivity.b("0", Constant.CASH_LOAD_SUCCESS, a10);
            zVar.a(b10);
        }
    }
}
