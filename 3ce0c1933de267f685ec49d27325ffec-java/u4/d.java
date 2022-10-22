package u4;

import java.util.Queue;
import n5.k;
import u4.m;
/* compiled from: BaseKeyPool.java */
/* loaded from: classes.dex */
abstract class d<T extends m> {

    /* renamed from: a  reason: collision with root package name */
    private final Queue<T> f35295a = k.e(20);

    abstract T a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public T b() {
        T poll = this.f35295a.poll();
        return poll == null ? a() : poll;
    }

    public void c(T t10) {
        if (this.f35295a.size() < 20) {
            this.f35295a.offer(t10);
        }
    }
}
