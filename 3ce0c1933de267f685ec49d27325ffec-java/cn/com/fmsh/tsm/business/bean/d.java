package cn.com.fmsh.tsm.business.bean;

import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import cn.com.fmsh.tsm.business.enums.EnumBusinessOrderLoadType;
import cn.com.fmsh.tsm.business.enums.EnumOrderStatus;
import f2.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ byte[] f6176a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ List<BusinessOrder> f6177b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ List<e> f6178c = new ArrayList();

    public static d c(c cVar) throws FMCommunicationMessageException {
        c[] j10;
        if (cVar == null || (j10 = cVar.j()) == null || j10.length < 1) {
            return null;
        }
        d dVar = new d();
        for (c cVar2 : j10) {
            byte id2 = cVar2.getId();
            if (id2 == -55) {
                dVar.h(EnumBusinessOrderLoadType.getBusinessOrderLoadType4ID(cVar2.d()));
            } else if (id2 == 16) {
                dVar.g(x2.c.e(cVar2.h()));
            } else if (id2 == 27) {
                c[] j11 = cVar2.j();
                if (j11 != null && j11.length > 0) {
                    for (c cVar3 : j11) {
                        BusinessOrder fromTag = BusinessOrder.fromTag(cVar3);
                        if (fromTag != null) {
                            dVar.a(fromTag);
                        }
                    }
                }
            } else if (id2 == 100) {
                c[] j12 = cVar2.j();
                if (j12 != null && j12.length > 0) {
                    for (c cVar4 : j12) {
                        e a10 = e.a(cVar4);
                        if (a10 != null) {
                            dVar.b(a10);
                        }
                    }
                }
            } else if (id2 != 105) {
                switch (id2) {
                    case 19:
                        dVar.i(cVar2.g());
                        continue;
                    case 20:
                        dVar.l(cVar2.g());
                        continue;
                    case 21:
                        dVar.k(EnumOrderStatus.getOrderStatus4ID(cVar2.d()));
                        continue;
                }
            } else {
                dVar.j(cVar2.h());
            }
        }
        return dVar;
    }

    public void a(BusinessOrder businessOrder) {
        if (businessOrder != null) {
            this.f6177b.add(businessOrder);
        }
    }

    public void b(e eVar) {
        if (eVar != null) {
            this.f6178c.add(eVar);
        }
    }

    public BusinessOrder[] d() {
        return (BusinessOrder[]) this.f6177b.toArray(new BusinessOrder[0]);
    }

    public byte[] e() {
        return this.f6176a;
    }

    public e[] f() {
        return (e[]) this.f6178c.toArray(new e[0]);
    }

    public void g(int i10) {
    }

    public void h(EnumBusinessOrderLoadType enumBusinessOrderLoadType) {
    }

    public void i(String str) {
    }

    public void j(byte[] bArr) {
        this.f6176a = bArr;
    }

    public void k(EnumOrderStatus enumOrderStatus) {
    }

    public void l(String str) {
    }
}
