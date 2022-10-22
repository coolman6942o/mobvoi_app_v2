package com.unionpay;

import com.unionpay.tsmservice.data.Constant;
/* loaded from: classes2.dex */
final class q implements y {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UPPayWapActivity f24467a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(UPPayWapActivity uPPayWapActivity) {
        this.f24467a = uPPayWapActivity;
    }

    @Override // com.unionpay.y
    public final void a(String str, z zVar) {
        String b10;
        Boolean.parseBoolean(str);
        this.f24467a.f23249a.setVisibility(r1 ? 0 : 8);
        if (zVar != null) {
            b10 = UPPayWapActivity.b("0", Constant.CASH_LOAD_SUCCESS, null);
            zVar.a(b10);
        }
    }
}
