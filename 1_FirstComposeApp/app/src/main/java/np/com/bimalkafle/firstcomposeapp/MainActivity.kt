package np.com.bimalkafle.firstcomposeapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Column {
                Text(text = "Hello World!")
                Text(text = "Good Morning")
                Button(onClick = {
                    Toast.makeText(applicationContext,"Button is working",Toast.LENGTH_SHORT).show()
                }) {
                    Text(text = "Click Me")
                }
            }
        }
    }
}




