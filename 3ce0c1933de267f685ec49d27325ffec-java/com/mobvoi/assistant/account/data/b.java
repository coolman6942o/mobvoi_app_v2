package com.mobvoi.assistant.account.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.b0;
import okhttp3.u;
import okhttp3.v;
import okhttp3.z;
/* compiled from: BasicParamsInterceptor.java */
/* loaded from: classes2.dex */
public class b implements v {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f15642a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, String> f15643b;

    /* renamed from: c  reason: collision with root package name */
    private List<String> f15644c;

    /* compiled from: BasicParamsInterceptor.java */
    /* renamed from: com.mobvoi.assistant.account.data.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0196b {

        /* renamed from: a  reason: collision with root package name */
        b f15645a = new b();

        public C0196b a(String str, String str2) {
            this.f15645a.f15643b.put(str, str2);
            return this;
        }

        public C0196b b(Map<String, String> map) {
            this.f15645a.f15642a.putAll(map);
            return this;
        }

        public b c() {
            return this.f15645a;
        }
    }

    private void c(z zVar, z.a aVar, Map<String, String> map) {
        u.a j10 = zVar.l().j();
        if (map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                j10.d(entry.getKey(), entry.getValue());
            }
        }
        aVar.q(j10.e());
    }

    @Override // okhttp3.v
    public b0 intercept(v.a aVar) throws IOException {
        z request = aVar.request();
        z.a i10 = request.i();
        Headers.a newBuilder = request.f().newBuilder();
        if (this.f15643b.size() > 0) {
            for (Map.Entry<String, String> entry : this.f15643b.entrySet()) {
                newBuilder.b(entry.getKey(), entry.getValue());
            }
        }
        if (this.f15644c.size() > 0) {
            for (String str : this.f15644c) {
                newBuilder.a(str);
            }
        }
        i10.i(newBuilder.f());
        if (this.f15642a.size() > 0) {
            c(request, i10, this.f15642a);
        }
        return aVar.a(i10.b());
    }

    private b() {
        this.f15642a = new HashMap();
        new HashMap();
        this.f15643b = new HashMap();
        this.f15644c = new ArrayList();
    }
}
