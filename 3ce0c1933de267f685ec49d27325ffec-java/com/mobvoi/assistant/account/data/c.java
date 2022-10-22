package com.mobvoi.assistant.account.data;

import android.text.TextUtils;
import java.io.IOException;
import java.util.List;
import okhttp3.b0;
import okhttp3.u;
import okhttp3.v;
import okhttp3.z;
/* compiled from: MultiDomainInterceptor.java */
/* loaded from: classes2.dex */
public class c implements v {
    private String a(z zVar) {
        List<String> e10 = zVar.e("base_url");
        if (e10 == null || e10.size() == 0) {
            return null;
        }
        if (e10.size() <= 1) {
            return zVar.d("base_url");
        }
        throw new IllegalArgumentException("Only one BaseUrl in the headers");
    }

    public z b(z zVar) {
        if (zVar.e("base_url").size() <= 0) {
            return zVar;
        }
        String a10 = a(zVar);
        if (TextUtils.isEmpty(a10)) {
            return zVar;
        }
        z.a i10 = zVar.i();
        i10.m("base_url");
        u l10 = u.l(a10);
        i10.q(zVar.l().j().s(l10.t()).i(l10.h()).o(l10.n()).e());
        if (zVar.j() != null) {
            return i10.o(null).b();
        }
        return i10.b();
    }

    @Override // okhttp3.v
    public b0 intercept(v.a aVar) throws IOException {
        return aVar.a(b(aVar.request()));
    }
}
