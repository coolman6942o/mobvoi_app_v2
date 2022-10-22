package bp;

import android.os.SystemClock;
/* compiled from: DfuProgressInfo.java */
/* loaded from: classes3.dex */
class j {

    /* renamed from: a  reason: collision with root package name */
    private final a f5454a;

    /* renamed from: b  reason: collision with root package name */
    private int f5455b;

    /* renamed from: c  reason: collision with root package name */
    private int f5456c;

    /* renamed from: d  reason: collision with root package name */
    private int f5457d;

    /* renamed from: e  reason: collision with root package name */
    private int f5458e;

    /* renamed from: f  reason: collision with root package name */
    private int f5459f;

    /* renamed from: g  reason: collision with root package name */
    private int f5460g;

    /* renamed from: h  reason: collision with root package name */
    private int f5461h;

    /* renamed from: i  reason: collision with root package name */
    private int f5462i;

    /* renamed from: j  reason: collision with root package name */
    private long f5463j;

    /* renamed from: k  reason: collision with root package name */
    private long f5464k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DfuProgressInfo.java */
    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.f5454a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i10) {
        n(this.f5456c + i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        int i10 = this.f5459f;
        int i11 = this.f5456c;
        int i12 = this.f5460g;
        return Math.min(i10 - i11, i12 - (i11 % i12));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j10 = this.f5463j;
        if (elapsedRealtime - j10 != 0) {
            return (this.f5456c - this.f5457d) / ((float) (elapsedRealtime - j10));
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f5456c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f5461h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f5455b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float g() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        float f10 = elapsedRealtime - this.f5463j != 0 ? (this.f5456c - this.f5458e) / ((float) (elapsedRealtime - this.f5464k)) : 0.0f;
        this.f5464k = elapsedRealtime;
        this.f5458e = this.f5456c;
        return f10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.f5462i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j i(int i10, int i11, int i12) {
        this.f5459f = i10;
        this.f5460g = Integer.MAX_VALUE;
        this.f5461h = i11;
        this.f5462i = i12;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j() {
        return this.f5456c == this.f5459f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return this.f5461h == this.f5462i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return this.f5456c % this.f5460g == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(int i10) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(int i10) {
        if (this.f5463j == 0) {
            this.f5463j = SystemClock.elapsedRealtime();
            this.f5457d = i10;
        }
        this.f5456c = i10;
        this.f5455b = (int) ((i10 * 100.0f) / this.f5459f);
        this.f5454a.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(int i10) {
        this.f5460g = i10;
    }

    public void p(int i10) {
        this.f5455b = i10;
        this.f5454a.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j q(int i10) {
        this.f5462i = i10;
        return this;
    }
}
