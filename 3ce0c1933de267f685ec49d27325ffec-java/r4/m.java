package r4;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: StreamAssetPathFetcher.java */
/* loaded from: classes.dex */
public class m extends b<InputStream> {
    public m(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // r4.d
    public Class<InputStream> a() {
        return InputStream.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public void d(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public InputStream f(AssetManager assetManager, String str) throws IOException {
        return assetManager.open(str);
    }
}
