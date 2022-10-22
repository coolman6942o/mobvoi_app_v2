package com.laser.tsm.sdk.business;

import com.laser.tsm.sdk.bean.Capdu;
import java.util.List;
/* loaded from: classes2.dex */
public class BaseBusinessForResp extends Business {
    private List<Capdu> capduList;
    private int finishFlag;
    private String operationDes;
    private int operationResult;

    public List<Capdu> getCapdus() {
        return this.capduList;
    }

    public int getFinishFlag() {
        return this.finishFlag;
    }

    public String getOperationDes() {
        return this.operationDes;
    }

    public int getOperationResult() {
        return this.operationResult;
    }

    public void setCapdus(List<Capdu> list) {
        this.capduList = list;
    }

    public void setFinishFlag(int i10) {
        this.finishFlag = i10;
    }

    public void setOperationDes(String str) {
        this.operationDes = str;
    }

    public void setOperationResult(int i10) {
        this.operationResult = i10;
    }
}
