package cn.com.fmsh.tsm.business.bean;

import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import cn.com.fmsh.tsm.business.enums.EnumOrderStatus;
import f2.c;
import x2.f;
import z2.a;
import z2.b;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ byte[] f6179a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f6180b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ int f6181c;

    public static e a(c cVar) throws FMCommunicationMessageException {
        a b10 = b.a().b();
        if (cVar == null) {
            if (b10 != null) {
                b10.c(BusinessOrder.class.getName(), x2.a.b("\u0007=\"甑戇支云诰华旲！\u0002>/寨豻丹稶", 3, 105));
            }
            return null;
        }
        c[] j10 = cVar.j();
        if (j10 == null || j10.length < 1) {
            if (b10 != null) {
                b10.c(BusinessOrder.class.getName(), f.a("Yk`甛我敱亃诺匀斤ｃ\u0018(!嬓頹乧稠", 5));
            }
            return null;
        }
        e eVar = new e();
        for (c cVar2 : j10) {
            byte id2 = cVar2.getId();
            if (id2 == 2) {
                eVar.j(cVar2.g());
            } else if (id2 == 13) {
                eVar.f(cVar2.d());
            } else if (id2 == 16) {
                eVar.e(x2.c.e(cVar2.h()));
            } else if (id2 == 105) {
                eVar.i(cVar2.h());
            } else if (id2 != 106) {
                switch (id2) {
                    case 18:
                        eVar.l(cVar2.g());
                        continue;
                    case 19:
                        eVar.g(cVar2.g());
                        continue;
                    case 20:
                        eVar.m(cVar2.g());
                        continue;
                    case 21:
                        eVar.k(EnumOrderStatus.getOrderStatus4ID(cVar2.d()));
                        continue;
                }
            } else {
                eVar.h(cVar2.h());
            }
        }
        return eVar;
    }

    public int b() {
        return this.f6181c;
    }

    public byte[] c() {
        return this.f6179a;
    }

    public String d() {
        return this.f6180b;
    }

    public void e(int i10) {
    }

    public void f(int i10) {
        this.f6181c = i10;
    }

    public void g(String str) {
    }

    public void h(byte[] bArr) {
        this.f6179a = bArr;
    }

    public void i(byte[] bArr) {
    }

    public void j(String str) {
    }

    public void k(EnumOrderStatus enumOrderStatus) {
    }

    public void l(String str) {
        this.f6180b = str;
    }

    public void m(String str) {
    }
}
