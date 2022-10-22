package b9;
/* compiled from: ModulusGF.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: f  reason: collision with root package name */
    public static final b f5105f = new b(929, 3);

    /* renamed from: a  reason: collision with root package name */
    private final int[] f5106a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f5107b;

    /* renamed from: c  reason: collision with root package name */
    private final c f5108c;

    /* renamed from: d  reason: collision with root package name */
    private final c f5109d;

    /* renamed from: e  reason: collision with root package name */
    private final int f5110e;

    private b(int i10, int i11) {
        this.f5110e = i10;
        this.f5106a = new int[i10];
        this.f5107b = new int[i10];
        int i12 = 1;
        for (int i13 = 0; i13 < i10; i13++) {
            this.f5106a[i13] = i12;
            i12 = (i12 * i11) % i10;
        }
        for (int i14 = 0; i14 < i10 - 1; i14++) {
            this.f5107b[this.f5106a[i14]] = i14;
        }
        this.f5108c = new c(this, new int[]{0});
        this.f5109d = new c(this, new int[]{1});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i10, int i11) {
        return (i10 + i11) % this.f5110e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c b(int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException();
        } else if (i11 == 0) {
            return this.f5108c;
        } else {
            int[] iArr = new int[i10 + 1];
            iArr[0] = i11;
            return new c(this, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i10) {
        return this.f5106a[i10];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c d() {
        return this.f5109d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f5110e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c f() {
        return this.f5108c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g(int i10) {
        if (i10 != 0) {
            return this.f5106a[(this.f5110e - this.f5107b[i10]) - 1];
        }
        throw new ArithmeticException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h(int i10) {
        if (i10 != 0) {
            return this.f5107b[i10];
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i(int i10, int i11) {
        if (i10 == 0 || i11 == 0) {
            return 0;
        }
        int[] iArr = this.f5106a;
        int[] iArr2 = this.f5107b;
        return iArr[(iArr2[i10] + iArr2[i11]) % (this.f5110e - 1)];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j(int i10, int i11) {
        int i12 = this.f5110e;
        return ((i10 + i12) - i11) % i12;
    }
}
