package ya;

import android.app.Application;
import bk.t;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.assistant.account.data.d;
import com.mobvoi.companion.proto.FilecountProto;
import ld.e;
import okhttp3.v;
import rx.i;
/* compiled from: AccountViewModel.java */
/* loaded from: classes2.dex */
public class w extends t {

    /* renamed from: m  reason: collision with root package name */
    public androidx.lifecycle.w<Integer> f36909m = new androidx.lifecycle.w<>();

    /* compiled from: AccountViewModel.java */
    /* loaded from: classes2.dex */
    class a extends i<FilecountProto.SoundFilecountResp> {
        a() {
        }

        /* renamed from: b */
        public void onNext(FilecountProto.SoundFilecountResp soundFilecountResp) {
            if (soundFilecountResp.getErrCode() == 0) {
                k.i("AccountViewModel", " soundFilecountResp.getTotalCount() = %s", Integer.valueOf(soundFilecountResp.getTotalCount()));
                w.this.f36909m.o(Integer.valueOf(soundFilecountResp.getTotalCount()));
                return;
            }
            k.c("AccountViewModel", "获取文件: %s", soundFilecountResp.getErrMsg());
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            k.c("AccountViewModel", "获取文件: %s", th2.getMessage());
        }
    }

    /* compiled from: AccountViewModel.java */
    /* loaded from: classes2.dex */
    static class b extends bk.a {

        /* renamed from: b  reason: collision with root package name */
        private static b f36911b;

        private b() {
        }

        public static b k() {
            if (f36911b == null) {
                synchronized (b.class) {
                    if (f36911b == null) {
                        f36911b = new b();
                    }
                }
            }
            return f36911b;
        }

        @Override // bk.a
        public v d() {
            return new d();
        }
    }

    public w(Application application) {
        super(application);
    }

    @Override // bk.t
    protected bk.a F() {
        return b.k();
    }

    @Override // bk.t
    protected String G(Application application) {
        return ta.a.s();
    }

    public void h0() {
        this.f5200k = ta.a.s();
        e.h().m(this.f5200k).Z(cq.a.c()).H(xp.a.b()).V(new a());
    }
}
