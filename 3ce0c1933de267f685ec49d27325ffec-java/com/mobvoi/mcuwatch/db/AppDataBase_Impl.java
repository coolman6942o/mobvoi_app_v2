package com.mobvoi.mcuwatch.db;

import androidx.room.RoomDatabase;
import androidx.room.h0;
import androidx.room.i;
import androidx.room.o;
import com.mobvoi.wear.contacts.ContactConstant;
import h1.c;
import h1.g;
import i1.b;
import i1.c;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public final class AppDataBase_Impl extends AppDataBase {

    /* renamed from: o  reason: collision with root package name */
    private volatile oi.a f19141o;

    /* loaded from: classes2.dex */
    class a extends h0.a {
        a(int i10) {
            super(i10);
        }

        @Override // androidx.room.h0.a
        public void a(b bVar) {
            bVar.l("CREATE TABLE IF NOT EXISTS `device_info` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `macAddress` TEXT, `name` TEXT)");
            bVar.l("CREATE UNIQUE INDEX IF NOT EXISTS `index_device_info_macAddress` ON `device_info` (`macAddress`)");
            bVar.l("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            bVar.l("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '46fb95f243e305eeeab5ed8ff18bf5bf')");
        }

        @Override // androidx.room.h0.a
        public void b(b bVar) {
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
            HashMap hashMap = new HashMap(3);
            hashMap.put("id", new g.a("id", "INTEGER", true, 1, null, 1));
            hashMap.put("macAddress", new g.a("macAddress", "TEXT", false, 0, null, 1));
            hashMap.put(ContactConstant.CallsRecordKeys.NAME, new g.a(ContactConstant.CallsRecordKeys.NAME, "TEXT", false, 0, null, 1));
            HashSet hashSet = new HashSet(0);
            HashSet hashSet2 = new HashSet(1);
            hashSet2.add(new g.d("index_device_info_macAddress", true, Arrays.asList("macAddress")));
            g gVar = new g(pi.a.TAB_NAME, hashMap, hashSet, hashSet2);
            g a10 = g.a(bVar, pi.a.TAB_NAME);
            if (gVar.equals(a10)) {
                return new h0.b(true, null);
            }
            return new h0.b(false, "device_info(com.mobvoi.mcuwatch.settings.persistence.entity.DeviceInfoEntity).\n Expected:\n" + gVar + "\n Found:\n" + a10);
        }
    }

    @Override // com.mobvoi.mcuwatch.db.AppDataBase
    public oi.a D() {
        oi.a aVar;
        if (this.f19141o != null) {
            return this.f19141o;
        }
        synchronized (this) {
            if (this.f19141o == null) {
                this.f19141o = new oi.b(this);
            }
            aVar = this.f19141o;
        }
        return aVar;
    }

    @Override // androidx.room.RoomDatabase
    protected o g() {
        return new o(this, new HashMap(0), new HashMap(0), pi.a.TAB_NAME);
    }

    @Override // androidx.room.RoomDatabase
    protected i1.c h(i iVar) {
        return iVar.f4229a.a(c.b.a(iVar.f4230b).c(iVar.f4231c).b(new h0(iVar, new a(1), "46fb95f243e305eeeab5ed8ff18bf5bf", "c3d43d178e581561b0727ec2c002071a")).a());
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> n() {
        HashMap hashMap = new HashMap();
        hashMap.put(oi.a.class, oi.b.c());
        return hashMap;
    }
}
