package qd;

import android.content.Context;
import android.content.Intent;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.ticpay.ui.PaymentCenterActivity;
import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.msgproxy.MessageInfo;
import com.mobvoi.wear.msgproxy.MessageProxyClient;
import com.mobvoi.wear.msgproxy.MessageProxyException;
import com.mobvoi.wear.msgproxy.MessageProxyListener;
import com.mobvoi.wear.msgproxy.NodeInfo;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import mk.a;
import mk.b;
/* compiled from: WearableUtil.java */
/* loaded from: classes2.dex */
public class o implements MessageProxyListener, d {

    /* renamed from: g  reason: collision with root package name */
    private static final TimeUnit f33113g = TimeUnit.SECONDS;

    /* renamed from: h  reason: collision with root package name */
    private static final Object f33114h = new Object();

    /* renamed from: i  reason: collision with root package name */
    private static o f33115i;

    /* renamed from: a  reason: collision with root package name */
    private final Context f33116a;

    /* renamed from: c  reason: collision with root package name */
    private volatile String f33118c;

    /* renamed from: f  reason: collision with root package name */
    private String f33121f;

    /* renamed from: b  reason: collision with root package name */
    private int f33117b = -1;

    /* renamed from: d  reason: collision with root package name */
    private final Semaphore f33119d = new Semaphore(1);

    /* renamed from: e  reason: collision with root package name */
    private final BlockingQueue<byte[]> f33120e = new LinkedBlockingDeque(1);

    private o(Context context) {
        this.f33116a = context;
    }

    private String j() {
        String num;
        synchronized (f33114h) {
            int i10 = (this.f33117b + 1) % 46656;
            this.f33117b = i10;
            num = Integer.toString(i10, 36);
        }
        return num;
    }

    public static o k(Context context) {
        o oVar = f33115i;
        if (oVar == null) {
            synchronized (f33114h) {
                oVar = f33115i;
                if (oVar == null) {
                    oVar = new o(context.getApplicationContext());
                    f33115i = oVar;
                }
            }
        }
        return oVar;
    }

    private void l(String str, byte[] bArr) {
        if (Arrays.equals(bArr, a.f30838c)) {
            k.a("WearableUtil", "nfc disabled");
            m("action.NFC_DISABLED", str);
        } else if (Arrays.equals(bArr, a.f30839d)) {
            k.a("WearableUtil", "se not init.");
            m("action.SE_NOT_INIT", str);
        } else {
            k.c("WearableUtil", "onMessageReceived path %s, mWaitForResultPath %s", str, this.f33118c);
            if (str.equals(this.f33118c)) {
                this.f33118c = null;
                k.c("WearableUtil", "onMessageReceived data %s", b.a(bArr));
                k.c("WearableUtil", "onMessageReceived put data to queue : %s", Boolean.valueOf(this.f33120e.offer(bArr)));
            }
            if (WearPath.TicPay.CPLC.equals(str)) {
                String a10 = b.a(bArr);
                k.c("WearableUtil", "onMessageReceived cplc %s", a10);
                String substring = a10.substring(6, a10.length() - 4);
                k.c("WearableUtil", "onMessageReceived real cplc %s", substring);
                this.f33121f = substring;
            } else if (WearPath.TicPay.BTC_INFO.equals(str)) {
                k.c("WearableUtil", "onMessageReceived info %s", b.a(bArr));
            } else if (WearPath.TicPay.SYNC_APPLET_INFO.equals(str)) {
                k.a("WearableUtil", "sync applet info to wear: ");
                MessageProxyClient.getInstance().sendMessage(WearPath.TicPay.SYNC_APPLET_INFO, "".getBytes(Charset.forName("UTF-8")));
            } else if (!WearPath.TicPay.SYNC_CARD_IMAGE.equals(str)) {
                if (WearPath.TicPay.BANK_CARD_INFO.equals(str)) {
                    String str2 = new String(bArr);
                    k.a("WearableUtil", "info: " + str2);
                    int length = str2.split(WearPath.TicPay.DIVIDER).length;
                } else if (WearPath.TicPay.HAS_KEYGUARD.equals(str)) {
                    boolean parseBoolean = Boolean.parseBoolean(new String(bArr));
                    k.a("WearableUtil", "hasKeyguard: " + parseBoolean);
                    b1.a.b(this.f33116a).d(new Intent("action.KEYGUARD_CHANGED"));
                } else if (WearPath.TicPay.BIND_CARD.equals(str)) {
                    PaymentCenterActivity.Y(this.f33116a, 0);
                }
            }
        }
    }

