package kotlin.coroutines;

import java.io.Serializable;
import java.util.Objects;
import kotlin.coroutines.f;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import qo.p;
/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes3.dex */
public final class CombinedContext implements f, Serializable {
    private final f.b element;
    private final f left;

    /* compiled from: CoroutineContextImpl.kt */
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements p<String, f.b, String> {
        public static final a INSTANCE = new a();

        a() {
            super(2);
        }

        /* renamed from: a */
        public final String invoke(String acc, f.b element) {
            i.f(acc, "acc");
            i.f(element, "element");
            if (acc.length() == 0) {
                return element.toString();
            }
            return acc + ", " + element;
        }
    }

    public CombinedContext(f left, f.b element) {
        i.f(left, "left");
        i.f(element, "element");
        this.left = left;
        this.element = element;
    }

    private final boolean a(f.b bVar) {
        return i.b(get(bVar.getKey()), bVar);
    }

    private final boolean b(CombinedContext combinedContext) {
        while (a(combinedContext.element)) {
            f fVar = combinedContext.left;
            if (fVar instanceof CombinedContext) {
                combinedContext = (CombinedContext) fVar;
            } else {
                Objects.requireNonNull(fVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return a((f.b) fVar);
            }
        }
        return false;
    }

    private final int g() {
        int i10 = 2;
        CombinedContext combinedContext = this;
        while (true) {
            f fVar = combinedContext.left;
            if (!(fVar instanceof CombinedContext)) {
                fVar = null;
            }
            combinedContext = (CombinedContext) fVar;
            if (combinedContext == null) {
                return i10;
            }
            i10++;
        }
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CombinedContext) {
                CombinedContext combinedContext = (CombinedContext) obj;
                if (combinedContext.g() != g() || !combinedContext.b(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // kotlin.coroutines.f
    public <R> R fold(R r10, p<? super R, ? super f.b, ? extends R> operation) {
        i.f(operation, "operation");
        return operation.invoke((Object) this.left.fold(r10, operation), this.element);
    }

    @Override // kotlin.coroutines.f
    public <E extends f.b> E get(f.c<E> key) {
        i.f(key, "key");
        CombinedContext combinedContext = this;
        while (true) {
            E e10 = (E) combinedContext.element.get(key);
            if (e10 != null) {
                return e10;
            }
            f fVar = combinedContext.left;
            if (!(fVar instanceof CombinedContext)) {
                return (E) fVar.get(key);
            }
            combinedContext = (CombinedContext) fVar;
        }
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    @Override // kotlin.coroutines.f
    public f minusKey(f.c<?> key) {
        i.f(key, "key");
        if (this.element.get(key) != null) {
            return this.left;
        }
        f minusKey = this.left.minusKey(key);
        return minusKey == this.left ? this : minusKey == EmptyCoroutineContext.INSTANCE ? this.element : new CombinedContext(minusKey, this.element);
    }

    @Override // kotlin.coroutines.f
    public f plus(f context) {
        i.f(context, "context");
        return f.a.a(this, context);
    }

    public String toString() {
        return "[" + ((String) fold("", a.INSTANCE)) + "]";
    }
}
