package zf;

import android.os.SystemClock;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.health.common.data.db.DbSyncAccessor;
import eg.f;
import java.lang.Enum;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import qf.b;
import xf.c;
import yf.c;
import yf.d;
/* compiled from: ClientSyncer.java */
/* loaded from: classes2.dex */
public class c<DataSync extends yf.c, DataIdentify extends yf.c, DataSearch extends yf.c, Type extends Enum<Type> & xf.c, Data extends b<Type>> {

    /* renamed from: a  reason: collision with root package name */
    private final DbSyncAccessor<Type, Data> f37398a;

    /* renamed from: b  reason: collision with root package name */
    private final i<Type, Data, DataSync, DataIdentify, DataSearch> f37399b;

    /* renamed from: c  reason: collision with root package name */
    private final j<Type, Data, DataSync> f37400c;

    /* renamed from: d  reason: collision with root package name */
    private final d<DataSync, DataIdentify> f37401d;

    /* renamed from: e  reason: collision with root package name */
    private final d<DataSearch, DataSync> f37402e;

    /* renamed from: f  reason: collision with root package name */
    private final k f37403f;

    /* renamed from: g  reason: collision with root package name */
    private final k f37404g;

    /* renamed from: h  reason: collision with root package name */
    private String f37405h = "";

    public c(DbSyncAccessor<Type, Data> dbSyncAccessor, i<Type, Data, DataSync, DataIdentify, DataSearch> iVar, j<Type, Data, DataSync> jVar, d<DataSync, DataIdentify> dVar, d<DataSearch, DataSync> dVar2, k kVar, k kVar2) {
        this.f37398a = dbSyncAccessor;
        this.f37399b = iVar;
        this.f37400c = jVar;
        this.f37401d = dVar;
        this.f37402e = dVar2;
        if (dVar != null) {
            dVar.a(new yf.b() { // from class: zf.a
                @Override // yf.b
                public final void a(List list, Throwable th2) {
                    c.this.g(list, th2);
                }
            });
        }
        if (dVar2 != null) {
            dVar2.a(new yf.b() { // from class: zf.b
                @Override // yf.b
                public final void a(List list, Throwable th2) {
                    c.this.f(list, th2);
                }
            });
        }
        this.f37403f = kVar;
        this.f37404g = kVar2;
    }

    private boolean c(DataSearch datasearch) {
        d<DataSearch, DataSync> dVar = this.f37402e;
        boolean z10 = true;
        if (dVar == null || !dVar.isConnected()) {
            Object[] objArr = new Object[1];
            if (this.f37402e == null) {
                z10 = false;
            }
            objArr[0] = Boolean.valueOf(z10);
            k.c("health.sync.client", "Cannot get data, isConnected: %s", objArr);
            return false;
        }
        k.c("health.sync.client", "getData for %s", datasearch);
        this.f37402e.b(Collections.singletonList(datasearch));
        return true;
    }

    private boolean d(DataSearch datasearch) {
        this.f37398a.a();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(List<DataSync> list, Throwable th2) {
        if (list != null) {
            if (!list.isEmpty()) {
                if (f.a.c()) {
                    Iterator<DataSync> it = list.iterator();
                    while (it.hasNext()) {
                        k.c("health.sync.client", "data fetched: %s", it.next());
                    }
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.f37400c.a(list);
                long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                String simpleName = list.get(0).getClass().getSimpleName();
                float f10 = ((float) elapsedRealtime2) / 1000.0f;
                k.c("health.sync.client", "getData for %s success, saved %d data, took %.1fs", simpleName, Integer.valueOf(list.size()), Float.valueOf(f10));
                if (elapsedRealtime2 > 1000) {
                    k.s("health.sync.client", "save %s stuck, took %.1fs", simpleName, Float.valueOf(f10));
                    return;
                }
                return;
            }
            this.f37400c.a(list);
        } else if (th2 != null) {
            k.r("health.sync.client", "getData failed", th2, new Object[0]);
            k kVar = this.f37404g;
            if (kVar != null) {
                kVar.a(th2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(List<DataIdentify> list, Throwable th2) {
        if (list != null) {
            k.i("health.sync.client", "postData success, set %d data to synced", Integer.valueOf(list.size()));
            this.f37399b.c(list);
        } else if (th2 != null) {
            k.r("health.sync.client", "postData failed", th2, new Object[0]);
            k kVar = this.f37403f;
            if (kVar != null) {
                kVar.a(th2);
            }
        }
    }

    private boolean h(List<DataSync> list) {
        d<DataSync, DataIdentify> dVar = this.f37401d;
        boolean z10 = true;
        if (dVar == null || !dVar.isConnected()) {
            Object[] objArr = new Object[1];
            if (this.f37401d == null) {
                z10 = false;
            }
            objArr[0] = Boolean.valueOf(z10);
            k.c("health.sync.client", "Cannot post data, isConnected: %s", objArr);
            return false;
        }
        if (!list.isEmpty()) {
            k.i("health.sync.client", "postData, have %d data to post", Integer.valueOf(list.size()));
            this.f37401d.b(list);
        }
        return true;
    }

    public boolean e(DataSearch datasearch) {
        if (TextUtils.isEmpty(datasearch.wwid)) {
            datasearch.wwid = this.f37405h;
        }
        return c(datasearch) || d(datasearch);
    }

    public void i(String str) {
        if (str == null) {
            str = "";
        }
        this.f37405h = str;
    }

    /* JADX WARN: Incorrect types in method signature: (TType;J)Z */
    public boolean j(Enum r12, long j10) {
        return k(r12, j10);
    }

    /* JADX WARN: Incorrect types in method signature: (TType;J)Z */
    public boolean k(Enum r22, long j10) {
        List<DataSync> a10 = this.f37399b.a(r22, j10);
        return a10.isEmpty() || h(a10);
    }
}
