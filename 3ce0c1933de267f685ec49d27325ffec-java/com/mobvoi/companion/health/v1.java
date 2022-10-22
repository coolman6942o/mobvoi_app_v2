package com.mobvoi.companion.health;

import android.content.Context;
import g0.d;
import g0.f;
import java.util.Locale;
import kotlin.jvm.internal.i;
/* compiled from: LanguageModule.kt */
/* loaded from: classes2.dex */
public final class v1 {
    public final String a(Context context) {
        i.f(context, "context");
        f a10 = d.a(context.getResources().getConfiguration());
        i.e(a10, "getLocales(context.resources.configuration)");
        Locale c10 = a10.c(0);
        String language = c10.getLanguage();
        i.e(language, "currLocal.language");
        String lowerCase = language.toLowerCase();
        i.e(lowerCase, "(this as java.lang.String).toLowerCase()");
        if (i.b(lowerCase, "zh")) {
            String country = c10.getCountry();
            i.e(country, "currLocal.country");
            String upperCase = country.toUpperCase();
            i.e(upperCase, "(this as java.lang.String).toUpperCase()");
            if (!i.b(upperCase, "CN")) {
                return "zh-TW";
            }
        }
        String language2 = c10.getLanguage();
        i.e(language2, "{\n            currLocal.language\n        }");
        return language2;
    }
}
