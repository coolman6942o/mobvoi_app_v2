package bg;

import com.mobvoi.health.common.data.pojo.DataType;
import java.util.Date;
import java.util.Locale;
/* compiled from: DataFragment.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final DataType f5138a;

    /* renamed from: b  reason: collision with root package name */
    public final long f5139b;

    /* renamed from: c  reason: collision with root package name */
    public final long f5140c;

    /* renamed from: d  reason: collision with root package name */
    public final float f5141d;

    private a(a aVar) {
        this(aVar.f5138a, aVar.f5139b, aVar.f5140c, aVar.f5141d);
    }

    public static a a(long j10) {
        return new a(null, j10, j10, 0.0f);
    }

    public static a b(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new a(aVar);
    }

    public static a c(qf.a aVar) {
        if (aVar == null) {
            return null;
        }
        return new a(aVar);
    }

    public a d(a aVar) {
        long j10;
        long j11;
        a f10;
        if (this.f5138a == aVar.f5138a) {
            a f11 = f(aVar.f5139b, aVar.f5140c);
            if (f11 == null || (f10 = aVar.f((j10 = f11.f5139b), (j11 = f11.f5140c))) == null) {
                return null;
            }
            return new a(this.f5138a, j10, j11, Math.max(f11.f5141d, f10.f5141d));
        }
        throw new IllegalArgumentException("fragments must have same type");
    }

    public boolean e(a aVar) {
        return aVar.f5139b < this.f5140c && aVar.f5140c > this.f5139b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f5138a == aVar.f5138a && this.f5139b == aVar.f5139b && this.f5140c == aVar.f5140c && this.f5141d == aVar.f5141d;
    }

    public a f(long j10, long j11) {
        if (j10 <= j11) {
            long j12 = this.f5140c;
            if (j10 > j12) {
                return null;
            }
            long j13 = this.f5139b;
            if (j11 < j13) {
                return null;
            }
            long j14 = j10 < j13 ? j13 : j10;
            long j15 = j11 > j12 ? j12 : j11;
            long j16 = j12 - j13;
            long j17 = j15 - j14;
            if (j16 == 0) {
                return new a(this);
            }
            if (j17 == 0) {
                return new a(this.f5138a, j14, j15, 0.0f);
            }
            return new a(this.f5138a, j14, j15, (this.f5141d * ((float) j17)) / ((float) j16));
        }
        throw new IllegalArgumentException("from should <= to");
    }

    public String toString() {
        return String.format(Locale.getDefault(), "DataFragment {%s, %s-%s, %.1f}", this.f5138a, new Date(this.f5139b).toString(), new Date(this.f5140c).toString(), Float.valueOf(this.f5141d));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private a(qf.a aVar) {
        this(r2, r0 == 0 ? aVar.f33128d : r0, aVar.f33128d, aVar.e());
        DataType from = DataType.from(aVar.f33127c);
        long j10 = aVar.f33129e;
    }

    private a(DataType dataType, long j10, long j11, float f10) {
        this.f5138a = dataType;
        this.f5139b = Math.min(j10, j11);
        this.f5140c = Math.max(j10, j11);
        this.f5141d = f10;
    }
}
