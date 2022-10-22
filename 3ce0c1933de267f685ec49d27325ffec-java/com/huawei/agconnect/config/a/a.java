package com.huawei.agconnect.config.a;

import android.content.Context;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.config.LazyInputStream;
import java.io.InputStream;
import java.util.Objects;
/* loaded from: classes.dex */
public class a extends AGConnectServicesConfig {

    /* renamed from: a  reason: collision with root package name */
    private final Context f13487a;

    /* renamed from: b  reason: collision with root package name */
    private final String f13488b;

    /* renamed from: c  reason: collision with root package name */
    private LazyInputStream f13489c;

    /* renamed from: d  reason: collision with root package name */
    private volatile b f13490d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f13491e = new Object();

    public a(Context context, String str) {
        this.f13487a = context;
        this.f13488b = str;
    }

    private static LazyInputStream a(Context context, final InputStream inputStream) {
        return new LazyInputStream(context) { // from class: com.huawei.agconnect.config.a.a.1
            @Override // com.huawei.agconnect.config.LazyInputStream
            public InputStream get(Context context2) {
                return inputStream;
            }
        };
    }

    private static String a(String str) {
        int i10 = 0;
        if (str.length() > 0) {
            while (str.charAt(i10) == '/') {
                i10++;
            }
        }
        return '/' + str.substring(i10);
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public boolean getBoolean(String str, boolean z10) {
        return Boolean.parseBoolean(getString(str, String.valueOf(z10)));
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public int getInt(String str) {
        return getInt(str, 0);
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public int getInt(String str, int i10) {
        try {
            return Integer.parseInt(getString(str, String.valueOf(i10)));
        } catch (NumberFormatException unused) {
            return i10;
        }
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public String getString(String str) {
        return getString(str, null);
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public String getString(String str, String str2) {
        Objects.requireNonNull(str, "path must not be null.");
        if (this.f13490d == null) {
            synchronized (this.f13491e) {
                if (this.f13490d == null) {
                    LazyInputStream lazyInputStream = this.f13489c;
                    if (lazyInputStream != null) {
                        this.f13490d = new d(lazyInputStream.loadInputStream());
                        this.f13489c.close();
                        this.f13489c = null;
                    } else {
                        this.f13490d = new g(this.f13487a, this.f13488b);
                    }
                }
            }
        }
        return this.f13490d.a(a(str), str2);
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void overlayWith(LazyInputStream lazyInputStream) {
        this.f13489c = lazyInputStream;
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void overlayWith(InputStream inputStream) {
        overlayWith(a(this.f13487a, inputStream));
    }
}
