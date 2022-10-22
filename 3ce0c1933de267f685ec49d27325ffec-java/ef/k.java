package ef;

import com.mobvoi.fitness.core.data.pojo.SportDataType;
import java.lang.Number;
import java.util.Arrays;
import java.util.Locale;
/* compiled from: SimpleData.java */
/* loaded from: classes2.dex */
public class k<T extends Number> extends n {

    /* renamed from: c  reason: collision with root package name */
    public final int f25942c;

    /* renamed from: d  reason: collision with root package name */
    protected final T[] f25943d;

    public k(SportDataType sportDataType, long j10, T[] tArr, int i10) {
        super(sportDataType, j10);
        this.f25942c = i10;
        this.f25943d = tArr;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "%s: {%d, acc %d, values %s}", this.f25944a.name(), Long.valueOf(this.f25945b), Integer.valueOf(this.f25942c), Arrays.toString(this.f25943d));
    }
}
