package ye;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import f1.k;
import f1.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: FitnessDao_Impl.java */
/* loaded from: classes2.dex */
public final class d implements ye.c {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f37066a;

    /* renamed from: b  reason: collision with root package name */
    private final f1.g<ye.a> f37067b;

    /* renamed from: c  reason: collision with root package name */
    private final f1.g<ye.b> f37068c;

    /* renamed from: d  reason: collision with root package name */
    private final f1.f<ye.a> f37069d;

    /* renamed from: e  reason: collision with root package name */
    private final f1.f<ye.b> f37070e;

    /* renamed from: f  reason: collision with root package name */
    private final f1.f<ye.a> f37071f;

    /* renamed from: g  reason: collision with root package name */
    private final f1.f<ye.b> f37072g;

    /* renamed from: h  reason: collision with root package name */
    private final l f37073h;

    /* renamed from: i  reason: collision with root package name */
    private final l f37074i;

    /* renamed from: j  reason: collision with root package name */
    private final l f37075j;

    /* compiled from: FitnessDao_Impl.java */
    /* loaded from: classes2.dex */
    class a extends f1.g<ye.a> {
        a(d dVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "INSERT OR REPLACE INTO `POINT` (`_id`,`TIME`,`HEART`,`STEP`,`LAT`,`LON`,`ACC`,`DISTANCE`,`SPEED`,`CALORIE`,`RECORD_ID`,`RESUME`,`SWIM_TRIPS`,`SWIM_DISTANCE`,`SWIM_STROKE`,`SWIM_TYPE`,`TIMESTAMP`,`ELEVATION`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* renamed from: m */
        public void g(i1.f fVar, ye.a aVar) {
            if (aVar.f() == null) {
                fVar.l0(1);
            } else {
                fVar.K(1, aVar.f().longValue());
            }
            fVar.K(2, aVar.q());
            if (aVar.e() == null) {
                fVar.l0(3);
            } else {
                fVar.K(3, aVar.e().intValue());
            }
            if (aVar.l() == null) {
                fVar.l0(4);
            } else {
                fVar.K(4, aVar.l().intValue());
            }
            fVar.y(5, aVar.g());
            fVar.y(6, aVar.h());
            fVar.y(7, aVar.a());
            if (aVar.c() == null) {
                fVar.l0(8);
            } else {
                fVar.K(8, aVar.c().intValue());
            }
            if (aVar.k() == null) {
                fVar.l0(9);
            } else {
                fVar.y(9, aVar.k().floatValue());
            }
            if (aVar.b() == null) {
                fVar.l0(10);
            } else {
                fVar.y(10, aVar.b().floatValue());
            }
            if (aVar.i() == null) {
                fVar.l0(11);
            } else {
                fVar.K(11, aVar.i().longValue());
            }
            Integer valueOf = aVar.j() == null ? null : Integer.valueOf(aVar.j().booleanValue() ? 1 : 0);
            if (valueOf == null) {
                fVar.l0(12);
            } else {
                fVar.K(12, valueOf.intValue());
            }
            if (aVar.o() == null) {
                fVar.l0(13);
            } else {
                fVar.y(13, aVar.o().floatValue());
            }
            if (aVar.m() == null) {
                fVar.l0(14);
            } else {
                fVar.K(14, aVar.m().intValue());
            }
            if (aVar.n() == null) {
                fVar.l0(15);
            } else {
                fVar.K(15, aVar.n().intValue());
            }
            if (aVar.p() == null) {
                fVar.l0(16);
            } else {
                fVar.K(16, aVar.p().intValue());
            }
            fVar.K(17, aVar.r());
            if (aVar.d() == null) {
                fVar.l0(18);
            } else {
                fVar.y(18, aVar.d().floatValue());
            }
        }
    }

    /* compiled from: FitnessDao_Impl.java */
    /* loaded from: classes2.dex */
    class b extends f1.g<ye.b> {
        b(d dVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "INSERT OR REPLACE INTO `RECORD` (`_id`,`HASH`,`TYPE`,`TARGET_TYPE`,`TARGET_VALUE`,`ACCOUNT_ID`,`SYNCED`,`DELETED`,`START_TIME`,`END_TIME`,`TIMESTAMP`,`DURATION`,`DISTANCE`,`CALORIE`,`STEP`,`HEART`,`GROUPS`,`SWIM_TRIPS`,`SWIM_DISTANCE`,`SWIM_POOL_LENGTH`,`SWIM_STROKE`,`DEVICE_ID`,`SESSION_MODE`,`MAX_ELEVATION`,`MIN_ELEVATION`,`CUMULATIVE_UP`,`CUMULATIVE_DOWN`,`SCORE`,`EXTRA`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* renamed from: m */
        public void g(i1.f fVar, ye.b bVar) {
            if (bVar.n() == null) {
                fVar.l0(1);
            } else {
                fVar.K(1, bVar.n().longValue());
            }
            if (bVar.l() == null) {
                fVar.l0(2);
            } else {
                fVar.m(2, bVar.l());
            }
            fVar.K(3, bVar.C());
            if (bVar.z() == null) {
                fVar.l0(4);
            } else {
                fVar.K(4, bVar.z().intValue());
            }
            if (bVar.A() == null) {
                fVar.l0(5);
            } else {
                fVar.y(5, bVar.A().floatValue());
            }
            if (bVar.a() == null) {
                fVar.l0(6);
            } else {
                fVar.m(6, bVar.a());
            }
            fVar.K(7, bVar.y());
            fVar.K(8, bVar.e() ? 1L : 0L);
            if (bVar.s() == null) {
                fVar.l0(9);
            } else {
                fVar.K(9, bVar.s().longValue());
            }
            if (bVar.i() == null) {
                fVar.l0(10);
            } else {
                fVar.K(10, bVar.i().longValue());
            }
            if (bVar.B() == null) {
                fVar.l0(11);
            } else {
                fVar.K(11, bVar.B().longValue());
            }
            fVar.K(12, bVar.h());
            if (bVar.g() == null) {
                fVar.l0(13);
            } else {
                fVar.K(13, bVar.g().intValue());
            }
            if (bVar.b() == null) {
                fVar.l0(14);
            } else {
                fVar.y(14, bVar.b().floatValue());
            }
            if (bVar.t() == null) {
                fVar.l0(15);
            } else {
                fVar.K(15, bVar.t().intValue());
            }
            if (bVar.m() == null) {
                fVar.l0(16);
            } else {
                fVar.K(16, bVar.m().intValue());
            }
            if (bVar.k() == null) {
                fVar.l0(17);
            } else {
                fVar.m(17, bVar.k());
            }
            if (bVar.x() == null) {
                fVar.l0(18);
            } else {
                fVar.y(18, bVar.x().floatValue());
            }
            if (bVar.u() == null) {
                fVar.l0(19);
            } else {
                fVar.K(19, bVar.u().intValue());
            }
            if (bVar.v() == null) {
                fVar.l0(20);
            } else {
                fVar.K(20, bVar.v().intValue());
            }
            if (bVar.w() == null) {
                fVar.l0(21);
            } else {
                fVar.K(21, bVar.w().intValue());
            }
            if (bVar.f() == null) {
                fVar.l0(22);
            } else {
                fVar.m(22, bVar.f());
            }
            if (bVar.r() == null) {
                fVar.l0(23);
            } else {
                fVar.K(23, bVar.r().intValue());
            }
            if (bVar.o() == null) {
                fVar.l0(24);
            } else {
                fVar.y(24, bVar.o().floatValue());
            }
            if (bVar.p() == null) {
                fVar.l0(25);
            } else {
                fVar.y(25, bVar.p().floatValue());
            }
            if (bVar.d() == null) {
                fVar.l0(26);
            } else {
                fVar.y(26, bVar.d().floatValue());
            }
            if (bVar.c() == null) {
                fVar.l0(27);
            } else {
                fVar.y(27, bVar.c().floatValue());
            }
            if (bVar.q() == null) {
                fVar.l0(28);
            } else {
                fVar.y(28, bVar.q().floatValue());
            }
            if (bVar.j() == null) {
                fVar.l0(29);
            } else {
                fVar.m(29, bVar.j());
            }
        }
    }

    /* compiled from: FitnessDao_Impl.java */
    /* loaded from: classes2.dex */
    class c extends f1.f<ye.a> {
        c(d dVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "DELETE FROM `POINT` WHERE `_id` = ?";
        }

        /* renamed from: j */
        public void g(i1.f fVar, ye.a aVar) {
            if (aVar.f() == null) {
                fVar.l0(1);
            } else {
                fVar.K(1, aVar.f().longValue());
            }
        }
    }

    /* compiled from: FitnessDao_Impl.java */
    /* renamed from: ye.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0538d extends f1.f<ye.b> {
        C0538d(d dVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "DELETE FROM `RECORD` WHERE `_id` = ?";
        }

        /* renamed from: j */
        public void g(i1.f fVar, ye.b bVar) {
            if (bVar.n() == null) {
                fVar.l0(1);
            } else {
                fVar.K(1, bVar.n().longValue());
            }
        }
    }

    /* compiled from: FitnessDao_Impl.java */
    /* loaded from: classes2.dex */
    class e extends f1.f<ye.a> {
        e(d dVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "UPDATE OR ABORT `POINT` SET `_id` = ?,`TIME` = ?,`HEART` = ?,`STEP` = ?,`LAT` = ?,`LON` = ?,`ACC` = ?,`DISTANCE` = ?,`SPEED` = ?,`CALORIE` = ?,`RECORD_ID` = ?,`RESUME` = ?,`SWIM_TRIPS` = ?,`SWIM_DISTANCE` = ?,`SWIM_STROKE` = ?,`SWIM_TYPE` = ?,`TIMESTAMP` = ?,`ELEVATION` = ? WHERE `_id` = ?";
        }

        /* renamed from: j */
        public void g(i1.f fVar, ye.a aVar) {
            if (aVar.f() == null) {
                fVar.l0(1);
            } else {
                fVar.K(1, aVar.f().longValue());
            }
            fVar.K(2, aVar.q());
            if (aVar.e() == null) {
                fVar.l0(3);
            } else {
                fVar.K(3, aVar.e().intValue());
            }
            if (aVar.l() == null) {
                fVar.l0(4);
            } else {
                fVar.K(4, aVar.l().intValue());
            }
            fVar.y(5, aVar.g());
            fVar.y(6, aVar.h());
            fVar.y(7, aVar.a());
            if (aVar.c() == null) {
                fVar.l0(8);
            } else {
                fVar.K(8, aVar.c().intValue());
            }
            if (aVar.k() == null) {
                fVar.l0(9);
            } else {
                fVar.y(9, aVar.k().floatValue());
            }
            if (aVar.b() == null) {
                fVar.l0(10);
            } else {
                fVar.y(10, aVar.b().floatValue());
            }
            if (aVar.i() == null) {
                fVar.l0(11);
            } else {
                fVar.K(11, aVar.i().longValue());
            }
            Integer valueOf = aVar.j() == null ? null : Integer.valueOf(aVar.j().booleanValue() ? 1 : 0);
            if (valueOf == null) {
                fVar.l0(12);
            } else {
                fVar.K(12, valueOf.intValue());
            }
            if (aVar.o() == null) {
                fVar.l0(13);
            } else {
                fVar.y(13, aVar.o().floatValue());
            }
            if (aVar.m() == null) {
                fVar.l0(14);
            } else {
                fVar.K(14, aVar.m().intValue());
            }
            if (aVar.n() == null) {
                fVar.l0(15);
            } else {
                fVar.K(15, aVar.n().intValue());
            }
            if (aVar.p() == null) {
                fVar.l0(16);
            } else {
                fVar.K(16, aVar.p().intValue());
            }
            fVar.K(17, aVar.r());
            if (aVar.d() == null) {
                fVar.l0(18);
            } else {
                fVar.y(18, aVar.d().floatValue());
            }
            if (aVar.f() == null) {
                fVar.l0(19);
            } else {
                fVar.K(19, aVar.f().longValue());
            }
        }
    }

    /* compiled from: FitnessDao_Impl.java */
    /* loaded from: classes2.dex */
    class f extends f1.f<ye.b> {
        f(d dVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "UPDATE OR ABORT `RECORD` SET `_id` = ?,`HASH` = ?,`TYPE` = ?,`TARGET_TYPE` = ?,`TARGET_VALUE` = ?,`ACCOUNT_ID` = ?,`SYNCED` = ?,`DELETED` = ?,`START_TIME` = ?,`END_TIME` = ?,`TIMESTAMP` = ?,`DURATION` = ?,`DISTANCE` = ?,`CALORIE` = ?,`STEP` = ?,`HEART` = ?,`GROUPS` = ?,`SWIM_TRIPS` = ?,`SWIM_DISTANCE` = ?,`SWIM_POOL_LENGTH` = ?,`SWIM_STROKE` = ?,`DEVICE_ID` = ?,`SESSION_MODE` = ?,`MAX_ELEVATION` = ?,`MIN_ELEVATION` = ?,`CUMULATIVE_UP` = ?,`CUMULATIVE_DOWN` = ?,`SCORE` = ?,`EXTRA` = ? WHERE `_id` = ?";
        }

