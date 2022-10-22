package com.mobvoi.companion.aw.ui.main;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.c;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import androidx.lifecycle.h0;
import androidx.lifecycle.x;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mobvoi.android.common.ui.widget.c;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.m;
import com.mobvoi.assistant.account.AccountConstant;
import com.mobvoi.assistant.account.tab.webview.OverseaBrowserActivity;
import com.mobvoi.companion.TicwearUiUtils;
import com.mobvoi.companion.aw.R;
import com.mobvoi.companion.aw.StartEntry;
import com.mobvoi.companion.aw.base.App;
import com.mobvoi.companion.device.PiiAlterActivity;
import com.mobvoi.companion.health.MainViewModel;
import com.mobvoi.companion.setting.Constants;
import java.util.ArrayList;
import java.util.List;
import jc.a;
import ra.h;
import rx.i;
import sa.g;
import vb.a;
import ya.v;
import yd.j;
import yd.p;
/* loaded from: classes2.dex */
public class HomeActivity extends com.mobvoi.companion.aw.ui.main.d implements a.b {

    /* renamed from: d  reason: collision with root package name */
    private ViewPager f16273d;

    /* renamed from: e  reason: collision with root package name */
    private BottomNavigationView f16274e;

    /* renamed from: g  reason: collision with root package name */
    private jc.a f16276g;

    /* renamed from: h  reason: collision with root package name */
    private List<Fragment> f16277h;

    /* renamed from: i  reason: collision with root package name */
    private Fragment f16278i;

    /* renamed from: j  reason: collision with root package name */
    private ge.b f16279j;

    /* renamed from: k  reason: collision with root package name */
    private Fragment f16280k;

    /* renamed from: n  reason: collision with root package name */
    public nc.d f16283n;

    /* renamed from: f  reason: collision with root package name */
    private boolean f16275f = lb.c.d();

    /* renamed from: l  reason: collision with root package name */
    private dq.b f16281l = new dq.b();

    /* renamed from: m  reason: collision with root package name */
    private BroadcastReceiver f16282m = new a();

