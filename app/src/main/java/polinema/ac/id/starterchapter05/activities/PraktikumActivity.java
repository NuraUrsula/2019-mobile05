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
        setContentView(R.layout.activity_praktikum);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .add(R.id.praktikum_fragment_placeholder, new PushUpFragment())
                    .commit();
        }
    }

    public void handlerPushups(View view) {
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_from_left, R.anim.enter_from_left, R.anim.exit_from_left);
//        fragmentTransaction.replace(R.id.praktikum_fragment_placeholder,new PushUpFragment());
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.praktikum_fragment_placeholder);

        if (fragment == null || fragment instanceof DipsFragment || fragment instanceof HandStandFragment) {
            getSupportFragmentManager().beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .replace(R.id.praktikum_fragment_placeholder, new PushUpFragment())
                    .commit();
        }
    }

    public void handlerDips(View view) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.praktikum_fragment_placeholder);

        if (fragment == null || fragment instanceof PushUpFragment || fragment instanceof HandStandFragment) {
            getSupportFragmentManager().beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .replace(R.id.praktikum_fragment_placeholder, new DipsFragment())
                    .commit();
        }
    }


    public void handlerHandstand(View view) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.praktikum_fragment_placeholder);

        if (fragment == null || fragment instanceof PushUpFragment || fragment instanceof DipsFragment) {
            getSupportFragmentManager().beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .replace(R.id.praktikum_fragment_placeholder, new HandStandFragment())
                    .commit();
        }
    }
}
