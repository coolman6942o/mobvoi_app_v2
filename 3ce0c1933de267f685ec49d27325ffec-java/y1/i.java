package y1;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import f1.g;
import f1.k;
import f1.l;
import h1.c;
import i1.f;
import java.util.ArrayList;
import java.util.List;
/* compiled from: SystemIdInfoDao_Impl.java */
/* loaded from: classes.dex */
public final class i implements h {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f36677a;

    /* renamed from: b  reason: collision with root package name */
    private final g<g> f36678b;

    /* renamed from: c  reason: collision with root package name */
    private final l f36679c;

    /* compiled from: SystemIdInfoDao_Impl.java */
    /* loaded from: classes.dex */
    class a extends g<g> {
        a(i iVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`system_id`) VALUES (?,?)";
        }

        /* renamed from: m */
        public void g(f fVar, g gVar) {
            String str = gVar.f36675a;
            if (str == null) {
                fVar.l0(1);
            } else {
                fVar.m(1, str);
            }
            fVar.K(2, gVar.f36676b);
        }
    }

    /* compiled from: SystemIdInfoDao_Impl.java */
    /* loaded from: classes.dex */
    class b extends l {
        b(i iVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "DELETE FROM SystemIdInfo where work_spec_id=?";
        }
    }

    public i(RoomDatabase roomDatabase) {
        this.f36677a = roomDatabase;
        this.f36678b = new a(this, roomDatabase);
        this.f36679c = new b(this, roomDatabase);
    }

    @Override // y1.h
    public List<String> a() {
        k h10 = k.h("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
        this.f36677a.d();
        Cursor b10 = c.b(this.f36677a, h10, false, null);
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

    @Override // y1.h
    public void b(g gVar) {
        this.f36677a.d();
        this.f36677a.e();
        try {
            this.f36678b.i(gVar);
            this.f36677a.B();
        } finally {
            this.f36677a.i();
        }
    }

    @Override // y1.h
    public g c(String str) {
        k h10 = k.h("SELECT `SystemIdInfo`.`work_spec_id` AS `work_spec_id`, `SystemIdInfo`.`system_id` AS `system_id` FROM SystemIdInfo WHERE work_spec_id=?", 1);
        if (str == null) {
            h10.l0(1);
        } else {
            h10.m(1, str);
        }
        this.f36677a.d();
        g gVar = null;
        Cursor b10 = c.b(this.f36677a, h10, false, null);
        try {
            int e10 = h1.b.e(b10, "work_spec_id");
            int e11 = h1.b.e(b10, "system_id");
            if (b10.moveToFirst()) {
                gVar = new g(b10.getString(e10), b10.getInt(e11));
            }
            return gVar;
        } finally {
            b10.close();
            h10.o();
        }
    }

    @Override // y1.h
    public void d(String str) {
        this.f36677a.d();
        f a10 = this.f36679c.a();
        if (str == null) {
            a10.l0(1);
        } else {
            a10.m(1, str);
        }
        this.f36677a.e();
        try {
            a10.r();
            this.f36677a.B();
        } finally {
            this.f36677a.i();
            this.f36679c.f(a10);
        }
    }
}
