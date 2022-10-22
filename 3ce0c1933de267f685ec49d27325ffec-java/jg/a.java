package jg;

import com.mobvoi.health.common.data.pojo.SportType;
import java.util.List;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.c;
/* compiled from: UserSportTypeSettingApi.java */
/* loaded from: classes2.dex */
public interface a {
    @POST("/data/motion_type/update/{account-id}")
    c<lg.a> a(@Body List<SportType> list);

    @GET("/data/motion_type/get/{account-id}")
    c<lg.a> b();
}
