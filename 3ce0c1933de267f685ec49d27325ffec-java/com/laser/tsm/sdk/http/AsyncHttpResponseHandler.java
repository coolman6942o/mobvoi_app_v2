package com.laser.tsm.sdk.http;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.laser.tsm.sdk.util.LogUtil;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.ByteArrayBuffer;
/* loaded from: classes2.dex */
public abstract class AsyncHttpResponseHandler implements ResponseHandlerInterface {
    protected static final int BUFFER_SIZE = 4096;
    protected static final int CANCEL_MESSAGE = 6;
    public static final String DEFAULT_CAHRSET = "UTF_8";
    protected static final int FALIURE_MESSAGE = 1;
    protected static final int FINISH_MESSAGE = 3;
    protected static final int PROGRESS_MESSAGE = 4;
    protected static final int RETRY_MESSAGE = 5;
    protected static final int START_MESSAGE = 2;
    protected static final int SUCCESS_MESSAGE = 0;
    private Handler handler;
    private boolean useSynchronousMode;
    private String responseCharset = "UTF_8";
    private URI requestURI = null;
    private Header[] requestHeaders = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ResponderHandler extends Handler {
        private final AsyncHttpResponseHandler mResponder;

        public ResponderHandler(AsyncHttpResponseHandler asyncHttpResponseHandler) {
            this.mResponder = asyncHttpResponseHandler;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.mResponder.handleMessage(message);
        }
    }

    public AsyncHttpResponseHandler() {
        setUseSynchronousMode(true);
    }

    private byte[] getResponseData(HttpEntity httpEntity) throws IOException {
        InputStream content;
        if (httpEntity == null || (content = httpEntity.getContent()) == null) {
            return null;
        }
        long contentLength = httpEntity.getContentLength();
        if (contentLength <= 2147483647L) {
            int i10 = (contentLength > 0L ? 1 : (contentLength == 0L ? 0 : -1));
            try {
                ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(i10 < 0 ? 4096 : (int) contentLength);
                byte[] bArr = new byte[4096];
                int i11 = 0;
                while (true) {
                    int read = content.read(bArr);
                    if (read == -1 || Thread.currentThread().isInterrupted()) {
                        break;
                    }
                    i11 += read;
                    byteArrayBuffer.append(bArr, 0, read);
                    sendProgressMessage(i11, (int) (i10 <= 0 ? 1L : contentLength));
                }
                AsyncHttpClient.silentCloseInputStream(content);
                return byteArrayBuffer.toByteArray();
            } catch (OutOfMemoryError unused) {
                System.gc();
                throw new IOException("File too large to fit into available memory");
            }
        } else {
            throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
        }
    }

    private Message obtainMessage(int i10, Object obj) {
        Handler handler = this.handler;
        if (handler != null) {
            return Message.obtain(handler, i10, obj);
        }
        Message obtain = Message.obtain();
        if (obtain == null) {
            return obtain;
        }
        obtain.what = i10;
        obtain.obj = obj;
        return obtain;
    }

    private void sendMessage(Message message) {
        if (getUseSynchronousMode() || this.handler == null) {
            handleMessage(message);
        } else if (!Thread.currentThread().isInterrupted()) {
            this.handler.sendMessage(message);
        }
    }

    public String getCharset() {
        String str = this.responseCharset;
        return str == null ? "UTF_8" : str;
    }

    @Override // com.laser.tsm.sdk.http.ResponseHandlerInterface
    public Header[] getRequestHeaders() {
        return this.requestHeaders;
    }

    @Override // com.laser.tsm.sdk.http.ResponseHandlerInterface
    public URI getRequestURI() {
        return this.requestURI;
    }

    @Override // com.laser.tsm.sdk.http.ResponseHandlerInterface
    public boolean getUseSynchronousMode() {
        return this.useSynchronousMode;
    }

