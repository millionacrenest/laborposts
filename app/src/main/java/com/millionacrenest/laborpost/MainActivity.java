package com.millionacrenest.laborpost;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

                startActivity(new Intent(MainActivity.this, MapsActivity.class));
            }
        });



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        added this

//        // Get ListView object from xml
//        final ListView listView = (ListView) findViewById(R.id.listView);
//
//        // Create a new Adapter
//        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1, android.R.id.text1);
//
//        // Assign adapter to ListView
//        listView.setAdapter(adapter);
//
//        // Connect to the Firebase database
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//
//        // Get a reference to the todoItems child items it the database
//        final DatabaseReference myRef = database.getReference("frontpage");
//
//        // Assign a listener to detect changes to the child items
//        // of the database reference.
//        myRef.addChildEventListener(new ChildEventListener(){
//
//            // This function is called once for each child that exists
//            // when the listener is added. Then it is called
//            // each time a new child is added.
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
//
//
//                Post post = dataSnapshot.getValue(Post.class);
//
//                String title = post.getTitle();
//                String body = post.getBody();
//                String posts = title + body;
//
//                System.out.println(posts);
//
//
//
//                adapter.add(title);
//
//
//            }
//
//            // This function is called each time a child item is removed.
//            public void onChildRemoved(DataSnapshot dataSnapshot){
//                String value = dataSnapshot.getValue(String.class);
//                adapter.remove(value);
//            }
//
//            // The following functions are also required in ChildEventListener implementations.
//            public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName){}
//            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName){}
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w("TAG:", "Failed to read value.", error.toException());
//            }
//        });
//
//        // Add items via the Button and EditText at the bottom of the window.
////        final EditText text = (EditText) findViewById(R.id.todoText);
////        final Button button = (Button) findViewById(R.id.addButton);
////
////        button.setOnClickListener(new View.OnClickListener() {
////            public void onClick(View v) {
////
////                // Create a new child with a auto-generated ID.
////                DatabaseReference childRef = myRef.push();
////
////                // Set the child's data to the value passed in from the text box.
////                childRef.setValue(text.getText().toString());
////
////            }
////        });
//
//        // Delete items when clicked
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//
//                Query myQuery = myRef.orderByValue().equalTo((String)
//                        listView.getItemAtPosition(position));
//
//                myQuery.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        if (dataSnapshot.hasChildren()) {
//                            DataSnapshot firstChild = dataSnapshot.getChildren().iterator().next();
//                            firstChild.getRef().removeValue();
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//                    }
//                })
//                ;}
//        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            startActivity(new Intent(MainActivity.this, Main2Activity.class));
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
