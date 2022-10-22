package com.bjleisen.iface.sdk.apdu;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bjleisen.bluetooth.DeviceInfo;
import com.bjleisen.bluetooth.IBluetoothInterfaceService;
import com.bjleisen.iface.sdk.bean.Capdu;
import com.bjleisen.iface.sdk.bean.Rapdu;
import com.bjleisen.iface.sdk.enums.EnumStatusCode;
import h9.a;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
/* compiled from: ApduBluetoothRequest.java */
/* loaded from: classes.dex */
public final class b extends c {

    /* renamed from: k  reason: collision with root package name */
    private final String f7737k = "ApduBluetoothRequest";

    public b(Context context, d dVar) {
        super(context, dVar);
    }

    @Override // com.bjleisen.iface.sdk.apdu.c
    protected final void a() {
        this.f7747j = false;
        List<Capdu> list = this.f7741d;
        if (list == null || list.size() == 0) {
            h9.b.g("ApduBluetoothRequest", "capdu list is null");
        } else if (this.f7744g == this.f7741d.size()) {
            h9.b.g("ApduBluetoothRequest", "the last capdu has executed ,no more capdu need to execute");
        } else {
            IBluetoothInterfaceService iBluetoothInterfaceService = LeisenIfaceConfig.f7683aq;
            if (iBluetoothInterfaceService == null) {
                h9.b.g("ApduBluetoothRequest", "bluetoothInterfaceService is null");
                return;
            }
            try {
                h9.b.e("ApduBluetoothRequest", "IBluetoothInterfaceService status:" + iBluetoothInterfaceService.queryBluetoothState());
                if (this.f7747j) {
                    a(-1, new Error("execute apdu interrupt"));
                    return;
                }
                if (!iBluetoothInterfaceService.queryBluetoothState()) {
                    DeviceInfo deviceInfo = LeisenIfaceConfig.aH;
                    if (deviceInfo == null) {
                        EnumStatusCode enumStatusCode = EnumStatusCode.STATUS_CONNECTION_DEVICE_FAILURE;
                        a(enumStatusCode.getStatus(), new Error(enumStatusCode.getMsg()));
                        return;
                    }
                    h9.b.e("ApduBluetoothRequest", "DeviceInfo:" + deviceInfo.getDeviceMac());
                    if (iBluetoothInterfaceService.connectBluetoothDevice(deviceInfo) != 0) {
                        EnumStatusCode enumStatusCode2 = EnumStatusCode.STATUS_CONNECTION_DEVICE_FAILURE;
                        a(enumStatusCode2.getStatus(), new Error(enumStatusCode2.getMsg()));
                        return;
                    }
                }
                if (this.f7747j) {
                    a(-1, new Error("execute apdu interrupt"));
                } else {
                    a(iBluetoothInterfaceService);
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
    }

    private void a(IBluetoothInterfaceService iBluetoothInterfaceService) {
        byte[] bArr;
        String str;
        String str2 = "";
        while (this.f7744g < this.f7741d.size()) {
            if (this.f7747j) {
                a(-1, new Error("execute apdu interrupt"));
                return;
            }
            Capdu capdu = this.f7741d.get(this.f7744g);
            this.f7745h = capdu;
            String cpadu = capdu.getCpadu();
            h9.b.e("ApduBluetoothRequest", "start get apdu index:" + this.f7744g + "==apdu:" + cpadu);
            byte[] c10 = a.c(cpadu);
            if (this.f7747j) {
                a(-1, new Error("execute apdu interrupt"));
                return;
            }
            String str3 = null;
            try {
                if ("00A404".equalsIgnoreCase(cpadu.substring(0, 6))) {
                    bArr = iBluetoothInterfaceService.openSEChannel(c10);
                } else {
                    bArr = iBluetoothInterfaceService.transiveAPDU(c10);
                }
            } catch (Exception unused) {
                bArr = null;
            }
            if (bArr != null) {
                str3 = a.a(bArr);
            }
            h9.b.e("ApduBluetoothRequest", "handle apdu response:" + str3);
            boolean z10 = this.f7747j;
            if (z10) {
                a(-1, new Error("execute apdu interrupt"));
                return;
            } else if (str3 == null) {
                a(this.f7745h.getIndex(), "", "");
                if (this.f7746i) {
                    a(-1, new Error("execute apdu failure: " + this.f7745h.getCpadu()));
                    return;
                }
                a(1);
                return;
            } else if (z10) {
                a(-1, new Error("execute apdu interrupt"));
                return;
            } else {
                if (str3.length() > 4) {
                    str3 = str3.substring(str3.length() - 4, str3.length());
                    str = str3.substring(0, str3.length() - 4).toUpperCase(Locale.getDefault());
                } else {
                    str = "";
                }
                if (str3 != null) {
                    str3 = str3.toUpperCase(Locale.getDefault());
                }
                if (str3.startsWith("6C") && str3.length() == 4) {
                    String substring = str3.substring(2, 4);
                    String cpadu2 = this.f7741d.get(this.f7744g).getCpadu();
                    this.f7741d.get(this.f7744g).setCpadu(cpadu2.substring(0, cpadu2.length() - 2) + substring);
                } else if (str3.startsWith("61")) {
                    str2 = str2 + str;
                    this.f7741d.get(this.f7744g).setCpadu("00C00000" + str3.substring(str3.length() - 2, str3.length()));
                } else {
                    if (!TextUtils.isEmpty(str2)) {
                        str = str2 + str;
                        str2 = "";
                    }
                    a(this.f7745h.getIndex(), str, str3);
                    String[] expSw = this.f7745h.getExpSw();
                    if (expSw == null || expSw.length <= 0 || Arrays.asList(expSw).contains(str3)) {
                        this.f7744g++;
                    } else if (this.f7746i) {
                        a(-1, new Error("return sw error: " + str3));
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
