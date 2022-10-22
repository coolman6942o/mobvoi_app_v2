package com.mobvoi.companion.health;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import androidx.lifecycle.w;
import androidx.lifecycle.z;
import com.mobvoi.companion.setting.CompanionSetting;
import com.mobvoi.health.common.data.pojo.DataType;
import com.mobvoi.sleep.data.pojo.SleepRecord;
import com.mobvoi.wear.companion.setup.settings.SettingConstants;
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
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.collections.q;
import kotlin.jvm.internal.Lambda;
import kotlin.text.t;
import nf.h;
import nf.k;
import rx.c;
import tc.c;
import tc.g;
import tc.i;
import tc.n;
import xc.j;
import xc.l;
/* compiled from: MainViewModel.kt */
/* loaded from: classes2.dex */
public final class MainViewModel extends androidx.lifecycle.b {

    /* renamed from: b  reason: collision with root package name */
    private boolean f16760b;

    /* renamed from: l  reason: collision with root package name */
    public String f16770l;

    /* renamed from: m  reason: collision with root package name */
    public sc.b f16771m;

    /* renamed from: n  reason: collision with root package name */
    private final f f16772n;

    /* renamed from: o  reason: collision with root package name */
    private final HomeTabLifeCycleChecker f16773o;

    /* renamed from: a  reason: collision with root package name */
    private final dq.b f16759a = new dq.b();

    /* renamed from: c  reason: collision with root package name */
    private w<Boolean> f16761c = new w<>(Boolean.FALSE);

    /* renamed from: d  reason: collision with root package name */
    private final w<Map<String, xc.b<?>>> f16762d = new w<>();

    /* renamed from: e  reason: collision with root package name */
    private final w<i> f16763e = new w<>();

    /* renamed from: f  reason: collision with root package name */
    private w<g> f16764f = new w<>();

    /* renamed from: g  reason: collision with root package name */
    private final w<Boolean> f16765g = new w<>();

    /* renamed from: h  reason: collision with root package name */
    private final w<Boolean> f16766h = new w<>();

    /* renamed from: i  reason: collision with root package name */
    private final w<Boolean> f16767i = new w<>();

    /* renamed from: j  reason: collision with root package name */
    private final w<Boolean> f16768j = new w<>();

    /* renamed from: k  reason: collision with root package name */
    private final w<Boolean> f16769k = new w<>();

    /* renamed from: p  reason: collision with root package name */
    private final k<i> f16774p = new k() { // from class: com.mobvoi.companion.health.n2
        @Override // nf.k
        public final void i(h hVar, Object obj) {
            MainViewModel.B(MainViewModel.this, hVar, (i) obj);
        }
    };

