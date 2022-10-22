package ze;

import com.alibaba.fastjson.JSON;
import com.mobvoi.android.common.utils.k;
import ef.p;
import j0.d;
import java.util.List;
/* compiled from: MigrationHelper.java */
/* loaded from: classes2.dex */
public class a {
    public static boolean a(long j10, long j11, long j12, List<d<Long, Long>> list) {
        int i10 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
        if (i10 >= 0 && j10 <= 2592000000L) {
            return true;
        }
        String b10 = b(list);
        Object[] objArr = new Object[5];
        objArr[0] = i10 < 0 ? "< 0" : "too large";
        objArr[1] = Long.valueOf(j10);
        objArr[2] = Long.valueOf(j11);
        objArr[3] = Long.valueOf(j12);
        objArr[4] = b10;
        k.s("fit.data.migration", "converted point time %s (%d), with original timestamp %d, startTime %d, pausePairs %s", objArr);
        if (!k.j()) {
            return false;
        }
        throw new RuntimeException("Converted point invalid");
    }

    static String b(List<d<Long, Long>> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        String[] strArr = new String[list.size()];
        for (int i10 = 0; i10 < list.size(); i10++) {
            d<Long, Long> dVar = list.get(i10);
            strArr[i10] = "" + dVar.f29364a + "," + dVar.f29365b;
        }
        return JSON.toJSONString(strArr);
    }

    public static p c(p pVar, long j10, long j11, long j12, List<d<Long, Long>> list) {
        boolean z10 = false;
        boolean z11 = true;
        if (j10 < 2592000000L) {
            pVar.f25951a = j10;
            return pVar;
        }
        if (j10 < j11 || j10 > j12) {
            z10 = true;
        }
        if (z10) {
            return null;
        }
        long j13 = j11;
        long j14 = 0;
        for (d<Long, Long> dVar : list) {
            if (j10 >= dVar.f29364a.longValue() && j10 < dVar.f29365b.longValue()) {
                break;
            } else if (dVar.f29364a.longValue() >= j10) {
                break;
            } else {
                j14 += dVar.f29364a.longValue() - j13;
                j13 = dVar.f29365b.longValue();
            }
        }
        z11 = z10;
        if (z11) {
            return null;
        }
        long j15 = (j10 - j13) + j14;
        if (j15 >= 0) {
            pVar.f25951a = j15;
            pVar.f25952b = j10;
        }
        return pVar;
    }
}
