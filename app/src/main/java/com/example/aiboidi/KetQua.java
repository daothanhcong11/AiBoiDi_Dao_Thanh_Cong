package com.example.aiboidi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.aiboidi.adapters.BoiAdapter;
import com.example.aiboidi.models.BoiData;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class KetQua extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ket_qua);

        Map <Character, String> data = new HashMap<Character, String>();
        data.put('a',"Vui tính vãi lúa :v");
        data.put('ă',"Chân thành này ");
        data.put('â',"Gan dạ nhé ");
        data.put('b',"Phong lưu -_-");
        data.put('c',"Chảnhhhh @@ ");
        data.put('d',"Đẹp *.* ");
        data.put('đ',"Ngố :p ");
        data.put('ê',"Chăm chỉ (y)");
        data.put('g',"Gan dạ nhé ");
        data.put('h',"Ngây thơ lắm !!!");
        data.put('i',"Đa Tài");
        data.put('k',"Đua Đòi  ");
        data.put('l',"Nhân hậu");
        data.put('m',"Hiền lành  ");
        data.put('n',"Mũm mĩn thôi rồi ");
        data.put('o',"ế rồi");
        data.put('ơ',"Nhiệt tình");
        data.put('ô',"Nhát chết");
        data.put('p',"Thông minh");
        data.put('q',"Đanh đá");
        data.put('r',"Gỉa tạo ");
        data.put('s',"Ngốc :((");
        data.put('t',"Ít nói");
        data.put('u',"Dê Xồm -__-");
        data.put('ư',"Tài giỏi ");
        data.put('v',"Hài hước");
        data.put('x',"Ham vui");
        data.put('y',"Đa Tình ");
        Set<Character> set = data.keySet();  // trả về đối tượng set chứa tất cả các key
        // get data
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        //show data
        TextView textView3 =findViewById(R.id.textView3);
        textView3.setText("Quẻ tên :"+ name + " !");

        TextView textView4 =findViewById(R.id.textView4);
        textView4.setText(name +" ấy à? Để xem nào: ");

        ArrayList<BoiData> boidatas = new ArrayList<>(); //tạo arraylist để chứa các value lấy được từ tên Map.

        // sử lí chuỗi
        name=name.trim();// xóa các khoảng trắng.
        name=name.toLowerCase(); // chuyển các kí tự viết hoa sang viết thường.

        char [] arr = name.toCharArray();

        /*   xóa kí tự trùng nhau
        duyệt 1 lần xét từng phần tử nếu phần tử nào chưa xuất hiện cho vào mảng mới.
        nếu đã có trong mảng mới thì bỏ qua.
        mỗi lần thêm phần tử vào mảng mới tăng biến đếm. */

        int n =name.length();
        char [] brr= new char[n]; // nếu k có kí tự trùng nhau thì mảng mới vẫn chứa n phần tử
        int bSize=0;
        boolean isExist=false; // biến kiểm tra giám sát
        for (int i = 0 ; i<n; i++){
            isExist =false; // gán lại isExist bằng false sau vòng for trong chạy hết 1 lần
            for(int j = 0 ; j<n;j++){
                if (arr[i]==brr[j]){
                    isExist =true;
                    break;
                }

            }
            if ( !isExist ){   // nếu phần tử arr[i] chưa có mặt trong brr[j] thì thêm vào brr[] tại vị trí bSize
                brr[bSize++]=arr[i];
            }

        }

        //quá trình sử lí chuỗi thu được mảng kí tự brr clean





        // duyệt và so sánh kí tự 2  mảng  (chr và set)
        for (int i = 0; i< brr.length;i++){
              for (Character key : set) {
                  if (key==brr[i]){
                      boidatas.add(new BoiData(data.get(key)));
                  }
              }
        }

        RecyclerView recyclerView = findViewById(R.id.rv);
        BoiAdapter adapter = new BoiAdapter(boidatas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}