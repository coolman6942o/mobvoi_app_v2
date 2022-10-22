package w8;
/* compiled from: DataCharacter.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f36139a;

    /* renamed from: b  reason: collision with root package name */
    private final int f36140b;

    public b(int i10, int i11) {
        this.f36139a = i10;
        this.f36140b = i11;
    }

    public final int a() {
        return this.f36140b;
    }

    public final int b() {
        return this.f36139a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f36139a == bVar.f36139a && this.f36140b == bVar.f36140b;
    }

    public final int hashCode() {
        return this.f36139a ^ this.f36140b;
    }

    public final String toString() {
        return this.f36139a + "(" + this.f36140b + ')';
    }
}
