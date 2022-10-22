package u4;

import android.graphics.Bitmap;
import n5.k;
/* compiled from: AttributeStrategy.java */
/* loaded from: classes.dex */
class c implements l {

    /* renamed from: a  reason: collision with root package name */
    private final b f35289a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final h<a, Bitmap> f35290b = new h<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AttributeStrategy.java */
    /* loaded from: classes.dex */
    public static class a implements m {

        /* renamed from: a  reason: collision with root package name */
        private final b f35291a;

        /* renamed from: b  reason: collision with root package name */
        private int f35292b;

        /* renamed from: c  reason: collision with root package name */
        private int f35293c;

        /* renamed from: d  reason: collision with root package name */
        private Bitmap.Config f35294d;

        public a(b bVar) {
            this.f35291a = bVar;
        }

        @Override // u4.m
        public void a() {
            this.f35291a.c(this);
        }

        public void b(int i10, int i11, Bitmap.Config config) {
            this.f35292b = i10;
            this.f35293c = i11;
            this.f35294d = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f35292b == aVar.f35292b && this.f35293c == aVar.f35293c && this.f35294d == aVar.f35294d;
        }

        public int hashCode() {
            int i10 = ((this.f35292b * 31) + this.f35293c) * 31;
            Bitmap.Config config = this.f35294d;
            return i10 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return c.f(this.f35292b, this.f35293c, this.f35294d);
        }
    }

    /* compiled from: AttributeStrategy.java */
    /* loaded from: classes.dex */
    static class b extends d<a> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d */
        public a a() {
            return new a(this);
        }

        a e(int i10, int i11, Bitmap.Config config) {
            a b10 = b();
            b10.b(i10, i11, config);
            return b10;
        }
    }

    static String f(int i10, int i11, Bitmap.Config config) {
        return "[" + i10 + "x" + i11 + "], " + config;
    }

    private static String g(Bitmap bitmap) {
        return f(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // u4.l
    public String a(int i10, int i11, Bitmap.Config config) {
        return f(i10, i11, config);
    }

    @Override // u4.l
    public int b(Bitmap bitmap) {
        return k.g(bitmap);
    }

    @Override // u4.l
    public void c(Bitmap bitmap) {
        this.f35290b.d(this.f35289a.e(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // u4.l
    public Bitmap d(int i10, int i11, Bitmap.Config config) {
        return this.f35290b.a(this.f35289a.e(i10, i11, config));
    }

    @Override // u4.l
    public String e(Bitmap bitmap) {
        return g(bitmap);
    }

    @Override // u4.l
    public Bitmap removeLast() {
        return this.f35290b.f();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f35290b;
    }
}
