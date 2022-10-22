package i5;

import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;
/* compiled from: ImageHeaderParserRegistry.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final List<ImageHeaderParser> f28084a = new ArrayList();

    public synchronized void a(ImageHeaderParser imageHeaderParser) {
        this.f28084a.add(imageHeaderParser);
    }

    public synchronized List<ImageHeaderParser> b() {
        return this.f28084a;
    }
}
