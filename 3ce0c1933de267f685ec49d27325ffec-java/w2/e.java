package w2;

import androidx.recyclerview.widget.g;
import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import cn.com.fmsh.script.ApduHandler;
import cn.com.fmsh.script.exception.FMScriptHandleException;
import cn.com.fmsh.tsm.business.bean.BusinessOrder;
import cn.com.fmsh.tsm.business.bean.CardAppRecord;
import cn.com.fmsh.tsm.business.bean.UserInfo;
import cn.com.fmsh.tsm.business.enums.EnumBusinessOrderType;
import cn.com.fmsh.tsm.business.enums.EnumCardAppType;
import cn.com.fmsh.tsm.business.enums.EnumCardIoType;
import cn.com.fmsh.tsm.business.enums.EnumOrderStatus;
import cn.com.fmsh.tsm.business.enums.EnumOrderType;
import cn.com.fmsh.tsm.business.exception.BusinessException;
import com.huawei.hms.ml.camera.CameraConfig;
import com.realsil.sdk.dfu.DfuException;
import f2.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import r2.d;
import x2.f;
import x2.g;
import x2.h;
import z2.a;
import z2.b;
/* loaded from: classes.dex */
public class e implements d {

    /* renamed from: a  reason: collision with root package name */
    /* synthetic */ a f35958a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f35959b = e.class.getName();

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ f f35960c;

    public e(f fVar) {
        this.f35958a = null;
        this.f35960c = fVar;
        this.f35958a = b.a().b();
    }

    private final /* bridge */ /* synthetic */ cn.com.fmsh.tsm.business.bean.d p(int i10, int i11, int i12, int i13, byte[] bArr, f2.b bVar, ApduHandler apduHandler, String str) throws BusinessException {
        byte[] bArr2;
        String a10 = f.a("议卜电说", 4);
        f2.a e10 = bVar.e(1112);
        try {
            c c10 = bVar.c((byte) 30);
            c10.c(i10);
            e10.c(c10);
            c c11 = bVar.c((byte) 13);
            c11.c(i12);
            e10.c(c11);
            c c12 = bVar.c((byte) 14);
            c12.c(i13);
            e10.c(c12);
            if (bArr != null && bArr.length > 0) {
                c c13 = bVar.c((byte) 15);
                c13.f(x2.c.c(bArr));
                e10.c(c13);
            }
            c c14 = bVar.c((byte) 16);
            c14.e(x2.c.n(i11, 4));
            e10.c(c14);
            c c15 = bVar.c((byte) 47);
            c15.c(ApduHandler.ApduHandlerType.NFC == apduHandler.f() ? EnumCardIoType.CARD_IO_TYPE_OUT.getId() : ApduHandler.ApduHandlerType.BLUETOOTH == apduHandler.f() ? EnumCardIoType.CARD_IO_TYPE_OUT.getId() : EnumCardIoType.CARD_IO_TYPE_IN.getId());
            e10.c(c15);
            bArr2 = e10.a();
        } catch (FMCommunicationMessageException e11) {
            a aVar = this.f35958a;
            if (aVar != null) {
                String str2 = this.f35959b;
                aVar.c(str2, String.valueOf(a10) + x2.a.b("斥＋淓恠奇瑑噣冥玣彅幣５", 3, 52) + h.f(e11));
            }
            f fVar = this.f35960c;
            fVar.t(String.valueOf(a10) + g.a(2, 48, "斤．淚恭外瑄噺冸珢开幪"), BusinessException.ErrorMessage.local_message_message_handle_exception, false);
            bArr2 = null;
        }
        byte[] n10 = this.f35960c.n(bArr2, a10, false, str);
        byte[] bArr3 = new byte[2];
        System.arraycopy(n10, 0, bArr3, 0, 2);
        if (!Arrays.equals(v2.b.f35577a, bArr3)) {
            a aVar2 = this.f35958a;
            if (aVar2 != null) {
                String str3 = this.f35959b;
                aVar2.b(str3, String.valueOf(a10) + x2.b.b(5, "旤１幻口多瑏奥赺pu") + x2.c.c(n10));
            }
            f fVar2 = this.f35960c;
            fVar2.t(String.valueOf(a10) + f.a("旼＋幷叱奚瑝奩走", 2), BusinessException.ErrorMessage.instance(x2.c.c(bArr3)), false);
        }
        try {
            c b10 = bVar.b(1112, Arrays.copyOfRange(n10, 2, n10.length)).b(96);
            if (b10 != null) {
                return cn.com.fmsh.tsm.business.bean.d.c(b10);
            }
            return null;
        } catch (FMCommunicationMessageException e12) {
            a aVar3 = this.f35958a;
            if (aVar3 != null) {
                String str4 = this.f35959b;
                aVar3.b(str4, String.valueOf(a10) + h.e("旴ｙ覫柋帽厱哙库几玽异幫|y", 5, 115) + h.f(e12));
            }
            f fVar3 = this.f35960c;
            fVar3.t(String.valueOf(a10) + FM_Exception.insert(4, 62, "旾ｊ觧柒平叮咑庎奩贳"), BusinessException.ErrorMessage.local_message_message_handle_exception, false);
            return null;
        }
    }

    private final /* bridge */ /* synthetic */ cn.com.fmsh.tsm.business.bean.d q(int i10, int i11, byte[] bArr, byte[] bArr2, f2.b bVar, String str) throws BusinessException {
        byte[] bArr3;
        String b10 = x2.a.b("浨劶诫匁甬讽", 3, 43);
        f2.a e10 = bVar.e(1142);
        try {
            c c10 = bVar.c((byte) 30);
            c10.c(i10);
            e10.c(c10);
            c c11 = bVar.c((byte) 14);
            c11.c(i11);
            e10.c(c11);
            if (bArr != null && bArr.length > 0) {
                c c12 = bVar.c((byte) 71);
                c12.e(bArr);
                e10.c(c12);
            }
            c c13 = bVar.c((byte) -76);
            c13.e(bArr2);
            e10.c(c13);
            bArr3 = e10.a();
        } catch (FMCommunicationMessageException e11) {
            a aVar = this.f35958a;
            if (aVar != null) {
                String str2 = this.f35959b;
                aVar.c(str2, String.valueOf(b10) + x2.c.i("斪ｃ淊怺奌琝噦击玤弅幢ｗ", 5, 115) + h.f(e11));
            }
            f fVar = this.f35960c;
            fVar.t(String.valueOf(b10) + x2.b.b(5, "旤１涀恼多瑏嘼冥珺彗常"), BusinessException.ErrorMessage.local_message_message_handle_exception, false);
            bArr3 = null;
        }
        byte[] n10 = this.f35960c.n(bArr3, b10, false, str);
        byte[] bArr4 = new byte[2];
        System.arraycopy(n10, 0, bArr4, 0, 2);
        if (!Arrays.equals(v2.b.f35577a, bArr4)) {
            a aVar2 = this.f35958a;
            if (aVar2 != null) {
                String str3 = this.f35959b;
                aVar2.b(str3, String.valueOf(b10) + f.a("旲－席厫奜瑓奣赪vi", 252) + x2.c.c(n10));
            }
            f fVar2 = this.f35960c;
            fVar2.t(String.valueOf(b10) + x2.c.i("斮４師叨奜琞奩贽", 1, 64), BusinessException.ErrorMessage.instance(x2.c.c(bArr4)), false);
        }
        try {
            c b11 = bVar.b(1112, Arrays.copyOfRange(n10, 2, n10.length)).b(96);
            if (b11 != null) {
                return cn.com.fmsh.tsm.business.bean.d.c(b11);
            }
            return null;
        } catch (FMCommunicationMessageException e12) {
            a aVar3 = this.f35958a;
            if (aVar3 != null) {
                String str4 = this.f35959b;
                aVar3.b(str4, String.valueOf(b10) + x2.a.b("斣｛觺枋帮厯和店凿珷彋帳7o", 5, 98) + h.f(e12));
            }
            f fVar3 = this.f35960c;
            fVar3.t(String.valueOf(b10) + x2.b.b(5, "旤１觫枃幭厹咙廋奻走"), BusinessException.ErrorMessage.local_message_message_handle_exception, false);
            return null;
        }
    }

    private final /* bridge */ /* synthetic */ cn.com.fmsh.tsm.business.bean.d r(byte[] bArr, f2.b bVar, String str) throws BusinessException {
        byte[] bArr2;
        try {
            f2.a e10 = bVar.e(1122);
            c c10 = bVar.c((byte) 105);
            c10.e(bArr);
            e10.c(c10);
            c c11 = bVar.c((byte) 101);
            c11.c(EnumOrderType.MAIN.getId());
            e10.c(c11);
            bArr2 = e10.a();
        } catch (FMCommunicationMessageException e11) {
            a aVar = this.f35958a;
            if (aVar != null) {
                aVar.c(this.f35959b, x2.c.i("乡讯匕俲怩枼诮斩>柁選幸厮详氆攧捤冧玠彁幮３", 3, 51) + h.f(e11));
            }
            this.f35960c.t(x2.b.b(2, "临许卐俱恴枣枴设斱~柙逨幠叮课汖敯挤冯珰奺赳"), BusinessException.ErrorMessage.local_message_message_handle_exception, false);
            bArr2 = null;
        }
        byte[] n10 = this.f35960c.n(bArr2, x2.a.b("乮诣匘俸恪柴访斿", 5, 108), false, str);
        byte[] copyOf = Arrays.copyOf(n10, 2);
        if (!Arrays.equals(v2.b.f35577a, copyOf)) {
            a aVar2 = this.f35958a;
            if (aVar2 != null) {
                aVar2.b(this.f35959b, f.a("串认卖信怲枿讵斢｝帽去咅廑镛记咑廍硗ip", 1) + x2.c.c(n10));
            }
            this.f35960c.t(FM_Exception.insert(4, 25, "丳讣协侲怣柠诼旡｜帺史够琒奼赣"), BusinessException.ErrorMessage.instance(x2.c.c(copyOf)), true);
        }
        try {
            c b10 = bVar.b(1132, Arrays.copyOfRange(n10, 2, n10.length)).b(96);
            if (b10 != null) {
                return cn.com.fmsh.tsm.business.bean.d.c(b10);
            }
            a aVar3 = this.f35958a;
            if (aVar3 != null) {
                aVar3.c(this.f35959b, f.a("串认卖信怲枿讵斢}帽去咅廑攲挱泽材卓呸桗笳\u0011qu\u001c2卨幫句河朆丷讫卓讳录", 1));
            }
            return null;
        } catch (FMCommunicationMessageException unused) {
            a aVar4 = this.f35958a;
            if (aVar4 != null) {
                aVar4.c(this.f35959b, x2.b.b(298, "丬诠匘侹怬枫讻旲＃觹枕幣叫咋廅攬挩彐幥２") + x2.c.c(n10));
            }
            this.f35960c.t(x2.d.c("乮诤匂侩恶柯诹旺ｑ覭柏帣厱哟店敤捫奧赢", 2), BusinessException.ErrorMessage.local_message_command_data_invaild, false);
            return null;
        }
    }

