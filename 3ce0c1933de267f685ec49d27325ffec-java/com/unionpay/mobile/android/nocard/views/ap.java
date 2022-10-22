package com.unionpay.mobile.android.nocard.views;

import android.os.Handler;
import android.os.Message;
import android.widget.LinearLayout;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.model.d;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.views.order.l;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ap implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ao f23620a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar) {
        this.f23620a = aoVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        d dVar;
        Map<String, Object> b10;
        k.c("uppay", "mHceHandler. handleMessage");
        this.f23620a.v();
        b.f23493bl = true;
        if (this.f23620a.f23639a.aP == l.f24231e.intValue()) {
            this.f23620a.f23610r.clear();
            this.f23620a.f23610r.remove(new HashMap());
            List<d> list = b.f23492bb;
            if (list == null || list.size() <= 0) {
                this.f23620a.m();
                this.f23620a.f23639a.aP = l.f24227a.intValue();
                ao aoVar = this.f23620a;
                b bVar = aoVar.f23639a;
                aoVar.a(c.bD.f23460bq, bVar.f23521bh, bVar.aE, true);
            } else {
                int size = b.f23492bb.size();
                for (int i10 = 0; i10 < size; i10++) {
                    b10 = ao.b(b.f23492bb.get(i10));
                    this.f23620a.f23610r.add(b10);
                    if (i10 == 0) {
                        this.f23620a.f23615w.b(dVar.b() + dVar.c() + " " + b10.get("text2"));
                    }
                }
                this.f23620a.f23615w.setVisibility(0);
                linearLayout = this.f23620a.f23616x;
                if (linearLayout != null) {
                    linearLayout2 = this.f23620a.f23616x;
                    linearLayout2.setVisibility(8);
                }
            }
        }
        return true;
    }
}