        /* renamed from: j */
        public void g(i1.f fVar, ye.b bVar) {
            if (bVar.n() == null) {
                fVar.l0(1);
            } else {
                fVar.K(1, bVar.n().longValue());
            }
            if (bVar.l() == null) {
                fVar.l0(2);
            } else {
                fVar.m(2, bVar.l());
            }
            fVar.K(3, bVar.C());
            if (bVar.z() == null) {
                fVar.l0(4);
            } else {
                fVar.K(4, bVar.z().intValue());
            }
            if (bVar.A() == null) {
                fVar.l0(5);
            } else {
                fVar.y(5, bVar.A().floatValue());
            }
            if (bVar.a() == null) {
                fVar.l0(6);
            } else {
                fVar.m(6, bVar.a());
            }
            fVar.K(7, bVar.y());
            fVar.K(8, bVar.e() ? 1L : 0L);
            if (bVar.s() == null) {
                fVar.l0(9);
            } else {
                fVar.K(9, bVar.s().longValue());
            }
            if (bVar.i() == null) {
                fVar.l0(10);
            } else {
                fVar.K(10, bVar.i().longValue());
            }
            if (bVar.B() == null) {
                fVar.l0(11);
            } else {
                fVar.K(11, bVar.B().longValue());
            }
            fVar.K(12, bVar.h());
            if (bVar.g() == null) {
                fVar.l0(13);
            } else {
                fVar.K(13, bVar.g().intValue());
            }
            if (bVar.b() == null) {
                fVar.l0(14);
            } else {
                fVar.y(14, bVar.b().floatValue());
            }
            if (bVar.t() == null) {
                fVar.l0(15);
            } else {
                fVar.K(15, bVar.t().intValue());
            }
            if (bVar.m() == null) {
                fVar.l0(16);
            } else {
                fVar.K(16, bVar.m().intValue());
            }
            if (bVar.k() == null) {
                fVar.l0(17);
            } else {
                fVar.m(17, bVar.k());
            }
            if (bVar.x() == null) {
                fVar.l0(18);
            } else {
                fVar.y(18, bVar.x().floatValue());
            }
            if (bVar.u() == null) {
                fVar.l0(19);
            } else {
                fVar.K(19, bVar.u().intValue());
            }
            if (bVar.v() == null) {
                fVar.l0(20);
            } else {
                fVar.K(20, bVar.v().intValue());
            }
            if (bVar.w() == null) {
                fVar.l0(21);
            } else {
                fVar.K(21, bVar.w().intValue());
            }
            if (bVar.f() == null) {
                fVar.l0(22);
            } else {
                fVar.m(22, bVar.f());
            }
            if (bVar.r() == null) {
                fVar.l0(23);
            } else {
                fVar.K(23, bVar.r().intValue());
            }
            if (bVar.o() == null) {
                fVar.l0(24);
            } else {
                fVar.y(24, bVar.o().floatValue());
            }
            if (bVar.p() == null) {
                fVar.l0(25);
            } else {
                fVar.y(25, bVar.p().floatValue());
            }
            if (bVar.d() == null) {
                fVar.l0(26);
            } else {
                fVar.y(26, bVar.d().floatValue());
            }
            if (bVar.c() == null) {
                fVar.l0(27);
            } else {
                fVar.y(27, bVar.c().floatValue());
            }
            if (bVar.q() == null) {
                fVar.l0(28);
            } else {
                fVar.y(28, bVar.q().floatValue());
            }
            if (bVar.j() == null) {
                fVar.l0(29);
            } else {
                fVar.m(29, bVar.j());
            }
            if (bVar.n() == null) {
                fVar.l0(30);
            } else {
                fVar.K(30, bVar.n().longValue());
            }
        }
    }

    /* compiled from: FitnessDao_Impl.java */
    /* loaded from: classes2.dex */
    class g extends l {
        g(d dVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "DELETE FROM POINT WHERE RECORD_ID = ?";
        }
    }

    /* compiled from: FitnessDao_Impl.java */
    /* loaded from: classes2.dex */
    class h extends l {
        h(d dVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "DELETE FROM POINT";
        }
    }

    /* compiled from: FitnessDao_Impl.java */
    /* loaded from: classes2.dex */
    class i extends l {
        i(d dVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "DELETE FROM RECORD";
        }
    }

    public d(RoomDatabase roomDatabase) {
        this.f37066a = roomDatabase;
        this.f37067b = new a(this, roomDatabase);
        this.f37068c = new b(this, roomDatabase);
        this.f37069d = new c(this, roomDatabase);
        this.f37070e = new C0538d(this, roomDatabase);
        this.f37071f = new e(this, roomDatabase);
        this.f37072g = new f(this, roomDatabase);
        this.f37073h = new g(this, roomDatabase);
        this.f37074i = new h(this, roomDatabase);
        this.f37075j = new i(this, roomDatabase);
    }

    private ye.b u(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("_id");
        int columnIndex2 = cursor.getColumnIndex("HASH");
        int columnIndex3 = cursor.getColumnIndex("TYPE");
        int columnIndex4 = cursor.getColumnIndex("TARGET_TYPE");
        int columnIndex5 = cursor.getColumnIndex("TARGET_VALUE");
        int columnIndex6 = cursor.getColumnIndex("ACCOUNT_ID");
        int columnIndex7 = cursor.getColumnIndex("SYNCED");
        int columnIndex8 = cursor.getColumnIndex("DELETED");
        int columnIndex9 = cursor.getColumnIndex("START_TIME");
        int columnIndex10 = cursor.getColumnIndex("END_TIME");
        int columnIndex11 = cursor.getColumnIndex("TIMESTAMP");
        int columnIndex12 = cursor.getColumnIndex("DURATION");
        int columnIndex13 = cursor.getColumnIndex("DISTANCE");
        int columnIndex14 = cursor.getColumnIndex("CALORIE");
        int columnIndex15 = cursor.getColumnIndex("STEP");
        int columnIndex16 = cursor.getColumnIndex("HEART");
        int columnIndex17 = cursor.getColumnIndex("GROUPS");
        int columnIndex18 = cursor.getColumnIndex("SWIM_TRIPS");
        int columnIndex19 = cursor.getColumnIndex("SWIM_DISTANCE");
        int columnIndex20 = cursor.getColumnIndex("SWIM_POOL_LENGTH");
        int columnIndex21 = cursor.getColumnIndex("SWIM_STROKE");
        int columnIndex22 = cursor.getColumnIndex("DEVICE_ID");
        int columnIndex23 = cursor.getColumnIndex("SESSION_MODE");
        int columnIndex24 = cursor.getColumnIndex("MAX_ELEVATION");
        int columnIndex25 = cursor.getColumnIndex("MIN_ELEVATION");
        int columnIndex26 = cursor.getColumnIndex("CUMULATIVE_UP");
        int columnIndex27 = cursor.getColumnIndex("CUMULATIVE_DOWN");
        int columnIndex28 = cursor.getColumnIndex("SCORE");
        int columnIndex29 = cursor.getColumnIndex("EXTRA");
        ye.b bVar = new ye.b();
        String str = null;
        if (columnIndex != -1) {
            bVar.Q(cursor.isNull(columnIndex) ? null : Long.valueOf(cursor.getLong(columnIndex)));
        }
        if (columnIndex2 != -1) {
            bVar.O(cursor.isNull(columnIndex2) ? null : cursor.getString(columnIndex2));
        }
        if (columnIndex3 != -1) {
            bVar.f0(cursor.getInt(columnIndex3));
        }
        if (columnIndex4 != -1) {
            bVar.c0(cursor.isNull(columnIndex4) ? null : Integer.valueOf(cursor.getInt(columnIndex4)));
        }
        if (columnIndex5 != -1) {
            bVar.d0(cursor.isNull(columnIndex5) ? null : Float.valueOf(cursor.getFloat(columnIndex5)));
        }
        if (columnIndex6 != -1) {
            bVar.D(cursor.isNull(columnIndex6) ? null : cursor.getString(columnIndex6));
        }
        if (columnIndex7 != -1) {
            bVar.b0(cursor.getInt(columnIndex7));
        }
        if (columnIndex8 != -1) {
            bVar.H(cursor.getInt(columnIndex8) != 0);
        }
        if (columnIndex9 != -1) {
            bVar.V(cursor.isNull(columnIndex9) ? null : Long.valueOf(cursor.getLong(columnIndex9)));
        }
        if (columnIndex10 != -1) {
            bVar.L(cursor.isNull(columnIndex10) ? null : Long.valueOf(cursor.getLong(columnIndex10)));
        }
        if (columnIndex11 != -1) {
            bVar.e0(cursor.isNull(columnIndex11) ? null : Long.valueOf(cursor.getLong(columnIndex11)));
        }
        if (columnIndex12 != -1) {
            bVar.K(cursor.getLong(columnIndex12));
        }
        if (columnIndex13 != -1) {
            bVar.J(cursor.isNull(columnIndex13) ? null : Integer.valueOf(cursor.getInt(columnIndex13)));
        }
        if (columnIndex14 != -1) {
            bVar.E(cursor.isNull(columnIndex14) ? null : Float.valueOf(cursor.getFloat(columnIndex14)));
        }
        if (columnIndex15 != -1) {
            bVar.W(cursor.isNull(columnIndex15) ? null : Integer.valueOf(cursor.getInt(columnIndex15)));
        }
        if (columnIndex16 != -1) {
            bVar.P(cursor.isNull(columnIndex16) ? null : Integer.valueOf(cursor.getInt(columnIndex16)));
        }
        if (columnIndex17 != -1) {
            bVar.N(cursor.isNull(columnIndex17) ? null : cursor.getString(columnIndex17));
        }
        if (columnIndex18 != -1) {
            bVar.a0(cursor.isNull(columnIndex18) ? null : Float.valueOf(cursor.getFloat(columnIndex18)));
        }
        if (columnIndex19 != -1) {
            bVar.X(cursor.isNull(columnIndex19) ? null : Integer.valueOf(cursor.getInt(columnIndex19)));
        }
        if (columnIndex20 != -1) {
            bVar.Y(cursor.isNull(columnIndex20) ? null : Integer.valueOf(cursor.getInt(columnIndex20)));
        }
        if (columnIndex21 != -1) {
            bVar.Z(cursor.isNull(columnIndex21) ? null : Integer.valueOf(cursor.getInt(columnIndex21)));
        }
        if (columnIndex22 != -1) {
            bVar.I(cursor.isNull(columnIndex22) ? null : cursor.getString(columnIndex22));
        }
        if (columnIndex23 != -1) {
            bVar.U(cursor.isNull(columnIndex23) ? null : Integer.valueOf(cursor.getInt(columnIndex23)));
        }
        if (columnIndex24 != -1) {
            bVar.R(cursor.isNull(columnIndex24) ? null : Float.valueOf(cursor.getFloat(columnIndex24)));
        }
        if (columnIndex25 != -1) {
            bVar.S(cursor.isNull(columnIndex25) ? null : Float.valueOf(cursor.getFloat(columnIndex25)));
        }
        if (columnIndex26 != -1) {
            bVar.G(cursor.isNull(columnIndex26) ? null : Float.valueOf(cursor.getFloat(columnIndex26)));
        }
        if (columnIndex27 != -1) {
            bVar.F(cursor.isNull(columnIndex27) ? null : Float.valueOf(cursor.getFloat(columnIndex27)));
        }
        if (columnIndex28 != -1) {
            bVar.T(cursor.isNull(columnIndex28) ? null : Float.valueOf(cursor.getFloat(columnIndex28)));
        }
        if (columnIndex29 != -1) {
            if (!cursor.isNull(columnIndex29)) {
                str = cursor.getString(columnIndex29);
            }
            bVar.M(str);
        }
        return bVar;
    }

    public static List<Class<?>> v() {
        return Collections.emptyList();
    }

