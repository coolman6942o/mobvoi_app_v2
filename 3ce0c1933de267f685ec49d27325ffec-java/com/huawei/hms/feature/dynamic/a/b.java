package com.huawei.hms.feature.dynamic.a;

import android.util.Log;
import dalvik.system.DexClassLoader;
/* loaded from: classes.dex */
public final class b extends DexClassLoader {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13786a = b.class.getSimpleName();

    public b(String str, String str2, ClassLoader classLoader) {
        super(str, str2, null, classLoader);
    }

    @Override // java.lang.ClassLoader
    protected final Class<?> loadClass(String str, boolean z10) throws ClassNotFoundException {
        if (!str.startsWith("java.") && !str.startsWith("android.")) {
            try {
                return findClass(str);
            } catch (ClassNotFoundException unused) {
                Log.w(f13786a, "Cannot find The class:".concat(str));
            }
        }
        return super.loadClass(str, z10);
    }
}
