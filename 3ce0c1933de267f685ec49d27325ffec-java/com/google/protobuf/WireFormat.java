package com.google.protobuf;

import java.io.IOException;
/* loaded from: classes.dex */
public final class WireFormat {

    /* renamed from: a  reason: collision with root package name */
    static final int f13141a = c(1, 3);

    /* renamed from: b  reason: collision with root package name */
    static final int f13142b = c(1, 4);

    /* renamed from: c  reason: collision with root package name */
    static final int f13143c = c(2, 0);

    /* renamed from: d  reason: collision with root package name */
    static final int f13144d = c(3, 2);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* loaded from: classes.dex */
    public static class FieldType extends Enum<FieldType> {
        private static final /* synthetic */ FieldType[] $VALUES;
        public static final FieldType BOOL;
        public static final FieldType BYTES;
        public static final FieldType DOUBLE;
        public static final FieldType ENUM;
        public static final FieldType FIXED32;
        public static final FieldType FIXED64;
        public static final FieldType FLOAT;
        public static final FieldType GROUP;
        public static final FieldType INT32;
        public static final FieldType INT64;
        public static final FieldType MESSAGE;
        public static final FieldType SFIXED32;
        public static final FieldType SFIXED64;
        public static final FieldType SINT32;
        public static final FieldType SINT64;
        public static final FieldType STRING;
        public static final FieldType UINT32;
        public static final FieldType UINT64;
        private final JavaType javaType;
        private final int wireType;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* loaded from: classes.dex */
        static class a extends FieldType {
            a(String str, int i10, JavaType javaType, int i11) {
                super(str, i10, javaType, i11, null);
            }

            @Override // com.google.protobuf.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* loaded from: classes.dex */
        static class b extends FieldType {
            b(String str, int i10, JavaType javaType, int i11) {
                super(str, i10, javaType, i11, null);
            }

            @Override // com.google.protobuf.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* loaded from: classes.dex */
        static class c extends FieldType {
            c(String str, int i10, JavaType javaType, int i11) {
                super(str, i10, javaType, i11, null);
            }

            @Override // com.google.protobuf.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* loaded from: classes.dex */
        static class d extends FieldType {
            d(String str, int i10, JavaType javaType, int i11) {
                super(str, i10, javaType, i11, null);
            }

            @Override // com.google.protobuf.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        }

        static {
            FieldType fieldType = new FieldType("DOUBLE", 0, JavaType.DOUBLE, 1);
            DOUBLE = fieldType;
            FieldType fieldType2 = new FieldType("FLOAT", 1, JavaType.FLOAT, 5);
            FLOAT = fieldType2;
            JavaType javaType = JavaType.LONG;
            FieldType fieldType3 = new FieldType("INT64", 2, javaType, 0);
            INT64 = fieldType3;
            FieldType fieldType4 = new FieldType("UINT64", 3, javaType, 0);
            UINT64 = fieldType4;
            JavaType javaType2 = JavaType.INT;
            FieldType fieldType5 = new FieldType("INT32", 4, javaType2, 0);
            INT32 = fieldType5;
            FieldType fieldType6 = new FieldType("FIXED64", 5, javaType, 1);
            FIXED64 = fieldType6;
            FieldType fieldType7 = new FieldType("FIXED32", 6, javaType2, 5);
            FIXED32 = fieldType7;
            FieldType fieldType8 = new FieldType("BOOL", 7, JavaType.BOOLEAN, 0);
            BOOL = fieldType8;
            a aVar = new a("STRING", 8, JavaType.STRING, 2);
            STRING = aVar;
            JavaType javaType3 = JavaType.MESSAGE;
            b bVar = new b("GROUP", 9, javaType3, 3);
            GROUP = bVar;
            c cVar = new c("MESSAGE", 10, javaType3, 2);
            MESSAGE = cVar;
            d dVar = new d("BYTES", 11, JavaType.BYTE_STRING, 2);
            BYTES = dVar;
            FieldType fieldType9 = new FieldType("UINT32", 12, javaType2, 0);
            UINT32 = fieldType9;
            FieldType fieldType10 = new FieldType("ENUM", 13, JavaType.ENUM, 0);
            ENUM = fieldType10;
            FieldType fieldType11 = new FieldType("SFIXED32", 14, javaType2, 5);
            SFIXED32 = fieldType11;
            FieldType fieldType12 = new FieldType("SFIXED64", 15, javaType, 1);
            SFIXED64 = fieldType12;
            FieldType fieldType13 = new FieldType("SINT32", 16, javaType2, 0);
            SINT32 = fieldType13;
            FieldType fieldType14 = new FieldType("SINT64", 17, javaType, 0);
            SINT64 = fieldType14;
            $VALUES = new FieldType[]{fieldType, fieldType2, fieldType3, fieldType4, fieldType5, fieldType6, fieldType7, fieldType8, aVar, bVar, cVar, dVar, fieldType9, fieldType10, fieldType11, fieldType12, fieldType13, fieldType14};
        }

