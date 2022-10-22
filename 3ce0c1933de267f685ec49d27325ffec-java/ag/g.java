package ag;

import com.mobvoi.android.common.utils.d;
import com.mobvoi.health.common.data.pojo.DataType;
import java.util.List;
import yf.c;
/* compiled from: DataSetSync.java */
/* loaded from: classes2.dex */
public class g extends c {
    public List<a> points;
    public int type = DataType.Unknown.typeCode;
    public long time_from = 0;
    public long time_to = 0;

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DataSetSync[type=");
        sb2.append(DataType.from(this.type));
        sb2.append(", points=");
        List<a> list = this.points;
        sb2.append(list == null ? -1 : list.size());
        sb2.append(", timeFrom=");
        sb2.append(d.a(this.time_from));
        sb2.append(", timeTo=");
        sb2.append(d.a(this.time_to));
        sb2.append(", wwid=");
        sb2.append(this.wwid);
        sb2.append(", did=");
        sb2.append(this.device_id);
        sb2.append("]");
        return sb2.toString();
    }
}
