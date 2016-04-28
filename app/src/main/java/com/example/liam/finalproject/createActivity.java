package com.example.liam.finalproject;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;

import java.util.HashMap;

public class createActivity extends AppCompatActivity {

    Firebase mRef;
    EditText p1, p2, p3, p4, p5, p6, p7, p8, p9, name;
    Button submit,pickTeamImg;
    String imgDecodableString;
    String imageURL;
    private static int RESULT_LOAD_IMAGE = 1;
    final private String url = "https://diamond-tracker.firebaseio.com/League";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        mRef= new Firebase(url);

        TextView title = (TextView) findViewById(R.id.t);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/playball.ttf");
        title.setTypeface(tf);

        p1 = (EditText)findViewById(R.id.edit1);
        p2 = (EditText)findViewById(R.id.edit2);
        p3 = (EditText)findViewById(R.id.edit3);
        p4 = (EditText)findViewById(R.id.edit4);
        p5 = (EditText)findViewById(R.id.edit5);
        p6 = (EditText)findViewById(R.id.edit6);
        p7 = (EditText)findViewById(R.id.edit7);
        p8 = (EditText)findViewById(R.id.edit8);
        p9 = (EditText)findViewById(R.id.edit9);
        name = (EditText)findViewById(R.id.editName);

        submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createTeam();
            }
        });

        pickTeamImg = (Button)findViewById(R.id.teamImage);
        pickTeamImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK
                    && null != data) {
                // Get the Image from data

                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };

                // Get the cursor
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableString = cursor.getString(columnIndex);
                imageURL = imgDecodableString;
                cursor.close();
                // Set the Image in ImageView after decoding the String

                //test.setImageBitmap(BitmapFactory.decodeFile(imgDecodableString));

            } else {
                Toast.makeText(this, "You haven't picked Image",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }

    }

    private void createTeam() {
        if (imageURL == null || name.getText().toString() == "" || p1.getText().toString() == "" || p2.getText().toString() == "" || p3.getText().toString() == "" || p4.getText().toString() == "" || p5.getText().toString() == "" || p6.getText().toString() == "" || p7.getText().toString() == "" || p8.getText().toString() == "" || p9.getText() == null) {
            Toast.makeText(getApplicationContext(), "Team could not be added", Toast.LENGTH_LONG).show();
            return;
        }


        int temp = ((MyApplication) this.getApplication()).getCount();
        Firebase teamRef = mRef.push();

        HashMap<String, Object> team = new HashMap<>();
        team.put("id", teamRef.getKey());
        team.put("pitcher", p1.getText().toString());
        team.put("catcher", p2.getText().toString());
        team.put("first", p3.getText().toString());
        team.put("second", p4.getText().toString());
        team.put("third", p5.getText().toString());
        team.put("shortStop", p6.getText().toString());
        team.put("leftField", p7.getText().toString());
        team.put("centerField", p8.getText().toString());
        team.put("rightField", p9.getText().toString());
        team.put("name", name.getText().toString());
        team.put("url", imageURL);
        team.put("wins", 0);
        team.put("losses", 0);

        teamRef.setValue(team);
        Toast.makeText(getApplicationContext(), "Team added", Toast.LENGTH_LONG).show();

        ((MyApplication) this.getApplication()).incrementCount();

        Intent intent = new Intent(this,AppActivity.class);
        startActivity(intent);
    }
}
