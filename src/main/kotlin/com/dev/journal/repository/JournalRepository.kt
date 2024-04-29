package com.dev.journal.repository

import com.dev.journal.model.Entry
import org.springframework.data.repository.CrudRepository

interface JournalRepository: CrudRepository<Entry, Long> {
}