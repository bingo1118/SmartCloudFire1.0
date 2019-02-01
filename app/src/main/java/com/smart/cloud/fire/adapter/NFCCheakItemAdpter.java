package com.smart.cloud.fire.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.smart.cloud.fire.global.NFCCheakItem;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import fire.cloud.smart.com.smartcloudfire.R;

/**
 * Created by Rain on 2019/1/15.
 */
public class NFCCheakItemAdpter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<NFCCheakItem> data;

    //构造器，接受数据集
    public NFCCheakItemAdpter(List<NFCCheakItem> data) {
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nfc_cheak_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        //将数据填充到具体的view中
        NFCCheakItem item=data.get(position);
        ((MyViewHolder)holder).itemname.setText(item.getItemname());

        // 如果设置了回调，则设置点击事件
        if (mOnItemChangeListener != null) {
            ((MyViewHolder)holder).radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    int radioButtonId = group.getCheckedRadioButtonId();
                    switch (radioButtonId){
                        case R.id.radio1:
                            mOnItemChangeListener.onItemChangeClick(position,true);
                            break;
                        case R.id.radio2:
                            mOnItemChangeListener.onItemChangeClick(position,false);
                            break;
                    }
                }
            });
        }
    }



    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.itemName_text)
        TextView itemname;
        @Bind(R.id.radio_group)
        RadioGroup radio_group;
        @Bind(R.id.radio1)
        RadioButton radio1;
        @Bind(R.id.radio2)
        RadioButton radio2;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    /**
     * 定义接口回调
     */
    public interface OnItemChangeListener {
        void onItemChangeClick(int position,boolean state);
    }

    private OnItemChangeListener mOnItemChangeListener;

    public void setOnItemChangeListener(OnItemChangeListener listener) {
        this.mOnItemChangeListener = listener;
    }
}


