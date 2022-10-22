package com.mobvoi.companion.aw.watchfacecenter;

import android.content.Context;
import cc.e;
import com.mobvoi.companion.aw.watchfacecenter.bean.WatchFaceBean;
import com.mobvoi.wear.msgproxy.MessageInfo;
import com.mobvoi.wear.msgproxy.MessageProxyClient;
import com.mobvoi.wear.msgproxy.MessageProxyListener;
import com.mobvoi.wear.msgproxy.NodeInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.i;
import kotlin.text.d;
/* compiled from: WatchFaceViewModel.kt */
/* loaded from: classes2.dex */
public abstract class u implements MessageProxyListener {

    /* renamed from: a  reason: collision with root package name */
    private final Context f16487a;

    /* renamed from: b  reason: collision with root package name */
    private final String f16488b;

    /* compiled from: WatchFaceViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class a extends com.google.gson.reflect.a<List<? extends WatchFaceBean>> {
        a() {
        }
    }

    public u(Context context) {
        i.f(context, "context");
        this.f16487a = context;
        String string = context.getString(s.v_res_0x7f141258);
        i.e(string, "context.getString(R.string.watchface_develop_by_ticwatch)");
        this.f16488b = string;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ArrayList<e> a(String cardTypeName, MessageInfo message, int i10) {
        i.f(cardTypeName, "cardTypeName");
        i.f(message, "message");
        com.google.gson.e eVar = new com.google.gson.e();
        byte[] payload = message.getPayload();
        i.e(payload, "message.payload");
        List<WatchFaceBean> list = (List) eVar.k(new String(payload, d.f30092a), new a().getType());
        i.e(list, "");
        if (!list.isEmpty()) {
            for (WatchFaceBean watchFaceBean : list) {
                if (i10 == 100) {
                    watchFaceBean.z(this.f16488b);
                    watchFaceBean.u(1);
                } else if (i10 == 101) {
                    watchFaceBean.u(2);
                }
            }
        }
        boolean z10 = list.size() > 6;
        boolean isEmpty = list.isEmpty();
        ArrayList<e> arrayList = new ArrayList<>();
        arrayList.add(new e(i10, cardTypeName, z10, list, isEmpty ? 1 : 0, 0, 32, null));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        MessageProxyClient.getInstance().removeListener(this);
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyListener
    public void onConnectedNodesChanged(List<NodeInfo> nodes) {
        i.f(nodes, "nodes");
    }
}
