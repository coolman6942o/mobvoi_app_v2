package e4;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class c implements FileFilter {
    public c(b bVar) {
    }

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return Pattern.matches("cpu[0-9]+", file.getName());
    }
}
