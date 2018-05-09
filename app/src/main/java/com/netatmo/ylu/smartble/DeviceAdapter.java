package com.netatmo.ylu.smartble;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.netatmo.ylu.smart_ble.BleDevice;

import java.util.List;

public class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.BleDeviceHolder> {

    private Context context;
    private List<BleDevice> list;

    public DeviceAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public BleDeviceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.list_item,parent);
        return new BleDeviceHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull BleDeviceHolder holder, int position) {
        BleDevice bleDevice = list.get(position);
        holder.name.setText(bleDevice.getName());
        holder.deviceId.setText(bleDevice.getMacAddress());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setDevices(List<BleDevice> bleDevices){
        this.list = bleDevices;
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
