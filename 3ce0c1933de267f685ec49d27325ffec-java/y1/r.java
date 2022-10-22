package y1;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.work.WorkInfo;
import f1.k;
import f1.l;
import java.util.ArrayList;
import java.util.List;
import y1.p;
/* compiled from: WorkSpecDao_Impl.java */
/* loaded from: classes.dex */
public final class r implements q {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f36715a;

    /* renamed from: b  reason: collision with root package name */
    private final f1.g<p> f36716b;

    /* renamed from: c  reason: collision with root package name */
    private final l f36717c;

    /* renamed from: d  reason: collision with root package name */
    private final l f36718d;

    /* renamed from: e  reason: collision with root package name */
    private final l f36719e;

    /* renamed from: f  reason: collision with root package name */
    private final l f36720f;

    /* renamed from: g  reason: collision with root package name */
    private final l f36721g;

    /* renamed from: h  reason: collision with root package name */
    private final l f36722h;

    /* renamed from: i  reason: collision with root package name */
    private final l f36723i;

    /* compiled from: WorkSpecDao_Impl.java */
    /* loaded from: classes.dex */
    class a extends f1.g<p> {
        a(r rVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* renamed from: m */
        public void g(i1.f fVar, p pVar) {
            String str = pVar.f36689a;
            if (str == null) {
                fVar.l0(1);
            } else {
                fVar.m(1, str);
            }
            fVar.K(2, v.j(pVar.f36690b));
            String str2 = pVar.f36691c;
            if (str2 == null) {
                fVar.l0(3);
            } else {
                fVar.m(3, str2);
            }
            String str3 = pVar.f36692d;
            if (str3 == null) {
                fVar.l0(4);
            } else {
                fVar.m(4, str3);
            }
            byte[] k10 = androidx.work.d.k(pVar.f36693e);
            if (k10 == null) {
                fVar.l0(5);
            } else {
                fVar.P(5, k10);
            }
            byte[] k11 = androidx.work.d.k(pVar.f36694f);
            if (k11 == null) {
                fVar.l0(6);
            } else {
                fVar.P(6, k11);
            }
            fVar.K(7, pVar.f36695g);
            fVar.K(8, pVar.f36696h);
            fVar.K(9, pVar.f36697i);
            fVar.K(10, pVar.f36699k);
            fVar.K(11, v.a(pVar.f36700l));
            fVar.K(12, pVar.f36701m);
            fVar.K(13, pVar.f36702n);
            fVar.K(14, pVar.f36703o);
            fVar.K(15, pVar.f36704p);
            fVar.K(16, pVar.f36705q ? 1L : 0L);
            fVar.K(17, v.i(pVar.f36706r));
            androidx.work.b bVar = pVar.f36698j;
            if (bVar != null) {
                fVar.K(18, v.h(bVar.b()));
                fVar.K(19, bVar.g() ? 1L : 0L);
                fVar.K(20, bVar.h() ? 1L : 0L);
                fVar.K(21, bVar.f() ? 1L : 0L);
                fVar.K(22, bVar.i() ? 1L : 0L);
                fVar.K(23, bVar.c());
                fVar.K(24, bVar.d());
                byte[] c10 = v.c(bVar.a());
                if (c10 == null) {
                    fVar.l0(25);
                } else {
                    fVar.P(25, c10);
                }
            } else {
                fVar.l0(18);
                fVar.l0(19);
                fVar.l0(20);
                fVar.l0(21);
                fVar.l0(22);
                fVar.l0(23);
                fVar.l0(24);
                fVar.l0(25);
            }
        }
    }

    /* compiled from: WorkSpecDao_Impl.java */
    /* loaded from: classes.dex */
    class b extends l {
        b(r rVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "DELETE FROM workspec WHERE id=?";
        }
    }

    /* compiled from: WorkSpecDao_Impl.java */
    /* loaded from: classes.dex */
    class c extends l {
        c(r rVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "UPDATE workspec SET output=? WHERE id=?";
        }
    }

    /* compiled from: WorkSpecDao_Impl.java */
    /* loaded from: classes.dex */
    class d extends l {
        d(r rVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "UPDATE workspec SET period_start_time=? WHERE id=?";
        }
    }

    /* compiled from: WorkSpecDao_Impl.java */
    /* loaded from: classes.dex */
    class e extends l {
        e(r rVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
        }
    }

    /* compiled from: WorkSpecDao_Impl.java */
    /* loaded from: classes.dex */
    class f extends l {
        f(r rVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
        }
    }

    /* compiled from: WorkSpecDao_Impl.java */
    /* loaded from: classes.dex */
    class g extends l {
        g(r rVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
        }
    }

    /* compiled from: WorkSpecDao_Impl.java */
    /* loaded from: classes.dex */
    class h extends l {
        h(r rVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
        }
    }

    /* compiled from: WorkSpecDao_Impl.java */
    /* loaded from: classes.dex */
    class i extends l {
        i(r rVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
        }
    }

