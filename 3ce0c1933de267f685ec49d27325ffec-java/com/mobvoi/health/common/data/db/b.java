package com.mobvoi.health.common.data.db;

import android.content.Context;
import android.text.TextUtils;
import com.mobvoi.health.common.data.db.DbSyncAccessor;
import com.mobvoi.health.common.data.pojo.ActivityType;
import eg.f;
import java.util.List;
import java.util.Locale;
import qf.c;
import qf.j;
import qf.k;
import rf.e;
/* compiled from: DbSessionAccessor.java */
/* loaded from: classes2.dex */
public class b implements k {

    /* renamed from: a  reason: collision with root package name */
    private e f17960a;

    /* renamed from: b  reason: collision with root package name */
    private String f17961b = "";

    private b(HealthDatabase healthDatabase) {
        this.f17960a = healthDatabase.E();
    }

    public static b l(Context context) {
        return new b(HealthDatabase.G(context));
    }

    private boolean t(c cVar, c cVar2, boolean z10) {
        if (TextUtils.equals(cVar.f33133i, cVar2.f33133i)) {
            boolean z11 = cVar.a() && cVar2.a();
            if (z10 || cVar.a()) {
                cVar.f33126b = cVar2.f33126b;
                cVar.f33125a = cVar2.f33125a;
                cVar.f33127c = cVar2.f33127c;
                cVar.f33129e = cVar2.f33129e;
                cVar.f33128d = cVar2.f33128d;
            }
            if (cVar.f33131g == 0 && cVar2.f33131g == 1) {
                cVar.f33131g = 1;
            }
            if (!z11) {
                cVar.f33130f = 0;
            }
            if (f.a.b()) {
                com.mobvoi.android.common.utils.k.p("health.db.dataSession", "update: %s", cVar);
            }
            return this.f17960a.e(cVar) == 1;
        }
        throw new RuntimeException(String.format(Locale.US, "Not same sid: %s vs. %s", cVar, cVar2));
    }

    @Override // com.mobvoi.health.common.data.db.DbSyncAccessor
    public void a() {
    }

    @Override // qf.k
    public c c(String str) {
        return this.f17960a.d(str);
    }

    @Override // com.mobvoi.health.common.data.db.DbSyncAccessor
    public /* synthetic */ void e(Enum r12, long j10, long j11) {
        j.a(this, r12, j10, j11);
    }

    @Override // com.mobvoi.health.common.data.db.DbSyncAccessor
    public /* synthetic */ List h(Enum r12, long j10, long j11) {
        return j.b(this, r12, j10, j11);
    }

    @Override // com.mobvoi.health.common.data.db.DbSyncAccessor
    public /* synthetic */ List i(String str, Enum r22, long j10, long j11) {
        return j.c(this, str, r22, j10, j11);
    }

    @Override // com.mobvoi.health.common.data.db.DbSyncAccessor
    public void k(List<c> list) {
        throw new RuntimeException("Not implemented yet");
    }

    public void m(String str) {
        this.f17961b = str;
        a();
    }

    /* renamed from: n */
    public c d(c cVar) throws NullPointerException, DbSyncAccessor.InvalidParamsException, DbSyncAccessor.TimeOverlapException {
        if (cVar.e()) {
            c c10 = c(cVar.f33133i);
            if (c10 == null) {
                this.f17960a.g(cVar);
                return cVar;
            }
            if (!c10.equals(cVar)) {
                t(c10, cVar, false);
            }
            return c10;
        }
        throw new DbSyncAccessor.InvalidParamsException(String.format(Locale.getDefault(), "%s is invalid.", cVar));
    }

    @Override // com.mobvoi.health.common.data.db.DbSyncAccessor
    public String o() {
        return this.f17961b;
    }

    public void p(String str) {
        com.mobvoi.android.common.utils.k.c("health.db.dataSession", "markAsSynced: %s, rowsUpdated: %s", str, Integer.valueOf(this.f17960a.c(str)));
    }

    /* renamed from: q */
    public List<c> g(String str, String str2, ActivityType activityType, long j10, long j11) {
        return this.f17960a.f(str, str2, activityType, j10, j11);
    }

    /* renamed from: r */
    public List<c> f(ActivityType activityType, long j10) {
        return this.f17960a.h(this.f17961b, null, activityType, j10);
    }

    /* renamed from: s */
    public boolean b(c cVar) {
        c c10 = c(cVar.f33133i);
        if (c10 == null) {
            com.mobvoi.android.common.utils.k.q("health.db.dataSession", "");
            return false;
        } else if (!c10.equals(cVar)) {
            return t(c10, cVar, true);
        } else {
            return true;
        }
    }
}
