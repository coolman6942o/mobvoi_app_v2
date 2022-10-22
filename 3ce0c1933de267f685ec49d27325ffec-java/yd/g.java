package yd;

import android.content.Context;
import android.content.Intent;
import com.mobvoi.companion.BrowserActivity;
import com.mobvoi.companion.R;
import com.mobvoi.companion.TicAppConstants;
import com.mobvoi.companion.browser.BasicBrowserActivity;
/* compiled from: IntentUtil.java */
/* loaded from: classes2.dex */
public class g {
    public static Intent a(Context context) {
        Intent intent = new Intent(context, BrowserActivity.class);
        if (b.c(context)) {
            intent.putExtra("url", context.getString(R.string.oversea_store_url));
        } else {
            intent.putExtra("url", TicAppConstants.STORE_URL);
        }
        intent.putExtra(BasicBrowserActivity.KEY_TITLE, context.getString(R.string.title_appstore));
        return intent;
    }
}
