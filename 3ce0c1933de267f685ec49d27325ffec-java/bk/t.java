package bk;

import android.app.Application;
import android.content.Context;
import android.util.Pair;
import androidx.lifecycle.b;
import androidx.lifecycle.w;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.ticcare.common.model.bean.TicCareDeviceInfo;
import com.mobvoi.ticcare.common.model.bean.a;
import com.mobvoi.ticcare.common.model.bean.b;
import dk.a;
import dk.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import retrofit2.HttpException;
import zn.g;
/* compiled from: TicCareViewModel.java */
/* loaded from: classes2.dex */
public abstract class t extends b {

    /* renamed from: k  reason: collision with root package name */
    protected String f5200k;

    /* renamed from: a  reason: collision with root package name */
    private final a f5190a = F();

    /* renamed from: b  reason: collision with root package name */
    private final w<Integer> f5191b = new w<>();

    /* renamed from: c  reason: collision with root package name */
    private final w<Integer> f5192c = new w<>();

    /* renamed from: d  reason: collision with root package name */
    private final w<Integer> f5193d = new w<>();

    /* renamed from: e  reason: collision with root package name */
    private final w<Boolean> f5194e = new w<>();

    /* renamed from: f  reason: collision with root package name */
    private final w<Pair<Boolean, List<TicCareDeviceInfo>>> f5195f = new w<>();

    /* renamed from: g  reason: collision with root package name */
    private final w<Pair<Boolean, List<TicCareDeviceInfo>>> f5196g = new w<>();

    /* renamed from: h  reason: collision with root package name */
    private final w<Pair<Boolean, List<a.C0276a>>> f5197h = new w<>();

    /* renamed from: i  reason: collision with root package name */
    private final w<Boolean> f5198i = new w<>();

    /* renamed from: j  reason: collision with root package name */
    private final w<Pair<Boolean, String>> f5199j = new w<>();

    /* renamed from: l  reason: collision with root package name */
    private xn.a f5201l = new xn.a();

