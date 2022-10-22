package i5;

import androidx.collection.a;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import n5.i;
/* compiled from: ModelToResourceClassCache.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<i> f28088a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    private final a<i, List<Class<?>>> f28089b = new a<>();

    public List<Class<?>> a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        List<Class<?>> list;
        i andSet = this.f28088a.getAndSet(null);
        if (andSet == null) {
            andSet = new i(cls, cls2, cls3);
        } else {
            andSet.a(cls, cls2, cls3);
        }
        synchronized (this.f28089b) {
            list = this.f28089b.get(andSet);
        }
        this.f28088a.set(andSet);
        return list;
    }

    public void b(Class<?> cls, Class<?> cls2, Class<?> cls3, List<Class<?>> list) {
        synchronized (this.f28089b) {
            this.f28089b.put(new i(cls, cls2, cls3), list);
        }
    }
}
