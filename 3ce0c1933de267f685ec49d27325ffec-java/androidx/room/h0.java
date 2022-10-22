package androidx.room;

import android.database.Cursor;
import f1.j;
import i1.c;
import java.util.List;
/* compiled from: RoomOpenHelper.java */
/* loaded from: classes.dex */
public class h0 extends c.a {

    /* renamed from: b  reason: collision with root package name */
    private i f4222b;

    /* renamed from: c  reason: collision with root package name */
    private final a f4223c;

    /* renamed from: d  reason: collision with root package name */
    private final String f4224d;

    /* renamed from: e  reason: collision with root package name */
    private final String f4225e;

    /* compiled from: RoomOpenHelper.java */
    /* loaded from: classes.dex */
    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f4226a;

        public a(int i10) {
            this.f4226a = i10;
        }

        protected abstract void a(i1.b bVar);

        protected abstract void b(i1.b bVar);

        protected abstract void c(i1.b bVar);

        protected abstract void d(i1.b bVar);

        protected abstract void e(i1.b bVar);

        protected abstract void f(i1.b bVar);

        protected abstract b g(i1.b bVar);
    }

    /* compiled from: RoomOpenHelper.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f4227a;

        /* renamed from: b  reason: collision with root package name */
        public final String f4228b;

        public b(boolean z10, String str) {
            this.f4227a = z10;
            this.f4228b = str;
        }
    }

    public h0(i iVar, a aVar, String str, String str2) {
        super(aVar.f4226a);
        this.f4222b = iVar;
        this.f4223c = aVar;
        this.f4224d = str;
        this.f4225e = str2;
    }

    /* JADX WARN: Finally extract failed */
    private void h(i1.b bVar) {
        if (k(bVar)) {
            String str = null;
            Cursor f02 = bVar.f0(new i1.a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
            try {
                if (f02.moveToFirst()) {
                    str = f02.getString(0);
                }
                f02.close();
                if (!this.f4224d.equals(str) && !this.f4225e.equals(str)) {
                    throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
                }
            } catch (Throwable th2) {
                f02.close();
                throw th2;
            }
        } else {
            b g10 = this.f4223c.g(bVar);
            if (g10.f4227a) {
                this.f4223c.e(bVar);
                l(bVar);
                return;
            }
            throw new IllegalStateException("Pre-packaged database has an invalid schema: " + g10.f4228b);
        }
    }

    private void i(i1.b bVar) {
        bVar.l("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    private static boolean j(i1.b bVar) {
        Cursor U = bVar.U("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z10 = false;
            if (U.moveToFirst()) {
                if (U.getInt(0) == 0) {
                    z10 = true;
                }
            }
            return z10;
        } finally {
            U.close();
        }
    }

    private static boolean k(i1.b bVar) {
        Cursor U = bVar.U("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            boolean z10 = false;
            if (U.moveToFirst()) {
                if (U.getInt(0) != 0) {
                    z10 = true;
                }
            }
            return z10;
        } finally {
            U.close();
        }
    }

    private void l(i1.b bVar) {
        i(bVar);
        bVar.l(j.a(this.f4224d));
    }

    @Override // i1.c.a
    public void b(i1.b bVar) {
        super.b(bVar);
    }

    @Override // i1.c.a
    public void d(i1.b bVar) {
        boolean j10 = j(bVar);
        this.f4223c.a(bVar);
        if (!j10) {
            b g10 = this.f4223c.g(bVar);
            if (!g10.f4227a) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + g10.f4228b);
            }
        }
        l(bVar);
        this.f4223c.c(bVar);
    }

    @Override // i1.c.a
    public void e(i1.b bVar, int i10, int i11) {
        g(bVar, i10, i11);
    }

    @Override // i1.c.a
    public void f(i1.b bVar) {
        super.f(bVar);
        h(bVar);
        this.f4223c.d(bVar);
        this.f4222b = null;
    }

    @Override // i1.c.a
    public void g(i1.b bVar, int i10, int i11) {
        boolean z10;
        List<g1.a> c10;
        i iVar = this.f4222b;
        if (iVar == null || (c10 = iVar.f4232d.c(i10, i11)) == null) {
            z10 = false;
        } else {
            this.f4223c.f(bVar);
            for (g1.a aVar : c10) {
                aVar.a(bVar);
            }
            b g10 = this.f4223c.g(bVar);
            if (g10.f4227a) {
                this.f4223c.e(bVar);
                l(bVar);
                z10 = true;
            } else {
                throw new IllegalStateException("Migration didn't properly handle: " + g10.f4228b);
            }
        }
        if (!z10) {
            i iVar2 = this.f4222b;
            if (iVar2 == null || iVar2.a(i10, i11)) {
                throw new IllegalStateException("A migration from " + i10 + " to " + i11 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
            }
            this.f4223c.b(bVar);
            this.f4223c.a(bVar);
        }
    }
}
