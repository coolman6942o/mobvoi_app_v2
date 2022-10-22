package com.unionpay;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.amap.api.services.core.AMapException;
import com.unionpay.utils.UPUtils;
import com.unionpay.utils.b;
import com.unionpay.utils.i;
import com.unionpay.utils.j;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
final class a implements Handler.Callback {
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003b, code lost:
        if (r11 == false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x014d, code lost:
        if (r11 == false) goto L42;
     */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean handleMessage(Message message) {
        boolean z10;
        String str;
        Context context;
        String str2;
        Context context2;
        String str3;
        String str4;
        Context context3;
        String str5;
        String str6;
        String str7;
        boolean z11;
        JSONArray b10;
        Context context4;
        String str8;
        String str9;
        Context context5;
        JSONArray jSONArray;
        int i10;
        Handler handler;
        boolean z12;
        Context context6;
        String str10 = "0";
        switch (message.what) {
            case 1001:
                boolean unused = UPPayAssistEx.R = true;
                context5 = UPPayAssistEx.I;
                jSONArray = UPPayAssistEx.X;
                i10 = UPPayAssistEx.Q;
                UPPayAssistEx.a(context5, jSONArray, i10);
                break;
            case 1002:
                try {
                    if (message.obj != null) {
                        JSONObject jSONObject = new JSONObject((String) message.obj);
                        String a10 = i.a(jSONObject, "sign");
                        int i11 = 0;
                        try {
                            str9 = UPPayAssistEx.M;
                            i11 = Integer.parseInt(str9);
                        } catch (NumberFormatException unused2) {
                        }
                        String str11 = new String(Base64.decode(jSONObject.getString("configs"), 2));
                        String str12 = "";
                        String str13 = jSONObject.has("sePayConf") ? new String(Base64.decode(jSONObject.getString("sePayConf"), 2)) : str12;
                        if (!TextUtils.isEmpty(str13)) {
                            str12 = str13;
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str11);
                        sb2.append(str12);
                        str = UPPayAssistEx.J;
                        sb2.append(str);
                        String a11 = b.a(UPUtils.a(sb2.toString()));
                        String forConfig = UPUtils.forConfig(i11, a10);
                        if (!TextUtils.isEmpty(forConfig) && forConfig.equals(a11)) {
                            context = UPPayAssistEx.I;
                            StringBuilder sb3 = new StringBuilder("configs");
                            str2 = UPPayAssistEx.E;
                            sb3.append(str2);
                            UPUtils.a(context, (String) message.obj, sb3.toString());
                            context2 = UPPayAssistEx.I;
                            str3 = UPPayAssistEx.M;
                            StringBuilder sb4 = new StringBuilder("mode");
                            str4 = UPPayAssistEx.E;
                            sb4.append(str4);
                            UPUtils.a(context2, str3, sb4.toString());
                            context3 = UPPayAssistEx.I;
                            str5 = UPPayAssistEx.J;
                            StringBuilder sb5 = new StringBuilder("or");
                            str6 = UPPayAssistEx.E;
                            sb5.append(str6);
                            UPUtils.a(context3, str5, sb5.toString());
                            str7 = UPPayAssistEx.C;
                            if (!TextUtils.isEmpty(str7)) {
                                context4 = UPPayAssistEx.I;
                                StringBuilder sb6 = new StringBuilder("se_configs");
                                str8 = UPPayAssistEx.C;
                                sb6.append(str8);
                                UPUtils.a(context4, str12, sb6.toString());
                            }
                            z11 = UPPayAssistEx.R;
                            if (!z11) {
                                b10 = UPPayAssistEx.b(new JSONArray(str11), "sort");
                                JSONArray unused3 = UPPayAssistEx.X = b10;
                                UPPayAssistEx.d(str12);
                            }
                        }
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                z10 = UPPayAssistEx.R;
                break;
            case 1003:
                handler = UPPayAssistEx.U;
                handler.removeMessages(AMapException.CODE_AMAP_DAILY_QUERY_OVER_LIMIT);
                try {
                    if (((Integer) message.obj).intValue() == 1) {
                        str10 = "1";
                    }
                } catch (Exception unused4) {
                }
                z12 = UPPayAssistEx.S;
                break;
            case AMapException.CODE_AMAP_DAILY_QUERY_OVER_LIMIT /* 1004 */:
                j.b("uppay", "QUERY_CAPACITY_TIME_OUT");
                boolean unused5 = UPPayAssistEx.S = true;
                context6 = UPPayAssistEx.I;
                UPPayAssistEx.b(context6, str10);
                break;
        }
        return true;
    }
}
