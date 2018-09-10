package com.netatmo.ylu.smartble;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.netatmo.ylu.smartble.nap.Accessory;

import java.util.List;

public class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.BleDeviceHolder> {

    private Context context;
    private List<Accessory> list;

    public DeviceAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public BleDeviceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        return new BleDeviceHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull BleDeviceHolder holder, int position) {
        Accessory accessory = list.get(position);
        holder.name.setText(accessory.getName());
        holder.deviceId.setText(accessory.getAccessoryId());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setDevices(List<Accessory> bluetoothLEDevices){
        this.list = bluetoothLEDevices;
    }


    public class BleDeviceHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private TextView deviceId;

        public BleDeviceHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            deviceId = itemView.findViewById(R.id.mac);
        }
    }
}
