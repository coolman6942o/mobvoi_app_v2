package com.laser.utils.apdu;
/* loaded from: classes2.dex */
public class GenerateAPDUException extends Exception {
    private static final long serialVersionUID = 1;

    public GenerateAPDUException() {
        super("generate APDU error!");
    }

    public GenerateAPDUException(String str) {
        super(str);
    }

    public GenerateAPDUException(String str, Throwable th2) {
        super(str, th2);
    }
}
