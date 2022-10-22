package com.mobvoi.companion.common.msgproxy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.d;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.msgproxy.MessageInfo;
import com.mobvoi.wear.msgproxy.MessageProxyClient;
import com.mobvoi.wear.msgproxy.MessageProxyListener;
import com.mobvoi.wear.msgproxy.NodeInfo;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import qo.l;
/* compiled from: MessageDebugActivity.kt */
/* loaded from: classes2.dex */
public final class MessageDebugActivity extends d implements com.mobvoi.android.common.ipc.a, MessageProxyListener {

    /* renamed from: a  reason: collision with root package name */
    private final io.d f16663a = com.mobvoi.android.common.ui.viewbinding.a.a(this, b.INSTANCE);

    /* renamed from: b  reason: collision with root package name */
    private boolean f16664b;

    /* compiled from: MessageDebugActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: MessageDebugActivity.kt */
    /* loaded from: classes2.dex */
    /* synthetic */ class b extends FunctionReferenceImpl implements l<LayoutInflater, mc.a> {
        public static final b INSTANCE = new b();

        b() {
            super(1, mc.a.class, "inflate", "inflate(Landroid/view/LayoutInflater;)Lcom/mobvoi/companion/common/databinding/ActivityMessageDebugBinding;", 0);
        }

        /* renamed from: g */
        public final mc.a invoke(LayoutInflater p02) {
            i.f(p02, "p0");
            return mc.a.d(p02);
        }
    }

    static {
        new a(null);
    }

    private final mc.a K() {
        return (mc.a) this.f16663a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(MessageDebugActivity this$0, View view) {
        i.f(this$0, "this$0");
        this$0.S("/debug/demo1/foo/msg1", "this is a message content1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(MessageDebugActivity this$0, View view) {
        i.f(this$0, "this$0");
        this$0.S("/debug/demo1/single1", "this is a message content2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(MessageDebugActivity this$0, View view) {
        i.f(this$0, "this$0");
        this$0.S("/debug/demo2/bar/msg1", "this is a message content1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(MessageDebugActivity this$0, View view) {
        i.f(this$0, "this$0");
        this$0.S("/debug/demo2/single2", "this is a message content2");
    }

    private final void Q() {
        K().f30650b.setEnabled(this.f16664b);
        K().f30651c.setEnabled(this.f16664b);
        K().f30652d.setEnabled(this.f16664b);
        K().f30653e.setEnabled(this.f16664b);
    }

    private final void S(String str, String str2) {
        MessageProxyClient messageProxyClient = MessageProxyClient.getInstance();
        Charset charset = kotlin.text.d.f30092a;
        Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = str2.getBytes(charset);
        i.e(bytes, "(this as java.lang.String).getBytes(charset)");
        messageProxyClient.sendMessage(str, bytes);
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyListener
    public void onConnectedNodesChanged(List<? extends NodeInfo> nodes) {
        i.f(nodes, "nodes");
        k.i("MessageDebugActivity", "onConnectedNodesChanged: %s", nodes);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(K().a());
        MessageProxyClient.getInstance().addConnectListener(this);
        MessageProxyClient.getInstance().addListener(this);
        K().f30650b.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.common.msgproxy.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageDebugActivity.L(MessageDebugActivity.this, view);
            }
        });
        K().f30651c.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.common.msgproxy.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageDebugActivity.M(MessageDebugActivity.this, view);
            }
        });
        K().f30652d.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.common.msgproxy.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageDebugActivity.N(MessageDebugActivity.this, view);
            }
        });
        K().f30653e.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.common.msgproxy.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageDebugActivity.O(MessageDebugActivity.this, view);
            }
        });
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyListener
    public void onMessageReceived(MessageInfo message) {
        i.f(message, "message");
        byte[] payload = message.getPayload();
        i.e(payload, "message.payload");
        k.i("MessageDebugActivity", "onMessageReceived, path: %s, data: %s", message.getPath(), new String(payload, kotlin.text.d.f30092a));
    }

    @Override // com.mobvoi.android.common.ipc.a
    public void onStateChanged(int i10) {
        boolean z10 = true;
        k.i("MessageDebugActivity", "MessageProxyService connect state: %d", Integer.valueOf(i10));
        if (i10 != 3) {
            z10 = false;
        }
        this.f16664b = z10;
        Q();
    }
}
