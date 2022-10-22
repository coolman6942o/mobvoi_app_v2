package rn;

import android.os.Bundle;
import androidx.lifecycle.b0;
import androidx.lifecycle.f0;
import androidx.lifecycle.h0;
import java.util.Map;
import java.util.Set;
import qn.e;
/* compiled from: HiltViewModelFactory.java */
/* loaded from: classes2.dex */
public final class c implements h0.b {

    /* renamed from: a  reason: collision with root package name */
    private final Set<String> f33647a;

    /* renamed from: b  reason: collision with root package name */
    private final h0.b f33648b;

    /* renamed from: c  reason: collision with root package name */
    private final androidx.lifecycle.a f33649c;

    /* compiled from: HiltViewModelFactory.java */
    /* loaded from: classes2.dex */
    class a extends androidx.lifecycle.a {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ e f33650d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(c cVar, androidx.savedstate.c cVar2, Bundle bundle, e eVar) {
            super(cVar2, bundle);
            this.f33650d = eVar;
        }

        @Override // androidx.lifecycle.a
        protected <T extends f0> T d(String str, Class<T> cls, b0 b0Var) {
            ho.a<f0> aVar = ((b) ln.a.a(this.f33650d.a(b0Var).build(), b.class)).a().get(cls.getName());
            if (aVar != null) {
                return (T) aVar.get();
            }
            throw new IllegalStateException("Expected the @HiltViewModel-annotated class '" + cls.getName() + "' to be available in the multi-binding of @HiltViewModelMap but none was found.");
        }
    }

    /* compiled from: HiltViewModelFactory.java */
    /* loaded from: classes2.dex */
    public interface b {
        Map<String, ho.a<f0>> a();
    }

    public c(androidx.savedstate.c cVar, Bundle bundle, Set<String> set, h0.b bVar, e eVar) {
        this.f33647a = set;
        this.f33648b = bVar;
        this.f33649c = new a(this, cVar, bundle, eVar);
    }

    @Override // androidx.lifecycle.h0.b
    public <T extends f0> T a(Class<T> cls) {
        if (this.f33647a.contains(cls.getName())) {
            return (T) this.f33649c.a(cls);
        }
        return (T) this.f33648b.a(cls);
    }
}
