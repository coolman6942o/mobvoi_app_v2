package com.bjleisen.iface.sdk.bean.resp;
/* loaded from: classes.dex */
public class AppletDetailBusiRespInfo extends BaseBusiRespInfo {
    private String appletDescMsg;
    private String busiIssuer;
    private String cardBigIcon;
    private int cardPrice;
    private String favorableDesc;
    private String favorableId;

    public String getAppletDescMsg() {
        return this.appletDescMsg;
    }

    public String getBusiIssuer() {
        return this.busiIssuer;
    }

    public String getCardBigIcon() {
        return this.cardBigIcon;
    }

    public int getCardPrice() {
        return this.cardPrice;
    }

    public String getFavorableDesc() {
        return this.favorableDesc;
    }

    public String getFavorableId() {
        return this.favorableId;
    }

    public String getOriCardPrice() {
        return String.valueOf(this.cardPrice / 100.0f);
    }

    public void setAppletDescMsg(String str) {
        this.appletDescMsg = str;
    }

    public void setBusiIssuer(String str) {
        this.busiIssuer = str;
    }

    public void setCardBigIcon(String str) {
        this.cardBigIcon = str;
    }

    public void setCardPrice(int i10) {
        this.cardPrice = i10;
    }

    public void setFavorableDesc(String str) {
        this.favorableDesc = str;
    }

    public void setFavorableId(String str) {
        this.favorableId = str;
    }
}
