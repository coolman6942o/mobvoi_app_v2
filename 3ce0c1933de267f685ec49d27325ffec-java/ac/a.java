package ac;

import cc.d;
import cc.f;
import cc.g;
import java.util.Map;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.c;
/* compiled from: WatchFaceApi.kt */
/* loaded from: classes2.dex */
public interface a {
    @Headers({"url_name:card"})
    @GET("/api/cards/v2")
    c<f> a(@Query("oversea") boolean z10, @Query("wwid") String str, @QueryMap Map<String, String> map);

    @Headers({"url_name:appstore"})
    @GET("/api/app/package/all")
    c<g> b(@Query("apk_package_name") String str, @Query("oversea") boolean z10);

    @Headers({"url_name:appstore"})
    @GET("/api/watch_face/type/page")
    c<d> c(@Query("categoryId") int i10, @Query("second_category_id") int i11, @Query("page_index") int i12, @Query("page_size") int i13, @Query("wwid") String str, @QueryMap Map<String, String> map, @Query("oversea") boolean z10);

    @Headers({"url_name:appstore"})
    @GET("/api/v3/app_info/latest/{page_num}/{page_size}")
    c<d> d(@Path(encoded = true, value = "page_num") String str, @Path(encoded = true, value = "page_size") String str2, @QueryMap Map<String, String> map, @Query("oversea") boolean z10);
}
