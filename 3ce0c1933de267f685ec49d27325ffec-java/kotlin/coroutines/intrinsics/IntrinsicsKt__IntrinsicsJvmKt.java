package kotlin.coroutines.intrinsics;

import io.h;
import io.m;
import java.util.Objects;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.o;
import qo.l;
import qo.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IntrinsicsJvm.kt */
/* loaded from: classes3.dex */
public class IntrinsicsKt__IntrinsicsJvmKt {
    public static <T> c<m> a(final l<? super c<? super T>, ? extends Object> createCoroutineUnintercepted, c<? super T> completion) {
        c<m> cVar;
        i.f(createCoroutineUnintercepted, "$this$createCoroutineUnintercepted");
        i.f(completion, "completion");
        final c<?> a10 = f.a(completion);
        if (createCoroutineUnintercepted instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) createCoroutineUnintercepted).create(a10);
        }
        final kotlin.coroutines.f context = a10.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            cVar = new RestrictedContinuationImpl(a10) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1
                private int label;

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                protected Object invokeSuspend(Object obj) {
                    int i10 = this.label;
                    if (i10 == 0) {
                        this.label = 1;
                        h.b(obj);
                        l lVar = createCoroutineUnintercepted;
                        Objects.requireNonNull(lVar, "null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                        return ((l) o.b(lVar, 1)).invoke(this);
                    } else if (i10 == 1) {
                        this.label = 2;
                        h.b(obj);
                        return obj;
                    } else {
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                }
            };
        } else {
            cVar = new ContinuationImpl(a10, context) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2
                private int label;

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                protected Object invokeSuspend(Object obj) {
                    int i10 = this.label;
                    if (i10 == 0) {
                        this.label = 1;
                        h.b(obj);
                        l lVar = createCoroutineUnintercepted;
                        Objects.requireNonNull(lVar, "null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                        return ((l) o.b(lVar, 1)).invoke(this);
                    } else if (i10 == 1) {
                        this.label = 2;
                        h.b(obj);
                        return obj;
                    } else {
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                }
            };
        }
        return cVar;
    }

    public static <R, T> c<m> b(final p<? super R, ? super c<? super T>, ? extends Object> createCoroutineUnintercepted, final R r10, c<? super T> completion) {
        c<m> cVar;
        i.f(createCoroutineUnintercepted, "$this$createCoroutineUnintercepted");
        i.f(completion, "completion");
        final c<?> a10 = f.a(completion);
        if (createCoroutineUnintercepted instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) createCoroutineUnintercepted).create(r10, a10);
        }
        final kotlin.coroutines.f context = a10.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            cVar = new RestrictedContinuationImpl(a10) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3
                private int label;

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                protected Object invokeSuspend(Object obj) {
                    int i10 = this.label;
                    if (i10 == 0) {
                        this.label = 1;
                        h.b(obj);
                        p pVar = createCoroutineUnintercepted;
                        Objects.requireNonNull(pVar, "null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                        return ((p) o.b(pVar, 2)).invoke(r10, this);
                    } else if (i10 == 1) {
                        this.label = 2;
                        h.b(obj);
                        return obj;
                    } else {
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                }
            };
        } else {
            cVar = new ContinuationImpl(a10, context) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4
                private int label;

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                protected Object invokeSuspend(Object obj) {
                    int i10 = this.label;
                    if (i10 == 0) {
                        this.label = 1;
                        h.b(obj);
                        p pVar = createCoroutineUnintercepted;
                        Objects.requireNonNull(pVar, "null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                        return ((p) o.b(pVar, 2)).invoke(r10, this);
                    } else if (i10 == 1) {
                        this.label = 2;
                        h.b(obj);
                        return obj;
                    } else {
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                }
            };
        }
        return cVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> c<T> c(c<? super T> intercepted) {
        c<T> cVar;
        i.f(intercepted, "$this$intercepted");
        ContinuationImpl continuationImpl = !(intercepted instanceof ContinuationImpl) ? null : intercepted;
        return (continuationImpl == null || (cVar = (c<T>) continuationImpl.intercepted()) == null) ? intercepted : cVar;
    }
}
