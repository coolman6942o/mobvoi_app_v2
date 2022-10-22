package androidx.work.impl;

import android.content.Context;
import android.os.Build;
/* compiled from: WorkDatabaseMigrations.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static g1.a f4757a = new C0055a(1, 2);

    /* renamed from: b  reason: collision with root package name */
    public static g1.a f4758b = new b(3, 4);

    /* renamed from: c  reason: collision with root package name */
    public static g1.a f4759c = new c(4, 5);

    /* renamed from: d  reason: collision with root package name */
    public static g1.a f4760d = new d(6, 7);

    /* renamed from: e  reason: collision with root package name */
    public static g1.a f4761e = new e(7, 8);

    /* renamed from: f  reason: collision with root package name */
    public static g1.a f4762f = new f(8, 9);

    /* renamed from: g  reason: collision with root package name */
    public static g1.a f4763g = new g(11, 12);

    /* compiled from: WorkDatabaseMigrations.java */
    /* renamed from: androidx.work.impl.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0055a extends g1.a {
        C0055a(int i10, int i11) {
            super(i10, i11);
        }

        @Override // g1.a
        public void a(i1.b bVar) {
            bVar.l("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            bVar.l("INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo");
            bVar.l("DROP TABLE IF EXISTS alarmInfo");
            bVar.l("INSERT OR IGNORE INTO worktag(tag, work_spec_id) SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec");
        }
    }

    /* compiled from: WorkDatabaseMigrations.java */
    /* loaded from: classes.dex */
    class b extends g1.a {
        b(int i10, int i11) {
            super(i10, i11);
        }

        @Override // g1.a
        public void a(i1.b bVar) {
            if (Build.VERSION.SDK_INT >= 23) {
                bVar.l("UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0");
            }
        }
    }

    /* compiled from: WorkDatabaseMigrations.java */
    /* loaded from: classes.dex */
    class c extends g1.a {
        c(int i10, int i11) {
            super(i10, i11);
        }

        @Override // g1.a
        public void a(i1.b bVar) {
            bVar.l("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
            bVar.l("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
        }
    }

    /* compiled from: WorkDatabaseMigrations.java */
    /* loaded from: classes.dex */
    class d extends g1.a {
        d(int i10, int i11) {
            super(i10, i11);
        }

        @Override // g1.a
        public void a(i1.b bVar) {
            bVar.l("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        }
    }

    /* compiled from: WorkDatabaseMigrations.java */
    /* loaded from: classes.dex */
    class e extends g1.a {
        e(int i10, int i11) {
            super(i10, i11);
        }

        @Override // g1.a
        public void a(i1.b bVar) {
            bVar.l("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec` (`period_start_time`)");
        }
    }

    /* compiled from: WorkDatabaseMigrations.java */
    /* loaded from: classes.dex */
    class f extends g1.a {
        f(int i10, int i11) {
            super(i10, i11);
        }

        @Override // g1.a
        public void a(i1.b bVar) {
            bVar.l("ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* compiled from: WorkDatabaseMigrations.java */
    /* loaded from: classes.dex */
    class g extends g1.a {
        g(int i10, int i11) {
            super(i10, i11);
        }

        @Override // g1.a
        public void a(i1.b bVar) {
            bVar.l("ALTER TABLE workspec ADD COLUMN `out_of_quota_policy` INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* compiled from: WorkDatabaseMigrations.java */
    /* loaded from: classes.dex */
    public static class h extends g1.a {

        /* renamed from: c  reason: collision with root package name */
        final Context f4764c;

        public h(Context context, int i10, int i11) {
            super(i10, i11);
            this.f4764c = context;
        }

        @Override // g1.a
        public void a(i1.b bVar) {
            if (this.f27193b >= 10) {
                bVar.M("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", 1});
            } else {
                this.f4764c.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
            }
        }
    }

    /* compiled from: WorkDatabaseMigrations.java */
    /* loaded from: classes.dex */
    public static class i extends g1.a {

        /* renamed from: c  reason: collision with root package name */
        final Context f4765c;

        public i(Context context) {
            super(9, 10);
            this.f4765c = context;
        }

        @Override // g1.a
        public void a(i1.b bVar) {
            bVar.l("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            z1.e.b(this.f4765c, bVar);
            z1.c.a(this.f4765c, bVar);
        }
    }
}
