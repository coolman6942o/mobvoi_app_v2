package rf;

import android.database.sqlite.SQLiteException;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.health.common.data.pojo.DataType;
import i1.e;
import java.util.ArrayList;
import java.util.List;
/* compiled from: DataPointDao.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class a {
    public static int a(b _this, qf.a aVar) {
        return _this.q(aVar.f33126b, aVar.f33125a, aVar.f33127c, aVar.f33129e, aVar.f33128d);
    }

    public static int b(b _this, qf.a aVar) {
        return _this.p(aVar.f33126b, aVar.f33125a, aVar.f33127c, aVar.f33128d);
    }

    public static int c(b _this, qf.a aVar) {
        return _this.f(aVar.f33126b, aVar.f33125a, aVar.f33127c, aVar.f33128d, aVar.f33129e);
    }

    public static List d(b _this, String str, String str2, DataType dataType, long j10, long j11, String str3) {
        StringBuilder sb2 = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        sb2.append("SELECT * FROM data_point WHERE ");
        sb2.append("(time_to >= ? AND time_to < ?) ");
        arrayList.add(Long.valueOf(j10));
        arrayList.add(Long.valueOf(j11));
        if (str != null) {
            sb2.append("AND wwid = ? ");
            arrayList.add(str);
        }
        if (str2 != null) {
            sb2.append("AND device_id = ? ");
            arrayList.add(str2);
        }
        if (dataType != null) {
            sb2.append("AND type = ? ");
            arrayList.add(Integer.valueOf(dataType.getTypeCode()));
        }
        if (str3 != null) {
            sb2.append(str3);
        }
        return _this.i(new i1.a(sb2.toString(), arrayList.toArray()));
    }

    public static List e(b _this, String str, String str2, DataType dataType, long j10, long j11) {
        return _this.c(str, str2, dataType, j10, j11, "ORDER BY time_to ASC");
    }

    public static List f(b _this, i1.a aVar) {
        ArrayList arrayList = new ArrayList();
        try {
            try {
                return _this.h(aVar);
            } catch (SQLiteException e10) {
                k.e("DataPointDao", "findDataPointsSafe SQLiteException", e10);
                return arrayList;
            }
        } catch (Throwable unused) {
            return arrayList;
        }
    }

    public static List g(b _this, String str, String str2, DataType dataType, long j10, long j11) {
        return _this.c(str, str2, dataType, j10, j11, "ORDER BY time_to DESC LIMIT 1");
    }

    public static List h(b _this, String str, String str2, DataType dataType) {
        boolean z10;
        StringBuilder sb2 = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        sb2.append("SELECT * FROM data_point ");
        boolean z11 = true;
        if (str != null) {
            sb2.append("WHERE ");
            sb2.append("wwid = ? ");
            arrayList.add(str);
            z10 = true;
        } else {
            z10 = false;
        }
        if (str2 != null) {
            if (!z10) {
                sb2.append("WHERE ");
                sb2.append("device_id = ? ");
            } else {
                sb2.append("AND device_id = ? ");
                z11 = z10;
            }
            arrayList.add(str2);
            z10 = z11;
        }
        if (dataType != null) {
            if (!z10) {
                sb2.append("WHERE ");
                sb2.append("type = ? ");
            } else {
                sb2.append("AND type = ? ");
            }
            arrayList.add(Integer.valueOf(dataType.getTypeCode()));
        }
        sb2.append("ORDER BY time_to DESC LIMIT 1");
        return _this.i(new i1.a(sb2.toString(), arrayList.toArray()));
    }

    public static List i(b _this, String str, String str2, DataType dataType, long j10) {
        StringBuilder sb2 = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        sb2.append("SELECT * FROM data_point WHERE synced= ");
        sb2.append(0);
        sb2.append(" ");
        if (str != null) {
            sb2.append("AND wwid = ? ");
            arrayList.add(str);
        }
        if (str2 != null) {
            sb2.append("AND device_id = ? ");
            arrayList.add(str2);
        }
        if (dataType != null) {
            sb2.append("AND type = ? ");
            arrayList.add(Integer.valueOf(dataType.getTypeCode()));
        }
        if (j10 > 0) {
            sb2.append("AND time_to <= ? ");
            arrayList.add(Long.valueOf(j10));
        }
        sb2.append("ORDER BY time_to DESC LIMIT 2000");
        return _this.i(new i1.a(sb2.toString(), arrayList.toArray()));
    }

    public static int j(b _this, e eVar) {
        try {
            try {
                return _this.a(eVar);
            } catch (SQLiteException e10) {
                k.e("DataPointDao", "updateDataPointsSafe SQLiteException", e10);
                return 0;
            }
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static int k(b _this, String str, DataType dataType, long j10, long j11) {
        StringBuilder sb2 = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        sb2.append("UPDATE data_point SET synced= ");
        sb2.append(1);
        sb2.append(" WHERE ");
        sb2.append("(time_to >= ? AND time_to < ?) ");
        arrayList.add(Long.valueOf(j10));
        arrayList.add(Long.valueOf(j11));
        if (str != null) {
            sb2.append("AND wwid = ? ");
            arrayList.add(str);
        }
        if (dataType != null) {
            sb2.append("AND type = ? ");
            arrayList.add(Integer.valueOf(dataType.getTypeCode()));
        }
        return _this.r(new i1.a(sb2.toString(), arrayList.toArray()));
    }
}
