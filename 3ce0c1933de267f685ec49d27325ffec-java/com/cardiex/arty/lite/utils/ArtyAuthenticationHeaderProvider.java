package com.cardiex.arty.lite.utils;

import android.content.Context;
import android.util.Log;
import com.cardiex.arty.lite.utils.TokenRefreshUtil;
import com.google.gson.e;
import io.d;
import java.util.Date;
import java.util.Random;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.l;
import kotlinx.coroutines.h;
import kotlinx.coroutines.t0;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.w;
import okhttp3.y;
import okhttp3.z;
import software.tingle.api.authentication.a;
/* compiled from: ArtyAuthenticationHeaderProvider.kt */
/* loaded from: classes.dex */
public final class ArtyAuthenticationHeaderProvider extends a {
    private static final int BACKOFF_MILLI_SECONDS = 2000;
    private static final int MAX_ATTEMPTS = 3;
    private final String accessToken;
    private final d backChannel$delegate;
    private final String baseUrl;
    private final Context context;
    private final boolean enableLogging;
    public static final Companion Companion = new Companion(null);
    private static final w MEDIA_TYPE_JSON = w.f32297g.a("application/json");
    private static final String TAG = l.b(ArtyAuthenticationHeaderProvider.class).a();
    private static final Random sRandom = new Random();

    /* compiled from: ArtyAuthenticationHeaderProvider.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtyAuthenticationHeaderProvider(Context context, String baseUrl, String accessToken, boolean z10) {
        super(null, 1, null);
        d a10;
        i.f(context, "context");
        i.f(baseUrl, "baseUrl");
        i.f(accessToken, "accessToken");
        this.context = context;
        this.baseUrl = baseUrl;
        this.accessToken = accessToken;
        this.enableLogging = z10;
        a10 = io.f.a(new ArtyAuthenticationHeaderProvider$backChannel$2(this));
        this.backChannel$delegate = a10;
    }

    private final y getBackChannel() {
        return (y) this.backChannel$delegate.getValue();
    }

    private final String getJwt() {
        long nextInt = sRandom.nextInt(1000) + 2000;
        int i10 = 1;
        while (true) {
            int i11 = i10 + 1;
            String str = TAG;
            Log.d(str, "Attempt #" + i10 + " to acquire Auth Token");
            Log.i(str, i.n("Making token acquisition request, number of attempts = ", Integer.valueOf(i10)));
            MobVoiTokenResponse mobVoiTokenResponse = (MobVoiTokenResponse) h.c(t0.b(), new ArtyAuthenticationHeaderProvider$jwt$response$1(this, null));
            if (mobVoiTokenResponse != null) {
                TokenRefreshUtil.Companion companion = TokenRefreshUtil.Companion;
                Context context = this.context;
                String jwt = mobVoiTokenResponse.getJwt();
                i.d(jwt);
                companion.parseAndCacheToken(context, jwt);
                Log.d(str, "Valid token was acquired, expiry time: " + new Date(companion.getAccessTokenExpiry(this.context)) + ' ');
                String jwt2 = mobVoiTokenResponse.getJwt();
                i.d(jwt2);
                return jwt2;
            }
            Log.d(str, "Failed to acquire auth code on attempt #" + i10 + ' ');
            if (i10 == 3) {
                return "";
            }
            try {
                Log.v(str, "Sleeping for " + nextInt + " ms before retry");
                Thread.sleep(nextInt);
            } catch (InterruptedException unused) {
                Log.d(TAG, "Thread interrupted: abort remaining retries!");
                Thread.currentThread().interrupt();
            }
            nextInt *= 2;
            if (i11 > 3) {
                return "";
            }
            i10 = i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MobVoiTokenResponse getRequestMobVoiToken() {
        e eVar = new e();
        MobVoiTokenRequest mobVoiTokenRequest = new MobVoiTokenRequest(this.accessToken);
        z.a p10 = new z.a().p(i.n(this.baseUrl, "/token/mobvoi"));
        a0.a aVar = a0.Companion;
        String s10 = eVar.s(mobVoiTokenRequest);
        i.e(s10, "gson.toJson(tokenRequest)");
        try {
            b0 execute = getBackChannel().a(p10.l(aVar.b(s10, MEDIA_TYPE_JSON)).b()).execute();
            c0 c10 = execute.c();
            if (!execute.E() || c10 == null) {
                return null;
            }
            MobVoiTokenResponse mobVoiTokenResponse = (MobVoiTokenResponse) eVar.h(c10.charStream(), MobVoiTokenResponse.class);
            c10.close();
            return mobVoiTokenResponse;
        } catch (Exception e10) {
            System.out.print(e10);
            return null;
        }
    }

    @Override // software.tingle.api.authentication.a
    protected String getParameter(z.a request) {
        i.f(request, "request");
        return getJwt();
    }
}