    @Override // ye.c
    public List<ye.b> a(int i10) {
        k kVar;
        Throwable th2;
        int i11;
        Long l10;
        int i12;
        Integer num;
        Integer num2;
        String str;
        Float f10;
        Integer num3;
        Integer num4;
        Integer num5;
        String str2;
        Integer num6;
        Float f11;
        Float f12;
        Float f13;
        Float f14;
        Float f15;
        String str3;
        k h10 = k.h("SELECT * FROM RECORD WHERE ( ACCOUNT_ID IS NULL OR ACCOUNT_ID = '') AND SYNCED <> ? AND END_TIME > 0 AND DELETED = 0", 1);
        h10.K(1, i10);
        this.f37066a.d();
        Cursor b10 = h1.c.b(this.f37066a, h10, false, null);
        try {
            int e10 = h1.b.e(b10, "_id");
            int e11 = h1.b.e(b10, "HASH");
            int e12 = h1.b.e(b10, "TYPE");
            int e13 = h1.b.e(b10, "TARGET_TYPE");
            int e14 = h1.b.e(b10, "TARGET_VALUE");
            int e15 = h1.b.e(b10, "ACCOUNT_ID");
            int e16 = h1.b.e(b10, "SYNCED");
            int e17 = h1.b.e(b10, "DELETED");
            int e18 = h1.b.e(b10, "START_TIME");
            int e19 = h1.b.e(b10, "END_TIME");
            int e20 = h1.b.e(b10, "TIMESTAMP");
            int e21 = h1.b.e(b10, "DURATION");
            int e22 = h1.b.e(b10, "DISTANCE");
            int e23 = h1.b.e(b10, "CALORIE");
            kVar = h10;
            try {
                int e24 = h1.b.e(b10, "STEP");
                int e25 = h1.b.e(b10, "HEART");
                int e26 = h1.b.e(b10, "GROUPS");
                int e27 = h1.b.e(b10, "SWIM_TRIPS");
                int e28 = h1.b.e(b10, "SWIM_DISTANCE");
                int e29 = h1.b.e(b10, "SWIM_POOL_LENGTH");
                int e30 = h1.b.e(b10, "SWIM_STROKE");
                int e31 = h1.b.e(b10, "DEVICE_ID");
                int e32 = h1.b.e(b10, "SESSION_MODE");
                int e33 = h1.b.e(b10, "MAX_ELEVATION");
                int e34 = h1.b.e(b10, "MIN_ELEVATION");
                int e35 = h1.b.e(b10, "CUMULATIVE_UP");
                int e36 = h1.b.e(b10, "CUMULATIVE_DOWN");
                int e37 = h1.b.e(b10, "SCORE");
                int e38 = h1.b.e(b10, "EXTRA");
                int i13 = e23;
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    ye.b bVar = new ye.b();
                    if (b10.isNull(e10)) {
                        i11 = e10;
                        l10 = null;
                    } else {
                        l10 = Long.valueOf(b10.getLong(e10));
                        i11 = e10;
                    }
                    bVar.Q(l10);
                    bVar.O(b10.isNull(e11) ? null : b10.getString(e11));
                    bVar.f0(b10.getInt(e12));
                    bVar.c0(b10.isNull(e13) ? null : Integer.valueOf(b10.getInt(e13)));
                    bVar.d0(b10.isNull(e14) ? null : Float.valueOf(b10.getFloat(e14)));
                    bVar.D(b10.isNull(e15) ? null : b10.getString(e15));
                    bVar.b0(b10.getInt(e16));
                    bVar.H(b10.getInt(e17) != 0);
                    bVar.V(b10.isNull(e18) ? null : Long.valueOf(b10.getLong(e18)));
                    bVar.L(b10.isNull(e19) ? null : Long.valueOf(b10.getLong(e19)));
                    bVar.e0(b10.isNull(e20) ? null : Long.valueOf(b10.getLong(e20)));
                    int i14 = e11;
                    e12 = e12;
                    bVar.K(b10.getLong(e21));
                    bVar.J(b10.isNull(e22) ? null : Integer.valueOf(b10.getInt(e22)));
                    int i15 = i13;
                    bVar.E(b10.isNull(i15) ? null : Float.valueOf(b10.getFloat(i15)));
                    int i16 = e24;
                    if (b10.isNull(i16)) {
                        i12 = i14;
                        num = null;
                    } else {
                        num = Integer.valueOf(b10.getInt(i16));
                        i12 = i14;
                    }
                    bVar.W(num);
                    int i17 = e25;
                    if (b10.isNull(i17)) {
                        e25 = i17;
                        num2 = null;
                    } else {
                        num2 = Integer.valueOf(b10.getInt(i17));
                        e25 = i17;
                    }
                    bVar.P(num2);
                    int i18 = e26;
                    if (b10.isNull(i18)) {
                        e26 = i18;
                        str = null;
                    } else {
                        e26 = i18;
                        str = b10.getString(i18);
                    }
                    bVar.N(str);
                    int i19 = e27;
                    if (b10.isNull(i19)) {
                        e27 = i19;
                        f10 = null;
                    } else {
                        f10 = Float.valueOf(b10.getFloat(i19));
                        e27 = i19;
                    }
                    bVar.a0(f10);
                    int i20 = e28;
                    if (b10.isNull(i20)) {
                        e28 = i20;
                        num3 = null;
                    } else {
                        num3 = Integer.valueOf(b10.getInt(i20));
                        e28 = i20;
                    }
                    bVar.X(num3);
                    int i21 = e29;
                    if (b10.isNull(i21)) {
                        e29 = i21;
                        num4 = null;
                    } else {
                        num4 = Integer.valueOf(b10.getInt(i21));
                        e29 = i21;
                    }
                    bVar.Y(num4);
                    int i22 = e30;
                    if (b10.isNull(i22)) {
                        e30 = i22;
                        num5 = null;
                    } else {
                        num5 = Integer.valueOf(b10.getInt(i22));
                        e30 = i22;
                    }
                    bVar.Z(num5);
                    int i23 = e31;
                    if (b10.isNull(i23)) {
                        e31 = i23;
                        str2 = null;
                    } else {
                        e31 = i23;
                        str2 = b10.getString(i23);
                    }
                    bVar.I(str2);
                    int i24 = e32;
                    if (b10.isNull(i24)) {
                        e32 = i24;
                        num6 = null;
                    } else {
                        num6 = Integer.valueOf(b10.getInt(i24));
                        e32 = i24;
                    }
                    bVar.U(num6);
                    int i25 = e33;
                    if (b10.isNull(i25)) {
                        e33 = i25;
                        f11 = null;
                    } else {
                        f11 = Float.valueOf(b10.getFloat(i25));
                        e33 = i25;
                    }
                    bVar.R(f11);
                    int i26 = e34;
                    if (b10.isNull(i26)) {
                        e34 = i26;
                        f12 = null;
                    } else {
                        f12 = Float.valueOf(b10.getFloat(i26));
                        e34 = i26;
                    }
                    bVar.S(f12);
                    int i27 = e35;
                    if (b10.isNull(i27)) {
                        e35 = i27;
                        f13 = null;
                    } else {
                        f13 = Float.valueOf(b10.getFloat(i27));
                        e35 = i27;
                    }
                    bVar.G(f13);
                    int i28 = e36;
                    if (b10.isNull(i28)) {
                        e36 = i28;
                        f14 = null;
                    } else {
                        f14 = Float.valueOf(b10.getFloat(i28));
                        e36 = i28;
                    }
                    bVar.F(f14);
                    int i29 = e37;
                    if (b10.isNull(i29)) {
                        e37 = i29;
                        f15 = null;
                    } else {
                        f15 = Float.valueOf(b10.getFloat(i29));
                        e37 = i29;
                    }
                    bVar.T(f15);
                    int i30 = e38;
                    if (b10.isNull(i30)) {
                        e38 = i30;
                        str3 = null;
                    } else {
                        e38 = i30;
                        str3 = b10.getString(i30);
                    }
                    bVar.M(str3);
                    arrayList.add(bVar);
                    e24 = i16;
                    e10 = i11;
                    e11 = i12;
                    i13 = i15;
                }
                b10.close();
                kVar.o();
                return arrayList;
            } catch (Throwable th3) {
                th2 = th3;
                b10.close();
                kVar.o();
                throw th2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            kVar = h10;
        }
    }

    @Override // ye.c
    public long b(ye.b bVar) {
        this.f37066a.d();
        this.f37066a.e();
        try {
            long k10 = this.f37068c.k(bVar);
            this.f37066a.B();
            return k10;
        } finally {
            this.f37066a.i();
        }
    }

    @Override // ye.c
    public List<ye.b> c() {
        k kVar;
        Throwable th2;
        int i10;
        Long l10;
        int i11;
        Integer num;
        Integer num2;
        String str;
        Float f10;
        Integer num3;
        Integer num4;
        Integer num5;
        String str2;
        Integer num6;
        Float f11;
        Float f12;
        Float f13;
        Float f14;
        Float f15;
        String str3;
        k h10 = k.h("SELECT * FROM RECORD WHERE ( ACCOUNT_ID IS NULL OR ACCOUNT_ID = '') AND START_TIME > 0 AND END_TIME > 0 AND DELETED = 0", 0);
        this.f37066a.d();
        Cursor b10 = h1.c.b(this.f37066a, h10, false, null);
        try {
            int e10 = h1.b.e(b10, "_id");
            int e11 = h1.b.e(b10, "HASH");
            int e12 = h1.b.e(b10, "TYPE");
            int e13 = h1.b.e(b10, "TARGET_TYPE");
            int e14 = h1.b.e(b10, "TARGET_VALUE");
            int e15 = h1.b.e(b10, "ACCOUNT_ID");
            int e16 = h1.b.e(b10, "SYNCED");
            int e17 = h1.b.e(b10, "DELETED");
            int e18 = h1.b.e(b10, "START_TIME");
            int e19 = h1.b.e(b10, "END_TIME");
            int e20 = h1.b.e(b10, "TIMESTAMP");
            int e21 = h1.b.e(b10, "DURATION");
            int e22 = h1.b.e(b10, "DISTANCE");
            int e23 = h1.b.e(b10, "CALORIE");
            kVar = h10;
            try {
                int e24 = h1.b.e(b10, "STEP");
                int e25 = h1.b.e(b10, "HEART");
                int e26 = h1.b.e(b10, "GROUPS");
                int e27 = h1.b.e(b10, "SWIM_TRIPS");
                int e28 = h1.b.e(b10, "SWIM_DISTANCE");
                int e29 = h1.b.e(b10, "SWIM_POOL_LENGTH");
                int e30 = h1.b.e(b10, "SWIM_STROKE");
                int e31 = h1.b.e(b10, "DEVICE_ID");
                int e32 = h1.b.e(b10, "SESSION_MODE");
                int e33 = h1.b.e(b10, "MAX_ELEVATION");
                int e34 = h1.b.e(b10, "MIN_ELEVATION");
                int e35 = h1.b.e(b10, "CUMULATIVE_UP");
                int e36 = h1.b.e(b10, "CUMULATIVE_DOWN");
                int e37 = h1.b.e(b10, "SCORE");
                int e38 = h1.b.e(b10, "EXTRA");
                int i12 = e23;
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    ye.b bVar = new ye.b();
                    if (b10.isNull(e10)) {
                        i10 = e10;
                        l10 = null;
                    } else {
                        l10 = Long.valueOf(b10.getLong(e10));
                        i10 = e10;
                    }
                    bVar.Q(l10);
                    bVar.O(b10.isNull(e11) ? null : b10.getString(e11));
                    bVar.f0(b10.getInt(e12));
                    bVar.c0(b10.isNull(e13) ? null : Integer.valueOf(b10.getInt(e13)));
                    bVar.d0(b10.isNull(e14) ? null : Float.valueOf(b10.getFloat(e14)));
                    bVar.D(b10.isNull(e15) ? null : b10.getString(e15));
                    bVar.b0(b10.getInt(e16));
                    bVar.H(b10.getInt(e17) != 0);
                    bVar.V(b10.isNull(e18) ? null : Long.valueOf(b10.getLong(e18)));
                    bVar.L(b10.isNull(e19) ? null : Long.valueOf(b10.getLong(e19)));
                    bVar.e0(b10.isNull(e20) ? null : Long.valueOf(b10.getLong(e20)));
                    int i13 = e11;
                    e12 = e12;
                    bVar.K(b10.getLong(e21));
                    bVar.J(b10.isNull(e22) ? null : Integer.valueOf(b10.getInt(e22)));
                    int i14 = i12;
                    bVar.E(b10.isNull(i14) ? null : Float.valueOf(b10.getFloat(i14)));
                    int i15 = e24;
                    if (b10.isNull(i15)) {
                        i11 = i13;
                        num = null;
                    } else {
                        num = Integer.valueOf(b10.getInt(i15));
                        i11 = i13;
                    }
                    bVar.W(num);
                    int i16 = e25;
                    if (b10.isNull(i16)) {
                        e25 = i16;
                        num2 = null;
                    } else {
                        num2 = Integer.valueOf(b10.getInt(i16));
                        e25 = i16;
                    }
                    bVar.P(num2);
                    int i17 = e26;
                    if (b10.isNull(i17)) {
                        e26 = i17;
                        str = null;
                    } else {
                        e26 = i17;
                        str = b10.getString(i17);
                    }
                    bVar.N(str);
                    int i18 = e27;
                    if (b10.isNull(i18)) {
                        e27 = i18;
                        f10 = null;
                    } else {
                        f10 = Float.valueOf(b10.getFloat(i18));
                        e27 = i18;
                    }
                    bVar.a0(f10);
                    int i19 = e28;
                    if (b10.isNull(i19)) {
                        e28 = i19;
                        num3 = null;
                    } else {
                        num3 = Integer.valueOf(b10.getInt(i19));
                        e28 = i19;
                    }
                    bVar.X(num3);
                    int i20 = e29;
                    if (b10.isNull(i20)) {
                        e29 = i20;
                        num4 = null;
                    } else {
                        num4 = Integer.valueOf(b10.getInt(i20));
                        e29 = i20;
                    }
                    bVar.Y(num4);
                    int i21 = e30;
                    if (b10.isNull(i21)) {
                        e30 = i21;
                        num5 = null;
                    } else {
                        num5 = Integer.valueOf(b10.getInt(i21));
                        e30 = i21;
                    }
                    bVar.Z(num5);
                    int i22 = e31;
                    if (b10.isNull(i22)) {
                        e31 = i22;
                        str2 = null;
                    } else {
                        e31 = i22;
                        str2 = b10.getString(i22);
                    }
                    bVar.I(str2);
                    int i23 = e32;
                    if (b10.isNull(i23)) {
                        e32 = i23;
                        num6 = null;
                    } else {
                        num6 = Integer.valueOf(b10.getInt(i23));
                        e32 = i23;
                    }
                    bVar.U(num6);
                    int i24 = e33;
                    if (b10.isNull(i24)) {
                        e33 = i24;
                        f11 = null;
                    } else {
                        f11 = Float.valueOf(b10.getFloat(i24));
                        e33 = i24;
                    }
                    bVar.R(f11);
                    int i25 = e34;
                    if (b10.isNull(i25)) {
                        e34 = i25;
                        f12 = null;
                    } else {
                        f12 = Float.valueOf(b10.getFloat(i25));
                        e34 = i25;
                    }
                    bVar.S(f12);
                    int i26 = e35;
                    if (b10.isNull(i26)) {
                        e35 = i26;
                        f13 = null;
                    } else {
                        f13 = Float.valueOf(b10.getFloat(i26));
                        e35 = i26;
                    }
                    bVar.G(f13);
                    int i27 = e36;
                    if (b10.isNull(i27)) {
                        e36 = i27;
                        f14 = null;
                    } else {
                        f14 = Float.valueOf(b10.getFloat(i27));
                        e36 = i27;
                    }
                    bVar.F(f14);
                    int i28 = e37;
                    if (b10.isNull(i28)) {
                        e37 = i28;
                        f15 = null;
                    } else {
                        f15 = Float.valueOf(b10.getFloat(i28));
                        e37 = i28;
                    }
                    bVar.T(f15);
                    int i29 = e38;
                    if (b10.isNull(i29)) {
                        e38 = i29;
                        str3 = null;
                    } else {
                        e38 = i29;
                        str3 = b10.getString(i29);
                    }
                    bVar.M(str3);
                    arrayList.add(bVar);
                    e24 = i15;
                    e10 = i10;
                    e11 = i11;
                    i12 = i14;
                }
                b10.close();
                kVar.o();
                return arrayList;
            } catch (Throwable th3) {
                th2 = th3;
                b10.close();
                kVar.o();
                throw th2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            kVar = h10;
        }
    }

