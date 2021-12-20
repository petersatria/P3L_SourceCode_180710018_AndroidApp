package com.e.main.nbc_0018;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.e.main.nbc_0018.api.ApiClient;
import com.e.main.nbc_0018.api.ApiInterface;
import com.e.main.nbc_0018.dao.customerDao;
import com.e.main.nbc_0018.dao.produkDao;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserProfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserProfilFragment extends Fragment {

    private customerDao customerDao;
    private TextView tNama,tPoin;
    private Button logoutBtn,riwayatBtn;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UserProfilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserProfilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserProfilFragment newInstance(String param1, String param2) {
        UserProfilFragment fragment = new UserProfilFragment();
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
        View view = inflater.inflate(R.layout.fragment_user_profil, container, false);
        customerDao = new customerDao();
        tNama = view.findViewById(R.id.nama_customer);
        tPoin = view.findViewById(R.id.poin_customer);
        logoutBtn = view.findViewById(R.id.logoutBtn);
        riwayatBtn = view.findViewById(R.id.riwayatBtn);
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        customerDao.setKode_cust(sharedPref.getString("kode_cust", null));
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<customerDao> customerDaoCall = apiService.get(customerDao.getKode_cust());
        customerDaoCall.enqueue(new Callback<customerDao>() {
            @Override
            public void onResponse(Call<customerDao> call, Response<customerDao> response) {
                if(response.body()!=null){
                    customerDao = response.body();
                    tNama.setText(customerDao.getNama_cust());
                    tPoin.setText(customerDao.getPoin_cust());

                }
            }

            @Override
            public void onFailure(Call<customerDao> call, Throwable t) {
                Log.d("error message", String.valueOf(t));
            }
        });

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.clear();
                editor.apply();
                Navigation.findNavController(view).navigate(R.id.action_userProfilFragment_to_akunFragment);

            }
        });

        riwayatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_userProfilFragment_to_riwayatFragment);
            }
        });

        return view;
    }
}