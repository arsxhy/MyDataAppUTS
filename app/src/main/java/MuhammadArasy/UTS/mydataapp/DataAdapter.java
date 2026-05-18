package MuhammadArasy.UTS.mydataapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class DataAdapter extends ArrayAdapter<UserData> {

    public DataAdapter(@NonNull Context context, @NonNull List<UserData> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_data, parent, false);
        }

        UserData data = getItem(position);

        TextView tvNama = convertView.findViewById(R.id.tvItemNama);
        TextView tvNimProdi = convertView.findViewById(R.id.tvItemNimProdi);
        TextView tvDetail = convertView.findViewById(R.id.tvItemDetail);

        if (data != null) {
            tvNama.setText(data.getNama());
            tvNimProdi.setText(data.getNim() + " - " + data.getProdi());
            tvDetail.setText("Kelas: " + data.getKelas() + " | Email: " + data.getEmail());
        }

        return convertView;
    }
}