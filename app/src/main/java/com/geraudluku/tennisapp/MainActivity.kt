package com.geraudluku.tennisapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.geraudluku.tennisapp.ui.theme.TennisAppTheme
import com.geraudluku.tennisapp.R

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
    TennisAppTheme {
        Scaffold(
            backgroundColor = Color.White,
            topBar = {
                TopAppBar(
                    backgroundColor = Color.White,
                    contentPadding = PaddingValues(horizontal = 24.dp, vertical = 16.dp),
                    elevation = 0.dp
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(Color.Black),
                            contentAlignment = Alignment.Center
                        ) {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    imageVector = Icons.Default.Menu,
                                    contentDescription = "Hamburger Menu",
                                    modifier = Modifier.padding(2.dp),
                                    tint = Color.White
                                )
                            }
                        }

                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = "Search Icon",
                                tint = Color.Black,
                                modifier = Modifier.size(32.dp)
                            )
                        }
                    }
                }
            },
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 24.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.clubs),
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.h3.fontSize
                )

                Spacer(modifier = Modifier.size(10.dp))

                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(2) {
                        ClubItem()
                    }
                }

                Spacer(modifier = Modifier.size(30.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Train",
                        color = Color.Black,
                        fontSize = MaterialTheme.typography.h4.fontSize,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Alles",
                        color = colorResource(id = R.color.green),
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.size(10.dp))

                LazyColumn() {
                    items(2) {
                        TrainItem()
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ClubItem(title: Int = R.string.women_club, image: Int = R.drawable.tennis_player) {
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(30.dp))
            .background(colorResource(id = R.color.row1)),
        contentAlignment = Alignment.Center
    ) {
        Row(modifier = Modifier.padding(vertical = 50.dp, horizontal = 20.dp)) {
            Column {
                Text(
                    modifier = Modifier.padding(bottom = 10.dp),
                    text = stringResource(id = title),
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

                Spacer(modifier = Modifier.height(50.dp))

                Text(
                    text = stringResource(id = R.string.events),
                    color = Color.Black,
                    fontSize = 22.sp,
                )
            }

            //Tennis Player Image
            Image(
                painter = painterResource(id = image),
                contentDescription = "A poster image of a tennis player",
//                contentScale = ContentScale.FillBounds
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