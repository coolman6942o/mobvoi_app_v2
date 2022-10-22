package rh;

import com.mobvoi.android.common.utils.d;
import java.util.Locale;
/* compiled from: HeartRate.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final long f33518a;

    /* renamed from: b  reason: collision with root package name */
    public final float f33519b;

    public b(long j10, float f10) {
        this.f33518a = j10;
        this.f33519b = f10;
    }

    public String toString() {
        return String.format(Locale.US, "HeartRate[time=%s, value=%s]", d.a(this.f33518a), Float.valueOf(this.f33519b));
    }
}
