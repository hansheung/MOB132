package com.hansheung.mob132

//So for normal class we need to override toString, hashCode and equals to use them.
//But in data class it's already done
//On top of that, we have a copy function inside data class
data class Task(
    val id: Int? = null,
    val title: String,
    val desc: String,
    val status: Boolean = false
){
    //I need this function to create objects, so this function should be available before
    //creating any object
    companion object{
        fun generateTask(n:Int): List<Task>{
            return (1..n ).map {Task(title="Title $it", desc = "Description $it")}
        }
    }
}
