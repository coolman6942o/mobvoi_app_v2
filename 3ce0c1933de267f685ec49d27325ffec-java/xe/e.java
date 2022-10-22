package xe;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.fitness.core.data.db.gen.FitnessDatabase;
import ef.r;
import ef.u;
import i1.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import nf.h;
import ye.b;
import ye.c;
/* compiled from: SportRecordAccessor.java */
/* loaded from: classes2.dex */
public class e implements b {

    /* renamed from: a  reason: collision with root package name */
    private final FitnessDatabase f36531a;

    /* renamed from: b  reason: collision with root package name */
    private final c f36532b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<u> f36533c = new TreeSet(u.I);

    /* renamed from: d  reason: collision with root package name */
    private final h<Collection<u>> f36534d = new nf.c();

    /* renamed from: e  reason: collision with root package name */
    private boolean f36535e = false;

    /* renamed from: f  reason: collision with root package name */
    private String f36536f;

    private e(FitnessDatabase fitnessDatabase) {
        this.f36531a = fitnessDatabase;
        this.f36532b = fitnessDatabase.F();
    }

    private d t(b bVar) {
        return new d(bVar, this.f36532b);
    }

    public static e u(FitnessDatabase fitnessDatabase) {
        return new e(fitnessDatabase);
    }

    private b v(String str) {
        if (str == null) {
            return null;
        }
        return this.f36532b.t(str);
    }

    private void y() {
        if (!x()) {
            a();
        } else {
            this.f36535e = true;
        }
    }

