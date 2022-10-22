package org.json.alipay;

import com.mobvoi.wear.lpa.LpaConstants;
import com.unionpay.tsmservice.data.Constant;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f32513a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    public Map f32514b;

    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(byte b10) {
            this();
        }

        public final Object clone() {
            return this;
        }

        public final boolean equals(Object obj) {
            return obj == null || obj == this;
        }

        public final String toString() {
            return LpaConstants.VALUE_NULL;
        }
    }

    public b() {
        this.f32514b = new HashMap();
    }

    public b(String str) {
        this(new c(str));
    }

    public b(Map map) {
        this.f32514b = map == null ? new HashMap() : map;
    }

    public b(c cVar) {
        this();
        if (cVar.c() == '{') {
            while (true) {
                char c10 = cVar.c();
                if (c10 == 0) {
                    throw cVar.a("A JSONObject text must end with '}'");
                } else if (c10 != '}') {
                    cVar.a();
                    String obj = cVar.d().toString();
                    char c11 = cVar.c();
                    if (c11 == '=') {
                        if (cVar.b() != '>') {
                            cVar.a();
                        }
                    } else if (c11 != ':') {
                        throw cVar.a("Expected a ':' after a key");
                    }
                    Object d10 = cVar.d();
                    if (obj != null) {
                        if (d10 != null) {
                            b(d10);
                            this.f32514b.put(obj, d10);
                        } else {
                            this.f32514b.remove(obj);
                        }
                        char c12 = cVar.c();
                        if (c12 == ',' || c12 == ';') {
                            if (cVar.c() != '}') {
                                cVar.a();
                            } else {
                                return;
                            }
                        } else if (c12 != '}') {
                            throw cVar.a("Expected a ',' or '}'");
                        } else {
                            return;
                        }
                    } else {
                        throw new JSONException("Null key.");
                    }
                } else {
                    return;
                }
            }
        } else {
            throw cVar.a("A JSONObject text must begin with '{'");
        }
    }

    public static String a(Object obj) {
        if (obj == null || obj.equals(null)) {
            return LpaConstants.VALUE_NULL;
        }
        if (!(obj instanceof Number)) {
            return ((obj instanceof Boolean) || (obj instanceof b) || (obj instanceof org.json.alipay.a)) ? obj.toString() : obj instanceof Map ? new b((Map) obj).toString() : obj instanceof Collection ? new org.json.alipay.a((Collection) obj).toString() : obj.getClass().isArray() ? new org.json.alipay.a(obj).toString() : c(obj.toString());
        }
        Number number = (Number) obj;
        b(number);
        String obj2 = number.toString();
        if (obj2.indexOf(46) <= 0 || obj2.indexOf(101) >= 0 || obj2.indexOf(69) >= 0) {
            return obj2;
        }
        while (obj2.endsWith("0")) {
            obj2 = obj2.substring(0, obj2.length() - 1);
        }
        return obj2.endsWith(".") ? obj2.substring(0, obj2.length() - 1) : obj2;
    }

    public static void b(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Double) {
            Double d10 = (Double) obj;
            if (d10.isInfinite() || d10.isNaN()) {
                throw new JSONException("JSON does not allow non-finite numbers.");
            }
        } else if (obj instanceof Float) {
            Float f10 = (Float) obj;
            if (f10.isInfinite() || f10.isNaN()) {
                throw new JSONException("JSON does not allow non-finite numbers.");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 == '<') goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(String str) {
        String str2;
        if (str == null || str.length() == 0) {
            return "\"\"";
        }
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length + 4);
        stringBuffer.append('\"');
        int i10 = 0;
        char c10 = 0;
        while (i10 < length) {
            char charAt = str.charAt(i10);
            if (charAt == '\f') {
                str2 = "\\f";
            } else if (charAt != '\r') {
                if (charAt != '\"') {
                    if (charAt != '/') {
                        if (charAt != '\\') {
                            switch (charAt) {
                                case '\b':
                                    str2 = "\\b";
                                    break;
                                case '\t':
                                    str2 = "\\t";
                                    break;
                                case '\n':
                                    str2 = "\\n";
                                    break;
                                default:
                                    if (charAt < ' ' || ((charAt >= 128 && charAt < 160) || (charAt >= 8192 && charAt < 8448))) {
                                        String str3 = Constant.DEFAULT_CVN2 + Integer.toHexString(charAt);
                                        str2 = "\\u" + str3.substring(str3.length() - 4);
                                        break;
                                    }
                                    stringBuffer.append(charAt);
                                    break;
                            }
                        }
                    }
                    i10++;
                    c10 = charAt;
                }
                stringBuffer.append('\\');
                stringBuffer.append(charAt);
                i10++;
                c10 = charAt;
            } else {
                str2 = "\\r";
            }
            stringBuffer.append(str2);
            i10++;
            c10 = charAt;
        }
        stringBuffer.append('\"');
        return stringBuffer.toString();
    }

    public final Object a(String str) {
        Object obj = str == null ? null : this.f32514b.get(str);
        if (obj != null) {
            return obj;
        }
        throw new JSONException("JSONObject[" + c(str) + "] not found.");
    }

    public final Iterator a() {
        return this.f32514b.keySet().iterator();
    }

    public final boolean b(String str) {
        return this.f32514b.containsKey(str);
    }

    public String toString() {
        try {
            Iterator a10 = a();
            StringBuffer stringBuffer = new StringBuffer("{");
            while (a10.hasNext()) {
                if (stringBuffer.length() > 1) {
                    stringBuffer.append(',');
                }
                Object next = a10.next();
                stringBuffer.append(c(next.toString()));
                stringBuffer.append(':');
                stringBuffer.append(a(this.f32514b.get(next)));
            }
            stringBuffer.append('}');
            return stringBuffer.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
