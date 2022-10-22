package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import okhttp3.a0;
import okhttp3.c0;
import okhttp3.e;
import okhttp3.u;
import okhttp3.y;
import retrofit2.BuiltInConverters;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.ServiceMethod;
/* loaded from: classes3.dex */
public final class Retrofit {
    final List<CallAdapter.Factory> adapterFactories;
    final u baseUrl;
    final e.a callFactory;
    final Executor callbackExecutor;
    final List<Converter.Factory> converterFactories;
    private final Map<Method, ServiceMethod<?, ?>> serviceMethodCache = new ConcurrentHashMap();
    final boolean validateEagerly;

    Retrofit(e.a aVar, u uVar, List<Converter.Factory> list, List<CallAdapter.Factory> list2, Executor executor, boolean z10) {
        this.callFactory = aVar;
        this.baseUrl = uVar;
        this.converterFactories = Collections.unmodifiableList(list);
        this.adapterFactories = Collections.unmodifiableList(list2);
        this.callbackExecutor = executor;
        this.validateEagerly = z10;
    }

    private void eagerlyValidateMethods(Class<?> cls) {
        Method[] declaredMethods;
        Platform platform = Platform.get();
        for (Method method : cls.getDeclaredMethods()) {
            if (!platform.isDefaultMethod(method)) {
                loadServiceMethod(method);
            }
        }
    }

    public u baseUrl() {
        return this.baseUrl;
    }

    public CallAdapter<?, ?> callAdapter(Type type, Annotation[] annotationArr) {
        return nextCallAdapter(null, type, annotationArr);
    }

    public List<CallAdapter.Factory> callAdapterFactories() {
        return this.adapterFactories;
    }

    public e.a callFactory() {
        return this.callFactory;
    }

    public Executor callbackExecutor() {
        return this.callbackExecutor;
    }

    public List<Converter.Factory> converterFactories() {
        return this.converterFactories;
    }

