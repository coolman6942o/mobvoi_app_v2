package androidx.collection;

import io.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import qo.r;
/* compiled from: LruCache.kt */
/* loaded from: classes.dex */
public final class LruCacheKt$lruCache$3 extends Lambda implements r<Boolean, K, V, V, m> {
    public static final LruCacheKt$lruCache$3 INSTANCE = new LruCacheKt$lruCache$3();

    public LruCacheKt$lruCache$3() {
        super(4);
    }

    @Override // qo.r
    public /* bridge */ /* synthetic */ m invoke(Boolean bool, Object obj, Object obj2, Object obj3) {
        invoke(bool.booleanValue(), (boolean) obj, obj2, obj3);
        return m.f28349a;
    }

    public final void invoke(boolean z10, K k10, V v10, V v11) {
        i.g(k10, "<anonymous parameter 1>");
        i.g(v10, "<anonymous parameter 2>");
    }
}
