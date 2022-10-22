package g5;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import k5.i;
import n5.k;
/* compiled from: TargetTracker.java */
/* loaded from: classes.dex */
public final class p implements i {

    /* renamed from: a  reason: collision with root package name */
    private final Set<i<?>> f27292a = Collections.newSetFromMap(new WeakHashMap());

    public void i() {
        this.f27292a.clear();
    }

    public List<i<?>> j() {
        return k.i(this.f27292a);
    }

    public void k(i<?> iVar) {
        this.f27292a.add(iVar);
    }

    public void l(i<?> iVar) {
        this.f27292a.remove(iVar);
    }

    @Override // g5.i
    public void onDestroy() {
        for (i iVar : k.i(this.f27292a)) {
            iVar.onDestroy();
        }
    }

    @Override // g5.i
    public void onStart() {
        for (i iVar : k.i(this.f27292a)) {
            iVar.onStart();
        }
    }

    @Override // g5.i
    public void onStop() {
        for (i iVar : k.i(this.f27292a)) {
            iVar.onStop();
        }
    }
}
