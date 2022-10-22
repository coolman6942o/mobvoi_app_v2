package com.bjleisen.iface.sdk.bean.resp;

import com.bjleisen.iface.sdk.bean.TradeDetail;
import java.util.List;
/* loaded from: classes.dex */
public class ZytSearchTradeBusiRespInfo extends BaseBusiRespInfo {
    private List<TradeDetail> amtTranDetailsList;
    private String cardNo;
    private int count;
    private int rtnind;

    public List<TradeDetail> getAmtTranDetailsList() {
        return this.amtTranDetailsList;
    }

    public String getCardNo() {
        return this.cardNo;
    }

    public int getCount() {
        return this.count;
    }

    public int getRtnind() {
        return this.rtnind;
    }

    public void setAmtTranDetailsList(List<TradeDetail> list) {
        this.amtTranDetailsList = list;
    }

    public void setCardNo(String str) {
        this.cardNo = str;
    }

    public void setCount(int i10) {
        this.count = i10;
    }

    public void setRtnind(int i10) {
        this.rtnind = i10;
    }
}
