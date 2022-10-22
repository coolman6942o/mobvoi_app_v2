package com.mobvoi.mcuwatch.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Keep;
import b1.a;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.f;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.apollo.client.c0;
import com.mobvoi.apollo.client.q;
import com.mobvoi.wear.common.base.WearPath;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import qd.c;
import qd.d;
/* loaded from: classes2.dex */
public class ApolloApduExecutor extends c0 implements d {

    /* renamed from: j  reason: collision with root package name */
    private static final TimeUnit f20258j = TimeUnit.SECONDS;

    /* renamed from: k  reason: collision with root package name */
    private static final Object f20259k = new Object();

    /* renamed from: c  reason: collision with root package name */
    private String f20260c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f20261d;

    /* renamed from: e  reason: collision with root package name */
    private int f20262e;

    /* renamed from: f  reason: collision with root package name */
    private volatile String f20263f;

    /* renamed from: g  reason: collision with root package name */
    private final Semaphore f20264g;

    /* renamed from: h  reason: collision with root package name */
    private final BlockingQueue<byte[]> f20265h;

    /* renamed from: i  reason: collision with root package name */
    private String f20266i;

    @Keep
    public ApolloApduExecutor() {
        this(b.e());
    }

    private String p() {
        String num;
        synchronized (f20259k) {
            int i10 = (this.f20262e + 1) % 46656;
            this.f20262e = i10;
            num = Integer.toString(i10, 36);
        }
        return num;
    }

    private void q(String str, byte[] bArr) {
        if (Arrays.equals(bArr, d.f32943h0)) {
            k.a("ApolloApduExecutor", "nfc disabled");
            r("action.NFC_DISABLED", str);
        } else if (Arrays.equals(bArr, d.f32944i0)) {
            k.a("ApolloApduExecutor", "se not init.");
            r("action.SE_NOT_INIT", str);
        } else {
            k.c("ApolloApduExecutor", "onMessageReceived path %s, mWaitForResultPath %s", str, this.f20263f);
            if (str.equals(this.f20263f)) {
                this.f20263f = null;
                k.c("ApolloApduExecutor", "onMessageReceived data %s", f.b(bArr));
                k.c("ApolloApduExecutor", "onMessageReceived put data to queue : %s", Boolean.valueOf(this.f20265h.offer(bArr)));
            }
            if (1282 == j().intValue()) {
                String b10 = f.b(bArr);
                k.c("ApolloApduExecutor", "onMessageReceived cplc %s", b10);
                if (!TextUtils.isEmpty(b10)) {
                    String substring = b10.substring(6, b10.length() - 4);
                    k.c("ApolloApduExecutor", "onMessageReceived real cplc %s", substring);
                    this.f20260c = substring;
                }
            }
        }
    }

    private void r(String str, String str2) {
        a.b(this.f20261d).d(new Intent(str));
        if (str2.equals(this.f20263f)) {
            this.f20263f = null;
            this.f20265h.offer(new byte[0]);
        }
    }

    @Override // qd.d
    public void a() {
        q.f15504a.K(1298, new byte[]{1}, null);
    }

    @Override // qd.d
    public void b() {
        q.f15504a.K(1297, new byte[]{1}, null);
    }

