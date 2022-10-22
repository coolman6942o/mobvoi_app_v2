package q;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
/* compiled from: LruCache.java */
/* loaded from: classes.dex */
public class a<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<K, V> f32898a;

    /* renamed from: b  reason: collision with root package name */
    private int f32899b;

    /* renamed from: c  reason: collision with root package name */
    private int f32900c;

    /* renamed from: d  reason: collision with root package name */
    private int f32901d;

    /* renamed from: e  reason: collision with root package name */
    private int f32902e;

    /* renamed from: f  reason: collision with root package name */
    private int f32903f;

    /* renamed from: g  reason: collision with root package name */
    private int f32904g;

    /* renamed from: h  reason: collision with root package name */
    private int f32905h;

    public a(int i10) {
        if (i10 > 0) {
            this.f32900c = i10;
            this.f32898a = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private int f(K k10, V v10) {
        int g10 = g(k10, v10);
        if (g10 >= 0) {
            return g10;
        }
        throw new IllegalStateException("Negative size: " + k10 + ContainerUtils.KEY_VALUE_DELIMITER + v10);
    }

    protected V a(K k10) {
        return null;
    }

    protected void b(boolean z10, K k10, V v10, V v11) {
    }

    public final V c(K k10) {
        V put;
        Objects.requireNonNull(k10, "key == null");
        synchronized (this) {
            V v10 = this.f32898a.get(k10);
            if (v10 != null) {
                this.f32904g++;
                return v10;
            }
            this.f32905h++;
            V a10 = a(k10);
            if (a10 == null) {
                return null;
            }
            synchronized (this) {
                this.f32902e++;
                put = this.f32898a.put(k10, a10);
                if (put != null) {
                    this.f32898a.put(k10, put);
                } else {
                    this.f32899b += f(k10, a10);
                }
            }
            if (put != null) {
                b(false, k10, a10, put);
                return put;
            }
            h(this.f32900c);
            return a10;
        }
    }

    public final V d(K k10, V v10) {
        V put;
        if (k10 == null || v10 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f32901d++;
            this.f32899b += f(k10, v10);
            put = this.f32898a.put(k10, v10);
            if (put != null) {
                this.f32899b -= f(k10, put);
            }
        }
        if (put != null) {
            b(false, k10, put, v10);
        }
        h(this.f32900c);
        return put;
    }

    public final V e(K k10) {
        V remove;
        Objects.requireNonNull(k10, "key == null");
        synchronized (this) {
            remove = this.f32898a.remove(k10);
            if (remove != null) {
                this.f32899b -= f(k10, remove);
            }
        }
        if (remove != null) {
            b(false, k10, remove, null);
        }
        return remove;
    }

    protected int g(K k10, V v10) {
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h(int i10) {
        K key;
        V value;
        while (true) {
            synchronized (this) {
                if (this.f32899b >= 0 && (!this.f32898a.isEmpty() || this.f32899b == 0)) {
                    if (this.f32899b <= i10 || this.f32898a.isEmpty()) {
                        break;
                    }
                    Map.Entry<K, V> next = this.f32898a.entrySet().iterator().next();
                    key = next.getKey();
                    value = next.getValue();
                    this.f32898a.remove(key);
                    this.f32899b -= f(key, value);
                    this.f32903f++;
                } else {
                    break;
                }
            }
            b(true, key, value, null);
        }
    }

    public final synchronized String toString() {
        int i10;
        int i11;
        i10 = this.f32904g;
        i11 = this.f32905h + i10;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f32900c), Integer.valueOf(this.f32904g), Integer.valueOf(this.f32905h), Integer.valueOf(i11 != 0 ? (i10 * 100) / i11 : 0));
    }
}
