package retrofit2.converter.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.e0;
import com.google.protobuf.l0;
import com.google.protobuf.q;
import java.io.IOException;
import okhttp3.c0;
import retrofit2.Converter;
/* loaded from: classes3.dex */
final class ProtoResponseBodyConverter<T extends e0> implements Converter<c0, T> {
    private final l0<T> parser;
    private final q registry;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoResponseBodyConverter(l0<T> l0Var, q qVar) {
        this.parser = l0Var;
        this.registry = qVar;
    }

    public T convert(c0 c0Var) throws IOException {
        try {
            try {
                return this.parser.parseFrom(c0Var.byteStream(), this.registry);
            } catch (InvalidProtocolBufferException e10) {
                throw new RuntimeException(e10);
            }
        } finally {
            c0Var.close();
        }
    }
}
