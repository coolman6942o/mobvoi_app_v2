package com.google.protobuf;

import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.TextFormat;
import com.google.protobuf.WireFormat;
import com.google.protobuf.d0;
import com.google.protobuf.e0;
import com.google.protobuf.t;
import com.google.protobuf.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public final class Descriptors {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f12918a = Logger.getLogger(Descriptors.class.getName());

    /* loaded from: classes.dex */
    public static class DescriptorValidationException extends Exception {
        private static final long serialVersionUID = 5750205775490483148L;
        private final String description;
        private final String name;
        private final d0 proto;

        /* synthetic */ DescriptorValidationException(FileDescriptor fileDescriptor, String str, a aVar) {
            this(fileDescriptor, str);
        }

        public String getDescription() {
            return this.description;
        }

        public d0 getProblemProto() {
            return this.proto;
        }

        public String getProblemSymbolName() {
            return this.name;
        }

        /* synthetic */ DescriptorValidationException(f fVar, String str, a aVar) {
            this(fVar, str);
        }

        /* synthetic */ DescriptorValidationException(f fVar, String str, Throwable th2, a aVar) {
            this(fVar, str, th2);
        }

        private DescriptorValidationException(f fVar, String str) {
            super(fVar.b() + ": " + str);
            this.name = fVar.b();
            this.proto = fVar.d();
            this.description = str;
        }

        private DescriptorValidationException(f fVar, String str, Throwable th2) {
            this(fVar, str);
            initCause(th2);
        }

        private DescriptorValidationException(FileDescriptor fileDescriptor, String str) {
            super(fileDescriptor.c() + ": " + str);
            this.name = fileDescriptor.c();
            this.proto = fileDescriptor.d();
            this.description = str;
        }
    }

    /* loaded from: classes.dex */
    public static final class FieldDescriptor extends f implements Comparable<FieldDescriptor>, t.b<FieldDescriptor> {

        /* renamed from: l  reason: collision with root package name */
        private static final WireFormat.FieldType[] f12919l = WireFormat.FieldType.values();

        /* renamed from: a  reason: collision with root package name */
        private final int f12920a;

        /* renamed from: b  reason: collision with root package name */
        private DescriptorProtos.FieldDescriptorProto f12921b;

        /* renamed from: c  reason: collision with root package name */
        private final String f12922c;

        /* renamed from: d  reason: collision with root package name */
        private final FileDescriptor f12923d;

        /* renamed from: e  reason: collision with root package name */
        private final b f12924e;

        /* renamed from: f  reason: collision with root package name */
        private Type f12925f;

        /* renamed from: g  reason: collision with root package name */
        private b f12926g;

        /* renamed from: h  reason: collision with root package name */
        private b f12927h;

        /* renamed from: i  reason: collision with root package name */
        private h f12928i;

        /* renamed from: j  reason: collision with root package name */
        private d f12929j;

        /* renamed from: k  reason: collision with root package name */
        private Object f12930k;

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

        /* JADX WARN: Init of enum FIXED32 can be incorrect */
        /* JADX WARN: Init of enum FIXED64 can be incorrect */
        /* JADX WARN: Init of enum GROUP can be incorrect */
        /* JADX WARN: Init of enum INT32 can be incorrect */
        /* JADX WARN: Init of enum INT64 can be incorrect */
        /* JADX WARN: Init of enum MESSAGE can be incorrect */
        /* JADX WARN: Init of enum SFIXED32 can be incorrect */
        /* JADX WARN: Init of enum SFIXED64 can be incorrect */
        /* JADX WARN: Init of enum SINT32 can be incorrect */
        /* JADX WARN: Init of enum SINT64 can be incorrect */
        /* JADX WARN: Init of enum UINT32 can be incorrect */
        /* JADX WARN: Init of enum UINT64 can be incorrect */
        /* loaded from: classes.dex */
        public enum Type {
            DOUBLE(JavaType.DOUBLE),
            FLOAT(JavaType.FLOAT),
            INT64(r4),
            UINT64(r4),
            INT32(r10),
            FIXED64(r4),
            FIXED32(r10),
            BOOL(JavaType.BOOLEAN),
            STRING(JavaType.STRING),
            GROUP(r14),
            MESSAGE(r14),
            BYTES(JavaType.BYTE_STRING),
            UINT32(r10),
            ENUM(JavaType.ENUM),
            SFIXED32(r10),
            SFIXED64(r4),
            SINT32(r10),
            SINT64(r4);
            
            private JavaType javaType;

            static {
                JavaType javaType = JavaType.LONG;
                JavaType javaType2 = JavaType.INT;
                JavaType javaType3 = JavaType.MESSAGE;
            }

            Type(JavaType javaType) {
                this.javaType = javaType;
            }

            public JavaType getJavaType() {
                return this.javaType;
            }

            public DescriptorProtos.FieldDescriptorProto.Type toProto() {
                return DescriptorProtos.FieldDescriptorProto.Type.forNumber(ordinal() + 1);
            }

            public static Type valueOf(DescriptorProtos.FieldDescriptorProto.Type type) {
                return values()[type.getNumber() - 1];
            }
        }

        static {
            if (Type.values().length != DescriptorProtos.FieldDescriptorProto.Type.values().length) {
                throw new RuntimeException("descriptor.proto has a new declared type but Descriptors.java wasn't updated.");
            }
        }

        /* synthetic */ FieldDescriptor(DescriptorProtos.FieldDescriptorProto fieldDescriptorProto, FileDescriptor fileDescriptor, b bVar, int i10, boolean z10, a aVar) throws DescriptorValidationException {
            this(fieldDescriptorProto, fileDescriptor, bVar, i10, z10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void E(DescriptorProtos.FieldDescriptorProto fieldDescriptorProto) {
            this.f12921b = fieldDescriptorProto;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h() throws DescriptorValidationException {
            if (this.f12921b.hasExtendee()) {
                f l10 = this.f12923d.f12937g.l(this.f12921b.getExtendee(), this, c.EnumC0167c.TYPES_ONLY);
                if (l10 instanceof b) {
                    this.f12926g = (b) l10;
                    if (!k().u(getNumber())) {
                        throw new DescriptorValidationException(this, '\"' + k().b() + "\" does not declare " + getNumber() + " as an extension number.", (a) null);
                    }
                } else {
                    throw new DescriptorValidationException(this, '\"' + this.f12921b.getExtendee() + "\" is not a message type.", (a) null);
                }
            }
            if (this.f12921b.hasTypeName()) {
                f l11 = this.f12923d.f12937g.l(this.f12921b.getTypeName(), this, c.EnumC0167c.TYPES_ONLY);
                if (!this.f12921b.hasType()) {
                    if (l11 instanceof b) {
                        this.f12925f = Type.MESSAGE;
                    } else if (l11 instanceof d) {
                        this.f12925f = Type.ENUM;
                    } else {
                        throw new DescriptorValidationException(this, '\"' + this.f12921b.getTypeName() + "\" is not a type.", (a) null);
                    }
                }
                if (u() == JavaType.MESSAGE) {
                    if (l11 instanceof b) {
                        this.f12927h = (b) l11;
                        if (this.f12921b.hasDefaultValue()) {
                            throw new DescriptorValidationException(this, "Messages can't have default values.", (a) null);
                        }
                    } else {
                        throw new DescriptorValidationException(this, '\"' + this.f12921b.getTypeName() + "\" is not a message type.", (a) null);
                    }
                } else if (u() != JavaType.ENUM) {
                    throw new DescriptorValidationException(this, "Field with primitive type has type_name.", (a) null);
                } else if (l11 instanceof d) {
                    this.f12929j = (d) l11;
                } else {
                    throw new DescriptorValidationException(this, '\"' + this.f12921b.getTypeName() + "\" is not an enum type.", (a) null);
                }
            } else if (u() == JavaType.MESSAGE || u() == JavaType.ENUM) {
                throw new DescriptorValidationException(this, "Field with message or enum type missing type_name.", (a) null);
            }
            if (!this.f12921b.getOptions().getPacked() || B()) {
                if (this.f12921b.hasDefaultValue()) {
                    if (!o()) {
                        try {
                            switch (a.f12938a[x().ordinal()]) {
                                case 1:
                                case 2:
                                case 3:
                                    this.f12930k = Integer.valueOf(TextFormat.h(this.f12921b.getDefaultValue()));
                                    break;
                                case 4:
                                case 5:
                                    this.f12930k = Integer.valueOf(TextFormat.k(this.f12921b.getDefaultValue()));
                                    break;
                                case 6:
                                case 7:
                                case 8:
                                    this.f12930k = Long.valueOf(TextFormat.i(this.f12921b.getDefaultValue()));
                                    break;
                                case 9:
                                case 10:
                                    this.f12930k = Long.valueOf(TextFormat.l(this.f12921b.getDefaultValue()));
                                    break;
                                case 11:
                                    if (!this.f12921b.getDefaultValue().equals("inf")) {
                                        if (!this.f12921b.getDefaultValue().equals("-inf")) {
                                            if (!this.f12921b.getDefaultValue().equals("nan")) {
                                                this.f12930k = Float.valueOf(this.f12921b.getDefaultValue());
                                                break;
                                            } else {
                                                this.f12930k = Float.valueOf(Float.NaN);
                                                break;
                                            }
                                        } else {
                                            this.f12930k = Float.valueOf(Float.NEGATIVE_INFINITY);
                                            break;
                                        }
                                    } else {
                                        this.f12930k = Float.valueOf(Float.POSITIVE_INFINITY);
                                        break;
                                    }
                                case 12:
                                    if (!this.f12921b.getDefaultValue().equals("inf")) {
                                        if (!this.f12921b.getDefaultValue().equals("-inf")) {
                                            if (!this.f12921b.getDefaultValue().equals("nan")) {
                                                this.f12930k = Double.valueOf(this.f12921b.getDefaultValue());
                                                break;
                                            } else {
                                                this.f12930k = Double.valueOf(Double.NaN);
                                                break;
                                            }
                                        } else {
                                            this.f12930k = Double.valueOf(Double.NEGATIVE_INFINITY);
                                            break;
                                        }
                                    } else {
                                        this.f12930k = Double.valueOf(Double.POSITIVE_INFINITY);
                                        break;
                                    }
                                case 13:
                                    this.f12930k = Boolean.valueOf(this.f12921b.getDefaultValue());
                                    break;
                                case 14:
                                    this.f12930k = this.f12921b.getDefaultValue();
                                    break;
                                case 15:
                                    try {
                                        this.f12930k = TextFormat.r(this.f12921b.getDefaultValue());
                                        break;
                                    } catch (TextFormat.InvalidEscapeSequenceException e10) {
                                        throw new DescriptorValidationException(this, "Couldn't parse default value: " + e10.getMessage(), e10, null);
                                    }
                                case 16:
                                    e f10 = this.f12929j.f(this.f12921b.getDefaultValue());
                                    this.f12930k = f10;
                                    if (f10 != null) {
                                        break;
                                    } else {
                                        throw new DescriptorValidationException(this, "Unknown enum default value: \"" + this.f12921b.getDefaultValue() + '\"', (a) null);
                                    }
                                case 17:
                                case 18:
                                    throw new DescriptorValidationException(this, "Message type had default value.", (a) null);
                            }
                        } catch (NumberFormatException e11) {
                            throw new DescriptorValidationException(this, "Could not parse default value: \"" + this.f12921b.getDefaultValue() + '\"', e11, null);
                        }
                    } else {
                        throw new DescriptorValidationException(this, "Repeated fields cannot have default values.", (a) null);
                    }
                } else if (o()) {
                    this.f12930k = Collections.emptyList();
                } else {
                    int i10 = a.f12939b[u().ordinal()];
                    if (i10 == 1) {
                        this.f12930k = this.f12929j.i().get(0);
                    } else if (i10 != 2) {
                        this.f12930k = u().defaultDefault;
                    } else {
                        this.f12930k = null;
                    }
                }
                if (!y()) {
                    this.f12923d.f12937g.d(this);
                }
                b bVar = this.f12926g;
                if (bVar != null && bVar.q().getMessageSetWireFormat()) {
                    if (!y()) {
                        throw new DescriptorValidationException(this, "MessageSets cannot have fields, only extensions.", (a) null);
                    } else if (!A() || x() != Type.MESSAGE) {
                        throw new DescriptorValidationException(this, "Extensions of MessageSets must be optional messages.", (a) null);
                    }
                }
            } else {
                throw new DescriptorValidationException(this, "[packed = true] can only be specified for repeated primitive fields.", (a) null);
            }
        }

        private static String i(String str) {
            StringBuilder sb2 = new StringBuilder(str.length());
            boolean z10 = false;
            for (int i10 = 0; i10 < str.length(); i10++) {
                Character valueOf = Character.valueOf(str.charAt(i10));
                if (valueOf.charValue() == '_') {
                    z10 = true;
                } else if (z10) {
                    sb2.append(Character.toUpperCase(valueOf.charValue()));
                    z10 = false;
                } else {
                    sb2.append(valueOf);
                }
            }
            return sb2.toString();
        }

        public boolean A() {
            return this.f12921b.getLabel() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL;
        }

        public boolean B() {
            return o() && p().isPackable();
        }

        public boolean C() {
            return this.f12921b.getLabel() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_REQUIRED;
        }

        public boolean D() {
            if (this.f12925f != Type.STRING) {
                return false;
            }
            if (!k().q().getMapEntry() && a().n() != FileDescriptor.Syntax.PROTO3) {
                return a().k().getJavaStringCheckUtf8();
            }
            return true;
        }

        /* renamed from: F */
        public DescriptorProtos.FieldDescriptorProto d() {
            return this.f12921b;
        }

        @Override // com.google.protobuf.Descriptors.f
        public FileDescriptor a() {
            return this.f12923d;
        }

        @Override // com.google.protobuf.Descriptors.f
        public String b() {
            return this.f12922c;
        }

        @Override // com.google.protobuf.Descriptors.f
        public String c() {
            return this.f12921b.getName();
        }

        /* renamed from: g */
        public int compareTo(FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.f12926g == this.f12926g) {
                return getNumber() - fieldDescriptor.getNumber();
            }
            throw new IllegalArgumentException("FieldDescriptors can only be compared to other FieldDescriptors for fields of the same message type.");
        }

        @Override // com.google.protobuf.t.b
        public int getNumber() {
            return this.f12921b.getNumber();
        }

        public h j() {
            return this.f12928i;
        }

        public b k() {
            return this.f12926g;
        }

        public Object l() {
            if (u() != JavaType.MESSAGE) {
                return this.f12930k;
            }
            throw new UnsupportedOperationException("FieldDescriptor.getDefaultValue() called on an embedded message field.");
        }

        public d m() {
            if (u() == JavaType.ENUM) {
                return this.f12929j;
            }
            throw new UnsupportedOperationException("This field is not of enum type.");
        }

        public b n() {
            if (y()) {
                return this.f12924e;
            }
            throw new UnsupportedOperationException("This field is not an extension.");
        }

        @Override // com.google.protobuf.t.b
        public boolean o() {
            return this.f12921b.getLabel() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED;
        }

        @Override // com.google.protobuf.t.b
        public WireFormat.FieldType p() {
            return f12919l[this.f12925f.ordinal()];
        }

        public int q() {
            return this.f12920a;
        }

        @Override // com.google.protobuf.t.b
        public e0.a r(e0.a aVar, e0 e0Var) {
            return ((d0.a) aVar).mergeFrom((d0) e0Var);
        }

        @Override // com.google.protobuf.t.b
        public WireFormat.JavaType s() {
            return p().getJavaType();
        }

        @Override // com.google.protobuf.t.b
        public boolean t() {
            if (!B()) {
                return false;
            }
            if (a().n() == FileDescriptor.Syntax.PROTO2) {
                return w().getPacked();
            }
            return !w().hasPacked() || w().getPacked();
        }

        public String toString() {
            return b();
        }

        public JavaType u() {
            return this.f12925f.getJavaType();
        }

        public b v() {
            if (u() == JavaType.MESSAGE) {
                return this.f12927h;
            }
            throw new UnsupportedOperationException("This field is not of message type.");
        }

        public DescriptorProtos.FieldOptions w() {
            return this.f12921b.getOptions();
        }

        public Type x() {
            return this.f12925f;
        }

        public boolean y() {
            return this.f12921b.hasExtendee();
        }

        public boolean z() {
            return x() == Type.MESSAGE && o() && v().q().getMapEntry();
        }

        private FieldDescriptor(DescriptorProtos.FieldDescriptorProto fieldDescriptorProto, FileDescriptor fileDescriptor, b bVar, int i10, boolean z10) throws DescriptorValidationException {
            this.f12920a = i10;
            this.f12921b = fieldDescriptorProto;
            this.f12922c = Descriptors.c(fileDescriptor, bVar, fieldDescriptorProto.getName());
            this.f12923d = fileDescriptor;
            if (fieldDescriptorProto.hasJsonName()) {
                fieldDescriptorProto.getJsonName();
            } else {
                i(fieldDescriptorProto.getName());
            }
            if (fieldDescriptorProto.hasType()) {
                this.f12925f = Type.valueOf(fieldDescriptorProto.getType());
            }
            if (getNumber() > 0) {
                if (z10) {
                    if (fieldDescriptorProto.hasExtendee()) {
                        this.f12926g = null;
                        if (bVar != null) {
                            this.f12924e = bVar;
                        } else {
                            this.f12924e = null;
                        }
                        if (!fieldDescriptorProto.hasOneofIndex()) {
                            this.f12928i = null;
                        } else {
                            throw new DescriptorValidationException(this, "FieldDescriptorProto.oneof_index set for extension field.", (a) null);
                        }
                    } else {
                        throw new DescriptorValidationException(this, "FieldDescriptorProto.extendee not set for extension field.", (a) null);
                    }
                } else if (!fieldDescriptorProto.hasExtendee()) {
                    this.f12926g = bVar;
                    if (!fieldDescriptorProto.hasOneofIndex()) {
                        this.f12928i = null;
                    } else if (fieldDescriptorProto.getOneofIndex() < 0 || fieldDescriptorProto.getOneofIndex() >= bVar.d().getOneofDeclCount()) {
                        throw new DescriptorValidationException(this, "FieldDescriptorProto.oneof_index is out of range for type " + bVar.c(), (a) null);
                    } else {
                        h hVar = bVar.n().get(fieldDescriptorProto.getOneofIndex());
                        this.f12928i = hVar;
                        h.d(hVar);
                    }
                    this.f12924e = null;
                } else {
                    throw new DescriptorValidationException(this, "FieldDescriptorProto.extendee set for non-extension field.", (a) null);
                }
                fileDescriptor.f12937g.f(this);
                return;
            }
            throw new DescriptorValidationException(this, "Field numbers must be positive integers.", (a) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12938a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f12939b;

        static {
            int[] iArr = new int[FieldDescriptor.JavaType.values().length];
            f12939b = iArr;
            try {
                iArr[FieldDescriptor.JavaType.ENUM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12939b[FieldDescriptor.JavaType.MESSAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[FieldDescriptor.Type.values().length];
            f12938a = iArr2;
            try {
                iArr2[FieldDescriptor.Type.INT32.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12938a[FieldDescriptor.Type.SINT32.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12938a[FieldDescriptor.Type.SFIXED32.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12938a[FieldDescriptor.Type.UINT32.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12938a[FieldDescriptor.Type.FIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f12938a[FieldDescriptor.Type.INT64.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f12938a[FieldDescriptor.Type.SINT64.ordinal()] = 7;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f12938a[FieldDescriptor.Type.SFIXED64.ordinal()] = 8;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f12938a[FieldDescriptor.Type.UINT64.ordinal()] = 9;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f12938a[FieldDescriptor.Type.FIXED64.ordinal()] = 10;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f12938a[FieldDescriptor.Type.FLOAT.ordinal()] = 11;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f12938a[FieldDescriptor.Type.DOUBLE.ordinal()] = 12;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f12938a[FieldDescriptor.Type.BOOL.ordinal()] = 13;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f12938a[FieldDescriptor.Type.STRING.ordinal()] = 14;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f12938a[FieldDescriptor.Type.BYTES.ordinal()] = 15;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f12938a[FieldDescriptor.Type.ENUM.ordinal()] = 16;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f12938a[FieldDescriptor.Type.MESSAGE.ordinal()] = 17;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f12938a[FieldDescriptor.Type.GROUP.ordinal()] = 18;
            } catch (NoSuchFieldError unused20) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends f {

        /* renamed from: a  reason: collision with root package name */
        private DescriptorProtos.DescriptorProto f12940a;

        /* renamed from: b  reason: collision with root package name */
        private final String f12941b;

        /* renamed from: c  reason: collision with root package name */
        private final FileDescriptor f12942c;

        /* renamed from: d  reason: collision with root package name */
        private final b[] f12943d;

        /* renamed from: e  reason: collision with root package name */
        private final d[] f12944e;

        /* renamed from: f  reason: collision with root package name */
        private final FieldDescriptor[] f12945f;

        /* renamed from: g  reason: collision with root package name */
        private final FieldDescriptor[] f12946g;

        /* renamed from: h  reason: collision with root package name */
        private final h[] f12947h;

        /* synthetic */ b(DescriptorProtos.DescriptorProto descriptorProto, FileDescriptor fileDescriptor, b bVar, int i10, a aVar) throws DescriptorValidationException {
            this(descriptorProto, fileDescriptor, bVar, i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g() throws DescriptorValidationException {
            for (b bVar : this.f12943d) {
                bVar.g();
            }
            for (FieldDescriptor fieldDescriptor : this.f12945f) {
                fieldDescriptor.h();
            }
            for (FieldDescriptor fieldDescriptor2 : this.f12946g) {
                fieldDescriptor2.h();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v(DescriptorProtos.DescriptorProto descriptorProto) {
            this.f12940a = descriptorProto;
            int i10 = 0;
            int i11 = 0;
            while (true) {
                b[] bVarArr = this.f12943d;
                if (i11 >= bVarArr.length) {
                    break;
                }
                bVarArr[i11].v(descriptorProto.getNestedType(i11));
                i11++;
            }
            int i12 = 0;
            while (true) {
                h[] hVarArr = this.f12947h;
                if (i12 >= hVarArr.length) {
                    break;
                }
                hVarArr[i12].i(descriptorProto.getOneofDecl(i12));
                i12++;
            }
            int i13 = 0;
            while (true) {
                d[] dVarArr = this.f12944e;
                if (i13 >= dVarArr.length) {
                    break;
                }
                dVarArr[i13].j(descriptorProto.getEnumType(i13));
                i13++;
            }
            int i14 = 0;
            while (true) {
                FieldDescriptor[] fieldDescriptorArr = this.f12945f;
                if (i14 < fieldDescriptorArr.length) {
                    fieldDescriptorArr[i14].E(descriptorProto.getField(i14));
                    i14++;
                }
            }
            while (true) {
                FieldDescriptor[] fieldDescriptorArr2 = this.f12946g;
                if (i10 < fieldDescriptorArr2.length) {
                    fieldDescriptorArr2[i10].E(descriptorProto.getExtension(i10));
                    i10++;
                } else {
                    return;
                }
            }
        }

        @Override // com.google.protobuf.Descriptors.f
        public FileDescriptor a() {
            return this.f12942c;
        }

        @Override // com.google.protobuf.Descriptors.f
        public String b() {
            return this.f12941b;
        }

        @Override // com.google.protobuf.Descriptors.f
        public String c() {
            return this.f12940a.getName();
        }

        public FieldDescriptor h(String str) {
            c cVar = this.f12942c.f12937g;
            f g10 = cVar.g(this.f12941b + '.' + str);
            if (g10 == null || !(g10 instanceof FieldDescriptor)) {
                return null;
            }
            return (FieldDescriptor) g10;
        }

        public FieldDescriptor i(int i10) {
            return (FieldDescriptor) this.f12942c.f12937g.f12951d.get(new c.a(this, i10));
        }

        public List<d> j() {
            return Collections.unmodifiableList(Arrays.asList(this.f12944e));
        }

        public List<FieldDescriptor> k() {
            return Collections.unmodifiableList(Arrays.asList(this.f12946g));
        }

        public List<FieldDescriptor> l() {
            return Collections.unmodifiableList(Arrays.asList(this.f12945f));
        }

        public List<b> m() {
            return Collections.unmodifiableList(Arrays.asList(this.f12943d));
        }

        public List<h> n() {
            return Collections.unmodifiableList(Arrays.asList(this.f12947h));
        }

        public DescriptorProtos.MessageOptions q() {
            return this.f12940a.getOptions();
        }

        public boolean u(int i10) {
            for (DescriptorProtos.DescriptorProto.ExtensionRange extensionRange : this.f12940a.getExtensionRangeList()) {
                if (extensionRange.getStart() <= i10 && i10 < extensionRange.getEnd()) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: w */
        public DescriptorProtos.DescriptorProto d() {
            return this.f12940a;
        }

        b(String str) throws DescriptorValidationException {
            String str2;
            String str3;
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf != -1) {
                str2 = str.substring(lastIndexOf + 1);
                str3 = str.substring(0, lastIndexOf);
            } else {
                str3 = "";
                str2 = str;
            }
            this.f12940a = DescriptorProtos.DescriptorProto.newBuilder().S(str2).a(DescriptorProtos.DescriptorProto.ExtensionRange.newBuilder().q(1).n(536870912).build()).build();
            this.f12941b = str;
            this.f12943d = new b[0];
            this.f12944e = new d[0];
            this.f12945f = new FieldDescriptor[0];
            this.f12946g = new FieldDescriptor[0];
            this.f12947h = new h[0];
            this.f12942c = new FileDescriptor(str3, this);
        }

        private b(DescriptorProtos.DescriptorProto descriptorProto, FileDescriptor fileDescriptor, b bVar, int i10) throws DescriptorValidationException {
            this.f12940a = descriptorProto;
            this.f12941b = Descriptors.c(fileDescriptor, bVar, descriptorProto.getName());
            this.f12942c = fileDescriptor;
            this.f12947h = new h[descriptorProto.getOneofDeclCount()];
            for (int i11 = 0; i11 < descriptorProto.getOneofDeclCount(); i11++) {
                this.f12947h[i11] = new h(descriptorProto.getOneofDecl(i11), fileDescriptor, this, i11, null);
            }
            this.f12943d = new b[descriptorProto.getNestedTypeCount()];
            for (int i12 = 0; i12 < descriptorProto.getNestedTypeCount(); i12++) {
                this.f12943d[i12] = new b(descriptorProto.getNestedType(i12), fileDescriptor, this, i12);
            }
            this.f12944e = new d[descriptorProto.getEnumTypeCount()];
            for (int i13 = 0; i13 < descriptorProto.getEnumTypeCount(); i13++) {
                this.f12944e[i13] = new d(descriptorProto.getEnumType(i13), fileDescriptor, this, i13, null);
            }
            this.f12945f = new FieldDescriptor[descriptorProto.getFieldCount()];
            for (int i14 = 0; i14 < descriptorProto.getFieldCount(); i14++) {
                this.f12945f[i14] = new FieldDescriptor(descriptorProto.getField(i14), fileDescriptor, this, i14, false, null);
            }
            this.f12946g = new FieldDescriptor[descriptorProto.getExtensionCount()];
            for (int i15 = 0; i15 < descriptorProto.getExtensionCount(); i15++) {
                this.f12946g[i15] = new FieldDescriptor(descriptorProto.getExtension(i15), fileDescriptor, this, i15, true, null);
            }
            for (int i16 = 0; i16 < descriptorProto.getOneofDeclCount(); i16++) {
                h[] hVarArr = this.f12947h;
                hVarArr[i16].f12974d = new FieldDescriptor[hVarArr[i16].g()];
                this.f12947h[i16].f12973c = 0;
            }
            for (int i17 = 0; i17 < descriptorProto.getFieldCount(); i17++) {
                h j10 = this.f12945f[i17].j();
                if (j10 != null) {
                    j10.f12974d[h.d(j10)] = this.f12945f[i17];
                }
            }
            fileDescriptor.f12937g.f(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: b  reason: collision with root package name */
        private boolean f12949b;

        /* renamed from: c  reason: collision with root package name */
        private final Map<String, f> f12950c = new HashMap();

        /* renamed from: d  reason: collision with root package name */
        private final Map<a, FieldDescriptor> f12951d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        private final Map<a, e> f12952e = new HashMap();

        /* renamed from: a  reason: collision with root package name */
        private final Set<FileDescriptor> f12948a = new HashSet();

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private final f f12953a;

            /* renamed from: b  reason: collision with root package name */
            private final int f12954b;

            a(f fVar, int i10) {
                this.f12953a = fVar;
                this.f12954b = i10;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return this.f12953a == aVar.f12953a && this.f12954b == aVar.f12954b;
            }

            public int hashCode() {
                return (this.f12953a.hashCode() * 65535) + this.f12954b;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class b extends f {

            /* renamed from: a  reason: collision with root package name */
            private final String f12955a;

            /* renamed from: b  reason: collision with root package name */
            private final String f12956b;

            /* renamed from: c  reason: collision with root package name */
            private final FileDescriptor f12957c;

            b(String str, String str2, FileDescriptor fileDescriptor) {
                this.f12957c = fileDescriptor;
                this.f12956b = str2;
                this.f12955a = str;
            }

            @Override // com.google.protobuf.Descriptors.f
            public FileDescriptor a() {
                return this.f12957c;
            }

            @Override // com.google.protobuf.Descriptors.f
            public String b() {
                return this.f12956b;
            }

            @Override // com.google.protobuf.Descriptors.f
            public String c() {
                return this.f12955a;
            }

            @Override // com.google.protobuf.Descriptors.f
            public d0 d() {
                return this.f12957c.d();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.google.protobuf.Descriptors$c$c  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public enum EnumC0167c {
            TYPES_ONLY,
            AGGREGATES_ONLY,
            ALL_SYMBOLS
        }

        c(FileDescriptor[] fileDescriptorArr, boolean z10) {
            this.f12949b = z10;
            for (int i10 = 0; i10 < fileDescriptorArr.length; i10++) {
                this.f12948a.add(fileDescriptorArr[i10]);
                i(fileDescriptorArr[i10]);
            }
            for (FileDescriptor fileDescriptor : this.f12948a) {
                try {
                    e(fileDescriptor.l(), fileDescriptor);
                } catch (DescriptorValidationException unused) {
                }
            }
        }

        private void i(FileDescriptor fileDescriptor) {
            for (FileDescriptor fileDescriptor2 : fileDescriptor.m()) {
                if (this.f12948a.add(fileDescriptor2)) {
                    i(fileDescriptor2);
                }
            }
        }

        static void m(f fVar) throws DescriptorValidationException {
            String c10 = fVar.c();
            if (c10.length() != 0) {
                boolean z10 = true;
                for (int i10 = 0; i10 < c10.length(); i10++) {
                    char charAt = c10.charAt(i10);
                    if (charAt >= 128) {
                        z10 = false;
                    }
                    if (!Character.isLetter(charAt) && charAt != '_' && (!Character.isDigit(charAt) || i10 <= 0)) {
                        z10 = false;
                    }
                }
                if (!z10) {
                    throw new DescriptorValidationException(fVar, '\"' + c10 + "\" is not a valid identifier.", (a) null);
                }
                return;
            }
            throw new DescriptorValidationException(fVar, "Missing name.", (a) null);
        }

        void c(e eVar) {
            a aVar = new a(eVar.g(), eVar.getNumber());
            e put = this.f12952e.put(aVar, eVar);
            if (put != null) {
                this.f12952e.put(aVar, put);
            }
        }

        void d(FieldDescriptor fieldDescriptor) throws DescriptorValidationException {
            a aVar = new a(fieldDescriptor.k(), fieldDescriptor.getNumber());
            FieldDescriptor put = this.f12951d.put(aVar, fieldDescriptor);
            if (put != null) {
                this.f12951d.put(aVar, put);
                throw new DescriptorValidationException(fieldDescriptor, "Field number " + fieldDescriptor.getNumber() + " has already been used in \"" + fieldDescriptor.k().b() + "\" by field \"" + put.c() + "\".", (a) null);
            }
        }

        void e(String str, FileDescriptor fileDescriptor) throws DescriptorValidationException {
            String str2;
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf == -1) {
                str2 = str;
            } else {
                e(str.substring(0, lastIndexOf), fileDescriptor);
                str2 = str.substring(lastIndexOf + 1);
            }
            f put = this.f12950c.put(str, new b(str2, str, fileDescriptor));
            if (put != null) {
                this.f12950c.put(str, put);
                if (!(put instanceof b)) {
                    throw new DescriptorValidationException(fileDescriptor, '\"' + str2 + "\" is already defined (as something other than a package) in file \"" + put.a().c() + "\".", (a) null);
                }
            }
        }

        void f(f fVar) throws DescriptorValidationException {
            m(fVar);
            String b10 = fVar.b();
            int lastIndexOf = b10.lastIndexOf(46);
            f put = this.f12950c.put(b10, fVar);
            if (put != null) {
                this.f12950c.put(b10, put);
                if (fVar.a() != put.a()) {
                    throw new DescriptorValidationException(fVar, '\"' + b10 + "\" is already defined in file \"" + put.a().c() + "\".", (a) null);
                } else if (lastIndexOf == -1) {
                    throw new DescriptorValidationException(fVar, '\"' + b10 + "\" is already defined.", (a) null);
                } else {
                    throw new DescriptorValidationException(fVar, '\"' + b10.substring(lastIndexOf + 1) + "\" is already defined in \"" + b10.substring(0, lastIndexOf) + "\".", (a) null);
                }
            }
        }

        f g(String str) {
            return h(str, EnumC0167c.ALL_SYMBOLS);
        }

        f h(String str, EnumC0167c cVar) {
            f fVar = this.f12950c.get(str);
            if (fVar != null && (cVar == EnumC0167c.ALL_SYMBOLS || ((cVar == EnumC0167c.TYPES_ONLY && k(fVar)) || (cVar == EnumC0167c.AGGREGATES_ONLY && j(fVar))))) {
                return fVar;
            }
            for (FileDescriptor fileDescriptor : this.f12948a) {
                f fVar2 = fileDescriptor.f12937g.f12950c.get(str);
                if (fVar2 != null && (cVar == EnumC0167c.ALL_SYMBOLS || ((cVar == EnumC0167c.TYPES_ONLY && k(fVar2)) || (cVar == EnumC0167c.AGGREGATES_ONLY && j(fVar2))))) {
                    return fVar2;
                }
            }
            return null;
        }

        boolean j(f fVar) {
            return (fVar instanceof b) || (fVar instanceof d) || (fVar instanceof b) || (fVar instanceof i);
        }

        boolean k(f fVar) {
            return (fVar instanceof b) || (fVar instanceof d);
        }

        f l(String str, f fVar, EnumC0167c cVar) throws DescriptorValidationException {
            f fVar2;
            String str2;
            if (str.startsWith(".")) {
                str2 = str.substring(1);
                fVar2 = h(str2, cVar);
            } else {
                int indexOf = str.indexOf(46);
                String substring = indexOf == -1 ? str : str.substring(0, indexOf);
                StringBuilder sb2 = new StringBuilder(fVar.b());
                while (true) {
                    int lastIndexOf = sb2.lastIndexOf(".");
                    if (lastIndexOf == -1) {
                        fVar2 = h(str, cVar);
                        str2 = str;
                        break;
                    }
                    int i10 = lastIndexOf + 1;
                    sb2.setLength(i10);
                    sb2.append(substring);
                    f h10 = h(sb2.toString(), EnumC0167c.AGGREGATES_ONLY);
                    if (h10 != null) {
                        if (indexOf != -1) {
                            sb2.setLength(i10);
                            sb2.append(str);
                            fVar2 = h(sb2.toString(), cVar);
                        } else {
                            fVar2 = h10;
                        }
                        str2 = sb2.toString();
                    } else {
                        sb2.setLength(lastIndexOf);
                    }
                }
            }
            if (fVar2 != null) {
                return fVar2;
            }
            if (!this.f12949b || cVar != EnumC0167c.TYPES_ONLY) {
                throw new DescriptorValidationException(fVar, '\"' + str + "\" is not defined.", (a) null);
            }
            Logger logger = Descriptors.f12918a;
            logger.warning("The descriptor for message type \"" + str + "\" can not be found and a placeholder is created for it");
            b bVar = new b(str2);
            this.f12948a.add(bVar.a());
            return bVar;
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends f implements u.b<e> {

        /* renamed from: a  reason: collision with root package name */
        private DescriptorProtos.EnumDescriptorProto f12958a;

        /* renamed from: b  reason: collision with root package name */
        private final String f12959b;

        /* renamed from: c  reason: collision with root package name */
        private final FileDescriptor f12960c;

        /* renamed from: d  reason: collision with root package name */
        private e[] f12961d;

        /* renamed from: e  reason: collision with root package name */
        private final WeakHashMap<Integer, WeakReference<e>> f12962e;

        /* synthetic */ d(DescriptorProtos.EnumDescriptorProto enumDescriptorProto, FileDescriptor fileDescriptor, b bVar, int i10, a aVar) throws DescriptorValidationException {
            this(enumDescriptorProto, fileDescriptor, bVar, i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(DescriptorProtos.EnumDescriptorProto enumDescriptorProto) {
            this.f12958a = enumDescriptorProto;
            int i10 = 0;
            while (true) {
                e[] eVarArr = this.f12961d;
                if (i10 < eVarArr.length) {
                    eVarArr[i10].h(enumDescriptorProto.getValue(i10));
                    i10++;
                } else {
                    return;
                }
            }
        }

        @Override // com.google.protobuf.Descriptors.f
        public FileDescriptor a() {
            return this.f12960c;
        }

        @Override // com.google.protobuf.Descriptors.f
        public String b() {
            return this.f12959b;
        }

        @Override // com.google.protobuf.Descriptors.f
        public String c() {
            return this.f12958a.getName();
        }

        public e f(String str) {
            c cVar = this.f12960c.f12937g;
            f g10 = cVar.g(this.f12959b + '.' + str);
            if (g10 == null || !(g10 instanceof e)) {
                return null;
            }
            return (e) g10;
        }

        public e g(int i10) {
            return (e) this.f12960c.f12937g.f12952e.get(new c.a(this, i10));
        }

        public e h(int i10) {
            e g10 = g(i10);
            if (g10 != null) {
                return g10;
            }
            synchronized (this) {
                Integer num = new Integer(i10);
                WeakReference<e> weakReference = this.f12962e.get(num);
                if (weakReference != null) {
                    g10 = weakReference.get();
                }
                if (g10 == null) {
                    g10 = new e(this.f12960c, this, num, (a) null);
                    this.f12962e.put(num, new WeakReference<>(g10));
                }
            }
            return g10;
        }

        public List<e> i() {
            return Collections.unmodifiableList(Arrays.asList(this.f12961d));
        }

        /* renamed from: k */
        public DescriptorProtos.EnumDescriptorProto d() {
            return this.f12958a;
        }

        private d(DescriptorProtos.EnumDescriptorProto enumDescriptorProto, FileDescriptor fileDescriptor, b bVar, int i10) throws DescriptorValidationException {
            this.f12962e = new WeakHashMap<>();
            this.f12958a = enumDescriptorProto;
            this.f12959b = Descriptors.c(fileDescriptor, bVar, enumDescriptorProto.getName());
            this.f12960c = fileDescriptor;
            if (enumDescriptorProto.getValueCount() != 0) {
                this.f12961d = new e[enumDescriptorProto.getValueCount()];
                for (int i11 = 0; i11 < enumDescriptorProto.getValueCount(); i11++) {
                    this.f12961d[i11] = new e(enumDescriptorProto.getValue(i11), fileDescriptor, this, i11, null);
                }
                fileDescriptor.f12937g.f(this);
                return;
            }
            throw new DescriptorValidationException(this, "Enums must contain at least one value.", (a) null);
        }
    }

    /* loaded from: classes.dex */
    public static final class e extends f implements u.a {

        /* renamed from: a  reason: collision with root package name */
        private final int f12963a;

        /* renamed from: b  reason: collision with root package name */
        private DescriptorProtos.EnumValueDescriptorProto f12964b;

        /* renamed from: c  reason: collision with root package name */
        private final String f12965c;

        /* renamed from: d  reason: collision with root package name */
        private final FileDescriptor f12966d;

        /* renamed from: e  reason: collision with root package name */
        private final d f12967e;

        /* synthetic */ e(DescriptorProtos.EnumValueDescriptorProto enumValueDescriptorProto, FileDescriptor fileDescriptor, d dVar, int i10, a aVar) throws DescriptorValidationException {
            this(enumValueDescriptorProto, fileDescriptor, dVar, i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(DescriptorProtos.EnumValueDescriptorProto enumValueDescriptorProto) {
            this.f12964b = enumValueDescriptorProto;
        }

        @Override // com.google.protobuf.Descriptors.f
        public FileDescriptor a() {
            return this.f12966d;
        }

        @Override // com.google.protobuf.Descriptors.f
        public String b() {
            return this.f12965c;
        }

        @Override // com.google.protobuf.Descriptors.f
        public String c() {
            return this.f12964b.getName();
        }

        public int f() {
            return this.f12963a;
        }

        public d g() {
            return this.f12967e;
        }

        @Override // com.google.protobuf.u.a
        public int getNumber() {
            return this.f12964b.getNumber();
        }

        /* renamed from: i */
        public DescriptorProtos.EnumValueDescriptorProto d() {
            return this.f12964b;
        }

        public String toString() {
            return this.f12964b.getName();
        }

        /* synthetic */ e(FileDescriptor fileDescriptor, d dVar, Integer num, a aVar) {
            this(fileDescriptor, dVar, num);
        }

        private e(DescriptorProtos.EnumValueDescriptorProto enumValueDescriptorProto, FileDescriptor fileDescriptor, d dVar, int i10) throws DescriptorValidationException {
            this.f12963a = i10;
            this.f12964b = enumValueDescriptorProto;
            this.f12966d = fileDescriptor;
            this.f12967e = dVar;
            this.f12965c = dVar.b() + '.' + enumValueDescriptorProto.getName();
            fileDescriptor.f12937g.f(this);
            fileDescriptor.f12937g.c(this);
        }

        private e(FileDescriptor fileDescriptor, d dVar, Integer num) {
            DescriptorProtos.EnumValueDescriptorProto b10 = DescriptorProtos.EnumValueDescriptorProto.newBuilder().s("UNKNOWN_ENUM_VALUE_" + dVar.c() + "_" + num).t(num.intValue()).build();
            this.f12963a = -1;
            this.f12964b = b10;
            this.f12966d = fileDescriptor;
            this.f12967e = dVar;
            this.f12965c = dVar.b() + '.' + b10.getName();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class f {
        public abstract FileDescriptor a();

        public abstract String b();

        public abstract String c();

        public abstract d0 d();
    }

    /* loaded from: classes.dex */
    public static final class g extends f {

        /* renamed from: a  reason: collision with root package name */
        private DescriptorProtos.MethodDescriptorProto f12968a;

        /* renamed from: b  reason: collision with root package name */
        private final String f12969b;

        /* renamed from: c  reason: collision with root package name */
        private final FileDescriptor f12970c;

        /* synthetic */ g(DescriptorProtos.MethodDescriptorProto methodDescriptorProto, FileDescriptor fileDescriptor, i iVar, int i10, a aVar) throws DescriptorValidationException {
            this(methodDescriptorProto, fileDescriptor, iVar, i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g() throws DescriptorValidationException {
            c cVar = this.f12970c.f12937g;
            String inputType = this.f12968a.getInputType();
            c.EnumC0167c cVar2 = c.EnumC0167c.TYPES_ONLY;
            f l10 = cVar.l(inputType, this, cVar2);
            if (l10 instanceof b) {
                b bVar = (b) l10;
                f l11 = this.f12970c.f12937g.l(this.f12968a.getOutputType(), this, cVar2);
                if (l11 instanceof b) {
                    b bVar2 = (b) l11;
                    return;
                }
                throw new DescriptorValidationException(this, '\"' + this.f12968a.getOutputType() + "\" is not a message type.", (a) null);
            }
            throw new DescriptorValidationException(this, '\"' + this.f12968a.getInputType() + "\" is not a message type.", (a) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(DescriptorProtos.MethodDescriptorProto methodDescriptorProto) {
            this.f12968a = methodDescriptorProto;
        }

        @Override // com.google.protobuf.Descriptors.f
        public FileDescriptor a() {
            return this.f12970c;
        }

        @Override // com.google.protobuf.Descriptors.f
        public String b() {
            return this.f12969b;
        }

        @Override // com.google.protobuf.Descriptors.f
        public String c() {
            return this.f12968a.getName();
        }

        /* renamed from: i */
        public DescriptorProtos.MethodDescriptorProto d() {
            return this.f12968a;
        }

        private g(DescriptorProtos.MethodDescriptorProto methodDescriptorProto, FileDescriptor fileDescriptor, i iVar, int i10) throws DescriptorValidationException {
            this.f12968a = methodDescriptorProto;
            this.f12970c = fileDescriptor;
            this.f12969b = iVar.b() + '.' + methodDescriptorProto.getName();
            fileDescriptor.f12937g.f(this);
        }
    }

    /* loaded from: classes.dex */
    public static final class h {

        /* renamed from: a  reason: collision with root package name */
        private final int f12971a;

        /* renamed from: b  reason: collision with root package name */
        private b f12972b;

        /* renamed from: c  reason: collision with root package name */
        private int f12973c;

        /* renamed from: d  reason: collision with root package name */
        private FieldDescriptor[] f12974d;

        /* synthetic */ h(DescriptorProtos.OneofDescriptorProto oneofDescriptorProto, FileDescriptor fileDescriptor, b bVar, int i10, a aVar) throws DescriptorValidationException {
            this(oneofDescriptorProto, fileDescriptor, bVar, i10);
        }

        static /* synthetic */ int d(h hVar) {
            int i10 = hVar.f12973c;
            hVar.f12973c = i10 + 1;
            return i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(DescriptorProtos.OneofDescriptorProto oneofDescriptorProto) {
        }

        public b f() {
            return this.f12972b;
        }

        public int g() {
            return this.f12973c;
        }

        public int h() {
            return this.f12971a;
        }

        private h(DescriptorProtos.OneofDescriptorProto oneofDescriptorProto, FileDescriptor fileDescriptor, b bVar, int i10) throws DescriptorValidationException {
            Descriptors.c(fileDescriptor, bVar, oneofDescriptorProto.getName());
            this.f12971a = i10;
            this.f12972b = bVar;
            this.f12973c = 0;
        }
    }

    /* loaded from: classes.dex */
    public static final class i extends f {

        /* renamed from: a  reason: collision with root package name */
        private DescriptorProtos.ServiceDescriptorProto f12975a;

        /* renamed from: b  reason: collision with root package name */
        private final String f12976b;

        /* renamed from: c  reason: collision with root package name */
        private final FileDescriptor f12977c;

        /* renamed from: d  reason: collision with root package name */
        private g[] f12978d;

        /* synthetic */ i(DescriptorProtos.ServiceDescriptorProto serviceDescriptorProto, FileDescriptor fileDescriptor, int i10, a aVar) throws DescriptorValidationException {
            this(serviceDescriptorProto, fileDescriptor, i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g() throws DescriptorValidationException {
            for (g gVar : this.f12978d) {
                gVar.g();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(DescriptorProtos.ServiceDescriptorProto serviceDescriptorProto) {
            this.f12975a = serviceDescriptorProto;
            int i10 = 0;
            while (true) {
                g[] gVarArr = this.f12978d;
                if (i10 < gVarArr.length) {
                    gVarArr[i10].h(serviceDescriptorProto.getMethod(i10));
                    i10++;
                } else {
                    return;
                }
            }
        }

        @Override // com.google.protobuf.Descriptors.f
        public FileDescriptor a() {
            return this.f12977c;
        }

        @Override // com.google.protobuf.Descriptors.f
        public String b() {
            return this.f12976b;
        }

        @Override // com.google.protobuf.Descriptors.f
        public String c() {
            return this.f12975a.getName();
        }

        /* renamed from: i */
        public DescriptorProtos.ServiceDescriptorProto d() {
            return this.f12975a;
        }

        private i(DescriptorProtos.ServiceDescriptorProto serviceDescriptorProto, FileDescriptor fileDescriptor, int i10) throws DescriptorValidationException {
            this.f12975a = serviceDescriptorProto;
            this.f12976b = Descriptors.c(fileDescriptor, null, serviceDescriptorProto.getName());
            this.f12977c = fileDescriptor;
            this.f12978d = new g[serviceDescriptorProto.getMethodCount()];
            for (int i11 = 0; i11 < serviceDescriptorProto.getMethodCount(); i11++) {
                this.f12978d[i11] = new g(serviceDescriptorProto.getMethod(i11), fileDescriptor, this, i11, null);
            }
            fileDescriptor.f12937g.f(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(FileDescriptor fileDescriptor, b bVar, String str) {
        if (bVar != null) {
            return bVar.b() + '.' + str;
        } else if (fileDescriptor.l().length() <= 0) {
            return str;
        } else {
            return fileDescriptor.l() + '.' + str;
        }
    }

    /* loaded from: classes.dex */
    public static final class FileDescriptor extends f {

        /* renamed from: a  reason: collision with root package name */
        private DescriptorProtos.FileDescriptorProto f12931a;

        /* renamed from: b  reason: collision with root package name */
        private final b[] f12932b;

        /* renamed from: c  reason: collision with root package name */
        private final d[] f12933c;

        /* renamed from: d  reason: collision with root package name */
        private final i[] f12934d;

        /* renamed from: e  reason: collision with root package name */
        private final FieldDescriptor[] f12935e;

        /* renamed from: f  reason: collision with root package name */
        private final FileDescriptor[] f12936f;

        /* renamed from: g  reason: collision with root package name */
        private final c f12937g;

        /* loaded from: classes.dex */
        public enum Syntax {
            UNKNOWN("unknown"),
            PROTO2("proto2"),
            PROTO3("proto3");
            
            private final String name;

            Syntax(String str) {
                this.name = str;
            }
        }

        /* loaded from: classes.dex */
        public interface a {
            o assignDescriptors(FileDescriptor fileDescriptor);
        }

        private FileDescriptor(DescriptorProtos.FileDescriptorProto fileDescriptorProto, FileDescriptor[] fileDescriptorArr, c cVar, boolean z10) throws DescriptorValidationException {
            this.f12937g = cVar;
            this.f12931a = fileDescriptorProto;
            fileDescriptorArr.clone();
            HashMap hashMap = new HashMap();
            for (FileDescriptor fileDescriptor : fileDescriptorArr) {
                hashMap.put(fileDescriptor.c(), fileDescriptor);
            }
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < fileDescriptorProto.getPublicDependencyCount(); i10++) {
                int publicDependency = fileDescriptorProto.getPublicDependency(i10);
                if (publicDependency < 0 || publicDependency >= fileDescriptorProto.getDependencyCount()) {
                    throw new DescriptorValidationException(this, "Invalid public dependency index.", (a) null);
                }
                String dependency = fileDescriptorProto.getDependency(publicDependency);
                FileDescriptor fileDescriptor2 = (FileDescriptor) hashMap.get(dependency);
                if (fileDescriptor2 != null) {
                    arrayList.add(fileDescriptor2);
                } else if (!z10) {
                    throw new DescriptorValidationException(this, "Invalid public dependency: " + dependency, (a) null);
                }
            }
            FileDescriptor[] fileDescriptorArr2 = new FileDescriptor[arrayList.size()];
            this.f12936f = fileDescriptorArr2;
            arrayList.toArray(fileDescriptorArr2);
            cVar.e(l(), this);
            this.f12932b = new b[fileDescriptorProto.getMessageTypeCount()];
            for (int i11 = 0; i11 < fileDescriptorProto.getMessageTypeCount(); i11++) {
                this.f12932b[i11] = new b(fileDescriptorProto.getMessageType(i11), this, null, i11, null);
            }
            this.f12933c = new d[fileDescriptorProto.getEnumTypeCount()];
            for (int i12 = 0; i12 < fileDescriptorProto.getEnumTypeCount(); i12++) {
                this.f12933c[i12] = new d(fileDescriptorProto.getEnumType(i12), this, null, i12, null);
            }
            this.f12934d = new i[fileDescriptorProto.getServiceCount()];
            for (int i13 = 0; i13 < fileDescriptorProto.getServiceCount(); i13++) {
                this.f12934d[i13] = new i(fileDescriptorProto.getService(i13), this, i13, null);
            }
            this.f12935e = new FieldDescriptor[fileDescriptorProto.getExtensionCount()];
            for (int i14 = 0; i14 < fileDescriptorProto.getExtensionCount(); i14++) {
                this.f12935e[i14] = new FieldDescriptor(fileDescriptorProto.getExtension(i14), this, null, i14, true, null);
            }
        }

        public static FileDescriptor f(DescriptorProtos.FileDescriptorProto fileDescriptorProto, FileDescriptor[] fileDescriptorArr, boolean z10) throws DescriptorValidationException {
            FileDescriptor fileDescriptor = new FileDescriptor(fileDescriptorProto, fileDescriptorArr, new c(fileDescriptorArr, z10), z10);
            fileDescriptor.g();
            return fileDescriptor;
        }

        private void g() throws DescriptorValidationException {
            for (b bVar : this.f12932b) {
                bVar.g();
            }
            for (i iVar : this.f12934d) {
                iVar.g();
            }
            for (FieldDescriptor fieldDescriptor : this.f12935e) {
                fieldDescriptor.h();
            }
        }

        public static void q(String[] strArr, FileDescriptor[] fileDescriptorArr, a aVar) {
            DescriptorProtos.FileDescriptorProto parseFrom;
            StringBuilder sb2 = new StringBuilder();
            for (String str : strArr) {
                sb2.append(str);
            }
            byte[] bytes = sb2.toString().getBytes(u.f13365b);
            try {
                try {
                    FileDescriptor f10 = f(DescriptorProtos.FileDescriptorProto.parseFrom(bytes), fileDescriptorArr, true);
                    o assignDescriptors = aVar.assignDescriptors(f10);
                    if (assignDescriptors != null) {
                        try {
                            f10.u(DescriptorProtos.FileDescriptorProto.parseFrom(bytes, assignDescriptors));
                        } catch (InvalidProtocolBufferException e10) {
                            throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e10);
                        }
                    }
                } catch (DescriptorValidationException e11) {
                    throw new IllegalArgumentException("Invalid embedded descriptor for \"" + parseFrom.getName() + "\".", e11);
                }
            } catch (InvalidProtocolBufferException e12) {
                throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e12);
            }
        }

        private void u(DescriptorProtos.FileDescriptorProto fileDescriptorProto) {
            this.f12931a = fileDescriptorProto;
            int i10 = 0;
            int i11 = 0;
            while (true) {
                b[] bVarArr = this.f12932b;
                if (i11 >= bVarArr.length) {
                    break;
                }
                bVarArr[i11].v(fileDescriptorProto.getMessageType(i11));
                i11++;
            }
            int i12 = 0;
            while (true) {
                d[] dVarArr = this.f12933c;
                if (i12 >= dVarArr.length) {
                    break;
                }
                dVarArr[i12].j(fileDescriptorProto.getEnumType(i12));
                i12++;
            }
            int i13 = 0;
            while (true) {
                i[] iVarArr = this.f12934d;
                if (i13 < iVarArr.length) {
                    iVarArr[i13].h(fileDescriptorProto.getService(i13));
                    i13++;
                }
            }
            while (true) {
                FieldDescriptor[] fieldDescriptorArr = this.f12935e;
                if (i10 < fieldDescriptorArr.length) {
                    fieldDescriptorArr[i10].E(fileDescriptorProto.getExtension(i10));
                    i10++;
                } else {
                    return;
                }
            }
        }

        @Override // com.google.protobuf.Descriptors.f
        public FileDescriptor a() {
            return this;
        }

        @Override // com.google.protobuf.Descriptors.f
        public String b() {
            return this.f12931a.getName();
        }

        @Override // com.google.protobuf.Descriptors.f
        public String c() {
            return this.f12931a.getName();
        }

        public FieldDescriptor h(String str) {
            if (str.indexOf(46) != -1) {
                return null;
            }
            if (l().length() > 0) {
                str = l() + '.' + str;
            }
            f g10 = this.f12937g.g(str);
            if (g10 == null || !(g10 instanceof FieldDescriptor) || g10.a() != this) {
                return null;
            }
            return (FieldDescriptor) g10;
        }

        public List<d> i() {
            return Collections.unmodifiableList(Arrays.asList(this.f12933c));
        }

        public List<b> j() {
            return Collections.unmodifiableList(Arrays.asList(this.f12932b));
        }

        public DescriptorProtos.FileOptions k() {
            return this.f12931a.getOptions();
        }

        public String l() {
            return this.f12931a.getPackage();
        }

        public List<FileDescriptor> m() {
            return Collections.unmodifiableList(Arrays.asList(this.f12936f));
        }

        public Syntax n() {
            Syntax syntax = Syntax.PROTO3;
            return syntax.name.equals(this.f12931a.getSyntax()) ? syntax : Syntax.PROTO2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean v() {
            return n() == Syntax.PROTO3;
        }

        /* renamed from: w */
        public DescriptorProtos.FileDescriptorProto d() {
            return this.f12931a;
        }

        FileDescriptor(String str, b bVar) throws DescriptorValidationException {
            c cVar = new c(new FileDescriptor[0], true);
            this.f12937g = cVar;
            DescriptorProtos.FileDescriptorProto.b newBuilder = DescriptorProtos.FileDescriptorProto.newBuilder();
            this.f12931a = newBuilder.P(bVar.b() + ".placeholder.proto").Q(str).a(bVar.d()).build();
            this.f12936f = new FileDescriptor[0];
            this.f12932b = new b[]{bVar};
            this.f12933c = new d[0];
            this.f12934d = new i[0];
            this.f12935e = new FieldDescriptor[0];
            cVar.e(str, this);
            cVar.f(bVar);
        }
    }
}
