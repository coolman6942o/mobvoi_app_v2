package ha;

import ia.b;
import ia.d;
import ia.f;
import ia.h;
import ia.i;
import io.m;
import okhttp3.c0;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.c;
/* compiled from: AbupService.kt */
/* loaded from: classes2.dex */
public interface a {
    @POST("/register/{productId}")
    c<i<ia.c>> a(@Path("productId") String str, @Body d dVar);

    @Streaming
    @GET
    c<c0> b(@Url String str, @Header("RANGE") String str2);

    @POST("/product/{productId}/{deviceId}/ota/checkVersion")
    c<i<h>> c(@Path("productId") String str, @Path("deviceId") String str2, @Body b bVar);

    @POST("/product/{productId}/{deviceId}/ota/reportDownResult")
    c<i<m>> d(@Path("productId") String str, @Path("deviceId") String str2, @Body f fVar);
}
