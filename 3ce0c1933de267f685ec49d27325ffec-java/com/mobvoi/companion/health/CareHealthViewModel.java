package com.mobvoi.companion.health;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.lifecycle.w;
import com.google.gson.e;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.health.common.data.pojo.DataType;
import com.mobvoi.sleep.data.pojo.SleepRecord;
import ef.u;
import io.m;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.collections.q;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.t;
import rx.c;
import tc.g;
import tc.h;
import tc.n;
import xc.d;
import xc.j;
/* compiled from: CareHealthViewModel.kt */
/* loaded from: classes2.dex */
public final class CareHealthViewModel extends androidx.lifecycle.b {

    /* renamed from: a  reason: collision with root package name */
    private final dq.b f16694a = new dq.b();

    /* renamed from: b  reason: collision with root package name */
    private final w<Map<String, xc.b<?>>> f16695b = new w<>();

    /* renamed from: c  reason: collision with root package name */
    private w<g> f16696c = new w<>();

    /* renamed from: d  reason: collision with root package name */
    public sc.b f16697d;

    /* compiled from: CareHealthViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: CareHealthViewModel.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f16698a;

        static {
            int[] iArr = new int[DataType.values().length];
            iArr[DataType.GoalTodayStep.ordinal()] = 1;
            iArr[DataType.GoalTodayExercise.ordinal()] = 2;
            iArr[DataType.GoalTodayActive.ordinal()] = 3;
            f16698a = iArr;
        }
    }

    /* compiled from: CareHealthViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class c extends com.google.gson.reflect.a<ArrayList<n>> {
        c() {
        }
    }

    static {
        new a(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CareHealthViewModel(Application application) {
        super(application);
        i.f(application, "application");
    }

    private final rx.c<h> C() {
        return B().c().Z(cq.a.c()).p(new yp.b() { // from class: com.mobvoi.companion.health.c0
            @Override // yp.b
            public final void call(Object obj) {
                CareHealthViewModel.D(CareHealthViewModel.this, (h) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(CareHealthViewModel this$0, h hVar) {
        i.f(this$0, "this$0");
        if (hVar == null || !hVar.a() || hVar.b() == null) {
            k.d("MainViewModel", "fetchHomeMedalInfo failed");
            return;
        }
        this$0.F().m(hVar.b());
        this$0.G().edit().putString(this$0.m("vpa_medal_info_result"), new e().s(hVar.b())).apply();
    }

    private final int E(DataType dataType, long j10, long j11) {
        qf.a E = ig.b.J().z().j(null, dataType, j10, j11);
        if (E != null) {
            return (int) E.e();
        }
        int i10 = b.f16698a[dataType.ordinal()];
        if (i10 == 1) {
            return 10000;
        }
        if (i10 != 2) {
            return i10 != 3 ? -1 : 10;
        }
        return 30;
    }

    private final SharedPreferences G() {
        return w().getSharedPreferences("vpa_health_care_cards", 0);
    }

    private final rx.c<m> H() {
        rx.c<m> Z = rx.c.x(b0.f16816a).Z(cq.a.c());
        i.e(Z, "fromCallable {\n            HealthRemoteDataSyncer().startSync()\n        }.subscribeOn(Schedulers.io())");
        return Z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final m I() {
        new m1().e();
        return m.f28349a;
    }

    private final Map<Integer, xf.a> L(long j10, long j11) {
        List<qf.a> h10 = ig.b.J().z().h(DataType.BodyAndMindState, j10, j11);
        i.e(h10, "getInstance().pointAccessor().queryDataList(\n            DataType.BodyAndMindState,\n            start,\n            end\n        )");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!h10.isEmpty()) {
            q.r(h10, x.f17150a);
            for (qf.a aVar : h10) {
                float[] f10 = aVar.f();
                int i10 = (int) f10[0];
                int i11 = (int) f10[1];
                if (!linkedHashMap.containsKey(Integer.valueOf(i10))) {
                    linkedHashMap.put(Integer.valueOf(i10), new xf.a(i10, i11, aVar.f33129e));
                }
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int M(qf.a o12, qf.a o22) {
        i.f(o12, "o1");
        i.f(o22, "o2");
        long j10 = o12.f33129e;
        long j11 = o22.f33129e;
        if (j10 < j11) {
            return 1;
        }
        return j10 > j11 ? -1 : 0;
    }

    private final List<qf.a> N(DataType dataType, long j10, long j11) {
        List<qf.a> h10 = ig.b.J().z().h(dataType, j10, j11);
        i.e(h10, "getInstance().pointAccessor().queryDataList(dataType, start, end)");
        return h10;
    }

    private final List<rh.b> O(long j10, long j11) {
        List<rh.b> a10 = ig.b.J().I().a(j10, j11);
        i.e(a10, "getInstance().heartAccessor.getHeartRates(start, end)");
        return a10;
    }

    private final Collection<SleepRecord> P(long j10, long j11) {
        Collection<SleepRecord> b10 = ig.b.J().K().b(j10, j11, 0);
        i.e(b10, "getInstance().sleepAccessor.querySleepRecords(\n            start,\n            end,\n            SleepRecordType.NORMAL\n        )");
        return b10;
    }

    private final String m(String str) {
        return str + '_' + ((Object) com.mobvoi.health.companion.system.c.a().s(com.mobvoi.android.common.utils.b.e()));
    }

    private final yp.g<List<tc.i>, LinkedHashMap<String, xc.b<?>>> n() {
        return new yp.g() { // from class: com.mobvoi.companion.health.z
            @Override // yp.g
            public final Object call(Object obj) {
                LinkedHashMap o10;
                o10 = CareHealthViewModel.o(CareHealthViewModel.this, (List) obj);
                return o10;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final LinkedHashMap o(CareHealthViewModel this$0, List list) {
        long j10;
        boolean z10;
        long j11;
        long j12;
        boolean z11;
        long j13;
        long j14;
        boolean z12;
        boolean z13;
        boolean z14;
        long j15;
        long j16;
        long j17;
        boolean z15;
        int i10;
        String str;
        Iterator it;
        ArrayList arrayList;
        long j18;
        boolean z16;
        boolean z17;
        boolean I;
        i.f(this$0, "this$0");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (list != null) {
            long currentTimeMillis = System.currentTimeMillis();
            long b10 = eg.c.b(currentTimeMillis);
            long millis = b10 + TimeUnit.DAYS.toMillis(1L);
            Iterator it2 = list.iterator();
            boolean z18 = false;
            while (it2.hasNext()) {
                tc.i iVar = (tc.i) it2.next();
                String b11 = iVar.b();
                if (b11 != null) {
                    switch (b11.hashCode()) {
                        case -1905428213:
                            z11 = z18;
                            j13 = b10;
                            int i11 = 0;
                            j10 = millis;
                            if (b11.equals("CARD_NOISE")) {
                                j11 = j13;
                                z10 = z11;
                                List<qf.a> N = this$0.N(DataType.NOISE_DECIBEL, j13, j10);
                                Integer a10 = iVar.a();
                                if (a10 != null) {
                                    i11 = a10.intValue();
                                }
                                linkedHashMap.put("CARD_NOISE", new d(N, i11));
                                break;
                            }
                            j11 = j13;
                            z10 = z11;
                            break;
                        case -1900904248:
                            z11 = z18;
                            j13 = b10;
                            int i12 = 0;
                            j10 = millis;
                            if (b11.equals("CARD_SLEEP")) {
                                Collection<SleepRecord> P = this$0.P(j13, j10);
                                Integer a11 = iVar.a();
                                if (a11 != null) {
                                    i12 = a11.intValue();
                                }
                                xc.m mVar = new xc.m(P, i12);
                                mVar.e(z11);
                                m mVar2 = m.f28349a;
                                linkedHashMap.put("CARD_SLEEP", mVar);
                            }
                            j11 = j13;
                            z10 = z11;
                            break;
                        case -1900775067:
                            z11 = z18;
                            j14 = millis;
                            j13 = b10;
                            int i13 = 0;
                            if (b11.equals("CARD_SPORT")) {
                                j10 = j14;
                                List<u> g10 = yg.f.X().p().g(new Date(j10), new Date(j13), -1);
                                Integer a12 = iVar.a();
                                if (a12 != null) {
                                    i13 = a12.intValue();
                                }
                                linkedHashMap.put("CARD_SPORT", new xc.n(g10, i13));
                                j11 = j13;
                                z10 = z11;
                                break;
                            }
                            j11 = j13;
                            z10 = z11;
                            j10 = j14;
                            break;
                        case -1831977688:
                            z11 = z18;
                            long j19 = b10;
                            int i14 = 0;
                            j10 = millis;
                            if (b11.equals("CARD_MCU_HEART_RATE")) {
                                j13 = j19;
                                j14 = j10;
                                com.mobvoi.health.companion.heartrate.ui.c j20 = com.mobvoi.health.companion.heartrate.ui.a.j(this$0.O(j13, j10), null, j13, j10, 1);
                                Integer a13 = iVar.a();
                                if (a13 != null) {
                                    i14 = a13.intValue();
                                }
                                linkedHashMap.put("CARD_MCU_HEART_RATE", new xc.i(j20, i14));
                                j11 = j13;
                                z10 = z11;
                                j10 = j14;
                                break;
                            } else {
                                z10 = z11;
                                j11 = j19;
                                break;
                            }
                        case -992367500:
                            z14 = z18;
                            j15 = b10;
                            z13 = true;
                            int i15 = 0;
                            j10 = millis;
                            if (!b11.equals("CARD_BLOOD_OXYGEN")) {
                                z10 = z14;
                                j11 = j15;
                                break;
                            } else {
                                List<qf.a> N2 = this$0.N(DataType.BloodOxygen, j15, j10);
                                Integer a14 = iVar.a();
                                if (a14 != null) {
                                    i15 = a14.intValue();
                                }
                                linkedHashMap.put("CARD_BLOOD_OXYGEN", new d(N2, i15));
                                xc.b bVar = (xc.b) linkedHashMap.get("CARD_SLEEP");
                                if (bVar != null) {
                                    if (bVar instanceof xc.m) {
                                        ((xc.m) bVar).e(true);
                                    }
                                    m mVar3 = m.f28349a;
                                }
                                z18 = true;
                                millis = j10;
                                b10 = j15;
                                continue;
                            }
                        case -589429229:
                            z12 = z18;
                            if (b11.equals("CARD_AW_HEART_RATE")) {
                                List<rh.b> O = this$0.O(b10, millis);
                                List h10 = ig.b.J().z().h(DataType.Motion, b10, millis);
                                i.e(h10, "getInstance().pointAccessor()\n                            .queryDataList(\n                                DataType.Motion, dayStartMillis, dayEndMills\n                            )");
                                z13 = true;
                                int i16 = 0;
                                z14 = z12;
                                long j21 = millis;
                                j15 = b10;
                                com.mobvoi.health.companion.heartrate.ui.c j22 = com.mobvoi.health.companion.heartrate.ui.a.j(O, com.mobvoi.health.companion.heartrate.ui.a.l(h10, b10, millis), b10, j21, 1);
                                Integer a15 = iVar.a();
                                if (a15 != null) {
                                    i16 = a15.intValue();
                                }
                                linkedHashMap.put("CARD_AW_HEART_RATE", new xc.i(j22, i16));
                                j10 = j21;
                                z10 = z14;
                                j11 = j15;
                                break;
                            }
                            j12 = millis;
                            z10 = z12;
                            j11 = b10;
                            j10 = j12;
                            break;
                        case -584960364:
                            z12 = z18;
                            if (b11.equals("CARD_PRESSURE")) {
                                List<qf.a> N3 = this$0.N(DataType.Pressure, b10, millis);
                                Integer a16 = iVar.a();
                                linkedHashMap.put("CARD_PRESSURE", new d(N3, a16 == null ? 0 : a16.intValue()));
                            }
                            j12 = millis;
                            z10 = z12;
                            j11 = b10;
                            j10 = j12;
                            break;
                        case -497902946:
                            z12 = z18;
                            if (b11.equals("CARD_MCU_ACTIVITY")) {
                                oh.b bVar2 = new oh.b(this$0.w(), ig.b.J());
                                bVar2.f(new pg.a());
                                bVar2.e(b10, millis);
                                bVar2.d(com.mobvoi.health.companion.system.c.a().s(com.mobvoi.android.common.utils.b.e()), com.mobvoi.health.companion.system.c.a().c(com.mobvoi.android.common.utils.b.e()));
                                m mVar4 = m.f28349a;
                                j jVar = new j(bVar2.b().get((int) TimeUnit.MILLISECONDS.toSeconds(b10)), eg.b.a(this$0.E(DataType.GoalTodayStep, 0L, System.currentTimeMillis()), 10000));
                                Integer a17 = iVar.a();
                                linkedHashMap.put("CARD_MCU_ACTIVITY", new xc.k(currentTimeMillis, jVar, a17 == null ? 0 : a17.intValue()));
                            }
                            j12 = millis;
                            z10 = z12;
                            j11 = b10;
                            j10 = j12;
                            break;
                        case -64494267:
                            z12 = z18;
                            j16 = currentTimeMillis;
                            if (b11.equals("CARD_TEMPERATION")) {
                                List<qf.a> N4 = this$0.N(DataType.Temperature, b10, millis);
                                Integer a18 = iVar.a();
                                linkedHashMap.put("CARD_TEMPERATION", new d(N4, a18 == null ? 0 : a18.intValue()));
                            }
                            currentTimeMillis = j16;
                            j12 = millis;
                            z10 = z12;
                            j11 = b10;
                            j10 = j12;
                            break;
                        case 218473033:
                            z12 = z18;
                            j17 = currentTimeMillis;
                            z15 = true;
                            if (b11.equals("CARD_AW_ACTIVITY")) {
                                oh.b bVar3 = new oh.b(this$0.w(), ig.b.J());
                                bVar3.f(new pg.a());
                                bVar3.e(b10, millis);
                                bVar3.d(com.mobvoi.health.companion.system.c.a().s(com.mobvoi.android.common.utils.b.e()), com.mobvoi.health.companion.system.c.a().c(com.mobvoi.android.common.utils.b.e()));
                                m mVar5 = m.f28349a;
                                long currentTimeMillis2 = System.currentTimeMillis();
                                xc.e eVar = new xc.e(bVar3.b().get((int) TimeUnit.MILLISECONDS.toSeconds(b10)), eg.b.a(this$0.E(DataType.GoalTodayStep, 0L, currentTimeMillis2), 10000), eg.b.a(this$0.E(DataType.GoalTodayExercise, 0L, currentTimeMillis2) / 60, 30), eg.b.a(this$0.E(DataType.GoalTodayActive, 0L, currentTimeMillis2), 10));
                                Integer a19 = iVar.a();
                                if (a19 == null) {
                                    j16 = j17;
                                    i10 = 0;
                                } else {
                                    i10 = a19.intValue();
                                    j16 = j17;
                                }
                                linkedHashMap.put("CARD_AW_ACTIVITY", new xc.f(j16, eVar, i10));
                                currentTimeMillis = j16;
                                j12 = millis;
                                z10 = z12;
                                j11 = b10;
                                j10 = j12;
                                break;
                            }
                            currentTimeMillis = j17;
                            z10 = z12;
                            j10 = millis;
                            j11 = b10;
                            break;
                        case 859642322:
                            z12 = z18;
                            j17 = currentTimeMillis;
                            z15 = true;
                            if (b11.equals("CARD_BODY_MIND_STATE")) {
                                Map<Integer, xf.a> L = this$0.L(b10, millis);
                                Integer a20 = iVar.a();
                                linkedHashMap.put("CARD_BODY_MIND_STATE", new xc.a(L, a20 == null ? 0 : a20.intValue()));
                            }
                            currentTimeMillis = j17;
                            z10 = z12;
                            j10 = millis;
                            j11 = b10;
                            break;
                        case 1750161800:
                            if (b11.equals("CARD_HEALTH_REPORT")) {
                                String string = this$0.G().getString(this$0.m("vpa_health_report_result"), null);
                                Type type = new c().getType();
                                i.e(type, "object : TypeToken<ArrayList<WatchBanners>>() {}.type");
                                Object k10 = new e().k(string, type);
                                i.e(k10, "Gson().fromJson(reportResultJson, listType)");
                                ArrayList arrayList2 = (ArrayList) k10;
                                Locale locale = this$0.w().getResources().getConfiguration().locale;
                                String language = locale.getLanguage();
                                i.e(language, "currLocal.language");
                                String lowerCase = language.toLowerCase();
                                i.e(lowerCase, "(this as java.lang.String).toLowerCase()");
                                if (i.b(lowerCase, "zh")) {
                                    String country = locale.getCountry();
                                    i.e(country, "currLocal.country");
                                    String upperCase = country.toUpperCase();
                                    i.e(upperCase, "(this as java.lang.String).toUpperCase()");
                                    if (!i.b(upperCase, "CN")) {
                                        str = "zh-TW";
                                        k.a("MainViewModel", i.n("getHealthReportInfoObservable: currLanguage is ", str));
                                        HashMap hashMap = new HashMap();
                                        it = arrayList2.iterator();
                                        while (it.hasNext()) {
                                            n nVar = (n) it.next();
                                            String c10 = nVar.c();
                                            it = it;
                                            if (c10 == null) {
                                                z16 = z18;
                                                j18 = currentTimeMillis;
                                                z17 = false;
                                            } else {
                                                z16 = z18;
                                                j18 = currentTimeMillis;
                                                I = kotlin.text.u.I(c10, "?", false, 2, null);
                                                z17 = I;
                                            }
                                            if (z17) {
                                                nVar.e(((Object) nVar.c()) + "&wwid=" + ((Object) ta.a.x()) + "&session=" + ((Object) ta.a.s()) + "&language=" + ((Object) locale.getLanguage()));
                                            } else {
                                                nVar.e(((Object) nVar.c()) + "?wwid=" + ((Object) ta.a.x()) + "&session=" + ((Object) ta.a.s()) + "&language=" + ((Object) locale.getLanguage()));
                                            }
                                            String d10 = nVar.d();
                                            String str2 = "";
                                            if (d10 == null) {
                                                d10 = str2;
                                            }
                                            ArrayList arrayList3 = (ArrayList) hashMap.get(d10);
                                            if (arrayList3 == null) {
                                                ArrayList arrayList4 = new ArrayList();
                                                arrayList4.add(nVar);
                                                String d11 = nVar.d();
                                                if (d11 != null) {
                                                    str2 = d11;
                                                }
                                                hashMap.put(str2, arrayList4);
                                            } else {
                                                arrayList3.add(nVar);
                                            }
                                            z18 = z16;
                                            currentTimeMillis = j18;
                                        }
                                        z12 = z18;
                                        j17 = currentTimeMillis;
                                        z15 = true;
                                        arrayList = (ArrayList) hashMap.get(str);
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                        }
                                        linkedHashMap.put("CARD_HEALTH_REPORT", new xc.g(arrayList));
                                        currentTimeMillis = j17;
                                        z10 = z12;
                                        j10 = millis;
                                        j11 = b10;
                                        break;
                                    }
                                }
                                str = locale.getLanguage();
                                k.a("MainViewModel", i.n("getHealthReportInfoObservable: currLanguage is ", str));
                                HashMap hashMap2 = new HashMap();
                                it = arrayList2.iterator();
                                while (it.hasNext()) {
                                }
                                z12 = z18;
                                j17 = currentTimeMillis;
                                z15 = true;
                                arrayList = (ArrayList) hashMap2.get(str);
                                if (arrayList == null) {
                                }
                                linkedHashMap.put("CARD_HEALTH_REPORT", new xc.g(arrayList));
                                currentTimeMillis = j17;
                                z10 = z12;
                                j10 = millis;
                                j11 = b10;
                            }
                            break;
                    }
                    z18 = z10;
                    b10 = j11;
                    millis = j10;
                }
                j12 = millis;
                z10 = z18;
                j11 = b10;
                j10 = j12;
                z18 = z10;
                b10 = j11;
                millis = j10;
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x004d, code lost:
        if ((!r5) == true) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final List q(String str, CareHealthViewModel this$0, SharedPreferences sharedPreferences) {
        List<tc.i> b10;
        boolean s10;
        i.f(this$0, "this$0");
        tc.j jVar = (tc.j) new e().j(str, tc.j.class);
        g gVar = (g) new e().j(this$0.G().getString(this$0.m("vpa_medal_info_result"), null), g.class);
        if (gVar != null) {
            this$0.F().m(gVar);
        }
        String string = sharedPreferences.getString(this$0.m("vpa_health_report_result"), null);
        boolean z10 = true;
        if (string != null) {
            s10 = t.s(string);
        }
        z10 = false;
        if (z10 && (b10 = jVar.b()) != null) {
            b10.add(0, new tc.i(2, "CARD_HEALTH_REPORT"));
        }
        return jVar.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(CareHealthViewModel this$0, LinkedHashMap linkedHashMap) {
        i.f(this$0, "this$0");
        this$0.A().m(linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(Throwable th2) {
        k.d("MainViewModel", th2.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(Throwable th2) {
        k.d("MainViewModel", th2.getMessage());
    }

    private final Context w() {
        return getApplication().getApplicationContext();
    }

    private final rx.c<LinkedHashMap<String, xc.b<?>>> x() {
        rx.c<LinkedHashMap<String, xc.b<?>>> p10 = B().e().Z(cq.a.c()).v(new yp.g() { // from class: com.mobvoi.companion.health.y
            @Override // yp.g
            public final Object call(Object obj) {
                c y10;
                y10 = CareHealthViewModel.y(CareHealthViewModel.this, (tc.j) obj);
                return y10;
            }
        }).D(n()).p(new yp.b() { // from class: com.mobvoi.companion.health.d0
            @Override // yp.b
            public final void call(Object obj) {
                CareHealthViewModel.z(CareHealthViewModel.this, (LinkedHashMap) obj);
            }
        });
        i.e(p10, "cardsObservable.doOnNext { result ->\n            healthData.postValue(result)\n        }");
        return p10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final rx.c y(CareHealthViewModel this$0, tc.j jVar) {
        List<tc.i> b10;
        i.f(this$0, "this$0");
        if (jVar != null && jVar.a()) {
            boolean z10 = false;
            if (jVar.b() != null && (!b10.isEmpty())) {
                z10 = true;
            }
            if (z10) {
                this$0.G().edit().putString(this$0.m("vpa_health_cards_result"), new e().s(jVar)).apply();
                return rx.c.A(jVar.b());
            }
        }
        return rx.c.t(new Throwable("queryHealthCardData failed"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(CareHealthViewModel this$0, LinkedHashMap linkedHashMap) {
        i.f(this$0, "this$0");
        this$0.A().m(linkedHashMap);
    }

    public final w<Map<String, xc.b<?>>> A() {
        return this.f16695b;
    }

    public final sc.b B() {
        sc.b bVar = this.f16697d;
        if (bVar != null) {
            return bVar;
        }
        i.u("healthDataApiHelper");
        throw null;
    }

    public final w<g> F() {
        return this.f16696c;
    }

    public final void J() {
        K(false);
    }

    public final void K(boolean z10) {
        p(z10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.f0
    public void onCleared() {
        super.onCleared();
        this.f16694a.b();
    }

    public final void p(boolean z10) {
        boolean s10;
        final SharedPreferences G = G();
        rx.c<m> H = H();
        final String string = G.getString(m("vpa_health_cards_result"), null);
        rx.c<h> C = C();
        boolean z11 = false;
        if (string != null) {
            s10 = t.s(string);
            if (!s10) {
                z11 = true;
            }
        }
        if (!z11 || z10) {
            this.f16694a.a(rx.c.e(H, x(), C).Y(h0.f16861a, f0.f16855a));
            return;
        }
        this.f16694a.a(rx.c.e(rx.c.x(new Callable() { // from class: com.mobvoi.companion.health.a0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List q5;
                q5 = CareHealthViewModel.q(string, this, G);
                return q5;
            }
        }).D(n()).p(new yp.b() { // from class: com.mobvoi.companion.health.e0
            @Override // yp.b
            public final void call(Object obj) {
                CareHealthViewModel.r(CareHealthViewModel.this, (LinkedHashMap) obj);
            }
        }), H, C).Y(i0.f16864a, g0.f16858a));
    }
}
