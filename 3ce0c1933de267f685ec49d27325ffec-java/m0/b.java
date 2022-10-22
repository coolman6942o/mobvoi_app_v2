package m0;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.core.view.c;
import androidx.core.view.d0;
import j0.h;
/* compiled from: InputConnectionCompat.java */
@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public final class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InputConnectionCompat.java */
    /* loaded from: classes.dex */
    public class a extends InputConnectionWrapper {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f30591a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InputConnection inputConnection, boolean z10, d dVar) {
            super(inputConnection, z10);
            this.f30591a = dVar;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean commitContent(InputContentInfo inputContentInfo, int i10, Bundle bundle) {
            if (this.f30591a.a(m0.c.f(inputContentInfo), i10, bundle)) {
                return true;
            }
            return super.commitContent(inputContentInfo, i10, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InputConnectionCompat.java */
    /* renamed from: m0.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0394b extends InputConnectionWrapper {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f30592a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0394b(InputConnection inputConnection, boolean z10, d dVar) {
            super(inputConnection, z10);
            this.f30592a = dVar;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean performPrivateCommand(String str, Bundle bundle) {
            if (b.d(str, bundle, this.f30592a)) {
                return true;
            }
            return super.performPrivateCommand(str, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InputConnectionCompat.java */
    /* loaded from: classes.dex */
    public class c implements d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f30593a;

        c(View view) {
            this.f30593a = view;
        }

        @Override // m0.b.d
        public boolean a(m0.c cVar, int i10, Bundle bundle) {
            if (Build.VERSION.SDK_INT >= 25 && (i10 & 1) != 0) {
                try {
                    cVar.d();
                    InputContentInfo inputContentInfo = (InputContentInfo) cVar.e();
                    bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                    bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", inputContentInfo);
                } catch (Exception e10) {
                    Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e10);
                    return false;
                }
            }
            return d0.j0(this.f30593a, new c.a(new ClipData(cVar.b(), new ClipData.Item(cVar.a())), 2).d(cVar.c()).b(bundle).a()) == null;
        }
    }

    /* compiled from: InputConnectionCompat.java */
    /* loaded from: classes.dex */
    public interface d {
        boolean a(m0.c cVar, int i10, Bundle bundle);
    }

    private static d a(View view) {
        h.g(view);
        return new c(view);
    }

    public static InputConnection b(View view, InputConnection inputConnection, EditorInfo editorInfo) {
        return c(inputConnection, editorInfo, a(view));
    }

    @Deprecated
    public static InputConnection c(InputConnection inputConnection, EditorInfo editorInfo, d dVar) {
        j0.c.c(inputConnection, "inputConnection must be non-null");
        j0.c.c(editorInfo, "editorInfo must be non-null");
        j0.c.c(dVar, "onCommitContentListener must be non-null");
        if (Build.VERSION.SDK_INT >= 25) {
            return new a(inputConnection, false, dVar);
        }
        return m0.a.a(editorInfo).length == 0 ? inputConnection : new C0394b(inputConnection, false, dVar);
    }

    static boolean d(String str, Bundle bundle, d dVar) {
        boolean z10;
        Throwable th2;
        ResultReceiver resultReceiver;
        boolean z11 = false;
        z11 = false;
        if (bundle == null) {
            return false;
        }
        if (TextUtils.equals("androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", str)) {
            z10 = false;
        } else if (!TextUtils.equals("android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", str)) {
            return false;
        } else {
            z10 = true;
        }
        try {
            resultReceiver = (ResultReceiver) bundle.getParcelable(z10 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER");
            try {
                Uri uri = (Uri) bundle.getParcelable(z10 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI");
                ClipDescription clipDescription = (ClipDescription) bundle.getParcelable(z10 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION");
                Uri uri2 = (Uri) bundle.getParcelable(z10 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI");
                int i10 = bundle.getInt(z10 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS");
                Bundle bundle2 = (Bundle) bundle.getParcelable(z10 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS");
                if (!(uri == null || clipDescription == null)) {
                    z11 = dVar.a(new m0.c(uri, clipDescription, uri2), i10, bundle2);
                }
                if (resultReceiver != null) {
                    int i11 = z11 ? 1 : 0;
                    int i12 = z11 ? 1 : 0;
                    int i13 = z11 ? 1 : 0;
                    resultReceiver.send(i11, null);
                }
                return z11;
            } catch (Throwable th3) {
                th2 = th3;
                if (resultReceiver != null) {
                    resultReceiver.send(0, null);
                }
                throw th2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            resultReceiver = null;
        }
    }
}
