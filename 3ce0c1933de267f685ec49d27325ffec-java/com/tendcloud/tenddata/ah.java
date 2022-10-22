package com.tendcloud.tenddata;

import java.io.OutputStream;
import java.net.HttpURLConnection;
/* compiled from: td */
/* loaded from: classes2.dex */
public final class ah {

    /* renamed from: a  reason: collision with root package name */
    private final a f22607a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f22608b;

    /* compiled from: td */
    /* loaded from: classes2.dex */
    public enum a {
        UNIVERSAL_STREAM("application/octet-stream"),
        JSON("application/json"),
        FORM("application/x-www-form-urlencoded"),
        EMPTY("");
        
        private String name;

        a(String str) {
            this.name = str;
        }

        public String getName() {
            return this.name;
        }
    }

    public ah(a aVar, byte[] bArr) {
        this.f22607a = aVar;
        this.f22608b = bArr;
    }

    public byte[] a() {
        return this.f22608b;
    }

    public a b() {
        return this.f22607a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(HttpURLConnection httpURLConnection) {
        OutputStream outputStream;
        httpURLConnection.setFixedLengthStreamingMode(this.f22608b.length);
        httpURLConnection.setRequestProperty("Content-Type", this.f22607a.getName());
        try {
            outputStream = httpURLConnection.getOutputStream();
        } catch (Throwable unused) {
            outputStream = null;
        }
        try {
            try {
                outputStream.write(this.f22608b);
            } catch (Throwable unused2) {
                if (outputStream == null) {
                    return;
                }
                outputStream.close();
            }
            outputStream.close();
        } catch (Throwable unused3) {
        }
    }
}
