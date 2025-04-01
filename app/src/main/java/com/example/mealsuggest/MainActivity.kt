package com.example.mealsuggest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mealsuggest.ui.theme.MealSuggestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent() {
            var mealSuggestion by remember {
                mutableStateOf("")
            }

            var timeOfDay by remember {
                mutableStateOf("")
            }

            MealSuggestTheme {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize())
                {
                    Spacer(modifier = Modifier.size(30.dp))

                    Text(
                        text = "Meal Suggest",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Black
                    )

                    OutlinedTextField(
                        value = timeOfDay,
                        onValueChange = {
                            text ->
                            timeOfDay = text
                        },
                        placeholder = {
                            Text(text = "Enter Time Of Day Here")
                        },
                        keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences)
                    )

                    Row {
                        Button(onClick = {
                            mealSuggestion = when(timeOfDay){
                                "Morning" -> "Scrambled eggs with spinach, tomatoes, and whole-grain toast"
                                "Mid-morning" -> "Greek yogurt with honey and berries"
                                "Afternoon" -> "Grilled chicken salad with mixed greens, avocado, and a lemon vinaigrette"
                                "Mid-afternoon" -> "Cottage cheese with sliced cucumber and a sprinkle of paprika"
                                "Evening" -> "Stir-fried beef or tempeh with brown rice and mixed vegetables"
                                "Evening snack" -> "A handful of mixed nuts and dark chocolate"
                                else -> "Invalid time of day, please try the following: " +
                                        "\n - Morning" +
                                        "\n - Mid morning" +
                                        "\n - Afternoon" +
                                        "\n - Mid afternoon" +
                                        "\n - Evening" +
                                        "\n - Late evening"
                            }
                            println(timeOfDay)
                            println(mealSuggestion)
                        }) {
                            Text(text = "Find Meal")
                        }
                        Button(onClick = {}) {
                            Text(text = "Reset")
                        }
                    }

                    Text(text = "Meal Suggestion: \n\n $mealSuggestion")

                }
            }
        }
    }
}

