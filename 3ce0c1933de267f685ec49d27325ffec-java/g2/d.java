package g2;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.communication.message.enumerate.ETagType;
import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import f2.c;
import f2.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import x2.e;
import x2.f;
import x2.g;
import x2.h;
import z2.a;
import z2.b;
/* loaded from: classes.dex */
public class d implements c {

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ byte f27211c;

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ byte[] f27212d;

    /* renamed from: e  reason: collision with root package name */
    private /* synthetic */ ETagType f27213e;

    /* renamed from: g  reason: collision with root package name */
    private /* synthetic */ b f27215g;

    /* renamed from: i  reason: collision with root package name */
    private /* synthetic */ f f27217i;

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ a f27209a = b.a().b();

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f27210b = a.class.getName();

    /* renamed from: f  reason: collision with root package name */
    private /* synthetic */ List<c> f27214f = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ boolean f27216h = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(b bVar) {
        this.f27215g = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(b bVar, byte b10) {
        this.f27215g = bVar;
        this.f27211c = b10;
        this.f27217i = bVar.n(b10);
    }

    @Override // f2.c
    public byte[] a() throws FMCommunicationMessageException {
        int i10 = 4;
        if (!b()) {
            a aVar = this.f27209a;
            if (aVar != null) {
                aVar.c(this.f27210b, String.format(h.e("T\u000bS\u0005-\nA????????????????????????????????????????????????", 3, 74), Byte.valueOf(this.f27211c)));
            }
            throw new FMCommunicationMessageException(String.format(e.a(4, "\r\u001d\u0018Y PV???????????????????????????]MH????????????"), Byte.valueOf(this.f27211c)));
        }
        if (ETagType.C == this.f27213e) {
            this.f27212d = new byte[0];
            for (c cVar : this.f27214f) {
                this.f27212d = x2.c.s(this.f27212d, cVar.a());
            }
        }
        byte[] bArr = this.f27212d;
        if (bArr == null) {
            a aVar2 = this.f27209a;
            if (aVar2 != null) {
                aVar2.c(this.f27210b, String.format(f.a("XHAX%\u0005\u0007????????????????????????s\b\u0018\u0011????????????", 4), Byte.valueOf(this.f27211c)));
            }
            throw new FMCommunicationMessageException(String.format(f.a("YK@_$\u0006\u0006????????????????????????l\t\u001b\u0010????????????", 5), Byte.valueOf(this.f27211c)));
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[4];
        bArr2[0] = this.f27211c;
        if (length >= 255) {
            bArr2[1] = -1;
            byte[] n10 = x2.c.n(length, 2);
            bArr2[2] = n10[0];
            bArr2[3] = n10[1];
        } else {
            bArr2[1] = (byte) length;
            i10 = 2;
        }
        byte[] bArr3 = new byte[i10 + length];
        for (int i11 = 0; i11 < i10; i11++) {
            bArr3[i11] = bArr2[i11];
        }
        for (int i12 = 0; i12 < length; i12++) {
            bArr3[i10 + i12] = this.f27212d[i12];
        }
        return bArr3;
    }

    @Override // f2.c
    public boolean b() {
        f fVar = this.f27217i;
        if (fVar == null) {
            a aVar = this.f27209a;
            if (aVar != null) {
                aVar.c(this.f27210b, String.format(x2.a.b("T\u0016\t^y\u000bW??????????????????????????????????????????", 176, 87), Byte.valueOf(this.f27211c)));
            }
            return false;
        }
        if (fVar.c() != 0) {
            byte[] bArr = this.f27212d;
            if (bArr == null || bArr.length < 1) {
                a aVar2 = this.f27209a;
                if (aVar2 != null) {
                    aVar2.c(this.f27210b, String.format(x2.b.b(1, "ZXCT?\u001d\r????????????SSZ????????????"), Byte.valueOf(this.f27211c)));
                }
                return false;
            } else if (bArr.length > this.f27217i.c()) {
                a aVar3 = this.f27209a;
                if (aVar3 != null) {
                    aVar3.c(this.f27210b, String.format(e.a(234, "\u000b\u0003\u0002\u0013n\u0016\f??????????????????????????????????????????????????????"), Byte.valueOf(this.f27211c)));
                }
                return false;
            }
        }
        return true;
    }

    @Override // f2.c
    public int c(int i10) throws FMCommunicationMessageException {
        if (!this.f27216h) {
            f fVar = this.f27217i;
            if (fVar != null) {
                ETagType e10 = fVar.e();
                this.f27213e = e10;
                if (e10 == ETagType.I) {
                    this.f27212d = x2.c.n(i10, this.f27217i.c());
                    return 0;
                }
                throw new FMCommunicationMessageException(String.format(e.a(2, "???\u000e\u001cGX#QQ??????????????????UE@??????????????????"), Byte.valueOf(this.f27211c)));
            }
            throw new FMCommunicationMessageException(String.format(h.e("???\u0018X\u0001H%\u0015G??????????????????AC\b????????????", 2, 77), Byte.valueOf(this.f27211c)));
        }
        throw new FMCommunicationMessageException(String.format(g.a(3, 97, "???\u0000TQ\f}AG???????????????\u0014 e??????"), Byte.valueOf(this.f27211c)));
    }

    @Override // f2.c
    public int d() throws FMCommunicationMessageException {
        if (ETagType.I == this.f27213e) {
            return x2.c.e(this.f27212d);
        }
        return -1;
    }

    @Override // f2.c
    public int e(byte[] bArr) throws FMCommunicationMessageException {
        if (!this.f27216h) {
            f fVar = this.f27217i;
            if (fVar != null) {
                ETagType e10 = fVar.e();
                this.f27213e = e10;
                if (e10 != ETagType.B) {
                    throw new FMCommunicationMessageException(String.format(FM_Exception.insert(178, 43, "???\u0015MP\u0019(@\u001e??????????????????DZ\u0001??????????????????"), Byte.valueOf(this.f27211c)));
                } else if (this.f27217i.c() == 0 || bArr.length <= this.f27217i.c()) {
                    this.f27212d = bArr;
                    return 0;
                } else {
                    throw new FMCommunicationMessageException(String.format(g.a(200, 110, "???RUE\u000b{\u0014G??????????????????HK_?????????????????????"), Byte.valueOf(this.f27211c)));
                }
            } else {
                throw new FMCommunicationMessageException(String.format(g.a(154, 87, "???\u0015YH\u001d8L\u0016??????????????????\u0018B\u001d????????????"), Byte.valueOf(this.f27211c)));
            }
        } else {
            throw new FMCommunicationMessageException(String.format(h.e("???@F]\u0016e\u000b[???????????????\fjy??????", 4, 19), Byte.valueOf(this.f27211c)));
        }
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof d) && this.f27211c == ((d) obj).f27211c;
    }

    @Override // f2.c
    public int f(String str) throws FMCommunicationMessageException {
        if (!this.f27216h) {
            f fVar = this.f27217i;
            if (fVar != null) {
                this.f27213e = fVar.e();
                h2.g b10 = h2.a.c().b(this.f27213e);
                if (b10 != null) {
                    this.f27212d = b10.a(str);
                    return 0;
                }
                throw new FMCommunicationMessageException(String.format(FM_Exception.insert(210, 53, "???_\u0001\u0012QzL\u0014??????????????????H\u0010A???????????????"), Byte.valueOf(this.f27211c)));
            }
            throw new FMCommunicationMessageException(String.format(x2.c.i("???\\\u0016\u0001NaK_??????????????????_\u001b\u000e????????????", 226, 79), Byte.valueOf(this.f27211c)));
        }
        throw new FMCommunicationMessageException(String.format(f.a("???]GD[x\u0002\n???????????????\u0011#8??????", 4), Byte.valueOf(this.f27211c)));
    }

    @Override // f2.c
    public String g() throws FMCommunicationMessageException {
        h2.g b10 = h2.a.c().b(this.f27213e);
        if (b10 != null) {
            return b10.b(this.f27212d);
        }
        return null;
    }

    @Override // f2.c
    public byte getId() {
        return this.f27211c;
    }

    @Override // f2.c
    public byte[] h() throws FMCommunicationMessageException {
        if (ETagType.B == this.f27213e) {
            return this.f27212d;
        }
        return null;
    }

    @Override // f2.c
    public int i(c cVar) throws FMCommunicationMessageException {
        boolean z10;
        if (cVar == null) {
            throw new FMCommunicationMessageException(String.format(FM_Exception.insert(5, 102, "???\u001b\u0014\\Z\"\u0015\u000e?????????????????????W\b\b??????"), Byte.valueOf(this.f27211c)));
        } else if (!this.f27216h) {
            f fVar = this.f27217i;
            if (fVar != null) {
                ETagType e10 = fVar.e();
                this.f27213e = e10;
                if (e10 == ETagType.C) {
                    g[] d10 = this.f27217i.d();
                    int length = d10.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 >= length) {
                            z10 = false;
                            break;
                        } else if (d10[i10].a() == cVar.getId()) {
                            z10 = true;
                            break;
                        } else {
                            i10++;
                        }
                    }
                    if (z10) {
                        this.f27214f.add(cVar);
                        return 0;
                    }
                    throw new FMCommunicationMessageException(String.format(x2.b.b(288, "???L\u0002\t\u0002a\u0017\u0007??????????????????\u0013\u0013\u001ah???????????????"), Byte.valueOf(cVar.getId())));
                }
                throw new FMCommunicationMessageException(String.format(f.a("???\u0011\u0003\u0018\u0007|\u000e\u000e??????????????????JZ_??????????????????", 352), Byte.valueOf(this.f27211c)));
            }
            throw new FMCommunicationMessageException(String.format(x2.a.b("???S\u001bJ\u001bv^\u0004??????????????????J\u0010C????????????", 4, 51), Byte.valueOf(this.f27211c)));
        } else {
            throw new FMCommunicationMessageException(String.format(h.e("???\u0006LO\u0018{\u0001I???????????????B0+??????", 218, 27), Byte.valueOf(this.f27211c)));
        }
    }

    @Override // f2.c
    public c[] j() throws FMCommunicationMessageException {
        return (c[]) this.f27214f.toArray(new c[0]);
    }

    @Override // f2.c
    public int k() throws FMCommunicationMessageException {
        return this.f27214f.size();
    }

    @Override // f2.c
    public c l(int i10) throws FMCommunicationMessageException {
        if (i10 >= 0 && i10 <= this.f27214f.size()) {
            return this.f27214f.get(i10);
        }
        throw new FMCommunicationMessageException(String.format(h.e("????????????\u0012>?\no\u001bA?????????Txu?????????????????????????????????", 5, 121), Byte.valueOf(this.f27211c)));
    }

    public int m(byte b10, byte[] bArr) throws FMCommunicationMessageException {
        this.f27211c = b10;
        this.f27216h = true;
        f n10 = this.f27215g.n(b10);
        this.f27217i = n10;
        if (n10 == null) {
            a aVar = this.f27209a;
            if (aVar != null) {
                aVar.c(this.f27210b, String.format(x2.a.b("???????????????????????????\u001cFA\u001ea[_", 1, 95), Byte.valueOf(b10)));
            }
            return -2;
        }
        this.f27213e = n10.e();
        int length = bArr.length;
        if (this.f27217i.c() == 0 || length <= this.f27217i.c()) {
            this.f27212d = bArr;
            if (ETagType.C == this.f27213e) {
                for (e.a aVar2 : f2.e.a().b(this.f27212d, 1)) {
                    d dVar = new d(this.f27215g);
                    dVar.m(aVar2.b()[0], aVar2.a());
                    if (dVar.b()) {
                        this.f27214f.add(dVar);
                    }
                }
            }
            return 0;
        }
        a aVar3 = this.f27209a;
        if (aVar3 != null) {
            aVar3.c(this.f27210b, String.format(f.a("_IBYz\u0004\u0004?????????????????????????????????????????????", 3), Byte.valueOf(b10)));
        }
        return -2;
    }

    public int n(byte[] bArr) {
        int i10;
        this.f27216h = true;
        if (bArr != null && bArr.length >= 2) {
            byte b10 = bArr[0];
            this.f27211c = b10;
            f n10 = this.f27215g.n(b10);
            this.f27217i = n10;
            if (n10 == null) {
                return -2;
            }
            this.f27213e = n10.e();
            int i11 = bArr[1] & 255;
            byte[] bArr2 = new byte[2];
            if (i11 == 255) {
                bArr2[0] = bArr[2];
                bArr2[1] = bArr[3];
                i11 = x2.c.e(bArr2);
                i10 = 4;
            } else {
                i10 = 2;
            }
            int i12 = i10 + i11;
            if (bArr.length < i12) {
                return -1;
            }
            if (this.f27217i.c() != 0 && i11 > this.f27217i.c()) {
                return -2;
            }
            if (i12 > bArr.length) {
                a aVar = this.f27209a;
                if (aVar == null) {
                    return -3;
                }
                aVar.c(this.f27210b, f.a("????????????Y", 6) + bArr.length + x2.c.i("\u0006??????????????????????????????\u0001", 4, 125) + String.format(g.a(2, 123, "w\u0015"), Integer.valueOf(i11)) + x2.b.b(2, "R:????????????????????????????????????R") + bArr.length + FM_Exception.insert(188, 11, "\u001d???"));
                return -3;
            }
            this.f27212d = Arrays.copyOfRange(bArr, i10, i12);
        }
        return -1;
    }
}
