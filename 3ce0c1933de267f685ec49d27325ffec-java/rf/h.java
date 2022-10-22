package rf;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import com.mobvoi.wear.contacts.ContactConstant;
import f1.g;
import f1.k;
import f1.l;
import i1.f;
import java.util.Collections;
import java.util.List;
/* compiled from: DataSourceDao_Impl.java */
/* loaded from: classes2.dex */
public final class h implements g {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f33508a;

    /* renamed from: b  reason: collision with root package name */
    private final g<qf.d> f33509b;

    /* compiled from: DataSourceDao_Impl.java */
    /* loaded from: classes2.dex */
    class a extends g<qf.d> {
        a(h hVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "INSERT OR REPLACE INTO `data_source` (`name`,`wwid`,`device_id`,`device_model`,`device_type`,`device_version`) VALUES (?,?,?,?,?,?)";
        }

        /* renamed from: m */
        public void g(f fVar, qf.d dVar) {
            String str = dVar.f33134a;
            if (str == null) {
                fVar.l0(1);
            } else {
                fVar.m(1, str);
            }
            String str2 = dVar.f33135b;
            if (str2 == null) {
                fVar.l0(2);
            } else {
                fVar.m(2, str2);
            }
            String str3 = dVar.f33136c;
            if (str3 == null) {
                fVar.l0(3);
            } else {
                fVar.m(3, str3);
            }
            String str4 = dVar.f33137d;
            if (str4 == null) {
                fVar.l0(4);
            } else {
                fVar.m(4, str4);
            }
            String str5 = dVar.f33138e;
            if (str5 == null) {
                fVar.l0(5);
            } else {
                fVar.m(5, str5);
            }
            String str6 = dVar.f33139f;
            if (str6 == null) {
                fVar.l0(6);
            } else {
                fVar.m(6, str6);
            }
        }
    }

    /* compiled from: DataSourceDao_Impl.java */
    /* loaded from: classes2.dex */
    class b extends f1.f<qf.d> {
        b(h hVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "UPDATE OR ABORT `data_source` SET `name` = ?,`wwid` = ?,`device_id` = ?,`device_model` = ?,`device_type` = ?,`device_version` = ? WHERE `name` = ?";
        }

        /* renamed from: j */
        public void g(f fVar, qf.d dVar) {
            String str = dVar.f33134a;
            if (str == null) {
                fVar.l0(1);
            } else {
                fVar.m(1, str);
            }
            String str2 = dVar.f33135b;
            if (str2 == null) {
                fVar.l0(2);
            } else {
                fVar.m(2, str2);
            }
            String str3 = dVar.f33136c;
            if (str3 == null) {
                fVar.l0(3);
            } else {
                fVar.m(3, str3);
            }
            String str4 = dVar.f33137d;
            if (str4 == null) {
                fVar.l0(4);
            } else {
                fVar.m(4, str4);
            }
            String str5 = dVar.f33138e;
            if (str5 == null) {
                fVar.l0(5);
            } else {
                fVar.m(5, str5);
            }
            String str6 = dVar.f33139f;
            if (str6 == null) {
                fVar.l0(6);
            } else {
                fVar.m(6, str6);
            }
            String str7 = dVar.f33134a;
            if (str7 == null) {
                fVar.l0(7);
            } else {
                fVar.m(7, str7);
            }
        }
    }

    /* compiled from: DataSourceDao_Impl.java */
    /* loaded from: classes2.dex */
    class c extends l {
        c(h hVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "DELETE FROM data_source WHERE name = ?";
        }
    }

    /* compiled from: DataSourceDao_Impl.java */
    /* loaded from: classes2.dex */
    class d extends l {
        d(h hVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "DELETE FROM data_source ";
        }
    }

    public h(RoomDatabase roomDatabase) {
        this.f33508a = roomDatabase;
        this.f33509b = new a(this, roomDatabase);
        new b(this, roomDatabase);
        new c(this, roomDatabase);
        new d(this, roomDatabase);
    }

    public static List<Class<?>> d() {
        return Collections.emptyList();
    }