    @Override // ye.c
    public List<ye.a> d(Long l10, Long l11) {
        k kVar;
        Throwable th2;
        int e10;
        int e11;
        int e12;
        int e13;
        int e14;
        int e15;
        int e16;
        int e17;
        int e18;
        int e19;
        int e20;
        int e21;
        int e22;
        int e23;
        int i10;
        Long l12;
        Boolean bool;
        int i11;
        Integer num;
        int i12;
        Integer num2;
        Integer num3;
        k h10 = k.h("SELECT * FROM POINT WHERE RECORD_ID  = ? AND TIME = ?", 2);
        if (l10 == null) {
            h10.l0(1);
        } else {
            h10.K(1, l10.longValue());
        }
        if (l11 == null) {
            h10.l0(2);
        } else {
            h10.K(2, l11.longValue());
        }
        this.f37066a.d();
        Cursor b10 = h1.c.b(this.f37066a, h10, false, null);
        try {
            e10 = h1.b.e(b10, "_id");
            e11 = h1.b.e(b10, "TIME");
            e12 = h1.b.e(b10, "HEART");
            e13 = h1.b.e(b10, "STEP");
            e14 = h1.b.e(b10, "LAT");
            e15 = h1.b.e(b10, "LON");
            e16 = h1.b.e(b10, "ACC");
            e17 = h1.b.e(b10, "DISTANCE");
            e18 = h1.b.e(b10, "SPEED");
            e19 = h1.b.e(b10, "CALORIE");
            e20 = h1.b.e(b10, "RECORD_ID");
            e21 = h1.b.e(b10, "RESUME");
            e22 = h1.b.e(b10, "SWIM_TRIPS");
            e23 = h1.b.e(b10, "SWIM_DISTANCE");
            kVar = h10;
        } catch (Throwable th3) {
            th2 = th3;
            kVar = h10;
        }
        try {
            int e24 = h1.b.e(b10, "SWIM_STROKE");
            int e25 = h1.b.e(b10, "SWIM_TYPE");
            int e26 = h1.b.e(b10, "TIMESTAMP");
            int e27 = h1.b.e(b10, "ELEVATION");
            int i13 = e23;
            ArrayList arrayList = new ArrayList(b10.getCount());
            while (b10.moveToNext()) {
                ye.a aVar = new ye.a();
                if (b10.isNull(e10)) {
                    i10 = e10;
                    l12 = null;
                } else {
                    l12 = Long.valueOf(b10.getLong(e10));
                    i10 = e10;
                }
                aVar.y(l12);
                int i14 = e22;
                aVar.J(b10.getLong(e11));
                aVar.x(b10.isNull(e12) ? null : Integer.valueOf(b10.getInt(e12)));
                aVar.E(b10.isNull(e13) ? null : Integer.valueOf(b10.getInt(e13)));
                aVar.z(b10.getDouble(e14));
                aVar.A(b10.getDouble(e15));
                aVar.s(b10.getFloat(e16));
                aVar.v(b10.isNull(e17) ? null : Integer.valueOf(b10.getInt(e17)));
                aVar.D(b10.isNull(e18) ? null : Float.valueOf(b10.getFloat(e18)));
                aVar.t(b10.isNull(e19) ? null : Float.valueOf(b10.getFloat(e19)));
                aVar.B(b10.isNull(e20) ? null : Long.valueOf(b10.getLong(e20)));
                Integer valueOf = b10.isNull(e21) ? null : Integer.valueOf(b10.getInt(e21));
                if (valueOf == null) {
                    bool = null;
                } else {
                    bool = Boolean.valueOf(valueOf.intValue() != 0);
                }
                aVar.C(bool);
                aVar.H(b10.isNull(i14) ? null : Float.valueOf(b10.getFloat(i14)));
                int i15 = i13;
                if (b10.isNull(i15)) {
                    i11 = e20;
                    num = null;
                } else {
                    num = Integer.valueOf(b10.getInt(i15));
                    i11 = e20;
                }
                aVar.F(num);
                int i16 = e24;
                if (b10.isNull(i16)) {
                    i12 = i16;
                    num2 = null;
                } else {
                    num2 = Integer.valueOf(b10.getInt(i16));
                    i12 = i16;
                }
                aVar.G(num2);
                int i17 = e25;
                if (b10.isNull(i17)) {
                    e25 = i17;
                    num3 = null;
                } else {
                    num3 = Integer.valueOf(b10.getInt(i17));
                    e25 = i17;
                }
                aVar.I(num3);
                e21 = e21;
                int i18 = e26;
                aVar.K(b10.getLong(i18));
                int i19 = e27;
                aVar.w(b10.isNull(i19) ? null : Float.valueOf(b10.getFloat(i19)));
                arrayList.add(aVar);
                e27 = i19;
                e22 = i14;
                e24 = i12;
                e26 = i18;
                i13 = i15;
                e20 = i11;
                e10 = i10;
            }
            b10.close();
            kVar.o();
            return arrayList;
        } catch (Throwable th4) {
            th2 = th4;
            b10.close();
            kVar.o();
            throw th2;
        }
    }

