package cn.com.fmsh.tsm.business.bean;

import java.io.Serializable;
/* loaded from: classes.dex */
public class UserInfo implements Serializable {
    private static final /* synthetic */ long serialVersionUID = 1;

    /* renamed from: a  reason: collision with root package name */
    /* synthetic */ String f6163a = null;

    /* renamed from: b  reason: collision with root package name */
    /* synthetic */ String f6164b = null;

    /* renamed from: c  reason: collision with root package name */
    /* synthetic */ int f6165c = -1;

    /* renamed from: d  reason: collision with root package name */
    /* synthetic */ String f6166d = null;

    /* renamed from: e  reason: collision with root package name */
    /* synthetic */ String f6167e = null;

    /* renamed from: f  reason: collision with root package name */
    /* synthetic */ String f6168f = null;

    /* renamed from: g  reason: collision with root package name */
    /* synthetic */ int f6169g = -1;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ String f6170h = null;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ byte[] f6171i = null;

    /* renamed from: j  reason: collision with root package name */
    /* synthetic */ String f6172j = null;

    public String getCertNo() {
        return this.f6170h;
    }

    public int getCertType() {
        return this.f6169g;
    }

    public String getMail() {
        return this.f6166d;
    }

    public String getPassword() {
        return this.f6164b;
    }

    public String getPhone() {
        return this.f6167e;
    }

    public String getRealName() {
        return this.f6168f;
    }

    public String getUserName() {
        return this.f6163a;
    }

    public int getUserType() {
        return this.f6165c;
    }

    public String getVerificationCode() {
        return this.f6172j;
    }

    public byte[] getVerificationCodeNo() {
        return this.f6171i;
    }

    public void setCertNo(String str) {
        this.f6170h = str;
    }

    public void setCertType(int i10) {
        this.f6169g = i10;
    }

    public void setMail(String str) {
        this.f6166d = str;
    }

    public void setPassword(String str) {
        this.f6164b = str;
    }

    public void setPhone(String str) {
        this.f6167e = str;
    }

    public void setRealName(String str) {
        this.f6168f = str;
    }

    public void setUserName(String str) {
        this.f6163a = str;
    }

    public void setUserType(int i10) {
        this.f6165c = i10;
    }

    public void setVerificationCode(String str) {
        this.f6172j = str;
    }

    public void setVerificationCodeNo(byte[] bArr) {
        this.f6171i = bArr;
    }
}
