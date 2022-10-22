package com.mobvoi.companion.lpa;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.mobvoi.android.common.ui.viewbinding.FragmentViewBindingDelegate;
import com.mobvoi.companion.R;
import java.util.List;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.l;
import kotlin.reflect.KProperty;
import oc.o;
/* compiled from: SimOpenGuideFragment.kt */
/* loaded from: classes2.dex */
public final class j0 extends Fragment {

    /* renamed from: d  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f17209d = {l.h(new PropertyReference1Impl(l.b(j0.class), "viewBinding", "getViewBinding()Lcom/mobvoi/companion/databinding/FragmentSimOpenGuideBinding;"))};

    /* renamed from: a  reason: collision with root package name */
    private PackageManager f17210a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f17211b;

    /* renamed from: c  reason: collision with root package name */
    private final FragmentViewBindingDelegate f17212c = com.mobvoi.android.common.ui.viewbinding.a.b(this, b.INSTANCE);

    /* compiled from: SimOpenGuideFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: SimOpenGuideFragment.kt */
    /* loaded from: classes2.dex */
    /* synthetic */ class b extends FunctionReferenceImpl implements qo.l<View, o> {
        public static final b INSTANCE = new b();

        b() {
            super(1, o.class, "bind", "bind(Landroid/view/View;)Lcom/mobvoi/companion/databinding/FragmentSimOpenGuideBinding;", 0);
        }

        /* renamed from: g */
        public final o invoke(View p02) {
            i.f(p02, "p0");
            return o.b(p02);
        }
    }

    static {
        new a(null);
    }

    public j0() {
        super(R.layout.fragment_sim_open_guide);
    }

    private final o Z() {
        return (o) this.f17212c.b(this, f17209d[0]);
    }

    private final boolean a0() {
        PackageManager packageManager = this.f17210a;
        List<PackageInfo> installedPackages = packageManager == null ? null : packageManager.getInstalledPackages(0);
        if (installedPackages != null) {
            for (PackageInfo packageInfo : installedPackages) {
                if (i.b("com.sinovatech.unicom.ui", packageInfo.packageName)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(j0 this$0, View view) {
        i.f(this$0, "this$0");
        if (this$0.f17211b) {
            PackageManager packageManager = this$0.f17210a;
            Intent launchIntentForPackage = packageManager == null ? null : packageManager.getLaunchIntentForPackage("com.sinovatech.unicom.ui");
            if (launchIntentForPackage != null) {
                this$0.startActivity(launchIntentForPackage);
                return;
            }
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("http://ad.10010.com/uniAdms_2.0/ad/urlProxy?placeCode=WT_AD_004&&targetUrl=http://m1.img.10010.com/e4/images/unicomClient_AndroidV5_2.apk&&areaCode=098&&targetId=8a948d8c4081953d014099711eae0005&&placeId=4028b8813ecad797013ecadd1adc0009&&sysId=WT"));
        this$0.startActivity(intent);
    }

    private final void c0() {
        if (this.f17211b) {
            Z().f31554b.setText(getString(R.string.open_unicom));
        } else {
            Z().f31554b.setText(getString(R.string.download_unicom));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (a0() != this.f17211b) {
            this.f17211b = a0();
            c0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.f(view, "view");
        super.onViewCreated(view, bundle);
        androidx.fragment.app.f activity = getActivity();
        this.f17210a = activity == null ? null : activity.getPackageManager();
        this.f17211b = a0();
        c0();
        Z().f31554b.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.lpa.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                j0.b0(j0.this, view2);
            }
        });
    }
}
