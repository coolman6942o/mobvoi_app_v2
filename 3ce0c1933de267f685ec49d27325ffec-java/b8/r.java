package b8;

import e8.a;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public final class r implements c {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Class<?>> f5101a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Class<?>> f5102b;

    /* renamed from: c  reason: collision with root package name */
    private final c f5103c;

    public r(Iterable<f> iterable, c cVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (f fVar : iterable) {
            boolean d10 = fVar.d();
            Class<?> b10 = fVar.b();
            if (d10) {
                hashSet.add(b10);
            } else {
                hashSet2.add(b10);
            }
        }
        this.f5101a = Collections.unmodifiableSet(hashSet);
        this.f5102b = Collections.unmodifiableSet(hashSet2);
        this.f5103c = cVar;
    }

    @Override // b8.c
    public final <T> T a(Class<T> cls) {
        if (this.f5101a.contains(cls)) {
            return (T) this.f5103c.a(cls);
        }
        throw new IllegalArgumentException(String.format("Requesting %s is not allowed.", cls));
    }

    @Override // b8.c
    public final <T> a<T> b(Class<T> cls) {
        if (this.f5102b.contains(cls)) {
            return this.f5103c.b(cls);
        }
        throw new IllegalArgumentException(String.format("Requesting Provider<%s> is not allowed.", cls));
    }
}
