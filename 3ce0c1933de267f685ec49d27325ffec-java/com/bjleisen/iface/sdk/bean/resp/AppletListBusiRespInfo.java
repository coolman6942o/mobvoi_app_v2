package com.bjleisen.iface.sdk.bean.resp;

import com.bjleisen.iface.sdk.bean.Applet;
import java.util.List;
/* loaded from: classes.dex */
public class AppletListBusiRespInfo extends BaseBusiRespInfo {
    private List<Applet> applets;
    private int isHaveErrorOrder;

    public List<Applet> getApplets() {
        return this.applets;
    }

    public int getIsHaveErrorOrder() {
        return this.isHaveErrorOrder;
    }

    public void setApplets(List<Applet> list) {
        this.applets = list;
    }

    public void setIsHaveErrorOrder(int i10) {
        this.isHaveErrorOrder = i10;
    }
}
