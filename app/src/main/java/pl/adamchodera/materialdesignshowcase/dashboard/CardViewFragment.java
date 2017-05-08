package pl.adamchodera.materialdesignshowcase.dashboard;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.adamchodera.materialdesignshowcase.R;

public class CardViewFragment extends Fragment {

    @BindView(R.id.show_card_button)
    AppCompatButton showCardButton;

    @BindView(R.id.card_view)
    CardView cardView;

    public CardViewFragment() {
        // Required empty public constructor
    }

    public static CardViewFragment newInstance() {
        return new CardViewFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_card_view, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.show_card_button)
    protected void showCard() {
        // get the center for the clipping circle
        int cx = cardView.getMeasuredWidth() / 2;
        int cy = cardView.getMeasuredHeight() / 2;

        // get the final radius for the clipping circle
        int finalRadius = Math.max(cardView.getWidth(), cardView.getHeight()) / 2;

        // create the animator for this view (the start radius is zero)
        Animator anim =
                null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            anim = ViewAnimationUtils.createCircularReveal(cardView, cx, cy, 0, finalRadius);
        }

        // make the view visible and start the animation
        cardView.setVisibility(View.VISIBLE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            anim.start();
        }

        showCardButton.setVisibility(View.INVISIBLE);
    }

    @OnClick(R.id.card_view)
    protected void hideCard() {
        // get the center for the clipping circle
        int cx = cardView.getMeasuredWidth() / 2;
        int cy = cardView.getMeasuredHeight() / 2;

        // get the initial radius for the clipping circle
        int initialRadius = cardView.getWidth() / 2;

        // create the animation (the final radius is zero)
        Animator anim =
                null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            anim = ViewAnimationUtils.createCircularReveal(cardView, cx, cy, initialRadius, 0);


            // make the view invisible when the animation is done
            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    cardView.setVisibility(View.INVISIBLE);
                    showCardButton.setVisibility(View.VISIBLE);

                }
            });
            // start the animation
            anim.start();
        } else {
            cardView.setVisibility(View.INVISIBLE);
            showCardButton.setVisibility(View.VISIBLE);
        }
    }
}
