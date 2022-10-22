package kotlinx.coroutines;

import io.m;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import qo.l;
/* compiled from: CancellableContinuationImpl.kt */
/* loaded from: classes3.dex */
final class z {

    /* renamed from: a  reason: collision with root package name */
    public final Object f30355a;

    /* renamed from: b  reason: collision with root package name */
    public final k f30356b;

    /* renamed from: c  reason: collision with root package name */
    public final l<Throwable, m> f30357c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f30358d;

    /* renamed from: e  reason: collision with root package name */
    public final Throwable f30359e;

    /* JADX WARN: Multi-variable type inference failed */
    public z(Object obj, k kVar, l<? super Throwable, m> lVar, Object obj2, Throwable th2) {
        this.f30355a = obj;
        this.f30356b = kVar;
        this.f30357c = lVar;
        this.f30358d = obj2;
        this.f30359e = th2;
    }

    public static /* synthetic */ z b(z zVar, Object obj, k kVar, l lVar, Object obj2, Throwable th2, int i10, Object obj3) {
        if ((i10 & 1) != 0) {
            obj = zVar.f30355a;
        }
        if ((i10 & 2) != 0) {
            kVar = zVar.f30356b;
        }
        k kVar2 = kVar;
        l<Throwable, m> lVar2 = lVar;
        if ((i10 & 4) != 0) {
            lVar2 = zVar.f30357c;
        }
        l lVar3 = lVar2;
        if ((i10 & 8) != 0) {
            obj2 = zVar.f30358d;
        }
        Object obj4 = obj2;
        if ((i10 & 16) != 0) {
            th2 = zVar.f30359e;
        }
        return zVar.a(obj, kVar2, lVar3, obj4, th2);
    }

    public final z a(Object obj, k kVar, l<? super Throwable, m> lVar, Object obj2, Throwable th2) {
        return new z(obj, kVar, lVar, obj2, th2);
    }

    public final boolean c() {
        return this.f30359e != null;
    }

    public final void d(n<?> nVar, Throwable th2) {
        k kVar = this.f30356b;
        if (kVar != null) {
            nVar.m(kVar, th2);
        }
        l<Throwable, m> lVar = this.f30357c;
        if (lVar != null) {
            nVar.o(lVar, th2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return i.b(this.f30355a, zVar.f30355a) && i.b(this.f30356b, zVar.f30356b) && i.b(this.f30357c, zVar.f30357c) && i.b(this.f30358d, zVar.f30358d) && i.b(this.f30359e, zVar.f30359e);
    }

    public int hashCode() {
        Object obj = this.f30355a;
        int i10 = 0;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        k kVar = this.f30356b;
        int hashCode2 = (hashCode + (kVar == null ? 0 : kVar.hashCode())) * 31;
        l<Throwable, m> lVar = this.f30357c;
        int hashCode3 = (hashCode2 + (lVar == null ? 0 : lVar.hashCode())) * 31;
        Object obj2 = this.f30358d;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th2 = this.f30359e;
        if (th2 != null) {
            i10 = th2.hashCode();
        }
        return hashCode4 + i10;
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f30355a + ", cancelHandler=" + this.f30356b + ", onCancellation=" + this.f30357c + ", idempotentResume=" + this.f30358d + ", cancelCause=" + this.f30359e + ')';
    }

    public /* synthetic */ z(Object obj, k kVar, l lVar, Object obj2, Throwable th2, int i10, f fVar) {
        this(obj, (i10 & 2) != 0 ? null : kVar, (i10 & 4) != 0 ? null : lVar, (i10 & 8) != 0 ? null : obj2, (i10 & 16) != 0 ? null : th2);
    }
}
