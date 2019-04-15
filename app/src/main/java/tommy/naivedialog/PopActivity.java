package tommy.naivedialog;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

public class PopActivity extends AppCompatActivity {

    private PopupWindow popupWindow1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);

        initView();
    }

    private void initView() {
        //show the down of view
        findViewById(R.id.btn_position1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDropDown(v);
            }
        });

        //show the down of window
        findViewById(R.id.btn_position2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDownOfWindow(v);
            }
        });


    }


    private void showDownOfWindow(View view) {

        PopupWindow popupWindow = new PopupWindow();

        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setContentView(LayoutInflater.from(this).inflate(R.layout.layout_simple_popupwindow, null));

        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow.setFocusable(true);
        // add animator
        popupWindow.setAnimationStyle(R.style.popup_anim_style);

        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
    }

    private void showDropDown(View view) {
        popupWindow1 = new PopupWindow();
        popupWindow1.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow1.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        View inflateView = LayoutInflater.from(this).inflate(R.layout.layout_simple_popupwindow, null);
        inflateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (popupWindow1 != null && popupWindow1.isShowing()) {
                    popupWindow1.dismiss();
                }
            }
        });
        popupWindow1.setContentView(inflateView);

        //set background transparent
        popupWindow1.setBackgroundDrawable(new ColorDrawable(0x00000000));
        //if focusable is true, key back that dismiss popup not destroy activity, but outside click event
        //to dismiss popupWindow will work anyway
        popupWindow1.setFocusable(false);
        //make outside click event that dismiss popup window no work
        popupWindow1.setOutsideTouchable(false);
        //no Gravity.TOP and Gravity.BOTTOM in this method
        popupWindow1.showAsDropDown(view, 0, -80, Gravity.END);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        //avoid popupWindow's click event skip over(break) when popupWindow is showing
        if (null != popupWindow1 && popupWindow1.isShowing()) {
            return false;
        }
        return super.dispatchTouchEvent(ev);
    }


    @Override
    public void onBackPressed() {
        if (popupWindow1 != null && popupWindow1.isShowing()) {
            popupWindow1.dismiss();
        } else {
            super.onBackPressed();
        }
    }

}
