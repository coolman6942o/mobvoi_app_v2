package pk;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* compiled from: PedometerRunningCalorieData.java */
/* loaded from: classes2.dex */
public class g0 {

    /* renamed from: a  reason: collision with root package name */
    protected String f32799a;

    /* renamed from: c  reason: collision with root package name */
    protected int f32801c;

    /* renamed from: d  reason: collision with root package name */
    protected int f32802d;

    /* renamed from: e  reason: collision with root package name */
    protected String f32803e;

    /* renamed from: g  reason: collision with root package name */
    protected int f32805g;

    /* renamed from: h  reason: collision with root package name */
    protected long f32806h;

    /* renamed from: b  reason: collision with root package name */
    protected List f32800b = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    protected Date f32804f = new Date();

    public List a() {
        return this.f32800b;
    }

    public int b() {
        return this.f32802d;
    }

    public long c() {
        return this.f32806h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g0.class != obj.getClass()) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return this.f32801c == g0Var.f32801c && this.f32806h == g0Var.f32806h;
    }

    public int hashCode() {
        long j10 = this.f32806h;
        return ((this.f32801c + 31) * 31) + ((int) (j10 ^ (j10 >>> 32)));
    }

    public String toString() {
        return "PedometerCalorieData [deviceId=" + this.f32803e + ", broadcastId=" + this.f32799a + ", currentUploadingCount=" + this.f32801c + ", utc=" + this.f32806h + ", remainCount=" + this.f32805g + ", deltaUtc=" + this.f32802d + ", calories=" + this.f32800b + ", measureTime=" + this.f32804f + "]";
    }
}
