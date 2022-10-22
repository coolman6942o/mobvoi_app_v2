package ad;

import android.app.Application;
import com.cardiex.arty.lite.Arty;
import com.cardiex.arty.lite.models.Pageable;
import com.cardiex.arty.lite.models.coach.Advice;
import com.cardiex.arty.lite.models.coach.Insight;
import com.cardiex.arty.lite.models.coach.InsightType;
import com.cardiex.arty.lite.models.push.AddPushRegistration;
import com.cardiex.arty.lite.models.push.PushRegistration;
import com.cardiex.arty.lite.models.social.Badge;
import com.cardiex.arty.lite.networking.ApiResultCallback;
import com.mobvoi.companion.setting.CompanionSetting;
import java.util.Date;
import nf.h;
import tc.i;
/* compiled from: ArtyRequestManager.kt */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    private static Arty f169b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f170c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f171d;

    /* renamed from: a  reason: collision with root package name */
    public static final a f168a = new a();

    /* renamed from: e  reason: collision with root package name */
    private static h<i> f172e = new nf.a();

    /* renamed from: f  reason: collision with root package name */
    private static final h<Insight[]> f173f = new nf.a();

    /* renamed from: g  reason: collision with root package name */
    private static final h<Boolean> f174g = new nf.a();

    /* renamed from: h  reason: collision with root package name */
    private static final h<Badge[]> f175h = new nf.a();

    /* renamed from: i  reason: collision with root package name */
    private static final h<Boolean> f176i = new nf.a();

    /* renamed from: j  reason: collision with root package name */
    private static final Pageable f177j = new Pageable(0, 10, "asc");

    /* compiled from: ArtyRequestManager.kt */
    /* renamed from: ad.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0002a implements ApiResultCallback<Advice[]> {
        C0002a() {
        }

        /* renamed from: a */
        public void onSuccess(Advice[] result) {
            kotlin.jvm.internal.i.f(result, "result");
            a aVar = a.f168a;
            aVar.p(false);
            i a10 = yc.i.f36981a.a(result);
            if (a10 != null) {
                aVar.b().f(a10);
            }
        }

        @Override // com.cardiex.arty.lite.networking.ApiResultCallback
        public void onError(Exception e10) {
            kotlin.jvm.internal.i.f(e10, "e");
            a.f168a.p(false);
            e10.printStackTrace();
        }
    }

    /* compiled from: ArtyRequestManager.kt */
    /* loaded from: classes2.dex */
    public static final class b implements ApiResultCallback<Badge[]> {
        b() {
        }

        /* renamed from: a */
        public void onSuccess(Badge[] result) {
            kotlin.jvm.internal.i.f(result, "result");
            a.f168a.d().f(result);
        }

        @Override // com.cardiex.arty.lite.networking.ApiResultCallback
        public void onError(Exception e10) {
            kotlin.jvm.internal.i.f(e10, "e");
            e10.printStackTrace();
            a.f168a.h().f(Boolean.TRUE);
        }
    }

    /* compiled from: ArtyRequestManager.kt */
    /* loaded from: classes2.dex */
    public static final class c implements ApiResultCallback<Insight[]> {
        c() {
        }

        /* renamed from: a */
        public void onSuccess(Insight[] result) {
            kotlin.jvm.internal.i.f(result, "result");
            int i10 = 0;
            if (!(result.length == 0)) {
                int length = result.length;
                while (i10 < length) {
                    Insight insight = result[i10];
                    i10++;
                    InsightType component2 = insight.component2();
                    Advice component3 = insight.component3();
                    if (component2 == InsightType.ADVICE && component3 != null) {
                        component3.isSeen();
                    }
                }
            }
            a.f168a.g().f(result);
        }

        @Override // com.cardiex.arty.lite.networking.ApiResultCallback
        public void onError(Exception e10) {
            kotlin.jvm.internal.i.f(e10, "e");
            e10.printStackTrace();
            a.f168a.i().f(Boolean.TRUE);
        }
    }

    /* compiled from: ArtyRequestManager.kt */
    /* loaded from: classes2.dex */
    public static final class d implements ApiResultCallback<Object> {
        d() {
        }

        @Override // com.cardiex.arty.lite.networking.ApiResultCallback
        public void onError(Exception e10) {
            kotlin.jvm.internal.i.f(e10, "e");
            e10.printStackTrace();
        }

        @Override // com.cardiex.arty.lite.networking.ApiResultCallback
        public void onSuccess(Object result) {
            kotlin.jvm.internal.i.f(result, "result");
        }
    }

    /* compiled from: ArtyRequestManager.kt */
    /* loaded from: classes2.dex */
    public static final class e implements ApiResultCallback<Object> {
        e() {
        }

        @Override // com.cardiex.arty.lite.networking.ApiResultCallback
        public void onError(Exception e10) {
            kotlin.jvm.internal.i.f(e10, "e");
            e10.printStackTrace();
        }

        @Override // com.cardiex.arty.lite.networking.ApiResultCallback
        public void onSuccess(Object result) {
            kotlin.jvm.internal.i.f(result, "result");
        }
    }

    /* compiled from: ArtyRequestManager.kt */
    /* loaded from: classes2.dex */
    public static final class f implements ApiResultCallback<Object> {
        f() {
        }

        @Override // com.cardiex.arty.lite.networking.ApiResultCallback
        public void onError(Exception e10) {
            kotlin.jvm.internal.i.f(e10, "e");
            e10.printStackTrace();
        }

        @Override // com.cardiex.arty.lite.networking.ApiResultCallback
        public void onSuccess(Object result) {
            kotlin.jvm.internal.i.f(result, "result");
        }
    }

    /* compiled from: ArtyRequestManager.kt */
    /* loaded from: classes2.dex */
    public static final class g implements ApiResultCallback<PushRegistration> {
        g() {
        }

        /* renamed from: a */
        public void onSuccess(PushRegistration result) {
            kotlin.jvm.internal.i.f(result, "result");
        }

        @Override // com.cardiex.arty.lite.networking.ApiResultCallback
        public void onError(Exception e10) {
            kotlin.jvm.internal.i.f(e10, "e");
            e10.printStackTrace();
        }
    }

    private a() {
    }

    public final void a() {
        if (!f170c) {
            f170c = true;
            Arty arty = f169b;
            if (arty != null) {
                arty.getAdvice(f177j, new C0002a());
            }
        }
    }

    public final h<i> b() {
        return f172e;
    }

    public final void c() {
        Arty arty = f169b;
        if (arty != null) {
            arty.getBadges(new b());
        }
    }

    public final h<Badge[]> d() {
        return f175h;
    }

    public final void e() {
        f(f177j, new Date(eg.c.a(System.currentTimeMillis()).getTimeInMillis()));
    }

    public final void f(Pageable pageable, Date date) {
        kotlin.jvm.internal.i.f(pageable, "pageable");
        kotlin.jvm.internal.i.f(date, "date");
        Arty arty = f169b;
        if (arty != null) {
            arty.getInsight(pageable, date, new c());
        }
    }

    public final h<Insight[]> g() {
        return f173f;
    }

    public final h<Boolean> h() {
        return f176i;
    }

    public final h<Boolean> i() {
        return f174g;
    }

    public final boolean j() {
        return f171d;
    }

    public final void k() {
        String artyJsonWebToken = CompanionSetting.getArtyJsonWebToken();
        if (!(artyJsonWebToken == null || artyJsonWebToken.length() == 0)) {
            Application e10 = com.mobvoi.android.common.utils.b.e();
            kotlin.jvm.internal.i.e(e10, "getApplication()");
            String artyJsonWebToken2 = CompanionSetting.getArtyJsonWebToken();
            kotlin.jvm.internal.i.e(artyJsonWebToken2, "getArtyJsonWebToken()");
            f169b = new Arty(e10, artyJsonWebToken2, false, 4, null);
        }
    }

    public final void l(String adviceId) {
        kotlin.jvm.internal.i.f(adviceId, "adviceId");
        Arty arty = f169b;
        if (arty != null) {
            arty.markAdviceSeen(adviceId, true, new d());
        }
    }

    public final void m(Date date) {
        kotlin.jvm.internal.i.f(date, "date");
        Arty arty = f169b;
        if (arty != null) {
            arty.markAdviceSeen(date, new e());
        }
    }

    public final void n(String id2) {
        kotlin.jvm.internal.i.f(id2, "id");
        Arty arty = f169b;
        if (arty != null) {
            arty.markBadgeSeen(id2, true, new f());
        }
    }

    public final void o(AddPushRegistration addPushRegistration) {
        kotlin.jvm.internal.i.f(addPushRegistration, "addPushRegistration");
        Arty arty = f169b;
        if (arty != null) {
            arty.addPushDevice(addPushRegistration, new g());
        }
    }

    public final void p(boolean z10) {
        f170c = z10;
    }

    public final void q(boolean z10) {
        f171d = z10;
    }
}
