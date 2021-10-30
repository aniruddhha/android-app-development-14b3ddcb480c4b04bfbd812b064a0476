package com.aniruddha.kudalkar.appdevsession.week3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.aniruddha.kudalkar.appdevsession.R;

import java.util.List;

public class SmsAdapter extends RecyclerView.Adapter<SmsViewHolder> {

    private final Context context;
    private final List<ImpMsg> messages;
    private final MutableLiveData<ImpMsg> clickedItem;

    public SmsAdapter(
            Context context,
            List<ImpMsg> messages,
            MutableLiveData<ImpMsg> clickedItem
    ) {
        this.context = context;
        this.messages = messages;
        this.clickedItem = clickedItem;
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

        holder.itemView.setOnClickListener( v -> clickedItem.setValue(msg) );
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }
}
