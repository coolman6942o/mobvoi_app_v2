package n5;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* compiled from: LruCache.java */
/* loaded from: classes.dex */
public class g<T, Y> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<T, Y> f31038a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    private long f31039b;

    /* renamed from: c  reason: collision with root package name */
    private long f31040c;

    public g(long j10) {
        this.f31039b = j10;
    }

    private void f() {
        m(this.f31039b);
    }

    public void b() {
        m(0L);
    }

    public synchronized Y g(T t10) {
        return this.f31038a.get(t10);
    }

    public synchronized long h() {
        return this.f31039b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int i(Y y10) {
        return 1;
    }

    protected void j(T t10, Y y10) {
    }

    public synchronized Y k(T t10, Y y10) {
        long i10 = i(y10);
        if (i10 >= this.f31039b) {
            j(t10, y10);
            return null;
        }
        if (y10 != null) {
            this.f31040c += i10;
        }
        Y put = this.f31038a.put(t10, y10);
        if (put != null) {
            this.f31040c -= i(put);
            if (!put.equals(y10)) {
                j(t10, put);
            }
        }
        f();
        return put;
    }

    public synchronized Y l(T t10) {
        Y remove;
        remove = this.f31038a.remove(t10);
        if (remove != null) {
            this.f31040c -= i(remove);
        }
        return remove;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void m(long j10) {
        while (this.f31040c > j10) {
            Iterator<Map.Entry<T, Y>> it = this.f31038a.entrySet().iterator();
            Map.Entry<T, Y> next = it.next();
            Y value = next.getValue();
            this.f31040c -= i(value);
            T key = next.getKey();
            it.remove();
            j(key, value);
        }
    }
}
