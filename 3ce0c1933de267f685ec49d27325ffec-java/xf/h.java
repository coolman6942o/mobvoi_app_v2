package xf;

import com.mobvoi.health.common.data.pojo.HeartRateLevel;
import java.util.Locale;
/* compiled from: UiHeartRate.java */
/* loaded from: classes2.dex */
public class h implements f {

    /* renamed from: a  reason: collision with root package name */
    public long f36542a;

    /* renamed from: b  reason: collision with root package name */
    public float f36543b;

    /* renamed from: c  reason: collision with root package name */
    public HeartRateLevel f36544c;

    public h(long j10, float f10) {
        this.f36542a = j10;
        this.f36543b = f10;
        this.f36544c = HeartRateLevel.NONE;
    }

    @Override // xf.f
    public double a() {
        return this.f36542a / 1000.0d;
    }

    public int b() {
        return Math.round(this.f36543b);
    }

    @Override // xf.f
    public double getValue() {
        return this.f36543b;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "HR {%d, %.1f}", Long.valueOf(this.f36542a), Float.valueOf(this.f36543b));
    }

    public h(long j10, float f10, HeartRateLevel heartRateLevel) {
        this.f36542a = j10;
        this.f36543b = f10;
        this.f36544c = heartRateLevel;
    }
}