    @Override // rf.g
    public long a(qf.d dVar) {
        this.f33508a.d();
        this.f33508a.e();
        try {
            long k10 = this.f33509b.k(dVar);
            this.f33508a.B();
            return k10;
        } finally {
            this.f33508a.i();
        }
    }

    @Override // rf.g
    public qf.d b(String str) {
        k h10 = k.h("SELECT * FROM data_source WHERE name = ? ", 1);
        if (str == null) {
            h10.l0(1);
        } else {
            h10.m(1, str);
        }
        this.f33508a.d();
        qf.d dVar = null;
        Cursor b10 = h1.c.b(this.f33508a, h10, false, null);
        try {
            int e10 = h1.b.e(b10, ContactConstant.CallsRecordKeys.NAME);
            int e11 = h1.b.e(b10, "wwid");
            int e12 = h1.b.e(b10, "device_id");
            int e13 = h1.b.e(b10, "device_model");
            int e14 = h1.b.e(b10, "device_type");
            int e15 = h1.b.e(b10, "device_version");
            if (b10.moveToFirst()) {
                qf.d dVar2 = new qf.d();
                if (b10.isNull(e10)) {
                    dVar2.f33134a = null;
                } else {
                    dVar2.f33134a = b10.getString(e10);
                }
                if (b10.isNull(e11)) {
                    dVar2.f33135b = null;
                } else {
                    dVar2.f33135b = b10.getString(e11);
                }
                if (b10.isNull(e12)) {
                    dVar2.f33136c = null;
                } else {
                    dVar2.f33136c = b10.getString(e12);
                }
                if (b10.isNull(e13)) {
                    dVar2.f33137d = null;
                } else {
                    dVar2.f33137d = b10.getString(e13);
                }
                if (b10.isNull(e14)) {
                    dVar2.f33138e = null;
                } else {
                    dVar2.f33138e = b10.getString(e14);
                }
                if (b10.isNull(e15)) {
                    dVar2.f33139f = null;
                } else {
                    dVar2.f33139f = b10.getString(e15);
                }
                dVar = dVar2;
            }
            return dVar;
        } finally {
            b10.close();
            h10.o();
        }
    }

    @Override // rf.g
    public qf.d c(String str, String str2) {
        k h10 = k.h("SELECT * FROM data_source WHERE wwid = ? AND device_id = ? LIMIT 1", 2);
        if (str == null) {
            h10.l0(1);
        } else {
            h10.m(1, str);
        }
        if (str2 == null) {
            h10.l0(2);
        } else {
            h10.m(2, str2);
        }
        this.f33508a.d();
        qf.d dVar = null;
        Cursor b10 = h1.c.b(this.f33508a, h10, false, null);
        try {
            int e10 = h1.b.e(b10, ContactConstant.CallsRecordKeys.NAME);
            int e11 = h1.b.e(b10, "wwid");
            int e12 = h1.b.e(b10, "device_id");
            int e13 = h1.b.e(b10, "device_model");
            int e14 = h1.b.e(b10, "device_type");
            int e15 = h1.b.e(b10, "device_version");
            if (b10.moveToFirst()) {
                qf.d dVar2 = new qf.d();
                if (b10.isNull(e10)) {
                    dVar2.f33134a = null;
                } else {
                    dVar2.f33134a = b10.getString(e10);
                }
                if (b10.isNull(e11)) {
                    dVar2.f33135b = null;
                } else {
                    dVar2.f33135b = b10.getString(e11);
                }
                if (b10.isNull(e12)) {
                    dVar2.f33136c = null;
                } else {
                    dVar2.f33136c = b10.getString(e12);
                }
                if (b10.isNull(e13)) {
                    dVar2.f33137d = null;
                } else {
                    dVar2.f33137d = b10.getString(e13);
                }
                if (b10.isNull(e14)) {
                    dVar2.f33138e = null;
                } else {
                    dVar2.f33138e = b10.getString(e14);
                }
                if (b10.isNull(e15)) {
                    dVar2.f33139f = null;
                } else {
                    dVar2.f33139f = b10.getString(e15);
                }
                dVar = dVar2;
            }
            return dVar;
        } finally {
            b10.close();
            h10.o();
        }
    }
}
