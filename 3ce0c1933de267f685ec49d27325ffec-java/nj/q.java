package nj;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;
import com.cardiex.arty.lite.models.push.AddPushRegistration;
import com.cardiex.arty.lite.models.push.PushRegistrationKind;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.e;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.assistant.account.data.AccountManager;
import com.mobvoi.assistant.account.data.a;
import com.mobvoi.companion.setting.CompanionSetting;
import com.mobvoi.wear.common.base.TicwatchModels;
import ki.c;
import pk.f;
/* compiled from: McuWatchPairManager.java */
/* loaded from: classes2.dex */
public class q {

    /* renamed from: c  reason: collision with root package name */
    private static final String f31282c = "q";

    /* renamed from: d  reason: collision with root package name */
    private static q f31283d;

    /* renamed from: a  reason: collision with root package name */
    private int f31284a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f31285b;

    private q() {
    }

    private void C() {
        a.v().y(AccountManager.h().g().sessionId).Z(cq.a.c()).H(xp.a.b()).Y(n.f31279a, o.f31280a);
    }

    public static q g() {
        if (f31283d == null) {
            synchronized (q.class) {
                if (f31283d == null) {
                    f31283d = new q();
                }
            }
        }
        return f31283d;
    }

    private void h() {
        String j10 = j();
        if (!TextUtils.isEmpty(j10)) {
            if (!TextUtils.isEmpty(CompanionSetting.getArtyJsonWebToken())) {
                ad.a.f168a.k();
                return;
            }
            String s10 = ta.a.s();
            final Application e10 = b.e();
            c.f29983b.g().a(j10, s10, "health_cardiex").p(new yp.b() { // from class: nj.m
                @Override // yp.b
                public final void call(Object obj) {
                    q.this.u((yh.b) obj);
                }
            }).Z(cq.a.c()).H(xp.a.b()).Y(new yp.b() { // from class: nj.l
                @Override // yp.b
                public final void call(Object obj) {
                    q.v(e10, (yh.b) obj);
                }
            }, p.f31281a);
        }
    }

    public static String i(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.contains("TicWatch GTH Pro")) {
            return "TicWatch GTH Pro";
        }
        if (str.contains(TicwatchModels.TICWATCH_GTH)) {
            return TicwatchModels.TICWATCH_GTH;
        }
        if (str.contains(TicwatchModels.TICWATCH_GTX)) {
            return TicwatchModels.TICWATCH_GTX;
        }
        if (str.contains("TicWatch GTA")) {
            return "TicWatch GTA";
        }
        if (str.contains("TicWatch GTW")) {
            return "TicWatch GTW";
        }
        if (str.contains("Mobvoi GTK")) {
            return "Mobvoi GTK";
        }
        if (str.contains("TicWatch GTK")) {
            return "TicWatch GTK";
        }
        return null;
    }

    private String j() {
        f a10 = mi.a.a();
        if (a10 != null) {
            return a10.a();
        }
        return null;
    }

    private String k() {
        f a10 = mi.a.a();
        if (a10 != null) {
            return a10.b();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(yh.b bVar) {
        if (bVar != null && bVar.err_code == 0) {
            CompanionSetting.setArtyJsonWebToken(bVar.jwt);
            ad.a.f168a.k();
            z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v(Context context, yh.b bVar) {
        if (bVar == null) {
            k.d(f31282c, " getJsonWebToken err");
        } else if (bVar.err_code == 306) {
            Toast.makeText(context, context.getString(sh.k.L), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w(Throwable th2) {
        String str = f31282c;
        k.d(str, " getJsonWebToken throwable = " + th2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x(sa.b bVar) {
        if (bVar.errorCode == 0) {
            CompanionSetting.setArtyAuthorizeStatus(bVar.authorize);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void y(Throwable th2) {
        k.e(f31282c, " syncArtyAuthStatus throwable = ", th2);
    }

    private void z() {
        String b10 = ii.a.b();
        if (!TextUtils.isEmpty(b10)) {
            String e10 = e.e(b.e());
            String str = Build.DEVICE;
            ad.a.f168a.o(new AddPushRegistration(str, b10, e10, "Android " + Build.VERSION.RELEASE, PushRegistrationKind.FCM));
        }
    }

    public void A(boolean z10) {
        this.f31285b = z10;
    }

    public void B(int i10) {
        this.f31284a = i10;
    }

    public boolean f() {
        return this.f31285b;
    }

    public int l() {
        String k10 = k();
        if (TextUtils.isEmpty(k10)) {
            return -1;
        }
        if (k10.contains("TicWatch GTH Pro")) {
            return 3;
        }
        if (k10.contains(TicwatchModels.TICWATCH_GTH)) {
            return 2;
        }
        if (k10.contains(TicwatchModels.TICWATCH_GTX)) {
            return 1;
        }
        if (k10.contains("TicWatch GTA")) {
            return 4;
        }
        if (k10.contains("Mobvoi GTK")) {
            return 7;
        }
        if (k10.contains("TicWatch GTK")) {
            return 6;
        }
        return k10.contains("TicWatch GTW") ? 5 : -1;
    }

    public int m() {
        return this.f31284a;
    }

    public void n() {
        h();
        if (!CompanionSetting.isArtyEnable()) {
            CompanionSetting.setArtyEnable(true);
        }
        C();
    }

    public boolean o() {
        return l() == 5;
    }

    public boolean p(int i10) {
        return l() == i10;
    }

    public boolean q(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.contains(TicwatchModels.TICWATCH_GTX) || str.contains("TicWatch GTH Pro") || str.contains(TicwatchModels.TICWATCH_GTH) || str.contains("TicWatch GTA") || str.contains("TicWatch GTW") || str.contains("Mobvoi GTK") || str.contains("TicWatch GTK");
        }
        return false;
    }

    public boolean r() {
        int l10 = l();
        return l10 == 1 || l10 == 4 || l10 == 6 || l10 == 7;
    }

    public boolean s() {
        int l10 = l();
        return l10 == 2 || l10 == 3;
    }

    public boolean t() {
        return q(k());
    }
}
