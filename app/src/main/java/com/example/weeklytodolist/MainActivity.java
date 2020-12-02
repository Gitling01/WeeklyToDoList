package com.example.weeklytodolist;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Section> sectionList = new ArrayList<>();
    RecyclerView mainRecyclerView;

    ArrayList<String> sectionOneItems = new ArrayList<>();
    ArrayList<String> sectionTwoItems = new ArrayList<>();
    ArrayList<String> sectionThreeItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        mainRecyclerView = findViewById(R.id.mainRecyclerView);
        MainRecyclerAdapter mainRecyclerAdapter = new MainRecyclerAdapter(sectionList);
        mainRecyclerView.setAdapter(mainRecyclerAdapter);
        mainRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                //Toast.makeText(MainActivity.this, "Hiii", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Add a New Task");
                final EditText input = new EditText(MainActivity.this);
                builder.setView(input);

                final String[] days = new String[]{"monday", "tuesday", "wednesday", "thursday", "friday"};
                final boolean[] checkedItems = new boolean[]{true, false, false, true, false};

                //final List<String> daysList = Arrays.asList(days);

                builder.setMultiChoiceItems(days, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checkedItems[which] = isChecked;
                        String currentItem = days[which];

                    }
                });

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(MainActivity.this, "Wassup", Toast.LENGTH_SHORT).show();

                        int i = 0;

                        for (i, i <= checkedItems.length, i++) {
                            checkedItems[i]
                            String newString = days[i];

                            if (i == 0) {
                                sectionOneItems.add(days[i]);
                            }

                            if (i == 1) {
                                sectionTwoItems.add(days[i]);
                            }

                            if (i == 2) {
                                sectionThreeItems.add(days[i]);
                            } else {
                                Toast.makeText(MainActivity.this, "This item is not for Mon-Wed", Toast.LENGTH_SHORT).show();
                            }

                        }

                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });


                builder.show();

            }
        });

    }

    private void initData() {

        String sectionOneName = "Monday";
        sectionOneItems.add("Put together equipment");
        sectionOneItems.add("Add different layout views");
        sectionOneItems.add("Look up insurance");

        String sectionTwoName = "Tuesday";
        sectionTwoItems.add("Create Sister Sister gifs");
        sectionTwoItems.add("Work out");

        String sectionThreeName = "Wednesday";
        sectionThreeItems.add("Buy Thanksgiving groceries");
        sectionThreeItems.add("Zoom with family");
        sectionThreeItems.add("Maybe nap");
        sectionThreeItems.add("Do more stuff");

        String sectionFourName = "Thursday";
        ArrayList<String> sectionFourItems = new ArrayList<>();
        sectionFourItems.add("Buy soap");
        sectionFourItems.add("Take a walk");
        sectionFourItems.add("Read");

        String sectionFiveName = "Friday";
        ArrayList<String> sectionFiveItems = new ArrayList<>();
        sectionFiveItems.add("Celebrate TGIF");
        sectionFiveItems.add("Order food");
        sectionFiveItems.add("Work on app");

        sectionList.add(new Section(sectionOneName, sectionOneItems));
        sectionList.add(new Section(sectionTwoName, sectionTwoItems));
        sectionList.add(new Section(sectionThreeName, sectionThreeItems));
        sectionList.add(new Section(sectionFourName, sectionFourItems));
        sectionList.add(new Section(sectionFiveName, sectionFiveItems));
    }

}