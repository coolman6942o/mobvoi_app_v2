package wf;

import com.mobvoi.android.common.json.JsonBean;
/* compiled from: ResponseBase.java */
/* loaded from: classes2.dex */
public class o implements JsonBean {
    public static final int ERROR_CODE_OK = 0;
    public int err_code;
    public String err_msg;
    public String status;

    public boolean a() {
        return this.err_code == 0;
    }
}
