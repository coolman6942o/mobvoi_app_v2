package th;

import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import v9.e;
import yh.a;
/* compiled from: WeatherApi.kt */
/* loaded from: classes2.dex */
public interface c {
    @Headers({"sign_appkey: sign_appkey"})
    @POST("/cardstream/json/weather")
    rx.c<e> a(@Body a aVar);
}
