package pl.adamchodera.materialdesignshowcase.authentication.common;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.BindView;
import pl.adamchodera.materialdesignshowcase.R;

public abstract class AuthenticationActivity extends AppCompatActivity implements AuthenticationFormView.OnButtonClickedListener {

    @BindView(R.id.progress_bar)
    protected View progressView;

    @BindView(R.id.authentication_form)
    protected AuthenticationFormView formView;

    public abstract void onRaisedButtonClicked();

    public abstract void onFlatButtonClicked();

    protected abstract String getRaisedButtonLabel();

    protected abstract String getFlatButtonLabel();

    protected void initFormView() {
        formView.setOnButtonClickedListener(this);

        formView.setRaisedButtonLabel(getRaisedButtonLabel());
        formView.setFlatButtonLabel(getFlatButtonLabel());
    }

    /**
     * Shows the progress bar and hides the form.
     */
    protected void showProgress(final boolean show) {
        progressView.setVisibility(show ? View.VISIBLE : View.GONE);
        formView.setVisibility(show ? View.GONE : View.VISIBLE);
    }

    // TODO implement Snackbar
}
