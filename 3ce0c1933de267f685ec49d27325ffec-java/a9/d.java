package a9;
/* compiled from: Codeword.java */
/* loaded from: classes.dex */
final class d {

    /* renamed from: a  reason: collision with root package name */
    private final int f144a;

    /* renamed from: b  reason: collision with root package name */
    private final int f145b;

    /* renamed from: c  reason: collision with root package name */
    private final int f146c;

    /* renamed from: d  reason: collision with root package name */
    private final int f147d;

    /* renamed from: e  reason: collision with root package name */
    private int f148e = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(int i10, int i11, int i12, int i13) {
        this.f144a = i10;
        this.f145b = i11;
        this.f146c = i12;
        this.f147d = i13;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f146c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f145b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f148e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f144a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f147d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f145b - this.f144a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return h(this.f148e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(int i10) {
        return i10 != -1 && this.f146c == (i10 % 3) * 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(int i10) {
        this.f148e = i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        this.f148e = ((this.f147d / 30) * 3) + (this.f146c / 3);
    }

    public String toString() {
        return this.f148e + "|" + this.f147d;
    }
}
