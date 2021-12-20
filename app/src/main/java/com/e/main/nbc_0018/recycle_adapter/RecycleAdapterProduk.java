package com.e.main.nbc_0018.recycle_adapter;

import android.content.Context;
import android.content.Intent;
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

import java.util.List;

public class RecycleAdapterProduk  extends RecyclerView.Adapter<RecycleAdapterProduk.MyViewHolder>{
    private Context context;
    private List<produkDao> result;

    public RecycleAdapterProduk(Context context, List<produkDao> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.recycle_adapter_produk,parent,false);
        final MyViewHolder holder = new MyViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapterProduk.MyViewHolder myViewHolder, int position) {
        final produkDao produk = result.get(position);
        myViewHolder.tNama.setText(produk.getNama_prd());
        myViewHolder.tHarga.setText("Rp "+produk.getHarga_prd());
        myViewHolder.tStok.setText(produk.getStok_prd());
        myViewHolder.tUkuran.setText(produk.getUkuran_prd()+" "+produk.getSatuan_prd());
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tNama,tHarga,tStok,tUkuran;
        private LinearLayout mParent;
        private final Context context;
        private CardView cardView;

        public MyViewHolder(@NonNull final View itemView){
            super(itemView);
            tNama=itemView.findViewById(R.id.nama_produk_text);
            tHarga=itemView.findViewById(R.id.harga_produk_text);
            tStok=itemView.findViewById(R.id.stok_produk_text);
            tUkuran=itemView.findViewById(R.id.ukuran_produk_text);
            mParent=itemView.findViewById(R.id.produk_content);
            cardView =itemView.findViewById(R.id.card_produk);
            context = itemView.getContext();
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(context, "Hai", Toast.LENGTH_SHORT).show();
        }
    }


}
