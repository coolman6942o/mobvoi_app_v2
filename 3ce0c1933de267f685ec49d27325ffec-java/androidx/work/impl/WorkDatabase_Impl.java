package androidx.work.impl;

import androidx.room.RoomDatabase;
import androidx.room.h0;
import com.mobvoi.wear.contacts.ContactConstant;
import h1.c;
import h1.g;
import i1.c;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import y1.b;
import y1.e;
import y1.f;
import y1.h;
import y1.i;
import y1.k;
import y1.l;
import y1.n;
import y1.o;
import y1.q;
import y1.r;
import y1.t;
import y1.u;
/* loaded from: classes.dex */
public final class WorkDatabase_Impl extends WorkDatabase {

    /* renamed from: o  reason: collision with root package name */
    private volatile q f4749o;

    /* renamed from: p  reason: collision with root package name */
    private volatile b f4750p;

    /* renamed from: q  reason: collision with root package name */
    private volatile t f4751q;

    /* renamed from: r  reason: collision with root package name */
    private volatile h f4752r;

    /* renamed from: s  reason: collision with root package name */
    private volatile k f4753s;

    /* renamed from: t  reason: collision with root package name */
    private volatile n f4754t;

    /* renamed from: u  reason: collision with root package name */
    private volatile e f4755u;

    /* loaded from: classes.dex */
    class a extends h0.a {
        a(int i10) {
            super(i10);
        }

