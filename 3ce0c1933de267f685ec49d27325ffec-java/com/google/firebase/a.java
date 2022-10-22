package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import b6.h;
import b6.i;
import b8.m;
import com.mobvoi.wear.contacts.ContactConstant;
import h6.n;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class a {

    /* renamed from: h  reason: collision with root package name */
    private static final List<String> f12406h = Arrays.asList("com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId");

    /* renamed from: i  reason: collision with root package name */
    private static final List<String> f12407i = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");

    /* renamed from: j  reason: collision with root package name */
    private static final List<String> f12408j = Arrays.asList("com.google.android.gms.measurement.AppMeasurement");

    /* renamed from: k  reason: collision with root package name */
    private static final List<String> f12409k = Arrays.asList(new String[0]);

    /* renamed from: l  reason: collision with root package name */
    private static final Set<String> f12410l = Collections.emptySet();

    /* renamed from: m  reason: collision with root package name */
    private static final Object f12411m = new Object();

    /* renamed from: n  reason: collision with root package name */
    static final Map<String, a> f12412n = new androidx.collection.a();

    /* renamed from: a  reason: collision with root package name */
    private final Context f12413a;

    /* renamed from: b  reason: collision with root package name */
    private final String f12414b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.firebase.b f12415c;

    /* renamed from: d  reason: collision with root package name */
    private final m f12416d;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicBoolean f12417e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    private final AtomicBoolean f12418f = new AtomicBoolean();

    /* renamed from: g  reason: collision with root package name */
    private final List<AbstractC0161a> f12419g = new CopyOnWriteArrayList();

    /* renamed from: com.google.firebase.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface AbstractC0161a {
        void a(boolean z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(24)
    /* loaded from: classes.dex */
    public static class b extends BroadcastReceiver {

        /* renamed from: b  reason: collision with root package name */
        private static AtomicReference<b> f12420b = new AtomicReference<>();

        /* renamed from: a  reason: collision with root package name */
        private final Context f12421a;

        private b(Context context) {
            this.f12421a = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void a(Context context) {
            if (f12420b.get() == null) {
                b bVar = new b(context);
                if (f12420b.compareAndSet(null, bVar)) {
                    context.registerReceiver(bVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            synchronized (a.f12411m) {
                for (a aVar : a.f12412n.values()) {
                    aVar.o();
                }
            }
            this.f12421a.unregisterReceiver(this);
        }
    }

    private a(Context context, String str, com.google.firebase.b bVar) {
        new CopyOnWriteArrayList();
        new CopyOnWriteArrayList();
        Context context2 = (Context) i.k(context);
        this.f12413a = context2;
        this.f12414b = i.g(str);
        com.google.firebase.b bVar2 = (com.google.firebase.b) i.k(bVar);
        this.f12415c = bVar2;
        new f8.a();
        this.f12416d = new m(new b8.i(context2).b(), b8.a.b(Context.class, context2), b8.a.b(a.class, this), b8.a.b(com.google.firebase.b.class, bVar2));
    }

    public static a c() {
        a aVar;
        synchronized (f12411m) {
            aVar = f12412n.get("[DEFAULT]");
            if (aVar == null) {
                String a10 = com.google.android.gms.common.util.a.a();
                StringBuilder sb2 = new StringBuilder(String.valueOf(a10).length() + 116);
                sb2.append("Default FirebaseApp is not initialized in this process ");
                sb2.append(a10);
                sb2.append(". Make sure to call FirebaseApp.initializeApp(Context) first.");
                throw new IllegalStateException(sb2.toString());
            }
        }
        return aVar;
    }

    public static a f(Context context) {
        synchronized (f12411m) {
            if (f12412n.containsKey("[DEFAULT]")) {
                return c();
            }
            com.google.firebase.b a10 = com.google.firebase.b.a(context);
            if (a10 == null) {
                return null;
            }
            return g(context, a10);
        }
    }

    public static a g(Context context, com.google.firebase.b bVar) {
        return h(context, bVar, "[DEFAULT]");
    }

    public static a h(Context context, com.google.firebase.b bVar, String str) {
        a aVar;
        f8.b.b(context);
        if (n.a() && (context.getApplicationContext() instanceof Application)) {
            com.google.android.gms.common.api.internal.b.c((Application) context.getApplicationContext());
            com.google.android.gms.common.api.internal.b.b().a(new c());
        }
        String trim = str.trim();
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f12411m) {
            Map<String, a> map = f12412n;
            boolean z10 = !map.containsKey(trim);
            StringBuilder sb2 = new StringBuilder(String.valueOf(trim).length() + 33);
            sb2.append("FirebaseApp name ");
            sb2.append(trim);
            sb2.append(" already exists!");
            i.o(z10, sb2.toString());
            i.l(context, "Application context cannot be null.");
            aVar = new a(context, trim, bVar);
            map.put(trim, aVar);
        }
        f8.b.a(aVar);
        aVar.o();
        return aVar;
    }

    public static void j(boolean z10) {
        synchronized (f12411m) {
            ArrayList arrayList = new ArrayList(f12412n.values());
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                a aVar = (a) obj;
                if (aVar.f12417e.get()) {
                    aVar.n(z10);
                }
            }
        }
    }

    private final void k() {
        i.o(!this.f12418f.get(), "FirebaseApp was deleted");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void m(Class<T> cls, T t10, Iterable<String> iterable, boolean z10) {
        for (String str : iterable) {
            if (z10) {
                try {
                } catch (ClassNotFoundException unused) {
                    if (!f12410l.contains(str)) {
                        Log.d("FirebaseApp", String.valueOf(str).concat(" is not linked. Skipping initialization."));
                    } else {
                        throw new IllegalStateException(String.valueOf(str).concat(" is missing, but is required. Check if it has been removed by Proguard."));
                    }
                } catch (IllegalAccessException e10) {
                    String valueOf = String.valueOf(str);
                    Log.wtf("FirebaseApp", valueOf.length() != 0 ? "Failed to initialize ".concat(valueOf) : new String("Failed to initialize "), e10);
                } catch (NoSuchMethodException unused2) {
                    throw new IllegalStateException(String.valueOf(str).concat("#getInstance has been removed by Proguard. Add keep rule to prevent it."));
                } catch (InvocationTargetException e11) {
                    Log.wtf("FirebaseApp", "Firebase API initialization failure.", e11);
                }
                if (f12409k.contains(str)) {
                }
            }
            Method method = Class.forName(str).getMethod("getInstance", cls);
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                method.invoke(null, t10);
            }
        }
    }

    private final void n(boolean z10) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (AbstractC0161a aVar : this.f12419g) {
            aVar.a(z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        boolean k10 = androidx.core.content.b.k(this.f12413a);
        if (k10) {
            b.a(this.f12413a);
        } else {
            this.f12416d.c(i());
        }
        m(a.class, this, f12406h, k10);
        if (i()) {
            m(a.class, this, f12407i, k10);
            m(Context.class, this.f12413a, f12408j, k10);
        }
    }

    public <T> T a(Class<T> cls) {
        k();
        return (T) this.f12416d.a(cls);
    }

    public Context b() {
        k();
        return this.f12413a;
    }

    public String d() {
        k();
        return this.f12414b;
    }

    public com.google.firebase.b e() {
        k();
        return this.f12415c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        return this.f12414b.equals(((a) obj).d());
    }

    public int hashCode() {
        return this.f12414b.hashCode();
    }

    public boolean i() {
        return "[DEFAULT]".equals(d());
    }

    public String toString() {
        return h.c(this).a(ContactConstant.CallsRecordKeys.NAME, this.f12414b).a("options", this.f12415c).toString();
    }
}
