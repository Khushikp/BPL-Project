package com.example.bpl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bpl.databinding.ActivitySeeMore2Binding;

import java.util.ArrayList;

public class SeeMore2 extends AppCompatActivity {


    @NonNull ActivitySeeMore2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySeeMore2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.profile1,R.drawable.profile2,R.drawable.profile3,R.drawable.profile4,R.drawable.profile5,R.drawable.profile6,R.drawable.profile7,R.drawable.profile8,R.drawable.profile9,R.drawable.profile10};
        String[] name = {"James", "George","Abigail","Mary","Nick","Ella","Abby","Leo", "Julian", "Nicolas"};
        String[] email = {"jamesanderson@gmail.com", "georgewalker@gmail.com", "abigailsteven@gmail.com", "marysophia@gmail.com","nicklewis@gmail.com", "ellaburton@gmail.com", "abbywalker@gmail.com", "leorobinson@gmail.com", "julianjones@gmail.com", "nicolssmith@gmail.com"};
        String[] phone = {"8975641215","8945671215","8975641215","7896541235","4563284965","8975422865","9876884965","1254897632","7654213098","7654213098" };
        String[] gender = {"Male","Male", "Female","Female","Male","Female","Male","Male","Female","Male"};
        String[] address = {"ABC","ABC","ABC","ABC","ABC","ABC","ABC","ABC","ABC","ABC"};
        String[] city = {"Rome","NewYork","England","Rajkot","Toronto","Sydney","Wuhan","Nyon","Hatta","Male"};
        String[] pincode ={"123456","360064","123098","123098","209833","360002","370003","987654","659922","345005"};
        String[] country = {"Italy", "United States", "United Kingdom", "India", "Canada", "Australia","China", "Switzerland","Dubai","Maldives"};

        ArrayList<User> userArrayList = new ArrayList<>();

        for (int i = 0; i < imageId.length; i++)
        {
            User user = new User(name[i], email[i], phone[i],imageId[i],gender[i],address[i],city[i],pincode[i],country[i]
            );
            userArrayList.add(user);
        }

        ListAdapter listAdapter = new ListAdapter(SeeMore2.this, userArrayList);

      binding.listview.setAdapter(listAdapter);
      binding.listview.setClickable(true);
      binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(SeeMore2.this,UserActivity.class);
               intent.putExtra("name",name[position]);
                intent.putExtra("email",email[position]);
                intent.putExtra("phone",phone[position]);
                intent.putExtra("gender",gender[position]);
                intent.putExtra("address",address[position]);
                intent.putExtra("city",city[position]);
                intent.putExtra("pincode",pincode[position]);
                intent.putExtra("country",country[position]);
                startActivity(intent);

         }
      });
    }
}