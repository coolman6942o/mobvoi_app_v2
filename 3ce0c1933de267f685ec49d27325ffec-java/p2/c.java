package p2;

import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import cn.com.fmsh.script.exception.FMScriptHandleException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import x2.e;
import x2.f;
import x2.h;
import z2.b;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ Map<Integer, b> f32546a = new HashMap();

    public c() {
        b.a().b();
        f.a("MybvR8+\"1\":", 4);
    }

    private final /* bridge */ /* synthetic */ void a(byte[] bArr, b bVar) {
        bVar.h(bArr[0]);
        bVar.g(Arrays.copyOfRange(bArr, 1, bArr.length - 2));
        byte[] copyOfRange = Arrays.copyOfRange(bArr, bArr.length - 2, bArr.length);
        bVar.a(new byte[]{copyOfRange[0], copyOfRange[1], 0});
    }

    private final /* bridge */ /* synthetic */ void b(f2.c[] cVarArr, b bVar) throws FMCommunicationMessageException {
        byte[] h10;
        for (f2.c cVar : cVarArr) {
            byte id2 = cVar.getId();
            if (id2 == 56) {
                bVar.h(cVar.d());
            } else if (id2 == 57) {
                bVar.g(cVar.h());
            } else if (id2 == 60 && (h10 = cVar.h()) != null) {
                bVar.a(h10);
            }
        }
    }

    public boolean c(b bVar) throws FMScriptHandleException {
        if (bVar == null) {
            return false;
        }
        if (this.f32546a.size() >= 1 || 1 == bVar.c()) {
            this.f32546a.put(Integer.valueOf(bVar.c()), bVar);
            return true;
        }
        throw new FMScriptHandleException(x2.b.b(2, "徊扽衉皔笷乆朰捛亣盖廒刟古专昦%３奇呝腚杧奒琇夽贲"));
    }

    public void d(f2.c cVar) throws FMCommunicationMessageException, FMScriptHandleException {
        if (cVar != null) {
            byte id2 = cVar.getId();
            if (!cVar.b()) {
                throw new FMCommunicationMessageException(String.format(h.e("核捭触林巬兼揝侔皕GTPB>EB觢枓诲汅挎仯旻＃ERR旷救", 4, 2), Byte.valueOf(cVar.getId())));
            } else if (id2 == -95) {
                int k10 = cVar.k();
                for (int i10 = 0; i10 < k10; i10++) {
                    f2.c l10 = cVar.l(i10);
                    if (l10 != null) {
                        b bVar = new b();
                        byte id3 = l10.getId();
                        bVar.i(id3);
                        if (id3 == -92) {
                            b(l10.j(), bVar);
                        } else if (id3 == -96) {
                            a(l10.h(), bVar);
                        } else {
                            this.f32546a.clear();
                            throw new FMCommunicationMessageException(String.format(x2.b.b(174, "Zw呟霾厭肯晲I#戈而U+ｆ记\u0014*1Z)O_旭敐"), Byte.valueOf(id3)));
                        }
                        c(bVar);
                    }
                }
            } else if (id2 == -96) {
                b bVar2 = new b();
                bVar2.i(id2);
                a(cVar.h(), bVar2);
                c(bVar2);
            } else {
                throw new FMCommunicationMessageException(String.format(e.a(64, "T(戍耛\u0000u戊肷輡挲乩九厈腆杳ｎ\u0011\t\f\u0015t\f\n斺攕"), Byte.valueOf(id2)));
            }
        } else {
            throw new FMCommunicationMessageException(e.a(2, "\u0003\u001b\u001a转捡丼挎仨雉吚旣４O_F举穽"));
        }
    }

    public b e(int i10) {
        return this.f32546a.get(Integer.valueOf(i10));
    }

    public b[] f() {
        b[] bVarArr = new b[this.f32546a.size()];
        int i10 = 0;
        for (Integer num : this.f32546a.keySet()) {
            bVarArr[i10] = this.f32546a.get(num);
            i10++;
        }
        return bVarArr;
    }

    public b g() {
        return this.f32546a.get(1);
    }
}
