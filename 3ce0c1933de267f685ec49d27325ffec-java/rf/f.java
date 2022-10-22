package rf;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import com.mobvoi.health.common.data.pojo.ActivityType;
import com.mobvoi.wear.common.base.Constants;
import f1.g;
import f1.k;
import f1.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: DataSessionDao_Impl.java */
/* loaded from: classes2.dex */
public final class f implements rf.e {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f33504a;

    /* renamed from: b  reason: collision with root package name */
    private final g<qf.c> f33505b;

    /* renamed from: c  reason: collision with root package name */
    private final f1.f<qf.c> f33506c;

    /* renamed from: d  reason: collision with root package name */
    private final l f33507d;

    /* compiled from: DataSessionDao_Impl.java */
    /* loaded from: classes2.dex */
    class a extends g<qf.c> {
        a(f fVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "INSERT OR REPLACE INTO `data_session` (`device_id`,`wwid`,`type`,`time_to`,`time_from`,`synced`,`deleted`,`id`) VALUES (?,?,?,?,?,?,?,?)";
        }

        /* renamed from: m */
        public void g(i1.f fVar, qf.c cVar) {
            String str = cVar.f33125a;
            if (str == null) {
                fVar.l0(1);
            } else {
                fVar.m(1, str);
            }
            String str2 = cVar.f33126b;
            if (str2 == null) {
                fVar.l0(2);
            } else {
                fVar.m(2, str2);
            }
            fVar.K(3, cVar.f33127c);
            fVar.K(4, cVar.f33128d);
            fVar.K(5, cVar.f33129e);
            fVar.K(6, cVar.f33130f);
            fVar.K(7, cVar.f33131g);
            String str3 = cVar.f33133i;
            if (str3 == null) {
                fVar.l0(8);
            } else {
                fVar.m(8, str3);
            }
        }
    }

    /* compiled from: DataSessionDao_Impl.java */
    /* loaded from: classes2.dex */
    class b extends f1.f<qf.c> {
        b(f fVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "DELETE FROM `data_session` WHERE `id` = ?";
        }

        /* renamed from: j */
        public void g(i1.f fVar, qf.c cVar) {
            String str = cVar.f33133i;
            if (str == null) {
                fVar.l0(1);
            } else {
                fVar.m(1, str);
            }
        }
    }

    /* compiled from: DataSessionDao_Impl.java */
    /* loaded from: classes2.dex */
    class c extends f1.f<qf.c> {
        c(f fVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "UPDATE OR ABORT `data_session` SET `device_id` = ?,`wwid` = ?,`type` = ?,`time_to` = ?,`time_from` = ?,`synced` = ?,`deleted` = ?,`id` = ? WHERE `id` = ?";
        }

        /* renamed from: j */
        public void g(i1.f fVar, qf.c cVar) {
            String str = cVar.f33125a;
            if (str == null) {
                fVar.l0(1);
            } else {
                fVar.m(1, str);
            }
            String str2 = cVar.f33126b;
            if (str2 == null) {
                fVar.l0(2);
            } else {
                fVar.m(2, str2);
            }
            fVar.K(3, cVar.f33127c);
            fVar.K(4, cVar.f33128d);
            fVar.K(5, cVar.f33129e);
            fVar.K(6, cVar.f33130f);
            fVar.K(7, cVar.f33131g);
            String str3 = cVar.f33133i;
            if (str3 == null) {
                fVar.l0(8);
            } else {
                fVar.m(8, str3);
            }
            String str4 = cVar.f33133i;
            if (str4 == null) {
                fVar.l0(9);
            } else {
                fVar.m(9, str4);
            }
        }
    }

    /* compiled from: DataSessionDao_Impl.java */
    /* loaded from: classes2.dex */
    class d extends l {
        d(f fVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "UPDATE data_session SET synced=1 WHERE id = ?";
        }
    }

    /* compiled from: DataSessionDao_Impl.java */
    /* loaded from: classes2.dex */
    class e extends l {
        e(f fVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "UPDATE data_session SET wwid=?, synced=0 WHERE wwid = ''";
        }
    }

