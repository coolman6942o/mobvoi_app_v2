package w2;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.communication.core.LinkInfo;
import cn.com.fmsh.communication.exception.CommunicationException;
import cn.com.fmsh.communication.exception.SocketException;
import cn.com.fmsh.communication.exception.session.CloseSessionException;
import cn.com.fmsh.communication.exception.session.OpenSessionException;
import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import cn.com.fmsh.exception.InvalidParameterException;
import cn.com.fmsh.script.ApduHandler;
import cn.com.fmsh.tsm.business.exception.BusinessException;
import com.realsil.sdk.dfu.DfuException;
import d2.b;
import d2.c;
import d2.d;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Random;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import w2.i;
import x2.e;
import x2.g;
import x2.h;
import z2.a;
/* loaded from: classes.dex */
public class f {

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ b f35964d;

    /* renamed from: e  reason: collision with root package name */
    private /* synthetic */ ApduHandler f35965e;

    /* renamed from: f  reason: collision with root package name */
    private /* synthetic */ f2.b f35966f;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ byte[] f35968h;

    /* renamed from: i  reason: collision with root package name */
    private /* synthetic */ byte[] f35969i;

    /* renamed from: j  reason: collision with root package name */
    private /* synthetic */ byte[] f35970j;

    /* renamed from: a  reason: collision with root package name */
    /* synthetic */ a f35961a = z2.b.a().b();

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f35962b = f.class.getName();

    /* renamed from: g  reason: collision with root package name */
    private /* synthetic */ i f35967g = null;

    /* renamed from: k  reason: collision with root package name */
    private /* synthetic */ cn.com.fmsh.script.a f35971k = null;

    /* renamed from: l  reason: collision with root package name */
    private /* synthetic */ h f35972l = new h();

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ d f35963c = d2.a.a();

    final /* bridge */ /* synthetic */ boolean a(c cVar) {
        return cVar.h();
    }

