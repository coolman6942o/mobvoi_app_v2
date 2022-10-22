package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CompositeGeneratedAdaptersObserver implements n {

    /* renamed from: a  reason: collision with root package name */
    private final i[] f3238a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompositeGeneratedAdaptersObserver(i[] iVarArr) {
        this.f3238a = iVarArr;
    }

    @Override // androidx.lifecycle.n
    public void c(p pVar, Lifecycle.Event event) {
        v vVar = new v();
        for (i iVar : this.f3238a) {
            iVar.a(pVar, event, false, vVar);
        }
        for (i iVar2 : this.f3238a) {
            iVar2.a(pVar, event, true, vVar);
        }
    }
}