    @Override // ye.c
    public List<ye.b> e(long j10, long j11, int i10) {
        k kVar;
        Throwable th2;
        int e10;
        int e11;
        int e12;
        int e13;
        int e14;
        int e15;
        int e16;
        int e17;
        int e18;
        int e19;
        int e20;
        int e21;
        int e22;
        int e23;
        int i11;
        Long l10;
        int i12;
        Integer num;
        Integer num2;
        String str;
        int i13;
        Float f10;
        Integer num3;
        Integer num4;
        Integer num5;
        String str2;
        Integer num6;
        Float f11;
        Float f12;
        Float f13;
        Float f14;
        Float f15;
        String str3;
        k h10 = k.h("SELECT * FROM RECORD WHERE ( ACCOUNT_ID IS NULL OR ACCOUNT_ID = '') AND START_TIME < ? AND START_TIME >= ? AND END_TIME > 0 AND DELETED = 0 ORDER BY START_TIME ASC  LIMIT ?", 3);
        h10.K(1, j10);
        h10.K(2, j11);
        h10.K(3, i10);
        this.f37066a.d();
        Cursor b10 = h1.c.b(this.f37066a, h10, false, null);
        try {
            e10 = h1.b.e(b10, "_id");
            e11 = h1.b.e(b10, "HASH");
            e12 = h1.b.e(b10, "TYPE");
            e13 = h1.b.e(b10, "TARGET_TYPE");
            e14 = h1.b.e(b10, "TARGET_VALUE");
            e15 = h1.b.e(b10, "ACCOUNT_ID");
            e16 = h1.b.e(b10, "SYNCED");
            e17 = h1.b.e(b10, "DELETED");
            e18 = h1.b.e(b10, "START_TIME");
            e19 = h1.b.e(b10, "END_TIME");
            e20 = h1.b.e(b10, "TIMESTAMP");
            e21 = h1.b.e(b10, "DURATION");
            e22 = h1.b.e(b10, "DISTANCE");
            e23 = h1.b.e(b10, "CALORIE");
            kVar = h10;
        } catch (Throwable th3) {
            th2 = th3;
            kVar = h10;
        }
        try {
            int e24 = h1.b.e(b10, "STEP");
            int e25 = h1.b.e(b10, "HEART");
            int e26 = h1.b.e(b10, "GROUPS");
            int e27 = h1.b.e(b10, "SWIM_TRIPS");
            int e28 = h1.b.e(b10, "SWIM_DISTANCE");
            int e29 = h1.b.e(b10, "SWIM_POOL_LENGTH");
            int e30 = h1.b.e(b10, "SWIM_STROKE");
            int e31 = h1.b.e(b10, "DEVICE_ID");
            int e32 = h1.b.e(b10, "SESSION_MODE");
            int e33 = h1.b.e(b10, "MAX_ELEVATION");
            int e34 = h1.b.e(b10, "MIN_ELEVATION");
            int e35 = h1.b.e(b10, "CUMULATIVE_UP");
            int e36 = h1.b.e(b10, "CUMULATIVE_DOWN");
            int e37 = h1.b.e(b10, "SCORE");
            int e38 = h1.b.e(b10, "EXTRA");
            int i14 = e23;
            ArrayList arrayList = new ArrayList(b10.getCount());
            while (b10.moveToNext()) {
                ye.b bVar = new ye.b();
                if (b10.isNull(e10)) {
                    i11 = e10;
                    l10 = null;
                } else {
                    l10 = Long.valueOf(b10.getLong(e10));
                    i11 = e10;
                }
                bVar.Q(l10);
                bVar.O(b10.isNull(e11) ? null : b10.getString(e11));
                bVar.f0(b10.getInt(e12));
                bVar.c0(b10.isNull(e13) ? null : Integer.valueOf(b10.getInt(e13)));
                bVar.d0(b10.isNull(e14) ? null : Float.valueOf(b10.getFloat(e14)));
                bVar.D(b10.isNull(e15) ? null : b10.getString(e15));
                bVar.b0(b10.getInt(e16));
                bVar.H(b10.getInt(e17) != 0);
                bVar.V(b10.isNull(e18) ? null : Long.valueOf(b10.getLong(e18)));
                bVar.L(b10.isNull(e19) ? null : Long.valueOf(b10.getLong(e19)));
                bVar.e0(b10.isNull(e20) ? null : Long.valueOf(b10.getLong(e20)));
                e11 = e11;
                bVar.K(b10.getLong(e21));
                bVar.J(b10.isNull(e22) ? null : Integer.valueOf(b10.getInt(e22)));
                int i15 = i14;
                bVar.E(b10.isNull(i15) ? null : Float.valueOf(b10.getFloat(i15)));
                int i16 = e24;
                if (b10.isNull(i16)) {
                    i12 = e20;
                    num = null;
                } else {
                    num = Integer.valueOf(b10.getInt(i16));
                    i12 = e20;
                }
                bVar.W(num);
                int i17 = e25;
                if (b10.isNull(i17)) {
                    e25 = i17;
                    num2 = null;
                } else {
                    num2 = Integer.valueOf(b10.getInt(i17));
                    e25 = i17;
                }
                bVar.P(num2);
                int i18 = e26;
                if (b10.isNull(i18)) {
                    e26 = i18;
                    str = null;
                } else {
                    e26 = i18;
                    str = b10.getString(i18);
                }
                bVar.N(str);
                int i19 = e27;
                if (b10.isNull(i19)) {
                    i13 = i19;
                    f10 = null;
                } else {
                    f10 = Float.valueOf(b10.getFloat(i19));
                    i13 = i19;
                }
                bVar.a0(f10);
                int i20 = e28;
                if (b10.isNull(i20)) {
                    e28 = i20;
                    num3 = null;
                } else {
                    num3 = Integer.valueOf(b10.getInt(i20));
                    e28 = i20;
                }
                bVar.X(num3);
                int i21 = e29;
                if (b10.isNull(i21)) {
                    e29 = i21;
                    num4 = null;
                } else {
                    num4 = Integer.valueOf(b10.getInt(i21));
                    e29 = i21;
                }
                bVar.Y(num4);
                int i22 = e30;
                if (b10.isNull(i22)) {
                    e30 = i22;
                    num5 = null;
                } else {
                    num5 = Integer.valueOf(b10.getInt(i22));
                    e30 = i22;
                }
                bVar.Z(num5);
                int i23 = e31;
                if (b10.isNull(i23)) {
                    e31 = i23;
                    str2 = null;
                } else {
                    e31 = i23;
                    str2 = b10.getString(i23);
                }
                bVar.I(str2);
                int i24 = e32;
                if (b10.isNull(i24)) {
                    e32 = i24;
                    num6 = null;
                } else {
                    num6 = Integer.valueOf(b10.getInt(i24));
                    e32 = i24;
                }
                bVar.U(num6);
                int i25 = e33;
                if (b10.isNull(i25)) {
                    e33 = i25;
                    f11 = null;
                } else {
                    f11 = Float.valueOf(b10.getFloat(i25));
                    e33 = i25;
                }
                bVar.R(f11);
                int i26 = e34;
                if (b10.isNull(i26)) {
                    e34 = i26;
                    f12 = null;
                } else {
                    f12 = Float.valueOf(b10.getFloat(i26));
                    e34 = i26;
                }
                bVar.S(f12);
                int i27 = e35;
                if (b10.isNull(i27)) {
                    e35 = i27;
                    f13 = null;
                } else {
                    f13 = Float.valueOf(b10.getFloat(i27));
                    e35 = i27;
                }
                bVar.G(f13);
                int i28 = e36;
                if (b10.isNull(i28)) {
                    e36 = i28;
                    f14 = null;
                } else {
                    f14 = Float.valueOf(b10.getFloat(i28));
                    e36 = i28;
                }
                bVar.F(f14);
                int i29 = e37;
                if (b10.isNull(i29)) {
                    e37 = i29;
                    f15 = null;
                } else {
                    f15 = Float.valueOf(b10.getFloat(i29));
                    e37 = i29;
                }
                bVar.T(f15);
                int i30 = e38;
                if (b10.isNull(i30)) {
                    e38 = i30;
                    str3 = null;
                } else {
                    e38 = i30;
                    str3 = b10.getString(i30);
                }
                bVar.M(str3);
                arrayList.add(bVar);
                e20 = i12;
                e24 = i16;
                e27 = i13;
                i14 = i15;
                e10 = i11;
            }
            b10.close();
            kVar.o();
            return arrayList;
        } catch (Throwable th4) {
            th2 = th4;
            b10.close();
            kVar.o();
            throw th2;
        }
    }

    @Override // ye.c
    public List<ye.b> f(String str) {
        k kVar;
        Throwable th2;
        int i10;
        Long l10;
        int i11;
        Integer num;
        Integer num2;
        String str2;
        Float f10;
        Integer num3;
        Integer num4;
        Integer num5;
        String str3;
        Integer num6;
        Float f11;
        Float f12;
        Float f13;
        Float f14;
        Float f15;
        String str4;
        k h10 = k.h("SELECT * FROM RECORD WHERE ACCOUNT_ID = ? AND START_TIME > 0 AND END_TIME > 0 AND DELETED = 0", 1);
        if (str == null) {
            h10.l0(1);
        } else {
            h10.m(1, str);
        }
        this.f37066a.d();
        Cursor b10 = h1.c.b(this.f37066a, h10, false, null);
        try {
            int e10 = h1.b.e(b10, "_id");
            int e11 = h1.b.e(b10, "HASH");
            int e12 = h1.b.e(b10, "TYPE");
            int e13 = h1.b.e(b10, "TARGET_TYPE");
            int e14 = h1.b.e(b10, "TARGET_VALUE");
            int e15 = h1.b.e(b10, "ACCOUNT_ID");
            int e16 = h1.b.e(b10, "SYNCED");
            int e17 = h1.b.e(b10, "DELETED");
            int e18 = h1.b.e(b10, "START_TIME");
            int e19 = h1.b.e(b10, "END_TIME");
            int e20 = h1.b.e(b10, "TIMESTAMP");
            int e21 = h1.b.e(b10, "DURATION");
            int e22 = h1.b.e(b10, "DISTANCE");
            int e23 = h1.b.e(b10, "CALORIE");
            kVar = h10;
            try {
                int e24 = h1.b.e(b10, "STEP");
                int e25 = h1.b.e(b10, "HEART");
                int e26 = h1.b.e(b10, "GROUPS");
                int e27 = h1.b.e(b10, "SWIM_TRIPS");
                int e28 = h1.b.e(b10, "SWIM_DISTANCE");
                int e29 = h1.b.e(b10, "SWIM_POOL_LENGTH");
                int e30 = h1.b.e(b10, "SWIM_STROKE");
                int e31 = h1.b.e(b10, "DEVICE_ID");
                int e32 = h1.b.e(b10, "SESSION_MODE");
                int e33 = h1.b.e(b10, "MAX_ELEVATION");
                int e34 = h1.b.e(b10, "MIN_ELEVATION");
                int e35 = h1.b.e(b10, "CUMULATIVE_UP");
                int e36 = h1.b.e(b10, "CUMULATIVE_DOWN");
                int e37 = h1.b.e(b10, "SCORE");
                int e38 = h1.b.e(b10, "EXTRA");
                int i12 = e23;
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    ye.b bVar = new ye.b();
                    if (b10.isNull(e10)) {
                        i10 = e10;
                        l10 = null;
                    } else {
                        l10 = Long.valueOf(b10.getLong(e10));
                        i10 = e10;
                    }
                    bVar.Q(l10);
                    bVar.O(b10.isNull(e11) ? null : b10.getString(e11));
                    bVar.f0(b10.getInt(e12));
                    bVar.c0(b10.isNull(e13) ? null : Integer.valueOf(b10.getInt(e13)));
                    bVar.d0(b10.isNull(e14) ? null : Float.valueOf(b10.getFloat(e14)));
                    bVar.D(b10.isNull(e15) ? null : b10.getString(e15));
                    bVar.b0(b10.getInt(e16));
                    bVar.H(b10.getInt(e17) != 0);
                    bVar.V(b10.isNull(e18) ? null : Long.valueOf(b10.getLong(e18)));
                    bVar.L(b10.isNull(e19) ? null : Long.valueOf(b10.getLong(e19)));
                    bVar.e0(b10.isNull(e20) ? null : Long.valueOf(b10.getLong(e20)));
                    int i13 = e11;
                    e12 = e12;
                    bVar.K(b10.getLong(e21));
                    bVar.J(b10.isNull(e22) ? null : Integer.valueOf(b10.getInt(e22)));
                    int i14 = i12;
                    bVar.E(b10.isNull(i14) ? null : Float.valueOf(b10.getFloat(i14)));
                    int i15 = e24;
                    if (b10.isNull(i15)) {
                        i11 = i13;
                        num = null;
                    } else {
                        num = Integer.valueOf(b10.getInt(i15));
                        i11 = i13;
                    }
                    bVar.W(num);
                    int i16 = e25;
                    if (b10.isNull(i16)) {
                        e25 = i16;
                        num2 = null;
                    } else {
                        num2 = Integer.valueOf(b10.getInt(i16));
                        e25 = i16;
                    }
                    bVar.P(num2);
                    int i17 = e26;
                    if (b10.isNull(i17)) {
                        e26 = i17;
                        str2 = null;
                    } else {
                        e26 = i17;
                        str2 = b10.getString(i17);
                    }
                    bVar.N(str2);
                    int i18 = e27;
                    if (b10.isNull(i18)) {
                        e27 = i18;
                        f10 = null;
                    } else {
                        f10 = Float.valueOf(b10.getFloat(i18));
                        e27 = i18;
                    }
                    bVar.a0(f10);
                    int i19 = e28;
                    if (b10.isNull(i19)) {
                        e28 = i19;
                        num3 = null;
                    } else {
                        num3 = Integer.valueOf(b10.getInt(i19));
                        e28 = i19;
                    }
                    bVar.X(num3);
                    int i20 = e29;
                    if (b10.isNull(i20)) {
                        e29 = i20;
                        num4 = null;
                    } else {
                        num4 = Integer.valueOf(b10.getInt(i20));
                        e29 = i20;
                    }
                    bVar.Y(num4);
                    int i21 = e30;
                    if (b10.isNull(i21)) {
                        e30 = i21;
                        num5 = null;
                    } else {
                        num5 = Integer.valueOf(b10.getInt(i21));
                        e30 = i21;
                    }
                    bVar.Z(num5);
                    int i22 = e31;
                    if (b10.isNull(i22)) {
                        e31 = i22;
                        str3 = null;
                    } else {
                        e31 = i22;
                        str3 = b10.getString(i22);
                    }
                    bVar.I(str3);
                    int i23 = e32;
                    if (b10.isNull(i23)) {
                        e32 = i23;
                        num6 = null;
                    } else {
                        num6 = Integer.valueOf(b10.getInt(i23));
                        e32 = i23;
                    }
                    bVar.U(num6);
                    int i24 = e33;
                    if (b10.isNull(i24)) {
                        e33 = i24;
                        f11 = null;
                    } else {
                        f11 = Float.valueOf(b10.getFloat(i24));
                        e33 = i24;
                    }
                    bVar.R(f11);
                    int i25 = e34;
                    if (b10.isNull(i25)) {
                        e34 = i25;
                        f12 = null;
                    } else {
                        f12 = Float.valueOf(b10.getFloat(i25));
                        e34 = i25;
                    }
                    bVar.S(f12);
                    int i26 = e35;
                    if (b10.isNull(i26)) {
                        e35 = i26;
                        f13 = null;
                    } else {
                        f13 = Float.valueOf(b10.getFloat(i26));
                        e35 = i26;
                    }
                    bVar.G(f13);
                    int i27 = e36;
                    if (b10.isNull(i27)) {
                        e36 = i27;
                        f14 = null;
                    } else {
                        f14 = Float.valueOf(b10.getFloat(i27));
                        e36 = i27;
                    }
                    bVar.F(f14);
                    int i28 = e37;
                    if (b10.isNull(i28)) {
                        e37 = i28;
                        f15 = null;
                    } else {
                        f15 = Float.valueOf(b10.getFloat(i28));
                        e37 = i28;
                    }
                    bVar.T(f15);
                    int i29 = e38;
                    if (b10.isNull(i29)) {
                        e38 = i29;
                        str4 = null;
                    } else {
                        e38 = i29;
                        str4 = b10.getString(i29);
                    }
                    bVar.M(str4);
                    arrayList.add(bVar);
                    e24 = i15;
                    e10 = i10;
                    e11 = i11;
                    i12 = i14;
                }
                b10.close();
                kVar.o();
                return arrayList;
            } catch (Throwable th3) {
                th2 = th3;
                b10.close();
                kVar.o();
                throw th2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            kVar = h10;
        }
    }

