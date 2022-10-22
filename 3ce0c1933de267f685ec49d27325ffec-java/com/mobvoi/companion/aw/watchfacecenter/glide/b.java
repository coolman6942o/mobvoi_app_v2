package com.mobvoi.companion.aw.watchfacecenter.glide;

import com.google.gson.JsonParseException;
import com.google.gson.e;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.msgproxy.MessageInfo;
import com.mobvoi.wear.msgproxy.MessageProxyClient;
import com.mobvoi.wear.msgproxy.MessageProxyListener;
import com.mobvoi.wear.msgproxy.NodeInfo;
import io.m;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Pair;
import kotlin.jvm.internal.i;
import kotlin.text.d;
/* compiled from: BluetoothWfImageDispatcher.kt */
/* loaded from: classes2.dex */
public final class b implements MessageProxyListener {

    /* renamed from: b  reason: collision with root package name */
    private static final int f16437b;

    /* renamed from: c  reason: collision with root package name */
    private static final int f16438c;

    /* renamed from: d  reason: collision with root package name */
    private static final ExecutorService f16439d;

    /* renamed from: a  reason: collision with root package name */
    public static final b f16436a = new b();

    /* renamed from: e  reason: collision with root package name */
    private static final HashMap<Pair<String, Long>, g> f16440e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private static final HashMap<String, List<Pair<String, Long>>> f16441f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private static final Object f16442g = new Object();

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f16437b = availableProcessors;
        int max = Math.max(2, Math.min(availableProcessors - 1, 4));
        f16438c = max;
        f16439d = Executors.newFixedThreadPool(max);
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(MessageInfo message) {
        i.f(message, "$message");
        b bVar = f16436a;
        byte[] payload = message.getPayload();
        i.e(payload, "message.payload");
        cc.b e10 = bVar.e(new String(payload, d.f30092a));
        if (e10 != null) {
            String a10 = e10.a();
            byte[] b10 = e10.b();
            if (!(a10 == null || b10 == null)) {
                synchronized (f16442g) {
                    List<Pair<String, Long>> list = f16441f.get(a10);
                    if (list != null) {
                        if (!list.isEmpty()) {
                            ByteBuffer byteBuffer = ByteBuffer.wrap(b10);
                            for (Pair<String, Long> pair : list) {
                                HashMap<Pair<String, Long>, g> hashMap = f16440e;
                                g gVar = hashMap.get(pair);
                                if (gVar != null) {
                                    i.e(byteBuffer, "byteBuffer");
                                    gVar.a(byteBuffer);
                                }
                                hashMap.remove(pair);
                            }
                        }
                        f16441f.remove(a10);
                    }
                }
            }
        }
    }

    private final cc.b e(String str) {
        try {
            return (cc.b) new e().j(str, cc.b.class);
        } catch (JsonParseException e10) {
            k.d("BluetoothWfImageDispatcher", e10.getMessage());
            return null;
        }
    }

    public final void b() {
        MessageProxyClient.getInstance().addListener(this);
    }

    public final void c(Pair<String, Long> key, g listener) {
        i.f(key, "key");
        i.f(listener, "listener");
        synchronized (f16442g) {
            String first = key.getFirst();
            f16440e.put(key, listener);
            HashMap<String, List<Pair<String, Long>>> hashMap = f16441f;
            List<Pair<String, Long>> list = hashMap.get(first);
            if (list == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(key);
                hashMap.put(first, arrayList);
            } else {
                list.add(key);
            }
            MessageProxyClient messageProxyClient = MessageProxyClient.getInstance();
            Charset charset = d.f30092a;
            if (first != null) {
                byte[] bytes = first.getBytes(charset);
                i.e(bytes, "(this as java.lang.String).getBytes(charset)");
                messageProxyClient.sendMessage(WearPath.WatchfaceMarket.GET_IMAGE, bytes);
                m mVar = m.f28349a;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }
    }

    public final void f(Pair<String, Long> key) {
        i.f(key, "key");
        synchronized (f16442g) {
            f16440e.remove(key);
            List<Pair<String, Long>> list = f16441f.get(key.getFirst());
            if (list != null) {
                list.remove(key);
            }
        }
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyListener
    public void onConnectedNodesChanged(List<NodeInfo> nodes) {
        i.f(nodes, "nodes");
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyListener
    public void onMessageReceived(final MessageInfo message) {
        i.f(message, "message");
        if (i.b(message.getPath(), WearPath.WatchfaceMarket.GET_IMAGE)) {
            f16439d.execute(new Runnable() { // from class: com.mobvoi.companion.aw.watchfacecenter.glide.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.d(MessageInfo.this);
                }
            });
        }
    }
}
