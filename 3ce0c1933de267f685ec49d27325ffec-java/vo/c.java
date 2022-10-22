package vo;

import kotlin.jvm.internal.f;
/* compiled from: Ranges.kt */
/* loaded from: classes3.dex */
public final class c extends vo.a {

    /* renamed from: f  reason: collision with root package name */
    public static final a f35850f = new a(null);

    /* renamed from: e  reason: collision with root package name */
    private static final c f35849e = new c(1, 0);

    /* compiled from: Ranges.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final c a() {
            return c.f35849e;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public c(int i10, int i11) {
        super(i10, i11, 1);
    }

    @Override // vo.a
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (!(a() == cVar.a() && b() == cVar.b())) {
                }
            }
            return true;
        }
        return false;
    }

    public Integer g() {
        return Integer.valueOf(b());
    }

    public Integer h() {
        return Integer.valueOf(a());
    }

    @Override // vo.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (a() * 31) + b();
    }

    @Override // vo.a
    public boolean isEmpty() {
        return a() > b();
    }

    @Override // vo.a
    public String toString() {
        return a() + ".." + b();
    }
}
