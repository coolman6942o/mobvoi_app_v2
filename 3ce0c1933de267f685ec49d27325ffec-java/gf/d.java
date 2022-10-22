package gf;

import android.os.Message;
import com.alibaba.fastjson.JSON;
import com.huawei.agconnect.exception.AGCServerException;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.s;
import com.mobvoi.fitness.core.data.bt.c;
import com.mobvoi.wear.util.GzipUtils;
import eg.a;
import jf.i;
/* compiled from: BtServer.java */
/* loaded from: classes2.dex */
public abstract class d implements i, s.a {

    /* renamed from: a  reason: collision with root package name */
    private final a f27446a;

    /* renamed from: b  reason: collision with root package name */
    private final String f27447b;

    /* renamed from: c  reason: collision with root package name */
    private final String f27448c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f27449d;

    /* renamed from: e  reason: collision with root package name */
    private String f27450e;

    public d(String str) {
        this(str, a.e());
    }

    private void l(Object obj) {
        String jSONString = JSON.toJSONString(obj);
        if (this.f27449d) {
            this.f27446a.o(this.f27448c, GzipUtils.gzipByte(a.r(jSONString)));
            return;
        }
        this.f27446a.n(this.f27448c, jSONString);
    }

    @Override // com.mobvoi.android.common.utils.s.a
    public void handleMessage(Message message) {
        if (message.what == 1) {
            j0.d dVar = (j0.d) message.obj;
            String str = (String) dVar.f29364a;
            byte[] bArr = (byte[]) dVar.f29365b;
            if (str == null || !str.equals(this.f27447b)) {
                k.s("fit.sync.bt_server", "Message should not be handled in this server, expect path %s, actual %s", this.f27447b, str);
                return;
            }
            if (a.j(bArr)) {
                bArr = GzipUtils.ungzipToByte(bArr);
            }
            k(a.c(bArr));
        }
    }

    public int j(com.mobvoi.fitness.core.data.bt.a aVar) {
        if (aVar == null) {
            return 412;
        }
        String str = aVar.accountId;
        if (str == null || !str.equals(this.f27450e)) {
            return AGCServerException.TOKEN_INVALID;
        }
        return 200;
    }

    protected abstract void k(String str);

    public void m(int i10, String str) {
        c cVar = new c();
        cVar.f17902a = i10;
        cVar.f17903b = str;
        l(cVar);
    }

    public void n(String str) {
        this.f27450e = str;
    }

    public void o(boolean z10) {
        this.f27449d = z10;
    }

    public void p() {
        this.f27446a.k(this.f27447b, new s(this));
    }

    public d(String str, a aVar) {
        this.f27447b = str;
        this.f27448c = str + "/re";
        this.f27446a = aVar;
    }
}
