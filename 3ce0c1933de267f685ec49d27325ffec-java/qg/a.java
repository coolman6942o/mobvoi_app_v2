package qg;

import com.mobvoi.android.common.utils.d;
import java.util.Locale;
/* compiled from: BloodOxygen.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final long f33152a;

    /* renamed from: b  reason: collision with root package name */
    public final float f33153b;

    public a(long j10, float f10) {
        this.f33152a = j10;
        this.f33153b = f10;
    }

    public String toString() {
        return String.format(Locale.US, "BloodOxygen[time=%s, value=%s]", d.a(this.f33152a), Float.valueOf(this.f33153b));
    }
}
