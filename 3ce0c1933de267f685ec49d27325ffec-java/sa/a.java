package sa;

import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.assistant.account.AccountConstant;
import com.mobvoi.wear.info.AccountInfoHelper;
import com.mobvoi.wear.providers.SocialContract;
import h8.c;
import sa.g;
/* compiled from: AccountInfo.java */
/* loaded from: classes2.dex */
public class a implements JsonBean {
    @c(AccountInfoHelper.AccountInfo.KEY_ACCOUNT_ID)
    public String accountId;
    public boolean agree;
    public String app = AccountConstant.a();
    public String birthday;
    public String career;
    public String company;
    public String email;
    @c("head_image_url")
    public String headUrl;
    public String height;
    public String home;
    @c(SocialContract.RankingUserColumns.NICKNAME)
    public String nickName;
    @h8.a(deserialize = false, serialize = false)
    public String phoneNumber;
    public boolean pii;
    @c("referral_code")
    public String referralCode;
    public String region;
    @c("session_id")
    public String sessionId;
    public int sex;
    public String weight;
    public String wwid;

    public static a a(g.a aVar) {
        if (aVar == null) {
            return null;
        }
        a aVar2 = new a();
        aVar2.phoneNumber = aVar.phone;
        aVar2.email = aVar.email;
        aVar2.sessionId = aVar.sessionId;
        aVar2.wwid = aVar.wwid;
        aVar2.referralCode = aVar.referralCode;
        g.b bVar = aVar.info;
        if (bVar != null) {
            aVar2.career = bVar.career;
            aVar2.home = bVar.home;
            aVar2.headUrl = bVar.headImageUrl;
            aVar2.birthday = bVar.birthday;
            aVar2.company = bVar.company;
            aVar2.sex = bVar.sex;
            aVar2.accountId = bVar.accountId;
            aVar2.nickName = bVar.nickName;
            aVar2.weight = bVar.weight;
            aVar2.height = bVar.height;
            aVar2.agree = bVar.agree;
            aVar2.pii = bVar.pii;
            aVar2.region = bVar.region;
        }
        return aVar2;
    }

    public String toString() {
        return "AccountInfo:\n\tphoneNumber=" + this.phoneNumber + "\n\temail=" + this.email + "\n\tsessionId=" + this.sessionId + "\n\tcareer=" + this.career + "\n\thome=" + this.home + "\n\theadUrl=" + this.headUrl + "\n\tbirthday=" + this.birthday + "\n\tcompany=" + this.company + "\n\tsex=" + this.sex + "\n\taccountId=" + this.accountId + "\n\tnickName=" + this.nickName + "height=" + this.height + "weight=" + this.weight + "pii=" + this.pii + "region=" + this.region;
    }
}
