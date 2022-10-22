package qf;

import android.content.Context;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.health.common.data.db.HealthDatabase;
import java.util.HashMap;
import java.util.Map;
import rf.g;
/* compiled from: DbDataSourceAccessor.java */
/* loaded from: classes2.dex */
public class f implements e {

    /* renamed from: a  reason: collision with root package name */
    private g f33140a;

    /* renamed from: b  reason: collision with root package name */
    private String f33141b = "";

    /* renamed from: c  reason: collision with root package name */
    private Map<String, d> f33142c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private Map<String, d> f33143d = new HashMap();

    public f(Context context) {
        this.f33140a = HealthDatabase.G(context).F();
    }

    private void b(d dVar, boolean z10) {
        k.c("health.db.dataSource", "cache: %s, copy: %s", dVar, Boolean.valueOf(z10));
        if (z10) {
            dVar = new d(dVar);
        }
        this.f33142c.put(dVar.f33134a, dVar);
        this.f33143d.put(dVar.f33136c, dVar);
    }

    @Override // qf.e
    public d a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        d e10 = e(str, true);
        if (e10 == null) {
            e10 = this.f33140a.c(this.f33141b, str);
            k.c("health.db.dataSource", "loaded from DB: %s for deviceId[%s] and wwid=[%s]", e10, str, this.f33141b);
            if (e10 != null) {
                b(e10, true);
            }
        }
        return e10;
    }

    void c() {
        this.f33142c.clear();
        this.f33143d.clear();
    }

    public void d(String str) {
        if (!str.isEmpty() && !str.equals(this.f33141b)) {
            c();
        }
        this.f33141b = str;
    }

    d e(String str, boolean z10) {
        d dVar = this.f33143d.get(str);
        return (dVar == null || !z10) ? dVar : new d(dVar);
    }

    d f(String str, boolean z10) {
        d dVar = this.f33142c.get(str);
        return (dVar == null || !z10) ? dVar : new d(dVar);
    }

    public d g(String str) {
        if (str == null) {
            return null;
        }
        d f10 = f(str, true);
        if (f10 == null) {
            f10 = this.f33140a.b(str);
            k.c("health.db.dataSource", "loaded from DB: %s for name[%s]", f10, str);
            if (f10 != null) {
                b(f10, true);
            }
        }
        return f10;
    }

    public String h(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        d e10 = e(str, false);
        if (e10 == null) {
            e10 = this.f33140a.c(this.f33141b, str);
            k.c("health.db.dataSource", "loaded from DB: %s for deviceId[%s] and wwid=[%s]", e10, str, this.f33141b);
            if (e10 != null) {
                b(e10, false);
            }
        }
        if (e10 == null) {
            return null;
        }
        return e10.f33134a;
    }

    public d i(d dVar) {
        k.c("health.db.dataSource", "insert: %s", dVar);
        dVar.f33135b = this.f33141b;
        b(dVar, true);
        this.f33140a.a(dVar);
        return dVar;
    }
}
