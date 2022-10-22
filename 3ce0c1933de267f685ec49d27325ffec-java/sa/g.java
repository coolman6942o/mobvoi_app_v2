package sa;

import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.wear.info.AccountInfoHelper;
import com.mobvoi.wear.providers.SocialContract;
import h8.c;
/* compiled from: LoginResponse.java */
/* loaded from: classes2.dex */
public class g extends c {
    @c("result")
    public a result;

    /* compiled from: LoginResponse.java */
    /* loaded from: classes2.dex */
    public static class a implements JsonBean {
        public String email;
        @c("info")
        public b info;
        public String phone;
        @c("referral_code")
        public String referralCode;
        @c("session_id")
        public String sessionId;
        public String wwid;
    }

    /* compiled from: LoginResponse.java */
    /* loaded from: classes2.dex */
    public static class b implements JsonBean {
        @c(AccountInfoHelper.AccountInfo.KEY_ACCOUNT_ID)
        public String accountId;
        public boolean agree;
        public String birthday;
        public String career;
        public String company;
        @c("head_image_url")
        public String headImageUrl;
        public String height;
        public String home;
        @c(SocialContract.RankingUserColumns.NICKNAME)
        public String nickName;
        public boolean pii;
        public String region;
        public int sex;
        public String weight;
    }
}
