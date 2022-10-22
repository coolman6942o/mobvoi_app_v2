package com.mobvoi.assistant.account.ui.account;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.d;
import com.mobvoi.assistant.account.AccountConstant;
import com.mobvoi.assistant.account.ui.account.AccountFragment;
import gb.b;
import gb.f;
import gb.g;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import kotlin.jvm.internal.n;
import kotlin.text.u;
import lb.c;
import pa.i;
import wa.e;
/* compiled from: AccountFragment.kt */
/* loaded from: classes2.dex */
public final class AccountFragment extends com.mobvoi.companion.base.m3.b implements g, View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private String f15677b;

    /* renamed from: c  reason: collision with root package name */
    private String f15678c;

    /* renamed from: d  reason: collision with root package name */
    private String f15679d;

    /* renamed from: e  reason: collision with root package name */
    private String f15680e;

    /* renamed from: f  reason: collision with root package name */
    private f f15681f;

    /* renamed from: g  reason: collision with root package name */
    private final TextWatcher f15682g = new b();

    /* renamed from: h  reason: collision with root package name */
    private e f15683h;

    /* compiled from: AccountFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a implements fb.b {
        a() {
        }

        @Override // fb.b
        public void a() {
            AccountFragment accountFragment = AccountFragment.this;
            String string = accountFragment.getString(i.f32715y);
            kotlin.jvm.internal.i.e(string, "getString(R.string.kid_privacy_policy)");
            accountFragment.n0("https://activities.chumenwenwen.com/vpa/tickids/privacy-policy/index.html", string);
        }

        @Override // fb.b
        public void b() {
            AccountFragment accountFragment = AccountFragment.this;
            String string = accountFragment.getString(i.M);
            kotlin.jvm.internal.i.e(string, "getString(R.string.privacy_policy)");
            accountFragment.n0("https://www.chumenwenwen.com/privacy-policy.html", string);
        }

        @Override // fb.b
        public void c() {
            AccountFragment accountFragment = AccountFragment.this;
            String string = accountFragment.getString(i.f32691a0);
            kotlin.jvm.internal.i.e(string, "getString(R.string.user_agreement)");
            accountFragment.n0("https://developer.chumenwenwen.com/agreement/", string);
        }
    }

    /* compiled from: AccountFragment.kt */
    /* loaded from: classes2.dex */
    public static final class b extends gc.i {
        b() {
        }

        @Override // gc.i, android.text.TextWatcher
        public void onTextChanged(CharSequence s10, int i10, int i11, int i12) {
            kotlin.jvm.internal.i.f(s10, "s");
            AccountFragment.this.h0();
            if (AccountFragment.this.g0().f36215i.getVisibility() == 8) {
                AccountFragment.this.f0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0() {
        g0().f36216j.setText("");
        g0().f36212f.setEnabled(c.m(g0().f36209c.getText().toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e g0() {
        e eVar = this.f15683h;
        kotlin.jvm.internal.i.d(eVar);
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0() {
        if (g0().f36216j.getVisibility() == 0) {
            g0().f36216j.setText("");
            g0().f36216j.setVisibility(4);
            g0().f36217k.setBackgroundColor(androidx.core.content.b.c(requireContext(), pa.c.f32618a));
        }
    }

    private final void i0() {
        if (getArguments() != null) {
            Bundle requireArguments = requireArguments();
            kotlin.jvm.internal.i.e(requireArguments, "requireArguments()");
            if (requireArguments.containsKey("extra_rest_type")) {
                String string = requireArguments.getString("extra_rest_type", "rest_sign_up");
                this.f15677b = string;
                int i10 = i.W;
                if (string != null) {
                    switch (string.hashCode()) {
                        case -2090751111:
                            if (string.equals("rest_change_pwd")) {
                                i10 = i.T;
                                break;
                            }
                            break;
                        case -1161142878:
                            if (string.equals("rest_reset_pwd")) {
                                i10 = i.T;
                                break;
                            }
                            break;
                        case -971779561:
                            if (string.equals("rest_bind_third_party")) {
                                i10 = i.f32704n;
                                break;
                            }
                            break;
                        case 543051506:
                            string.equals("rest_sign_up");
                            break;
                        case 1986433207:
                            if (string.equals("update_account")) {
                                i10 = i.R;
                                break;
                            }
                            break;
                    }
                }
                n nVar = n.f30086a;
                Locale locale = Locale.US;
                String string2 = getString(i10);
                kotlin.jvm.internal.i.e(string2, "getString(titleId)");
                String format = String.format(locale, string2, Arrays.copyOf(new Object[]{getString(i.f32699i)}, 1));
                kotlin.jvm.internal.i.e(format, "java.lang.String.format(locale, format, *args)");
                l0(format);
            }
            if (requireArguments.containsKey("extra_third_party_type")) {
                this.f15679d = requireArguments.getString("extra_third_party_type");
            }
            if (requireArguments.containsKey("extra_third_party_uid")) {
                this.f15680e = requireArguments.getString("extra_third_party_uid");
            }
            if (kotlin.jvm.internal.i.b("update_account", this.f15677b) || kotlin.jvm.internal.i.b("rest_change_pwd", this.f15677b)) {
                g0().f36214h.setVisibility(8);
            } else {
                g0().f36214h.setVisibility(0);
            }
            if (!com.mobvoi.companion.base.settings.a.isOversea() || !kotlin.jvm.internal.i.b("rest_bind_third_party", this.f15677b)) {
                g0().f36210d.setVisibility(8);
            } else {
                g0().f36210d.setVisibility(0);
            }
            if (com.mobvoi.companion.base.settings.a.isOversea() || !kotlin.jvm.internal.i.b("rest_sign_up", this.f15677b)) {
                g0().f36215i.setVisibility(8);
                return;
            }
            g0().f36215i.setVisibility(0);
            g0().f36212f.setEnabled(g0().f36211e.isChecked());
            g0().f36211e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: gb.a
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                    AccountFragment.j0(AccountFragment.this, compoundButton, z10);
                }
            });
            TextView textView = g0().f36213g;
            kotlin.jvm.internal.i.e(textView, "binding.loginPrivacyText");
            fb.a.a(textView, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(AccountFragment this$0, CompoundButton compoundButton, boolean z10) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.g0().f36212f.setEnabled(z10);
    }

    private final void k0() {
        CharSequence E0;
        String string = getString(i.f32707q);
        kotlin.jvm.internal.i.e(string, "getString(R.string.captcha_sending)");
        Z(string);
        g0().f36212f.setEnabled(false);
        String obj = g0().f36209c.getText().toString();
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.CharSequence");
        E0 = u.E0(obj);
        String obj2 = E0.toString();
        this.f15678c = obj2;
        f fVar = this.f15681f;
        if (fVar != null) {
            fVar.b(this.f15677b, obj2);
        } else {
            kotlin.jvm.internal.i.u("mPresenter");
            throw null;
        }
    }

    private final void l0(String str) {
        androidx.appcompat.app.a supportActionBar = ((d) requireActivity()).getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.z(str);
        }
    }

    private final void m0(String str) {
        g0().f36216j.setVisibility(0);
        g0().f36216j.setText(str);
        g0().f36217k.setBackgroundColor(androidx.core.content.b.c(requireContext(), pa.c.f32622e));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0(String str, String str2) {
        new gb.e(requireActivity(), str, str2).show();
    }

    @Override // gb.g
    public void c(String errorMsg) {
        kotlin.jvm.internal.i.f(errorMsg, "errorMsg");
        Y();
        m0(errorMsg);
        g0().f36212f.setEnabled(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v10) {
        kotlin.jvm.internal.i.f(v10, "v");
        int id2 = v10.getId();
        if (id2 == pa.e.P) {
            lb.d.a(requireActivity(), g0().f36209c);
            androidx.navigation.fragment.a.a(this).u();
        } else if (id2 == pa.e.f32659r) {
            if (g0().f36215i.getVisibility() != 0) {
                k0();
            } else if (AccountConstant.c()) {
                if (c.p(g0().f36209c.getText().toString())) {
                    k0();
                    return;
                }
                String string = getString(i.f32698h);
                kotlin.jvm.internal.i.e(string, "getString(R.string.account_phone_format_error)");
                m0(string);
            } else if (c.m(g0().f36209c.getText().toString())) {
                k0();
            } else {
                String string2 = getString(pa.b.b(com.mobvoi.companion.base.settings.a.isOversea()));
                kotlin.jvm.internal.i.e(string2, "getString(\n                                AccountResources.getAccountFormatError(\n                                    BaseCompanionSetting.isOversea()\n                                )\n                            )");
                m0(string2);
            }
        } else if (id2 == pa.e.f32629c) {
            g0().f36209c.setText("");
            g0().f36209c.requestFocus();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.i.f(inflater, "inflater");
        this.f15683h = e.d(inflater, viewGroup, false);
        LinearLayout c10 = g0().a();
        kotlin.jvm.internal.i.e(c10, "binding.root");
        return c10;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        f fVar = this.f15681f;
        if (fVar != null) {
            fVar.unsubscribe();
        } else {
            kotlin.jvm.internal.i.u("mPresenter");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.i.f(view, "view");
        super.onViewCreated(view, bundle);
        this.f15681f = new gb.c(getActivity(), this);
        g0().f36209c.addTextChangedListener(this.f15682g);
        g0().f36212f.setOnClickListener(this);
        g0().f36214h.setOnClickListener(this);
        g0().f36208b.setOnClickListener(this);
        lb.d.b(requireActivity(), g0().f36209c);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getString(i.C));
        boolean z10 = false;
        spannableStringBuilder.setSpan(new UnderlineSpan(), 0, spannableStringBuilder.length(), 34);
        g0().f36214h.setText(spannableStringBuilder);
        g0().f36212f.setEnabled(false);
        if (AccountConstant.c() && kotlin.jvm.internal.i.b("rest_sign_up", this.f15677b)) {
            z10 = true;
        }
        g0().f36209c.setHint(pa.b.c(z10, com.mobvoi.companion.base.settings.a.isOversea()));
        i0();
    }

    @Override // gb.g
    public void x(boolean z10) {
        Y();
        h0();
        g0().f36212f.setEnabled(true);
        if (z10) {
            this.f15677b = "rest_register_third_party";
        }
        b.C0291b bVar = gb.b.f27308a;
        String str = this.f15677b;
        kotlin.jvm.internal.i.d(str);
        androidx.navigation.fragment.a.a(this).t(bVar.a(str, this.f15678c, this.f15679d, this.f15680e));
    }
}
