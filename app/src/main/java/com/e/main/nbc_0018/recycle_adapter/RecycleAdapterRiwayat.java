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
import com.e.main.nbc_0018.dao.promoDao;
import com.e.main.nbc_0018.dao.riwayatDao;

import java.util.List;

public class RecycleAdapterRiwayat extends RecyclerView.Adapter<RecycleAdapterRiwayat.MyViewHolder>{
    private Context context;
    private List<riwayatDao> result;

    public RecycleAdapterRiwayat(Context context, List<riwayatDao> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.recycle_adapter_riwayat,parent,false);
        final RecycleAdapterRiwayat.MyViewHolder holder = new RecycleAdapterRiwayat.MyViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapterRiwayat.MyViewHolder myViewHolder, int position) {
        final riwayatDao riwayat = result.get(position);
        myViewHolder.tTotal.setText("Rp " + riwayat.getTotal());
        myViewHolder.tKode.setText(riwayat.getKode_transaksi());
        myViewHolder.tTgl.setText("Tanggal Transaksi : "+riwayat.getTgl_transaksi());
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tTotal,tKode,tTgl;
        private LinearLayout mParent;
        private final Context context;
        private CardView cardView;

        public MyViewHolder(@NonNull final View itemView){
            super(itemView);
            tKode=itemView.findViewById(R.id.kode_riwayat_text);
            tTgl=itemView.findViewById(R.id.tgl_riwayat_text);
            tTotal=itemView.findViewById(R.id.total_riwayat_text);
            mParent=itemView.findViewById(R.id.riwayat_content);
            cardView =itemView.findViewById(R.id.card_riwayat);
            context = itemView.getContext();
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(context, "Hai", Toast.LENGTH_SHORT).show();
        }
    }


}
