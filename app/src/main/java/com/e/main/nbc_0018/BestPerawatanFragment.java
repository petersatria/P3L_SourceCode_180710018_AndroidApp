package com.e.main.nbc_0018;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
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
import com.e.main.nbc_0018.dao.perawatanDao;
import com.e.main.nbc_0018.recycle_adapter.RecycleAdapterPerawatan;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BestPerawatanFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BestPerawatanFragment extends Fragment {

    private List<perawatanDao> perawatans;
    private RecycleAdapterPerawatan recycleAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Button backBtn;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BestPerawatanFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BestPerawatanFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BestPerawatanFragment newInstance(String param1, String param2) {
        BestPerawatanFragment fragment = new BestPerawatanFragment();
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
        View view = inflater.inflate(R.layout.fragment_best_perawatan, container, false);
        perawatans = new ArrayList<>();
        backBtn = (Button) view.findViewById(R.id.perawatan_back_btn);
        recyclerView=view.findViewById(R.id.perawatan_recycle_view);
        recycleAdapter=new RecycleAdapterPerawatan(getContext(),perawatans);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recycleAdapter);
        this.initPerawatan();
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_bestPerawatanFragment_to_perawatanFragment);
            }
        });
        return view;
    }

    private void initPerawatan(){
        try {
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            java.util.Date date= new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int month = cal.get(Calendar.MONTH);
            int year = cal.get(Calendar.YEAR);
            Call<List<perawatanDao>> perawtanDaoCall = apiService.viewBestPerawatan(String.valueOf(year),String.valueOf(month));
            perawtanDaoCall.enqueue(new Callback<List<perawatanDao>>() {
                @Override
                public void onResponse(Call<List<perawatanDao>> call, Response<List<perawatanDao>> response) {
                    if(response.body()!=null){
                        perawatans.addAll(response.body());
                        recycleAdapter.notifyDataSetChanged();

                    }
                }

                @Override
                public void onFailure(Call<List<perawatanDao>> call, Throwable t) {
                    Log.d("error message", String.valueOf(t));
                }
            });
        }catch (Exception e){
            Log.d("produk get", "onCreate: error");
        }
    }
}