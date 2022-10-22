package df;

import com.alibaba.fastjson.annotation.JSONField;
import com.mobvoi.android.common.json.JsonBean;
/* compiled from: NetResponse.java */
/* loaded from: classes2.dex */
public class d implements JsonBean {
    @JSONField(name = "err_code")
    public int errCode;
    @JSONField(name = "err_msg")
    public String errMessage;
}
