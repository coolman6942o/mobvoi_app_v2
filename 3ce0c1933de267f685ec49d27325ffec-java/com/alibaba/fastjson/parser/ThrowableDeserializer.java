package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ThrowableDeserializer extends JavaBeanDeserializer {
    public ThrowableDeserializer(ParserConfig parserConfig, Class<?> cls) {
        super(parserConfig, cls, cls);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
        if (java.lang.Throwable.class.isAssignableFrom(r1) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00d3, code lost:
        if (r1 != null) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d5, code lost:
        r0 = (T) new java.lang.Exception(r11, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00dc, code lost:
        r0 = r1.getConstructors();
        r1 = r0.length;
        r4 = null;
        r5 = null;
        r8 = null;
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00e6, code lost:
        if (r3 >= r1) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00e8, code lost:
        r13 = r0[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ef, code lost:
        if (r13.getParameterTypes().length != 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00f1, code lost:
        r8 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00f8, code lost:
        if (r13.getParameterTypes().length != 1) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0101, code lost:
        if (r13.getParameterTypes()[0] != java.lang.String.class) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0103, code lost:
        r5 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x010b, code lost:
        if (r13.getParameterTypes().length != 2) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0114, code lost:
        if (r13.getParameterTypes()[0] != java.lang.String.class) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x011e, code lost:
        if (r13.getParameterTypes()[1] != java.lang.Throwable.class) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0120, code lost:
        r4 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0121, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0124, code lost:
        if (r4 == null) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0126, code lost:
        r6 = (java.lang.Throwable) r4.newInstance(r11, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0136, code lost:
        if (r5 == null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0138, code lost:
        r6 = (java.lang.Throwable) r5.newInstance(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0145, code lost:
        if (r8 == null) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0147, code lost:
        r6 = (java.lang.Throwable) r8.newInstance(new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0151, code lost:
        if (r6 != null) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0153, code lost:
        r0 = (T) new java.lang.Exception(r11, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0159, code lost:
        r0 = (T) r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x015a, code lost:
        if (r12 == null) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x015c, code lost:
        ((java.lang.Throwable) r0).setStackTrace(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x015f, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0160, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0168, code lost:
        throw new com.alibaba.fastjson.JSONException("create instance error", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00d0 A[SYNTHETIC] */
    @Override // com.alibaba.fastjson.parser.JavaBeanDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Class<?> cls;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i10 = jSONLexer.token;
        Throwable th2 = null;
        if (i10 == 8) {
            jSONLexer.nextToken();
            return null;
        }
        if (defaultJSONParser.resolveStatus == 2) {
            defaultJSONParser.resolveStatus = 0;
        } else if (i10 != 12) {
            throw new JSONException("syntax error");
        }
        if (type != null && (type instanceof Class)) {
            cls = (Class) type;
        }
        cls = null;
        HashMap hashMap = new HashMap();
        Throwable th3 = null;
        String str = null;
        StackTraceElement[] stackTraceElementArr = null;
        while (true) {
            String scanSymbol = jSONLexer.scanSymbol(defaultJSONParser.symbolTable);
            if (scanSymbol == null) {
                int i11 = jSONLexer.token;
                if (i11 == 13) {
                    jSONLexer.nextToken(16);
                    break;
                } else if (i11 == 16) {
                }
            }
            jSONLexer.nextTokenWithChar(':');
            if (JSON.DEFAULT_TYPE_KEY.equals(scanSymbol)) {
                if (jSONLexer.token == 4) {
                    cls = TypeUtils.loadClass(jSONLexer.stringVal(), defaultJSONParser.config.defaultClassLoader);
                    jSONLexer.nextToken(16);
                } else {
                    throw new JSONException("syntax error");
                }
            } else if ("message".equals(scanSymbol)) {
                int i12 = jSONLexer.token;
                if (i12 == 8) {
                    str = null;
                } else if (i12 == 4) {
                    str = jSONLexer.stringVal();
                } else {
                    throw new JSONException("syntax error");
                }
                jSONLexer.nextToken();
            } else {
                if ("cause".equals(scanSymbol)) {
                    th3 = (Throwable) deserialze(defaultJSONParser, null, "cause");
                } else if ("stackTrace".equals(scanSymbol)) {
                    stackTraceElementArr = (StackTraceElement[]) defaultJSONParser.parseObject((Class<Object>) StackTraceElement[].class);
                } else {
                    hashMap.put(scanSymbol, defaultJSONParser.parse());
                }
                if (jSONLexer.token != 13) {
                    jSONLexer.nextToken(16);
                    break;
                }
            }
            if (jSONLexer.token != 13) {
            }
        }
    }
}
