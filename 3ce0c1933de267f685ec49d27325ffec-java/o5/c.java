package o5;
/* compiled from: StateVerifier.java */
/* loaded from: classes.dex */
public abstract class c {

    /* compiled from: StateVerifier.java */
    /* loaded from: classes.dex */
    private static class b extends c {

        /* renamed from: a  reason: collision with root package name */
        private volatile boolean f31450a;

        b() {
            super();
        }

        @Override // o5.c
        public void b(boolean z10) {
            this.f31450a = z10;
        }

        @Override // o5.c
        public void c() {
            if (this.f31450a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    public static c a() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(boolean z10);

    public abstract void c();

    private c() {
    }
}
