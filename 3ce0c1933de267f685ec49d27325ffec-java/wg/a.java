package wg;

import ah.b;
import ah.c;
import android.content.Context;
import com.mobvoi.fitness.core.data.bt.e;
import com.mobvoi.wear.common.base.WearPath;
import gf.d;
/* compiled from: BtAccountServer.java */
/* loaded from: classes2.dex */
public abstract class a extends d {

    /* renamed from: f  reason: collision with root package name */
    private final Context f36232f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BtAccountServer.java */
    /* renamed from: wg.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0524a implements b.a<Boolean> {
        C0524a() {
        }

        /* renamed from: b */
        public void a(Boolean bool) {
            a.this.r(bool.booleanValue());
        }
    }

    public a(Context context) {
        super(WearPath.Sports.USER_PROFILE);
        this.f36232f = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(boolean z10) {
        m(z10 ? 200 : 621, null);
    }

    private boolean s(e eVar) {
        ah.a o10 = c.a().o(this.f36232f);
        if (o10.b(eVar)) {
            c.a().f(this.f36232f, o10, new C0524a());
        } else {
            r(true);
        }
        return true;
    }

    @Override // gf.d
    protected void k(String str) {
        e b10 = e.b(str);
        int j10 = j(b10);
        if (j10 != 200) {
            m(j10, null);
        } else {
            s(b10);
        }
    }
}
