package y1;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import f1.g;
import f1.k;
import h1.c;
import i1.f;
import java.util.ArrayList;
import java.util.List;
/* compiled from: WorkTagDao_Impl.java */
/* loaded from: classes.dex */
public final class u implements t {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f36726a;

    /* renamed from: b  reason: collision with root package name */
    private final g<s> f36727b;

    /* compiled from: WorkTagDao_Impl.java */
    /* loaded from: classes.dex */
    class a extends g<s> {
        a(u uVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
        }

        /* renamed from: m */
        public void g(f fVar, s sVar) {
            String str = sVar.f36724a;
            if (str == null) {
                fVar.l0(1);
            } else {
                fVar.m(1, str);
            }
            String str2 = sVar.f36725b;
            if (str2 == null) {
                fVar.l0(2);
            } else {
                fVar.m(2, str2);
            }
        }
    }

    public u(RoomDatabase roomDatabase) {
        this.f36726a = roomDatabase;
        this.f36727b = new a(this, roomDatabase);
    }

    @Override // y1.t
    public void a(s sVar) {
        this.f36726a.d();
        this.f36726a.e();
        try {
            this.f36727b.i(sVar);
            this.f36726a.B();
        } finally {
            this.f36726a.i();
        }
    }

    @Override // y1.t
    public List<String> b(String str) {
        k h10 = k.h("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
        if (str == null) {
            h10.l0(1);
        } else {
            h10.m(1, str);
        }
        this.f36726a.d();
        Cursor b10 = c.b(this.f36726a, h10, false, null);
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
