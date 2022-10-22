package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
/* compiled from: SavedStateRegistryController.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final c f4356a;

    /* renamed from: b  reason: collision with root package name */
    private final SavedStateRegistry f4357b = new SavedStateRegistry();

    private b(c cVar) {
        this.f4356a = cVar;
    }

    public static b a(c cVar) {
        return new b(cVar);
    }

    public SavedStateRegistry b() {
        return this.f4357b;
    }

    public void c(Bundle bundle) {
        Lifecycle lifecycle = this.f4356a.getLifecycle();
        if (lifecycle.b() == Lifecycle.State.INITIALIZED) {
            lifecycle.a(new Recreator(this.f4356a));
            this.f4357b.b(lifecycle, bundle);
            return;
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
    }

    public void d(Bundle bundle) {
        this.f4357b.c(bundle);
    }
}
