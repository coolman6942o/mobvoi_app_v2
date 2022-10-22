package xc;

import com.mobvoi.health.core.data.pojo.DataType;
import kotlin.jvm.internal.i;
import oh.a;
/* compiled from: HealthCardData.kt */
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final a f36508a;

    /* renamed from: b  reason: collision with root package name */
    private final int f36509b;

    /* renamed from: c  reason: collision with root package name */
    private final int f36510c;

    /* renamed from: d  reason: collision with root package name */
    private final int f36511d;

    public e(a aVar, int i10, int i11, int i12) {
        this.f36508a = aVar;
        this.f36509b = i10;
        this.f36510c = i11;
        this.f36511d = i12;
    }

    public final int a() {
        return this.f36511d;
    }

    public final int b() {
        return this.f36510c;
    }

    public final int c() {
        return this.f36509b;
    }

    public final int d(DataType dataType) {
        i.f(dataType, "dataType");
        a aVar = this.f36508a;
        if (aVar == null) {
            return 0;
        }
        return aVar.e(dataType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return i.b(this.f36508a, eVar.f36508a) && this.f36509b == eVar.f36509b && this.f36510c == eVar.f36510c && this.f36511d == eVar.f36511d;
    }

    public int hashCode() {
        a aVar = this.f36508a;
        return ((((((aVar == null ? 0 : aVar.hashCode()) * 31) + this.f36509b) * 31) + this.f36510c) * 31) + this.f36511d;
    }

    public String toString() {
        return "DataForDayWrapper(data=" + this.f36508a + ", stepGoal=" + this.f36509b + ", exerciseGoal=" + this.f36510c + ", activeGoal=" + this.f36511d + ')';
    }
}
