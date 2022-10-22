package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.t;
/* compiled from: NavGraphNavigator.java */
@t.b("navigation")
/* loaded from: classes.dex */
public class n extends t<m> {

    /* renamed from: a  reason: collision with root package name */
    private final u f3527a;

    public n(u uVar) {
        this.f3527a = uVar;
    }

    @Override // androidx.navigation.t
    public boolean e() {
        return true;
    }

    /* renamed from: f */
    public m a() {
        return new m(this);
    }

    /* renamed from: g */
    public k b(m mVar, Bundle bundle, q qVar, t.a aVar) {
        int z10 = mVar.z();
        if (z10 != 0) {
            k w10 = mVar.w(z10, false);
            if (w10 != null) {
                return this.f3527a.e(w10.k()).b(w10, w10.c(bundle), qVar, aVar);
            }
            String y10 = mVar.y();
            throw new IllegalArgumentException("navigation destination " + y10 + " is not a direct child of this NavGraph");
        }
        throw new IllegalStateException("no start destination defined via app:startDestination for " + mVar.g());
    }
}
