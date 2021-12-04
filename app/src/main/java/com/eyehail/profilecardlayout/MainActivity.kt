package com.eyehail.profilecardlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
// added to MainScreen userProfiles: List<UserProfile> = userProfileList as
//default parameter, so MainActivity doesnt need non empty constructor
fun MainScreen(userProfiles: List<UserProfile> = userProfileList) {
    //adding Scaffold - start
    //Scaffold "topBar: @Composable () -> Unit = {}" need composable so wrap function in curly brackets
    //else it will be stroke by red warning
    Scaffold(topBar = { AppBar() }) {
        Surface(modifier = Modifier
            .fillMaxSize(),
            //color = Color.LightGray) changed color in Theme.kt
        )
        {

            //adding LazyColumn
            LazyColumn {
                items(userProfiles) { userProfile ->
                    ProfileCard(userProfile = userProfile)
                }
            }





            }

        }
}



@Composable
fun AppBar() {
    TopAppBar(
        navigationIcon = { Icon(Icons.Default.Home,
        "content description", Modifier.padding(horizontal = 12.dp)) },
        title = { Text("Messaging Application Users") },

    )
}
//adding Scaffold - end

@Composable
fun ProfileCard(userProfile: UserProfile) {
    Card(modifier = Modifier
        //changing padding
        .padding(top = 8.dp, bottom = 4.dp, start = 16.dp, end = 16.dp)
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
            ProfilePicture(userProfile.drawableId, userProfile.status)
            ProfileContent(userProfile.name, userProfile.status)

        }

    }
}

@Composable
fun ProfilePicture(drawableId: Int, onlineStatus: Boolean) {
    Card(shape = CircleShape,
    border = BorderStroke(width = 2.dp,
        //color = Color.Green
    //apply newly added color from MaterialTheme.colors palette
    color =
        if (onlineStatus) {
            MaterialTheme.colors.lightGreen
        } else Color.Red

    ),
        modifier = Modifier.padding(4.dp),
        elevation = 4.dp,
    // also have to change background here as above bcz Card inherit color from Theme.kt
    backgroundColor = Color.White
    ) {
        Image(
            //replaced R.drawable.id by drawableId
            painter = painterResource(id = drawableId),
            contentDescription = "Content Description",
            modifier = Modifier.size(72.dp),
            contentScale = ContentScale.Crop
        )
    }

}

@Composable
fun ProfileContent(userName: String, onlineStatus: Boolean) {
    Column(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()) {
        CompositionLocalProvider(LocalContentAlpha provides (
                if (onlineStatus) 1f
                else ContentAlpha.medium))  {
            Text(userName, style = MaterialTheme.typography.h5)
        }

        // making text a little transparent
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(if (onlineStatus)"Active now" else "Offline", style = MaterialTheme.typography.body2)
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