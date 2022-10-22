package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.d0;
/* compiled from: RouteDatabase.kt */
/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private final Set<d0> f32022a = new LinkedHashSet();

    public final synchronized void a(d0 route) {
        kotlin.jvm.internal.i.f(route, "route");
        this.f32022a.remove(route);
    }

    public final synchronized void b(d0 failedRoute) {
        kotlin.jvm.internal.i.f(failedRoute, "failedRoute");
        this.f32022a.add(failedRoute);
    }

    public final synchronized boolean c(d0 route) {
        kotlin.jvm.internal.i.f(route, "route");
        return this.f32022a.contains(route);
    }
}
