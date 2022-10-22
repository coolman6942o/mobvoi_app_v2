package com.unionpay.b;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.unionpay.UPSEInfoResp;
import com.unionpay.utils.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class h implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f23296a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.f23296a = gVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        int i10 = message.what;
        if (i10 == 1) {
            handler = this.f23296a.f23294i;
            handler.removeMessages(4);
            j.b("uppay", "msg error");
            g.a(this.f23296a, message.arg1, (String) message.obj);
            return false;
        } else if (i10 == 4) {
            j.b("uppay", "timeout");
            g.a(this.f23296a, message.arg1, UPSEInfoResp.ERROR_TIMEOUT);
            this.f23296a.f23287b = null;
            return false;
        } else if (i10 != 4000) {
            return false;
        } else {
            handler2 = this.f23296a.f23294i;
            handler2.removeMessages(4);
            g.a(this.f23296a, (Bundle) message.obj);
            return false;
        }
    }
}
