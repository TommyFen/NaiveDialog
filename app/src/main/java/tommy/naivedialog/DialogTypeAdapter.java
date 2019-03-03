package tommy.naivedialog;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * @author : Tommy
 */
public class DialogTypeAdapter extends RecyclerView.Adapter<DialogTypeAdapter.DialogTypeViewHolder> {

    private List<DialogType> mTypes;

    private OnItemClickListener onItemClickListener;

    public DialogTypeAdapter(List<DialogType> types) {
        this.mTypes = types;
    }

    @NonNull
    @Override
    public DialogTypeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.item_dialog_type, viewGroup, false);
        return new DialogTypeViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull DialogTypeViewHolder holder, int i) {
        final DialogType dialogType = mTypes.get(i);
        holder.tvTypeName.setText(dialogType.getTypeName());
        holder.tvTypeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != onItemClickListener) {
                    onItemClickListener.onItemClick(dialogType.getType());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTypes.size();
    }

    static class DialogTypeViewHolder extends RecyclerView.ViewHolder {

        TextView tvTypeName;

        DialogTypeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTypeName = itemView.findViewById(R.id.tv_type_name);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    interface OnItemClickListener{

        void onItemClick(Type type);

    }


}
