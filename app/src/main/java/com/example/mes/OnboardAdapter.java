package com.example.mes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OnboardAdapter extends RecyclerView.Adapter<OnboardAdapter.OnboardViewHolder> {

    private final Context context;

    public OnboardAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public OnboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_onboard, parent, false);
        return new OnboardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OnboardViewHolder holder, int position) {
        String title;
        String description;

        switch (position) {
            case 0:
                title = "Мгновенный чат";
                description = "Мгновенно общайтесь со своими контактами и легко делитесь медиафайлами.";
                break;
            case 1:
                title = "Групповые чаты";
                description = "Создавайте группы чата, чтобы оставаться на связи с несколькими друзьями.";
                break;
            case 2:
                title = "Уведомления";
                description = "Получайте уведомления, чтобы никогда не пропустить ни одного сообщения.";
                break;
            default:
                title = "Оставайтесь на связи";
                description = "Оставайтесь на связи с нашим многофункциональным мессенджером.";
                break;
        }

        holder.messengerTitle.setText(title);
        holder.messengerDescription.setText(description);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    static class OnboardViewHolder extends RecyclerView.ViewHolder {
        TextView messengerTitle;
        TextView messengerDescription;

        public OnboardViewHolder(@NonNull View itemView) {
            super(itemView);

            messengerTitle = itemView.findViewById(R.id.messengerTitle);
            messengerDescription = itemView.findViewById(R.id.messengerDescription);
        }
    }
}
