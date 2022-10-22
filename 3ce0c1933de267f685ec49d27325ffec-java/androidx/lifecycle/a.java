package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.h0;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.c;
/* compiled from: AbstractSavedStateViewModelFactory.java */
/* loaded from: classes.dex */
public abstract class a extends h0.c {

    /* renamed from: a  reason: collision with root package name */
    private final SavedStateRegistry f3279a;

    /* renamed from: b  reason: collision with root package name */
    private final Lifecycle f3280b;

    /* renamed from: c  reason: collision with root package name */
    private final Bundle f3281c;

    public a(c cVar, Bundle bundle) {
        this.f3279a = cVar.getSavedStateRegistry();
        this.f3280b = cVar.getLifecycle();
        this.f3281c = bundle;
    }

    @Override // androidx.lifecycle.h0.c, androidx.lifecycle.h0.b
    public final <T extends f0> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) c(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.h0.e
    public void b(f0 f0Var) {
        SavedStateHandleController.d(f0Var, this.f3279a, this.f3280b);
    }

    @Override // androidx.lifecycle.h0.c
    public final <T extends f0> T c(String str, Class<T> cls) {
        SavedStateHandleController j10 = SavedStateHandleController.j(this.f3279a, this.f3280b, str, this.f3281c);
        T t10 = (T) d(str, cls, j10.k());
        t10.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", j10);
        return t10;
    }

    protected abstract <T extends f0> T d(String str, Class<T> cls, b0 b0Var);
}
