package com.example.mealsuggest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 30.dp, top = 60.dp, end = 30.dp)
                )
                {

                    Text(
                        text = "Meal Suggest",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Black
                    )

                    Spacer(modifier = Modifier.size(30.dp))

                    OutlinedTextField(
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .border(1.dp, Color.Gray, shape = RoundedCornerShape(12.dp)),
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

                    Spacer(modifier = Modifier.size(10.dp))

                    Row {
                        Button(onClick = {
                            mealSuggestion = when(timeOfDay){
                                "Morning" -> "Scrambled eggs with spinach, tomatoes, and whole-grain toast"
                                "Mid morning" -> "Greek yogurt with honey and berries"
                                "Afternoon" -> "Grilled chicken salad with mixed greens, avocado, and a lemon vinaigrette"
                                "Mid afternoon" -> "Cottage cheese with sliced cucumber and a sprinkle of paprika"
                                "Evening" -> "Stir-fried beef with mixed vegetables"
                                "Late evening" -> "A handful of mixed nuts and dark chocolate"
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

                        Spacer(modifier = Modifier.size(15.dp))

                        Button(onClick = {
                            timeOfDay = ""
                            mealSuggestion = ""
                        }) {
                            Text(text = "Reset")
                        }
                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 25.dp)
                            .align(Alignment.Start),
                        fontWeight = FontWeight.Medium,
                        text = "Meal Suggestion:",
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 25.dp, end = 25.dp)
                            .align(Alignment.Start),
                        text = mealSuggestion
                    )

                }
            }
        }
    }
}

