package gf;

import android.os.Message;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.s;
import com.mobvoi.fitness.core.data.bt.c;
import com.mobvoi.wear.util.GzipUtils;
import j0.d;
/* compiled from: BtClient.java */
/* loaded from: classes2.dex */
public abstract class a implements hf.a, s.a {

    /* renamed from: a  reason: collision with root package name */
    private final eg.a f27439a;

    /* renamed from: b  reason: collision with root package name */
    private final String f27440b;

    /* renamed from: c  reason: collision with root package name */
    private final String f27441c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f27442d;

    public a(String str) {
        this(str, eg.a.e());
    }

    @Override // com.mobvoi.android.common.utils.s.a
    public void handleMessage(Message message) {
        if (message.what == 1) {
            d dVar = (d) message.obj;
            String str = (String) dVar.f29364a;
            byte[] bArr = (byte[]) dVar.f29365b;
            if (str == null || !str.equals(this.f27441c)) {
                k.s("fit.sync.bt_client", "Message should not be handled in this client, expect path %s, actual %s", this.f27441c, str);
                return;
            }
            if (eg.a.j(bArr)) {
                bArr = GzipUtils.ungzipToByte(bArr);
            }
            c cVar = (c) JSON.parseObject(bArr, c.class, new Feature[0]);
            if (cVar.f17902a == 200) {
                i(cVar.f17903b, null);
            }
        }
    }

    protected abstract void i(String str, Throwable th2);

    @Override // hf.a
    public boolean isConnected() {
        return this.f27439a.i();
    }

    public void j(String str) {
        if (this.f27442d) {
            this.f27439a.o(this.f27440b, GzipUtils.gzipByte(eg.a.r(str)));
            return;
        }
        this.f27439a.n(this.f27440b, str);
    }

    public void k(boolean z10) {
        this.f27442d = z10;
    }

    public void l() {
        this.f27439a.k(this.f27441c, new s(this));
    }

    public a(String str, eg.a aVar) {
        this.f27440b = str;
        this.f27441c = str + "/re";
        this.f27439a = aVar;
    }
}
