package com.mobvoi.fitness.core.data.db.gen;

import androidx.room.RoomDatabase;
import androidx.room.h0;
import androidx.room.i;
import androidx.room.o;
import h1.g;
import i1.b;
import i1.c;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import ye.c;
import ye.d;
/* loaded from: classes2.dex */
public final class FitnessDatabase_Impl extends FitnessDatabase {

    /* renamed from: y  reason: collision with root package name */
    private volatile c f17916y;

    /* loaded from: classes2.dex */
    class a extends h0.a {
        a(int i10) {
            super(i10);
        }

        @Override // androidx.room.h0.a
        public void a(b bVar) {
            bVar.l("CREATE TABLE IF NOT EXISTS `POINT` (`_id` INTEGER, `TIME` INTEGER NOT NULL, `HEART` INTEGER, `STEP` INTEGER, `LAT` REAL NOT NULL, `LON` REAL NOT NULL, `ACC` REAL NOT NULL, `DISTANCE` INTEGER, `SPEED` REAL, `CALORIE` REAL, `RECORD_ID` INTEGER, `RESUME` INTEGER, `SWIM_TRIPS` REAL, `SWIM_DISTANCE` INTEGER, `SWIM_STROKE` INTEGER, `SWIM_TYPE` INTEGER, `TIMESTAMP` INTEGER NOT NULL, `ELEVATION` REAL, PRIMARY KEY(`_id`))");
            bVar.l("CREATE TABLE IF NOT EXISTS `RECORD` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `HASH` TEXT, `TYPE` INTEGER NOT NULL, `TARGET_TYPE` INTEGER, `TARGET_VALUE` REAL, `ACCOUNT_ID` TEXT, `SYNCED` INTEGER NOT NULL, `DELETED` INTEGER NOT NULL, `START_TIME` INTEGER, `END_TIME` INTEGER, `TIMESTAMP` INTEGER, `DURATION` INTEGER NOT NULL, `DISTANCE` INTEGER, `CALORIE` REAL, `STEP` INTEGER, `HEART` INTEGER, `GROUPS` TEXT, `SWIM_TRIPS` REAL, `SWIM_DISTANCE` INTEGER, `SWIM_POOL_LENGTH` INTEGER, `SWIM_STROKE` INTEGER, `DEVICE_ID` TEXT, `SESSION_MODE` INTEGER, `MAX_ELEVATION` REAL, `MIN_ELEVATION` REAL, `CUMULATIVE_UP` REAL, `CUMULATIVE_DOWN` REAL, `SCORE` REAL, `EXTRA` TEXT)");
            bVar.l("CREATE INDEX IF NOT EXISTS `IDX_RECORD_HASH` ON `RECORD` (`HASH`)");
            bVar.l("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            bVar.l("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '7594257f2dda57fa09beeb2d30571fc3')");
        }

        @Override // androidx.room.h0.a
        public void b(b bVar) {
            bVar.l("DROP TABLE IF EXISTS `POINT`");
            bVar.l("DROP TABLE IF EXISTS `RECORD`");
            if (((RoomDatabase) FitnessDatabase_Impl.this).f4145h != null) {
                int size = ((RoomDatabase) FitnessDatabase_Impl.this).f4145h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((RoomDatabase.b) ((RoomDatabase) FitnessDatabase_Impl.this).f4145h.get(i10)).b(bVar);
                }
            }
        }

