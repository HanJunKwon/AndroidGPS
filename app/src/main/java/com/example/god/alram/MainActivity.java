package com.example.god.alram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String start, end;
    private EditText editText_start_search, editText_end_search;
    private ListView listView_placeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "GPS 설정은 '설정-연결-위치-사용 중(높은 정확도)'해야 정확한 위치를 파악할 수 있습니다.", Toast.LENGTH_LONG).show();
        setSearchArea();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    public void setSearchArea(){
        start=new String("");
        end=new String("");
        editText_start_search = (EditText) findViewById(R.id.start_search_bar);

        // 도착지 검색
        editText_start_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //텍스트를 입력하기 전에 call back
                //start 지점에서 사작되는 count갯수만큼의 글자들이 count 갯수만큼의 글자들로 대치되었을때 호출 된다.
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 텍스트가 변경 될 때마다 call back
            }

            @Override
            public void afterTextChanged(Editable s) {
                // 텍스트 입력이 모두 끝났을 때 call back
                start=editText_start_search.getText().toString();
                if(start.equals("")){
                    //출발지에 아무런 내용도 입력하지 않은 경우
                }
                else {
                    // 구글맵과 연동하여 유사한 단어의 장소를 아래 보여준다.
                }
            }
        });

        editText_end_search = (EditText) findViewById(R.id.end_search_bar);
        listView_placeList = (ListView)findViewById(R.id.place_list);
    }
}
