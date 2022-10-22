package androidx.appcompat.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.d1;
import androidx.core.app.h;
import androidx.core.app.r;
import androidx.fragment.app.f;
import androidx.lifecycle.k0;
import androidx.lifecycle.l0;
import androidx.savedstate.SavedStateRegistry;
import i.b;
/* compiled from: AppCompatActivity.java */
/* loaded from: classes.dex */
public class d extends f implements e, r.a {
    private static final String DELEGATE_TAG = "androidx:appcompat";
    private f mDelegate;
    private Resources mResources;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppCompatActivity.java */
    /* loaded from: classes.dex */
    public class a implements SavedStateRegistry.b {
        a() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.b
        public Bundle a() {
            Bundle bundle = new Bundle();
            d.this.getDelegate().x(bundle);
            return bundle;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppCompatActivity.java */
    /* loaded from: classes.dex */
    public class b implements androidx.activity.contextaware.d {
        b() {
        }

        @Override // androidx.activity.contextaware.d
        public void a(Context context) {
            f delegate = d.this.getDelegate();
            delegate.q();
            delegate.t(d.this.getSavedStateRegistry().a(d.DELEGATE_TAG));
        }
    }

    public d() {
        initDelegate();
    }

    private void initDelegate() {
        getSavedStateRegistry().d(DELEGATE_TAG, new a());
        addOnContextAvailableListener(new b());
    }

    private void initViewTreeOwners() {
        k0.a(getWindow().getDecorView(), this);
        l0.a(getWindow().getDecorView(), this);
        androidx.savedstate.d.a(getWindow().getDecorView(), this);
    }

    private boolean performMenuItemShortcut(KeyEvent keyEvent) {
        Window window;
        return Build.VERSION.SDK_INT < 26 && !keyEvent.isCtrlPressed() && !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) && keyEvent.getRepeatCount() == 0 && !KeyEvent.isModifierKey(keyEvent.getKeyCode()) && (window = getWindow()) != null && window.getDecorView() != null && window.getDecorView().dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        getDelegate().d(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(getDelegate().h(context));
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.g()) {
            super.closeOptionsMenu();
        }
    }

    @Override // androidx.core.app.f, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (keyCode != 82 || supportActionBar == null || !supportActionBar.q(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i10) {
        return (T) getDelegate().k(i10);
    }

    public f getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = f.i(this, this);
        }
        return this.mDelegate;
    }

    public androidx.appcompat.app.b getDrawerToggleDelegate() {
        return getDelegate().m();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return getDelegate().o();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.mResources == null && d1.c()) {
            this.mResources = new d1(this, super.getResources());
        }
        Resources resources = this.mResources;
        return resources == null ? super.getResources() : resources;
    }

    public androidx.appcompat.app.a getSupportActionBar() {
        return getDelegate().p();
    }

    @Override // androidx.core.app.r.a
    public Intent getSupportParentActivityIntent() {
        return h.a(this);
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        getDelegate().r();
    }

    @Override // androidx.fragment.app.f, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        getDelegate().s(configuration);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        onSupportContentChanged();
    }

    public void onCreateSupportNavigateUpTaskStack(r rVar) {
        rVar.c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getDelegate().u();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (performMenuItemShortcut(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // androidx.fragment.app.f, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.j() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i10, Menu menu) {
        return super.onMenuOpened(i10, menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNightModeChanged(int i10) {
    }

    @Override // androidx.fragment.app.f, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i10, Menu menu) {
        super.onPanelClosed(i10, menu);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        getDelegate().v(bundle);
    }

    @Override // androidx.fragment.app.f, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        getDelegate().w();
    }

    public void onPrepareSupportNavigateUpTaskStack(r rVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onStart() {
        super.onStart();
        getDelegate().y();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onStop() {
        super.onStop();
        getDelegate().z();
    }

    @Override // androidx.appcompat.app.e
    public void onSupportActionModeFinished(i.b bVar) {
    }

    @Override // androidx.appcompat.app.e
    public void onSupportActionModeStarted(i.b bVar) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (supportShouldUpRecreateTask(supportParentActivityIntent)) {
            r e10 = r.e(this);
            onCreateSupportNavigateUpTaskStack(e10);
            onPrepareSupportNavigateUpTaskStack(e10);
            e10.h();
            try {
                androidx.core.app.a.o(this);
                return true;
            } catch (IllegalStateException unused) {
                finish();
                return true;
            }
        } else {
            supportNavigateUpTo(supportParentActivityIntent);
            return true;
        }
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i10) {
        super.onTitleChanged(charSequence, i10);
        getDelegate().J(charSequence);
    }

    @Override // androidx.appcompat.app.e
    public i.b onWindowStartingSupportActionMode(b.a aVar) {
        return null;
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.r()) {
            super.openOptionsMenu();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        initViewTreeOwners();
        getDelegate().D(i10);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        getDelegate().H(toolbar);
    }

    @Deprecated
    public void setSupportProgress(int i10) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z10) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z10) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z10) {
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i10) {
        super.setTheme(i10);
        getDelegate().I(i10);
    }

    public i.b startSupportActionMode(b.a aVar) {
        return getDelegate().K(aVar);
    }

    @Override // androidx.fragment.app.f
    public void supportInvalidateOptionsMenu() {
        getDelegate().r();
    }

    public void supportNavigateUpTo(Intent intent) {
        h.e(this, intent);
    }

    public boolean supportRequestWindowFeature(int i10) {
        return getDelegate().C(i10);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return h.f(this, intent);
    }

    public d(int i10) {
        super(i10);
        initDelegate();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        initViewTreeOwners();
        getDelegate().E(view);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        getDelegate().F(view, layoutParams);
    }
}
