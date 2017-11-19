//package com.millionacrenest.laborpost;
//
//import android.*;
//import android.Manifest;
//import android.app.ProgressDialog;
//import android.content.Context;
//import android.content.Intent;
//import android.content.pm.PackageManager;
//import android.net.Uri;
//import android.os.Build;
//import android.provider.MediaStore;
//import android.support.annotation.NonNull;
//import android.support.v4.content.ContextCompat;
//import android.support.v4.content.IntentCompat;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.firebase.client.Firebase;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.storage.FirebaseStorage;
//import com.google.firebase.storage.StorageReference;
//
//import static android.content.Intent.ACTION_PICK;
//import static android.content.Intent.CATEGORY_APP_GALLERY;
//
//public class Poster extends AppCompatActivity {
//
//    Button select_image, savePost;
//    ImageView post_image;
//    TextView postTitle, postBody;
//    public static final int READ_EXTERNAL_STORAGE = 0;
//    private ProgressDialog mProgressDialog;
//    private Firebase mPostRef;
//    private Uri mImageUri = null;
//    private DatabaseReference mDatabaseRef;
//    private StorageReference mStorage;
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_poster);
//
//        Firebase.setAndroidContext(this);
//        select_image = (Button)findViewById(R.id.select_image);
//        savePost = (Button)findViewById(R.id.savePost);
//        post_image = (ImageView)findViewById(R.id.post_image);
//        postTitle = (TextView)findViewById(R.id.postTitle);
//        postBody = (TextView)findViewById(R.id.postBody);
//
//
//        select_image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE) !=
//                        PackageManager.PERMISSION_GRANTED) {
//                    Toast.makeText(getApplicationContext(), "Call for permission", Toast.LENGTH_SHORT).show();
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                        requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, READ_EXTERNAL_STORAGE);
//                    }
//                } else {
//                    //callgallary();
//                }
//            }
//
//
//        });
//
//        mDatabaseRef = FirebaseDatabase.getInstance().getReference();
//        mPostRef = new Firebase("gs://distro-168522.appspot.com").child("dailyNotes").push();
//        mStorage = FirebaseStorage.getInstance().getReferenceFromUrl("gs://distro-168522.appspot.com");
//
//
//        savePost.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                final String mName = postTitle.getText().toString();
//
//                if(mName.isEmpty())
//                {
//                    Toast.makeText(getApplicationContext(), "Fill all fields", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                Firebase childRef_name = mPostRef.child("image_title");
//                childRef_name.setValue(mName);
//                Toast.makeText(getApplicationContext(), "Update Info", Toast.LENGTH_SHORT).show();
//
//            }
//
//        });
//
//
//
//    }
//
//    //@Override
//    public void onRequestPermissionResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        switch (requestCode) {
//            case READ_EXTERNAL_STORAGE:
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
//                    callgallary();
//                return;
//
//        }
//        Toast.makeText(getApplicationContext(), "....", Toast.LENGTH_SHORT).show();
//
//
//    }
//
//    private void callgallery() {
//        Intent intent = new Intent(Intent.ACTION_PICK);
//        intent.setType("image/*");
//        startActivityForResult(intent, GALLERY_PICK);
//    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
////        if (requestCode == ACTION_PICK)
//
//
//    }
//
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
