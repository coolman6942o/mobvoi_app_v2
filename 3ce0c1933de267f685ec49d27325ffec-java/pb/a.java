package pb;

import com.mobvoi.be.ticassistant.DeviceInfoProto;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.c;
/* compiled from: DeviceListApi.java */
/* loaded from: classes2.dex */
public interface a {
    @Headers({"Content-Type: application/x-protobuf", "Accept: application/x-protobuf"})
    @POST("/device-info/bind")
    c<DeviceInfoProto.DeviceInfoResponse> a(@Body DeviceInfoProto.BindDataCollection bindDataCollection);
}
