package w6;

import android.content.Context;
import b6.i;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.internal.c;
import com.google.android.gms.internal.location.p;
import com.google.android.gms.internal.location.y;
import t6.b;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final a.g<p> f36005a;

    /* renamed from: b  reason: collision with root package name */
    private static final a.AbstractC0105a<p, Object> f36006b;

    /* renamed from: c  reason: collision with root package name */
    public static final com.google.android.gms.common.api.a<Object> f36007c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public static final w6.a f36008d = new y();

    /* loaded from: classes.dex */
    public static abstract class a<R extends h> extends c<R, p> {
        public a(com.google.android.gms.common.api.d dVar) {
            super(d.f36007c, dVar);
        }
    }

    static {
        a.g<p> gVar = new a.g<>();
        f36005a = gVar;
        e eVar = new e();
        f36006b = eVar;
        f36007c = new com.google.android.gms.common.api.a<>("LocationServices.API", eVar, gVar);
        new b();
        new t6.d();
    }

    public static com.google.android.gms.location.a a(Context context) {
        return new com.google.android.gms.location.a(context);
    }

    public static p b(com.google.android.gms.common.api.d dVar) {
        boolean z10 = true;
        i.b(dVar != null, "GoogleApiClient parameter is required.");
        p pVar = (p) dVar.m(f36005a);
        if (pVar == null) {
            z10 = false;
        }
        i.o(z10, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return pVar;
    }
}
