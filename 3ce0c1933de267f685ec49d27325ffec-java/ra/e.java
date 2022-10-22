package ra;

import com.mobvoi.android.common.utils.k;
import okhttp3.logging.HttpLoggingInterceptor;
/* loaded from: classes3.dex */
public final /* synthetic */ class e implements HttpLoggingInterceptor.a {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ e f33484b = new e();

    private /* synthetic */ e() {
    }

    @Override // okhttp3.logging.HttpLoggingInterceptor.a
    public final void a(String str) {
        k.a("BaseAccountApi", str);
    }
}
