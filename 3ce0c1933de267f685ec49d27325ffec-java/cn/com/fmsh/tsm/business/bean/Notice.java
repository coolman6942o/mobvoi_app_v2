package cn.com.fmsh.tsm.business.bean;

import java.io.Serializable;
/* loaded from: classes.dex */
public class Notice implements Serializable {
    public static int NOTICE_TXT = 22;
    public static int NOTICE_UNSOLVED = 33;
    private static final /* synthetic */ long serialVersionUID = 1;

    /* renamed from: a  reason: collision with root package name */
    /* synthetic */ int f6156a;

    /* renamed from: b  reason: collision with root package name */
    /* synthetic */ String f6157b;

    /* renamed from: c  reason: collision with root package name */
    /* synthetic */ String f6158c;

    /* renamed from: d  reason: collision with root package name */
    /* synthetic */ String f6159d;

    /* renamed from: e  reason: collision with root package name */
    /* synthetic */ String f6160e;

    /* renamed from: f  reason: collision with root package name */
    /* synthetic */ int f6161f;

    /* renamed from: g  reason: collision with root package name */
    /* synthetic */ byte[] f6162g;

    public String getContent() {
        return this.f6158c;
    }

    public String getEndDate() {
        return this.f6160e;
    }

    public int getNo() {
        return this.f6156a;
    }

    public byte[] getOrder() {
        return this.f6162g;
    }

    public String getStartDate() {
        return this.f6159d;
    }

    public String getTitle() {
        return this.f6157b;
    }

    public int getType() {
        return this.f6161f;
    }

    public void setContent(String str) {
        this.f6158c = str;
    }

    public void setEndDate(String str) {
        this.f6160e = str;
    }

    public void setNo(int i10) {
        this.f6156a = i10;
    }

    public void setOrder(byte[] bArr) {
        this.f6162g = bArr;
    }

    public void setStartDate(String str) {
        this.f6159d = str;
    }

    public void setTitle(String str) {
        this.f6157b = str;
    }

    public void setType(int i10) {
        this.f6161f = i10;
    }
}
