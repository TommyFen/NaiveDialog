package tommy.naivedialog;

import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import tommy.naivedialog.dialog_fragment.AlertDialogFragment;
import tommy.naivedialog.dialog_fragment.TabFragmentDialog;
import tommy.naivedialog.dialog_fragment.XmlDialogFragment;
import tommy.naivedialog.dialog_fragment.XmlDialogFragment2;
import tommy.naivedialog.dialog_fragment.XmlDialogFragment3;
import tommy.naivedialog.popup.PopupFragment;

import static tommy.naivedialog.Type.POPUP;

public class MainActivity extends AppCompatActivity implements PopupFragment.OnFragmentInteractionListener, DialogTypeAdapter.OnItemClickListener {

    private RecyclerView rvDialogType;
    private List<DialogType> mTypes;
    private DialogTypeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTypes = new ArrayList<>();
        rvDialogType = findViewById(R.id.rv_dialog_type);

        mAdapter = new DialogTypeAdapter(mTypes);
        mAdapter.setOnItemClickListener(this);
        rvDialogType.setAdapter(mAdapter);
        rvDialogType.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                if (parent.getChildAdapterPosition(view) == 0) {
                    outRect.top = 8;
                }
                outRect.bottom = 4;

            }
        });

        getDialogTypeData();
    }


    private void getDialogTypeData() {

        if (null != mTypes) {
            mTypes.add(new DialogType(POPUP, "PopupWindow"));
            mTypes.add(new DialogType(Type.DIALOG_FRAGMENT_1, "DIALOG_FRAGMENT_1"));
            mTypes.add(new DialogType(Type.DIALOG_FRAGMENT_2, "DIALOG_FRAGMENT_2"));
            mTypes.add(new DialogType(Type.DIALOG_FRAGMENT_3, "DIALOG_FRAGMENT_3"));
            mTypes.add(new DialogType(Type.DIALOG_FRAGMENT_4, "DIALOG_FRAGMENT_4"));
            mTypes.add(new DialogType(Type.DIALOG_FRAGMENT_5, "DIALOG_FRAGMENT_5"));
            mTypes.add(new DialogType(Type.DIALOG_FRAGMENT_6, "DIALOG_FRAGMENT_6"));
            mTypes.add(new DialogType(Type.DIALOG_FRAGMENT_7, "DIALOG_FRAGMENT_7"));
            mTypes.add(new DialogType(Type.DIALOG_FRAGMENT_8, "DIALOG_FRAGMENT_8"));
            mTypes.add(new DialogType(Type.DIALOG_FRAGMENT_9, "DIALOG_FRAGMENT_9"));
            mTypes.add(new DialogType(Type.DIALOG_FRAGMENT_10, "DIALOG_FRAGMENT_10"));
            mTypes.add(new DialogType(Type.DIALOG_FRAGMENT_11, "DIALOG_FRAGMENT_11"));
        }

    }



    @Override
    public void onFragmentInteraction(Uri uri) {
    }

    @Override
    public void onItemClick(Type type) {
        switch (type) {
            case POPUP:
                Intent intent = new Intent(MainActivity.this, PopActivity.class);
                startActivity(intent);
            case DIALOG_FRAGMENT_1:
                // alert dialog
                new AlertDialogFragment().show(getSupportFragmentManager());
                break;
            case DIALOG_FRAGMENT_2:
                new XmlDialogFragment().show(getSupportFragmentManager());
                break;
            case DIALOG_FRAGMENT_3:
                new XmlDialogFragment2().show(getSupportFragmentManager());
                break;
            case DIALOG_FRAGMENT_4:
                new XmlDialogFragment3().show(getSupportFragmentManager());
                break;
            case DIALOG_FRAGMENT_5:
                new TabFragmentDialog().show(getSupportFragmentManager());
                break;
            default:
                Toast.makeText(this, "Coming soon", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
