package ef;

import com.mobvoi.health.common.data.pojo.SportType;
/* compiled from: HiitTypeTimes.java */
/* loaded from: classes2.dex */
public class i extends k<Integer> {
    public final int a() {
        T[] tArr = this.f25943d;
        if (((Integer[]) tArr).length >= 3) {
            return ((Integer[]) tArr)[2].intValue();
        }
        return 0;
    }

    public final SportType b() {
        return SportType.from(((Integer[]) this.f25943d)[0].intValue());
    }
}
