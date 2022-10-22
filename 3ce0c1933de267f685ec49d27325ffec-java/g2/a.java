package g2;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import com.huawei.hms.ml.camera.CameraConfig;
import f2.c;
import f2.e;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import x2.d;
import x2.h;
import z2.b;
/* loaded from: classes.dex */
public class a implements f2.a {

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ e f27196c;

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ b f27197d;

    /* renamed from: e  reason: collision with root package name */
    private /* synthetic */ int f27198e;

    /* renamed from: f  reason: collision with root package name */
    private /* synthetic */ byte[] f27199f;

    /* renamed from: a  reason: collision with root package name */
    /* synthetic */ z2.a f27194a = b.a().b();

    /* renamed from: b  reason: collision with root package name */
    /* synthetic */ String f27195b = a.class.getName();

    /* renamed from: g  reason: collision with root package name */
    private /* synthetic */ boolean f27200g = false;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ List<c> f27201h = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ a(b bVar) {
        this.f27197d = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ a(b bVar, int i10) {
        this.f27197d = bVar;
        this.f27198e = i10;
    }

    private final /* bridge */ /* synthetic */ void d(byte[] bArr) throws FMCommunicationMessageException {
        for (e.a aVar : e.a().b(bArr, 1)) {
            d j10 = this.f27197d.j(aVar.b()[0], aVar.a());
            if (!j10.b()) {
                this.f27201h.clear();
                z2.a aVar2 = this.f27194a;
                if (aVar2 != null) {
                    aVar2.c(a.class.getName(), FM_Exception.insert(5, 5, "亅迕別店刊枆逧Ateh!\"/方ｘ\r?$桏讋也呟沉"));
                }
                throw new FMCommunicationMessageException(x2.e.a(4, "桠挲仓这刳庇刜枊週Yrinadc旿\uff00觬枂莢収别皚\u0015\u0005\u0000髆讌奡赶"));
            }
            this.f27201h.add(j10);
        }
    }

    @Override // f2.a
    public byte[] a() throws FMCommunicationMessageException {
        if (g()) {
            byte[] d10 = d.d(this.f27198e, 2);
            for (c cVar : this.f27201h) {
                byte[] a10 = cVar.a();
                if (a10 != null) {
                    d10 = x2.c.s(d10, a10);
                }
            }
            return d10;
        }
        throw new FMCommunicationMessageException(FM_Exception.insert(204, 9, "淘怶宻谪輸挿或存芚庎初？涔怪宷谶斠攁"));
    }

    @Override // f2.a
    public c b(int i10) throws FMCommunicationMessageException {
        for (c cVar : this.f27201h) {
            if (cVar != null && i10 == cVar.getId()) {
                return cVar;
            }
        }
        return null;
    }

    @Override // f2.a
    public int c(c cVar) throws FMCommunicationMessageException {
        if (this.f27200g) {
            return -1;
        }
        if (cVar == null) {
            return -2;
        }
        this.f27201h.add(cVar);
        return 0;
    }

    public int e(int i10, byte[] bArr) throws FMCommunicationMessageException {
        this.f27200g = true;
        this.f27198e = i10;
        e l10 = this.f27197d.l(i10);
        this.f27196c = l10;
        if (l10 != null) {
            d(bArr);
            return 0;
        }
        throw new FMCommunicationMessageException(x2.c.i("档挻亜运剰廎刋染遲@m0mx3*旼）覣枋莡厇剼皃涊怲缎砒乃呁泑", 3, 91));
    }

    public int f(byte[] bArr) throws FMCommunicationMessageException {
        this.f27200g = true;
        if (bArr == null || bArr.length < 2) {
            throw new InvalidParameterException(FM_Exception.insert(CameraConfig.CAMERA_THIRD_DEGREE, 99, "校捵嬉苃廋刐枎遭淘恼无ｕ佼兺皆孒苊廄则镮廲乚吒泈"));
        }
        int b10 = h.b(d.b(Arrays.copyOf(bArr, 2)), -1);
        this.f27198e = b10;
        if (b10 != -1) {
            e l10 = this.f27197d.l(b10);
            this.f27196c = l10;
            if (l10 != null) {
                d(Arrays.copyOfRange(bArr, 2, bArr.length));
                return 0;
            }
            throw new FMCommunicationMessageException(d.c("桼捸事迃刿廕剜柘遭Sjsbc4!斣ｊ觴枘莮叜剫盈淕怡缉砑丌吚泖", 210));
        }
        this.f27201h.clear();
        throw new InvalidParameterException(h.e("栨捡嬚苉庆刐柁遣涉怰斫７觺柇菢叅刡盋罛砊丄呏沐", CameraConfig.CAMERA_THIRD_DEGREE, 94));
    }

    public boolean g() {
        if (this.f27196c == null) {
            this.f27196c = this.f27199f == null ? this.f27197d.l(this.f27198e) : this.f27197d.m(this.f27198e);
        }
        e eVar = this.f27196c;
        if (eVar == null) {
            z2.a aVar = this.f27194a;
            if (aVar != null) {
                aVar.c(this.f27195b, h.e("涊性吆沁怽梀柣斺＞華又涌急宊丟俽怭夹赫", 5, 70));
            }
            return false;
        }
        c[] c10 = eVar.c();
        for (c cVar : c10) {
            if (cVar.a() == 1) {
                boolean z10 = false;
                for (c cVar2 : this.f27201h) {
                    if (cVar2.getId() == cVar.b()) {
                        z10 = true;
                    }
                }
                if (!z10) {
                    z2.a aVar2 = this.f27194a;
                    if (aVar2 != null) {
                        aVar2.c(this.f27195b, String.format(x2.e.a(2, "鄚缴旚件宙乏Di|at\u007f~E") + this.f27198e + x2.c.i("\u0001徂頩孅圠皗\n(3D/M]ｇ乛嬙圤；诧淅怷乎吆泌", 5, 107), Byte.valueOf(cVar.b())));
                    }
                    return false;
                }
            }
        }
        for (c cVar3 : this.f27201h) {
            boolean z11 = false;
            for (c cVar4 : c10) {
                if (cVar3.getId() == cVar4.b()) {
                    z11 = true;
                }
            }
            if (!z11) {
                z2.a aVar3 = this.f27194a;
                if (aVar3 != null) {
                    aVar3.c(this.f27195b, String.format(x2.c.i("淑恭书嶦绒杏盋L\u0000\rH9\u001dS;坨酄罼旜仲丠杼寅乁", 2, 41), Byte.valueOf(cVar3.getId())));
                }
                return false;
            }
        }
        return true;
    }
}