    @Override // ye.c
    public void g(ye.a... aVarArr) {
        this.f37066a.d();
        this.f37066a.e();
        try {
            this.f37067b.j(aVarArr);
            this.f37066a.B();
        } finally {
            this.f37066a.i();
        }
    }

    @Override // ye.c
    public void h(ye.b... bVarArr) {
        this.f37066a.d();
        this.f37066a.e();
        try {
            this.f37072g.i(bVarArr);
            this.f37066a.B();
        } finally {
            this.f37066a.i();
        }
    }

    @Override // ye.c
    public List<ye.b> i(i1.e eVar) {
        this.f37066a.d();
        Cursor b10 = h1.c.b(this.f37066a, eVar, false, null);
        try {
            ArrayList arrayList = new ArrayList(b10.getCount());
            while (b10.moveToNext()) {
                arrayList.add(u(b10));
            }
            return arrayList;
        } finally {
            b10.close();
        }
    }

    @Override // ye.c
    public void j(Long l10) {
        this.f37066a.d();
        i1.f a10 = this.f37073h.a();
        if (l10 == null) {
            a10.l0(1);
        } else {
            a10.K(1, l10.longValue());
        }
        this.f37066a.e();
        try {
            a10.r();
            this.f37066a.B();
        } finally {
            this.f37066a.i();
            this.f37073h.f(a10);
        }
    }

    @Override // ye.c
    public List<ye.a> k(Long l10) {
        k kVar;
        Throwable th2;
        int i10;
        Long l11;
        Boolean bool;
        int i11;
        Integer num;
        Integer num2;
        k h10 = k.h("SELECT * FROM POINT WHERE RECORD_ID  = ?", 1);
        if (l10 == null) {
            h10.l0(1);
        } else {
            h10.K(1, l10.longValue());
        }
        this.f37066a.d();
        Cursor b10 = h1.c.b(this.f37066a, h10, false, null);
        try {
            int e10 = h1.b.e(b10, "_id");
            int e11 = h1.b.e(b10, "TIME");
            int e12 = h1.b.e(b10, "HEART");
            int e13 = h1.b.e(b10, "STEP");
            int e14 = h1.b.e(b10, "LAT");
            int e15 = h1.b.e(b10, "LON");
            int e16 = h1.b.e(b10, "ACC");
            int e17 = h1.b.e(b10, "DISTANCE");
            int e18 = h1.b.e(b10, "SPEED");
            int e19 = h1.b.e(b10, "CALORIE");
            int e20 = h1.b.e(b10, "RECORD_ID");
            int e21 = h1.b.e(b10, "RESUME");
            int e22 = h1.b.e(b10, "SWIM_TRIPS");
            int e23 = h1.b.e(b10, "SWIM_DISTANCE");
            kVar = h10;
            try {
                int e24 = h1.b.e(b10, "SWIM_STROKE");
                int e25 = h1.b.e(b10, "SWIM_TYPE");
                int e26 = h1.b.e(b10, "TIMESTAMP");
                int e27 = h1.b.e(b10, "ELEVATION");
                int i12 = e23;
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    ye.a aVar = new ye.a();
                    if (b10.isNull(e10)) {
                        i10 = e10;
                        l11 = null;
                    } else {
                        l11 = Long.valueOf(b10.getLong(e10));
                        i10 = e10;
                    }
                    aVar.y(l11);
                    arrayList = arrayList;
                    int i13 = e21;
                    aVar.J(b10.getLong(e11));
                    aVar.x(b10.isNull(e12) ? null : Integer.valueOf(b10.getInt(e12)));
                    aVar.E(b10.isNull(e13) ? null : Integer.valueOf(b10.getInt(e13)));
                    aVar.z(b10.getDouble(e14));
                    aVar.A(b10.getDouble(e15));
                    aVar.s(b10.getFloat(e16));
                    aVar.v(b10.isNull(e17) ? null : Integer.valueOf(b10.getInt(e17)));
                    aVar.D(b10.isNull(e18) ? null : Float.valueOf(b10.getFloat(e18)));
                    aVar.t(b10.isNull(e19) ? null : Float.valueOf(b10.getFloat(e19)));
                    aVar.B(b10.isNull(e20) ? null : Long.valueOf(b10.getLong(e20)));
                    Integer valueOf = b10.isNull(i13) ? null : Integer.valueOf(b10.getInt(i13));
                    if (valueOf == null) {
                        bool = null;
                    } else {
                        bool = Boolean.valueOf(valueOf.intValue() != 0);
                    }
                    aVar.C(bool);
                    aVar.H(b10.isNull(e22) ? null : Float.valueOf(b10.getFloat(e22)));
                    int i14 = i12;
                    aVar.F(b10.isNull(i14) ? null : Integer.valueOf(b10.getInt(i14)));
                    int i15 = e24;
                    if (b10.isNull(i15)) {
                        i11 = i13;
                        num = null;
                    } else {
                        num = Integer.valueOf(b10.getInt(i15));
                        i11 = i13;
                    }
                    aVar.G(num);
                    int i16 = e25;
                    if (b10.isNull(i16)) {
                        e25 = i16;
                        num2 = null;
                    } else {
                        num2 = Integer.valueOf(b10.getInt(i16));
                        e25 = i16;
                    }
                    aVar.I(num2);
                    e20 = e20;
                    int i17 = e26;
                    aVar.K(b10.getLong(i17));
                    int i18 = e27;
                    aVar.w(b10.isNull(i18) ? null : Float.valueOf(b10.getFloat(i18)));
                    arrayList.add(aVar);
                    e27 = i18;
                    e24 = i15;
                    e21 = i11;
                    i12 = i14;
                    e26 = i17;
                    e10 = i10;
                }
                b10.close();
                kVar.o();
                return arrayList;
            } catch (Throwable th3) {
                th2 = th3;
                b10.close();
                kVar.o();
                throw th2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            kVar = h10;
        }
    }

    @Override // ye.c
    public List<ye.b> l(String str, long j10, long j11, int i10) {
        k kVar;
        Throwable th2;
        int i11;
        Long l10;
        int i12;
        Integer num;
        Integer num2;
        String str2;
        Float f10;
        int i13;
        Integer num3;
        Integer num4;
        Integer num5;
        String str3;
        Integer num6;
        Float f11;
        Float f12;
        Float f13;
        Float f14;
        Float f15;
        String str4;
        k h10 = k.h("SELECT * FROM RECORD WHERE ACCOUNT_ID = ? AND START_TIME < ? AND START_TIME >= ? AND END_TIME > 0 AND DELETED = 0 ORDER BY START_TIME ASC  LIMIT ?", 4);
        if (str == null) {
            h10.l0(1);
        } else {
            h10.m(1, str);
        }
        h10.K(2, j10);
        h10.K(3, j11);
        h10.K(4, i10);
        this.f37066a.d();
        Cursor b10 = h1.c.b(this.f37066a, h10, false, null);
        try {
            int e10 = h1.b.e(b10, "_id");
            int e11 = h1.b.e(b10, "HASH");
            int e12 = h1.b.e(b10, "TYPE");
            int e13 = h1.b.e(b10, "TARGET_TYPE");
            int e14 = h1.b.e(b10, "TARGET_VALUE");
            int e15 = h1.b.e(b10, "ACCOUNT_ID");
            int e16 = h1.b.e(b10, "SYNCED");
            int e17 = h1.b.e(b10, "DELETED");
            int e18 = h1.b.e(b10, "START_TIME");
            int e19 = h1.b.e(b10, "END_TIME");
            int e20 = h1.b.e(b10, "TIMESTAMP");
            int e21 = h1.b.e(b10, "DURATION");
            int e22 = h1.b.e(b10, "DISTANCE");
            int e23 = h1.b.e(b10, "CALORIE");
            kVar = h10;
            try {
                int e24 = h1.b.e(b10, "STEP");
                int e25 = h1.b.e(b10, "HEART");
                int e26 = h1.b.e(b10, "GROUPS");
                int e27 = h1.b.e(b10, "SWIM_TRIPS");
                int e28 = h1.b.e(b10, "SWIM_DISTANCE");
                int e29 = h1.b.e(b10, "SWIM_POOL_LENGTH");
                int e30 = h1.b.e(b10, "SWIM_STROKE");
                int e31 = h1.b.e(b10, "DEVICE_ID");
                int e32 = h1.b.e(b10, "SESSION_MODE");
                int e33 = h1.b.e(b10, "MAX_ELEVATION");
                int e34 = h1.b.e(b10, "MIN_ELEVATION");
                int e35 = h1.b.e(b10, "CUMULATIVE_UP");
                int e36 = h1.b.e(b10, "CUMULATIVE_DOWN");
                int e37 = h1.b.e(b10, "SCORE");
                int e38 = h1.b.e(b10, "EXTRA");
                int i14 = e23;
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    ye.b bVar = new ye.b();
                    if (b10.isNull(e10)) {
                        i11 = e10;
                        l10 = null;
                    } else {
                        l10 = Long.valueOf(b10.getLong(e10));
                        i11 = e10;
                    }
                    bVar.Q(l10);
                    bVar.O(b10.isNull(e11) ? null : b10.getString(e11));
                    bVar.f0(b10.getInt(e12));
                    bVar.c0(b10.isNull(e13) ? null : Integer.valueOf(b10.getInt(e13)));
                    bVar.d0(b10.isNull(e14) ? null : Float.valueOf(b10.getFloat(e14)));
                    bVar.D(b10.isNull(e15) ? null : b10.getString(e15));
                    bVar.b0(b10.getInt(e16));
                    bVar.H(b10.getInt(e17) != 0);
                    bVar.V(b10.isNull(e18) ? null : Long.valueOf(b10.getLong(e18)));
                    bVar.L(b10.isNull(e19) ? null : Long.valueOf(b10.getLong(e19)));
                    bVar.e0(b10.isNull(e20) ? null : Long.valueOf(b10.getLong(e20)));
                    int i15 = e11;
                    e12 = e12;
                    bVar.K(b10.getLong(e21));
                    bVar.J(b10.isNull(e22) ? null : Integer.valueOf(b10.getInt(e22)));
                    int i16 = i14;
                    bVar.E(b10.isNull(i16) ? null : Float.valueOf(b10.getFloat(i16)));
                    int i17 = e24;
                    if (b10.isNull(i17)) {
                        i12 = i15;
                        num = null;
                    } else {
                        num = Integer.valueOf(b10.getInt(i17));
                        i12 = i15;
                    }
                    bVar.W(num);
                    int i18 = e25;
                    if (b10.isNull(i18)) {
                        e25 = i18;
                        num2 = null;
                    } else {
                        num2 = Integer.valueOf(b10.getInt(i18));
                        e25 = i18;
                    }
                    bVar.P(num2);
                    int i19 = e26;
                    if (b10.isNull(i19)) {
                        e26 = i19;
                        str2 = null;
                    } else {
                        e26 = i19;
                        str2 = b10.getString(i19);
                    }
                    bVar.N(str2);
                    int i20 = e27;
                    if (b10.isNull(i20)) {
                        e27 = i20;
                        f10 = null;
                    } else {
                        f10 = Float.valueOf(b10.getFloat(i20));
                        e27 = i20;
                    }
                    bVar.a0(f10);
                    int i21 = e28;
                    if (b10.isNull(i21)) {
                        i13 = i21;
                        num3 = null;
                    } else {
                        num3 = Integer.valueOf(b10.getInt(i21));
                        i13 = i21;
                    }
                    bVar.X(num3);
                    int i22 = e29;
                    if (b10.isNull(i22)) {
                        e29 = i22;
                        num4 = null;
                    } else {
                        num4 = Integer.valueOf(b10.getInt(i22));
                        e29 = i22;
                    }
                    bVar.Y(num4);
                    int i23 = e30;
                    if (b10.isNull(i23)) {
                        e30 = i23;
                        num5 = null;
                    } else {
                        num5 = Integer.valueOf(b10.getInt(i23));
                        e30 = i23;
                    }
                    bVar.Z(num5);
                    int i24 = e31;
                    if (b10.isNull(i24)) {
                        e31 = i24;
                        str3 = null;
                    } else {
                        e31 = i24;
                        str3 = b10.getString(i24);
                    }
                    bVar.I(str3);
                    int i25 = e32;
                    if (b10.isNull(i25)) {
                        e32 = i25;
                        num6 = null;
                    } else {
                        num6 = Integer.valueOf(b10.getInt(i25));
                        e32 = i25;
                    }
                    bVar.U(num6);
                    int i26 = e33;
                    if (b10.isNull(i26)) {
                        e33 = i26;
                        f11 = null;
                    } else {
                        f11 = Float.valueOf(b10.getFloat(i26));
                        e33 = i26;
                    }
                    bVar.R(f11);
                    int i27 = e34;
                    if (b10.isNull(i27)) {
                        e34 = i27;
                        f12 = null;
                    } else {
                        f12 = Float.valueOf(b10.getFloat(i27));
                        e34 = i27;
                    }
                    bVar.S(f12);
                    int i28 = e35;
                    if (b10.isNull(i28)) {
                        e35 = i28;
                        f13 = null;
                    } else {
                        f13 = Float.valueOf(b10.getFloat(i28));
                        e35 = i28;
                    }
                    bVar.G(f13);
                    int i29 = e36;
                    if (b10.isNull(i29)) {
                        e36 = i29;
                        f14 = null;
                    } else {
                        f14 = Float.valueOf(b10.getFloat(i29));
                        e36 = i29;
                    }
                    bVar.F(f14);
                    int i30 = e37;
                    if (b10.isNull(i30)) {
                        e37 = i30;
                        f15 = null;
                    } else {
                        f15 = Float.valueOf(b10.getFloat(i30));
                        e37 = i30;
                    }
                    bVar.T(f15);
                    int i31 = e38;
                    if (b10.isNull(i31)) {
                        e38 = i31;
                        str4 = null;
                    } else {
                        e38 = i31;
                        str4 = b10.getString(i31);
                    }
                    bVar.M(str4);
                    arrayList.add(bVar);
                    e28 = i13;
                    e10 = i11;
                    i14 = i16;
                    e11 = i12;
                    e24 = i17;
                }
                b10.close();
                kVar.o();
                return arrayList;
            } catch (Throwable th3) {
                th2 = th3;
                b10.close();
                kVar.o();
                throw th2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            kVar = h10;
        }
    }

