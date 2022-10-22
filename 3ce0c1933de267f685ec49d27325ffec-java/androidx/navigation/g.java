package androidx.navigation;

import androidx.lifecycle.f0;
import androidx.lifecycle.h0;
import androidx.lifecycle.i0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
/* compiled from: NavControllerViewModel.java */
/* loaded from: classes.dex */
class g extends f0 {

    /* renamed from: b  reason: collision with root package name */
    private static final h0.b f3483b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<UUID, i0> f3484a = new HashMap<>();

    /* compiled from: NavControllerViewModel.java */
    /* loaded from: classes.dex */
    class a implements h0.b {
        a() {
        }

        @Override // androidx.lifecycle.h0.b
        public <T extends f0> T a(Class<T> cls) {
            return new g();
        }
    }

    g() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g b(i0 i0Var) {
        return (g) new h0(i0Var, f3483b).a(g.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(UUID uuid) {
        i0 remove = this.f3484a.remove(uuid);
        if (remove != null) {
            remove.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i0 c(UUID uuid) {
        i0 i0Var = this.f3484a.get(uuid);
        if (i0Var != null) {
            return i0Var;
        }
        i0 i0Var2 = new i0();
        this.f3484a.put(uuid, i0Var2);
        return i0Var2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.f0
    public void onCleared() {
        for (i0 i0Var : this.f3484a.values()) {
            i0Var.a();
        }
        this.f3484a.clear();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("NavControllerViewModel{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} ViewModelStores (");
        Iterator<UUID> it = this.f3484a.keySet().iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(')');
        return sb2.toString();
    }
}
