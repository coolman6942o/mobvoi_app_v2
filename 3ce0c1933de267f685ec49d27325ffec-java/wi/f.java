package wi;

import androidx.lifecycle.f0;
import dq.b;
import rx.j;
/* compiled from: RxViewModel.java */
/* loaded from: classes2.dex */
public abstract class f extends f0 {

    /* renamed from: a  reason: collision with root package name */
    private final b f36253a = new b();

    public void a(j jVar) {
        this.f36253a.a(jVar);
    }

    @Override // androidx.lifecycle.f0
    public void onCleared() {
        super.onCleared();
        this.f36253a.b();
    }
}
