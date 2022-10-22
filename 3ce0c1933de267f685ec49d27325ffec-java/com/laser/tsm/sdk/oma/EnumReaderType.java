package com.laser.tsm.sdk.oma;
/* loaded from: classes2.dex */
public enum EnumReaderType {
    READER_TYPE_SIM("SIM"),
    READER_TYPE_ESE("eSE"),
    READER_TYPE_SD("SD");
    
    private String value;

    EnumReaderType(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
