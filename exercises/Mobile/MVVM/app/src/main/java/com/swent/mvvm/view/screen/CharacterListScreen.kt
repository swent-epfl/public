package com.swent.mvvm.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.swent.mvvm.R
import com.swent.mvvm.model.api.ApiResponse
import com.swent.mvvm.model.data.Character
import com.swent.mvvm.viewmodel.CharacterViewModel

@Composable
fun CharacterListScreen(characterViewModel: CharacterViewModel = viewModel()) {
    /** This is the base of our screen, which is called in the MainActivity.
      It also contains the view model module. */

    Column {
        SimpleAppBar(title = "Your new TAs")
        CharactersContent(characterViewModel)
    }
}

@Composable
fun SimpleAppBar(title: String) {
    /** Acts as a title bar for the screen */
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(16.dp),
        )
    }
}

@Composable
fun CharactersContent(characterViewModel: CharacterViewModel) {
    /** The cool thing about @Composable is that when the LiveData changes
     it will automatically update any UI element linked to it for you! */

    // TODO: Depending on the ApiResponse from characterViewModel, we display the appropriate content
}

@Composable
fun CenteredMessage(message: String, isError: Boolean = false) {
    /** A composable that centers a message on the screen,
      notifying the user of any happenings. */
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier.padding(16.dp)
        ){
            Text(
                text = message,
                fontWeight = FontWeight.Bold,
                color = if (isError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun CharacterList(characters: List<Character>) {
    /** Lazy Column only composes and lays out the items
     that are visible on the screen, which makes it very efficient
     for long lists. This also delays downloading images. */

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(characters) { character ->
            CharacterItem(character)
        }
    }
}

@Composable
fun CharacterItem(character: Character) {
    Card(
        modifier = Modifier.padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(data = character.image)
                        .apply {
                            crossfade(true)
                            placeholder(R.drawable.ic_launcher_foreground)
                        }
                        .build()
                ),
                contentDescription = "Character Image of ${character.name}",
                modifier = Modifier
                    .size(100.dp)
                    .padding(4.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = character.name,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Species: ${character.species}"
                )
            }
        }
    }
}

@Preview
@Composable
fun CharacterItemPreview() {
    // TODO: Create a preview for the CharacterItem composable (use split screen to see the preview)
}
