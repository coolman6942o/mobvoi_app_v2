package com.mobvoi.mcuwatch.ui.search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.a;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.w;
import com.mobvoi.assistant.account.ui.login.LoginFragment;
import com.mobvoi.companion.base.m3.d;
import ei.h;
import pa.e;
import sh.i;
import sh.k;
/* loaded from: classes2.dex */
public class SearchActivity extends d {
    public static void start(Context context) {
        context.startActivity(new Intent(context, SearchActivity.class));
    }

    public void H(Fragment fragment) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (fragment instanceof LoginFragment) {
            supportFragmentManager.a1(null, 1);
        }
        w l10 = supportFragmentManager.l();
        l10.s(e.f32671x, fragment);
        l10.h(null);
        l10.j();
    }

    public void I(String str) {
        if ("key_navigation".equals(str)) {
            H(new e());
        } else if ("key_scan".equals(str)) {
            H(new SearchFragment());
        }
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return i.B;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 1) {
            getFragmentManager().popBackStack();
        } else {
            a.p(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h.a().c(this);
        setTitle(k.Y2);
        String stringExtra = getIntent().getStringExtra("type");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "key_navigation";
        }
        I(stringExtra);
    }
}
