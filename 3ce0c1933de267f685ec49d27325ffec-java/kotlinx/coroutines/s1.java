package kotlinx.coroutines;
/* compiled from: MainCoroutineDispatcher.kt */
/* loaded from: classes3.dex */
public abstract class s1 extends g0 {
    public abstract s1 W();

    /* JADX INFO: Access modifiers changed from: protected */
    public final String g0() {
        s1 s1Var;
        s1 c10 = t0.c();
        if (this == c10) {
            return "Dispatchers.Main";
        }
        try {
            s1Var = c10.W();
        } catch (UnsupportedOperationException unused) {
            s1Var = null;
        }
        if (this == s1Var) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // kotlinx.coroutines.g0
    public String toString() {
        String g02 = g0();
        if (g02 != null) {
            return g02;
        }
        return o0.a(this) + '@' + o0.b(this);
    }
}
