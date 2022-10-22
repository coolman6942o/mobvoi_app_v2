package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.collection.a;
import b6.i;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.tasks.b;
import com.google.android.gms.tasks.e;
import com.huawei.hms.ml.camera.CameraConfig;
import h6.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public final class c3 extends z2 {

    /* renamed from: c  reason: collision with root package name */
    protected v3 f9194c;

    /* renamed from: d  reason: collision with root package name */
    private AppMeasurement.b f9195d;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9197f;

    /* renamed from: e  reason: collision with root package name */
    private final Set<AppMeasurement.c> f9196e = new CopyOnWriteArraySet();

    /* renamed from: h  reason: collision with root package name */
    protected boolean f9199h = true;

    /* renamed from: g  reason: collision with root package name */
    private final AtomicReference<String> f9198g = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: protected */
    public c3(d2 d2Var) {
        super(d2Var);
    }

    private final void V(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        long b10 = b().b();
        i.k(conditionalUserProperty);
        i.g(conditionalUserProperty.mName);
        i.g(conditionalUserProperty.mOrigin);
        i.k(conditionalUserProperty.mValue);
        conditionalUserProperty.mCreationTimestamp = b10;
        String str = conditionalUserProperty.mName;
        Object obj = conditionalUserProperty.mValue;
        if (p().g0(str) != 0) {
            c().K().d("Invalid conditional user property name", o().O(str));
        } else if (p().v0(str, obj) != 0) {
            c().K().c("Invalid conditional user property value", o().O(str), obj);
        } else {
            Object w02 = p().w0(str, obj);
            if (w02 == null) {
                c().K().c("Unable to normalize conditional user property value", o().O(str), obj);
                return;
            }
            conditionalUserProperty.mValue = w02;
            long j10 = conditionalUserProperty.mTriggerTimeout;
            if (TextUtils.isEmpty(conditionalUserProperty.mTriggerEventName) || (j10 <= 15552000000L && j10 >= 1)) {
                long j11 = conditionalUserProperty.mTimeToLive;
                if (j11 > 15552000000L || j11 < 1) {
                    c().K().c("Invalid conditional user property time to live", o().O(str), Long.valueOf(j11));
                } else {
                    d().J(new j3(this, conditionalUserProperty));
                }
            } else {
                c().K().c("Invalid conditional user property timeout", o().O(str), Long.valueOf(j10));
            }
        }
    }

    private final void W(String str, String str2, long j10, Bundle bundle, boolean z10, boolean z11, boolean z12, String str3) {
        Bundle bundle2;
        if (bundle == null) {
            bundle2 = new Bundle();
        } else {
            Bundle bundle3 = new Bundle(bundle);
            for (String str4 : bundle3.keySet()) {
                Object obj = bundle3.get(str4);
                if (obj instanceof Bundle) {
                    bundle3.putBundle(str4, new Bundle((Bundle) obj));
                } else {
                    int i10 = 0;
                    if (obj instanceof Parcelable[]) {
                        Parcelable[] parcelableArr = (Parcelable[]) obj;
                        while (i10 < parcelableArr.length) {
                            if (parcelableArr[i10] instanceof Bundle) {
                                parcelableArr[i10] = new Bundle((Bundle) parcelableArr[i10]);
                            }
                            i10++;
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList = (ArrayList) obj;
                        while (i10 < arrayList.size()) {
                            Object obj2 = arrayList.get(i10);
                            if (obj2 instanceof Bundle) {
                                arrayList.set(i10, new Bundle((Bundle) obj2));
                            }
                            i10++;
                        }
                    }
                }
            }
            bundle2 = bundle3;
        }
        d().J(new u3(this, str, str2, j10, bundle2, z10, z11, z12, str3));
    }

    private final void X(String str, String str2, long j10, Object obj) {
        d().J(new e3(this, str, str2, obj, j10));
    }

    private final void b0(String str, String str2, Bundle bundle, boolean z10, boolean z11, boolean z12, String str3) {
        W(str, str2, b().b(), bundle, true, z11, z12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0(String str, String str2, Object obj, long j10) {
        i.g(str);
        i.g(str2);
        e();
        u();
        if (!this.f9815a.g0()) {
            c().Q().a("User property not set since app measurement is disabled");
        } else if (this.f9815a.C0()) {
            c().Q().c("Setting user property (FE)", o().M(str2), obj);
            l().P(new zzjx(str2, j10, obj, str));
        }
    }

    private final void d0(String str, String str2, String str3, Bundle bundle) {
        long b10 = b().b();
        i.g(str2);
        AppMeasurement.ConditionalUserProperty conditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
        conditionalUserProperty.mAppId = str;
        conditionalUserProperty.mName = str2;
        conditionalUserProperty.mCreationTimestamp = b10;
        if (str3 != null) {
            conditionalUserProperty.mExpiredEventName = str3;
            conditionalUserProperty.mExpiredEventParams = bundle;
        }
        d().J(new k3(this, conditionalUserProperty));
    }

    private final Map<String, Object> f0(String str, String str2, String str3, boolean z10) {
        b1 N;
        String str4;
        if (d().N()) {
            N = c().K();
            str4 = "Cannot get user properties from analytics worker thread";
        } else {
            d();
            if (z1.z()) {
                N = c().K();
                str4 = "Cannot get user properties from main thread";
            } else {
                AtomicReference atomicReference = new AtomicReference();
                synchronized (atomicReference) {
                    this.f9815a.d().J(new m3(this, atomicReference, str, str2, str3, z10));
                    try {
                        atomicReference.wait(5000L);
                    } catch (InterruptedException e10) {
                        c().N().d("Interrupted waiting for get user properties", e10);
                    }
                }
                List<zzjx> list = (List) atomicReference.get();
                if (list == null) {
                    N = c().N();
                    str4 = "Timed out waiting for get user properties";
                } else {
                    a aVar = new a(list.size());
                    for (zzjx zzjxVar : list) {
                        aVar.put(zzjxVar.f9893b, zzjxVar.G0());
                    }
                    return aVar;
                }
            }
        }
        N.a(str4);
        return Collections.emptyMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        e();
        u();
        i.k(conditionalUserProperty);
        i.g(conditionalUserProperty.mName);
        i.g(conditionalUserProperty.mOrigin);
        i.k(conditionalUserProperty.mValue);
        if (!this.f9815a.g0()) {
            c().Q().a("Conditional property not sent since Firebase Analytics is disabled");
            return;
        }
        zzjx zzjxVar = new zzjx(conditionalUserProperty.mName, conditionalUserProperty.mTriggeredTimestamp, conditionalUserProperty.mValue, conditionalUserProperty.mOrigin);
        try {
            zzeu D = p().D(conditionalUserProperty.mTriggeredEventName, conditionalUserProperty.mTriggeredEventParams, conditionalUserProperty.mOrigin, 0L, true, false);
            l().U(new zzed(conditionalUserProperty.mAppId, conditionalUserProperty.mOrigin, zzjxVar, conditionalUserProperty.mCreationTimestamp, false, conditionalUserProperty.mTriggerEventName, p().D(conditionalUserProperty.mTimedOutEventName, conditionalUserProperty.mTimedOutEventParams, conditionalUserProperty.mOrigin, 0L, true, false), conditionalUserProperty.mTriggerTimeout, D, conditionalUserProperty.mTimeToLive, p().D(conditionalUserProperty.mExpiredEventName, conditionalUserProperty.mExpiredEventParams, conditionalUserProperty.mOrigin, 0L, true, false)));
        } catch (IllegalArgumentException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0(String str, String str2, long j10, Bundle bundle, boolean z10, boolean z11, boolean z12, String str3) {
        String[] strArr;
        Bundle bundle2;
        int i10;
        long j11;
        i.g(str);
        i.g(str2);
        i.k(bundle);
        e();
        u();
        if (!this.f9815a.g0()) {
            c().Q().a("Event not sent since app measurement is disabled");
            return;
        }
        int i11 = 0;
        if (!this.f9197f) {
            this.f9197f = true;
            try {
                try {
                    Class.forName("com.google.android.gms.tagmanager.TagManagerService").getDeclaredMethod("initialize", Context.class).invoke(null, getContext());
                } catch (Exception e10) {
                    c().N().d("Failed to invoke Tag Manager's initialize() method", e10);
                }
            } catch (ClassNotFoundException unused) {
                c().P().a("Tag Manager is not found and thus will not be used");
            }
        }
        if (z12 && !"_iap".equals(str2)) {
            r5 K = this.f9815a.K();
            int i12 = 2;
            if (K.A0("event", str2)) {
                if (!K.S("event", AppMeasurement.a.f10131a, str2)) {
                    i12 = 13;
                } else if (K.Q("event", 40, str2)) {
                    i12 = 0;
                }
            }
            if (i12 != 0) {
                c().M().d("Invalid public event name. Event will not be logged (FE)", o().M(str2));
                this.f9815a.K();
                String G = r5.G(str2, 40, true);
                if (str2 != null) {
                    i11 = str2.length();
                }
                this.f9815a.K().I(i12, "_ev", G, i11);
                return;
            }
        }
        w3 M = m().M();
        if (M != null && !bundle.containsKey("_sc")) {
            M.f9775d = true;
        }
        x3.H(M, bundle, z10 && z12);
        boolean equals = "am".equals(str);
        boolean j02 = r5.j0(str2);
        if (z10 && this.f9195d != null && !j02 && !equals) {
            c().Q().c("Passing event to registered event handler (FE)", o().M(str2), o().J(bundle));
            this.f9195d.a(str, str2, bundle, j10);
        } else if (this.f9815a.C0()) {
            int e02 = p().e0(str2);
            if (e02 != 0) {
                c().M().d("Invalid event name. Event will not be logged (FE)", o().M(str2));
                p();
                String G2 = r5.G(str2, 40, true);
                if (str2 != null) {
                    i11 = str2.length();
                }
                this.f9815a.K().N(str3, e02, "_ev", G2, i11);
                return;
            }
            List<String> c10 = f.c("_o", "_sn", "_sc", "_si");
            Bundle B = p().B(str2, bundle, c10, z12, true);
            w3 w3Var = (B == null || !B.containsKey("_sc") || !B.containsKey("_si")) ? null : new w3(B.getString("_sn"), B.getString("_sc"), Long.valueOf(B.getLong("_si")).longValue());
            if (w3Var != null) {
                M = w3Var;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(B);
            long nextLong = p().y0().nextLong();
            String[] strArr2 = (String[]) B.keySet().toArray(new String[bundle.size()]);
            Arrays.sort(strArr2);
            int length = strArr2.length;
            int i13 = 0;
            int i14 = 0;
            while (i14 < length) {
                String str4 = strArr2[i14];
                Object obj = B.get(str4);
                p();
                Bundle[] s02 = r5.s0(obj);
                if (s02 != null) {
                    String str5 = "_eid";
                    B.putInt(str4, s02.length);
                    int i15 = 0;
                    while (i15 < s02.length) {
                        Bundle bundle3 = s02[i15];
                        int i16 = i15;
                        x3.H(M, bundle3, true);
                        String str6 = str5;
                        i13 = i13;
                        long j12 = nextLong;
                        strArr2 = strArr2;
                        B = B;
                        Bundle B2 = p().B("_ep", bundle3, c10, z12, false);
                        B2.putString("_en", str2);
                        B2.putLong(str6, j12);
                        B2.putString("_gn", str4);
                        B2.putInt("_ll", s02.length);
                        B2.putInt("_i", i16);
                        arrayList.add(B2);
                        i15 = i16 + 1;
                        str5 = str6;
                        nextLong = j12;
                    }
                    j11 = nextLong;
                    strArr = strArr2;
                    bundle2 = B;
                    i10 = s02.length + i13;
                } else {
                    strArr = strArr2;
                    bundle2 = B;
                    j11 = nextLong;
                    i10 = i13;
                }
                i14++;
                B = bundle2;
                strArr2 = strArr;
                nextLong = j11;
                i13 = i10;
            }
            Bundle bundle4 = B;
            long j13 = nextLong;
            int i17 = i13;
            if (i17 != 0) {
                bundle4.putLong("_eid", j13);
                bundle4.putInt("_epc", i17);
            }
            int i18 = 0;
            while (i18 < arrayList.size()) {
                Bundle bundle5 = (Bundle) arrayList.get(i18);
                String str7 = i18 != 0 ? "_ep" : str2;
                bundle5.putString("_o", str);
                if (z11) {
                    bundle5 = p().o0(bundle5);
                }
                Bundle bundle6 = bundle5;
                c().Q().c("Logging event (FE)", o().M(str2), o().J(bundle6));
                l().M(new zzeu(str7, new zzer(bundle6), str, j10), str3);
                if (!equals) {
                    for (AppMeasurement.c cVar : this.f9196e) {
                        cVar.a(str, str2, new Bundle(bundle6), j10);
                    }
                }
                i18++;
            }
            if (m().M() != null && "_ae".equals(str2)) {
                q().H(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        e();
        u();
        i.k(conditionalUserProperty);
        i.g(conditionalUserProperty.mName);
        if (!this.f9815a.g0()) {
            c().Q().a("Conditional property not cleared since Firebase Analytics is disabled");
            return;
        }
        try {
            l().U(new zzed(conditionalUserProperty.mAppId, conditionalUserProperty.mOrigin, new zzjx(conditionalUserProperty.mName, 0L, null, null), conditionalUserProperty.mCreationTimestamp, conditionalUserProperty.mActive, conditionalUserProperty.mTriggerEventName, null, conditionalUserProperty.mTriggerTimeout, null, conditionalUserProperty.mTimeToLive, p().D(conditionalUserProperty.mExpiredEventName, conditionalUserProperty.mExpiredEventParams, conditionalUserProperty.mOrigin, conditionalUserProperty.mCreationTimestamp, true, false)));
        } catch (IllegalArgumentException unused) {
        }
    }

    private final List<AppMeasurement.ConditionalUserProperty> l0(String str, String str2, String str3) {
        b1 K;
        String str4;
        if (d().N()) {
            K = c().K();
            str4 = "Cannot get conditional user properties from analytics worker thread";
        } else {
            d();
            if (z1.z()) {
                K = c().K();
                str4 = "Cannot get conditional user properties from main thread";
            } else {
                AtomicReference atomicReference = new AtomicReference();
                synchronized (atomicReference) {
                    this.f9815a.d().J(new l3(this, atomicReference, str, str2, str3));
                    try {
                        atomicReference.wait(5000L);
                    } catch (InterruptedException e10) {
                        c().N().c("Interrupted waiting for get conditional user properties", str, e10);
                    }
                }
                List<zzed> list = (List) atomicReference.get();
                if (list == null) {
                    c().N().d("Timed out waiting for get conditional user properties", str);
                    return Collections.emptyList();
                }
                ArrayList arrayList = new ArrayList(list.size());
                for (zzed zzedVar : list) {
                    AppMeasurement.ConditionalUserProperty conditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
                    conditionalUserProperty.mAppId = str;
                    conditionalUserProperty.mOrigin = str2;
                    conditionalUserProperty.mCreationTimestamp = zzedVar.f9879d;
                    zzjx zzjxVar = zzedVar.f9878c;
                    conditionalUserProperty.mName = zzjxVar.f9893b;
                    conditionalUserProperty.mValue = zzjxVar.G0();
                    conditionalUserProperty.mActive = zzedVar.f9880e;
                    conditionalUserProperty.mTriggerEventName = zzedVar.f9881f;
                    zzeu zzeuVar = zzedVar.f9882g;
                    if (zzeuVar != null) {
                        conditionalUserProperty.mTimedOutEventName = zzeuVar.f9888a;
                        zzer zzerVar = zzeuVar.f9889b;
                        if (zzerVar != null) {
                            conditionalUserProperty.mTimedOutEventParams = zzerVar.L0();
                        }
                    }
                    conditionalUserProperty.mTriggerTimeout = zzedVar.f9883h;
                    zzeu zzeuVar2 = zzedVar.f9884i;
                    if (zzeuVar2 != null) {
                        conditionalUserProperty.mTriggeredEventName = zzeuVar2.f9888a;
                        zzer zzerVar2 = zzeuVar2.f9889b;
                        if (zzerVar2 != null) {
                            conditionalUserProperty.mTriggeredEventParams = zzerVar2.L0();
                        }
                    }
                    conditionalUserProperty.mTriggeredTimestamp = zzedVar.f9878c.f9894c;
                    conditionalUserProperty.mTimeToLive = zzedVar.f9885j;
                    zzeu zzeuVar3 = zzedVar.f9886k;
                    if (zzeuVar3 != null) {
                        conditionalUserProperty.mExpiredEventName = zzeuVar3.f9888a;
                        zzer zzerVar3 = zzeuVar3.f9889b;
                        if (zzerVar3 != null) {
                            conditionalUserProperty.mExpiredEventParams = zzerVar3.L0();
                        }
                    }
                    arrayList.add(conditionalUserProperty);
                }
                return arrayList;
            }
        }
        K.a(str4);
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0(boolean z10) {
        e();
        u();
        c().Q().d("Setting app measurement enabled (FE)", Boolean.valueOf(z10));
        r().z(z10);
        if (!s().D(j().A())) {
            l().a0();
        } else if (!this.f9815a.g0() || !this.f9199h) {
            l().a0();
        } else {
            c().Q().a("Recording app launch after enabling measurement for the first time (FE)");
            u0();
        }
    }

    public final void A(String str, String str2, String str3, Bundle bundle) {
        i.g(str);
        f();
        d0(str, str2, str3, bundle);
    }

    public final b<String> B() {
        try {
            String K = r().K();
            return K != null ? e.e(K) : e.c(d().O(), new g3(this));
        } catch (Exception e10) {
            c().N().a("Failed to schedule task for getAppInstanceId");
            return e.d(e10);
        }
    }

    public final List<AppMeasurement.ConditionalUserProperty> C(String str, String str2) {
        return l0(null, str, str2);
    }

    public final List<AppMeasurement.ConditionalUserProperty> D(String str, String str2, String str3) {
        i.g(str);
        f();
        return l0(str, str2, str3);
    }

    public final Map<String, Object> E(String str, String str2, boolean z10) {
        return f0(null, str, str2, z10);
    }

    public final Map<String, Object> F(String str, String str2, String str3, boolean z10) {
        i.g(str);
        f();
        return f0(str, str2, str3, z10);
    }

    public final void G(String str, String str2, Bundle bundle) {
        b0(str, str2, bundle, true, this.f9195d == null || r5.j0(str2), false, null);
    }

    public final void H(AppMeasurement.c cVar) {
        u();
        i.k(cVar);
        if (!this.f9196e.add(cVar)) {
            c().N().a("OnEventListener already registered");
        }
    }

    public final void I() {
        d().J(new i3(this, b().b()));
    }

    public final void J(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        i.k(conditionalUserProperty);
        AppMeasurement.ConditionalUserProperty conditionalUserProperty2 = new AppMeasurement.ConditionalUserProperty(conditionalUserProperty);
        if (!TextUtils.isEmpty(conditionalUserProperty2.mAppId)) {
            c().N().a("Package name should be null when calling setConditionalUserProperty");
        }
        conditionalUserProperty2.mAppId = null;
        V(conditionalUserProperty2);
    }

    public final void K(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        i.k(conditionalUserProperty);
        i.g(conditionalUserProperty.mAppId);
        f();
        V(new AppMeasurement.ConditionalUserProperty(conditionalUserProperty));
    }

    public final void L(AppMeasurement.b bVar) {
        AppMeasurement.b bVar2;
        e();
        u();
        if (!(bVar == null || bVar == (bVar2 = this.f9195d))) {
            i.o(bVar2 == null, "EventInterceptor already set.");
        }
        this.f9195d = bVar;
    }

    public final void M(boolean z10) {
        u();
        d().J(new r3(this, z10));
    }

    public final void N(long j10) {
        d().J(new s3(this, j10));
    }

    public final void O(long j10) {
        d().J(new t3(this, j10));
    }

    public final void P(String str, String str2, Object obj) {
        i.g(str);
        long b10 = b().b();
        int g02 = p().g0(str2);
        int i10 = 0;
        if (g02 != 0) {
            p();
            String G = r5.G(str2, 24, true);
            if (str2 != null) {
                i10 = str2.length();
            }
            this.f9815a.K().I(g02, "_ev", G, i10);
        } else if (obj != null) {
            int v02 = p().v0(str2, obj);
            if (v02 != 0) {
                p();
                String G2 = r5.G(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i10 = String.valueOf(obj).length();
                }
                this.f9815a.K().I(v02, "_ev", G2, i10);
                return;
            }
            Object w02 = p().w0(str2, obj);
            if (w02 != null) {
                X(str, str2, b10, w02);
            }
        } else {
            X(str, str2, b10, null);
        }
    }

    public final void Q(AppMeasurement.c cVar) {
        u();
        i.k(cVar);
        if (!this.f9196e.remove(cVar)) {
            c().N().a("OnEventListener had not been registered");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void Y(String str, String str2, Bundle bundle) {
        e();
        i0(str, str2, b().b(), bundle, true, this.f9195d == null || r5.j0(str2), false, null);
    }

    public final void Z(String str, String str2, Bundle bundle, long j10) {
        W(str, str2, j10, bundle, false, true, true, null);
    }

    public final void a0(String str, String str2, Bundle bundle, boolean z10) {
        b0(str, str2, bundle, true, this.f9195d == null || r5.j0(str2), true, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String e0(long j10) {
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            d().J(new h3(this, atomicReference));
            try {
                atomicReference.wait(j10);
            } catch (InterruptedException unused) {
                c().N().a("Interrupted waiting for app instance id");
                return null;
            }
        }
        return (String) atomicReference.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void j0(String str) {
        this.f9198g.set(str);
    }

    public final String m0() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) d().B(atomicReference, 15000L, "String test flag value", new n3(this, atomicReference));
    }

    public final List<zzjx> o0(boolean z10) {
        b1 N;
        String str;
        u();
        c().Q().a("Fetching user attributes (FE)");
        if (d().N()) {
            N = c().K();
            str = "Cannot get all user properties from analytics worker thread";
        } else {
            d();
            if (z1.z()) {
                N = c().K();
                str = "Cannot get all user properties from main thread";
            } else {
                AtomicReference atomicReference = new AtomicReference();
                synchronized (atomicReference) {
                    this.f9815a.d().J(new f3(this, atomicReference, z10));
                    try {
                        atomicReference.wait(5000L);
                    } catch (InterruptedException e10) {
                        c().N().d("Interrupted waiting for get user properties", e10);
                    }
                }
                List<zzjx> list = (List) atomicReference.get();
                if (list != null) {
                    return list;
                }
                N = c().N();
                str = "Timed out waiting for get user properties";
            }
        }
        N.a(str);
        return Collections.emptyList();
    }

    public final String p0() {
        return this.f9198g.get();
    }

    public final Boolean q0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) d().B(atomicReference, 15000L, "boolean test flag value", new d3(this, atomicReference));
    }

    public final Long r0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) d().B(atomicReference, 15000L, "long test flag value", new o3(this, atomicReference));
    }

    public final Integer s0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) d().B(atomicReference, 15000L, "int test flag value", new p3(this, atomicReference));
    }

    public final Double t0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) d().B(atomicReference, 15000L, "double test flag value", new q3(this, atomicReference));
    }

    public final void u0() {
        e();
        u();
        if (this.f9815a.C0()) {
            l().Z();
            this.f9199h = false;
            String N = r().N();
            if (!TextUtils.isEmpty(N)) {
                k().u();
                if (!N.equals(Build.VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", N);
                    G(CameraConfig.CAMERA_FOCUS_AUTO, "_ou", bundle);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.z2
    protected final boolean v() {
        return false;
    }

    public final void z(String str, String str2, Bundle bundle) {
        d0(null, str, str2, bundle);
    }
}
