package androidx.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.core.app.f;
import androidx.core.view.l;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.a0;
import androidx.lifecycle.c0;
import androidx.lifecycle.h0;
import androidx.lifecycle.i0;
import androidx.lifecycle.j;
import androidx.lifecycle.j0;
import androidx.lifecycle.k0;
import androidx.lifecycle.l0;
import androidx.lifecycle.n;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.savedstate.SavedStateRegistry;
import c.a;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ComponentActivity extends f implements androidx.activity.contextaware.a, j0, j, androidx.savedstate.c, f, androidx.activity.result.c {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final ActivityResultRegistry mActivityResultRegistry;
    private int mContentLayoutId;
    final androidx.activity.contextaware.b mContextAwareHelper;
    private h0.b mDefaultFactory;
    private final q mLifecycleRegistry;
    private final l mMenuHostHelper;
    private final AtomicInteger mNextLocalRequestCode;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    final androidx.savedstate.b mSavedStateRegistryController;
    private i0 mViewModelStore;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ComponentActivity.super.onBackPressed();
            } catch (IllegalStateException e10) {
                if (!TextUtils.equals(e10.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e10;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    class b extends ActivityResultRegistry {

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f295a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ a.C0080a f296b;

            a(int i10, a.C0080a aVar) {
                this.f295a = i10;
                this.f296b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.c(this.f295a, this.f296b.a());
            }
        }

        /* renamed from: androidx.activity.ComponentActivity$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0004b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f298a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ IntentSender.SendIntentException f299b;

            RunnableC0004b(int i10, IntentSender.SendIntentException sendIntentException) {
                this.f298a = i10;
                this.f299b = sendIntentException;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.b(this.f298a, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.f299b));
            }
        }

        b() {
        }

        @Override // androidx.activity.result.ActivityResultRegistry
        public <I, O> void f(int i10, c.a<I, O> aVar, I i11, androidx.core.app.b bVar) {
            ComponentActivity componentActivity = ComponentActivity.this;
            a.C0080a<O> b10 = aVar.b(componentActivity, i11);
            if (b10 != null) {
                new Handler(Looper.getMainLooper()).post(new a(i10, b10));
                return;
            }
            Intent a10 = aVar.a(componentActivity, i11);
            Bundle bundle = null;
            if (a10.getExtras() != null && a10.getExtras().getClassLoader() == null) {
                a10.setExtrasClassLoader(componentActivity.getClassLoader());
            }
            if (a10.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                bundle = a10.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                a10.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            } else if (bVar != null) {
                bundle = bVar.b();
            }
            Bundle bundle2 = bundle;
            if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(a10.getAction())) {
                String[] stringArrayExtra = a10.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                androidx.core.app.a.s(componentActivity, stringArrayExtra, i10);
            } else if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(a10.getAction())) {
                IntentSenderRequest intentSenderRequest = (IntentSenderRequest) a10.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
                try {
                    androidx.core.app.a.y(componentActivity, intentSenderRequest.d(), i10, intentSenderRequest.a(), intentSenderRequest.b(), intentSenderRequest.c(), 0, bundle2);
                } catch (IntentSender.SendIntentException e10) {
                    new Handler(Looper.getMainLooper()).post(new RunnableC0004b(i10, e10));
                }
            } else {
                androidx.core.app.a.x(componentActivity, a10, i10, bundle2);
            }
        }
    }

    /* loaded from: classes.dex */
    static class c {
        static void a(View view) {
            view.cancelPendingInputEvents();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        Object f301a;

        /* renamed from: b  reason: collision with root package name */
        i0 f302b;

        d() {
        }
    }

    public ComponentActivity() {
        this.mContextAwareHelper = new androidx.activity.contextaware.b();
        this.mMenuHostHelper = new l(new Runnable() { // from class: androidx.activity.d
            @Override // java.lang.Runnable
            public final void run() {
                ComponentActivity.this.invalidateMenu();
            }
        });
        this.mLifecycleRegistry = new q(this);
        this.mSavedStateRegistryController = androidx.savedstate.b.a(this);
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new a());
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new b();
        if (getLifecycle() != null) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 19) {
                getLifecycle().a(new n() { // from class: androidx.activity.ComponentActivity.3
                    @Override // androidx.lifecycle.n
                    public void c(p pVar, Lifecycle.Event event) {
                        if (event == Lifecycle.Event.ON_STOP) {
                            Window window = ComponentActivity.this.getWindow();
                            View peekDecorView = window != null ? window.peekDecorView() : null;
                            if (peekDecorView != null) {
                                c.a(peekDecorView);
                            }
                        }
                    }
                });
            }
            getLifecycle().a(new n() { // from class: androidx.activity.ComponentActivity.4
                @Override // androidx.lifecycle.n
                public void c(p pVar, Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        ComponentActivity.this.mContextAwareHelper.b();
                        if (!ComponentActivity.this.isChangingConfigurations()) {
                            ComponentActivity.this.getViewModelStore().a();
                        }
                    }
                }
            });
            getLifecycle().a(new n() { // from class: androidx.activity.ComponentActivity.5
                @Override // androidx.lifecycle.n
                public void c(p pVar, Lifecycle.Event event) {
                    ComponentActivity.this.ensureViewModelStore();
                    ComponentActivity.this.getLifecycle().c(this);
                }
            });
            if (19 <= i10 && i10 <= 23) {
                getLifecycle().a(new ImmLeaksCleaner(this));
            }
            getSavedStateRegistry().d(ACTIVITY_RESULT_TAG, new SavedStateRegistry.b() { // from class: androidx.activity.c
                @Override // androidx.savedstate.SavedStateRegistry.b
                public final Bundle a() {
                    Bundle lambda$new$0;
                    lambda$new$0 = ComponentActivity.this.lambda$new$0();
                    return lambda$new$0;
                }
            });
            addOnContextAvailableListener(new androidx.activity.contextaware.d() { // from class: androidx.activity.b
                @Override // androidx.activity.contextaware.d
                public final void a(Context context) {
                    ComponentActivity.this.lambda$new$1(context);
                }
            });
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    private void initViewTreeOwners() {
        k0.a(getWindow().getDecorView(), this);
        l0.a(getWindow().getDecorView(), this);
        androidx.savedstate.d.a(getWindow().getDecorView(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle lambda$new$0() {
        Bundle bundle = new Bundle();
        this.mActivityResultRegistry.h(bundle);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(Context context) {
        Bundle a10 = getSavedStateRegistry().a(ACTIVITY_RESULT_TAG);
        if (a10 != null) {
            this.mActivityResultRegistry.g(a10);
        }
    }

    @Override // android.app.Activity
    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        super.addContentView(view, layoutParams);
    }

    public void addMenuProvider(androidx.core.view.n nVar) {
        this.mMenuHostHelper.c(nVar);
    }

    public final void addOnContextAvailableListener(androidx.activity.contextaware.d dVar) {
        this.mContextAwareHelper.a(dVar);
    }

    void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            d dVar = (d) getLastNonConfigurationInstance();
            if (dVar != null) {
                this.mViewModelStore = dVar.f302b;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new i0();
            }
        }
    }

    @Override // androidx.activity.result.c
    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // androidx.lifecycle.j
    public h0.b getDefaultViewModelProviderFactory() {
        if (getApplication() != null) {
            if (this.mDefaultFactory == null) {
                this.mDefaultFactory = new c0(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
            }
            return this.mDefaultFactory;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        d dVar = (d) getLastNonConfigurationInstance();
        if (dVar != null) {
            return dVar.f301a;
        }
        return null;
    }

    @Override // androidx.core.app.f, androidx.lifecycle.p
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.activity.f
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    @Override // androidx.savedstate.c
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }

    @Override // androidx.lifecycle.j0
    public i0 getViewModelStore() {
        if (getApplication() != null) {
            ensureViewModelStore();
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    @Deprecated
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (!this.mActivityResultRegistry.b(i10, i11, intent)) {
            super.onActivityResult(i10, i11, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.mOnBackPressedDispatcher.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mSavedStateRegistryController.c(bundle);
        this.mContextAwareHelper.c(this);
        super.onCreate(bundle);
        a0.g(this);
        int i10 = this.mContentLayoutId;
        if (i10 != 0) {
            setContentView(i10);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        this.mMenuHostHelper.h(menu, getMenuInflater());
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (super.onOptionsItemSelected(menuItem)) {
            return true;
        }
        return this.mMenuHostHelper.i(menuItem);
    }

    @Override // android.app.Activity
    @Deprecated
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        if (!this.mActivityResultRegistry.b(i10, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) && Build.VERSION.SDK_INT >= 23) {
            super.onRequestPermissionsResult(i10, strArr, iArr);
        }
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        d dVar;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        i0 i0Var = this.mViewModelStore;
        if (i0Var == null && (dVar = (d) getLastNonConfigurationInstance()) != null) {
            i0Var = dVar.f302b;
        }
        if (i0Var == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        d dVar2 = new d();
        dVar2.f301a = onRetainCustomNonConfigurationInstance;
        dVar2.f302b = i0Var;
        return dVar2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.app.f, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Lifecycle lifecycle = getLifecycle();
        if (lifecycle instanceof q) {
            ((q) lifecycle).o(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.d(bundle);
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.d();
    }

    public final <I, O> androidx.activity.result.b<I> registerForActivityResult(c.a<I, O> aVar, ActivityResultRegistry activityResultRegistry, androidx.activity.result.a<O> aVar2) {
        return activityResultRegistry.i("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, aVar, aVar2);
    }

    public void removeMenuProvider(androidx.core.view.n nVar) {
        this.mMenuHostHelper.j(nVar);
    }

    @Override // androidx.activity.contextaware.a
    public final void removeOnContextAvailableListener(androidx.activity.contextaware.d dVar) {
        this.mContextAwareHelper.e(dVar);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (m1.a.d()) {
                m1.a.a("reportFullyDrawn() for ComponentActivity");
            }
            int i10 = Build.VERSION.SDK_INT;
            if (i10 > 19) {
                super.reportFullyDrawn();
            } else if (i10 == 19 && androidx.core.content.b.a(this, "android.permission.UPDATE_DEVICE_STATS") == 0) {
                super.reportFullyDrawn();
            }
        } finally {
            m1.a.b();
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i10) {
        initViewTreeOwners();
        super.setContentView(i10);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i10) {
        super.startActivityForResult(intent, i10);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13);
    }

    public void addMenuProvider(androidx.core.view.n nVar, p pVar) {
        this.mMenuHostHelper.d(nVar, pVar);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i10, Bundle bundle) {
        super.startActivityForResult(intent, i10, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13, bundle);
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(androidx.core.view.n nVar, p pVar, Lifecycle.State state) {
        this.mMenuHostHelper.e(nVar, pVar, state);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        initViewTreeOwners();
        super.setContentView(view);
    }

    public final <I, O> androidx.activity.result.b<I> registerForActivityResult(c.a<I, O> aVar, androidx.activity.result.a<O> aVar2) {
        return registerForActivityResult(aVar, this.mActivityResultRegistry, aVar2);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        super.setContentView(view, layoutParams);
    }

    public ComponentActivity(int i10) {
        this();
        this.mContentLayoutId = i10;
    }
}
