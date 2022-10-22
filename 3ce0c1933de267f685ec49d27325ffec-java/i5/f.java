package i5;

import java.util.ArrayList;
import java.util.List;
/* compiled from: ResourceEncoderRegistry.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<?>> f28095a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ResourceEncoderRegistry.java */
    /* loaded from: classes.dex */
    public static final class a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f28096a;

        /* renamed from: b  reason: collision with root package name */
        final q4.f<T> f28097b;

        a(Class<T> cls, q4.f<T> fVar) {
            this.f28096a = cls;
            this.f28097b = fVar;
        }

        boolean a(Class<?> cls) {
            return this.f28096a.isAssignableFrom(cls);
        }
    }

    public synchronized <Z> void a(Class<Z> cls, q4.f<Z> fVar) {
        this.f28095a.add(new a<>(cls, fVar));
    }

    public synchronized <Z> q4.f<Z> b(Class<Z> cls) {
        int size = this.f28095a.size();
        for (int i10 = 0; i10 < size; i10++) {
            a<?> aVar = this.f28095a.get(i10);
            if (aVar.a(cls)) {
                return (q4.f<Z>) aVar.f28097b;
            }
        }
        return null;
    }
}
