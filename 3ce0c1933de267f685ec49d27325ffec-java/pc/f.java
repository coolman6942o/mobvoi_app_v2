package pc;

import android.text.TextUtils;
import android.util.SparseArray;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.health.core.data.pojo.DataType;
import fg.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kg.c;
import nf.h;
import nf.m;
import oh.a;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
/* compiled from: HealthDataManager.java */
/* loaded from: classes2.dex */
public class f {

    /* renamed from: e  reason: collision with root package name */
    private static volatile f f32747e;

    /* renamed from: a  reason: collision with root package name */
    private a f32748a;

    /* renamed from: b  reason: collision with root package name */
    private final List<e> f32749b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final m f32750c = new m();

    /* renamed from: d  reason: collision with root package name */
    private HashMap<String, a> f32751d = new HashMap<>();

    private f() {
        c.g(b.e()).newBuilder().addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
    }

    public static f g() {
        if (f32747e == null) {
            synchronized (f.class) {
                if (f32747e == null) {
                    f32747e = new f();
                }
            }
        }
        return f32747e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(h hVar, SparseArray sparseArray) {
        n(sparseArray);
    }

    private void n(SparseArray<a> sparseArray) {
        k.h("HealthDataManager", " updateTodayData data.size = " + sparseArray.size());
        if (sparseArray.size() > 0) {
            this.f32748a = sparseArray.get(eg.c.j());
        } else {
            this.f32748a = null;
        }
        k.h("HealthDataManager", " updateTodayData mTodayData = " + this.f32748a);
        a aVar = this.f32748a;
        if (aVar != null) {
            String b10 = aVar.b();
            if (!TextUtils.isEmpty(b10)) {
                this.f32751d.put(b10, this.f32748a);
            }
        }
        HashMap<String, a> hashMap = this.f32751d;
        if (hashMap != null) {
            Iterator<Map.Entry<String, a>> it = hashMap.entrySet().iterator();
            if (it.hasNext() && it.next().getValue().d() != eg.c.j()) {
                this.f32751d.clear();
            }
        }
        for (e eVar : this.f32749b) {
            eVar.setLoadingIndicator(false);
        }
    }

    public void b(e eVar) {
        boolean isEmpty = this.f32749b.isEmpty();
        this.f32749b.add(eVar);
        if (isEmpty) {
            long b10 = eg.c.b(System.currentTimeMillis());
            ig.b.J().w(Long.valueOf(b10), Long.valueOf((eg.c.f26040a * 1000) + b10));
            this.f32750c.a(pg.b.q().p(new nf.k() { // from class: pc.e
                @Override // nf.k
                public final void i(h hVar, Object obj) {
                    f.this.m(hVar, (SparseArray) obj);
                }
            }));
        }
    }

    public int c(a aVar) {
        if (aVar != null) {
            return aVar.e(DataType.Active);
        }
        return 0;
    }

    public int d(String str) {
        return c(this.f32751d.get(str));
    }

    public int e(a aVar) {
        if (aVar != null) {
            return ph.a.b(aVar.e(DataType.Exercise));
        }
        return 0;
    }

    public int f(String str) {
        return e(this.f32751d.get(str));
    }

    public long h(a aVar) {
        if (aVar != null) {
            return aVar.a();
        }
        return 0L;
    }

    public long i(String str) {
        return h(this.f32751d.get(str));
    }

    public int j(a aVar) {
        if (aVar != null) {
            return aVar.e(DataType.Step);
        }
        return 0;
    }

    public int k(String str) {
        return j(this.f32751d.get(str));
    }

    public void l(String str, String str2) {
        pg.b.q().d(str, str2);
    }
}
