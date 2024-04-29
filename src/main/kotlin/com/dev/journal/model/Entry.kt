package com.dev.journal.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Entry(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,
        val title: String,
        val content: String
) {
    constructor() : this(0, "", "")
}
