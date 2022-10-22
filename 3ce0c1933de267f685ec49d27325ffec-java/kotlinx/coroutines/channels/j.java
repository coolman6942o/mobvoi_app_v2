package kotlinx.coroutines.channels;

import io.m;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.internal.w;
import qo.l;
/* compiled from: LinkedListChannel.kt */
/* loaded from: classes3.dex */
public class j<E> extends a<E> {
    public j(l<? super E, m> lVar) {
        super(lVar);
    }

    @Override // kotlinx.coroutines.channels.a
    protected final boolean C() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.a
    protected final boolean D() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.c
    protected final boolean p() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.c
    protected final boolean q() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.c
    public Object s(E e10) {
        m<?> u10;
        do {
            Object s10 = super.s(e10);
            w wVar = b.f30135b;
            if (s10 == wVar) {
                return wVar;
            }
            if (s10 == b.f30136c) {
                u10 = u(e10);
                if (u10 == null) {
                    return wVar;
                }
            } else if (s10 instanceof h) {
                return s10;
            } else {
                throw new IllegalStateException(i.n("Invalid offerInternal result ", s10).toString());
            }
        } while (!(u10 instanceof h));
        return u10;
    }
}
