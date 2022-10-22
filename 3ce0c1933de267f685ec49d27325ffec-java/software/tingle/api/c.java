package software.tingle.api;

import java.util.Collection;
import java.util.HashMap;
import kotlin.collections.e;
import kotlin.collections.k;
import kotlin.collections.m;
import kotlin.jvm.internal.i;
/* compiled from: HttpApiResponseProblem.kt */
/* loaded from: classes3.dex */
public class c {
    @h8.c("type")

    /* renamed from: a  reason: collision with root package name */
    private String f35027a;
    @h8.c("title")

    /* renamed from: b  reason: collision with root package name */
    private String f35028b;
    @h8.c("detail")

    /* renamed from: c  reason: collision with root package name */
    private String f35029c;
    @h8.c("instance")

    /* renamed from: d  reason: collision with root package name */
    private String f35030d;
    @h8.c("errors")

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, String[]> f35031e;
    @h8.c("error_code")

    /* renamed from: f  reason: collision with root package name */
    private String f35032f;
    @h8.c("error_description")

    /* renamed from: g  reason: collision with root package name */
    private String f35033g;

    private final String d() {
        HashMap<String, String[]> e10 = e();
        Collection<String[]> values = e10 == null ? null : e10.values();
        if (values == null) {
            values = m.g();
        }
        if (values.isEmpty()) {
            return "";
        }
        Object E = k.E(values);
        i.e(E, "labels.first()");
        return (String) e.q((Object[]) E);
    }

    public String a() {
        String h10 = h();
        return h10 == null ? f() : h10;
    }

    public String b() {
        String c10 = c();
        if (c10 != null) {
            return c10;
        }
        String g10 = g();
        return g10 == null ? d() : g10;
    }

    public String c() {
        return this.f35029c;
    }

    public HashMap<String, String[]> e() {
        return this.f35031e;
    }

    public String f() {
        return this.f35032f;
    }

    public String g() {
        return this.f35033g;
    }

    public String h() {
        return this.f35028b;
    }
}
