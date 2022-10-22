package t5;

import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.a;
import p6.b;
import p6.c;
import x5.e;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a.g<c> f35053a;

    /* renamed from: b  reason: collision with root package name */
    public static final a.g<com.google.android.gms.auth.api.signin.internal.c> f35054b;

    /* renamed from: c  reason: collision with root package name */
    private static final a.AbstractC0105a<c, C0501a> f35055c;

    /* renamed from: d  reason: collision with root package name */
    private static final a.AbstractC0105a<com.google.android.gms.auth.api.signin.internal.c, GoogleSignInOptions> f35056d;

    /* renamed from: e  reason: collision with root package name */
    public static final com.google.android.gms.common.api.a<GoogleSignInOptions> f35057e;

    /* renamed from: f  reason: collision with root package name */
    public static final w5.a f35058f = new e();

    @Deprecated
    /* renamed from: t5.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0501a implements a.d.c, a.d {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f35059a;

        @Deprecated
        /* renamed from: t5.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0502a {

            /* renamed from: a  reason: collision with root package name */
            protected Boolean f35060a = Boolean.FALSE;

            public C0501a a() {
                return new C0501a(this);
            }
        }

        static {
            new C0502a().a();
        }

        public C0501a(C0502a aVar) {
            this.f35059a = aVar.f35060a.booleanValue();
        }

        public final Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putString("consumer_package", null);
            bundle.putBoolean("force_save_dialog", this.f35059a);
            return bundle;
        }
    }

    static {
        a.g<c> gVar = new a.g<>();
        f35053a = gVar;
        a.g<com.google.android.gms.auth.api.signin.internal.c> gVar2 = new a.g<>();
        f35054b = gVar2;
        e eVar = new e();
        f35055c = eVar;
        f fVar = new f();
        f35056d = fVar;
        com.google.android.gms.common.api.a<c> aVar = b.f35063c;
        new com.google.android.gms.common.api.a("Auth.CREDENTIALS_API", eVar, gVar);
        f35057e = new com.google.android.gms.common.api.a<>("Auth.GOOGLE_SIGN_IN_API", fVar, gVar2);
        v5.a aVar2 = b.f35064d;
        new b();
    }
}
