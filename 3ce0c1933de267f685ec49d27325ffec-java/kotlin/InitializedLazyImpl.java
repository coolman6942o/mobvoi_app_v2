package kotlin;

import io.d;
import java.io.Serializable;
/* compiled from: Lazy.kt */
/* loaded from: classes3.dex */
public final class InitializedLazyImpl<T> implements d<T>, Serializable {
    private final T value;

    public InitializedLazyImpl(T t10) {
        this.value = t10;
    }

    @Override // io.d
    public T getValue() {
        return this.value;
    }

    public boolean isInitialized() {
        return true;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
