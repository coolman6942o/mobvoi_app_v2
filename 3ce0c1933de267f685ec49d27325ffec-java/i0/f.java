package i0;

import java.util.Locale;
/* compiled from: TextDirectionHeuristicsCompat.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final i0.e f28000a = new e(null, false);

    /* renamed from: b  reason: collision with root package name */
    public static final i0.e f28001b = new e(null, true);

    /* renamed from: c  reason: collision with root package name */
    public static final i0.e f28002c;

    /* renamed from: d  reason: collision with root package name */
    public static final i0.e f28003d;

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* loaded from: classes.dex */
    private static class a implements c {

        /* renamed from: b  reason: collision with root package name */
        static final a f28004b = new a(true);

        /* renamed from: a  reason: collision with root package name */
        private final boolean f28005a;

        private a(boolean z10) {
            this.f28005a = z10;
        }

        @Override // i0.f.c
        public int a(CharSequence charSequence, int i10, int i11) {
            int i12 = i11 + i10;
            boolean z10 = false;
            while (i10 < i12) {
                int a10 = f.a(Character.getDirectionality(charSequence.charAt(i10)));
                if (a10 != 0) {
                    if (a10 != 1) {
                        continue;
                        i10++;
                        z10 = z10;
                    } else if (!this.f28005a) {
                        return 1;
                    }
                } else if (this.f28005a) {
                    return 0;
                }
                z10 = true;
                i10++;
                z10 = z10;
            }
            if (z10) {
                return this.f28005a ? 1 : 0;
            }
            return 2;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* loaded from: classes.dex */
    private static class b implements c {

        /* renamed from: a  reason: collision with root package name */
        static final b f28006a = new b();

        private b() {
        }

        @Override // i0.f.c
        public int a(CharSequence charSequence, int i10, int i11) {
            int i12 = i11 + i10;
            int i13 = 2;
            while (i10 < i12 && i13 == 2) {
                i13 = f.b(Character.getDirectionality(charSequence.charAt(i10)));
                i10++;
            }
            return i13;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* loaded from: classes.dex */
    public interface c {
        int a(CharSequence charSequence, int i10, int i11);
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* loaded from: classes.dex */
    private static abstract class d implements i0.e {

        /* renamed from: a  reason: collision with root package name */
        private final c f28007a;

        d(c cVar) {
            this.f28007a = cVar;
        }

        private boolean c(CharSequence charSequence, int i10, int i11) {
            int a10 = this.f28007a.a(charSequence, i10, i11);
            if (a10 == 0) {
                return true;
            }
            if (a10 != 1) {
                return b();
            }
            return false;
        }

        @Override // i0.e
        public boolean a(CharSequence charSequence, int i10, int i11) {
            if (charSequence == null || i10 < 0 || i11 < 0 || charSequence.length() - i11 < i10) {
                throw new IllegalArgumentException();
            } else if (this.f28007a == null) {
                return b();
            } else {
                return c(charSequence, i10, i11);
            }
        }

        protected abstract boolean b();
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* loaded from: classes.dex */
    private static class e extends d {

        /* renamed from: b  reason: collision with root package name */
        private final boolean f28008b;

        e(c cVar, boolean z10) {
            super(cVar);
            this.f28008b = z10;
        }

        @Override // i0.f.d
        protected boolean b() {
            return this.f28008b;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* renamed from: i0.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0306f extends d {

        /* renamed from: b  reason: collision with root package name */
        static final C0306f f28009b = new C0306f();

        C0306f() {
            super(null);
        }

        @Override // i0.f.d
        protected boolean b() {
            return g.b(Locale.getDefault()) == 1;
        }
    }

    static {
        b bVar = b.f28006a;
        f28002c = new e(bVar, false);
        f28003d = new e(bVar, true);
        new e(a.f28004b, false);
        C0306f fVar = C0306f.f28009b;
    }

    static int a(int i10) {
        if (i10 != 0) {
            return (i10 == 1 || i10 == 2) ? 0 : 2;
        }
        return 1;
    }

    static int b(int i10) {
        if (i10 != 0) {
            if (i10 == 1 || i10 == 2) {
                return 0;
            }
            switch (i10) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
