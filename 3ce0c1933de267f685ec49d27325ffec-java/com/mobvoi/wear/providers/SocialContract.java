package com.mobvoi.wear.providers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class SocialContract {
    public static final String AUTHORITY = "com.mobvoi.ticwear.provider.social";
    public static final Uri CONTENT_URI = Uri.parse("content://com.mobvoi.ticwear.provider.social");

    /* loaded from: classes2.dex */
    public static final class RankingUser implements RankingUserColumns {
        public static final Uri CONTENT_SINGLE_URI;
        public static final Uri CONTENT_URI;
        private static final String USER_WHERE = "wwid=?";

        static {
            Uri uri = SocialContract.CONTENT_URI;
            CONTENT_URI = Uri.withAppendedPath(uri, "ranking_user");
            CONTENT_SINGLE_URI = Uri.withAppendedPath(uri, "ranking_user/single");
        }

        private RankingUser() {
        }

        public static Cursor query(ContentResolver contentResolver, String str, String[] strArr) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return contentResolver.query(CONTENT_URI, strArr, USER_WHERE, new String[]{str}, null);
        }

        public static Cursor querySingle(ContentResolver contentResolver, String[] strArr) {
            return contentResolver.query(CONTENT_SINGLE_URI, strArr, null, null, null);
        }
    }

    /* loaded from: classes2.dex */
    protected interface RankingUserColumns extends BaseColumns {
        public static final String IMG_URL = "img_url";
        public static final String NICKNAME = "nickname";
        public static final String RANK = "rank";
        public static final String STEPS = "steps";
        public static final String WW_ID = "wwid";
    }

    private SocialContract() {
    }
}