    /* compiled from: MainViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: MainViewModel.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f16775a;

        static {
            int[] iArr = new int[DataType.values().length];
            iArr[DataType.GoalTodayStep.ordinal()] = 1;
            iArr[DataType.GoalTodayExercise.ordinal()] = 2;
            iArr[DataType.GoalTodayActive.ordinal()] = 3;
            f16775a = iArr;
        }
    }

    /* compiled from: MainViewModel.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements qo.a<m> {
        c() {
            super(0);
        }

        @Override // qo.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            MainViewModel.this.O().m(Boolean.TRUE);
        }
    }

    /* compiled from: MainViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class d extends com.google.gson.reflect.a<ArrayList<n>> {
        d() {
        }
    }

    /* compiled from: MainViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class e extends com.google.gson.reflect.a<ArrayList<n>> {
        e() {
        }
    }

    /* compiled from: MainViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class f extends BroadcastReceiver {
        f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            kotlin.jvm.internal.i.f(context, "context");
            kotlin.jvm.internal.i.f(intent, "intent");
            String action = intent.getAction();
            if (action != null) {
                int hashCode = action.hashCode();
                if (hashCode != -980823944) {
                    if (hashCode != -149952446) {
                        if (hashCode != 410804625 || !action.equals("action.LOGIN")) {
                            return;
                        }
                        if (MainViewModel.this.E()) {
                            MainViewModel.this.F(false);
                        } else {
                            MainViewModel.this.C0(false);
                        }
                    } else if (action.equals("action.LOGOUT")) {
                        MainViewModel.this.C0(false);
                    }
                } else if (action.equals("action.UPDATE_MCU_WATCH_DATA")) {
                    MainViewModel.this.f16760b = intent.getBooleanExtra("extra.SYNC_MCU_WATCH_FINISH", false);
                    MainViewModel.this.F(false);
                }
            }
        }
    }

    static {
        new a(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainViewModel(Application application) {
        super(application);
        kotlin.jvm.internal.i.f(application, "application");
        f fVar = new f();
        this.f16772n = fVar;
        HomeTabLifeCycleChecker homeTabLifeCycleChecker = new HomeTabLifeCycleChecker(new c());
        this.f16773o = homeTabLifeCycleChecker;
        b1.a b10 = b1.a.b(application.getApplicationContext());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action.LOGIN");
        intentFilter.addAction("action.LOGOUT");
        intentFilter.addAction("action.UPDATE_MCU_WATCH_DATA");
        m mVar = m.f28349a;
        b10.c(fVar, intentFilter);
        z.h().getLifecycle().a(homeTabLifeCycleChecker);
        z();
    }

    private final String A(String str) {
        return str + '_' + ((Object) ta.a.x());
    }

    private final List<rh.b> A0(long j10, long j11) {
        List<rh.b> a10 = ig.b.J().I().a(j10, j11);
        kotlin.jvm.internal.i.e(a10, "getInstance().heartAccessor.getHeartRates(start, end)");
        return a10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(MainViewModel this$0, h hVar, i iVar) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.T().m(iVar);
    }

    private final Collection<SleepRecord> B0(long j10, long j11) {
        Collection<SleepRecord> b10 = ig.b.J().K().b(j10, j11, 0);
        kotlin.jvm.internal.i.e(b10, "getInstance().sleepAccessor.querySleepRecords(\n            start,\n            end,\n            SleepRecordType.NORMAL\n        )");
        return b10;
    }

    private final yp.g<List<i>, LinkedHashMap<String, xc.b<?>>> C() {
        return new yp.g() { // from class: com.mobvoi.companion.health.e2
            @Override // yp.g
            public final Object call(Object obj) {
                LinkedHashMap D;
                D = MainViewModel.D(MainViewModel.this, (List) obj);
                return D;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C0(boolean z10) {
        if (!kotlin.jvm.internal.i.b(this.f16761c.f(), Boolean.valueOf(z10))) {
            this.f16761c.m(Boolean.valueOf(z10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LinkedHashMap D(MainViewModel mainViewModel, List list) {
        boolean z10;
        long j10;
        long j11;
        MainViewModel mainViewModel2;
        boolean z11;
        long j12;
        boolean z12;
        long j13;
        boolean z13;
        long j14;
        int size;
        boolean z14;
        MainViewModel this$0 = mainViewModel;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (list != null) {
            boolean z15 = true;
            if (!list.isEmpty()) {
                long currentTimeMillis = System.currentTimeMillis();
                long b10 = eg.c.b(currentTimeMillis);
                long millis = b10 + TimeUnit.DAYS.toMillis(1L);
                Iterator it = list.iterator();
                boolean z16 = false;
                while (it.hasNext()) {
                    i iVar = (i) it.next();
                    String b11 = iVar.b();
                    if (b11 != null) {
                        switch (b11.hashCode()) {
                            case -1905428213:
                                j12 = millis;
                                j11 = b10;
                                z12 = z16;
                                z11 = z15;
                                mainViewModel2 = this$0;
                                if (b11.equals("CARD_NOISE")) {
                                    j10 = j12;
                                    z10 = z12;
                                    List<qf.a> z02 = mainViewModel.z0(DataType.NOISE_DECIBEL, j11, j10);
                                    Integer a10 = iVar.a();
                                    linkedHashMap.put("CARD_NOISE", new xc.d(z02, a10 == null ? 0 : a10.intValue()));
                                    break;
                                }
                                j10 = j12;
                                z10 = z12;
                                break;
                            case -1900904248:
                                z12 = z16;
                                j12 = millis;
                                j11 = b10;
                                z11 = z15;
                                mainViewModel2 = this$0;
                                if (b11.equals("CARD_SLEEP")) {
                                    Collection<SleepRecord> B0 = mainViewModel2.B0(j11, j12);
                                    Integer a11 = iVar.a();
                                    xc.m mVar = new xc.m(B0, a11 == null ? 0 : a11.intValue());
                                    mVar.e(z12);
                                    m mVar2 = m.f28349a;
                                    linkedHashMap.put("CARD_SLEEP", mVar);
                                }
                                j10 = j12;
                                z10 = z12;
                                break;
                            case -1900775067:
                                j12 = millis;
                                j13 = b10;
                                z12 = z16;
                                z11 = z15;
                                mainViewModel2 = this$0;
                                if (b11.equals("CARD_SPORT")) {
                                    j11 = j13;
                                    List<u> g10 = yg.f.X().p().g(new Date(j12), new Date(j11), -1);
                                    Integer a12 = iVar.a();
                                    linkedHashMap.put("CARD_SPORT", new xc.n(g10, a12 == null ? 0 : a12.intValue()));
                                    j10 = j12;
                                    z10 = z12;
                                    break;
                                }
                                j10 = j12;
                                z10 = z12;
                                j11 = j13;
                                break;
                            case -1831977688:
                                z12 = z16;
                                z11 = z15;
                                mainViewModel2 = this$0;
                                if (b11.equals("CARD_MCU_HEART_RATE")) {
                                    j12 = millis;
                                    j13 = b10;
                                    com.mobvoi.health.companion.heartrate.ui.c j15 = com.mobvoi.health.companion.heartrate.ui.a.j(mainViewModel2.A0(b10, millis), null, b10, j12, 1);
                                    Integer a13 = iVar.a();
                                    linkedHashMap.put("CARD_MCU_HEART_RATE", new xc.i(j15, a13 == null ? 0 : a13.intValue()));
                                    j10 = j12;
                                    z10 = z12;
                                    j11 = j13;
                                    break;
                                } else {
                                    z10 = z12;
                                    j10 = millis;
                                    j11 = b10;
                                    break;
                                }
                            case -992367500:
                                mainViewModel2 = this$0;
                                z10 = z16;
                                if (!b11.equals("CARD_BLOOD_OXYGEN")) {
                                    z11 = true;
                                    j10 = millis;
                                    j11 = b10;
                                    break;
                                } else {
                                    List<qf.a> z03 = mainViewModel.z0(DataType.BloodOxygen, b10, millis);
                                    Integer a14 = iVar.a();
                                    linkedHashMap.put("CARD_BLOOD_OXYGEN", new xc.d(z03, a14 == null ? 0 : a14.intValue()));
                                    xc.b bVar = (xc.b) linkedHashMap.get("CARD_SLEEP");
                                    if (bVar == null) {
                                        z14 = true;
                                    } else {
                                        if (bVar instanceof xc.m) {
                                            z14 = true;
                                            ((xc.m) bVar).e(true);
                                        } else {
                                            z14 = true;
                                        }
                                        m mVar3 = m.f28349a;
                                    }
                                    z16 = z14;
                                    this$0 = mainViewModel2;
                                    z15 = z16;
                                    continue;
                                }
                            case -673803282:
                                mainViewModel2 = this$0;
                                j10 = millis;
                                z10 = z16;
                                if (b11.equals("CARD_ARRHYTHMIA")) {
                                    xc.b<?> c10 = iVar.c();
                                    Objects.requireNonNull(c10, "null cannot be cast to non-null type com.mobvoi.companion.health.viewholder.data.HeartHealthCardData");
                                    linkedHashMap.put("CARD_ARRHYTHMIA", (xc.h) c10);
                                }
                                j11 = b10;
                                z11 = true;
                                break;
                            case -589429229:
                                z13 = z16;
                                if (b11.equals("CARD_AW_HEART_RATE")) {
                                    mainViewModel2 = mainViewModel;
                                    List<rh.b> A0 = mainViewModel2.A0(b10, millis);
                                    List h10 = ig.b.J().z().h(DataType.Motion, b10, millis);
                                    kotlin.jvm.internal.i.e(h10, "getInstance().pointAccessor()\n                            .queryDataList(\n                                DataType.Motion, dayStartMillis, dayEndMills\n                            )");
                                    long j16 = millis;
                                    j11 = b10;
                                    com.mobvoi.health.companion.heartrate.ui.c j17 = com.mobvoi.health.companion.heartrate.ui.a.j(A0, com.mobvoi.health.companion.heartrate.ui.a.l(h10, b10, millis), b10, j16, 1);
                                    Integer a15 = iVar.a();
                                    linkedHashMap.put("CARD_AW_HEART_RATE", new xc.i(j17, a15 == null ? 0 : a15.intValue()));
                                    j10 = j16;
                                    z10 = z13;
                                    z11 = true;
                                    break;
                                }
                                mainViewModel2 = mainViewModel;
                                z10 = z13;
                                z11 = true;
                                j10 = millis;
                                j11 = b10;
                                break;
                            case -584960364:
                                z13 = z16;
                                if (b11.equals("CARD_PRESSURE")) {
                                    List<qf.a> z04 = mainViewModel.z0(DataType.Pressure, b10, millis);
                                    Integer a16 = iVar.a();
                                    linkedHashMap.put("CARD_PRESSURE", new xc.d(z04, a16 == null ? 0 : a16.intValue()));
                                }
                                mainViewModel2 = mainViewModel;
                                z10 = z13;
                                z11 = true;
                                j10 = millis;
                                j11 = b10;
                                break;
                            case -497902946:
                                j14 = millis;
                                z13 = z16;
                                if (b11.equals("CARD_MCU_ACTIVITY")) {
                                    oh.b bVar2 = new oh.b(mainViewModel.V(), ig.b.J());
                                    bVar2.f(new pg.a());
                                    millis = j14;
                                    bVar2.e(b10, millis);
                                    bVar2.d(ta.a.x(), null);
                                    m mVar4 = m.f28349a;
                                    j jVar = new j(bVar2.b().get((int) TimeUnit.MILLISECONDS.toSeconds(b10)), eg.b.a(mainViewModel.p0(DataType.GoalTodayStep, 0L, System.currentTimeMillis()), 10000));
                                    Integer a17 = iVar.a();
                                    linkedHashMap.put("CARD_MCU_ACTIVITY", new xc.k(currentTimeMillis, jVar, a17 == null ? 0 : a17.intValue()));
                                    mainViewModel2 = mainViewModel;
                                    z10 = z13;
                                    z11 = true;
                                    j10 = millis;
                                    j11 = b10;
                                    break;
                                }
                                mainViewModel2 = mainViewModel;
                                z10 = z13;
                                j11 = b10;
                                j10 = j14;
                                z11 = true;
                                break;
                            case -64494267:
                                j14 = millis;
                                z13 = z16;
                                if (b11.equals("CARD_TEMPERATION")) {
                                    List<qf.a> z05 = mainViewModel.z0(DataType.Temperature, b10, j14);
                                    if ((!z05.isEmpty()) && (size = z05.size() - 1) >= 0) {
                                        while (true) {
                                            int i10 = size - 1;
                                            if (z05.get(size).e() == 0.0f) {
                                                z05.remove(size);
                                            }
                                            if (i10 >= 0) {
                                                size = i10;
                                            }
                                        }
                                    }
                                    Integer a18 = iVar.a();
                                    linkedHashMap.put("CARD_TEMPERATION", new xc.d(z05, a18 == null ? 0 : a18.intValue()));
                                }
                                mainViewModel2 = mainViewModel;
                                z10 = z13;
                                j11 = b10;
                                j10 = j14;
                                z11 = true;
                                break;
                            case 218473033:
                                if (b11.equals("CARD_AW_ACTIVITY")) {
                                    oh.b bVar3 = new oh.b(mainViewModel.V(), ig.b.J());
                                    bVar3.f(new pg.a());
                                    bVar3.e(b10, millis);
                                    bVar3.d(ta.a.x(), null);
                                    m mVar5 = m.f28349a;
                                    long currentTimeMillis2 = System.currentTimeMillis();
                                    z13 = z16;
                                    j14 = millis;
                                    xc.e eVar = new xc.e(bVar3.b().get((int) TimeUnit.MILLISECONDS.toSeconds(b10)), eg.b.a(mainViewModel.p0(DataType.GoalTodayStep, 0L, currentTimeMillis2), 10000), eg.b.a(mainViewModel.p0(DataType.GoalTodayExercise, 0L, currentTimeMillis2) / 60, 30), eg.b.a(mainViewModel.p0(DataType.GoalTodayActive, 0L, currentTimeMillis2), 10));
                                    Integer a19 = iVar.a();
                                    linkedHashMap.put("CARD_AW_ACTIVITY", new xc.f(currentTimeMillis, eVar, a19 == null ? 0 : a19.intValue()));
                                    mainViewModel2 = mainViewModel;
                                    z10 = z13;
                                    j11 = b10;
                                    j10 = j14;
                                    z11 = true;
                                    break;
                                }
                                break;
                            case 859642322:
                                if (b11.equals("CARD_BODY_MIND_STATE")) {
                                    Map<Integer, xf.a> x02 = this$0.x0(b10, millis);
                                    Integer a20 = iVar.a();
                                    linkedHashMap.put("CARD_BODY_MIND_STATE", new xc.a(x02, a20 == null ? 0 : a20.intValue()));
                                    break;
                                }
                                break;
                            case 1155404857:
                                if (b11.equals("CARD_PREMATURE_BEAT")) {
                                    xc.b<?> c11 = iVar.c();
                                    Objects.requireNonNull(c11, "null cannot be cast to non-null type com.mobvoi.companion.health.viewholder.data.HeartHealthCardData");
                                    linkedHashMap.put("CARD_PREMATURE_BEAT", (xc.h) c11);
                                    break;
                                }
                                break;
                            case 1400199994:
                                if (b11.equals("CARD_ATRIAL_FIBRILLATION")) {
                                    xc.b<?> c12 = iVar.c();
                                    Objects.requireNonNull(c12, "null cannot be cast to non-null type com.mobvoi.companion.health.viewholder.data.HeartHealthCardData");
                                    linkedHashMap.put("CARD_ATRIAL_FIBRILLATION", (xc.h) c12);
                                    break;
                                }
                                break;
                            case 1750161800:
                                if (b11.equals("CARD_HEALTH_REPORT")) {
                                    String string = mainViewModel.r0().getString(this$0.A("vpa_health_report_result"), null);
                                    Type type = new d().getType();
                                    kotlin.jvm.internal.i.e(type, "object : TypeToken<ArrayList<WatchBanners>>() {}.type");
                                    Object k10 = new com.google.gson.e().k(string, type);
                                    kotlin.jvm.internal.i.e(k10, "Gson().fromJson(reportResultJson, listType)");
                                    HashMap hashMap = new HashMap();
                                    Iterator it2 = ((ArrayList) k10).iterator();
                                    while (it2.hasNext()) {
                                        n nVar = (n) it2.next();
                                        String d10 = nVar.d();
                                        if (d10 == null) {
                                            d10 = "";
                                        }
                                        ArrayList arrayList = (ArrayList) hashMap.get(d10);
                                        if (arrayList == null) {
                                            ArrayList arrayList2 = new ArrayList();
                                            arrayList2.add(nVar);
                                            String d11 = nVar.d();
                                            if (d11 == null) {
                                                d11 = "";
                                            }
                                            hashMap.put(d11, arrayList2);
                                        } else {
                                            arrayList.add(nVar);
                                        }
                                    }
                                    ArrayList arrayList3 = (ArrayList) hashMap.get(mainViewModel.o0());
                                    if (arrayList3 == null) {
                                        arrayList3 = new ArrayList();
                                    }
                                    linkedHashMap.put("CARD_HEALTH_REPORT", new xc.g(arrayList3));
                                    break;
                                }
                                break;
                            case 1800119406:
                                if (b11.equals("CARD_ARTY_REPORT")) {
                                    yc.c h11 = yc.i.f36981a.h();
                                    Integer a21 = iVar.a();
                                    linkedHashMap.put("CARD_ARTY_REPORT", new l(h11, a21 == null ? 0 : a21.intValue()));
                                    mainViewModel.S();
                                    break;
                                }
                                break;
                            case 1998042564:
                                if (b11.equals("CARD_HEART_24H_DETECT")) {
                                    linkedHashMap.put("CARD_HEART_24H_DETECT", new xc.d(null, 2));
                                    break;
                                }
                                break;
                        }
                        this$0 = mainViewModel2;
                        z15 = z11;
                        millis = j10;
                        z16 = z10;
                        b10 = j11;
                    }
                    z10 = z16;
                    z11 = z15;
                    mainViewModel2 = this$0;
                    j10 = millis;
                    j11 = b10;
                    this$0 = mainViewModel2;
                    z15 = z11;
                    millis = j10;
                    z16 = z10;
                    b10 = j11;
                }
            }
        }
        return linkedHashMap;
    }

    private final void D0() {
        ad.a.f168a.b().c(this.f16774p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean E() {
        Map<String, qk.a> e10 = qk.b.g().e();
        return e10 != null && (e10.isEmpty() ^ true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(MainViewModel this$0, Throwable th2) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        com.mobvoi.android.common.utils.k.d("MainViewModel", th2.getMessage());
        this$0.X().m(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0062, code lost:
        if ((!r2) == true) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final List I(String str, MainViewModel this$0, SharedPreferences sharedPreferences) {
        boolean s10;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        tc.j jVar = (tc.j) new com.google.gson.e().j(str, tc.j.class);
        List<i> b10 = jVar == null ? null : jVar.b();
        if (b10 == null) {
            b10 = new ArrayList<>();
        }
        g gVar = (g) new com.google.gson.e().j(this$0.r0().getString(this$0.A("vpa_medal_info_result"), null), g.class);
        if (gVar != null) {
            this$0.q0().m(gVar);
        }
        boolean z10 = true;
        this$0.C0(true);
        this$0.R(b10);
        String string = sharedPreferences.getString(this$0.A("vpa_health_report_result"), null);
        if (string != null) {
            s10 = t.s(string);
        }
        z10 = false;
        if (z10) {
            Type type = new e().getType();
            kotlin.jvm.internal.i.e(type, "object : TypeToken<ArrayList<WatchBanners>>() {}.type");
            Object k10 = new com.google.gson.e().k(string, type);
            kotlin.jvm.internal.i.e(k10, "Gson().fromJson(reportResultJson, listType)");
            Iterator it = ((ArrayList) k10).iterator();
            while (true) {
                if (it.hasNext()) {
                    if (kotlin.jvm.internal.i.b(((n) it.next()).d(), this$0.o0())) {
                        b10.add(0, new i(2, "CARD_HEALTH_REPORT"));
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return b10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LinkedHashMap J(LinkedHashMap linkedHashMap, LinkedHashMap linkedHashMap2) {
        linkedHashMap2.putAll(linkedHashMap);
        return linkedHashMap2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(MainViewModel this$0, LinkedHashMap linkedHashMap) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.e0().m(linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(MainViewModel this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (this$0.f16760b) {
            this$0.f16760b = false;
            this$0.u0().m(Boolean.TRUE);
            return;
        }
        this$0.U().m(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(MainViewModel this$0, Throwable th2) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        com.mobvoi.android.common.utils.k.d("MainViewModel", th2.getMessage());
        if (this$0.f16760b) {
            this$0.f16760b = false;
            this$0.u0().m(Boolean.FALSE);
            return;
        }
        this$0.X().m(Boolean.TRUE);
    }

    private final rx.c<LinkedHashMap<String, xc.b<?>>> P() {
        rx.c<LinkedHashMap<String, xc.b<?>>> D = rx.c.x(new Callable() { // from class: com.mobvoi.companion.health.i2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List Q;
                Q = MainViewModel.Q(MainViewModel.this);
                return Q;
            }
        }).Z(cq.a.c()).D(C());
        kotlin.jvm.internal.i.e(D, "fromCallable {\n            return@fromCallable getArtyReportCardList(mutableListOf())\n        }.subscribeOn(Schedulers.io())\n            .map(convertResponse())");
        return D;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List Q(MainViewModel this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        return this$0.R(new ArrayList());
    }

    private final List<i> R(List<i> list) {
        if (CompanionSetting.isArtyEnable()) {
            list.add(0, new i(2, "CARD_ARTY_REPORT"));
        }
        return list;
    }

    private final void S() {
        if (CompanionSetting.getArtyGuidePageShowFinished() && CompanionSetting.isArtyAuthorize()) {
            ad.a.f168a.a();
        }
    }

    private final Context V() {
        return getApplication().getApplicationContext();
    }

    private final rx.c<LinkedHashMap<String, xc.b<?>>> Z() {
        rx.c<LinkedHashMap<String, xc.b<?>>> p10 = rx.c.k0(f0().e().Z(cq.a.c()).v(new yp.g() { // from class: com.mobvoi.companion.health.c2
            @Override // yp.g
            public final Object call(Object obj) {
                c a02;
                a02 = MainViewModel.a0(MainViewModel.this, (tc.j) obj);
                return a02;
            }
        }).D(C()), P(), g0().D(new yp.g() { // from class: com.mobvoi.companion.health.d2
            @Override // yp.g
            public final Object call(Object obj) {
                LinkedHashMap b02;
                b02 = MainViewModel.b0(MainViewModel.this, (List) obj);
                return b02;
            }
        }), j0(), k2.f16873a).p(new yp.b() { // from class: com.mobvoi.companion.health.y1
            @Override // yp.b
            public final void call(Object obj) {
                MainViewModel.d0(MainViewModel.this, (LinkedHashMap) obj);
            }
        });
        kotlin.jvm.internal.i.e(p10, "zip(\n            cardsObservable,\n            artyCardObservable,\n            healthReportObservable,\n            heartHealthObservable,\n            Func4 { mapFirst, mapSecond, mapThird, mapFour ->\n                return@Func4 mapFour.apply {\n                    putAll(mapThird)\n                }.apply {\n                    putAll(mapSecond)\n                }.apply {\n                    putAll(mapFirst)\n                }\n            }).doOnNext { result ->\n            healthData.postValue(result)\n            fetchDataSuccessFlag.postValue(true)\n        }");
        return p10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final rx.c a0(MainViewModel this$0, tc.j jVar) {
        List<i> b10;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (jVar == null || !jVar.a()) {
            return rx.c.t(new Throwable("queryHealthCardData failed"));
        }
        boolean z10 = false;
        if (jVar.b() != null && (!b10.isEmpty())) {
            z10 = true;
        }
        com.mobvoi.android.common.utils.k.a("MainViewModel", kotlin.jvm.internal.i.n("getHomeTabCards() -- hasCardsData:", Boolean.valueOf(z10)));
        this$0.r0().edit().putString(this$0.A("vpa_health_cards_result"), z10 ? new com.google.gson.e().s(jVar) : "").apply();
        List<i> b11 = jVar.b();
        if (b11 == null) {
            b11 = new ArrayList<>();
        }
        return rx.c.A(b11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LinkedHashMap b0(MainViewModel this$0, List bannerList) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        kotlin.jvm.internal.i.e(bannerList, "bannerList");
        if (!bannerList.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            HashMap hashMap = new HashMap();
            Iterator it = bannerList.iterator();
            while (it.hasNext()) {
                n nVar = (n) it.next();
                String d10 = nVar.d();
                String str = "";
                if (d10 == null) {
                    d10 = str;
                }
                ArrayList arrayList2 = (ArrayList) hashMap.get(d10);
                if (arrayList2 == null) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(nVar);
                    String d11 = nVar.d();
                    if (d11 != null) {
                        str = d11;
                    }
                    hashMap.put(str, arrayList3);
                } else {
                    arrayList2.add(nVar);
                }
            }
            ArrayList arrayList4 = (ArrayList) hashMap.get(this$0.o0());
            if (arrayList4 != null) {
                arrayList.addAll(arrayList4);
            }
            this$0.r0().edit().putString(this$0.A("vpa_health_report_result"), new com.google.gson.e().s(bannerList)).apply();
            linkedHashMap.put("CARD_HEALTH_REPORT", new xc.g(arrayList));
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LinkedHashMap c0(LinkedHashMap linkedHashMap, LinkedHashMap linkedHashMap2, LinkedHashMap linkedHashMap3, LinkedHashMap linkedHashMap4) {
        linkedHashMap4.putAll(linkedHashMap3);
        linkedHashMap4.putAll(linkedHashMap2);
        linkedHashMap4.putAll(linkedHashMap);
        return linkedHashMap4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(MainViewModel this$0, LinkedHashMap linkedHashMap) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.e0().m(linkedHashMap);
        this$0.Y().m(Boolean.TRUE);
    }

    private final rx.c<List<n>> g0() {
        sc.b f02 = f0();
        String x10 = ta.a.x();
        String packageName = V().getPackageName();
        kotlin.jvm.internal.i.e(packageName, "getContext().packageName");
        String b10 = yd.b.b();
        kotlin.jvm.internal.i.e(b10, "getVersionCode()");
        rx.c<List<n>> N = f02.d(x10, packageName, b10, o0()).Z(cq.a.c()).v(f2.f16856a).N(g2.f16859a);
        kotlin.jvm.internal.i.e(N, "healthDataApiHelper.getHomeTabBannerInfo(\n            AccountPreferenceHelper.getWwid(),\n            getContext().packageName,\n            ApplicationUtil.getVersionCode(),\n            language\n        ).subscribeOn(Schedulers.io())\n            .flatMap(Func1 { resp ->\n                if (resp != null && resp.isOk() && (resp.watchBanners?.isNotEmpty() == true)) {\n                    return@Func1 Observable.just(resp.watchBanners ?: ArrayList())\n                } else {\n                    return@Func1 Observable.error(Throwable(\"Error happens when getHealthReportInfoObservable\"))\n                }\n            }).onErrorReturn {\n                return@onErrorReturn ArrayList<WatchBanners>()\n            }");
        return N;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final rx.c h0(tc.b bVar) {
        List<n> b10;
        if (bVar != null && bVar.a()) {
            boolean z10 = false;
            if (bVar.b() != null && (!b10.isEmpty())) {
                z10 = true;
            }
            if (z10) {
                List<n> b11 = bVar.b();
                if (b11 == null) {
                    b11 = new ArrayList<>();
                }
                return rx.c.A(b11);
            }
        }
        return rx.c.t(new Throwable("Error happens when getHealthReportInfoObservable"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List i0(Throwable th2) {
        return new ArrayList();
    }

    private final rx.c<LinkedHashMap<String, xc.b<?>>> j0() {
        rx.c<LinkedHashMap<String, xc.b<?>>> N = f0().b().Z(cq.a.c()).v(new yp.g() { // from class: com.mobvoi.companion.health.b2
            @Override // yp.g
            public final Object call(Object obj) {
                c k02;
                k02 = MainViewModel.k0(MainViewModel.this, (tc.c) obj);
                return k02;
            }
        }).D(C()).N(h2.f16862a);
        kotlin.jvm.internal.i.e(N, "healthDataApiHelper.getHeartHealthInfo()\n            .subscribeOn(Schedulers.io())\n            .flatMap(Func1 { resp ->\n                if (resp != null && resp.isOk() && resp.heartHealthMap != null && resp.heartHealthMap!!.isNotEmpty()) {\n                    if (resp.heartHealthMap!!.containsKey(\"heart_health\")) {\n                        //待添加的卡片列表\n                        val healthCardList = ArrayList<VPAHealthCard>()\n                        notifyDisplayTabValueChange(true)\n                        //心率预警信息\n                        val healthInfoList = resp.heartHealthMap!![\"heart_health\"]\n                        //24h心率监测开关值\n                        val is24HHeartMonitor =\n                            resp.switchType?.get(\"24h_heart_monitor\").equals(\"1\")\n                        //是否支持rri\n                        val showRRI = UserSettingHelper.getInstance().isShowRRIView(ApplicationUtils.getApplication())\n                        //无心率预警\n                        if (healthInfoList == null || healthInfoList.isEmpty()) {\n                            //24小时心率监测打开 显示心脏健康卡片\n                            if (is24HHeartMonitor && showRRI) {\n                                val card = VPAHealthCard(2, CARD_HEART_24H_DETECT)\n                                healthCardList.add(0, card)\n                            }\n                        } else {\n                            //是否是支持rri的国家\n                            if (showRRI) {\n                                //有心率预警\n                                healthInfoList.forEach { healthInfo ->\n                                    healthInfo.getValues()?.let {\n                                        if (it.size == 2) {\n                                            val type = it[0].toInt()\n                                            when (type) {\n                                                //房颤\n                                                TYPE_ATRIAL_FIBRILLATION -> {\n                                                    if (healthInfo.startTime != getPrefs().getLong(\n                                                            PREF_KEY_ATRIAL_FIBRILLATION,\n                                                            -1L\n                                                        )\n                                                    ) {\n                                                        //如果当前产生这条\n                                                        val card =\n                                                            VPAHealthCard(\n                                                                2,\n                                                                CARD_ATRIAL_FIBRILLATION\n                                                            )\n                                                        card.data = HeartHealthCardData(\n                                                            HeartHealth(\n                                                                type,\n                                                                healthInfo.startTime,\n                                                                it[1].toInt()\n                                                            ), 2\n                                                        )\n                                                        healthCardList.add(0, card)\n                                                    }\n                                                }\n                                                //心动过速、过缓\n                                                TYPE_TACHYCARDIA, TYPE_BRADYCARDIA -> {\n                                                    if (healthInfo.startTime != getPrefs().getLong(\n                                                            PREF_KEY_ARRHYTHMIA,\n                                                            -1L\n                                                        )\n                                                    ) {\n                                                        //如果当前产生这条\n                                                        val card = VPAHealthCard(2, CARD_ARRHYTHMIA)\n                                                        card.data = HeartHealthCardData(\n                                                            HeartHealth(\n                                                                type,\n                                                                healthInfo.startTime,\n                                                                it[1].toInt()\n                                                            ), 2\n                                                        )\n                                                        healthCardList.add(card)\n                                                    }\n                                                }\n                                                //早搏\n                                                TYPE_PREMATURE_BEAT -> {\n                                                    if (healthInfo.startTime != getPrefs().getLong(\n                                                            PREF_KEY_PREMATURE_BEAT,\n                                                            -1L\n                                                        )\n                                                    ) {\n                                                        //如果当前产生这条\n                                                        val card =\n                                                            VPAHealthCard(2, CARD_PREMATURE_BEAT)\n                                                        card.data = HeartHealthCardData(\n                                                            HeartHealth(\n                                                                type,\n                                                                healthInfo.startTime,\n                                                                it[1].toInt()\n                                                            ), 2\n                                                        )\n                                                        healthCardList.add(card)\n                                                    }\n                                                }\n                                            }\n                                        }\n                                    }\n                                }\n                            }\n                        }\n                        return@Func1 Observable.just(healthCardList)\n                    }\n                }\n                return@Func1 Observable.error(Throwable(\"query Heart health failed\"))\n            }).map(convertResponse())\n            .onErrorReturn {\n                return@onErrorReturn LinkedHashMap<String, CardData<*>>()\n            }");
        return N;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final rx.c k0(MainViewModel this$0, tc.c cVar) {
        boolean q5;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (!(cVar == null || !cVar.a() || cVar.b() == null)) {
            Map<String, List<c.a>> b10 = cVar.b();
            kotlin.jvm.internal.i.d(b10);
            if (!b10.isEmpty()) {
                Map<String, List<c.a>> b11 = cVar.b();
                kotlin.jvm.internal.i.d(b11);
                if (b11.containsKey("heart_health")) {
                    ArrayList arrayList = new ArrayList();
                    this$0.C0(true);
                    Map<String, List<c.a>> b12 = cVar.b();
                    kotlin.jvm.internal.i.d(b12);
                    List<c.a> list = b12.get("heart_health");
                    Map<String, String> c10 = cVar.c();
                    q5 = t.q(c10 == null ? null : c10.get("24h_heart_monitor"), "1", false, 2, null);
                    boolean i10 = of.h.b().i(com.mobvoi.android.common.utils.b.e());
                    if (list == null || list.isEmpty()) {
                        if (q5 && i10) {
                            arrayList.add(0, new i(2, "CARD_HEART_24H_DETECT"));
                        }
                    } else if (i10) {
                        for (c.a aVar : list) {
                            float[] b13 = aVar.b();
                            if (b13 != null && b13.length == 2) {
                                int i11 = (int) b13[0];
                                if (i11 != 1) {
                                    if (i11 == 2 || i11 == 3) {
                                        if (aVar.a() != this$0.r0().getLong("vpa_heart_arrhythmia", -1L)) {
                                            i iVar = new i(2, "CARD_ARRHYTHMIA");
                                            iVar.f(new xc.h(new rh.a(i11, aVar.a(), (int) b13[1]), 2));
                                            arrayList.add(iVar);
                                        }
                                    } else if (i11 == 4 && aVar.a() != this$0.r0().getLong("vpa_heart_health_premature_beat", -1L)) {
                                        i iVar2 = new i(2, "CARD_PREMATURE_BEAT");
                                        iVar2.f(new xc.h(new rh.a(i11, aVar.a(), (int) b13[1]), 2));
                                        arrayList.add(iVar2);
                                    }
                                } else if (aVar.a() != this$0.r0().getLong("vpa_heart_health_atrial_fibrillation", -1L)) {
                                    i iVar3 = new i(2, "CARD_ATRIAL_FIBRILLATION");
                                    iVar3.f(new xc.h(new rh.a(i11, aVar.a(), (int) b13[1]), 2));
                                    arrayList.add(0, iVar3);
                                }
                            }
                        }
                    }
                    return rx.c.A(arrayList);
                }
            }
        }
        return rx.c.t(new Throwable("query Heart health failed"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LinkedHashMap l0(Throwable th2) {
        return new LinkedHashMap();
    }

    private final rx.c<tc.h> m0() {
        return f0().c().Z(cq.a.c()).p(new yp.b() { // from class: com.mobvoi.companion.health.p2
            @Override // yp.b
            public final void call(Object obj) {
                MainViewModel.n0(MainViewModel.this, (tc.h) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(MainViewModel this$0, tc.h hVar) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (hVar == null || !hVar.a() || hVar.b() == null) {
            com.mobvoi.android.common.utils.k.d("MainViewModel", "fetchHomeMedalInfo failed");
            return;
        }
        this$0.q0().m(hVar.b());
        this$0.r0().edit().putString(this$0.A("vpa_medal_info_result"), new com.google.gson.e().s(hVar.b())).apply();
    }

    private final int p0(DataType dataType, long j10, long j11) {
        qf.a E = ig.b.J().z().j(null, dataType, j10, j11);
        if (E != null) {
            return (int) E.e();
        }
        int i10 = b.f16775a[dataType.ordinal()];
        if (i10 == 1) {
            return 10000;
        }
        if (i10 != 2) {
            return i10 != 3 ? -1 : 10;
        }
        return 30;
    }

    private final SharedPreferences r0() {
        return V().getSharedPreferences("vpa_health_cards", 0);
    }

    private final rx.c<m> s0() {
        rx.c<m> Z = rx.c.x(m2.f16885a).Z(cq.a.c());
        kotlin.jvm.internal.i.e(Z, "fromCallable {\n            HealthRemoteDataSyncer().startSync()\n        }.subscribeOn(Schedulers.io())");
        return Z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final m t0() {
        new m1().e();
        return m.f28349a;
    }

    private final Map<Integer, xf.a> x0(long j10, long j11) {
        List<qf.a> h10 = ig.b.J().z().h(DataType.BodyAndMindState, j10, j11);
        kotlin.jvm.internal.i.e(h10, "getInstance().pointAccessor().queryDataList(\n            DataType.BodyAndMindState,\n            start,\n            end\n        )");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!h10.isEmpty()) {
            q.r(h10, x1.f17152a);
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
    public static final int y0(qf.a o12, qf.a o22) {
        kotlin.jvm.internal.i.f(o12, "o1");
        kotlin.jvm.internal.i.f(o22, "o2");
        long j10 = o12.f33129e;
        long j11 = o22.f33129e;
        if (j10 < j11) {
            return 1;
        }
        return j10 > j11 ? -1 : 0;
    }

    private final void z() {
        ad.a.f168a.b().a(this.f16774p);
    }

    private final List<qf.a> z0(DataType dataType, long j10, long j11) {
        List<qf.a> h10 = ig.b.J().z().h(dataType, j10, j11);
        kotlin.jvm.internal.i.e(h10, "getInstance().pointAccessor().queryDataList(dataType, start, end)");
        return h10;
    }

    public final void F(boolean z10) {
        final SharedPreferences r02 = r0();
        rx.c<m> s02 = s0();
        final String string = r02.getString(A("vpa_health_cards_result"), null);
        rx.c<tc.h> m02 = m0();
        if (string == null || z10) {
            this.f16759a.a(rx.c.e(s02, Z(), m02).Y(a2.f16813a, new yp.b() { // from class: com.mobvoi.companion.health.q2
                @Override // yp.b
                public final void call(Object obj) {
                    MainViewModel.H(MainViewModel.this, (Throwable) obj);
                }
            }));
            return;
        }
        this.f16759a.a(rx.c.e(rx.c.l0(rx.c.x(new Callable() { // from class: com.mobvoi.companion.health.l2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List I;
                I = MainViewModel.I(string, this, r02);
                return I;
            }
        }).D(C()), j0(), j2.f16867a).p(new yp.b() { // from class: com.mobvoi.companion.health.s2
            @Override // yp.b
            public final void call(Object obj) {
                MainViewModel.K(MainViewModel.this, (LinkedHashMap) obj);
            }
        }), s02, m02).o(new yp.a() { // from class: com.mobvoi.companion.health.o2
            @Override // yp.a
            public final void call() {
                MainViewModel.L(MainViewModel.this);
            }
        }).Y(z1.f17163a, new yp.b() { // from class: com.mobvoi.companion.health.r2
            @Override // yp.b
            public final void call(Object obj) {
                MainViewModel.N(MainViewModel.this, (Throwable) obj);
            }
        }));
    }

    public final w<Boolean> O() {
        return this.f16765g;
    }

    public final w<i> T() {
        return this.f16763e;
    }

    public final w<Boolean> U() {
        return this.f16768j;
    }

    public final w<Boolean> W() {
        return this.f16761c;
    }

    public final w<Boolean> X() {
        return this.f16766h;
    }

    public final w<Boolean> Y() {
        return this.f16767i;
    }

    public final w<Map<String, xc.b<?>>> e0() {
        return this.f16762d;
    }

    public final sc.b f0() {
        sc.b bVar = this.f16771m;
        if (bVar != null) {
            return bVar;
        }
        kotlin.jvm.internal.i.u("healthDataApiHelper");
        throw null;
    }

    public final String o0() {
        String str = this.f16770l;
        if (str != null) {
            return str;
        }
        kotlin.jvm.internal.i.u(SettingConstants.LANGUAGE);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.f0
    public void onCleared() {
        super.onCleared();
        z.h().getLifecycle().c(this.f16773o);
        b1.a.b(V()).e(this.f16772n);
        this.f16759a.b();
        D0();
    }

    public final w<g> q0() {
        return this.f16764f;
    }

    public final w<Boolean> u0() {
        return this.f16769k;
    }

    public final void v0() {
        w0(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
        if ((!r0) == true) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void w0(boolean z10) {
        boolean z11;
        boolean s10;
        boolean s11;
        String x10 = ta.a.x();
        boolean z12 = true;
        if (x10 != null) {
            s11 = t.s(x10);
            if (!s11) {
                z11 = true;
                if (z11) {
                    String d10 = ta.a.d();
                    if (d10 != null) {
                        s10 = t.s(d10);
                    }
                    z12 = false;
                    if (z12 && E()) {
                        F(z10);
                        return;
                    }
                }
                C0(false);
            }
        }
        z11 = false;
        if (z11) {
        }
        C0(false);
    }
}
