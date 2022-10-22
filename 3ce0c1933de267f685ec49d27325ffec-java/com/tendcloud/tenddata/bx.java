package com.tendcloud.tenddata;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.tendcloud.tenddata.ah;
import com.tendcloud.tenddata.bh;
import com.tendcloud.tenddata.l;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
/* compiled from: td */
/* loaded from: classes2.dex */
public class bx {

    /* renamed from: a  reason: collision with root package name */
    private static String f22763a = "utf-8";

    /* renamed from: c  reason: collision with root package name */
    private static final int f22765c = 5;

    /* renamed from: d  reason: collision with root package name */
    private static final int f22766d = 30000;

    /* renamed from: g  reason: collision with root package name */
    private static final boolean f22767g = true;

    /* renamed from: h  reason: collision with root package name */
    private static final int f22768h = 65536;

    /* renamed from: j  reason: collision with root package name */
    private static HandlerThread f22770j;

    /* renamed from: e  reason: collision with root package name */
    private long f22771e = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f22772f = true;

    /* renamed from: k  reason: collision with root package name */
    private Handler f22773k;

    /* renamed from: b  reason: collision with root package name */
    private static final CRC32 f22764b = new CRC32();

    /* renamed from: i  reason: collision with root package name */
    private static volatile bx f22769i = null;

    static {
        try {
            v.a().register(a());
        } catch (Throwable unused) {
        }
    }

