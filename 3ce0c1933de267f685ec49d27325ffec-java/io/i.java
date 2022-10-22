package io;

import java.io.Serializable;
import kotlin.jvm.internal.f;
import qo.a;
/* compiled from: LazyJVM.kt */
/* loaded from: classes3.dex */
final class i<T> implements d<T>, Serializable {
    private volatile Object _value;
    private a<? extends T> initializer;
    private final Object lock;

    public i(a<? extends T> initializer, Object obj) {
        kotlin.jvm.internal.i.f(initializer, "initializer");
        this.initializer = initializer;
        this._value = k.f28348a;
        this.lock = obj == null ? this : obj;
    }

    public boolean a() {
        return this._value != k.f28348a;
    }

    @Override // io.d
    public T getValue() {
        T t10;
        T t11 = (T) this._value;
        k kVar = k.f28348a;
        if (t11 != kVar) {
            return t11;
        }
        synchronized (this.lock) {
            t10 = (T) this._value;
            if (t10 == kVar) {
                a<? extends T> aVar = this.initializer;
                kotlin.jvm.internal.i.d(aVar);
                t10 = aVar.invoke();
                this._value = t10;
                this.initializer = null;
            }
        }
        return t10;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ i(a aVar, Object obj, int i10, f fVar) {
        this(aVar, (i10 & 2) != 0 ? null : obj);
    }
}
