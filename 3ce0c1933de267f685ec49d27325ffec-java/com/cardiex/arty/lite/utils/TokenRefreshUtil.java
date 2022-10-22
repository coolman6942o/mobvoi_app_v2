package com.cardiex.arty.lite.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import androidx.preference.b;
import com.cardiex.arty.lite.utils.LogUtils;
import com.google.gson.e;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.t;
import kotlin.text.u;
/* compiled from: TokenRefreshUtil.kt */
/* loaded from: classes.dex */
public final class TokenRefreshUtil {
    private static final String KEY_ARTY_ACCESS_TOKEN = "arty_access_token";
    private static final String KEY_ARTY_ACCESS_TOKEN_EXPIRY = "arty_access_token_expiry";
    public static final Companion Companion = new Companion(null);
    private static final String TAG = LogUtils.Companion.makeLogTag(TokenRefreshUtil.class);
    private static final e gson = new e();

    /* compiled from: TokenRefreshUtil.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private final SharedPreferences.Editor createPreferencesEditor(Context context) {
            SharedPreferences.Editor edit = getSharedPreferences(context).edit();
            i.e(edit, "getSharedPreferences(context).edit()");
            return edit;
        }

        private final SharedPreferences getSharedPreferences(Context context) {
            SharedPreferences a10 = b.a(context);
            i.e(a10, "getDefaultSharedPreferences(context)");
            return a10;
        }

        private final AuthResponse parseToken(String str) {
            List o02;
            String m10;
            o02 = u.o0(str, new String[]{"."}, false, 0, 6, null);
            byte[] decode = Base64.decode((String) o02.get(1), 0);
            i.e(decode, "decode(tokenSplit, Base64.DEFAULT)");
            m10 = t.m(decode);
            try {
                return (AuthResponse) TokenRefreshUtil.gson.j(m10, AuthResponse.class);
            } catch (Exception e10) {
                System.out.print(e10);
                return null;
            }
        }

        private final boolean setAccessToken(Context context, String str) {
            LogUtils.Companion companion = LogUtils.Companion;
            companion.LOGI(TokenRefreshUtil.TAG, i.n("Access token of length ", Integer.valueOf(TextUtils.isEmpty(str) ? 0 : str.length())));
            companion.LOGV(TokenRefreshUtil.TAG, i.n("Access Token: ", str));
            return getSharedPreferences(context).edit().putString(TokenRefreshUtil.KEY_ARTY_ACCESS_TOKEN, str).commit();
        }

        private final boolean setAccessTokenExpiryTime(Context context, long j10) {
            long currentTimeMillis = (System.currentTimeMillis() + (j10 * 1000)) - 10000;
            LogUtils.Companion.LOGI(TokenRefreshUtil.TAG, i.n("Access Token Expiry: ", Long.valueOf(currentTimeMillis)));
            return createPreferencesEditor(context).putLong(TokenRefreshUtil.KEY_ARTY_ACCESS_TOKEN_EXPIRY, currentTimeMillis).commit();
        }

        public final String getAccessToken(Context context) {
            i.f(context, "context");
            return getSharedPreferences(context).getString(TokenRefreshUtil.KEY_ARTY_ACCESS_TOKEN, null);
        }

        public final long getAccessTokenExpiry(Context context) {
            i.f(context, "context");
            return getSharedPreferences(context).getLong(TokenRefreshUtil.KEY_ARTY_ACCESS_TOKEN_EXPIRY, 0L);
        }

        public final boolean hasAccessTokenExpired(Context context) {
            i.f(context, "context");
            long currentTimeMillis = System.currentTimeMillis();
            long accessTokenExpiry = getAccessTokenExpiry(context);
            LogUtils.Companion companion = LogUtils.Companion;
            String str = TokenRefreshUtil.TAG;
            companion.LOGD(str, "Expiry compared between now=" + currentTimeMillis + " expires=" + accessTokenExpiry);
            return currentTimeMillis >= accessTokenExpiry;
        }

        public final void parseAndCacheToken(Context context, String token) {
            i.f(context, "context");
            i.f(token, "token");
            AuthResponse parseToken = parseToken(token);
            if (parseToken != null) {
                setAccessToken(context, token);
                setAccessTokenExpiryTime(context, parseToken.getExpiresOn());
            }
        }
    }
}
