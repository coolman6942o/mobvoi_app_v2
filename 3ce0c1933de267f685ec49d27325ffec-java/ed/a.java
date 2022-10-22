package ed;

import android.app.Application;
import androidx.lifecycle.b;
import rx.j;
/* compiled from: RxViewModel.java */
/* loaded from: classes2.dex */
public abstract class a extends b {

    /* renamed from: a  reason: collision with root package name */
    private final dq.b f25884a = new dq.b();

    public a(Application application) {
        super(application);
    }

    public void a(j jVar) {
        this.f25884a.a(jVar);
    }

    @Override // androidx.lifecycle.f0
    public void onCleared() {
        super.onCleared();
        this.f25884a.b();
    }
}
