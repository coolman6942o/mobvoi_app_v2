package y8;
/* compiled from: CurrentParsingState.java */
/* loaded from: classes.dex */
final class m {

    /* renamed from: a  reason: collision with root package name */
    private int f36783a = 0;

    /* renamed from: b  reason: collision with root package name */
    private a f36784b = a.NUMERIC;

    /* compiled from: CurrentParsingState.java */
    /* loaded from: classes.dex */
    private enum a {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f36783a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i10) {
        this.f36783a += i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.f36784b == a.ALPHA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.f36784b == a.ISO_IEC_646;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.f36784b = a.ALPHA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.f36784b = a.ISO_IEC_646;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        this.f36784b = a.NUMERIC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(int i10) {
        this.f36783a = i10;
    }
}
