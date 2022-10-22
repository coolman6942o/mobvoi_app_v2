package com.mobvoi.companion.aw.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.d;
import com.mobvoi.android.common.utils.k;
/* compiled from: BaseActivity.java */
/* loaded from: classes2.dex */
public abstract class a extends d {
    protected abstract void G();

    protected void H() {
        k.a("BaseActivity", "onLoginFailed: failure");
    }

    protected void I() {
        k.a("BaseActivity", "onLoginSuccess: success");
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 != 1000) {
            return;
        }
        if (i11 == -1) {
            I();
        } else {
            H();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(getLayoutId());
        G();
        initView();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        k.d("BaseActivity", "onOptionsItemSelected : android.R.id.home");
        onBackPressed();
        return true;
    }
}
