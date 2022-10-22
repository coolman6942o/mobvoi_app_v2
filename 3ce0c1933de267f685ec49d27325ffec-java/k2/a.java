package k2;

import cn.com.fmsh.tsm.business.bean.BusinessOrder;
import cn.com.fmsh.tsm.business.bean.CardAppRecord;
import cn.com.fmsh.tsm.business.bean.UserInfo;
import cn.com.fmsh.tsm.business.bean.c;
import cn.com.fmsh.tsm.business.bean.d;
import cn.com.fmsh.tsm.business.enums.EnumBusinessOrderType;
import cn.com.fmsh.tsm.business.enums.EnumCardAppStatus;
import cn.com.fmsh.tsm.business.enums.EnumCardAppType;
import cn.com.fmsh.tsm.business.enums.EnumOrderStatus;
import cn.com.fmsh.tsm.business.enums.EnumTerminalOpType;
import cn.com.fmsh.tsm.business.exception.BusinessException;
import java.util.List;
import r2.b;
/* compiled from: NfcosClientManagerImpl.java */
/* loaded from: classes.dex */
public class a implements i2.a {

    /* renamed from: d  reason: collision with root package name */
    private static final String f29714d = i2.a.class.getName();

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f29715e = {-96, 0, 0, 0, 3, -122, -104, 7, 1};

    /* renamed from: f  reason: collision with root package name */
    private static final byte[] f29716f = {89, 67, 84, 46, 85, 83, 69, 82};

    /* renamed from: g  reason: collision with root package name */
    private static final byte[] f29717g = {0, -92, 4, 0, 9};

    /* renamed from: a  reason: collision with root package name */
    private n2.a f29718a = null;

    /* renamed from: b  reason: collision with root package name */
    private r2.a f29719b;

    /* renamed from: c  reason: collision with root package name */
    private z2.a f29720c;

    public a() {
        this.f29719b = null;
        this.f29720c = null;
        r2.a b10 = b.b();
        this.f29719b = b10;
        b10.d(new j2.a(null, 1));
        this.f29719b.c(new byte[]{2, 1, (byte) EnumTerminalOpType.ANDROID.getId()});
        l2.a aVar = new l2.a();
        this.f29720c = aVar;
        aVar.d(true);
        z2.b.a().c(this.f29720c);
    }

    private byte[] v(EnumCardAppType enumCardAppType) {
        if (enumCardAppType == EnumCardAppType.CARD_APP_TYPE_LNT) {
            return (byte[]) f29716f.clone();
        }
        return (byte[]) f29715e.clone();
    }

    @Override // i2.a
    public int a(byte[] bArr, byte[] bArr2) throws BusinessException {
        return this.f29719b.e().a(bArr, bArr2);
    }

    @Override // i2.a
    public int b() throws BusinessException {
        return this.f29719b.e().b();
    }

    @Override // i2.a
    public Integer c(EnumCardAppType enumCardAppType) throws BusinessException {
        this.f29718a.e(v(enumCardAppType));
        return this.f29719b.e().c(enumCardAppType);
    }

    @Override // i2.a
    public cn.com.fmsh.tsm.business.bean.a d(byte[] bArr, EnumCardAppType enumCardAppType, byte[] bArr2, String str) throws BusinessException {
        this.f29720c.e(f29714d, "[调试接口]应用删除操作执行...");
        return this.f29719b.b().d(bArr, enumCardAppType, bArr2, str);
    }

    @Override // i2.a
    public d e(byte[] bArr) throws BusinessException {
        return this.f29719b.e().e(bArr);
    }

    @Override // i2.a
    public String f(byte[] bArr) throws BusinessException {
        return this.f29719b.e().f(bArr);
    }

    @Override // i2.a
    public byte[] g(EnumCardAppType enumCardAppType) throws BusinessException {
        this.f29718a.e(v(enumCardAppType));
        return this.f29719b.e().g(enumCardAppType);
    }

    @Override // i2.a
    public String h(EnumCardAppType enumCardAppType) throws BusinessException {
        this.f29718a.e(v(enumCardAppType));
        return this.f29719b.e().h(enumCardAppType);
    }

    @Override // i2.a
    public List<CardAppRecord> i(EnumCardAppType enumCardAppType) throws BusinessException {
        this.f29718a.e(v(enumCardAppType));
        return this.f29719b.e().i(enumCardAppType);
    }

