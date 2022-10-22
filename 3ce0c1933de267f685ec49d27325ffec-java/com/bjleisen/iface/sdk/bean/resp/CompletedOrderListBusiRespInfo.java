package com.bjleisen.iface.sdk.bean.resp;

import com.bjleisen.iface.sdk.bean.OrderInfo;
import java.util.List;
/* loaded from: classes.dex */
public class CompletedOrderListBusiRespInfo extends BaseBusiRespInfo {
    private List<OrderInfo> orderInfos;
    private int total;

    public List<OrderInfo> getOrderInfos() {
        return this.orderInfos;
    }

    public int getTotal() {
        return this.total;
    }

    public void setOrderInfos(List<OrderInfo> list) {
        this.orderInfos = list;
    }

    public void setTotal(int i10) {
        this.total = i10;
    }
}