    public <T> T create(final Class<T> cls) {
        Utils.validateServiceInterface(cls);
        if (this.validateEagerly) {
            eagerlyValidateMethods(cls);
        }
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: retrofit2.Retrofit.1
            private final Platform platform = Platform.get();

            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                if (method.getDeclaringClass() == Object.class) {
                    return method.invoke(this, objArr);
                }
                if (this.platform.isDefaultMethod(method)) {
                    return this.platform.invokeDefaultMethod(method, cls, obj, objArr);
                }
                ServiceMethod<?, ?> loadServiceMethod = Retrofit.this.loadServiceMethod(method);
                return loadServiceMethod.callAdapter.adapt(new OkHttpCall(loadServiceMethod, objArr));
            }
        });
    }

    ServiceMethod<?, ?> loadServiceMethod(Method method) {
        ServiceMethod serviceMethod;
        ServiceMethod<?, ?> serviceMethod2 = this.serviceMethodCache.get(method);
        if (serviceMethod2 != null) {
            return serviceMethod2;
        }
        synchronized (this.serviceMethodCache) {
            serviceMethod = this.serviceMethodCache.get(method);
            if (serviceMethod == null) {
                serviceMethod = new ServiceMethod.Builder(this, method).build();
                this.serviceMethodCache.put(method, serviceMethod);
            }
        }
        return serviceMethod;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public CallAdapter<?, ?> nextCallAdapter(CallAdapter.Factory factory, Type type, Annotation[] annotationArr) {
        Utils.checkNotNull(type, "returnType == null");
        Utils.checkNotNull(annotationArr, "annotations == null");
        int indexOf = this.adapterFactories.indexOf(factory) + 1;
        int size = this.adapterFactories.size();
        for (int i10 = indexOf; i10 < size; i10++) {
            CallAdapter<?, ?> callAdapter = this.adapterFactories.get(i10).get(type, annotationArr, this);
            if (callAdapter != null) {
                return callAdapter;
            }
        }
        StringBuilder sb2 = new StringBuilder("Could not locate call adapter for ");
        sb2.append(type);
        sb2.append(".\n");
        if (factory != null) {
            sb2.append("  Skipped:");
            for (int i11 = 0; i11 < indexOf; i11++) {
                sb2.append("\n   * ");
                sb2.append(this.adapterFactories.get(i11).getClass().getName());
            }
            sb2.append('\n');
        }
        sb2.append("  Tried:");
        int size2 = this.adapterFactories.size();
        while (indexOf < size2) {
            sb2.append("\n   * ");
            sb2.append(this.adapterFactories.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb2.toString());
    }

    public <T> Converter<T, a0> nextRequestBodyConverter(Converter.Factory factory, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        Utils.checkNotNull(type, "type == null");
        Utils.checkNotNull(annotationArr, "parameterAnnotations == null");
        Utils.checkNotNull(annotationArr2, "methodAnnotations == null");
        int indexOf = this.converterFactories.indexOf(factory) + 1;
        int size = this.converterFactories.size();
        for (int i10 = indexOf; i10 < size; i10++) {
            Converter<T, a0> converter = (Converter<T, a0>) this.converterFactories.get(i10).requestBodyConverter(type, annotationArr, annotationArr2, this);
            if (converter != null) {
                return converter;
            }
        }
        StringBuilder sb2 = new StringBuilder("Could not locate RequestBody converter for ");
        sb2.append(type);
        sb2.append(".\n");
        if (factory != null) {
            sb2.append("  Skipped:");
            for (int i11 = 0; i11 < indexOf; i11++) {
                sb2.append("\n   * ");
                sb2.append(this.converterFactories.get(i11).getClass().getName());
            }
            sb2.append('\n');
        }
        sb2.append("  Tried:");
        int size2 = this.converterFactories.size();
        while (indexOf < size2) {
            sb2.append("\n   * ");
            sb2.append(this.converterFactories.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb2.toString());
    }

    public <T> Converter<c0, T> nextResponseBodyConverter(Converter.Factory factory, Type type, Annotation[] annotationArr) {
        Utils.checkNotNull(type, "type == null");
        Utils.checkNotNull(annotationArr, "annotations == null");
        int indexOf = this.converterFactories.indexOf(factory) + 1;
        int size = this.converterFactories.size();
        for (int i10 = indexOf; i10 < size; i10++) {
            Converter<c0, T> converter = (Converter<c0, T>) this.converterFactories.get(i10).responseBodyConverter(type, annotationArr, this);
            if (converter != null) {
                return converter;
            }
        }
        StringBuilder sb2 = new StringBuilder("Could not locate ResponseBody converter for ");
        sb2.append(type);
        sb2.append(".\n");
        if (factory != null) {
            sb2.append("  Skipped:");
            for (int i11 = 0; i11 < indexOf; i11++) {
                sb2.append("\n   * ");
                sb2.append(this.converterFactories.get(i11).getClass().getName());
            }
            sb2.append('\n');
        }
        sb2.append("  Tried:");
        int size2 = this.converterFactories.size();
        while (indexOf < size2) {
            sb2.append("\n   * ");
            sb2.append(this.converterFactories.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb2.toString());
    }

    public <T> Converter<T, a0> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return nextRequestBodyConverter(null, type, annotationArr, annotationArr2);
    }

    public <T> Converter<c0, T> responseBodyConverter(Type type, Annotation[] annotationArr) {
        return nextResponseBodyConverter(null, type, annotationArr);
    }

    public <T> Converter<T, String> stringConverter(Type type, Annotation[] annotationArr) {
        Utils.checkNotNull(type, "type == null");
        Utils.checkNotNull(annotationArr, "annotations == null");
        int size = this.converterFactories.size();
        for (int i10 = 0; i10 < size; i10++) {
            Converter<T, String> converter = (Converter<T, String>) this.converterFactories.get(i10).stringConverter(type, annotationArr, this);
            if (converter != null) {
                return converter;
            }
        }
        return BuiltInConverters.ToStringConverter.INSTANCE;
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        private final List<CallAdapter.Factory> adapterFactories;
        private u baseUrl;
        private e.a callFactory;
        private Executor callbackExecutor;
        private final List<Converter.Factory> converterFactories;
        private final Platform platform;
        private boolean validateEagerly;

        Builder(Platform platform) {
            ArrayList arrayList = new ArrayList();
            this.converterFactories = arrayList;
            this.adapterFactories = new ArrayList();
            this.platform = platform;
            arrayList.add(new BuiltInConverters());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder addCallAdapterFactory(CallAdapter.Factory factory) {
            this.adapterFactories.add(Utils.checkNotNull(factory, "factory == null"));
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder addConverterFactory(Converter.Factory factory) {
            this.converterFactories.add(Utils.checkNotNull(factory, "factory == null"));
            return this;
        }

        public Builder baseUrl(String str) {
            Utils.checkNotNull(str, "baseUrl == null");
            u l10 = u.l(str);
            if (l10 != null) {
                return baseUrl(l10);
            }
            throw new IllegalArgumentException("Illegal URL: " + str);
        }

        public Retrofit build() {
            if (this.baseUrl != null) {
                e.a aVar = this.callFactory;
                if (aVar == null) {
                    aVar = new y();
                }
                e.a aVar2 = aVar;
                Executor executor = this.callbackExecutor;
                if (executor == null) {
                    executor = this.platform.defaultCallbackExecutor();
                }
                Executor executor2 = executor;
                ArrayList arrayList = new ArrayList(this.adapterFactories);
                arrayList.add(this.platform.defaultCallAdapterFactory(executor2));
                return new Retrofit(aVar2, this.baseUrl, new ArrayList(this.converterFactories), arrayList, executor2, this.validateEagerly);
            }
            throw new IllegalStateException("Base URL required.");
        }

        public Builder callFactory(e.a aVar) {
            this.callFactory = (e.a) Utils.checkNotNull(aVar, "factory == null");
            return this;
        }

        public Builder callbackExecutor(Executor executor) {
            this.callbackExecutor = (Executor) Utils.checkNotNull(executor, "executor == null");
            return this;
        }

        public Builder client(y yVar) {
            return callFactory((e.a) Utils.checkNotNull(yVar, "client == null"));
        }

        public Builder validateEagerly(boolean z10) {
            this.validateEagerly = z10;
            return this;
        }

        public Builder baseUrl(u uVar) {
            Utils.checkNotNull(uVar, "baseUrl == null");
            List<String> m10 = uVar.m();
            if ("".equals(m10.get(m10.size() - 1))) {
                this.baseUrl = uVar;
                return this;
            }
            throw new IllegalArgumentException("baseUrl must end in /: " + uVar);
        }

        public Builder() {
            this(Platform.get());
        }

        Builder(Retrofit retrofit) {
            ArrayList arrayList = new ArrayList();
            this.converterFactories = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.adapterFactories = arrayList2;
            this.platform = Platform.get();
            this.callFactory = retrofit.callFactory;
            this.baseUrl = retrofit.baseUrl;
            arrayList.addAll(retrofit.converterFactories);
            arrayList2.addAll(retrofit.adapterFactories);
            arrayList2.remove(arrayList2.size() - 1);
            this.callbackExecutor = retrofit.callbackExecutor;
            this.validateEagerly = retrofit.validateEagerly;
        }
    }
}
