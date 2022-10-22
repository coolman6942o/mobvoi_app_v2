package com.mobvoi.mcuwatch.article;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import com.cardiex.arty.lite.models.coach.Article;
import com.mobvoi.mcuwatch.article.a;
import com.mobvoi.mcuwatch.article.widget.ArticleTitleBar;
import hc.e;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import qo.l;
import sh.k;
import wi.d;
/* compiled from: ArticleActivity.kt */
/* loaded from: classes2.dex */
public final class ArticleActivity extends d<zh.d> implements ArticleTitleBar.b, NestedScrollView.b {

    /* renamed from: g  reason: collision with root package name */
    public static final b f19087g = new b(null);

    /* renamed from: d  reason: collision with root package name */
    private final io.d f19088d;

    /* renamed from: e  reason: collision with root package name */
    private Float f19089e = Float.valueOf(0.0f);

    /* renamed from: f  reason: collision with root package name */
    private Article f19090f;

    /* compiled from: ArticleActivity.kt */
    /* loaded from: classes2.dex */
    /* synthetic */ class a extends FunctionReferenceImpl implements l<LayoutInflater, zh.d> {
        public static final a INSTANCE = new a();

        a() {
            super(1, zh.d.class, "inflate", "inflate(Landroid/view/LayoutInflater;)Lcom/mobvoi/mcuwatch/databinding/ActivityArticleBinding;", 0);
        }

        /* renamed from: g */
        public final zh.d invoke(LayoutInflater p02) {
            i.f(p02, "p0");
            return zh.d.d(p02);
        }
    }

    /* compiled from: ArticleActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }

        public final void a(Context context, Article data) {
            i.f(context, "context");
            i.f(data, "data");
            Intent intent = new Intent(context, ArticleActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("article_key", data);
            intent.putExtras(bundle);
            context.startActivity(intent);
        }
    }

    /* compiled from: ArticleActivity.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements qo.a<ArticleActivity> {
        c() {
            super(0);
        }

        /* renamed from: a */
        public final ArticleActivity invoke() {
            return ArticleActivity.this;
        }
    }

    public ArticleActivity() {
        super(a.INSTANCE);
        io.d a10;
        a10 = io.f.a(new c());
        this.f19088d = a10;
    }

    private final ArticleActivity Q() {
        return (ArticleActivity) this.f19088d.getValue();
    }

    private final void S() {
        Bundle extras = getIntent().getExtras();
        this.f19090f = (Article) (extras == null ? null : extras.get("article_key"));
    }

    private final void U() {
        a.C0222a aVar = com.mobvoi.mcuwatch.article.a.f19091a;
        LinearLayout linearLayout = H().f37524c;
        i.e(linearLayout, "binding.articleLl");
        Bitmap a10 = aVar.a(linearLayout);
        if (a10 != null) {
            aVar.b(Q(), a10);
        }
    }

    private final void V(int i10) {
        H().f37525d.setTextColor(getResources().getColor(i10));
        H().f37523b.setTextColor(getResources().getColor(i10));
    }

    private final void initView() {
        Article article = this.f19090f;
        if (article != null) {
            H().f37525d.setText(article.getTitle());
            H().f37523b.setText(getString(k.f_res_0x7f1400c6, new Object[]{article.getAuthor(), article.getAuthorLocation()}));
            if (TextUtils.isEmpty(article.getImage())) {
                H().f37526e.setBackgroundColor(getResources().getColor(sh.d.f34452l));
                V(sh.d.f34445e);
                H().f37529h.setIsWhiteColor(false);
            } else {
                com.bumptech.glide.c.w(Q()).r(article.getImage()).u0(H().f37526e);
                V(sh.d.a_res_0x7f06002c);
                H().f37529h.setIsWhiteColor(true);
            }
            H().f37527f.setText(Html.fromHtml(article.getBodyHtml()));
            String id2 = article.getId();
            if (id2 != null) {
                ad.a.f168a.l(id2);
            }
        }
        H().f37528g.setOnScrollChangeListener(this);
        ArticleTitleBar articleTitleBar = H().f37529h;
        articleTitleBar.setTranslucentStatus(Q());
        articleTitleBar.setOnTabBarClickListener(Q());
    }

    @Override // wi.d
    protected boolean J() {
        return true;
    }

    public final void T() {
        if (e.j(Q())) {
            U();
        } else {
            androidx.core.app.a.s(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
        }
    }

    @Override // com.mobvoi.mcuwatch.article.widget.ArticleTitleBar.b
    public void e() {
        T();
    }

    @Override // com.mobvoi.mcuwatch.article.widget.ArticleTitleBar.b
    public void f() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // wi.d, com.mobvoi.companion.base.m3.a, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        S();
        initView();
    }

    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] permissions, int[] grantResults) {
        i.f(permissions, "permissions");
        i.f(grantResults, "grantResults");
        super.onRequestPermissionsResult(i10, permissions, grantResults);
        if (i10 == 1) {
            if (!(!(grantResults.length == 0)) || grantResults[0] != 0) {
                O(getString(k.f34805g2));
            } else {
                U();
            }
        }
    }

    @Override // androidx.core.widget.NestedScrollView.b
    public void w(NestedScrollView nestedScrollView, int i10, int i11, int i12, int i13) {
        float e10;
        float b10;
        int b11 = aa.d.b(158.0f, Q());
        float f10 = i11 < b11 ? (i11 * 1.0f) / b11 : 1.0f;
        if (!i.a(f10, this.f19089e)) {
            ArticleTitleBar articleTitleBar = H().f37529h;
            e10 = vo.f.e(f10, 1.0f);
            b10 = vo.f.b(e10, 0.0f);
            articleTitleBar.f(b10);
            this.f19089e = Float.valueOf(f10);
        }
    }
}
