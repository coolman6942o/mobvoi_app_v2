package com.bjleisen.iface.sdk.apdu;

import android.content.Context;
import android.text.TextUtils;
import com.bjleisen.iface.sdk.bean.Capdu;
import com.bjleisen.iface.sdk.bean.Rapdu;
import com.bjleisen.iface.sdk.nfc.NfcOperator;
import h9.b;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
/* compiled from: NfcApduRequest.java */
/* loaded from: classes.dex */
public final class j extends c {
    public j(Context context, d dVar) {
        super(context, dVar);
    }

    private void d() {
        String str;
        List<Capdu> list = this.f7741d;
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("capduList is null or empty");
        }
        String str2 = "";
        while (this.f7744g < this.f7741d.size()) {
            Capdu capdu = this.f7741d.get(this.f7744g);
            this.f7745h = capdu;
            try {
                String execute = NfcOperator.getInstance().execute(capdu.getCpadu());
                b.d("handle apdu response:" + execute);
                if (execute == null) {
                    a(this.f7745h.getIndex(), "", "");
                    if (this.f7746i) {
                        a(-1, new Error("execute apdu failure: " + this.f7745h.getCpadu()));
                        return;
                    }
                    a(1);
                    return;
                }
                if (execute.length() > 4) {
                    execute = execute.substring(execute.length() - 4, execute.length());
                    str = execute.substring(0, execute.length() - 4).toUpperCase(Locale.getDefault());
                } else {
                    str = "";
                }
                if (execute != null) {
                    execute = execute.toUpperCase(Locale.getDefault());
                }
                b.d("get response res_sw:" + execute);
                if (execute.startsWith("6C") && execute.length() == 4) {
                    String substring = execute.substring(2, 4);
                    String cpadu = this.f7741d.get(this.f7744g).getCpadu();
                    this.f7741d.get(this.f7744g).setCpadu(cpadu.substring(0, cpadu.length() - 2) + substring);
                } else if (execute.startsWith("61")) {
                    str2 = str2 + str;
                    this.f7741d.get(this.f7744g).setCpadu("00C00000" + execute.substring(execute.length() - 2, execute.length()));
                } else {
                    if (!TextUtils.isEmpty(str2)) {
                        str = str2 + str;
                        str2 = "";
                    }
                    a(this.f7745h.getIndex(), str, execute);
                    String[] expSw = this.f7745h.getExpSw();
                    if (expSw == null || expSw.length <= 0 || Arrays.asList(expSw).contains(execute)) {
                        this.f7744g++;
                    } else if (this.f7746i) {
                        a(-1, new Error("return sw error: " + execute));
                        return;
                    } else {
                        a(1);
                        return;
                    }
                }
            } catch (IOException e10) {
                e10.printStackTrace();
                if (this.f7746i) {
                    a(-1, new Error("execute apdu process error," + e10.getMessage()));
                    return;
                }
                a(1);
                return;
            }
        }
        if (this.f7746i) {
            List<Rapdu> list2 = this.f7742e;
            a(list2.get(list2.size() - 1));
            return;
        }
        a(0);
    }

    @Override // com.bjleisen.iface.sdk.apdu.c
    protected final void a() {
        String str;
        List<Capdu> list = this.f7741d;
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("capduList is null or empty");
        }
        String str2 = "";
        while (this.f7744g < this.f7741d.size()) {
            Capdu capdu = this.f7741d.get(this.f7744g);
            this.f7745h = capdu;
            try {
                String execute = NfcOperator.getInstance().execute(capdu.getCpadu());
                b.d("handle apdu response:" + execute);
                if (execute == null) {
                    a(this.f7745h.getIndex(), "", "");
                    if (this.f7746i) {
                        a(-1, new Error("execute apdu failure: " + this.f7745h.getCpadu()));
                        return;
                    }
                    a(1);
                    return;
                }
                if (execute.length() > 4) {
                    execute = execute.substring(execute.length() - 4, execute.length());
                    str = execute.substring(0, execute.length() - 4).toUpperCase(Locale.getDefault());
                } else {
                    str = "";
                }
                if (execute != null) {
                    execute = execute.toUpperCase(Locale.getDefault());
                }
                b.d("get response res_sw:" + execute);
                if (execute.startsWith("6C") && execute.length() == 4) {
                    String substring = execute.substring(2, 4);
                    String cpadu = this.f7741d.get(this.f7744g).getCpadu();
                    this.f7741d.get(this.f7744g).setCpadu(cpadu.substring(0, cpadu.length() - 2) + substring);
                } else if (execute.startsWith("61")) {
                    str2 = str2 + str;
                    this.f7741d.get(this.f7744g).setCpadu("00C00000" + execute.substring(execute.length() - 2, execute.length()));
                } else {
                    if (!TextUtils.isEmpty(str2)) {
                        str = str2 + str;
                        str2 = "";
                    }
                    a(this.f7745h.getIndex(), str, execute);
                    String[] expSw = this.f7745h.getExpSw();
                    if (expSw == null || expSw.length <= 0 || Arrays.asList(expSw).contains(execute)) {
                        this.f7744g++;
                    } else if (this.f7746i) {
                        a(-1, new Error("return sw error: " + execute));
                        return;
                    } else {
                        a(1);
                        return;
                    }
                }
            } catch (IOException e10) {
                e10.printStackTrace();
                if (this.f7746i) {
                    a(-1, new Error("execute apdu process error," + e10.getMessage()));
                    return;
                }
                a(1);
                return;
            }
        }
        if (this.f7746i) {
            List<Rapdu> list2 = this.f7742e;
            a(list2.get(list2.size() - 1));
            return;
        }
        a(0);
    }
}
