package g2;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.communication.message.enumerate.ETagType;
import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import x2.c;
import x2.d;
import x2.e;
import x2.f;
import x2.g;
import x2.h;
import z2.a;
/* loaded from: classes.dex */
public class b implements f2.b {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ a f27202a = z2.b.a().b();

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f27203b = b.class.getName();

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ Map<Byte, f> f27204c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ Map<Integer, e> f27205d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private /* synthetic */ Map<Integer, e> f27206e = new HashMap();

    @Override // f2.b
    public int a(InputStream inputStream) throws FMCommunicationMessageException {
        Map<Integer, e> map;
        Integer valueOf;
        if (inputStream != null) {
            try {
                Element documentElement = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement();
                int i10 = 1;
                NodeList elementsByTagName = documentElement.getElementsByTagName(x2.b.b(1, "Zxc"));
                int i11 = 0;
                int i12 = 0;
                while (i12 < elementsByTagName.getLength()) {
                    f fVar = new f();
                    Node item = elementsByTagName.item(i12);
                    NamedNodeMap attributes = item.getAttributes();
                    Node namedItem = attributes.getNamedItem(x2.a.b("%y", 124, 49));
                    if (namedItem != null) {
                        fVar.g((byte) Integer.parseInt(namedItem.getNodeValue(), 16));
                    }
                    Node namedItem2 = attributes.getNamedItem(FM_Exception.insert(5, 4, "eh\u007frmu"));
                    if (namedItem2 != null) {
                        fVar.h(Integer.parseInt(namedItem2.getNodeValue()));
                    }
                    Node namedItem3 = attributes.getNamedItem(x2.b.b(3, "dbvt"));
                    if (namedItem3 != null) {
                        fVar.i(ETagType.valueOf(namedItem3.getNodeValue()));
                    }
                    Node namedItem4 = attributes.getNamedItem(f.a("hlu`", 4));
                    if (namedItem4 != null) {
                        fVar.f(namedItem4.getNodeValue());
                    }
                    NodeList childNodes = item.getChildNodes();
                    int i13 = 0;
                    while (i13 < childNodes.getLength()) {
                        Node item2 = childNodes.item(i13);
                        if (item2 == null) {
                            a aVar = this.f27202a;
                            if (aVar != null) {
                                aVar.c(this.f27203b, FM_Exception.insert(5, 58, "助輾\tV\u0016宑丌斘亯日ａS\u0000\u001c芗烶丳稹"));
                            }
                        } else if (c.i("Zlxo", 156, 5).equals(item2.getNodeName())) {
                            NamedNodeMap attributes2 = item2.getAttributes();
                            g gVar = new g();
                            Node namedItem5 = attributes2.getNamedItem(h.e(";o*", 114, 63));
                            if (namedItem5 != null) {
                                gVar.f((byte) Integer.parseInt(namedItem5.getNodeValue(), 16));
                            }
                            Node namedItem6 = attributes2.getNamedItem(f.a("nbwb", 2));
                            if (namedItem6 != null) {
                                gVar.b(namedItem6.getNodeValue());
                            }
                            Node namedItem7 = attributes2.getNamedItem(d.c("<7?0|v{m", 126));
                            if (namedItem7 != null) {
                                gVar.d(Integer.parseInt(namedItem7.getNodeValue()));
                            }
                            Node namedItem8 = attributes2.getNamedItem(x2.a.b("6.0/+", 3, 3));
                            if (namedItem8 != null) {
                                gVar.c(Integer.parseInt(namedItem8.getNodeValue()));
                            }
                            Node namedItem9 = attributes2.getNamedItem(e.a(240, "*:/+#"));
                            if (namedItem9 != null) {
                                gVar.e(Integer.parseInt(namedItem9.getNodeValue()));
                            }
                            fVar.a(gVar);
                        }
                        i13++;
                        i10 = 1;
                    }
                    this.f27204c.put(Byte.valueOf(fVar.b()), fVar);
                    i12++;
                    i11 = 0;
                }
                NodeList elementsByTagName2 = documentElement.getElementsByTagName(e.a(5, "\u00178spgni"));
                for (int i14 = i11; i14 < elementsByTagName2.getLength(); i14++) {
                    Node item3 = elementsByTagName2.item(i14);
                    NamedNodeMap attributes3 = item3.getAttributes();
                    String nodeValue = attributes3.getNamedItem(x2.b.b(3, "stbt")).getNodeValue();
                    Node namedItem10 = attributes3.getNamedItem(e.a(i10, "$<(\u001cmam"));
                    e eVar = new e();
                    eVar.e(Integer.parseInt(nodeValue));
                    if (namedItem10 != null) {
                        eVar.f(namedItem10.getNodeValue());
                    }
                    NodeList childNodes2 = item3.getChildNodes();
                    int i15 = i11;
                    while (i15 < childNodes2.getLength()) {
                        Node item4 = childNodes2.item(i15);
                        if (item4 == null) {
                            a aVar2 = this.f27202a;
                            if (aVar2 != null) {
                                aVar2.c(this.f27203b, x2.b.b(254, "劫轫UMP寘丄旟亵斸ｕ涌恠芘炼个穡"));
                            }
                        } else if (x2.a.b("\u0016|<2", 2, 43).equals(item4.getNodeName())) {
                            NamedNodeMap attributes4 = item4.getAttributes();
                            c cVar = new c();
                            Node namedItem11 = attributes4.getNamedItem(h.e("U+t", 4, 73));
                            if (namedItem11 != null) {
                                cVar.f((byte) Integer.parseInt(namedItem11.getNodeValue(), 16));
                            }
                            Node namedItem12 = attributes4.getNamedItem(x2.b.b(110, "6s}hnbq-"));
                            if (namedItem12 != null) {
                                cVar.d(Integer.parseInt(namedItem12.getNodeValue()));
                            }
                            Node namedItem13 = attributes4.getNamedItem(h.e("d'th-", 4, 94));
                            if (namedItem13 != null) {
                                cVar.c(Integer.parseInt(namedItem13.getNodeValue()));
                            } else {
                                cVar.c(i10);
                            }
                            Node namedItem14 = attributes4.getNamedItem(g.a(5, 77, ":0k9{"));
                            if (namedItem14 != null) {
                                cVar.e(Integer.parseInt(namedItem14.getNodeValue()));
                            }
                            eVar.a(cVar);
                        }
                        i15++;
                        i11 = 0;
                    }
                    if (eVar.d() == null) {
                        map = this.f27205d;
                        valueOf = Integer.valueOf(eVar.b());
                    } else {
                        map = this.f27206e;
                        valueOf = Integer.valueOf(eVar.b());
                    }
                    map.put(valueOf, eVar);
                }
                a aVar3 = this.f27202a;
                if (aVar3 != null) {
                    aVar3.e(this.f27203b, FM_Exception.insert(4, 8, "d\u007fyd(}}3;1?%h37nny\u007f {e{%;#"));
                }
                return i11;
            } catch (IOException e10) {
                a aVar4 = this.f27202a;
                if (aVar4 != null) {
                    aVar4.b(this.f27203b, h.f(e10));
                }
                throw new FMCommunicationMessageException(g.a(5, 106, "鄘缱旎以劽轺当幣") + h.f(e10));
            } catch (ParserConfigurationException e11) {
                a aVar5 = this.f27202a;
                if (aVar5 != null) {
                    aVar5.b(this.f27203b, h.f(e11));
                }
                throw new FMCommunicationMessageException(c.i("鄔缽旊亱勡輦彗幷", 2, 122) + h.f(e11));
            } catch (SAXException e12) {
                a aVar6 = this.f27202a;
                if (aVar6 != null) {
                    aVar6.b(this.f27203b, h.f(e12));
                }
                throw new FMCommunicationMessageException(d.c("鄘缨旐亾効轷弙帴", 2) + h.f(e12));
            }
        } else {
            throw new FMCommunicationMessageException(x2.a.b("酕缲旇亲动轱奡赱", 296, 100));
        }
    }

    /* renamed from: f */
    public a e(int i10) {
        return new a(this, i10);
    }

    /* renamed from: g */
    public a b(int i10, byte[] bArr) throws FMCommunicationMessageException {
        a aVar = new a(this);
        if (aVar.e(i10, bArr) == 0) {
            return aVar;
        }
        return null;
    }

    /* renamed from: h */
    public a d(byte[] bArr) throws FMCommunicationMessageException {
        a aVar = new a(this);
        if (aVar.f(bArr) == 0) {
            return aVar;
        }
        return null;
    }

    /* renamed from: i */
    public d c(byte b10) {
        return new d(this, b10);
    }

    public d j(byte b10, byte[] bArr) throws FMCommunicationMessageException {
        d dVar = new d(this);
        dVar.m(b10, bArr);
        return dVar;
    }

    public d k(byte[] bArr) throws FMCommunicationMessageException {
        d dVar = new d(this);
        dVar.n(bArr);
        return dVar;
    }

    public e l(int i10) {
        return this.f27205d.get(Integer.valueOf(i10));
    }

    public e m(int i10) {
        return this.f27206e.get(Integer.valueOf(i10));
    }

    public f n(byte b10) {
        return this.f27204c.get(Byte.valueOf(b10));
    }
}
