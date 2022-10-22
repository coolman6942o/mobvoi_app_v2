package rx.subjects;

import rx.c;
/* compiled from: Subject.java */
/* loaded from: classes3.dex */
public abstract class d<T, R> extends c<R> implements rx.d<T> {
    /* JADX INFO: Access modifiers changed from: protected */
    public d(c.a<R> aVar) {
        super(aVar);
    }

    public abstract boolean m0();

    public final c<T, R> n0() {
        if (getClass() == c.class) {
            return (c) this;
        }
        return new c<>(this);
    }
}
