package jp;

import kotlin.jvm.internal.i;
/* compiled from: HttpMethod.kt */
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f29661a = new f();

    private f() {
    }

    public static final boolean b(String method) {
        i.f(method, "method");
        return !i.b(method, "GET") && !i.b(method, "HEAD");
    }

    public static final boolean e(String method) {
        i.f(method, "method");
        return i.b(method, "POST") || i.b(method, "PUT") || i.b(method, "PATCH") || i.b(method, "PROPPATCH") || i.b(method, "REPORT");
    }

    public final boolean a(String method) {
        i.f(method, "method");
        return i.b(method, "POST") || i.b(method, "PATCH") || i.b(method, "PUT") || i.b(method, "DELETE") || i.b(method, "MOVE");
    }

    public final boolean c(String method) {
        i.f(method, "method");
        return !i.b(method, "PROPFIND");
    }

    public final boolean d(String method) {
        i.f(method, "method");
        return i.b(method, "PROPFIND");
    }
}
