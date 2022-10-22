package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.contextaware.d;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.c;
import androidx.core.app.a;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.i0;
import androidx.lifecycle.j0;
import androidx.lifecycle.q;
import androidx.savedstate.SavedStateRegistry;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* compiled from: FragmentActivity.java */
/* loaded from: classes.dex */
public class f extends ComponentActivity implements a.c, a.e {
    static final String LIFECYCLE_TAG = "android:support:lifecycle";
    boolean mCreated;
    boolean mResumed;
    final i mFragments = i.b(new a());
    final q mFragmentLifecycleRegistry = new q(this);
    boolean mStopped = true;

    /* compiled from: FragmentActivity.java */
    /* loaded from: classes.dex */
    class a extends k<f> implements j0, androidx.activity.f, c, androidx.savedstate.c, q {
        public a() {
            super(f.this);
        }

        @Override // androidx.fragment.app.q
        public void a(FragmentManager fragmentManager, Fragment fragment) {
            f.this.onAttachFragment(fragment);
        }

        @Override // androidx.fragment.app.k, androidx.fragment.app.h
        public View c(int i10) {
            return f.this.findViewById(i10);
        }

        @Override // androidx.fragment.app.k, androidx.fragment.app.h
        public boolean d() {
            Window window = f.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // androidx.activity.result.c
        public ActivityResultRegistry getActivityResultRegistry() {
            return f.this.getActivityResultRegistry();
        }

        @Override // androidx.lifecycle.p
        public Lifecycle getLifecycle() {
            return f.this.mFragmentLifecycleRegistry;
        }

        @Override // androidx.activity.f
        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return f.this.getOnBackPressedDispatcher();
        }

        @Override // androidx.savedstate.c
        public SavedStateRegistry getSavedStateRegistry() {
            return f.this.getSavedStateRegistry();
        }

        @Override // androidx.lifecycle.j0
        public i0 getViewModelStore() {
            return f.this.getViewModelStore();
        }

        @Override // androidx.fragment.app.k
        public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            f.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // androidx.fragment.app.k
        public LayoutInflater j() {
            return f.this.getLayoutInflater().cloneInContext(f.this);
        }

        @Override // androidx.fragment.app.k
        public boolean l(String str) {
            return androidx.core.app.a.w(f.this, str);
        }

        @Override // androidx.fragment.app.k
        public void o() {
            f.this.supportInvalidateOptionsMenu();
        }

        /* renamed from: p */
        public f i() {
            return f.this;
        }
    }

    public f() {
        init();
    }

    private void init() {
        getSavedStateRegistry().d(LIFECYCLE_TAG, new SavedStateRegistry.b() { // from class: androidx.fragment.app.e
            @Override // androidx.savedstate.SavedStateRegistry.b
            public final Bundle a() {
                Bundle lambda$init$0;
                lambda$init$0 = f.this.lambda$init$0();
                return lambda$init$0;
            }
        });
        addOnContextAvailableListener(new d() { // from class: androidx.fragment.app.d
            @Override // androidx.activity.contextaware.d
            public final void a(Context context) {
                f.this.lambda$init$1(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle lambda$init$0() {
        markFragmentsCreated();
        this.mFragmentLifecycleRegistry.h(Lifecycle.Event.ON_STOP);
        return new Bundle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(Context context) {
        this.mFragments.a(null);
    }

    private static boolean markState(FragmentManager fragmentManager, Lifecycle.State state) {
        boolean z10 = false;
        for (Fragment fragment : fragmentManager.t0()) {
            if (fragment != null) {
                if (fragment.getHost() != null) {
                    z10 |= markState(fragment.getChildFragmentManager(), state);
                }
                a0 a0Var = fragment.mViewLifecycleOwner;
                if (a0Var != null && a0Var.getLifecycle().b().isAtLeast(Lifecycle.State.STARTED)) {
                    fragment.mViewLifecycleOwner.f(state);
                    z10 = true;
                }
                if (fragment.mLifecycleRegistry.b().isAtLeast(Lifecycle.State.STARTED)) {
                    fragment.mLifecycleRegistry.o(state);
                    z10 = true;
                }
            }
        }
        return z10;
    }

    final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.v(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (getApplication() != null) {
            androidx.loader.app.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.mFragments.t().U(str, fileDescriptor, printWriter, strArr);
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.t();
    }

    @Deprecated
    public androidx.loader.app.a getSupportLoaderManager() {
        return androidx.loader.app.a.b(this);
    }

    void markFragmentsCreated() {
        do {
        } while (markState(getSupportFragmentManager(), Lifecycle.State.CREATED));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        this.mFragments.u();
        super.onActivityResult(i10, i11, intent);
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mFragments.u();
        super.onConfigurationChanged(configuration);
        this.mFragments.d(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.h(Lifecycle.Event.ON_CREATE);
        this.mFragments.f();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i10, Menu menu) {
        if (i10 == 0) {
            return super.onCreatePanelMenu(i10, menu) | this.mFragments.g(menu, getMenuInflater());
        }
        return super.onCreatePanelMenu(i10, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.h();
        this.mFragmentLifecycleRegistry.h(Lifecycle.Event.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.i();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        if (i10 == 0) {
            return this.mFragments.k(menuItem);
        }
        if (i10 != 6) {
            return false;
        }
        return this.mFragments.e(menuItem);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z10) {
        this.mFragments.j(z10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        this.mFragments.u();
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i10, Menu menu) {
        if (i10 == 0) {
            this.mFragments.l(menu);
        }
        super.onPanelClosed(i10, menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.m();
        this.mFragmentLifecycleRegistry.h(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z10) {
        this.mFragments.n(z10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Deprecated
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i10, View view, Menu menu) {
        if (i10 == 0) {
            return onPrepareOptionsPanel(view, menu) | this.mFragments.o(menu);
        }
        return super.onPreparePanel(i10, view, menu);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        this.mFragments.u();
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        this.mFragments.u();
        super.onResume();
        this.mResumed = true;
        this.mFragments.s();
    }

    protected void onResumeFragments() {
        this.mFragmentLifecycleRegistry.h(Lifecycle.Event.ON_RESUME);
        this.mFragments.p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStart() {
        this.mFragments.u();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.c();
        }
        this.mFragments.s();
        this.mFragmentLifecycleRegistry.h(Lifecycle.Event.ON_START);
        this.mFragments.q();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.u();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.r();
        this.mFragmentLifecycleRegistry.h(Lifecycle.Event.ON_STOP);
    }

    public void setEnterSharedElementCallback(androidx.core.app.q qVar) {
        androidx.core.app.a.u(this, qVar);
    }

    public void setExitSharedElementCallback(androidx.core.app.q qVar) {
        androidx.core.app.a.v(this, qVar);
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i10) {
        startActivityFromFragment(fragment, intent, i10, (Bundle) null);
    }

    @Deprecated
    public void startIntentSenderFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) throws IntentSender.SendIntentException {
        if (i10 == -1) {
            androidx.core.app.a.y(this, intentSender, i10, intent, i11, i12, i13, bundle);
        } else {
            fragment.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        androidx.core.app.a.p(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        androidx.core.app.a.q(this);
    }

    public void supportStartPostponedEnterTransition() {
        androidx.core.app.a.z(this);
    }

    @Override // androidx.core.app.a.e
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i10) {
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i10, Bundle bundle) {
        if (i10 == -1) {
            androidx.core.app.a.x(this, intent, -1, bundle);
        } else {
            fragment.startActivityForResult(intent, i10, bundle);
        }
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    public f(int i10) {
        super(i10);
        init();
    }
}
