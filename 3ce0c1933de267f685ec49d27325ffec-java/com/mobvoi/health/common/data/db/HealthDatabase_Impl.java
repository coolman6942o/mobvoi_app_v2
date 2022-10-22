package com.mobvoi.health.common.data.db;

import androidx.room.RoomDatabase;
import androidx.room.h0;
import androidx.room.i;
import androidx.room.o;
import com.mobvoi.wear.common.base.Constants;
import com.mobvoi.wear.contacts.ContactConstant;
import h1.c;
import h1.g;
import i1.c;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import rf.b;
import rf.e;
import rf.f;
import rf.g;
import rf.h;
/* loaded from: classes2.dex */
public final class HealthDatabase_Impl extends HealthDatabase {

    /* renamed from: s  reason: collision with root package name */
    private volatile b f17950s;

    /* renamed from: t  reason: collision with root package name */
    private volatile e f17951t;

    /* renamed from: u  reason: collision with root package name */
    private volatile g f17952u;

    /* loaded from: classes2.dex */
    class a extends h0.a {
        a(int i10) {
            super(i10);
        }

        @Override // androidx.room.h0.a
        public void a(i1.b bVar) {
            bVar.l("CREATE TABLE IF NOT EXISTS `data_point` (`device_id` TEXT NOT NULL DEFAULT '', `wwid` TEXT, `type` INTEGER NOT NULL DEFAULT -1, `time_to` INTEGER NOT NULL, `time_from` INTEGER NOT NULL, `synced` INTEGER NOT NULL DEFAULT 0, `deleted` INTEGER NOT NULL DEFAULT 0, `_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `values` TEXT NOT NULL DEFAULT '')");
            bVar.l("CREATE INDEX IF NOT EXISTS `point_query` ON `data_point` (`wwid`, `type`, `time_to`, `time_from`)");
            bVar.l("CREATE INDEX IF NOT EXISTS `point_sync` ON `data_point` (`wwid`, `type`, `synced`)");
            bVar.l("CREATE TABLE IF NOT EXISTS `data_session` (`device_id` TEXT NOT NULL DEFAULT '', `wwid` TEXT, `type` INTEGER NOT NULL DEFAULT -1, `time_to` INTEGER NOT NULL, `time_from` INTEGER NOT NULL, `synced` INTEGER NOT NULL DEFAULT 0, `deleted` INTEGER NOT NULL DEFAULT 0, `id` TEXT NOT NULL, PRIMARY KEY(`id`))");
            bVar.l("CREATE INDEX IF NOT EXISTS `session_sync` ON `data_session` (`wwid`, `type`, `synced`)");
            bVar.l("CREATE INDEX IF NOT EXISTS `session_query` ON `data_session` (`wwid`, `type`, `time_to`, `time_from`)");
            bVar.l("CREATE TABLE IF NOT EXISTS `data_source` (`name` TEXT NOT NULL, `wwid` TEXT NOT NULL DEFAULT '', `device_id` TEXT NOT NULL DEFAULT '', `device_model` TEXT NOT NULL DEFAULT '', `device_type` TEXT, `device_version` TEXT, PRIMARY KEY(`name`))");
            bVar.l("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            bVar.l("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '993724866f858147fc2b385340b6c6a2')");
        }

        @Override // androidx.room.h0.a
        public void b(i1.b bVar) {
            bVar.l("DROP TABLE IF EXISTS `data_point`");
            bVar.l("DROP TABLE IF EXISTS `data_session`");
            bVar.l("DROP TABLE IF EXISTS `data_source`");
            if (((RoomDatabase) HealthDatabase_Impl.this).f4145h != null) {
                int size = ((RoomDatabase) HealthDatabase_Impl.this).f4145h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((RoomDatabase.b) ((RoomDatabase) HealthDatabase_Impl.this).f4145h.get(i10)).b(bVar);
                }
            }
        }

