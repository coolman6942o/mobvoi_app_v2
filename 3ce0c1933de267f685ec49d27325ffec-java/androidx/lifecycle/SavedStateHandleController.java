package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class SavedStateHandleController implements n {

    /* renamed from: a  reason: collision with root package name */
    private final String f3269a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3270b = false;

    /* renamed from: c  reason: collision with root package name */
    private final b0 f3271c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a implements SavedStateRegistry.a {
        a() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.a
        public void a(c cVar) {
            if (cVar instanceof j0) {
                i0 viewModelStore = ((j0) cVar).getViewModelStore();
                SavedStateRegistry savedStateRegistry = cVar.getSavedStateRegistry();
                for (String str : viewModelStore.c()) {
                    SavedStateHandleController.d(viewModelStore.b(str), savedStateRegistry, cVar.getLifecycle());
                }
                if (!viewModelStore.c().isEmpty()) {
                    savedStateRegistry.e(a.class);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
        }
    }

    SavedStateHandleController(String str, b0 b0Var) {
        this.f3269a = str;
        this.f3271c = b0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(f0 f0Var, SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) f0Var.getTag("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController != null && !savedStateHandleController.l()) {
            savedStateHandleController.h(savedStateRegistry, lifecycle);
            m(savedStateRegistry, lifecycle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SavedStateHandleController j(SavedStateRegistry savedStateRegistry, Lifecycle lifecycle, String str, Bundle bundle) {
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, b0.a(savedStateRegistry.a(str), bundle));
        savedStateHandleController.h(savedStateRegistry, lifecycle);
        m(savedStateRegistry, lifecycle);
        return savedStateHandleController;
    }

    private static void m(final SavedStateRegistry savedStateRegistry, final Lifecycle lifecycle) {
        Lifecycle.State b10 = lifecycle.b();
        if (b10 == Lifecycle.State.INITIALIZED || b10.isAtLeast(Lifecycle.State.STARTED)) {
            savedStateRegistry.e(a.class);
        } else {
            lifecycle.a(new n() { // from class: androidx.lifecycle.SavedStateHandleController.1
                @Override // androidx.lifecycle.n
                public void c(p pVar, Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_START) {
                        Lifecycle.this.c(this);
                        savedStateRegistry.e(a.class);
                    }
                }
            });
        }
    }

    @Override // androidx.lifecycle.n
    public void c(p pVar, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.f3270b = false;
            pVar.getLifecycle().c(this);
        }
    }

    void h(SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        if (!this.f3270b) {
            this.f3270b = true;
            lifecycle.a(this);
            savedStateRegistry.d(this.f3269a, this.f3271c.b());
            return;
        }
        throw new IllegalStateException("Already attached to lifecycleOwner");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b0 k() {
        return this.f3271c;
    }

    boolean l() {
        return this.f3270b;
    }
}
