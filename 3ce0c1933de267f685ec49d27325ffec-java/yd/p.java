package yd;

import android.text.TextUtils;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.m;
import com.mobvoi.wear.companion.setup.settings.SettingConstants;
import lb.c;
import sa.o;
import ta.a;
/* compiled from: TimeZoneCountryUtil.java */
/* loaded from: classes2.dex */
public class p {
    public static void e() {
        if (TextUtils.isEmpty(a.s())) {
            k.a("TimeZoneCountryUtil", "need login");
            return;
        }
        String str = (String) i.a().c(SettingConstants.COUNTRY, "");
        final String j10 = c.j();
        k.c("TimeZoneCountryUtil", "check country, sp = %s , current = %s", str, j10);
        if (!j10.equals(str) && m.b(b.e())) {
            com.mobvoi.assistant.account.data.a.v().A(a.s(), j10).Z(cq.a.c()).H(xp.a.b()).Y(new yp.b() { // from class: yd.l
                @Override // yp.b
                public final void call(Object obj) {
                    p.g(j10, (sa.c) obj);
                }
            }, o.f37021a);
        }
    }

    public static void f() {
        if (TextUtils.isEmpty(a.s())) {
            k.a("TimeZoneCountryUtil", "need login");
            return;
        }
        String str = (String) i.a().c("time_zone", "");
        final String k10 = c.k();
        k.c("TimeZoneCountryUtil", "check time zone, sp = %s , current = %s", str, k10);
        if (!k10.equals(str) && m.b(b.e())) {
            com.mobvoi.assistant.account.data.a.v().x(k10).Z(cq.a.c()).H(xp.a.b()).Y(new yp.b() { // from class: yd.m
                @Override // yp.b
                public final void call(Object obj) {
                    p.i(k10, (o) obj);
                }
            }, n.f37020a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(String str, sa.c cVar) {
        if (cVar.b()) {
            k.c("TimeZoneCountryUtil", "country update response : %s", cVar.errorCode + " msg:" + cVar.errorMsg + " status:" + cVar.status);
            i.a().d(SettingConstants.COUNTRY, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(String str, o oVar) {
        k.c("TimeZoneCountryUtil", "time zone post response : %s", oVar);
        if (oVar.a() || oVar.errCode == 100005) {
            i.a().d("time_zone", str);
        }
    }
}
