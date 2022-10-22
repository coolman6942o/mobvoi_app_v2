package com.bjleisen.iface.sdk.bean.resp;

import com.bjleisen.iface.sdk.bean.Capdu;
import java.util.List;
/* loaded from: classes.dex */
public class NextBusiRespInfo extends BaseBusiRespInfo {
    private List<Capdu> capdus;
    private int finishFlag;
    private int rapduRespFlag;
    private String taskSeqNum;

    public List<Capdu> getCapdus() {
        return this.capdus;
    }

    public int getFinishFlag() {
        return this.finishFlag;
    }

    public int getRapduRespFlag() {
        return this.rapduRespFlag;
    }

    public String getTaskSeqNum() {
        return this.taskSeqNum;
    }

    public void setCapdus(List<Capdu> list) {
        this.capdus = list;
    }

    public void setFinishFlag(int i10) {
        this.finishFlag = i10;
    }

    public void setRapduRespFlag(int i10) {
        this.rapduRespFlag = i10;
    }

    public void setTaskSeqNum(String str) {
        this.taskSeqNum = str;
    }
}
