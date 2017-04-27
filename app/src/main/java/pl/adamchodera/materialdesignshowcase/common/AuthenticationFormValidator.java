package pl.adamchodera.materialdesignshowcase.common;

import android.text.TextUtils;

public class AuthenticationFormValidator {

    public boolean isEmailValid(final String email) {
        if (TextUtils.isEmpty(email)) {
            return false;
        }

        //TODO: Implement better solution
        return email.contains("@");
    }

    public boolean isPasswordValid(final String password) {
        if (TextUtils.isEmpty(password)) {
            return false;
        }

        //TODO: Implement better solution
        return password.length() > 4;
    }
}