    /* loaded from: classes2.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (TextUtils.equals(action, "action.TOKEN_INVALID")) {
                aa.c.d(HomeActivity.this.getString(R.string.account_expired));
                vb.a.a(HomeActivity.this);
            } else if (TextUtils.equals(action, "android.net.conn.CONNECTIVITY_CHANGE")) {
                m.b(App.d());
            } else if (TextUtils.equals(action, "action.REGION_CHANGE")) {
                HomeActivity.this.v0();
            } else if (TextUtils.equals(action, "action.LOGIN_SUCCESS")) {
                HomeActivity.this.r0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements a.AbstractC0354a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ jc.a f16285a;

        b(jc.a aVar) {
            this.f16285a = aVar;
        }

        @Override // jc.a.AbstractC0354a
        public void a() {
            this.f16285a.dismiss();
            ta.a.G(true);
            ta.a.O(true);
            com.mobvoi.assistant.account.data.a.v().e(ta.a.e());
            HomeActivity.this.B0(true);
        }

        @Override // jc.a.AbstractC0354a
        public void onCancel() {
            this.f16285a.dismiss();
            ta.a.G(false);
            HomeActivity.this.B0(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c extends i<sa.c> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f16287a;

        c(HomeActivity homeActivity, boolean z10) {
            this.f16287a = z10;
        }

        /* renamed from: b */
        public void onNext(sa.c cVar) {
            if (cVar.b()) {
                k.a("HomeActivity", "pii modify success: " + this.f16287a);
                ta.a.G(this.f16287a);
                return;
            }
            k.a("HomeActivity", "pii modify failed: " + this.f16287a);
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            k.e("HomeActivity", "modify fail", th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            yd.i.a().d("show_download", Boolean.FALSE);
            if (yd.b.c(HomeActivity.this)) {
                TicwearUiUtils.AndroidWear.openPlayStore(HomeActivity.this, "com.mobvoi.companion.ai");
            } else {
                TicwearUiUtils.AndroidWear.openUrl(HomeActivity.this, "https://mushroom.mobvoi.com/api/qrdownload/smart_companion");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e extends r {
        e(FragmentManager fragmentManager, int i10) {
            super(fragmentManager, i10);
        }

        @Override // androidx.viewpager.widget.a
        public int d() {
            return HomeActivity.this.f16277h.size();
        }

        @Override // androidx.fragment.app.r
        public Fragment t(int i10) {
            return (Fragment) HomeActivity.this.f16277h.get(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f extends ViewPager.m {
        f() {
        }

        @Override // androidx.viewpager.widget.ViewPager.m, androidx.viewpager.widget.ViewPager.j
        public void v(int i10) {
            super.v(i10);
            HomeActivity.this.C0(i10);
            HomeActivity.this.f16274e.getMenu().getItem(i10).setChecked(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f16291a;

        g(String str) {
            this.f16291a = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            OverseaBrowserActivity.J(HomeActivity.this, this.f16291a);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setAntiAlias(true);
            textPaint.setUnderlineText(false);
            textPaint.setColor(HomeActivity.this.getResources().getColor(R.color.color_mobvoi_primary_dark));
        }
    }

    private void A0() {
        startActivity(new Intent(this, PiiAlterActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(int i10) {
        int i11 = 0;
        if (i10 != 0) {
            i11 = j7.a.b(this, R.attr.colorSurface, 0);
        }
        getWindow().setStatusBarColor(i11);
    }

    private void b0() {
        this.f16281l.a(com.mobvoi.assistant.account.data.a.v().z(ta.a.s(), true).Z(h.a().b()).H(h.a().a()).Y(l.f16310a, m.f16311a));
    }

    private boolean c0() {
        return !TextUtils.isEmpty(ta.a.d()) && !TextUtils.isEmpty(ta.a.s());
    }

    private void d0() {
        this.f16281l.a(com.mobvoi.assistant.account.data.a.v().j(ta.a.s(), com.mobvoi.android.common.utils.e.e(this), AccountConstant.a()).Z(h.a().b()).H(h.a().a()).Y(new yp.b() { // from class: com.mobvoi.companion.aw.ui.main.k
            @Override // yp.b
            public final void call(Object obj) {
                HomeActivity.this.j0((g) obj);
            }
        }, n.f16312a));
    }

    private ClickableSpan f0(String str) {
        return new g(str);
    }

    private void hideLoadingDialog() {
        jc.a aVar = this.f16276g;
        if (aVar != null && aVar.isShowing()) {
            this.f16276g.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(sa.g gVar) {
        if (gVar.b() && !sa.a.a(gVar.result).agree) {
            z0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean l0(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.navigation_account) {
            C0(2);
            this.f16273d.R(this.f16277h.indexOf(this.f16280k), false);
        } else if (itemId == R.id.navigation_device) {
            C0(1);
            this.f16273d.R(this.f16277h.indexOf(this.f16279j), false);
        } else if (itemId == R.id.navigation_home) {
            C0(0);
            this.f16273d.R(this.f16277h.indexOf(this.f16278i), false);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(Boolean bool) {
        this.f16274e.getMenu().getItem(0).setVisible(bool.booleanValue());
        if (bool.booleanValue()) {
            w0(0);
        } else {
            w0(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n0(View view) {
        yd.i.a().d("show_download", Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(View view) {
        A0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(androidx.appcompat.app.c cVar, View view) {
        cVar.dismiss();
        b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        b1.a.b(App.d()).d(new Intent("action.LOGIN"));
        if (this.f16275f != lb.c.d()) {
            this.f16275f = lb.c.d();
            v0();
        }
        ((v) this.f16280k).a0();
        this.f16279j.a0();
        d0();
        this.f16283n.f();
        p.f();
        p.e();
        j.f37016a.a();
    }

    private static String s0(int i10, long j10) {
        return "android:switcher:" + i10 + ":" + j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0() {
        Intent intent = getIntent();
        intent.addFlags(67108864);
        finish();
        startActivity(intent);
    }

    private void w0(int i10) {
        if (this.f16273d != null && this.f16277h != null && this.f16279j != null && this.f16278i != null) {
            C0(i10);
            if (i10 == 0) {
                this.f16273d.R(this.f16277h.indexOf(this.f16278i), false);
            } else if (i10 == 1) {
                this.f16273d.R(this.f16277h.indexOf(this.f16279j), false);
            }
        }
    }

    private void x0() {
        if (TextUtils.isEmpty(ta.a.x())) {
            yd.i.a().d("show_download", Boolean.FALSE);
        } else if (((Boolean) yd.i.a().c("show_download", Boolean.TRUE)).booleanValue()) {
            new c.b(this).f(R.string.permission_request_title).c(yd.b.c(this) ? R.string.h_res_0x7f1403c7 : R.string.g_res_0x7f1403c6).b(R.string.f_res_0x7f1403c5).a(R.string.res_0x7f140273_common_gotit).e(new d()).d(com.mobvoi.companion.aw.ui.main.g.f16305a).g();
        }
    }

    private void y0() {
        jc.a aVar = new jc.a(this);
        View inflate = LayoutInflater.from(this).inflate(R.layout.wearable_pii_alert_dialog, (ViewGroup) null);
        inflate.findViewById(R.id.more_detail).setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.aw.ui.main.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeActivity.this.o0(view);
            }
        });
        aVar.e(inflate);
        aVar.setCancelable(true);
        aVar.c(getString(R.string.pii_dialog_disagree), getString(R.string.res_0x7f140267_common_agree));
        aVar.d(new b(aVar));
        aVar.show();
    }

    private void z0() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.dialog_privacy, (ViewGroup) null, false);
        final androidx.appcompat.app.c a10 = new c.a(this).s(inflate).a();
        TextView textView = (TextView) inflate.findViewById(R.id.tv_dialog_title);
        final TextView textView2 = (TextView) inflate.findViewById(R.id.tv_agree);
        String string = getString(R.string.dialog_privacy_title);
        int indexOf = string.indexOf("Privacy Policy");
        int indexOf2 = string.indexOf("Terms of Service");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        spannableStringBuilder.setSpan(f0(Constants.PRIVACY_URL), indexOf, indexOf + 14, 17);
        spannableStringBuilder.setSpan(f0(Constants.TERMS_URL), indexOf2, indexOf2 + 16, 17);
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(getResources().getColor(17170445));
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.aw.ui.main.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeActivity.this.p0(a10, view);
            }
        });
        ((CheckBox) inflate.findViewById(R.id.check_agree)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.mobvoi.companion.aw.ui.main.h
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                textView2.setEnabled(z10);
            }
        });
        a10.setCancelable(false);
        a10.show();
    }

    public void B0(boolean z10) {
        com.mobvoi.assistant.account.data.a.v().f(ta.a.s(), z10).Z(cq.a.c()).H(xp.a.b()).V(new c(this, z10));
    }

    public Fragment e0(int i10) {
        return getSupportFragmentManager().g0(s0(this.f16273d.getId(), i10));
    }

    protected void g0() {
        this.f16273d = (ViewPager) findViewById(R.id.viewpager_home);
        this.f16274e = (BottomNavigationView) findViewById(R.id.navigation);
        k.c("HomeActivity", "isTaiwanRegion %b ", Boolean.valueOf(this.f16275f));
        com.google.android.gms.common.b.q().r(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action.TOKEN_INVALID");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("action.REGION_CHANGE");
        intentFilter.addAction("action.LOGIN_SUCCESS");
        b1.a.b(App.d()).c(this.f16282m, intentFilter);
        this.f16277h = new ArrayList();
        Fragment e02 = e0(0);
        this.f16278i = e02;
        if (e02 == null) {
            this.f16278i = new com.mobvoi.companion.aw.ui.main.c();
        }
        this.f16277h.add(this.f16278i);
        ge.b bVar = (ge.b) e0(1);
        this.f16279j = bVar;
        if (bVar == null) {
            this.f16279j = new ge.b();
        }
        this.f16277h.add(this.f16279j);
        Fragment e03 = e0(2);
        this.f16280k = e03;
        if (e03 == null) {
            this.f16280k = v.T0();
        }
        this.f16277h.add(this.f16280k);
        if (c0()) {
            d0();
        }
    }

    protected void initView() {
        this.f16273d.setAdapter(new e(getSupportFragmentManager(), 1));
        this.f16273d.setOffscreenPageLimit(this.f16277h.size() - 1);
        this.f16274e.setOnNavigationItemSelectedListener(new BottomNavigationView.c() { // from class: com.mobvoi.companion.aw.ui.main.j
            @Override // com.google.android.material.navigation.NavigationBarView.c
            public final boolean a(MenuItem menuItem) {
                boolean l02;
                l02 = HomeActivity.this.l0(menuItem);
                return l02;
            }
        });
        this.f16273d.c(new f());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 != 1000) {
            return;
        }
        if (i11 == -1) {
            u0();
        } else {
            t0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_home);
        yd.d.c(this, j7.a.f(j7.a.b(this, 16842801, -16777216)));
        g0();
        initView();
        this.f16274e.setItemIconTintList(null);
        MainViewModel mainViewModel = (MainViewModel) new h0(this).a(MainViewModel.class);
        mainViewModel.W().i(this, new x() { // from class: com.mobvoi.companion.aw.ui.main.i
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                HomeActivity.this.m0((Boolean) obj);
            }
        });
        mainViewModel.v0();
        p.f();
        p.e();
        j.f37016a.a();
        if (!ta.a.b() && c0()) {
            y0();
        }
        x0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f16281l.b();
        b1.a.b(App.d()).e(this.f16282m);
    }

    @Override // androidx.appcompat.app.d, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // vb.a.b
    public void onLogOutIng() {
        if (this.f16276g == null) {
            jc.a aVar = new jc.a(this);
            this.f16276g = aVar;
            aVar.f(R.string.logout_ing);
        }
        if (!this.f16276g.isShowing()) {
            this.f16276g.show();
        }
    }

    @Override // vb.a.b
    public void onLogoutFailure() {
        hideLoadingDialog();
        Toast.makeText(App.d(), (int) R.string.logout_fail, 0).show();
    }

    @Override // vb.a.b
    public void onLogoutSuccess() {
        ((db.e) kc.b.b().a(db.e.class)).k();
        hideLoadingDialog();
        Toast.makeText(App.d(), (int) R.string.logout_success, 0).show();
        b1.a.b(App.d()).d(new Intent("action.LOGOUT"));
        xb.a.a();
        startActivity(new Intent(this, StartEntry.class));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        k.a("HomeActivity", "onNewIntent");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onPause() {
        super.onPause();
        sb.a.h(this, "HomeActivity");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        sb.a.i(this, "HomeActivity");
        com.google.android.gms.common.b.q().r(this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
    }

    protected void t0() {
        k.a("HomeActivity", "onLoginFailed: failure");
    }

    protected void u0() {
        k.a("HomeActivity", "onLoginSuccess: success");
    }
}
