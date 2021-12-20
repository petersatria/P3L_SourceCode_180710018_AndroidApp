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

import com.e.main.nbc_0018.api.ApiClient;
import com.e.main.nbc_0018.api.ApiInterface;
import com.e.main.nbc_0018.dao.jadwalDao;
import com.e.main.nbc_0018.dao.promoDao;
import com.e.main.nbc_0018.recycle_adapter.RecycleAdapterJadwal;
import com.e.main.nbc_0018.recycle_adapter.RecycleAdapterPromo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JadwalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JadwalFragment extends Fragment {
    private List<jadwalDao> jadwals;
    private RecycleAdapterJadwal recycleAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public JadwalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JadwalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static JadwalFragment newInstance(String param1, String param2) {
        JadwalFragment fragment = new JadwalFragment();
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
        View view = inflater.inflate(R.layout.fragment_jadwal, container, false);
        jadwals = new ArrayList<>();
        recyclerView=view.findViewById(R.id.jadwal_recycle_view);
        recycleAdapter=new RecycleAdapterJadwal(getContext(),jadwals);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recycleAdapter);
        this.initJadwal();
        return view;
    }



    private void initJadwal(){
        try {
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Call<List<jadwalDao>> jadwalDaoCall = apiService.viewAllJadwal();
            jadwalDaoCall.enqueue(new Callback<List<jadwalDao>>() {
                @Override
                public void onResponse(Call<List<jadwalDao>> call, Response<List<jadwalDao>> response) {
                    if(response.body()!=null){
                        jadwals.addAll(response.body());
                        recycleAdapter.notifyDataSetChanged();

                    }
                }

                @Override
                public void onFailure(Call<List<jadwalDao>> call, Throwable t) {
                    Log.d("error message", String.valueOf(t));
                }
            });
        }catch (Exception e){
            Log.d("produk get", "onCreate: error");
        }
    }
}