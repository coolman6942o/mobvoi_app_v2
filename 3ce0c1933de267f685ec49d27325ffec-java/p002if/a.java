package p002if;

import android.content.Context;
import android.text.TextUtils;
import bf.c;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.m;
import com.mobvoi.health.common.data.sync.net.ServerSyncException;
import com.mobvoi.wear.providers.HealthFlagsHelper;
import df.d;
import hf.o;
import java.util.Objects;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/* compiled from: NetClient.java */
/* renamed from: if.a  reason: invalid package */
/* loaded from: classes2.dex */
class a implements hf.a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f28241a;

    /* renamed from: b  reason: collision with root package name */
    private final c f28242b;

    /* renamed from: c  reason: collision with root package name */
    private final cf.a f28243c;

    /* compiled from: NetClient.java */
    /* renamed from: if.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0315a implements Callback<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f28244a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ o f28245b;

        C0315a(b bVar, o oVar) {
            this.f28244a = bVar;
            this.f28245b = oVar;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<R> call, Throwable th2) {
            k.r("fit.net.client", "Request network failed", th2, new Object[0]);
            o oVar = this.f28245b;
            if (oVar != null) {
                oVar.a(null, th2);
            }
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<R> call, Response<R> response) {
            Throwable k10 = a.this.k(response);
            Object a10 = (k10 != null || response.body() == null) ? null : this.f28244a.a((d) response.body());
            if (k10 != null) {
                k.r("fit.net.client", "Request error", k10, new Object[0]);
            } else {
                k.c("fit.net.client", "Request success, data: %s", a10);
            }
            o oVar = this.f28245b;
            if (oVar != null) {
                oVar.a(a10, k10);
            }
        }
    }

    /* compiled from: NetClient.java */
    /* renamed from: if.a$b */
    /* loaded from: classes2.dex */
    interface b<R extends d, T> {
        T a(R r10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, c cVar) {
        this.f28241a = context;
        this.f28242b = cVar;
        this.f28243c = (cf.a) cVar.a(cf.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Throwable k(Response<? extends d> response) {
        if (!response.isSuccessful()) {
            return new ServerSyncException(response.message(), response.code());
        }
        d body = response.body();
        Objects.requireNonNull(body, "Deserialized response body error!");
        if (body.errCode != 0) {
            return new ServerSyncException(body.errMessage, body.errCode);
        }
        return null;
    }

    @Override // hf.a
    public boolean isConnected() {
        if (eg.d.a(com.mobvoi.android.common.utils.b.e())) {
            return HealthFlagsHelper.isFeatureEnabled(HealthFlagsHelper.FLAG_NETWORK_SYNC) && m.b(this.f28241a) && !TextUtils.isEmpty(this.f28242b.b());
        }
        eg.d.d(com.mobvoi.android.common.utils.b.e());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf.a j() {
        return this.f28243c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <R extends d, T> Callback<R> l(o<T> oVar, b<R, T> bVar) {
        return new C0315a(bVar, oVar);
    }
}
