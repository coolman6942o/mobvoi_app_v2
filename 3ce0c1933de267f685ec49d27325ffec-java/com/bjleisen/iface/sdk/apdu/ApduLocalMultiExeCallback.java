package com.bjleisen.iface.sdk.apdu;

import com.bjleisen.iface.sdk.bean.Rapdu;
/* loaded from: classes.dex */
public interface ApduLocalMultiExeCallback {
    void closeSEChannel();

    Rapdu transiveAPDU(String str);
}
