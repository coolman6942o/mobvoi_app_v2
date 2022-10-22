package yl;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: e  reason: collision with root package name */
    public static boolean f37130e = false;

    /* renamed from: a  reason: collision with root package name */
    public int f37131a = 50000000;

    /* renamed from: b  reason: collision with root package name */
    public volatile long f37132b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f37133c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37134d;

    public b(boolean z10, int i10) {
        this.f37133c = -1;
        this.f37134d = false;
        this.f37134d = z10;
        this.f37133c = i10 * this.f37131a;
    }

    public void a() {
        if (this.f37134d) {
            if (this.f37132b != -1 && this.f37133c != -1) {
                do {
                } while (System.nanoTime() - this.f37132b < this.f37133c);
                if (f37130e) {
                    il.b.j("flow control stopped");
                }
            } else if (f37130e) {
                il.b.c("flow control block with error, must initial first");
            }
        }
    }

    public void b() {
        if (this.f37134d) {
            this.f37132b = System.nanoTime();
            if (f37130e) {
                il.b.j("flow control started");
            }
        }
    }
}
