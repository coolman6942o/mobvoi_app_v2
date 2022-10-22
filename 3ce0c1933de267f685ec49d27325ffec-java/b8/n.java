package b8;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
final class n {

    /* renamed from: a  reason: collision with root package name */
    private final a<?> f5093a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<n> f5094b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    private final Set<n> f5095c = new HashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(a<?> aVar) {
        this.f5093a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(n nVar) {
        this.f5094b.add(nVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(n nVar) {
        this.f5095c.add(nVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(n nVar) {
        this.f5095c.remove(nVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<n> d() {
        return this.f5094b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final a<?> e() {
        return this.f5093a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean f() {
        return this.f5095c.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean g() {
        return this.f5094b.isEmpty();
    }
}
