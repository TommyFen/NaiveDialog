package tommy.naivedialog;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;

import tommy.naivedialog.popup.PopupFragment;

public class MainActivity extends AppCompatActivity implements PopupFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Layout Click Event
     * @param view
     */
    public void goFragment(View view) {
        switch (view.getId()) {
            case R.id.go_popup:
                goPopupWindows();
                break;
        }
    }


    private void goPopupWindows() {
        replaceFragment(new PopupFragment());
    }


    private void replaceFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
