package com.mobvoi.assistant.account.ui.captcha;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.mobvoi.assistant.account.AccountHomeActivity;
import com.mobvoi.assistant.account.data.AccountManager;
import com.mobvoi.assistant.account.ui.captcha.CaptchaFragment;
import ib.g;
import ib.h;
import ib.i;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.n;
import pa.c;
import pa.e;
import wa.d;
/* compiled from: CaptchaFragment.kt */
/* loaded from: classes2.dex */
public final class CaptchaFragment extends com.mobvoi.companion.base.m3.b implements i {

    /* renamed from: b  reason: collision with root package name */
    private String f15688b;

    /* renamed from: c  reason: collision with root package name */
    private String f15689c;

    /* renamed from: d  reason: collision with root package name */
    private String f15690d;

    /* renamed from: e  reason: collision with root package name */
    private String f15691e;

    /* renamed from: f  reason: collision with root package name */
    private String f15692f;

    /* renamed from: g  reason: collision with root package name */
    private String f15693g;

    /* renamed from: h  reason: collision with root package name */
    private AccountHomeActivity f15694h;

    /* renamed from: i  reason: collision with root package name */
    private h f15695i;

    /* renamed from: j  reason: collision with root package name */
    private d f15696j;

    /* compiled from: CaptchaFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a extends gc.i {
        a() {
        }

        @Override // gc.i, android.text.TextWatcher
        public void onTextChanged(CharSequence s10, int i10, int i11, int i12) {
            kotlin.jvm.internal.i.f(s10, "s");
            CaptchaFragment.this.h0();
        }
    }

    /* compiled from: CaptchaFragment.kt */
    /* loaded from: classes2.dex */
    public static final class b extends gc.i {
        b() {
        }

        @Override // gc.i, android.text.TextWatcher
        public void onTextChanged(CharSequence s10, int i10, int i11, int i12) {
            kotlin.jvm.internal.i.f(s10, "s");
            CaptchaFragment.this.i0();
        }
    }

