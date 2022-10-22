package ld;

import com.mobvoi.companion.proto.AccountProto;
import com.mobvoi.companion.proto.FilecountProto;
import com.mobvoi.companion.proto.PayProto;
import com.mobvoi.companion.proto.ProductProto;
import com.mobvoi.companion.proto.ResponseProto;
import com.mobvoi.companion.proto.SoundProto;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import rx.c;
/* compiled from: SoundApi.java */
/* loaded from: classes2.dex */
public interface d {
    @Headers({"sign_appkey: sign_appkey"})
    @GET("/sound/file")
    c<SoundProto.SoundFileResp> a(@Header("token") String str, @Query("page_no") int i10, @Query("page_size") int i11);

    @Headers({"sign_appkey: sign_appkey"})
    @GET("/sound/product")
    c<ProductProto.SoundProductResp> b(@Header("token") String str);

    @DELETE("/sound/file")
    @Headers({"sign_appkey: sign_appkey"})
    c<SoundProto.SoundFileResp> c(@Header("token") String str, @Query("file_id") String str2);

    @Headers({"sign_appkey: sign_appkey"})
    @PUT("/sound/file/flags")
    c<SoundProto.SoundFileResp> d(@Header("token") String str, @Body SoundProto.SoundFile soundFile);

    @FormUrlEncoded
    @Headers({"sign_appkey: sign_appkey"})
    @POST("/sound/pay/paypal")
    c<ResponseProto.CommonResp> e(@Header("token") String str, @Field("order_id") String str2);

    @FormUrlEncoded
    @Headers({"sign_appkey: sign_appkey"})
    @PUT("/sound/file/speaker")
    c<ResponseProto.CommonResp> f(@Header("token") String str, @Field("file_id") String str2, @Field("paragraph_id") int i10, @Field("speaker_name") String str3);

    @Headers({"sign_appkey: sign_appkey"})
    @GET("/sound/product")
    c<ProductProto.SoundProductResp> g(@Header("token") String str, @Query("lang") String str2);

    @Headers({"sign_appkey: sign_appkey"})
    @GET("/sound/file/count")
    c<FilecountProto.SoundFilecountResp> h(@Header("token") String str);

    @FormUrlEncoded
    @Headers({"sign_appkey: sign_appkey"})
    @POST("/sound/card/bind")
    c<AccountProto.SoundAccountResp> i(@Header("token") String str, @Field("card_id") String str2);

    @Headers({"sign_appkey: sign_appkey"})
    @POST("/sound/file/modified-text")
    c<ResponseProto.CommonResp> j(@Header("token") String str, @Body SoundProto.ModifiedTextReq modifiedTextReq);

    @Headers({"sign_appkey: sign_appkey"})
    @GET("/sound/file/convert/result")
    c<SoundProto.SoundConvertResultResp> k(@Header("token") String str, @Query("file_id") String str2);

    @FormUrlEncoded
    @Headers({"sign_appkey: sign_appkey"})
    @POST("/sound/file/keywords")
    c<ResponseProto.CommonResp> l(@Header("token") String str, @Field("file_id") String str2, @Field("keywords") String[] strArr);

    @Headers({"sign_appkey: sign_appkey"})
    @POST("/sound/pay")
    c<PayProto.SoundPayResp> m(@Header("token") String str, @Body PayProto.SoundPay soundPay);

    @Headers({"sign_appkey: sign_appkey"})
    @PUT("/sound/file/rename")
    c<SoundProto.SoundFileResp> n(@Header("token") String str, @Body SoundProto.RenameReq renameReq);

    @Headers({"sign_appkey: sign_appkey"})
    @GET("/sound/account")
    c<AccountProto.SoundAccountResp> o(@Header("token") String str);

    @FormUrlEncoded
    @Headers({"sign_appkey: sign_appkey"})
    @POST("/sound/file/convert/start")
    c<SoundProto.SoundConvertResultResp> p(@Header("token") String str, @Field("file_id") String str2, @Field("near_speaker_num") int i10, @Field("far_speaker_num") int i11, @Field("lang") String str3);
}
