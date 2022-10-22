package com.unionpay;

import java.util.Comparator;
import org.json.JSONObject;
/* loaded from: classes2.dex */
final class e implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    String f23300a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(String str) {
        this.f23300a = "";
        this.f23300a = str;
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        int i10 = (((JSONObject) obj).optLong(this.f23300a) > ((JSONObject) obj2).optLong(this.f23300a) ? 1 : (((JSONObject) obj).optLong(this.f23300a) == ((JSONObject) obj2).optLong(this.f23300a) ? 0 : -1));
        if (i10 < 0) {
            return -1;
        }
        return i10 > 0 ? 1 : 0;
    }
}
