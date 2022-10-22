package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.b;
import d.f;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;
import n0.c;
/* compiled from: SuggestionsAdapter.java */
/* loaded from: classes.dex */
class r0 extends c implements View.OnClickListener {

    /* renamed from: l  reason: collision with root package name */
    private final SearchView f1315l;

    /* renamed from: m  reason: collision with root package name */
    private final SearchableInfo f1316m;

    /* renamed from: n  reason: collision with root package name */
    private final Context f1317n;

    /* renamed from: o  reason: collision with root package name */
    private final WeakHashMap<String, Drawable.ConstantState> f1318o;

    /* renamed from: p  reason: collision with root package name */
    private final int f1319p;

    /* renamed from: s  reason: collision with root package name */
    private ColorStateList f1322s;

    /* renamed from: q  reason: collision with root package name */
    private boolean f1320q = false;

    /* renamed from: r  reason: collision with root package name */
    private int f1321r = 1;

    /* renamed from: t  reason: collision with root package name */
    private int f1323t = -1;

    /* renamed from: u  reason: collision with root package name */
    private int f1324u = -1;

    /* renamed from: v  reason: collision with root package name */
    private int f1325v = -1;

    /* renamed from: w  reason: collision with root package name */
    private int f1326w = -1;

    /* renamed from: x  reason: collision with root package name */
    private int f1327x = -1;

    /* renamed from: y  reason: collision with root package name */
    private int f1328y = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuggestionsAdapter.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f1329a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f1330b;

        /* renamed from: c  reason: collision with root package name */
        public final ImageView f1331c;

        /* renamed from: d  reason: collision with root package name */
        public final ImageView f1332d;

        /* renamed from: e  reason: collision with root package name */
        public final ImageView f1333e;

