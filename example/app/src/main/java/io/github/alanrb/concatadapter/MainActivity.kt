package io.github.alanrb.concatadapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ConcatAdapter
import io.github.alanrb.concatadapter.adapter.GalleryAdapter
import io.github.alanrb.concatadapter.adapter.HeaderAdapter
import io.github.alanrb.concatadapter.adapter.NoteAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val concatAdapter = ConcatAdapter()

    private val characterAdapter = HeaderAdapter(
        character = Character(
            name = "Mickey",
            avatar = "https://images.unsplash.com/photo-1535764558463-30f3af596bee?w=400&h=400"
        )
    )

    private val noteAdapter = NoteAdapter(
        message = "Beautiful photos from Unsplash",
        onDismissClicked = ::onDismissClicked
    )

    private val galleryAdapter = GalleryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        concatAdapter.addAdapter(characterAdapter)
        concatAdapter.addAdapter(noteAdapter)
        concatAdapter.addAdapter(galleryAdapter)

        galleryAdapter.items = listOf(
            Gallery(img = "https://images.unsplash.com/photo-1499087972600-5ae61724ff2b?w=600&h=400"),
            Gallery(img = "https://images.unsplash.com/photo-1528066588405-9e20509b9e34?w=600&h=400"),
            Gallery(img = "https://images.unsplash.com/photo-1547782101-30c84b97a71b?w=600&h=400"),
            Gallery(img = "https://images.unsplash.com/photo-1585578030055-c6e244eb52c7?w=600&h=400"),
            Gallery(img = "https://images.unsplash.com/photo-1561090164-41875ecdae5a?w=600&h=400")
        )
        galleryAdapter.notifyDataSetChanged()

        with(rvData) {
            adapter = concatAdapter
        }
    }

    private fun onDismissClicked() {
        concatAdapter.removeAdapter(noteAdapter)
    }
}