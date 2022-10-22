package com.mobvoi.companion.lpa;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.c;
import androidx.fragment.app.w;
import com.mobvoi.android.common.ui.viewbinding.FragmentViewBindingDelegate;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.s;
import com.mobvoi.companion.R;
import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.msgproxy.MessageInfo;
import com.mobvoi.wear.msgproxy.MessageProxyClient;
import com.mobvoi.wear.msgproxy.MessageProxyException;
import com.mobvoi.wear.msgproxy.MessageProxyListener;
import com.mobvoi.wear.msgproxy.NodeInfo;
import com.mobvoi.wear.util.LogCleaner;
import java.util.List;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.l;
import kotlin.reflect.KProperty;
import kotlin.text.d;
import oc.p;
/* compiled from: SimOpenTutorialFragment.kt */
/* loaded from: classes2.dex */
public final class m0 extends m implements MessageProxyListener {

    /* renamed from: j  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f17228j = {l.h(new PropertyReference1Impl(l.b(m0.class), "viewBinding", "getViewBinding()Lcom/mobvoi/companion/databinding/FragmentSimOpenTutorialBinding;"))};

    /* renamed from: f  reason: collision with root package name */
    public c f17229f;

    /* renamed from: g  reason: collision with root package name */
    public BroadcastReceiver f17230g;

    /* renamed from: h  reason: collision with root package name */
    public s f17231h;

    /* renamed from: i  reason: collision with root package name */
    private final FragmentViewBindingDelegate f17232i = com.mobvoi.android.common.ui.viewbinding.a.b(this, b.INSTANCE);

    /* compiled from: SimOpenTutorialFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: SimOpenTutorialFragment.kt */
    /* loaded from: classes2.dex */
    /* synthetic */ class b extends FunctionReferenceImpl implements qo.l<View, p> {
        public static final b INSTANCE = new b();

        b() {
            super(1, p.class, "bind", "bind(Landroid/view/View;)Lcom/mobvoi/companion/databinding/FragmentSimOpenTutorialBinding;", 0);
        }

        /* renamed from: g */
        public final p invoke(View p02) {
            i.f(p02, "p0");
            return p.b(p02);
        }
    }

    static {
        new a(null);
    }

    public m0() {
        super(R.layout.fragment_sim_open_tutorial);
    }

    private final void e0() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("enable_profile_sucess");
        intentFilter.addAction("enable_profile_fail");
        intentFilter.addAction("stop_show_wait_dialog");
        androidx.fragment.app.f activity = getActivity();
        if (activity != null) {
            b1.a.b(activity).c(h0(), intentFilter);
        }
        MessageProxyClient.getInstance().sendMessage(WearPath.Lpa.START_ENABLE);
        if (!g0().isShowing()) {
            g0().show();
        }
    }

    private final p i0() {
        return (p) this.f17232i.b(this, f17228j[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(m0 this$0, View view) {
        i.f(this$0, "this$0");
        MessageProxyClient.getInstance().sendMessage(WearPath.Lpa.SHOW_QR_CODE);
        androidx.fragment.app.f activity = this$0.getActivity();
        if (activity != null) {
            w l10 = activity.getSupportFragmentManager().l();
            i.e(l10, "it.supportFragmentManager.beginTransaction()");
            l10.s(R.id.fragment, new j0());
            l10.h(null);
            l10.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(m0 this$0, View view) {
        i.f(this$0, "this$0");
        this$0.l0();
    }

    private final void l0() {
        try {
            if (MessageProxyClient.getInstance().hasConnectedNodes()) {
                e0();
            } else {
                aa.c.c(R.string.enable_now);
            }
            f0().sendEmptyMessageDelayed(0, LogCleaner.ONE_MINUTE);
        } catch (MessageProxyException e10) {
            k.e("SimOpenTurorial", "MessageProxyException, %s", e10);
        }
    }

    public final s f0() {
        s sVar = this.f17231h;
        if (sVar != null) {
            return sVar;
        }
        i.u("mCountDownHandler");
        throw null;
    }

    public final c g0() {
        c cVar = this.f17229f;
        if (cVar != null) {
            return cVar;
        }
        i.u("mLoadingDialog");
        throw null;
    }

    public final BroadcastReceiver h0() {
        BroadcastReceiver broadcastReceiver = this.f17230g;
        if (broadcastReceiver != null) {
            return broadcastReceiver;
        }
        i.u("mResultReceiver");
        throw null;
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyListener
    public void onConnectedNodesChanged(List<? extends NodeInfo> nodes) {
        i.f(nodes, "nodes");
        k.c("SimOpenTurorial", "onConnectedNodesChanged: %s", nodes);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        androidx.fragment.app.f activity = getActivity();
        if (activity != null) {
            b1.a.b(activity).e(h0());
        }
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyListener
    public void onMessageReceived(MessageInfo message) {
        i.f(message, "message");
        String path = message.getPath();
        k.c("SimOpenTurorial", "receiveMessage path = %s", path);
        androidx.fragment.app.f activity = getActivity();
        if (activity != null) {
            if (i.b(WearPath.Lpa.ENABLE_SUCCESS, path)) {
                b1.a.b(activity).d(new Intent("enable_profile_sucess"));
                k.a("SimOpenTurorial", "sim open success");
            } else if (i.b(WearPath.Lpa.ENABLE_FAIL, path)) {
                byte[] payload = message.getPayload();
                i.e(payload, "message.payload");
                String str = new String(payload, d.f30092a);
                if (i.b("profileNotInDisabledState", str)) {
                    b1.a.b(activity).d(new Intent("stop_show_wait_dialog"));
                    aa.c.a(R.string.already_enabled);
                } else {
                    Intent intent = new Intent("enable_profile_fail");
                    intent.putExtra("reason", str);
                    b1.a.b(activity).d(intent);
                }
                k.c("SimOpenTurorial", "sim open fail: %s", str);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.f(view, "view");
        super.onViewCreated(view, bundle);
        MessageProxyClient.getInstance().addListener(this);
        i0().f31557c.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.lpa.k0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                m0.j0(m0.this, view2);
            }
        });
        i0().f31556b.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.lpa.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                m0.k0(m0.this, view2);
            }
        });
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey("need_refresh_now") && arguments.getBoolean("need_refresh_now")) {
            l0();
        }
    }
}