    public t(Application application) {
        super(application);
        this.f5200k = G(application);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(c cVar) throws Exception {
        if (cVar != null) {
            this.f5192c.m(Integer.valueOf(cVar.errCode));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(Throwable th2) throws Exception {
        k.h("TicCareViewModel", " addCareWatchDevice throwable = " + th2);
        this.f5192c.m(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(c cVar) throws Exception {
        if (cVar.errCode == 0) {
            this.f5194e.m(Boolean.TRUE);
        } else {
            this.f5194e.m(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(Throwable th2) throws Exception {
        this.f5194e.m(Boolean.FALSE);
        k.h("TicCareViewModel", " cancelCareWatchDevice throwable = " + th2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(String str, c cVar) throws Exception {
        if (cVar.errCode == 0) {
            this.f5199j.m(new Pair<>(Boolean.TRUE, str));
        } else {
            this.f5199j.m(new Pair<>(Boolean.FALSE, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(Throwable th2) throws Exception {
        this.f5199j.m(new Pair<>(Boolean.FALSE, null));
        k.h("TicCareViewModel", " deleteCareWatchUser throwable = " + th2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(com.mobvoi.ticcare.common.model.bean.a aVar) throws Exception {
        if (aVar.errCode == 0) {
            ArrayList arrayList = new ArrayList();
            for (a.C0241a aVar2 : aVar.data) {
                arrayList.add(TicCareDeviceInfo.a(aVar2));
            }
            this.f5195f.m(new Pair<>(Boolean.TRUE, arrayList));
            return;
        }
        this.f5195f.m(new Pair<>(Boolean.FALSE, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(Throwable th2) throws Exception {
        this.f5195f.m(new Pair<>(Boolean.FALSE, null));
        k.h("TicCareViewModel", " queryCareMeResult throwable = " + th2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(dk.b bVar) throws Exception {
        if (bVar.errCode != 0) {
            this.f5191b.m(100002);
        } else if (bVar.data.booleanValue()) {
            this.f5191b.m(1000);
        } else {
            this.f5191b.m(1001);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(Throwable th2) throws Exception {
        this.f5191b.m(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(com.mobvoi.ticcare.common.model.bean.b bVar) throws Exception {
        if (bVar.errCode == 0) {
            List<b.a> list = bVar.data;
            if (list == null || list.size() <= 0) {
                this.f5196g.m(new Pair<>(Boolean.FALSE, null));
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (b.a aVar : bVar.data) {
                arrayList.add(TicCareDeviceInfo.b(aVar));
            }
            this.f5196g.m(new Pair<>(Boolean.TRUE, arrayList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(Throwable th2) throws Exception {
        this.f5196g.m(new Pair<>(Boolean.FALSE, null));
        k.h("TicCareViewModel", " queryFollowMeResult throwable = " + th2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(dk.a aVar) throws Exception {
        if (aVar.errCode == 0) {
            this.f5197h.m(new Pair<>(Boolean.TRUE, aVar.data));
        } else {
            this.f5197h.m(new Pair<>(Boolean.FALSE, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(Throwable th2) throws Exception {
        this.f5197h.m(new Pair<>(Boolean.FALSE, null));
        k.h("TicCareViewModel", " queryWatchShareDataSetting throwable = " + th2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(c cVar) throws Exception {
        this.f5193d.m(Integer.valueOf(cVar.errCode));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(Throwable th2) throws Exception {
        if (th2 instanceof HttpException) {
            HttpException httpException = (HttpException) th2;
            this.f5193d.m(Integer.valueOf(httpException.code()));
            k.h("TicCareViewModel", " updateCareWatchNickName httpException.code() = " + httpException.code());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(Context context, String str, boolean z10, c cVar) throws Exception {
        if (cVar.errCode == 0) {
            f0(context, str, z10);
            this.f5198i.m(Boolean.TRUE);
            return;
        }
        this.f5198i.m(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(Throwable th2) throws Exception {
        this.f5198i.m(Boolean.FALSE);
        k.h("TicCareViewModel", " updateWatchShareDataSetting throwable = " + th2);
    }

    private void f0(Context context, String str, boolean z10) {
        if (str.equals("SHARE_EXERCISE")) {
            ek.a.b(context, "key_share_exercise", z10);
        } else if (str.equals("SHARE_HEALTH")) {
            ek.a.b(context, "key_share_health", z10);
        }
    }

    private void u() {
        if (this.f5201l == null) {
            this.f5201l = new xn.a();
        }
    }

    public w<Pair<Boolean, String>> A() {
        return this.f5199j;
    }

    public w<Integer> B() {
        return this.f5191b;
    }

    public w<Pair<Boolean, List<TicCareDeviceInfo>>> C() {
        return this.f5196g;
    }

    public w<Boolean> D() {
        return this.f5198i;
    }

    public w<Pair<Boolean, List<a.C0276a>>> E() {
        return this.f5197h;
    }

    protected abstract a F();

    protected abstract String G(Application application);

    public w<Integer> H() {
        return this.f5193d;
    }

    public void a0() {
        if (this.f5200k == null) {
            k.h("TicCareViewModel", " queryCareMeResult mToken == null");
            return;
        }
        u();
        this.f5201l.b(this.f5190a.e(this.f5200k).subscribe(new g() { // from class: bk.b
            @Override // zn.g
            public final void accept(Object obj) {
                t.this.O((com.mobvoi.ticcare.common.model.bean.a) obj);
            }
        }, new g() { // from class: bk.c
            @Override // zn.g
            public final void accept(Object obj) {
                t.this.P((Throwable) obj);
            }
        }));
    }

    public void b0(String str) {
        if (this.f5200k == null) {
            k.h("TicCareViewModel", " queryCareStatus mToken == null");
            return;
        }
        u();
        this.f5201l.b(this.f5190a.f(this.f5200k, str).subscribe(new g() { // from class: bk.l
            @Override // zn.g
            public final void accept(Object obj) {
                t.this.Q((dk.b) obj);
            }
        }, new g() { // from class: bk.e
            @Override // zn.g
            public final void accept(Object obj) {
                t.this.R((Throwable) obj);
            }
        }));
    }

    public void c0() {
        if (this.f5200k == null) {
            k.h("TicCareViewModel", " queryFollowMeResult mToken == null");
            return;
        }
        u();
        this.f5201l.b(this.f5190a.g(this.f5200k).subscribe(new g() { // from class: bk.m
            @Override // zn.g
            public final void accept(Object obj) {
                t.this.S((com.mobvoi.ticcare.common.model.bean.b) obj);
            }
        }, new g() { // from class: bk.d
            @Override // zn.g
            public final void accept(Object obj) {
                t.this.T((Throwable) obj);
            }
        }));
    }

    public void d0() {
        if (this.f5200k == null) {
            k.h("TicCareViewModel", " queryWatchShareDataSetting mToken == null");
            return;
        }
        u();
        this.f5201l.b(this.f5190a.h(this.f5200k).subscribe(new g() { // from class: bk.k
            @Override // zn.g
            public final void accept(Object obj) {
                t.this.U((dk.a) obj);
            }
        }, new g() { // from class: bk.f
            @Override // zn.g
            public final void accept(Object obj) {
                t.this.V((Throwable) obj);
            }
        }));
    }

    public void e0(TicCareDeviceInfo ticCareDeviceInfo, String str) {
        if (this.f5200k == null) {
            k.h("TicCareViewModel", " updateCareWatchNickName mToken == null");
            return;
        }
        u();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("care_wwid", ticCareDeviceInfo.wwid);
        hashMap.put("care_device_id", ticCareDeviceInfo.deviceId);
        hashMap.put("care_remark_name", str);
        this.f5201l.b(this.f5190a.i(this.f5200k, hashMap).subscribe(new g() { // from class: bk.n
            @Override // zn.g
            public final void accept(Object obj) {
                t.this.W((c) obj);
            }
        }, new g() { // from class: bk.h
            @Override // zn.g
            public final void accept(Object obj) {
                t.this.X((Throwable) obj);
            }
        }));
    }

    public void g0(final Context context, final String str, final boolean z10) {
        if (this.f5200k == null) {
            k.h("TicCareViewModel", " updateWatchShareDataSetting mToken == null");
            return;
        }
        u();
        this.f5201l.b(this.f5190a.j(this.f5200k, str, z10).subscribe(new g() { // from class: bk.i
            @Override // zn.g
            public final void accept(Object obj) {
                t.this.Y(context, str, z10, (c) obj);
            }
        }, new g() { // from class: bk.g
            @Override // zn.g
            public final void accept(Object obj) {
                t.this.Z((Throwable) obj);
            }
        }));
    }

    public void s(TicCareDeviceInfo ticCareDeviceInfo) {
        if (this.f5200k == null) {
            k.h("TicCareViewModel", " updateCareWatchNickName mToken == null");
            return;
        }
        u();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("care_wwid", ticCareDeviceInfo.wwid);
        hashMap.put("care_device_name", ticCareDeviceInfo.deviceName);
        hashMap.put("care_device_type", ticCareDeviceInfo.deviceType);
        hashMap.put("care_device_id", ticCareDeviceInfo.deviceId);
        hashMap.put("care_remark_name", ticCareDeviceInfo.remarkName);
        this.f5201l.b(this.f5190a.a(this.f5200k, hashMap).subscribe(new g() { // from class: bk.p
            @Override // zn.g
            public final void accept(Object obj) {
                t.this.I((c) obj);
            }
        }, new g() { // from class: bk.q
            @Override // zn.g
            public final void accept(Object obj) {
                t.this.J((Throwable) obj);
            }
        }));
    }

    public void t(TicCareDeviceInfo ticCareDeviceInfo) {
        if (this.f5200k == null) {
            k.h("TicCareViewModel", " updateCareWatchNickName mToken == null");
            return;
        }
        u();
        this.f5201l.b(this.f5190a.b(this.f5200k, ticCareDeviceInfo.wwid, ticCareDeviceInfo.deviceId).subscribe(new g() { // from class: bk.o
            @Override // zn.g
            public final void accept(Object obj) {
                t.this.K((c) obj);
            }
        }, new g() { // from class: bk.r
            @Override // zn.g
            public final void accept(Object obj) {
                t.this.L((Throwable) obj);
            }
        }));
    }

    public void v(final String str) {
        if (this.f5200k == null) {
            k.h("TicCareViewModel", " deleteCareWatchUser mToken == null");
            return;
        }
        u();
        this.f5201l.b(this.f5190a.c(this.f5200k, str).subscribe(new g() { // from class: bk.j
            @Override // zn.g
            public final void accept(Object obj) {
                t.this.M(str, (c) obj);
            }
        }, new g() { // from class: bk.s
            @Override // zn.g
            public final void accept(Object obj) {
                t.this.N((Throwable) obj);
            }
        }));
    }

    public void w() {
        xn.a aVar = this.f5201l;
        if (aVar != null) {
            aVar.d();
        }
    }

    public w<Integer> x() {
        return this.f5192c;
    }

    public w<Boolean> y() {
        return this.f5194e;
    }

    public w<Pair<Boolean, List<TicCareDeviceInfo>>> z() {
        return this.f5195f;
    }
}
