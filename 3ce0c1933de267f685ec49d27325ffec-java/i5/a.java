package i5;

import java.util.ArrayList;
import java.util.List;
/* compiled from: EncoderRegistry.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final List<C0308a<?>> f28081a = new ArrayList();

    /* compiled from: EncoderRegistry.java */
    /* renamed from: i5.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static final class C0308a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f28082a;

        /* renamed from: b  reason: collision with root package name */
        final q4.a<T> f28083b;

        C0308a(Class<T> cls, q4.a<T> aVar) {
            this.f28082a = cls;
            this.f28083b = aVar;
        }

        boolean a(Class<?> cls) {
            return this.f28082a.isAssignableFrom(cls);
        }
    }

    public synchronized <T> void a(Class<T> cls, q4.a<T> aVar) {
        this.f28081a.add(new C0308a<>(cls, aVar));
    }

    public synchronized <T> q4.a<T> b(Class<T> cls) {
        for (C0308a<?> aVar : this.f28081a) {
            if (aVar.a(cls)) {
                return (q4.a<T>) aVar.f28083b;
            }
        }
        return null;
    }
}
