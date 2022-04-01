package com.example.bica;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bica.member.LoginActivity;

public class SettingFragment extends Fragment {

    private Toolbar tb_setting;
    private ListView lv_setting;

    public SettingFragment() {
        // Required empty public constructor
    }
    public static SettingFragment newInstance() {
        SettingFragment fragment = new SettingFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        //Fragment에서 Toolbar 셋업
        tb_setting = view.findViewById(R.id.tb_setting);
        lv_setting = view.findViewById(R.id.listview);

        tb_setting.setTitle(null);
        final String[] mid = {"공지사항", "도움말", "비밀번호 변경", "로그아웃"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, mid);
        lv_setting.setAdapter(adapter);

        lv_setting.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //switch ()
                switch (i){
                    case 0:
                        Intent startNoticeActivity = new Intent(getContext(), NoticeActivity.class);
                        startActivity(startNoticeActivity);
                        break;
                    case 1:
                        Intent startHelpActivity = new Intent(getContext(), HelpActivity.class);
                        startActivity(startHelpActivity);
                        break;
                    case 2:
                        Intent startEditInfoActivity = new Intent(getContext(), EditInfoActivity.class);
                        startActivity(startEditInfoActivity);
                        break;
                    case 3:
                        new AlertDialog.Builder(getContext())
                                .setTitle("로그아웃").setMessage("로그아웃 하시겠습니까?")
                                .setPositiveButton("로그아웃", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent intent = new Intent(getContext(), InitialActivity.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                                        startActivity(intent);
                                    }
                                })
                                .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                })
                                .show();
                        break;

                }
            }
        });

       return view;
    }

}