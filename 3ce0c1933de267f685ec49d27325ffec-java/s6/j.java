package s6;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;
/* loaded from: classes.dex */
final class j extends WeakReference<Throwable> {

    /* renamed from: a  reason: collision with root package name */
    private final int f34330a;

    public j(Throwable th2, ReferenceQueue<Throwable> referenceQueue) {
        super(th2, referenceQueue);
        Objects.requireNonNull(th2, "The referent cannot be null");
        this.f34330a = System.identityHashCode(th2);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == j.class) {
            if (this == obj) {
                return true;
            }
            j jVar = (j) obj;
            if (this.f34330a == jVar.f34330a && get() == jVar.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f34330a;
    }
}