        @Override // androidx.room.h0.a
        protected void c(i1.b bVar) {
            if (((RoomDatabase) HealthDatabase_Impl.this).f4145h != null) {
                int size = ((RoomDatabase) HealthDatabase_Impl.this).f4145h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((RoomDatabase.b) ((RoomDatabase) HealthDatabase_Impl.this).f4145h.get(i10)).a(bVar);
                }
            }
        }

        @Override // androidx.room.h0.a
        public void d(i1.b bVar) {
            ((RoomDatabase) HealthDatabase_Impl.this).f4138a = bVar;
            HealthDatabase_Impl.this.t(bVar);
            if (((RoomDatabase) HealthDatabase_Impl.this).f4145h != null) {
                int size = ((RoomDatabase) HealthDatabase_Impl.this).f4145h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((RoomDatabase.b) ((RoomDatabase) HealthDatabase_Impl.this).f4145h.get(i10)).c(bVar);
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
            HashMap hashMap = new HashMap(9);
            hashMap.put("device_id", new g.a("device_id", "TEXT", true, 0, "''", 1));
            hashMap.put("wwid", new g.a("wwid", "TEXT", false, 0, null, 1));
            hashMap.put("type", new g.a("type", "INTEGER", true, 0, "-1", 1));
            hashMap.put(Constants.Fitness.DATA_TIME_TO, new g.a(Constants.Fitness.DATA_TIME_TO, "INTEGER", true, 0, null, 1));
            hashMap.put(Constants.Fitness.DATA_TIME_FROM, new g.a(Constants.Fitness.DATA_TIME_FROM, "INTEGER", true, 0, null, 1));
            hashMap.put("synced", new g.a("synced", "INTEGER", true, 0, "0", 1));
            hashMap.put("deleted", new g.a("deleted", "INTEGER", true, 0, "0", 1));
            hashMap.put("_id", new g.a("_id", "INTEGER", true, 1, null, 1));
            hashMap.put("values", new g.a("values", "TEXT", true, 0, "''", 1));
            HashSet hashSet = new HashSet(0);
            HashSet hashSet2 = new HashSet(2);
            hashSet2.add(new g.d("point_query", false, Arrays.asList("wwid", "type", Constants.Fitness.DATA_TIME_TO, Constants.Fitness.DATA_TIME_FROM)));
            hashSet2.add(new g.d("point_sync", false, Arrays.asList("wwid", "type", "synced")));
            h1.g gVar = new h1.g("data_point", hashMap, hashSet, hashSet2);
            h1.g a10 = h1.g.a(bVar, "data_point");
            if (!gVar.equals(a10)) {
                return new h0.b(false, "data_point(com.mobvoi.health.common.data.db.DataPoint).\n Expected:\n" + gVar + "\n Found:\n" + a10);
            }
            HashMap hashMap2 = new HashMap(8);
            hashMap2.put("device_id", new g.a("device_id", "TEXT", true, 0, "''", 1));
            hashMap2.put("wwid", new g.a("wwid", "TEXT", false, 0, null, 1));
            hashMap2.put("type", new g.a("type", "INTEGER", true, 0, "-1", 1));
            hashMap2.put(Constants.Fitness.DATA_TIME_TO, new g.a(Constants.Fitness.DATA_TIME_TO, "INTEGER", true, 0, null, 1));
            hashMap2.put(Constants.Fitness.DATA_TIME_FROM, new g.a(Constants.Fitness.DATA_TIME_FROM, "INTEGER", true, 0, null, 1));
            hashMap2.put("synced", new g.a("synced", "INTEGER", true, 0, "0", 1));
            hashMap2.put("deleted", new g.a("deleted", "INTEGER", true, 0, "0", 1));
            hashMap2.put("id", new g.a("id", "TEXT", true, 1, null, 1));
            HashSet hashSet3 = new HashSet(0);
            HashSet hashSet4 = new HashSet(2);
            hashSet4.add(new g.d("session_sync", false, Arrays.asList("wwid", "type", "synced")));
            hashSet4.add(new g.d("session_query", false, Arrays.asList("wwid", "type", Constants.Fitness.DATA_TIME_TO, Constants.Fitness.DATA_TIME_FROM)));
            h1.g gVar2 = new h1.g("data_session", hashMap2, hashSet3, hashSet4);
            h1.g a11 = h1.g.a(bVar, "data_session");
            if (!gVar2.equals(a11)) {
                return new h0.b(false, "data_session(com.mobvoi.health.common.data.db.DataSession).\n Expected:\n" + gVar2 + "\n Found:\n" + a11);
            }
            HashMap hashMap3 = new HashMap(6);
            hashMap3.put(ContactConstant.CallsRecordKeys.NAME, new g.a(ContactConstant.CallsRecordKeys.NAME, "TEXT", true, 1, null, 1));
            hashMap3.put("wwid", new g.a("wwid", "TEXT", true, 0, "''", 1));
            hashMap3.put("device_id", new g.a("device_id", "TEXT", true, 0, "''", 1));
            hashMap3.put("device_model", new g.a("device_model", "TEXT", true, 0, "''", 1));
            hashMap3.put("device_type", new g.a("device_type", "TEXT", false, 0, null, 1));
            hashMap3.put("device_version", new g.a("device_version", "TEXT", false, 0, null, 1));
            h1.g gVar3 = new h1.g("data_source", hashMap3, new HashSet(0), new HashSet(0));
            h1.g a12 = h1.g.a(bVar, "data_source");
            if (gVar3.equals(a12)) {
                return new h0.b(true, null);
            }
            return new h0.b(false, "data_source(com.mobvoi.health.common.data.db.DataSource).\n Expected:\n" + gVar3 + "\n Found:\n" + a12);
        }
    }

    @Override // com.mobvoi.health.common.data.db.HealthDatabase
    public b D() {
        b bVar;
        if (this.f17950s != null) {
            return this.f17950s;
        }
        synchronized (this) {
            if (this.f17950s == null) {
                this.f17950s = new rf.c(this);
            }
            bVar = this.f17950s;
        }
        return bVar;
    }

    @Override // com.mobvoi.health.common.data.db.HealthDatabase
    public e E() {
        e eVar;
        if (this.f17951t != null) {
            return this.f17951t;
        }
        synchronized (this) {
            if (this.f17951t == null) {
                this.f17951t = new f(this);
            }
            eVar = this.f17951t;
        }
        return eVar;
    }

    @Override // com.mobvoi.health.common.data.db.HealthDatabase
    public rf.g F() {
        rf.g gVar;
        if (this.f17952u != null) {
            return this.f17952u;
        }
        synchronized (this) {
            if (this.f17952u == null) {
                this.f17952u = new h(this);
            }
            gVar = this.f17952u;
        }
        return gVar;
    }

    @Override // androidx.room.RoomDatabase
    protected o g() {
        return new o(this, new HashMap(0), new HashMap(0), "data_point", "data_session", "data_source");
    }

    @Override // androidx.room.RoomDatabase
    protected i1.c h(i iVar) {
        return iVar.f4229a.a(c.b.a(iVar.f4230b).c(iVar.f4231c).b(new h0(iVar, new a(5), "993724866f858147fc2b385340b6c6a2", "1cc050c5261cfdbe0bc233706aca1f83")).a());
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> n() {
        HashMap hashMap = new HashMap();
        hashMap.put(b.class, rf.c.u());
        hashMap.put(e.class, f.j());
        hashMap.put(rf.g.class, h.d());
        return hashMap;
    }
}
