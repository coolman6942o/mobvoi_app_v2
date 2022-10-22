package com.bjleisen.iface.sdk.bean.resp;

import com.bjleisen.iface.sdk.bean.AbnormalOrder;
import java.util.List;
/* loaded from: classes.dex */
public class AbnormalOrderListBusiRespInfo extends BaseBusiRespInfo {
    private List<AbnormalOrder> orderList;

    public List<AbnormalOrder> getOrderList() {
        return this.orderList;
    }

    public void setOrderList(List<AbnormalOrder> list) {
        this.orderList = list;
    }
}
