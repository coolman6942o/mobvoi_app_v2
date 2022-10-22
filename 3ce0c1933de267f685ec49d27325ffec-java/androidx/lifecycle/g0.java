package androidx.lifecycle;

import androidx.lifecycle.f0;
import androidx.lifecycle.h0;
import io.d;
import kotlin.jvm.internal.i;
import qo.a;
import wo.c;
/* compiled from: ViewModelLazy.kt */
/* loaded from: classes.dex */
public final class g0<VM extends f0> implements d<VM> {

    /* renamed from: a  reason: collision with root package name */
    private final c<VM> f3311a;

    /* renamed from: b  reason: collision with root package name */
    private final a<i0> f3312b;

    /* renamed from: c  reason: collision with root package name */
    private final a<h0.b> f3313c;

    /* renamed from: d  reason: collision with root package name */
    private VM f3314d;

    /* JADX WARN: Multi-variable type inference failed */
    public g0(c<VM> viewModelClass, a<? extends i0> storeProducer, a<? extends h0.b> factoryProducer) {
        i.f(viewModelClass, "viewModelClass");
        i.f(storeProducer, "storeProducer");
        i.f(factoryProducer, "factoryProducer");
        this.f3311a = viewModelClass;
        this.f3312b = storeProducer;
        this.f3313c = factoryProducer;
    }

    /* renamed from: a */
    public VM getValue() {
        VM vm2 = this.f3314d;
        if (vm2 != null) {
            return vm2;
        }
        VM vm3 = (VM) new h0(this.f3312b.invoke(), this.f3313c.invoke()).a(po.a.a(this.f3311a));
        this.f3314d = vm3;
        return vm3;
    }
}
