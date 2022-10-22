package wf;

import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.health.common.data.pojo.DataType;
import java.util.List;
/* compiled from: DataSet.java */
/* loaded from: classes2.dex */
public class h implements JsonBean {
    public String data_source_name;
    public long max_end_time_ms;
    public long min_start_time_ms;
    public List<a> points;

    /* compiled from: DataSet.java */
    /* loaded from: classes2.dex */
    public static class a implements JsonBean {
        public String data_type;
        public int deleted = 0;
        public long end_time_millis;
        public Double fp_val;
        public Integer int_val;
        public long start_time_millis;
        public String string_val;

        public static a a(int i10, ag.a aVar) {
            a aVar2 = new a();
            aVar2.data_type = DataType.from(i10).name;
            aVar2.start_time_millis = aVar.time_from;
            aVar2.end_time_millis = aVar.time_to;
            aVar2.string_val = aVar.values;
            aVar2.deleted = aVar.deleted;
            return aVar2;
        }
    }
}
