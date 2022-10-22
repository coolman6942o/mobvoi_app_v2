package y1;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import f1.g;
import f1.k;
import h1.c;
import i1.f;
import java.util.ArrayList;
import java.util.List;
/* compiled from: WorkNameDao_Impl.java */
/* loaded from: classes.dex */
public final class l implements k {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f36682a;

    /* renamed from: b  reason: collision with root package name */
    private final g<j> f36683b;

    /* compiled from: WorkNameDao_Impl.java */
    /* loaded from: classes.dex */
    class a extends g<j> {
        a(l lVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
        }

        /* renamed from: m */
        public void g(f fVar, j jVar) {
            String str = jVar.f36680a;
            if (str == null) {
                fVar.l0(1);
            } else {
                fVar.m(1, str);
            }
            String str2 = jVar.f36681b;
            if (str2 == null) {
                fVar.l0(2);
            } else {
                fVar.m(2, str2);
            }
        }
    }

    public l(RoomDatabase roomDatabase) {
        this.f36682a = roomDatabase;
        this.f36683b = new a(this, roomDatabase);
    }

    @Override // y1.k
    public void a(j jVar) {
        this.f36682a.d();
        this.f36682a.e();
        try {
            this.f36683b.i(jVar);
            this.f36682a.B();
        } finally {
            this.f36682a.i();
        }
    }

    @Override // y1.k
    public List<String> b(String str) {
        k h10 = k.h("SELECT name FROM workname WHERE work_spec_id=?", 1);
        if (str == null) {
            h10.l0(1);
        } else {
            h10.m(1, str);
        }
        this.f36682a.d();
        Cursor b10 = c.b(this.f36682a, h10, false, null);
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
}
