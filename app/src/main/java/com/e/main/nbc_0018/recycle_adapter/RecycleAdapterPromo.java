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
import com.e.main.nbc_0018.dao.produkDao;
import com.e.main.nbc_0018.dao.promoDao;

import java.util.List;

public class RecycleAdapterPromo extends RecyclerView.Adapter<RecycleAdapterPromo.MyViewHolder>{
    private Context context;
    private List<promoDao> result;

    public RecycleAdapterPromo(Context context, List<promoDao> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.recycle_adapter_promo,parent,false);
        final RecycleAdapterPromo.MyViewHolder holder = new RecycleAdapterPromo.MyViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapterPromo.MyViewHolder myViewHolder, int position) {
        final promoDao promo = result.get(position);
        myViewHolder.tNama.setText(promo.getNama_promo());
        myViewHolder.tKode.setText(promo.getKode_promo());
        myViewHolder.tDiskon.setText("Potongan : "+ (Float.parseFloat(promo.getDiskon())*100) + "%");
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tNama,tKode,tDiskon;
        private LinearLayout mParent;
        private final Context context;
        private CardView cardView;

        public MyViewHolder(@NonNull final View itemView){
            super(itemView);
            tNama=itemView.findViewById(R.id.nama_promo_text);
            tKode=itemView.findViewById(R.id.kode_promo_text);
            tDiskon=itemView.findViewById(R.id.diskon_promo_text);
            mParent=itemView.findViewById(R.id.promo_content);
            cardView =itemView.findViewById(R.id.card_promo);
            context = itemView.getContext();
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(context, "Hai", Toast.LENGTH_SHORT).show();
        }
    }
}
