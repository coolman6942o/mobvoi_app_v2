package ra;

import android.text.TextUtils;
import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.wear.common.base.Constants;
import java.util.HashMap;
import java.util.Map;
/* compiled from: CommonParam.java */
/* loaded from: classes2.dex */
public class g implements JsonBean {
    private String deviceId;
    private String pkg;
    private String platform = "android";
    private String region = Constants.Setting.CHINA_REGION;
    private String source;

    /* renamed from: vc  reason: collision with root package name */
    private String f33486vc;

    /* renamed from: vn  reason: collision with root package name */
    private String f33487vn;

    public Map<String, String> a() {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(this.pkg)) {
            hashMap.put("pkg", this.pkg);
            if (!TextUtils.isEmpty(this.platform)) {
                hashMap.put("platform", this.platform);
            }
            if (!TextUtils.isEmpty(this.region)) {
                hashMap.put("region", this.region);
            }
            if (!TextUtils.isEmpty(this.deviceId)) {
                hashMap.put("device_id", this.deviceId);
            }
            if (!TextUtils.isEmpty(this.f33487vn)) {
                hashMap.put("vn", this.f33487vn);
            }
            if (!TextUtils.isEmpty(this.f33486vc)) {
                hashMap.put("vc", this.f33486vc);
            }
            if (hashMap.size() > 0) {
                return hashMap;
            }
            return null;
        }
        throw new IllegalArgumentException("the pak can not be null");
    }

    public void b(String str) {
        this.pkg = str;
    }

    public void c(String str) {
        this.region = str;
    }

    public void d(String str) {
        this.source = str;
    }

    public void e(String str) {
        this.f33486vc = str;
    }

    public void f(String str) {
        this.f33487vn = str;
    }
}
