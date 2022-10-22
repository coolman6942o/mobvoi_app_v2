package com.laser.tsm.sdk.oma;
/* loaded from: classes2.dex */
public class SmartCardBean {
    public static final int READER_TYPE_ESE = 1;
    public static final int READER_TYPE_SD = 2;
    public static final int READER_TYPE_SIM = 0;
    private String command;
    private int reader;

    public SmartCardBean(int i10) {
        this.reader = -1;
        this.reader = i10;
    }

    public String getCommand() {
        return this.command;
    }

    public int getReader() {
        return this.reader;
    }

    public String getReaderName() {
        int i10 = this.reader;
        if (i10 == 0) {
            return "SIM";
        }
        if (i10 == 1) {
            return "eSE";
        }
        if (i10 != 2) {
            return null;
        }
        return "SD";
    }

    public void setCommand(String str) {
        this.command = str;
    }

    public void setReader(int i10) {
        this.reader = i10;
    }

    public SmartCardBean(int i10, String str) {
        this.reader = -1;
        this.reader = i10;
        this.command = str;
    }
}
