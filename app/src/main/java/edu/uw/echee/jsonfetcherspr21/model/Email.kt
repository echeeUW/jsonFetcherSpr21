package edu.uw.echee.jsonfetcherspr21.model

data class Email(
    val id: Int,
    val from: String,
    val content: String? = null,
    val isImportant: Boolean,
)


val emailJsonString = """
    {
        "id": 0,
        "from": "seahawks@gmail.com",
        "content": "Go Hawks!!! SEA!! HAWKSSS!!!! Go 12s! Legion of boom",
        "isImportant": true
    }
""".trimIndent()
