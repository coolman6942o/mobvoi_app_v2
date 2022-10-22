package ih;

import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.d;
import java.util.Locale;
/* compiled from: Temperature.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final long f28271a;

    /* renamed from: b  reason: collision with root package name */
    public final float f28272b;

    public a(long j10, float f10) {
        this.f28271a = j10;
        this.f28272b = f10;
    }

    public static float a(float f10) {
        return !com.mobvoi.companion.base.settings.a.isTempCelsius(b.e()) ? (float) ((f10 * 1.8d) + 32.0d) : f10;
    }

    public long b() {
        return this.f28271a;
    }

    public float c() {
        return this.f28272b;
    }

    public String toString() {
        return String.format(Locale.US, "Temperature[time=%s, value=%s]", d.a(this.f28271a), Float.valueOf(this.f28272b));
    }
}
