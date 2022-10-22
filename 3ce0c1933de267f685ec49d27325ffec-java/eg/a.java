package eg;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.msgproxy.MessageInfo;
import com.mobvoi.wear.msgproxy.MessageProxyClient;
import com.mobvoi.wear.msgproxy.MessageProxyException;
import com.mobvoi.wear.msgproxy.MessageProxyListener;
import com.mobvoi.wear.msgproxy.NodeInfo;
import com.mobvoi.wear.util.GzipUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import nf.h;
/* compiled from: BtTransporter.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private static a f26029c;

    /* renamed from: a  reason: collision with root package name */
    private e f26030a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Handler> f26031b = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BtTransporter.java */
    /* loaded from: classes2.dex */
    public interface b {
        void a(boolean z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BtTransporter.java */
    /* loaded from: classes2.dex */
    public static final class c extends d {
        @Override // eg.a.d
        public void d(j0.d<String, byte[]> dVar) {
        }

        private c() {
            super(null);
            f(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BtTransporter.java */
    /* loaded from: classes2.dex */
    public static abstract class d {

        /* renamed from: a  reason: collision with root package name */
        private boolean f26032a = true;

        /* renamed from: b  reason: collision with root package name */
        private boolean f26033b = false;

        /* renamed from: c  reason: collision with root package name */
        private final b f26034c;

        protected d(b bVar) {
            this.f26034c = bVar;
        }

        protected void a() {
            this.f26032a = true;
            this.f26033b = false;
        }

        public boolean b() {
            return this.f26032a;
        }

        public boolean c() {
            return this.f26033b && this.f26032a;
        }

        public abstract void d(j0.d<String, byte[]> dVar);

        protected void e() {
            this.f26033b = false;
        }

        protected void f(boolean z10) {
            this.f26032a = z10;
            this.f26033b = true;
            b bVar = this.f26034c;
            if (bVar != null) {
                bVar.a(z10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BtTransporter.java */
    /* loaded from: classes2.dex */
    public static class e extends Handler implements b {

        /* renamed from: a  reason: collision with root package name */
        private d f26035a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f26036b;

        /* renamed from: c  reason: collision with root package name */
        private final nf.c<Boolean> f26037c;

        /* renamed from: d  reason: collision with root package name */
        private final Queue<j0.d<String, byte[]>> f26038d;

        /* JADX INFO: Access modifiers changed from: private */
        public h<Boolean> d() {
            e();
            return this.f26037c;
        }

        private synchronized d e() {
            if (this.f26035a == null) {
                k.i(a.f(), "Create Message client with proxy? %s", Boolean.valueOf(this.f26036b));
                if (this.f26036b) {
                    this.f26035a = new f(this);
                } else {
                    this.f26035a = new c();
                }
            }
            return this.f26035a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean f() {
            return e().b();
        }

        private List<j0.d<String, byte[]>> g() {
            ArrayList arrayList;
            synchronized (this.f26038d) {
                arrayList = new ArrayList(this.f26038d);
                this.f26038d.clear();
            }
            return arrayList;
        }

        private synchronized void h() {
            d dVar = this.f26035a;
            if (dVar != null) {
                dVar.a();
                this.f26035a = null;
                e();
            }
        }

        private void i(j0.d<String, byte[]> dVar) {
            e().d(dVar);
        }

        private void j() {
            if (e().c()) {
                for (j0.d<String, byte[]> dVar : g()) {
                    i(dVar);
                }
            }
        }

        @Override // eg.a.b
        public void a(boolean z10) {
            removeMessages(2);
            obtainMessage(2, Boolean.valueOf(z10)).sendToTarget();
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                j0.d<String, byte[]> dVar = (j0.d) message.obj;
                String str = dVar.f29364a;
                if (e().c()) {
                    i(dVar);
                    return;
                }
                k.c(a.f(), "pending message %s", str);
                synchronized (this.f26038d) {
                    this.f26038d.add(dVar);
                }
            } else if (i10 == 2) {
                j();
                this.f26037c.f(Boolean.valueOf(((Boolean) message.obj).booleanValue()));
            }
        }

        void k(boolean z10) {
            this.f26036b = z10;
            h();
        }

        private e(Context context) {
            this.f26036b = false;
            this.f26037c = new nf.c<>();
            this.f26038d = new LinkedList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BtTransporter.java */
    /* loaded from: classes2.dex */
    public static final class f extends d implements com.mobvoi.android.common.ipc.a, MessageProxyListener {

        /* renamed from: d  reason: collision with root package name */
        private MessageProxyClient f26039d;

        protected f(b bVar) {
            super(bVar);
            g();
        }

        private synchronized MessageProxyClient g() {
            if (this.f26039d == null) {
                k.h(a.f(), "Create MessageProxyClient");
                MessageProxyClient messageProxyClient = MessageProxyClient.getInstance();
                this.f26039d = messageProxyClient;
                messageProxyClient.addConnectListener(this);
                this.f26039d.addListener(this);
                this.f26039d.connectProxyService();
                if (this.f26039d.isProxyServiceConnected()) {
                    try {
                        onConnectedNodesChanged(this.f26039d.getConnectedNodes());
                    } catch (MessageProxyException e10) {
                        k.e(a.f(), "wrong service connect state!", e10);
                        e();
                    }
                }
            }
            return this.f26039d;
        }

        @Override // eg.a.d
        protected void a() {
            super.a();
            this.f26039d.removeConnectListener(this);
            this.f26039d.removeListener(this);
            this.f26039d = null;
        }

        @Override // eg.a.d
        public void d(j0.d<String, byte[]> dVar) {
            String str = dVar.f29364a;
            byte[] bArr = dVar.f29365b;
            a.l("send proxy message", str, bArr);
            g().sendMessage(str, bArr);
        }

        @Override // com.mobvoi.wear.msgproxy.MessageProxyListener
        public void onConnectedNodesChanged(List<NodeInfo> list) {
            boolean z10 = !list.isEmpty();
            k.i(a.f(), "Connection changed to connected? %s", Boolean.valueOf(z10));
            f(z10);
        }

        @Override // com.mobvoi.wear.msgproxy.MessageProxyListener
        public void onMessageReceived(MessageInfo messageInfo) {
        }

        @Override // com.mobvoi.android.common.ipc.a
        public void onStateChanged(int i10) {
            if (i10 == 1) {
                k.a(a.f(), "MessageProxyClient disconnected");
                e();
            } else if (i10 == 2) {
                k.a(a.f(), "MessageProxyClient connecting");
            } else if (i10 == 3) {
                k.a(a.f(), "MessageProxyClient connected");
                try {
                    onConnectedNodesChanged(g().getConnectedNodes());
                } catch (MessageProxyException e10) {
                    k.e(a.f(), "wrong service connect state!", e10);
                    e();
                }
            }
        }
    }

    private a(Context context) {
        this.f26030a = new e(context);
    }

    public static String c(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }

    public static a e() {
        a aVar = f26029c;
        if (aVar != null) {
            return aVar;
        }
        throw new RuntimeException("Call BtTransport.init(Context) before using it.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String f() {
        return eg.f.f26043a + "bt.transporter";
    }

    public static void h(Context context) {
        f26029c = new a(context.getApplicationContext());
    }

    public static boolean j(byte[] bArr) {
        if (bArr.length < 2) {
            return false;
        }
        return 35615 == (((bArr[1] << 8) & 65280) | (bArr[0] & 255));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(String str, String str2, byte[] bArr) {
        if (k.j()) {
            boolean j10 = j(bArr);
            String ungzipToString = j10 ? GzipUtils.ungzipToString(bArr) : c(bArr);
            String f10 = f();
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = str2;
            objArr[2] = j10 ? " (compressed)" : "";
            k.c(f10, "%s..... path %s, data%s: {{{", objArr);
            int i10 = 0;
            while (i10 < ungzipToString.length()) {
                int i11 = i10 + 2048;
                k.a(f(), ungzipToString.substring(i10, Math.min(i11, ungzipToString.length())));
                i10 = i11;
            }
            k.c(f(), "}}} end %s for path %s", str, str2);
        }
    }

    private void p(Handler handler, String str, byte[] bArr) {
        Message obtainMessage = handler.obtainMessage(1);
        obtainMessage.obj = j0.d.a(str, bArr);
        obtainMessage.sendToTarget();
    }

    public static byte[] r(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    public h<Boolean> d() {
        return this.f26030a.d();
    }

    public void g(String str, byte[] bArr) {
        Handler handler = this.f26031b.get(str);
        if (handler != null) {
            l("received message", str, bArr);
            p(handler, str, bArr);
            return;
        }
        l("message not handled", str, bArr);
    }

    public boolean i() {
        return this.f26030a.f();
    }

    public void k(String str, Handler handler) {
        if (handler != null) {
            k.i(f(), "Start listen to message %s", str);
            this.f26031b.put(str, handler);
        }
    }

    public void m(String str, Object obj) {
        o(str, JSON.toJSONBytes(obj, new SerializerFeature[0]));
    }

    public void n(String str, String str2) {
        o(str, r(str2));
    }

    public void o(String str, byte[] bArr) {
        p(this.f26030a, str, bArr);
    }

    public void q(boolean z10) {
        this.f26030a.k(z10);
    }
}
