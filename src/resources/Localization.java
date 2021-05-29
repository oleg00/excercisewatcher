package resources;

import java.util.Locale;

public class Localization {
    private Localization() {
        throw new IllegalStateException("Utility class");
    }

    public static final Locale UKRAINE = new Locale("uk", "UA");
    public static final Locale ENGLISH = Locale.ENGLISH;

    public static Locale currentLocale = ENGLISH;

    public static void setCurrentLocale (Locale newLocale) {
        currentLocale = newLocale;
    }
}
