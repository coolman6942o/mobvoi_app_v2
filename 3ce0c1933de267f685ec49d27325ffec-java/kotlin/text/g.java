package kotlin.text;

import kotlin.jvm.internal.i;
import vo.c;
/* compiled from: Regex.kt */
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private final String f30106a;

    /* renamed from: b  reason: collision with root package name */
    private final c f30107b;

    public g(String value, c range) {
        i.f(value, "value");
        i.f(range, "range");
        this.f30106a = value;
        this.f30107b = range;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return i.b(this.f30106a, gVar.f30106a) && i.b(this.f30107b, gVar.f30107b);
    }

    public int hashCode() {
        String str = this.f30106a;
        int i10 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        c cVar = this.f30107b;
        if (cVar != null) {
            i10 = cVar.hashCode();
        }
        return hashCode + i10;
    }

    public String toString() {
        return "MatchGroup(value=" + this.f30106a + ", range=" + this.f30107b + ")";
    }
}
