package sd;

import android.text.TextUtils;
import com.bjleisen.iface.sdk.apdu.LeisenIfaceOperator;
import com.laser.tsm.sdk.tsm.TSMOperator;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.q;
import com.mobvoi.wear.common.base.WearPath;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import qd.d;
import ud.a;
/* compiled from: BusCardManager.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: m  reason: collision with root package name */
    private static b f34391m;

    /* renamed from: a  reason: collision with root package name */
    private LeisenIfaceOperator f34392a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f34393b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f34394c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f34395d;

    /* renamed from: e  reason: collision with root package name */
    private UUID f34396e;

    /* renamed from: f  reason: collision with root package name */
    private String f34397f;

    /* renamed from: g  reason: collision with root package name */
    private String f34398g;

    /* renamed from: h  reason: collision with root package name */
    private String f34399h;

    /* renamed from: i  reason: collision with root package name */
    private final CopyOnWriteArrayList<a> f34400i = new CopyOnWriteArrayList<>();

    /* renamed from: j  reason: collision with root package name */
    private final Map<String, a> f34401j = new ConcurrentHashMap();

    /* renamed from: k  reason: collision with root package name */
    private i2.a f34402k;

    /* renamed from: l  reason: collision with root package name */
    private d f34403l;

    private b() {
    }

    private synchronized void b() {
        if (this.f34402k == null) {
            this.f34402k = i2.b.a();
        }
    }

    public static synchronized b h() {
        b bVar;
        synchronized (b.class) {
            if (f34391m == null) {
                f34391m = new b();
            }
            bVar = f34391m;
        }
        return bVar;
    }

    public void a(a aVar) {
        this.f34400i.add(aVar);
        this.f34401j.put(aVar.appAid, aVar);
    }

    public d c() {
        return this.f34403l;
    }

    public String d(String str) {
        return this.f34397f + str;
    }

    public String e(String str) {
        a aVar = this.f34401j.get(str);
        return aVar != null ? aVar.name : "";
    }

    public String f() {
        return this.f34399h;
    }

    public String g() {
        if (TextUtils.isEmpty(this.f34398g)) {
            this.f34398g = this.f34403l.h();
        }
        return this.f34398g;
    }

    public a i(String str) {
        return this.f34401j.get(str);
    }

    public i2.a j() {
        b();
        return this.f34402k;
    }

    public int k() {
        return (this.f34394c && !this.f34395d) ? 4 : 1;
    }

    public String l() {
        return this.f34397f;
    }

    public String m() {
        UUID uuid = this.f34396e;
        if (uuid != null) {
            return uuid.toString();
        }
        return null;
    }

    public int n() {
        Iterator<a> it = this.f34400i.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (it.next().j()) {
                i10++;
            }
        }
        return i10;
    }

    public boolean o() {
        return this.f34394c;
    }

    public synchronized void p() {
        if (!this.f34393b) {
            this.f34393b = true;
            this.f34392a = LeisenIfaceOperator.getInstance();
            this.f34394c = q.a(com.mobvoi.android.common.utils.b.e(), WearPath.TicPay.PAY, "bus_card_test_mode", false);
            this.f34395d = q.a(com.mobvoi.android.common.utils.b.e(), WearPath.TicPay.PAY, "bus_card_alipay_mode", false);
            this.f34396e = UUID.randomUUID();
            k.a("BusCardManager", "onCreate sessionId = " + this.f34396e);
        }
    }

    public synchronized void q() {
        if (this.f34393b) {
            this.f34392a.clearData();
            TSMOperator.getInstance().clearDeviceData();
            this.f34392a = null;
            this.f34400i.clear();
            this.f34394c = false;
            this.f34395d = false;
            this.f34393b = false;
            this.f34396e = null;
            this.f34397f = null;
            this.f34402k = null;
            k.a("BusCardManager", "onDestroy");
        }
    }

    public void r(a aVar) {
        this.f34400i.remove(aVar);
        this.f34401j.remove(aVar.appAid);
    }

    public void s(d dVar) {
        k.c("BusCardManager", "setApduExecutor() called with: %s", dVar);
        this.f34403l = dVar;
    }

    public void t(String str) {
        this.f34399h = str;
    }

    public void u(String str) {
        this.f34398g = str;
    }

    public void v(String str) {
        this.f34397f = str;
    }

    public void w(String str) {
        if (this.f34400i != null && !TextUtils.isEmpty(str)) {
            Iterator<a> it = this.f34400i.iterator();
            while (it.hasNext()) {
                a next = it.next();
                next.isDefault = str.equals(next.appAid);
            }
        }
    }
}
