package edu.uw.echee.jsonfetcherspr21.model

data class Email(
    val id: Int,
    val from: String,
    val content: String? = null,
    val isImportant: Boolean,
)
