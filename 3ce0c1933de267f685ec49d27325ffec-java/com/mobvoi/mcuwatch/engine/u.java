package com.mobvoi.mcuwatch.engine;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.mcuwatch.pair.service.RingingService;
import com.yc.pedometer.sdk.BluetoothLeService;
import en.h;
import en.j;
import en.q;
import gn.z;
import io.m;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.n;
import kotlin.text.t;
/* compiled from: UTEBleEngine.kt */
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes2.dex */
public final class u extends o implements j, en.d, en.f {

    /* renamed from: b  reason: collision with root package name */
    private static di.b f19203b;

    /* renamed from: c  reason: collision with root package name */
    private static di.a f19204c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f19205d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f19206e;

    /* renamed from: f  reason: collision with root package name */
    public static Context f19207f;

    /* renamed from: g  reason: collision with root package name */
    private static en.c f19208g;

    /* renamed from: h  reason: collision with root package name */
    private static com.yc.pedometer.sdk.a f19209h;

    /* renamed from: i  reason: collision with root package name */
    public static fn.a f19210i;

    /* renamed from: j  reason: collision with root package name */
    private static com.mobvoi.mcuwatch.engine.d f19211j;

    /* renamed from: k  reason: collision with root package name */
    private static p f19212k;

    /* renamed from: l  reason: collision with root package name */
    public static q f19213l;

    /* renamed from: m  reason: collision with root package name */
    public static fi.a f19214m;

    /* renamed from: n  reason: collision with root package name */
    public static WeakReference<m> f19215n;

    /* renamed from: p  reason: collision with root package name */
    private static SharedPreferences f19217p;

    /* renamed from: q  reason: collision with root package name */
    private static rx.subjects.b<String> f19218q;

    /* renamed from: r  reason: collision with root package name */
    private static final io.d f19219r;

    /* renamed from: s  reason: collision with root package name */
    private static final io.d f19220s;

    /* renamed from: w  reason: collision with root package name */
    private static final io.d f19224w;

    /* renamed from: a  reason: collision with root package name */
    public static final u f19202a = new u();

    /* renamed from: o  reason: collision with root package name */
    private static final Map<String, String> f19216o = new LinkedHashMap();

    /* renamed from: t  reason: collision with root package name */
    private static final f f19221t = new f();

    /* renamed from: u  reason: collision with root package name */
    private static final d f19222u = new d();

    /* renamed from: v  reason: collision with root package name */
    private static final h f19223v = t.f19201a;

    /* renamed from: x  reason: collision with root package name */
    private static final BroadcastReceiver f19225x = new e();

    /* compiled from: UTEBleEngine.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements qo.a<String[]> {
        public static final a INSTANCE = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final String[] invoke() {
            return u.f19202a.F().getResources().getStringArray(sh.b.f34437w);
        }
    }

    /* compiled from: UTEBleEngine.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements qo.a<String[]> {
        public static final b INSTANCE = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final String[] invoke() {
            return u.f19202a.F().getResources().getStringArray(sh.b.f34438x);
        }
    }

    /* compiled from: UTEBleEngine.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements qo.a<a> {
        public static final c INSTANCE = new c();

        /* compiled from: UTEBleEngine.kt */
        @SuppressLint({"HandlerLeak"})
        /* loaded from: classes2.dex */
        public static final class a extends Handler {
            a(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                i.f(msg, "msg");
                k.a("UTE_OTA", i.n("handleMessage ", Integer.valueOf(msg.what)));
                int i10 = msg.what;
                if (i10 == 1) {
                    u uVar = u.f19202a;
                    uVar.G().removeCallbacks(u.f19221t);
                    uVar.X();
                    uVar.W();
                } else if (i10 == 2) {
                    u.f19202a.w();
                    s.f19186a.p(100);
                } else if (i10 != 200) {
                    switch (i10) {
                        case 100:
                            u uVar2 = u.f19202a;
                            Object obj = msg.obj;
                            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                            u.f19205d = ((Boolean) obj).booleanValue();
                            com.mobvoi.mcuwatch.engine.d C = uVar2.C();
                            if (C != null) {
                                C.h();
                            }
                            uVar2.G().postDelayed(u.f19222u, 120000L);
                            return;
                        case 101:
                            u uVar3 = u.f19202a;
                            uVar3.G().removeCallbacks(u.f19222u);
                            com.mobvoi.mcuwatch.engine.d C2 = uVar3.C();
                            if (C2 != null) {
                                C2.f(false);
                                return;
                            }
                            return;
                        case 102:
                            u uVar4 = u.f19202a;
                            Object obj2 = msg.obj;
                            Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                            u.f19205d = ((Boolean) obj2).booleanValue();
                            uVar4.G().removeCallbacks(u.f19222u);
                            com.mobvoi.mcuwatch.engine.d C3 = uVar4.C();
                            if (C3 != null) {
                                C3.f(u.f19205d);
                                return;
                            }
                            return;
                        case 103:
                            int i11 = msg.arg1;
                            com.mobvoi.mcuwatch.engine.d C4 = u.f19202a.C();
                            if (C4 != null) {
                                C4.b(i11);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                } else {
                    u uVar5 = u.f19202a;
                    u.s(-4);
                    com.mobvoi.mcuwatch.engine.d C5 = uVar5.C();
                    if (C5 != null) {
                        C5.e();
                    }
                }
            }
        }

        c() {
            super(0);
        }

        /* renamed from: a */
        public final a invoke() {
            return new a(Looper.getMainLooper());
        }
    }

