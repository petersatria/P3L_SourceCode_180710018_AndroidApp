package com.e.main.nbc_0018.recycle_adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.e.main.nbc_0018.R;
import com.e.main.nbc_0018.dao.jadwalDao;
import com.e.main.nbc_0018.dao.promoDao;

import java.util.List;

public class RecycleAdapterJadwal extends RecyclerView.Adapter<RecycleAdapterJadwal.MyViewHolder>{
    private Context context;
    private List<jadwalDao> result;

    public RecycleAdapterJadwal(Context context, List<jadwalDao> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.recycle_adapter_jadwal,parent,false);
        final RecycleAdapterJadwal.MyViewHolder holder = new RecycleAdapterJadwal.MyViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapterJadwal.MyViewHolder myViewHolder, int position) {

        final jadwalDao jadwal = result.get(position);
        myViewHolder.tNama.setText(jadwal.getNama_pegawai());
        myViewHolder.tHari.setText(jadwal.getHari());
        myViewHolder.tjam.setText("Jam : "+ jadwal.getJam_mulai().substring(0,5) + " - " + jadwal.getJam_selesai().substring(0,5));

    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tNama,tHari,tjam;
        private LinearLayout mParent;
        private final Context context;
        private CardView cardView;

        public MyViewHolder(@NonNull final View itemView){
            super(itemView);
            tNama=itemView.findViewById(R.id.nama_jadwal_text);
            tHari=itemView.findViewById(R.id.hari_jadwal_text);
            tjam=itemView.findViewById(R.id.jam_jadwal_text);
            mParent=itemView.findViewById(R.id.jadwal_content);
            cardView =itemView.findViewById(R.id.card_jadwal);
            context = itemView.getContext();
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(context, "Hai", Toast.LENGTH_SHORT).show();
        }
    }
}
