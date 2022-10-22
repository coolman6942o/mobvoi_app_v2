package w2;

import cn.com.fmsh.communication.core.LinkInfo;
import cn.com.fmsh.util.log.Level;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import x2.c;
import x2.d;
import z2.b;
/* loaded from: classes.dex */
public class i {

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ String f35979c;

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ byte[] f35980d;

    /* renamed from: e  reason: collision with root package name */
    private /* synthetic */ byte[] f35981e;

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ z2.a f35977a = b.a().b();

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f35978b = i.class.getName();

    /* renamed from: j  reason: collision with root package name */
    private /* synthetic */ byte f35986j = 0;

    /* renamed from: k  reason: collision with root package name */
    private /* synthetic */ String f35987k = "";

    /* renamed from: l  reason: collision with root package name */
    private /* synthetic */ String f35988l = "";

    /* renamed from: g  reason: collision with root package name */
    private /* synthetic */ List<byte[]> f35983g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Map<String, LinkInfo> f35984h = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private /* synthetic */ Map<String, List<a>> f35982f = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    private /* synthetic */ Map<Integer, String> f35985i = new HashMap();

    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public int f35989a = 0;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f35990b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f35991c;

        public a(i iVar) {
        }
    }

    public i() {
        Level level = Level.ERROR;
    }

    public void a(byte[] bArr) {
        if (bArr != null && bArr.length >= 1) {
            this.f35983g.add(bArr);
        }
    }

    public void b(int i10, String str) {
        if (str != null) {
            this.f35985i.put(Integer.valueOf(i10), str);
        }
    }

    public void c(String str, int i10, byte[] bArr, byte[] bArr2) {
        if (str == null || bArr == null || bArr2 == null || i10 == -1) {
            z2.a aVar = this.f35977a;
            if (aVar != null) {
                aVar.c(this.f35978b, x2.b.b(236, "勹轹酂罴斂仦丶宀铴侽怨斤ｑ徍劳轣皍寒钺侫怺斠攃"));
                return;
            }
            return;
        }
        a aVar2 = new a(this);
        aVar2.f35989a = i10;
        aVar2.f35990b = bArr;
        aVar2.f35991c = bArr2;
        List<a> list = this.f35982f.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f35982f.put(str, list);
        }
        list.add(aVar2);
    }

    public void d(String str, int i10, int i11, String str2) {
        if (str != null && str.length() > 0 && i10 > 0 && str2 != null && str2.length() > 0) {
            LinkInfo linkInfo = new LinkInfo();
            linkInfo.d(str);
            linkInfo.e(i10);
            linkInfo.f(i11);
            this.f35984h.put(str2, linkInfo);
        }
    }

    public byte[][] e() {
        return (byte[][]) this.f35983g.toArray((byte[][]) Array.newInstance(byte.class, 1, 1));
    }

    public String f() {
        return this.f35979c;
    }

    public String g() {
        return this.f35987k;
    }

    public a[] h(String str) {
        List<a> list = this.f35982f.get(str);
        if (list != null) {
            return (a[]) list.toArray(new a[0]);
        }
        z2.a aVar = this.f35977a;
        if (aVar == null) {
            return null;
        }
        String str2 = this.f35978b;
        aVar.c(str2, c.i("鄔罡斂仭泰李\u0006", 2, 22) + str + d.c("\b宿廃盌rob", 2));
        return null;
    }

    public LinkInfo i(String str) {
        return this.f35984h.get(str);
    }

    public byte j() {
        return this.f35986j;
    }

    public String k() {
        return this.f35988l;
    }

    public String l(int i10) {
        return this.f35985i.get(Integer.valueOf(i10));
    }

    public byte[] m() {
        return this.f35981e;
    }

    public byte[] n() {
        return this.f35980d;
    }

    public void o(String str) {
        this.f35979c = str;
    }

    public void p(String str) {
        this.f35987k = str;
    }

    public void q(byte b10) {
        this.f35986j = b10;
    }

    public void r(String str) {
        this.f35988l = str;
    }

    public void s(byte[] bArr) {
        this.f35980d = bArr;
    }
}
