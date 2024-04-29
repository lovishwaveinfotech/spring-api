package com.dev.journal.controller

import com.dev.journal.model.Entry
import com.dev.journal.model.ResponseBody
import com.dev.journal.service.JournalService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping ("api")
class JournalController {

    @Autowired
    lateinit var service: JournalService

    @GetMapping("getAllData")
    fun getAllData(): ResponseBody {
        return ResponseBody(code = 200, status = true, message = "Data fetched successfully", data = service.getAllData())
    }

    @GetMapping("getDataById")
    fun getDataById(@RequestParam id: Long): ResponseBody {
        val data = service.getDataById(id)
        return if (!data.isEmpty) {
            ResponseBody(code = 200, status = true, message = "Data fetched successfully", data = data)
        }else {
            ResponseBody(code = 404, status = true, message = "Data not found", data = data)
        }
    }

    @PostMapping("createEntry")
    fun addEntry(@RequestBody body: Entry): ResponseBody {
        val data = service.createEntry(body)
        return ResponseBody(code = 200, status = true, message = "New entry added successfully", data = data)
    }

    @PutMapping("updateEntry")
    fun updateEntry(@RequestBody body: Entry): ResponseBody {
//        entry[body.id] = body
        return ResponseBody(code = 200, status = true, message = "Entry updated successfully", data = null)
    }

    @DeleteMapping("deleteEntry")
    fun deleteEntry(@RequestParam id: Long): ResponseBody {
        val isDeleted = service.deleteData(id)
        return if (isDeleted) {
            ResponseBody(code = 200, status = true, message = "Entry deleted successfully", data = null)
        } else {
            ResponseBody(code = 404, status = true, message = "Data not found", data = null)
        }
    }
}