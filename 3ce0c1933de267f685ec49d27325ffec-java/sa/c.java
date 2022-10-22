package sa;

import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.wear.permission.PermissionConstant;
/* compiled from: CommonResponse.java */
/* loaded from: classes2.dex */
public class c implements JsonBean {
    private static final String ERROR = "error";
    private static final int ERROR_CODE_ALREADY_SIGNED = 101;
    public static final int ERROR_CODE_NICK_ALREADY_EXIST = 313;
    public static final int ERROR_CODE_NICK_NAME_VERIFIED_FAILED = 100006;
    private static final int ERROR_CODE_NOT_EXIST = 100;
    public static final int ERROR_CODE_SEND_SUCCESS_AND_NOT_EXIST = 100005;
    public static final int ERROR_CODE_SHOW_SERVER_MSG = 100001;
    private static final int ERROR_CODE_THIRD_PARTY_NOT_BIND = 1101;
    private static final int ERROR_CODE_TOKEN_INVALID = 306;
    private static final String EXPIRED = "expired";
    private static final String SUCCESS = "success";
    @h8.c("err_code")
    public int errorCode;
    @h8.c("err_msg")
    public String errorMsg;
    @h8.c(PermissionConstant.Columns.STATUS)
    public String status;

    public boolean a() {
        return this.errorCode == ERROR_CODE_TOKEN_INVALID;
    }

    public boolean b() {
        return "success".equals(this.status);
    }

    public boolean c() {
        return this.errorCode == 100;
    }

    public boolean d() {
        return this.errorCode == 100005;
    }

    public boolean e() {
        return 100001 == this.errorCode;
    }

    public boolean f() {
        return this.errorCode == 1101;
    }
}