        @Override // androidx.room.h0.a
        public void a(i1.b bVar) {
            bVar.l("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            bVar.l("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
            bVar.l("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
            bVar.l("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `period_start_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `required_network_type` INTEGER, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB, PRIMARY KEY(`id`))");
            bVar.l("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
            bVar.l("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `WorkSpec` (`period_start_time`)");
            bVar.l("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            bVar.l("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
            bVar.l("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            bVar.l("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            bVar.l("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
            bVar.l("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            bVar.l("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            bVar.l("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            bVar.l("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c103703e120ae8cc73c9248622f3cd1e')");
        }

        @Override // androidx.room.h0.a
        public void b(i1.b bVar) {
            bVar.l("DROP TABLE IF EXISTS `Dependency`");
            bVar.l("DROP TABLE IF EXISTS `WorkSpec`");
            bVar.l("DROP TABLE IF EXISTS `WorkTag`");
            bVar.l("DROP TABLE IF EXISTS `SystemIdInfo`");
            bVar.l("DROP TABLE IF EXISTS `WorkName`");
            bVar.l("DROP TABLE IF EXISTS `WorkProgress`");
            bVar.l("DROP TABLE IF EXISTS `Preference`");
            if (((RoomDatabase) WorkDatabase_Impl.this).f4145h != null) {
                int size = ((RoomDatabase) WorkDatabase_Impl.this).f4145h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((RoomDatabase.b) ((RoomDatabase) WorkDatabase_Impl.this).f4145h.get(i10)).b(bVar);
                }
            }
        }

        @Override // androidx.room.h0.a
        protected void c(i1.b bVar) {
            if (((RoomDatabase) WorkDatabase_Impl.this).f4145h != null) {
                int size = ((RoomDatabase) WorkDatabase_Impl.this).f4145h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((RoomDatabase.b) ((RoomDatabase) WorkDatabase_Impl.this).f4145h.get(i10)).a(bVar);
                }
            }
        }

        @Override // androidx.room.h0.a
        public void d(i1.b bVar) {
            ((RoomDatabase) WorkDatabase_Impl.this).f4138a = bVar;
            bVar.l("PRAGMA foreign_keys = ON");
            WorkDatabase_Impl.this.t(bVar);
            if (((RoomDatabase) WorkDatabase_Impl.this).f4145h != null) {
                int size = ((RoomDatabase) WorkDatabase_Impl.this).f4145h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((RoomDatabase.b) ((RoomDatabase) WorkDatabase_Impl.this).f4145h.get(i10)).c(bVar);
                }
            }
        }

        @Override // androidx.room.h0.a
        public void e(i1.b bVar) {
        }

        @Override // androidx.room.h0.a
        public void f(i1.b bVar) {
            c.a(bVar);
        }

        @Override // androidx.room.h0.a
        protected h0.b g(i1.b bVar) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("work_spec_id", new g.a("work_spec_id", "TEXT", true, 1, null, 1));
            hashMap.put("prerequisite_id", new g.a("prerequisite_id", "TEXT", true, 2, null, 1));
            HashSet hashSet = new HashSet(2);
            hashSet.add(new g.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            hashSet.add(new g.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("prerequisite_id"), Arrays.asList("id")));
            HashSet hashSet2 = new HashSet(2);
            hashSet2.add(new g.d("index_Dependency_work_spec_id", false, Arrays.asList("work_spec_id")));
            hashSet2.add(new g.d("index_Dependency_prerequisite_id", false, Arrays.asList("prerequisite_id")));
            g gVar = new g("Dependency", hashMap, hashSet, hashSet2);
            g a10 = g.a(bVar, "Dependency");
            if (!gVar.equals(a10)) {
                return new h0.b(false, "Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + gVar + "\n Found:\n" + a10);
            }
            HashMap hashMap2 = new HashMap(25);
            hashMap2.put("id", new g.a("id", "TEXT", true, 1, null, 1));
            hashMap2.put("state", new g.a("state", "INTEGER", true, 0, null, 1));
            hashMap2.put("worker_class_name", new g.a("worker_class_name", "TEXT", true, 0, null, 1));
            hashMap2.put("input_merger_class_name", new g.a("input_merger_class_name", "TEXT", false, 0, null, 1));
            hashMap2.put("input", new g.a("input", "BLOB", true, 0, null, 1));
            hashMap2.put("output", new g.a("output", "BLOB", true, 0, null, 1));
            hashMap2.put("initial_delay", new g.a("initial_delay", "INTEGER", true, 0, null, 1));
            hashMap2.put("interval_duration", new g.a("interval_duration", "INTEGER", true, 0, null, 1));
            hashMap2.put("flex_duration", new g.a("flex_duration", "INTEGER", true, 0, null, 1));
            hashMap2.put("run_attempt_count", new g.a("run_attempt_count", "INTEGER", true, 0, null, 1));
            hashMap2.put("backoff_policy", new g.a("backoff_policy", "INTEGER", true, 0, null, 1));
            hashMap2.put("backoff_delay_duration", new g.a("backoff_delay_duration", "INTEGER", true, 0, null, 1));
            hashMap2.put("period_start_time", new g.a("period_start_time", "INTEGER", true, 0, null, 1));
            hashMap2.put("minimum_retention_duration", new g.a("minimum_retention_duration", "INTEGER", true, 0, null, 1));
            hashMap2.put("schedule_requested_at", new g.a("schedule_requested_at", "INTEGER", true, 0, null, 1));
            hashMap2.put("run_in_foreground", new g.a("run_in_foreground", "INTEGER", true, 0, null, 1));
            hashMap2.put("out_of_quota_policy", new g.a("out_of_quota_policy", "INTEGER", true, 0, null, 1));
            hashMap2.put("required_network_type", new g.a("required_network_type", "INTEGER", false, 0, null, 1));
            hashMap2.put("requires_charging", new g.a("requires_charging", "INTEGER", true, 0, null, 1));
            hashMap2.put("requires_device_idle", new g.a("requires_device_idle", "INTEGER", true, 0, null, 1));
            hashMap2.put("requires_battery_not_low", new g.a("requires_battery_not_low", "INTEGER", true, 0, null, 1));
            hashMap2.put("requires_storage_not_low", new g.a("requires_storage_not_low", "INTEGER", true, 0, null, 1));
            hashMap2.put("trigger_content_update_delay", new g.a("trigger_content_update_delay", "INTEGER", true, 0, null, 1));
            hashMap2.put("trigger_max_content_delay", new g.a("trigger_max_content_delay", "INTEGER", true, 0, null, 1));
            hashMap2.put("content_uri_triggers", new g.a("content_uri_triggers", "BLOB", false, 0, null, 1));
            HashSet hashSet3 = new HashSet(0);
            HashSet hashSet4 = new HashSet(2);
            hashSet4.add(new g.d("index_WorkSpec_schedule_requested_at", false, Arrays.asList("schedule_requested_at")));
            hashSet4.add(new g.d("index_WorkSpec_period_start_time", false, Arrays.asList("period_start_time")));
            g gVar2 = new g("WorkSpec", hashMap2, hashSet3, hashSet4);
            g a11 = g.a(bVar, "WorkSpec");
            if (!gVar2.equals(a11)) {
                return new h0.b(false, "WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + gVar2 + "\n Found:\n" + a11);
            }
            HashMap hashMap3 = new HashMap(2);
            hashMap3.put("tag", new g.a("tag", "TEXT", true, 1, null, 1));
            hashMap3.put("work_spec_id", new g.a("work_spec_id", "TEXT", true, 2, null, 1));
            HashSet hashSet5 = new HashSet(1);
            hashSet5.add(new g.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            HashSet hashSet6 = new HashSet(1);
            hashSet6.add(new g.d("index_WorkTag_work_spec_id", false, Arrays.asList("work_spec_id")));
            g gVar3 = new g("WorkTag", hashMap3, hashSet5, hashSet6);
            g a12 = g.a(bVar, "WorkTag");
            if (!gVar3.equals(a12)) {
                return new h0.b(false, "WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + gVar3 + "\n Found:\n" + a12);
            }
            HashMap hashMap4 = new HashMap(2);
            hashMap4.put("work_spec_id", new g.a("work_spec_id", "TEXT", true, 1, null, 1));
            hashMap4.put("system_id", new g.a("system_id", "INTEGER", true, 0, null, 1));
            HashSet hashSet7 = new HashSet(1);
            hashSet7.add(new g.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            g gVar4 = new g("SystemIdInfo", hashMap4, hashSet7, new HashSet(0));
            g a13 = g.a(bVar, "SystemIdInfo");
            if (!gVar4.equals(a13)) {
                return new h0.b(false, "SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + gVar4 + "\n Found:\n" + a13);
            }
            HashMap hashMap5 = new HashMap(2);
            hashMap5.put(ContactConstant.CallsRecordKeys.NAME, new g.a(ContactConstant.CallsRecordKeys.NAME, "TEXT", true, 1, null, 1));
            hashMap5.put("work_spec_id", new g.a("work_spec_id", "TEXT", true, 2, null, 1));
            HashSet hashSet8 = new HashSet(1);
            hashSet8.add(new g.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            HashSet hashSet9 = new HashSet(1);
            hashSet9.add(new g.d("index_WorkName_work_spec_id", false, Arrays.asList("work_spec_id")));
            g gVar5 = new g("WorkName", hashMap5, hashSet8, hashSet9);
            g a14 = g.a(bVar, "WorkName");
            if (!gVar5.equals(a14)) {
                return new h0.b(false, "WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + gVar5 + "\n Found:\n" + a14);
            }
            HashMap hashMap6 = new HashMap(2);
            hashMap6.put("work_spec_id", new g.a("work_spec_id", "TEXT", true, 1, null, 1));
            hashMap6.put("progress", new g.a("progress", "BLOB", true, 0, null, 1));
            HashSet hashSet10 = new HashSet(1);
            hashSet10.add(new g.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            g gVar6 = new g("WorkProgress", hashMap6, hashSet10, new HashSet(0));
            g a15 = g.a(bVar, "WorkProgress");
            if (!gVar6.equals(a15)) {
                return new h0.b(false, "WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + gVar6 + "\n Found:\n" + a15);
            }
            HashMap hashMap7 = new HashMap(2);
            hashMap7.put("key", new g.a("key", "TEXT", true, 1, null, 1));
            hashMap7.put("long_value", new g.a("long_value", "INTEGER", false, 0, null, 1));
            g gVar7 = new g("Preference", hashMap7, new HashSet(0), new HashSet(0));
            g a16 = g.a(bVar, "Preference");
            if (gVar7.equals(a16)) {
                return new h0.b(true, null);
            }
            return new h0.b(false, "Preference(androidx.work.impl.model.Preference).\n Expected:\n" + gVar7 + "\n Found:\n" + a16);
        }
    }

    @Override // androidx.work.impl.WorkDatabase
    public b E() {
        b bVar;
        if (this.f4750p != null) {
            return this.f4750p;
        }
        synchronized (this) {
            if (this.f4750p == null) {
                this.f4750p = new y1.c(this);
            }
            bVar = this.f4750p;
        }
        return bVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public e I() {
        e eVar;
        if (this.f4755u != null) {
            return this.f4755u;
        }
        synchronized (this) {
            if (this.f4755u == null) {
                this.f4755u = new f(this);
            }
            eVar = this.f4755u;
        }
        return eVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public h J() {
        h hVar;
        if (this.f4752r != null) {
            return this.f4752r;
        }
        synchronized (this) {
            if (this.f4752r == null) {
                this.f4752r = new i(this);
            }
            hVar = this.f4752r;
        }
        return hVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public k K() {
        k kVar;
        if (this.f4753s != null) {
            return this.f4753s;
        }
        synchronized (this) {
            if (this.f4753s == null) {
                this.f4753s = new l(this);
            }
            kVar = this.f4753s;
        }
        return kVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public n L() {
        n nVar;
        if (this.f4754t != null) {
            return this.f4754t;
        }
        synchronized (this) {
            if (this.f4754t == null) {
                this.f4754t = new o(this);
            }
            nVar = this.f4754t;
        }
        return nVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public q M() {
        q qVar;
        if (this.f4749o != null) {
            return this.f4749o;
        }
        synchronized (this) {
            if (this.f4749o == null) {
                this.f4749o = new r(this);
            }
            qVar = this.f4749o;
        }
        return qVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public t N() {
        t tVar;
        if (this.f4751q != null) {
            return this.f4751q;
        }
        synchronized (this) {
            if (this.f4751q == null) {
                this.f4751q = new u(this);
            }
            tVar = this.f4751q;
        }
        return tVar;
    }

    @Override // androidx.room.RoomDatabase
    protected androidx.room.o g() {
        return new androidx.room.o(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    @Override // androidx.room.RoomDatabase
    protected i1.c h(androidx.room.i iVar) {
        return iVar.f4229a.a(c.b.a(iVar.f4230b).c(iVar.f4231c).b(new h0(iVar, new a(12), "c103703e120ae8cc73c9248622f3cd1e", "49f946663a8deb7054212b8adda248c6")).a());
    }
}
