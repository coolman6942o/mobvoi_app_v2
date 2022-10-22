package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.MessageReflection;
import com.google.protobuf.a1;
import com.google.protobuf.b;
import com.google.protobuf.d0;
import com.google.protobuf.u;
import com.mobvoi.wear.providers.HealthDataProviderContracts;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* compiled from: AbstractMessage.java */
/* loaded from: classes.dex */
public abstract class a extends com.google.protobuf.b implements d0 {
    protected int memoizedSize = -1;

    /* compiled from: AbstractMessage.java */
    /* renamed from: com.google.protobuf.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0170a<BuilderType extends AbstractC0170a<BuilderType>> extends b.a implements d0.a {
        /* JADX INFO: Access modifiers changed from: protected */
        public static UninitializedMessageException newUninitializedMessageException(d0 d0Var) {
            return new UninitializedMessageException(MessageReflection.c(d0Var));
        }

        @Override // com.google.protobuf.b.a
        public abstract BuilderType clone();

        /* JADX INFO: Access modifiers changed from: package-private */
        public void dispose() {
            throw new IllegalStateException("Should be overridden by subclasses.");
        }

        public List<String> findInitializationErrors() {
            return MessageReflection.c(this);
        }

        public d0.a getFieldBuilder(Descriptors.FieldDescriptor fieldDescriptor) {
            throw new UnsupportedOperationException("getFieldBuilder() called on an unsupported message type.");
        }

