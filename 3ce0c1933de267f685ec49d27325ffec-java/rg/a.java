package rg;

import com.mobvoi.health.companion.pressure.PressureRateLevel;
import fg.o;
/* compiled from: PressureLevelPercent.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f33510a;

    /* renamed from: b  reason: collision with root package name */
    public PressureRateLevel f33511b;

    /* renamed from: c  reason: collision with root package name */
    public float f33512c;

    /* renamed from: d  reason: collision with root package name */
    public float f33513d;

    public a(int i10, PressureRateLevel pressureRateLevel) {
        this.f33510a = i10;
        this.f33511b = pressureRateLevel;
    }

    public int a() {
        PressureRateLevel pressureRateLevel = this.f33511b;
        if (pressureRateLevel == PressureRateLevel.HIGH) {
            return o.f26475o0;
        }
        if (pressureRateLevel == PressureRateLevel.MEDIUM) {
            return o.f26479q0;
        }
        if (pressureRateLevel == PressureRateLevel.LOW) {
            return o.f26477p0;
        }
        return o.f26481r0;
    }
}
