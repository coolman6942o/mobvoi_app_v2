package x5;

import android.content.Context;
import android.util.Log;
import androidx.loader.content.a;
import com.google.android.gms.common.api.internal.l;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class d extends a<Void> implements l {

    /* renamed from: p  reason: collision with root package name */
    private Semaphore f36454p = new Semaphore(0);

    /* renamed from: q  reason: collision with root package name */
    private Set<com.google.android.gms.common.api.d> f36455q;

    public d(Context context, Set<com.google.android.gms.common.api.d> set) {
        super(context);
        this.f36455q = set;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I */
    public final Void F() {
        int i10 = 0;
        for (com.google.android.gms.common.api.d dVar : this.f36455q) {
            if (dVar.q(this)) {
                i10++;
            }
        }
        try {
            this.f36454p.tryAcquire(i10, 5L, TimeUnit.SECONDS);
            return null;
        } catch (InterruptedException e10) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e10);
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @Override // com.google.android.gms.common.api.internal.l
    public final void onComplete() {
        this.f36454p.release();
    }

    @Override // androidx.loader.content.c
    protected final void r() {
        this.f36454p.drainPermits();
        h();
    }
}
