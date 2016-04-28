package spark.com.sms;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by root on 4/18/16.
 */
public class RecycleViewHolders extends RecyclerView.ViewHolder {

    public TextView textViewUsername;
    public TextView textViewEmail;

    public RecycleViewHolders(View itemView) {
        super(itemView);

        textViewUsername = (TextView)itemView.findViewById(R.id.textViewUsername);
        textViewEmail = (TextView)itemView.findViewById(R.id.textViewEmail);

    }
}
