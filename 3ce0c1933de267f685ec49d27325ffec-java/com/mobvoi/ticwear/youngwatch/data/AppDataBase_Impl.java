package com.mobvoi.ticwear.youngwatch.data;

import androidx.room.RoomDatabase;
import androidx.room.h0;
import androidx.room.i;
import androidx.room.o;
import h1.c;
import h1.g;
import i1.b;
import i1.c;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import pk.l;
import pk.l0;
import pk.m;
import pk.m0;
/* loaded from: classes2.dex */
public final class AppDataBase_Impl extends AppDataBase {

    /* loaded from: classes2.dex */
    class a extends h0.a {
        a(int i10) {
            super(i10);
        }

        @Override // androidx.room.h0.a
        public void a(b bVar) {
            bVar.l("CREATE TABLE IF NOT EXISTS `sleep_raw` (`time` INTEGER NOT NULL, `sleep` INTEGER NOT NULL, PRIMARY KEY(`time`))");
            bVar.l("CREATE TABLE IF NOT EXISTS `device_info` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `macAddress` TEXT)");
            bVar.l("CREATE UNIQUE INDEX IF NOT EXISTS `index_device_info_macAddress` ON `device_info` (`macAddress`)");
            bVar.l("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            bVar.l("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '921d37b80a11b34196d7b9de8762a7d3')");
        }

        @Override // androidx.room.h0.a
        public void b(b bVar) {
            bVar.l("DROP TABLE IF EXISTS `sleep_raw`");
            bVar.l("DROP TABLE IF EXISTS `device_info`");
            if (((RoomDatabase) AppDataBase_Impl.this).f4145h != null) {
                int size = ((RoomDatabase) AppDataBase_Impl.this).f4145h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((RoomDatabase.b) ((RoomDatabase) AppDataBase_Impl.this).f4145h.get(i10)).b(bVar);
                }
            }
        }

        @Override // androidx.room.h0.a
        protected void c(b bVar) {
            if (((RoomDatabase) AppDataBase_Impl.this).f4145h != null) {
                int size = ((RoomDatabase) AppDataBase_Impl.this).f4145h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((RoomDatabase.b) ((RoomDatabase) AppDataBase_Impl.this).f4145h.get(i10)).a(bVar);
                }
            }
        }

        @Override // androidx.room.h0.a
        public void d(b bVar) {
            ((RoomDatabase) AppDataBase_Impl.this).f4138a = bVar;
            AppDataBase_Impl.this.t(bVar);
            if (((RoomDatabase) AppDataBase_Impl.this).f4145h != null) {
                int size = ((RoomDatabase) AppDataBase_Impl.this).f4145h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((RoomDatabase.b) ((RoomDatabase) AppDataBase_Impl.this).f4145h.get(i10)).c(bVar);
                }
            }
        }

        @Override // androidx.room.h0.a
        public void e(b bVar) {
        }

        @Override // androidx.room.h0.a
        public void f(b bVar) {
            c.a(bVar);
        }

        @Override // androidx.room.h0.a
        protected h0.b g(b bVar) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("time", new g.a("time", "INTEGER", true, 1, null, 1));
            hashMap.put("sleep", new g.a("sleep", "INTEGER", true, 0, null, 1));
            g gVar = new g("sleep_raw", hashMap, new HashSet(0), new HashSet(0));
            g a10 = g.a(bVar, "sleep_raw");
            if (!gVar.equals(a10)) {
                return new h0.b(false, "sleep_raw(com.mobvoi.ticwear.youngwatch.data.SleepRawEntity).\n Expected:\n" + gVar + "\n Found:\n" + a10);
            }
            HashMap hashMap2 = new HashMap(2);
            hashMap2.put("id", new g.a("id", "INTEGER", true, 1, null, 1));
            hashMap2.put("macAddress", new g.a("macAddress", "TEXT", false, 0, null, 1));
            HashSet hashSet = new HashSet(0);
            HashSet hashSet2 = new HashSet(1);
            hashSet2.add(new g.d("index_device_info_macAddress", true, Arrays.asList("macAddress")));
            g gVar2 = new g(pi.a.TAB_NAME, hashMap2, hashSet, hashSet2);
            g a11 = g.a(bVar, pi.a.TAB_NAME);
            if (gVar2.equals(a11)) {
                return new h0.b(true, null);
            }
            return new h0.b(false, "device_info(com.mobvoi.ticwear.youngwatch.data.DeviceInfoEntity).\n Expected:\n" + gVar2 + "\n Found:\n" + a11);
        }
    }

    @Override // androidx.room.RoomDatabase
    protected o g() {
        return new o(this, new HashMap(0), new HashMap(0), "sleep_raw", pi.a.TAB_NAME);
    }

    @Override // androidx.room.RoomDatabase
    protected i1.c h(i iVar) {
        return iVar.f4229a.a(c.b.a(iVar.f4230b).c(iVar.f4231c).b(new h0(iVar, new a(1), "921d37b80a11b34196d7b9de8762a7d3", "8215185ba7e334a7b78c1acf747deb24")).a());
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> n() {
        HashMap hashMap = new HashMap();
        hashMap.put(l0.class, m0.a());
        hashMap.put(l.class, m.a());
        return hashMap;
    }
}
