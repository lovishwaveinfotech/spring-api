package com.dev.journal.service

import com.dev.journal.model.Entry
import com.dev.journal.repository.JournalRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList


@Service
class JournalService {

    @Autowired
    lateinit var repository: JournalRepository

    fun getAllData(): MutableList<Entry> {
        val data: MutableList<Entry> = ArrayList()
        repository.findAll().forEach { entry -> data.add(entry) }
        return data
    }

    fun getDataById(id: Long): Optional<Entry> {
        return repository.findById(id)
    }

    fun deleteData(id: Long): Boolean {
        val data = getDataById(id)
        if (data.isPresent) {
            repository.deleteById(id)
            return true
        } else {
            return false
        }
    }

    fun createEntry(data: Entry): Entry {
        repository.save(data)
        return data
    }
}