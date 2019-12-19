package com.example.fruit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        FruitAdapter adapter=new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);
        ListView listView=(ListView) findViewById(R.id.List_view);
        listView.setAdapter(adapter);
        }
        private void initFruits(){
        for(int i=0;i<2;i++){
            Fruit apple=new  Fruit("Apple",R.drawable.apple_pic);
            fruitList.add(apple);
            Fruit banana=new  Fruit("Banana",R.drawable.banana_pic);
            fruitList.add(banana);
            Fruit orange=new  Fruit("orange",R.drawable.orange_pic);
            fruitList.add(orange);
            Fruit watermelon=new  Fruit("watermelon",R.drawable.watermelon_pic);
            fruitList.add(watermelon);
            Fruit pear=new  Fruit("pear",R.drawable.pear_pic);
            fruitList.add(pear);
            Fruit grape=new  Fruit("grape",R.drawable.grape_pic);
            fruitList.add(grape);
            Fruit pineapple=new  Fruit("pineapple",R.drawable.pineapple_pic);
            fruitList.add(pineapple);
            Fruit cherry=new  Fruit("cherry",R.drawable.cherry_pic);
            fruitList.add(cherry);
            }
        }
    }

