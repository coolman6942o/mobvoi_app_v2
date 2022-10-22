package sc;

import java.util.List;
import kotlin.jvm.internal.i;
import rx.c;
import ta.a;
import tc.h;
import tc.j;
import tc.m;
/* compiled from: HealthDataApiHelper.kt */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final a f34376a;

    public b(a healthDataApi) {
        i.f(healthDataApi, "healthDataApi");
        this.f34376a = healthDataApi;
    }

    public final c<m> a(String wwid, boolean z10) {
        i.f(wwid, "wwid");
        return this.f34376a.d(wwid, z10);
    }

    public final c<tc.c> b() {
        String str;
        a aVar = this.f34376a;
        if (com.mobvoi.health.companion.system.c.a().p()) {
            str = com.mobvoi.health.companion.system.c.a().s(com.mobvoi.android.common.utils.b.e());
        } else {
            str = a.x();
        }
        return aVar.b(str);
    }

    public final c<h> c() {
        return this.f34376a.c("http://health.ticwear.com/user/vpa/medal/curr_high_strength", a.s());
    }

    public final c<tc.b> d(String str, String pkg, String version, String language) {
        i.f(pkg, "pkg");
        i.f(version, "version");
        i.f(language, "language");
        return this.f34376a.f(str, pkg, version, language);
    }

    public final c<j> e() {
        String str;
        a aVar = this.f34376a;
        if (com.mobvoi.health.companion.system.c.a().p()) {
            str = com.mobvoi.health.companion.system.c.a().s(com.mobvoi.android.common.utils.b.e());
        } else {
            str = a.x();
        }
        return aVar.a(str);
    }

    public final c<j> f(List<String> typeList) {
        i.f(typeList, "typeList");
        a aVar = this.f34376a;
        String x10 = a.x();
        i.e(x10, "getWwid()");
        return aVar.e(typeList, x10);
    }
}
