package com.enzank.countryapp.presentation.country_details.components

import android.view.Display.Mode
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enzank.countryapp.domain.model.CountryDetails

@Composable
fun CountryHeader(countryDetails: CountryDetails) {
    countryDetails.country?.name?.common?.let {
        Text(
            text = it,
            style = TextStyle(
                color = Color.Black,
                fontSize = 40.sp,
                fontWeight = FontWeight.ExtraBold
            ),
            modifier = Modifier.padding(12.dp)
        )
    }

    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
        countryDetails.population?.let {
            Text(
                text = "Population: $it",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                ),
                modifier = Modifier.padding(8.dp)
            )
        }

        countryDetails.currency?.let {
            Text(
                text = "Currency: ${it.name} Symbol: ${it.symbol}",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                ),
                modifier = Modifier.padding(8.dp)
            )
        }

        countryDetails.region?.let {
            Text(
                text = "Region: $it",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                ),
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}