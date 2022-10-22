package ef;

import com.mobvoi.fitness.core.data.pojo.SportDataType;
import java.util.Locale;
/* compiled from: Calorie.java */
/* loaded from: classes2.dex */
public class a extends n {

    /* renamed from: c  reason: collision with root package name */
    private final float f25906c;

    public a(long j10, float f10) {
        super(SportDataType.Calorie, j10);
        this.f25906c = f10;
    }

    public float a() {
        return this.f25906c;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "%s: {%d, calorie %.2f}", this.f25944a.name(), Long.valueOf(this.f25945b), Float.valueOf(this.f25906c));
    }
}
