package ag;

import com.mobvoi.health.common.data.pojo.DataType;
import yf.c;
/* compiled from: DataSetIdentify.java */
/* loaded from: classes2.dex */
public class e extends c {
    public int type = DataType.Unknown.typeCode;
    public long time_from = 0;
    public long time_to = 0;

    public static e a(g gVar) {
        e eVar = new e();
        eVar.device_id = gVar.device_id;
        eVar.wwid = gVar.wwid;
        eVar.type = gVar.type;
        eVar.time_from = gVar.time_from;
        eVar.time_to = gVar.time_to;
        return eVar;
    }
}
