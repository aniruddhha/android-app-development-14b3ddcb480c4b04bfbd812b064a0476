package com.aniruddha.kudalkar.appdevsession.week3;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aniruddha.kudalkar.appdevsession.R;

public class SmsViewHolder extends RecyclerView.ViewHolder {

    public SmsViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public TextView nm() {
        return itemView.findViewById(R.id.txNm);
    }

    public TextView msg() {
        return itemView.findViewById(R.id.txMsg);
    }

    public TextView num() {
        return itemView.findViewById(R.id.txNum);
    }
}
