package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Extension;
import com.google.protobuf.a;
import com.google.protobuf.d0;
import com.google.protobuf.e0;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes.dex */
public abstract class GeneratedMessage extends com.google.protobuf.a implements Serializable {
    protected static boolean alwaysUseFieldBuilders = false;
    private static final long serialVersionUID = 1;
    protected a1 unknownFields = a1.c();

    /* loaded from: classes.dex */
    class a implements f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.b f13011a;

        a(GeneratedMessage generatedMessage, a.b bVar) {
            this.f13011a = bVar;
        }

        @Override // com.google.protobuf.a.b
        public void a() {
            this.f13011a.a();
        }
    }

    /* loaded from: classes.dex */
    static class b extends g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d0 f13012b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f13013c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(d0 d0Var, int i10) {
            super(null);
            this.f13012b = d0Var;
            this.f13013c = i10;
        }

        @Override // com.google.protobuf.GeneratedMessage.g
        public Descriptors.FieldDescriptor b() {
            return this.f13012b.getDescriptorForType().k().get(this.f13013c);
        }
    }

    /* loaded from: classes.dex */
    static class c extends g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d0 f13014b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13015c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(d0 d0Var, String str) {
            super(null);
            this.f13014b = d0Var;
            this.f13015c = str;
        }

        @Override // com.google.protobuf.GeneratedMessage.g
        protected Descriptors.FieldDescriptor b() {
            return this.f13014b.getDescriptorForType().h(this.f13015c);
        }
    }

    /* loaded from: classes.dex */
    static class d extends g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class f13016b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13017c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f13018d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Class cls, String str, String str2) {
            super(null);
            this.f13016b = cls;
            this.f13017c = str;
            this.f13018d = str2;
        }

        @Override // com.google.protobuf.GeneratedMessage.g
        protected Descriptors.FieldDescriptor b() {
            try {
                return ((Descriptors.FileDescriptor) this.f13016b.getClassLoader().loadClass(this.f13017c).getField("descriptor").get(null)).h(this.f13018d);
            } catch (Exception e10) {
                throw new RuntimeException("Cannot load descriptors: " + this.f13017c + " is not a valid descriptor class name", e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class e {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f13019a;

        static {
            int[] iArr = new int[Descriptors.FieldDescriptor.JavaType.values().length];
            f13019a = iArr;
            try {
                iArr[Descriptors.FieldDescriptor.JavaType.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13019a[Descriptors.FieldDescriptor.JavaType.ENUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes.dex */
    protected interface f extends a.b {
    }

    /* loaded from: classes.dex */
    private static abstract class g implements h {

        /* renamed from: a  reason: collision with root package name */
        private volatile Descriptors.FieldDescriptor f13020a;

        private g() {
        }

        @Override // com.google.protobuf.GeneratedMessage.h
        public Descriptors.FieldDescriptor a() {
            if (this.f13020a == null) {
                synchronized (this) {
                    if (this.f13020a == null) {
                        this.f13020a = b();
                    }
                }
            }
            return this.f13020a;
        }

        protected abstract Descriptors.FieldDescriptor b();

        /* synthetic */ g(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface h {
        Descriptors.FieldDescriptor a();
    }

    /* loaded from: classes.dex */
    public static final class i {

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public interface a {
            Object a(GeneratedMessage generatedMessage, int i10);

            Object b(GeneratedMessage generatedMessage);

            boolean c(GeneratedMessage generatedMessage);

            Object d(GeneratedMessage generatedMessage);

            int e(GeneratedMessage generatedMessage);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class b {
        }

        static /* synthetic */ Descriptors.b a(i iVar) {
            throw null;
        }

        static /* synthetic */ b b(i iVar, Descriptors.h hVar) {
            throw null;
        }

        static /* synthetic */ a c(i iVar, Descriptors.FieldDescriptor fieldDescriptor) {
            throw null;
        }
    }

    /* loaded from: classes.dex */
    public static class j<ContainingType extends d0, Type> extends Extension<ContainingType, Type> {

        /* renamed from: a  reason: collision with root package name */
        private h f13021a;

        /* renamed from: b  reason: collision with root package name */
        private final Class f13022b;

        /* renamed from: c  reason: collision with root package name */
        private final d0 f13023c;

        /* renamed from: d  reason: collision with root package name */
        private final Method f13024d;

        j(h hVar, Class cls, d0 d0Var, Extension.ExtensionType extensionType) {
            if (!d0.class.isAssignableFrom(cls) || cls.isInstance(d0Var)) {
                this.f13021a = hVar;
                this.f13022b = cls;
                this.f13023c = d0Var;
                if (m0.class.isAssignableFrom(cls)) {
                    this.f13024d = GeneratedMessage.getMethodOrDie(cls, "valueOf", Descriptors.e.class);
                    GeneratedMessage.getMethodOrDie(cls, "getValueDescriptor", new Class[0]);
                    return;
                }
                this.f13024d = null;
                return;
            }
            throw new IllegalArgumentException("Bad messageDefaultInstance for " + cls.getName());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.Extension
        public Object c(Object obj) {
            Descriptors.FieldDescriptor d10 = d();
            if (!d10.o()) {
                return e(obj);
            }
            if (!(d10.u() == Descriptors.FieldDescriptor.JavaType.MESSAGE || d10.u() == Descriptors.FieldDescriptor.JavaType.ENUM)) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : (List) obj) {
                arrayList.add(e(obj2));
            }
            return arrayList;
        }

        @Override // com.google.protobuf.Extension
        public Descriptors.FieldDescriptor d() {
            h hVar = this.f13021a;
            if (hVar != null) {
                return hVar.a();
            }
            throw new IllegalStateException("getDescriptor() called before internalInit()");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.Extension
        public Object e(Object obj) {
            int i10 = e.f13019a[d().u().ordinal()];
            return i10 != 1 ? i10 != 2 ? obj : GeneratedMessage.invokeOrDie(this.f13024d, null, (Descriptors.e) obj) : this.f13022b.isInstance(obj) ? obj : this.f13023c.newBuilderForType().mergeFrom((d0) obj).build();
        }

        /* renamed from: f */
        public d0 a() {
            return this.f13023c;
        }
    }

    protected GeneratedMessage() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <MessageType extends ExtendableMessage<MessageType>, T> Extension<MessageType, T> checkNotLite(n<MessageType, T> nVar) {
        if (!nVar.b()) {
            return (Extension) nVar;
        }
        throw new IllegalArgumentException("Expected non-lite extension.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable(boolean z10) {
        TreeMap treeMap = new TreeMap();
        List<Descriptors.FieldDescriptor> l10 = i.a(d()).l();
        int i10 = 0;
        while (i10 < l10.size()) {
            Descriptors.FieldDescriptor fieldDescriptor = l10.get(i10);
            Descriptors.h j10 = fieldDescriptor.j();
            if (j10 != null) {
                i10 += j10.g() - 1;
                if (!hasOneof(j10)) {
                    i10++;
                } else {
                    fieldDescriptor = getOneofFieldDescriptor(j10);
                    if (z10 || fieldDescriptor.u() != Descriptors.FieldDescriptor.JavaType.STRING) {
                        treeMap.put(fieldDescriptor, getField(fieldDescriptor));
                    } else {
                        treeMap.put(fieldDescriptor, getFieldRaw(fieldDescriptor));
                    }
                    i10++;
                }
            } else {
                if (fieldDescriptor.o()) {
                    List list = (List) getField(fieldDescriptor);
                    if (!list.isEmpty()) {
                        treeMap.put(fieldDescriptor, list);
                    }
                } else {
                    if (!hasField(fieldDescriptor)) {
                    }
                    if (z10) {
                    }
                    treeMap.put(fieldDescriptor, getField(fieldDescriptor));
                }
                i10++;
            }
        }
        return treeMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e10) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object invokeOrDie(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    public static <ContainingType extends d0, Type> j<ContainingType, Type> newFileScopedGeneratedExtension(Class cls, d0 d0Var) {
        return new j<>(null, cls, d0Var, Extension.ExtensionType.IMMUTABLE);
    }

    public static <ContainingType extends d0, Type> j<ContainingType, Type> newMessageScopedGeneratedExtension(d0 d0Var, int i10, Class cls, d0 d0Var2) {
        return new j<>(new b(d0Var, i10), cls, d0Var2, Extension.ExtensionType.IMMUTABLE);
    }

    protected abstract i d();

    protected abstract d0.a g(f fVar);

    @Override // com.google.protobuf.g0
    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
        return Collections.unmodifiableMap(getAllFieldsMutable(false));
    }

    Map<Descriptors.FieldDescriptor, Object> getAllFieldsRaw() {
        return Collections.unmodifiableMap(getAllFieldsMutable(true));
    }

    @Override // com.google.protobuf.f0, com.google.protobuf.g0
    public abstract /* synthetic */ d0 getDefaultInstanceForType();

    @Override // com.google.protobuf.f0, com.google.protobuf.g0
    public abstract /* synthetic */ e0 getDefaultInstanceForType();

    @Override // com.google.protobuf.g0
    public Descriptors.b getDescriptorForType() {
        return i.a(d());
    }

    @Override // com.google.protobuf.g0
    public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
        return i.c(d(), fieldDescriptor).b(this);
    }

    Object getFieldRaw(Descriptors.FieldDescriptor fieldDescriptor) {
        return i.c(d(), fieldDescriptor).d(this);
    }

    @Override // com.google.protobuf.a
    public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.h hVar) {
        i.b(d(), hVar);
        throw null;
    }

    @Override // com.google.protobuf.e0, com.google.protobuf.d0
    public l0<? extends GeneratedMessage> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    public Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10) {
        return i.c(d(), fieldDescriptor).a(this, i10);
    }

    public int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor) {
        return i.c(d(), fieldDescriptor).e(this);
    }

    @Override // com.google.protobuf.a, com.google.protobuf.e0
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int e10 = MessageReflection.e(this, getAllFieldsRaw());
        this.memoizedSize = e10;
        return e10;
    }

    @Override // com.google.protobuf.g0
    public a1 getUnknownFields() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    @Override // com.google.protobuf.g0
    public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
        return i.c(d(), fieldDescriptor).c(this);
    }

    @Override // com.google.protobuf.a
    public boolean hasOneof(Descriptors.h hVar) {
        i.b(d(), hVar);
        throw null;
    }

    @Override // com.google.protobuf.a, com.google.protobuf.f0
    public boolean isInitialized() {
        for (Descriptors.FieldDescriptor fieldDescriptor : getDescriptorForType().l()) {
            if (fieldDescriptor.C() && !hasField(fieldDescriptor)) {
                return false;
            }
            if (fieldDescriptor.u() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (fieldDescriptor.o()) {
                    for (d0 d0Var : (List) getField(fieldDescriptor)) {
                        if (!d0Var.isInitialized()) {
                            return false;
                        }
                    }
                    continue;
                } else if (hasField(fieldDescriptor) && !((d0) getField(fieldDescriptor)).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.google.protobuf.e0, com.google.protobuf.d0
    public abstract /* synthetic */ d0.a newBuilderForType();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.a
    public d0.a newBuilderForType(a.b bVar) {
        return g(new a(this, bVar));
    }

    @Override // com.google.protobuf.e0, com.google.protobuf.d0
    public abstract /* synthetic */ e0.a newBuilderForType();

    @Override // com.google.protobuf.e0, com.google.protobuf.d0
    public abstract /* synthetic */ d0.a toBuilder();

    @Override // com.google.protobuf.e0, com.google.protobuf.d0
    public abstract /* synthetic */ e0.a toBuilder();

    @Override // com.google.protobuf.a, com.google.protobuf.e0
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        MessageReflection.k(this, getAllFieldsRaw(), codedOutputStream, false);
    }

    public static <ContainingType extends d0, Type> j<ContainingType, Type> newFileScopedGeneratedExtension(Class cls, d0 d0Var, String str, String str2) {
        return new j<>(new d(cls, str, str2), cls, d0Var, Extension.ExtensionType.MUTABLE);
    }

    public static <ContainingType extends d0, Type> j<ContainingType, Type> newMessageScopedGeneratedExtension(d0 d0Var, String str, Class cls, d0 d0Var2) {
        return new j<>(new c(d0Var, str), cls, d0Var2, Extension.ExtensionType.MUTABLE);
    }

    /* loaded from: classes.dex */
    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage> extends GeneratedMessage implements g0 {
        private static final long serialVersionUID = 1;
        private final t<Descriptors.FieldDescriptor> extensions = t.A();

        protected ExtendableMessage() {
        }

        private void j(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.k() != getDescriptorForType()) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }

        private void k(Extension<MessageType, ?> extension) {
            if (extension.d().k() != getDescriptorForType()) {
                throw new IllegalArgumentException("Extension is for type \"" + extension.d().k().b() + "\" which does not match message type \"" + getDescriptorForType().b() + "\".");
            }
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.g0
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            Map allFieldsMutable = getAllFieldsMutable(false);
            allFieldsMutable.putAll(i());
            return Collections.unmodifiableMap(allFieldsMutable);
        }

        @Override // com.google.protobuf.GeneratedMessage
        public Map<Descriptors.FieldDescriptor, Object> getAllFieldsRaw() {
            Map allFieldsMutable = getAllFieldsMutable(false);
            allFieldsMutable.putAll(i());
            return Collections.unmodifiableMap(allFieldsMutable);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.f0, com.google.protobuf.g0
        public abstract /* synthetic */ d0 getDefaultInstanceForType();

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.f0, com.google.protobuf.g0
        public abstract /* synthetic */ e0 getDefaultInstanceForType();

        public final <Type> Type getExtension(n<MessageType, Type> nVar) {
            Extension<MessageType, ?> checkNotLite = GeneratedMessage.checkNotLite(nVar);
            k(checkNotLite);
            Descriptors.FieldDescriptor d10 = checkNotLite.d();
            Object l10 = this.extensions.l(d10);
            if (l10 != null) {
                return (Type) checkNotLite.c(l10);
            }
            if (d10.o()) {
                return (Type) Collections.emptyList();
            }
            if (d10.u() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                return (Type) checkNotLite.a();
            }
            return (Type) checkNotLite.c(d10.l());
        }

        public final <Type> int getExtensionCount(n<MessageType, List<Type>> nVar) {
            Extension<MessageType, ?> checkNotLite = GeneratedMessage.checkNotLite(nVar);
            k(checkNotLite);
            return this.extensions.p(checkNotLite.d());
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.g0
        public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.y()) {
                return GeneratedMessage.super.getField(fieldDescriptor);
            }
            j(fieldDescriptor);
            Object l10 = this.extensions.l(fieldDescriptor);
            if (l10 != null) {
                return l10;
            }
            if (fieldDescriptor.o()) {
                return Collections.emptyList();
            }
            if (fieldDescriptor.u() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                return k.g(fieldDescriptor.v());
            }
            return fieldDescriptor.l();
        }

        @Override // com.google.protobuf.GeneratedMessage
        public Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10) {
            if (!fieldDescriptor.y()) {
                return GeneratedMessage.super.getRepeatedField(fieldDescriptor, i10);
            }
            j(fieldDescriptor);
            return this.extensions.o(fieldDescriptor, i10);
        }

        @Override // com.google.protobuf.GeneratedMessage
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.y()) {
                return GeneratedMessage.super.getRepeatedFieldCount(fieldDescriptor);
            }
            j(fieldDescriptor);
            return this.extensions.p(fieldDescriptor);
        }

        protected boolean h() {
            return this.extensions.u();
        }

        public final <Type> boolean hasExtension(n<MessageType, Type> nVar) {
            Extension<MessageType, ?> checkNotLite = GeneratedMessage.checkNotLite(nVar);
            k(checkNotLite);
            return this.extensions.s(checkNotLite.d());
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.g0
        public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.y()) {
                return GeneratedMessage.super.hasField(fieldDescriptor);
            }
            j(fieldDescriptor);
            return this.extensions.s(fieldDescriptor);
        }

        protected Map<Descriptors.FieldDescriptor, Object> i() {
            return this.extensions.k();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.a, com.google.protobuf.f0
        public boolean isInitialized() {
            return GeneratedMessage.super.isInitialized() && h();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.e0, com.google.protobuf.d0
        public abstract /* synthetic */ d0.a newBuilderForType();

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.e0, com.google.protobuf.d0
        public abstract /* synthetic */ e0.a newBuilderForType();

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.e0, com.google.protobuf.d0
        public abstract /* synthetic */ d0.a toBuilder();

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.e0, com.google.protobuf.d0
        public abstract /* synthetic */ e0.a toBuilder();

        public final <Type> boolean hasExtension(Extension<MessageType, Type> extension) {
            return hasExtension((n) extension);
        }

        public final <Type> int getExtensionCount(Extension<MessageType, List<Type>> extension) {
            return getExtensionCount((n) extension);
        }

        public final <Type> boolean hasExtension(j<MessageType, Type> jVar) {
            return hasExtension((n) jVar);
        }

        public final <Type> int getExtensionCount(j<MessageType, List<Type>> jVar) {
            return getExtensionCount((n) jVar);
        }

        public final <Type> Type getExtension(n<MessageType, List<Type>> nVar, int i10) {
            Extension<MessageType, ?> checkNotLite = GeneratedMessage.checkNotLite(nVar);
            k(checkNotLite);
            return (Type) checkNotLite.e(this.extensions.o(checkNotLite.d(), i10));
        }

        public final <Type> Type getExtension(Extension<MessageType, Type> extension) {
            return (Type) getExtension((n<MessageType, Object>) extension);
        }

        public final <Type> Type getExtension(j<MessageType, Type> jVar) {
            return (Type) getExtension((n<MessageType, Object>) jVar);
        }

        public final <Type> Type getExtension(Extension<MessageType, List<Type>> extension, int i10) {
            return (Type) getExtension((n<MessageType, List<Object>>) extension, i10);
        }

        public final <Type> Type getExtension(j<MessageType, List<Type>> jVar, int i10) {
            return (Type) getExtension((n<MessageType, List<Object>>) jVar, i10);
        }
    }
}
