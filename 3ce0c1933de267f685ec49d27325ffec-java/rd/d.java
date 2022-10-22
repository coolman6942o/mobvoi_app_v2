package rd;

import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.c;
/* compiled from: SafetyCheckApi.java */
/* loaded from: classes2.dex */
public interface d {
    @Headers({"Accept: application/json"})
    @POST("bind_info")
    c<b> a(@Body a aVar);
}
