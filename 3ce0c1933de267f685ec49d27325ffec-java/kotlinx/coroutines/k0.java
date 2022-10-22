package kotlinx.coroutines;

import kotlin.coroutines.f;
import kotlin.jvm.internal.i;
/* compiled from: CoroutineName.kt */
/* loaded from: classes3.dex */
public final class k0 extends kotlin.coroutines.a {

    /* renamed from: b  reason: collision with root package name */
    public static final a f30250b = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final String f30251a;

    /* compiled from: CoroutineName.kt */
    /* loaded from: classes3.dex */
    public static final class a implements f.c<k0> {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public final String Q() {
        return this.f30251a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof k0) && i.b(this.f30251a, ((k0) obj).f30251a);
    }

    public int hashCode() {
        return this.f30251a.hashCode();
    }

    public String toString() {
        return "CoroutineName(" + this.f30251a + ')';
    }
}
