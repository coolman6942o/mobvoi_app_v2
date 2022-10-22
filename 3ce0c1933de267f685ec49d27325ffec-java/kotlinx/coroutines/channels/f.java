package kotlinx.coroutines.channels;

import io.m;
import qo.l;
/* compiled from: Channel.kt */
/* loaded from: classes3.dex */
public final class f {
    public static final <E> e<E> a(int i10, BufferOverflow bufferOverflow, l<? super E, m> lVar) {
        int i11 = 1;
        if (i10 == -2) {
            if (bufferOverflow == BufferOverflow.SUSPEND) {
                i11 = e.f30151a.a();
            }
            return new d(i11, bufferOverflow, lVar);
        } else if (i10 == -1) {
            if (bufferOverflow != BufferOverflow.SUSPEND) {
                i11 = 0;
            }
            if (i11 != 0) {
                return new i(lVar);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        } else if (i10 != 0) {
            if (i10 == Integer.MAX_VALUE) {
                return new j(lVar);
            }
            if (i10 == 1 && bufferOverflow == BufferOverflow.DROP_OLDEST) {
                return new i(lVar);
            }
            return new d(i10, bufferOverflow, lVar);
        } else if (bufferOverflow == BufferOverflow.SUSPEND) {
            return new n(lVar);
        } else {
            return new d(1, bufferOverflow, lVar);
        }
    }

    public static /* synthetic */ e b(int i10, BufferOverflow bufferOverflow, l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        if ((i11 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((i11 & 4) != 0) {
            lVar = null;
        }
        return a(i10, bufferOverflow, lVar);
    }
}
