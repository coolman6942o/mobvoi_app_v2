package ef;

import com.mobvoi.fitness.core.data.pojo.SportDataType;
import java.util.Locale;
/* compiled from: SportLocation.java */
/* loaded from: classes2.dex */
public class o extends n {

    /* renamed from: c  reason: collision with root package name */
    public double f25946c;

    /* renamed from: d  reason: collision with root package name */
    public double f25947d;

    /* renamed from: e  reason: collision with root package name */
    public float f25948e;

    /* renamed from: f  reason: collision with root package name */
    public float f25949f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f25950g;

    public o() {
        this(0L);
    }

    public boolean a() {
        return this.f25948e >= 0.0f;
    }

    public String toString() {
        return String.format(Locale.US, "SportLocation %s {%.8f,%.8f, acc %.2f, speed %.3f, resume %s}", Long.valueOf(this.f25945b), Double.valueOf(this.f25947d), Double.valueOf(this.f25946c), Float.valueOf(this.f25948e), Float.valueOf(this.f25949f), Boolean.valueOf(this.f25950g));
    }

    public o(long j10) {
        super(SportDataType.Location, j10);
        this.f25950g = false;
        this.f25946c = 0.0d;
        this.f25947d = 0.0d;
        this.f25948e = -1.0f;
        this.f25949f = 0.0f;
    }
}
