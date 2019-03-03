package tommy.naivedialog.dialog_fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import tommy.naivedialog.R;

/**
 * @author : Tommy
 * 通过 onCreateDialog() 方法，使用 AlertDialog.Builder 填充 xml 布局 来实现对话框
 */

public class XmlDialogFragment extends DialogFragment {


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = LayoutInflater.from(getActivity());

        View view = inflater.inflate(R.layout.dialog_fragment, null);

        Button btnOk =  view.findViewById(R.id.btn_ok);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "666", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setView(view).setPositiveButton("sure", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "dialog sure clicked", Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("cancel", null);
        return builder.create();
    }

    public void show(FragmentManager manager) {
        show(manager,"xml_dialog1");
    }
}
