package com.paypal.android.sdk;

import com.huawei.agconnect.exception.AGCServerException;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class y3 extends f1 {

    /* renamed from: e  reason: collision with root package name */
    private final boolean f22067e;

    /* renamed from: f  reason: collision with root package name */
    private final int f22068f;

    public y3(s1 s1Var, int i10, boolean z10, int i11) {
        super(i10, s1Var);
        this.f22067e = z10;
        this.f22068f = i11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.paypal.android.sdk.f1
    public final String f() {
        int i10 = this.f22068f;
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 != 0) {
                sb2.append(",\n");
            }
            String str = new String(new char[4]);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(i11);
            sb2.append(String.format(Locale.US, "    {\n        \"type\":\"sms_otp\",\n        \"token_identifier\":\"mock_token_id_%s\",\n        \"token_identifier_display\":\"xxx-xxx-%s\"\n    }\n", Integer.valueOf(i11), str.replace("\u0000", sb3.toString()).substring(0, 4)));
        }
        return String.format(Locale.US, "{\n    \"nonce\":\"mock-login-nonce\",\n    \"error\":\"2fa_required\",\n    \"error_description\":\"Unable to authenticate the user. 2fa flow completion is necessary for successful login.\",\n    \"visitor_id\":\"mock-visitor_id\",\n    \"2fa_enabled\":\"true\",\n    \"2fa_token_identifier\":[\n%s    ]\n}", sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.paypal.android.sdk.f1
    public final int g() {
        return AGCServerException.TOKEN_INVALID;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.paypal.android.sdk.f1
    public final boolean h(r1 r1Var) {
        return this.f22067e && (r1Var instanceof r3) && !((r3) r1Var).E();
    }
}
