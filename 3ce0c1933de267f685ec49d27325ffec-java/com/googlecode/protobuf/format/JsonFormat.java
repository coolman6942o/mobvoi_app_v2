package com.googlecode.protobuf.format;

import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors;
import com.google.protobuf.a1;
import com.google.protobuf.d0;
import java.io.IOException;
import java.math.BigInteger;
import java.text.StringCharacterIterator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class JsonFormat {

    /* loaded from: classes.dex */
    public static class ParseException extends IOException {
        private static final long serialVersionUID = 1;

        public ParseException(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f13476a;

        static {
            int[] iArr = new int[Descriptors.FieldDescriptor.Type.values().length];
            f13476a = iArr;
            try {
                iArr[Descriptors.FieldDescriptor.Type.INT32.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13476a[Descriptors.FieldDescriptor.Type.INT64.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13476a[Descriptors.FieldDescriptor.Type.SINT32.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13476a[Descriptors.FieldDescriptor.Type.SINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13476a[Descriptors.FieldDescriptor.Type.SFIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13476a[Descriptors.FieldDescriptor.Type.SFIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f13476a[Descriptors.FieldDescriptor.Type.FLOAT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f13476a[Descriptors.FieldDescriptor.Type.DOUBLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f13476a[Descriptors.FieldDescriptor.Type.BOOL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f13476a[Descriptors.FieldDescriptor.Type.UINT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f13476a[Descriptors.FieldDescriptor.Type.FIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f13476a[Descriptors.FieldDescriptor.Type.UINT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f13476a[Descriptors.FieldDescriptor.Type.FIXED64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f13476a[Descriptors.FieldDescriptor.Type.STRING.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f13476a[Descriptors.FieldDescriptor.Type.BYTES.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f13476a[Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f13476a[Descriptors.FieldDescriptor.Type.MESSAGE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f13476a[Descriptors.FieldDescriptor.Type.GROUP.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        Appendable f13477a;

        /* renamed from: b  reason: collision with root package name */
        boolean f13478b = true;

        /* renamed from: c  reason: collision with root package name */
        StringBuilder f13479c = new StringBuilder();

        public b(Appendable appendable) {
            this.f13477a = appendable;
        }

        private void d(CharSequence charSequence, int i10) throws IOException {
            if (i10 != 0) {
                if (this.f13478b) {
                    this.f13478b = false;
                    this.f13477a.append(this.f13479c);
                }
                this.f13477a.append(charSequence);
            }
        }

        public void a() {
            this.f13479c.append("  ");
        }

        public void b() {
            int length = this.f13479c.length();
            if (length != 0) {
                this.f13479c.delete(length - 2, length);
                return;
            }
            throw new IllegalArgumentException(" Outdent() without matching Indent().");
        }

        public void c(CharSequence charSequence) throws IOException {
            int length = charSequence.length();
            int i10 = 0;
            for (int i11 = 0; i11 < length; i11++) {
                if (charSequence.charAt(i11) == '\n') {
                    d(charSequence.subSequence(i10, length), (i11 - i10) + 1);
                    i10 = i11 + 1;
                    this.f13478b = true;
                }
            }
            d(charSequence.subSequence(i10, length), length - i10);
        }
    }

    static {
        Pattern.compile("[0-9]", 2);
    }

    static void a(StringBuilder sb2, char c10) {
        sb2.append(c10 < 16 ? "\\u000" : c10 < 256 ? "\\u00" : c10 < 4096 ? "\\u0" : "\\u");
        sb2.append(Integer.toHexString(c10));
    }

    static String b(ByteString byteString) {
        StringBuilder sb2 = new StringBuilder(byteString.size());
        for (int i10 = 0; i10 < byteString.size(); i10++) {
            byte byteAt = byteString.byteAt(i10);
            if (byteAt == 34) {
                sb2.append("\\\"");
            } else if (byteAt == 39) {
                sb2.append("\\'");
            } else if (byteAt != 92) {
                switch (byteAt) {
                    case 7:
                        sb2.append("\\a");
                        continue;
                    case 8:
                        sb2.append("\\b");
                        continue;
                    case 9:
                        sb2.append("\\t");
                        continue;
                    case 10:
                        sb2.append("\\n");
                        continue;
                    case 11:
                        sb2.append("\\v");
                        continue;
                    case 12:
                        sb2.append("\\f");
                        continue;
                    case 13:
                        sb2.append("\\r");
                        continue;
                    default:
                        if (byteAt < 32) {
                            sb2.append(k((char) byteAt));
                            break;
                        } else {
                            sb2.append((char) byteAt);
                            continue;
                        }
                }
            } else {
                sb2.append("\\\\");
            }
        }
        return sb2.toString();
    }

    static String c(String str) {
        StringBuilder sb2 = new StringBuilder(str.length());
        StringCharacterIterator stringCharacterIterator = new StringCharacterIterator(str);
        for (char first = stringCharacterIterator.first(); first != 65535; first = stringCharacterIterator.next()) {
            if (first == '\f') {
                sb2.append("\\f");
            } else if (first == '\r') {
                sb2.append("\\r");
            } else if (first == '\"') {
                sb2.append("\\\"");
            } else if (first != '\\') {
                switch (first) {
                    case '\b':
                        sb2.append("\\b");
                        continue;
                    case '\t':
                        sb2.append("\\t");
                        continue;
                    case '\n':
                        sb2.append("\\n");
                        continue;
                    default:
                        if (first >= 0 && first <= 31) {
                            a(sb2, first);
                            continue;
                        } else if (!Character.isHighSurrogate(first)) {
                            sb2.append(first);
                            break;
                        } else {
                            a(sb2, first);
                            char next = stringCharacterIterator.next();
                            if (next != 65535) {
                                a(sb2, next);
                                break;
                            } else {
                                throw new IllegalArgumentException("invalid unicode string: unexpected high surrogate pair value without corresponding low value.");
                            }
                        }
                        break;
                }
            } else {
                sb2.append("\\\\");
            }
        }
        return sb2.toString();
    }

    protected static void d(d0 d0Var, b bVar) throws IOException {
        Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> it = d0Var.getAllFields().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Descriptors.FieldDescriptor, Object> next = it.next();
            f(next.getKey(), next.getValue(), bVar);
            if (it.hasNext()) {
                bVar.c(",");
            }
        }
        if (d0Var.getUnknownFields().b().size() > 0) {
            bVar.c(", ");
        }
        j(d0Var.getUnknownFields(), bVar);
    }

    public static void e(d0 d0Var, Appendable appendable) throws IOException {
        b bVar = new b(appendable);
        bVar.c("{");
        d(d0Var, bVar);
        bVar.c("}");
    }

    public static void f(Descriptors.FieldDescriptor fieldDescriptor, Object obj, b bVar) throws IOException {
        h(fieldDescriptor, obj, bVar);
    }

    private static void g(Descriptors.FieldDescriptor fieldDescriptor, Object obj, b bVar) throws IOException {
        switch (a.f13476a[fieldDescriptor.x().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                bVar.c(obj.toString());
                return;
            case 10:
            case 11:
                bVar.c(l(((Integer) obj).intValue()));
                return;
            case 12:
            case 13:
                bVar.c(m(((Long) obj).longValue()));
                return;
            case 14:
                bVar.c("\"");
                bVar.c(c((String) obj));
                bVar.c("\"");
                return;
            case 15:
                bVar.c("\"");
                bVar.c(b((ByteString) obj));
                bVar.c("\"");
                return;
            case 16:
                bVar.c("\"");
                bVar.c(((Descriptors.e) obj).c());
                bVar.c("\"");
                return;
            case 17:
            case 18:
                bVar.c("{");
                d((d0) obj, bVar);
                bVar.c("}");
                return;
            default:
                return;
        }
    }

    private static void h(Descriptors.FieldDescriptor fieldDescriptor, Object obj, b bVar) throws IOException {
        if (fieldDescriptor.y()) {
            bVar.c("\"");
            if (!fieldDescriptor.k().q().getMessageSetWireFormat() || fieldDescriptor.x() != Descriptors.FieldDescriptor.Type.MESSAGE || !fieldDescriptor.A() || fieldDescriptor.n() != fieldDescriptor.v()) {
                bVar.c(fieldDescriptor.b());
            } else {
                bVar.c(fieldDescriptor.v().b());
            }
            bVar.c("\"");
        } else {
            bVar.c("\"");
            if (fieldDescriptor.x() == Descriptors.FieldDescriptor.Type.GROUP) {
                bVar.c(fieldDescriptor.v().c());
            } else {
                bVar.c(fieldDescriptor.c());
            }
            bVar.c("\"");
        }
        Descriptors.FieldDescriptor.JavaType u10 = fieldDescriptor.u();
        Descriptors.FieldDescriptor.JavaType javaType = Descriptors.FieldDescriptor.JavaType.MESSAGE;
        if (u10 == javaType) {
            bVar.c(": ");
            bVar.a();
        } else {
            bVar.c(": ");
        }
        if (fieldDescriptor.o()) {
            bVar.c("[");
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                g(fieldDescriptor, it.next(), bVar);
                if (it.hasNext()) {
                    bVar.c(",");
                }
            }
            bVar.c("]");
            return;
        }
        g(fieldDescriptor, obj, bVar);
        if (fieldDescriptor.u() == javaType) {
            bVar.b();
        }
    }

    public static String i(d0 d0Var) {
        try {
            StringBuilder sb2 = new StringBuilder();
            e(d0Var, sb2);
            return sb2.toString();
        } catch (IOException e10) {
            throw new RuntimeException("Writing to a StringBuilder threw an IOException (should never happen).", e10);
        }
    }

    protected static void j(a1 a1Var, b bVar) throws IOException {
        boolean z10 = true;
        for (Map.Entry<Integer, a1.c> entry : a1Var.b().entrySet()) {
            a1.c value = entry.getValue();
            if (z10) {
                z10 = false;
            } else {
                bVar.c(", ");
            }
            bVar.c("\"");
            bVar.c(entry.getKey().toString());
            bVar.c("\"");
            bVar.c(": [");
            boolean z11 = true;
            for (Long l10 : value.r()) {
                long longValue = l10.longValue();
                if (z11) {
                    z11 = false;
                } else {
                    bVar.c(", ");
                }
                bVar.c(m(longValue));
            }
            for (Integer num : value.k()) {
                int intValue = num.intValue();
                if (z11) {
                    z11 = false;
                } else {
                    bVar.c(", ");
                }
                bVar.c(String.format(null, "0x%08x", Integer.valueOf(intValue)));
            }
            for (Long l11 : value.l()) {
                long longValue2 = l11.longValue();
                if (z11) {
                    z11 = false;
                } else {
                    bVar.c(", ");
                }
                bVar.c(String.format(null, "0x%016x", Long.valueOf(longValue2)));
            }
            for (ByteString byteString : value.o()) {
                if (z11) {
                    z11 = false;
                } else {
                    bVar.c(", ");
                }
                bVar.c("\"");
                bVar.c(b(byteString));
                bVar.c("\"");
            }
            for (a1 a1Var2 : value.m()) {
                if (z11) {
                    z11 = false;
                } else {
                    bVar.c(", ");
                }
                bVar.c("{");
                j(a1Var2, bVar);
                bVar.c("}");
            }
            bVar.c("]");
        }
    }

    static String k(char c10) {
        if (c10 < 16) {
            return "\\u000" + Integer.toHexString(c10);
        } else if (c10 < 256) {
            return "\\u00" + Integer.toHexString(c10);
        } else if (c10 < 4096) {
            return "\\u0" + Integer.toHexString(c10);
        } else {
            return "\\u" + Integer.toHexString(c10);
        }
    }

    private static String l(int i10) {
        if (i10 >= 0) {
            return Integer.toString(i10);
        }
        return Long.toString(i10 & 4294967295L);
    }

    private static String m(long j10) {
        if (j10 >= 0) {
            return Long.toString(j10);
        }
        return BigInteger.valueOf(j10 & Long.MAX_VALUE).setBit(63).toString();
    }
}