    private List<u> z() {
        List<b> list;
        if (TextUtils.isEmpty(this.f36536f)) {
            list = this.f36532b.c();
        } else {
            list = this.f36532b.f(this.f36536f);
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (b bVar : list) {
            u e10 = a.e(bVar);
            if (e10 != null && e10.h()) {
                arrayList.add(e10);
            }
        }
        return arrayList;
    }

    @Override // xe.b
    public void a() {
        this.f36534d.f(this.f36533c);
    }

    @Override // xe.b
    public h<Collection<u>> b() {
        this.f36533c.clear();
        this.f36533c.addAll(z());
        this.f36534d.f(this.f36533c);
        return this.f36534d;
    }

    @Override // xe.b
    public void c(String str) {
        b v10 = v(str);
        if (v10 != null) {
            k.c("fit.db.record", "deleteRecord:%s", v10.l());
            t(v10).a();
            this.f36532b.q(v10);
            this.f36533c.remove(a.e(v10));
            y();
        }
    }

    @Override // xe.b
    public void d(String str) {
        b v10 = v(str);
        if (v10 != null) {
            v10.H(true);
            this.f36532b.h(v10);
            this.f36533c.remove(a.e(v10));
            y();
        }
    }

    @Override // xe.b
    public List<u> e(Date date, Date date2, int i10, String str) {
        List<b> list;
        long currentTimeMillis = date == null ? System.currentTimeMillis() : date.getTime();
        long time = date2 == null ? 0L : date2.getTime();
        if (i10 < 0) {
            i10 = Integer.MAX_VALUE;
        }
        int i11 = i10;
        if (i11 == 0 || time > currentTimeMillis) {
            return Collections.emptyList();
        }
        if (TextUtils.isEmpty(str)) {
            list = this.f36532b.e(currentTimeMillis, time, i11);
        } else {
            list = this.f36532b.l(str, currentTimeMillis, time, i11);
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (b bVar : list) {
            u e10 = a.e(bVar);
            if (e10 != null && e10.h()) {
                arrayList.add(e10);
            }
        }
        return arrayList;
    }

    @Override // xe.b
    public void endBatchEdit() {
        this.f36531a.B();
        this.f36531a.i();
        if (this.f36535e) {
            this.f36535e = false;
            a();
        }
    }

    @Override // xe.b
    public void f(String str) {
        b v10 = v(str);
        if (v10 != null) {
            t(v10).a();
        }
    }

    @Override // xe.b
    public List<u> g(Date date, Date date2, int i10) {
        return e(date, date2, i10, this.f36536f);
    }

    @Override // xe.b
    public void h(r rVar) {
        u b10 = rVar.b();
        b h10 = a.h(b10);
        if (w(h10)) {
            k.a("fit.db.record", "跳过这条数据的插入");
            return;
        }
        h10.Q(Long.valueOf(this.f36532b.b(h10)));
        t(h10).e(rVar.a());
        if (rVar.c() && rVar.d()) {
            this.f36533c.add(b10);
            y();
        }
    }

    @Override // xe.b
    public List<r> i(String str) {
        List<b> list;
        int b10 = a.b(str);
        if (TextUtils.isEmpty(this.f36536f)) {
            list = this.f36532b.a(3);
        } else {
            list = this.f36532b.o(this.f36536f, 3);
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (b bVar : list) {
            if ((bVar.y() & b10) == 0) {
                arrayList.add(new r(a.e(bVar), t(bVar).b()));
            }
        }
        return arrayList;
    }

    @Override // xe.b
    public void j(r rVar) {
        b v10;
        u b10 = rVar.b();
        if (b10 != null && (v10 = v(b10.f25984c)) != null && !v10.e()) {
            b i10 = a.i(v10, b10);
            this.f36532b.h(i10);
            t(i10).e(rVar.a());
            if (rVar.c() && rVar.d()) {
                this.f36533c.remove(b10);
                this.f36533c.add(b10);
                y();
            }
        }
    }

    @Override // xe.b
    public boolean k(String str, String str2) {
        b v10 = v(str2);
        return (v10 == null || (a.b(str) & v10.y()) == 0) ? false : true;
    }

    @Override // xe.b
    public boolean l(String str) {
        return v(str) != null;
    }

    @Override // xe.b
    public r m(String str) {
        b v10 = v(str);
        if (v10 == null || v10.e()) {
            return null;
        }
        return new r(a.e(v10), t(v10).b());
    }

    @Override // xe.b
    public void n() {
        this.f36531a.e();
    }

    @Override // xe.b
    public List<String> o() {
        List<b> p10 = this.f36532b.p();
        ArrayList arrayList = new ArrayList(p10.size());
        for (b bVar : p10) {
            arrayList.add(bVar.l());
        }
        return arrayList;
    }

    @Override // xe.b
    public void p(String str, String str2, boolean z10) {
        b v10 = v(str2);
        if (v10 != null) {
            int y10 = v10.y();
            int b10 = a.b(str);
            v10.b0(z10 ? a.c(y10, b10) : a.a(y10, b10));
            this.f36532b.h(v10);
            if (!v10.e()) {
                u e10 = a.e(v10);
                this.f36533c.remove(e10);
                this.f36533c.add(e10);
                y();
            }
        }
    }

    @Override // xe.b
    public void q() {
        this.f36532b.s();
        this.f36532b.m();
    }

    @Override // xe.b
    public void r(String str) {
        k.c("fit.db.record", "setAccountId: %s in %s", str, this);
        if (!TextUtils.equals(this.f36536f, str)) {
            this.f36536f = str;
            s();
        }
    }

    @Override // xe.b
    public void s() {
        try {
            this.f36533c.clear();
            this.f36533c.addAll(z());
            this.f36534d.f(this.f36533c);
        } catch (Exception e10) {
            k.e("fit.db.record", "reloadSummaryCache exception!", e10);
            try {
                Application e11 = com.mobvoi.android.common.utils.b.e();
                SQLiteDatabase.deleteDatabase(e11.getDatabasePath("fitness.db"));
                new c(e11).getWritableDatabase().close();
                this.f36533c.clear();
                this.f36533c.addAll(z());
                this.f36534d.f(this.f36533c);
            } catch (SQLiteException unused) {
                k.e("fit.db.record", "reloadSummaryCache SQLiteException again!", e10);
            }
        }
    }

    public boolean w(b bVar) {
        String str;
        Object[] objArr;
        if (TextUtils.isEmpty(this.f36536f)) {
            objArr = new Object[]{Integer.valueOf(bVar.C()), bVar.s(), bVar.i(), bVar.b(), Long.valueOf(bVar.h())};
            str = "SELECT * FROM RECORD  WHERE TYPE = ? AND START_TIME = ? AND END_TIME = ? AND CALORIE = ? AND DURATION = ?";
        } else {
            objArr = new Object[]{this.f36536f, Integer.valueOf(bVar.C()), bVar.s(), bVar.i(), bVar.b(), Long.valueOf(bVar.h())};
            str = "SELECT * FROM RECORD  WHERE ACCOUNT_ID = ? AND TYPE = ? AND START_TIME = ? AND END_TIME = ? AND CALORIE = ? AND DURATION = ?";
        }
        return this.f36532b.i(new a(str, objArr)).size() > 0;
    }

    public boolean x() {
        return this.f36531a.p();
    }
}
