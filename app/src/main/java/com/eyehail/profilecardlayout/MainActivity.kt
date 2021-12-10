package com.eyehail.profilecardlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.transform.CircleCropTransformation
import com.eyehail.profilecardlayout.ui.theme.MyTheme
import com.eyehail.profilecardlayout.ui.theme.lightGreen
import com.google.accompanist.coil.rememberCoilPainter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme() {
                UsersApplication()
            }

        }
    }
}

@Composable
fun UsersApplication(userProfiles: List<UserProfile> = userProfileList) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "users_list") {
        composable("users_list") {
            UserListScreen(userProfiles, navController)
        }
        // adding id for identifying userprofile
        composable(route = "user_details/{userId}",
        arguments = listOf(navArgument("userId") {
            type = NavType.IntType
        })) {navBackStackEntry ->
            UserProfileDetailsScreen(navBackStackEntry.arguments!!.getInt("userId"))
        }
    }
}

@Composable
// added to MainScreen userProfiles: List<UserProfile> = userProfileList as
//default parameter, so MainActivity doesnt need non empty constructor
fun UserListScreen(userProfiles: List<UserProfile>, navController: NavHostController?) {
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
                    ProfileCard(userProfile = userProfile) {
                        navController?.navigate("user_details/${userProfile.id}") // find navigate wiht route option
                    }
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
fun ProfileCard(userProfile: UserProfile, clickAction: () -> Unit) {
    Card(modifier = Modifier
        //changing padding
        .padding(top = 8.dp, bottom = 4.dp, start = 16.dp, end = 16.dp)
        .fillMaxWidth()
        .wrapContentHeight(align = Alignment.Top)
        .clickable(onClick = { clickAction.invoke() }),
    elevation = 8.dp,
    //change card background color to white bcz Card inherit color from Theme
    backgroundColor = Color.White
    ) {
        Row(modifier = Modifier
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start) {

            // changed userProfile.drawableId to userProfile.pictureUrl
            ProfilePicture(userProfile.pictureUrl, userProfile.status, 72.dp)
            ProfileContent(userProfile.name, userProfile.status, Alignment.Start)

        }

    }
}

@Composable
// also changed drawableId to pictureUrl
fun ProfilePicture(pictureUrl: String, onlineStatus: Boolean, imageSize: Dp) {
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

            painter = rememberCoilPainter(request = pictureUrl,
                    requestBuilder = {
                transformations(CircleCropTransformation())
            },),
            modifier = Modifier.size(imageSize),
        contentDescription = "Profile content description"
        )
    }

}

@Composable
fun ProfileContent(userName: String, onlineStatus: Boolean, alignment: Alignment.Horizontal) {
    Column(modifier = Modifier
        .padding(8.dp),
        //.fillMaxWidth() //comment it to center the content
    horizontalAlignment = alignment // to center status
    ) {
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

@Composable

fun UserProfileDetailsScreen(userId: Int) {
val userProfile = userProfileList.first { userProfile -> userId == userProfile.id }
    Scaffold(topBar = { AppBar() }) {
        Surface(modifier = Modifier
            .fillMaxSize(),
        )
        {
            Column(modifier = Modifier
                .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top) {
                ProfilePicture(userProfile.pictureUrl, userProfile.status, 240.dp)
                ProfileContent(userProfile.name, userProfile.status, Alignment.CenterHorizontally)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserProfileDetailsPreview() {
    MyTheme() {
        UserProfileDetailsScreen(userId = 0)
    }
}

@Preview(showBackground = true)
@Composable
fun UserListPreview() {
    MyTheme() {
        UserListScreen(userProfiles = userProfileList, null)
    }
}