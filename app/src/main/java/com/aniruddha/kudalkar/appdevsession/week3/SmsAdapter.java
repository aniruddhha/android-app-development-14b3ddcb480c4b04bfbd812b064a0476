package com.aniruddha.kudalkar.appdevsession.week3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aniruddha.kudalkar.appdevsession.R;

import java.util.List;

public class SmsAdapter extends RecyclerView.Adapter<SmsViewHolder> {

    private final Context context;
    private final List<ImpMsg> messages;

    public SmsAdapter(
            Context context,
            List<ImpMsg> messages
    ) {
        this.context = context;
        this.messages = messages;
    }

    @NonNull
    @Override
    public SmsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View root = LayoutInflater.from(context).inflate(
                R.layout.sms_rec_item,
                parent,
                false
        );

        return new SmsViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull SmsViewHolder holder, int position) {

        ImpMsg msg = messages.get(position);

        holder.nm().setText(msg.getNm());
        holder.num().setText(msg.getNum());
        holder.msg().setText(msg.getMsg());
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }
}
