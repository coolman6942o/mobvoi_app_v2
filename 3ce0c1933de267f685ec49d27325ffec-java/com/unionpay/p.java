package com.unionpay;

import com.unionpay.tsmservice.data.Constant;
import com.unionpay.utils.UPUtils;
/* loaded from: classes2.dex */
final class p implements y {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UPPayWapActivity f24466a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(UPPayWapActivity uPPayWapActivity) {
        this.f24466a = uPPayWapActivity;
    }

    @Override // com.unionpay.y
    public final void a(String str, z zVar) {
        String b10;
        UPUtils.b(this.f24466a, str);
        if (zVar != null) {
            b10 = UPPayWapActivity.b("0", Constant.CASH_LOAD_SUCCESS, null);
            zVar.a(b10);
        }
    }
}
