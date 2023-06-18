package com.example.netclantest.core.explorescreen.topbar

sealed class Tabs(
    val navigation: String,
    val title: String,
) {
    object Personal : Tabs(
        navigation = "personal_screen",
        title = "Personal",
    )

    object Business : Tabs(
        navigation = "business_screen",
        title = "Business",

    )

    object Merchant : Tabs(
        navigation = "merchant_screen",
        title = "Merchant",

    )
}
