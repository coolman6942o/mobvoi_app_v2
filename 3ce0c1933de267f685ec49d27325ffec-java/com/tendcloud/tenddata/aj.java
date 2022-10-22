package com.tendcloud.tenddata;

import java.net.HttpURLConnection;
/* compiled from: td */
/* loaded from: classes2.dex */
public enum aj {
    GET(false),
    POST(true);
    

    /* renamed from: c  reason: collision with root package name */
    private final boolean f22613c;

    aj(boolean z10) {
        this.f22613c = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.setRequestMethod(name());
            httpURLConnection.setDoOutput(this.f22613c);
            httpURLConnection.setDoInput(true);
        } catch (Throwable unused) {
        }
    }
}
