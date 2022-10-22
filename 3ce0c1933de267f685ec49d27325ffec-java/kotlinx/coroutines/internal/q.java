package kotlinx.coroutines.internal;

import kotlin.KotlinNothingValueException;
import kotlin.coroutines.f;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.s1;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainDispatchers.kt */
/* loaded from: classes3.dex */
public final class q extends s1 {

    /* renamed from: b  reason: collision with root package name */
    private final Throwable f30239b;

    /* renamed from: c  reason: collision with root package name */
    private final String f30240c;

    public q(Throwable th2, String str) {
        this.f30239b = th2;
        this.f30240c = str;
    }

    private final Void i0() {
        String n10;
        if (this.f30239b != null) {
            String str = this.f30240c;
            String str2 = "";
            if (!(str == null || (n10 = i.n(". ", str)) == null)) {
                str2 = n10;
            }
            throw new IllegalStateException(i.n("Module with the Main dispatcher had failed to initialize", str2), this.f30239b);
        }
        p.c();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.g0
    public boolean V(f fVar) {
        i0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.s1
    public s1 W() {
        return this;
    }

    /* renamed from: h0 */
    public Void Q(f fVar, Runnable runnable) {
        i0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.s1, kotlinx.coroutines.g0
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Dispatchers.Main[missing");
        Throwable th2 = this.f30239b;
        sb2.append(th2 != null ? i.n(", cause=", th2) : "");
        sb2.append(']');
        return sb2.toString();
    }
}
