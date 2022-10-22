package i5;

import androidx.collection.a;
import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.load.engine.q;
import f5.g;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: LoadPathCache.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static final q<?, ?, ?> f28085c = new q<>(Object.class, Object.class, Object.class, Collections.singletonList(new i(Object.class, Object.class, Object.class, Collections.emptyList(), new g(), null)), null);

    /* renamed from: a  reason: collision with root package name */
    private final a<n5.i, q<?, ?, ?>> f28086a = new a<>();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference<n5.i> f28087b = new AtomicReference<>();

    private n5.i b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        n5.i andSet = this.f28087b.getAndSet(null);
        if (andSet == null) {
            andSet = new n5.i();
        }
        andSet.a(cls, cls2, cls3);
        return andSet;
    }

    public <Data, TResource, Transcode> q<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        q<Data, TResource, Transcode> qVar;
        n5.i b10 = b(cls, cls2, cls3);
        synchronized (this.f28086a) {
            qVar = (q<Data, TResource, Transcode>) this.f28086a.get(b10);
        }
        this.f28087b.set(b10);
        return qVar;
    }

    public boolean c(q<?, ?, ?> qVar) {
        return f28085c.equals(qVar);
    }

    public void d(Class<?> cls, Class<?> cls2, Class<?> cls3, q<?, ?, ?> qVar) {
        synchronized (this.f28086a) {
            a<n5.i, q<?, ?, ?>> aVar = this.f28086a;
            n5.i iVar = new n5.i(cls, cls2, cls3);
            if (qVar == null) {
                qVar = f28085c;
            }
            aVar.put(iVar, qVar);
        }
    }
}
