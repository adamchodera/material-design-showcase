package pl.adamchodera.materialdesignshowcase.authentication.common;

import android.content.Context;
import android.text.TextUtils;

import pl.adamchodera.materialdesignshowcase.R;

public class AuthenticationFormValidator {

    public boolean isEmailValid(final String email) {
        if (TextUtils.isEmpty(email)) {
            return false;
        }

        //TODO: Implement better solution
        return email.contains("@");
    }

    public boolean isPasswordValid(final String password, final Context context) {
        if (TextUtils.isEmpty(password)) {
            return false;
        }

        //TODO: Implement better solution
        final int passwordLength = password.length();
        final int maxPasswordLength = context.getResources().getInteger(R.integer.password_max_length);
        final int minPasswordLength = 4;

        return passwordLength >= minPasswordLength && passwordLength <= maxPasswordLength;
    }
}
