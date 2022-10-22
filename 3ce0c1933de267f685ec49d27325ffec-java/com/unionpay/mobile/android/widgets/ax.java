package com.unionpay.mobile.android.widgets;

import android.view.View;
import com.mobvoi.wear.msgproxy.MessageProxyConstants;
import com.unionpay.mobile.android.utils.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ax implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UPWidget f24330a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(UPWidget uPWidget) {
        this.f24330a = uPWidget;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        long j10;
        long j11;
        UPWidget uPWidget;
        int id2 = view.getId();
        UPWidget uPWidget2 = this.f24330a;
        int i10 = uPWidget2.f24255c;
        if (id2 == 10) {
            k.c("kb", " [ FIN ]");
            UPWidget.b(this.f24330a);
        } else if (id2 == 20) {
            k.c("kb", " [ DEL ]");
            if (i10 > 0) {
                UPWidget uPWidget3 = this.f24330a;
                j11 = uPWidget3.f24256p;
                uPWidget3.deleteOnce(j11);
                uPWidget.f24255c--;
                String substring = ((aa) this.f24330a).f24277b.b().toString().substring(0, i10 - 1);
                ((aa) this.f24330a).f24277b.c(substring);
                ((aa) this.f24330a).f24277b.b(substring.length());
            }
        } else if (i10 == 6) {
            k.c("kb", " [ FIN ]");
        } else {
            j10 = uPWidget2.f24256p;
            uPWidget2.appendOnce(j10, Integer.toString(id2));
            String str = MessageProxyConstants.NODE_ID_ANY;
            if (i10 != 0) {
                str = ((aa) this.f24330a).f24277b.b() + str;
            }
            ((aa) this.f24330a).f24277b.c(str);
            ((aa) this.f24330a).f24277b.b(str.length());
            this.f24330a.f24255c++;
        }
    }
}
