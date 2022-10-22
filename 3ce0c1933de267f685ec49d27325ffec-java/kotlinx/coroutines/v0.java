package kotlinx.coroutines;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public final class v0 implements e1 {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f30340a;

    public v0(boolean z10) {
        this.f30340a = z10;
    }

    @Override // kotlinx.coroutines.e1
    public boolean c() {
        return this.f30340a;
    }

    @Override // kotlinx.coroutines.e1
    public t1 d() {
        return null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Empty{");
        sb2.append(c() ? "Active" : "New");
        sb2.append('}');
        return sb2.toString();
    }
}
