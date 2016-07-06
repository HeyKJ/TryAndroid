package com.example.adsw21.firstandroid;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

/**
 * Created by adsw2 on 2016-07-07.
 */
public class SearchStore_Command {
    private static SearchStore_Command searchStore_command = new SearchStore_Command();
    private SearchStore_Command(){}

    public static SearchStore_Command getInstance(){
        return searchStore_command;
    }

    public View getStoreList(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState, Toolbar toolbar, View search_storeView){
        final Toolbar bar = toolbar;
        //매장 주소 검색 결과 Table 생성
        final TableLayout store_list = (TableLayout) search_storeView.findViewById(R.id.store_list);
        //결과 Table Row 생성
        for(int i=0; i<10; i++){
            TableRow tr = new TableRow(search_storeView.getContext());
            //매장명 TextView
            TextView store_name = new TextView(search_storeView.getContext());
            store_name.setWidth(200);
            store_name.setHeight(250);
            store_name.setPaintFlags(store_name.getPaintFlags() | Paint.FAKE_BOLD_TEXT_FLAG);
            store_name.setTextColor(ContextCompat.getColor(search_storeView.getContext(), R.color.colorPrimaryDark));
            store_name.setText("종각점" + i);
            //매장주소 TextView
            TextView store_addr = new TextView(search_storeView.getContext());
            store_addr.setTextColor(ContextCompat.getColor(search_storeView.getContext(), R.color.colorPrimaryDark));
            store_addr.setText("서울 특별시 중구 을지로3가 101");
            //매장선택 Button
            Button select_store = new Button(search_storeView.getContext());
            select_store.setText("선택");
            //setBackground 빨간줄 신경안쓰셔도 됩니다. 정상 작동됨
            select_store.setBackground(ContextCompat.getDrawable(search_storeView.getContext(), R.drawable.select_store_btn));

            //해당 Row의 0, 1, 2번째 열에 각각 매장명, 매장주소, 매장선택 추가
            tr.addView(store_name, 0);
            tr.addView(store_addr, 1);
            tr.addView(select_store, 2);
            store_list.addView(tr);

            //매장선택 Button Click Listener
            select_store.setOnClickListener(new Button.OnClickListener(){
                public void onClick(View view){
                    //Click된 Button의 Row를 가져옴
                    TableRow tr = (TableRow)view.getParent();
                    //해당 Row의 매장명을 가져옴
                    TextView tv = (TextView)tr.getChildAt(0);
                    //상단 고객명 아래 매장명 이름을 선택한 매장명으로 바꿈
                    bar.setSubtitle(tv.getText().toString());
                }
            });
        }
        return search_storeView;
    }
}
