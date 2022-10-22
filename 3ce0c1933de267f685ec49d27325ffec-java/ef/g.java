package ef;

import com.mobvoi.fitness.core.data.pojo.SportDataType;
import java.util.Arrays;
/* compiled from: HeartRate.java */
/* loaded from: classes2.dex */
public class g extends k<Integer> {
    public g(long j10, int i10, int i11) {
        super(SportDataType.HeartRate, j10, new Integer[]{Integer.valueOf(i11)}, i10);
    }

    public int a() {
        return ((Integer[]) this.f25943d)[0].intValue();
    }

    @Override // ef.k
    public String toString() {
        return "HeartRate{accuracy=" + this.f25942c + ", values=" + Arrays.toString(this.f25943d) + ", type=" + this.f25944a + ", time=" + this.f25945b + '}';
    }
}
