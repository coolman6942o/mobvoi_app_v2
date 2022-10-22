package gf;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.huawei.agconnect.exception.AGCServerException;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.fitness.core.data.bt.b;
import com.mobvoi.wear.common.base.WearPath;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import jf.a;
import jf.f;
/* compiled from: BtDeleteServer.java */
/* loaded from: classes2.dex */
public abstract class c extends d implements a {

    /* renamed from: f  reason: collision with root package name */
    private f<List<String>> f27445f;

    public c() {
        super(WearPath.Sports.SPORTS_DELETE);
    }

    @Override // jf.a
    public void c(List<String> list) {
        m(200, JSON.toJSONString(list));
    }

    @Override // jf.a
    public void d(f<List<String>> fVar) {
        this.f27445f = fVar;
    }

    @Override // gf.d
    public int j(com.mobvoi.fitness.core.data.bt.a aVar) {
        int j10 = super.j(aVar);
        if (j10 != 200) {
            return j10;
        }
        if (!(aVar instanceof b)) {
            k.s("fit.sync.bt.del_server", "Request data not BtDelete, is %s", aVar.getClass().getSimpleName());
            return AGCServerException.UNKNOW_EXCEPTION;
        }
        String str = ((b) aVar).f17901id;
        return (str == null || str.isEmpty()) ? 412 : 200;
    }

    @Override // gf.d
    protected void k(String str) {
        List list;
        f<List<String>> fVar;
        try {
            list = JSON.parseArray(str, b.class);
        } catch (JSONException e10) {
            k.r("fit.sync.bt.del_server", "json format is invalid or old, skip delete request", e10, new Object[0]);
            list = Collections.emptyList();
        }
        if (!list.isEmpty()) {
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b bVar = (b) it.next();
                int j10 = j(bVar);
                if (j10 != 200) {
                    m(j10, null);
                    break;
                }
                arrayList.add(bVar.f17901id);
            }
            if (arrayList.size() == list.size() && (fVar = this.f27445f) != null) {
                fVar.a(arrayList);
            }
        }
    }
}