        public a(View view) {
            this.f1329a = (TextView) view.findViewById(16908308);
            this.f1330b = (TextView) view.findViewById(16908309);
            this.f1331c = (ImageView) view.findViewById(16908295);
            this.f1332d = (ImageView) view.findViewById(16908296);
            this.f1333e = (ImageView) view.findViewById(f.f24805q);
        }
    }

    public r0(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f1315l = searchView;
        this.f1316m = searchableInfo;
        this.f1319p = searchView.getSuggestionCommitIconResId();
        this.f1317n = context;
        this.f1318o = weakHashMap;
    }

    private void A(String str, Drawable drawable) {
        if (drawable != null) {
            this.f1318o.put(str, drawable.getConstantState());
        }
    }

    private void B(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    private Drawable k(String str) {
        Drawable.ConstantState constantState = this.f1318o.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private CharSequence l(CharSequence charSequence) {
        if (this.f1322s == null) {
            TypedValue typedValue = new TypedValue();
            this.f1317n.getTheme().resolveAttribute(d.a.O, typedValue, true);
            this.f1322s = this.f1317n.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f1322s, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private Drawable m(ComponentName componentName) {
        PackageManager packageManager = this.f1317n.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e10) {
            Log.w("SuggestionsAdapter", e10.toString());
            return null;
        }
    }

    private Drawable n(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        Drawable.ConstantState constantState = null;
        if (this.f1318o.containsKey(flattenToShortString)) {
            Drawable.ConstantState constantState2 = this.f1318o.get(flattenToShortString);
            if (constantState2 == null) {
                return null;
            }
            return constantState2.newDrawable(this.f1317n.getResources());
        }
        Drawable m10 = m(componentName);
        if (m10 != null) {
            constantState = m10.getConstantState();
        }
        this.f1318o.put(flattenToShortString, constantState);
        return m10;
    }

    public static String o(Cursor cursor, String str) {
        return w(cursor, cursor.getColumnIndex(str));
    }

    private Drawable p() {
        Drawable n10 = n(this.f1316m.getSearchActivity());
        return n10 != null ? n10 : this.f1317n.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable q(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return r(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            } else {
                InputStream openInputStream = this.f1317n.getContentResolver().openInputStream(uri);
                if (openInputStream != null) {
                    Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
                    try {
                        openInputStream.close();
                    } catch (IOException e10) {
                        Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e10);
                    }
                    return createFromStream;
                }
                throw new FileNotFoundException("Failed to open " + uri);
            }
        } catch (FileNotFoundException e11) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e11.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e11.getMessage());
        return null;
    }

    private Drawable s(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f1317n.getPackageName() + "/" + parseInt;
            Drawable k10 = k(str2);
            if (k10 != null) {
                return k10;
            }
            Drawable e10 = b.e(this.f1317n, parseInt);
            A(str2, e10);
            return e10;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable k11 = k(str);
            if (k11 != null) {
                return k11;
            }
            Drawable q5 = q(Uri.parse(str));
            A(str, q5);
            return q5;
        }
    }

    private Drawable t(Cursor cursor) {
        int i10 = this.f1326w;
        if (i10 == -1) {
            return null;
        }
        Drawable s10 = s(cursor.getString(i10));
        return s10 != null ? s10 : p();
    }

    private Drawable u(Cursor cursor) {
        int i10 = this.f1327x;
        if (i10 == -1) {
            return null;
        }
        return s(cursor.getString(i10));
    }

    private static String w(Cursor cursor, int i10) {
        if (i10 == -1) {
            return null;
        }
        try {
            return cursor.getString(i10);
        } catch (Exception e10) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e10);
            return null;
        }
    }

    private void y(ImageView imageView, Drawable drawable, int i10) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i10);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void z(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    @Override // n0.a, n0.b.a
    public void a(Cursor cursor) {
        if (this.f1320q) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.a(cursor);
            if (cursor != null) {
                this.f1323t = cursor.getColumnIndex("suggest_text_1");
                this.f1324u = cursor.getColumnIndex("suggest_text_2");
                this.f1325v = cursor.getColumnIndex("suggest_text_2_url");
                this.f1326w = cursor.getColumnIndex("suggest_icon_1");
                this.f1327x = cursor.getColumnIndex("suggest_icon_2");
                this.f1328y = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e10) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e10);
        }
    }

    @Override // n0.a, n0.b.a
    public CharSequence c(Cursor cursor) {
        String o10;
        String o11;
        if (cursor == null) {
            return null;
        }
        String o12 = o(cursor, "suggest_intent_query");
        if (o12 != null) {
            return o12;
        }
        if (this.f1316m.shouldRewriteQueryFromData() && (o11 = o(cursor, "suggest_intent_data")) != null) {
            return o11;
        }
        if (!this.f1316m.shouldRewriteQueryFromText() || (o10 = o(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return o10;
    }

    @Override // n0.b.a
    public Cursor d(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.f1315l.getVisibility() == 0 && this.f1315l.getWindowVisibility() == 0) {
            try {
                Cursor v10 = v(this.f1316m, charSequence2, 50);
                if (v10 != null) {
                    v10.getCount();
                    return v10;
                }
            } catch (RuntimeException e10) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e10);
            }
        }
        return null;
    }

    @Override // n0.a
    public void e(View view, Context context, Cursor cursor) {
        CharSequence charSequence;
        a aVar = (a) view.getTag();
        int i10 = this.f1328y;
        int i11 = i10 != -1 ? cursor.getInt(i10) : 0;
        if (aVar.f1329a != null) {
            z(aVar.f1329a, w(cursor, this.f1323t));
        }
        if (aVar.f1330b != null) {
            String w10 = w(cursor, this.f1325v);
            if (w10 != null) {
                charSequence = l(w10);
            } else {
                charSequence = w(cursor, this.f1324u);
            }
            if (TextUtils.isEmpty(charSequence)) {
                TextView textView = aVar.f1329a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f1329a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f1329a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f1329a.setMaxLines(1);
                }
            }
            z(aVar.f1330b, charSequence);
        }
        ImageView imageView = aVar.f1331c;
        if (imageView != null) {
            y(imageView, t(cursor), 4);
        }
        ImageView imageView2 = aVar.f1332d;
        if (imageView2 != null) {
            y(imageView2, u(cursor), 8);
        }
        int i12 = this.f1321r;
        if (i12 == 2 || (i12 == 1 && (i11 & 1) != 0)) {
            aVar.f1333e.setVisibility(0);
            aVar.f1333e.setTag(aVar.f1329a.getText());
            aVar.f1333e.setOnClickListener(this);
            return;
        }
        aVar.f1333e.setVisibility(8);
    }

    @Override // n0.a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i10, view, viewGroup);
        } catch (RuntimeException e10) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e10);
            View g10 = g(this.f1317n, b(), viewGroup);
            if (g10 != null) {
                ((a) g10.getTag()).f1329a.setText(e10.toString());
            }
            return g10;
        }
    }

    @Override // n0.a, android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i10, view, viewGroup);
        } catch (RuntimeException e10) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e10);
            View h10 = h(this.f1317n, b(), viewGroup);
            if (h10 != null) {
                ((a) h10.getTag()).f1329a.setText(e10.toString());
            }
            return h10;
        }
    }

    @Override // n0.c, n0.a
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        View h10 = super.h(context, cursor, viewGroup);
        h10.setTag(new a(h10));
        ((ImageView) h10.findViewById(f.f24805q)).setImageResource(this.f1319p);
        return h10;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        B(b());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        B(b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f1315l.U((CharSequence) tag);
        }
    }

    Drawable r(Uri uri) throws FileNotFoundException {
        int parseInt;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.f1317n.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            parseInt = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (parseInt != 0) {
                        return resourcesForApplication.getDrawable(parseInt);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        } else {
            throw new FileNotFoundException("No authority: " + uri);
        }
    }

    Cursor v(SearchableInfo searchableInfo, String str, int i10) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i10 > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i10));
        }
        return this.f1317n.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }

    public void x(int i10) {
        this.f1321r = i10;
    }
}
