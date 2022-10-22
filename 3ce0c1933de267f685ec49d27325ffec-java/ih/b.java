package ih;

import hg.f;
import java.util.List;
/* compiled from: TodayTemperature.java */
/* loaded from: classes2.dex */
public class b extends f {

    /* renamed from: b  reason: collision with root package name */
    public float f28273b;

    /* renamed from: c  reason: collision with root package name */
    public float f28274c;

    /* renamed from: d  reason: collision with root package name */
    public float f28275d;

    /* renamed from: e  reason: collision with root package name */
    public int f28276e;

    /* renamed from: f  reason: collision with root package name */
    public int f28277f;

    /* renamed from: g  reason: collision with root package name */
    public long f28278g;

    /* renamed from: h  reason: collision with root package name */
    public List<a> f28279h;

    public b(float f10, float f11, float f12, int i10, int i11, long j10, List<a> list) {
        super(j10);
        this.f28273b = f10;
        this.f28274c = f11;
        this.f28275d = f12;
        this.f28276e = i10;
        this.f28277f = i11;
        this.f28278g = j10;
        this.f28279h = list;
    }

    public String toString() {
        return "TodayTemperature{avg=" + this.f28273b + ", min=" + this.f28274c + ", max=" + this.f28275d + ", minIndex=" + this.f28276e + ", maxIndex=" + this.f28277f + ", startOfDay=" + this.f28278g + '}';
    }
}