    final /* bridge */ /* synthetic */ boolean b(String str) throws BusinessException {
        c a10 = this.f35963c.a(str);
        if (a10 == null) {
            a aVar = this.f35961a;
            if (aVar != null) {
                aVar.c(this.f35962b, x2.b.b(6, "筭刮旿８绗窥辋揥剻帥叱夽贲"));
            }
            throw new BusinessException(g.a(5, 68, "笫利斫ｍ铻揬刽帢句奨贸"), BusinessException.ErrorMessage.local_communication_connect_fail);
        }
        if (!a10.c()) {
            a10 = f(str);
        }
        if (!a10.c()) {
            a aVar2 = this.f35961a;
            if (aVar2 != null) {
                aVar2.c(this.f35962b, x2.c.i("笵剧斵ｃ纓竨迍掺刻幤厳奾赾", 340, 12));
            }
            throw new BusinessException(x2.b.b(5, "筬刭旾？铠揬剤帬厺奤败"), BusinessException.ErrorMessage.local_communication_connect_fail);
        }
        e2.c cVar = new e2.c();
        i.a[] h10 = this.f35967g.h(str);
        if (h10 == null || h10.length < 1) {
            a aVar3 = this.f35961a;
            if (aVar3 != null) {
                aVar3.c(this.f35962b, x2.a.b("细章吁幢叢筭判询汔旡４酔罴斜仪丰朴宅三宇铧侢怫ｉ笸剷她赬", 318, 1));
            }
            throw new BusinessException(g.a(4, 53, "纜竦呏幠厸笣刢记汞斧＊酖缾斂京丢杮寃乇宅钽侬恭；笲刱奧贮"), BusinessException.ErrorMessage.local_communication_no_key);
        }
        int nextInt = h10.length > 1 ? new Random().nextInt(h10.length) : 0;
        cVar.j((byte) h10[nextInt].f35989a);
        cVar.i(h10[nextInt].f35990b);
        cVar.k(h10[nextInt].f35991c);
        cVar.n(this.f35967g.n());
        cVar.l(this.f35970j);
        if (this.f35967g.m() != null) {
            int length = this.f35967g.m().length;
        }
        byte[] bArr = this.f35968h;
        String k10 = this.f35967g.k();
        if (bArr != null) {
            if (k10 != null && this.f35967g.k().length() > 0) {
                byte[] m10 = x2.c.m(this.f35967g.k());
                bArr = x2.c.s(x2.c.s(bArr, new byte[]{4, (byte) m10.length}), m10);
            }
            if (this.f35967g.f() != null && this.f35967g.f().length() > 0) {
                byte[] m11 = x2.c.m(this.f35967g.f());
                bArr = x2.c.s(x2.c.s(bArr, new byte[]{5, (byte) m11.length}), m11);
            }
        } else {
            if (k10 != null && this.f35967g.k().length() > 0) {
                byte[] bytes = this.f35967g.k().getBytes();
                bArr = x2.c.s(new byte[]{4, (byte) bytes.length}, bytes);
            }
            if (this.f35967g.f() != null && this.f35967g.f().length() > 0) {
                byte[] m12 = x2.c.m(this.f35967g.f());
                bArr = x2.c.s(x2.c.s(bArr, new byte[]{5, (byte) m12.length}), m12);
            }
        }
        cVar.h(bArr);
        byte[] bArr2 = this.f35969i;
        if (bArr2 != null) {
            cVar.m(bArr2);
        } else {
            cVar.m(new byte[32]);
        }
        try {
            return a10.b(cVar, false);
        } catch (CommunicationException e10) {
            if (this.f35961a == null) {
                this.f35961a = z2.b.a().b();
            }
            a aVar4 = this.f35961a;
            if (aVar4 != null) {
                String str2 = this.f35962b;
                aVar4.c(str2, x2.d.c("纟窧呈帹叫筲刭旸ｓ遊侠攢挭弖帽，'", 4) + h.f(e10));
            }
            throw new BusinessException(e.a(1, "纞窶呍帬史筻券旽＂逋俵敧捴弟常"), BusinessException.ErrorMessage.local_communication_sign_in_fail);
        } catch (SocketException e11) {
            if (this.f35961a == null) {
                this.f35961a = z2.b.a().b();
            }
            a aVar5 = this.f35961a;
            if (aVar5 != null) {
                String str3 = this.f35962b;
                aVar5.c(str3, h.e("绊窵呃帹厲笤剢於ｎ罋绎弈帺 2", 5, 120) + h.f(e11));
            }
            throw new BusinessException(x2.d.c("纐窦呋常召筳刮旹，缀纞彑幼", 5), BusinessException.ErrorMessage.local_communication_connect_fail);
        } catch (OpenSessionException e12) {
            if (this.f35961a == null) {
                this.f35961a = z2.b.a().b();
            }
            if (e12.getExceptionType() != null) {
                a aVar6 = this.f35961a;
                if (aVar6 != null) {
                    String str4 = this.f35962b;
                    aVar6.c(str4, e.a(3, "纐窴呏干叴筹刺诺汒夗琐夨费３\"") + e12.getExceptionType().getDescription());
                }
            } else {
                a aVar7 = this.f35961a;
                if (aVar7 != null) {
                    String str5 = this.f35962b;
                    aVar7.c(str5, x2.a.b("纝窾吜幺厵笿刭议気夕琋奸赠－}", 5, 92) + h.f(e12));
                }
            }
            throw new BusinessException(FM_Exception.insert(DfuException.ERROR_DFU_ENABLE_BUFFER_CHECK_NO_RESPONSE, 79, "终窠吏幾厬筵剪设汚奃琐头赱"), BusinessException.ErrorMessage.local_communication_sign_in_fail);
        } catch (InvalidParameterException e13) {
            if (this.f35961a == null) {
                this.f35961a = z2.b.a().b();
            }
            a aVar8 = this.f35961a;
            if (aVar8 != null) {
                String str6 = this.f35962b;
                aVar8.c(str6, x2.d.c("纝窩呆帻叩筴叙敼施攆ｅp", 2) + h.f(e13));
            }
            throw new BusinessException(x2.b.b(230, "纛窱吘幧可筴受攰斫攞"), BusinessException.ErrorMessage.local_communication_sign_in_fail);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ boolean c(String str) throws BusinessException {
        c a10 = this.f35963c.a(str);
        if (a10 == null) {
            return false;
        }
        try {
            return a10.d(null);
        } catch (CommunicationException e10) {
            if (this.f35961a != null) {
                a aVar = this.f35961a;
                String str2 = this.f35962b;
                aVar.b(str2, x2.d.c("练窳呜席县笾逑诵汑夀瑓新｛遒俸敺捵夈瑛彌幧p", 152) + h.f(e10));
            }
            throw new BusinessException(x2.f.a("绅童吖幷叱笠遛讯気奖瑉斺ｅ遜侢攰挳奞瑑彖幩", 5), BusinessException.ErrorMessage.local_communication_sign_out_fail);
        } catch (SocketException e11) {
            if (this.f35961a != null) {
                a aVar2 = this.f35961a;
                String str3 = this.f35962b;
                aVar2.b(str3, x2.d.c("纝窩呆帻叩筴逛读氟奊瑙斦ｍ罃统凮玵彔广x", 2) + h.f(e11));
            }
            throw new BusinessException(x2.c.i("绗竬吖幸叿筭逗诬汝斵ｋ缚纓冩珧彙幧", 168, 4), BusinessException.ErrorMessage.local_communication_sign_out_fail);
        } catch (CloseSessionException e12) {
            if (this.f35961a != null) {
                a aVar3 = this.f35961a;
                String str4 = this.f35962b;
                aVar3.b(str4, g.a(3, 3, "纛窹呈帯厯筼逅诿汉夊琗夥贲:") + h.f(e12));
            }
            throw new BusinessException(x2.c.i("给竩吊幣叵笤遏讳氛奊瑅天质", 186, 117), BusinessException.ErrorMessage.local_communication_sign_out_fail);
        } catch (InvalidParameterException e13) {
            if (this.f35961a != null) {
                a aVar4 = this.f35961a;
                String str5 = this.f35962b;
                aVar4.b(str5, e.a(200, "绕窯呒帵厹笲遏讥気斮ｗ佾儤盀厅攺断攘s") + h.f(e13));
            }
            throw new BusinessException(x2.a.b("纛竤呒幨厣筵遃讬汑施／佻其盏叁敫斳敃", 3, 56), BusinessException.ErrorMessage.local_communication_sign_out_fail);
        }
    }

    public void d(boolean z10) throws BusinessException {
        ApduHandler apduHandler;
        if (z10 && (apduHandler = this.f35965e) != null) {
            apduHandler.close();
        }
    }

    public void e(String str, String str2) throws BusinessException {
        c a10 = this.f35963c.a(str2);
        if (a10 == null) {
            a aVar = this.f35961a;
            if (aVar != null) {
                String str3 = this.f35962b;
                aVar.c(str3, String.valueOf(str) + x2.c.i("y纇窪辅援剷幮口夸贺", 2, 118));
            }
            throw new BusinessException(String.valueOf(str) + x2.c.i("k绞竮辒掲割幾厨奲贫", 244, 75), BusinessException.ErrorMessage.local_communication_connect_fail);
        }
        if (!a10.c()) {
            a10 = f(str2);
        }
        if (!a10.c()) {
            a aVar2 = this.f35961a;
            if (aVar2 != null) {
                String str4 = this.f35962b;
                aVar2.c(str4, String.valueOf(str) + FM_Exception.insert(4, 29, "(绍窭辁揹利幥厣奡质"));
            }
            throw new BusinessException(String.valueOf(str) + h.e("\"纄竹辞掯剤幭司奣费", 5, 74), BusinessException.ErrorMessage.local_communication_connect_fail);
        } else if (!a(a10) && !b(str2)) {
            a aVar3 = this.f35961a;
            if (aVar3 != null) {
                String str5 = this.f35962b;
                aVar3.c(str5, String.valueOf(str) + FM_Exception.insert(3, 46, "'绝窬朻筡剽"));
            }
            throw new BusinessException(String.valueOf(str) + x2.d.c("i绒竤筢刽奯赪", 342), BusinessException.ErrorMessage.local_communication_sign_in_fail);
        }
    }

    public c f(String str) throws BusinessException {
        if (this.f35961a == null) {
            this.f35961a = z2.b.a().b();
        }
        a aVar = this.f35961a;
        if (aVar != null) {
            String str2 = this.f35962b;
            aVar.e(str2, h.e("cpp39xny,x6", 3, 31) + str + FM_Exception.insert(4, 5, "&#<"));
        }
        if (this.f35967g == null) {
            i j10 = j();
            this.f35967g = j10;
            if (j10 == null) {
                a aVar2 = this.f35961a;
                if (aVar2 != null) {
                    aVar2.c(this.f35962b, e.a(5, "钤揸到幰叶旿\uff00劯软庁田酖罰斆仲夶贯"));
                }
                return null;
            }
        }
        LinkInfo i10 = this.f35967g.i(str);
        if (i10 == null) {
            a aVar3 = this.f35961a;
            if (aVar3 != null) {
                aVar3.c(this.f35962b, x2.a.b("钭掭刭幡厷斪｝酋罵斗亳乷来实乐诫帰厨侬恭", 3, 21));
            }
            return null;
        }
        c a10 = this.f35963c.a(str);
        if (a10 == null) {
            a aVar4 = this.f35961a;
            if (aVar4 != null) {
                aVar4.c(this.f35962b, x2.b.b(186, "菰厄遇侩寍俕夸贱"));
            }
            return null;
        }
        a10.g(this.f35964d);
        if (a10.c()) {
            return a10;
        }
        try {
            if (a10.f(i10)) {
                return a10;
            }
            a aVar5 = this.f35961a;
            if (aVar5 != null) {
                String str3 = this.f35962b;
                aVar5.c(str3, x2.a.b("钭掶剣幠厣H", 3, 64) + i10.a() + ":" + i10.b() + e.a(1, "\u000b斯ｐ钡控头购"));
            }
            throw new BusinessException(FM_Exception.insert(178, 3, "铨掼刬幬厲冿珸彉并"), BusinessException.ErrorMessage.local_communication_connect_fail);
        } catch (SocketException unused) {
            if (this.f35961a != null) {
                a aVar6 = this.f35961a;
                String str4 = this.f35962b;
                aVar6.c(str4, x2.a.b("钪揧删席叼\u0001", 4, 78) + i10.a() + ":" + i10.b() + FM_Exception.insert(4, 56, "U斶ｔ铮揭失赽"));
            }
            throw new BusinessException(g.a(100, 53, "钪掬刮帠司冧玢彅幤"), BusinessException.ErrorMessage.local_communication_connect_fail);
        } catch (InvalidParameterException unused2) {
            if (this.f35961a != null) {
                this.f35961a.c(this.f35962b, x2.f.a("铳掯刷幷叱斨ｗ佸儰盖厍攼斩攎", 5));
            }
            throw new BusinessException(x2.b.b(2, "铱掿刵幣叫新}佼儢厐攭弊師"), BusinessException.ErrorMessage.local_communication_connect_param_error);
        }
    }

    public InputStream g(String str) throws BusinessException {
        InputStream resourceAsStream = f.class.getResourceAsStream(str);
        byte[] bArr = new byte[128];
        byte[] bArr2 = new byte[512];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr3 = new byte[1];
        try {
            try {
                try {
                    resourceAsStream.read(bArr3);
                    if (resourceAsStream.read(bArr) < 128) {
                        if (this.f35961a == null) {
                            this.f35961a = z2.b.a().b();
                        }
                        a aVar = this.f35961a;
                        if (aVar != null) {
                            aVar.c(this.f35962b, x2.b.b(3, "绘竴酋罿斛亱勲輠斾｟鄓罧斓仩冏宬斠攃ｚ杫讷剧PLK劣寈皝宂旈"));
                        }
                        throw new BusinessException(g.a(3, 22, "纛竦酒罻旌亷勷轰旵５鄂缫旜仧冂室斳攁"), BusinessException.ErrorMessage.local_app_config_invaild_content);
                    }
                    while (true) {
                        int read = resourceAsStream.read(bArr2);
                        if (read < 0) {
                            try {
                                break;
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                        } else {
                            byteArrayOutputStream.write(Arrays.copyOf(bArr2, read));
                        }
                    }
                    resourceAsStream.close();
                    g b10 = this.f35972l.b(bArr3[0]);
                    if (b10 == null) {
                        if (this.f35961a == null) {
                            this.f35961a = z2.b.a().b();
                        }
                        a aVar2 = this.f35961a;
                        if (aVar2 != null) {
                            aVar2.c(this.f35962b, FM_Exception.insert(5, 122, "绁竬鄐缹旖亽勥輢斯｟坥鄊缯斜代寉钬雅吕为朻扵刵鄒缷旔亻伸畩盟宓铪"));
                        }
                        throw new BusinessException(x2.f.a("绅童酊罪斆亨勻輥斣～来戲剹鄋缭旇享", 5), BusinessException.ErrorMessage.local_app_config_invaild_content);
                    }
                    byte[] b11 = y2.c.b(b10.c(), b10.b(), bArr, false);
                    if (b11.length < 36) {
                        if (this.f35961a == null) {
                            this.f35961a = z2.b.a().b();
                        }
                        a aVar3 = this.f35961a;
                        if (aVar3 != null) {
                            aVar3.c(this.f35962b, x2.c.i("鄔缱旂份敡挹施攋%]\u0006\u001a覢寁吃盗攩捱镺庭斱攟", 2, 102));
                        }
                        throw new BusinessException(x2.c.i("绗竭酈罦斌仸励轩旡６朷戾剳鄋缧旋亹", 168, 3), BusinessException.ErrorMessage.local_app_config_invaild_content);
                    }
                    Arrays.copyOf(b11, 20);
                    return new ByteArrayInputStream(x2.c.b(y2.a.b(Arrays.copyOfRange(b11, 20, 36), byteArrayOutputStream.toByteArray())));
                } catch (Throwable th2) {
                    if (resourceAsStream != null) {
                        try {
                            resourceAsStream.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                    }
                    throw th2;
                }
            } catch (FileNotFoundException unused) {
                if (this.f35961a == null) {
                    this.f35961a = z2.b.a().b();
                }
                a aVar4 = this.f35961a;
                if (aVar4 != null) {
                    aVar4.c(this.f35962b, h.e("绉窤酘缱旎以勽轺斧７术戱利鄎罣旐亷", 36, 74));
                }
                throw new BusinessException(x2.d.c("纞窨鄕缧斝份劼轰斨ｃ杪戯割酞罪斒仰", 3), BusinessException.ErrorMessage.local_app_load_config_fail);
            }
        } catch (IOException e12) {
            if (this.f35961a == null) {
                this.f35961a = z2.b.a().b();
            }
            a aVar5 = this.f35961a;
            if (aVar5 != null) {
                String str2 = this.f35962b;
                aVar5.c(str2, h.e("讶厕鄔缡旂仭凫玷弟師３", 112, 118) + h.f(e12));
            }
            throw new BusinessException(x2.f.a("组竦酋罭文享勺輪斢｝杤戵剸鄈缬旘亪", 4), BusinessException.ErrorMessage.local_app_load_config_fail);
        }
    }

    public void h(String str) throws BusinessException {
        c a10 = this.f35963c.a(str);
        if (a10 != null) {
            try {
                a10.a();
            } catch (SocketException e10) {
                if (this.f35961a == null) {
                    this.f35961a = z2.b.a().b();
                }
                a aVar = this.f35961a;
                if (aVar != null) {
                    String str2 = this.f35962b;
                    aVar.c(str2, x2.d.c("兮闣纗窿响帡厳皐铻掳函珨彋幢ｑ", 298) + h.f(e10));
                }
                throw new BusinessException(x2.a.b("儠閼纇窢哇帺厷盁钽揤冥班彙幡", 3, 126));
            }
        }
    }

    public ApduHandler i() {
        return this.f35965e;
    }

    public i j() {
        if (this.f35967g == null) {
            try {
                InputStream g10 = g(h.e(".*z%t*n!j.?c9", 4, 71));
                if (!(g10 != null ? o(g10) : false)) {
                    a aVar = this.f35961a;
                    if (aVar != null) {
                        aVar.c(this.f35962b, g.a(240, 119, "钾揲剾帶召日＆务轥庛甮鄐缺旌亴奨赵"));
                    }
                    return null;
                }
            } catch (BusinessException unused) {
                a aVar2 = this.f35961a;
                if (aVar2 != null) {
                    aVar2.c(this.f35962b, x2.f.a("脑朤触枒嘷剁妒區斥｜勭輷廓畬鄌缰旜亮奤起", 3));
                }
                return null;
            }
        }
        return this.f35967g;
    }

    public f2.b k() {
        InputStream inputStream;
        if (this.f35966f == null) {
            try {
                inputStream = g(x2.d.c("y*=:ij{hp7-=", 3));
            } catch (BusinessException unused) {
                if (this.f35961a == null) {
                    this.f35961a = z2.b.a().b();
                }
                a aVar = this.f35961a;
                if (aVar != null) {
                    aVar.c(this.f35962b, FM_Exception.insert(5, 30, "莾发淍怬夅琙旫ｗ勹轪涝怼鄜罡斊亽奸财"));
                }
                inputStream = null;
            }
            if (!(inputStream != null ? p(inputStream) : false)) {
                if (this.f35961a == null) {
                    this.f35961a = z2.b.a().b();
                }
                a aVar2 = this.f35961a;
                if (aVar2 != null) {
                    aVar2.c(this.f35962b, x2.d.c("菤厒涝恩夓琎斯ｆ勻輱涕恡酒罾斆交奲赱", 224));
                }
                return null;
            }
        }
        return this.f35966f;
    }

    public cn.com.fmsh.script.a l() {
        if (this.f35967g == null) {
            i j10 = j();
            this.f35967g = j10;
            if (j10 == null) {
                a aVar = this.f35961a;
                if (aVar == null) {
                    return null;
                }
                aVar.c(this.f35962b, x2.b.b(4, "铯掹刷幡叭斾｟勾輴廀畷酇罻文份大赤"));
                return null;
            }
        }
        cn.com.fmsh.script.a aVar2 = this.f35971k;
        if (aVar2 == null) {
            this.f35971k = o2.b.a().b(i());
            this.f35971k.c(new a(this.f35967g.e()));
        } else {
            aVar2.a(i());
        }
        return this.f35971k;
    }

    public String m(int i10) {
        return j().l(i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] n(byte[] bArr, String str, boolean z10, String str2) throws BusinessException {
        a aVar;
        String a10;
        BusinessException.ErrorMessage errorMessage;
        c a11 = this.f35963c.a(str2);
        byte[] bArr2 = null;
        if (a11 == null) {
            a aVar2 = this.f35961a;
            if (aVar2 != null) {
                String str3 = this.f35962b;
                aVar2.c(str3, x2.f.a("丗劫夃琂旷r菬厎带厢違侭宰谧\u0018", 5) + str2 + e.a(68, "D夭贺"));
            }
            return null;
        }
        try {
            bArr2 = a11.e(bArr);
        } catch (CommunicationException e10) {
            if (this.f35961a != null) {
                a aVar3 = this.f35961a;
                String str4 = this.f35962b;
                aVar3.b(str4, String.valueOf(str) + g.a(3, 2, "s纝窸呈帨厭讨汃旵）逝俨敻捣弍帩)5") + h.f(e10));
            }
            a10 = x2.b.b(3, "绘竴吗幢召记氐斫ｄ\u00001j\u007fz~透価彉幮");
            errorMessage = BusinessException.ErrorMessage.local_communication_connect_fail;
            t(a10, errorMessage, z10);
            if (bArr2 != null) {
            }
            if (this.f35961a == null) {
            }
            aVar = this.f35961a;
            if (aVar != null) {
            }
            t(g.a(1, 117, "纙窩告帣厵语汍旲５朤攵剨帾厲咚廘攱捸"), BusinessException.ErrorMessage.local_communication_no_response, z10);
            return bArr2;
        } catch (SocketException e11) {
            if (this.f35961a == null) {
                this.f35961a = z2.b.a().b();
            }
            a aVar4 = this.f35961a;
            if (aVar4 != null) {
                String str5 = this.f35962b;
                aVar4.b(str5, String.valueOf(str) + x2.a.b("r绊窽吓幡厲该氀斤．\u0001mq)w6遈俣彐帺(b", 2, 48) + h.f(e11));
            }
            a10 = x2.d.c("绁竵吚帯厽让氍斶＝Q|g>##遒俸弈帣", 182);
            errorMessage = BusinessException.ErrorMessage.local_communication_connect_fail;
            t(a10, errorMessage, z10);
            if (bArr2 != null) {
            }
            if (this.f35961a == null) {
            }
            aVar = this.f35961a;
            if (aVar != null) {
            }
            t(g.a(1, 117, "纙窩告帣厵语汍旲５朤攵剨帾厲咚廘攱捸"), BusinessException.ErrorMessage.local_communication_no_response, z10);
            return bArr2;
        } catch (InvalidParameterException e12) {
            if (this.f35961a == null) {
                this.f35961a = z2.b.a().b();
            }
            a aVar5 = this.f35961a;
            if (aVar5 != null) {
                String str6 = this.f35962b;
                aVar5.b(str6, String.valueOf(str) + h.e("-绝窦同帢叵诮氏旷ｙ友敭当帽c-", 4, 52) + h.f(e12));
            }
            a10 = x2.f.a("练竧吔幱厯讫氛斠｟厒攽彈广", 3);
            errorMessage = BusinessException.ErrorMessage.local_communication_request_param_error;
            t(a10, errorMessage, z10);
            if (bArr2 != null) {
            }
            if (this.f35961a == null) {
            }
            aVar = this.f35961a;
            if (aVar != null) {
            }
            t(g.a(1, 117, "纙窩告帣厵语汍旲５朤攵剨帾厲咚廘攱捸"), BusinessException.ErrorMessage.local_communication_no_response, z10);
            return bArr2;
        }
        if (bArr2 != null || bArr2.length < 2) {
            if (this.f35961a == null) {
                this.f35961a = z2.b.a().b();
            }
            aVar = this.f35961a;
            if (aVar != null) {
                aVar.c(this.f35962b, x2.d.c("師厹奞瑍丆劬诩汍失赴n杹敲別幵叧哅廍攺挵", 5));
            }
            t(g.a(1, 117, "纙窩告帣厵语汍旲５朤攵剨帾厲咚廘攱捸"), BusinessException.ErrorMessage.local_communication_no_response, z10);
        }
        return bArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0102 A[Catch: SAXException -> 0x02de, IOException -> 0x0308, ParserConfigurationException -> 0x0332, TryCatch #2 {IOException -> 0x0308, ParserConfigurationException -> 0x0332, SAXException -> 0x02de, blocks: (B:5:0x0015, B:6:0x002d, B:8:0x0034, B:10:0x0056, B:11:0x0063, B:13:0x0073, B:14:0x007c, B:16:0x0088, B:17:0x0091, B:19:0x00a0, B:21:0x00a6, B:23:0x00b6, B:24:0x00c4, B:26:0x00c8, B:27:0x00d2, B:28:0x00d6, B:30:0x00da, B:31:0x00e5, B:33:0x00e9, B:34:0x00f2, B:36:0x0102, B:38:0x0108, B:40:0x011c, B:41:0x0126, B:43:0x012a, B:44:0x0132, B:45:0x0136, B:47:0x013a, B:48:0x0146, B:50:0x014a, B:51:0x0153, B:52:0x0160, B:54:0x0166, B:55:0x0173, B:57:0x0179, B:58:0x0189, B:64:0x01a1, B:66:0x01b7, B:67:0x01bb, B:69:0x01c7, B:72:0x01d3, B:73:0x01d8, B:74:0x01db, B:76:0x01f1, B:77:0x01fe, B:78:0x0202, B:80:0x0218, B:82:0x0222, B:84:0x022e, B:86:0x0238, B:88:0x0247, B:90:0x0251, B:92:0x025f, B:97:0x026b, B:98:0x0270, B:99:0x0276, B:101:0x028c, B:103:0x0292, B:105:0x02a0, B:107:0x02a6, B:109:0x02b2, B:110:0x02ba, B:112:0x02ca, B:114:0x02d4), top: B:145:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0146 A[Catch: SAXException -> 0x02de, IOException -> 0x0308, ParserConfigurationException -> 0x0332, TryCatch #2 {IOException -> 0x0308, ParserConfigurationException -> 0x0332, SAXException -> 0x02de, blocks: (B:5:0x0015, B:6:0x002d, B:8:0x0034, B:10:0x0056, B:11:0x0063, B:13:0x0073, B:14:0x007c, B:16:0x0088, B:17:0x0091, B:19:0x00a0, B:21:0x00a6, B:23:0x00b6, B:24:0x00c4, B:26:0x00c8, B:27:0x00d2, B:28:0x00d6, B:30:0x00da, B:31:0x00e5, B:33:0x00e9, B:34:0x00f2, B:36:0x0102, B:38:0x0108, B:40:0x011c, B:41:0x0126, B:43:0x012a, B:44:0x0132, B:45:0x0136, B:47:0x013a, B:48:0x0146, B:50:0x014a, B:51:0x0153, B:52:0x0160, B:54:0x0166, B:55:0x0173, B:57:0x0179, B:58:0x0189, B:64:0x01a1, B:66:0x01b7, B:67:0x01bb, B:69:0x01c7, B:72:0x01d3, B:73:0x01d8, B:74:0x01db, B:76:0x01f1, B:77:0x01fe, B:78:0x0202, B:80:0x0218, B:82:0x0222, B:84:0x022e, B:86:0x0238, B:88:0x0247, B:90:0x0251, B:92:0x025f, B:97:0x026b, B:98:0x0270, B:99:0x0276, B:101:0x028c, B:103:0x0292, B:105:0x02a0, B:107:0x02a6, B:109:0x02b2, B:110:0x02ba, B:112:0x02ca, B:114:0x02d4), top: B:145:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01a1 A[Catch: SAXException -> 0x02de, IOException -> 0x0308, ParserConfigurationException -> 0x0332, TRY_ENTER, TryCatch #2 {IOException -> 0x0308, ParserConfigurationException -> 0x0332, SAXException -> 0x02de, blocks: (B:5:0x0015, B:6:0x002d, B:8:0x0034, B:10:0x0056, B:11:0x0063, B:13:0x0073, B:14:0x007c, B:16:0x0088, B:17:0x0091, B:19:0x00a0, B:21:0x00a6, B:23:0x00b6, B:24:0x00c4, B:26:0x00c8, B:27:0x00d2, B:28:0x00d6, B:30:0x00da, B:31:0x00e5, B:33:0x00e9, B:34:0x00f2, B:36:0x0102, B:38:0x0108, B:40:0x011c, B:41:0x0126, B:43:0x012a, B:44:0x0132, B:45:0x0136, B:47:0x013a, B:48:0x0146, B:50:0x014a, B:51:0x0153, B:52:0x0160, B:54:0x0166, B:55:0x0173, B:57:0x0179, B:58:0x0189, B:64:0x01a1, B:66:0x01b7, B:67:0x01bb, B:69:0x01c7, B:72:0x01d3, B:73:0x01d8, B:74:0x01db, B:76:0x01f1, B:77:0x01fe, B:78:0x0202, B:80:0x0218, B:82:0x0222, B:84:0x022e, B:86:0x0238, B:88:0x0247, B:90:0x0251, B:92:0x025f, B:97:0x026b, B:98:0x0270, B:99:0x0276, B:101:0x028c, B:103:0x0292, B:105:0x02a0, B:107:0x02a6, B:109:0x02b2, B:110:0x02ba, B:112:0x02ca, B:114:0x02d4), top: B:145:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01db A[Catch: SAXException -> 0x02de, IOException -> 0x0308, ParserConfigurationException -> 0x0332, TryCatch #2 {IOException -> 0x0308, ParserConfigurationException -> 0x0332, SAXException -> 0x02de, blocks: (B:5:0x0015, B:6:0x002d, B:8:0x0034, B:10:0x0056, B:11:0x0063, B:13:0x0073, B:14:0x007c, B:16:0x0088, B:17:0x0091, B:19:0x00a0, B:21:0x00a6, B:23:0x00b6, B:24:0x00c4, B:26:0x00c8, B:27:0x00d2, B:28:0x00d6, B:30:0x00da, B:31:0x00e5, B:33:0x00e9, B:34:0x00f2, B:36:0x0102, B:38:0x0108, B:40:0x011c, B:41:0x0126, B:43:0x012a, B:44:0x0132, B:45:0x0136, B:47:0x013a, B:48:0x0146, B:50:0x014a, B:51:0x0153, B:52:0x0160, B:54:0x0166, B:55:0x0173, B:57:0x0179, B:58:0x0189, B:64:0x01a1, B:66:0x01b7, B:67:0x01bb, B:69:0x01c7, B:72:0x01d3, B:73:0x01d8, B:74:0x01db, B:76:0x01f1, B:77:0x01fe, B:78:0x0202, B:80:0x0218, B:82:0x0222, B:84:0x022e, B:86:0x0238, B:88:0x0247, B:90:0x0251, B:92:0x025f, B:97:0x026b, B:98:0x0270, B:99:0x0276, B:101:0x028c, B:103:0x0292, B:105:0x02a0, B:107:0x02a6, B:109:0x02b2, B:110:0x02ba, B:112:0x02ca, B:114:0x02d4), top: B:145:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0202 A[Catch: SAXException -> 0x02de, IOException -> 0x0308, ParserConfigurationException -> 0x0332, TryCatch #2 {IOException -> 0x0308, ParserConfigurationException -> 0x0332, SAXException -> 0x02de, blocks: (B:5:0x0015, B:6:0x002d, B:8:0x0034, B:10:0x0056, B:11:0x0063, B:13:0x0073, B:14:0x007c, B:16:0x0088, B:17:0x0091, B:19:0x00a0, B:21:0x00a6, B:23:0x00b6, B:24:0x00c4, B:26:0x00c8, B:27:0x00d2, B:28:0x00d6, B:30:0x00da, B:31:0x00e5, B:33:0x00e9, B:34:0x00f2, B:36:0x0102, B:38:0x0108, B:40:0x011c, B:41:0x0126, B:43:0x012a, B:44:0x0132, B:45:0x0136, B:47:0x013a, B:48:0x0146, B:50:0x014a, B:51:0x0153, B:52:0x0160, B:54:0x0166, B:55:0x0173, B:57:0x0179, B:58:0x0189, B:64:0x01a1, B:66:0x01b7, B:67:0x01bb, B:69:0x01c7, B:72:0x01d3, B:73:0x01d8, B:74:0x01db, B:76:0x01f1, B:77:0x01fe, B:78:0x0202, B:80:0x0218, B:82:0x0222, B:84:0x022e, B:86:0x0238, B:88:0x0247, B:90:0x0251, B:92:0x025f, B:97:0x026b, B:98:0x0270, B:99:0x0276, B:101:0x028c, B:103:0x0292, B:105:0x02a0, B:107:0x02a6, B:109:0x02b2, B:110:0x02ba, B:112:0x02ca, B:114:0x02d4), top: B:145:0x0015 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean o(InputStream inputStream) throws BusinessException {
        NodeList elementsByTagName;
        NodeList elementsByTagName2;
        int i10;
        NodeList elementsByTagName3;
        int i11;
        NodeList elementsByTagName4;
        a aVar;
        a aVar2;
        String str;
        String b10;
        a aVar3;
        String str2;
        String c10;
        this.f35967g = new i();
        boolean z10 = true;
        if (inputStream != null) {
            try {
                Element documentElement = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement();
                NodeList elementsByTagName5 = documentElement.getElementsByTagName(g.a(5, 2, "\u00062+-8-"));
                int i12 = 0;
                while (true) {
                    int i13 = -1;
                    if (i12 >= elementsByTagName5.getLength()) {
                        break;
                    }
                    NamedNodeMap attributes = elementsByTagName5.item(i12).getAttributes();
                    Node namedItem = attributes.getNamedItem(x2.d.c("o3 ?&.", DfuException.ERROR_ENTER_OTA_MODE_FAILED));
                    String nodeValue = namedItem != null ? namedItem.getNodeValue() : null;
                    Node namedItem2 = attributes.getNamedItem(x2.f.a("?,45%oTvyt", 68));
                    String nodeValue2 = namedItem2 != null ? namedItem2.getNodeValue() : null;
                    Node namedItem3 = attributes.getNamedItem(x2.b.b(5, "brzg"));
                    if (namedItem3 != null) {
                        i13 = h.b(namedItem3.getNodeValue(), -1);
                    }
                    Node namedItem4 = attributes.getNamedItem(h.e("t4l(2\u007f\u000bz*>`6c", 42, 52));
                    this.f35967g.d(nodeValue, i13, namedItem4 != null ? h.b(namedItem4.getNodeValue(), 0) : 0, nodeValue2);
                    i12++;
                    z10 = true;
                }
                NamedNodeMap attributes2 = documentElement.getElementsByTagName(FM_Exception.insert(302, 10, "Fy4=3% 4")).item(0).getAttributes();
                Node namedItem5 = attributes2.getNamedItem(x2.b.b(5, "fdxv"));
                if (namedItem5 != null) {
                    this.f35967g.s(x2.c.m(namedItem5.getNodeValue()));
                }
                Node namedItem6 = attributes2.getNamedItem(FM_Exception.insert(192, 46, "&'s'2o+uB'bm%u&"));
                if (namedItem6 != null) {
                    this.f35967g.o(namedItem6.getNodeValue());
                }
                Node namedItem7 = attributes2.getNamedItem(x2.b.b(2, "|~nF~4\"5(<"));
                if (namedItem7 != null) {
                    this.f35967g.r(namedItem7.getNodeValue());
                }
                NodeList elementsByTagName6 = documentElement.getElementsByTagName(x2.d.c("J$#=;Idi\u007f=*", 146));
                int i14 = 3;
                if (elementsByTagName6 != null) {
                    Node item = elementsByTagName6.item(0);
                    if (item != null) {
                        Node namedItem8 = item.getAttributes().getNamedItem(x2.d.c(" &4<\u007f", 3));
                        if (namedItem8 != null) {
                            this.f35967g.q(h.a(namedItem8.getNodeValue(), (byte) 0));
                        } else {
                            aVar3 = this.f35961a;
                            if (aVar3 != null) {
                                str2 = this.f35962b;
                                c10 = h.e("酏缧旗仡丳讧匙朶溊丌匍呤说午条溛偮盝攰捩顷", 5, 103);
                                aVar3.c(str2, c10);
                            }
                        }
                        elementsByTagName = documentElement.getElementsByTagName(h.e("Cbwwu/7\u0018'1g", 3, 13));
                        if (elementsByTagName != null) {
                            Node item2 = elementsByTagName.item(0);
                            if (item2 != null) {
                                Node namedItem9 = item2.getAttributes().getNamedItem(x2.c.i("\u007fg/58", DfuException.ERROR_USER_NOT_ACTIVE_IMAGE_ERROR, 29));
                                if (namedItem9 != null) {
                                    this.f35967g.p(namedItem9.getNodeValue());
                                } else {
                                    aVar2 = this.f35961a;
                                    if (aVar2 != null) {
                                        str = this.f35962b;
                                        b10 = x2.b.b(76, "鄔缪旈京丈匕吰厄啗缊硆侳怲");
                                        aVar2.c(str, b10);
                                    }
                                }
                            } else {
                                a aVar4 = this.f35961a;
                                if (aVar4 != null) {
                                    aVar4.c(this.f35962b, e.a(4, "鄔缲旘仴厇啎缝砏俰恻业匟吶数捭顿"));
                                }
                            }
                            elementsByTagName2 = documentElement.getElementsByTagName(x2.a.b("\u001fq-", 4, 64));
                            i10 = 0;
                            while (i10 < elementsByTagName2.getLength()) {
                                NamedNodeMap attributes3 = elementsByTagName2.item(i10).getAttributes();
                                String str3 = "";
                                Node namedItem10 = attributes3.getNamedItem(x2.f.a("ci`d&", 2));
                                int parseInt = namedItem10 != null ? Integer.parseInt(namedItem10.getNodeValue()) : -1;
                                Node namedItem11 = attributes3.getNamedItem(x2.d.c("20)%uisz", 4));
                                byte[] m10 = namedItem11 != null ? x2.c.m(namedItem11.getNodeValue()) : null;
                                Node namedItem12 = attributes3.getNamedItem(h.e("2*/$;(p", 98, 6));
                                byte[] m11 = namedItem12 != null ? x2.c.m(namedItem12.getNodeValue()) : null;
                                Node namedItem13 = attributes3.getNamedItem(x2.a.b("&-i8$f\t{`%", 5, 83));
                                if (namedItem13 != null) {
                                    str3 = namedItem13.getNodeValue();
                                }
                                if (!(str3 == null && (m10 == null || m11 == null || parseInt == -1))) {
                                    this.f35967g.c(str3, parseInt, m10, m11);
                                }
                                i10++;
                                z10 = true;
                                i14 = 3;
                            }
                            int i15 = z10 ? 1 : 0;
                            int i16 = z10 ? 1 : 0;
                            int i17 = z10 ? 1 : 0;
                            elementsByTagName3 = documentElement.getElementsByTagName(g.a(i15, 73, "\u0010sg"));
                            for (i11 = 0; i11 < elementsByTagName3.getLength(); i11++) {
                                Node namedItem14 = elementsByTagName3.item(i11).getAttributes().getNamedItem(h.e("w(},d", 4, 72));
                                if (namedItem14 != null) {
                                    this.f35967g.a(x2.c.m(namedItem14.getNodeValue()));
                                }
                            }
                            elementsByTagName4 = documentElement.getElementsByTagName(x2.c.i("Ocla\u007f\u007f0?\u00140#\u0003<p}qo", 150, 9));
                            int i18 = -1;
                            String str4 = null;
                            for (int i19 = 0; i19 < elementsByTagName4.getLength(); i19++) {
                                NamedNodeMap attributes4 = elementsByTagName4.item(i19).getAttributes();
                                Node namedItem15 = attributes4.getNamedItem(x2.c.i("*{q>h Y=l#", 2, 69));
                                if (namedItem15 != null) {
                                    str4 = namedItem15.getNodeValue();
                                }
                                Node namedItem16 = attributes4.getNamedItem(x2.a.b("7-(7oatyCq~s", 5, i14));
                                if (namedItem16 != null) {
                                    i18 = h.b(namedItem16.getNodeValue(), -1);
                                }
                                if (i18 != -1 || str4 != null) {
                                    this.f35967g.b(i18, str4);
                                }
                            }
                            aVar = this.f35961a;
                            if (aVar != null) {
                                aVar.e(this.f35962b, h.e("np=}vp?c,n#!-n;p!|", 5, 61));
                            }
                            return z10;
                        }
                        aVar2 = this.f35961a;
                        if (aVar2 != null) {
                            str = this.f35962b;
                            b10 = x2.b.b(76, "鄔缪旈京术宊乒厄啗缊硆");
                            aVar2.c(str, b10);
                        }
                        elementsByTagName2 = documentElement.getElementsByTagName(x2.a.b("\u001fq-", 4, 64));
                        i10 = 0;
                        while (i10 < elementsByTagName2.getLength()) {
                        }
                        int i152 = z10 ? 1 : 0;
                        int i162 = z10 ? 1 : 0;
                        int i172 = z10 ? 1 : 0;
                        elementsByTagName3 = documentElement.getElementsByTagName(g.a(i152, 73, "\u0010sg"));
                        while (i11 < elementsByTagName3.getLength()) {
                        }
                        elementsByTagName4 = documentElement.getElementsByTagName(x2.c.i("Ocla\u007f\u007f0?\u00140#\u0003<p}qo", 150, 9));
                        int i182 = -1;
                        String str42 = null;
                        while (i19 < elementsByTagName4.getLength()) {
                        }
                        aVar = this.f35961a;
                        if (aVar != null) {
                        }
                        return z10;
                    }
                    aVar3 = this.f35961a;
                    if (aVar3 != null) {
                        str2 = this.f35962b;
                        c10 = x2.d.c("鄔缤斜仺丰讬匊朵滑也卆吿敵捸顾", 230);
                        aVar3.c(str2, c10);
                    }
                    elementsByTagName = documentElement.getElementsByTagName(h.e("Cbwwu/7\u0018'1g", 3, 13));
                    if (elementsByTagName != null) {
                    }
                } else {
                    aVar3 = this.f35961a;
                    if (aVar3 != null) {
                        str2 = this.f35962b;
                        c10 = x2.d.c("鄚缦旞亼朱宖乔讬匊朵滑", 4);
                        aVar3.c(str2, c10);
                    }
                    elementsByTagName = documentElement.getElementsByTagName(h.e("Cbwwu/7\u0018'1g", 3, 13));
                    if (elementsByTagName != null) {
                    }
                }
            } catch (IOException e10) {
                if (this.f35961a == null) {
                    this.f35961a = z2.b.a().b();
                }
                a aVar5 = this.f35961a;
                if (aVar5 != null) {
                    aVar5.b(this.f35962b, h.f(e10));
                }
                throw new BusinessException(x2.b.b(4, "给竳酊罼斚亾勳輣斿ｘ杵扴別配罥斑亷"), BusinessException.ErrorMessage.local_app_config_invaild_content);
            } catch (ParserConfigurationException e11) {
                if (this.f35961a == null) {
                    this.f35961a = z2.b.a().b();
                }
                a aVar6 = this.f35961a;
                if (aVar6 != null) {
                    aVar6.b(this.f35962b, h.f(e11));
                }
                throw new BusinessException(x2.d.c("纜窪鄛缩斟仿劺轶斪ａ杴戱剰酜罬斔仲", 1), BusinessException.ErrorMessage.local_app_config_invaild_content);
            } catch (SAXException e12) {
                if (this.f35961a == null) {
                    this.f35961a = z2.b.a().b();
                }
                a aVar7 = this.f35961a;
                if (aVar7 != null) {
                    aVar7.b(this.f35962b, h.f(e12));
                }
                throw new BusinessException(x2.b.b(2, "织竵酈罾斜亰勱輡斱～杷扶刣酓罧斓仩"), BusinessException.ErrorMessage.local_app_config_invaild_content);
            }
        } else {
            throw new BusinessException(g.a(5, 1, "纝窹鄚缶旞京勻輡奬赻"));
        }
    }

    public boolean p(InputStream inputStream) {
        if (this.f35961a == null) {
            this.f35961a = z2.b.a().b();
        }
        g2.b b10 = f2.d.b();
        this.f35966f = b10;
        try {
            if (b10.a(inputStream) == 0) {
                return true;
            }
            a aVar = this.f35961a;
            if (aVar != null) {
                aVar.c(this.f35962b, x2.c.i("丟勱奟琀斧ｐ涏怽覾枘嘻杴助輩鄒罤旒件夺赳", 174, 43));
            }
            this.f35966f = null;
            return false;
        } catch (FMCommunicationMessageException e10) {
            a aVar2 = this.f35961a;
            if (aVar2 != null) {
                String str = this.f35962b;
                aVar2.b(str, x2.c.i("乀勼奄琅旰ｅ淄恠觱柅嘰朱劾轼鄉缩凰玽归幫，", 3, 99) + h.f(e10));
            }
            return false;
        }
    }

    public void q(r2.f fVar) {
    }

    public void r(ApduHandler apduHandler) {
        this.f35965e = apduHandler;
    }

    public void s(byte[] bArr) {
        this.f35968h = bArr;
    }

    public void t(String str, BusinessException.ErrorMessage errorMessage, boolean z10) throws BusinessException {
        ApduHandler apduHandler;
        if (z10 && (apduHandler = this.f35965e) != null) {
            apduHandler.close();
        }
        throw new BusinessException(str, errorMessage);
    }
}
