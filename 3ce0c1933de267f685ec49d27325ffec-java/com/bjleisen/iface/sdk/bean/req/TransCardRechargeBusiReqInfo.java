package com.bjleisen.iface.sdk.bean.req;
/* loaded from: classes.dex */
public class TransCardRechargeBusiReqInfo extends BaseBusiReqInfo {
    private String cardNo;
    private String cardTradeNo;
    private int dealType;
    private String lastTradeRecord;
    private ReservedField reservedField;
    private String tranOrderId;
    private int type;

    public String getCardNo() {
        return this.cardNo;
    }

    public String getCardTradeNo() {
        return this.cardTradeNo;
    }

    public int getDealType() {
        return this.dealType;
    }

    public String getLastTradeRecord() {
        return this.lastTradeRecord;
    }

    public ReservedField getReservedField() {
        return this.reservedField;
    }

    public String getTranOrderId() {
        return this.tranOrderId;
    }

    public int getType() {
        return this.type;
    }

    public void setCardNo(String str) {
        this.cardNo = str;
    }

    public void setCardTradeNo(String str) {
        this.cardTradeNo = str;
    }

    public void setDealType(int i10) {
        this.dealType = i10;
    }

    public void setLastTradeRecord(String str) {
        this.lastTradeRecord = str;
    }

    public void setReservedField(ReservedField reservedField) {
        this.reservedField = reservedField;
    }

    public void setTranOrderId(String str) {
        this.tranOrderId = str;
    }

    public void setType(int i10) {
        this.type = i10;
    }
}