    private final void f0(boolean z10) {
        if (z10) {
            g0().f36200e.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            g0().f36200e.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        g0().f36200e.setSelection(g0().f36200e.getText().length());
    }

    private final d g0() {
        d dVar = this.f15696j;
        kotlin.jvm.internal.i.d(dVar);
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0() {
        if (g0().f36203h.getVisibility() == 0) {
            g0().f36203h.setText("");
            g0().f36203h.setVisibility(4);
            View view = g0().f36205j;
            AccountHomeActivity accountHomeActivity = this.f15694h;
            if (accountHomeActivity != null) {
                view.setBackgroundColor(androidx.core.content.b.c(accountHomeActivity, c.f32618a));
            } else {
                kotlin.jvm.internal.i.u("mActivity");
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0() {
        if (g0().f36204i.getVisibility() == 0) {
            g0().f36204i.setText("");
            g0().f36204i.setVisibility(4);
            View view = g0().f36206k;
            AccountHomeActivity accountHomeActivity = this.f15694h;
            if (accountHomeActivity != null) {
                view.setBackgroundColor(androidx.core.content.b.c(accountHomeActivity, c.f32618a));
            } else {
                kotlin.jvm.internal.i.u("mActivity");
                throw null;
            }
        }
    }

    private final void j0() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.containsKey("extra_account")) {
                this.f15688b = arguments.getString("extra_account");
            }
            if (arguments.containsKey("extra_rest_type")) {
                this.f15690d = arguments.getString("extra_rest_type", "rest_sign_up");
            }
            if (arguments.containsKey("extra_third_party_type")) {
                this.f15691e = arguments.getString("extra_third_party_type");
            }
            if (arguments.containsKey("extra_third_party_uid")) {
                this.f15692f = arguments.getString("extra_third_party_uid");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(CaptchaFragment this$0, CompoundButton noName_0, boolean z10) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(noName_0, "$noName_0");
        this$0.f0(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(CaptchaFragment this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.n0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(CaptchaFragment this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.q0();
    }

    private final void n0() {
        this.f15689c = g0().f36197b.getText().toString();
        this.f15693g = g0().f36200e.getText().toString();
        if (TextUtils.isEmpty(this.f15689c)) {
            String string = getString(pa.i.f32706p);
            kotlin.jvm.internal.i.e(string, "getString(R.string.captcha_hint)");
            s0(string);
        } else if ((!kotlin.jvm.internal.i.b(this.f15690d, "rest_sign_up") && !kotlin.jvm.internal.i.b(this.f15690d, "rest_reset_pwd") && !kotlin.jvm.internal.i.b(this.f15690d, "rest_register_third_party")) || o0()) {
            h0();
            i0();
            g0().f36198c.setEnabled(false);
            String str = this.f15690d;
            if (str != null) {
                switch (str.hashCode()) {
                    case -2090751111:
                        if (!str.equals("rest_change_pwd")) {
                            return;
                        }
                        break;
                    case -1161142878:
                        if (!str.equals("rest_reset_pwd")) {
                            return;
                        }
                        break;
                    case -971779561:
                        if (str.equals("rest_bind_third_party")) {
                            String string2 = getString(pa.i.f32705o);
                            kotlin.jvm.internal.i.e(string2, "getString(R.string.bind_third_party_bing)");
                            Z(string2);
                            h hVar = this.f15695i;
                            if (hVar != null) {
                                hVar.k(this.f15688b, this.f15689c, this.f15691e, this.f15692f);
                                return;
                            } else {
                                kotlin.jvm.internal.i.u("mCaptchaPresenter");
                                throw null;
                            }
                        } else {
                            return;
                        }
                    case 173405693:
                        if (str.equals("rest_register_third_party")) {
                            String string3 = getString(pa.i.V);
                            kotlin.jvm.internal.i.e(string3, "getString(R.string.sign_up_ing)");
                            Z(string3);
                            h hVar2 = this.f15695i;
                            if (hVar2 != null) {
                                hVar2.f(this.f15688b, this.f15689c, this.f15693g, this.f15691e, this.f15692f);
                                return;
                            } else {
                                kotlin.jvm.internal.i.u("mCaptchaPresenter");
                                throw null;
                            }
                        } else {
                            return;
                        }
                    case 543051506:
                        if (str.equals("rest_sign_up")) {
                            String string4 = getString(pa.i.V);
                            kotlin.jvm.internal.i.e(string4, "getString(R.string.sign_up_ing)");
                            Z(string4);
                            h hVar3 = this.f15695i;
                            if (hVar3 != null) {
                                hVar3.h(this.f15688b, this.f15689c, this.f15693g, "");
                                return;
                            } else {
                                kotlin.jvm.internal.i.u("mCaptchaPresenter");
                                throw null;
                            }
                        } else {
                            return;
                        }
                    case 1986433207:
                        if (str.equals("update_account")) {
                            h hVar4 = this.f15695i;
                            if (hVar4 != null) {
                                hVar4.j(this.f15690d, this.f15688b, this.f15689c);
                                return;
                            } else {
                                kotlin.jvm.internal.i.u("mCaptchaPresenter");
                                throw null;
                            }
                        } else {
                            return;
                        }
                    default:
                        return;
                }
                String string5 = getString(pa.i.S);
                kotlin.jvm.internal.i.e(string5, "getString(R.string.reset_pwd_ing)");
                Z(string5);
                h hVar5 = this.f15695i;
                if (hVar5 != null) {
                    hVar5.o(this.f15688b, this.f15689c, this.f15693g);
                } else {
                    kotlin.jvm.internal.i.u("mCaptchaPresenter");
                    throw null;
                }
            }
        }
    }

    private final boolean o0() {
        String c10 = lb.c.c(getActivity(), g0().f36200e.getText().toString());
        if (c10 == null || TextUtils.isEmpty(c10)) {
            return true;
        }
        t0(c10);
        return false;
    }

    private final void p0() {
        String str;
        if (lb.c.p(this.f15688b)) {
            str = getString(pa.i.f32709s, this.f15688b);
        } else {
            str = lb.c.n(this.f15688b) ? getString(pa.i.f32708r) : "";
        }
        kotlin.jvm.internal.i.e(str, "when {\n            AccountUtil.isValidPhoneNumber(mAccount) -> {\n                getString(R.string.captcha_sent_phone, mAccount)\n            }\n            AccountUtil.isValidEmail(mAccount) -> {\n                getString(R.string.captcha_sent_mail)\n            }\n            else -> {\n                \"\"\n            }\n        }");
        Toast.makeText(getActivity(), str, 1).show();
    }

    private final void q0() {
        p0();
        String string = getString(pa.i.f32707q);
        kotlin.jvm.internal.i.e(string, "getString(R.string.captcha_sending)");
        Z(string);
        h hVar = this.f15695i;
        if (hVar != null) {
            hVar.b(this.f15690d, this.f15688b);
        } else {
            kotlin.jvm.internal.i.u("mCaptchaPresenter");
            throw null;
        }
    }

    private final void r0(String str) {
        androidx.appcompat.app.a supportActionBar = ((androidx.appcompat.app.d) requireActivity()).getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.z(str);
        }
    }

    private final void s0(String str) {
        g0().f36203h.setVisibility(0);
        g0().f36203h.setText(str);
        View view = g0().f36205j;
        AccountHomeActivity accountHomeActivity = this.f15694h;
        if (accountHomeActivity != null) {
            view.setBackgroundColor(androidx.core.content.b.c(accountHomeActivity, c.f32622e));
        } else {
            kotlin.jvm.internal.i.u("mActivity");
            throw null;
        }
    }

    private final void t0(String str) {
        g0().f36204i.setVisibility(0);
        g0().f36204i.setText(str);
        View view = g0().f36206k;
        AccountHomeActivity accountHomeActivity = this.f15694h;
        if (accountHomeActivity != null) {
            view.setBackgroundColor(androidx.core.content.b.c(accountHomeActivity, c.f32622e));
        } else {
            kotlin.jvm.internal.i.u("mActivity");
            throw null;
        }
    }

    private final void u0() {
        String string = getString(pa.i.D);
        kotlin.jvm.internal.i.e(string, "getString(R.string.logining)");
        Z(string);
        h hVar = this.f15695i;
        if (hVar != null) {
            hVar.m(this.f15688b, this.f15693g);
        } else {
            kotlin.jvm.internal.i.u("mCaptchaPresenter");
            throw null;
        }
    }

    @Override // ib.i
    public void K() {
        Y();
        AccountHomeActivity accountHomeActivity = this.f15694h;
        if (accountHomeActivity != null) {
            lb.d.a(accountHomeActivity, g0().f36197b);
            AccountHomeActivity accountHomeActivity2 = this.f15694h;
            if (accountHomeActivity2 != null) {
                lb.d.a(accountHomeActivity2, g0().f36200e);
                g0().f36198c.setEnabled(true);
                String str = this.f15690d;
                if (str != null) {
                    switch (str.hashCode()) {
                        case -2090751111:
                            if (str.equals("rest_change_pwd")) {
                                aa.c.a(pa.i.J);
                                AccountHomeActivity accountHomeActivity3 = this.f15694h;
                                if (accountHomeActivity3 != null) {
                                    accountHomeActivity3.finish();
                                    return;
                                } else {
                                    kotlin.jvm.internal.i.u("mActivity");
                                    throw null;
                                }
                            } else {
                                return;
                            }
                        case -1161142878:
                            if (str.equals("rest_reset_pwd")) {
                                aa.c.a(pa.i.J);
                                androidx.navigation.fragment.a.a(this).o(e.f32639h);
                                return;
                            }
                            return;
                        case -971779561:
                            if (!str.equals("rest_bind_third_party")) {
                                return;
                            }
                            break;
                        case 173405693:
                            if (!str.equals("rest_register_third_party")) {
                                return;
                            }
                            break;
                        case 543051506:
                            if (str.equals("rest_sign_up")) {
                                u0();
                                return;
                            }
                            return;
                        case 1986433207:
                            if (str.equals("update_account")) {
                                AccountHomeActivity accountHomeActivity4 = this.f15694h;
                                if (accountHomeActivity4 != null) {
                                    AccountManager.i(accountHomeActivity4.getApplicationContext());
                                    AccountHomeActivity accountHomeActivity5 = this.f15694h;
                                    if (accountHomeActivity5 != null) {
                                        accountHomeActivity5.finish();
                                        return;
                                    } else {
                                        kotlin.jvm.internal.i.u("mActivity");
                                        throw null;
                                    }
                                } else {
                                    kotlin.jvm.internal.i.u("mActivity");
                                    throw null;
                                }
                            } else {
                                return;
                            }
                        default:
                            return;
                    }
                    androidx.navigation.fragment.a.a(this).t(ib.d.f28214a.a(this.f15691e, this.f15692f));
                    return;
                }
                return;
            }
            kotlin.jvm.internal.i.u("mActivity");
            throw null;
        }
        kotlin.jvm.internal.i.u("mActivity");
        throw null;
    }

    @Override // ib.i
    public void T() {
        Y();
        g0().f36202g.j();
    }

    @Override // ib.i
    public void X(String errorMsg) {
        kotlin.jvm.internal.i.f(errorMsg, "errorMsg");
        AccountHomeActivity accountHomeActivity = this.f15694h;
        if (accountHomeActivity != null) {
            lb.d.a(accountHomeActivity, g0().f36197b);
            AccountHomeActivity accountHomeActivity2 = this.f15694h;
            if (accountHomeActivity2 != null) {
                lb.d.a(accountHomeActivity2, g0().f36200e);
                Y();
                s0(errorMsg);
                g0().f36198c.setEnabled(true);
                return;
            }
            kotlin.jvm.internal.i.u("mActivity");
            throw null;
        }
        kotlin.jvm.internal.i.u("mActivity");
        throw null;
    }

    @Override // ib.i
    public void a() {
        Y();
        sa.a e10 = ta.a.e();
        sb.a.j(e10.wwid, e10.phoneNumber, e10.email, e10.nickName, e10.sex == 0);
        AccountHomeActivity accountHomeActivity = this.f15694h;
        if (accountHomeActivity != null) {
            lb.d.a(accountHomeActivity, g0().f36197b);
            AccountHomeActivity accountHomeActivity2 = this.f15694h;
            if (accountHomeActivity2 != null) {
                lb.d.a(accountHomeActivity2, g0().f36200e);
                b1.a.b(com.mobvoi.android.common.utils.b.e()).d(new Intent("action.LOGIN_SUCCESS"));
                g0().f36198c.setEnabled(true);
                AccountHomeActivity accountHomeActivity3 = this.f15694h;
                if (accountHomeActivity3 != null) {
                    accountHomeActivity3.H();
                    AccountHomeActivity accountHomeActivity4 = this.f15694h;
                    if (accountHomeActivity4 != null) {
                        accountHomeActivity4.setResult(-1);
                        AccountHomeActivity accountHomeActivity5 = this.f15694h;
                        if (accountHomeActivity5 != null) {
                            accountHomeActivity5.finish();
                        } else {
                            kotlin.jvm.internal.i.u("mActivity");
                            throw null;
                        }
                    } else {
                        kotlin.jvm.internal.i.u("mActivity");
                        throw null;
                    }
                } else {
                    kotlin.jvm.internal.i.u("mActivity");
                    throw null;
                }
            } else {
                kotlin.jvm.internal.i.u("mActivity");
                throw null;
            }
        } else {
            kotlin.jvm.internal.i.u("mActivity");
            throw null;
        }
    }

    @Override // ib.i
    public void b(String errorMsg) {
        kotlin.jvm.internal.i.f(errorMsg, "errorMsg");
        Y();
        s0(errorMsg);
        g0().f36198c.setEnabled(true);
        androidx.navigation.fragment.a.a(this).o(e.f32639h);
    }

    @Override // ib.i
    public void c(String errorMsg) {
        kotlin.jvm.internal.i.f(errorMsg, "errorMsg");
        Y();
        s0(errorMsg);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        super.onAttach(context);
        if (context instanceof AccountHomeActivity) {
            this.f15694h = (AccountHomeActivity) context;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.i.f(inflater, "inflater");
        this.f15696j = d.d(inflater, viewGroup, false);
        LinearLayout c10 = g0().a();
        kotlin.jvm.internal.i.e(c10, "binding.root");
        return c10;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        h hVar = this.f15695i;
        if (hVar != null) {
            hVar.unsubscribe();
        } else {
            kotlin.jvm.internal.i.u("mCaptchaPresenter");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        String str;
        kotlin.jvm.internal.i.f(view, "view");
        super.onViewCreated(view, bundle);
        j0();
        this.f15695i = new g(getActivity(), this);
        g0().f36201f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ib.c
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                CaptchaFragment.k0(CaptchaFragment.this, compoundButton, z10);
            }
        });
        g0().f36198c.setOnClickListener(new View.OnClickListener() { // from class: ib.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CaptchaFragment.l0(CaptchaFragment.this, view2);
            }
        });
        g0().f36202g.setOnClickListener(new View.OnClickListener() { // from class: ib.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CaptchaFragment.m0(CaptchaFragment.this, view2);
            }
        });
        g0().f36197b.addTextChangedListener(new a());
        g0().f36200e.addTextChangedListener(new b());
        int i10 = pa.i.W;
        String str2 = this.f15690d;
        if (str2 != null) {
            switch (str2.hashCode()) {
                case -2090751111:
                    if (str2.equals("rest_change_pwd")) {
                        i10 = pa.i.T;
                        break;
                    }
                    break;
                case -1161142878:
                    if (str2.equals("rest_reset_pwd")) {
                        i10 = pa.i.T;
                        break;
                    }
                    break;
                case -971779561:
                    if (str2.equals("rest_bind_third_party")) {
                        i10 = pa.i.f32704n;
                        g0().f36199d.setVisibility(8);
                        break;
                    }
                    break;
                case 173405693:
                    str = "rest_register_third_party";
                    str2.equals(str);
                    break;
                case 543051506:
                    str = "rest_sign_up";
                    str2.equals(str);
                    break;
                case 1986433207:
                    if (str2.equals("update_account")) {
                        i10 = pa.i.R;
                        g0().f36199d.setVisibility(8);
                        break;
                    }
                    break;
            }
        }
        n nVar = n.f30086a;
        Locale locale = Locale.US;
        String string = getString(i10);
        kotlin.jvm.internal.i.e(string, "getString(titleId)");
        String format = String.format(locale, string, Arrays.copyOf(new Object[]{getString(pa.i.f32700j)}, 1));
        kotlin.jvm.internal.i.e(format, "java.lang.String.format(locale, format, *args)");
        r0(format);
        AccountHomeActivity accountHomeActivity = this.f15694h;
        if (accountHomeActivity != null) {
            lb.d.b(accountHomeActivity, g0().f36197b);
        } else {
            kotlin.jvm.internal.i.u("mActivity");
            throw null;
        }
    }
}
