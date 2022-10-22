package com.mobvoi.apollo.db;

import androidx.room.RoomDatabase;
import androidx.room.h0;
import androidx.room.i;
import androidx.room.o;
import com.mobvoi.wear.contacts.ContactConstant;
import h1.c;
import h1.g;
import i1.b;
import i1.c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public final class ApolloDatabase_Impl extends ApolloDatabase {

    /* renamed from: p  reason: collision with root package name */
    private volatile ga.a f15564p;

    /* loaded from: classes2.dex */
    class a extends h0.a {
        a(int i10) {
            super(i10);
        }

        @Override // androidx.room.h0.a
        public void a(b bVar) {
            bVar.l("CREATE TABLE IF NOT EXISTS `contacts` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `num` TEXT NOT NULL)");
            bVar.l("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            bVar.l("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '5e7f5a9fa433139a9947f6fbbab9acd5')");
        }

        @Override // androidx.room.h0.a
        public void b(b bVar) {
            bVar.l("DROP TABLE IF EXISTS `contacts`");
            if (((RoomDatabase) ApolloDatabase_Impl.this).f4145h != null) {
                int size = ((RoomDatabase) ApolloDatabase_Impl.this).f4145h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((RoomDatabase.b) ((RoomDatabase) ApolloDatabase_Impl.this).f4145h.get(i10)).b(bVar);
                }
            }
        }

        @Override // androidx.room.h0.a
        protected void c(b bVar) {
            if (((RoomDatabase) ApolloDatabase_Impl.this).f4145h != null) {
                int size = ((RoomDatabase) ApolloDatabase_Impl.this).f4145h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((RoomDatabase.b) ((RoomDatabase) ApolloDatabase_Impl.this).f4145h.get(i10)).a(bVar);
                }
            }
        }

        @Override // androidx.room.h0.a
        public void d(b bVar) {
            ((RoomDatabase) ApolloDatabase_Impl.this).f4138a = bVar;
            ApolloDatabase_Impl.this.t(bVar);
            if (((RoomDatabase) ApolloDatabase_Impl.this).f4145h != null) {
                int size = ((RoomDatabase) ApolloDatabase_Impl.this).f4145h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((RoomDatabase.b) ((RoomDatabase) ApolloDatabase_Impl.this).f4145h.get(i10)).c(bVar);
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
            hashMap.put(ContactConstant.CallsRecordKeys.NAME, new g.a(ContactConstant.CallsRecordKeys.NAME, "TEXT", true, 0, null, 1));
            hashMap.put("num", new g.a("num", "TEXT", true, 0, null, 1));
            g gVar = new g("contacts", hashMap, new HashSet(0), new HashSet(0));
            g a10 = g.a(bVar, "contacts");
            if (gVar.equals(a10)) {
                return new h0.b(true, null);
            }
            return new h0.b(false, "contacts(com.mobvoi.apollo.protocol.model.Contact).\n Expected:\n" + gVar + "\n Found:\n" + a10);
        }
    }

    @Override // com.mobvoi.apollo.db.ApolloDatabase
    public ga.a F() {
        ga.a aVar;
        if (this.f15564p != null) {
            return this.f15564p;
        }
        synchronized (this) {
            if (this.f15564p == null) {
                this.f15564p = new com.mobvoi.apollo.db.a(this);
            }
            aVar = this.f15564p;
        }
        return aVar;
    }

    @Override // androidx.room.RoomDatabase
    protected o g() {
        return new o(this, new HashMap(0), new HashMap(0), "contacts");
    }

    @Override // androidx.room.RoomDatabase
    protected i1.c h(i iVar) {
        return iVar.f4229a.a(c.b.a(iVar.f4230b).c(iVar.f4231c).b(new h0(iVar, new a(1), "5e7f5a9fa433139a9947f6fbbab9acd5", "4d746088010559332889872880a34a6c")).a());
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> n() {
        HashMap hashMap = new HashMap();
        hashMap.put(ga.a.class, com.mobvoi.apollo.db.a.f());
        return hashMap;
    }
}
