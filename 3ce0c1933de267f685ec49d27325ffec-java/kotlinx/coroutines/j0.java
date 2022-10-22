package kotlinx.coroutines;

import io.m;
import java.util.Objects;
import kotlin.coroutines.f;
import kotlin.jvm.internal.i;
import kotlin.text.u;
/* compiled from: CoroutineContext.kt */
/* loaded from: classes3.dex */
public final class j0 extends kotlin.coroutines.a implements z1<String> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f30246b = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final long f30247a;

    /* compiled from: CoroutineContext.kt */
    /* loaded from: classes3.dex */
    public static final class a implements f.c<j0> {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public j0(long j10) {
        super(f30246b);
        this.f30247a = j10;
    }

    public final long Q() {
        return this.f30247a;
    }

    /* renamed from: T */
    public void v(f fVar, String str) {
        Thread.currentThread().setName(str);
    }

    /* renamed from: V */
    public String I(f fVar) {
        int Y;
        String Q;
        k0 k0Var = (k0) fVar.get(k0.f30250b);
        String str = "coroutine";
        if (!(k0Var == null || (Q = k0Var.Q()) == null)) {
            str = Q;
        }
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        Y = u.Y(name, " @", 0, false, 6, null);
        if (Y < 0) {
            Y = name.length();
        }
        StringBuilder sb2 = new StringBuilder(str.length() + Y + 10);
        Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
        String substring = name.substring(0, Y);
        i.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        sb2.append(substring);
        sb2.append(" @");
        sb2.append(str);
        sb2.append('#');
        sb2.append(Q());
        m mVar = m.f28349a;
        String sb3 = sb2.toString();
        i.e(sb3, "StringBuilder(capacity).…builderAction).toString()");
        currentThread.setName(sb3);
        return name;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j0) && this.f30247a == ((j0) obj).f30247a;
    }

    public int hashCode() {
        return ia.a.a(this.f30247a);
    }

    public String toString() {
        return "CoroutineId(" + this.f30247a + ')';
    }
}
