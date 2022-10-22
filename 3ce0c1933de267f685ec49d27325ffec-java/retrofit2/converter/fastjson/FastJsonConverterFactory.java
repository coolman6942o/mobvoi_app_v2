package retrofit2.converter.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.a0;
import okhttp3.c0;
import retrofit2.Converter;
import retrofit2.Retrofit;
/* loaded from: classes3.dex */
public class FastJsonConverterFactory extends Converter.Factory {
    private Feature[] features;
    private SerializeConfig serializeConfig;
    private SerializerFeature[] serializerFeatures;
    private ParserConfig mParserConfig = ParserConfig.getGlobalInstance();
    private int featureValues = JSON.DEFAULT_PARSER_FEATURE;

    private FastJsonConverterFactory() {
    }

    public static FastJsonConverterFactory create() {
        return new FastJsonConverterFactory();
    }

    public ParserConfig getParserConfig() {
        return this.mParserConfig;
    }

    public int getParserFeatureValues() {
        return this.featureValues;
    }

    public Feature[] getParserFeatures() {
        return this.features;
    }

    public SerializeConfig getSerializeConfig() {
        return this.serializeConfig;
    }

    public SerializerFeature[] getSerializerFeatures() {
        return this.serializerFeatures;
    }

    @Override // retrofit2.Converter.Factory
    public Converter<?, a0> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        return new FastJsonRequestBodyConverter(this.serializeConfig, this.serializerFeatures);
    }

    @Override // retrofit2.Converter.Factory
    public Converter<c0, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new FastJsonResponseBodyConverter(type, this.mParserConfig, this.featureValues, this.features);
    }

    public FastJsonConverterFactory setParserConfig(ParserConfig parserConfig) {
        this.mParserConfig = parserConfig;
        return this;
    }

    public FastJsonConverterFactory setParserFeatureValues(int i10) {
        this.featureValues = i10;
        return this;
    }

    public FastJsonConverterFactory setParserFeatures(Feature[] featureArr) {
        this.features = featureArr;
        return this;
    }

    public FastJsonConverterFactory setSerializeConfig(SerializeConfig serializeConfig) {
        this.serializeConfig = serializeConfig;
        return this;
    }

    public FastJsonConverterFactory setSerializerFeatures(SerializerFeature[] serializerFeatureArr) {
        this.serializerFeatures = serializerFeatureArr;
        return this;
    }
}