    @Override // ye.c
    public void m() {
        this.f37066a.d();
        i1.f a10 = this.f37074i.a();
        this.f37066a.e();
        try {
            a10.r();
            this.f37066a.B();
        } finally {
            this.f37066a.i();
            this.f37074i.f(a10);
        }
    }

    @Override // ye.c
    public void n(ye.a... aVarArr) {
        this.f37066a.d();
        this.f37066a.e();
        try {
            this.f37069d.i(aVarArr);
            this.f37066a.B();
        } finally {
            this.f37066a.i();
        }
    }

    @Override // ye.c
    public List<ye.b> o(String str, int i10) {
        k kVar;
        Throwable th2;
        int e10;
        int e11;
        int e12;
        int e13;
        int e14;
        int e15;
        int e16;
        int e17;
        int e18;
        int e19;
        int e20;
        int e21;
        int e22;
        int e23;
        int i11;
        Long l10;
        int i12;
        Integer num;
        Integer num2;
        String str2;
        Float f10;
        Integer num3;
        Integer num4;
        Integer num5;
        String str3;
        Integer num6;
        Float f11;
        Float f12;
        Float f13;
        Float f14;
        Float f15;
        String str4;
        k h10 = k.h("SELECT * FROM RECORD WHERE  ACCOUNT_ID = ? AND SYNCED <> ? AND END_TIME > 0 AND DELETED = 0", 2);
        if (str == null) {
            h10.l0(1);
        } else {
            h10.m(1, str);
        }
        h10.K(2, i10);
        this.f37066a.d();
        Cursor b10 = h1.c.b(this.f37066a, h10, false, null);
        try {
            e10 = h1.b.e(b10, "_id");
            e11 = h1.b.e(b10, "HASH");
            e12 = h1.b.e(b10, "TYPE");
            e13 = h1.b.e(b10, "TARGET_TYPE");
            e14 = h1.b.e(b10, "TARGET_VALUE");
            e15 = h1.b.e(b10, "ACCOUNT_ID");
            e16 = h1.b.e(b10, "SYNCED");
            e17 = h1.b.e(b10, "DELETED");
            e18 = h1.b.e(b10, "START_TIME");
            e19 = h1.b.e(b10, "END_TIME");
            e20 = h1.b.e(b10, "TIMESTAMP");
            e21 = h1.b.e(b10, "DURATION");
            e22 = h1.b.e(b10, "DISTANCE");
            e23 = h1.b.e(b10, "CALORIE");
            kVar = h10;
        } catch (Throwable th3) {
            th2 = th3;
            kVar = h10;
        }
        try {
            int e24 = h1.b.e(b10, "STEP");
            int e25 = h1.b.e(b10, "HEART");
            int e26 = h1.b.e(b10, "GROUPS");
            int e27 = h1.b.e(b10, "SWIM_TRIPS");
            int e28 = h1.b.e(b10, "SWIM_DISTANCE");
            int e29 = h1.b.e(b10, "SWIM_POOL_LENGTH");
            int e30 = h1.b.e(b10, "SWIM_STROKE");
            int e31 = h1.b.e(b10, "DEVICE_ID");
            int e32 = h1.b.e(b10, "SESSION_MODE");
            int e33 = h1.b.e(b10, "MAX_ELEVATION");
            int e34 = h1.b.e(b10, "MIN_ELEVATION");
            int e35 = h1.b.e(b10, "CUMULATIVE_UP");
            int e36 = h1.b.e(b10, "CUMULATIVE_DOWN");
            int e37 = h1.b.e(b10, "SCORE");
            int e38 = h1.b.e(b10, "EXTRA");
            int i13 = e23;
            ArrayList arrayList = new ArrayList(b10.getCount());
            while (b10.moveToNext()) {
                ye.b bVar = new ye.b();
                if (b10.isNull(e10)) {
                    i11 = e10;
                    l10 = null;
                } else {
                    l10 = Long.valueOf(b10.getLong(e10));
                    i11 = e10;
                }
                bVar.Q(l10);
                bVar.O(b10.isNull(e11) ? null : b10.getString(e11));
                bVar.f0(b10.getInt(e12));
                bVar.c0(b10.isNull(e13) ? null : Integer.valueOf(b10.getInt(e13)));
                bVar.d0(b10.isNull(e14) ? null : Float.valueOf(b10.getFloat(e14)));
                bVar.D(b10.isNull(e15) ? null : b10.getString(e15));
                bVar.b0(b10.getInt(e16));
                bVar.H(b10.getInt(e17) != 0);
                bVar.V(b10.isNull(e18) ? null : Long.valueOf(b10.getLong(e18)));
                bVar.L(b10.isNull(e19) ? null : Long.valueOf(b10.getLong(e19)));
                bVar.e0(b10.isNull(e20) ? null : Long.valueOf(b10.getLong(e20)));
                int i14 = e11;
                e12 = e12;
                bVar.K(b10.getLong(e21));
                bVar.J(b10.isNull(e22) ? null : Integer.valueOf(b10.getInt(e22)));
                int i15 = i13;
                bVar.E(b10.isNull(i15) ? null : Float.valueOf(b10.getFloat(i15)));
                int i16 = e24;
                if (b10.isNull(i16)) {
                    i12 = i14;
                    num = null;
                } else {
                    num = Integer.valueOf(b10.getInt(i16));
                    i12 = i14;
                }
                bVar.W(num);
                int i17 = e25;
                if (b10.isNull(i17)) {
                    e25 = i17;
                    num2 = null;
                } else {
                    num2 = Integer.valueOf(b10.getInt(i17));
                    e25 = i17;
                }
                bVar.P(num2);
                int i18 = e26;
                if (b10.isNull(i18)) {
                    e26 = i18;
                    str2 = null;
                } else {
                    e26 = i18;
                    str2 = b10.getString(i18);
                }
                bVar.N(str2);
                int i19 = e27;
                if (b10.isNull(i19)) {
                    e27 = i19;
                    f10 = null;
                } else {
                    f10 = Float.valueOf(b10.getFloat(i19));
                    e27 = i19;
                }
                bVar.a0(f10);
                int i20 = e28;
                if (b10.isNull(i20)) {
                    e28 = i20;
                    num3 = null;
                } else {
                    num3 = Integer.valueOf(b10.getInt(i20));
                    e28 = i20;
                }
                bVar.X(num3);
                int i21 = e29;
                if (b10.isNull(i21)) {
                    e29 = i21;
                    num4 = null;
                } else {
                    num4 = Integer.valueOf(b10.getInt(i21));
                    e29 = i21;
                }
                bVar.Y(num4);
                int i22 = e30;
                if (b10.isNull(i22)) {
                    e30 = i22;
                    num5 = null;
                } else {
                    num5 = Integer.valueOf(b10.getInt(i22));
                    e30 = i22;
                }
                bVar.Z(num5);
                int i23 = e31;
                if (b10.isNull(i23)) {
                    e31 = i23;
                    str3 = null;
                } else {
                    e31 = i23;
                    str3 = b10.getString(i23);
                }
                bVar.I(str3);
                int i24 = e32;
                if (b10.isNull(i24)) {
                    e32 = i24;
                    num6 = null;
                } else {
                    num6 = Integer.valueOf(b10.getInt(i24));
                    e32 = i24;
                }
                bVar.U(num6);
                int i25 = e33;
                if (b10.isNull(i25)) {
                    e33 = i25;
                    f11 = null;
                } else {
                    f11 = Float.valueOf(b10.getFloat(i25));
                    e33 = i25;
                }
                bVar.R(f11);
                int i26 = e34;
                if (b10.isNull(i26)) {
                    e34 = i26;
                    f12 = null;
                } else {
                    f12 = Float.valueOf(b10.getFloat(i26));
                    e34 = i26;
                }
                bVar.S(f12);
                int i27 = e35;
                if (b10.isNull(i27)) {
                    e35 = i27;
                    f13 = null;
                } else {
                    f13 = Float.valueOf(b10.getFloat(i27));
                    e35 = i27;
                }
                bVar.G(f13);
                int i28 = e36;
                if (b10.isNull(i28)) {
                    e36 = i28;
                    f14 = null;
                } else {
                    f14 = Float.valueOf(b10.getFloat(i28));
                    e36 = i28;
                }
                bVar.F(f14);
                int i29 = e37;
                if (b10.isNull(i29)) {
                    e37 = i29;
                    f15 = null;
                } else {
                    f15 = Float.valueOf(b10.getFloat(i29));
                    e37 = i29;
                }
                bVar.T(f15);
                int i30 = e38;
                if (b10.isNull(i30)) {
                    e38 = i30;
                    str4 = null;
                } else {
                    e38 = i30;
                    str4 = b10.getString(i30);
                }
                bVar.M(str4);
                arrayList.add(bVar);
                e24 = i16;
                e10 = i11;
                e11 = i12;
                i13 = i15;
            }
            b10.close();
            kVar.o();
            return arrayList;
        } catch (Throwable th4) {
            th2 = th4;
            b10.close();
            kVar.o();
            throw th2;
        }
    }

