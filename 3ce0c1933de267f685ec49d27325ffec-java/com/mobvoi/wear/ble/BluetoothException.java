package com.mobvoi.wear.ble;

import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class BluetoothException extends Exception {
    private static final long serialVersionUID = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BluetoothException(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BluetoothException(String str, Object... objArr) {
        super(String.format(Locale.US, str, objArr));
    }
}
