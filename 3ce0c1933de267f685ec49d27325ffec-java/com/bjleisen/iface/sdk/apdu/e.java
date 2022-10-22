package com.bjleisen.iface.sdk.apdu;

import android.content.Context;
import android.text.TextUtils;
import com.bjleisen.iface.sdk.bean.Capdu;
import com.bjleisen.iface.sdk.bean.Rapdu;
import com.bjleisen.iface.sdk.enums.EnumStatusCode;
import com.bjleisen.iface.sdk.oma.CardResult;
import com.bjleisen.iface.sdk.oma.SmartCard;
import h9.b;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
/* compiled from: ApduSmartCardRequest.java */
/* loaded from: classes.dex */
final class e extends c {

    /* renamed from: k  reason: collision with root package name */
    private static final String f7755k = "ApduSmartCardRequest";

    public e(Context context, d dVar) {
        super(context, dVar);
    }

    private void d() {
        EnumStatusCode enumStatusCode;
        String str;
        String str2 = "";
        while (this.f7744g < this.f7741d.size()) {
            Capdu capdu = this.f7741d.get(this.f7744g);
            this.f7745h = capdu;
            String cpadu = capdu.getCpadu();
            b.e(f7755k, "start execute index:" + this.f7744g + ",capdu:" + cpadu);
            if (this.f7747j) {
                EnumStatusCode enumStatusCode2 = EnumStatusCode.STATUS_USER_CANCEL;
                a(enumStatusCode2.getStatus(), new Error(enumStatusCode2.getMsg()));
                return;
            }
            CardResult execute = SmartCard.getInstance().execute(this.f7740c, cpadu);
            b.e(f7755k, "result status:" + execute.getStatus());
            if (execute.getStatus() != 0) {
                a(EnumStatusCode.STATUS_SMARTCARD_OPER_FAILURE.getStatus(), new Error(enumStatusCode.getMsg() + ":" + execute.getErrorMsg()));
                return;
            }
            String rapdu = execute.getRapdu();
            b.e(f7755k, "handle apdu response:" + rapdu);
            if (TextUtils.isEmpty(rapdu)) {
                a(this.f7745h.getIndex(), "", "");
                if (this.f7746i) {
                    a(-1, new Error("execute apdu failure: " + this.f7745h.getCpadu()));
                    return;
                }
                a(1);
                return;
            }
            if (rapdu.length() > 4) {
                rapdu = rapdu.substring(rapdu.length() - 4, rapdu.length());
                str = rapdu.substring(0, rapdu.length() - 4).toUpperCase(Locale.getDefault());
            } else {
                str = "";
            }
            if (rapdu != null) {
                rapdu = rapdu.toUpperCase(Locale.getDefault());
            }
            if (rapdu.startsWith("6C") && rapdu.length() == 4) {
                String substring = rapdu.substring(2, 4);
                String cpadu2 = this.f7741d.get(this.f7744g).getCpadu();
                this.f7741d.get(this.f7744g).setCpadu(cpadu2.substring(0, cpadu2.length() - 2) + substring);
            } else if (rapdu.startsWith("61")) {
                str2 = str2 + str;
                this.f7741d.get(this.f7744g).setCpadu("00C00000" + rapdu.substring(rapdu.length() - 2, rapdu.length()));
            } else {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2 + str;
                    str2 = "";
                }
                a(this.f7745h.getIndex(), str, rapdu);
                String[] expSw = this.f7745h.getExpSw();
                if (expSw == null || expSw.length <= 0 || Arrays.asList(expSw).contains(rapdu)) {
                    this.f7744g++;
                } else if (this.f7746i) {
                    a(EnumStatusCode.STATUS_SMARTCARD_OPER_FAILURE.getStatus(), new Error("Execute apdu failure"));
                    return;
                } else {
                    a(1);
                    return;
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

    @Override // com.bjleisen.iface.sdk.apdu.c
    protected final synchronized void a() {
        EnumStatusCode enumStatusCode;
        this.f7747j = false;
        List<Capdu> list = this.f7741d;
        if (!(list == null || list.size() == 0)) {
            if (this.f7744g >= this.f7741d.size()) {
                b.g(f7755k, "the last capdu has executed ,no more capdu need to execute");
                return;
            }
            String str = "";
            while (this.f7744g < this.f7741d.size()) {
                Capdu capdu = this.f7741d.get(this.f7744g);
                this.f7745h = capdu;
                String cpadu = capdu.getCpadu();
                b.e(f7755k, "start execute index:" + this.f7744g + ",capdu:" + cpadu);
                if (this.f7747j) {
                    EnumStatusCode enumStatusCode2 = EnumStatusCode.STATUS_USER_CANCEL;
                    a(enumStatusCode2.getStatus(), new Error(enumStatusCode2.getMsg()));
                    return;
                }
                CardResult execute = SmartCard.getInstance().execute(this.f7740c, cpadu);
                b.e(f7755k, "result status:" + execute.getStatus());
                if (execute.getStatus() != 0) {
                    a(EnumStatusCode.STATUS_SMARTCARD_OPER_FAILURE.getStatus(), new Error(enumStatusCode.getMsg() + ":" + execute.getErrorMsg()));
                    return;
                }
                String rapdu = execute.getRapdu();
                b.e(f7755k, "handle apdu response:" + rapdu);
                if (TextUtils.isEmpty(rapdu)) {
                    a(this.f7745h.getIndex(), "", "");
                    if (this.f7746i) {
                        a(-1, new Error("execute apdu failure: " + this.f7745h.getCpadu()));
                        return;
                    }
                    a(1);
                    return;
                }
                String str2 = "";
                if (rapdu.length() > 4) {
                    rapdu = rapdu.substring(rapdu.length() - 4, rapdu.length());
                    str2 = rapdu.substring(0, rapdu.length() - 4).toUpperCase(Locale.getDefault());
                }
                if (rapdu != null) {
                    rapdu = rapdu.toUpperCase(Locale.getDefault());
                }
                if (rapdu.startsWith("6C") && rapdu.length() == 4) {
                    String substring = rapdu.substring(2, 4);
                    String cpadu2 = this.f7741d.get(this.f7744g).getCpadu();
                    this.f7741d.get(this.f7744g).setCpadu(cpadu2.substring(0, cpadu2.length() - 2) + substring);
                } else if (rapdu.startsWith("61")) {
                    str = str + str2;
                    this.f7741d.get(this.f7744g).setCpadu("00C00000" + rapdu.substring(rapdu.length() - 2, rapdu.length()));
                } else {
                    if (!TextUtils.isEmpty(str)) {
                        str2 = str + str2;
                        str = "";
                    }
                    a(this.f7745h.getIndex(), str2, rapdu);
                    String[] expSw = this.f7745h.getExpSw();
                    if (expSw == null || expSw.length <= 0 || Arrays.asList(expSw).contains(rapdu)) {
                        this.f7744g++;
                    } else if (this.f7746i) {
                        a(EnumStatusCode.STATUS_SMARTCARD_OPER_FAILURE.getStatus(), new Error("Execute apdu failure"));
                        return;
                    } else {
                        a(1);
                        return;
                    }
                }
            }
            if (this.f7746i) {
                List<Rapdu> list2 = this.f7742e;
                a(list2.get(list2.size() - 1));
                return;
            }
            a(0);
            return;
        }
        b.f("capdu list is null");
    }
}
