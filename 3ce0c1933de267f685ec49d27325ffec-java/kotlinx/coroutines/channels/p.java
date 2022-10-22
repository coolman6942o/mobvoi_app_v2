package kotlinx.coroutines.channels;

import io.m;
import kotlin.coroutines.c;
/* compiled from: Channel.kt */
/* loaded from: classes3.dex */
public interface p<E> {

    /* compiled from: Channel.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public static /* synthetic */ boolean a(p pVar, Throwable th2, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    th2 = null;
                }
                return pVar.c(th2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
        }
    }

    boolean c(Throwable th2);

    Object d(E e10, c<? super m> cVar);
}
