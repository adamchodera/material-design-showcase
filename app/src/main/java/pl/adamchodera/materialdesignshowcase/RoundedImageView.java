package pl.adamchodera.materialdesignshowcase;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RoundedImageView extends ImageView {

    public RoundedImageView(final Context context) {
        super(context);
        init();
    }

    public RoundedImageView(final Context context, AttributeSet arAttributeSet) {
        super(context, arAttributeSet);
        init();
    }

    public RoundedImageView(Context context, AttributeSet attributeSet, int defStyleAttr) {
        super(context, attributeSet, defStyleAttr);
        init();
    }

    private void init() {
        Resources res = getResources();
        Bitmap src = BitmapFactory.decodeResource(res, R.drawable.img_my_photo);

        RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(res, src);
        drawable.setCircular(true);

        setImageDrawable(drawable);
    }
}
