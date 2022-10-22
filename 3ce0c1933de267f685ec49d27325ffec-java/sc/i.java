package sc;

import cq.a;
import rx.c;
import tc.e;
import tc.f;
/* compiled from: SportMedalApiHelper.kt */
/* loaded from: classes2.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private final h f34377a;

    public i(h sportMedalApi) {
        kotlin.jvm.internal.i.f(sportMedalApi, "sportMedalApi");
        this.f34377a = sportMedalApi;
    }

    public final c<f> a(String str) {
        c<f> H = this.f34377a.a(str).Z(a.c()).H(xp.a.b());
        kotlin.jvm.internal.i.e(H, "sportMedalApi.getCurrentWeekSportMedal(sessionId)\n            .subscribeOn(Schedulers.io())\n            .observeOn(AndroidSchedulers.mainThread())");
        return H;
    }

    public final c<e> b(String str, String str2, String str3) {
        c<e> H = this.f34377a.b(str, str2, str3).Z(a.c()).H(xp.a.b());
        kotlin.jvm.internal.i.e(H, "sportMedalApi.getWeekOfMonthSportMedal(sessionId, startMonth, endMonth)\n            .subscribeOn(Schedulers.io())\n            .observeOn(AndroidSchedulers.mainThread())");
        return H;
    }
}
