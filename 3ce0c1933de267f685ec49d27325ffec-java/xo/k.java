package xo;

import java.util.Iterator;
import kotlin.jvm.internal.i;
import qo.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Sequences.kt */
/* loaded from: classes3.dex */
public class k extends j {

    /* compiled from: Sequences.kt */
    /* loaded from: classes3.dex */
    public static final class a implements e<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Iterator f36637a;

        public a(Iterator it) {
            this.f36637a = it;
        }

        @Override // xo.e
        public Iterator<T> iterator() {
            return this.f36637a;
        }
    }

    public static <T> e<T> c(Iterator<? extends T> asSequence) {
        i.f(asSequence, "$this$asSequence");
        return d(new a(asSequence));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> e<T> d(e<? extends T> constrainOnce) {
        i.f(constrainOnce, "$this$constrainOnce");
        return constrainOnce instanceof xo.a ? constrainOnce : new xo.a(constrainOnce);
    }

    public static <T> e<T> e(qo.a<? extends T> seedFunction, l<? super T, ? extends T> nextFunction) {
        i.f(seedFunction, "seedFunction");
        i.f(nextFunction, "nextFunction");
        return new d(seedFunction, nextFunction);
    }
}
