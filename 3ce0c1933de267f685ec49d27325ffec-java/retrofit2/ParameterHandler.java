package retrofit2;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.a0;
import okhttp3.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class ParameterHandler<T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Body<T> extends ParameterHandler<T> {
        private final Converter<T, a0> converter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Body(Converter<T, a0> converter) {
            this.converter = converter;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, T t10) {
            if (t10 != null) {
                try {
                    requestBuilder.setBody(this.converter.convert(t10));
                } catch (IOException e10) {
                    throw new RuntimeException("Unable to convert " + t10 + " to RequestBody", e10);
                }
            } else {
                throw new IllegalArgumentException("Body parameter value must not be null.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Field<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final String name;
        private final Converter<T, String> valueConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Field(String str, Converter<T, String> converter, boolean z10) {
            this.name = (String) Utils.checkNotNull(str, "name == null");
            this.valueConverter = converter;
            this.encoded = z10;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, T t10) throws IOException {
            String convert;
            if (t10 != null && (convert = this.valueConverter.convert(t10)) != null) {
                requestBuilder.addFormField(this.name, convert, this.encoded);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class FieldMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encoded;
        private final Converter<T, String> valueConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public FieldMap(Converter<T, String> converter, boolean z10) {
            this.valueConverter = converter;
            this.encoded = z10;
        }

        @Override // retrofit2.ParameterHandler
        /* bridge */ /* synthetic */ void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
            apply(requestBuilder, (Map) ((Map) obj));
        }

        void apply(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            String convert = this.valueConverter.convert(value);
                            if (convert != null) {
                                requestBuilder.addFormField(key, convert, this.encoded);
                            } else {
                                throw new IllegalArgumentException("Field map value '" + value + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + key + "'.");
                            }
                        } else {
                            throw new IllegalArgumentException("Field map contained null value for key '" + key + "'.");
                        }
                    } else {
                        throw new IllegalArgumentException("Field map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Field map was null.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Header<T> extends ParameterHandler<T> {
        private final String name;
        private final Converter<T, String> valueConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Header(String str, Converter<T, String> converter) {
            this.name = (String) Utils.checkNotNull(str, "name == null");
            this.valueConverter = converter;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, T t10) throws IOException {
            String convert;
            if (t10 != null && (convert = this.valueConverter.convert(t10)) != null) {
                requestBuilder.addHeader(this.name, convert);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class HeaderMap<T> extends ParameterHandler<Map<String, T>> {
        private final Converter<T, String> valueConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public HeaderMap(Converter<T, String> converter) {
            this.valueConverter = converter;
        }

        @Override // retrofit2.ParameterHandler
        /* bridge */ /* synthetic */ void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
            apply(requestBuilder, (Map) ((Map) obj));
        }

        void apply(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            requestBuilder.addHeader(key, this.valueConverter.convert(value));
                        } else {
                            throw new IllegalArgumentException("Header map contained null value for key '" + key + "'.");
                        }
                    } else {
                        throw new IllegalArgumentException("Header map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Header map was null.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Part<T> extends ParameterHandler<T> {
        private final Converter<T, a0> converter;
        private final Headers headers;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Part(Headers headers, Converter<T, a0> converter) {
            this.headers = headers;
            this.converter = converter;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, T t10) {
            if (t10 != null) {
                try {
                    requestBuilder.addPart(this.headers, this.converter.convert(t10));
                } catch (IOException e10) {
                    throw new RuntimeException("Unable to convert " + t10 + " to RequestBody", e10);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class PartMap<T> extends ParameterHandler<Map<String, T>> {
        private final String transferEncoding;
        private final Converter<T, a0> valueConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public PartMap(Converter<T, a0> converter, String str) {
            this.valueConverter = converter;
            this.transferEncoding = str;
        }

        @Override // retrofit2.ParameterHandler
        /* bridge */ /* synthetic */ void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
            apply(requestBuilder, (Map) ((Map) obj));
        }

        void apply(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            requestBuilder.addPart(Headers.of("Content-Disposition", "form-data; name=\"" + key + "\"", "Content-Transfer-Encoding", this.transferEncoding), this.valueConverter.convert(value));
                        } else {
                            throw new IllegalArgumentException("Part map contained null value for key '" + key + "'.");
                        }
                    } else {
                        throw new IllegalArgumentException("Part map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Part map was null.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Path<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final String name;
        private final Converter<T, String> valueConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Path(String str, Converter<T, String> converter, boolean z10) {
            this.name = (String) Utils.checkNotNull(str, "name == null");
            this.valueConverter = converter;
            this.encoded = z10;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, T t10) throws IOException {
            if (t10 != null) {
                requestBuilder.addPathParam(this.name, this.valueConverter.convert(t10), this.encoded);
                return;
            }
            throw new IllegalArgumentException("Path parameter \"" + this.name + "\" value must not be null.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Query<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final String name;
        private final Converter<T, String> valueConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Query(String str, Converter<T, String> converter, boolean z10) {
            this.name = (String) Utils.checkNotNull(str, "name == null");
            this.valueConverter = converter;
            this.encoded = z10;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, T t10) throws IOException {
            String convert;
            if (t10 != null && (convert = this.valueConverter.convert(t10)) != null) {
                requestBuilder.addQueryParam(this.name, convert, this.encoded);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class QueryMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encoded;
        private final Converter<T, String> valueConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public QueryMap(Converter<T, String> converter, boolean z10) {
            this.valueConverter = converter;
            this.encoded = z10;
        }

        @Override // retrofit2.ParameterHandler
        /* bridge */ /* synthetic */ void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
            apply(requestBuilder, (Map) ((Map) obj));
        }

        void apply(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            String convert = this.valueConverter.convert(value);
                            if (convert != null) {
                                requestBuilder.addQueryParam(key, convert, this.encoded);
                            } else {
                                throw new IllegalArgumentException("Query map value '" + value + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + key + "'.");
                            }
                        } else {
                            throw new IllegalArgumentException("Query map contained null value for key '" + key + "'.");
                        }
                    } else {
                        throw new IllegalArgumentException("Query map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Query map was null.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class QueryName<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final Converter<T, String> nameConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public QueryName(Converter<T, String> converter, boolean z10) {
            this.nameConverter = converter;
            this.encoded = z10;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, T t10) throws IOException {
            if (t10 != null) {
                requestBuilder.addQueryParam(this.nameConverter.convert(t10), null, this.encoded);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class RawPart extends ParameterHandler<x.c> {
        static final RawPart INSTANCE = new RawPart();

        private RawPart() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void apply(RequestBuilder requestBuilder, x.c cVar) throws IOException {
            if (cVar != null) {
                requestBuilder.addPart(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class RelativeUrl extends ParameterHandler<Object> {
        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, Object obj) {
            Utils.checkNotNull(obj, "@Url parameter is null.");
            requestBuilder.setRelativeUrl(obj);
        }
    }

    ParameterHandler() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void apply(RequestBuilder requestBuilder, T t10) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ParameterHandler<Object> array() {
        return new ParameterHandler<Object>() { // from class: retrofit2.ParameterHandler.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // retrofit2.ParameterHandler
            void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
                if (obj != null) {
                    int length = Array.getLength(obj);
                    for (int i10 = 0; i10 < length; i10++) {
                        ParameterHandler.this.apply(requestBuilder, Array.get(obj, i10));
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ParameterHandler<Iterable<T>> iterable() {
        return new ParameterHandler<Iterable<T>>() { // from class: retrofit2.ParameterHandler.1
            @Override // retrofit2.ParameterHandler
            /* bridge */ /* synthetic */ void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
                apply(requestBuilder, (Iterable) ((Iterable) obj));
            }

            void apply(RequestBuilder requestBuilder, Iterable<T> iterable) throws IOException {
                if (iterable != null) {
                    for (T t10 : iterable) {
                        ParameterHandler.this.apply(requestBuilder, t10);
                    }
                }
            }
        };
    }
}
