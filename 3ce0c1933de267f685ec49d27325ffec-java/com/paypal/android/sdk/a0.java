package com.paypal.android.sdk;

import android.os.Handler;
import android.os.Message;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes2.dex */
public class a0 extends h0 {

    /* renamed from: f  reason: collision with root package name */
    private static final String f20968f = a0.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private Handler f20969a;

    /* renamed from: b  reason: collision with root package name */
    private String f20970b;

    /* renamed from: c  reason: collision with root package name */
    private String f20971c;

    /* renamed from: d  reason: collision with root package name */
    private String f20972d;

    /* renamed from: e  reason: collision with root package name */
    private o f20973e;

    public a0(String str, String str2, String str3, o oVar, Handler handler) {
        this.f20969a = handler;
        this.f20970b = str;
        this.f20971c = str2;
        this.f20972d = str3;
        this.f20973e = oVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00c5, code lost:
        if (r11 == null) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(String str) {
        HttpURLConnection httpURLConnection;
        Throwable th2;
        BufferedReader bufferedReader;
        Exception e10;
        URL url;
        String str2 = "";
        BufferedReader bufferedReader2 = null;
        try {
            url = new URL(str);
            httpURLConnection = (HttpURLConnection) url.openConnection();
        } catch (Exception e11) {
            e10 = e11;
            bufferedReader = null;
            httpURLConnection = null;
        } catch (Throwable th3) {
            th2 = th3;
            httpURLConnection = null;
        }
        try {
            httpURLConnection.setReadTimeout(60000);
            httpURLConnection.setConnectTimeout(60000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("User-Agent", String.format("%s/%s/%s/%s/Android", this.f20973e.a(), this.f20973e.c(), this.f20972d, this.f20971c));
            httpURLConnection.setRequestProperty("Accept-Language", "en-us");
            int responseCode = httpURLConnection.getResponseCode();
            String str3 = f20968f;
            m0.l(str3, "\nSending 'GET' request to URL : " + url);
            m0.l(str3, "Response Code : " + responseCode);
            bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            while (true) {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        str2 = str2 + readLine;
                    } catch (Exception e12) {
                        e10 = e12;
                        Handler handler = this.f20969a;
                        handler.sendMessage(Message.obtain(handler, 1, e10));
                        y1.f(bufferedReader);
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    bufferedReader2 = bufferedReader;
                    y1.f(bufferedReader2);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th2;
                }
            }
            m0.l(f20968f, str2.toString());
            y1.f(bufferedReader);
        } catch (Exception e13) {
            e10 = e13;
            bufferedReader = null;
        } catch (Throwable th5) {
            th2 = th5;
            y1.f(bufferedReader2);
            if (httpURLConnection != null) {
            }
            throw th2;
        }
        httpURLConnection.disconnect();
        return str2;
    }

    @Override // com.paypal.android.sdk.h0, java.lang.Runnable
    public void run() {
        Handler handler = this.f20969a;
        if (handler != null) {
            try {
                try {
                    handler.sendMessage(Message.obtain(handler, 20, this.f20970b));
                    String a10 = a(this.f20970b);
                    m0.l(f20968f, String.format("%s/%s/%s/%s/Android", this.f20973e.a(), this.f20973e.c(), this.f20972d, this.f20971c));
                    Handler handler2 = this.f20969a;
                    handler2.sendMessage(Message.obtain(handler2, 22, a10.toString()));
                } catch (Exception e10) {
                    Handler handler3 = this.f20969a;
                    handler3.sendMessage(Message.obtain(handler3, 21, e10));
                }
            } finally {
                i0.a().d(this);
            }
        }
    }
}
