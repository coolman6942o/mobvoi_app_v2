package kotlinx.coroutines;

import ap.b;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.c;
import kotlin.coroutines.e;
import qo.l;
import qo.p;
/* compiled from: CoroutineStart.kt */
/* loaded from: classes3.dex */
public enum CoroutineStart {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    /* compiled from: CoroutineStart.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30113a;

        static {
            int[] iArr = new int[CoroutineStart.values().length];
            iArr[CoroutineStart.DEFAULT.ordinal()] = 1;
            iArr[CoroutineStart.ATOMIC.ordinal()] = 2;
            iArr[CoroutineStart.UNDISPATCHED.ordinal()] = 3;
            iArr[CoroutineStart.LAZY.ordinal()] = 4;
            f30113a = iArr;
        }
    }

    public static /* synthetic */ void isLazy$annotations() {
    }

    public final <T> void invoke(l<? super c<? super T>, ? extends Object> lVar, c<? super T> cVar) {
        int i10 = a.f30113a[ordinal()];
        if (i10 == 1) {
            ap.a.d(lVar, cVar);
        } else if (i10 == 2) {
            e.a(lVar, cVar);
        } else if (i10 == 3) {
            b.a(lVar, cVar);
        } else if (i10 != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean isLazy() {
        return this == LAZY;
    }

    public final <R, T> void invoke(p<? super R, ? super c<? super T>, ? extends Object> pVar, R r10, c<? super T> cVar) {
        int i10 = a.f30113a[ordinal()];
        if (i10 == 1) {
            ap.a.f(pVar, r10, cVar, null, 4, null);
        } else if (i10 == 2) {
            e.b(pVar, r10, cVar);
        } else if (i10 == 3) {
            b.b(pVar, r10, cVar);
        } else if (i10 != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }
}
