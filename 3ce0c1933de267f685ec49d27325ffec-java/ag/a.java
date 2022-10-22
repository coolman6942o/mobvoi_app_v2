package ag;

import android.text.TextUtils;
import com.mobvoi.android.common.json.JsonBean;
import wf.h;
/* compiled from: DataPointSync.java */
/* loaded from: classes2.dex */
public class a implements JsonBean {
    public long time_from = 0;
    public long time_to = 0;
    public String values = "";
    public int deleted = 0;

    public static a a(qf.a aVar) {
        a aVar2 = new a();
        aVar2.time_from = aVar.f33129e;
        aVar2.time_to = aVar.f33128d;
        aVar2.values = aVar.f33124j;
        aVar2.deleted = aVar.f33131g;
        return aVar2;
    }

    public static a b(h.a aVar) {
        a aVar2 = new a();
        aVar2.time_from = aVar.start_time_millis;
        aVar2.time_to = aVar.end_time_millis;
        if (!TextUtils.isEmpty(aVar.string_val)) {
            aVar2.values = aVar.string_val;
        } else {
            Double d10 = aVar.fp_val;
            if (d10 == null || d10.doubleValue() == 0.0d) {
                aVar2.values = String.valueOf(aVar.int_val);
            } else {
                aVar2.values = String.valueOf(aVar.fp_val);
            }
        }
        aVar2.deleted = aVar.deleted;
        return aVar2;
    }
}
