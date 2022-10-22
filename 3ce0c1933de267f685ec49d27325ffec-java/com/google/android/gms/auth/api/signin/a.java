package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    static final Comparator f8415a = new a();

    private a() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int compareTo;
        compareTo = ((Scope) obj).G0().compareTo(((Scope) obj2).G0());
        return compareTo;
    }
}
