package com.ta.utdid2.b.a;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import org.xmlpull.v1.XmlSerializer;
/* loaded from: classes2.dex */
public class a implements XmlSerializer {

    /* renamed from: a  reason: collision with root package name */
    public static String f22421a = "xmlpull.org/v1/doc/features.html#indent-output";

    /* renamed from: a  reason: collision with other field name */
    public static final String[] f5a = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&quot;", null, null, null, "&amp;", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&lt;", null, "&gt;", null};

    /* renamed from: a  reason: collision with other field name */
    public OutputStream f6a;

    /* renamed from: a  reason: collision with other field name */
    public Writer f7a;

    /* renamed from: a  reason: collision with other field name */
    public CharsetEncoder f9a;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22422e;
    public int mPos;

    /* renamed from: a  reason: collision with other field name */
    public final char[] f10a = new char[8192];

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f8a = ByteBuffer.allocate(8192);

    private void a(String str, int i10, int i11) throws IOException {
        if (i11 > 8192) {
            int i12 = i11 + i10;
            while (i10 < i12) {
                int i13 = i10 + 8192;
                a(str, i10, i13 < i12 ? 8192 : i12 - i10);
                i10 = i13;
            }
            return;
        }
        int i14 = this.mPos;
        if (i14 + i11 > 8192) {
            flush();
            i14 = this.mPos;
        }
        str.getChars(i10, i10 + i11, this.f10a, i14);
        this.mPos = i14 + i11;
    }

    private void append(char c10) throws IOException {
        int i10 = this.mPos;
        if (i10 >= 8191) {
            flush();
            i10 = this.mPos;
        }
        this.f10a[i10] = c10;
        this.mPos = i10 + 1;
    }

    public static String d() {
        return "http://" + f22421a;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer attribute(String str, String str2, String str3) throws IOException, IllegalArgumentException, IllegalStateException {
        append(' ');
        if (str != null) {
            append(str);
            append(':');
        }
        append(str2);
        append("=\"");
        a(str3);
        append('\"');
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void cdsect(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void comment(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void docdecl(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void endDocument() throws IOException, IllegalArgumentException, IllegalStateException {
        flush();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer endTag(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.f22422e) {
            append(" />\n");
        } else {
            append("</");
            if (str != null) {
                append(str);
                append(':');
            }
            append(str2);
            append(">\n");
        }
        this.f22422e = false;
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void entityRef(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void flush() throws IOException {
        int i10 = this.mPos;
        if (i10 > 0) {
            if (this.f6a != null) {
                CharBuffer wrap = CharBuffer.wrap(this.f10a, 0, i10);
                CoderResult encode = this.f9a.encode(wrap, this.f8a, true);
                while (!encode.isError()) {
                    if (encode.isOverflow()) {
                        a();
                        encode = this.f9a.encode(wrap, this.f8a, true);
                    } else {
                        a();
                        this.f6a.flush();
                    }
                }
                throw new IOException(encode.toString());
            }
            this.f7a.write(this.f10a, 0, i10);
            this.f7a.flush();
            this.mPos = 0;
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public int getDepth() {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public boolean getFeature(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getName() {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getNamespace() {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getPrefix(String str, boolean z10) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public Object getProperty(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void ignorableWhitespace(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void processingInstruction(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setFeature(String str, boolean z10) throws IllegalArgumentException, IllegalStateException {
        if (!str.equals(d())) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setOutput(OutputStream outputStream, String str) throws IOException, IllegalArgumentException, IllegalStateException {
        if (outputStream != null) {
            try {
                this.f9a = Charset.forName(str).newEncoder();
                this.f6a = outputStream;
            } catch (IllegalCharsetNameException e10) {
                throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e10));
            } catch (UnsupportedCharsetException e11) {
                throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e11));
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setPrefix(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setProperty(String str, Object obj) throws IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void startDocument(String str, Boolean bool) throws IOException, IllegalArgumentException, IllegalStateException {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<?xml version='1.0' encoding='utf-8' standalone='");
        sb2.append(bool.booleanValue() ? "yes" : "no");
        sb2.append("' ?>\n");
        append(sb2.toString());
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer startTag(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.f22422e) {
            append(">\n");
        }
        append('<');
        if (str != null) {
            append(str);
            append(':');
        }
        append(str2);
        this.f22422e = true;
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer text(char[] cArr, int i10, int i11) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.f22422e) {
            append(">");
            this.f22422e = false;
        }
        a(cArr, i10, i11);
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer text(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.f22422e) {
            append(">");
            this.f22422e = false;
        }
        a(str);
        return this;
    }

    private void append(char[] cArr, int i10, int i11) throws IOException {
        if (i11 > 8192) {
            int i12 = i11 + i10;
            while (i10 < i12) {
                int i13 = i10 + 8192;
                append(cArr, i10, i13 < i12 ? 8192 : i12 - i10);
                i10 = i13;
            }
            return;
        }
        int i14 = this.mPos;
        if (i14 + i11 > 8192) {
            flush();
            i14 = this.mPos;
        }
        System.arraycopy(cArr, i10, this.f10a, i14, i11);
        this.mPos = i14 + i11;
    }

    private void a(String str) throws IOException {
        String str2;
        int length = str.length();
        String[] strArr = f5a;
        char length2 = (char) strArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            char charAt = str.charAt(i10);
            if (charAt < length2 && (str2 = strArr[charAt]) != null) {
                if (i11 < i10) {
                    a(str, i11, i10 - i11);
                }
                i11 = i10 + 1;
                append(str2);
            }
            i10++;
        }
        if (i11 < i10) {
            a(str, i11, i10 - i11);
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setOutput(Writer writer) throws IOException, IllegalArgumentException, IllegalStateException {
        this.f7a = writer;
    }

    private void append(String str) throws IOException {
        a(str, 0, str.length());
    }

    private void a(char[] cArr, int i10, int i11) throws IOException {
        String str;
        String[] strArr = f5a;
        char length = (char) strArr.length;
        int i12 = i11 + i10;
        int i13 = i10;
        while (i10 < i12) {
            char c10 = cArr[i10];
            if (c10 < length && (str = strArr[c10]) != null) {
                if (i13 < i10) {
                    append(cArr, i13, i10 - i13);
                }
                i13 = i10 + 1;
                append(str);
            }
            i10++;
        }
        if (i13 < i10) {
            append(cArr, i13, i10 - i13);
        }
    }

    private void a() throws IOException {
        int position = this.f8a.position();
        if (position > 0) {
            this.f8a.flip();
            this.f6a.write(this.f8a.array(), 0, position);
            this.f8a.clear();
        }
    }
}
