package dk;

import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.wear.permission.PermissionConstant;
/* compiled from: TicCareResponse.java */
/* loaded from: classes2.dex */
public class c implements JsonBean {
    @h8.c("errCode")
    public int errCode;
    @h8.c("errMsg")
    public String errMsg;
    @h8.c("redirectUrl")
    public String redirectUrl;
    @h8.c("result")
    public String result;
    @h8.c(PermissionConstant.Columns.STATUS)
    public String status;
}
