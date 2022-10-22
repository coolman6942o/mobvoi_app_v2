package com.huawei.hms.mlsdk.common;

import java.util.Arrays;
import java.util.Objects;
/* loaded from: classes2.dex */
public final class AppSettingHolder<T> {
    private final String persistenceKey;
    private final T setting;

    private AppSettingHolder(String str, T t10) {
        Objects.requireNonNull(str, "Null PersistentKey");
        Objects.requireNonNull(t10, "Null setting");
        this.persistenceKey = str;
        this.setting = t10;
    }

    public static <T> AppSettingHolder<T> create(String str, T t10) {
        return new AppSettingHolder<>(str, t10);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AppSettingHolder)) {
            return false;
        }
        AppSettingHolder appSettingHolder = (AppSettingHolder) obj;
        return this.persistenceKey.equals(appSettingHolder.persistenceKey) && this.setting.equals(appSettingHolder.setting);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.persistenceKey, this.setting});
    }

    public final String toString() {
        String str = this.persistenceKey;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 97 + String.valueOf(this.setting).length());
        sb2.append("MlModelDriverInstanceKey{persistentKey=");
        sb2.append(str);
        sb2.append(", setting=");
        sb2.append(this.setting);
        sb2.append("}");
        return sb2.toString();
    }
}
