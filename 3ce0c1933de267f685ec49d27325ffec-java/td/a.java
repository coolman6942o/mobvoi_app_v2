package td;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.alipay.sdk.app.PayTask;
import com.mobvoi.android.common.utils.k;
import java.util.Map;
/* compiled from: Alipay.java */
/* loaded from: classes2.dex */
public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private HandlerC0505a f35125a = new HandlerC0505a(this, Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    private Activity f35126b;

    /* renamed from: c  reason: collision with root package name */
    private String f35127c;

    /* renamed from: d  reason: collision with root package name */
    private c f35128d;

    /* compiled from: Alipay.java */
    /* renamed from: td.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class HandlerC0505a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public a f35129a;

        public HandlerC0505a(a aVar, Looper looper) {
            super(looper);
            this.f35129a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            this.f35129a.a(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Alipay.java */
    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        String f35130a;

        b(a aVar, Map<String, String> map) {
            if (map != null) {
                for (String str : map.keySet()) {
                    if (TextUtils.equals(str, "resultStatus")) {
                        this.f35130a = map.get(str);
                    }
                }
            }
        }
    }

    public a(Activity activity, c cVar) {
        this.f35126b = activity;
        this.f35128d = cVar;
    }

    public void a(Message message) {
        if (message.what == 1) {
            String str = new b(this, (Map) message.obj).f35130a;
            k.a("Pay", "Alipay result:" + str);
            if ("9000".equalsIgnoreCase(str)) {
                this.f35128d.c();
            } else if ("6001".equalsIgnoreCase(str)) {
                this.f35128d.d();
            } else {
                this.f35128d.b();
            }
        }
    }

    public void b(String str) {
        this.f35127c = str;
        new Thread(this).start();
    }

    @Override // java.lang.Runnable
    public void run() {
        Map<String, String> payV2 = new PayTask(this.f35126b).payV2(this.f35127c, true);
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = payV2;
        this.f35125a.sendMessage(obtain);
    }
}