    @Override // ye.c
    public List<ye.b> p() {
        k kVar;
        Throwable th2;
        int i10;
        Long l10;
        int i11;
        Integer num;
        Integer num2;
        String str;
        Float f10;
        Integer num3;
        Integer num4;
        Integer num5;
        String str2;
        Integer num6;
        Float f11;
        Float f12;
        Float f13;
        Float f14;
        Float f15;
        String str3;
        k h10 = k.h("SELECT * FROM RECORD WHERE DELETED  = 1", 0);
        this.f37066a.d();
        Cursor b10 = h1.c.b(this.f37066a, h10, false, null);
        try {
            int e10 = h1.b.e(b10, "_id");
            int e11 = h1.b.e(b10, "HASH");
            int e12 = h1.b.e(b10, "TYPE");
            int e13 = h1.b.e(b10, "TARGET_TYPE");
            int e14 = h1.b.e(b10, "TARGET_VALUE");
            int e15 = h1.b.e(b10, "ACCOUNT_ID");
            int e16 = h1.b.e(b10, "SYNCED");
            int e17 = h1.b.e(b10, "DELETED");
            int e18 = h1.b.e(b10, "START_TIME");
            int e19 = h1.b.e(b10, "END_TIME");
            int e20 = h1.b.e(b10, "TIMESTAMP");
            int e21 = h1.b.e(b10, "DURATION");
            int e22 = h1.b.e(b10, "DISTANCE");
            int e23 = h1.b.e(b10, "CALORIE");
            kVar = h10;
            try {
                int e24 = h1.b.e(b10, "STEP");
                int e25 = h1.b.e(b10, "HEART");
                int e26 = h1.b.e(b10, "GROUPS");
                int e27 = h1.b.e(b10, "SWIM_TRIPS");
                int e28 = h1.b.e(b10, "SWIM_DISTANCE");
                int e29 = h1.b.e(b10, "SWIM_POOL_LENGTH");
                int e30 = h1.b.e(b10, "SWIM_STROKE");
                int e31 = h1.b.e(b10, "DEVICE_ID");
                int e32 = h1.b.e(b10, "SESSION_MODE");
                int e33 = h1.b.e(b10, "MAX_ELEVATION");
                int e34 = h1.b.e(b10, "MIN_ELEVATION");
                int e35 = h1.b.e(b10, "CUMULATIVE_UP");
                int e36 = h1.b.e(b10, "CUMULATIVE_DOWN");
                int e37 = h1.b.e(b10, "SCORE");
                int e38 = h1.b.e(b10, "EXTRA");
                int i12 = e23;
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    ye.b bVar = new ye.b();
                    if (b10.isNull(e10)) {
                        i10 = e10;
                        l10 = null;
                    } else {
                        l10 = Long.valueOf(b10.getLong(e10));
                        i10 = e10;
                    }
                    bVar.Q(l10);
                    bVar.O(b10.isNull(e11) ? null : b10.getString(e11));
                    bVar.f0(b10.getInt(e12));
                    bVar.c0(b10.isNull(e13) ? null : Integer.valueOf(b10.getInt(e13)));
                    bVar.d0(b10.isNull(e14) ? null : Float.valueOf(b10.getFloat(e14)));
                    bVar.D(b10.isNull(e15) ? null : b10.getString(e15));
                    bVar.b0(b10.getInt(e16));
                    bVar.H(b10.getInt(e17) != 0);
                    bVar.V(b10.isNull(e18) ? null : Long.valueOf(b10.getLong(e18)));
                    bVar.L(b10.isNull(e19) ? null : Long.valueOf(b10.getLong(e19)));
                    bVar.e0(b10.isNull(e20) ? null : Long.valueOf(b10.getLong(e20)));
                    int i13 = e11;
                    e12 = e12;
                    bVar.K(b10.getLong(e21));
                    bVar.J(b10.isNull(e22) ? null : Integer.valueOf(b10.getInt(e22)));
                    int i14 = i12;
                    bVar.E(b10.isNull(i14) ? null : Float.valueOf(b10.getFloat(i14)));
                    int i15 = e24;
                    if (b10.isNull(i15)) {
                        i11 = i13;
                        num = null;
                    } else {
                        num = Integer.valueOf(b10.getInt(i15));
                        i11 = i13;
                    }
                    bVar.W(num);
                    int i16 = e25;
                    if (b10.isNull(i16)) {
                        e25 = i16;
                        num2 = null;
                    } else {
                        num2 = Integer.valueOf(b10.getInt(i16));
                        e25 = i16;
                    }
                    bVar.P(num2);
                    int i17 = e26;
                    if (b10.isNull(i17)) {
                        e26 = i17;
                        str = null;
                    } else {
                        e26 = i17;
                        str = b10.getString(i17);
                    }
                    bVar.N(str);
                    int i18 = e27;
                    if (b10.isNull(i18)) {
                        e27 = i18;
                        f10 = null;
                    } else {
                        f10 = Float.valueOf(b10.getFloat(i18));
                        e27 = i18;
                    }
                    bVar.a0(f10);
                    int i19 = e28;
                    if (b10.isNull(i19)) {
                        e28 = i19;
                        num3 = null;
                    } else {
                        num3 = Integer.valueOf(b10.getInt(i19));
                        e28 = i19;
                    }
                    bVar.X(num3);
                    int i20 = e29;
                    if (b10.isNull(i20)) {
                        e29 = i20;
                        num4 = null;
                    } else {
                        num4 = Integer.valueOf(b10.getInt(i20));
                        e29 = i20;
                    }
                    bVar.Y(num4);
                    int i21 = e30;
                    if (b10.isNull(i21)) {
                        e30 = i21;
                        num5 = null;
                    } else {
                        num5 = Integer.valueOf(b10.getInt(i21));
                        e30 = i21;
                    }
                    bVar.Z(num5);
                    int i22 = e31;
                    if (b10.isNull(i22)) {
                        e31 = i22;
                        str2 = null;
                    } else {
                        e31 = i22;
                        str2 = b10.getString(i22);
                    }
                    bVar.I(str2);
                    int i23 = e32;
                    if (b10.isNull(i23)) {
                        e32 = i23;
                        num6 = null;
                    } else {
                        num6 = Integer.valueOf(b10.getInt(i23));
                        e32 = i23;
                    }
                    bVar.U(num6);
                    int i24 = e33;
                    if (b10.isNull(i24)) {
                        e33 = i24;
                        f11 = null;
                    } else {
                        f11 = Float.valueOf(b10.getFloat(i24));
                        e33 = i24;
                    }
                    bVar.R(f11);
                    int i25 = e34;
                    if (b10.isNull(i25)) {
                        e34 = i25;
                        f12 = null;
                    } else {
                        f12 = Float.valueOf(b10.getFloat(i25));
                        e34 = i25;
                    }
                    bVar.S(f12);
                    int i26 = e35;
                    if (b10.isNull(i26)) {
                        e35 = i26;
                        f13 = null;
                    } else {
                        f13 = Float.valueOf(b10.getFloat(i26));
                        e35 = i26;
                    }
                    bVar.G(f13);
                    int i27 = e36;
                    if (b10.isNull(i27)) {
                        e36 = i27;
                        f14 = null;
                    } else {
                        f14 = Float.valueOf(b10.getFloat(i27));
                        e36 = i27;
                    }
                    bVar.F(f14);
                    int i28 = e37;
                    if (b10.isNull(i28)) {
                        e37 = i28;
                        f15 = null;
                    } else {
                        f15 = Float.valueOf(b10.getFloat(i28));
                        e37 = i28;
                    }
                    bVar.T(f15);
                    int i29 = e38;
                    if (b10.isNull(i29)) {
                        e38 = i29;
                        str3 = null;
                    } else {
                        e38 = i29;
                        str3 = b10.getString(i29);
                    }
                    bVar.M(str3);
                    arrayList.add(bVar);
                    e24 = i15;
                    e10 = i10;
                    e11 = i11;
                    i12 = i14;
                }
                b10.close();
                kVar.o();
                return arrayList;
            } catch (Throwable th3) {
                th2 = th3;
                b10.close();
                kVar.o();
                throw th2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            kVar = h10;
        }
    }

    @Override // ye.c
    public void q(ye.b... bVarArr) {
        this.f37066a.d();
        this.f37066a.e();
        try {
            this.f37070e.i(bVarArr);
            this.f37066a.B();
        } finally {
            this.f37066a.i();
        }
    }

    @Override // ye.c
    public void r(ye.a... aVarArr) {
        this.f37066a.d();
        this.f37066a.e();
        try {
            this.f37071f.i(aVarArr);
            this.f37066a.B();
        } finally {
            this.f37066a.i();
        }
    }

    @Override // ye.c
    public void s() {
        this.f37066a.d();
        i1.f a10 = this.f37075j.a();
        this.f37066a.e();
        try {
            a10.r();
            this.f37066a.B();
        } finally {
            this.f37066a.i();
            this.f37075j.f(a10);
        }
    }

    @Override // ye.c
    public ye.b t(String str) {
        k kVar;
        Throwable th2;
        ye.b bVar;
        k h10 = k.h("SELECT * FROM RECORD WHERE HASH  = ?  LIMIT 1", 1);
        if (str == null) {
            h10.l0(1);
        } else {
            h10.m(1, str);
        }
        this.f37066a.d();
        Cursor b10 = h1.c.b(this.f37066a, h10, false, null);
        try {
            int e10 = h1.b.e(b10, "_id");
            int e11 = h1.b.e(b10, "HASH");
            int e12 = h1.b.e(b10, "TYPE");
            int e13 = h1.b.e(b10, "TARGET_TYPE");
            int e14 = h1.b.e(b10, "TARGET_VALUE");
            int e15 = h1.b.e(b10, "ACCOUNT_ID");
            int e16 = h1.b.e(b10, "SYNCED");
            int e17 = h1.b.e(b10, "DELETED");
            int e18 = h1.b.e(b10, "START_TIME");
            int e19 = h1.b.e(b10, "END_TIME");
            int e20 = h1.b.e(b10, "TIMESTAMP");
            int e21 = h1.b.e(b10, "DURATION");
            int e22 = h1.b.e(b10, "DISTANCE");
            int e23 = h1.b.e(b10, "CALORIE");
            kVar = h10;
            try {
                int e24 = h1.b.e(b10, "STEP");
                int e25 = h1.b.e(b10, "HEART");
                int e26 = h1.b.e(b10, "GROUPS");
                int e27 = h1.b.e(b10, "SWIM_TRIPS");
                int e28 = h1.b.e(b10, "SWIM_DISTANCE");
                int e29 = h1.b.e(b10, "SWIM_POOL_LENGTH");
                int e30 = h1.b.e(b10, "SWIM_STROKE");
                int e31 = h1.b.e(b10, "DEVICE_ID");
                int e32 = h1.b.e(b10, "SESSION_MODE");
                int e33 = h1.b.e(b10, "MAX_ELEVATION");
                int e34 = h1.b.e(b10, "MIN_ELEVATION");
                int e35 = h1.b.e(b10, "CUMULATIVE_UP");
                int e36 = h1.b.e(b10, "CUMULATIVE_DOWN");
                int e37 = h1.b.e(b10, "SCORE");
                int e38 = h1.b.e(b10, "EXTRA");
                if (b10.moveToFirst()) {
                    ye.b bVar2 = new ye.b();
                    bVar2.Q(b10.isNull(e10) ? null : Long.valueOf(b10.getLong(e10)));
                    bVar2.O(b10.isNull(e11) ? null : b10.getString(e11));
                    bVar2.f0(b10.getInt(e12));
                    bVar2.c0(b10.isNull(e13) ? null : Integer.valueOf(b10.getInt(e13)));
                    bVar2.d0(b10.isNull(e14) ? null : Float.valueOf(b10.getFloat(e14)));
                    bVar2.D(b10.isNull(e15) ? null : b10.getString(e15));
                    bVar2.b0(b10.getInt(e16));
                    bVar2.H(b10.getInt(e17) != 0);
                    bVar2.V(b10.isNull(e18) ? null : Long.valueOf(b10.getLong(e18)));
                    bVar2.L(b10.isNull(e19) ? null : Long.valueOf(b10.getLong(e19)));
                    bVar2.e0(b10.isNull(e20) ? null : Long.valueOf(b10.getLong(e20)));
                    bVar2.K(b10.getLong(e21));
                    bVar2.J(b10.isNull(e22) ? null : Integer.valueOf(b10.getInt(e22)));
                    bVar2.E(b10.isNull(e23) ? null : Float.valueOf(b10.getFloat(e23)));
                    bVar2.W(b10.isNull(e24) ? null : Integer.valueOf(b10.getInt(e24)));
                    bVar2.P(b10.isNull(e25) ? null : Integer.valueOf(b10.getInt(e25)));
                    bVar2.N(b10.isNull(e26) ? null : b10.getString(e26));
                    bVar2.a0(b10.isNull(e27) ? null : Float.valueOf(b10.getFloat(e27)));
                    bVar2.X(b10.isNull(e28) ? null : Integer.valueOf(b10.getInt(e28)));
                    bVar2.Y(b10.isNull(e29) ? null : Integer.valueOf(b10.getInt(e29)));
                    bVar2.Z(b10.isNull(e30) ? null : Integer.valueOf(b10.getInt(e30)));
                    bVar2.I(b10.isNull(e31) ? null : b10.getString(e31));
                    bVar2.U(b10.isNull(e32) ? null : Integer.valueOf(b10.getInt(e32)));
                    bVar2.R(b10.isNull(e33) ? null : Float.valueOf(b10.getFloat(e33)));
                    bVar2.S(b10.isNull(e34) ? null : Float.valueOf(b10.getFloat(e34)));
                    bVar2.G(b10.isNull(e35) ? null : Float.valueOf(b10.getFloat(e35)));
                    bVar2.F(b10.isNull(e36) ? null : Float.valueOf(b10.getFloat(e36)));
                    bVar2.T(b10.isNull(e37) ? null : Float.valueOf(b10.getFloat(e37)));
                    bVar2.M(b10.isNull(e38) ? null : b10.getString(e38));
                    bVar = bVar2;
                } else {
                    bVar = null;
                }
                b10.close();
                kVar.o();
                return bVar;
            } catch (Throwable th3) {
                th2 = th3;
                b10.close();
                kVar.o();
                throw th2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            kVar = h10;
        }
    }
}
