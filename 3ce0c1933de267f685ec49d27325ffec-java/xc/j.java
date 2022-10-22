package xc;

import com.mobvoi.health.core.data.pojo.DataType;
import kotlin.jvm.internal.i;
import oh.a;
/* compiled from: McuActivityCardData.kt */
/* loaded from: classes2.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    private final a f36513a;

    /* renamed from: b  reason: collision with root package name */
    private final int f36514b;

    public j(a aVar, int i10) {
        this.f36513a = aVar;
        this.f36514b = i10;
    }

    public final int a() {
        return this.f36514b;
    }

    public final int b(DataType dataType) {
        i.f(dataType, "dataType");
        a aVar = this.f36513a;
        if (aVar == null) {
            return 0;
        }
        return aVar.e(dataType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return i.b(this.f36513a, jVar.f36513a) && this.f36514b == jVar.f36514b;
    }

    public int hashCode() {
        a aVar = this.f36513a;
        return ((aVar == null ? 0 : aVar.hashCode()) * 31) + this.f36514b;
    }

    public String toString() {
        return "McuActivityBundle(data=" + this.f36513a + ", stepGoal=" + this.f36514b + ')';
    }
}