        public String getInitializationErrorString() {
            return MessageReflection.a(findInitializationErrors());
        }

        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.h hVar) {
            throw new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
        }

        public d0.a getRepeatedFieldBuilder(Descriptors.FieldDescriptor fieldDescriptor, int i10) {
            throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on an unsupported message type.");
        }

        public boolean hasOneof(Descriptors.h hVar) {
            throw new UnsupportedOperationException("hasOneof() is not implemented.");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void markClean() {
            throw new IllegalStateException("Should be overridden by subclasses.");
        }

        @Override // com.google.protobuf.b.a
        public boolean mergeDelimitedFrom(InputStream inputStream) throws IOException {
            return super.mergeDelimitedFrom(inputStream);
        }

        public String toString() {
            return TextFormat.o(this);
        }

        public BuilderType clearOneof(Descriptors.h hVar) {
            throw new UnsupportedOperationException("clearOneof() is not implemented.");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.b.a
        public BuilderType internalMergeFrom(com.google.protobuf.b bVar) {
            return mergeFrom((d0) bVar);
        }

        @Override // com.google.protobuf.b.a
        public boolean mergeDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return super.mergeDelimitedFrom(inputStream, qVar);
        }

        public BuilderType mergeUnknownFields(a1 a1Var) {
            setUnknownFields(a1.h(getUnknownFields()).o(a1Var).build());
            return this;
        }

        public BuilderType clear() {
            for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : getAllFields().entrySet()) {
                clearField(entry.getKey());
            }
            return this;
        }

        public BuilderType mergeFrom(d0 d0Var) {
            if (d0Var.getDescriptorForType() == getDescriptorForType()) {
                for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : d0Var.getAllFields().entrySet()) {
                    Descriptors.FieldDescriptor key = entry.getKey();
                    if (key.o()) {
                        for (Object obj : (List) entry.getValue()) {
                            addRepeatedField(key, obj);
                        }
                    } else if (key.u() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                        d0 d0Var2 = (d0) getField(key);
                        if (d0Var2 == d0Var2.getDefaultInstanceForType()) {
                            setField(key, entry.getValue());
                        } else {
                            setField(key, d0Var2.newBuilderForType().mergeFrom(d0Var2).mergeFrom((d0) entry.getValue()).build());
                        }
                    } else {
                        setField(key, entry.getValue());
                    }
                }
                mergeUnknownFields(d0Var.getUnknownFields());
                return this;
            }
            throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
        }

        @Override // com.google.protobuf.b.a
        public BuilderType mergeFrom(i iVar) throws IOException {
            return mergeFrom(iVar, (q) o.e());
        }

        @Override // com.google.protobuf.b.a, com.google.protobuf.e0.a
        public BuilderType mergeFrom(i iVar, q qVar) throws IOException {
            int F;
            a1.b h10 = a1.h(getUnknownFields());
            do {
                F = iVar.F();
                if (F == 0) {
                    break;
                }
            } while (MessageReflection.g(iVar, h10, qVar, getDescriptorForType(), new MessageReflection.b(this), F));
            setUnknownFields(h10.build());
            return this;
        }

        @Override // com.google.protobuf.b.a
        public BuilderType mergeFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(byteString);
        }

        @Override // com.google.protobuf.b.a, com.google.protobuf.d0.a
        public BuilderType mergeFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(byteString, qVar);
        }

        @Override // com.google.protobuf.b.a, com.google.protobuf.e0.a
        public BuilderType mergeFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(bArr);
        }

        @Override // com.google.protobuf.b.a
        public BuilderType mergeFrom(byte[] bArr, int i10, int i11) throws InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(bArr, i10, i11);
        }

        @Override // com.google.protobuf.b.a
        public BuilderType mergeFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.b.a
        public BuilderType mergeFrom(byte[] bArr, int i10, int i11, q qVar) throws InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(bArr, i10, i11, qVar);
        }

        @Override // com.google.protobuf.b.a
        public BuilderType mergeFrom(InputStream inputStream) throws IOException {
            return (BuilderType) super.mergeFrom(inputStream);
        }

        @Override // com.google.protobuf.b.a
        public BuilderType mergeFrom(InputStream inputStream, q qVar) throws IOException {
            return (BuilderType) super.mergeFrom(inputStream, qVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: AbstractMessage.java */
    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    private static boolean compareBytes(Object obj, Object obj2) {
        if (!(obj instanceof byte[]) || !(obj2 instanceof byte[])) {
            return toByteString(obj).equals(toByteString(obj2));
        }
        return Arrays.equals((byte[]) obj, (byte[]) obj2);
    }

    static boolean compareFields(Map<Descriptors.FieldDescriptor, Object> map, Map<Descriptors.FieldDescriptor, Object> map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (Descriptors.FieldDescriptor fieldDescriptor : map.keySet()) {
            if (!map2.containsKey(fieldDescriptor)) {
                return false;
            }
            Object obj = map.get(fieldDescriptor);
            Object obj2 = map2.get(fieldDescriptor);
            if (fieldDescriptor.x() == Descriptors.FieldDescriptor.Type.BYTES) {
                if (fieldDescriptor.o()) {
                    List list = (List) obj;
                    List list2 = (List) obj2;
                    if (list.size() != list2.size()) {
                        return false;
                    }
                    for (int i10 = 0; i10 < list.size(); i10++) {
                        if (!compareBytes(list.get(i10), list2.get(i10))) {
                            return false;
                        }
                    }
                    continue;
                } else if (!compareBytes(obj, obj2)) {
                    return false;
                }
            } else if (fieldDescriptor.z()) {
                if (!compareMapField(obj, obj2)) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    private static boolean compareMapField(Object obj, Object obj2) {
        return MapFieldLite.k(convertMapEntryListToMap((List) obj), convertMapEntryListToMap((List) obj2));
    }

    private static Map convertMapEntryListToMap(List list) {
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        d0 d0Var = (d0) it.next();
        Descriptors.b descriptorForType = d0Var.getDescriptorForType();
        Descriptors.FieldDescriptor h10 = descriptorForType.h("key");
        Descriptors.FieldDescriptor h11 = descriptorForType.h(HealthDataProviderContracts.NAME_VALUE);
        Object field = d0Var.getField(h11);
        if (field instanceof Descriptors.e) {
            field = Integer.valueOf(((Descriptors.e) field).getNumber());
        }
        hashMap.put(d0Var.getField(h10), field);
        while (it.hasNext()) {
            d0 d0Var2 = (d0) it.next();
            Object field2 = d0Var2.getField(h11);
            if (field2 instanceof Descriptors.e) {
                field2 = Integer.valueOf(((Descriptors.e) field2).getNumber());
            }
            hashMap.put(d0Var2.getField(h10), field2);
        }
        return hashMap;
    }

    @Deprecated
    protected static int hashBoolean(boolean z10) {
        return z10 ? 1231 : 1237;
    }

    @Deprecated
    protected static int hashEnum(u.a aVar) {
        return aVar.getNumber();
    }

    @Deprecated
    protected static int hashEnumList(List<? extends u.a> list) {
        int i10 = 1;
        for (u.a aVar : list) {
            i10 = (i10 * 31) + hashEnum(aVar);
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int hashFields(int i10, Map<Descriptors.FieldDescriptor, Object> map) {
        int i11;
        int f10;
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : map.entrySet()) {
            Descriptors.FieldDescriptor key = entry.getKey();
            Object value = entry.getValue();
            int number = (i10 * 37) + key.getNumber();
            if (key.z()) {
                i11 = number * 53;
                f10 = hashMapField(value);
            } else if (key.x() != Descriptors.FieldDescriptor.Type.ENUM) {
                i11 = number * 53;
                f10 = value.hashCode();
            } else if (key.o()) {
                i11 = number * 53;
                f10 = u.g((List) value);
            } else {
                i11 = number * 53;
                f10 = u.f((u.a) value);
            }
            i10 = i11 + f10;
        }
        return i10;
    }

    @Deprecated
    protected static int hashLong(long j10) {
        return (int) (j10 ^ (j10 >>> 32));
    }

    private static int hashMapField(Object obj) {
        return MapFieldLite.a(convertMapEntryListToMap((List) obj));
    }

    private static ByteString toByteString(Object obj) {
        if (obj instanceof byte[]) {
            return ByteString.copyFrom((byte[]) obj);
        }
        return (ByteString) obj;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        if (getDescriptorForType() != d0Var.getDescriptorForType()) {
            return false;
        }
        return compareFields(getAllFields(), d0Var.getAllFields()) && getUnknownFields().equals(d0Var.getUnknownFields());
    }

    public List<String> findInitializationErrors() {
        return MessageReflection.c(this);
    }

    public String getInitializationErrorString() {
        return MessageReflection.a(findInitializationErrors());
    }

    public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.h hVar) {
        throw new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
    }

    @Override // com.google.protobuf.e0
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int e10 = MessageReflection.e(this, getAllFields());
        this.memoizedSize = e10;
        return e10;
    }

    public boolean hasOneof(Descriptors.h hVar) {
        throw new UnsupportedOperationException("hasOneof() is not implemented.");
    }

    public int hashCode() {
        int i10 = this.memoizedHashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashFields = (hashFields(779 + getDescriptorForType().hashCode(), getAllFields()) * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = hashFields;
        return hashFields;
    }

    @Override // com.google.protobuf.f0
    public boolean isInitialized() {
        return MessageReflection.f(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d0.a newBuilderForType(b bVar) {
        throw new UnsupportedOperationException("Nested builder is not supported for this type.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.b
    public UninitializedMessageException newUninitializedMessageException() {
        return AbstractC0170a.newUninitializedMessageException((d0) this);
    }

    public final String toString() {
        return TextFormat.o(this);
    }

    @Override // com.google.protobuf.e0
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        MessageReflection.k(this, getAllFields(), codedOutputStream, false);
    }
}
