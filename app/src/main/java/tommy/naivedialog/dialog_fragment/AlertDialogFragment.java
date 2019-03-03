package tommy.naivedialog.dialog_fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

/**
 * @author : Tommy
 * 根据已有的 AlertDialog 创建 FragmentDialog 可根据设置的 Dialog
 * 主题来设计 Dialog 的样式
 */

public class AlertDialogFragment extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Dialog").setMessage("This is a DialogFragment inner AlertDialog")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "click dialog", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("cancel", null);

        return builder.create();
    }

    public void show(FragmentManager manager) {
        show(manager, "alert_dialog");
    }
}