        @Override // androidx.room.h0.a
        protected void c(b bVar) {
            if (((RoomDatabase) FitnessDatabase_Impl.this).f4145h != null) {
                int size = ((RoomDatabase) FitnessDatabase_Impl.this).f4145h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((RoomDatabase.b) ((RoomDatabase) FitnessDatabase_Impl.this).f4145h.get(i10)).a(bVar);
                }
            }
        }

        @Override // androidx.room.h0.a
        public void d(b bVar) {
            ((RoomDatabase) FitnessDatabase_Impl.this).f4138a = bVar;
            FitnessDatabase_Impl.this.t(bVar);
            if (((RoomDatabase) FitnessDatabase_Impl.this).f4145h != null) {
                int size = ((RoomDatabase) FitnessDatabase_Impl.this).f4145h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((RoomDatabase.b) ((RoomDatabase) FitnessDatabase_Impl.this).f4145h.get(i10)).c(bVar);
                }
            }
        }

        @Override // androidx.room.h0.a
        public void e(b bVar) {
        }

        @Override // androidx.room.h0.a
        public void f(b bVar) {
            h1.c.a(bVar);
        }

        @Override // androidx.room.h0.a
        protected h0.b g(b bVar) {
            HashMap hashMap = new HashMap(18);
            hashMap.put("_id", new g.a("_id", "INTEGER", false, 1, null, 1));
            hashMap.put("TIME", new g.a("TIME", "INTEGER", true, 0, null, 1));
            hashMap.put("HEART", new g.a("HEART", "INTEGER", false, 0, null, 1));
            hashMap.put("STEP", new g.a("STEP", "INTEGER", false, 0, null, 1));
            hashMap.put("LAT", new g.a("LAT", "REAL", true, 0, null, 1));
            hashMap.put("LON", new g.a("LON", "REAL", true, 0, null, 1));
            hashMap.put("ACC", new g.a("ACC", "REAL", true, 0, null, 1));
            hashMap.put("DISTANCE", new g.a("DISTANCE", "INTEGER", false, 0, null, 1));
            hashMap.put("SPEED", new g.a("SPEED", "REAL", false, 0, null, 1));
            hashMap.put("CALORIE", new g.a("CALORIE", "REAL", false, 0, null, 1));
            hashMap.put("RECORD_ID", new g.a("RECORD_ID", "INTEGER", false, 0, null, 1));
            hashMap.put("RESUME", new g.a("RESUME", "INTEGER", false, 0, null, 1));
            hashMap.put("SWIM_TRIPS", new g.a("SWIM_TRIPS", "REAL", false, 0, null, 1));
            hashMap.put("SWIM_DISTANCE", new g.a("SWIM_DISTANCE", "INTEGER", false, 0, null, 1));
            hashMap.put("SWIM_STROKE", new g.a("SWIM_STROKE", "INTEGER", false, 0, null, 1));
            hashMap.put("SWIM_TYPE", new g.a("SWIM_TYPE", "INTEGER", false, 0, null, 1));
            hashMap.put("TIMESTAMP", new g.a("TIMESTAMP", "INTEGER", true, 0, null, 1));
            hashMap.put("ELEVATION", new g.a("ELEVATION", "REAL", false, 0, null, 1));
            g gVar = new g("POINT", hashMap, new HashSet(0), new HashSet(0));
            g a10 = g.a(bVar, "POINT");
            if (!gVar.equals(a10)) {
                return new h0.b(false, "POINT(com.mobvoi.fitness.core.data.db.gen.DbSportPoint).\n Expected:\n" + gVar + "\n Found:\n" + a10);
            }
            HashMap hashMap2 = new HashMap(29);
            hashMap2.put("_id", new g.a("_id", "INTEGER", false, 1, null, 1));
            hashMap2.put("HASH", new g.a("HASH", "TEXT", false, 0, null, 1));
            hashMap2.put("TYPE", new g.a("TYPE", "INTEGER", true, 0, null, 1));
            hashMap2.put("TARGET_TYPE", new g.a("TARGET_TYPE", "INTEGER", false, 0, null, 1));
            hashMap2.put("TARGET_VALUE", new g.a("TARGET_VALUE", "REAL", false, 0, null, 1));
            hashMap2.put("ACCOUNT_ID", new g.a("ACCOUNT_ID", "TEXT", false, 0, null, 1));
            hashMap2.put("SYNCED", new g.a("SYNCED", "INTEGER", true, 0, null, 1));
            hashMap2.put("DELETED", new g.a("DELETED", "INTEGER", true, 0, null, 1));
            hashMap2.put("START_TIME", new g.a("START_TIME", "INTEGER", false, 0, null, 1));
            hashMap2.put("END_TIME", new g.a("END_TIME", "INTEGER", false, 0, null, 1));
            hashMap2.put("TIMESTAMP", new g.a("TIMESTAMP", "INTEGER", false, 0, null, 1));
            hashMap2.put("DURATION", new g.a("DURATION", "INTEGER", true, 0, null, 1));
            hashMap2.put("DISTANCE", new g.a("DISTANCE", "INTEGER", false, 0, null, 1));
            hashMap2.put("CALORIE", new g.a("CALORIE", "REAL", false, 0, null, 1));
            hashMap2.put("STEP", new g.a("STEP", "INTEGER", false, 0, null, 1));
            hashMap2.put("HEART", new g.a("HEART", "INTEGER", false, 0, null, 1));
            hashMap2.put("GROUPS", new g.a("GROUPS", "TEXT", false, 0, null, 1));
            hashMap2.put("SWIM_TRIPS", new g.a("SWIM_TRIPS", "REAL", false, 0, null, 1));
            hashMap2.put("SWIM_DISTANCE", new g.a("SWIM_DISTANCE", "INTEGER", false, 0, null, 1));
            hashMap2.put("SWIM_POOL_LENGTH", new g.a("SWIM_POOL_LENGTH", "INTEGER", false, 0, null, 1));
            hashMap2.put("SWIM_STROKE", new g.a("SWIM_STROKE", "INTEGER", false, 0, null, 1));
            hashMap2.put("DEVICE_ID", new g.a("DEVICE_ID", "TEXT", false, 0, null, 1));
            hashMap2.put("SESSION_MODE", new g.a("SESSION_MODE", "INTEGER", false, 0, null, 1));
            hashMap2.put("MAX_ELEVATION", new g.a("MAX_ELEVATION", "REAL", false, 0, null, 1));
            hashMap2.put("MIN_ELEVATION", new g.a("MIN_ELEVATION", "REAL", false, 0, null, 1));
            hashMap2.put("CUMULATIVE_UP", new g.a("CUMULATIVE_UP", "REAL", false, 0, null, 1));
            hashMap2.put("CUMULATIVE_DOWN", new g.a("CUMULATIVE_DOWN", "REAL", false, 0, null, 1));
            hashMap2.put("SCORE", new g.a("SCORE", "REAL", false, 0, null, 1));
            hashMap2.put("EXTRA", new g.a("EXTRA", "TEXT", false, 0, null, 1));
            HashSet hashSet = new HashSet(0);
            HashSet hashSet2 = new HashSet(1);
            hashSet2.add(new g.d("IDX_RECORD_HASH", false, Arrays.asList("HASH")));
            g gVar2 = new g("RECORD", hashMap2, hashSet, hashSet2);
            g a11 = g.a(bVar, "RECORD");
            if (gVar2.equals(a11)) {
                return new h0.b(true, null);
            }
            return new h0.b(false, "RECORD(com.mobvoi.fitness.core.data.db.gen.DbSportRecord).\n Expected:\n" + gVar2 + "\n Found:\n" + a11);
        }
    }

    @Override // com.mobvoi.fitness.core.data.db.gen.FitnessDatabase
    public c F() {
        c cVar;
        if (this.f17916y != null) {
            return this.f17916y;
        }
        synchronized (this) {
            if (this.f17916y == null) {
                this.f17916y = new d(this);
            }
            cVar = this.f17916y;
        }
        return cVar;
    }

    @Override // androidx.room.RoomDatabase
    protected o g() {
        return new o(this, new HashMap(0), new HashMap(0), "POINT", "RECORD");
    }

    @Override // androidx.room.RoomDatabase
    protected i1.c h(i iVar) {
        return iVar.f4229a.a(c.b.a(iVar.f4230b).c(iVar.f4231c).b(new h0(iVar, new a(1020), "7594257f2dda57fa09beeb2d30571fc3", "ca31843ac86126ff2c9e9ab5921a7c1a")).a());
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> n() {
        HashMap hashMap = new HashMap();
        hashMap.put(ye.c.class, d.v());
        return hashMap;
    }
}
