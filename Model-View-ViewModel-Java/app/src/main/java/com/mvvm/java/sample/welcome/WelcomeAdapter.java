package com.mvvm.java.sample.welcome;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mvvm.java.core.base.BaseViewHolder;
import com.mvvm.java.databinding.ItemWelcomeBinding;

import java.util.List;

public class WelcomeAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final List<Welcome> welcomes;

    public WelcomeAdapter(List<Welcome> welcomes) {
        this.welcomes = welcomes;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemWelcomeBinding binding = ItemWelcomeBinding.inflate(inflater, parent, false);
        return new WelcomeAdapter.WelcomeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (welcomes != null) {
            return welcomes.size();
        }
        return 0;
    }

    class WelcomeViewHolder extends BaseViewHolder {
        private final ItemWelcomeBinding binding;

        public WelcomeViewHolder(@NonNull ItemWelcomeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);
            Welcome item = welcomes.get(position);
            this.binding.image.setImageResource(item.getImage());
            this.binding.headline.setText(item.getHeadline());
            this.binding.description.setText(item.getDescription());
        }

        @Override
        protected void clear() {
        }
    }
}