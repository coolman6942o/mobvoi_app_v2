package kc;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;
/* compiled from: AutoServiceFactory.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    private static b f29863b;

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, Object> f29864a = new HashMap();

    private b() {
    }

    public static b b() {
        if (f29863b == null) {
            synchronized (b.class) {
                if (f29863b == null) {
                    f29863b = new b();
                }
            }
        }
        return f29863b;
    }

    public <T> T a(Class<T> cls) {
        if (this.f29864a.containsKey(cls)) {
            return (T) this.f29864a.get(cls);
        }
        T t10 = (T) ServiceLoader.load(cls).iterator().next();
        this.f29864a.put(cls, t10);
        return t10;
    }
}
