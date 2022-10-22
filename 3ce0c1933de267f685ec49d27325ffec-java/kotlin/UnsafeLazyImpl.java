package kotlin;

import io.d;
import io.k;
import java.io.Serializable;
import kotlin.jvm.internal.i;
import qo.a;
/* compiled from: Lazy.kt */
/* loaded from: classes3.dex */
public final class UnsafeLazyImpl<T> implements d<T>, Serializable {
    private Object _value = k.f28348a;
    private a<? extends T> initializer;

    public UnsafeLazyImpl(a<? extends T> initializer) {
        i.f(initializer, "initializer");
        this.initializer = initializer;
    }

    @Override // io.d
    public T getValue() {
        if (this._value == k.f28348a) {
            a<? extends T> aVar = this.initializer;
            i.d(aVar);
            this._value = aVar.invoke();
            this.initializer = null;
        }
        return (T) this._value;
    }

    public boolean isInitialized() {
        return this._value != k.f28348a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
