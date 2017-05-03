package pl.adamchodera.materialdesignshowcase;

import android.content.Context;
import android.content.Intent;

public class ShareLinkUtil {

    private final Context context;

    public ShareLinkUtil(final Context context) {
        this.context = context;
    }

    public void shareLinkToThisApp() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, getLinkToGooglePlay());
        sendIntent.setType("text/plain");
        context.startActivity(Intent.createChooser(sendIntent, context.getResources().getText(R.string.share_link)));
    }

    private String getLinkToGooglePlay() {
        return "Check out this app: https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID;
    }
}
