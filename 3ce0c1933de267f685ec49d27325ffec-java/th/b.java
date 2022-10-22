package th;

import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.g;
import yh.c;
/* compiled from: WatchfaceApi.kt */
/* loaded from: classes2.dex */
public interface b {
    @Headers({"sign_appkey: sign_appkey"})
    @GET("/")
    g<List<c>> a(@Header("token") String str, @Query("pageNum") int i10, @Query("pageSize") int i11, @Query("width") int i12, @Query("height") int i13, @Query("type") int i14, @Query("lang") String str2);

    @GET("/")
    g<List<c>> b(@Header("token") String str, @Query("pageNum") int i10, @Query("pageSize") int i11, @Query("lang") String str2);
}
