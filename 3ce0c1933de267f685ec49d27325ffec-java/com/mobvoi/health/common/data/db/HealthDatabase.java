package com.mobvoi.health.common.data.db;

import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.room.g0;
import com.mobvoi.android.common.utils.k;
import rf.e;
import rf.g;
/* loaded from: classes2.dex */
public abstract class HealthDatabase extends RoomDatabase {

    /* renamed from: n  reason: collision with root package name */
    private static HealthDatabase f17945n;

    /* renamed from: o  reason: collision with root package name */
    private static final g1.a f17946o = new a(1, 5);

    /* renamed from: p  reason: collision with root package name */
    private static final g1.a f17947p = new b(2, 5);

    /* renamed from: q  reason: collision with root package name */
    private static final g1.a f17948q = new c(3, 5);

    /* renamed from: r  reason: collision with root package name */
    private static final g1.a f17949r = new d(4, 5);

    /* loaded from: classes2.dex */
    class a extends g1.a {
        a(int i10, int i11) {
            super(i10, i11);
        }

        @Override // g1.a
        public void a(i1.b bVar) {
            k.a("HealthDatabase", "migrate: MIGRATION_1_5");
            try {
                bVar.l("CREATE TABLE point (`device_id` TEXT NOT NULL DEFAULT '', `wwid` TEXT, `type` INTEGER NOT NULL DEFAULT -1, `time_to` INTEGER NOT NULL, `time_from` INTEGER NOT NULL, `synced` INTEGER NOT NULL DEFAULT 0, `deleted` INTEGER NOT NULL DEFAULT 0, `_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `values` TEXT NOT NULL DEFAULT '')");
                bVar.l("CREATE TABLE session (`device_id` TEXT NOT NULL DEFAULT '', `wwid` TEXT, `type` INTEGER NOT NULL DEFAULT -1, `time_to` INTEGER NOT NULL, `time_from` INTEGER NOT NULL, `synced` INTEGER NOT NULL DEFAULT 0, `deleted` INTEGER NOT NULL DEFAULT 0, `id` TEXT NOT NULL, PRIMARY KEY(`id`))");
                bVar.l("CREATE TABLE source (`name` TEXT NOT NULL, `wwid` TEXT NOT NULL DEFAULT '', `device_id` TEXT NOT NULL DEFAULT '', `device_model` TEXT NOT NULL DEFAULT '', `device_type` TEXT, `device_version` TEXT, PRIMARY KEY(`name`))");
                bVar.l("INSERT INTO point (wwid,type,time_to,time_from,synced,_id, `values`) SELECT wwid,type,time_to,time_from,synced,_id,`values` FROM data_point");
                bVar.l("INSERT INTO session ( wwid, type, time_to, time_from, synced, id) SELECT  wwid, type, time_to, time_from, synced, id FROM data_session");
                bVar.l("DROP TABLE IF EXISTS data_source");
                bVar.l("DROP TABLE IF EXISTS data_point");
                bVar.l("DROP TABLE IF EXISTS data_session");
                bVar.l("ALTER TABLE source RENAME TO data_source");
                bVar.l("ALTER TABLE point RENAME TO data_point");
                bVar.l("ALTER TABLE session RENAME TO data_session");
                bVar.l("CREATE INDEX IF NOT EXISTS `point_query` ON `data_point` (`wwid`, `type`, `time_to`, `time_from`)");
                bVar.l("CREATE INDEX IF NOT EXISTS `point_sync` ON `data_point` (`wwid`, `type`, `synced`)");
                bVar.l("CREATE INDEX IF NOT EXISTS `session_sync` ON `data_session` (`wwid`, `type`, `synced`)");
                bVar.l("CREATE INDEX IF NOT EXISTS `session_query` ON `data_session` (`wwid`, `type`, `time_to`, `time_from`)");
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    /* loaded from: classes2.dex */
    class b extends g1.a {
        b(int i10, int i11) {
            super(i10, i11);
        }

        @Override // g1.a
        public void a(i1.b bVar) {
            k.a("HealthDatabase", "migrate: MIGRATION_2_5");
            try {
                bVar.l("CREATE TABLE point (`device_id` TEXT NOT NULL DEFAULT '', `wwid` TEXT, `type` INTEGER NOT NULL DEFAULT -1, `time_to` INTEGER NOT NULL, `time_from` INTEGER NOT NULL, `synced` INTEGER NOT NULL DEFAULT 0, `deleted` INTEGER NOT NULL DEFAULT 0, `_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `values` TEXT NOT NULL DEFAULT '')");
                bVar.l("CREATE TABLE session (`device_id` TEXT NOT NULL DEFAULT '', `wwid` TEXT, `type` INTEGER NOT NULL DEFAULT -1, `time_to` INTEGER NOT NULL, `time_from` INTEGER NOT NULL, `synced` INTEGER NOT NULL DEFAULT 0, `deleted` INTEGER NOT NULL DEFAULT 0, `id` TEXT NOT NULL, PRIMARY KEY(`id`))");
                bVar.l("CREATE TABLE source (`name` TEXT NOT NULL, `wwid` TEXT NOT NULL DEFAULT '', `device_id` TEXT NOT NULL DEFAULT '', `device_model` TEXT NOT NULL DEFAULT '', `device_type` TEXT, `device_version` TEXT, PRIMARY KEY(`name`))");
                bVar.l("INSERT INTO point (wwid,type,time_to,time_from,synced,_id, `values`) SELECT wwid,type,time_to,time_from,synced,_id,`values` FROM data_point");
                bVar.l("INSERT INTO session ( wwid, type, time_to, time_from, synced, id) SELECT  wwid, type, time_to, time_from, synced, id FROM data_session");
                bVar.l("DROP TABLE IF EXISTS data_source");
                bVar.l("DROP TABLE IF EXISTS data_point");
                bVar.l("DROP TABLE IF EXISTS data_session");
                bVar.l("ALTER TABLE source RENAME TO data_source");
                bVar.l("ALTER TABLE point RENAME TO data_point");
                bVar.l("ALTER TABLE session RENAME TO data_session");
                bVar.l("CREATE INDEX IF NOT EXISTS `point_query` ON `data_point` (`wwid`, `type`, `time_to`, `time_from`)");
                bVar.l("CREATE INDEX IF NOT EXISTS `point_sync` ON `data_point` (`wwid`, `type`, `synced`)");
                bVar.l("CREATE INDEX IF NOT EXISTS `session_sync` ON `data_session` (`wwid`, `type`, `synced`)");
                bVar.l("CREATE INDEX IF NOT EXISTS `session_query` ON `data_session` (`wwid`, `type`, `time_to`, `time_from`)");
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    /* loaded from: classes2.dex */
    class c extends g1.a {
        c(int i10, int i11) {
            super(i10, i11);
        }

        @Override // g1.a
        public void a(i1.b bVar) {
            k.a("HealthDatabase", "migrate: MIGRATION_3_5");
            try {
                bVar.l("CREATE TABLE point (`device_id` TEXT NOT NULL DEFAULT '', `wwid` TEXT, `type` INTEGER NOT NULL DEFAULT -1, `time_to` INTEGER NOT NULL, `time_from` INTEGER NOT NULL, `synced` INTEGER NOT NULL DEFAULT 0, `deleted` INTEGER NOT NULL DEFAULT 0, `_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `values` TEXT NOT NULL DEFAULT '')");
                bVar.l("CREATE TABLE session (`device_id` TEXT NOT NULL DEFAULT '', `wwid` TEXT, `type` INTEGER NOT NULL DEFAULT -1, `time_to` INTEGER NOT NULL, `time_from` INTEGER NOT NULL, `synced` INTEGER NOT NULL DEFAULT 0, `deleted` INTEGER NOT NULL DEFAULT 0, `id` TEXT NOT NULL, PRIMARY KEY(`id`))");
                bVar.l("CREATE TABLE source (`name` TEXT NOT NULL, `wwid` TEXT NOT NULL DEFAULT '', `device_id` TEXT NOT NULL DEFAULT '', `device_model` TEXT NOT NULL DEFAULT '', `device_type` TEXT, `device_version` TEXT, PRIMARY KEY(`name`))");
                bVar.l("INSERT INTO source (name, wwid, device_id,device_model,device_type,device_version) SELECT name, wwid, device_id,device_model,device_type,device_version FROM data_source");
                bVar.l("INSERT INTO point (device_id,wwid,type,time_to,time_from,synced,_id, `values`) SELECT device_id,wwid,type,time_to,time_from,synced,_id,`values` FROM data_point");
                bVar.l("INSERT INTO session (device_id, wwid, type, time_to, time_from, synced, id) SELECT device_id, wwid, type, time_to, time_from, synced, id FROM data_session");
                bVar.l("DROP TABLE IF EXISTS data_source");
                bVar.l("DROP TABLE IF EXISTS data_point");
                bVar.l("DROP TABLE IF EXISTS data_session");
                bVar.l("ALTER TABLE source RENAME TO data_source");
                bVar.l("ALTER TABLE point RENAME TO data_point");
                bVar.l("ALTER TABLE session RENAME TO data_session");
                bVar.l("CREATE INDEX IF NOT EXISTS `point_query` ON `data_point` (`wwid`, `type`, `time_to`, `time_from`)");
                bVar.l("CREATE INDEX IF NOT EXISTS `point_sync` ON `data_point` (`wwid`, `type`, `synced`)");
                bVar.l("CREATE INDEX IF NOT EXISTS `session_sync` ON `data_session` (`wwid`, `type`, `synced`)");
                bVar.l("CREATE INDEX IF NOT EXISTS `session_query` ON `data_session` (`wwid`, `type`, `time_to`, `time_from`)");
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    /* loaded from: classes2.dex */
    class d extends g1.a {
        d(int i10, int i11) {
            super(i10, i11);
        }

        @Override // g1.a
        public void a(i1.b bVar) {
            k.a("HealthDatabase", "migrate: MIGRATION_4_5");
            try {
                bVar.l("CREATE TABLE point (`device_id` TEXT NOT NULL DEFAULT '', `wwid` TEXT, `type` INTEGER NOT NULL DEFAULT -1, `time_to` INTEGER NOT NULL, `time_from` INTEGER NOT NULL, `synced` INTEGER NOT NULL DEFAULT 0, `deleted` INTEGER NOT NULL DEFAULT 0, `_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `values` TEXT NOT NULL DEFAULT '')");
                bVar.l("CREATE TABLE session (`device_id` TEXT NOT NULL DEFAULT '', `wwid` TEXT, `type` INTEGER NOT NULL DEFAULT -1, `time_to` INTEGER NOT NULL, `time_from` INTEGER NOT NULL, `synced` INTEGER NOT NULL DEFAULT 0, `deleted` INTEGER NOT NULL DEFAULT 0, `id` TEXT NOT NULL, PRIMARY KEY(`id`))");
                bVar.l("CREATE TABLE source (`name` TEXT NOT NULL, `wwid` TEXT NOT NULL DEFAULT '', `device_id` TEXT NOT NULL DEFAULT '', `device_model` TEXT NOT NULL DEFAULT '', `device_type` TEXT, `device_version` TEXT, PRIMARY KEY(`name`))");
                bVar.l("INSERT INTO source (name, wwid, device_id,device_model,device_type,device_version) SELECT name, wwid, device_id,device_model,device_type,device_version FROM data_source");
                bVar.l("INSERT INTO point (device_id,wwid,type,time_to,time_from,synced,deleted,_id, `values`) SELECT device_id,wwid,type,time_to,time_from,synced,deleted,_id,`values` FROM data_point");
                bVar.l("INSERT INTO session (device_id, wwid, type, time_to, time_from, synced, deleted, id) SELECT device_id, wwid, type, time_to, time_from, synced, deleted, id FROM data_session");
                bVar.l("DROP TABLE IF EXISTS data_source");
                bVar.l("DROP TABLE IF EXISTS data_point");
                bVar.l("DROP TABLE IF EXISTS data_session");
                bVar.l("ALTER TABLE source RENAME TO data_source");
                bVar.l("ALTER TABLE point RENAME TO data_point");
                bVar.l("ALTER TABLE session RENAME TO data_session");
                bVar.l("CREATE INDEX IF NOT EXISTS `point_query` ON `data_point` (`wwid`, `type`, `time_to`, `time_from`)");
                bVar.l("CREATE INDEX IF NOT EXISTS `point_sync` ON `data_point` (`wwid`, `type`, `synced`)");
                bVar.l("CREATE INDEX IF NOT EXISTS `session_sync` ON `data_session` (`wwid`, `type`, `synced`)");
                bVar.l("CREATE INDEX IF NOT EXISTS `session_query` ON `data_session` (`wwid`, `type`, `time_to`, `time_from`)");
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public static HealthDatabase G(Context context) {
        HealthDatabase healthDatabase = f17945n;
        if (healthDatabase == null) {
            synchronized (HealthDatabase.class) {
                healthDatabase = f17945n;
                if (healthDatabase == null) {
                    HealthDatabase healthDatabase2 = (HealthDatabase) g0.a(context.getApplicationContext(), HealthDatabase.class, "health_common.db").c().b(H()).d();
                    f17945n = healthDatabase2;
                    healthDatabase = healthDatabase2;
                }
            }
        }
        return healthDatabase;
    }

    private static g1.a[] H() {
        return new g1.a[]{f17946o, f17947p, f17948q, f17949r};
    }

    public abstract rf.b D();

    public abstract e E();

    public abstract g F();
}
