package sg.edu.np.mad.madpractical3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        User user = new User("John Doe", "MAD Developer", 1, false);
        String randomInt = getIntent().getStringExtra("random integer");
        if (randomInt != null) {
            user.name = "MAD " + randomInt;
        }
        TextView tvDescription = findViewById(R.id.tvDescription);
        TextView tvName = findViewById(R.id.tvName);
        Button btnFollow = findViewById(R.id.btnFollow);
        tvName.setText(user.name);
        tvDescription.setText(user.description);
        btnFollow.setText("Follow");
        btnFollow.setOnClickListener(v -> {
            if (user.followed) {
                btnFollow.setText("Follow");
                user.followed = false;
                Toast toast = Toast.makeText(this, "Unfollowed", Toast.LENGTH_SHORT);
                toast.show();
            } else {
                btnFollow.setText("Unfollow");
                user.followed = true;
                Toast toast = Toast.makeText(this, "Followed", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}