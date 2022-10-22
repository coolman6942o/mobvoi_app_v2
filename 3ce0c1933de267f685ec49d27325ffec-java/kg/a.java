package kg;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.e;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.health.companion.system.WearDevices;
import java.util.List;
import qf.d;
import qf.f;
import retrofit2.Call;
import wf.b;
import wf.l;
import wf.m;
import wf.n;
import yf.c;
/* compiled from: DataSourceManager.java */
/* loaded from: classes2.dex */
class a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f29881a;

    /* renamed from: b  reason: collision with root package name */
    private final uf.a f29882b;

    /* renamed from: c  reason: collision with root package name */
    private final f f29883c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(c cVar, f fVar) {
        this.f29881a = cVar.h();
        this.f29882b = cVar;
        this.f29883c = fVar;
    }

    private m a(d dVar) {
        m mVar = new m();
        mVar.type = dVar.f33138e;
        mVar.f36231id = dVar.f33136c;
        mVar.model = dVar.f33137d;
        mVar.version = dVar.f33139f;
        return mVar;
    }

    private WearDevices.b b() {
        WearDevices.b bVar = new WearDevices.b();
        bVar.f19010a = WearDevices.DeviceType.Phone;
        bVar.f19011b = e.e(this.f29881a);
        bVar.f19012c = Build.MODEL;
        bVar.f19013d = Build.VERSION.RELEASE;
        return bVar;
    }

    public m c(String str, c cVar) {
        Call<n> call;
        List<l> list;
        if (yf.a.a(str)) {
            return null;
        }
        d g10 = this.f29883c.g(str);
        if (g10 == null) {
            try {
                vf.c cVar2 = (vf.c) this.f29882b.a(vf.c.class);
                k.h("health.DataSourceMgr", " healthServer.isRequestTicCare = " + this.f29882b.b());
                k.h("health.DataSourceMgr", " syncBase.wwid = " + cVar.wwid);
                if (this.f29882b.b()) {
                    call = cVar2.a(cVar.wwid);
                } else {
                    call = cVar2.b();
                }
                n body = call.execute().body();
                if (!(body == null || !body.a() || (list = body.data_sources) == null)) {
                    for (l lVar : list) {
                        d dVar = new d();
                        dVar.f33134a = lVar.data_source_name;
                        m mVar = lVar.device;
                        dVar.f33136c = mVar.f36231id;
                        dVar.f33137d = mVar.model;
                        String str2 = mVar.type;
                        dVar.f33138e = str2;
                        dVar.f33139f = mVar.version;
                        if (TextUtils.isEmpty(str2)) {
                            dVar.f33138e = WearDevices.DeviceType.Unknown.name;
                        }
                        if (TextUtils.isEmpty(dVar.f33136c)) {
                            dVar.f33136c = "unknown";
                        }
                        if (TextUtils.isEmpty(dVar.f33137d)) {
                            dVar.f33137d = "unknown";
                        }
                        if (TextUtils.isEmpty(dVar.f33139f)) {
                            dVar.f33139f = "unknown";
                        }
                        k.i("health.net.server", "Got new data source to insert: %s", dVar);
                        d i10 = this.f29883c.i(dVar);
                        if (str.equals(i10.f33134a)) {
                            g10 = i10;
                        }
                    }
                }
            } catch (Exception e10) {
                k.e("health.net.server", "Error when request data source name", e10);
            }
        }
        if (g10 == null) {
            return null;
        }
        return a(g10);
    }

    public String d(String str) {
        WearDevices.b bVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String h10 = this.f29883c.h(str);
        if (TextUtils.isEmpty(h10)) {
            if (str.equals(e.e(this.f29881a))) {
                bVar = b();
            } else {
                bVar = com.mobvoi.health.companion.system.c.a().m(this.f29881a).a(str);
            }
            if (bVar == null) {
                k.s("health.DataSourceMgr", "No device found for ID[%s]", str);
                return null;
            }
            WearDevices.DeviceType deviceType = bVar.f19010a;
            if (deviceType == null || deviceType == WearDevices.DeviceType.Unknown || TextUtils.isEmpty(bVar.f19011b)) {
                k.s("health.DataSourceMgr", "Bad device info found: %s", bVar);
                return null;
            }
            if (TextUtils.isEmpty(bVar.f19012c)) {
                bVar.f19012c = "unknown";
            }
            if (TextUtils.isEmpty(bVar.f19013d)) {
                bVar.f19013d = "unknown";
            }
            b bVar2 = new b();
            wf.a aVar = bVar2.application;
            aVar.package_name = "com.mobvoi.fitness";
            aVar.version = "1.0";
            m mVar = bVar2.device;
            mVar.f36231id = bVar.f19011b;
            mVar.type = bVar.f19010a.name;
            mVar.model = bVar.f19012c;
            mVar.version = bVar.f19013d;
            try {
                wf.c body = ((vf.c) this.f29882b.a(vf.c.class)).c(bVar2).execute().body();
                if (body != null && body.a()) {
                    d dVar = new d();
                    dVar.f33134a = body.data_source_name;
                    dVar.f33136c = bVar.f19011b;
                    dVar.f33137d = bVar.f19012c;
                    dVar.f33138e = bVar.f19010a.name;
                    dVar.f33139f = bVar.f19013d;
                    k.i("health.net.server", "Got new data source to insert: %s", dVar);
                    return this.f29883c.i(dVar).f33134a;
                } else if (body != null) {
                    k.s("health.net.server", "Failed to create data source, error %d: %s", Integer.valueOf(body.err_code), body.err_msg);
                }
            } catch (Exception e10) {
                k.e("health.net.server", "Error when request data source name", e10);
            }
        }
        return h10;
    }
}
