package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.n;
import androidx.lifecycle.p;
import androidx.savedstate.Recreator;
import java.util.Map;
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class SavedStateRegistry {

    /* renamed from: b  reason: collision with root package name */
    private Bundle f4350b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4351c;

    /* renamed from: d  reason: collision with root package name */
    private Recreator.a f4352d;

    /* renamed from: a  reason: collision with root package name */
    private l.b<String, b> f4349a = new l.b<>();

    /* renamed from: e  reason: collision with root package name */
    boolean f4353e = true;

    /* loaded from: classes.dex */
    public interface a {
        void a(c cVar);
    }

    /* loaded from: classes.dex */
    public interface b {
        Bundle a();
    }

    public Bundle a(String str) {
        if (this.f4351c) {
            Bundle bundle = this.f4350b;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle.getBundle(str);
            this.f4350b.remove(str);
            if (this.f4350b.isEmpty()) {
                this.f4350b = null;
            }
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Lifecycle lifecycle, Bundle bundle) {
        if (!this.f4351c) {
            if (bundle != null) {
                this.f4350b = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
            }
            lifecycle.a(new n() { // from class: androidx.savedstate.SavedStateRegistry.1
                @Override // androidx.lifecycle.n
                public void c(p pVar, Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_START) {
                        SavedStateRegistry.this.f4353e = true;
                    } else if (event == Lifecycle.Event.ON_STOP) {
                        SavedStateRegistry.this.f4353e = false;
                    }
                }
            });
            this.f4351c = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already restored.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f4350b;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        l.b<String, b>.d c10 = this.f4349a.c();
        while (c10.hasNext()) {
            Map.Entry next = c10.next();
            bundle2.putBundle((String) next.getKey(), ((b) next.getValue()).a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    public void d(String str, b bVar) {
        if (this.f4349a.f(str, bVar) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public void e(Class<? extends a> cls) {
        if (this.f4353e) {
            if (this.f4352d == null) {
                this.f4352d = new Recreator.a(this);
            }
            try {
                cls.getDeclaredConstructor(new Class[0]);
                this.f4352d.b(cls.getName());
            } catch (NoSuchMethodException e10) {
                throw new IllegalArgumentException("Class" + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e10);
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }
}
