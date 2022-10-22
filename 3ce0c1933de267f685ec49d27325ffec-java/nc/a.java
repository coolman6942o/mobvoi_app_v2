package nc;

import com.mobvoi.be.pushunicorn.PushUnicornProto;
import com.mobvoi.wear.common.base.Constants;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.c;
/* compiled from: MobvoiPushApi.kt */
/* loaded from: classes2.dex */
public interface a {
    @Headers({"Content-Type: application/x-protobuf", "Accept: application/x-protobuf"})
    @POST(Constants.Setting.SUPER_POWER_SAVE_MODE_REASON_USER)
    c<PushUnicornProto.UserPushResponse> a(@Body PushUnicornProto.UserPushRequest userPushRequest);
}
