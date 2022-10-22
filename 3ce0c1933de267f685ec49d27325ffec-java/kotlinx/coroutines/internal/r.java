package kotlinx.coroutines.internal;

import io.b;
import io.m;
import kotlin.coroutines.f;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.i0;
import qo.l;
/*  JADX ERROR: JadxRuntimeException in pass: ClassModifier
    jadx.core.utils.exceptions.JadxRuntimeException: Not class type: E
    	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:53)
    	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
    	at jadx.core.dex.visitors.ClassModifier.removeSyntheticFields(ClassModifier.java:82)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:60)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:54)
    */
/* compiled from: OnUndeliveredElement.kt */
/* loaded from: classes3.dex */
public final class r {

    /* compiled from: OnUndeliveredElement.kt */
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements l<Throwable, m> {
        final /* synthetic */ f $context;
        final /* synthetic */ E $element;
        final /* synthetic */ l<E, m> $this_bindCancellationFun;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(l<? super E, m> lVar, E e10, f fVar) {
            super(1);
            this.$this_bindCancellationFun = lVar;
            this.$element = e10;
            this.$context = fVar;
        }

        @Override // qo.l
        public /* bridge */ /* synthetic */ m invoke(Throwable th2) {
            invoke2(th2);
            return m.f28349a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th2) {
            r.b(this.$this_bindCancellationFun, this.$element, this.$context);
        }
    }

    public static final <E> l<Throwable, m> a(l<? super E, m> lVar, E e10, f fVar) {
        return new a(lVar, e10, fVar);
    }

    public static final <E> void b(l<? super E, m> lVar, E e10, f fVar) {
        UndeliveredElementException c10 = c(lVar, e10, null);
        if (c10 != null) {
            i0.a(fVar, c10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> UndeliveredElementException c(l<? super E, m> lVar, E e10, UndeliveredElementException undeliveredElementException) {
        try {
            lVar.invoke(e10);
        } catch (Throwable th2) {
            if (undeliveredElementException == null || undeliveredElementException.getCause() == th2) {
                return new UndeliveredElementException(i.n("Exception in undelivered element handler for ", e10), th2);
            }
            b.a(undeliveredElementException, th2);
        }
        return undeliveredElementException;
    }

    public static /* synthetic */ UndeliveredElementException d(l lVar, Object obj, UndeliveredElementException undeliveredElementException, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            undeliveredElementException = null;
        }
        return c(lVar, obj, undeliveredElementException);
    }
}
