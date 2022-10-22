package com.laser.tsm.sdk.business;
/* loaded from: classes2.dex */
public class BaseBusinessForReqNext extends BaseBusinessForReq {
    private ApduResBean rapduList;
    private int result;

    public ApduResBean getRapduList() {
        return this.rapduList;
    }

    public int getResult() {
        return this.result;
    }

    public void setRapduList(ApduResBean apduResBean) {
        this.rapduList = apduResBean;
    }

    public void setResult(int i10) {
        this.result = i10;
    }
}
