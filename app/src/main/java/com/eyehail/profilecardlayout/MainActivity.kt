package com.eyehail.profilecardlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eyehail.profilecardlayout.ui.theme.MyTheme
import com.eyehail.profilecardlayout.ui.theme.lightGreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme() {
                MainScreen()
            }

        }
    }
}

@Composable
fun MainScreen() {
    //adding Scaffold - start
    //Scaffold "topBar: @Composable () -> Unit = {}" need composable so wrap function in curly brackets
    //else it will be stroke by red warning
    Scaffold(topBar = { AppBar() }) {
        Surface(modifier = Modifier
            .fillMaxSize(),
            //color = Color.LightGray) changed color in Theme.kt
        )
        {
            ProfileCard()
        }
    }

}

@Composable
fun AppBar() {
    TopAppBar(
        navigationIcon = { Icon(Icons.Default.Home,
        "content description") },
        title = { Text("Messaging Application Users") }
    )
}
//adding Scaffold - end

@Composable
fun ProfileCard() {
    Card(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .wrapContentHeight(align = Alignment.Top),
    elevation = 8.dp,
    //change card background color to white bcz Card inherit color from Theme
    backgroundColor = Color.White
    ) {
        Row(modifier = Modifier
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start) {
            ProfilePicture()
            ProfileContent()

        }

    }
}

@Composable
fun ProfilePicture() {
    Card(shape = CircleShape,
    border = BorderStroke(width = 2.dp,
        //color = Color.Green
    //apply newly added color from MaterialTheme.colors palette
    color = MaterialTheme.colors.lightGreen
    ),
        modifier = Modifier.padding(4.dp),
        elevation = 4.dp,
    // also have to change background here as above bcz Card inherit color from Theme.kt
    backgroundColor = Color.White
    ) {
        Image(
            painter = painterResource(id = R.drawable.dragon),
            contentDescription = "Content Description",
            modifier = Modifier.size(72.dp),
            contentScale = ContentScale.Crop
        )
    }

}

@Composable
fun ProfileContent() {
    Column(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()) {
        Text("John Doe", style = MaterialTheme.typography.h5)
        // making text a little transparent
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text("Active now", style = MaterialTheme.typography.body2)
        }

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyTheme() {
        MainScreen()
    }
}