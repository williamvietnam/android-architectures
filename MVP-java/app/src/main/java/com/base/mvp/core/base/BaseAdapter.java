package com.base.mvp.core.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.DrawableRes;
import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.base.mvp.core.utilities.AppLogger;
import com.base.mvp.core.utilities.StringUtils;
import com.base.mvp.databinding.ItemListHeaderBinding;
import com.base.mvp.databinding.ItemLoadMoreBinding;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {
    public static final int LOAD_MORE = 0;
    public static final int HEADER = 1;
    public static final int DATA = 2;

    @IntDef({LOAD_MORE, HEADER, DATA})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ITEM_TYPE {
    }

    protected Context context;
    protected List<BaseAdapterModel<T>> itemList;
    protected ItemClickListener<T> itemClickListener;

    public BaseAdapter(AppCompatActivity activityContext) {
        this.context = activityContext;
        this.itemList = new ArrayList<>();
    }

    public void setItemClickListener(ItemClickListener<T> itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void reset() {
        this.itemList.clear();
        notifyDataSetChanged();
    }

    public List<T> getData() {
        List<T> data = new ArrayList<>();
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).type == DATA) {
                data.add(itemList.get(i).data);
            }
        }
        return data;
    }

    public void addHeader(Header header) {
        itemList.add(new BaseAdapterModel<>(header));
        notifyItemInserted(itemList.size() - 1);
    }

    public void addLoadMore() {
        itemList.add(new BaseAdapterModel<>());
        notifyItemInserted(itemList.size() - 1);
    }

    public void removeLoadMore() {
        if (!itemList.isEmpty() && itemList.get(itemList.size() - 1).type == LOAD_MORE) {
            itemList.remove(itemList.size() - 1);
            notifyItemRemoved(itemList.size());
        }
    }

    public void addData(List<T> dataList) {
        for (T data : dataList) {
            itemList.add(new BaseAdapterModel<>(data));
        }
        notifyItemRangeInserted(itemList.size() - dataList.size(), dataList.size());
    }

    public void add(T data) {
        itemList.add(new BaseAdapterModel<>(data));
        notifyItemInserted(itemList.size() - 1);
    }

    public void remove(int position) {
        if (!itemList.isEmpty()) {
            itemList.remove(position);
        }
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, getItemCount());
    }

    @Override
    public int getItemViewType(int position) {
        return itemList.get(position).type;
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == HEADER) {
            ItemListHeaderBinding binding = ItemListHeaderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new HeaderViewHolder(binding);
        } else if (viewType == LOAD_MORE) {
            ItemLoadMoreBinding binding = ItemLoadMoreBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new LoadMoreViewHolder(binding);
        } else {    // DATA
            return createDataView(parent);
        }
    }

    protected abstract BaseViewHolder createDataView(@NonNull ViewGroup parent);

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    public interface ItemClickListener<T> {
        void onItemClick(T item);

        void onAction1Click(Header item);

        void onAction2Click(Header item);
    }

    public static class Header {
        private String header;
        private String subHeader;
        private @DrawableRes
        int action1Res;
        private @DrawableRes
        int action2Res;

        public Header(String header, String subHeader, @DrawableRes int action1Res, @DrawableRes int action2Res) {
            this.header = header;
            this.subHeader = subHeader;
            this.action1Res = action1Res;
            this.action2Res = action2Res;
        }

        public String getHeader() {
            return header;
        }

        public String getSubHeader() {
            return subHeader;
        }

        public int getAction1Res() {
            return action1Res;
        }

        public int getAction2Res() {
            return action2Res;
        }
    }

    private static class LoadMoreViewHolder extends BaseViewHolder {
        ItemLoadMoreBinding binding;

        public LoadMoreViewHolder(ItemLoadMoreBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);
        }

        @Override
        protected void clear() {

        }
    }

    private class HeaderViewHolder extends BaseViewHolder {
        ItemListHeaderBinding viewBinding;

        public HeaderViewHolder(ItemListHeaderBinding viewBinding) {
            super(viewBinding.getRoot());
            this.viewBinding = viewBinding;
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);
            Header header = itemList.get(position).header;
            if (header != null) {
                if (StringUtils.isNullOrEmpty(header.getHeader())) {
                    viewBinding.tvHeader.setVisibility(View.GONE);
                } else {
                    viewBinding.tvHeader.setText(header.getHeader());
                    viewBinding.tvHeader.setVisibility(View.VISIBLE);
                }

                if (StringUtils.isNullOrEmpty(header.getSubHeader())) {
                    viewBinding.tvSubHeader.setVisibility(View.GONE);
                } else {
                    viewBinding.tvSubHeader.setText(header.getSubHeader());
                    viewBinding.tvSubHeader.setVisibility(View.VISIBLE);
                }

                if (header.getAction1Res() > 0) {
                    viewBinding.ivAction1.setImageResource(header.getAction1Res());
                    viewBinding.ivAction1.setOnClickListener(v -> itemClickListener.onAction1Click(header));
                    viewBinding.ivAction1.setVisibility(View.VISIBLE);
                } else {
                    viewBinding.ivAction1.setVisibility(View.GONE);
                }

                if (header.getAction2Res() > 0) {
                    viewBinding.ivAction2.setImageResource(header.getAction2Res());
                    viewBinding.ivAction2.setOnClickListener(v -> itemClickListener.onAction2Click(header));
                    viewBinding.ivAction2.setVisibility(View.VISIBLE);
                } else {
                    viewBinding.ivAction2.setVisibility(View.GONE);
                }
            } else {
                AppLogger.e("Item at position " + position + " is not a header");
            }
        }

        @Override
        protected void clear() {
            viewBinding.tvHeader.setVisibility(View.GONE);
            viewBinding.tvSubHeader.setVisibility(View.GONE);
            viewBinding.ivAction1.setVisibility(View.GONE);
            viewBinding.ivAction2.setVisibility(View.GONE);
        }
    }

    protected static class BaseAdapterModel<T> {
        private @ITEM_TYPE
        int type;
        private Header header;
        private T data;

        // Constructor for LOAD_MORE
        private BaseAdapterModel() {
            this.type = LOAD_MORE;
            this.header = null;
            this.data = null;
        }

        // Constructor for HEADER
        private BaseAdapterModel(@Nullable Header header) {
            this.type = HEADER;
            this.header = header;
            this.data = null;
        }

        // Constructor for DATA
        private BaseAdapterModel(T data) {
            this.type = DATA;
            this.header = null;
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }

}