    private bx() {
        this.f22773k = null;
        HandlerThread handlerThread = new HandlerThread("ModuleDataForward", 10);
        f22770j = handlerThread;
        handlerThread.start();
        this.f22773k = new Handler(f22770j.getLooper()) { // from class: com.tendcloud.tenddata.bx.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                try {
                    Object obj = message.obj;
                    if (obj != null && (obj instanceof a)) {
                        bx.this.a((a) obj);
                    }
                    bx.this.b();
                } catch (Throwable th2) {
                    bf.postSDKError(th2);
                }
            }
        };
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0054 A[Catch: all -> 0x0065, LOOP:0: B:19:0x004e->B:21:0x0054, LOOP_END, TRY_LEAVE, TryCatch #0 {all -> 0x0065, blocks: (B:4:0x0009, B:6:0x001c, B:8:0x0020, B:9:0x0027, B:10:0x0029, B:11:0x002c, B:13:0x0031, B:14:0x003d, B:18:0x0046, B:19:0x004e, B:21:0x0054), top: B:25:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b() {
        int i10;
        Iterator<a> it;
        int i11;
        int nextInt;
        if (!this.f22773k.hasMessages(5)) {
            try {
                SecureRandom b10 = u.b();
                int[] a10 = ab.a();
                if (m.i(ab.f22568h)) {
                    if (!this.f22772f) {
                        i11 = a10[1] * 1;
                        nextInt = b10.nextInt(f22766d);
                        i10 = i11 + nextInt;
                        if (i10 > 1800000) {
                            i10 = 1800000;
                        }
                        it = a.getFeaturesList().iterator();
                        while (it.hasNext()) {
                            Handler handler = this.f22773k;
                            handler.sendMessageDelayed(Message.obtain(handler, 5, it.next()), i10);
                        }
                        return;
                    }
                    i10 = a10[1];
                    if (i10 > 1800000) {
                    }
                    it = a.getFeaturesList().iterator();
                    while (it.hasNext()) {
                    }
                    return;
                } else if (!this.f22772f) {
                    i11 = a10[0] * 1;
                    nextInt = b10.nextInt(60000) - f22766d;
                    i10 = i11 + nextInt;
                    if (i10 > 1800000) {
                    }
                    it = a.getFeaturesList().iterator();
                    while (it.hasNext()) {
                    }
                    return;
                } else {
                    i10 = a10[0];
                    if (i10 > 1800000) {
                    }
                    it = a.getFeaturesList().iterator();
                    while (it.hasNext()) {
                    }
                    return;
                }
            } catch (Throwable th2) {
                bf.postSDKError(th2);
            }
            bf.postSDKError(th2);
        }
    }

    public final void onTDEBEventForwardRequest(bh bhVar) {
        if (bhVar != null && ab.f22568h != null) {
            if (bhVar.f22730b.equals(bh.a.IMMEDIATELY)) {
                if (this.f22773k.hasMessages(5, bhVar.f22729a)) {
                    this.f22773k.removeMessages(5);
                }
                Message.obtain(this.f22773k, 5, bhVar.f22729a).sendToTarget();
            } else if (bhVar.f22730b.equals(bh.a.HIGH)) {
                if (this.f22773k.hasMessages(5)) {
                    this.f22773k.removeMessages(5);
                }
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.f22771e;
                long j10 = ab.Y;
                long abs = Math.abs(elapsedRealtime - ab.Y);
                if (abs <= ab.Y) {
                    j10 = abs;
                }
                this.f22773k.sendMessageDelayed(Message.obtain(this.f22773k, 5, bhVar.f22729a), j10);
            }
        }
    }

    private void a(String str, a aVar, boolean z10) {
        String str2 = "[" + aVar.name() + "] " + str;
        int index = aVar.index();
        if (index != 0 && index != 1 && index != 3 && index != 99 && index != 7 && index != 8) {
            g.iForInternal(str2);
        } else if (z10) {
            g.iForDeveloper(str2);
        } else {
            g.dForInternal(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        boolean z10;
        Throwable th2;
        TreeSet<bz> a10;
        ak b10;
        if (m.b(ab.f22568h) && aVar.needToSendData()) {
            try {
                z10 = l.a(l.b.getFeatureLockFileName(aVar.index()));
            } catch (Throwable th3) {
                th2 = th3;
                z10 = false;
            }
            if (z10) {
                try {
                    a10 = by.a().a(aVar);
                } catch (Throwable th4) {
                    th2 = th4;
                    try {
                        bf.postSDKError(th2);
                        if (!z10) {
                            return;
                        }
                        l.releaseFileLock(l.b.getFeatureLockFileName(aVar.index()));
                        return;
                    } finally {
                        if (z10) {
                            l.releaseFileLock(l.b.getFeatureLockFileName(aVar.index()));
                        }
                    }
                }
                if (a10 != null && a10.size() > 0) {
                    a("New local data found!", aVar, false);
                    byte[] a11 = a(a10, u.f(a(a10)));
                    ai aiVar = new ai();
                    if (!aVar.name().equals("PUSH")) {
                        a11 = p.a(a11);
                        aiVar.a("decrypt-version", ab.N);
                    }
                    CRC32 crc32 = f22764b;
                    crc32.reset();
                    crc32.update(a11);
                    if (a11 != null && a11.length > 0) {
                        a("Submit local data to collector server ...", aVar, true);
                    }
                    StringBuilder sb2 = new StringBuilder(aVar.getUrl());
                    if (aVar.name().equals("TRACKING")) {
                        sb2.append("/" + Long.toHexString(crc32.getValue()));
                        sb2.append("/1");
                    } else {
                        sb2.append("/" + Long.toHexString(crc32.getValue()));
                    }
                    if (ae.b(ae.a().url(sb2.toString()).body(new ah(ah.a.EMPTY, a11)).method(aj.POST).cert(aVar.getCert()).header(aiVar).host(aVar.getHost()).ip(aVar.getIP()).build()).b() == 200) {
                        this.f22771e = SystemClock.elapsedRealtime();
                        this.f22772f = true;
                        by.a().sendMessageSuccess(aVar);
                        a("Data submitted successfully!", aVar, true);
                        ab.V.set(0);
                    } else {
                        ab.V.incrementAndGet();
                        by.a().sendMessageFaild(aVar);
                        this.f22772f = false;
                        a("Failed to submit data! Response code " + b10.b(), aVar, true);
                    }
                    if (z10) {
                        l.releaseFileLock(l.b.getFeatureLockFileName(aVar.index()));
                        return;
                    }
                    return;
                }
                a("No new data found!", aVar, false);
                if (z10) {
                    l.releaseFileLock(l.b.getFeatureLockFileName(aVar.index()));
                }
            }
        }
    }

    private static String a(TreeSet<bz> treeSet) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        Iterator<bz> it = treeSet.iterator();
        while (it.hasNext()) {
            bz next = it.next();
            if (next.c() != null && next.c().length > 0) {
                sb2.append(new String(next.c()));
                sb2.append(",");
            }
        }
        sb2.deleteCharAt(sb2.length() - 1);
        sb2.append("]");
        return sb2.toString();
    }

    private static byte[] a(TreeSet<bz> treeSet, byte[] bArr) {
        int size;
        try {
            if (bArr.length < 65536 || (size = treeSet.size()) == 1) {
                return bArr;
            }
            for (int i10 = 0; i10 < size / 2; i10++) {
                treeSet.pollLast();
            }
            return a(treeSet, u.f(a(treeSet)));
        } catch (Throwable unused) {
            return bArr;
        }
    }

    public static byte[] a(byte[] bArr) {
        BufferedInputStream bufferedInputStream;
        byte[] bArr2 = new byte[2048];
        try {
            bufferedInputStream = new BufferedInputStream(new InflaterInputStream(new ByteArrayInputStream(bArr), new Inflater(false)));
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = bufferedInputStream.read(bArr2);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } else {
                        byteArrayOutputStream.close();
                        bufferedInputStream.close();
                        return byteArrayOutputStream.toByteArray();
                    }
                }
            } catch (Exception unused) {
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                }
                return null;
            }
        } catch (Exception unused2) {
            bufferedInputStream = null;
        }
    }

    public static bx a() {
        if (f22769i == null) {
            synchronized (bx.class) {
                if (f22769i == null) {
                    f22769i = new bx();
                }
            }
        }
        return f22769i;
    }
}
