package rf;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import com.mobvoi.health.common.data.db.DataPoint;
import com.mobvoi.health.common.data.pojo.DataType;
import com.mobvoi.wear.common.base.Constants;
import f1.g;
import f1.k;
import f1.l;
import i1.e;
import i1.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: DataPointDao_Impl.java */
/* loaded from: classes2.dex */
public final class c implements rf.b {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f33502a;

    /* renamed from: b  reason: collision with root package name */
    private final g<qf.a> f33503b;

    /* compiled from: DataPointDao_Impl.java */
    /* loaded from: classes2.dex */
    class a extends g<qf.a> {
        a(c cVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "INSERT OR REPLACE INTO `data_point` (`device_id`,`wwid`,`type`,`time_to`,`time_from`,`synced`,`deleted`,`_id`,`values`) VALUES (?,?,?,?,?,?,?,nullif(?, 0),?)";
        }

        /* renamed from: m */
        public void g(f fVar, qf.a aVar) {
            String str = aVar.f33125a;
            if (str == null) {
                fVar.l0(1);
            } else {
                fVar.m(1, str);
            }
            String str2 = aVar.f33126b;
            if (str2 == null) {
                fVar.l0(2);
            } else {
                fVar.m(2, str2);
            }
            fVar.K(3, aVar.f33127c);
            fVar.K(4, aVar.f33128d);
            fVar.K(5, aVar.f33129e);
            fVar.K(6, aVar.f33130f);
            fVar.K(7, aVar.f33131g);
            fVar.K(8, aVar.f33123i);
            String str3 = aVar.f33124j;
            if (str3 == null) {
                fVar.l0(9);
            } else {
                fVar.m(9, str3);
            }
        }
    }

    /* compiled from: DataPointDao_Impl.java */
    /* loaded from: classes2.dex */
    class b extends f1.f<qf.a> {
        b(c cVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "UPDATE OR ABORT `data_point` SET `device_id` = ?,`wwid` = ?,`type` = ?,`time_to` = ?,`time_from` = ?,`synced` = ?,`deleted` = ?,`_id` = ?,`values` = ? WHERE `_id` = ?";
        }

        /* renamed from: j */
        public void g(f fVar, qf.a aVar) {
            String str = aVar.f33125a;
            if (str == null) {
                fVar.l0(1);
            } else {
                fVar.m(1, str);
            }
            String str2 = aVar.f33126b;
            if (str2 == null) {
                fVar.l0(2);
            } else {
                fVar.m(2, str2);
            }
            fVar.K(3, aVar.f33127c);
            fVar.K(4, aVar.f33128d);
            fVar.K(5, aVar.f33129e);
            fVar.K(6, aVar.f33130f);
            fVar.K(7, aVar.f33131g);
            fVar.K(8, aVar.f33123i);
            String str3 = aVar.f33124j;
            if (str3 == null) {
                fVar.l0(9);
            } else {
                fVar.m(9, str3);
            }
            fVar.K(10, aVar.f33123i);
        }
    }

    /* compiled from: DataPointDao_Impl.java */
    /* renamed from: rf.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0462c extends l {
        C0462c(c cVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "DELETE FROM data_point WHERE _id = ?";
        }
    }

    /* compiled from: DataPointDao_Impl.java */
    /* loaded from: classes2.dex */
    class d extends l {
        d(c cVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "UPDATE data_point SET wwid=?, synced=0 WHERE wwid = ''";
        }
    }

    public c(RoomDatabase roomDatabase) {
        this.f33502a = roomDatabase;
        this.f33503b = new a(this, roomDatabase);
        new b(this, roomDatabase);
        new C0462c(this, roomDatabase);
        new d(this, roomDatabase);
    }

