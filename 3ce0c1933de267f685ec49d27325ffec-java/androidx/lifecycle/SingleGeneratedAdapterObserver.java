package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SingleGeneratedAdapterObserver implements n {

    /* renamed from: a  reason: collision with root package name */
    private final i f3274a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SingleGeneratedAdapterObserver(i iVar) {
        this.f3274a = iVar;
    }

    @Override // androidx.lifecycle.n
    public void c(p pVar, Lifecycle.Event event) {
        this.f3274a.a(pVar, event, false, null);
        this.f3274a.a(pVar, event, true, null);
    }
}
