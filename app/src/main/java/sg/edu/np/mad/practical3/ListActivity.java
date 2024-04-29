package sg.edu.np.mad.practical3;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

import sg.edu.np.mad.madpractical3.R;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ImageView imageView = findViewById(R.id.imageView1);

        imageView.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
            builder.setTitle("Profile")
                    .setMessage("MADness");

            builder.setPositiveButton("VIEW", (dialog, id) -> {
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                Random random = new Random();
                int randomw = random.nextInt(100000000);
                String randomInt = Integer.toString(randomw);
                intent.putExtra("random integer", randomInt);
                startActivity(intent);
            });

            builder.setNegativeButton("CLOSE", (dialog, id) -> {
                dialog.dismiss();
            });

            AlertDialog dialog = builder.create();
            dialog.show();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}