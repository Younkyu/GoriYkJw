package goriproject.ykjw.com.myapplication.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Younkyu on 2017-04-10.
 */

public class SignUtil {
    // 이메일 정규식([영문, 숫자, (._%+-)]@[영문, 숫자, (.-)].[영문 2자리~6자리] 형식)
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    // 비밀번호 정규식([영문, 숫자, (!@.#$%^&*?_~)] 6자리~16자리 형식)
    private static final Pattern VALID_PASSWORD_ADDRESS_REGEX =
            Pattern.compile("^[a-zA-Z0-9!@.#$%^&*?_~]{6,16}");

    public static boolean validateEmail(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }

    public static boolean validatePassword(String password) {
        Matcher matcher = VALID_PASSWORD_ADDRESS_REGEX.matcher(password);
        return matcher.matches();
    }

    public static boolean checkTwoPasswords(String original, String check) {
        if("".equals(original)||"".equals(check)) {
            return false;
        } else {
            return original.equals(check);
        }
    }
}