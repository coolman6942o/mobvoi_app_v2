package kg;

import com.mobvoi.android.common.utils.k;
import okhttp3.logging.HttpLoggingInterceptor;
/* loaded from: classes3.dex */
public final /* synthetic */ class f implements HttpLoggingInterceptor.a {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ f f29891b = new f();

    private /* synthetic */ f() {
    }

    @Override // okhttp3.logging.HttpLoggingInterceptor.a
    public final void a(String str) {
        k.o("fit.net.server", str);
    }
}
