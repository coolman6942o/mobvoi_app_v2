package wf;

import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.health.common.data.pojo.ActivityType;
/* compiled from: DataSession.java */
/* loaded from: classes2.dex */
public class d implements JsonBean {
    public String activity_type;
    public String data_source_name;
    public int deleted = 0;
    public long end_time_ms;
    public String session_id;
    public long start_time_ms;

    public static d a(String str, ag.d dVar) {
        d dVar2 = new d();
        dVar2.data_source_name = str;
        dVar2.session_id = dVar.sid;
        dVar2.activity_type = ActivityType.from(dVar.activity).name;
        dVar2.start_time_ms = dVar.time_from;
        dVar2.end_time_ms = dVar.time_to;
        dVar2.deleted = dVar.deleted;
        return dVar2;
    }
}
