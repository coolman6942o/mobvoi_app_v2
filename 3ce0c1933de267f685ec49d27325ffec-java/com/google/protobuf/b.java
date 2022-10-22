package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.b;
import com.google.protobuf.b.a;
import com.google.protobuf.e0;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
/* compiled from: AbstractMessageLite.java */
/* loaded from: classes.dex */
public abstract class b<MessageType extends b<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> implements e0 {
    protected int memoizedHashCode = 0;

    /* compiled from: AbstractMessageLite.java */
    /* loaded from: classes.dex */
    public static abstract class a<MessageType extends b<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> implements e0.a {
        /* JADX INFO: Access modifiers changed from: protected */
        public static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
            Objects.requireNonNull(iterable);
            if (iterable instanceof y) {
                checkForNullValues(((y) iterable).O());
                collection.addAll((Collection) iterable);
            } else if (iterable instanceof Collection) {
                checkForNullValues(iterable);
                collection.addAll((Collection) iterable);
            } else {
                for (T t10 : iterable) {
                    Objects.requireNonNull(t10);
                    collection.add(t10);
                }
            }
        }

        private static void checkForNullValues(Iterable<?> iterable) {
            Iterator<?> it = iterable.iterator();
            while (it.hasNext()) {
                Objects.requireNonNull(it.next());
            }
        }

        private String getReadingExceptionMessage(String str) {
            return "Reading " + getClass().getName() + " from a " + str + " threw an IOException (should never happen).";
        }

        protected static UninitializedMessageException newUninitializedMessageException(e0 e0Var) {
            return new UninitializedMessageException(e0Var);
        }

        public abstract BuilderType clone();

        public abstract /* bridge */ /* synthetic */ e0.a clone();

        public abstract /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException;

        protected abstract BuilderType internalMergeFrom(MessageType messagetype);

