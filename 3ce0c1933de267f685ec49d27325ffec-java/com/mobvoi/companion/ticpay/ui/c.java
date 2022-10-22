package com.mobvoi.companion.ticpay.ui;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.s;
import com.mobvoi.companion.base.m3.d;
import com.mobvoi.wear.msgproxy.MessageInfo;
import com.mobvoi.wear.msgproxy.MessageProxyClient;
import com.mobvoi.wear.msgproxy.MessageProxyListener;
import com.mobvoi.wear.msgproxy.NodeInfo;
import java.util.List;
import jc.a;
import qd.m;
/* compiled from: PaymentBaseActivity.java */
/* loaded from: classes2.dex */
public abstract class c extends d implements MessageProxyListener, s.a {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f17618a = false;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f17619b = false;

    /* renamed from: c  reason: collision with root package name */
    private s f17620c = new s(this);

    /* renamed from: d  reason: collision with root package name */
    private jc.a f17621d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PaymentBaseActivity.java */
    /* loaded from: classes2.dex */
    public class a implements a.AbstractC0354a {
        a() {
        }

        @Override // jc.a.AbstractC0354a
        public void a() {
            c.this.f17621d.dismiss();
            c.this.setResult(0);
            c.this.finish();
        }

        @Override // jc.a.AbstractC0354a
        public void onCancel() {
            c.this.f17621d.dismiss();
            c.this.setResult(0);
            c.this.finish();
        }
    }

    private NodeInfo J(List<NodeInfo> list) {
        String d10 = com.mobvoi.companion.wear.a.f().d();
        if (!TextUtils.isEmpty(d10)) {
            for (NodeInfo nodeInfo : list) {
                if (nodeInfo.getId().equals(d10)) {
                    return nodeInfo;
                }
            }
            return null;
        } else if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    protected void I() {
        jc.a aVar = this.f17621d;
        if (aVar != null && aVar.isShowing()) {
            this.f17621d.dismiss();
        }
    }

    public void K() {
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L(String str) {
        M(str, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M(String str, boolean z10) {
        if (!isFinishing() && !isDestroyed()) {
            if (this.f17621d == null) {
                jc.a aVar = new jc.a(this);
                this.f17621d = aVar;
                aVar.b(getResources().getString(m.f33043a));
                this.f17621d.setCanceledOnTouchOutside(false);
                this.f17621d.d(new a());
            }
            k.a("PaymentBaseActivity", "show error dialog.");
            this.f17621d.setCancelable(z10);
            this.f17621d.i(str);
            this.f17621d.show();
        }
    }

    public void handleMessage(Message message) {
        if (message.what == 1) {
            if (!this.f17618a) {
                finish();
            } else {
                M(getString(m.f33099u), false);
            }
        }
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyListener
    public void onConnectedNodesChanged(List<NodeInfo> list) {
        k.c("PaymentBaseActivity", "onConnectedNodesChanged: %s", list);
        NodeInfo J = J(list);
        if (J == null || !J.isNearby()) {
            k.a("PaymentBaseActivity", "onPeerDisconnected");
            if (!this.f17619b) {
                this.f17620c.sendEmptyMessageDelayed(1, 5L);
                return;
            }
            return;
        }
        k.a("PaymentBaseActivity", "onPeerConnected");
        this.f17620c.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(m.f33085o);
        MessageProxyClient.getInstance().addListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        this.f17620c.removeCallbacksAndMessages(null);
        I();
        MessageProxyClient.getInstance().removeListener(this);
        super.onDestroy();
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyListener
    public void onMessageReceived(MessageInfo messageInfo) {
    }
}