    public r(RoomDatabase roomDatabase) {
        this.f36715a = roomDatabase;
        this.f36716b = new a(this, roomDatabase);
        this.f36717c = new b(this, roomDatabase);
        this.f36718d = new c(this, roomDatabase);
        this.f36719e = new d(this, roomDatabase);
        this.f36720f = new e(this, roomDatabase);
        this.f36721g = new f(this, roomDatabase);
        this.f36722h = new g(this, roomDatabase);
        this.f36723i = new h(this, roomDatabase);
        new i(this, roomDatabase);
    }

    @Override // y1.q
    public void a(String str) {
        this.f36715a.d();
        i1.f a10 = this.f36717c.a();
        if (str == null) {
            a10.l0(1);
        } else {
            a10.m(1, str);
        }
        this.f36715a.e();
        try {
            a10.r();
            this.f36715a.B();
        } finally {
            this.f36715a.i();
            this.f36717c.f(a10);
        }
    }

    @Override // y1.q
    public int b(WorkInfo.State state, String... strArr) {
        this.f36715a.d();
        StringBuilder b10 = h1.f.b();
        b10.append("UPDATE workspec SET state=");
        b10.append("?");
        b10.append(" WHERE id IN (");
        h1.f.a(b10, strArr.length);
        b10.append(")");
        i1.f f10 = this.f36715a.f(b10.toString());
        f10.K(1, v.j(state));
        int i10 = 2;
        for (String str : strArr) {
            if (str == null) {
                f10.l0(i10);
            } else {
                f10.m(i10, str);
            }
            i10++;
        }
        this.f36715a.e();
        try {
            int r10 = f10.r();
            this.f36715a.B();
            return r10;
        } finally {
            this.f36715a.i();
        }
    }

    @Override // y1.q
    public void c(p pVar) {
        this.f36715a.d();
        this.f36715a.e();
        try {
            this.f36716b.i(pVar);
            this.f36715a.B();
        } finally {
            this.f36715a.i();
        }
    }

    @Override // y1.q
    public int d(String str, long j10) {
        this.f36715a.d();
        i1.f a10 = this.f36722h.a();
        a10.K(1, j10);
        if (str == null) {
            a10.l0(2);
        } else {
            a10.m(2, str);
        }
        this.f36715a.e();
        try {
            int r10 = a10.r();
            this.f36715a.B();
            return r10;
        } finally {
            this.f36715a.i();
            this.f36722h.f(a10);
        }
    }

    @Override // y1.q
    public List<p.b> e(String str) {
        k h10 = k.h("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            h10.l0(1);
        } else {
            h10.m(1, str);
        }
        this.f36715a.d();
        Cursor b10 = h1.c.b(this.f36715a, h10, false, null);
        try {
            int e10 = h1.b.e(b10, "id");
            int e11 = h1.b.e(b10, "state");
            ArrayList arrayList = new ArrayList(b10.getCount());
            while (b10.moveToNext()) {
                p.b bVar = new p.b();
                bVar.f36707a = b10.getString(e10);
                bVar.f36708b = v.g(b10.getInt(e11));
                arrayList.add(bVar);
            }
            return arrayList;
        } finally {
            b10.close();
            h10.o();
        }
    }

