package com.dev.journal.model

data class ResponseBody(
        val code: Long,
        val status: Boolean,
        val message: String,
        val data: Any?
)
