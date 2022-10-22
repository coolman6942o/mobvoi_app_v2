package com.mobvoi.companion.health.share;

import android.app.Application;
import androidx.lifecycle.f0;
import androidx.lifecycle.h0;
import kotlin.jvm.internal.i;
/* compiled from: HealthShareChartViewModel.kt */
/* loaded from: classes2.dex */
public final class n implements h0.b {

    /* renamed from: a  reason: collision with root package name */
    private final Application f16990a;

    /* renamed from: b  reason: collision with root package name */
    private final String f16991b;

    /* renamed from: c  reason: collision with root package name */
    private final String f16992c;

    public n(Application application, String sportId, String sportTypeName) {
        i.f(application, "application");
        i.f(sportId, "sportId");
        i.f(sportTypeName, "sportTypeName");
        this.f16990a = application;
        this.f16991b = sportId;
        this.f16992c = sportTypeName;
    }

    @Override // androidx.lifecycle.h0.b
    public <T extends f0> T a(Class<T> modelClass) {
        i.f(modelClass, "modelClass");
        T newInstance = modelClass.getDeclaredConstructor(Application.class, String.class, String.class).newInstance(this.f16990a, this.f16991b, this.f16992c);
        i.e(newInstance, "modelClass.getDeclaredConstructor(\n            Application::class.java,\n            String::class.java,\n            String::class.java\n        ).newInstance(application, sportId, sportTypeName)");
        return newInstance;
    }
}
