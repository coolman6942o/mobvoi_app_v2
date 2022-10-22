package te;

import android.text.TextUtils;
import com.google.protobuf.ByteString;
import com.mobvoi.companion.FeedbackProto;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.y;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.protobuf.ProtoConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
/* compiled from: FeedbackUtil.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static AbstractC0506a f35141a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FeedbackUtil.java */
    /* renamed from: te.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface AbstractC0506a {
        @Headers({"Content-Type: application/x-protobuf", "Accept: application/x-protobuf", "Content-Encoding: gzip"})
        @POST("/rest/feedbacks2/{name}")
        Call<FeedbackProto.Response> a(@Path("name") String str, @Body FeedbackProto.Request request);
    }

    private static AbstractC0506a a() {
        if (f35141a == null) {
            f35141a = (AbstractC0506a) new Retrofit.Builder().client(b()).baseUrl("https://feedbackhub.mobvoi.com").addConverterFactory(ProtoConverterFactory.create()).build().create(AbstractC0506a.class);
        }
        return f35141a;
    }

    private static y b() {
        y.a a10 = new y.a().a(new b());
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return a10.e(60L, timeUnit).O(60L, timeUnit).M(60L, timeUnit).c();
    }

    private static String c(String str) {
        return TextUtils.isEmpty(str) ? "" : "vpa".equals(str) ? "VPA" : "tichome".equals(str) ? "Tichome" : str;
    }

    public static int d(String str, String str2, String str3, String str4, String str5, Map<String, String> map, Map<String, byte[]> map2) {
        FeedbackProto.FeedbackRequest.Builder newBuilder = FeedbackProto.FeedbackRequest.newBuilder();
        if (str == null) {
            str = "";
        }
        FeedbackProto.FeedbackRequest.Builder wwid = newBuilder.setWwid(str);
        if (str2 == null) {
            str2 = "";
        }
        FeedbackProto.FeedbackRequest.Builder feedbackClassification = wwid.setDeviceId(str2).setFeedbackClassification(str4);
        if (str5 == null) {
            str5 = "";
        }
        FeedbackProto.FeedbackRequest.Builder happenedAt = feedbackClassification.setFeedbackContent(str5).setSource(c(str3)).setHappenedAt(System.currentTimeMillis());
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                happenedAt.putExtras(entry.getKey(), entry.getValue());
            }
        }
        if (map2 != null) {
            for (Map.Entry<String, byte[]> entry2 : map2.entrySet()) {
                byte[] value = entry2.getValue();
                if (!(value == null || value.length == 0)) {
                    happenedAt.putAttachments(entry2.getKey(), ByteString.copyFrom(value));
                }
            }
        }
        try {
            FeedbackProto.Response body = a().a(str3, FeedbackProto.Request.newBuilder().setFeedback(happenedAt).build()).execute().body();
            if (body != null) {
                return body.getFeedback().getId();
            }
        } catch (IOException unused) {
        }
        return -1;
    }
}
