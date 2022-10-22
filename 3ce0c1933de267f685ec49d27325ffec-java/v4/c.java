package v4;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import n5.j;
/* compiled from: DiskCacheWriteLocker.java */
/* loaded from: classes.dex */
final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, a> f35587a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final b f35588b = new b();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskCacheWriteLocker.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Lock f35589a = new ReentrantLock();

        /* renamed from: b  reason: collision with root package name */
        int f35590b;

        a() {
        }
    }

    /* compiled from: DiskCacheWriteLocker.java */
    /* loaded from: classes.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<a> f35591a = new ArrayDeque();

        b() {
        }

        a a() {
            a poll;
            synchronized (this.f35591a) {
                poll = this.f35591a.poll();
            }
            return poll == null ? new a() : poll;
        }

        void b(a aVar) {
            synchronized (this.f35591a) {
                if (this.f35591a.size() < 10) {
                    this.f35591a.offer(aVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        a aVar;
        synchronized (this) {
            aVar = this.f35587a.get(str);
            if (aVar == null) {
                aVar = this.f35588b.a();
                this.f35587a.put(str, aVar);
            }
            aVar.f35590b++;
        }
        aVar.f35589a.lock();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        a aVar;
        synchronized (this) {
            aVar = (a) j.d(this.f35587a.get(str));
            int i10 = aVar.f35590b;
            if (i10 >= 1) {
                int i11 = i10 - 1;
                aVar.f35590b = i11;
                if (i11 == 0) {
                    a remove = this.f35587a.remove(str);
                    if (remove.equals(aVar)) {
                        this.f35588b.b(remove);
                    } else {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", safeKey: " + str);
                    }
                }
            } else {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f35590b);
            }
        }
        aVar.f35589a.unlock();
    }
}