    /* compiled from: DataSessionDao_Impl.java */
    /* renamed from: rf.f$f  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0463f extends l {
        C0463f(f fVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "DELETE FROM data_session WHERE id = ?";
        }
    }

    public f(RoomDatabase roomDatabase) {
        this.f33504a = roomDatabase;
        this.f33505b = new a(this, roomDatabase);
        new b(this, roomDatabase);
        this.f33506c = new c(this, roomDatabase);
        this.f33507d = new d(this, roomDatabase);
        new e(this, roomDatabase);
        new C0463f(this, roomDatabase);
    }

    private qf.c i(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("device_id");
        int columnIndex2 = cursor.getColumnIndex("wwid");
        int columnIndex3 = cursor.getColumnIndex("type");
        int columnIndex4 = cursor.getColumnIndex(Constants.Fitness.DATA_TIME_TO);
        int columnIndex5 = cursor.getColumnIndex(Constants.Fitness.DATA_TIME_FROM);
        int columnIndex6 = cursor.getColumnIndex("synced");
        int columnIndex7 = cursor.getColumnIndex("deleted");
        int columnIndex8 = cursor.getColumnIndex("id");
        qf.c cVar = new qf.c();
        if (columnIndex != -1) {
            if (cursor.isNull(columnIndex)) {
                cVar.f33125a = null;
            } else {
                cVar.f33125a = cursor.getString(columnIndex);
            }
        }
        if (columnIndex2 != -1) {
            if (cursor.isNull(columnIndex2)) {
                cVar.f33126b = null;
            } else {
                cVar.f33126b = cursor.getString(columnIndex2);
            }
        }
        if (columnIndex3 != -1) {
            cVar.f33127c = cursor.getInt(columnIndex3);
        }
        if (columnIndex4 != -1) {
            cVar.f33128d = cursor.getLong(columnIndex4);
        }
        if (columnIndex5 != -1) {
            cVar.f33129e = cursor.getLong(columnIndex5);
        }
        if (columnIndex6 != -1) {
            cVar.f33130f = cursor.getInt(columnIndex6);
        }
        if (columnIndex7 != -1) {
            cVar.f33131g = cursor.getInt(columnIndex7);
        }
        if (columnIndex8 != -1) {
            if (cursor.isNull(columnIndex8)) {
                cVar.f33133i = null;
            } else {
                cVar.f33133i = cursor.getString(columnIndex8);
            }
        }
        return cVar;
    }

    public static List<Class<?>> j() {
        return Collections.emptyList();
    }

    @Override // rf.e
    public List<qf.c> a(i1.e eVar) {
        this.f33504a.d();
        Cursor b10 = h1.c.b(this.f33504a, eVar, false, null);
        try {
            ArrayList arrayList = new ArrayList(b10.getCount());
            while (b10.moveToNext()) {
                arrayList.add(i(b10));
            }
            return arrayList;
        } finally {
            b10.close();
        }
    }

    @Override // rf.e
    public /* synthetic */ List b(String str, String str2, ActivityType activityType, long j10, long j11, String str3) {
        return rf.d.a(this, str, str2, activityType, j10, j11, str3);
    }

    @Override // rf.e
    public int c(String str) {
        this.f33504a.d();
        i1.f a10 = this.f33507d.a();
        if (str == null) {
            a10.l0(1);
        } else {
            a10.m(1, str);
        }
        this.f33504a.e();
        try {
            int r10 = a10.r();
            this.f33504a.B();
            return r10;
        } finally {
            this.f33504a.i();
            this.f33507d.f(a10);
        }
    }

    @Override // rf.e
    public qf.c d(String str) {
        k h10 = k.h("SELECT * FROM data_session WHERE id = ? ", 1);
        if (str == null) {
            h10.l0(1);
        } else {
            h10.m(1, str);
        }
        this.f33504a.d();
        qf.c cVar = null;
        Cursor b10 = h1.c.b(this.f33504a, h10, false, null);
        try {
            int e10 = h1.b.e(b10, "device_id");
            int e11 = h1.b.e(b10, "wwid");
            int e12 = h1.b.e(b10, "type");
            int e13 = h1.b.e(b10, Constants.Fitness.DATA_TIME_TO);
            int e14 = h1.b.e(b10, Constants.Fitness.DATA_TIME_FROM);
            int e15 = h1.b.e(b10, "synced");
            int e16 = h1.b.e(b10, "deleted");
            int e17 = h1.b.e(b10, "id");
            if (b10.moveToFirst()) {
                qf.c cVar2 = new qf.c();
                if (b10.isNull(e10)) {
                    cVar2.f33125a = null;
                } else {
                    cVar2.f33125a = b10.getString(e10);
                }
                if (b10.isNull(e11)) {
                    cVar2.f33126b = null;
                } else {
                    cVar2.f33126b = b10.getString(e11);
                }
                cVar2.f33127c = b10.getInt(e12);
                cVar2.f33128d = b10.getLong(e13);
                cVar2.f33129e = b10.getLong(e14);
                cVar2.f33130f = b10.getInt(e15);
                cVar2.f33131g = b10.getInt(e16);
                if (b10.isNull(e17)) {
                    cVar2.f33133i = null;
                } else {
                    cVar2.f33133i = b10.getString(e17);
                }
                cVar = cVar2;
            }
            return cVar;
        } finally {
            b10.close();
            h10.o();
        }
    }

    @Override // rf.e
    public int e(qf.c cVar) {
        this.f33504a.d();
        this.f33504a.e();
        try {
            int h10 = this.f33506c.h(cVar) + 0;
            this.f33504a.B();
            return h10;
        } finally {
            this.f33504a.i();
        }
    }

    @Override // rf.e
    public /* synthetic */ List f(String str, String str2, ActivityType activityType, long j10, long j11) {
        return rf.d.b(this, str, str2, activityType, j10, j11);
    }

    @Override // rf.e
    public long g(qf.c cVar) {
        this.f33504a.d();
        this.f33504a.e();
        try {
            long k10 = this.f33505b.k(cVar);
            this.f33504a.B();
            return k10;
        } finally {
            this.f33504a.i();
        }
    }

    @Override // rf.e
    public /* synthetic */ List h(String str, String str2, ActivityType activityType, long j10) {
        return rf.d.c(this, str, str2, activityType, j10);
    }
}
