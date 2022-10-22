package com.mobvoi.companion.lpa;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.msgproxy.MessageInfo;
import com.mobvoi.wear.msgproxy.MessageProxyClient;
import com.mobvoi.wear.msgproxy.MessageProxyListener;
import com.mobvoi.wear.msgproxy.NodeInfo;
import io.d;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.m;
import kotlin.text.u;
import qo.l;
/* compiled from: JupiterEsimActivity.kt */
/* loaded from: classes2.dex */
public final class JupiterEsimActivity extends k implements MessageProxyListener {

    /* renamed from: d  reason: collision with root package name */
    private final d f17169d = com.mobvoi.android.common.ui.viewbinding.a.a(this, b.INSTANCE);

    /* renamed from: e  reason: collision with root package name */
    public fe.a f17170e;

    /* compiled from: JupiterEsimActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: JupiterEsimActivity.kt */
    /* loaded from: classes2.dex */
    /* synthetic */ class b extends FunctionReferenceImpl implements l<LayoutInflater, oc.b> {
        public static final b INSTANCE = new b();

        b() {
            super(1, oc.b.class, "inflate", "inflate(Landroid/view/LayoutInflater;)Lcom/mobvoi/companion/databinding/ActivityEsimTestBinding;", 0);
        }

        /* renamed from: g */
        public final oc.b invoke(LayoutInflater p02) {
            i.f(p02, "p0");
            return oc.b.d(p02);
        }
    }

    static {
        new a(null);
    }

    private final oc.b O() {
        return (oc.b) this.f17169d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(JupiterEsimActivity this$0, View view) {
        i.f(this$0, "this$0");
        this$0.X();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(JupiterEsimActivity this$0, View view) {
        i.f(this$0, "this$0");
        this$0.U("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(JupiterEsimActivity this$0, View view) {
        i.f(this$0, "this$0");
        this$0.W("");
    }

    private final void U(String str) {
        String str2 = ((Object) O().f31499d.getText()) + "###" + ((Object) O().f31498c.getText());
        MessageProxyClient messageProxyClient = MessageProxyClient.getInstance();
        Charset charset = kotlin.text.d.f30092a;
        Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = str2.getBytes(charset);
        i.e(bytes, "(this as java.lang.String).getBytes(charset)");
        messageProxyClient.sendMessage(WearPath.Lpa.START_DOWNLOAD_PATH, bytes);
    }

    private final void V(String str) {
        MessageProxyClient.getInstance().sendMessage(WearPath.Lpa.START_ACTIVITY_PATH);
    }

    private final void W(String str) {
        MessageProxyClient.getInstance().sendMessage(WearPath.Lpa.GET_IEMI_AND_EID_PATH);
    }

    private final void X() {
        N().i(fe.a.f26404l);
    }

    private final void initView() {
        O().f31502g.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.lpa.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JupiterEsimActivity.Q(JupiterEsimActivity.this, view);
            }
        });
        O().f31500e.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.lpa.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JupiterEsimActivity.S(JupiterEsimActivity.this, view);
            }
        });
        O().f31497b.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.lpa.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JupiterEsimActivity.T(JupiterEsimActivity.this, view);
            }
        });
    }

    public final fe.a N() {
        fe.a aVar = this.f17170e;
        if (aVar != null) {
            return aVar;
        }
        i.u("mIntegrator");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        fe.b l10 = fe.a.l(i10, i11, intent);
        if (l10 != null) {
            String a10 = l10.a();
            O().f31499d.setText(a10);
            k.f("JupiterEsimActivity", "onActivityResult: %s", a10);
        }
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyListener
    public void onConnectedNodesChanged(List<? extends NodeInfo> nodes) {
        i.f(nodes, "nodes");
        k.c("JupiterEsimActivity", "onConnectedNodesChanged, %s", nodes.toString());
    }

    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(O().a());
        MessageProxyClient.getInstance().addListener(this);
        initView();
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyListener
    public void onMessageReceived(MessageInfo message) {
        List o02;
        String f10;
        i.f(message, "message");
        k.c("JupiterEsimActivity", "onMessageReceived() A message from watch was received:%s %s", message.getNodeId(), message.getPath());
        if (i.b(WearPath.Lpa.IEMI_AND_EID_RESULT_PATH, message.getPath())) {
            byte[] payload = message.getPayload();
            i.e(payload, "message.payload");
            o02 = u.o0(new String(payload, kotlin.text.d.f30092a), new String[]{"###"}, false, 0, 6, null);
            Object[] array = o02.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            String[] strArr = (String[]) array;
            k.c("JupiterEsimActivity", "imei = %s, eid = %s", strArr[0], strArr[1]);
            TextView textView = O().f31501f;
            f10 = m.f("\n                IMEI==" + strArr[0] + "\n                EID==" + strArr[1] + "\n                ");
            textView.setText(f10);
        }
    }

    public final void onStartWearableActivityClick(View view) {
        V("");
    }
}
