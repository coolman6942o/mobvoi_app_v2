package com.mobvoi.assistant.account.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.widget.NestedScrollView;
import com.mobvoi.assistant.account.AccountConstant;
import com.mobvoi.assistant.account.AccountHomeActivity;
import com.mobvoi.assistant.account.ui.login.LoginFragment;
import com.mobvoi.companion.setting.Constants;
import db.e;
import io.j;
import java.util.List;
import java.util.Objects;
import jb.k;
import jb.l;
import kotlin.text.t;
import lb.c;
import lb.d;
import pa.f;
import pa.g;
import pa.i;
/* compiled from: LoginFragment.kt */
/* loaded from: classes2.dex */
public final class LoginFragment extends com.mobvoi.companion.base.m3.b implements jb.b, View.OnClickListener, View.OnFocusChangeListener {

    /* renamed from: b  reason: collision with root package name */
    private boolean f15699b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f15700c;

    /* renamed from: d  reason: collision with root package name */
    private AccountHomeActivity f15701d;

    /* renamed from: e  reason: collision with root package name */
    private jb.a f15702e;

    /* renamed from: f  reason: collision with root package name */
    private e f15703f;

    /* renamed from: g  reason: collision with root package name */
    private final TextWatcher f15704g = new b();

    /* renamed from: h  reason: collision with root package name */
    private wa.a f15705h;

    /* compiled from: LoginFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a implements fb.b {
        a() {
        }

        @Override // fb.b
        public void a() {
            LoginFragment loginFragment = LoginFragment.this;
            String string = loginFragment.getString(i.f32715y);
            kotlin.jvm.internal.i.e(string, "getString(R.string.kid_privacy_policy)");
            loginFragment.F0("https://activities.chumenwenwen.com/vpa/tickids/privacy-policy/index.html", string);
        }

        @Override // fb.b
        public void b() {
            LoginFragment loginFragment = LoginFragment.this;
            String string = loginFragment.getString(i.M);
            kotlin.jvm.internal.i.e(string, "getString(R.string.privacy_policy)");
            loginFragment.F0("https://www.chumenwenwen.com/privacy-policy.html", string);
        }

        @Override // fb.b
        public void c() {
            LoginFragment loginFragment = LoginFragment.this;
            String string = loginFragment.getString(i.f32691a0);
            kotlin.jvm.internal.i.e(string, "getString(R.string.user_agreement)");
            loginFragment.F0("https://developer.chumenwenwen.com/agreement/", string);
        }
    }

    /* compiled from: LoginFragment.kt */
    /* loaded from: classes2.dex */
    public static final class b extends gc.i {
        b() {
        }

