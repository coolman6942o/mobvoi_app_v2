package rf;

import com.mobvoi.health.common.data.pojo.ActivityType;
import i1.a;
import java.util.ArrayList;
import java.util.List;
/* compiled from: DataSessionDao.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class d {
    public static List a(e _this, String str, String str2, ActivityType activityType, long j10, long j11, String str3) {
        StringBuilder sb2 = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        sb2.append("SELECT * FROM data_session WHERE ");
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
        if (activityType != null) {
            sb2.append("AND type = ? ");
            arrayList.add(Integer.valueOf(activityType.getTypeCode()));
        }
        if (str3 != null) {
            sb2.append(str3);
        }
        return _this.a(new a(sb2.toString(), arrayList.toArray()));
    }

    public static List b(e _this, String str, String str2, ActivityType activityType, long j10, long j11) {
        return _this.b(str, str2, activityType, j10, j11, "ORDER BY time_to ASC");
    }

    public static List c(e _this, String str, String str2, ActivityType activityType, long j10) {
        StringBuilder sb2 = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        sb2.append("SELECT * FROM data_session WHERE ");
        sb2.append("(time_from > 0 AND time_to > 0) ");
        sb2.append("AND synced = ");
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
        if (activityType != null) {
            sb2.append("AND type = ? ");
            arrayList.add(Integer.valueOf(activityType.getTypeCode()));
        }
        if (j10 > 0) {
            sb2.append("AND time_to <= ? ");
            arrayList.add(Long.valueOf(j10));
        }
        sb2.append("ORDER BY time_to DESC LIMIT 2000");
        return _this.a(new a(sb2.toString(), arrayList.toArray()));
    }
}
