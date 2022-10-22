package gi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.setting.CompanionSetting;
import com.mobvoi.mcuwatch.engine.l;
import com.mobvoi.mcuwatch.notify.NotificationService;
import nj.q;
import pk.f;
import qi.j;
/* compiled from: McuModelReceiver.java */
/* loaded from: classes2.dex */
public class a extends BroadcastReceiver {
    private void a(String str, String str2) {
        f a10;
        if (!TextUtils.isEmpty(str) && (a10 = mi.a.a()) != null) {
            String b10 = a10.b();
            if (!TextUtils.isEmpty(b10) && b10.contains("TicWatch GTH Pro")) {
                String a11 = a10.a();
                if (!TextUtils.isEmpty(a11) && ci.a.b().f(a11)) {
                    ii.a.e(str2);
                    l.f19166a.u(str);
                }
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.provider.Telephony.SMS_RECEIVED".equals(intent.getAction())) {
            try {
                Object[] objArr = (Object[]) intent.getExtras().get("pdus");
                int length = objArr.length;
                SmsMessage[] smsMessageArr = new SmsMessage[length];
                for (int i10 = 0; i10 < objArr.length; i10++) {
                    smsMessageArr[i10] = SmsMessage.createFromPdu((byte[]) objArr[i10]);
                }
                for (int i11 = 0; i11 < length; i11++) {
                    SmsMessage smsMessage = smsMessageArr[i11];
                    String originatingAddress = smsMessage.getOriginatingAddress();
                    Cursor query = b.e().getContentResolver().query(Uri.parse("content://com.android.contacts/data/phones/filter/" + originatingAddress), new String[]{"display_name"}, null, null, null);
                    if (query != null && query.moveToFirst()) {
                        originatingAddress = query.getString(0);
                        k.c("McuModelReceiver", "短信发件人：%s", originatingAddress);
                        query.close();
                    }
                    NotificationService.h(3, originatingAddress, smsMessage.getDisplayMessageBody());
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        } else if ("com.mobvoi.action.notification.bin".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("extra.notification_id");
            if (!stringExtra.equals(ii.a.a())) {
                a(intent.getStringExtra("extra.notification"), stringExtra);
            }
        } else if (j.f33166f.equals(intent.getAction())) {
            if (q.g().p(3)) {
                q.g().n();
            }
        } else if (j.f33167g.equals(intent.getAction())) {
            CompanionSetting.setArtyJsonWebToken("");
        }
    }
}
