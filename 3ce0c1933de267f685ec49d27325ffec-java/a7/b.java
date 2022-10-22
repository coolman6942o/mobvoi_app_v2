package a7;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final a.g<com.google.android.gms.signin.internal.a> f119a;

    /* renamed from: b  reason: collision with root package name */
    private static final a.g<com.google.android.gms.signin.internal.a> f120b;

    /* renamed from: c  reason: collision with root package name */
    public static final a.AbstractC0105a<com.google.android.gms.signin.internal.a, a> f121c;

    /* renamed from: d  reason: collision with root package name */
    private static final a.AbstractC0105a<com.google.android.gms.signin.internal.a, Object> f122d;

    /* renamed from: e  reason: collision with root package name */
    public static final a<a> f123e;

    static {
        a.g<com.google.android.gms.signin.internal.a> gVar = new a.g<>();
        f119a = gVar;
        a.g<com.google.android.gms.signin.internal.a> gVar2 = new a.g<>();
        f120b = gVar2;
        c cVar = new c();
        f121c = cVar;
        d dVar = new d();
        f122d = dVar;
        new Scope("profile");
        new Scope("email");
        f123e = new a<>("SignIn.API", cVar, gVar);
        new a("SignIn.INTERNAL_API", dVar, gVar2);
    }
}
