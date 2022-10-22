package tc;

import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.wear.permission.PermissionConstant;
import h8.c;
/* compiled from: BaseResp.kt */
/* loaded from: classes2.dex */
public abstract class a implements JsonBean {
    @c("err_code")
    private Integer errorCode;
    @c("err_msg")
    private String errorMsg;
    @c(PermissionConstant.Columns.STATUS)
    private String status;

    public final boolean a() {
        Integer num = this.errorCode;
        return num != null && num.intValue() == 0;
    }
}