        /* synthetic */ FieldType(String str, int i10, JavaType javaType, int i11, a aVar) {
            this(str, i10, javaType, i11);
        }

        public static FieldType valueOf(String str) {
            return (FieldType) Enum.valueOf(FieldType.class, str);
        }

        public static FieldType[] values() {
            return (FieldType[]) $VALUES.clone();
        }

        public JavaType getJavaType() {
            return this.javaType;
        }

        public int getWireType() {
            return this.wireType;
        }

        public boolean isPackable() {
            return true;
        }

        private FieldType(String str, int i10, JavaType javaType, int i11) {
            this.javaType = javaType;
            this.wireType = i11;
        }
    }

    /* loaded from: classes.dex */
    public enum JavaType {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(ByteString.EMPTY),
        ENUM(null),
        MESSAGE(null);
        
        private final Object defaultDefault;

        JavaType(Object obj) {
            this.defaultDefault = obj;
        }
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f13145a;

        static {
            int[] iArr = new int[FieldType.values().length];
            f13145a = iArr;
            try {
                iArr[FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13145a[FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13145a[FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13145a[FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13145a[FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13145a[FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f13145a[FieldType.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f13145a[FieldType.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f13145a[FieldType.BYTES.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f13145a[FieldType.UINT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f13145a[FieldType.SFIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f13145a[FieldType.SFIXED64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f13145a[FieldType.SINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f13145a[FieldType.SINT64.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f13145a[FieldType.STRING.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f13145a[FieldType.GROUP.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f13145a[FieldType.MESSAGE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f13145a[FieldType.ENUM.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* loaded from: classes.dex */
    static abstract class b extends Enum<b> {
        private static final /* synthetic */ b[] $VALUES;
        public static final b LAZY;
        public static final b LOOSE;
        public static final b STRICT;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* loaded from: classes.dex */
        static class a extends b {
            a(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.protobuf.WireFormat.b
            Object a(i iVar) throws IOException {
                return iVar.D();
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* renamed from: com.google.protobuf.WireFormat$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static class C0169b extends b {
            C0169b(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.protobuf.WireFormat.b
            Object a(i iVar) throws IOException {
                return iVar.E();
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* loaded from: classes.dex */
        static class c extends b {
            c(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.protobuf.WireFormat.b
            Object a(i iVar) throws IOException {
                return iVar.m();
            }
        }

        static {
            a aVar = new a("LOOSE", 0);
            LOOSE = aVar;
            C0169b bVar = new C0169b("STRICT", 1);
            STRICT = bVar;
            c cVar = new c("LAZY", 2);
            LAZY = cVar;
            $VALUES = new b[]{aVar, bVar, cVar};
        }

        private b(String str, int i10) {
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) $VALUES.clone();
        }

        abstract Object a(i iVar) throws IOException;

        /* synthetic */ b(String str, int i10, a aVar) {
            this(str, i10);
        }
    }

    public static int a(int i10) {
        return i10 >>> 3;
    }

    public static int b(int i10) {
        return i10 & 7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i10, int i11) {
        return (i10 << 3) | i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object d(i iVar, FieldType fieldType, b bVar) throws IOException {
        switch (a.f13145a[fieldType.ordinal()]) {
            case 1:
                return Double.valueOf(iVar.n());
            case 2:
                return Float.valueOf(iVar.r());
            case 3:
                return Long.valueOf(iVar.u());
            case 4:
                return Long.valueOf(iVar.H());
            case 5:
                return Integer.valueOf(iVar.t());
            case 6:
                return Long.valueOf(iVar.q());
            case 7:
                return Integer.valueOf(iVar.p());
            case 8:
                return Boolean.valueOf(iVar.l());
            case 9:
                return iVar.m();
            case 10:
                return Integer.valueOf(iVar.G());
            case 11:
                return Integer.valueOf(iVar.z());
            case 12:
                return Long.valueOf(iVar.A());
            case 13:
                return Integer.valueOf(iVar.B());
            case 14:
                return Long.valueOf(iVar.C());
            case 15:
                return bVar.a(iVar);
            case 16:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 17:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 18:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }
}
