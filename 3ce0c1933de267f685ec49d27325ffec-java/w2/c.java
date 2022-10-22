package w2;

import cn.com.fmsh.script.ApduHandler;
import r2.a;
import r2.d;
import r2.f;
/* loaded from: classes.dex */
public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ d f35948a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ e f35949b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ f f35950c;

    public c() {
        f fVar = new f();
        this.f35950c = fVar;
        this.f35948a = new d(fVar);
        this.f35949b = new e(this.f35950c);
        new b(this.f35950c);
    }

    @Override // r2.a
    public void a(ApduHandler apduHandler) {
        this.f35950c.r(apduHandler);
    }

    @Override // r2.a
    public r2.c b() {
        return this.f35948a;
    }

    @Override // r2.a
    public void c(byte[] bArr) {
        this.f35950c.s(bArr);
    }

    @Override // r2.a
    public void d(f fVar) {
        this.f35950c.q(fVar);
    }

    @Override // r2.a
    public d e() {
        return this.f35949b;
    }
}
