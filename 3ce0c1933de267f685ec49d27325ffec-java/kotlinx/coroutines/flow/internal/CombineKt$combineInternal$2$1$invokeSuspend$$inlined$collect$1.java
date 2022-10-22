package kotlinx.coroutines.flow.internal;

import io.h;
import io.m;
import kotlin.collections.x;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.channels.e;
import kotlinx.coroutines.f2;
import kotlinx.coroutines.flow.c;
/* compiled from: Collect.kt */
/* loaded from: classes3.dex */
public final class CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1 implements c<T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f30176a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f30177b;

    @d(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1", f = "Combine.kt", l = {135, 136}, m = "emit")
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(kotlin.coroutines.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1.this.emit(null, this);
        }
    }

    public CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1(e eVar, int i10) {
        this.f30176a = eVar;
        this.f30177b = i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0055 A[RETURN] */
    @Override // kotlinx.coroutines.flow.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(T t10, kotlin.coroutines.c<? super m> cVar) {
        AnonymousClass1 r02;
        Object d10;
        int i10;
        if (cVar instanceof AnonymousClass1) {
            r02 = (AnonymousClass1) cVar;
            int i11 = r02.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                r02.label = i11 - Integer.MIN_VALUE;
                Object obj = r02.result;
                d10 = b.d();
                i10 = r02.label;
                if (i10 != 0) {
                    h.b(obj);
                    e eVar = this.f30176a;
                    x xVar = new x(this.f30177b, t10);
                    r02.label = 1;
                    if (eVar.d(xVar, r02) == d10) {
                        return d10;
                    }
                } else if (i10 == 1) {
                    h.b(obj);
                } else if (i10 == 2) {
                    h.b(obj);
                    return m.f28349a;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r02.label = 2;
                if (f2.a(r02) == d10) {
                    return d10;
                }
                return m.f28349a;
            }
        }
        r02 = new AnonymousClass1(cVar);
        Object obj2 = r02.result;
        d10 = b.d();
        i10 = r02.label;
        if (i10 != 0) {
        }
        r02.label = 2;
        if (f2.a(r02) == d10) {
        }
        return m.f28349a;
    }
}
