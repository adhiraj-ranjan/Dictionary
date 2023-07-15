package com.looker.dictionary

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.looker.ui.WordSearchPage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		val sharedText = intent?.getStringExtra(Intent.EXTRA_TEXT)
		if (sharedText != null) {
			setContent {
				DictionaryApp {
					WordSearchPage(initialSearchQuery = sharedText)
				}
			}
		} else {
			setContent {
				DictionaryApp {
					WordSearchPage()
				}
			}
		}

		WindowCompat.setDecorFitsSystemWindows(window, false)
	}
}
