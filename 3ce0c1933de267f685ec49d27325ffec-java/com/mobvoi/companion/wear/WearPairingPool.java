package com.mobvoi.companion.wear;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.q;
import com.mobvoi.android.common.utils.r;
import com.mobvoi.companion.TicAppConstants;
import com.mobvoi.wear.info.WearInfo;
import com.mobvoi.wear.msgproxy.MessageInfo;
import com.mobvoi.wear.msgproxy.MessageProxyClient;
import com.mobvoi.wear.msgproxy.MessageProxyException;
import com.mobvoi.wear.msgproxy.MessageProxyListener;
import com.mobvoi.wear.msgproxy.NodeInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class WearPairingPool implements MessageProxyListener {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: i  reason: collision with root package name */
    private static volatile WearPairingPool f17810i;

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, WearNode> f17811a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f17812b;

    /* renamed from: c  reason: collision with root package name */
    private final MessageProxyClient f17813c;

    /* renamed from: d  reason: collision with root package name */
    private final com.mobvoi.companion.wear.a f17814d;

    /* renamed from: e  reason: collision with root package name */
    private String f17815e;

    /* renamed from: f  reason: collision with root package name */
    private final Handler f17816f;

    /* renamed from: g  reason: collision with root package name */
    private Runnable f17817g;

    /* renamed from: h  reason: collision with root package name */
    private final List<f> f17818h;

    /* loaded from: classes2.dex */
    public enum ConnectionState {
        Disconnected,
        ConnectedCloud,
        ConnectedNearby
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f17819a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f17820b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f17821c;

        a(f fVar, List list, String str) {
            this.f17819a = fVar;
            this.f17820b = list;
            this.f17821c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (WearPairingPool.this.f17818h.contains(this.f17819a)) {
                this.f17819a.l(this.f17820b, this.f17821c);
            }
        }
    }

    /* loaded from: classes2.dex */
    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f17823a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ WearInfo f17824b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f17825c;

        b(String str, WearInfo wearInfo, String str2) {
            this.f17823a = str;
            this.f17824b = wearInfo;
            this.f17825c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            WearPairingPool.this.f17814d.a(this.f17823a, this.f17824b, this.f17825c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f17827a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f17828b;

        c(String str, List list) {
            this.f17827a = str;
            this.f17828b = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.c("WearPairingPool", "Notify nodes changed, current %s, nodes %s", this.f17827a, this.f17828b);
            for (f fVar : WearPairingPool.this.f17818h) {
                fVar.l(this.f17828b, this.f17827a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f17830a;

        d(List list) {
            this.f17830a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            WearPairingPool.this.f17814d.k(this.f17830a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class e implements Comparator<WearNode> {
        private e() {
        }

        /* renamed from: a */
        public int compare(WearNode wearNode, WearNode wearNode2) {
            int compareTo = wearNode.deviceId.compareTo(wearNode2.deviceId);
            return compareTo == 0 ? wearNode.compareTo(wearNode2) : compareTo;
        }

        /* synthetic */ e(a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
        void l(List<WearNode> list, String str);
    }

    private WearPairingPool(Context context) {
        this(context, new Handler(Looper.getMainLooper()), MessageProxyClient.getInstance(), com.mobvoi.companion.wear.a.f());
        j();
    }

    private List<String> e() {
        ArrayList<WearNode> arrayList;
        ArrayList<String> arrayList2 = new ArrayList();
        synchronized (this.f17811a) {
            arrayList = new ArrayList(this.f17811a.values());
        }
        String str = null;
        Collections.sort(arrayList, new e(null));
        for (WearNode wearNode : arrayList) {
            if (!com.mobvoi.android.common.utils.e.f(str) && str.equals(wearNode.deviceId)) {
                k.c("WearPairingPool", "Found %s duplicate, remove it.", wearNode);
                arrayList2.add(wearNode.nodeId);
            }
            str = wearNode.deviceId;
        }
        boolean z10 = false;
        for (String str2 : arrayList2) {
            r(this.f17812b, str2);
            synchronized (this.f17811a) {
                if (this.f17811a.containsKey(str2)) {
                    k.s("WearPairingPool", "Duplicate Node %s is connected, we have multiple connected node with same deviceId!?", str2);
                    this.f17811a.remove(str2);
                }
            }
            z10 = true;
        }
        this.f17816f.post(new d(arrayList2));
        if (z10) {
            n();
        }
        return arrayList2;
    }

    static String f(String str) {
        return "wear_id_" + str;
    }

    public static WearPairingPool i() {
        if (f17810i == null) {
            synchronized (WearPairingPool.class) {
                if (f17810i == null) {
                    f17810i = new WearPairingPool(com.mobvoi.android.common.utils.b.e());
                }
            }
        }
        return f17810i;
    }

    private void k() {
        ArrayList<WearNode> arrayList;
        synchronized (this.f17811a) {
            arrayList = new ArrayList(this.f17811a.values());
        }
        for (WearNode wearNode : arrayList) {
            WearInfo c10 = this.f17814d.c(wearNode.nodeId);
            if (c10 == null) {
                k.s("WearPairingPool", "Can't found wear info for %s", wearNode.nodeId);
            } else {
                w(wearNode.nodeId, c10);
            }
        }
    }

    private boolean m(String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().startsWith("ticwatch");
    }

    private void n() {
        List<WearNode> g10 = g();
        String s10 = s(g10);
        synchronized (this.f17811a) {
            this.f17815e = s10;
        }
        if (!this.f17818h.isEmpty()) {
            this.f17816f.removeCallbacks(this.f17817g);
            c cVar = new c(s10, g10);
            this.f17817g = cVar;
            this.f17816f.post(cVar);
        }
    }

    private String s(List<WearNode> list) {
        synchronized (this.f17811a) {
            if (!this.f17811a.containsKey(this.f17815e)) {
                return list.isEmpty() ? "" : list.get(0).nodeId;
            }
            return this.f17815e;
        }
    }

    private void v(List<NodeInfo> list) {
        synchronized (this.f17811a) {
            for (WearNode wearNode : this.f17811a.values()) {
                wearNode.connectionState = ConnectionState.Disconnected;
            }
            for (NodeInfo nodeInfo : list) {
                String id2 = nodeInfo.getId();
                WearInfo c10 = this.f17814d.c(id2);
                if (nodeInfo.getNodeType() == 2) {
                    k.c("WearPairingPool", "ignore Ticwear node: %s", nodeInfo);
                } else if (!m(nodeInfo.getName())) {
                    k.c("WearPairingPool", "ignore not TicWatch node: %s", nodeInfo);
                } else {
                    WearNode wearNode2 = this.f17811a.get(id2);
                    if (wearNode2 == null) {
                        wearNode2 = new WearNode();
                    }
                    wearNode2.nodeId = id2;
                    if (c10 == null || r.b(c10.btName)) {
                        wearNode2.nodeName = nodeInfo.getName();
                    } else {
                        wearNode2.nodeName = c10.btName;
                    }
                    wearNode2.connectionState = nodeInfo.isNearby() ? ConnectionState.ConnectedNearby : ConnectionState.ConnectedCloud;
                    wearNode2.deviceId = c10 == null ? "" : c10.wearDeviceId;
                    this.f17811a.put(id2, wearNode2);
                }
            }
            ArrayList<String> arrayList = new ArrayList(this.f17811a.size());
            for (WearNode wearNode3 : this.f17811a.values()) {
                if ((wearNode3.connectionState == ConnectionState.Disconnected) && !wearNode3.persisted) {
                    arrayList.add(wearNode3.nodeId);
                }
            }
            for (String str : arrayList) {
                this.f17811a.remove(str);
            }
        }
        n();
    }

    private void w(String str, WearInfo wearInfo) {
        if (wearInfo != null) {
            k.c("WearPairingPool", "Update deviceId of %s to %s", str, wearInfo.wearDeviceId);
            synchronized (this.f17811a) {
                WearNode wearNode = this.f17811a.get(str);
                if (wearNode != null) {
                    wearNode.deviceId = wearInfo.wearDeviceId;
                    if (!r.b(wearInfo.btName) && !r.a(wearNode.nodeName, wearInfo.btName)) {
                        k.c("WearPairingPool", "update nodeName of %s from %s to %s for %s", str, wearNode.nodeName, wearInfo.btName, str);
                        wearNode.nodeName = wearInfo.btName;
                        p(wearNode);
                    }
                }
            }
        }
    }

    public void c(f fVar) {
        this.f17818h.add(fVar);
        this.f17816f.post(new a(fVar, g(), this.f17815e));
    }

    public boolean d(String str) {
        if (str == null) {
            str = "";
        }
        synchronized (this.f17811a) {
            if (this.f17815e.equals(str)) {
                return false;
            }
            if (!this.f17811a.containsKey(str)) {
                return false;
            }
            this.f17815e = str;
            n();
            return true;
        }
    }

    public List<WearNode> g() {
        ArrayList arrayList;
        synchronized (this.f17811a) {
            arrayList = new ArrayList(this.f17811a.values());
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public String h() {
        return this.f17815e;
    }

    void j() {
        Map<String, ?> all = this.f17812b.getSharedPreferences(TicAppConstants.PREF_WEAR_CONNECTION, 0).getAll();
        for (String str : all.keySet()) {
            if (str.startsWith("wear_id_")) {
                WearNode wearNode = (WearNode) new com.google.gson.e().j((String) all.get(str), WearNode.class);
                wearNode.persisted = true;
                if (k.j() && !str.substring(8).equals(wearNode.nodeId)) {
                    throw new IllegalStateException("Preference key " + str + " not match node id " + wearNode.nodeId + "!");
                } else if (!m(wearNode.nodeName)) {
                    k.c("WearPairingPool", "ignore not TicWatch node: %s", wearNode);
                } else {
                    this.f17811a.put(wearNode.nodeId, wearNode);
                }
            }
        }
        this.f17813c.addListener(this);
        try {
            v(this.f17813c.getConnectedNodes());
        } catch (MessageProxyException unused) {
        }
        k();
        e();
    }

    public boolean l() {
        boolean isEmpty;
        synchronized (this.f17811a) {
            isEmpty = this.f17811a.isEmpty();
        }
        return isEmpty;
    }

    public WearNode o(Context context, String str) {
        synchronized (this.f17811a) {
            WearNode wearNode = this.f17811a.get(str);
            if (wearNode == null) {
                return null;
            }
            wearNode.persisted = true;
            WearNode a10 = wearNode.clone();
            n();
            p(a10);
            return a10;
        }
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyListener
    public void onConnectedNodesChanged(List<NodeInfo> list) {
        v(list);
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyListener
    public void onMessageReceived(MessageInfo messageInfo) {
    }

    public void p(WearNode wearNode) {
        String f10 = f(wearNode.nodeId);
        String s10 = new com.google.gson.e().s(wearNode);
        k.c("WearPairingPool", "Persistent node %s: %s", f10, s10);
        q.h(this.f17812b, TicAppConstants.PREF_WEAR_CONNECTION, f10, s10);
    }

    public void q(f fVar) {
        this.f17818h.remove(fVar);
    }

    public WearNode r(Context context, String str) {
        synchronized (this.f17811a) {
            WearNode wearNode = this.f17811a.get(str);
            if (wearNode == null) {
                return null;
            }
            wearNode.persisted = false;
            if (wearNode.connectionState == ConnectionState.Disconnected) {
                this.f17811a.remove(str);
            }
            WearNode a10 = wearNode.clone();
            n();
            String f10 = f(str);
            k.c("WearPairingPool", "Remove persistent node %s", f10);
            context.getSharedPreferences(TicAppConstants.PREF_WEAR_CONNECTION, 0).edit().remove(f10).apply();
            return a10;
        }
    }

    public void t(String str) {
        this.f17815e = str;
    }

    public boolean u(String str, int i10) {
        boolean z10;
        synchronized (this.f17811a) {
            WearNode wearNode = this.f17811a.get(str);
            if (wearNode != null) {
                wearNode.batteryLevel = i10;
                z10 = true;
            } else {
                z10 = false;
            }
        }
        n();
        return z10;
    }

    public void x(String str, WearInfo wearInfo, String str2) {
        k.c("WearPairingPool", "updateWearInfo: nodeId %s, data %s", str, str2);
        w(str, wearInfo);
        if (!e().contains(str)) {
            this.f17816f.post(new b(str, wearInfo, str2));
        }
    }

    WearPairingPool(Context context, Handler handler, MessageProxyClient messageProxyClient, com.mobvoi.companion.wear.a aVar) {
        this.f17811a = new HashMap();
        this.f17815e = "";
        this.f17818h = new ArrayList();
        this.f17812b = context;
        this.f17816f = handler;
        this.f17813c = messageProxyClient;
        this.f17814d = aVar;
    }
}
