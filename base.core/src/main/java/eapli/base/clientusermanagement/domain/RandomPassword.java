package eapli.base.clientusermanagement.domain;

import eapli.framework.domain.model.Immutable;
import eapli.framework.strings.util.Strings;

/**
 *
 * @author marly
 */
@Immutable
public class RandomPassword {

    private static final int DEFAULT_LENGTH = 12;

    private static final String LOWER_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER_CHARS = LOWER_CHARS.toUpperCase();
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL = "_-+*/=#?!.&$€";

    public static final String ALLOWED_CHARS = LOWER_CHARS + UPPER_CHARS + NUMBERS + SPECIAL;

    private String password = "";

    /**
     * Constructs a random password with the default length.
     */
    public RandomPassword() {
        this(DEFAULT_LENGTH);
    }

    /**
     * Constructs a random password with the desired length.
     *
     * @param length
     */
    public RandomPassword(final int length) {
        password = Strings.randomString(1, UPPER_CHARS) + Strings.randomString(1, NUMBERS) +
                Strings.randomString(length-2, ALLOWED_CHARS);
    }

    @Override
    public String toString() {
        return password;
    }

}
