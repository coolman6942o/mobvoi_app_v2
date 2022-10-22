package y1;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import f1.g;
import f1.k;
import i1.f;
import java.util.ArrayList;
import java.util.List;
/* compiled from: DependencyDao_Impl.java */
/* loaded from: classes.dex */
public final class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f36669a;

    /* renamed from: b  reason: collision with root package name */
    private final g<y1.a> f36670b;

    /* compiled from: DependencyDao_Impl.java */
    /* loaded from: classes.dex */
    class a extends g<y1.a> {
        a(c cVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
        }

        /* renamed from: m */
        public void g(f fVar, y1.a aVar) {
            String str = aVar.f36667a;
            if (str == null) {
                fVar.l0(1);
            } else {
                fVar.m(1, str);
            }
            String str2 = aVar.f36668b;
            if (str2 == null) {
                fVar.l0(2);
            } else {
                fVar.m(2, str2);
            }
        }
    }

    public c(RoomDatabase roomDatabase) {
        this.f36669a = roomDatabase;
        this.f36670b = new a(this, roomDatabase);
    }

    @Override // y1.b
    public List<String> a(String str) {
        k h10 = k.h("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            h10.l0(1);
        } else {
            h10.m(1, str);
        }
        this.f36669a.d();
        Cursor b10 = h1.c.b(this.f36669a, h10, false, null);
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

    @Override // y1.b
    public boolean b(String str) {
        boolean z10 = true;
        k h10 = k.h("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if (str == null) {
            h10.l0(1);
        } else {
            h10.m(1, str);
        }
        this.f36669a.d();
        boolean z11 = false;
        Cursor b10 = h1.c.b(this.f36669a, h10, false, null);
        try {
            if (b10.moveToFirst()) {
                if (b10.getInt(0) == 0) {
                    z10 = false;
                }
                z11 = z10;
            }
            return z11;
        } finally {
            b10.close();
            h10.o();
        }
    }

    @Override // y1.b
    public void c(y1.a aVar) {
        this.f36669a.d();
        this.f36669a.e();
        try {
            this.f36670b.i(aVar);
            this.f36669a.B();
        } finally {
            this.f36669a.i();
        }
    }

    @Override // y1.b
    public boolean d(String str) {
        boolean z10 = true;
        k h10 = k.h("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            h10.l0(1);
        } else {
            h10.m(1, str);
        }
        this.f36669a.d();
        boolean z11 = false;
        Cursor b10 = h1.c.b(this.f36669a, h10, false, null);
        try {
            if (b10.moveToFirst()) {
                if (b10.getInt(0) == 0) {
                    z10 = false;
                }
                z11 = z10;
            }
            return z11;
        } finally {
            b10.close();
            h10.o();
        }
    }
}
