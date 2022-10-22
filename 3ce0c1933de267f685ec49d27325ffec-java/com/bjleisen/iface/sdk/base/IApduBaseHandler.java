package com.bjleisen.iface.sdk.base;
/* loaded from: classes.dex */
public interface IApduBaseHandler {
    void closeChannel();

    byte[] transiveAPDU(byte[] bArr);
}
