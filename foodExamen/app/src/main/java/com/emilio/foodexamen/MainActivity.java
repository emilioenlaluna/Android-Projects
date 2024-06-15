package com.emilio.foodexamen;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FoodAdapter adapter;
    private List<FoodModel> foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        foodList = new ArrayList<>();
        foodList.add(new FoodModel(R.drawable.food1, "Pizza", "Deliciosa pizza italiana"));
        foodList.add(new FoodModel(R.drawable.food2, "Hamburguesa", "Jugosa hamburguesa con queso"));
        foodList.add(new FoodModel(R.drawable.food3, "Ensalada", "Ensalada fresca y saludable"));
        foodList.add(new FoodModel(R.drawable.food4, "Sushi", "Rollos de sushi con arroz y pescado fresco"));

        adapter = new FoodAdapter(this, foodList);
        recyclerView.setAdapter(adapter);
    }
}
