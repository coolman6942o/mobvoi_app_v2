package bq;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: RxJavaPlugins.java */
/* loaded from: classes3.dex */
public class f {

    /* renamed from: f  reason: collision with root package name */
    private static final f f5526f = new f();

    /* renamed from: g  reason: collision with root package name */
    static final bq.b f5527g = new a();

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<bq.b> f5528a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference<d> f5529b = new AtomicReference<>();

    /* renamed from: c  reason: collision with root package name */
    private final AtomicReference<h> f5530c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    private final AtomicReference<bq.a> f5531d = new AtomicReference<>();

    /* renamed from: e  reason: collision with root package name */
    private final AtomicReference<g> f5532e = new AtomicReference<>();

    /* compiled from: RxJavaPlugins.java */
    /* loaded from: classes3.dex */
    static class a extends bq.b {
        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RxJavaPlugins.java */
    /* loaded from: classes3.dex */
    public class b extends bq.a {
        b(f fVar) {
        }
    }

    f() {
    }

    @Deprecated
    public static f c() {
        return f5526f;
    }

    static Object e(Class<?> cls, Properties properties) {
        Properties properties2 = (Properties) properties.clone();
        String simpleName = cls.getSimpleName();
        String property = properties2.getProperty("rxjava.plugin." + simpleName + ".implementation");
        if (property == null) {
            Iterator it = properties2.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String obj = entry.getKey().toString();
                if (obj.startsWith("rxjava.plugin.") && obj.endsWith(".class") && simpleName.equals(entry.getValue().toString())) {
                    String str = "rxjava.plugin." + obj.substring(0, obj.length() - 6).substring(14) + ".impl";
                    String property2 = properties2.getProperty(str);
                    if (property2 != null) {
                        property = property2;
                    } else {
                        throw new IllegalStateException("Implementing class declaration for " + simpleName + " missing: " + str);
                    }
                }
            }
        }
        if (property == null) {
            return null;
        }
        try {
            return Class.forName(property).asSubclass(cls).newInstance();
        } catch (ClassCastException e10) {
            throw new IllegalStateException(simpleName + " implementation is not an instance of " + simpleName + ": " + property, e10);
        } catch (ClassNotFoundException e11) {
            throw new IllegalStateException(simpleName + " implementation class not found: " + property, e11);
        } catch (IllegalAccessException e12) {
            throw new IllegalStateException(simpleName + " implementation not able to be accessed: " + property, e12);
        } catch (InstantiationException e13) {
            throw new IllegalStateException(simpleName + " implementation not able to be instantiated: " + property, e13);
        }
    }

    public bq.a a() {
        if (this.f5531d.get() == null) {
            Object e10 = e(bq.a.class, System.getProperties());
            if (e10 == null) {
                this.f5531d.compareAndSet(null, new b(this));
            } else {
                this.f5531d.compareAndSet(null, (bq.a) e10);
            }
        }
        return this.f5531d.get();
    }

    public bq.b b() {
        if (this.f5528a.get() == null) {
            Object e10 = e(bq.b.class, System.getProperties());
            if (e10 == null) {
                this.f5528a.compareAndSet(null, f5527g);
            } else {
                this.f5528a.compareAndSet(null, (bq.b) e10);
            }
        }
        return this.f5528a.get();
    }

    public d d() {
        if (this.f5529b.get() == null) {
            Object e10 = e(d.class, System.getProperties());
            if (e10 == null) {
                this.f5529b.compareAndSet(null, e.f());
            } else {
                this.f5529b.compareAndSet(null, (d) e10);
            }
        }
        return this.f5529b.get();
    }

    public g f() {
        if (this.f5532e.get() == null) {
            Object e10 = e(g.class, System.getProperties());
            if (e10 == null) {
                this.f5532e.compareAndSet(null, g.h());
            } else {
                this.f5532e.compareAndSet(null, (g) e10);
            }
        }
        return this.f5532e.get();
    }

    public h g() {
        if (this.f5530c.get() == null) {
            Object e10 = e(h.class, System.getProperties());
            if (e10 == null) {
                this.f5530c.compareAndSet(null, i.f());
            } else {
                this.f5530c.compareAndSet(null, (h) e10);
            }
        }
        return this.f5530c.get();
    }
}
