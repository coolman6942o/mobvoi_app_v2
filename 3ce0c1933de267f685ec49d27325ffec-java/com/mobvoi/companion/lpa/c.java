package com.mobvoi.companion.lpa;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.f;
import androidx.fragment.app.w;
import com.mobvoi.android.common.ui.viewbinding.FragmentViewBindingDelegate;
import com.mobvoi.companion.R;
import com.mobvoi.companion.setting.CompanionSetting;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.l;
import kotlin.reflect.KProperty;
import oc.g;
/* compiled from: EnableFailFragment.kt */
/* loaded from: classes2.dex */
public final class c extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f17176b = {l.h(new PropertyReference1Impl(l.b(c.class), "viewBinding", "getViewBinding()Lcom/mobvoi/companion/databinding/FragmentEnableFailBinding;"))};

    /* renamed from: a  reason: collision with root package name */
    private final FragmentViewBindingDelegate f17177a = com.mobvoi.android.common.ui.viewbinding.a.b(this, b.INSTANCE);

    /* compiled from: EnableFailFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a extends ClickableSpan {
        a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Fragment fragment;
            i.f(view, "view");
            f activity = c.this.getActivity();
            if (activity != null) {
                w l10 = activity.getSupportFragmentManager().l();
                i.e(l10, "it.supportFragmentManager.beginTransaction()");
                if (CompanionSetting.getUnicomProfileEnableStatus()) {
                    fragment = new e();
                } else {
                    fragment = new m0();
                }
                l10.s(R.id.fragment, fragment);
                l10.k();
            }
        }
    }

    /* compiled from: EnableFailFragment.kt */
    /* loaded from: classes2.dex */
    /* synthetic */ class b extends FunctionReferenceImpl implements qo.l<View, g> {
        public static final b INSTANCE = new b();

        b() {
            super(1, g.class, "bind", "bind(Landroid/view/View;)Lcom/mobvoi/companion/databinding/FragmentEnableFailBinding;", 0);
        }

        /* renamed from: g */
        public final g invoke(View p02) {
            i.f(p02, "p0");
            return g.b(p02);
        }
    }

    public c() {
        super(R.layout.fragment_enable_fail);
    }

    private final g a0() {
        return (g) this.f17177a.b(this, f17176b[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(c this$0, View view) {
        Fragment fragment;
        i.f(this$0, "this$0");
        f activity = this$0.getActivity();
        if (activity != null) {
            w l10 = activity.getSupportFragmentManager().l();
            i.e(l10, "it.supportFragmentManager.beginTransaction()");
            if (CompanionSetting.getUnicomProfileEnableStatus()) {
                fragment = new e();
            } else {
                fragment = new m0();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("need_refresh_now", true);
            fragment.setArguments(bundle);
            l10.s(R.id.fragment, fragment);
            l10.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(c this$0, View view) {
        i.f(this$0, "this$0");
        f activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.f(view, "view");
        super.onViewCreated(view, bundle);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) getString(R.string.reason_one_1));
        String string = getString(R.string.reason_one_2);
        i.e(string, "getString(R.string.reason_one_2)");
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new a(), 0, string.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(-10583071), 0, string.length(), 33);
        spannableStringBuilder.append((CharSequence) spannableString);
        spannableStringBuilder.append((CharSequence) getString(R.string.reason_one_3));
        a0().f31526d.setText(spannableStringBuilder);
        a0().f31526d.setMovementMethod(LinkMovementMethod.getInstance());
        a0().f31525c.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.lpa.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                c.b0(c.this, view2);
            }
        });
        a0().f31524b.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.lpa.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                c.c0(c.this, view2);
            }
        });
    }
}
