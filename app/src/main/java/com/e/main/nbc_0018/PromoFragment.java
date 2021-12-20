package com.e.main.nbc_0018;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.e.main.nbc_0018.api.ApiClient;
import com.e.main.nbc_0018.api.ApiInterface;
import com.e.main.nbc_0018.dao.produkDao;
import com.e.main.nbc_0018.dao.promoDao;
import com.e.main.nbc_0018.recycle_adapter.RecycleAdapterProduk;
import com.e.main.nbc_0018.recycle_adapter.RecycleAdapterPromo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PromoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PromoFragment extends Fragment {
    private List<promoDao> promos;
    private RecycleAdapterPromo recycleAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PromoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PromoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PromoFragment newInstance(String param1, String param2) {
        PromoFragment fragment = new PromoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_promo, container, false);
        promos = new ArrayList<>();
        recyclerView=view.findViewById(R.id.promo_recycle_view);
        recycleAdapter=new RecycleAdapterPromo(getContext(),promos);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recycleAdapter);
        this.initPromo();
        return view;
    }

    private void initPromo(){
        try {
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Call<List<promoDao>> promoDaoCall = apiService.viewAllPromo();
            promoDaoCall.enqueue(new Callback<List<promoDao>>() {
                @Override
                public void onResponse(Call<List<promoDao>> call, Response<List<promoDao>> response) {
                    if(response.body()!=null){
                        promos.addAll(response.body());
                        recycleAdapter.notifyDataSetChanged();

                    }
                }

                @Override
                public void onFailure(Call<List<promoDao>> call, Throwable t) {
                    Log.d("error message", String.valueOf(t));
                }
            });
        }catch (Exception e){
            Log.d("produk get", "onCreate: error");
        }
    }
}