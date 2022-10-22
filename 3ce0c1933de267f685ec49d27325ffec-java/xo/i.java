package xo;

import io.m;
import java.util.Iterator;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import qo.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SequenceBuilder.kt */
/* loaded from: classes3.dex */
public class i {

    /* compiled from: Sequences.kt */
    /* loaded from: classes3.dex */
    public static final class a implements e<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f36636a;

        public a(p pVar) {
            this.f36636a = pVar;
        }

        @Override // xo.e
        public Iterator<T> iterator() {
            return i.a(this.f36636a);
        }
    }

    public static final <T> Iterator<T> a(p<? super g<? super T>, ? super c<? super m>, ? extends Object> block) {
        c<m> b10;
        kotlin.jvm.internal.i.f(block, "block");
        f fVar = new f();
        b10 = IntrinsicsKt__IntrinsicsJvmKt.b(block, fVar, fVar);
        fVar.h(b10);
        return fVar;
    }

    public static <T> e<T> b(p<? super g<? super T>, ? super c<? super m>, ? extends Object> block) {
        kotlin.jvm.internal.i.f(block, "block");
        return new a(block);
    }
}
