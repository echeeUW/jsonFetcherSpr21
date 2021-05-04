package edu.uw.echee.jsonfetcherspr21.model


data class Inbox(
        val title: String,
        val emails: List<Email>,
)

private val emailsJsonString = """
    {
        "title": "Mailed It - App",

    	"emails": [
    		{
    			"id": 0,
    			"from": "seahawks@gmail.com",
    			"content": "Go Hawks!!! SEA!! HAWKSSS!!!! Go 12s! Legion of boom",
    			"isImportant": true
    		},
    		{
    			"id": 1,
    			"from": "49ers@hotmail.com",
    			"content": "Let's go Niners!!! Richard Sherman interception! Ay bay bay",
    			"isImportant": false
    		},
    		{
    			"id": 2,
    			"from": "patriots@aol.com",
    			"content": "We like flat footballs and spy cameras",
    			"isImportant": false
    		},
    		{
    			"id": 3,
    			"from": "tony@starkindustries.com",
    			"content": "I am Iron-Man and I love cheeseburgers. I love you 3000",
    			"isImportant": true
    		}
    	]
    }
""".trimIndent()
