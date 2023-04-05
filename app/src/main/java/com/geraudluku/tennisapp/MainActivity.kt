package com.geraudluku.tennisapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.geraudluku.tennisapp.ui.theme.TennisAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultPreview()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    val clubs = listOf(
        Club(
            "Women's Club",
            colorResource(id = R.color.women),
            painterResource(id = R.drawable.tennis_player)
        ),
        Club(
            "Men's Club",
            colorResource(id = R.color.men),
            painterResource(id = R.drawable.men_tennis_player)
        )
    )
    TennisAppTheme {
        Scaffold(
            backgroundColor = Color.White,
            topBar = {
                TopAppBar(
                    backgroundColor = Color.White,
                    contentPadding = PaddingValues(horizontal = 24.dp, vertical = 16.dp),
                    elevation = 0.dp
                ) {

                    IconButton(modifier = Modifier
                        .clip(shape = RoundedCornerShape(25))
                        .background(Color.Black),
                        onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "menu",
                            tint = Color.White
                        )
                    }

                    Spacer(Modifier.weight(1f))

                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search Icon",
                            tint = Color.Black,
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }
            },
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState(), true)
                    .padding(start = 24.dp)
            ) {

                Text(
                    text = stringResource(id = R.string.clubs),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.h3.fontSize,
                    modifier = Modifier.padding(bottom = 20.dp)
                )

                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(clubs) { club ->
                        ClubItem(club)
                    }
                }

                Spacer(modifier = Modifier.size(30.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 16.dp, bottom = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Train",
                        color = Color.Black,
                        fontSize = MaterialTheme.typography.h5.fontSize,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Alles",
                        color = colorResource(id = R.color.green),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Column {
                    for (i in 1..2) {
                        TrainItem()
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ClubItem(
    club: Club = Club(
        "Women's Club",
        colorResource(id = R.color.men),
        painterResource(id = R.drawable.men_tennis_player)
    )
) {

    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(30.dp))
            .background(club.color),
        contentAlignment = Alignment.Center
    ) {

        Row(
            modifier = Modifier
                .padding(start = 20.dp)
                .padding(top = 25.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(Modifier.width(150.dp)) {
                Text(
                    modifier = Modifier.padding(bottom = 10.dp),
                    text = club.title,
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.h4.fontSize,
                    fontWeight = FontWeight.Bold
                )

                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = Color.White
                    ),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.all_levels),
                        color = colorResource(id = R.color.black)
                    )
                }

                Spacer(modifier = Modifier.height(180.dp))

                Text(
                    text = stringResource(id = R.string.events),
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    modifier = Modifier.padding(bottom = 50.dp)
                )
            }

            //Tennis Player Image
            Image(
                painter = club.image,
                contentDescription = "A poster image of a tennis player",
                contentScale = ContentScale.FillBounds
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TrainItem() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(10.dp))
                .background(colorResource(id = R.color.green_ball))
                .padding(5.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.tennis_balls),
                contentDescription = "Tennis Ball"
            )
        }

        Spacer(modifier = Modifier.size(8.dp))

        Column {
            Text(
                text = "Yoga & Tennis",
                color = colorResource(id = R.color.black),
                fontSize = MaterialTheme.typography.h5.fontSize,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Feb 27 | 10:00am-11:00am",
                color = Color.LightGray,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 5.dp),
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier
                .clip(shape = CircleShape)
                .background(colorResource(id = R.color.black)),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = "$10",
                color = colorResource(id = R.color.white),
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(7.dp),
            )
        }

    }
}


data class Club(
    var title: String,
    var color: Color,
    var image: Painter
)