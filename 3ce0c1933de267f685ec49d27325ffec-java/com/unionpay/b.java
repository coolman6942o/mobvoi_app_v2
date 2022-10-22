package com.unionpay;

import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b implements UPQuerySEPayInfoCallback {
    @Override // com.unionpay.UPQuerySEPayInfoCallback
    public final void onError(String str, String str2, String str3, String str4) {
        String unused = UPPayAssistEx.C = str2;
        UPPayAssistEx.p();
    }

    @Override // com.unionpay.UPQuerySEPayInfoCallback
    public final void onResult(String str, String str2, int i10, Bundle bundle) {
        String unused = UPPayAssistEx.C = str2;
        UPPayAssistEx.p();
    }
}
