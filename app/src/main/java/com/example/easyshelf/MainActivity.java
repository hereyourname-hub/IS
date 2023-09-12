package com.example.easyshelf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);



        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Создать ActionBarDrawerToggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.home);
        }

        // Установить слушатель для DrawerLayout
        drawerLayout.addDrawerListener(toggle);

        // Синхронизировать состояние DrawerLayout с иконкой "гамбургера"
        toggle.syncState();



        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = auth.getCurrentUser();

        if (currentUser == null){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        // Инициализация TextView с идентификатором currentUser
        TextView currentUserTextView = navigationView.getHeaderView(0).findViewById(R.id.currentUser);

        if (currentUser != null) {
            String email = currentUser.getEmail();

            // Установка email в TextView
            currentUserTextView.setText(email);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId(); // Получить идентификатор элемента меню

        if (itemId == R.id.home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
        }else if (itemId == R.id.logout) {
            // Выполните выход пользователя из Firebase
            FirebaseAuth.getInstance().signOut();

            // Переход на экран входа (например, LoginActivity)
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }else if (itemId == R.id.about_us) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new AboutUsFragment()).commit();
        }


        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout); // Инициализация переменной drawerLayout
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}