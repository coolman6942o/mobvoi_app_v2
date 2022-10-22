package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.a1;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public final class TextFormat {

    /* renamed from: a  reason: collision with root package name */
    private static final b f13112a = new b(null);

    /* loaded from: classes.dex */
    public static class InvalidEscapeSequenceException extends IOException {
        private static final long serialVersionUID = -8164033650142593304L;

        InvalidEscapeSequenceException(String str) {
            super(str);
        }
    }

    /* loaded from: classes.dex */
    public static class ParseException extends IOException {
        private static final long serialVersionUID = 3196188060225107702L;
        private final int column;
        private final int line;

        public ParseException(String str) {
            this(-1, -1, str);
        }

        public int getColumn() {
            return this.column;
        }

        public int getLine() {
            return this.line;
        }

        public ParseException(int i10, int i11, String str) {
            super(Integer.toString(i10) + ":" + i11 + ": " + str);
            this.line = i10;
            this.column = i11;
        }
    }

    /* loaded from: classes.dex */
    public static class Parser {

        /* loaded from: classes.dex */
        public enum SingularOverwritePolicy {
            ALLOW_SINGULAR_OVERWRITES,
            FORBID_SINGULAR_OVERWRITES
        }

        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            private boolean f13113a = false;

            /* renamed from: b  reason: collision with root package name */
            private SingularOverwritePolicy f13114b = SingularOverwritePolicy.ALLOW_SINGULAR_OVERWRITES;

            /* renamed from: c  reason: collision with root package name */
            private x0 f13115c;

            public Parser a() {
                return new Parser(this.f13113a, this.f13114b, this.f13115c, null);
            }
        }

        /* synthetic */ Parser(boolean z10, SingularOverwritePolicy singularOverwritePolicy, x0 x0Var, a aVar) {
            this(z10, singularOverwritePolicy, x0Var);
        }

        public static a a() {
            return new a();
        }

        private Parser(boolean z10, SingularOverwritePolicy singularOverwritePolicy, x0 x0Var) {
        }
    }

    /* loaded from: classes.dex */
    public static class UnknownFieldParseException extends ParseException {
        private final String unknownField;

        public UnknownFieldParseException(String str) {
            this(-1, -1, "", str);
        }

        public String getUnknownField() {
            return this.unknownField;
        }

        public UnknownFieldParseException(int i10, int i11, String str, String str2) {
            super(i10, i11, str2);
            this.unknownField = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f13116a;

        static {
            int[] iArr = new int[Descriptors.FieldDescriptor.Type.values().length];
            f13116a = iArr;
            try {
                iArr[Descriptors.FieldDescriptor.Type.INT32.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13116a[Descriptors.FieldDescriptor.Type.SINT32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13116a[Descriptors.FieldDescriptor.Type.SFIXED32.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13116a[Descriptors.FieldDescriptor.Type.INT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13116a[Descriptors.FieldDescriptor.Type.SINT64.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13116a[Descriptors.FieldDescriptor.Type.SFIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f13116a[Descriptors.FieldDescriptor.Type.BOOL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f13116a[Descriptors.FieldDescriptor.Type.FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f13116a[Descriptors.FieldDescriptor.Type.DOUBLE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f13116a[Descriptors.FieldDescriptor.Type.UINT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f13116a[Descriptors.FieldDescriptor.Type.FIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f13116a[Descriptors.FieldDescriptor.Type.UINT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f13116a[Descriptors.FieldDescriptor.Type.FIXED64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f13116a[Descriptors.FieldDescriptor.Type.STRING.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f13116a[Descriptors.FieldDescriptor.Type.BYTES.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f13116a[Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f13116a[Descriptors.FieldDescriptor.Type.MESSAGE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f13116a[Descriptors.FieldDescriptor.Type.GROUP.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        boolean f13117a;

        /* renamed from: b  reason: collision with root package name */
        boolean f13118b;

        /* synthetic */ b(a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(g0 g0Var, c cVar) throws IOException {
            for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : g0Var.getAllFields().entrySet()) {
                f(entry.getKey(), entry.getValue(), cVar);
            }
            j(g0Var.getUnknownFields(), cVar);
        }

        private void f(Descriptors.FieldDescriptor fieldDescriptor, Object obj, c cVar) throws IOException {
            if (fieldDescriptor.o()) {
                for (Object obj2 : (List) obj) {
                    h(fieldDescriptor, obj2, cVar);
                }
                return;
            }
            h(fieldDescriptor, obj, cVar);
        }

        private void g(Descriptors.FieldDescriptor fieldDescriptor, Object obj, c cVar) throws IOException {
            String str;
            switch (a.f13116a[fieldDescriptor.x().ordinal()]) {
                case 1:
                case 2:
                case 3:
                    cVar.c(((Integer) obj).toString());
                    return;
                case 4:
                case 5:
                case 6:
                    cVar.c(((Long) obj).toString());
                    return;
                case 7:
                    cVar.c(((Boolean) obj).toString());
                    return;
                case 8:
                    cVar.c(((Float) obj).toString());
                    return;
                case 9:
                    cVar.c(((Double) obj).toString());
                    return;
                case 10:
                case 11:
                    cVar.c(TextFormat.s(((Integer) obj).intValue()));
                    return;
                case 12:
                case 13:
                    cVar.c(TextFormat.t(((Long) obj).longValue()));
                    return;
                case 14:
                    cVar.c("\"");
                    if (this.f13118b) {
                        str = w0.e((String) obj);
                    } else {
                        str = TextFormat.e((String) obj).replace("\n", "\\n");
                    }
                    cVar.c(str);
                    cVar.c("\"");
                    return;
                case 15:
                    cVar.c("\"");
                    if (obj instanceof ByteString) {
                        cVar.c(TextFormat.c((ByteString) obj));
                    } else {
                        cVar.c(TextFormat.d((byte[]) obj));
                    }
                    cVar.c("\"");
                    return;
                case 16:
                    cVar.c(((Descriptors.e) obj).c());
                    return;
                case 17:
                case 18:
                    e((d0) obj, cVar);
                    return;
                default:
                    return;
            }
        }

        private void h(Descriptors.FieldDescriptor fieldDescriptor, Object obj, c cVar) throws IOException {
            if (fieldDescriptor.y()) {
                cVar.c("[");
                if (!fieldDescriptor.k().q().getMessageSetWireFormat() || fieldDescriptor.x() != Descriptors.FieldDescriptor.Type.MESSAGE || !fieldDescriptor.A() || fieldDescriptor.n() != fieldDescriptor.v()) {
                    cVar.c(fieldDescriptor.b());
                } else {
                    cVar.c(fieldDescriptor.v().b());
                }
                cVar.c("]");
            } else if (fieldDescriptor.x() == Descriptors.FieldDescriptor.Type.GROUP) {
                cVar.c(fieldDescriptor.v().c());
            } else {
                cVar.c(fieldDescriptor.c());
            }
            Descriptors.FieldDescriptor.JavaType u10 = fieldDescriptor.u();
            Descriptors.FieldDescriptor.JavaType javaType = Descriptors.FieldDescriptor.JavaType.MESSAGE;
            if (u10 != javaType) {
                cVar.c(": ");
            } else if (this.f13117a) {
                cVar.c(" { ");
            } else {
                cVar.c(" {\n");
                cVar.a();
            }
            g(fieldDescriptor, obj, cVar);
            if (fieldDescriptor.u() == javaType) {
                if (this.f13117a) {
                    cVar.c("} ");
                    return;
                }
                cVar.b();
                cVar.c("}\n");
            } else if (this.f13117a) {
                cVar.c(" ");
            } else {
                cVar.c("\n");
            }
        }

        private void i(int i10, int i11, List<?> list, c cVar) throws IOException {
            for (Object obj : list) {
                cVar.c(String.valueOf(i10));
                cVar.c(": ");
                TextFormat.q(i11, obj, cVar);
                cVar.c(this.f13117a ? " " : "\n");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(a1 a1Var, c cVar) throws IOException {
            for (Map.Entry<Integer, a1.c> entry : a1Var.b().entrySet()) {
                int intValue = entry.getKey().intValue();
                a1.c value = entry.getValue();
                i(intValue, 0, value.r(), cVar);
                i(intValue, 5, value.k(), cVar);
                i(intValue, 1, value.l(), cVar);
                i(intValue, 2, value.o(), cVar);
                for (a1 a1Var2 : value.m()) {
                    cVar.c(entry.getKey().toString());
                    if (this.f13117a) {
                        cVar.c(" { ");
                    } else {
                        cVar.c(" {\n");
                        cVar.a();
                    }
                    j(a1Var2, cVar);
                    if (this.f13117a) {
                        cVar.c("} ");
                    } else {
                        cVar.b();
                        cVar.c("}\n");
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public b k(boolean z10) {
            this.f13118b = z10;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public b l(boolean z10) {
            this.f13117a = z10;
            return this;
        }

        private b() {
            this.f13117a = false;
            this.f13118b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final Appendable f13119a;

        /* renamed from: b  reason: collision with root package name */
        private final StringBuilder f13120b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f13121c;

        /* synthetic */ c(Appendable appendable, a aVar) {
            this(appendable);
        }

        private void d(CharSequence charSequence) throws IOException {
            if (charSequence.length() != 0) {
                if (this.f13121c) {
                    this.f13121c = false;
                    this.f13119a.append(this.f13120b);
                }
                this.f13119a.append(charSequence);
            }
        }

        public void a() {
            this.f13120b.append("  ");
        }

        public void b() {
            int length = this.f13120b.length();
            if (length != 0) {
                this.f13120b.delete(length - 2, length);
                return;
            }
            throw new IllegalArgumentException(" Outdent() without matching Indent().");
        }

        public void c(CharSequence charSequence) throws IOException {
            int length = charSequence.length();
            int i10 = 0;
            for (int i11 = 0; i11 < length; i11++) {
                if (charSequence.charAt(i11) == '\n') {
                    int i12 = i11 + 1;
                    d(charSequence.subSequence(i10, i12));
                    this.f13121c = true;
                    i10 = i12;
                }
            }
            d(charSequence.subSequence(i10, length));
        }

        private c(Appendable appendable) {
            this.f13120b = new StringBuilder();
            this.f13121c = true;
            this.f13119a = appendable;
        }
    }

    static {
        Logger.getLogger(TextFormat.class.getName());
        new b(null).l(true);
        new b(null).k(false);
        Parser.a().a();
    }

    private TextFormat() {
    }

    private static int b(byte b10) {
        if (48 <= b10 && b10 <= 57) {
            return b10 - 48;
        }
        return ((97 > b10 || b10 > 122) ? b10 - 65 : b10 - 97) + 10;
    }

    public static String c(ByteString byteString) {
        return w0.a(byteString);
    }

    public static String d(byte[] bArr) {
        return w0.c(bArr);
    }

    public static String e(String str) {
        return w0.d(str);
    }

    private static boolean f(byte b10) {
        return (48 <= b10 && b10 <= 57) || (97 <= b10 && b10 <= 102) || (65 <= b10 && b10 <= 70);
    }

    private static boolean g(byte b10) {
        return 48 <= b10 && b10 <= 55;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(String str) throws NumberFormatException {
        return (int) j(str, true, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long i(String str) throws NumberFormatException {
        return j(str, true, true);
    }

    private static long j(String str, boolean z10, boolean z11) throws NumberFormatException {
        int i10 = 0;
        boolean z12 = true;
        if (!str.startsWith("-", 0)) {
            z12 = false;
        } else if (z10) {
            i10 = 1;
        } else {
            throw new NumberFormatException("Number must be positive: " + str);
        }
        int i11 = 10;
        if (str.startsWith("0x", i10)) {
            i10 += 2;
            i11 = 16;
        } else if (str.startsWith("0", i10)) {
            i11 = 8;
        }
        String substring = str.substring(i10);
        if (substring.length() < 16) {
            long parseLong = Long.parseLong(substring, i11);
            if (z12) {
                parseLong = -parseLong;
            }
            if (z11) {
                return parseLong;
            }
            if (z10) {
                if (parseLong <= 2147483647L && parseLong >= -2147483648L) {
                    return parseLong;
                }
                throw new NumberFormatException("Number out of range for 32-bit signed integer: " + str);
            } else if (parseLong < 4294967296L && parseLong >= 0) {
                return parseLong;
            } else {
                throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + str);
            }
        } else {
            BigInteger bigInteger = new BigInteger(substring, i11);
            if (z12) {
                bigInteger = bigInteger.negate();
            }
            if (!z11) {
                if (z10) {
                    if (bigInteger.bitLength() > 31) {
                        throw new NumberFormatException("Number out of range for 32-bit signed integer: " + str);
                    }
                } else if (bigInteger.bitLength() > 32) {
                    throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + str);
                }
            } else if (z10) {
                if (bigInteger.bitLength() > 63) {
                    throw new NumberFormatException("Number out of range for 64-bit signed integer: " + str);
                }
            } else if (bigInteger.bitLength() > 64) {
                throw new NumberFormatException("Number out of range for 64-bit unsigned integer: " + str);
            }
            return bigInteger.longValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int k(String str) throws NumberFormatException {
        return (int) j(str, false, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long l(String str) throws NumberFormatException {
        return j(str, false, true);
    }

    public static void m(g0 g0Var, Appendable appendable) throws IOException {
        f13112a.e(g0Var, new c(appendable, null));
    }

    public static void n(a1 a1Var, Appendable appendable) throws IOException {
        f13112a.j(a1Var, new c(appendable, null));
    }

    public static String o(g0 g0Var) {
        try {
            StringBuilder sb2 = new StringBuilder();
            m(g0Var, sb2);
            return sb2.toString();
        } catch (IOException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public static String p(a1 a1Var) {
        try {
            StringBuilder sb2 = new StringBuilder();
            n(a1Var, sb2);
            return sb2.toString();
        } catch (IOException e10) {
            throw new IllegalStateException(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(int i10, Object obj, c cVar) throws IOException {
        int b10 = WireFormat.b(i10);
        if (b10 == 0) {
            cVar.c(t(((Long) obj).longValue()));
        } else if (b10 == 1) {
            cVar.c(String.format(null, "0x%016x", (Long) obj));
        } else if (b10 == 2) {
            cVar.c("\"");
            cVar.c(c((ByteString) obj));
            cVar.c("\"");
        } else if (b10 == 3) {
            f13112a.j((a1) obj, cVar);
        } else if (b10 == 5) {
            cVar.c(String.format(null, "0x%08x", (Integer) obj));
        } else {
            throw new IllegalArgumentException("Bad tag: " + i10);
        }
    }

    public static ByteString r(CharSequence charSequence) throws InvalidEscapeSequenceException {
        int i10;
        int i11;
        ByteString copyFromUtf8 = ByteString.copyFromUtf8(charSequence.toString());
        int size = copyFromUtf8.size();
        byte[] bArr = new byte[size];
        int i12 = 0;
        int i13 = 0;
        while (i12 < copyFromUtf8.size()) {
            byte byteAt = copyFromUtf8.byteAt(i12);
            if (byteAt == 92) {
                i12++;
                if (i12 < copyFromUtf8.size()) {
                    byte byteAt2 = copyFromUtf8.byteAt(i12);
                    if (g(byteAt2)) {
                        int b10 = b(byteAt2);
                        int i14 = i12 + 1;
                        if (i14 < copyFromUtf8.size() && g(copyFromUtf8.byteAt(i14))) {
                            b10 = (b10 * 8) + b(copyFromUtf8.byteAt(i14));
                            i12 = i14;
                        }
                        int i15 = i12 + 1;
                        if (i15 < copyFromUtf8.size() && g(copyFromUtf8.byteAt(i15))) {
                            b10 = (b10 * 8) + b(copyFromUtf8.byteAt(i15));
                            i12 = i15;
                        }
                        i10 = i13 + 1;
                        bArr[i13] = (byte) b10;
                    } else {
                        if (byteAt2 == 34) {
                            i11 = i13 + 1;
                            bArr[i13] = 34;
                        } else if (byteAt2 == 39) {
                            i11 = i13 + 1;
                            bArr[i13] = 39;
                        } else if (byteAt2 == 92) {
                            i11 = i13 + 1;
                            bArr[i13] = 92;
                        } else if (byteAt2 == 102) {
                            i11 = i13 + 1;
                            bArr[i13] = 12;
                        } else if (byteAt2 == 110) {
                            i11 = i13 + 1;
                            bArr[i13] = 10;
                        } else if (byteAt2 == 114) {
                            i11 = i13 + 1;
                            bArr[i13] = 13;
                        } else if (byteAt2 == 116) {
                            i11 = i13 + 1;
                            bArr[i13] = 9;
                        } else if (byteAt2 == 118) {
                            i11 = i13 + 1;
                            bArr[i13] = 11;
                        } else if (byteAt2 == 120) {
                            i12++;
                            if (i12 >= copyFromUtf8.size() || !f(copyFromUtf8.byteAt(i12))) {
                                throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\x' with no digits");
                            }
                            int b11 = b(copyFromUtf8.byteAt(i12));
                            int i16 = i12 + 1;
                            if (i16 < copyFromUtf8.size() && f(copyFromUtf8.byteAt(i16))) {
                                b11 = (b11 * 16) + b(copyFromUtf8.byteAt(i16));
                                i12 = i16;
                            }
                            i10 = i13 + 1;
                            bArr[i13] = (byte) b11;
                        } else if (byteAt2 == 97) {
                            i11 = i13 + 1;
                            bArr[i13] = 7;
                        } else if (byteAt2 == 98) {
                            i11 = i13 + 1;
                            bArr[i13] = 8;
                        } else {
                            throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\" + ((char) byteAt2) + '\'');
                        }
                        i13 = i11;
                        i12++;
                    }
                } else {
                    throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\' at end of string.");
                }
            } else {
                i10 = i13 + 1;
                bArr[i13] = byteAt;
            }
            i13 = i10;
            i12++;
        }
        if (size == i13) {
            return ByteString.o(bArr);
        }
        return ByteString.copyFrom(bArr, 0, i13);
    }

    public static String s(int i10) {
        if (i10 >= 0) {
            return Integer.toString(i10);
        }
        return Long.toString(i10 & 4294967295L);
    }

    public static String t(long j10) {
        if (j10 >= 0) {
            return Long.toString(j10);
        }
        return BigInteger.valueOf(j10 & Long.MAX_VALUE).setBit(63).toString();
    }
}
