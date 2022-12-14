package u2;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.script.ApduHandler;
import cn.com.fmsh.script.exception.FMScriptHandleException;
import cn.com.fmsh.tsm.business.bean.CardAppRecord;
import cn.com.fmsh.tsm.business.enums.EnumCardAppStatus;
import cn.com.fmsh.tsm.business.enums.EnumTradeType;
import cn.com.fmsh.tsm.business.exception.BusinessException;
import com.realsil.sdk.dfu.DfuException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import t2.a;
import x2.c;
import x2.d;
import x2.e;
import x2.f;
import x2.g;
import x2.h;
/* loaded from: classes.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    /* synthetic */ z2.a f35276a = z2.b.a().b();

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f35277b = b.class.getName();

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ ApduHandler f35278c;

    private final /* bridge */ /* synthetic */ EnumTradeType g(byte b10) {
        switch (b10) {
            case -125:
            case 34:
                return EnumTradeType.recharge;
            case -107:
            case -103:
            case 3:
                return EnumTradeType.onlineRecharge;
            case 1:
            case 5:
            case 9:
                return EnumTradeType.bus;
            case 6:
            case 7:
            case 17:
            case 52:
                return EnumTradeType.subwayConsumption;
            case 20:
                return EnumTradeType.subwayUpdate;
            case 32:
                return EnumTradeType.maglev;
            case 49:
                return EnumTradeType.ferry;
            case 65:
            case 66:
                return EnumTradeType.taxi;
            case 81:
                return EnumTradeType.expressway;
            case 82:
                return EnumTradeType.park;
            case 99:
                return EnumTradeType.gasStation;
            case 104:
                return EnumTradeType.onlineConsumption;
            default:
                return null;
        }
    }

    private final /* bridge */ /* synthetic */ EnumTradeType h(byte b10, byte b11) {
        EnumTradeType enumTradeType;
        switch (b10) {
            case -125:
            case 34:
                enumTradeType = EnumTradeType.recharge;
                break;
            case 1:
            case 5:
            case 17:
                enumTradeType = EnumTradeType.subwayConsumption;
                break;
            case 9:
                enumTradeType = EnumTradeType.bus;
                break;
            case 20:
                enumTradeType = EnumTradeType.subwayUpdate;
                break;
            case 32:
                enumTradeType = EnumTradeType.maglev;
                break;
            case 49:
                enumTradeType = EnumTradeType.ferry;
                break;
            case 65:
                enumTradeType = EnumTradeType.taxi;
                break;
            case 81:
                enumTradeType = EnumTradeType.expressway;
                break;
            case 82:
                enumTradeType = EnumTradeType.park;
                break;
            case 99:
                enumTradeType = EnumTradeType.gasStation;
                break;
            default:
                enumTradeType = null;
                break;
        }
        return enumTradeType == null ? b11 != 2 ? EnumTradeType.elseTrade : EnumTradeType.recharge : enumTradeType;
    }

    private final /* bridge */ /* synthetic */ byte[] i(byte[] bArr) throws BusinessException {
        try {
            byte[] d10 = this.f35278c.d(bArr);
            if (d10 != null && d10.length >= 2) {
                return d10;
            }
            z2.a aVar = this.f35276a;
            if (aVar != null) {
                aVar.c(this.f35277b, f.a("Kw`t????????????????????????", 2));
            }
            ApduHandler apduHandler = this.f35278c;
            if (apduHandler != null) {
                apduHandler.close();
            }
            throw new BusinessException(e.a(6, "\u001a.eq???????????????????????????"), BusinessException.ErrorMessage.local_business_execute_fail);
        } catch (FMScriptHandleException e10) {
            z2.a aVar2 = this.f35276a;
            if (aVar2 != null) {
                String str = this.f35277b;
                aVar2.c(str, c.i("\u001bz~\u007f????????????????????????", 3, 16) + h.f(e10));
            }
            ApduHandler apduHandler2 = this.f35278c;
            if (apduHandler2 != null) {
                apduHandler2.close();
            }
            throw new BusinessException(d.c("\u00199>>????????????????????????", 5), BusinessException.ErrorMessage.local_business_execute_fail);
        }
    }

    @Override // t2.a
    public void a(ApduHandler apduHandler) {
        this.f35278c = apduHandler;
    }

    @Override // t2.a
    public int b() throws BusinessException {
        if (this.f35276a == null) {
            this.f35276a = z2.b.a().b();
        }
        z2.a aVar = this.f35276a;
        if (aVar != null) {
            aVar.e(this.f35277b, e.a(DfuException.ERROR_SEND_COMMAND_REACH_MAX_RETRY_TIMES, "???????????????????????????<1,+"));
        }
        if (this.f35278c == null) {
            z2.a aVar2 = this.f35276a;
            if (aVar2 != null) {
                aVar2.c(this.f35277b, x2.a.b("??????????????????????????????It$i???????????????", 160, 92));
            }
            throw new BusinessException(f.a("?????????????????????????????????\r9\"6???????????????", 5), BusinessException.ErrorMessage.local_business_apdu_handler_null);
        }
        i(new byte[]{0, -92, 0, 0, 2, 63, 1});
        byte[] bArr = new byte[17];
        bArr[0] = Byte.MIN_VALUE;
        bArr[1] = 80;
        bArr[2] = 3;
        bArr[3] = 2;
        bArr[4] = 11;
        bArr[5] = 1;
        bArr[16] = 15;
        byte[] i10 = i(bArr);
        if (i10.length >= 9) {
            return c.e(Arrays.copyOf(i10, 4)) - c.e(new byte[]{i10[6], i10[7], i10[8]});
        }
        z2.a aVar3 = this.f35276a;
        if (aVar3 != null) {
            aVar3.c(this.f35277b, x2.a.b("?????????????????????????????????\u0003_\u0018\\?????????????????????", 3, 77));
        }
        throw new BusinessException(x2.a.b("???????????????????????????????????????????????????", 3, 56), BusinessException.ErrorMessage.local_get_app_info_fail);
    }

    @Override // t2.a
    public String c() throws BusinessException {
        byte[] i10 = i(new byte[]{0, -92, 0, 0, 2, 63, 1});
        if (!c.q(i10)) {
            z2.a aVar = this.f35276a;
            if (aVar != null) {
                String str = this.f35277b;
                aVar.b(str, x2.b.b(DfuException.ERROR_WRITE_CHARAC_NOTIFY_ERROR, "????????????????????????????????????????????????????????????") + c.c(i10));
            }
            throw new BusinessException(x2.a.b("?????????????????????????????????????????????????????????????????????", 74, 57), BusinessException.ErrorMessage.local_business_execute_fail);
        }
        byte[] i11 = i(new byte[]{0, -80, -107});
        if (!c.q(i11)) {
            z2.a aVar2 = this.f35276a;
            if (aVar2 != null) {
                String str2 = this.f35277b;
                aVar2.b(str2, x2.a.b("???????????????????????????????????????jk???????????????", 4, 99) + c.c(i11));
            }
            throw new BusinessException(g.a(178, 97, "???????????????????????????????????????>e????????????"), BusinessException.ErrorMessage.local_business_execute_fail);
        } else if (i11.length >= 29) {
            return c.c(new byte[]{i11[24], i11[25], i11[26], i11[27]});
        } else {
            z2.a aVar3 = this.f35276a;
            if (aVar3 != null) {
                String str3 = this.f35277b;
                aVar3.b(str3, x2.a.b("???????????????????????????????????????rm???????????????", 2, 117) + c.c(i11));
            }
            throw new BusinessException(f.a("???????????????????????????????????????sj????????????", 1), BusinessException.ErrorMessage.local_business_execute_fail);
        }
    }

    @Override // t2.a
    public byte[] d() throws BusinessException {
        byte[] bArr = new byte[8];
        z2.a aVar = this.f35276a;
        if (aVar != null) {
            aVar.e(this.f35277b, FM_Exception.insert(4, 62, "????????????????????????????????????p b$"));
        }
        String a10 = e.a(174, "????????????????????????????????????g");
        if (this.f35278c == null) {
            z2.a aVar2 = this.f35276a;
            if (aVar2 != null) {
                String str = this.f35277b;
                aVar2.c(str, String.valueOf(a10) + d.c("???Uu22???????????????", 304));
            }
            throw new BusinessException(String.valueOf(a10) + d.c("???Qq66???????????????", 300), BusinessException.ErrorMessage.local_business_apdu_handler_null);
        }
        byte[] i10 = i(new byte[]{0, -92, 0, 0, 2, 63, 1});
        if (!c.q(i10)) {
            z2.a aVar3 = this.f35276a;
            if (aVar3 != null) {
                String str2 = this.f35277b;
                aVar3.c(str2, String.valueOf(a10) + g.a(216, 7, "?????????\u001c\u0000\r????????????4") + c.c(i10));
            }
            throw new BusinessException(String.valueOf(a10) + c.i("?????????\u0007Y\u0012????????????", 330, 87), BusinessException.ErrorMessage.local_message_apdu_execute_exception);
        } else if (i10.length >= 42) {
            System.arraycopy(i10, 34, bArr, 0, 8);
            return bArr;
        } else {
            byte[] i11 = i(new byte[]{0, -80, -107});
            if (!c.q(i11)) {
                z2.a aVar4 = this.f35276a;
                if (aVar4 != null) {
                    String str3 = this.f35277b;
                    aVar4.c(str3, String.valueOf(a10) + x2.a.b("?????????w8??????????????????$", 1, 39) + c.c(i11));
                }
                throw new BusinessException(String.valueOf(a10) + h.e("????????? n??????????????????", 182, 42), BusinessException.ErrorMessage.local_message_apdu_execute_exception);
            } else if (i11.length < 20) {
                return null;
            } else {
                System.arraycopy(i11, 12, bArr, 0, 8);
                return bArr;
            }
        }
    }

    @Override // t2.a
    public List<CardAppRecord> e() throws BusinessException {
        ArrayList arrayList = new ArrayList();
        z2.a aVar = this.f35276a;
        if (aVar != null) {
            aVar.e(this.f35277b, x2.a.b("?????????????????????????????????#wak", 1, 118));
        }
        String i10 = c.i("?????????????????????????????????", 204, 84);
        if (this.f35278c == null) {
            z2.a aVar2 = this.f35276a;
            if (aVar2 != null) {
                aVar2.c(this.f35277b, String.valueOf(i10) + FM_Exception.insert(210, 92, "??????O:\"w???????????????"));
            }
            throw new BusinessException(String.valueOf(i10) + x2.b.b(4, "??????Fby=???????????????"), BusinessException.ErrorMessage.local_business_apdu_handler_null);
        }
        i(new byte[]{0, -92, 0, 0, 2, 63, 1});
        HashMap hashMap = new HashMap();
        i(new byte[]{0, -92, 0, 0, 2, 0, 7});
        for (int i11 = 1; i11 <= 10; i11++) {
            byte[] i12 = i(new byte[]{0, -78, (byte) i11, 4});
            if (Arrays.equals(new byte[]{106, -125}, Arrays.copyOfRange(i12, i12.length - 2, i12.length))) {
                break;
            }
            if (i12.length >= 16) {
                String k10 = k(Arrays.copyOfRange(i12, 10, 15));
                EnumTradeType g10 = g(i12[0]);
                if (!(k10 == null || g10 == null)) {
                    hashMap.put(k10, g10);
                }
            }
        }
        i(new byte[]{0, -92, 0, 0, 2, 0, 24});
        for (int i13 = 1; i13 <= 10; i13++) {
            byte[] i14 = i(new byte[]{0, -78, (byte) i13, 4});
            if (Arrays.equals(new byte[]{106, -125}, Arrays.copyOfRange(i14, i14.length - 2, i14.length))) {
                break;
            }
            if (i14.length >= 23) {
                arrayList.add(j(i14, hashMap));
            }
        }
        return arrayList;
    }

    @Override // t2.a
    public String f() throws BusinessException {
        if (this.f35276a == null) {
            this.f35276a = z2.b.a().b();
        }
        z2.a aVar = this.f35276a;
        if (aVar != null) {
            aVar.e(this.f35277b, h.e("??????????????????????????????,$fh", 3, 94));
        }
        String a10 = f.a("??????????????????????????????", 142);
        if (this.f35278c != null) {
            return s2.b.a(Arrays.copyOfRange(d(), 4, 8));
        }
        z2.a aVar2 = this.f35276a;
        if (aVar2 != null) {
            String str = this.f35277b;
            aVar2.c(str, String.valueOf(a10) + h.e("??????\u0012mcd???????????????", 2, 106));
        }
        throw new BusinessException(String.valueOf(a10) + FM_Exception.insert(236, 37, "??????[/`|???????????????"), BusinessException.ErrorMessage.local_business_apdu_handler_null);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0147  */
    @Override // t2.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public EnumCardAppStatus getStatus() throws BusinessException {
        boolean z10;
        boolean z11;
        Date date;
        byte[] d10;
        EnumCardAppStatus enumCardAppStatus = EnumCardAppStatus.STATUS_INSTALL;
        z2.a aVar = this.f35276a;
        if (aVar != null) {
            aVar.e(this.f35277b, g.a(4, 23, "????????????????????????????????????&18"));
        }
        String insert = FM_Exception.insert(5, 27, "????????????????????????????????????");
        ApduHandler apduHandler = this.f35278c;
        if (apduHandler == null) {
            z2.a aVar2 = this.f35276a;
            if (aVar2 != null) {
                aVar2.c(this.f35277b, String.valueOf(insert) + FM_Exception.insert(86, 55, "??????\t/r8???????????????"));
            }
            throw new BusinessException(String.valueOf(insert) + g.a(2, 1, "??????\u0015%2\"???????????????"), BusinessException.ErrorMessage.local_business_apdu_handler_null);
        }
        try {
            byte[] d11 = apduHandler.d(new byte[]{0, -80, -107});
            if (!c.q(d11)) {
                return enumCardAppStatus;
            }
            byte[] bArr = new byte[32];
            bArr[30] = -112;
            if (!Arrays.equals(bArr, d11)) {
                enumCardAppStatus = EnumCardAppStatus.STATUS_PERSONALIZED;
                byte[] bArr2 = new byte[8];
                new Random().nextBytes(bArr2);
                try {
                    d10 = this.f35278c.d(c.s(new byte[]{0, 10, -125, 4, 8}, bArr2));
                    z10 = false;
                } catch (FMScriptHandleException e10) {
                    z2.a aVar3 = this.f35276a;
                    if (aVar3 != null) {
                        aVar3.b(this.f35277b, String.valueOf(insert) + f.a("????????????;", 5) + h.f(e10));
                    }
                    z10 = true;
                }
                if (!z10 && c.q(d10) && d10.length >= 5) {
                    String c10 = c.c(Arrays.copyOfRange(d10, 1, 5));
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        date = new SimpleDateFormat(g.a(136, 39, "!f?4YV&m")).parse(c10);
                    } catch (ParseException unused) {
                        if (this.f35276a != null) {
                            this.f35276a.c(this.f35277b, String.valueOf(insert) + f.a("?????????????????????????????????v", 5) + c10);
                        }
                        date = null;
                    }
                    if (date != null) {
                        if (d10[0] != 0 && date.getTime() >= currentTimeMillis) {
                            return EnumCardAppStatus.STATUS_ACTIVATE;
                        }
                        z11 = false;
                        if (z11) {
                            byte[] bArr3 = new byte[16];
                            bArr3[0] = Byte.MIN_VALUE;
                            bArr3[1] = 80;
                            bArr3[3] = 2;
                            bArr3[4] = 11;
                            bArr3[5] = 1;
                            bArr3[8] = 7;
                            bArr3[9] = -48;
                            try {
                                if (!c.q(this.f35278c.d(bArr3))) {
                                    return enumCardAppStatus;
                                }
                                try {
                                    byte[] d12 = this.f35278c.d(c.m(g.a(2, 87, "jy5e~5lc:Cj?7i$<p!!r/ \u007fw#c\u000e&n|Fi")));
                                    if (c.p(d12, new byte[]{-109, 2}) || c.q(d12)) {
                                        return EnumCardAppStatus.STATUS_ACTIVATE;
                                    }
                                } catch (FMScriptHandleException e11) {
                                    z2.a aVar4 = this.f35276a;
                                    if (aVar4 != null) {
                                        aVar4.b(this.f35277b, String.valueOf(insert) + c.i("???????????????????????????`", 168, 35) + h.f(e11));
                                    }
                                    return enumCardAppStatus;
                                }
                            } catch (FMScriptHandleException e12) {
                                z2.a aVar5 = this.f35276a;
                                if (aVar5 != null) {
                                    aVar5.b(this.f35277b, String.valueOf(insert) + g.a(5, 65, "???????????????????????????$") + h.f(e12));
                                }
                            }
                        }
                    }
                }
                z11 = true;
                if (z11) {
                }
            }
            return enumCardAppStatus;
        } catch (FMScriptHandleException e13) {
            z2.a aVar6 = this.f35276a;
            if (aVar6 != null) {
                aVar6.b(this.f35277b, String.valueOf(insert) + h.e("????????????hf%'????????????r", 3, 94) + h.f(e13));
            }
            return enumCardAppStatus;
        }
    }

    public CardAppRecord j(byte[] bArr, Map<String, EnumTradeType> map) {
        CardAppRecord cardAppRecord = new CardAppRecord();
        cardAppRecord.setTradeNo(c.e(new byte[]{bArr[0], bArr[1]}));
        byte[] bArr2 = {bArr[16], bArr[17], bArr[18], bArr[19]};
        cardAppRecord.setTradeDate(c.c(bArr2));
        byte[] bArr3 = {bArr[20], bArr[21], bArr[22]};
        cardAppRecord.setTradeTime(c.c(bArr3));
        EnumTradeType enumTradeType = map.get(String.valueOf(c.c(bArr2)) + c.c(bArr3));
        cardAppRecord.setAmount(Integer.parseInt(c.c(new byte[]{bArr[5], bArr[6], bArr[7], bArr[8]}), 16));
        cardAppRecord.setBalance(c.e(new byte[]{bArr[2], bArr[3], bArr[4]}));
        cardAppRecord.setOriTradeType(bArr[12]);
        cardAppRecord.setOriTradeType(bArr[9]);
        if (enumTradeType == null) {
            enumTradeType = h(bArr[12], bArr[9]);
        }
        cardAppRecord.setTradeType(enumTradeType);
        cardAppRecord.setTradeDevice(c.c(new byte[]{bArr[10], bArr[11], bArr[12], bArr[13], bArr[14], bArr[15]}));
        return cardAppRecord;
    }

    public String k(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int e10 = c.e(new byte[]{bArr[0], bArr[1]}) >> 4;
        stringBuffer.append(String.valueOf(e10));
        System.out.println(c.i("j,~'] ;x&#", 188, 54) + e10);
        String valueOf = String.valueOf(bArr[1] & 15);
        if (valueOf.length() == 1) {
            valueOf = "0" + valueOf;
        }
        stringBuffer.append(valueOf);
        String valueOf2 = String.valueOf((bArr[2] & 248) >> 3);
        if (valueOf2.length() == 1) {
            valueOf2 = "0" + valueOf2;
        }
        stringBuffer.append(valueOf2);
        String valueOf3 = String.valueOf(c.e(new byte[]{(byte) (bArr[2] & 7), (byte) (bArr[3] & 192)}) >> 6);
        if (valueOf3.length() == 1) {
            valueOf3 = "0" + valueOf3;
        }
        stringBuffer.append(valueOf3);
        String valueOf4 = String.valueOf((int) ((byte) (bArr[3] & 63)));
        if (valueOf4.length() == 1) {
            valueOf4 = "0" + valueOf4;
        }
        stringBuffer.append(valueOf4);
        String valueOf5 = String.valueOf((bArr[4] & 252) >> 2);
        if (valueOf5.length() == 1) {
            valueOf5 = "0" + valueOf5;
        }
        stringBuffer.append(valueOf5);
        return stringBuffer.toString();
    }
}
