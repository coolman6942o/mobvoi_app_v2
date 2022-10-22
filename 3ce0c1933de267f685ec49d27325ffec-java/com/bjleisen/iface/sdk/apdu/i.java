package com.bjleisen.iface.sdk.apdu;

import android.content.Context;
import android.os.RemoteException;
import com.bjleisen.bluetooth.DeviceInfo;
import com.bjleisen.bluetooth.IMultiBluetoothInterface;
import com.bjleisen.iface.sdk.bean.Capdu;
import com.bjleisen.iface.sdk.bean.Rapdu;
import com.bjleisen.iface.sdk.enums.EnumStatusCode;
import h9.b;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
/* compiled from: MultiApduBluetoothRequest.java */
/* loaded from: classes.dex */
public final class i extends c {

    /* renamed from: k  reason: collision with root package name */
    private final String f7758k = "MultiApduBluetoothRequest";

    public i(Context context, d dVar) {
        super(context, dVar);
    }

    @Override // com.bjleisen.iface.sdk.apdu.c
    protected final void a() {
        this.f7747j = false;
        List<Capdu> list = this.f7741d;
        if (list == null || list.size() == 0) {
            b.g("MultiApduBluetoothRequest", "capdu list is null");
            return;
        }
        IMultiBluetoothInterface iMultiBluetoothInterface = LeisenIfaceConfig.ar;
        if (iMultiBluetoothInterface == null) {
            b.g("MultiApduBluetoothRequest", "bluetooth service is null");
            return;
        }
        try {
            b.d("status:" + iMultiBluetoothInterface.queryBluetoothState());
            if (this.f7747j) {
                a(-1, new Error("execute apdu interrupt"));
                return;
            }
            if (!iMultiBluetoothInterface.queryBluetoothState()) {
                DeviceInfo deviceInfo = LeisenIfaceConfig.aH;
                if (deviceInfo == null) {
                    EnumStatusCode enumStatusCode = EnumStatusCode.STATUS_CONNECTION_DEVICE_FAILURE;
                    a(enumStatusCode.getStatus(), new Error(enumStatusCode.getMsg()));
                    return;
                } else if (iMultiBluetoothInterface.connectBluetoothDevice(deviceInfo) != 0) {
                    EnumStatusCode enumStatusCode2 = EnumStatusCode.STATUS_CONNECTION_DEVICE_FAILURE;
                    a(enumStatusCode2.getStatus(), new Error(enumStatusCode2.getMsg()));
                    return;
                }
            }
            if (this.f7747j) {
                a(-1, new Error("execute apdu interrupt"));
            } else {
                a(iMultiBluetoothInterface);
            }
        } catch (RemoteException e10) {
            e10.printStackTrace();
            EnumStatusCode enumStatusCode3 = EnumStatusCode.STATUS_BIND_BLUETOOTHSERVICE_ERROR;
            int status = enumStatusCode3.getStatus();
            a(status, new Error(enumStatusCode3.getMsg() + ":" + e10.getMessage()));
        } catch (Exception e11) {
            e11.printStackTrace();
            a(-1, new Error("bind server error: " + e11.getMessage()));
        }
    }

    private void a(IMultiBluetoothInterface iMultiBluetoothInterface) {
        List<Rapdu> transiveAPDU = iMultiBluetoothInterface.transiveAPDU(this.f7741d);
        b.e("MultiApduBluetoothRequest", "rapduList:" + transiveAPDU);
        for (int i10 = 0; i10 < transiveAPDU.size(); i10++) {
            Rapdu rapdu = transiveAPDU.get(i10);
            if (rapdu == null) {
                a(this.f7741d.get(i10).getIndex(), "", "");
                if (this.f7746i) {
                    a(-1, new Error("execute apdu failure: " + this.f7741d.get(i10).getCpadu()));
                    return;
                }
                a(1);
                return;
            } else if (this.f7747j) {
                a(-1, new Error("execute apdu interrupt"));
                return;
            } else {
                String sw = rapdu.getSw();
                if (sw != null) {
                    sw = sw.toUpperCase(Locale.getDefault());
                }
                a(rapdu.getIndex(), rapdu.getRapdu(), rapdu.getSw());
                String[] expSw = this.f7741d.get(i10).getExpSw();
                if (expSw != null && expSw.length > 0 && !Arrays.asList(expSw).contains(sw)) {
                    if (this.f7746i) {
                        a(-1, new Error("return sw error: " + rapdu.getSw()));
                        return;
                    } else {
                        a(1);
                        return;
                    }
                }
            }
        }
        if (this.f7746i) {
            List<Rapdu> list = this.f7742e;
            a(list.get(list.size() - 1));
            return;
        }
        a(0);
    }
}
