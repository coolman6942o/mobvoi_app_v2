package bf;

import com.mobvoi.android.common.utils.k;
import okhttp3.logging.HttpLoggingInterceptor;
/* loaded from: classes.dex */
public final /* synthetic */ class d implements HttpLoggingInterceptor.a {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ d f5135b = new d();

    private /* synthetic */ d() {
    }

    @Override // okhttp3.logging.HttpLoggingInterceptor.a
    public final void a(String str) {
        k.o("fit.net.server", str);
    }
}