    @Override // y1.q
    public List<p> f(long j10) {
        k kVar;
        Throwable th2;
        k h10 = k.h("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC", 1);
        h10.K(1, j10);
        this.f36715a.d();
        Cursor b10 = h1.c.b(this.f36715a, h10, false, null);
        try {
            int e10 = h1.b.e(b10, "required_network_type");
            int e11 = h1.b.e(b10, "requires_charging");
            int e12 = h1.b.e(b10, "requires_device_idle");
            int e13 = h1.b.e(b10, "requires_battery_not_low");
            int e14 = h1.b.e(b10, "requires_storage_not_low");
            int e15 = h1.b.e(b10, "trigger_content_update_delay");
            int e16 = h1.b.e(b10, "trigger_max_content_delay");
            int e17 = h1.b.e(b10, "content_uri_triggers");
            int e18 = h1.b.e(b10, "id");
            int e19 = h1.b.e(b10, "state");
            int e20 = h1.b.e(b10, "worker_class_name");
            int e21 = h1.b.e(b10, "input_merger_class_name");
            int e22 = h1.b.e(b10, "input");
            int e23 = h1.b.e(b10, "output");
            kVar = h10;
            try {
                int e24 = h1.b.e(b10, "initial_delay");
                int e25 = h1.b.e(b10, "interval_duration");
                int e26 = h1.b.e(b10, "flex_duration");
                int e27 = h1.b.e(b10, "run_attempt_count");
                int e28 = h1.b.e(b10, "backoff_policy");
                int e29 = h1.b.e(b10, "backoff_delay_duration");
                int e30 = h1.b.e(b10, "period_start_time");
                int e31 = h1.b.e(b10, "minimum_retention_duration");
                int e32 = h1.b.e(b10, "schedule_requested_at");
                int e33 = h1.b.e(b10, "run_in_foreground");
                int e34 = h1.b.e(b10, "out_of_quota_policy");
                int i10 = e23;
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    String string = b10.getString(e18);
                    e18 = e18;
                    String string2 = b10.getString(e20);
                    e20 = e20;
                    androidx.work.b bVar = new androidx.work.b();
                    int i11 = b10.getInt(e10);
                    e10 = e10;
                    bVar.k(v.e(i11));
                    bVar.m(b10.getInt(e11) != 0);
                    bVar.n(b10.getInt(e12) != 0);
                    bVar.l(b10.getInt(e13) != 0);
                    bVar.o(b10.getInt(e14) != 0);
                    e11 = e11;
                    e12 = e12;
                    bVar.p(b10.getLong(e15));
                    bVar.q(b10.getLong(e16));
                    bVar.j(v.b(b10.getBlob(e17)));
                    p pVar = new p(string, string2);
                    pVar.f36690b = v.g(b10.getInt(e19));
                    pVar.f36692d = b10.getString(e21);
                    pVar.f36693e = androidx.work.d.g(b10.getBlob(e22));
                    int i12 = i10;
                    pVar.f36694f = androidx.work.d.g(b10.getBlob(i12));
                    int i13 = e24;
                    i10 = i12;
                    pVar.f36695g = b10.getLong(i13);
                    e21 = e21;
                    int i14 = e25;
                    pVar.f36696h = b10.getLong(i14);
                    e13 = e13;
                    int i15 = e26;
                    pVar.f36697i = b10.getLong(i15);
                    int i16 = e27;
                    pVar.f36699k = b10.getInt(i16);
                    int i17 = e28;
                    pVar.f36700l = v.d(b10.getInt(i17));
                    e26 = i15;
                    int i18 = e29;
                    pVar.f36701m = b10.getLong(i18);
                    int i19 = e30;
                    pVar.f36702n = b10.getLong(i19);
                    e30 = i19;
                    int i20 = e31;
                    pVar.f36703o = b10.getLong(i20);
                    int i21 = e32;
                    pVar.f36704p = b10.getLong(i21);
                    int i22 = e33;
                    pVar.f36705q = b10.getInt(i22) != 0;
                    int i23 = e34;
                    pVar.f36706r = v.f(b10.getInt(i23));
                    pVar.f36698j = bVar;
                    arrayList.add(pVar);
                    e34 = i23;
                    e24 = i13;
                    e25 = i14;
                    e27 = i16;
                    e32 = i21;
                    e33 = i22;
                    e31 = i20;
                    e29 = i18;
                    e28 = i17;
                }
                b10.close();
                kVar.o();
                return arrayList;
            } catch (Throwable th3) {
                th2 = th3;
                b10.close();
                kVar.o();
                throw th2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            kVar = h10;
        }
    }

