package u2;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.script.ApduHandler;
import cn.com.fmsh.script.exception.FMScriptHandleException;
import cn.com.fmsh.tsm.business.bean.CardAppRecord;
import cn.com.fmsh.tsm.business.enums.EnumCardAppStatus;
import cn.com.fmsh.tsm.business.enums.EnumTradeType;
import cn.com.fmsh.tsm.business.exception.BusinessException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import x2.c;
import x2.d;
import x2.e;
import x2.f;
import x2.g;
import x2.h;
import z2.b;
/* loaded from: classes.dex */
public class a implements t2.a {

    /* renamed from: a  reason: collision with root package name */
    /* synthetic */ z2.a f35273a = b.a().b();

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f35274b = a.class.getName();

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ ApduHandler f35275c;

    private final /* bridge */ /* synthetic */ EnumTradeType g(byte b10) {
        if (b10 == 2) {
            return EnumTradeType.recharge;
        }
        if (b10 == 6) {
            return EnumTradeType.Consumption;
        }
        if (b10 != 9) {
            return null;
        }
        return EnumTradeType.CompositeConsumption;
    }

    private final /* bridge */ /* synthetic */ byte[] h(byte[] bArr) throws BusinessException {
        try {
            byte[] d10 = this.f35275c.d(bArr);
            if (d10 != null && d10.length >= 2) {
                return d10;
            }
            z2.a aVar = this.f35273a;
            if (aVar != null) {
                aVar.c(this.f35274b, f.a("Kw`t捙亿房蠙纁染乶稳", 130));
            }
            ApduHandler apduHandler = this.f35275c;
            if (apduHandler != null) {
                apduHandler.close();
            }
            throw new BusinessException(e.a(126, "\u0012&=)奛琄噭夌琍绝枍旴敟"), BusinessException.ErrorMessage.local_business_execute_fail);
        } catch (FMScriptHandleException e10) {
            z2.a aVar2 = this.f35273a;
            if (aVar2 != null) {
                String str = this.f35274b;
                aVar2.c(str, FM_Exception.insert(3, 86, "F-w|捘仱扬蠍凭玽彁帡") + h.f(e10));
            }
            ApduHandler apduHandler2 = this.f35275c;
            if (apduHandler2 != null) {
                apduHandler2.close();
            }
            throw new BusinessException(g.a(4, 35, "\u0015g~(指仧戡蠅凶玿彐幭"), BusinessException.ErrorMessage.local_business_execute_fail);
        }
    }

    @Override // t2.a
    public void a(ApduHandler apduHandler) {
        this.f35275c = apduHandler;
    }

    @Override // t2.a
    public int b() throws BusinessException {
        if (this.f35273a == null) {
            this.f35273a = b.a().b();
        }
        z2.a aVar = this.f35273a;
        if (aVar != null) {
            aVar.a(this.f35274b, g.a(208, 8, "\f\u0006\u0004x1=5*yJqtafs}nf~"));
        }
        if (this.f35275c == null) {
            z2.a aVar2 = this.f35273a;
            if (aVar2 != null) {
                aVar2.c(this.f35274b, FM_Exception.insert(154, 86, "莩厂仮通匷伕颟斮ｂE*4s奘瑔噠乤種"));
            }
            throw new BusinessException(c.i("莴又份過卮体飘斶ｗWa(2夆琛噰乩稴", 172, 27), BusinessException.ErrorMessage.local_business_apdu_handler_null);
        }
        h(new byte[]{0, -92, 0, 0, 2, -35, -15});
        h(new byte[]{0, -92, 0, 0, 2, -83, -13});
        byte[] bArr = new byte[17];
        bArr[0] = Byte.MIN_VALUE;
        bArr[1] = 80;
        bArr[2] = 3;
        bArr[3] = 2;
        bArr[4] = 11;
        bArr[5] = 1;
        bArr[16] = 15;
        byte[] h10 = h(bArr);
        if (h10.length >= 9) {
            return c.e(Arrays.copyOf(h10, 4)) - c.e(new byte[]{h10[6], h10[7], h10[8]});
        }
        z2.a aVar3 = this.f35273a;
        if (aVar3 != null) {
            aVar3.c(this.f35274b, c.i("菠厁亳逍匶伎颊旡｛\u0016GS\u0002咚広皓攧挹旷敟", 224, 32));
        }
        throw new BusinessException(f.a("莺叜亣逞占伇飆斮ｙ咟廛攼挧斦攋", 5), BusinessException.ErrorMessage.local_get_app_info_fail);
    }

