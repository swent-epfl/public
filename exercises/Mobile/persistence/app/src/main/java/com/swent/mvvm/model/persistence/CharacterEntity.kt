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
    // TODO: Add the necessary fields to store the character's attributes of interest.
    @PrimaryKey val id: Int = 0 // Temporary placeholder, remember to remove it!
)