package kotlin.jvm;
/* compiled from: KotlinReflectionNotSupportedError.kt */
/* loaded from: classes3.dex */
public class KotlinReflectionNotSupportedError extends Error {
    public KotlinReflectionNotSupportedError() {
        super("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }

    public KotlinReflectionNotSupportedError(String str) {
        super(str);
    }

    public KotlinReflectionNotSupportedError(String str, Throwable th2) {
        super(str, th2);
    }

    public KotlinReflectionNotSupportedError(Throwable th2) {
        super(th2);
    }
}
