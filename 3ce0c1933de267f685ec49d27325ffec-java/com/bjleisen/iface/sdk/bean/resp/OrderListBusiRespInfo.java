package com.bjleisen.iface.sdk.bean.resp;

import com.bjleisen.iface.sdk.bean.BusinessOrderInfo;
import java.util.List;
/* loaded from: classes.dex */
public class OrderListBusiRespInfo extends BaseBusiRespInfo {
    private List<BusinessOrderInfo> orderInfoList;
    private int total;

    public List<BusinessOrderInfo> getOrderInfoList() {
        return this.orderInfoList;
    }

    public int getTotal() {
        return this.total;
    }

    public void setOrderInfoList(List<BusinessOrderInfo> list) {
        this.orderInfoList = list;
    }

    public void setTotal(int i10) {
        this.total = i10;
    }
}
