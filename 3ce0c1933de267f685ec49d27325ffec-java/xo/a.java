package xo;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.i;
/* compiled from: SequencesJVM.kt */
/* loaded from: classes3.dex */
public final class a<T> implements e<T> {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<e<T>> f36622a;

    public a(e<? extends T> sequence) {
        i.f(sequence, "sequence");
        this.f36622a = new AtomicReference<>(sequence);
    }

    @Override // xo.e
    public Iterator<T> iterator() {
        e<T> andSet = this.f36622a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
