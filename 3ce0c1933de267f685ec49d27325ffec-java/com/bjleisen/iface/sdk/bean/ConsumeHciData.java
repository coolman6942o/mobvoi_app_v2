package com.bjleisen.iface.sdk.bean;

import com.bjleisen.iface.sdk.enums.EnumCardAppType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ConsumeHciData implements Serializable {
    private static final long serialVersionUID = 1;
    private int cardBalance;
    private EnumCardAppType cardType;
    private int transAmount;
    private int transState;
    private int transType;

    public int getCardBalance() {
        return this.cardBalance;
    }

    public EnumCardAppType getCardType() {
        return this.cardType;
    }

    public int getTransAmount() {
        return this.transAmount;
    }

    public int getTransState() {
        return this.transState;
    }

    public int getTransType() {
        return this.transType;
    }

    public void setCardBalance(int i10) {
        this.cardBalance = i10;
    }

    public void setCardType(EnumCardAppType enumCardAppType) {
        this.cardType = enumCardAppType;
    }

    public void setTransAmount(int i10) {
        this.transAmount = i10;
    }

    public void setTransState(int i10) {
        this.transState = i10;
    }

    public void setTransType(int i10) {
        this.transType = i10;
    }
}
