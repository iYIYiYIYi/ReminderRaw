package com.clarques.reminderraw.items;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.clarques.reminderraw.Adapter.TodoAdapter;
import com.clarques.reminderraw.R;
import com.clarques.reminderraw.types.PlanType;
import com.clarques.reminderraw.types.RemindFrequency;
import com.clarques.reminderraw.vo.plan;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link plan_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class plan_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public plan_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment plan_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static plan_fragment newInstance(String param1, String param2) {
        plan_fragment fragment = new plan_fragment();
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
        View view = inflater.inflate(R.layout.fragment_plan_fragment, container, false);

        return view;
    }

    /***
     * 随机产生TODO序列
     */
    private String[] names = {"锻炼","学习","工作","休息"};
    private void initRandomDataInList() {
        Random random = new Random(System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        String planName;
        for (int i = 0; i < 10; i++) {
            planName = names[random.nextInt(names.length)];
            list.add(new plan(planName,today,today, RemindFrequency.PER_DAY,1,"this is a plan", PlanType.values()[random.nextInt(PlanType.values().length)]));
        }
    }

    private List<plan> list;

    public void setPlanList(List<plan> list) {
        this.list = list;
    }

    public void setPlanList() {
        this.list = new ArrayList<>();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView plan_container = view.findViewById(R.id.planContainer);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        plan_container.setLayoutManager(manager);

        //添加随机数据
        setPlanList();initRandomDataInList();

        TodoAdapter todoAdapter = new TodoAdapter(list);
        plan_container.setAdapter(todoAdapter);
    }
}