    @Override // t2.a
    public String c() throws BusinessException {
        byte[] h10 = h(new byte[]{0, -92, 0, 0, 2, -35, -15});
        if (!c.q(h10)) {
            z2.a aVar = this.f35273a;
            if (aVar != null) {
                String str = this.f35274b;
                aVar.b(str, FM_Exception.insert(3, 19, "莰双卬乊廇畮材敄最旤ｉ遑抢廊甹盪彂奻赸ｊ") + c.c(h10));
            }
            throw new BusinessException(d.c("菠厞匸乀序甤朔敆杀斦ｍ遛抪庀甭相归损亭奞瑍夭质", 4), BusinessException.ErrorMessage.local_business_execute_fail);
        }
        byte[] h11 = h(new byte[]{0, -80, -107});
        if (!c.q(h11)) {
            z2.a aVar2 = this.f35273a;
            if (aVar2 != null) {
                String str2 = this.f35274b;
                aVar2.b(str2, x2.b.b(5, "莥友卩丙床畡杝攗杕斣，诰叀09斐亴奼赽ｙ") + c.c(h11));
            }
            throw new BusinessException(d.c("菢厐匶乂庍產朒敄杂斸ｓ讫厗#6斓仳奧赢", 2), BusinessException.ErrorMessage.local_business_execute_fail);
        } else if (h11.length >= 31) {
            return c.c(new byte[]{h11[27], h11[28], h11[29], h11[30]});
        } else {
            z2.a aVar3 = this.f35273a;
            if (aVar3 != null) {
                String str3 = this.f35274b;
                aVar3.b(str3, FM_Exception.insert(1, 48, "莲參匤丟廑畽朌攝朚旣ｉ诮厓d0旒仳夤赠／") + c.c(h11));
            }
            throw new BusinessException(x2.b.b(2, "莸双卤业序畮杘攔杘斤ｑ诳叅/<斓仩奻走"), BusinessException.ErrorMessage.local_business_execute_fail);
        }
    }

    @Override // t2.a
    public byte[] d() throws BusinessException {
        if (this.f35273a == null) {
            this.f35273a = b.a().b();
        }
        z2.a aVar = this.f35273a;
        if (aVar != null) {
            aVar.a(this.f35274b, g.a(5, 81, "\u0019\bCh~o/M->Q?o<m"));
        }
        if (this.f35275c == null) {
            z2.a aVar2 = this.f35273a;
            if (aVar2 != null) {
                aVar2.c(this.f35274b, e.a(202, "丕洵仡遒匪益廅畼廘前厪ｌ\u00026-9奋瑔嘽乢稡"));
            }
            throw new BusinessException(d.c("乕洧以逈卢皐庑畾廈剏厾６Jli+奋瑆嘹乸穩", 236), BusinessException.ErrorMessage.local_business_apdu_handler_null);
        }
        byte[] h10 = h(new byte[]{-60, -2});
        if (c.q(h10)) {
            return Arrays.copyOfRange(h10, 0, 8);
        }
        return null;
    }

    @Override // t2.a
    public List<CardAppRecord> e() throws BusinessException {
        if (this.f35273a == null) {
            this.f35273a = b.a().b();
        }
        ArrayList arrayList = new ArrayList();
        z2.a aVar = this.f35273a;
        if (aVar != null) {
            aVar.a(this.f35274b, g.a(5, 5, "\u0019\u0014\u000b${kr|\\rw^tut2!9azw"));
        }
        if (this.f35275c == null) {
            z2.a aVar2 = this.f35273a;
            if (aVar2 != null) {
                aVar2.c(this.f35274b, h.e("菨叒亭昝讣彍旫．F|uc够瑆嘭买稵", 2, 5));
            }
            throw new BusinessException(e.a(5, "菭压交昐讶彜旺＃Se|n多琇噬丽穰"), BusinessException.ErrorMessage.local_business_apdu_handler_null);
        }
        h(new byte[]{0, -92, 0, 0, 2, -35, -15});
        h(new byte[]{0, -92, 0, 0, 2, -83, -13});
        h(new byte[]{0, -92, 0, 0, 2, 0, 24});
        for (int i10 = 1; i10 <= 10; i10++) {
            byte[] h10 = h(new byte[]{0, -78, (byte) i10, 4});
            if (Arrays.equals(new byte[]{106, -125}, Arrays.copyOfRange(h10, h10.length - 2, h10.length))) {
                break;
            }
            if (h10.length >= 23) {
                arrayList.add(i(h10));
            }
        }
        return arrayList;
    }

    @Override // t2.a
    public String f() throws BusinessException {
        return c.c(d());
    }

