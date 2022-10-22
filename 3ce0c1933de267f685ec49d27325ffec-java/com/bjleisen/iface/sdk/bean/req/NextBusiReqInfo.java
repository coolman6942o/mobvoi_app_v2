package com.bjleisen.iface.sdk.bean.req;

import com.bjleisen.iface.sdk.bean.Rapdu;
import java.util.List;
/* loaded from: classes.dex */
public class NextBusiReqInfo extends BaseBusiReqInfo {
    private List<Rapdu> rapdus;
    private String taskSeqNum;

    public List<Rapdu> getRapdu() {
        return this.rapdus;
    }

    public String getTaskSeqNum() {
        return this.taskSeqNum;
    }

    public void setRapdu(List<Rapdu> list) {
        this.rapdus = list;
    }

    public void setTaskSeqNum(String str) {
        this.taskSeqNum = str;
    }
}
