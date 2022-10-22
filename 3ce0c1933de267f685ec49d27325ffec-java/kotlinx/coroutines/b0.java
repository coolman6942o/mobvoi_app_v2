package kotlinx.coroutines;

import io.m;
import kotlin.jvm.internal.i;
import qo.l;
/* compiled from: CompletionState.kt */
/* loaded from: classes3.dex */
public final class b0 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f30121a;

    /* renamed from: b  reason: collision with root package name */
    public final l<Throwable, m> f30122b;

    /* JADX WARN: Multi-variable type inference failed */
    public b0(Object obj, l<? super Throwable, m> lVar) {
        this.f30121a = obj;
        this.f30122b = lVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return i.b(this.f30121a, b0Var.f30121a) && i.b(this.f30122b, b0Var.f30122b);
    }

    public int hashCode() {
        Object obj = this.f30121a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f30122b.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.f30121a + ", onCancellation=" + this.f30122b + ')';
    }
}
