package com.swent.mvvm.model.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * An entity representing a character in the
 * Rick and Morty universe.
 */
@Entity(tableName = "characters")
data class CharacterEntity(
    /** The name of the character. */
    @ColumnInfo(name = "name")
    @PrimaryKey val name: String,

    /** The species of the character. */
    @ColumnInfo(name = "species")
    val species: String,

    /** The URL of the character's image. */
    @ColumnInfo(name = "image")
    val image: String
)