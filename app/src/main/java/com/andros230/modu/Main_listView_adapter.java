package com.andros230.modu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;


public class Main_listView_adapter extends BaseAdapter {
    private List<Map<String, Object>> data;
    private LayoutInflater mInflater;


    public Main_listView_adapter(Context context, List<Map<String, Object>> data) {
        this.data = data;
        this.mInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = mInflater.inflate(R.layout.main_listview_item, null);
            holder.name = (TextView) view.findViewById(R.id.main_listView_item_name);
            holder.time = (TextView) view.findViewById(R.id.main_listView_item_time);
            holder.add = (TextView) view.findViewById(R.id.main_listView_item_add);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.name.setText((String) data.get(i).get("name"));
        holder.time.setText((String) data.get(i).get("time"));
        holder.add.setText((String) data.get(i).get("add"));
        return view;
    }

    public class ViewHolder {
        public TextView name;
        private TextView time;
        private TextView add;
    }

}
