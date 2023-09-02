package com.bleh.resqmeal.viewmodels

import androidx.lifecycle.ViewModel
import com.bleh.resqmeal.R
import kotlinx.coroutines.flow.MutableStateFlow

data class BottomNavigationItem(
    val title: String,
    val iconUnselected: Int,
    val iconSelected: Int,
    val route: String,
)

class MainViewModel(): ViewModel() {
    val bottomNavigationItems = listOf(
        BottomNavigationItem(
            title = "Home",
            iconUnselected = R.drawable.ic_home,
            iconSelected = R.drawable.ic_home_selected,
            route = "home",
        ),
        BottomNavigationItem(
            title = "Food",
            iconUnselected = R.drawable.ic_bowl,
            iconSelected = R.drawable.ic_bowl_selected,
            route = "food",
        ),
        BottomNavigationItem(
            title = "Add",
            iconUnselected = R.drawable.ic_add,
            iconSelected = R.drawable.ic_add_selected,
            route = "add",
        ),
        BottomNavigationItem(
            title = "Profile",
            iconUnselected = R.drawable.ic_profile,
            iconSelected = R.drawable.ic_profile_selected,
            route = "profile",
        ),
    )

    private val _selectedItemIndex = MutableStateFlow(0)
    val selectedItemIndex = _selectedItemIndex

    fun setSelectedItemIndex(index: Int) {
        _selectedItemIndex.value = index
    }
}