    @Override // qd.d
    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            ByteBuffer order = ByteBuffer.allocate(bytes.length + 21).order(ByteOrder.LITTLE_ENDIAN);
            order.put((byte) 1).put((byte) 0).put((byte) 1).putShort((short) bytes.length).put(bytes).put((byte) 2).putShort((short) 0).put((byte) 3).putShort((short) 1).put((byte) 3).put((byte) 4).putShort((short) 0).put((byte) 5).putShort((short) 0).put((byte) 6).putShort((short) 0);
            q.f15504a.K(1285, order.array(), null);
        }
    }

    @Override // qd.d
    public byte[] d(String str, byte[] bArr) {
        int parseInt;
        long j10 = WearPath.TicPay.APDUS.equals(str) ? 120L : 60L;
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1606453733:
                if (str.equals(WearPath.TicPay.SET_DEFAULT_APP)) {
                    c10 = 0;
                    break;
                }
                break;
            case -1252644881:
                if (str.equals(WearPath.TicPay.NFC_BUS_PROPERTY)) {
                    c10 = 1;
                    break;
                }
                break;
            case -1194114810:
                if (str.equals(WearPath.TicPay.APDU)) {
                    c10 = 2;
                    break;
                }
                break;
            case -1194054998:
                if (str.equals(WearPath.TicPay.CPLC)) {
                    c10 = 3;
                    break;
                }
                break;
            case -1193878348:
                if (str.equals(WearPath.TicPay.DEVICE_INFO)) {
                    c10 = 4;
                    break;
                }
                break;
            case -731255366:
                if (str.equals(WearPath.TicPay.DEFAULT_BUS_AID)) {
                    c10 = 5;
                    break;
                }
                break;
            case 1637146669:
                if (str.equals(WearPath.TicPay.APDUS)) {
                    c10 = 6;
                    break;
                }
                break;
            case 1777761039:
                if (str.equals(WearPath.TicPay.GET_DEFAULT_APP)) {
                    c10 = 7;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                parseInt = 1283;
                break;
            case 1:
                return WearPath.TicPay.BEIJING.getBytes();
            case 2:
                parseInt = 1281;
                break;
            case 3:
                parseInt = 1282;
                break;
            case 4:
                parseInt = 1280;
                break;
            case 5:
                return new byte[0];
            case 6:
                parseInt = 1296;
                break;
            case 7:
                parseInt = 1284;
                break;
            default:
                try {
                    parseInt = Integer.parseInt(str);
                    break;
                } catch (NumberFormatException e10) {
                    e10.printStackTrace();
                    return null;
                }
        }
        k.c("ApolloApduExecutor", "sendMessageAndWaitForResponse path %d , data %s", Integer.valueOf(parseInt), f.b(bArr));
        try {
            this.f20264g.acquire();
        } catch (InterruptedException e11) {
            k.e("ApolloApduExecutor", "InterruptedException when tryAcquire.", e11);
        }
        if (1286 == parseInt) {
            n(1287);
        } else {
            n(Integer.valueOf(parseInt));
        }
        this.f20263f = parseInt + "/" + p();
        this.f20266i = this.f20263f;
        this.f20265h.clear();
        try {
            k.a("ApolloApduExecutor", "sendMessageAndWaitForResponse, send message " + this.f20263f);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            TimeUnit timeUnit2 = f20258j;
            o(timeUnit.convert(j10, timeUnit2));
            q.f15504a.K(parseInt, bArr, this);
            k.a("ApolloApduExecutor", "sendMessageAndWaitForResponse, send message success ");
            return this.f20265h.poll(j10, timeUnit2);
        } catch (InterruptedException e12) {
            e12.printStackTrace();
            k.e("ApolloApduExecutor", "sendMessageAndWaitForResponse, get response error ", e12);
            return null;
        } finally {
            k.a("ApolloApduExecutor", "sendMessageAndWaitForResponse, finally release semaphore ");
            this.f20264g.release();
        }
    }

    @Override // qd.d
    public boolean e() {
        return false;
    }

    @Override // qd.d
    public /* synthetic */ boolean f() {
        return c.a(this);
    }

    @Override // qd.d
    public void g(String str, byte[] bArr) {
        if (WearPath.TicPay.CLOSE_SE.equals(str)) {
            str = String.valueOf(1289);
        }
        q.f15504a.K(Integer.parseInt(str), bArr, null);
    }

    @Override // qd.d
    public String h() {
        return this.f20260c;
    }

    @Override // qd.d
    public boolean i() {
        return true;
    }

    @Override // qd.d
    public boolean isConnected() {
        return ci.a.b().e();
    }

    @Override // com.mobvoi.apollo.client.c0
    public void l(int i10) {
        super.l(i10);
        this.f20265h.offer(new byte[0]);
        k.f("ApolloApduExecutor", "%s onFail() stateCode:  =  %d", this.f20266i, Integer.valueOf(i10));
    }

    @Override // com.mobvoi.apollo.client.c0
    public void m(byte[] bArr) {
        k.c("ApolloApduExecutor", "%s onResponse() called with:  =  %s", this.f20266i, f.b(bArr));
        q(this.f20266i, bArr);
    }

    private ApolloApduExecutor(Context context) {
        this.f20261d = context;
        this.f20262e = -1;
        this.f20264g = new Semaphore(1);
        this.f20265h = new LinkedBlockingDeque(1);
    }
}
