package com.unionpay.mobile.android.pboctransaction.simapdu;

import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.pboctransaction.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class c implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f23850a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f23850a = bVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        int i10 = message.what;
        if (i10 == 1) {
            bVar = this.f23850a.f23847c;
            if (bVar != null) {
                bVar2 = this.f23850a.f23847c;
                bVar2.a();
                this.f23850a.f23847c = null;
            }
        } else if (i10 == 2) {
            bVar3 = this.f23850a.f23847c;
            if (bVar3 != null) {
                bVar4 = this.f23850a.f23847c;
                bVar4.b();
                this.f23850a.f23847c = null;
            }
        }
        return true;
    }
}