    private qf.a t(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("device_id");
        int columnIndex2 = cursor.getColumnIndex("wwid");
        int columnIndex3 = cursor.getColumnIndex("type");
        int columnIndex4 = cursor.getColumnIndex(Constants.Fitness.DATA_TIME_TO);
        int columnIndex5 = cursor.getColumnIndex(Constants.Fitness.DATA_TIME_FROM);
        int columnIndex6 = cursor.getColumnIndex("synced");
        int columnIndex7 = cursor.getColumnIndex("deleted");
        int columnIndex8 = cursor.getColumnIndex("_id");
        int columnIndex9 = cursor.getColumnIndex("values");
        qf.a aVar = new qf.a();
        if (columnIndex != -1) {
            if (cursor.isNull(columnIndex)) {
                aVar.f33125a = null;
            } else {
                aVar.f33125a = cursor.getString(columnIndex);
            }
        }
        if (columnIndex2 != -1) {
            if (cursor.isNull(columnIndex2)) {
                aVar.f33126b = null;
            } else {
                aVar.f33126b = cursor.getString(columnIndex2);
            }
        }
        if (columnIndex3 != -1) {
            aVar.f33127c = cursor.getInt(columnIndex3);
        }
        if (columnIndex4 != -1) {
            aVar.f33128d = cursor.getLong(columnIndex4);
        }
        if (columnIndex5 != -1) {
            aVar.f33129e = cursor.getLong(columnIndex5);
        }
        if (columnIndex6 != -1) {
            aVar.f33130f = cursor.getInt(columnIndex6);
        }
        if (columnIndex7 != -1) {
            aVar.f33131g = cursor.getInt(columnIndex7);
        }
        if (columnIndex8 != -1) {
            aVar.f33123i = cursor.getInt(columnIndex8);
        }
        if (columnIndex9 != -1) {
            if (cursor.isNull(columnIndex9)) {
                aVar.f33124j = null;
            } else {
                aVar.f33124j = cursor.getString(columnIndex9);
            }
        }
        return aVar;
    }

    public static List<Class<?>> u() {
        return Collections.emptyList();
    }

    @Override // rf.b
    public int a(e eVar) {
        this.f33502a.d();
        int i10 = 0;
        Cursor b10 = h1.c.b(this.f33502a, eVar, false, null);
        try {
            if (b10.moveToFirst()) {
                i10 = b10.getInt(0);
            }
            return i10;
        } finally {
            b10.close();
        }
    }

    @Override // rf.b
    public Long b(qf.a aVar) {
        this.f33502a.d();
        this.f33502a.e();
        try {
            long k10 = this.f33503b.k(aVar);
            this.f33502a.B();
            return Long.valueOf(k10);
        } finally {
            this.f33502a.i();
        }
    }

    @Override // rf.b
    public /* synthetic */ List c(String str, String str2, DataType dataType, long j10, long j11, String str3) {
        return rf.a.d(this, str, str2, dataType, j10, j11, str3);
    }

    @Override // rf.b
    public /* synthetic */ int d(qf.a aVar) {
        return rf.a.a(this, aVar);
    }

    @Override // rf.b
    public /* synthetic */ List e(String str, String str2, DataType dataType) {
        return rf.a.h(this, str, str2, dataType);
    }

    @Override // rf.b
    public int f(String str, String str2, int i10, long j10, long j11) {
        k h10 = k.h("SELECT COUNT(_id) FROM data_point WHERE wwid = ? AND device_id = ? AND type = ? AND time_from < ? AND time_to > ?", 5);
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
        h10.K(3, i10);
        h10.K(4, j10);
        h10.K(5, j11);
        this.f33502a.d();
        int i11 = 0;
        Cursor b10 = h1.c.b(this.f33502a, h10, false, null);
        try {
            if (b10.moveToFirst()) {
                i11 = b10.getInt(0);
            }
            return i11;
        } finally {
            b10.close();
            h10.o();
        }
    }

    @Override // rf.b
    public /* synthetic */ List g(String str, String str2, DataType dataType, long j10, long j11) {
        return rf.a.e(this, str, str2, dataType, j10, j11);
    }

    @Override // rf.b
    public List<qf.a> h(e eVar) {
        this.f33502a.d();
        Cursor b10 = h1.c.b(this.f33502a, eVar, false, null);
        try {
            ArrayList arrayList = new ArrayList(b10.getCount());
            while (b10.moveToNext()) {
                arrayList.add(t(b10));
            }
            return arrayList;
        } finally {
            b10.close();
        }
    }

    @Override // rf.b
    public /* synthetic */ List i(i1.a aVar) {
        return rf.a.f(this, aVar);
    }

    @Override // rf.b
    public /* synthetic */ int j(qf.a aVar) {
        return rf.a.b(this, aVar);
    }

    @Override // rf.b
    public /* synthetic */ List k(String str, String str2, DataType dataType, long j10) {
        return rf.a.i(this, str, str2, dataType, j10);
    }