    @Override // t2.a
    public EnumCardAppStatus getStatus() throws BusinessException {
        EnumCardAppStatus enumCardAppStatus = EnumCardAppStatus.STATUS_INSTALL;
        ApduHandler apduHandler = this.f35275c;
        if (apduHandler == null) {
            z2.a aVar = this.f35273a;
            if (aVar != null) {
                aVar.c(this.f35274b, x2.b.b(312, "菲历区乌廅畴彔剟犫怉日２\b$;?契理噣丬穻"));
            }
            throw new BusinessException(c.i("華厍卿下庐畯弙剀犦恒斠５]/&0夌琍嘦乫穮", 1, 99), BusinessException.ErrorMessage.local_business_apdu_handler_null);
        }
        try {
            if (!c.q(apduHandler.d(new byte[]{0, -92, 0, 0, 2, -35, -15}))) {
                return enumCardAppStatus;
            }
            try {
                if (!c.q(this.f35275c.d(new byte[]{0, -92, 0, 0, 2, -83, -13}))) {
                    return enumCardAppStatus;
                }
                byte[] bArr = new byte[5];
                bArr[1] = 10;
                try {
                    byte[] d10 = this.f35275c.d(bArr);
                    if (!c.q(d10)) {
                        return enumCardAppStatus;
                    }
                    if (d10.length < 5) {
                        z2.a aVar2 = this.f35273a;
                        if (aVar2 != null) {
                            aVar2.b(this.f35274b, c.i("菮収匶东廁甼开剟狧怑方＂乧亶卝给柕挏亣哋廑旤攋", 2, 63));
                        }
                        return enumCardAppStatus;
                    }
                    if (2 == d10[2]) {
                        enumCardAppStatus = EnumCardAppStatus.STATUS_PERSONALIZED;
                        byte[] bArr2 = new byte[16];
                        bArr2[0] = Byte.MIN_VALUE;
                        bArr2[1] = 80;
                        bArr2[2] = 1;
                        bArr2[3] = 2;
                        bArr2[4] = 11;
                        bArr2[5] = 2;
                        try {
                            return !c.q(this.f35275c.d(bArr2)) ? enumCardAppStatus : EnumCardAppStatus.STATUS_ACTIVATE;
                        } catch (FMScriptHandleException e10) {
                            z2.a aVar3 = this.f35273a;
                            if (aVar3 != null) {
                                String str = this.f35274b;
                                aVar3.b(str, d.c("副旱匬昱吩开逋旴｟坌嬍剛姜匞夨贯a", 120) + h.f(e10));
                            }
                        }
                    }
                    return enumCardAppStatus;
                } catch (FMScriptHandleException e11) {
                    z2.a aVar4 = this.f35273a;
                    if (aVar4 != null) {
                        String str2 = this.f35274b;
                        aVar4.b(str2, h.e("获叁卯乏廈畻彙剌犮恎新ｑ误叝ria2料代好赦`", 3, 23) + h.f(e11));
                    }
                    return enumCardAppStatus;
                }
            } catch (FMScriptHandleException e12) {
                z2.a aVar5 = this.f35273a;
                if (aVar5 != null) {
                    String str3 = this.f35274b;
                    aVar5.b(str3, FM_Exception.insert(5, 24, "莾受卸乛廝甩彊剜狿恀斯＝)遈抰\u0010MG*奠赬;") + h.f(e12));
                }
                return enumCardAppStatus;
            }
        } catch (FMScriptHandleException e13) {
            z2.a aVar6 = this.f35273a;
            if (aVar6 != null) {
                String str4 = this.f35274b;
                aVar6.b(str4, x2.b.b(5, "莥友卩丙床畡弇划狼恔时＇6逈拥S\u0006\u000bi奲赫c") + h.f(e13));
            }
            return enumCardAppStatus;
        }
    }

    public CardAppRecord i(byte[] bArr) {
        CardAppRecord cardAppRecord = new CardAppRecord();
        cardAppRecord.setTradeNo(c.e(new byte[]{bArr[0], bArr[1]}));
        cardAppRecord.setAmount(Integer.parseInt(c.c(new byte[]{bArr[5], bArr[6], bArr[7], bArr[8]}), 16));
        cardAppRecord.setTradeType(g(bArr[9]));
        cardAppRecord.setTradeDevice(c.c(new byte[]{bArr[10], bArr[11], bArr[12], bArr[13], bArr[14], bArr[15]}));
        cardAppRecord.setTradeDate(c.c(new byte[]{bArr[18], bArr[19]}));
        cardAppRecord.setTradeTime(c.c(new byte[]{bArr[20], bArr[21], bArr[22]}));
        return cardAppRecord;
    }
}
