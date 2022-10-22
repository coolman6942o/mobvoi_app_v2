package com.bjleisen.iface.sdk.bean.resp;

import com.bjleisen.iface.sdk.bean.Favouable;
import java.util.List;
/* loaded from: classes.dex */
public class PayOrderCalculateBusiRespInfo extends BaseBusiRespInfo {
    private List<Favouable> favouables;
    private String orderId;
    private int orgChargeMoney;

    public List<Favouable> getFavouables() {
        return this.favouables;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public int getOrgChargeMoney() {
        return this.orgChargeMoney;
    }

    public void setFavouables(List<Favouable> list) {
        this.favouables = list;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setOrgChargeMoney(int i10) {
        this.orgChargeMoney = i10;
    }
}
