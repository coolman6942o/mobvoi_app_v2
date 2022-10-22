package com.unionpay;

import com.unionpay.tsmservice.data.Constant;
import com.unionpay.utils.UPUtils;
/* loaded from: classes2.dex */
final class o implements y {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UPPayWapActivity f24465a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(UPPayWapActivity uPPayWapActivity) {
        this.f24465a = uPPayWapActivity;
    }

    @Override // com.unionpay.y
    public final void a(String str, z zVar) {
        String b10;
        String a10 = UPUtils.a(this.f24465a, str);
        if (zVar != null) {
            b10 = UPPayWapActivity.b("0", Constant.CASH_LOAD_SUCCESS, a10);
            zVar.a(b10);
        }
    }
}
