package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* compiled from: ViewModelStore.java */
/* loaded from: classes.dex */
public class i0 {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, f0> f3322a = new HashMap<>();

    public final void a() {
        for (f0 f0Var : this.f3322a.values()) {
            f0Var.clear();
        }
        this.f3322a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final f0 b(String str) {
        return this.f3322a.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<String> c() {
        return new HashSet(this.f3322a.keySet());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(String str, f0 f0Var) {
        f0 put = this.f3322a.put(str, f0Var);
        if (put != null) {
            put.onCleared();
        }
    }
}
