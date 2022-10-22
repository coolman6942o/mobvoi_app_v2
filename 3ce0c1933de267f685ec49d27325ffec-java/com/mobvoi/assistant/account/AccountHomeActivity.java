package com.mobvoi.assistant.account;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.m;
import androidx.navigation.p;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.WearableUiUtils;
import com.mobvoi.companion.base.m3.d;
import d1.c;
import d1.d;
import db.e;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kc.b;
import kotlin.collections.i0;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import pa.h;
/* compiled from: AccountHomeActivity.kt */
/* loaded from: classes2.dex */
public final class AccountHomeActivity extends d {

    /* renamed from: a  reason: collision with root package name */
    private Intent f15618a;

    /* renamed from: b  reason: collision with root package name */
    private e f15619b;

    /* renamed from: c  reason: collision with root package name */
    private d1.d f15620c;

    /* compiled from: AccountHomeActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    public AccountHomeActivity() {
        Set b10;
        b10 = i0.b();
        d1.d a10 = new d.b(b10).c(null).b(new pa.a(AccountHomeActivity$special$$inlined$AppBarConfiguration$default$1.INSTANCE)).a();
        i.c(a10, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
        this.f15620c = a10;
    }

    public final void H() {
        Intent intent = this.f15618a;
        if (intent != null) {
            startActivity(intent);
        }
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return pa.f.f32678b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        Fragment f02 = getSupportFragmentManager().f0(pa.e.f32627b);
        Objects.requireNonNull(f02, "null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment");
        List<Fragment> t02 = ((NavHostFragment) f02).getChildFragmentManager().t0();
        i.e(t02, "navHostFragment.childFragmentManager.fragments");
        if (!t02.isEmpty()) {
            t02.get(0).onActivityResult(i10, i11, intent);
        } else {
            k.d("AccountHomeActivity", "onActivityResult can not find content_frame fragment.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Object a10 = b.b().a(e.class);
        i.e(a10, "getSingleton().getInstance(ThirdPartyLoginManager::class.java)");
        this.f15619b = (e) a10;
        Intent intent = getIntent();
        if (intent == null) {
            k.d("AccountHomeActivity", "No intent extra specific, nothing to do.");
            setResult(0);
            finish();
            return;
        }
        String stringExtra = intent.getStringExtra("key_type");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "key_login";
        }
        this.f15618a = (Intent) intent.getParcelableExtra(WearableUiUtils.FOLLOW_INTENT);
        e eVar = this.f15619b;
        if (eVar != null) {
            if (eVar.h()) {
                e eVar2 = this.f15619b;
                if (eVar2 != null) {
                    eVar2.c(this);
                } else {
                    i.u("mLoginMgr");
                    throw null;
                }
            }
            NavController a11 = androidx.navigation.a.a(this, pa.e.f32627b);
            p l10 = a11.l();
            i.e(l10, "navController.navInflater");
            Bundle bundle2 = new Bundle();
            if (i.b(stringExtra, "key_profile")) {
                m c10 = l10.c(h.f32689a);
                c10.A(pa.e.R);
                io.m mVar = io.m.f28349a;
                a11.E(c10);
            } else if (i.b(stringExtra, "key_change_password")) {
                bundle2.putString("extra_rest_type", "rest_change_pwd");
                m c11 = l10.c(h.f32689a);
                c11.A(pa.e.f32625a);
                io.m mVar2 = io.m.f28349a;
                a11.F(c11, bundle2);
            } else {
                m c12 = l10.c(h.f32689a);
                c12.A(pa.e.I);
                io.m mVar3 = io.m.f28349a;
                a11.E(c12);
            }
            c.a(this, a11, this.f15620c);
            return;
        }
        i.u("mLoginMgr");
        throw null;
    }

    @Override // com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d
    public boolean onSupportNavigateUp() {
        return d1.e.a(androidx.navigation.a.a(this, pa.e.f32627b), this.f15620c) || super.onSupportNavigateUp();
    }
}