    /* compiled from: UTEBleEngine.kt */
    /* loaded from: classes2.dex */
    public static final class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            u uVar = u.f19202a;
            uVar.G().removeCallbacks(this);
            com.mobvoi.mcuwatch.engine.d C = uVar.C();
            if (C != null) {
                C.f(u.f19205d);
            }
            if (!u.f19205d) {
                k.d("UTE_OTA", "ble_fail_update");
                uVar.J().r();
                return;
            }
            u.f19205d = false;
            n.f19178a.X(false);
            k.a("UTE_OTA", "ble_update_successful");
        }
    }

    /* compiled from: UTEBleEngine.kt */
    /* loaded from: classes2.dex */
    public static final class e extends BroadcastReceiver {
        e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            i.f(context, "context");
            i.f(intent, "intent");
            String action = intent.getAction();
            if (i.b(action, gn.q.f27587f)) {
                String stringExtra = intent.getStringExtra("get_ble_version");
                u uVar = u.f19202a;
                if (uVar.D().m0()) {
                    uVar.D().onNext(stringExtra);
                }
                k.a("UTE_OTA", i.n("onReceive version ", stringExtra));
                uVar.v();
            } else if (i.b(action, gn.q.f27586e)) {
                n.f19178a.P(intent.getIntExtra("get_ble_battery", -1));
            }
        }
    }

    /* compiled from: UTEBleEngine.kt */
    /* loaded from: classes2.dex */
    public static final class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            u.f19202a.G().removeCallbacks(this);
            u.s(-3);
        }
    }

    static {
        io.d a10;
        io.d a11;
        io.d a12;
        rx.subjects.b<String> o02 = rx.subjects.b.o0();
        i.e(o02, "create()");
        f19218q = o02;
        a10 = io.f.a(a.INSTANCE);
        f19219r = a10;
        a11 = io.f.a(b.INSTANCE);
        f19220s = a11;
        a12 = io.f.a(c.INSTANCE);
        f19224w = a12;
    }

    private u() {
    }

    private final String[] K() {
        return (String[]) f19219r.getValue();
    }

    private final String[] L() {
        return (String[]) f19220s.getValue();
    }

    private final void O(int i10) {
        di.a aVar;
        fi.a aVar2;
        if (f19214m != null && (aVar = f19204c) != null) {
            if (i10 == 19) {
                aVar2 = fi.a.f27043c.c(f19202a.E().b());
            } else if (i10 != 20) {
                aVar2 = null;
            } else {
                k.d("UTEBleEngine", "蓝牙连接成功");
                aVar2 = fi.a.f27043c.a(f19202a.E().b());
            }
            if (aVar2 != null) {
                u uVar = f19202a;
                uVar.f0(aVar2);
                if (!(uVar.E().b().length() == 0)) {
                    aVar.b(aVar2, uVar.E().b());
                    if (aVar2.c() == 0) {
                        com.mobvoi.android.common.utils.q.e(com.mobvoi.android.common.utils.b.e(), "sync_mcu_fitness", "has_connect", false);
                        uVar.G().removeMessages(2);
                    }
                    if (aVar2.c() == 1) {
                        com.mobvoi.android.common.utils.q.e(com.mobvoi.android.common.utils.b.e(), "sync_mcu_fitness", "has_connect", true);
                        uVar.G().removeMessages(2);
                        uVar.G().sendEmptyMessageDelayed(2, 5000L);
                    }
                }
            }
        }
    }

    private final void P(int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 4) {
                    if (!(i10 == 5 || i10 == 7 || i10 == 8)) {
                        if (i10 != 81) {
                            if (!(i10 == 82 || i10 == 84 || i10 == 85 || i10 == 175 || i10 == 176)) {
                                switch (i10) {
                                    case 10:
                                    case 25:
                                    case 26:
                                    case 27:
                                    case 51:
                                    case 68:
                                    case 78:
                                    case 107:
                                    case 134:
                                    case 147:
                                        break;
                                    case 76:
                                        break;
                                    default:
                                        switch (i10) {
                                            case 29:
                                            case 30:
                                            case 31:
                                                break;
                                            default:
                                                switch (i10) {
                                                    case 109:
                                                    case 110:
                                                        break;
                                                    case 111:
                                                        break;
                                                    default:
                                                        switch (i10) {
                                                            case 123:
                                                                break;
                                                            case 124:
                                                            case 125:
                                                                break;
                                                            default:
                                                                return;
                                                        }
                                                }
                                        }
                                }
                            }
                        }
                    }
                }
            }
            V(i10);
            return;
        }
        s sVar = s.f19186a;
        if (sVar.d()) {
            sVar.g();
        }
    }

    private final void R() {
        int length = K().length - 1;
        if (length >= 0) {
            int i10 = 0;
            while (true) {
                int i11 = i10 + 1;
                Map<String, String> map = f19216o;
                String str = K()[i10];
                i.e(str, "WEATHER_ARRAY[i]");
                String str2 = L()[i10];
                i.e(str2, "WEATHER_CODE_ARRAY[i]");
                map.put(str, str2);
                if (i11 <= length) {
                    i10 = i11;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(int i10, int i11) {
        s.f19186a.p(104);
    }

    private final void V(int i10) {
        m mVar;
        if (!(f19215n == null || (mVar = H().get()) == null)) {
            mVar.p();
        }
        s sVar = s.f19186a;
        if (sVar.d()) {
            sVar.h(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X() {
        SharedPreferences sharedPreferences = f19217p;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString("img_local_version_name", "0");
            k.a("UTE_OTA", "readBleVersionStatus =" + ((Object) string) + ' ');
            boolean z10 = true;
            if (J().z(string) != 1) {
                z10 = false;
            }
            n.f19178a.X(z10);
            return;
        }
        i.u("settingSp");
        throw null;
    }

    private final void Z() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(gn.q.f27586e);
        intentFilter.addAction(gn.q.f27587f);
        f19202a.F().registerReceiver(f19225x, intentFilter);
    }

    public static final /* synthetic */ void s(int i10) {
    }

    private final void u(String str) {
        if (!i.b(E().b(), str) && E().c() != 1) {
            B();
        }
    }

    private final void y() throws RuntimeException {
        if (!f19206e) {
            throw new RuntimeException("UTEBleEngine not init yet");
        }
    }

    private final void z() {
        J().r();
    }

    public rx.c<Boolean> A(String address) {
        i.f(address, "address");
        y();
        m mVar = m.f28349a;
        k.a("UTEBleEngine", i.n("connect ", address));
        if (f19214m != null) {
            f19202a.u(address);
        }
        f19202a.f0(fi.a.f27043c.b(address));
        com.yc.pedometer.sdk.a aVar = f19209h;
        if (aVar != null) {
            rx.c<Boolean> A = rx.c.A(Boolean.valueOf(aVar.e(address)));
            i.e(A, "just(mConnect)");
            return A;
        }
        i.u("serviceOperate");
        throw null;
    }

    public void B() {
        com.yc.pedometer.sdk.a aVar = f19209h;
        if (aVar != null) {
            aVar.f();
            m mVar = m.f28349a;
            if (f19214m != null) {
                u uVar = f19202a;
                uVar.f0(fi.a.f27043c.c(uVar.E().b()));
                return;
            }
            return;
        }
        i.u("serviceOperate");
        throw null;
    }

    public final com.mobvoi.mcuwatch.engine.d C() {
        return f19211j;
    }

    public final rx.subjects.b<String> D() {
        return f19218q;
    }

    public final fi.a E() {
        fi.a aVar = f19214m;
        if (aVar != null) {
            return aVar;
        }
        i.u("connectState");
        throw null;
    }

    public final Context F() {
        Context context = f19207f;
        if (context != null) {
            return context;
        }
        i.u("context");
        throw null;
    }

    public final Handler G() {
        return (Handler) f19224w.getValue();
    }

    public final WeakReference<m> H() {
        WeakReference<m> weakReference = f19215n;
        if (weakReference != null) {
            return weakReference;
        }
        i.u("sendCmdListener");
        throw null;
    }

    public BluetoothLeService I() {
        com.yc.pedometer.sdk.a aVar = f19209h;
        if (aVar != null) {
            return aVar.g();
        }
        i.u("serviceOperate");
        throw null;
    }

    public final fn.a J() {
        fn.a aVar = f19210i;
        if (aVar != null) {
            return aVar;
        }
        i.u("updates");
        throw null;
    }

    public final Map<String, String> M() {
        return f19216o;
    }

    public final q N() {
        q qVar = f19213l;
        if (qVar != null) {
            return qVar;
        }
        i.u("writeCommand");
        throw null;
    }

    public final void Q(Context ctx) {
        i.f(ctx, "ctx");
        if (!S()) {
            f19206e = true;
            Context applicationContext = ctx.getApplicationContext();
            i.e(applicationContext, "ctx.applicationContext");
            g0(applicationContext);
            com.yc.pedometer.sdk.a it = com.yc.pedometer.sdk.a.h(F());
            it.k(this);
            it.j(this);
            BluetoothLeService g10 = it.g();
            if (g10 != null) {
                g10.c1(this);
            }
            u uVar = f19202a;
            i.e(it, "it");
            f19209h = it;
            fn.a it2 = fn.a.A(F());
            gn.u.e(true);
            it2.g0(uVar.G());
            it2.h0(this);
            i.e(it2, "it");
            uVar.k0(it2);
            v.f19226a.d(ctx);
            l.f19166a.n(ctx);
            q B = q.B(F());
            i.e(B, "getInstance(context)");
            l0(B);
            SharedPreferences sharedPreferences = F().getSharedPreferences(gn.q.f27582a, 0);
            i.e(sharedPreferences, "context.getSharedPreferences(GlobalVariable.SettingSP, 0)");
            f19217p = sharedPreferences;
            Z();
            R();
            en.c y10 = en.c.y(F());
            i.e(y10, "getInstance(context)");
            f19208g = y10;
            if (y10 != null) {
                y10.S(f19223v);
            } else {
                i.u("mDataProcessing");
                throw null;
            }
        }
    }

    public final boolean S() {
        return f19206e;
    }

    public boolean T() {
        y();
        m mVar = m.f28349a;
        com.yc.pedometer.sdk.a aVar = f19209h;
        if (aVar != null) {
            return aVar.i();
        }
        i.u("serviceOperate");
        throw null;
    }

    public final void W() {
        String B = J().B();
        n nVar = n.f19178a;
        if (!(!i.b(B, "no new version"))) {
            B = null;
        }
        if (B == null) {
            B = "";
        }
        nVar.Q(B);
    }

    public final void Y() {
        J().Z();
    }

    @SuppressLint({"MissingPermission"})
    public final void a0(Context context) {
        i.f(context, "context");
        try {
            sk.e.a(context).endCall();
        } catch (Exception e10) {
            k.e("UTEBleEngine", "Error occur when endCall, ", e10);
        }
    }

    public final void b0() {
        f19204c = null;
    }

    public final void c0() {
        f19203b = null;
    }

    public final void d0(com.mobvoi.mcuwatch.engine.d dVar) {
        f19211j = dVar;
    }

    @Override // en.j
    public void e(int i10) {
        BluetoothLeService I;
        k.a("UTEBleEngine", i.n("OnServiceStatus status = ", Integer.valueOf(i10)));
        if (i10 == 39 && (I = I()) != null) {
            I.c1(this);
        }
    }

    public void e0(di.a listener) {
        i.f(listener, "listener");
        f19204c = listener;
    }

    public final void f0(fi.a aVar) {
        i.f(aVar, "<set-?>");
        f19214m = aVar;
    }

    @Override // en.f
    public void g(int i10, String description) {
        i.f(description, "description");
        k.a("UTE_OTA", i.n("OnServerCallback status =", Integer.valueOf(i10)));
        G().sendEmptyMessage(1);
    }

    public final void g0(Context context) {
        i.f(context, "<set-?>");
        f19207f = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:
        if (r9 != false) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003e  */
    @Override // en.d
    @SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h(BluetoothDevice bluetoothDevice, int i10, byte[] bArr) {
        di.b bVar;
        boolean D;
        boolean D2;
        if (bluetoothDevice != null) {
            String name = bluetoothDevice.getName();
            boolean z10 = true;
            if (!(name == null || name.length() == 0)) {
                String name2 = bluetoothDevice.getName();
                i.e(name2, "it.name");
                D = t.D(name2, "TicWatch", false, 2, null);
                if (!D) {
                    String name3 = bluetoothDevice.getName();
                    i.e(name3, "it.name");
                    D2 = t.D(name3, "Mobvoi", false, 2, null);
                }
                if (!z10) {
                    bluetoothDevice = null;
                }
                if (bluetoothDevice != null && (bVar = f19203b) != null) {
                    bVar.a(new pk.f(bluetoothDevice.getName(), bluetoothDevice.getAddress(), i10));
                }
                return;
            }
            z10 = false;
            if (!z10) {
            }
            if (bluetoothDevice != null) {
                bVar.a(new pk.f(bluetoothDevice.getName(), bluetoothDevice.getAddress(), i10));
            }
        }
    }

    public void h0(di.b listener) {
        i.f(listener, "listener");
        f19203b = listener;
    }

    @Override // en.e
    public void i(boolean z10, int i10, int i11, int i12, cn.u uVar) {
        m mVar;
        k.h("UTEBleEngine", i.n("OnResultSportsModes ", Integer.valueOf(i10)));
        switch (i10) {
            case 86:
                p pVar = f19212k;
                if (pVar == null) {
                    mVar = null;
                } else {
                    pVar.a(i11, uVar);
                    if (i11 == 0) {
                        mj.c.e().d(i11, i12);
                    }
                    mVar = m.f28349a;
                }
                if (mVar == null) {
                    mj.c.e().d(i11, i12);
                    return;
                }
                return;
            case 87:
            default:
                return;
            case 88:
            case 90:
                s.f19186a.f(i10, i12);
                return;
            case 89:
                p pVar2 = f19212k;
                if (pVar2 != null) {
                    pVar2.a(i11, uVar);
                    return;
                }
                return;
        }
    }

    public final void i0(WeakReference<m> weakReference) {
        i.f(weakReference, "<set-?>");
        f19215n = weakReference;
    }

    @Override // com.mobvoi.mcuwatch.engine.o, en.e
    @SuppressLint({"MissingPermission"})
    public void j(boolean z10, int i10) {
        super.j(z10, i10);
        k.a("UTEBleEngine", "OnResult " + z10 + " status " + i10);
        if (i10 == 36 || i10 == 37) {
            s.f19186a.e(i10);
        } else if (i10 == 59) {
            a0(F());
        } else if (i10 == 62) {
            Intent intent = new Intent(F(), RingingService.class);
            intent.setAction("action_start");
            F().startService(intent);
        }
        O(i10);
        P(i10);
        if (i10 != 6) {
            switch (i10) {
                case 52:
                case 53:
                case 54:
                    k.a("UTEBleEngine", i.n("MUSIC_PLAYER ", Integer.valueOf(i10)));
                    bi.b.g().j(i10);
                    return;
                default:
                    return;
            }
        } else {
            G().removeMessages(2);
            G().sendEmptyMessageDelayed(2, 500L);
        }
    }

    public final void j0(p pVar) {
        f19212k = pVar;
    }

    public final void k0(fn.a aVar) {
        i.f(aVar, "<set-?>");
        f19210i = aVar;
    }

    @Override // en.e
    public void l(boolean z10, int i10, byte[] bArr) {
        k.a("UTEBleEngine", "OnDataResult status = " + i10 + "  result = " + z10);
        boolean z11 = false;
        if (bArr != null) {
            if (!(bArr.length == 0)) {
                new StringBuilder(bArr.length);
                int length = bArr.length;
                int i11 = 0;
                while (i11 < length) {
                    byte b10 = bArr[i11];
                    i11++;
                    n nVar = n.f30086a;
                    i.e(String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1)), "java.lang.String.format(format, *args)");
                }
            }
        }
        P(i10);
        if (i10 != 119) {
            switch (i10) {
                case 66:
                    if (z10) {
                        l.f19166a.m(true);
                        return;
                    }
                    return;
                case 67:
                    if (z10) {
                        l.f19166a.m(false);
                        return;
                    }
                    return;
                case 68:
                    l.f19166a.l(F(), bArr);
                    return;
                default:
                    return;
            }
        } else if (bArr != null) {
            if (!(bArr.length == 0)) {
                int i12 = bArr[0] & 8;
                n.f19178a.Y(i12 != 0);
                org.greenrobot.eventbus.c c10 = org.greenrobot.eventbus.c.c();
                if (i12 != 0) {
                    z11 = true;
                }
                c10.k(new qc.a(1, Boolean.valueOf(z11)));
            }
        }
    }

    public final void l0(q qVar) {
        i.f(qVar, "<set-?>");
        f19213l = qVar;
    }

    public void m0() {
        y();
        m mVar = m.f28349a;
        com.yc.pedometer.sdk.a aVar = f19209h;
        if (aVar != null) {
            aVar.l();
        } else {
            i.u("serviceOperate");
            throw null;
        }
    }

    public final void n0() {
        s.f19186a.p(101);
    }

    public final void o0() {
        J().k0();
    }

    public void p0() {
        y();
        m mVar = m.f28349a;
        com.yc.pedometer.sdk.a aVar = f19209h;
        if (aVar != null) {
            aVar.m();
        } else {
            i.u("serviceOperate");
            throw null;
        }
    }

    public final void q0() {
        z();
        gn.q.f27585d = false;
        J().v0();
        G().removeCallbacks(f19222u);
    }

    public void r0() {
        y();
        m mVar = m.f28349a;
        com.yc.pedometer.sdk.a aVar = f19209h;
        if (aVar != null) {
            aVar.n();
        } else {
            i.u("serviceOperate");
            throw null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public final int v() {
        com.mobvoi.mcuwatch.engine.f.j(this);
        if (com.mobvoi.android.common.utils.m.b(F())) {
            SharedPreferences sharedPreferences = f19217p;
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("img_local_version_name", "0");
                if (i.b(string, "0")) {
                    return AMapException.CODE_AMAP_ACCESS_TOO_FREQUENT;
                }
                if (J().k(string) == 2) {
                    return -2;
                }
                G().postDelayed(f19221t, 10000L);
                k.a("UTE_OTA", "ble version access_version_status");
                return AMapException.CODE_AMAP_DAILY_QUERY_OVER_LIMIT;
            }
            i.u("settingSp");
            throw null;
        }
        k.d("UTE_OTA", "checkBleServerVersion net error");
        return -1;
    }

    public final void w() {
        if (f19214m != null && E().c() == 1) {
            boolean j10 = z.v(F()).j();
            boolean a10 = nj.h.a(F());
            k.a("UTEBleEngine", "checkConnectState bleConnect " + j10 + " ----- isConnect " + a10);
            if (j10 && !a10) {
                String b10 = E().b();
                B();
                A(b10);
            }
        }
    }

    public final fi.a x(String address) {
        i.f(address, "address");
        if (f19214m == null || !i.b(E().b(), address)) {
            return fi.a.f27043c.c(address);
        }
        return new fi.a(E().c(), E().b());
    }
}
