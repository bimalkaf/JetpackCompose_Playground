package np.com.bimalkafle.bottomnavigationdemo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import np.com.bimalkafle.bottomnavigationdemo.pages.HomePage
import np.com.bimalkafle.bottomnavigationdemo.pages.NotificationPage
import np.com.bimalkafle.bottomnavigationdemo.pages.SettingsPage


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    
    
    val navItemList = listOf(
        NavItem("Home", Icons.Default.Home,0),
        NavItem("Notification", Icons.Default.Notifications,5),
        NavItem("Settings", Icons.Default.Settings,0),
    )

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }
    
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed { index, navItem -> 
                    NavigationBarItem(
                        selected =  selectedIndex == index ,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
                            BadgedBox(badge = {
                                if(navItem.badgeCount>0)
                                    Badge(){
                                        Text(text = navItem.badgeCount.toString())
                                    }
                            }) {
                                Icon(imageVector = navItem.icon, contentDescription = "Icon")
                            }
                               
                        },
                        label = {
                            Text(text = navItem.label)
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        ContentScreen(modifier = Modifier.padding(innerPadding),selectedIndex)
    }
}


@Composable
fun ContentScreen(modifier: Modifier = Modifier, selectedIndex : Int) {
    when(selectedIndex){
        0-> HomePage()
        1-> NotificationPage()
        2-> SettingsPage()
    }
}



















