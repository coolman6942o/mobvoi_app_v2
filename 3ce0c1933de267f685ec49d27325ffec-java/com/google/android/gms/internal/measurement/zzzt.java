package com.google.android.gms.internal.measurement;

import java.io.IOException;
/* loaded from: classes.dex */
public final class zzzt extends IOException {
    private a zzbst = null;

    public zzzt(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzzt a() {
        return new zzzt("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzzt b() {
        return new zzzt("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }
}
