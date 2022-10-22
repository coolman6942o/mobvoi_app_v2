package zj;

import com.mobvoi.sleep.data.pojo.SleepRecord;
import java.util.LinkedList;
import java.util.List;
import xf.h;
/* compiled from: ConvertUtils.java */
/* loaded from: classes2.dex */
public class b {
    public static List<h> a(SleepRecord sleepRecord) {
        LinkedList linkedList = new LinkedList();
        if (!(sleepRecord == null || sleepRecord.b() == null)) {
            for (yj.b bVar : sleepRecord.b()) {
                linkedList.add(new h(bVar.time, Math.round(bVar.value)));
            }
        }
        return linkedList;
    }
}
