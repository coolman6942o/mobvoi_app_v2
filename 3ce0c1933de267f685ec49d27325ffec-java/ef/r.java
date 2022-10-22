package ef;
/* compiled from: SportRecord.java */
/* loaded from: classes2.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private u f25978a;

    /* renamed from: b  reason: collision with root package name */
    private q f25979b;

    public r(u uVar, q qVar) {
        this.f25978a = uVar;
        this.f25979b = qVar;
    }

    public q a() {
        return this.f25979b;
    }

    public u b() {
        return this.f25978a;
    }

    public boolean c() {
        return this.f25978a.f25989h > 0;
    }

    public boolean d() {
        return this.f25978a.f25990i > 0;
    }

    public boolean e() {
        return this.f25978a.h();
    }

    public r(r rVar) {
        this(rVar.f25978a == null ? null : new u(rVar.f25978a), rVar.f25979b);
    }
}