        public boolean mergeDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            int read = inputStream.read();
            if (read == -1) {
                return false;
            }
            mergeFrom((InputStream) new C0171a(inputStream, i.y(read, inputStream)), qVar);
            return true;
        }

        public abstract BuilderType mergeFrom(i iVar) throws IOException;

        @Override // com.google.protobuf.e0.a
        public abstract BuilderType mergeFrom(i iVar, q qVar) throws IOException;

        public abstract /* bridge */ /* synthetic */ e0.a mergeFrom(ByteString byteString) throws InvalidProtocolBufferException;

        public abstract /* bridge */ /* synthetic */ e0.a mergeFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException;

        public abstract /* bridge */ /* synthetic */ e0.a mergeFrom(i iVar) throws IOException;

        @Override // com.google.protobuf.e0.a
        public abstract /* bridge */ /* synthetic */ e0.a mergeFrom(i iVar, q qVar) throws IOException;

        public abstract /* bridge */ /* synthetic */ e0.a mergeFrom(InputStream inputStream) throws IOException;

        public abstract /* bridge */ /* synthetic */ e0.a mergeFrom(InputStream inputStream, q qVar) throws IOException;

        @Override // com.google.protobuf.e0.a
        public abstract /* bridge */ /* synthetic */ e0.a mergeFrom(byte[] bArr) throws InvalidProtocolBufferException;

        public abstract /* bridge */ /* synthetic */ e0.a mergeFrom(byte[] bArr, int i10, int i11) throws InvalidProtocolBufferException;

        public abstract /* bridge */ /* synthetic */ e0.a mergeFrom(byte[] bArr, int i10, int i11, q qVar) throws InvalidProtocolBufferException;

        public abstract /* bridge */ /* synthetic */ e0.a mergeFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException;

        public BuilderType mergeFrom(ByteString byteString) throws InvalidProtocolBufferException {
            try {
                i newCodedInput = byteString.newCodedInput();
                mergeFrom(newCodedInput);
                newCodedInput.a(0);
                return this;
            } catch (InvalidProtocolBufferException e10) {
                throw e10;
            } catch (IOException e11) {
                throw new RuntimeException(getReadingExceptionMessage("ByteString"), e11);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AbstractMessageLite.java */
        /* renamed from: com.google.protobuf.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0171a extends FilterInputStream {

            /* renamed from: a  reason: collision with root package name */
            private int f13168a;

            /* JADX INFO: Access modifiers changed from: package-private */
            public C0171a(InputStream inputStream, int i10) {
                super(inputStream);
                this.f13168a = i10;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() throws IOException {
                return Math.min(super.available(), this.f13168a);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.f13168a <= 0) {
                    return -1;
                }
                int read = super.read();
                if (read >= 0) {
                    this.f13168a--;
                }
                return read;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j10) throws IOException {
                long skip = super.skip(Math.min(j10, this.f13168a));
                if (skip >= 0) {
                    this.f13168a = (int) (this.f13168a - skip);
                }
                return skip;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i10, int i11) throws IOException {
                int i12 = this.f13168a;
                if (i12 <= 0) {
                    return -1;
                }
                int read = super.read(bArr, i10, Math.min(i11, i12));
                if (read >= 0) {
                    this.f13168a -= read;
                }
                return read;
            }
        }

        public boolean mergeDelimitedFrom(InputStream inputStream) throws IOException {
            return mergeDelimitedFrom(inputStream, q.a());
        }

        public BuilderType mergeFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            try {
                i newCodedInput = byteString.newCodedInput();
                mergeFrom(newCodedInput, qVar);
                newCodedInput.a(0);
                return this;
            } catch (InvalidProtocolBufferException e10) {
                throw e10;
            } catch (IOException e11) {
                throw new RuntimeException(getReadingExceptionMessage("ByteString"), e11);
            }
        }

        @Override // com.google.protobuf.e0.a
        public BuilderType mergeFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return mergeFrom(bArr, 0, bArr.length);
        }

        public BuilderType mergeFrom(byte[] bArr, int i10, int i11) throws InvalidProtocolBufferException {
            try {
                i h10 = i.h(bArr, i10, i11);
                mergeFrom(h10);
                h10.a(0);
                return this;
            } catch (InvalidProtocolBufferException e10) {
                throw e10;
            } catch (IOException e11) {
                throw new RuntimeException(getReadingExceptionMessage("byte array"), e11);
            }
        }

        public BuilderType mergeFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return mergeFrom(bArr, 0, bArr.length, qVar);
        }

        public BuilderType mergeFrom(byte[] bArr, int i10, int i11, q qVar) throws InvalidProtocolBufferException {
            try {
                i h10 = i.h(bArr, i10, i11);
                mergeFrom(h10, qVar);
                h10.a(0);
                return this;
            } catch (InvalidProtocolBufferException e10) {
                throw e10;
            } catch (IOException e11) {
                throw new RuntimeException(getReadingExceptionMessage("byte array"), e11);
            }
        }

        public BuilderType mergeFrom(InputStream inputStream) throws IOException {
            i e10 = i.e(inputStream);
            mergeFrom(e10);
            e10.a(0);
            return this;
        }

        public BuilderType mergeFrom(InputStream inputStream, q qVar) throws IOException {
            i e10 = i.e(inputStream);
            mergeFrom(e10, qVar);
            e10.a(0);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public BuilderType mergeFrom(e0 e0Var) {
            if (getDefaultInstanceForType().getClass().isInstance(e0Var)) {
                return (BuilderType) internalMergeFrom((b) e0Var);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
    }

    protected static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
        a.addAll(iterable, collection);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void checkByteStringIsUtf8(ByteString byteString) throws IllegalArgumentException {
        if (!byteString.isValidUtf8()) {
            throw new IllegalArgumentException("Byte string is not UTF-8.");
        }
    }

    private String getSerializingExceptionMessage(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException(this);
    }

    @Override // com.google.protobuf.e0
    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            CodedOutputStream a02 = CodedOutputStream.a0(bArr);
            writeTo(a02);
            a02.d();
            return bArr;
        } catch (IOException e10) {
            throw new RuntimeException(getSerializingExceptionMessage("byte array"), e10);
        }
    }

    @Override // com.google.protobuf.e0
    public ByteString toByteString() {
        try {
            ByteString.f i10 = ByteString.i(getSerializedSize());
            writeTo(i10.b());
            return i10.a();
        } catch (IOException e10) {
            throw new RuntimeException(getSerializingExceptionMessage("ByteString"), e10);
        }
    }

    public void writeDelimitedTo(OutputStream outputStream) throws IOException {
        int serializedSize = getSerializedSize();
        CodedOutputStream Z = CodedOutputStream.Z(outputStream, CodedOutputStream.G(CodedOutputStream.I(serializedSize) + serializedSize));
        Z.E0(serializedSize);
        writeTo(Z);
        Z.W();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        CodedOutputStream Z = CodedOutputStream.Z(outputStream, CodedOutputStream.G(getSerializedSize()));
        writeTo(Z);
        Z.W();
    }
}
