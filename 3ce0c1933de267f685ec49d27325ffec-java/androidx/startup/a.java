package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k1.b;
/* compiled from: AppInitializer.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    private static volatile a f4358d;

    /* renamed from: e  reason: collision with root package name */
    private static final Object f4359e = new Object();

    /* renamed from: c  reason: collision with root package name */
    final Context f4362c;

    /* renamed from: b  reason: collision with root package name */
    final Set<Class<? extends k1.a<?>>> f4361b = new HashSet();

    /* renamed from: a  reason: collision with root package name */
    final Map<Class<?>, Object> f4360a = new HashMap();

    a(Context context) {
        this.f4362c = context.getApplicationContext();
    }

    public static a c(Context context) {
        if (f4358d == null) {
            synchronized (f4359e) {
                if (f4358d == null) {
                    f4358d = new a(context);
                }
            }
        }
        return f4358d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a() {
        try {
            try {
                m1.a.a("Startup");
                Bundle bundle = this.f4362c.getPackageManager().getProviderInfo(new ComponentName(this.f4362c.getPackageName(), InitializationProvider.class.getName()), 128).metaData;
                String string = this.f4362c.getString(b.f29713a);
                if (bundle != null) {
                    HashSet hashSet = new HashSet();
                    for (String str : bundle.keySet()) {
                        if (string.equals(bundle.getString(str, null))) {
                            Class<?> cls = Class.forName(str);
                            if (k1.a.class.isAssignableFrom(cls)) {
                                this.f4361b.add(cls);
                                b(cls, hashSet);
                            }
                        }
                    }
                }
            } finally {
                m1.a.b();
            }
        } catch (PackageManager.NameNotFoundException | ClassNotFoundException e10) {
            throw new StartupException(e10);
        }
    }

    <T> T b(Class<? extends k1.a<?>> cls, Set<Class<?>> set) {
        T t10;
        synchronized (f4359e) {
            if (m1.a.d()) {
                m1.a.a(cls.getSimpleName());
            }
            if (!set.contains(cls)) {
                if (!this.f4360a.containsKey(cls)) {
                    set.add(cls);
                    try {
                        k1.a<?> newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                        List<Class<? extends k1.a<?>>> a10 = newInstance.a();
                        if (!a10.isEmpty()) {
                            for (Class<? extends k1.a<?>> cls2 : a10) {
                                if (!this.f4360a.containsKey(cls2)) {
                                    b(cls2, set);
                                }
                            }
                        }
                        t10 = (T) newInstance.b(this.f4362c);
                        set.remove(cls);
                        this.f4360a.put(cls, t10);
                    } catch (Throwable th2) {
                        throw new StartupException(th2);
                    }
                } else {
                    t10 = (T) this.f4360a.get(cls);
                }
                m1.a.b();
            } else {
                throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
            }
        }
        return t10;
    }

    public <T> T d(Class<? extends k1.a<T>> cls) {
        return (T) b(cls, new HashSet());
    }
}
