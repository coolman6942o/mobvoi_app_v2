package xf;

import com.mobvoi.android.common.utils.d;
import java.util.Locale;
/* compiled from: TimeRange.java */
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final long f36540a;

    /* renamed from: b  reason: collision with root package name */
    public final long f36541b;

    public g(long j10, long j11) {
        this.f36540a = j10;
        this.f36541b = j11;
    }

    public String toString() {
        return String.format(Locale.US, "TimeRange[timeFrom=%s, timeTo=%s]", d.a(this.f36540a), d.a(this.f36541b));
    }
}
