package spark.com.sms;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import spark.com.sms.model.User;

/**
 * Created by root on 4/18/16.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecycleViewHolders> {

    private List<User> userList;
    private Context context;

    public RecyclerViewAdapter(List<User> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @Override
    public RecycleViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null);
        RecycleViewHolders recycleViewHolders = new RecycleViewHolders(view);
        return recycleViewHolders;
    }

    @Override
    public void onBindViewHolder(RecycleViewHolders holder, int position) {

        holder.textViewEmail.setText(userList.get(position).getEmail());
        holder.textViewUsername.setText(userList.get(position).getUsername());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
