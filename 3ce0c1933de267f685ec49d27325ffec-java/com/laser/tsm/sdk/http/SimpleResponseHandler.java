package com.laser.tsm.sdk.http;

import com.laser.tsm.sdk.util.LogUtil;
import java.io.UnsupportedEncodingException;
import org.apache.http.Header;
/* loaded from: classes2.dex */
public abstract class SimpleResponseHandler extends AsyncHttpResponseHandler {
    private String getResponseString(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e10) {
            LogUtil.e("", "==>" + e10.getMessage());
            return null;
        }
    }

    public abstract void OnFailure(String str, Throwable th2);

    @Override // com.laser.tsm.sdk.http.AsyncHttpResponseHandler
    public void onFailure(int i10, Header[] headerArr, byte[] bArr, Throwable th2) {
        OnFailure(getResponseString(bArr, getCharset()), th2);
    }

    @Override // com.laser.tsm.sdk.http.AsyncHttpResponseHandler
    public void onSuccess(int i10, Header[] headerArr, byte[] bArr) {
        onSuccess(getResponseString(bArr, getCharset()));
    }

    public abstract void onSuccess(String str);
}
