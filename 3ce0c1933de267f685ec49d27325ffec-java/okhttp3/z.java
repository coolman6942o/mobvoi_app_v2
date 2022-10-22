package okhttp3;

import gp.b;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jp.f;
import kotlin.Pair;
import kotlin.collections.a0;
import kotlin.collections.k;
import kotlin.jvm.internal.i;
import kotlin.text.t;
import okhttp3.Headers;
/* compiled from: Request.kt */
/* loaded from: classes3.dex */
public final class z {

    /* renamed from: a  reason: collision with root package name */
    private d f32371a;

    /* renamed from: b  reason: collision with root package name */
    private final u f32372b;

    /* renamed from: c  reason: collision with root package name */
    private final String f32373c;

    /* renamed from: d  reason: collision with root package name */
    private final Headers f32374d;

    /* renamed from: e  reason: collision with root package name */
    private final a0 f32375e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<Class<?>, Object> f32376f;

    public z(u url, String method, Headers headers, a0 a0Var, Map<Class<?>, ? extends Object> tags) {
        i.f(url, "url");
        i.f(method, "method");
        i.f(headers, "headers");
        i.f(tags, "tags");
        this.f32372b = url;
        this.f32373c = method;
        this.f32374d = headers;
        this.f32375e = a0Var;
        this.f32376f = tags;
    }

    public final a0 a() {
        return this.f32375e;
    }

    public final d b() {
        d dVar = this.f32371a;
        if (dVar != null) {
            return dVar;
        }
        d b10 = d.f31818o.b(this.f32374d);
        this.f32371a = b10;
        return b10;
    }

    public final Map<Class<?>, Object> c() {
        return this.f32376f;
    }

    public final String d(String name) {
        i.f(name, "name");
        return this.f32374d.get(name);
    }

    public final List<String> e(String name) {
        i.f(name, "name");
        return this.f32374d.values(name);
    }

    public final Headers f() {
        return this.f32374d;
    }

    public final boolean g() {
        return this.f32372b.i();
    }

    public final String h() {
        return this.f32373c;
    }

    public final a i() {
        return new a(this);
    }

    public final Object j() {
        return k(Object.class);
    }

    public final <T> T k(Class<? extends T> type) {
        i.f(type, "type");
        return type.cast(this.f32376f.get(type));
    }

    public final u l() {
        return this.f32372b;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Request{method=");
        sb2.append(this.f32373c);
        sb2.append(", url=");
        sb2.append(this.f32372b);
        if (this.f32374d.size() != 0) {
            sb2.append(", headers=[");
            int i10 = 0;
            for (Pair<? extends String, ? extends String> pair : this.f32374d) {
                i10++;
                if (i10 < 0) {
                    k.o();
                }
                Pair<? extends String, ? extends String> pair2 = pair;
                String component1 = pair2.component1();
                String component2 = pair2.component2();
                if (i10 > 0) {
                    sb2.append(", ");
                }
                sb2.append(component1);
                sb2.append(':');
                sb2.append(component2);
            }
            sb2.append(']');
        }
        if (!this.f32376f.isEmpty()) {
            sb2.append(", tags=");
            sb2.append(this.f32376f);
        }
        sb2.append('}');
        String sb3 = sb2.toString();
        i.e(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    /* compiled from: Request.kt */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private u f32377a;

        /* renamed from: b  reason: collision with root package name */
        private String f32378b;

        /* renamed from: c  reason: collision with root package name */
        private Headers.a f32379c;

        /* renamed from: d  reason: collision with root package name */
        private a0 f32380d;

        /* renamed from: e  reason: collision with root package name */
        private Map<Class<?>, Object> f32381e;

        public a() {
            this.f32381e = new LinkedHashMap();
            this.f32378b = "GET";
            this.f32379c = new Headers.a();
        }

        public static /* synthetic */ a f(a aVar, a0 a0Var, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    a0Var = b.f27628d;
                }
                return aVar.e(a0Var);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        }

        public a a(String name, String value) {
            i.f(name, "name");
            i.f(value, "value");
            this.f32379c.b(name, value);
            return this;
        }

        public z b() {
            u uVar = this.f32377a;
            if (uVar != null) {
                return new z(uVar, this.f32378b, this.f32379c.f(), this.f32380d, b.P(this.f32381e));
            }
            throw new IllegalStateException("url == null".toString());
        }

        public a c(d cacheControl) {
            i.f(cacheControl, "cacheControl");
            String dVar = cacheControl.toString();
            return dVar.length() == 0 ? m("Cache-Control") : h("Cache-Control", dVar);
        }

        public final a d() {
            return f(this, null, 1, null);
        }

        public a e(a0 a0Var) {
            return j("DELETE", a0Var);
        }

        public a g() {
            return j("GET", null);
        }

        public a h(String name, String value) {
            i.f(name, "name");
            i.f(value, "value");
            this.f32379c.j(name, value);
            return this;
        }

        public a i(Headers headers) {
            i.f(headers, "headers");
            this.f32379c = headers.newBuilder();
            return this;
        }

        public a j(String method, a0 a0Var) {
            i.f(method, "method");
            if (method.length() > 0) {
                if (a0Var == null) {
                    if (!(true ^ f.e(method))) {
                        throw new IllegalArgumentException(("method " + method + " must have a request body.").toString());
                    }
                } else if (!f.b(method)) {
                    throw new IllegalArgumentException(("method " + method + " must not have a request body.").toString());
                }
                this.f32378b = method;
                this.f32380d = a0Var;
                return this;
            }
            throw new IllegalArgumentException("method.isEmpty() == true".toString());
        }

        public a k(a0 body) {
            i.f(body, "body");
            return j("PATCH", body);
        }

        public a l(a0 body) {
            i.f(body, "body");
            return j("POST", body);
        }

        public a m(String name) {
            i.f(name, "name");
            this.f32379c.i(name);
            return this;
        }

        public <T> a n(Class<? super T> type, T t10) {
            i.f(type, "type");
            if (t10 == null) {
                this.f32381e.remove(type);
            } else {
                if (this.f32381e.isEmpty()) {
                    this.f32381e = new LinkedHashMap();
                }
                Map<Class<?>, Object> map = this.f32381e;
                T cast = type.cast(t10);
                i.d(cast);
                map.put(type, cast);
            }
            return this;
        }

        public a o(Object obj) {
            return n(Object.class, obj);
        }

        public a p(String url) {
            boolean B;
            boolean B2;
            i.f(url, "url");
            B = t.B(url, "ws:", true);
            if (B) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("http:");
                String substring = url.substring(3);
                i.e(substring, "(this as java.lang.String).substring(startIndex)");
                sb2.append(substring);
                url = sb2.toString();
            } else {
                B2 = t.B(url, "wss:", true);
                if (B2) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("https:");
                    String substring2 = url.substring(4);
                    i.e(substring2, "(this as java.lang.String).substring(startIndex)");
                    sb3.append(substring2);
                    url = sb3.toString();
                }
            }
            return q(u.f32275l.d(url));
        }

        public a q(u url) {
            i.f(url, "url");
            this.f32377a = url;
            return this;
        }

        public a(z request) {
            Map<Class<?>, Object> map;
            i.f(request, "request");
            this.f32381e = new LinkedHashMap();
            this.f32377a = request.l();
            this.f32378b = request.h();
            this.f32380d = request.a();
            if (request.c().isEmpty()) {
                map = new LinkedHashMap<>();
            } else {
                map = a0.p(request.c());
            }
            this.f32381e = map;
            this.f32379c = request.f().newBuilder();
        }
    }
}
