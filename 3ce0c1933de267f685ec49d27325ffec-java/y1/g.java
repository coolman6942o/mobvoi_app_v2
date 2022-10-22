package y1;
/* compiled from: SystemIdInfo.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final String f36675a;

    /* renamed from: b  reason: collision with root package name */
    public final int f36676b;

    public g(String str, int i10) {
        this.f36675a = str;
        this.f36676b = i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f36676b != gVar.f36676b) {
            return false;
        }
        return this.f36675a.equals(gVar.f36675a);
    }

    public int hashCode() {
        return (this.f36675a.hashCode() * 31) + this.f36676b;
    }
}
