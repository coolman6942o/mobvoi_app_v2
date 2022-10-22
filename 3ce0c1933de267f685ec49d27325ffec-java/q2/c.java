package q2;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.script.ApduHandler;
import cn.com.fmsh.script.a;
import cn.com.fmsh.script.exception.FMScriptHandleException;
import java.util.Arrays;
import p2.d;
import x2.e;
import x2.f;
import x2.h;
import z2.b;
/* loaded from: classes.dex */
public class c implements a {

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ ApduHandler f32916c;

    /* renamed from: e  reason: collision with root package name */
    private /* synthetic */ boolean f32918e;

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ z2.a f32914a = b.a().b();

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f32915b = c.class.getName();

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ a f32917d = new a();

    public c(ApduHandler apduHandler) {
        this.f32916c = apduHandler;
    }

    @Override // cn.com.fmsh.script.a
    public void a(ApduHandler apduHandler) {
        this.f32916c = apduHandler;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0184 A[SYNTHETIC] */
    @Override // cn.com.fmsh.script.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public p2.a b(p2.c cVar) throws FMScriptHandleException {
        int d10;
        byte[] b10;
        if (this.f32914a == null) {
            this.f32914a = b.a().b();
        }
        this.f32918e = false;
        p2.b bVar = null;
        if (cVar == null) {
            return null;
        }
        p2.a aVar = new p2.a();
        p2.b g10 = cVar.g();
        if (g10 == null) {
            z2.a aVar2 = this.f32914a;
            if (aVar2 != null) {
                aVar2.b(this.f32915b, FM_Exception.insert(1, 74, "够朮挞产扪蠛斷＇菢叉筥专朼捀仵奪贠"));
            }
            new FMScriptHandleException(f.a("外杨持仧执蠑斬｛菣厇筢之朩捂亦奮赹", 4)).setType(FMScriptHandleException.ScriptHandleExceptionType.INVALID_FIRST_ID);
            return null;
        }
        while (!d()) {
            byte[] b11 = g10.b();
            byte[] d11 = (this.f32916c.f() != ApduHandler.ApduHandlerType.OPEN_MOBILE || (b10 = this.f32917d.b(b11)) == null) ? this.f32916c.d(b11) : this.f32916c.e(b10) ? new byte[]{-112} : new byte[]{105, -123};
            d dVar = new d();
            dVar.b(g10.c());
            dVar.a(g10.b());
            if (d11 == null || d11.length < 2) {
                dVar.c(new byte[]{1});
                aVar.a(dVar);
                z2.a aVar3 = this.f32914a;
                if (aVar3 != null) {
                    String str = this.f32915b;
                    aVar3.c(str, x2.b.b(5, "夈杼挏价批蠅斢ｓ\u0011") + g10.c() + x2.c.i("\u0001挆仢扬衜夤贿", 5, 5));
                }
            } else {
                dVar.c(d11);
                aVar.a(dVar);
                byte[] copyOfRange = Arrays.copyOfRange(d11, d11.length - 2, d11.length);
                if (g10.e() == -96) {
                    if (g10.d(new byte[]{-1, -1}) == -1 && g10.d(copyOfRange) == -1) {
                        z2.a aVar4 = this.f32914a;
                        if (aVar4 != null) {
                            String str2 = this.f32915b;
                            aVar4.b(str2, f.a("外杨持仧执蠑斬｛\u000f", 4) + g10.c() + h.e("]挓京哑廄砅C", 3, 52) + x2.c.c(copyOfRange) + x2.c.i("\u0004乏杖朊倥丌筯", 2, 104));
                        }
                    }
                    d10 = g10.c() + 1;
                } else {
                    if (g10.e() == -92) {
                        if (g10.f()) {
                            d10 = g10.d(copyOfRange);
                            if (d10 == -1) {
                                d10 = g10.d(new byte[]{-1, -1});
                            }
                            if (d10 != 0) {
                                if (d10 == 255) {
                                }
                            }
                        }
                        d10 = g10.c() + 1;
                    }
                    if (bVar == null) {
                        if (bVar.c() > g10.c()) {
                            g10 = bVar;
                        } else {
                            FMScriptHandleException fMScriptHandleException = new FMScriptHandleException(h.e("奋末挄亸戲衂旱ｌ徜挕亯盀世朷捈们皅罌古丁奢亐朻朱捎仦盟桓诋＊戸衔夠赯", 116, 89));
                            fMScriptHandleException.setType(FMScriptHandleException.ScriptHandleExceptionType.INVALID_NEXT);
                            throw fMScriptHandleException;
                        }
                    }
                }
                bVar = cVar.e(d10);
                if (bVar == null) {
                }
            }
            return aVar;
        }
        FMScriptHandleException fMScriptHandleException2 = new FMScriptHandleException(e.a(68, "夃杽挘亦戢蠄施b异则撚伆裶倜次"));
        fMScriptHandleException2.setType(FMScriptHandleException.ScriptHandleExceptionType.STOPED);
        throw fMScriptHandleException2;
    }

    @Override // cn.com.fmsh.script.a
    public void c(o2.a aVar) {
        if (aVar != null) {
            for (b bVar : aVar.a()) {
                this.f32917d.a(bVar);
            }
        }
    }

    public synchronized boolean d() {
        return this.f32918e;
    }
}