    private final /* bridge */ /* synthetic */ List<BusinessOrder> s(List<EnumOrderStatus> list, int i10, EnumCardAppType enumCardAppType, EnumBusinessOrderType enumBusinessOrderType, f2.b bVar, byte[] bArr, String str) throws BusinessException {
        byte[] bArr2;
        c b10;
        BusinessOrder fromTag;
        try {
            f2.a e10 = bVar.e(1134);
            if (list != null && list.size() > 0) {
                byte[] bArr3 = new byte[list.size()];
                for (int i11 = 0; i11 < list.size(); i11++) {
                    EnumOrderStatus enumOrderStatus = list.get(i11);
                    if (enumOrderStatus != null) {
                        bArr3[i11] = (byte) enumOrderStatus.getId();
                    }
                }
                c c10 = bVar.c((byte) 92);
                c10.e(bArr3);
                e10.c(c10);
            }
            c c11 = bVar.c((byte) 38);
            c11.c(i10);
            e10.c(c11);
            if (enumCardAppType != null) {
                c c12 = bVar.c((byte) 14);
                c12.c(enumCardAppType.getId());
                e10.c(c12);
            }
            c c13 = bVar.c((byte) 101);
            c13.c(EnumOrderType.BUSINESS.getId());
            e10.c(c13);
            if (enumBusinessOrderType != null) {
                c c14 = bVar.c((byte) 72);
                c14.c(enumBusinessOrderType.getId());
                e10.c(c14);
            }
            if (bArr != null && bArr.length > 0) {
                c c15 = bVar.c((byte) -76);
                c15.e(bArr);
                e10.c(c15);
            }
            bArr2 = e10.a();
        } catch (FMCommunicationMessageException e11) {
            a aVar = this.f35958a;
            if (aVar != null) {
                aVar.c(this.f35959b, x2.a.b("义勴讵卌枾访早-枇遥帴叹诼氏政捿凩珥录帡！", 3, 98) + h.f(e11));
            }
            this.f35960c.t(x2.b.b(172, "七勥语匏枠讲断*枕逼年叢诪氊攣挰决珤奮贯"), BusinessException.ErrorMessage.local_message_message_handle_exception, false);
            bArr2 = null;
        }
        byte[] n10 = this.f35960c.n(bArr2, h.e("业勹诲匝枥论斦", 3, 120), false, str);
        byte[] copyOf = Arrays.copyOf(n10, 2);
        if (!Arrays.equals(v2.b.f35577a, copyOf)) {
            a aVar2 = this.f35958a;
            if (aVar2 != null) {
                aVar2.b(this.f35959b, FM_Exception.insert(3, 108, "丝勲诽匞柲诡旹ｗ帴厣哒废锎诬咂廏硆)?") + x2.c.c(n10));
            }
            this.f35960c.t(FM_Exception.insert(246, 84, "乀勯讠匃枯诼斤ｊ幩厾奆琐奻贻"), BusinessException.ErrorMessage.instance(x2.c.c(copyOf)), true);
        }
        ArrayList arrayList = new ArrayList();
        try {
            b10 = bVar.b(1132, Arrays.copyOfRange(n10, 2, n10.length)).b(27);
        } catch (FMCommunicationMessageException unused) {
            a aVar3 = this.f35958a;
            if (aVar3 != null) {
                aVar3.c(this.f35959b, x2.c.i("乃劰诫協枼诳斿－觺柁幺厱哔廅敹振彛帩ｓ", 2, 56) + x2.c.c(n10));
            }
            this.f35960c.t(g.a(DfuException.ERROR_DFU_SPP_RWS_NOT_READY, 71, "丐勰论匊柣讯既ｗ覡枙帣叧咓庑攼捽奫赤"), BusinessException.ErrorMessage.local_message_command_data_invaild, false);
        }
        if (b10 == null) {
            a aVar4 = this.f35958a;
            if (aVar4 != null) {
                aVar4.c(this.f35959b, x2.b.b(5, "丈劼讪卆査讫斢s帹厥没朂丌加议卂诲弘"));
            }
            return arrayList;
        }
        c[] j10 = b10.j();
        if (j10 != null && j10.length >= 1) {
            for (c cVar : j10) {
                if (!(cVar == null || (fromTag = BusinessOrder.fromTag(cVar)) == null)) {
                    arrayList.add(fromTag);
                }
            }
            return arrayList;
        }
        a aVar5 = this.f35958a;
        if (aVar5 != null) {
            aVar5.c(this.f35959b, FM_Exception.insert(112, 116, "乎勩课包枡诺旺,幧司乆勱详剨隊呈丮穲"));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v27, types: [w2.f] */
    /* JADX WARN: Type inference failed for: r0v29, types: [w2.f] */
    /* JADX WARN: Type inference failed for: r0v4, types: [w2.f] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [int] */
    /* JADX WARN: Type inference failed for: r7v15, types: [w2.f] */
    private final /* bridge */ /* synthetic */ boolean t(byte[] bArr, byte[] bArr2, f2.b bVar, String str) throws BusinessException {
        byte[] bArr3;
        byte[] bArr4;
        boolean z10;
        byte[] bArr5 = bArr2;
        String c10 = x2.d.c("匢乞廑甾圏孀", 368);
        ApduHandler i10 = this.f35960c.i();
        boolean z11 = false;
        if (i10 == null) {
            a aVar = this.f35958a;
            if (aVar != null) {
                aVar.b(this.f35959b, String.valueOf(c10) + x2.b.b(270, "旭＊PL\u0003\u0007奙瑎嘻乤穳"));
            }
            this.f35960c.t(String.valueOf(c10) + FM_Exception.insert(2, 3, "旰％读兇刕捷卹皟计闯施弈\"B]R9WZ\\k"), BusinessException.ErrorMessage.local_business_apdu_handler_null, false);
        }
        int i11 = 5;
        int i12 = 4;
        ?? r12 = 1;
        if (i10.c()) {
            a aVar2 = this.f35958a;
            if (aVar2 != null) {
                aVar2.b(this.f35959b, String.valueOf(c10) + x2.c.i("斯ｆZ\u001cY[奛琖噩欱忚", 2, 81));
            }
            this.f35960c.t(String.valueOf(c10) + g.a(4, 54, "斢＆\u0001F\bW夜瑈噬欹忉"), BusinessException.ErrorMessage.local_business_apdu_handler_busying, false);
        } else if (!i10.b()) {
            a aVar3 = this.f35958a;
            if (aVar3 != null) {
                aVar3.b(this.f35959b, String.valueOf(c10) + x2.d.c("斡ｄ辇揯卺夽贸", 4));
            }
            this.f35960c.t(String.valueOf(c10) + x2.c.i("斪＜辚掽匭失贱", 5, 52), BusinessException.ErrorMessage.local_message_apdu_execute_exception, true);
        }
        f2.a e10 = bVar.e(3011);
        int i13 = 47;
        p2.c cVar = null;
        try {
            c c11 = bVar.c((byte) 17);
            c11.e(bArr);
            e10.c(c11);
            c c12 = bVar.c((byte) 15);
            if (bArr5 == null || bArr5.length < 1) {
                bArr5 = new byte[8];
            }
            c12.f(x2.c.c(bArr5));
            e10.c(c12);
            c c13 = bVar.c((byte) 47);
            c13.c(ApduHandler.ApduHandlerType.NFC == i10.f() ? EnumCardIoType.CARD_IO_TYPE_OUT.getId() : ApduHandler.ApduHandlerType.BLUETOOTH == i10.f() ? EnumCardIoType.CARD_IO_TYPE_OUT.getId() : EnumCardIoType.CARD_IO_TYPE_IN.getId());
            e10.c(c13);
            bArr3 = e10.a();
        } catch (FMCommunicationMessageException e11) {
            a aVar4 = this.f35958a;
            if (aVar4 != null) {
                aVar4.c(this.f35959b, String.valueOf(c10) + f.a("旼＋枀逡席厫讯気攢挡彎幱｜", 2) + h.f(e11));
            }
            this.f35960c.t(String.valueOf(c10) + x2.d.c("斣ｊ染遨幪叺诬汎攭挠奮赵", 2), BusinessException.ErrorMessage.local_message_message_handle_exception, true);
            bArr3 = null;
        }
        byte[] n10 = this.f35960c.n(bArr3, c10, true, str);
        byte[] copyOf = Arrays.copyOf(n10, 2);
        c cVar2 = null;
        c cVar3 = null;
        c cVar4 = null;
        byte[] bArr6 = bArr3;
        byte[] bArr7 = n10;
        while (true) {
            bArr4 = v2.b.f35578b;
            if (!Arrays.equals(bArr4, copyOf)) {
                break;
            }
            try {
                f2.a d10 = bVar.d(bArr7);
                cVar3 = d10.b(-90);
                cVar4 = d10.b(-89);
                cVar2 = d10.b(-95);
            } catch (FMCommunicationMessageException e12) {
                a aVar5 = this.f35958a;
                if (aVar5 != null) {
                    aVar5.b(this.f35959b, f.a("卬一库甬圉ｒ覸柈带厢咂廘决珶彁幸gz", i11) + h.f(e12));
                }
                ?? r02 = this.f35960c;
                int i14 = r12 == true ? 1 : 0;
                int i15 = r12 == true ? 1 : 0;
                r02.t(x2.c.i("匹丕庒略圜嬃．親枀帤叮哈廘夢赿", i14, 71), BusinessException.ErrorMessage.local_message_message_handle_exception, r12);
            }
            c cVar5 = cVar4;
            if (cVar2 == null) {
                a aVar6 = this.f35958a;
                if (aVar6 != null) {
                    aVar6.b(this.f35959b, x2.c.i("区乜廅畤坏嬚ｑ師厣咃廝攴捱旺扲衜脑未）]&；", i12, 123));
                }
                this.f35960c.t(x2.d.c("匶乂廍畢圓孔１幽厯咝廕攢挭旴扢衚脝杴", i12), BusinessException.ErrorMessage.local_message_message_handle_exception, r12);
            }
            cVar = new p2.c();
            try {
                cVar.d(cVar2);
                p2.a b10 = this.f35960c.l().b(cVar);
                if (b10 == null || b10.b() < r12) {
                    a aVar7 = this.f35958a;
                    if (aVar7 != null) {
                        aVar7.b(this.f35959b, x2.d.c("匹乃廎畣圔孕２脕本戶蠎纀柘丯穼", i11));
                    }
                    this.f35960c.t(x2.d.c("匴乌廃畠圑孒７脖東戩蠓奡赤", 2), BusinessException.ErrorMessage.local_message_apdu_execute_exception, r12);
                }
                f2.a e13 = bVar.e(9001);
                e13.c(cVar3);
                e13.c(cVar5);
                e13.c(b10.d());
                bArr6 = e13.a();
                boolean z12 = r12 == true ? 1 : 0;
                boolean z13 = r12 == true ? 1 : 0;
                z10 = z12;
            } catch (FMCommunicationMessageException e14) {
                a aVar8 = this.f35958a;
                if (aVar8 != null) {
                    aVar8.b(this.f35959b, x2.c.i("医乒廂畼坚嬈ｂ帿厺咅廒攴挬覣柎冦珪彚幮nr", 3, 126) + h.f(e14));
                }
                z10 = true;
                this.f35960c.t(g.a(1, 123, "匰乆廓番坕嬀｟帽厹咉庋敪捻觳枛夷贤"), BusinessException.ErrorMessage.local_message_message_handle_exception, true);
            } catch (FMScriptHandleException e15) {
                a aVar9 = this.f35958a;
                if (aVar9 != null) {
                    aVar9.b(this.f35959b, x2.e.a(204, "匠乎廓畢坅嬈｟腌杵戻蠓冸珵彊平ｔ") + h.f(e15));
                }
                z10 = true;
                this.f35960c.t(h.e("占乗廍畽坙嬕ｅ腟杭戺蠕奤赴", i12, 124), BusinessException.ErrorMessage.local_message_apdu_execute_exception, true);
            }
            bArr7 = this.f35960c.n(bArr6, x2.d.c("卢丞庑畾坏嬀斿", 176), z10, str);
            copyOf = Arrays.copyOf(bArr7, 2);
            cVar4 = cVar5;
            r12 = z10;
            z11 = false;
            i11 = 5;
            i12 = 4;
            i13 = 47;
        }
        this.f35960c.d(r12);
        if (!Arrays.equals(v2.b.f35577a, copyOf) && !Arrays.equals(bArr4, copyOf)) {
            if (cVar != null) {
                p2.b[] f10 = cVar.f();
                int length = f10.length;
                for (int i16 = z11; i16 < length; i16++) {
                    p2.b bVar2 = f10[i16];
                    if (!(bVar2 == null || bVar2.b() == null)) {
                        int length2 = bVar2.b().length;
                        byte[] bArr8 = v2.a.f35576a;
                        if (length2 >= bArr8.length && Arrays.equals(bArr8, Arrays.copyOf(bVar2.b(), bArr8.length))) {
                            return r12;
                        }
                    }
                }
            }
            a aVar10 = this.f35958a;
            if (aVar10 != null) {
                aVar10.b(this.f35959b, String.valueOf(c10) + g.a(376, i13, "斾；n坝孜剎姉匇i幼叮咀庈镒讵哄廌砆,e") + x2.c.c(copyOf));
            }
            this.f35960c.t(String.valueOf(c10) + x2.b.b(i12, "旧０年叢夙瑎奢赻"), BusinessException.ErrorMessage.instance(x2.c.c(copyOf)), z11);
        }
        return r12;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:69|(8:147|70|71|143|72|73|141|74)|(1:85)(1:86)|(1:88)(1:89)|(2:149|90)|137|102|103|(3:115|(1:117)|118)|(2:145|120)(1:122)|121|123|124|129|(1:131)|132|(2:134|153)(2:135|152)|136|59) */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x02dc, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x02dd, code lost:
        r2 = r16.f35958a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x02df, code lost:
        if (r2 != null) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x02e1, code lost:
        r2.c(r16.f35959b, x2.h.e("丘勷夎瑘斤＊腀杢扥蠚冰玮彐幾", 5, 84));
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x02f5, code lost:
        if (cn.com.fmsh.script.exception.FMScriptHandleException.ScriptHandleExceptionType.STOPED == r0.getType()) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x02f7, code lost:
        r5 = 1;
        r16.f35960c.t(x2.e.a(2, "乍勻奙理袨叐涁"), cn.com.fmsh.tsm.business.exception.BusinessException.ErrorMessage.local_business_cancel, true);
        r4 = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0308, code lost:
        r5 = 1;
        r4 = 5;
        r16.f35960c.t(x2.d.c("杴坹戽蠇扻衁夯贪", 5), cn.com.fmsh.tsm.business.exception.BusinessException.ErrorMessage.local_message_apdu_execute_exception, true);
     */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x034d A[Catch: FMCommunicationMessageException -> 0x0358, TryCatch #5 {FMCommunicationMessageException -> 0x0358, blocks: (B:120:0x0345, B:121:0x0349, B:122:0x034d, B:123:0x0352), top: B:145:0x0345 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0345 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0261  */
    @Override // r2.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(byte[] bArr, byte[] bArr2) throws BusinessException {
        byte[] bArr3;
        c cVar;
        c cVar2;
        c c10;
        int i10;
        byte[] bArr4;
        a aVar;
        a aVar2;
        int i11;
        a aVar3;
        String str;
        f fVar;
        FMCommunicationMessageException e10;
        a aVar4;
        a aVar5 = this.f35958a;
        if (aVar5 != null) {
            aVar5.c(this.f35959b, h.e("e|\u0010y:4a)t'\u001au=noor'de=5cq?", 4, 50));
        }
        String a10 = g.a(118, 72, "奂琈杼冭亢晝");
        if (this.f35958a == null) {
            this.f35958a = b.a().b();
        }
        a aVar6 = this.f35958a;
        if (aVar6 != null) {
            aVar6.e(this.f35959b, x2.d.c("契瑀杽击亽昙5\"s", 2));
        }
        f fVar2 = this.f35960c;
        if (fVar2 == null) {
            a aVar7 = this.f35958a;
            if (aVar7 != null) {
                aVar7.c(this.f35959b, g.a(5, 80, "契瑃朿凶亱昖斣）乏勤夑瑃寬豤乯穿"));
            }
            throw new BusinessException(h.e("夅理朵凭仹昏旭ｖ乃効夓瑐嘽刉姘卄奠贵", 4, 31), BusinessException.ErrorMessage.local_business_init_fail);
        }
        f2.b k10 = fVar2.k();
        if (k10 == null) {
            a aVar8 = this.f35958a;
            if (aVar8 != null) {
                aVar8.c(this.f35959b, x2.b.b(4, "夕琚札冡亹晛斥ｒ淁总奛琌噽为穱"));
            }
            throw new BusinessException(x2.b.b(126, "夏琐末冿亳晑斻ｔ淋怡奝琂噧丠穿"), BusinessException.ErrorMessage.local_message_load_config_fail);
        }
        ApduHandler i12 = this.f35960c.i();
        if (i12 == null) {
            a aVar9 = this.f35958a;
            if (aVar9 != null) {
                aVar9.c(this.f35959b, x2.c.i("変琍朣冴亡昐旷３|k}b挒价夕琉噥丱穳", 310, 126));
            }
            throw new BusinessException(FM_Exception.insert(5, 8, "七浦亽逛卨穫临億偵斧ｕ讶儁剖挻占皍议闷斸弆9V\f\b~\u0017\u0007\nx"), BusinessException.ErrorMessage.local_business_apdu_handler_null);
        }
        int i13 = 0;
        int i14 = 3;
        boolean z10 = true;
        if (i12.c()) {
            a aVar10 = this.f35958a;
            if (aVar10 != null) {
                aVar10.b(this.f35959b, FM_Exception.insert(6, 17, "夎琝朦冮仪晌斦－SSP\u0010奒瑁嘰歪心"));
            }
            this.f35960c.t(h.e("奍琉朿凨以晔旻？\u0018\u000f\u0001^夕瑑嘵欠忐", 204, 102), BusinessException.ErrorMessage.local_business_apdu_handler_busying, false);
        } else if (!i12.b()) {
            a aVar11 = this.f35958a;
            if (aVar11 != null) {
                aVar11.b(this.f35959b, x2.b.b(4, "夕琚札冡亹晛斥ｒ辗揱匾夻贰"));
            }
            this.f35960c.t(h.e("处琊朲冷亴昏斾ｘ辞揩匹夵贵", 3, 12), BusinessException.ErrorMessage.local_message_apdu_execute_exception, true);
        }
        String m10 = this.f35960c.m(3021);
        if (m10 == null) {
            a aVar12 = this.f35958a;
            if (aVar12 != null) {
                aVar12.c(this.f35959b, String.valueOf(a10) + x2.e.a(3, "斮ｗ菩受夀琁皎幾叠夢贳"));
            }
            throw new BusinessException(String.valueOf(a10) + x2.e.a(278, "旽＂莦参夓琜皙平右夷贬"), BusinessException.ErrorMessage.local_app_query_server_fail);
        }
        this.f35960c.e(a10, m10);
        f2.a e11 = k10.e(3021);
        try {
            c c11 = k10.c((byte) 17);
            c11.e(bArr);
            e11.c(c11);
            bArr3 = e11.a();
        } catch (FMCommunicationMessageException e12) {
            a aVar13 = this.f35958a;
            if (aVar13 != null) {
                aVar13.c(this.f35959b, x2.e.a(4, "杳凯任昑夁琎'枊週幧叧语江数捭弄帱６") + h.f(e12));
            }
            this.f35960c.t(x2.c.i("杳冮以晖复琋}柑逹幮厱诲汋攽挿夤贼", 2, 36), BusinessException.ErrorMessage.local_message_message_handle_exception, true);
            bArr3 = null;
        }
        byte[] n10 = this.f35960c.n(bArr3, f.a("朤冸京昖夆瑙", 6), true, m10);
        byte[] copyOf = Arrays.copyOf(n10, 2);
        boolean z11 = false;
        p2.a aVar14 = null;
        f2.a aVar15 = null;
        while (Arrays.equals(v2.b.f35578b, copyOf)) {
            p2.c cVar3 = new p2.c();
            try {
                f2.a d10 = k10.d(n10);
                cVar2 = d10.b(-96);
                try {
                    cVar = d10.b(-95);
                    try {
                        c b10 = d10.b(-90);
                        c b11 = d10.b(-89);
                        aVar15 = k10.e(9001);
                        aVar15.c(b10);
                        aVar15.c(b11);
                    } catch (FMCommunicationMessageException e13) {
                        e10 = e13;
                        aVar4 = this.f35958a;
                        if (aVar4 != null) {
                            aVar4.c(h.e("l()A}d", i14, 103), String.valueOf(a10) + x2.b.b(124, "觪构幬叺哘廔攻挸冻珼录帺7") + h.f(e10));
                        }
                        this.f35960c.t(x2.e.a(74, "觼柒帶厸咆廚攡挺奦赿"), BusinessException.ErrorMessage.local_message_command_data_invaild, true);
                        if (cVar2 != null) {
                        }
                        if (cVar != null) {
                        }
                        cVar3.d(cVar);
                        aVar14 = this.f35960c.l().b(cVar3);
                        char c12 = 5;
                        int i15 = 1;
                        if (aVar14 != null) {
                        }
                        aVar3 = this.f35958a;
                        if (aVar3 != null) {
                        }
                        this.f35960c.t(x2.c.i("杵圲扬衘扺衊夾贽", DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED, 9), BusinessException.ErrorMessage.local_message_apdu_execute_exception, true);
                        if (!z11) {
                        }
                        aVar15.c(c10);
                        bArr4 = aVar15.a();
                        i10 = 1;
                        aVar = this.f35958a;
                        if (aVar != null) {
                        }
                        aVar2 = this.f35958a;
                        if (aVar2 != null) {
                        }
                        n10 = this.f35960c.n(bArr4, a10, true, m10);
                        copyOf = Arrays.copyOf(n10, 2);
                        i14 = i11;
                        z10 = true;
                        i13 = 0;
                    }
                } catch (FMCommunicationMessageException e14) {
                    e10 = e14;
                    cVar = null;
                    aVar4 = this.f35958a;
                    if (aVar4 != null) {
                    }
                    this.f35960c.t(x2.e.a(74, "觼柒帶厸咆廚攡挺奦赿"), BusinessException.ErrorMessage.local_message_command_data_invaild, true);
                    if (cVar2 != null) {
                    }
                    if (cVar != null) {
                    }
                    cVar3.d(cVar);
                    aVar14 = this.f35960c.l().b(cVar3);
                    char c122 = 5;
                    int i152 = 1;
                    if (aVar14 != null) {
                    }
                    aVar3 = this.f35958a;
                    if (aVar3 != null) {
                    }
                    this.f35960c.t(x2.c.i("杵圲扬衘扺衊夾贽", DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED, 9), BusinessException.ErrorMessage.local_message_apdu_execute_exception, true);
                    if (!z11) {
                    }
                    aVar15.c(c10);
                    bArr4 = aVar15.a();
                    i10 = 1;
                    aVar = this.f35958a;
                    if (aVar != null) {
                    }
                    aVar2 = this.f35958a;
                    if (aVar2 != null) {
                    }
                    n10 = this.f35960c.n(bArr4, a10, true, m10);
                    copyOf = Arrays.copyOf(n10, 2);
                    i14 = i11;
                    z10 = true;
                    i13 = 0;
                }
            } catch (FMCommunicationMessageException e15) {
                e10 = e15;
                cVar2 = null;
            }
            if (cVar2 != null) {
                z11 = false;
            } else {
                cVar2 = null;
            }
            if (cVar != null) {
                z11 = true;
            } else {
                cVar = cVar2;
            }
            try {
                cVar3.d(cVar);
            } catch (FMCommunicationMessageException e16) {
                if (this.f35958a != null) {
                    this.f35958a.c(this.f35959b, FM_Exception.insert(46, 67, "丈勴夜瑝旨－帷号咇庙盔散挸觺柌弝幺？") + h.f(e16));
                }
                fVar = this.f35960c;
                str = FM_Exception.insert(DfuException.ERROR_DFU_ENABLE_BUFFER_CHECK_NO_RESPONSE, 115, "平口哋廍盈支挼覦枈夺贻");
                fVar.t(str, BusinessException.ErrorMessage.local_communication_invalid_response, true);
                aVar14 = this.f35960c.l().b(cVar3);
                char c1222 = 5;
                int i1522 = 1;
                if (aVar14 != null) {
                }
                aVar3 = this.f35958a;
                if (aVar3 != null) {
                }
                this.f35960c.t(x2.c.i("杵圲扬衘扺衊夾贽", DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED, 9), BusinessException.ErrorMessage.local_message_apdu_execute_exception, true);
                if (!z11) {
                }
                aVar15.c(c10);
                bArr4 = aVar15.a();
                i10 = 1;
                aVar = this.f35958a;
                if (aVar != null) {
                }
                aVar2 = this.f35958a;
                if (aVar2 != null) {
                }
                n10 = this.f35960c.n(bArr4, a10, true, m10);
                copyOf = Arrays.copyOf(n10, 2);
                i14 = i11;
                z10 = true;
                i13 = 0;
            } catch (FMScriptHandleException e17) {
                if (this.f35958a != null) {
                    this.f35958a.c(this.f35959b, x2.d.c("乏勧奓瑎旯＆幨叼咐廚盛攠振觱枓弖帽", 2) + h.f(e17));
                }
                fVar = this.f35960c;
                str = x2.c.i("帯厠咉廌盈攰捺觫枌夡贡", 5, 116);
                fVar.t(str, BusinessException.ErrorMessage.local_communication_invalid_response, true);
                aVar14 = this.f35960c.l().b(cVar3);
                char c12222 = 5;
                int i15222 = 1;
                if (aVar14 != null) {
                }
                aVar3 = this.f35958a;
                if (aVar3 != null) {
                }
                this.f35960c.t(x2.c.i("杵圲扬衘扺衊夾贽", DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED, 9), BusinessException.ErrorMessage.local_message_apdu_execute_exception, true);
                if (!z11) {
                }
                aVar15.c(c10);
                bArr4 = aVar15.a();
                i10 = 1;
                aVar = this.f35958a;
                if (aVar != null) {
                }
                aVar2 = this.f35958a;
                if (aVar2 != null) {
                }
                n10 = this.f35960c.n(bArr4, a10, true, m10);
                copyOf = Arrays.copyOf(n10, 2);
                i14 = i11;
                z10 = true;
                i13 = 0;
            }
            aVar14 = this.f35960c.l().b(cVar3);
            char c122222 = 5;
            int i152222 = 1;
            if (aVar14 != null || aVar14.b() < i152222) {
                aVar3 = this.f35958a;
                if (aVar3 != null) {
                    aVar3.c(this.f35959b, x2.a.b("义勭奁瑘斡｜咄廖终枈丷穼", 3, 121));
                }
                this.f35960c.t(x2.c.i("杵圲扬衘扺衊夾贽", DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED, 9), BusinessException.ErrorMessage.local_message_apdu_execute_exception, true);
            }
            if (!z11) {
                try {
                    c10 = aVar14.c();
                } catch (FMCommunicationMessageException unused) {
                    a aVar16 = this.f35958a;
                    if (aVar16 != null) {
                        aVar16.c(this.f35959b, f.a("丐劦夀琇斨ｗ柜遵纚窠咁廝收挭冺班彘幯", 2));
                    }
                    i10 = 1;
                    this.f35960c.t(x2.a.b("柗逶幪厬讨汀攵挦夺贫", 3, 35), BusinessException.ErrorMessage.local_message_message_handle_exception, true);
                    bArr4 = null;
                }
            } else {
                c10 = aVar14.d();
            }
            aVar15.c(c10);
            bArr4 = aVar15.a();
            i10 = 1;
            aVar = this.f35958a;
            if (aVar != null) {
                aVar.a(this.f35959b, h.e("戹衄寞扌&\"?t!6g?l", i10, 42) + x2.c.c(bArr4));
            }
            aVar2 = this.f35958a;
            if (aVar2 != null) {
                i11 = 3;
                aVar2.a(this.f35959b, x2.c.i("纒窬夈瑓宒扗＜厈遃夏瑒绎柚绖師厱$}2", 3, 73));
            } else {
                i11 = 3;
            }
            n10 = this.f35960c.n(bArr4, a10, true, m10);
            copyOf = Arrays.copyOf(n10, 2);
            i14 = i11;
            z10 = true;
            i13 = 0;
        }
        this.f35960c.d(z10);
        if (Arrays.equals(v2.b.f35577a, copyOf)) {
            return i13;
        }
        a aVar17 = this.f35958a;
        if (aVar17 != null) {
            aVar17.c(this.f35959b, FM_Exception.insert(g.f.DEFAULT_SWIPE_ANIMATION_DURATION, 96, "杴凭人昍奚瑘２幭厮咓床锇讱咓床砟d~") + x2.c.c(n10));
        }
        return x2.d.a(copyOf);
    }

    @Override // r2.d
    public int b() throws BusinessException {
        if (this.f35958a == null) {
            this.f35958a = b.a().b();
        }
        a aVar = this.f35958a;
        if (aVar != null) {
            aVar.e(this.f35959b, f.a("畢扰瘿冻puv", 98));
        }
        f fVar = this.f35960c;
        if (fVar == null) {
            a aVar2 = this.f35958a;
            if (aVar2 != null) {
                aVar2.c(this.f35959b, x2.b.b(152, "甭戧逛冼斧ｐ九勳奙琎寪豿丳穮"));
            }
            throw new BusinessException(x2.e.a(4, "畱扫遟凸旳＄丑劯夕琒噿切姖化夲责"), BusinessException.ErrorMessage.local_business_init_fail);
        }
        if (fVar.i() != null) {
            this.f35960c.i().close();
        }
        String m10 = this.f35960c.m(1022);
        if (m10 == null) {
            a aVar3 = this.f35958a;
            if (aVar3 != null) {
                aVar3.c(this.f35959b, x2.b.b(4, "甹戫逇凨旫ｄ菤厈帺厤侾恥夤败"));
            }
            throw new BusinessException(h.e("甩戠遍凹斯＃菲厍幢厷俼怼夸贺", 4, 54), BusinessException.ErrorMessage.local_app_query_server_fail);
        } else if (this.f35960c.c(m10)) {
            return 0;
        } else {
            a aVar4 = this.f35958a;
            if (aVar4 != null) {
                aVar4.c(this.f35959b, FM_Exception.insert(3, 95, "甯扱遅凾旵奆瑇失赺"));
            }
            this.f35960c.h(m10);
            return -1;
        }
    }

    @Override // r2.d
    public Integer c(EnumCardAppType enumCardAppType) throws BusinessException {
        if (this.f35958a == null) {
            this.f35958a = b.a().b();
        }
        a aVar = this.f35958a;
        if (aVar != null) {
            aVar.e(this.f35959b, h.e("获叚仼逞危盘佑颉n\"6", 3, 44));
        }
        String b10 = x2.b.b(2, "莸双亡逊卺盂伈飁");
        t2.a a10 = s2.a.b().a(enumCardAppType);
        Integer num = null;
        if (a10 == null) {
            a aVar2 = this.f35958a;
            if (aVar2 != null) {
                String str = this.f35959b;
                aVar2.c(str, String.valueOf(b10) + x2.d.c("ｘ菲厀捀宂卨籡垀盘奉瑘嘧奱贴", 1));
            }
            return null;
        }
        ApduHandler i10 = this.f35960c.i();
        if (i10 == null) {
            a aVar3 = this.f35958a;
            if (aVar3 != null) {
                String str2 = this.f35959b;
                aVar3.b(str2, String.valueOf(b10) + x2.c.i("斬＂\u0003F\u000e\u000b外瑀噲乴穸", 3, 52));
            }
            f fVar = this.f35960c;
            fVar.t(String.valueOf(b10) + h.e("斩＞讲児剌挼印盀讨閤旤弟kY\u0004\u001d \fS\u000br", 2, 51), BusinessException.ErrorMessage.local_business_apdu_handler_null, false);
        }
        if (i10.c()) {
            a aVar4 = this.f35958a;
            if (aVar4 != null) {
                String str3 = this.f35959b;
                aVar4.b(str3, String.valueOf(b10) + x2.e.a(344, "斻｜\u0012\u0006\u001d\t奛瑄嘭欫徒"));
            }
            f fVar2 = this.f35960c;
            fVar2.t(String.valueOf(b10) + x2.g.a(164, 54, "既ｆAF\bW奜琈嘬欹忉"), BusinessException.ErrorMessage.local_business_apdu_handler_busying, false);
        } else if (!i10.b()) {
            a aVar5 = this.f35958a;
            if (aVar5 != null) {
                String str4 = this.f35959b;
                aVar5.b(str4, String.valueOf(b10) + x2.d.c("｛辖揼匫太贩", 4));
            }
            f fVar3 = this.f35960c;
            fVar3.t(String.valueOf(b10) + f.a("斾ｉ辜揺匽奨赳", 224), BusinessException.ErrorMessage.local_message_apdu_execute_exception, true);
        }
        a10.a(i10);
        try {
            try {
                num = Integer.valueOf(a10.b());
            } catch (BusinessException unused) {
                a aVar6 = this.f35958a;
                if (aVar6 != null) {
                    String str5 = this.f35959b;
                    aVar6.b(str5, String.valueOf(b10) + f.a("旻凰玷弆帹", 5));
                }
                f fVar4 = this.f35960c;
                fVar4.t(String.valueOf(b10) + FM_Exception.insert(184, 61, "旪冣玦彑帨"), BusinessException.ErrorMessage.local_message_apdu_execute_exception, true);
            }
            return num;
        } finally {
            i10.close();
        }
    }

    @Override // r2.d
    public cn.com.fmsh.tsm.business.bean.d d(byte[] bArr, EnumCardAppType enumCardAppType, byte[] bArr2) throws BusinessException {
        a aVar;
        String e10 = h.e("浤劫讥卞甼诤", 2, 4);
        if (this.f35958a == null) {
            this.f35958a = b.a().b();
        }
        a aVar2 = this.f35958a;
        if (aVar2 != null) {
            aVar2.e(this.f35959b, x2.g.a(DfuException.ERROR_DFU_SPP_RWS_NOT_READY, 39, "洱効诺匊电论z5l"));
        }
        if (bArr == null || bArr.length < 1) {
            a aVar3 = this.f35958a;
            if (aVar3 != null) {
                String str = this.f35959b;
                aVar3.c(str, String.valueOf(e10) + f.a("旼＋朮伡儻浠勰罃硓", 2));
            }
            throw new BusinessException(String.valueOf(e10) + x2.b.b(3, "旦７伦兴皘厅攢彟幰"), BusinessException.ErrorMessage.local_business_para_error);
        } else if (bArr2 == null || bArr2.length < 1) {
            a aVar4 = this.f35958a;
            if (aVar4 != null) {
                String str2 = this.f35959b;
                aVar4.c(str2, String.valueOf(e10) + x2.a.b("斢＜朦佨儡活労陜勴攠换", 4, 28));
            }
            throw new BusinessException(String.valueOf(e10) + h.e("旴ｈ伦儭皎厎敾归帪", 5, 66), BusinessException.ErrorMessage.local_business_para_error);
        } else {
            f fVar = this.f35960c;
            if (fVar == null) {
                a aVar5 = this.f35958a;
                if (aVar5 != null) {
                    String str3 = this.f35959b;
                    aVar5.c(str3, String.valueOf(e10) + x2.g.a(6, 74, "斠ｌ丐勵多瑎寫谽乼穪"));
                }
                throw new BusinessException(String.valueOf(e10) + x2.b.b(3, "旦７东劰夘瑁嘺剀妃卅奯贬"), BusinessException.ErrorMessage.local_business_init_fail);
            }
            f2.b k10 = fVar.k();
            if (k10 == null) {
                a aVar6 = this.f35958a;
                if (aVar6 != null) {
                    String str4 = this.f35959b;
                    aVar6.c(str4, String.valueOf(e10) + x2.d.c("斮ｅ淒怤夘琋噶丵空", 5));
                }
                throw new BusinessException(String.valueOf(e10) + FM_Exception.insert(3, 37, "旱\uff00淙怹够瑆嘭丰穵"), BusinessException.ErrorMessage.local_message_load_config_fail);
            }
            i j10 = this.f35960c.j();
            if (j10 == null) {
                a aVar7 = this.f35958a;
                if (aVar7 != null) {
                    String str5 = this.f35959b;
                    aVar7.c(str5, String.valueOf(e10) + x2.a.b("斥２鄄缺俾急宬象乱稬", 3, 43));
                }
                throw new BusinessException(String.valueOf(e10) + x2.g.a(3, 54, "斥％鄒罻侪恮寮谬丹稣"), BusinessException.ErrorMessage.local_message_load_config_fail);
            }
            byte j11 = j10.j();
            if (j11 == 0 && (aVar = this.f35958a) != null) {
                String str6 = this.f35959b;
                aVar.c(str6, String.valueOf(e10) + h.e("旴ｗ诶匘朣滏坰鄜缤旄仪丸朤宝义", 5, 121));
            }
            String m10 = this.f35960c.m(1142);
            if (m10 == null) {
                a aVar8 = this.f35958a;
                if (aVar8 != null) {
                    String str7 = this.f35959b;
                    aVar8.c(str7, String.valueOf(e10) + h.e("旷４莸厐奙瑒皏幱叩奡赢", 4, 23));
                }
                throw new BusinessException(String.valueOf(e10) + x2.g.a(42, 1, "旬７莫友多琙的干史夲贡"), BusinessException.ErrorMessage.local_app_query_server_fail);
            }
            this.f35960c.e(e10, m10);
            cn.com.fmsh.tsm.business.bean.d q5 = q(j11, enumCardAppType.getId(), bArr, bArr2, k10, m10);
            this.f35960c.d(false);
            return q5;
        }
    }

    @Override // r2.d
    public cn.com.fmsh.tsm.business.bean.d e(byte[] bArr) throws BusinessException {
        if (this.f35958a == null) {
            this.f35958a = b.a().b();
        }
        a aVar = this.f35958a;
        if (aVar != null) {
            aVar.e(this.f35959b, x2.e.a(3, "乣诹匋诧绂柢诨#>="));
        }
        String a10 = f.a("串认卖信怲枿讵", 1);
        f fVar = this.f35960c;
        if (fVar == null) {
            a aVar2 = this.f35958a;
            if (aVar2 != null) {
                String str = this.f35959b;
                aVar2.c(str, String.valueOf(a10) + x2.a.b("～乒势夐琌对豷丶穸", 226, 118));
            }
            throw new BusinessException(String.valueOf(a10) + x2.a.b("｝乔努夌瑃嘪刂妗协大贶", 1, 93), BusinessException.ErrorMessage.local_business_init_fail);
        }
        f2.b k10 = fVar.k();
        if (k10 == null) {
            a aVar3 = this.f35958a;
            if (aVar3 != null) {
                String str2 = this.f35959b;
                aVar3.c(str2, String.valueOf(a10) + FM_Exception.insert(4, 17, "＄涑恥够瑊嘵乴稥"));
            }
            throw new BusinessException(String.valueOf(a10) + x2.b.b(242, "ｓ涂恺处琍噾乻稶"), BusinessException.ErrorMessage.local_message_load_config_fail);
        }
        String m10 = this.f35960c.m(1122);
        if (m10 == null) {
            a aVar4 = this.f35958a;
            if (aVar4 != null) {
                String str3 = this.f35959b;
                aVar4.c(str3, String.valueOf(a10) + x2.a.b("旾＜莯取夌琖皜帳厸奡赽", 152, 8));
            }
            throw new BusinessException(String.valueOf(a10) + x2.e.a(2, "斡ｖ菪取备琀皍广叿夣贰"), BusinessException.ErrorMessage.local_app_query_server_fail);
        }
        this.f35960c.e(a10, m10);
        cn.com.fmsh.tsm.business.bean.d r10 = r(bArr, k10, m10);
        this.f35960c.d(false);
        return r10;
    }

    @Override // r2.d
    public String f(byte[] bArr) throws BusinessException {
        byte[] bArr2;
        if (this.f35958a == null) {
            this.f35958a = b.a().b();
        }
        a aVar = this.f35958a;
        if (aVar != null) {
            aVar.e(this.f35959b, x2.d.c("菮厜诹匙双祦颙叆凬讓mzk", DfuException.ERROR_NO_SERVICE_FOUND_OR_LOSS));
        }
        String insert = FM_Exception.insert(2, 44, "莱叄诼卟叇礪颈双冫诓");
        if (bArr == null || bArr.length < 1) {
            a aVar2 = this.f35958a;
            if (aVar2 != null) {
                aVar2.c(this.f35959b, x2.a.b("菣历诮匝厕礨飚厎冹讑｀佨儡盄设卍缂叧丶穲", 4, 124));
            }
            throw new BusinessException(f.a("获友许卂叅祹颈叝凥评．使儹盝说匆罆厺买稽", DfuException.ERROR_ENTER_OTA_MODE_FAILED), BusinessException.ErrorMessage.local_business_para_error);
        }
        f fVar = this.f35960c;
        if (fVar == null) {
            a aVar3 = this.f35958a;
            if (aVar3 != null) {
                aVar3.c(this.f35959b, x2.d.c("菢厐诵匝又祢额叚冰讏ｓ乊勠外琅寭豤乬稽", 2));
            }
            throw new BusinessException(h.e("菤厎访南取礤飗叀凶证ｉ乐劮夐瑟嘶剞姃匛奣赲", 118, 101), BusinessException.ErrorMessage.local_business_init_fail);
        }
        f2.b k10 = fVar.k();
        if (k10 == null) {
            a aVar4 = this.f35958a;
            if (aVar4 != null) {
                aVar4.c(this.f35959b, x2.g.a(2, 85, "菥厑设匄厗祳飖厓凷讎ｈ涑怡奇琞嘥乸穭"));
            }
            throw new BusinessException(x2.c.i("莺厏诧匄双祡颓受冠讘ｉ涙恲复瑓嘩乷穣", 150, 108), BusinessException.ErrorMessage.local_message_load_config_fail);
        }
        String m10 = this.f35960c.m(3062);
        if (m10 == null) {
            a aVar5 = this.f35958a;
            if (aVar5 != null) {
                aVar5.c(this.f35959b, String.valueOf(insert) + x2.e.a(DfuException.ERROR_READ_PATCH_INFO_ERROR, "旳＄莼变夕琒皓幩叭失账"));
            }
            throw new BusinessException(String.valueOf(insert) + x2.g.a(368, 69, "斶）菽叙奐琟盚帰司奼贷"), BusinessException.ErrorMessage.local_app_query_server_fail);
        }
        this.f35960c.e(insert, m10);
        f2.a e10 = k10.e(3062);
        String str = null;
        try {
            c c10 = k10.c((byte) 105);
            c10.e(bArr);
            e10.c(c10);
            bArr2 = e10.a();
        } catch (FMCommunicationMessageException e11) {
            a aVar6 = this.f35958a;
            if (aVar6 != null) {
                aVar6.c(this.f35959b, h.e("菩反诺區厃祧飊叟冫诂ｌ枙遺幤厤详氌敻挦凿珲彝帤ｃ", 1, 61) + h.f(e11));
            }
            this.f35960c.t(f.a("莧叛讨卒叕祩题反凵诔＞枋逬幺叶说求攭挴冭珤当并", 168), BusinessException.ErrorMessage.local_message_message_handle_exception, false);
            bArr2 = null;
        }
        byte[] n10 = this.f35960c.n(bArr2, insert, false, m10);
        if (n10 == null || n10.length < 2) {
            a aVar7 = this.f35958a;
            if (aVar7 != null) {
                aVar7.c(this.f35959b, FM_Exception.insert(174, 37, "莥厁课協厗礣颖參冷讞（纁窡掶攮剭既敏盈帢另哖廔敵捤"));
            }
            this.f35960c.t(f.a("莼叞讧南厎礴食厀冾讑ａ纂窨握敷剮斻攐监帡县咁廝收挭", 3), BusinessException.ErrorMessage.local_message_command_data_invaild, false);
        }
        byte[] bArr3 = new byte[2];
        System.arraycopy(n10, 0, bArr3, 0, 2);
        if (!Arrays.equals(v2.b.f35577a, bArr3)) {
            a aVar8 = this.f35958a;
            if (aVar8 != null) {
                aVar8.c(this.f35959b, x2.a.b("菹压诮匎叛祱颎叁冫讔h帠史夕理夾贻w", 94, 15) + x2.c.c(n10));
            }
            this.f35960c.t(x2.e.a(222, "菤厀读匉厎礪飃厞冦讏｝帧厧奞瑛失账"), BusinessException.ErrorMessage.instance(x2.c.c(bArr3)), false);
        }
        try {
            c b10 = k10.b(3062, Arrays.copyOfRange(n10, 2, n10.length)).b(66);
            if (b10 != null) {
                str = x2.c.c(b10.h());
            }
        } catch (FMCommunicationMessageException unused) {
            a aVar9 = this.f35958a;
            if (aVar9 != null) {
                aVar9.c(this.f35959b, x2.d.c("菲叀讥卍变礲飍厊冠诟＃解极幱厣咉廁收捹弊帡０", 82) + x2.c.c(n10));
            }
            this.f35960c.t(x2.e.a(2, "菠厌诿单叒祮颏叚凢诓９绐竴掻攷刴旧敂皉幣口哛庍敬捱"), BusinessException.ErrorMessage.local_message_command_data_invaild, false);
        }
        this.f35960c.d(false);
        return str;
    }

    @Override // r2.d
    public byte[] g(EnumCardAppType enumCardAppType) throws BusinessException {
        if (this.f35958a == null) {
            this.f35958a = b.a().b();
        }
        a aVar = this.f35958a;
        if (aVar != null) {
            aVar.e(this.f35959b, x2.g.a(5, 22, "菢叝底甿廂剔厮!+5"));
        }
        t2.a a10 = s2.a.b().a(enumCardAppType);
        byte[] bArr = null;
        if (a10 == null) {
            a aVar2 = this.f35958a;
            if (aVar2 != null) {
                aVar2.c(this.f35959b, f.a("莻叟庒甫序削厭斡ｘ菦厘捌寒匤簹埔盘奝瑐嘻奡赨", 4));
            }
            return null;
        }
        ApduHandler i10 = this.f35960c.i();
        if (i10 == null) {
            a aVar3 = this.f35958a;
            if (aVar3 != null) {
                aVar3.b(this.f35959b, f.a("莻叟庒甫序削厭斡ｘ\u0010\u001e\u000f\u001d奁瑄嘷书稣", 4));
            }
            this.f35960c.t(x2.b.b(196, "菦厊廓畺廒刟古旨％诣兗前挷匡盏诩闯斵弘*BU\u0002a\u0017\u0002\fs"), BusinessException.ErrorMessage.local_business_apdu_handler_null, false);
        }
        if (i10.c()) {
            a aVar4 = this.f35958a;
            if (aVar4 != null) {
                aVar4.b(this.f35959b, x2.d.c("莰厎廝畲廄刋叺旨＃A\u0001\u0006\u0006奀琓噮歴忑", DfuException.ERROR_REQUEST_MTU_NO_CALLBACK));
            }
            this.f35960c.t(x2.c.i("菭原庌畯庙划厣旵～\u0000@\u001b[奙瑊噳欩忀", 3, 79), BusinessException.ErrorMessage.local_business_apdu_handler_busying, false);
        } else if (!i10.b()) {
            a aVar5 = this.f35958a;
            if (aVar5 != null) {
                aVar5.b(this.f35959b, x2.b.b(356, "菦厊库町庒刟古旨ｅ辊揺匫奤败"));
            }
            this.f35960c.t(x2.b.b(4, "莦及库町庒剟厤斨ｅ辊揺卫夤败"), BusinessException.ErrorMessage.local_message_apdu_execute_exception, true);
        }
        a10.a(i10);
        try {
            try {
                bArr = a10.d();
            } catch (BusinessException unused) {
                if (this.f35958a != null) {
                    this.f35958a.b(this.f35959b, FM_Exception.insert(214, 72, "菭叔廞町廕剕叽斤几珲弈幪"));
                }
                this.f35960c.t(FM_Exception.insert(1, 121, "莲厈廃畸廆剕厬斢冷珶弝帠"), BusinessException.ErrorMessage.local_message_apdu_execute_exception, true);
            }
            return bArr;
        } finally {
            i10.close();
        }
    }

    @Override // r2.d
    public String h(EnumCardAppType enumCardAppType) throws BusinessException {
        if (this.f35958a == null) {
            this.f35958a = b.a().b();
        }
        a aVar = this.f35958a;
        if (aVar != null) {
            aVar.e(this.f35959b, FM_Exception.insert(4, 43, "莿叅仺逓卵盛卫靷厷%8o"));
        }
        t2.a a10 = s2.a.b().a(enumCardAppType);
        String str = null;
        if (a10 == null) {
            a aVar2 = this.f35958a;
            if (aVar2 != null) {
                aVar2.c(this.f35959b, x2.b.b(224, "菺厎卢靬叮旲＃莭厓捗寁匧簪埗皃外琛噠夢贻"));
            }
            return null;
        }
        ApduHandler i10 = this.f35960c.i();
        if (i10 == null) {
            a aVar3 = this.f35958a;
            if (aVar3 != null) {
                aVar3.b(this.f35959b, x2.d.c("莲叀卦霺厾斬ｇ]]ZZ处瑗嘪乩稾", 306));
            }
            this.f35960c.t(h.e("莶厂匦霸厺斶？诱兑刋挽匳盁诧閥斧弞,XG\u001c\u007f\r\u0010\n5", 4, 115), BusinessException.ErrorMessage.local_business_apdu_handler_null, false);
        }
        if (i10.c()) {
            a aVar4 = this.f35958a;
            if (aVar4 != null) {
                aVar4.b(this.f35959b, x2.g.a(202, 83, "莭叛匡靱叱斯\uff00\u001e\u0002A\r奏琘嘹欧忎"));
            }
            this.f35960c.t(x2.b.b(6, "莤又卨靶叨於ｙ\u0001\u001b\u0012T夈琑噪歮忁"), BusinessException.ErrorMessage.local_business_apdu_handler_busying, false);
        } else if (!i10.b()) {
            a aVar5 = this.f35958a;
            if (aVar5 != null) {
                aVar5.b(this.f35959b, x2.d.c("華原医霩叫旻２近接匰女赶", 5));
            }
            this.f35960c.t(x2.g.a(5, 51, "菢叞区靬厶斢＋辄推匡奢责"), BusinessException.ErrorMessage.local_message_apdu_execute_exception, true);
        }
        a10.a(i10);
        try {
            try {
                str = a10.f();
            } catch (BusinessException unused) {
                if (this.f35958a != null) {
                    this.f35958a.b(this.f35959b, h.e("获厚匹霦叧旪凲珤彂年", 3, 108));
                }
                this.f35960c.t(x2.d.c("華原医霩叫旻凤玿异幩", 5), BusinessException.ErrorMessage.local_message_apdu_execute_exception, true);
            }
            return str;
        } finally {
            i10.close();
        }
    }

    @Override // r2.d
    public List<CardAppRecord> i(EnumCardAppType enumCardAppType) throws BusinessException {
        if (this.f35958a == null) {
            this.f35958a = b.a().b();
        }
        a aVar = this.f35958a;
        if (aVar != null) {
            aVar.e(this.f35959b, x2.g.a(212, 5, "菳原匯盗仼晎诲弒b\u007fx"));
        }
        String b10 = x2.b.b(1, "莹叏卥皋亾晖诠弎");
        t2.a a10 = s2.a.b().a(enumCardAppType);
        List<CardAppRecord> list = null;
        if (a10 == null) {
            a aVar2 = this.f35958a;
            if (aVar2 != null) {
                String str = this.f35959b;
                aVar2.c(str, String.valueOf(b10) + FM_Exception.insert(3, 78, "＋菢叕捖宅卬簠垂盓奁琕嘩夾赸"));
            }
            return null;
        }
        ApduHandler i10 = this.f35960c.i();
        if (i10 == null) {
            a aVar3 = this.f35958a;
            if (aVar3 != null) {
                String str2 = this.f35959b;
                aVar3.b(str2, String.valueOf(b10) + h.e("斳＇\u0010G\u0019V奍琉嘽両穻", 328, 70));
            }
            f fVar = this.f35960c;
            fVar.t(String.valueOf(b10) + h.e("时｜请儘則捲匡皔访閾方彟h_\rQ/\u001eF\u0013i", 3, 80), BusinessException.ErrorMessage.local_business_apdu_handler_null, false);
        }
        if (i10.c()) {
            a aVar4 = this.f35958a;
            if (aVar4 != null) {
                String str3 = this.f35959b;
                aVar4.b(str3, String.valueOf(b10) + f.a("旼＋EQ\u001a\u000e奜瑓嘺欬徕", 2));
            }
            f fVar2 = this.f35960c;
            fVar2.t(String.valueOf(b10) + x2.b.b(2, "旹６D@_\u0013奕瑚嘯欱径"), BusinessException.ErrorMessage.local_business_apdu_handler_busying, false);
        } else if (!i10.b()) {
            a aVar5 = this.f35958a;
            if (aVar5 != null) {
                String str4 = this.f35959b;
                aVar5.b(str4, String.valueOf(b10) + x2.g.a(4, 26, "斢＂迖揧匽奧贵"));
            }
            f fVar3 = this.f35960c;
            fVar3.t(String.valueOf(b10) + x2.g.a(2, 3, "斤ｙ辆揾匿夰贡"), BusinessException.ErrorMessage.local_message_apdu_execute_exception, true);
        }
        a10.a(i10);
        try {
            try {
                list = a10.e();
            } catch (BusinessException unused) {
                if (this.f35958a != null) {
                    a aVar6 = this.f35958a;
                    String str5 = this.f35959b;
                    aVar6.b(str5, String.valueOf(b10) + x2.b.b(1, "旸凣玴弍帢"));
                }
                f fVar4 = this.f35960c;
                fVar4.t(String.valueOf(b10) + x2.g.a(2, 68, "斤凬珪弜帺"), BusinessException.ErrorMessage.local_message_apdu_execute_exception, true);
            }
            return list;
        } finally {
            i10.close();
        }
    }

    @Override // r2.d
    public String j(EnumCardAppType enumCardAppType) throws BusinessException {
        if (this.f35958a == null) {
            this.f35958a = b.a().b();
        }
        a aVar = this.f35958a;
        if (aVar != null) {
            aVar.e(this.f35959b, f.a("莻叟卧皇有攕杅yz\u007f", 4));
        }
        t2.a a10 = s2.a.b().a(enumCardAppType);
        String str = null;
        if (a10 == null) {
            return null;
        }
        ApduHandler i10 = this.f35960c.i();
        if (i10 == null) {
            a aVar2 = this.f35958a;
            if (aVar2 != null) {
                aVar2.b(this.f35959b, f.a("莻叟卧三应畵杓攟杋斧ｂ\n\u0018\u0001\u0017奛瑚嘱乬稩", 4));
            }
            this.f35960c.t(x2.d.c("菡厑匹乃庎産朕故杁方ｌ讦儊刔捦却皂诨閦无彅3CPOp\u001e\u0007\u0011j", 3), BusinessException.ErrorMessage.local_business_apdu_handler_null, false);
        }
        if (i10.c()) {
            a aVar3 = this.f35958a;
            if (aVar3 != null) {
                aVar3.b(this.f35959b, x2.e.a(2, "菠厌匼上店甮最敄朐旤９YKZT夀琁噢歮忉"));
            }
            this.f35960c.t(x2.e.a(DfuException.ERROR_REQUEST_MTU_NO_CALLBACK, "莾叚卮丘庁田朒敖朞旲＋K]TF夒琟噴歼徛"), BusinessException.ErrorMessage.local_business_apdu_handler_busying, false);
        } else if (!i10.b()) {
            a aVar4 = this.f35958a;
            if (aVar4 != null) {
                aVar4.b(this.f35959b, FM_Exception.insert(6, 54, "莽厖匷丆廖田杇敌朅斦＊辂掷匩奯贱"));
            }
            this.f35960c.t(FM_Exception.insert(5, 49, "莾双匪世廙當朆攈朎斴｟迚揰卧夦赭"), BusinessException.ErrorMessage.local_message_apdu_execute_exception, true);
        }
        a10.a(i10);
        try {
            try {
                str = a10.c();
            } catch (BusinessException unused) {
                if (this.f35958a != null) {
                    this.f35958a.b(this.f35959b, x2.d.c("菠厞匸乀序甤朔敆杀斦冻珢彁帬", 4));
                }
                this.f35960c.t(x2.c.i("莢叛匤丗庁略杌敕杊斻凿班彗帵", 318, 88), BusinessException.ErrorMessage.local_message_apdu_execute_exception, true);
            }
            return str;
        } finally {
            i10.close();
        }
    }

    @Override // r2.d
    public int k(UserInfo userInfo) throws BusinessException {
        String str;
        byte[] bArr;
        String b10 = x2.a.b("畻扱沱净", 3, 115);
        if (this.f35958a == null) {
            this.f35958a = b.a().b();
        }
        a aVar = this.f35958a;
        if (aVar != null) {
            aVar.e(this.f35959b, x2.d.c("畽扱沿凄１\\~~oｇq~o", 2));
        }
        if (userInfo == null) {
            throw new BusinessException(x2.e.a(5, "畲扪注冏旰％伬兪皖甽戯俺恱主穾"), BusinessException.ErrorMessage.local_business_para_error);
        } else if (userInfo.getUserName() == null || userInfo.getUserName().length() < 1) {
            a aVar2 = this.f35958a;
            if (aVar2 != null) {
                aVar2.c(this.f35959b, x2.g.a(4, 92, "畼执泤冄斲ｌ似儽盐甸戻赮厳为稦"));
            }
            throw new BusinessException(x2.d.c("畼扲沾凋旮％伺兮盘略扩赩厷丫穸", 1), BusinessException.ErrorMessage.local_business_para_error);
        } else if (userInfo.getPassword() == null || userInfo.getPassword().length() < 1) {
            a aVar3 = this.f35958a;
            if (aVar3 != null) {
                aVar3.c(this.f35959b, h.e("甩戡沣册斣＆伿儱皍當戤宎硜丨稽", 4, 53));
            }
            throw new BusinessException(x2.g.a(DfuException.ERROR_READ_PATCH_INFO_ERROR, 123, "用扬沾凝斺ｋ佢儸盜畻批宏硅严穠"), BusinessException.ErrorMessage.local_business_para_error);
        } else if (userInfo.getPassword().length() <= 32) {
            f fVar = this.f35960c;
            if (fVar == null) {
                if (this.f35958a == null) {
                    this.f35958a = b.a().b();
                }
                a aVar4 = this.f35958a;
                if (aVar4 != null) {
                    aVar4.c(this.f35959b, x2.g.a(5, 105, "畽扩沯农旯．乑勵夙琀寶谹乻稰"));
                }
                throw new BusinessException(FM_Exception.insert(68, 25, "畠扶沲冟旺ｉ乄勶夔琏嘪剆妟匛夷贺"), BusinessException.ErrorMessage.local_business_init_fail);
            }
            i j10 = fVar.j();
            if (j10 != null) {
                str = j10.g();
            } else {
                a aVar5 = this.f35958a;
                if (aVar5 != null) {
                    aVar5.c(this.f35959b, h.e("畷扼沿减旹７D<1-~d}:3:pe7丹稵", 2, 108));
                }
                str = null;
            }
            if (str == null) {
                a aVar6 = this.f35958a;
                if (aVar6 != null) {
                    aVar6.c(this.f35959b, x2.e.a(172, "甩戳泯円旻＜酞罸斞仪串杨區呣叉唈罇硕"));
                }
                throw new BusinessException(x2.b.b(3, "甸戬泮冝旪ｋ畺扪戈對唘戾丮穥"), BusinessException.ErrorMessage.local_business_para_error);
            }
            f2.b k10 = this.f35960c.k();
            if (k10 == null) {
                a aVar7 = this.f35958a;
                if (aVar7 != null) {
                    aVar7.c(this.f35959b, x2.b.b(278, "甫戹泱凈方ｖ淍怿奟琀噹並穽"));
                }
                throw new BusinessException(x2.g.a(6, 81, "畾扰泰凅旬＇淔恢奚瑉器乫稸"), BusinessException.ErrorMessage.local_message_load_config_fail);
            }
            String m10 = this.f35960c.m(1002);
            if (m10 == null) {
                a aVar8 = this.f35958a;
                if (aVar8 != null) {
                    String str2 = this.f35959b;
                    aVar8.c(str2, String.valueOf(b10) + x2.d.c("旫＂菨历奅瑔盇幧叵大财", 298));
                }
                throw new BusinessException(String.valueOf(b10) + FM_Exception.insert(194, 17, "新｛菿厏夎琝皈幮厾奮赵"), BusinessException.ErrorMessage.local_app_query_server_fail);
            }
            this.f35960c.e(b10, m10);
            f2.a e10 = k10.e(1002);
            try {
                c c10 = k10.c((byte) 1);
                c10.c(userInfo.getUserType());
                e10.c(c10);
                c c11 = k10.c((byte) 2);
                c11.f(userInfo.getUserName());
                e10.c(c11);
                c c12 = k10.c((byte) 3);
                c12.f(userInfo.getPassword());
                e10.c(c12);
                if (userInfo.getMail() != null && userInfo.getMail().length() > 1) {
                    c c13 = k10.c((byte) 4);
                    c13.f(userInfo.getMail());
                    e10.c(c13);
                }
                if (userInfo.getPhone() != null && userInfo.getPhone().length() > 1) {
                    c c14 = k10.c((byte) 5);
                    c14.f(userInfo.getPhone());
                    e10.c(c14);
                }
                if (userInfo.getRealName() != null && userInfo.getRealName().length() > 1) {
                    c c15 = k10.c((byte) 6);
                    c15.f(userInfo.getRealName());
                    e10.c(c15);
                }
                if (userInfo.getCertType() != -1) {
                    c c16 = k10.c((byte) 7);
                    c16.c(userInfo.getCertType());
                    e10.c(c16);
                }
                if (userInfo.getCertNo() != null && userInfo.getCertNo().length() > 1) {
                    c c17 = k10.c((byte) 8);
                    c17.f(userInfo.getCertNo());
                    e10.c(c17);
                }
                c c18 = k10.c((byte) -119);
                c18.f(str);
                e10.c(c18);
                bArr = e10.a();
            } catch (FMCommunicationMessageException e11) {
                a aVar9 = this.f35958a;
                if (aVar9 != null) {
                    String str3 = this.f35959b;
                    aVar9.c(str3, x2.e.a(3, "異扬沶再(枃逪幾叠诤汔敩捲弝帺?") + h.f(e11));
                }
                this.f35960c.t(x2.c.i("畴扠沺凁d柇遾帪厤许氈攵挮太贳", 5, 123), BusinessException.ErrorMessage.local_message_message_handle_exception, false);
                bArr = null;
            }
            byte[] n10 = this.f35960c.n(bArr, x2.c.i("畻扵泹册", 92, 111), false, m10);
            byte[] copyOf = Arrays.copyOf(n10, 2);
            this.f35960c.d(false);
            if (Arrays.equals(v2.b.f35577a, copyOf)) {
                return 0;
            }
            a aVar10 = this.f35958a;
            if (aVar10 != null) {
                String str4 = this.f35959b;
                aVar10.b(str4, x2.b.b(3, "甸戬泮冝０帴厢咐廜镊讱哄庀砞05") + x2.c.c(n10));
            }
            return x2.d.a(copyOf);
        } else {
            throw new BusinessException(x2.e.a(334, "畫扱没净方～畽扯宝铻锾廢徂頱层仞`d"), BusinessException.ErrorMessage.local_business_para_error);
        }
    }

    @Override // r2.d
    public boolean l(byte[] bArr, byte[] bArr2) throws BusinessException {
        String insert = FM_Exception.insert(1, 9, "卤丄広用圁孊");
        if (this.f35958a == null) {
            this.f35958a = b.a().b();
        }
        a aVar = this.f35958a;
        if (aVar != null) {
            aVar.e(this.f35959b, x2.g.a(6, 45, "匷三廄畵圂嬏*?p"));
        }
        if (bArr == null || bArr.length < 1) {
            a aVar2 = this.f35958a;
            if (aVar2 != null) {
                String str = this.f35959b;
                aVar2.c(str, String.valueOf(insert) + x2.d.c("斠ｋ佸儬皞让卉缛厩乵稺", 3));
            }
            throw new BusinessException(String.valueOf(insert) + x2.d.c("旱４伩儿盏课匘缈司为穫", CameraConfig.CAMERA_THIRD_DEGREE), BusinessException.ErrorMessage.local_business_para_error);
        } else if (bArr2 == null || bArr2.length < 1) {
            a aVar3 = this.f35958a;
            if (aVar3 != null) {
                String str2 = this.f35959b;
                aVar3.c(str2, String.valueOf(insert) + x2.e.a(3, "斮ｗ佾兤皀卦庞甥废刄叡丣穦"));
            }
            throw new BusinessException(String.valueOf(insert) + FM_Exception.insert(4, 65, "旾ｅ伪儮皈匬庚畧废剆句乩穮"), BusinessException.ErrorMessage.local_business_para_error);
        } else {
            f fVar = this.f35960c;
            if (fVar == null) {
                a aVar4 = this.f35958a;
                if (aVar4 != null) {
                    String str3 = this.f35959b;
                    aVar4.c(str3, String.valueOf(insert) + FM_Exception.insert(210, 49, "斠＋丂勨夞瑍宥豬乤穵"));
                }
                throw new BusinessException(String.valueOf(insert) + h.e("时ｂ丆勫夜琀嘼刟妛匈夽赿", 3, 78), BusinessException.ErrorMessage.local_business_init_fail);
            }
            f2.b k10 = fVar.k();
            if (k10 == null) {
                a aVar5 = this.f35958a;
                if (aVar5 != null) {
                    String str4 = this.f35959b;
                    aVar5.c(str4, String.valueOf(insert) + h.e("时１淒恸奐琗嘦丱稲", 3, 61));
                }
                throw new BusinessException(String.valueOf(insert) + FM_Exception.insert(2, 91, "旰ｍ涔恸奖瑋噠丹稤"), BusinessException.ErrorMessage.local_message_load_config_fail);
            }
            String m10 = this.f35960c.m(3011);
            if (m10 == null) {
                a aVar6 = this.f35958a;
                if (aVar6 != null) {
                    String str5 = this.f35959b;
                    aVar6.c(str5, String.valueOf(insert) + h.e("旣４莬又夅琂皃幹叽夡贶", 152, 3));
                }
                throw new BusinessException(String.valueOf(insert) + x2.e.a(2, "斡ｖ菪取备琀皍广叿夣贰"), BusinessException.ErrorMessage.local_app_query_server_fail);
            }
            this.f35960c.e(insert, m10);
            return t(bArr, bArr2, k10, m10);
        }
    }

    @Override // r2.d
    public cn.com.fmsh.tsm.business.bean.d m(int i10, int i11, byte[] bArr, EnumCardAppType enumCardAppType) throws BusinessException {
        byte b10;
        a aVar;
        String c10 = x2.d.c("诶匐略记", 1);
        if (this.f35958a == null) {
            this.f35958a = b.a().b();
        }
        a aVar2 = this.f35958a;
        if (aVar2 != null) {
            aVar2.a(this.f35959b, x2.e.a(5, "诸匈申说('\""));
        }
        if (i10 < 0 || i11 < 0 || enumCardAppType == null) {
            a aVar3 = this.f35958a;
            if (aVar3 != null) {
                aVar3.c(this.f35959b, String.valueOf(c10) + x2.d.c("斯ｆ佻儩皙双敯弒帹", 6));
            }
            throw new BusinessException(String.valueOf(c10) + x2.d.c("旿ｖ佫儹盉叜敿异帩", 150), BusinessException.ErrorMessage.local_business_para_error);
        }
        f fVar = this.f35960c;
        if (fVar == null) {
            a aVar4 = this.f35958a;
            if (aVar4 != null) {
                aVar4.c(this.f35959b, String.valueOf(c10) + h.e("旷＊丑励夑琜實豥丳穴", 4, 5));
            }
            throw new BusinessException(String.valueOf(c10) + x2.g.a(192, 73, "旦ｕ乘努奐琛嘮划妓南夻赶"), BusinessException.ErrorMessage.local_business_init_fail);
        }
        ApduHandler i12 = fVar.i();
        if (i12 == null) {
            a aVar5 = this.f35958a;
            if (aVar5 != null) {
                aVar5.b(this.f35959b, String.valueOf(c10) + h.e("旷，^\u000e\u0019I够瑜嘱丢穭", 4, 31));
            }
            this.f35960c.t(String.valueOf(c10) + x2.c.i("斫＋详兓刂捭卸盇诲閹旸彄}\u0010DR2IWXl", 134, 10), BusinessException.ErrorMessage.local_business_apdu_handler_null, false);
        }
        f2.b k10 = this.f35960c.k();
        if (k10 == null) {
            a aVar6 = this.f35958a;
            if (aVar6 != null) {
                aVar6.c(this.f35959b, String.valueOf(c10) + FM_Exception.insert(3, 77, "旱ｘ涉怡够琎嘽丸稵"));
            }
            throw new BusinessException(String.valueOf(c10) + x2.c.i("斬（涆恷夆琊噾乺稰", 3, 10), BusinessException.ErrorMessage.local_message_load_config_fail);
        }
        i j10 = this.f35960c.j();
        if (j10 != null) {
            b10 = j10.j();
            if (b10 == 0 && (aVar = this.f35958a) != null) {
                aVar.c(this.f35959b, String.valueOf(c10) + FM_Exception.insert(2, 94, "旰ｈ诠单朻滌圲酕缸旓令丽杤寖乃"));
            }
        } else {
            a aVar7 = this.f35958a;
            if (aVar7 != null) {
                aVar7.c(this.f35959b, String.valueOf(c10) + x2.a.b("旸｟朲戣刲鄊罢旖仠", 286, 69));
            }
            b10 = 0;
        }
        String m10 = this.f35960c.m(1112);
        if (m10 == null) {
            a aVar8 = this.f35958a;
            if (aVar8 != null) {
                aVar8.c(this.f35959b, String.valueOf(c10) + FM_Exception.insert(3, 30, "旱）菴厗奛琛皟帪厧夤贶"));
            }
            throw new BusinessException(String.valueOf(c10) + x2.c.i("斬１获厕夂瑏皈帼叢奤贽", 3, 67), BusinessException.ErrorMessage.local_app_query_server_fail);
        }
        this.f35960c.e(c10, m10);
        cn.com.fmsh.tsm.business.bean.d p10 = p(b10, i10, i11, enumCardAppType.getId(), bArr, k10, i12, m10);
        this.f35960c.d(false);
        return p10;
    }

    @Override // r2.d
    public List<BusinessOrder> n(int i10, int i11, EnumCardAppType enumCardAppType, EnumBusinessOrderType enumBusinessOrderType, List<EnumOrderStatus> list, byte[] bArr) throws BusinessException {
        if (this.f35958a == null) {
            this.f35958a = b.a().b();
        }
        a aVar = this.f35958a;
        if (aVar != null) {
            aVar.e(this.f35959b, x2.c.i("乀劤讲华柣诳4\u00117/|zp':", 3, 11));
        }
        String a10 = x2.e.a(4, "乃勽诽南柠诪");
        f fVar = this.f35960c;
        if (fVar == null) {
            a aVar2 = this.f35958a;
            if (aVar2 != null) {
                aVar2.c(this.f35959b, x2.b.b(92, "乓勵诽卟柰询＇丌勠奈瑑宻谬乢穹"));
            }
            throw new BusinessException(h.e("丛勿讹卍枰记＃世勨奂琅器剀姑匁奥赴", 4, 93), BusinessException.ErrorMessage.local_business_init_fail);
        }
        f2.b k10 = fVar.k();
        if (k10 == null) {
            a aVar3 = this.f35958a;
            if (aVar3 != null) {
                aVar3.c(this.f35959b, h.e("业劬诸卒柱讣＂涓性夑瑄嘧並稳", 3, 45));
            }
            throw new BusinessException(x2.e.a(DfuException.ERROR_NO_SERVICE_FOUND_OR_LOSS, "乁勿讣卑柢诨！涘恼夒琟噴严穸"), BusinessException.ErrorMessage.local_message_load_config_fail);
        }
        String m10 = this.f35960c.m(1134);
        if (m10 == null) {
            a aVar4 = this.f35958a;
            if (aVar4 != null) {
                String str = this.f35959b;
                aVar4.c(str, String.valueOf(a10) + x2.b.b(4, "旧０莰叄夙瑎盗席厹奥赺"));
            }
            throw new BusinessException(String.valueOf(a10) + x2.e.a(2, "斡ｖ菪取备琀皍广叿夣贰"), BusinessException.ErrorMessage.local_app_query_server_fail);
        }
        this.f35960c.e(a10, m10);
        List<BusinessOrder> s10 = s(list, i10 + i11, enumCardAppType, enumBusinessOrderType, k10, bArr, m10);
        this.f35960c.d(false);
        return s10;
    }

    @Override // r2.d
    public cn.com.fmsh.tsm.business.bean.c o(String str, String str2) throws BusinessException {
        String str3;
        String e10 = h.e("甪戴癿彐", 5, 1);
        if (this.f35958a == null) {
            this.f35958a = b.a().b();
        }
        a aVar = this.f35958a;
        if (aVar != null) {
            aVar.e(this.f35959b, FM_Exception.insert(5, 85, "甡扩癨彝ｕDb.#／u>+"));
        }
        if (str == null || "".equals(str) || str2 == null || "".equals(str2)) {
            throw new BusinessException(f.a("異扢瘩弚斺ｅ佦儦盄电戭吚戂耔寈砊串穿", 208), BusinessException.ErrorMessage.local_business_para_error);
        }
        f fVar = this.f35960c;
        if (fVar == null) {
            a aVar2 = this.f35958a;
            if (aVar2 != null) {
                aVar2.c(this.f35959b, x2.d.c("畾扰瘣弜旬＇丆劬奚瑉容谰乸穩", 3));
            }
            throw new BusinessException(f.a("畾扤瘫弘於ｋ乞勠奚瑝嘰剈妙卙好赬", 238), BusinessException.ErrorMessage.local_business_init_fail);
        }
        f2.b k10 = fVar.k();
        if (k10 == null) {
            a aVar3 = this.f35958a;
            if (aVar3 != null) {
                aVar3.c(this.f35959b, x2.a.b("甤扵癣弛旲６淘恩奘琔嘠乤穮", 316, 54));
            }
            throw new BusinessException(x2.e.a(5, "畲扪登彖旰％涄恠外琓噰両穤"), BusinessException.ErrorMessage.local_message_load_config_fail);
        }
        i j10 = this.f35960c.j();
        byte[] bArr = null;
        if (j10 != null) {
            str3 = j10.g();
        } else {
            a aVar4 = this.f35958a;
            if (aVar4 != null) {
                aVar4.c(this.f35959b, FM_Exception.insert(2, 46, "甮戣瘹彅旨｀Y'8b;g|=~q)zb乪穤"));
            }
            str3 = null;
        }
        if (str3 == null) {
            a aVar5 = this.f35958a;
            if (aVar5 != null) {
                aVar5.c(this.f35959b, x2.g.a(340, 113, "畬戢白彂旾ｕ畢扬戌屃啈戨个穻"));
            }
            throw new BusinessException(x2.g.a(4, 40, "畼戫瘿弙既０畬戻扔専啂戻乮稦"), BusinessException.ErrorMessage.local_business_para_error);
        }
        String m10 = this.f35960c.m(1022);
        if (m10 == null) {
            a aVar6 = this.f35958a;
            if (aVar6 != null) {
                aVar6.c(this.f35959b, String.valueOf(e10) + x2.e.a(110, "斵ｊ菾厚奋瑔监師厫奯贤"));
            }
            throw new BusinessException(String.valueOf(e10) + x2.g.a(3, 38, "斥５莨厓夏琗盓帮右奸赪"), BusinessException.ErrorMessage.local_app_query_server_fail);
        }
        this.f35960c.e(e10, m10);
        f2.a e11 = k10.e(1022);
        try {
            c c10 = k10.c((byte) 2);
            c10.f(str);
            e11.c(c10);
            c c11 = k10.c((byte) 3);
            c11.f(str2);
            e11.c(c11);
            c c12 = k10.c((byte) -119);
            c12.f(str3);
            e11.c(c12);
            bArr = e11.a();
        } catch (FMCommunicationMessageException e12) {
            a aVar7 = this.f35958a;
            if (aVar7 != null) {
                aVar7.c(this.f35959b, x2.d.c("異找瘡弞旪！枚逯平厡讵民攴捻凼玧弊幡ｐ", 5) + h.f(e12));
            }
            this.f35960c.t(x2.a.b("畾扰瘣弜旬＇枘逭席县讷氓攲捽凾玥弄幯", 6, 113), BusinessException.ErrorMessage.local_message_message_handle_exception, false);
        }
        byte[] n10 = this.f35960c.n(bArr, h.e("畧戤癬弎", 242, 36), false, m10);
        byte[] bArr2 = new byte[2];
        System.arraycopy(n10, 0, bArr2, 0, 2);
        cn.com.fmsh.tsm.business.bean.c cVar = new cn.com.fmsh.tsm.business.bean.c();
        if (n10.length != 2) {
            try {
                f2.a b10 = k10.b(1021, Arrays.copyOfRange(n10, 2, n10.length));
                cVar.c(h.b(x2.d.b(bArr2), 1001));
                c b11 = b10.b(36);
                if (b11 != null) {
                    cVar.b(b11.d());
                }
                c b12 = b10.b(43);
                if (b12 != null) {
                    cVar.d(b12.d());
                }
            } catch (FMCommunicationMessageException e13) {
                a aVar8 = this.f35958a;
                if (aVar8 != null) {
                    aVar8.c(this.f35959b, FM_Exception.insert(3, 10, "甯戦癠彐旹５覠柝帤厱咆廁支捧凩玭弅帩!") + h.f(e13));
                }
            }
        } else if (Arrays.equals(v2.b.f35577a, bArr2)) {
            cVar.c(0);
        } else {
            cVar.c(x2.d.a(bArr2));
        }
        this.f35960c.d(false);
        return cVar;
    }
}
