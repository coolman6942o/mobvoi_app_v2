package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import androidx.fragment.app.f;
import androidx.loader.app.a;
import androidx.loader.content.c;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import x5.d;
@KeepName
/* loaded from: classes.dex */
public class SignInHubActivity extends f {

    /* renamed from: f  reason: collision with root package name */
    private static boolean f8421f = false;

    /* renamed from: a  reason: collision with root package name */
    private boolean f8422a = false;

    /* renamed from: b  reason: collision with root package name */
    private SignInConfiguration f8423b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8424c;

    /* renamed from: d  reason: collision with root package name */
    private int f8425d;

    /* renamed from: e  reason: collision with root package name */
    private Intent f8426e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements a.AbstractC0034a<Void> {
        private a() {
        }

        @Override // androidx.loader.app.a.AbstractC0034a
        public final void V(c<Void> cVar) {
        }

        @Override // androidx.loader.app.a.AbstractC0034a
        public final /* synthetic */ void o(c<Void> cVar, Void r32) {
            SignInHubActivity signInHubActivity = SignInHubActivity.this;
            signInHubActivity.setResult(signInHubActivity.f8425d, SignInHubActivity.this.f8426e);
            SignInHubActivity.this.finish();
        }

        @Override // androidx.loader.app.a.AbstractC0034a
        public final c<Void> r(int i10, Bundle bundle) {
            return new d(SignInHubActivity.this, com.google.android.gms.common.api.d.l());
        }
    }

    private final void H(int i10) {
        Status status = new Status(i10);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        f8421f = false;
    }

    private final void J() {
        getSupportLoaderManager().c(0, null, new a());
        f8421f = false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (!this.f8422a) {
            setResult(0);
            if (i10 == 40962) {
                if (intent != null) {
                    SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
                    if (signInAccount != null && signInAccount.W() != null) {
                        GoogleSignInAccount W = signInAccount.W();
                        x5.f.c(this).b(this.f8423b.G0(), W);
                        intent.removeExtra("signInAccount");
                        intent.putExtra("googleSignInAccount", W);
                        this.f8424c = true;
                        this.f8425d = i11;
                        this.f8426e = intent;
                        J();
                        return;
                    } else if (intent.hasExtra("errorCode")) {
                        int intExtra = intent.getIntExtra("errorCode", 8);
                        if (intExtra == 13) {
                            intExtra = 12501;
                        }
                        H(intExtra);
                        return;
                    }
                }
                H(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String action = intent.getAction();
        if ("com.google.android.gms.auth.NO_IMPL".equals(action)) {
            H(12500);
        } else if (action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") || action.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            SignInConfiguration signInConfiguration = (SignInConfiguration) intent.getBundleExtra("config").getParcelable("config");
            this.f8423b = signInConfiguration;
            if (signInConfiguration == null) {
                Log.e("AuthSignInClient", "Activity started with invalid configuration.");
                setResult(0);
                finish();
                return;
            }
            if (!(bundle == null)) {
                boolean z10 = bundle.getBoolean("signingInGoogleApiClients");
                this.f8424c = z10;
                if (z10) {
                    this.f8425d = bundle.getInt("signInResultCode");
                    this.f8426e = (Intent) bundle.getParcelable("signInResultData");
                    J();
                }
            } else if (f8421f) {
                setResult(0);
                H(12502);
            } else {
                f8421f = true;
                Intent intent2 = new Intent(action);
                if (action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
                    intent2.setPackage("com.google.android.gms");
                } else {
                    intent2.setPackage(getPackageName());
                }
                intent2.putExtra("config", this.f8423b);
                try {
                    startActivityForResult(intent2, 40962);
                } catch (ActivityNotFoundException unused) {
                    this.f8422a = true;
                    Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
                    H(17);
                }
            }
        } else {
            String valueOf = String.valueOf(intent.getAction());
            Log.e("AuthSignInClient", valueOf.length() != 0 ? "Unknown action: ".concat(valueOf) : new String("Unknown action: "));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.f8424c);
        if (this.f8424c) {
            bundle.putInt("signInResultCode", this.f8425d);
            bundle.putParcelable("signInResultData", this.f8426e);
        }
    }
}
