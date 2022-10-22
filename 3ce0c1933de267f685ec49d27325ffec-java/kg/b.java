package kg;

import com.mobvoi.android.common.utils.k;
import okhttp3.logging.HttpLoggingInterceptor;
/* loaded from: classes3.dex */
public final /* synthetic */ class b implements HttpLoggingInterceptor.a {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ b f29884b = new b();

    private /* synthetic */ b() {
    }

    @Override // okhttp3.logging.HttpLoggingInterceptor.a
    public final void a(String str) {
        k.o("health.net.server", str);
    }
}
