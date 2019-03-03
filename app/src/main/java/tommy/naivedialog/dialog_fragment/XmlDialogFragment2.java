package tommy.naivedialog.dialog_fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import tommy.naivedialog.R;


/**
 * 使用 DialogFragment 实现自定义对话框
 * 悬浮界面的交互，在复杂的使用过程中，经常出现这样一个场景：
 * 需要拿到 Activity 界面实例，来调用公开的方法，且有时候也需要管理其生命周期，来提高整体程序的性能。
 * <p>
 * 然而，Dialog 类是一个独立的存在的界面，Activity 只能通过实例简单的管理，或者通过 Java 的回调机制来实现
 * 两个类之间的操作或者数据的简单交互。
 * <p>
 * DialogFragment本质上是一个 Fragment，依附于 Activity，生命周期可控，两者之间的交互也简单易处理。
 * <p>
 * Created by tommy on 2017/7/30.
 */

public class XmlDialogFragment2 extends DialogFragment {


    public static XmlDialogFragment2 getInstance() {
        return new XmlDialogFragment2();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.dialog_xml2, container, false);
        TextView tvOk = (TextView) view.findViewById(R.id.tv_ok);
        TextView tvCancel = (TextView) view.findViewById(R.id.tv_cancel);
        final EditText edtInput = (EditText) view.findViewById(R.id.edt_input);

        tvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = edtInput.getText().toString().trim();
                if (!TextUtils.isEmpty(input)) {
                    Toast.makeText(getContext(), input, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "输入不能为空", Toast.LENGTH_SHORT).show();
                }
                dismiss();
            }
        });

        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return view;
    }

    public void show(FragmentManager manager) {
        show(manager, "dialog_xml2");
    }

}
