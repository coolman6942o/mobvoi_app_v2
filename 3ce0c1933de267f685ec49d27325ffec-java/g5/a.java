package g5;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import n5.k;
/* compiled from: ActivityFragmentLifecycle.java */
/* loaded from: classes.dex */
class a implements h {

    /* renamed from: a  reason: collision with root package name */
    private final Set<i> f27260a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private boolean f27261b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f27262c;

    @Override // g5.h
    public void a(i iVar) {
        this.f27260a.add(iVar);
        if (this.f27262c) {
            iVar.onDestroy();
        } else if (this.f27261b) {
            iVar.onStart();
        } else {
            iVar.onStop();
        }
    }

    @Override // g5.h
    public void b(i iVar) {
        this.f27260a.remove(iVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f27262c = true;
        for (i iVar : k.i(this.f27260a)) {
            iVar.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        this.f27261b = true;
        for (i iVar : k.i(this.f27260a)) {
            iVar.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.f27261b = false;
        for (i iVar : k.i(this.f27260a)) {
            iVar.onStop();
        }
    }
}