    protected void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 0) {
            Object[] objArr = (Object[]) message.obj;
            if (objArr == null || objArr.length < 3) {
                Log.e("AsyncHttpResponseHandler", "SUCCESS_MESSAGE didn't got enough params");
            } else {
                onSuccess(((Integer) objArr[0]).intValue(), (Header[]) objArr[1], (byte[]) objArr[2]);
            }
        } else if (i10 == 1) {
            Object[] objArr2 = (Object[]) message.obj;
            if (objArr2 == null || objArr2.length < 4) {
                Log.e("AsyncHttpResponseHandler", "FAILURE_MESSAGE didn't got enough params");
            } else {
                onFailure(((Integer) objArr2[0]).intValue(), (Header[]) objArr2[1], (byte[]) objArr2[2], (Throwable) objArr2[3]);
            }
        } else if (i10 == 2) {
            onStart();
        } else if (i10 == 3) {
            onFinish();
        } else if (i10 == 4) {
            Object[] objArr3 = (Object[]) message.obj;
            if (objArr3 == null || objArr3.length < 2) {
                Log.e("AsyncHttpResponseHandler", "PROGRESS_MESSAGE didn't got enough params");
                return;
            }
            try {
                onProgress(((Integer) objArr3[0]).intValue(), ((Integer) objArr3[1]).intValue());
            } catch (Throwable th2) {
                Log.e("AsyncHttpResponseHandler", "custom onProgress contains an error", th2);
            }
        } else if (i10 == 6) {
            onCancel();
        }
    }

    public void onCancel() {
    }

    public abstract void onFailure(int i10, Header[] headerArr, byte[] bArr, Throwable th2);

    public void onFinish() {
    }

    public void onProgress(int i10, int i11) {
    }

    public void onStart() {
    }

    public abstract void onSuccess(int i10, Header[] headerArr, byte[] bArr);

    @Override // com.laser.tsm.sdk.http.ResponseHandlerInterface
    public void sendCancelMessage() {
        sendMessage(obtainMessage(6, null));
    }

    @Override // com.laser.tsm.sdk.http.ResponseHandlerInterface
    public void sendFailureMessage(int i10, Header[] headerArr, byte[] bArr, Throwable th2) {
        sendMessage(obtainMessage(1, new Object[]{Integer.valueOf(i10), headerArr, bArr, th2}));
    }

    @Override // com.laser.tsm.sdk.http.ResponseHandlerInterface
    public void sendFinishMessage() {
        sendMessage(obtainMessage(3, null));
    }

    @Override // com.laser.tsm.sdk.http.ResponseHandlerInterface
    public void sendProgressMessage(int i10, int i11) {
        sendMessage(obtainMessage(4, new Object[]{Integer.valueOf(i10), Integer.valueOf(i11)}));
    }

    @Override // com.laser.tsm.sdk.http.ResponseHandlerInterface
    public void sendResponseMessage(HttpResponse httpResponse) throws IOException {
        if (!Thread.currentThread().isInterrupted()) {
            StatusLine statusLine = httpResponse.getStatusLine();
            byte[] responseData = getResponseData(httpResponse.getEntity());
            if (!Thread.currentThread().isInterrupted()) {
                LogUtil.e("AysncHttpClient", "==>" + statusLine.getStatusCode() + "==" + new String(responseData));
                if (statusLine.getStatusCode() > 300) {
                    sendFailureMessage(statusLine.getStatusCode(), httpResponse.getAllHeaders(), responseData, new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()));
                } else {
                    sendSuccessMessage(statusLine.getStatusCode(), httpResponse.getAllHeaders(), responseData);
                }
            }
        }
    }

    @Override // com.laser.tsm.sdk.http.ResponseHandlerInterface
    public void sendRetryMessage(int i10) {
        sendMessage(obtainMessage(5, new Object[]{Integer.valueOf(i10)}));
    }

    @Override // com.laser.tsm.sdk.http.ResponseHandlerInterface
    public void sendStartMessage() {
        sendMessage(obtainMessage(2, null));
    }

    @Override // com.laser.tsm.sdk.http.ResponseHandlerInterface
    public void sendSuccessMessage(int i10, Header[] headerArr, byte[] bArr) {
        sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(i10), headerArr, bArr}));
    }

    public void setCharset(String str) {
        this.responseCharset = str;
    }

    @Override // com.laser.tsm.sdk.http.ResponseHandlerInterface
    public void setRequestHeaders(Header[] headerArr) {
        this.requestHeaders = headerArr;
    }

    @Override // com.laser.tsm.sdk.http.ResponseHandlerInterface
    public void setRequestURI(URI uri) {
        this.requestURI = uri;
    }

    @Override // com.laser.tsm.sdk.http.ResponseHandlerInterface
    public void setUseSynchronousMode(boolean z10) {
        if (!z10 && Looper.myLooper() == null) {
            z10 = true;
        }
        if (!z10 && this.handler == null) {
            this.handler = new ResponderHandler(this);
        } else if (z10 && this.handler != null) {
            this.handler = null;
        }
        this.useSynchronousMode = z10;
    }
}