    @Override // rf.b
    public qf.a l(String str, String str2, int i10) {
        k h10 = k.h("SELECT * FROM data_point WHERE wwid = ? AND device_id = ? AND type = ?  ORDER BY time_to DESC LIMIT 1", 3);
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
        h10.K(3, i10);
        this.f33502a.d();
        qf.a aVar = null;
        Cursor b10 = h1.c.b(this.f33502a, h10, false, null);
        try {
            int e10 = h1.b.e(b10, "device_id");
            int e11 = h1.b.e(b10, "wwid");
            int e12 = h1.b.e(b10, "type");
            int e13 = h1.b.e(b10, Constants.Fitness.DATA_TIME_TO);
            int e14 = h1.b.e(b10, Constants.Fitness.DATA_TIME_FROM);
            int e15 = h1.b.e(b10, "synced");
            int e16 = h1.b.e(b10, "deleted");
            int e17 = h1.b.e(b10, "_id");
            int e18 = h1.b.e(b10, "values");
            if (b10.moveToFirst()) {
                qf.a aVar2 = new qf.a();
                if (b10.isNull(e10)) {
                    aVar2.f33125a = null;
                } else {
                    aVar2.f33125a = b10.getString(e10);
                }
                if (b10.isNull(e11)) {
                    aVar2.f33126b = null;
                } else {
                    aVar2.f33126b = b10.getString(e11);
                }
                aVar2.f33127c = b10.getInt(e12);
                aVar2.f33128d = b10.getLong(e13);
                aVar2.f33129e = b10.getLong(e14);
                aVar2.f33130f = b10.getInt(e15);
                aVar2.f33131g = b10.getInt(e16);
                aVar2.f33123i = b10.getInt(e17);
                if (b10.isNull(e18)) {
                    aVar2.f33124j = null;
                } else {
                    aVar2.f33124j = b10.getString(e18);
                }
                aVar = aVar2;
            }
            return aVar;
        } finally {
            b10.close();
            h10.o();
        }
    }

    @Override // rf.b
    public /* synthetic */ int m(qf.a aVar) {
        return rf.a.c(this, aVar);
    }

    @Override // rf.b
    public /* synthetic */ List n(String str, String str2, DataType dataType, long j10, long j11) {
        return rf.a.g(this, str, str2, dataType, j10, j11);
    }

    @Override // rf.b
    public List<Long> o(DataPoint... dataPointArr) {
        this.f33502a.d();
        this.f33502a.e();
        try {
            List<Long> l10 = this.f33503b.l(dataPointArr);
            this.f33502a.B();
            return l10;
        } finally {
            this.f33502a.i();
        }
    }

    @Override // rf.b
    public int p(String str, String str2, int i10, long j10) {
        k h10 = k.h("SELECT COUNT(_id) FROM data_point WHERE wwid = ? AND device_id = ? AND type = ? AND  time_to = ?", 4);
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
        h10.K(3, i10);
        h10.K(4, j10);
        this.f33502a.d();
        int i11 = 0;
        Cursor b10 = h1.c.b(this.f33502a, h10, false, null);
        try {
            if (b10.moveToFirst()) {
                i11 = b10.getInt(0);
            }
            return i11;
        } finally {
            b10.close();
            h10.o();
        }
    }

    @Override // rf.b
    public int q(String str, String str2, int i10, long j10, long j11) {
        k h10 = k.h("SELECT COUNT(_id) FROM data_point WHERE wwid = ? AND device_id = ? AND type = ? AND time_from = ? AND time_to = ?", 5);
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
        h10.K(3, i10);
        h10.K(4, j10);
        h10.K(5, j11);
        this.f33502a.d();
        int i11 = 0;
        Cursor b10 = h1.c.b(this.f33502a, h10, false, null);
        try {
            if (b10.moveToFirst()) {
                i11 = b10.getInt(0);
            }
            return i11;
        } finally {
            b10.close();
            h10.o();
        }
    }

    @Override // rf.b
    public /* synthetic */ int r(e eVar) {
        return rf.a.j(this, eVar);
    }

    @Override // rf.b
    public /* synthetic */ int s(String str, DataType dataType, long j10, long j11) {
        return rf.a.k(this, str, dataType, j10, j11);
    }
}
