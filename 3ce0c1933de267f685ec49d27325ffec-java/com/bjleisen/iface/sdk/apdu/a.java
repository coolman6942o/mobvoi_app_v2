package com.bjleisen.iface.sdk.apdu;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bjleisen.iface.sdk.base.IApduBaseHandler;
import com.bjleisen.iface.sdk.bean.Capdu;
import com.bjleisen.iface.sdk.bean.Rapdu;
import com.bjleisen.iface.sdk.enums.EnumStatusCode;
import h9.b;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
/* compiled from: ApduBaseHandlerRequest.java */
/* loaded from: classes.dex */
public final class a extends c {

    /* renamed from: k  reason: collision with root package name */
    private final String f7717k = "ApduBaseHandlerRequest";

    public a(Context context, d dVar) {
        super(context, dVar);
    }

    @Override // com.bjleisen.iface.sdk.apdu.c
    protected final void a() {
        this.f7747j = false;
        List<Capdu> list = this.f7741d;
        if (list == null || list.size() == 0) {
            b.g("ApduBaseHandlerRequest", "capdu list is null");
        } else if (this.f7744g == this.f7741d.size()) {
            b.g("ApduBaseHandlerRequest", "the last capdu has executed ,no more capdu need to execute");
        } else {
            IApduBaseHandler iApduBaseHandler = LeisenIfaceConfig.f7682ap;
            if (iApduBaseHandler == null) {
                b.g("ApduBaseHandlerRequest", "bluetoothInterfaceService is null");
                return;
            }
            try {
                if (this.f7747j) {
                    a(-1, new Error("execute apdu interrupt"));
                } else {
                    a(iApduBaseHandler);
                }
            } catch (RemoteException e10) {
                e10.printStackTrace();
                EnumStatusCode enumStatusCode = EnumStatusCode.STATUS_BIND_BLUETOOTHSERVICE_ERROR;
                int status = enumStatusCode.getStatus();
                a(status, new Error(enumStatusCode.getMsg() + ":" + e10.getMessage()));
            } catch (Exception e11) {
                e11.printStackTrace();
                a(-1, new Error("bind server error: " + e11.getMessage()));
            }
        }
    }

    private void a(IApduBaseHandler iApduBaseHandler) {
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
            b.e("ApduBaseHandlerRequest", "start execute index:" + this.f7744g + ",capdu:" + cpadu);
            byte[] c10 = h9.a.c(cpadu);
            byte[] bArr = null;
            if (this.f7747j) {
                a(-1, new Error("execute apdu interrupt"));
                return;
            }
            try {
                bArr = iApduBaseHandler.transiveAPDU(c10);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            if (bArr == null) {
                a(this.f7745h.getIndex(), "", "");
                if (this.f7746i) {
                    a(-1, new Error("execute apdu failure: " + this.f7745h.getCpadu()));
                    return;
                }
                a(1);
                return;
            }
            String a10 = h9.a.a(bArr);
            b.e("ApduBaseHandlerRequest", "handle apdu response:" + a10);
            if (this.f7747j) {
                a(-1, new Error("execute apdu interrupt"));
                return;
            } else if (TextUtils.isEmpty(a10) || a10.length() < 4) {
                a(this.f7745h.getIndex(), "", a10);
                if (this.f7746i) {
                    a(-1, new Error("execute apdu failure: " + this.f7745h.getCpadu()));
                    return;
                }
                a(1);
                return;
            } else if (this.f7747j) {
                a(-1, new Error("execute apdu interrupt"));
                return;
            } else {
                if (a10.length() > 4) {
                    a10 = a10.substring(a10.length() - 4, a10.length());
                    str = a10.substring(0, a10.length() - 4).toUpperCase(Locale.getDefault());
                } else {
                    str = "";
                }
                String upperCase = a10.toUpperCase(Locale.getDefault());
                if (upperCase.startsWith("6C") && upperCase.length() == 4) {
                    String substring = upperCase.substring(2, 4);
                    String cpadu2 = this.f7741d.get(this.f7744g).getCpadu();
                    this.f7741d.get(this.f7744g).setCpadu(cpadu2.substring(0, cpadu2.length() - 2) + substring);
                } else if (upperCase.startsWith("61")) {
                    str2 = str2 + str;
                    this.f7741d.get(this.f7744g).setCpadu("00C00000" + upperCase.substring(upperCase.length() - 2, upperCase.length()));
                } else {
                    if (!TextUtils.isEmpty(str2)) {
                        str = str2 + str;
                        str2 = "";
                    }
                    a(this.f7745h.getIndex(), str, upperCase);
                    String[] expSw = this.f7745h.getExpSw();
                    if (expSw == null || expSw.length <= 0 || Arrays.asList(expSw).contains(upperCase)) {
                        this.f7744g++;
                    } else if (this.f7746i) {
                        a(-1, new Error("return sw error: " + upperCase));
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
