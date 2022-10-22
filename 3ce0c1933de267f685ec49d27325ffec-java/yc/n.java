package yc;

import gg.c;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.i;
/* compiled from: ArtyCardRequestData.kt */
/* loaded from: classes2.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    private long f37000a;

    /* renamed from: b  reason: collision with root package name */
    private long f37001b;

    /* renamed from: c  reason: collision with root package name */
    public Map<Long, ? extends List<? extends c>> f37002c;

    public final Map<Long, List<c>> a() {
        Map map = this.f37002c;
        if (map != null) {
            return map;
        }
        i.u("artyDataCollectionInfoMap");
        throw null;
    }

    public final long b() {
        return this.f37001b;
    }

    public final long c() {
        return this.f37000a;
    }

    public final void d(Map<Long, ? extends List<? extends c>> map) {
        i.f(map, "<set-?>");
        this.f37002c = map;
    }

    public final void e(long j10) {
        this.f37001b = j10;
    }

    public final void f(long j10) {
        this.f37000a = j10;
    }
}
