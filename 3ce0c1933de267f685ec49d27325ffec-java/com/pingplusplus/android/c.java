package com.pingplusplus.android;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Message;
import com.unionpay.tsmservice.data.Constant;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.net.ssl.HttpsURLConnection;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f22087a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ PaymentActivity f22088b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PaymentActivity paymentActivity, String str) {
        this.f22088b = paymentActivity;
        this.f22087a = str;
    }

    @Override // java.lang.Runnable
    @TargetApi(11)
    public void run() {
        HttpsURLConnection j10;
        Handler handler;
        Handler handler2;
        try {
            j10 = this.f22088b.j(this.f22087a);
            if (j10.getResponseCode() == 302) {
                handler = this.f22088b.f22084i;
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.obj = this.f22087a;
                obtainMessage.what = 4;
                handler2 = this.f22088b.f22084i;
                handler2.sendMessage(obtainMessage);
                return;
            }
            this.f22088b.d(Constant.CASH_LOAD_FAIL);
        } catch (MalformedURLException e10) {
            this.f22088b.e(Constant.CASH_LOAD_FAIL, "url is invalid");
            e10.printStackTrace();
        } catch (IOException e11) {
            this.f22088b.e(Constant.CASH_LOAD_FAIL, "url is invalid");
            e11.printStackTrace();
        } catch (Exception e12) {
            this.f22088b.e(Constant.CASH_LOAD_FAIL, "url is invalid");
            e12.printStackTrace();
        }
    }
}
