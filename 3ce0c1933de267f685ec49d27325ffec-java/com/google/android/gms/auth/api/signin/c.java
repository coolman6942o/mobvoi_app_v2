package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;
/* loaded from: classes.dex */
final class c implements Comparator<Scope> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Scope scope, Scope scope2) {
        return scope.G0().compareTo(scope2.G0());
    }
}
