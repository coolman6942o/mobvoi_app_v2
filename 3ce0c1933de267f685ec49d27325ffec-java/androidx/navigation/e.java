package androidx.navigation;

import android.os.Bundle;
/* compiled from: NavArgument.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final r f3440a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f3441b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f3442c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f3443d;

    /* compiled from: NavArgument.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private r<?> f3444a;

        /* renamed from: c  reason: collision with root package name */
        private Object f3446c;

        /* renamed from: b  reason: collision with root package name */
        private boolean f3445b = false;

        /* renamed from: d  reason: collision with root package name */
        private boolean f3447d = false;

        public e a() {
            if (this.f3444a == null) {
                this.f3444a = r.e(this.f3446c);
            }
            return new e(this.f3444a, this.f3445b, this.f3446c, this.f3447d);
        }

        public a b(Object obj) {
            this.f3446c = obj;
            this.f3447d = true;
            return this;
        }

        public a c(boolean z10) {
            this.f3445b = z10;
            return this;
        }

        public a d(r<?> rVar) {
            this.f3444a = rVar;
            return this;
        }
    }

    e(r<?> rVar, boolean z10, Object obj, boolean z11) {
        if (!rVar.f() && z10) {
            throw new IllegalArgumentException(rVar.c() + " does not allow nullable values");
        } else if (z10 || !z11 || obj != null) {
            this.f3440a = rVar;
            this.f3441b = z10;
            this.f3443d = obj;
            this.f3442c = z11;
        } else {
            throw new IllegalArgumentException("Argument with type " + rVar.c() + " has null value but is not nullable.");
        }
    }

    public Object a() {
        return this.f3443d;
    }

    public r<?> b() {
        return this.f3440a;
    }

    public boolean c() {
        return this.f3442c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str, Bundle bundle) {
        if (this.f3442c) {
            this.f3440a.i(bundle, str, this.f3443d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(String str, Bundle bundle) {
        if (!this.f3441b && bundle.containsKey(str) && bundle.get(str) == null) {
            return false;
        }
        try {
            this.f3440a.b(bundle, str);
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f3441b != eVar.f3441b || this.f3442c != eVar.f3442c || !this.f3440a.equals(eVar.f3440a)) {
            return false;
        }
        Object obj2 = this.f3443d;
        return obj2 != null ? obj2.equals(eVar.f3443d) : eVar.f3443d == null;
    }

    public int hashCode() {
        int hashCode = ((((this.f3440a.hashCode() * 31) + (this.f3441b ? 1 : 0)) * 31) + (this.f3442c ? 1 : 0)) * 31;
        Object obj = this.f3443d;
        return hashCode + (obj != null ? obj.hashCode() : 0);
    }
}
