package sa;

import com.mobvoi.android.common.json.JsonBean;
import h8.c;
/* compiled from: SignUpRequest.java */
/* loaded from: classes2.dex */
public class j implements JsonBean {
    public boolean agree;
    public String appkey;
    public String captcha;
    @c("captcha_type")
    public String captchaType;
    public String email;
    @c("need_captcha")
    public boolean needCaptcha;
    public String password;
    public String phone;
    public String region;
}
