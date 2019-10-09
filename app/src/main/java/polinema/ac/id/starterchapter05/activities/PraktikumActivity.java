package polinema.ac.id.starterchapter05.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import polinema.ac.id.starterchapter05.R;
import polinema.ac.id.starterchapter05.fragments.DipsFragment;
import polinema.ac.id.starterchapter05.fragments.HandStandFragment;
import polinema.ac.id.starterchapter05.fragments.PushUpFragment;

public class PraktikumActivity extends AppCompatActivity {

    private Object fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tugas_);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .add(R.id.frameLayout, new PushUpFragment())
                    .commit();
        }
    }

    public void handlerClikPushup(View view) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frameLayout);

        if (fragment == null || fragment instanceof DipsFragment || fragment instanceof HandStandFragment) {
            getSupportFragmentManager().beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .replace(R.id.frameLayout, new PushUpFragment())
                    .commit();
        }
    }

    public void handlerClickDips(View view) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frameLayout);

        if (fragment == null || fragment instanceof PushUpFragment || fragment instanceof HandStandFragment) {
            getSupportFragmentManager().beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .replace(R.id.frameLayout, new DipsFragment())
                    .commit();
        }
    }


    public void handlerClickHandstand(View view) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frameLayout);

        if (fragment == null || fragment instanceof PushUpFragment || fragment instanceof DipsFragment) {
            getSupportFragmentManager().beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .replace(R.id.frameLayout, new HandStandFragment())
                    .commit();
        }
    }
}
