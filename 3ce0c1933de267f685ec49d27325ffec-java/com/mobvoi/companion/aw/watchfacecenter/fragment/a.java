package com.mobvoi.companion.aw.watchfacecenter.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.mobvoi.companion.aw.watchfacecenter.bean.WatchFaceBean;
import com.mobvoi.wear.contacts.ContactConstant;
import io.d;
import io.f;
import java.util.HashMap;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import so.c;
/* compiled from: BaseWatchFaceFragment.kt */
/* loaded from: classes2.dex */
public abstract class a extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private final d f16378a;

    /* renamed from: b  reason: collision with root package name */
    private String f16379b;

    /* compiled from: BaseWatchFaceFragment.kt */
    /* renamed from: com.mobvoi.companion.aw.watchfacecenter.fragment.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0201a extends Lambda implements qo.a<Handler> {
        public static final C0201a INSTANCE = new C0201a();

        C0201a() {
            super(0);
        }

        /* renamed from: a */
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    }

    public a() {
        d a10;
        a10 = f.a(C0201a.INSTANCE);
        this.f16378a = a10;
    }

    public static /* synthetic */ void g0(a aVar, WatchFaceBean watchFaceBean, String str, String str2, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 4) != 0) {
                str2 = null;
            }
            aVar.f0(watchFaceBean, str, str2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackInstallWatchface");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Handler Y() {
        return (Handler) this.f16378a.getValue();
    }

    public abstract int Z();

    /* JADX INFO: Access modifiers changed from: protected */
    public final String a0() {
        return this.f16379b;
    }

    public abstract void b0(Context context);

    protected void c0(Context context) {
        i.f(context, "context");
    }

    public abstract void d0(Context context, View view);

    public final void e0() {
        Y().removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void f0(WatchFaceBean wf2, String key, String str) {
        int a10;
        i.f(wf2, "wf");
        i.f(key, "key");
        if (wf2.b() == 0 && wf2.i() != null) {
            Float r10 = wf2.r();
            a10 = c.a((r10 == null ? 0.0f : r10.floatValue()) * 100.0d);
            double d10 = a10 / 100.0d;
            HashMap hashMap = new HashMap();
            String i10 = wf2.i();
            if (i10 == null) {
                i10 = "";
            }
            hashMap.put(ContactConstant.CallsRecordKeys.NAME, i10);
            if (str == null) {
                str = "";
            }
            hashMap.put("cate", str);
            hashMap.put("price", String.valueOf(d10));
            sb.a.f(requireContext(), key, "buy", hashMap, d10);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f16379b = arguments == null ? null : arguments.getString("extra_node_id");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        i.f(inflater, "inflater");
        return inflater.inflate(Z(), viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        e0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.f(view, "view");
        super.onViewCreated(view, bundle);
        Context requireContext = requireContext();
        i.e(requireContext, "requireContext()");
        c0(requireContext);
        d0(requireContext, view);
        b0(requireContext);
    }
}
