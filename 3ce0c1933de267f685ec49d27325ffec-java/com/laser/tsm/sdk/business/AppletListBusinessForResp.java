package com.laser.tsm.sdk.business;

import com.laser.tsm.sdk.bean.AppInformation;
import java.util.List;
/* loaded from: classes2.dex */
public class AppletListBusinessForResp extends BaseBusinessForResp {
    private List<AppInformation> appInfoList;
    private int total;

    public List<AppInformation> getAppInfoList() {
        return this.appInfoList;
    }

    public int getTotal() {
        return this.total;
    }

    public void setAppInfoList(List<AppInformation> list) {
        this.appInfoList = list;
    }

    public void setTotal(int i10) {
        this.total = i10;
    }
}
