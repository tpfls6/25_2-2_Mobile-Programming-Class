package com.example.kotlinbasics

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlinbasics.ui.theme.KotlinBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinBasicsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        //week02Variables()
        //week02Functions()
        week03Classes()
        //week03Collections()
    }
}

private fun week02Variables(){
//    println("Week 02: Variables")
//
//    val courseName = "Mobile Programming"
//    //courseName = "IoT Programming" -> 에러
//    var week = 1
//    week = 2 //에러 X
//
//    println("Course : $courseName")
//    println("Week : $week")

    println("== Kotlin Variables ==")

    // val(immutable) vs var(mutable)
    val name = "Android"
    var version = 8

    println("Hello $name $version")

    val age: Int = 21
    val height: Double = 158.2 //명시 안해도 됨
    val isStudent: Boolean = true

    println("Age: $age, Height: $height, Student: $isStudent")

    //var nickname: String = null -> null 에러
    var nickname: String? = null // ? 붙이면 null 허용
    nickname = "barserin"
    println("Nickname: $nickname ${nickname?.length}")


}

private fun week02Functions(){
//    println("Week 02: Functions")
//
//    fun greet(name: String) = "Hello, $name!"
//
//    println(greet("Android developer"))

    println("== Kotlin Functions ==")

    fun greet(name: String): String {
        return "Hello, $name"
    }

    fun add(a: Int, b: Int) = a + b

    fun introduce(name: String, age: Int =19){ //단일 변수
        println("My name is $name and I'm $age years old")
    }

    println(greet("Kotlin"))
    println("Sum: ${add(5, -71)}")
    introduce("Kim", 7)
    introduce("Lee")
}

private fun week03Classes(){
    println("== Kotlin Classes ==")

    /*class Student{
        var name: String = ""
        var age: Int = 0

        fun introduce(){
            println("Hi, I'm $name and I'm $age years old")
        }
    }

    val student = Student()
    student.name = "Mirae"
    student.age = 21
    student.introduce()

    data class Person(val name: String, val age: Int)
    val person1 = Person("Kim", 23)
    val person2 = Person("Kim", 23) //두개는 같음, 주소도 같음

    println("Person1 : $person1")
    println("Equal? ${person1 == person2}")*/

    class Person(val name: String, var age: Int){
        fun introduce(){
            Log.d("KotlinWeek03", "안녕하세요, $name ($age)세 입니다.")
        }
        fun birthday(){
            age++ //후위 연산자 사용 가능
            Log.d("KotlinWeek03", "$name 의 생일! 이제 $age 세 ...")

        }
    }

    val person1 = Person("홍길동", 27)
    person1.introduce()
    person1.birthday()

    class Animal(var species: String){
        var weight: Double = 0.0 //필드 선언
        constructor(species: String, weight: Double) : this(species){
            this.weight = weight
            Log.d("KotlinWeek03", "$species 의 무게: $weight kg")
        } //매개변수 생성자

        fun makeSound(){
            Log.d("KotlinWeek03", "$species 가 소리를 냅니다.")
        }
    }

    val puppy = Animal("웰시코기", 10.5)
    puppy.makeSound()
}

private fun week03Collections(){
    println("== Kotlin Collections ==")

    val fruits = listOf("apple", "banana", "orange") // 리스트 (변경 X)
    val mutableFruits = mutableListOf("kiwi", "watermelon") // 리스트 (변경 O)

    //fruits.add() // 변경 X -> 쓸 때부터 에러
    println("Fruits : $fruits")

    mutableFruits.add("banana") // .add()로 추가
    println("MutableFruits : $mutableFruits")

    val scores = mapOf("Kim" to 100, "Park" to 97, "Lee" to 99)
    println("Scores : $scores")

    for(fruit in fruits){
        println("I like $fruit")
    }

    scores.forEach{(name, score) -> println("$name scored $score")}
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinBasicsTheme {
        Greeting("Android")
    }
}