    private void m(String str, String str2) {
        b1.a.b(this.f33116a).d(new Intent(str));
        if (str2.equals(this.f33118c)) {
            this.f33118c = null;
            this.f33120e.offer(new byte[0]);
        }
    }

    @Override // qd.d
    public void a() {
        MessageProxyClient.getInstance().sendMessage(WearPath.TicPay.EXIT_TICPAY_PAGE, new byte[]{1});
    }

    @Override // qd.d
    public void b() {
        MessageProxyClient.getInstance().sendMessage(WearPath.TicPay.ENTER_TICPAY_PAGE, new byte[]{1});
    }

    @Override // qd.d
    public /* synthetic */ void c(String str) {
        c.b(this, str);
    }

    /* JADX WARN: Finally extract failed */
    @Override // qd.d
    public byte[] d(String str, byte[] bArr) {
        k.c("WearableUtil", "sendMessageAndWaitForResponse path %s , data %s", str, b.a(bArr));
        long j10 = WearPath.TicPay.APDUS.equals(str) ? 120L : 60L;
        try {
            this.f33119d.tryAcquire(j10, f33113g);
        } catch (InterruptedException e10) {
            k.e("WearableUtil", "InterruptedException when tryAcquire.", e10);
        }
        String j11 = j();
        this.f33118c = str + "/" + j11;
        this.f33120e.clear();
        try {
            k.a("WearableUtil", "sendMessageAndWaitForResponse, send message " + this.f33118c);
            MessageProxyClient.getInstance().sendMessage(this.f33118c, bArr);
            k.a("WearableUtil", "sendMessageAndWaitForResponse, send message success ");
            try {
                byte[] poll = this.f33120e.poll(j10, f33113g);
                k.a("WearableUtil", "sendMessageAndWaitForResponse, finally release semaphore ");
                this.f33119d.release();
                return poll;
            } catch (InterruptedException e11) {
                e11.printStackTrace();
                k.e("WearableUtil", "sendMessageAndWaitForResponse, get response error ", e11);
                k.a("WearableUtil", "sendMessageAndWaitForResponse, finally release semaphore ");
                this.f33119d.release();
                return null;
            }
        } catch (Throwable th2) {
            k.a("WearableUtil", "sendMessageAndWaitForResponse, finally release semaphore ");
            this.f33119d.release();
            throw th2;
        }
    }

    @Override // qd.d
    public boolean e() {
        return true;
    }

    @Override // qd.d
    public boolean f() {
        return false;
    }

    @Override // qd.d
    public void g(String str, byte[] bArr) {
        MessageProxyClient.getInstance().sendMessage(str, bArr);
    }

    @Override // qd.d
    public String h() {
        return this.f33121f;
    }

    @Override // qd.d
    public boolean i() {
        return true;
    }

    @Override // qd.d
    public boolean isConnected() {
        try {
            return MessageProxyClient.getInstance().hasConnectedNodes();
        } catch (MessageProxyException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public void n() {
        MessageProxyClient.getInstance().sendMessage(WearPath.TicPay.CLOSE_SE, new byte[]{1});
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyListener
    public void onConnectedNodesChanged(List<NodeInfo> list) {
        k.c("WearableUtil", "onConnectedNodesChanged: %s", list);
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyListener
    public void onMessageReceived(MessageInfo messageInfo) {
        String path = messageInfo.getPath();
        if (!path.startsWith(WearPath.TicPay.PREFIX)) {
            k.a("WearableUtil", "aw path is not start with /ticpay, ignore.");
            return;
        }
        k.c("WearableUtil", "onMessageReceived:aw  %s", messageInfo);
        l(path, messageInfo.getPayload());
    }
}
