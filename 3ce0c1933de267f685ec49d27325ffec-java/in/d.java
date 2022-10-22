package in;

import com.huawei.hms.framework.common.ContainerUtils;
import java.net.URLDecoder;
import java.util.List;
import jn.a;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static String f28347a;

    public static a a(String str, String str2) {
        a.e("NetworkUitlity.post->" + str);
        a aVar = new a();
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(str);
        try {
            StringEntity stringEntity = new StringEntity("content=" + str2, "UTF-8");
            a.e("NetworkUitlity.post->content=" + str2);
            a.e("NetworkUitlity.post->contentMD5=" + c.a(str2));
            stringEntity.setContentType("application/x-www-form-urlencoded");
            httpPost.setEntity(stringEntity);
            if (f28347a != null) {
                httpPost.setHeader("Cookie", "PHPSESSID=" + f28347a);
                a.e("post PHPSESSID=" + f28347a);
            }
            HttpResponse execute = defaultHttpClient.execute(httpPost);
            int statusCode = execute.getStatusLine().getStatusCode();
            aVar.d(statusCode);
            a.e("NetworkUitlity.post->" + statusCode);
            String decode = URLDecoder.decode(EntityUtils.toString(execute.getEntity()));
            if (statusCode == 200) {
                aVar.c(decode);
                List cookies = defaultHttpClient.getCookieStore().getCookies();
                int i10 = 0;
                while (true) {
                    if (i10 >= cookies.size()) {
                        break;
                    }
                    a.e(((Cookie) cookies.get(i10)).getName() + ContainerUtils.KEY_VALUE_DELIMITER + ((Cookie) cookies.get(i10)).getValue());
                    if ("PHPSESSID".equals(((Cookie) cookies.get(i10)).getName())) {
                        f28347a = ((Cookie) cookies.get(i10)).getValue();
                        a.e("set PHPSESSID=" + f28347a);
                        break;
                    }
                    i10++;
                }
            } else {
                a.f("NetworkUitlity.post->error=", statusCode + decode);
                aVar.c(decode);
            }
        } catch (Exception e10) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("err", e10.toString());
                aVar.c(jSONObject.toString());
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
        }
        a.e("NetworkUitlity.post->" + aVar.a());
        return aVar;
    }
}