    @Override // i2.a
    public List<BusinessOrder> j(int i10, int i11, EnumCardAppType enumCardAppType, EnumBusinessOrderType enumBusinessOrderType, List<EnumOrderStatus> list, byte[] bArr) throws BusinessException {
        return this.f29719b.e().n(i10, i11, enumCardAppType, enumBusinessOrderType, list, bArr);
    }

    @Override // i2.a
    public void k(n2.a aVar) {
        this.f29718a = aVar;
        this.f29719b.a(aVar);
    }

    @Override // i2.a
    public boolean l(byte[] bArr, String str, String str2, byte[] bArr2) throws BusinessException {
        return this.f29719b.b().a(str2, bArr, str, bArr2);
    }

    @Override // i2.a
    public c m(String str, String str2) throws BusinessException {
        return this.f29719b.e().o(str, str2);
    }

    @Override // i2.a
    public d n(int i10, int i11, byte[] bArr, EnumCardAppType enumCardAppType) throws BusinessException {
        return this.f29719b.e().m(i10, i11, bArr, enumCardAppType);
    }

    @Override // i2.a
    public int o(String str, String str2) throws BusinessException {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(str);
        userInfo.setPassword(str2);
        userInfo.setUserType(2);
        return this.f29719b.e().k(userInfo);
    }

    @Override // i2.a
    public boolean p(byte[] bArr, byte[] bArr2) throws BusinessException {
        return this.f29719b.b().b(bArr, 1, bArr2, null);
    }

    @Override // i2.a
    public String q(EnumCardAppType enumCardAppType) throws BusinessException {
        this.f29718a.e(v(enumCardAppType));
        return this.f29719b.e().j(enumCardAppType);
    }

    @Override // i2.a
    public boolean r(byte[] bArr, byte[] bArr2) throws BusinessException {
        return this.f29719b.e().l(bArr, bArr2);
    }

    @Override // i2.a
    public d s(EnumCardAppType enumCardAppType, int i10, byte[] bArr, int i11, String str, byte[] bArr2) throws BusinessException {
        byte[] j10 = x2.c.j(m2.a.a((byte) 2, x2.c.n(i11, 4)), m2.a.a((byte) 1, x2.c.n(i10, 4)), m2.a.a((byte) 3, bArr), m2.a.a((byte) 5, str.getBytes()));
        z2.a aVar = this.f29720c;
        String str2 = f29714d;
        aVar.e(str2, "附加信息:" + x2.c.c(j10));
        return this.f29719b.e().d(bArr2, enumCardAppType, j10);
    }

    @Override // i2.a
    public EnumCardAppStatus t(EnumCardAppType enumCardAppType) throws BusinessException {
        n2.a aVar = this.f29718a;
        if (aVar == null) {
            throw new BusinessException("ApduExternalHandler通信适配不能正常连接", BusinessException.ErrorMessage.local_business_apdu_handler_null);
        } else if (!aVar.c()) {
            EnumCardAppStatus enumCardAppStatus = EnumCardAppStatus.STATUS_NO_APP;
            byte[] v10 = v(enumCardAppType);
            if (this.f29718a.b()) {
                try {
                    byte[] bArr = (byte[]) f29717g.clone();
                    bArr[4] = (byte) (v10.length & 255);
                    if (x2.c.q(this.f29718a.d(x2.c.j(bArr, v10)))) {
                        EnumCardAppStatus enumCardAppStatus2 = EnumCardAppStatus.STATUS_INSTALL;
                        this.f29718a.e(v10);
                        t2.a a10 = s2.a.b().a(enumCardAppType);
                        a10.a(this.f29718a);
                        enumCardAppStatus = a10.getStatus();
                    }
                    return enumCardAppStatus;
                } finally {
                    this.f29718a.close();
                }
            } else {
                throw new BusinessException("ApduExternalHandler通信适配不能正常连接", BusinessException.ErrorMessage.business_1920_unknow);
            }
        } else {
            throw new BusinessException("ApduExternalHandler正在忙", BusinessException.ErrorMessage.local_business_apdu_handler_busying);
        }
    }

    @Override // i2.a
    public List<BusinessOrder> u(int i10, int i11, EnumCardAppType enumCardAppType, EnumBusinessOrderType enumBusinessOrderType, List<EnumOrderStatus> list) throws BusinessException {
        return j(i10, i11, enumCardAppType, enumBusinessOrderType, list, null);
    }
}