    @Override // y1.q
    public List<p> g(int i10) {
        k kVar;
        Throwable th2;
        k h10 = k.h("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        h10.K(1, i10);
        this.f36715a.d();
        Cursor b10 = h1.c.b(this.f36715a, h10, false, null);
        try {
            int e10 = h1.b.e(b10, "required_network_type");
            int e11 = h1.b.e(b10, "requires_charging");
            int e12 = h1.b.e(b10, "requires_device_idle");
            int e13 = h1.b.e(b10, "requires_battery_not_low");
            int e14 = h1.b.e(b10, "requires_storage_not_low");
            int e15 = h1.b.e(b10, "trigger_content_update_delay");
            int e16 = h1.b.e(b10, "trigger_max_content_delay");
            int e17 = h1.b.e(b10, "content_uri_triggers");
            int e18 = h1.b.e(b10, "id");
            int e19 = h1.b.e(b10, "state");
            int e20 = h1.b.e(b10, "worker_class_name");
            int e21 = h1.b.e(b10, "input_merger_class_name");
            int e22 = h1.b.e(b10, "input");
            int e23 = h1.b.e(b10, "output");
            kVar = h10;
            try {
                int e24 = h1.b.e(b10, "initial_delay");
                int e25 = h1.b.e(b10, "interval_duration");
                int e26 = h1.b.e(b10, "flex_duration");
                int e27 = h1.b.e(b10, "run_attempt_count");
                int e28 = h1.b.e(b10, "backoff_policy");
                int e29 = h1.b.e(b10, "backoff_delay_duration");
                int e30 = h1.b.e(b10, "period_start_time");
                int e31 = h1.b.e(b10, "minimum_retention_duration");
                int e32 = h1.b.e(b10, "schedule_requested_at");
                int e33 = h1.b.e(b10, "run_in_foreground");
                int e34 = h1.b.e(b10, "out_of_quota_policy");
                int i11 = e23;
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    String string = b10.getString(e18);
                    e18 = e18;
                    String string2 = b10.getString(e20);
                    e20 = e20;
                    androidx.work.b bVar = new androidx.work.b();
                    int i12 = b10.getInt(e10);
                    e10 = e10;
                    bVar.k(v.e(i12));
                    bVar.m(b10.getInt(e11) != 0);
                    bVar.n(b10.getInt(e12) != 0);
                    bVar.l(b10.getInt(e13) != 0);
                    bVar.o(b10.getInt(e14) != 0);
                    e11 = e11;
                    e12 = e12;
                    bVar.p(b10.getLong(e15));
                    bVar.q(b10.getLong(e16));
                    bVar.j(v.b(b10.getBlob(e17)));
                    p pVar = new p(string, string2);
                    pVar.f36690b = v.g(b10.getInt(e19));
                    pVar.f36692d = b10.getString(e21);
                    pVar.f36693e = androidx.work.d.g(b10.getBlob(e22));
                    int i13 = i11;
                    pVar.f36694f = androidx.work.d.g(b10.getBlob(i13));
                    i11 = i13;
                    int i14 = e24;
                    pVar.f36695g = b10.getLong(i14);
                    e21 = e21;
                    int i15 = e25;
                    pVar.f36696h = b10.getLong(i15);
                    e13 = e13;
                    int i16 = e26;
                    pVar.f36697i = b10.getLong(i16);
                    int i17 = e27;
                    pVar.f36699k = b10.getInt(i17);
                    int i18 = e28;
                    pVar.f36700l = v.d(b10.getInt(i18));
                    e26 = i16;
                    int i19 = e29;
                    pVar.f36701m = b10.getLong(i19);
                    int i20 = e30;
                    pVar.f36702n = b10.getLong(i20);
                    e30 = i20;
                    int i21 = e31;
                    pVar.f36703o = b10.getLong(i21);
                    int i22 = e32;
                    pVar.f36704p = b10.getLong(i22);
                    int i23 = e33;
                    pVar.f36705q = b10.getInt(i23) != 0;
                    int i24 = e34;
                    pVar.f36706r = v.f(b10.getInt(i24));
                    pVar.f36698j = bVar;
                    arrayList.add(pVar);
                    e34 = i24;
                    e24 = i14;
                    e25 = i15;
                    e27 = i17;
                    e32 = i22;
                    e33 = i23;
                    e31 = i21;
                    e29 = i19;
                    e28 = i18;
                }
                b10.close();
                kVar.o();
                return arrayList;
            } catch (Throwable th3) {
                th2 = th3;
                b10.close();
                kVar.o();
                throw th2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            kVar = h10;
        }
    }

    @Override // y1.q
    public List<p> h() {
        k kVar;
        Throwable th2;
        k h10 = k.h("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.f36715a.d();
        Cursor b10 = h1.c.b(this.f36715a, h10, false, null);
        try {
            int e10 = h1.b.e(b10, "required_network_type");
            int e11 = h1.b.e(b10, "requires_charging");
            int e12 = h1.b.e(b10, "requires_device_idle");
            int e13 = h1.b.e(b10, "requires_battery_not_low");
            int e14 = h1.b.e(b10, "requires_storage_not_low");
            int e15 = h1.b.e(b10, "trigger_content_update_delay");
            int e16 = h1.b.e(b10, "trigger_max_content_delay");
            int e17 = h1.b.e(b10, "content_uri_triggers");
            int e18 = h1.b.e(b10, "id");
            int e19 = h1.b.e(b10, "state");
            int e20 = h1.b.e(b10, "worker_class_name");
            int e21 = h1.b.e(b10, "input_merger_class_name");
            int e22 = h1.b.e(b10, "input");
            int e23 = h1.b.e(b10, "output");
            kVar = h10;
            try {
                int e24 = h1.b.e(b10, "initial_delay");
                int e25 = h1.b.e(b10, "interval_duration");
                int e26 = h1.b.e(b10, "flex_duration");
                int e27 = h1.b.e(b10, "run_attempt_count");
                int e28 = h1.b.e(b10, "backoff_policy");
                int e29 = h1.b.e(b10, "backoff_delay_duration");
                int e30 = h1.b.e(b10, "period_start_time");
                int e31 = h1.b.e(b10, "minimum_retention_duration");
                int e32 = h1.b.e(b10, "schedule_requested_at");
                int e33 = h1.b.e(b10, "run_in_foreground");
                int e34 = h1.b.e(b10, "out_of_quota_policy");
                int i10 = e23;
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    String string = b10.getString(e18);
                    e18 = e18;
                    String string2 = b10.getString(e20);
                    e20 = e20;
                    androidx.work.b bVar = new androidx.work.b();
                    int i11 = b10.getInt(e10);
                    e10 = e10;
                    bVar.k(v.e(i11));
                    bVar.m(b10.getInt(e11) != 0);
                    bVar.n(b10.getInt(e12) != 0);
                    bVar.l(b10.getInt(e13) != 0);
                    bVar.o(b10.getInt(e14) != 0);
                    e11 = e11;
                    e12 = e12;
                    bVar.p(b10.getLong(e15));
                    bVar.q(b10.getLong(e16));
                    bVar.j(v.b(b10.getBlob(e17)));
                    p pVar = new p(string, string2);
                    pVar.f36690b = v.g(b10.getInt(e19));
                    pVar.f36692d = b10.getString(e21);
                    pVar.f36693e = androidx.work.d.g(b10.getBlob(e22));
                    int i12 = i10;
                    pVar.f36694f = androidx.work.d.g(b10.getBlob(i12));
                    i10 = i12;
                    int i13 = e24;
                    pVar.f36695g = b10.getLong(i13);
                    e22 = e22;
                    int i14 = e25;
                    pVar.f36696h = b10.getLong(i14);
                    e13 = e13;
                    int i15 = e26;
                    pVar.f36697i = b10.getLong(i15);
                    int i16 = e27;
                    pVar.f36699k = b10.getInt(i16);
                    int i17 = e28;
                    pVar.f36700l = v.d(b10.getInt(i17));
                    e26 = i15;
                    int i18 = e29;
                    pVar.f36701m = b10.getLong(i18);
                    int i19 = e30;
                    pVar.f36702n = b10.getLong(i19);
                    e30 = i19;
                    int i20 = e31;
                    pVar.f36703o = b10.getLong(i20);
                    int i21 = e32;
                    pVar.f36704p = b10.getLong(i21);
                    int i22 = e33;
                    pVar.f36705q = b10.getInt(i22) != 0;
                    int i23 = e34;
                    pVar.f36706r = v.f(b10.getInt(i23));
                    pVar.f36698j = bVar;
                    arrayList.add(pVar);
                    e34 = i23;
                    e24 = i13;
                    e25 = i14;
                    e27 = i16;
                    e32 = i21;
                    e33 = i22;
                    e31 = i20;
                    e29 = i18;
                    e28 = i17;
                }
                b10.close();
                kVar.o();
                return arrayList;
            } catch (Throwable th3) {
                th2 = th3;
                b10.close();
                kVar.o();
                throw th2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            kVar = h10;
        }
    }

    @Override // y1.q
    public void i(String str, androidx.work.d dVar) {
        this.f36715a.d();
        i1.f a10 = this.f36718d.a();
        byte[] k10 = androidx.work.d.k(dVar);
        if (k10 == null) {
            a10.l0(1);
        } else {
            a10.P(1, k10);
        }
        if (str == null) {
            a10.l0(2);
        } else {
            a10.m(2, str);
        }
        this.f36715a.e();
        try {
            a10.r();
            this.f36715a.B();
        } finally {
            this.f36715a.i();
            this.f36718d.f(a10);
        }
    }

    @Override // y1.q
    public List<p> j() {
        k kVar;
        Throwable th2;
        k h10 = k.h("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=1", 0);
        this.f36715a.d();
        Cursor b10 = h1.c.b(this.f36715a, h10, false, null);
        try {
            int e10 = h1.b.e(b10, "required_network_type");
            int e11 = h1.b.e(b10, "requires_charging");
            int e12 = h1.b.e(b10, "requires_device_idle");
            int e13 = h1.b.e(b10, "requires_battery_not_low");
            int e14 = h1.b.e(b10, "requires_storage_not_low");
            int e15 = h1.b.e(b10, "trigger_content_update_delay");
            int e16 = h1.b.e(b10, "trigger_max_content_delay");
            int e17 = h1.b.e(b10, "content_uri_triggers");
            int e18 = h1.b.e(b10, "id");
            int e19 = h1.b.e(b10, "state");
            int e20 = h1.b.e(b10, "worker_class_name");
            int e21 = h1.b.e(b10, "input_merger_class_name");
            int e22 = h1.b.e(b10, "input");
            int e23 = h1.b.e(b10, "output");
            kVar = h10;
            try {
                int e24 = h1.b.e(b10, "initial_delay");
                int e25 = h1.b.e(b10, "interval_duration");
                int e26 = h1.b.e(b10, "flex_duration");
                int e27 = h1.b.e(b10, "run_attempt_count");
                int e28 = h1.b.e(b10, "backoff_policy");
                int e29 = h1.b.e(b10, "backoff_delay_duration");
                int e30 = h1.b.e(b10, "period_start_time");
                int e31 = h1.b.e(b10, "minimum_retention_duration");
                int e32 = h1.b.e(b10, "schedule_requested_at");
                int e33 = h1.b.e(b10, "run_in_foreground");
                int e34 = h1.b.e(b10, "out_of_quota_policy");
                int i10 = e23;
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    String string = b10.getString(e18);
                    e18 = e18;
                    String string2 = b10.getString(e20);
                    e20 = e20;
                    androidx.work.b bVar = new androidx.work.b();
                    int i11 = b10.getInt(e10);
                    e10 = e10;
                    bVar.k(v.e(i11));
                    bVar.m(b10.getInt(e11) != 0);
                    bVar.n(b10.getInt(e12) != 0);
                    bVar.l(b10.getInt(e13) != 0);
                    bVar.o(b10.getInt(e14) != 0);
                    e11 = e11;
                    e12 = e12;
                    bVar.p(b10.getLong(e15));
                    bVar.q(b10.getLong(e16));
                    bVar.j(v.b(b10.getBlob(e17)));
                    p pVar = new p(string, string2);
                    pVar.f36690b = v.g(b10.getInt(e19));
                    pVar.f36692d = b10.getString(e21);
                    pVar.f36693e = androidx.work.d.g(b10.getBlob(e22));
                    int i12 = i10;
                    pVar.f36694f = androidx.work.d.g(b10.getBlob(i12));
                    i10 = i12;
                    int i13 = e24;
                    pVar.f36695g = b10.getLong(i13);
                    e22 = e22;
                    int i14 = e25;
                    pVar.f36696h = b10.getLong(i14);
                    e13 = e13;
                    int i15 = e26;
                    pVar.f36697i = b10.getLong(i15);
                    int i16 = e27;
                    pVar.f36699k = b10.getInt(i16);
                    int i17 = e28;
                    pVar.f36700l = v.d(b10.getInt(i17));
                    e26 = i15;
                    int i18 = e29;
                    pVar.f36701m = b10.getLong(i18);
                    int i19 = e30;
                    pVar.f36702n = b10.getLong(i19);
                    e30 = i19;
                    int i20 = e31;
                    pVar.f36703o = b10.getLong(i20);
                    int i21 = e32;
                    pVar.f36704p = b10.getLong(i21);
                    int i22 = e33;
                    pVar.f36705q = b10.getInt(i22) != 0;
                    int i23 = e34;
                    pVar.f36706r = v.f(b10.getInt(i23));
                    pVar.f36698j = bVar;
                    arrayList.add(pVar);
                    e34 = i23;
                    e24 = i13;
                    e25 = i14;
                    e27 = i16;
                    e32 = i21;
                    e33 = i22;
                    e31 = i20;
                    e29 = i18;
                    e28 = i17;
                }
                b10.close();
                kVar.o();
                return arrayList;
            } catch (Throwable th3) {
                th2 = th3;
                b10.close();
                kVar.o();
                throw th2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            kVar = h10;
        }
    }

    @Override // y1.q
    public boolean k() {
        boolean z10 = false;
        k h10 = k.h("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
        this.f36715a.d();
        Cursor b10 = h1.c.b(this.f36715a, h10, false, null);
        try {
            if (b10.moveToFirst()) {
                if (b10.getInt(0) != 0) {
                    z10 = true;
                }
            }
            return z10;
        } finally {
            b10.close();
            h10.o();
        }
    }

    @Override // y1.q
    public List<String> l(String str) {
        k h10 = k.h("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            h10.l0(1);
        } else {
            h10.m(1, str);
        }
        this.f36715a.d();
        Cursor b10 = h1.c.b(this.f36715a, h10, false, null);
        try {
            ArrayList arrayList = new ArrayList(b10.getCount());
            while (b10.moveToNext()) {
                arrayList.add(b10.getString(0));
            }
            return arrayList;
        } finally {
            b10.close();
            h10.o();
        }
    }

    @Override // y1.q
    public WorkInfo.State m(String str) {
        k h10 = k.h("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            h10.l0(1);
        } else {
            h10.m(1, str);
        }
        this.f36715a.d();
        WorkInfo.State state = null;
        Cursor b10 = h1.c.b(this.f36715a, h10, false, null);
        try {
            if (b10.moveToFirst()) {
                state = v.g(b10.getInt(0));
            }
            return state;
        } finally {
            b10.close();
            h10.o();
        }
    }

    @Override // y1.q
    public p n(String str) {
        k kVar;
        Throwable th2;
        p pVar;
        k h10 = k.h("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE id=?", 1);
        if (str == null) {
            h10.l0(1);
        } else {
            h10.m(1, str);
        }
        this.f36715a.d();
        Cursor b10 = h1.c.b(this.f36715a, h10, false, null);
        try {
            int e10 = h1.b.e(b10, "required_network_type");
            int e11 = h1.b.e(b10, "requires_charging");
            int e12 = h1.b.e(b10, "requires_device_idle");
            int e13 = h1.b.e(b10, "requires_battery_not_low");
            int e14 = h1.b.e(b10, "requires_storage_not_low");
            int e15 = h1.b.e(b10, "trigger_content_update_delay");
            int e16 = h1.b.e(b10, "trigger_max_content_delay");
            int e17 = h1.b.e(b10, "content_uri_triggers");
            int e18 = h1.b.e(b10, "id");
            int e19 = h1.b.e(b10, "state");
            int e20 = h1.b.e(b10, "worker_class_name");
            int e21 = h1.b.e(b10, "input_merger_class_name");
            int e22 = h1.b.e(b10, "input");
            int e23 = h1.b.e(b10, "output");
            kVar = h10;
            try {
                int e24 = h1.b.e(b10, "initial_delay");
                int e25 = h1.b.e(b10, "interval_duration");
                int e26 = h1.b.e(b10, "flex_duration");
                int e27 = h1.b.e(b10, "run_attempt_count");
                int e28 = h1.b.e(b10, "backoff_policy");
                int e29 = h1.b.e(b10, "backoff_delay_duration");
                int e30 = h1.b.e(b10, "period_start_time");
                int e31 = h1.b.e(b10, "minimum_retention_duration");
                int e32 = h1.b.e(b10, "schedule_requested_at");
                int e33 = h1.b.e(b10, "run_in_foreground");
                int e34 = h1.b.e(b10, "out_of_quota_policy");
                if (b10.moveToFirst()) {
                    String string = b10.getString(e18);
                    String string2 = b10.getString(e20);
                    androidx.work.b bVar = new androidx.work.b();
                    bVar.k(v.e(b10.getInt(e10)));
                    bVar.m(b10.getInt(e11) != 0);
                    bVar.n(b10.getInt(e12) != 0);
                    bVar.l(b10.getInt(e13) != 0);
                    bVar.o(b10.getInt(e14) != 0);
                    bVar.p(b10.getLong(e15));
                    bVar.q(b10.getLong(e16));
                    bVar.j(v.b(b10.getBlob(e17)));
                    p pVar2 = new p(string, string2);
                    pVar2.f36690b = v.g(b10.getInt(e19));
                    pVar2.f36692d = b10.getString(e21);
                    pVar2.f36693e = androidx.work.d.g(b10.getBlob(e22));
                    pVar2.f36694f = androidx.work.d.g(b10.getBlob(e23));
                    pVar2.f36695g = b10.getLong(e24);
                    pVar2.f36696h = b10.getLong(e25);
                    pVar2.f36697i = b10.getLong(e26);
                    pVar2.f36699k = b10.getInt(e27);
                    pVar2.f36700l = v.d(b10.getInt(e28));
                    pVar2.f36701m = b10.getLong(e29);
                    pVar2.f36702n = b10.getLong(e30);
                    pVar2.f36703o = b10.getLong(e31);
                    pVar2.f36704p = b10.getLong(e32);
                    pVar2.f36705q = b10.getInt(e33) != 0;
                    pVar2.f36706r = v.f(b10.getInt(e34));
                    pVar2.f36698j = bVar;
                    pVar = pVar2;
                } else {
                    pVar = null;
                }
                b10.close();
                kVar.o();
                return pVar;
            } catch (Throwable th3) {
                th2 = th3;
                b10.close();
                kVar.o();
                throw th2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            kVar = h10;
        }
    }

    @Override // y1.q
    public int o(String str) {
        this.f36715a.d();
        i1.f a10 = this.f36721g.a();
        if (str == null) {
            a10.l0(1);
        } else {
            a10.m(1, str);
        }
        this.f36715a.e();
        try {
            int r10 = a10.r();
            this.f36715a.B();
            return r10;
        } finally {
            this.f36715a.i();
            this.f36721g.f(a10);
        }
    }

    @Override // y1.q
    public List<androidx.work.d> p(String str) {
        k h10 = k.h("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (str == null) {
            h10.l0(1);
        } else {
            h10.m(1, str);
        }
        this.f36715a.d();
        Cursor b10 = h1.c.b(this.f36715a, h10, false, null);
        try {
            ArrayList arrayList = new ArrayList(b10.getCount());
            while (b10.moveToNext()) {
                arrayList.add(androidx.work.d.g(b10.getBlob(0)));
            }
            return arrayList;
        } finally {
            b10.close();
            h10.o();
        }
    }

    @Override // y1.q
    public int q(String str) {
        this.f36715a.d();
        i1.f a10 = this.f36720f.a();
        if (str == null) {
            a10.l0(1);
        } else {
            a10.m(1, str);
        }
        this.f36715a.e();
        try {
            int r10 = a10.r();
            this.f36715a.B();
            return r10;
        } finally {
            this.f36715a.i();
            this.f36720f.f(a10);
        }
    }

    @Override // y1.q
    public void r(String str, long j10) {
        this.f36715a.d();
        i1.f a10 = this.f36719e.a();
        a10.K(1, j10);
        if (str == null) {
            a10.l0(2);
        } else {
            a10.m(2, str);
        }
        this.f36715a.e();
        try {
            a10.r();
            this.f36715a.B();
        } finally {
            this.f36715a.i();
            this.f36719e.f(a10);
        }
    }

    @Override // y1.q
    public List<p> s(int i10) {
        k kVar;
        Throwable th2;
        k h10 = k.h("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT ?", 1);
        h10.K(1, i10);
        this.f36715a.d();
        Cursor b10 = h1.c.b(this.f36715a, h10, false, null);
        try {
            int e10 = h1.b.e(b10, "required_network_type");
            int e11 = h1.b.e(b10, "requires_charging");
            int e12 = h1.b.e(b10, "requires_device_idle");
            int e13 = h1.b.e(b10, "requires_battery_not_low");
            int e14 = h1.b.e(b10, "requires_storage_not_low");
            int e15 = h1.b.e(b10, "trigger_content_update_delay");
            int e16 = h1.b.e(b10, "trigger_max_content_delay");
            int e17 = h1.b.e(b10, "content_uri_triggers");
            int e18 = h1.b.e(b10, "id");
            int e19 = h1.b.e(b10, "state");
            int e20 = h1.b.e(b10, "worker_class_name");
            int e21 = h1.b.e(b10, "input_merger_class_name");
            int e22 = h1.b.e(b10, "input");
            int e23 = h1.b.e(b10, "output");
            kVar = h10;
            try {
                int e24 = h1.b.e(b10, "initial_delay");
                int e25 = h1.b.e(b10, "interval_duration");
                int e26 = h1.b.e(b10, "flex_duration");
                int e27 = h1.b.e(b10, "run_attempt_count");
                int e28 = h1.b.e(b10, "backoff_policy");
                int e29 = h1.b.e(b10, "backoff_delay_duration");
                int e30 = h1.b.e(b10, "period_start_time");
                int e31 = h1.b.e(b10, "minimum_retention_duration");
                int e32 = h1.b.e(b10, "schedule_requested_at");
                int e33 = h1.b.e(b10, "run_in_foreground");
                int e34 = h1.b.e(b10, "out_of_quota_policy");
                int i11 = e23;
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    String string = b10.getString(e18);
                    e18 = e18;
                    String string2 = b10.getString(e20);
                    e20 = e20;
                    androidx.work.b bVar = new androidx.work.b();
                    int i12 = b10.getInt(e10);
                    e10 = e10;
                    bVar.k(v.e(i12));
                    bVar.m(b10.getInt(e11) != 0);
                    bVar.n(b10.getInt(e12) != 0);
                    bVar.l(b10.getInt(e13) != 0);
                    bVar.o(b10.getInt(e14) != 0);
                    e11 = e11;
                    e12 = e12;
                    bVar.p(b10.getLong(e15));
                    bVar.q(b10.getLong(e16));
                    bVar.j(v.b(b10.getBlob(e17)));
                    p pVar = new p(string, string2);
                    pVar.f36690b = v.g(b10.getInt(e19));
                    pVar.f36692d = b10.getString(e21);
                    pVar.f36693e = androidx.work.d.g(b10.getBlob(e22));
                    int i13 = i11;
                    pVar.f36694f = androidx.work.d.g(b10.getBlob(i13));
                    i11 = i13;
                    int i14 = e24;
                    pVar.f36695g = b10.getLong(i14);
                    e21 = e21;
                    int i15 = e25;
                    pVar.f36696h = b10.getLong(i15);
                    e13 = e13;
                    int i16 = e26;
                    pVar.f36697i = b10.getLong(i16);
                    int i17 = e27;
                    pVar.f36699k = b10.getInt(i17);
                    int i18 = e28;
                    pVar.f36700l = v.d(b10.getInt(i18));
                    e26 = i16;
                    int i19 = e29;
                    pVar.f36701m = b10.getLong(i19);
                    int i20 = e30;
                    pVar.f36702n = b10.getLong(i20);
                    e30 = i20;
                    int i21 = e31;
                    pVar.f36703o = b10.getLong(i21);
                    int i22 = e32;
                    pVar.f36704p = b10.getLong(i22);
                    int i23 = e33;
                    pVar.f36705q = b10.getInt(i23) != 0;
                    int i24 = e34;
                    pVar.f36706r = v.f(b10.getInt(i24));
                    pVar.f36698j = bVar;
                    arrayList.add(pVar);
                    e34 = i24;
                    e24 = i14;
                    e25 = i15;
                    e27 = i17;
                    e32 = i22;
                    e33 = i23;
                    e31 = i21;
                    e29 = i19;
                    e28 = i18;
                }
                b10.close();
                kVar.o();
                return arrayList;
            } catch (Throwable th3) {
                th2 = th3;
                b10.close();
                kVar.o();
                throw th2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            kVar = h10;
        }
    }

    @Override // y1.q
    public int t() {
        this.f36715a.d();
        i1.f a10 = this.f36723i.a();
        this.f36715a.e();
        try {
            int r10 = a10.r();
            this.f36715a.B();
            return r10;
        } finally {
            this.f36715a.i();
            this.f36723i.f(a10);
        }
    }
}
