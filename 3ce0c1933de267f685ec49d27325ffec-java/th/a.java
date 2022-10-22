package th;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.c;
import yh.b;
/* compiled from: JsonWebTokenApi.kt */
/* loaded from: classes2.dex */
public interface a {
    @GET("/toc/jwt/cardiex/v1/auth")
    c<b> a(@Query("device_id") String str, @Query("token") String str2, @Query("type") String str3);
}
