package retrofit2;

import java.io.IOException;
import okhttp3.Headers;
import okhttp3.a0;
import okhttp3.s;
import okhttp3.u;
import okhttp3.w;
import okhttp3.x;
import okhttp3.z;
import okio.c;
import okio.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class RequestBuilder {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final String PATH_SEGMENT_ALWAYS_ENCODE_SET = " \"<>^`{}|\\?#";
    private final u baseUrl;
    private a0 body;
    private w contentType;
    private s.a formBuilder;
    private final boolean hasBody;
    private final String method;
    private x.a multipartBuilder;
    private String relativeUrl;
    private final z.a requestBuilder;
    private u.a urlBuilder;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class ContentTypeOverridingRequestBody extends a0 {
        private final w contentType;
        private final a0 delegate;

        ContentTypeOverridingRequestBody(a0 a0Var, w wVar) {
            this.delegate = a0Var;
            this.contentType = wVar;
        }

        @Override // okhttp3.a0
        public long contentLength() throws IOException {
            return this.delegate.contentLength();
        }

        @Override // okhttp3.a0
        public w contentType() {
            return this.contentType;
        }

        @Override // okhttp3.a0
        public void writeTo(d dVar) throws IOException {
            this.delegate.writeTo(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RequestBuilder(String str, u uVar, String str2, Headers headers, w wVar, boolean z10, boolean z11, boolean z12) {
        this.method = str;
        this.baseUrl = uVar;
        this.relativeUrl = str2;
        z.a aVar = new z.a();
        this.requestBuilder = aVar;
        this.contentType = wVar;
        this.hasBody = z10;
        if (headers != null) {
            aVar.i(headers);
        }
        if (z11) {
            this.formBuilder = new s.a();
        } else if (z12) {
            x.a aVar2 = new x.a();
            this.multipartBuilder = aVar2;
            aVar2.d(x.f32303g);
        }
    }

    private static String canonicalizeForPath(String str, boolean z10) {
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            int codePointAt = str.codePointAt(i10);
            if (codePointAt < 32 || codePointAt >= 127 || PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(codePointAt) != -1 || (!z10 && (codePointAt == 47 || codePointAt == 37))) {
                c cVar = new c();
                cVar.a0(str, 0, i10);
                canonicalizeForPath(cVar, str, i10, length, z10);
                return cVar.V();
            }
            i10 += Character.charCount(codePointAt);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addFormField(String str, String str2, boolean z10) {
        if (z10) {
            this.formBuilder.b(str, str2);
        } else {
            this.formBuilder.a(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addHeader(String str, String str2) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            w f10 = w.f(str2);
            if (f10 != null) {
                this.contentType = f10;
                return;
            }
            throw new IllegalArgumentException("Malformed content type: " + str2);
        }
        this.requestBuilder.a(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addPart(Headers headers, a0 a0Var) {
        this.multipartBuilder.a(headers, a0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addPathParam(String str, String str2, boolean z10) {
        String str3 = this.relativeUrl;
        if (str3 != null) {
            this.relativeUrl = str3.replace("{" + str + "}", canonicalizeForPath(str2, z10));
            return;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addQueryParam(String str, String str2, boolean z10) {
        String str3 = this.relativeUrl;
        if (str3 != null) {
            u.a k10 = this.baseUrl.k(str3);
            this.urlBuilder = k10;
            if (k10 != null) {
                this.relativeUrl = null;
            } else {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
        }
        if (z10) {
            this.urlBuilder.a(str, str2);
        } else {
            this.urlBuilder.d(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z build() {
        u uVar;
        u.a aVar = this.urlBuilder;
        if (aVar != null) {
            uVar = aVar.e();
        } else {
            uVar = this.baseUrl.s(this.relativeUrl);
            if (uVar == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
        }
        ContentTypeOverridingRequestBody contentTypeOverridingRequestBody = this.body;
        if (contentTypeOverridingRequestBody == null) {
            s.a aVar2 = this.formBuilder;
            if (aVar2 != null) {
                contentTypeOverridingRequestBody = aVar2.c();
            } else {
                x.a aVar3 = this.multipartBuilder;
                if (aVar3 != null) {
                    contentTypeOverridingRequestBody = aVar3.c();
                } else if (this.hasBody) {
                    contentTypeOverridingRequestBody = a0.create((w) null, new byte[0]);
                }
            }
        }
        w wVar = this.contentType;
        if (wVar != null) {
            if (contentTypeOverridingRequestBody != null) {
                contentTypeOverridingRequestBody = new ContentTypeOverridingRequestBody(contentTypeOverridingRequestBody, wVar);
            } else {
                this.requestBuilder.a("Content-Type", wVar.toString());
            }
        }
        return this.requestBuilder.q(uVar).j(this.method, contentTypeOverridingRequestBody).b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBody(a0 a0Var) {
        this.body = a0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRelativeUrl(Object obj) {
        this.relativeUrl = obj.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addPart(x.c cVar) {
        this.multipartBuilder.b(cVar);
    }

    private static void canonicalizeForPath(c cVar, String str, int i10, int i11, boolean z10) {
        c cVar2 = null;
        while (i10 < i11) {
            int codePointAt = str.codePointAt(i10);
            if (!z10 || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt < 32 || codePointAt >= 127 || PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(codePointAt) != -1 || (!z10 && (codePointAt == 47 || codePointAt == 37))) {
                    if (cVar2 == null) {
                        cVar2 = new c();
                    }
                    cVar2.M0(codePointAt);
                    while (!cVar2.B()) {
                        int readByte = cVar2.readByte() & 255;
                        cVar.C(37);
                        char[] cArr = HEX_DIGITS;
                        cVar.C(cArr[(readByte >> 4) & 15]);
                        cVar.C(cArr[readByte & 15]);
                    }
                } else {
                    cVar.M0(codePointAt);
                }
            }
            i10 += Character.charCount(codePointAt);
        }
    }
}
