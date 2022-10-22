package s6;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
final class i {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap<j, List<Throwable>> f34328a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b  reason: collision with root package name */
    private final ReferenceQueue<Throwable> f34329b = new ReferenceQueue<>();

    public final List<Throwable> a(Throwable th2, boolean z10) {
        while (true) {
            Reference<? extends Throwable> poll = this.f34329b.poll();
            if (poll == null) {
                break;
            }
            this.f34328a.remove(poll);
        }
        List<Throwable> list = this.f34328a.get(new j(th2, null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.f34328a.putIfAbsent(new j(th2, this.f34329b), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
