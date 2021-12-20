package com.e.main.nbc_0018;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.e.main.nbc_0018.api.ApiClient;
import com.e.main.nbc_0018.api.ApiInterface;
import com.e.main.nbc_0018.dao.produkDao;
import com.e.main.nbc_0018.recycle_adapter.RecycleAdapterProduk;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PodukFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PodukFragment extends Fragment {

    private List<produkDao> produks;
    private RecycleAdapterProduk recycleAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Button bestBtn;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PodukFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PodukFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PodukFragment newInstance(String param1, String param2) {
        PodukFragment fragment = new PodukFragment();
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
        View view = inflater.inflate(R.layout.fragment_poduk, container, false);
        produks = new ArrayList<>();
        bestBtn = (Button) view.findViewById(R.id.produk_best_btn);
        recyclerView=view.findViewById(R.id.produk_recycle_view);
        recycleAdapter=new RecycleAdapterProduk(getContext(),produks);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recycleAdapter);
        this.initProduk();

        bestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_produkFragment_to_bestProdukFragment);
            }
        });

        return view;
    }

    private void initProduk(){
        try {
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Call<List<produkDao>> produkDaoCall = apiService.viewAllProduk();
            produkDaoCall.enqueue(new Callback<List<produkDao>>() {
                @Override
                public void onResponse(Call<List<produkDao>> call, Response<List<produkDao>> response) {
                    if(response.body()!=null){
                        produks.addAll(response.body());
                        recycleAdapter.notifyDataSetChanged();
                        Log.d("json", String.valueOf(produks.size()));

                    }
                }

                @Override
                public void onFailure(Call<List<produkDao>> call, Throwable t) {
                    Log.d("error message", String.valueOf(t));
                }
            });
        }catch (Exception e){
            Log.d("produk get", "onCreate: error");
        }
    }
}