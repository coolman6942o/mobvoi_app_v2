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
import x2.d;
import x2.e;
import x2.f;
import x2.g;
import x2.h;
import z2.b;
/* loaded from: classes.dex */
public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    /* synthetic */ z2.a f35279a = b.a().b();

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f35280b = c.class.getName();

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ byte[] f35281c = {32};

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ ApduHandler f35282d;

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
            byte[] d10 = this.f35282d.d(bArr);
            if (d10 != null && d10.length >= 2) {
                return d10;
            }
            z2.a aVar = this.f35279a;
            if (aVar != null) {
                aVar.c(this.f35280b, x2.a.b("\u0012,a{挐令扮衞终柘乷稬", 3, 9));
            }
            ApduHandler apduHandler = this.f35282d;
            if (apduHandler != null) {
                apduHandler.close();
            }
            throw new BusinessException(d.c("\u00102wq夑琀嘿奌瑟纙枇旬敕", 94), BusinessException.ErrorMessage.local_business_execute_fail);
        } catch (FMScriptHandleException e10) {
            z2.a aVar2 = this.f35279a;
            if (aVar2 != null) {
                String str = this.f35280b;
                aVar2.c(str, f.a("Jxaw捘亸戾蠚冩珠彏干", 3) + h.f(e10));
            }
            ApduHandler apduHandler2 = this.f35282d;
            if (apduHandler2 != null) {
                apduHandler2.close();
            }
            throw new BusinessException(f.a("\u0001->\"捓亵戩蠇冲珵彀帧", 344), BusinessException.ErrorMessage.local_business_execute_fail);
        }
    }

    private final /* bridge */ /* synthetic */ byte[] j(byte[] bArr) {
        if (bArr == null || bArr.length < 1) {
            return null;
        }
        String c10 = x2.c.c(bArr);
        int indexOf = c10.indexOf(FM_Exception.insert(3, 103, ">\be_2O"));
        if (indexOf < 0) {
            z2.a aVar = this.f35279a;
            if (aVar != null) {
                aVar.b(this.f35280b, e.a(134, "h\u001815绔枖莺叆埝帔缏砝央货）哅废绝枍丙匒吱$\u0006s\u0005"));
            }
            return null;
        }
        byte[] m10 = x2.c.m(c10.substring(indexOf));
        return new byte[]{m10[13], m10[14]};
    }

    @Override // t2.a
    public void a(ApduHandler apduHandler) {
        this.f35282d = apduHandler;
    }

    @Override // t2.a
    public int b() throws BusinessException {
        if (this.f35279a == null) {
            this.f35279a = b.a().b();
        }
        z2.a aVar = this.f35279a;
        if (aVar != null) {
            aVar.e(this.f35280b, e.a(48, "VX_M1v{{s#&fgba"));
        }
        if (this.f35282d == null) {
            z2.a aVar2 = this.f35279a;
            if (aVar2 != null) {
                aVar2.c(this.f35280b, x2.a.b("菢叅亵違匬佒颔斱ｉBq{(奟琟噿乯稩", 5, 30));
            }
            throw new BusinessException(FM_Exception.insert(316, 114, "菷叄亠逌卩伃飑斨｜\u0003dbm夎瑚嘦乺稨"), BusinessException.ErrorMessage.local_business_apdu_handler_null);
        }
        byte[] j10 = j(i(new byte[]{0, -92, 0, 0, 2, 63, 1}));
        if (j10 == null || !Arrays.equals(j10, this.f35281c)) {
            throw new BusinessException(FM_Exception.insert(3, 125, "莰叒亥遄区企飈斤ｃ忉奍瑀盇匡乐晵九洣仵達匪"), BusinessException.ErrorMessage.local_get_app_info_no_sptcc);
        }
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
            return x2.c.e(Arrays.copyOf(i10, 4)) - x2.c.e(new byte[]{i10[6], i10[7], i10[8]});
        }
        z2.a aVar3 = this.f35279a;
        if (aVar3 != null) {
            aVar3.c(this.f35280b, d.c("莸取亵逘匲伝飈新；IIN\u000e咁廉益敯捾旡敚", 188));
        }
        throw new BusinessException(h.e("菸厊仭逌卢佉飀於｛咉庅敮捥斸攍", 242, 109), BusinessException.ErrorMessage.local_get_app_info_fail);
    }

    @Override // t2.a
    public String c() throws BusinessException {
        byte[] i10 = i(new byte[]{0, -92, 0, 0, 2, 63, 1});
        if (!x2.c.q(i10)) {
            z2.a aVar = this.f35279a;
            if (aVar != null) {
                String str = this.f35280b;
                aVar.b(str, FM_Exception.insert(4, 41, "莿叇医三庘畽杗敏杏斯．遂抽庉畮皡彍奰赯）") + x2.c.c(i10));
            }
            throw new BusinessException(x2.b.b(2, "莸双卤业序畮杘攔杘斤ｑ送拺床甡盺彊捍亱奄瑍奧贤"), BusinessException.ErrorMessage.local_business_execute_fail);
        }
        byte[] j10 = j(i10);
        if (j10 == null || !Arrays.equals(j10, this.f35281c)) {
            throw new BusinessException(g.a(192, 2, "莧叄亰逌卹佃颁旨ｌ忇奀瑀盌匫乁晡乚津仰遌匹"), BusinessException.ErrorMessage.local_get_app_info_no_sptcc);
        }
        byte[] i11 = i(new byte[]{0, -80, -107});
        if (!x2.c.q(i11)) {
            z2.a aVar2 = this.f35279a;
            if (aVar2 != null) {
                String str2 = this.f35280b;
                aVar2.b(str2, h.e("莶叏匰七廕由杘敁杞斯＝讲受h$旎价夨赴３", 4, 56) + x2.c.c(i11));
            }
            throw new BusinessException(x2.a.b("菢叞卺丄廕畼李攒朒时？讽厏}j斕仳天赮", 5, 19), BusinessException.ErrorMessage.local_business_execute_fail);
        } else if (i11.length >= 29) {
            return x2.c.c(new byte[]{i11[24], i11[25], i11[26], i11[27]});
        } else {
            z2.a aVar3 = this.f35279a;
            if (aVar3 != null) {
                String str3 = this.f35280b;
                aVar3.b(str3, f.a("莼叞卤丈廋畴材攞杌斦ａ讱厑ut旙亭奩走ｈ", 3) + x2.c.c(i11));
            }
            throw new BusinessException(x2.a.b("菥厒卷乂庎甤杗敘朝斢＊讣厜-{旇令奵贳", 2, 82), BusinessException.ErrorMessage.local_business_execute_fail);
        }
    }

    @Override // t2.a
    public byte[] d() throws BusinessException {
        byte[] bArr = new byte[8];
        z2.a aVar = this.f35279a;
        if (aVar != null) {
            aVar.e(this.f35280b, h.e("Q[@^&NH\u0011j\u001d\u0013e`y.", 5, 9));
        }
        if (this.f35282d == null) {
            z2.a aVar2 = this.f35279a;
            if (aVar2 != null) {
                aVar2.c(this.f35280b, g.a(5, 33, "也浡亳遂匸皞序畴廒刉叨ｌ@r'1夁琀嘯乲穳"));
            }
            throw new BusinessException(e.a(158, "丙浡亽逆卾皆庑甠庄则另８Vjy5奇瑀嘡乶稵"), BusinessException.ErrorMessage.local_business_apdu_handler_null);
        }
        byte[] i10 = i(new byte[]{0, -92, 0, 0, 2, 63, 1});
        byte[] j10 = j(i10);
        if (j10 == null || !Arrays.equals(j10, this.f35281c)) {
            throw new BusinessException(d.c("菡厑乒派其亯卽皉匿厸斶｝忇夗琂皑卧乚晧乓洽亿逖卼", 3), BusinessException.ErrorMessage.local_get_app_info_no_sptcc);
        } else if (!x2.c.q(i10)) {
            z2.a aVar3 = this.f35279a;
            if (aVar3 != null) {
                String str = this.f35280b;
                aVar3.c(str, d.c("菠厞乓洽具亨卼皊匾厧斷～遊拽DRA房蠅彘平&", 4) + x2.c.c(i10));
            }
            throw new BusinessException(f.a("莻叟丌浴公仹医盓匵厦斸ｇ遁抬\u0003\u001b\u001a戾蠚彑幨", 4), BusinessException.ErrorMessage.local_message_apdu_execute_exception);
        } else if (i10.length >= 42) {
            System.arraycopy(i10, 34, bArr, 0, 8);
            return bArr;
        } else {
            byte[] i11 = i(new byte[]{0, -80, -107});
            if (!x2.c.q(i11)) {
                z2.a aVar4 = this.f35279a;
                if (aVar4 != null) {
                    String str2 = this.f35280b;
                    aVar4.c(str2, g.a(4, 74, "菣又丂津兰仢危盞匥叹斮．遅拿1\u007f斓亨哅廆弞帾j") + x2.c.c(i11));
                }
                throw new BusinessException(x2.c.i("菮參丛洺儥亡占皙匸厢旧！遀抬0(斞亣咜庙弋幽", 2, 28), BusinessException.ErrorMessage.local_message_apdu_execute_exception);
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
        z2.a aVar = this.f35279a;
        if (aVar != null) {
            aVar.e(this.f35280b, x2.a.b("\u0013I\u0006\b$<&\u007f(3\u007fp#7z$p',u", 208, 89));
        }
        char c10 = 3;
        if (this.f35282d == null) {
            z2.a aVar2 = this.f35279a;
            if (aVar2 != null) {
                aVar2.c(this.f35280b, FM_Exception.insert(3, 105, "莰历份晑讻彁斫ｊ\u000ehe\u007f套瑚嘭临穭"));
            }
            throw new BusinessException(x2.a.b("菦厘亯昛诵弗早ｐ\u0018fw%奉琌噯乾稻", 1, 93), BusinessException.ErrorMessage.local_business_apdu_handler_null);
        }
        byte[] j10 = j(i(new byte[]{0, -92, 0, 0, 2, 63, 1}));
        if (j10 == null || !Arrays.equals(j10, this.f35281c)) {
            throw new BusinessException(f.a("莼叞丏浵儳仸匸盒价晃诽弟斱ｈ忄奚瑝盜匴也晠乆派仢遙匡", 3), BusinessException.ErrorMessage.local_get_app_info_no_sptcc);
        }
        HashMap hashMap = new HashMap();
        i(new byte[]{0, -92, 0, 0, 2, 0, 7});
        int i10 = 1;
        while (i10 <= 10) {
            byte[] bArr = new byte[5];
            bArr[1] = -78;
            bArr[2] = (byte) i10;
            bArr[c10] = 4;
            byte[] i11 = i(bArr);
            if (Arrays.equals(new byte[]{106, -125}, Arrays.copyOfRange(i11, i11.length - 2, i11.length))) {
                break;
            }
            if (i11.length >= 16) {
                String l10 = l(Arrays.copyOfRange(i11, 10, 15));
                EnumTradeType g10 = g(i11[0]);
                if (!(l10 == null || g10 == null)) {
                    hashMap.put(l10, g10);
                }
            }
            i10++;
            c10 = 3;
        }
        i(new byte[]{0, -92, 0, 0, 2, 0, 24});
        for (int i12 = 1; i12 <= 10; i12++) {
            byte[] i13 = i(new byte[]{0, -78, (byte) i12, 4});
            if (Arrays.equals(new byte[]{106, -125}, Arrays.copyOfRange(i13, i13.length - 2, i13.length))) {
                break;
            }
            if (i13.length >= 23) {
                arrayList.add(k(i13, hashMap));
            }
        }
        return arrayList;
    }

    @Override // t2.a
    public String f() throws BusinessException {
        if (this.f35279a == null) {
            this.f35279a = b.a().b();
        }
        z2.a aVar = this.f35279a;
        if (aVar != null) {
            aVar.e(this.f35280b, h.e("R\u000fIXy1tp4ocdii+-", 4, 94));
        }
        if (this.f35282d != null) {
            return s2.b.a(Arrays.copyOfRange(d(), 4, 8));
        }
        z2.a aVar2 = this.f35279a;
        if (aVar2 != null) {
            aVar2.c(this.f35280b, e.a(3, "華厍匿靣右旱＆L`wc夝琚噷丸穿"));
        }
        throw new BusinessException(x2.c.i("菭反卽霿厩早ｌ\u0000rg1奁琀噯乲稳", 3, 33), BusinessException.ErrorMessage.local_business_apdu_handler_null);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x010d  */
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
        z2.a aVar = this.f35279a;
        if (aVar != null) {
            aVar.e(this.f35280b, x2.a.b("菤厝弐刖厂蠇狵怚=%-", 3, 120));
        }
        ApduHandler apduHandler = this.f35282d;
        if (apduHandler == null) {
            z2.a aVar2 = this.f35279a;
            if (aVar2 != null) {
                aVar2.c(this.f35280b, h.e("菨厕匦丁庛畻弄剖犩怂斱ｇNc3.夛琅噯乱稵", 2, 100));
            }
            throw new BusinessException(f.a("莼叞卤丈廋畴弊创狥恑斻ｆ\u00064%+奟瑞嘽乨稵", 3), BusinessException.ErrorMessage.local_business_apdu_handler_null);
        }
        try {
            byte[] d11 = apduHandler.d(new byte[]{0, -80, -107});
            if (!x2.c.q(d11)) {
                return enumCardAppStatus;
            }
            byte[] bArr = new byte[32];
            bArr[30] = -112;
            if (!Arrays.equals(bArr, d11)) {
                enumCardAppStatus = EnumCardAppStatus.STATUS_PERSONALIZED;
                byte[] bArr2 = new byte[8];
                new Random().nextBytes(bArr2);
                try {
                    d10 = this.f35282d.d(x2.c.s(new byte[]{0, 10, -125, 4, 8}, bArr2));
                    z10 = false;
                } catch (FMScriptHandleException e10) {
                    z2.a aVar3 = this.f35279a;
                    if (aVar3 != null) {
                        aVar3.b(this.f35280b, d.c("剼旤晵呭圔孕锟宕时｝彀幫~", 5) + h.f(e10));
                    }
                    z10 = true;
                }
                if (!z10 && x2.c.q(d10) && d10.length >= 5) {
                    String c10 = x2.c.c(Arrays.copyOfRange(d10, 1, 5));
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        date = new SimpleDateFormat(d.c("/>!0WFxi", 3)).parse(c10);
                    } catch (ParseException unused) {
                        if (this.f35279a != null) {
                            this.f35279a.c(this.f35280b, x2.a.b("菤叜淉贡勐胻锜寎犽恃旯｜莰又监早杜栦彞弊帧l", 3, 55) + c10);
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
                                if (!x2.c.q(this.f35282d.d(bArr3))) {
                                    return enumCardAppStatus;
                                }
                                try {
                                    byte[] d12 = this.f35282d.d(x2.c.m(x2.c.i(";{f)3;cksI!kr\u007f#,1sb.2>`oz9Ub{zQ)", 140, 104)));
                                    if (x2.c.p(d12, new byte[]{-109, 2}) || x2.c.q(d12)) {
                                        return EnumCardAppStatus.STATUS_ACTIVATE;
                                    }
                                } catch (FMScriptHandleException e11) {
                                    z2.a aVar4 = this.f35279a;
                                    if (aVar4 != null) {
                                        aVar4.b(this.f35280b, x2.a.b("剷旯匰景吩弞逗斪ｇ坒嬑刅姌匀头赱y", 3, 111) + h.f(e11));
                                    }
                                    return enumCardAppStatus;
                                }
                            } catch (FMScriptHandleException e12) {
                                z2.a aVar5 = this.f35279a;
                                if (aVar5 != null) {
                                    aVar5.b(this.f35280b, e.a(2, "剳旷匼是吥弆逓旺＃圚孍刅姐匈夰贡=") + h.f(e12));
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
            z2.a aVar6 = this.f35279a;
            if (aVar6 != null) {
                aVar6.b(this.f35280b, h.e("莦叐卺乚廑畲彜剉犯恏斵ｔ诶叔'|pc斌件夤赯e", DfuException.ERROR_REQUEST_MTU_NO_CALLBACK, 21) + h.f(e13));
            }
            return enumCardAppStatus;
        }
    }

    public CardAppRecord k(byte[] bArr, Map<String, EnumTradeType> map) {
        CardAppRecord cardAppRecord = new CardAppRecord();
        cardAppRecord.setTradeNo(x2.c.e(new byte[]{bArr[0], bArr[1]}));
        byte[] bArr2 = {bArr[16], bArr[17], bArr[18], bArr[19]};
        cardAppRecord.setTradeDate(x2.c.c(bArr2));
        byte[] bArr3 = {bArr[20], bArr[21], bArr[22]};
        cardAppRecord.setTradeTime(x2.c.c(bArr3));
        cardAppRecord.setAmount(Integer.parseInt(x2.c.c(new byte[]{bArr[5], bArr[6], bArr[7], bArr[8]}), 16));
        cardAppRecord.setBalance(x2.c.e(new byte[]{bArr[2], bArr[3], bArr[4]}));
        cardAppRecord.setOriTradeType(bArr[12]);
        cardAppRecord.setOriTradeType(bArr[9]);
        EnumTradeType enumTradeType = map.get(String.valueOf(x2.c.c(bArr2)) + x2.c.c(bArr3));
        EnumTradeType h10 = h(bArr[12], bArr[9]);
        if (h10 != null) {
            cardAppRecord.setTradeType(h10);
        } else {
            cardAppRecord.setTradeType(enumTradeType);
        }
        cardAppRecord.setTradeDevice(x2.c.c(new byte[]{bArr[10], bArr[11], bArr[12], bArr[13], bArr[14], bArr[15]}));
        return cardAppRecord;
    }

    public String l(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.valueOf(x2.c.e(new byte[]{bArr[0], bArr[1]}) >> 4));
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
        String valueOf3 = String.valueOf(x2.c.e(new byte[]{(byte) (bArr[2] & 7), (byte) (bArr[3] & 192)}) >> 6);
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
