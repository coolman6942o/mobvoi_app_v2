package kotlinx.coroutines.flow.internal;

import io.m;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.o;
import kotlinx.coroutines.flow.c;
import qo.q;
/* compiled from: SafeCollector.kt */
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static final q<c<Object>, Object, kotlin.coroutines.c<? super m>, Object> f30184a = (q) o.b(a.INSTANCE, 3);

    /* compiled from: SafeCollector.kt */
    /* loaded from: classes3.dex */
    /* synthetic */ class a extends FunctionReferenceImpl implements q<c<? super Object>, Object, m> {
        public static final a INSTANCE = new a();

        a() {
            super(3, c.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        /* renamed from: g */
        public final Object invoke(c<Object> cVar, Object obj, kotlin.coroutines.c<? super m> cVar2) {
            return cVar.emit(obj, cVar2);
        }
    }
}
