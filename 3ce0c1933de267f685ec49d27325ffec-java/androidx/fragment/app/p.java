package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.f0;
import androidx.lifecycle.h0;
import androidx.lifecycle.i0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentManagerViewModel.java */
/* loaded from: classes.dex */
public final class p extends f0 {

    /* renamed from: h  reason: collision with root package name */
    private static final h0.b f3156h = new a();

    /* renamed from: d  reason: collision with root package name */
    private final boolean f3160d;

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, Fragment> f3157a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, p> f3158b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, i0> f3159c = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private boolean f3161e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3162f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3163g = false;

    /* compiled from: FragmentManagerViewModel.java */
    /* loaded from: classes.dex */
    class a implements h0.b {
        a() {
        }

        @Override // androidx.lifecycle.h0.b
        public <T extends f0> T a(Class<T> cls) {
            return new p(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(boolean z10) {
        this.f3160d = z10;
    }

    private void d(String str) {
        p pVar = this.f3158b.get(str);
        if (pVar != null) {
            pVar.onCleared();
            this.f3158b.remove(str);
        }
        i0 i0Var = this.f3159c.get(str);
        if (i0Var != null) {
            i0Var.a();
            this.f3159c.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static p g(i0 i0Var) {
        return (p) new h0(i0Var, f3156h).a(p.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment) {
        if (this.f3163g) {
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (!this.f3157a.containsKey(fragment.mWho)) {
            this.f3157a.put(fragment.mWho, fragment);
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Fragment fragment) {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        d(fragment.mWho);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str) {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
        }
        d(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment e(String str) {
        return this.f3157a.get(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        return this.f3157a.equals(pVar.f3157a) && this.f3158b.equals(pVar.f3158b) && this.f3159c.equals(pVar.f3159c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p f(Fragment fragment) {
        p pVar = this.f3158b.get(fragment.mWho);
        if (pVar != null) {
            return pVar;
        }
        p pVar2 = new p(this.f3160d);
        this.f3158b.put(fragment.mWho, pVar2);
        return pVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Collection<Fragment> h() {
        return new ArrayList(this.f3157a.values());
    }

    public int hashCode() {
        return (((this.f3157a.hashCode() * 31) + this.f3158b.hashCode()) * 31) + this.f3159c.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i0 i(Fragment fragment) {
        i0 i0Var = this.f3159c.get(fragment.mWho);
        if (i0Var != null) {
            return i0Var;
        }
        i0 i0Var2 = new i0();
        this.f3159c.put(fragment.mWho, i0Var2);
        return i0Var2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j() {
        return this.f3161e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Fragment fragment) {
        if (!this.f3163g) {
            if ((this.f3157a.remove(fragment.mWho) != null) && FragmentManager.H0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
            }
        } else if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(boolean z10) {
        this.f3163g = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m(Fragment fragment) {
        if (!this.f3157a.containsKey(fragment.mWho)) {
            return true;
        }
        if (this.f3160d) {
            return this.f3161e;
        }
        return !this.f3162f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.f0
    public void onCleared() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f3161e = true;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("FragmentManagerViewModel{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} Fragments (");
        Iterator<Fragment> it = this.f3157a.values().iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") Child Non Config (");
        Iterator<String> it2 = this.f3158b.keySet().iterator();
        while (it2.hasNext()) {
            sb2.append(it2.next());
            if (it2.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") ViewModelStores (");
        Iterator<String> it3 = this.f3159c.keySet().iterator();
        while (it3.hasNext()) {
            sb2.append(it3.next());
            if (it3.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(')');
        return sb2.toString();
    }
}
