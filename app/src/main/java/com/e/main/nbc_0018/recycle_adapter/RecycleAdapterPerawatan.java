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
import com.e.main.nbc_0018.dao.perawatanDao;
import com.e.main.nbc_0018.dao.produkDao;

import java.util.List;

public class RecycleAdapterPerawatan  extends RecyclerView.Adapter<RecycleAdapterPerawatan.MyViewHolder>{
    private Context context;
    private List<perawatanDao> result;

    public RecycleAdapterPerawatan(Context context, List<perawatanDao> result){
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.recycle_adapter_perawatan,parent,false);
        final RecycleAdapterPerawatan.MyViewHolder holder = new RecycleAdapterPerawatan.MyViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapterPerawatan.MyViewHolder myViewHolder, int position) {
        final perawatanDao perwatan = result.get(position);
        myViewHolder.tNama.setText(perwatan.getNama_prw());
        myViewHolder.tHarga.setText("Rp "+perwatan.getHarga_prw());
        myViewHolder.tDeskripsi.setText(perwatan.getDeskripsi_prw());
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tNama,tHarga,tDeskripsi;
        private LinearLayout mParent;
        private final Context context;
        private CardView cardView;

        public MyViewHolder(@NonNull final View itemView){
            super(itemView);
            tNama=itemView.findViewById(R.id.nama_perawatan_text);
            tHarga=itemView.findViewById(R.id.harga_perawatan_text);
            tDeskripsi=itemView.findViewById(R.id.deskripsi_perawatan_text);
            mParent=itemView.findViewById(R.id.perawatan_content);
            cardView =itemView.findViewById(R.id.card_perawatan);
            context = itemView.getContext();
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(context, "Hai", Toast.LENGTH_SHORT).show();
        }
    }

}
