package pl.adamchodera.materialdesignshowcase.registration;

import android.os.Bundle;

import butterknife.ButterKnife;
import pl.adamchodera.materialdesignshowcase.R;
import pl.adamchodera.materialdesignshowcase.common.AuthenticationActivity;

/**
 * A screen that offers registration via email & password.
 */
public class RegisterActivity extends AuthenticationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        super.initFormView();
    }

    @Override
    protected void triggerAuthentication() {
        super.showProgress(true);
    }
}

