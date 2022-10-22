package ag;

import com.mobvoi.health.common.data.pojo.ActivityType;
import yf.c;
/* compiled from: DataSessionSync.java */
/* loaded from: classes2.dex */
public class d extends c {
    public String sid;
    public int activity = ActivityType.Unknown.typeCode;
    public long time_from = 0;
    public long time_to = 0;
    public int deleted = 0;

    public static d a(String str, String str2, int i10, wf.d dVar) {
        d dVar2 = new d();
        dVar2.wwid = str;
        dVar2.device_id = str2;
        dVar2.activity = i10;
        dVar2.sid = dVar.session_id;
        dVar2.time_from = dVar.start_time_ms;
        dVar2.time_to = dVar.end_time_ms;
        dVar2.deleted = dVar.deleted;
        return dVar2;
    }

    public static d b(qf.c cVar) {
        d dVar = new d();
        dVar.wwid = cVar.f33126b;
        dVar.device_id = cVar.f33125a;
        dVar.sid = cVar.f33133i;
        dVar.activity = cVar.f33127c;
        dVar.time_from = cVar.f33129e;
        dVar.time_to = cVar.f33128d;
        dVar.deleted = cVar.f33131g;
        return dVar;
    }

    public String toString() {
        return "DataSessionSync[sid=" + this.sid + ", type=" + ActivityType.from(this.activity) + ", deleted=" + this.deleted + ", timeFrom=" + com.mobvoi.android.common.utils.d.a(this.time_from) + ", timeTo=" + com.mobvoi.android.common.utils.d.a(this.time_to) + ", wwid=" + this.wwid + ", did=" + this.device_id + "]";
    }
}
