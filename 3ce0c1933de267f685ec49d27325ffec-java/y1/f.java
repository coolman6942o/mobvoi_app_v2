package y1;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import f1.g;
import f1.k;
import h1.c;
/* compiled from: PreferenceDao_Impl.java */
/* loaded from: classes.dex */
public final class f implements e {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f36673a;

    /* renamed from: b  reason: collision with root package name */
    private final g<d> f36674b;

    /* compiled from: PreferenceDao_Impl.java */
    /* loaded from: classes.dex */
    class a extends g<d> {
        a(f fVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
        }

        /* renamed from: m */
        public void g(i1.f fVar, d dVar) {
            String str = dVar.f36671a;
            if (str == null) {
                fVar.l0(1);
            } else {
                fVar.m(1, str);
            }
            Long l10 = dVar.f36672b;
            if (l10 == null) {
                fVar.l0(2);
            } else {
                fVar.K(2, l10.longValue());
            }
        }
    }

    public f(RoomDatabase roomDatabase) {
        this.f36673a = roomDatabase;
        this.f36674b = new a(this, roomDatabase);
    }

    @Override // y1.e
    public void a(d dVar) {
        this.f36673a.d();
        this.f36673a.e();
        try {
            this.f36674b.i(dVar);
            this.f36673a.B();
        } finally {
            this.f36673a.i();
        }
    }

    @Override // y1.e
    public Long b(String str) {
        k h10 = k.h("SELECT long_value FROM Preference where `key`=?", 1);
        if (str == null) {
            h10.l0(1);
        } else {
            h10.m(1, str);
        }
        this.f36673a.d();
        Long l10 = null;
        Cursor b10 = c.b(this.f36673a, h10, false, null);
        try {
            if (b10.moveToFirst() && !b10.isNull(0)) {
                l10 = Long.valueOf(b10.getLong(0));
            }
            return l10;
        } finally {
            b10.close();
            h10.o();
        }
    }
}