        @Override // gc.i, android.text.TextWatcher
        public void onTextChanged(CharSequence s10, int i10, int i11, int i12) {
            kotlin.jvm.internal.i.f(s10, "s");
            LoginFragment.this.p0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(LoginFragment this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.C0();
    }

    private final void B0(int i10) {
        androidx.navigation.fragment.a.a(this).o(i10);
    }

    private final void C0() {
        if (AccountConstant.c()) {
            String obj = q0().f36163c.getText().toString();
            if (c.p(obj)) {
                String string = getString(i.f32707q);
                kotlin.jvm.internal.i.e(string, "getString(R.string.captcha_sending)");
                Z(string);
                q0().f36176p.setEnabled(false);
                jb.a aVar = this.f15702e;
                if (aVar != null) {
                    aVar.n(obj);
                } else {
                    kotlin.jvm.internal.i.u("mLoginPresenter");
                    throw null;
                }
            } else {
                Toast.makeText(getActivity(), i.f32698h, 1).show();
            }
        }
    }

    private final void D0(CompoundButton compoundButton, boolean z10) {
        compoundButton.setText(z10 ? i.B : i.A);
        this.f15700c = z10;
        int i10 = 0;
        q0().f36176p.setVisibility(z10 ? 0 : 8);
        CheckBox checkBox = q0().f36174n;
        if (z10) {
            i10 = 8;
        }
        checkBox.setVisibility(i10);
        q0().f36163c.setText("");
        q0().f36163c.setHint(pa.b.c(z10, com.mobvoi.companion.base.settings.a.isOversea()));
        q0().f36173m.setText("");
        q0().f36173m.setHint(z10 ? i.f32706p : i.N);
        n0(compoundButton, z10);
    }

    private final void E0(String str) {
        this.f15699b = !TextUtils.isEmpty(str);
        q0().f36164d.setText(str);
        if (this.f15699b) {
            q0().f36167g.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F0(String str, String str2) {
        new gb.e(requireActivity(), str, str2).show();
    }

    private final void G0() {
        Context requireContext = requireContext();
        kotlin.jvm.internal.i.e(requireContext, "requireContext()");
        if (s0(requireContext)) {
            AccountHomeActivity accountHomeActivity = this.f15701d;
            if (accountHomeActivity != null) {
                d.a(accountHomeActivity, getView());
                String string = getString(i.D);
                kotlin.jvm.internal.i.e(string, "getString(R.string.logining)");
                Z(string);
                q0().f36167g.setEnabled(false);
                String obj = q0().f36163c.getText().toString();
                String obj2 = q0().f36173m.getText().toString();
                jb.a aVar = this.f15702e;
                if (aVar != null) {
                    aVar.l(this.f15700c, obj, obj2);
                } else {
                    kotlin.jvm.internal.i.u("mLoginPresenter");
                    throw null;
                }
            } else {
                kotlin.jvm.internal.i.u("mActivity");
                throw null;
            }
        }
    }

    private final void k0() {
        final String str;
        final String str2;
        e eVar = this.f15703f;
        if (eVar != null) {
            List<db.c> a10 = eVar.a();
            LinearLayout linearLayout = q0().f36168h;
            kotlin.jvm.internal.i.e(linearLayout, "binding.loginGroup");
            LinearLayout linearLayout2 = q0().f36175o;
            kotlin.jvm.internal.i.e(linearLayout2, "binding.thirdPartyTitle");
            e eVar2 = this.f15703f;
            if (eVar2 == null) {
                kotlin.jvm.internal.i.u("mLoginMgr");
                throw null;
            } else if (eVar2.h()) {
                linearLayout.setVisibility(0);
                linearLayout2.setVisibility(0);
                int size = a10.size() - 1;
                if (size >= 0) {
                    int i10 = 0;
                    while (true) {
                        int i11 = i10 + 1;
                        db.c cVar = a10.get(i10);
                        if (cVar != null) {
                            View inflate = LayoutInflater.from(getActivity()).inflate(f.f32682f, (ViewGroup) linearLayout, false);
                            Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
                            ViewGroup viewGroup = (ViewGroup) inflate;
                            ((ImageView) viewGroup.findViewById(pa.e.f32636f0)).setImageResource(cVar.a());
                            viewGroup.setTag(cVar);
                            viewGroup.setOnClickListener(this);
                            linearLayout.addView(viewGroup);
                        }
                        if (i11 > size) {
                            break;
                        }
                        i10 = i11;
                    }
                }
                if (com.mobvoi.companion.base.settings.a.isOversea()) {
                    if (c.d()) {
                        str2 = "https://www.mobvoi.com/tw/pages/terms-of-service";
                        str = "https://www.mobvoi.com/tw/pages/privacy-policy";
                    } else {
                        str2 = Constants.TERMS_URL;
                        str = Constants.PRIVACY_URL;
                    }
                    RelativeLayout relativeLayout = q0().f36169i;
                    kotlin.jvm.internal.i.e(relativeLayout, "binding.loginPrivacy");
                    View inflate2 = LayoutInflater.from(getActivity()).inflate(f.f32687k, (ViewGroup) relativeLayout, false);
                    inflate2.findViewById(pa.e.f32648l0).setOnClickListener(new View.OnClickListener() { // from class: jb.f
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            LoginFragment.l0(LoginFragment.this, str, view);
                        }
                    });
                    inflate2.findViewById(pa.e.f32654o0).setOnClickListener(new View.OnClickListener() { // from class: jb.g
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            LoginFragment.m0(LoginFragment.this, str2, view);
                        }
                    });
                    relativeLayout.addView(inflate2);
                    q0().f36166f.setVisibility(8);
                    return;
                }
                q0().f36169i.setVisibility(8);
                q0().f36166f.setVisibility(0);
                TextView textView = q0().f36172l;
                kotlin.jvm.internal.i.e(textView, "binding.loginPrivacyText");
                textView.setVisibility(0);
                fb.a.a(textView, new a());
            } else {
                linearLayout.setVisibility(8);
                linearLayout2.setVisibility(8);
            }
        } else {
            kotlin.jvm.internal.i.u("mLoginMgr");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(LoginFragment this$0, String privacyPolicyUrl, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(privacyPolicyUrl, "$privacyPolicyUrl");
        String string = this$0.getString(i.M);
        kotlin.jvm.internal.i.e(string, "getString(\n                            R.string.privacy_policy\n                        )");
        this$0.F0(privacyPolicyUrl, string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(LoginFragment this$0, String userAgreementUrl, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(userAgreementUrl, "$userAgreementUrl");
        String string = this$0.getString(i.f32691a0);
        kotlin.jvm.internal.i.e(string, "getString(\n                            R.string.user_agreement\n                        )");
        this$0.F0(userAgreementUrl, string);
    }

    private final void n0(CompoundButton compoundButton, boolean z10) {
        if (z10) {
            q0().f36173m.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            q0().f36173m.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        q0().f36173m.setSelection(q0().f36173m.getText().length());
    }

    private final boolean o0() {
        String obj = q0().f36163c.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            AccountHomeActivity accountHomeActivity = this.f15701d;
            if (accountHomeActivity != null) {
                E0(accountHomeActivity.getString(pa.b.a(com.mobvoi.companion.base.settings.a.isOversea())));
                return false;
            }
            kotlin.jvm.internal.i.u("mActivity");
            throw null;
        } else if (!c.m(obj)) {
            AccountHomeActivity accountHomeActivity2 = this.f15701d;
            if (accountHomeActivity2 != null) {
                E0(accountHomeActivity2.getString(pa.b.b(com.mobvoi.companion.base.settings.a.isOversea())));
                return false;
            }
            kotlin.jvm.internal.i.u("mActivity");
            throw null;
        } else {
            E0("");
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0() {
        q0().f36177q.setText("");
        q0().f36167g.setEnabled(!TextUtils.isEmpty(q0().f36163c.getText()) && !TextUtils.isEmpty(q0().f36173m.getText()) && !this.f15699b);
    }

    private final wa.a q0() {
        wa.a aVar = this.f15705h;
        kotlin.jvm.internal.i.d(aVar);
        return aVar;
    }

    private final void r0(Context context, View view) {
        boolean p10;
        p10 = t.p(Build.MANUFACTURER, "huawei", true);
        if (p10) {
            View findFocus = view == null ? null : view.findFocus();
            if (findFocus instanceof EditText) {
                EditText editText = (EditText) findFocus;
                if (editText.getInputType() == 129 || editText.getInputType() == 144) {
                    AccountHomeActivity accountHomeActivity = this.f15701d;
                    if (accountHomeActivity != null) {
                        d.a(accountHomeActivity, findFocus);
                    } else {
                        kotlin.jvm.internal.i.u("mActivity");
                        throw null;
                    }
                }
            }
        }
    }

    private final boolean s0(final Context context) {
        boolean z10 = com.mobvoi.companion.base.settings.a.isOversea() || q0().f36170j.isChecked();
        if (!z10) {
            q0().f36170j.post(new Runnable() { // from class: jb.j
                @Override // java.lang.Runnable
                public final void run() {
                    LoginFragment.t0(LoginFragment.this, context);
                }
            });
            Toast makeText = Toast.makeText(context, i.P, 0);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(LoginFragment this$0, Context context) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(context, "$context");
        this$0.r0(context, this$0.getView());
    }

    private final void u0() {
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            q0().f36163c.setText(arguments == null ? null : arguments.getString("extra_account", ""));
            AccountHomeActivity accountHomeActivity = this.f15701d;
            if (accountHomeActivity != null) {
                d.b(accountHomeActivity, q0().f36173m);
            } else {
                kotlin.jvm.internal.i.u("mActivity");
                throw null;
            }
        } else {
            String m10 = ta.a.m();
            if (!TextUtils.isEmpty(m10)) {
                q0().f36163c.setText(m10);
                q0().f36163c.setSelection(q0().f36163c.getText().length());
            }
            q0().f36163c.requestFocus();
        }
        q0().f36167g.setEnabled(false);
    }

    private final void v0(View view) {
        k0();
        q0().f36163c.setHint(pa.b.c(false, com.mobvoi.companion.base.settings.a.isOversea()));
        q0().f36171k.setOnClickListener(new View.OnClickListener() { // from class: jb.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LoginFragment.w0(LoginFragment.this, view2);
            }
        });
        q0().f36178r.setOnClickListener(this);
        q0().f36163c.setOnFocusChangeListener(this);
        q0().f36173m.setOnFocusChangeListener(this);
        q0().f36162b.setOnClickListener(this);
        q0().f36163c.addTextChangedListener(this.f15704g);
        q0().f36173m.addTextChangedListener(this.f15704g);
        q0().f36167g.setOnClickListener(new View.OnClickListener() { // from class: jb.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LoginFragment.x0(LoginFragment.this, view2);
            }
        });
        q0().f36165e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: jb.i
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                LoginFragment.y0(LoginFragment.this, compoundButton, z10);
            }
        });
        q0().f36174n.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: jb.h
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                LoginFragment.z0(LoginFragment.this, compoundButton, z10);
            }
        });
        q0().f36176p.setOnClickListener(new View.OnClickListener() { // from class: jb.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LoginFragment.A0(LoginFragment.this, view2);
            }
        });
        if (com.mobvoi.companion.base.settings.a.isOversea()) {
            q0().f36165e.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(LoginFragment this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.q0().f36170j.setChecked(!this$0.q0().f36170j.isChecked());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(LoginFragment this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.G0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(LoginFragment this$0, CompoundButton buttonView, boolean z10) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(buttonView, "buttonView");
        this$0.D0(buttonView, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(LoginFragment this$0, CompoundButton buttonView, boolean z10) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(buttonView, "buttonView");
        this$0.n0(buttonView, z10);
    }

    @Override // jb.b
    public void G() {
        Y();
        q0().f36176p.j();
    }

    @Override // jb.b
    public void O(String type, String uid) {
        kotlin.jvm.internal.i.f(type, "type");
        kotlin.jvm.internal.i.f(uid, "uid");
        Y();
        q0().f36177q.setText("");
        q0().f36167g.setEnabled(true);
        androidx.navigation.fragment.a.a(this).t(k.f29492a.a("rest_bind_third_party", type, uid));
    }

    @Override // jb.b
    public void W() {
        String string = getString(i.D);
        kotlin.jvm.internal.i.e(string, "getString(R.string.logining)");
        Z(string);
        q0().f36167g.setEnabled(false);
    }

    @Override // jb.b
    public void a() {
        AccountHomeActivity accountHomeActivity = this.f15701d;
        if (accountHomeActivity != null) {
            d.a(accountHomeActivity, q0().f36163c);
            AccountHomeActivity accountHomeActivity2 = this.f15701d;
            if (accountHomeActivity2 != null) {
                d.a(accountHomeActivity2, q0().f36173m);
                b1.a.b(com.mobvoi.android.common.utils.b.e()).d(new Intent("action.LOGIN_SUCCESS"));
                Y();
                Toast.makeText(getActivity(), i.f32716z, 0).show();
                q0().f36167g.setEnabled(true);
                AccountHomeActivity accountHomeActivity3 = this.f15701d;
                if (accountHomeActivity3 != null) {
                    accountHomeActivity3.H();
                    Intent intent = new Intent();
                    intent.putExtra("token", ta.a.s());
                    AccountHomeActivity accountHomeActivity4 = this.f15701d;
                    if (accountHomeActivity4 != null) {
                        accountHomeActivity4.setResult(-1, intent);
                        AccountHomeActivity accountHomeActivity5 = this.f15701d;
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

    @Override // jb.b
    public void b(String errorMsg) {
        kotlin.jvm.internal.i.f(errorMsg, "errorMsg");
        Y();
        q0().f36177q.setText(errorMsg);
        q0().f36167g.setEnabled(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        jb.a aVar = this.f15702e;
        if (aVar != null) {
            aVar.a(i10, i11, intent);
        } else {
            kotlin.jvm.internal.i.u("mLoginPresenter");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        super.onAttach(context);
        if (context instanceof AccountHomeActivity) {
            this.f15701d = (AccountHomeActivity) context;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v10) {
        kotlin.jvm.internal.i.f(v10, "v");
        int id2 = v10.getId();
        if (id2 == pa.e.f32629c) {
            q0().f36163c.setText("");
            q0().f36163c.requestFocus();
        } else if (id2 == pa.e.f32652n0) {
            androidx.navigation.fragment.a.a(this).p(pa.e.f32641i, g0.b.a(j.a("extra_rest_type", "rest_reset_pwd")));
        }
        Object tag = v10.getTag();
        if (tag instanceof db.c) {
            Context requireContext = requireContext();
            kotlin.jvm.internal.i.e(requireContext, "requireContext()");
            if (s0(requireContext)) {
                jb.a aVar = this.f15702e;
                if (aVar != null) {
                    aVar.c(((db.c) tag).b());
                } else {
                    kotlin.jvm.internal.i.u("mLoginPresenter");
                    throw null;
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        Object a10 = kc.b.b().a(e.class);
        kotlin.jvm.internal.i.e(a10, "getSingleton().getInstance(ThirdPartyLoginManager::class.java)");
        this.f15703f = (e) a10;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        kotlin.jvm.internal.i.f(menu, "menu");
        kotlin.jvm.internal.i.f(inflater, "inflater");
        inflater.inflate(g.f32688a, menu);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.i.f(inflater, "inflater");
        this.f15705h = wa.a.d(inflater, viewGroup, false);
        NestedScrollView c10 = q0().a();
        kotlin.jvm.internal.i.e(c10, "binding.root");
        return c10;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        jb.a aVar = this.f15702e;
        if (aVar != null) {
            aVar.unsubscribe();
        } else {
            kotlin.jvm.internal.i.u("mLoginPresenter");
            throw null;
        }
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View v10, boolean z10) {
        kotlin.jvm.internal.i.f(v10, "v");
        int id2 = v10.getId();
        if (id2 == pa.e.f32631d) {
            if (z10) {
                E0("");
            }
        } else if (id2 == pa.e.f32626a0 && z10) {
            o0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem item) {
        kotlin.jvm.internal.i.f(item, "item");
        if (item.getItemId() != pa.e.f32630c0) {
            return super.onOptionsItemSelected(item);
        }
        B0(pa.e.f32645k);
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.i.f(view, "view");
        super.onViewCreated(view, bundle);
        this.f15702e = new l(this, this);
        v0(view);
        u0();
    }

    @Override // jb.b
    public void z(String errMsg) {
        kotlin.jvm.internal.i.f(errMsg, "errMsg");
        Y();
        Toast.makeText(com.mobvoi.android.common.utils.b.e(), errMsg, 0).show();
        q0().f36176p.setEnabled(true);
    }
}
