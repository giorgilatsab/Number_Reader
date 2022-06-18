package com.giorgi.number_reader

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.stream.Stream

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val read: Button = findViewById(R.id.read)
        val input: EditText = findViewById(R.id.inPut)
        val show: TextView = findViewById(R.id.show)

        read.setOnClickListener{
            val x:Int = input.text.toString().toInt()

            val one = listOf("ერთი","თერთმეტი","თორმეტი","ცამეტი","თოთხმეტი","თხუთმეტი",
                "თექვსმეტი","ჩვიდმეტი","თვრამეტი","ცხრამეტი")

                val two = listOf("ორი","ოცი","ოცდა")
                val tre = listOf("სამი","ოცდაათი",)
                val four = listOf("ოთხი","ორმოცი","ორმოცდა")
                val five = listOf("ხუთი","ორმოცდაათი")
                val six = listOf("ექვსი","სამოცი","სამოცდა")
                val seven = listOf("შვიდი","სამოცდაათი",)
                val eight = listOf("რვა","ოთხმოცი","ოთხმოცდა")
                val nine = listOf("ცხრა","ოთხმოცდაათი")
                val ten = listOf("ათი","ათი")

                val onehundred = "ასი"

            val listList = listOf(one,two,tre,four,five,six,seven,eight,nine,ten)

                if (x in 1..10)

                    show.setText(listList[x-1].first())

                else if (x in 11..19)
                {
                    show.setText(one[x-10])
                }

                else if (x in 20..99)
                {
                    val d = x%10
                    val c =  (x-d)/10
                    if (d==0){
                        show.setText(listList[c-1][1])
                    }

                    else if (listList[c-1].size == 3){
                        show.setText(listList[c-1].last() + listList[d-1].first())
                    }
                    else if (listList[c-1].size == 2){

                        show.setText(listList[c-2].last()  + one[d])
                    }

                }

                else if (x in 100..1000)     //100 დან 1000 მდე
                {
                    val d = x%100         //c-ასეული  m-ათეული k-ერთეული
                    val c =  (x-d)/100

                    val k = d%10
                    val m = (d-k)/10

                    if (x==100){
                        show.setText(onehundred)
                    }

                    else if (x> 100 && k in 1..10 && m==0 ){
                        if(c==1){
                            show.setText(onehundred.dropLast(1) + listList[k-1].first())
                        }
                        else{
                            show.setText( listList[c-1].first().dropLast(1) + onehundred.dropLast(1) + listList[d-1].first()) //***
                        }
                    }

                    else if (x>100 && m==1 && k in 1..9)  {//211,515,...

                        if(c==1){
                            show.setText(onehundred.dropLast(1) + one[k])
                        }
                        else
                        {
                            show.setText(listList[c-1].first().dropLast(1) + onehundred.dropLast(1) + one[k]) //211,319..
                        }
                    }

                    else if (x>100 && m>1 && c>1){

                        if (k==0){
                            show.setText(listList[c-1].first() + onehundred.dropLast(1)  + listList[m-1][1])
                        }

                        else if (listList[m-1].size==3){
                            if (listList[c-1].first() == "რვა" ||  listList[c-1].first() == "ცხრა" ){
                                show.setText(listList[c-1].first() + onehundred.dropLast(1) + listList[m-1].last() + listList[k-1].first())
                            }
                            else
                            show.setText(listList[c-1].first().dropLast(1) + onehundred.dropLast(1) + listList[m-1].last() + listList[k-1].first())
                        }
                        else if (listList[m-1].size==2){
                            if(listList[c-1].first() == "რვა" ||  listList[c-1].first() == "ცხრა"){
                                show.setText(listList[c-1].first() + onehundred.dropLast(1) + listList[m-2].last() + one[k])
                            }
                            else{
                                show.setText(listList[c-1].first().dropLast(1) + onehundred.dropLast(1) + listList[m-2].last() + one[k])
                            }
                        }

                    }

                    else if (k==0 && m==0)
                    {
                        if(listList[c-1].first() == "რვა" ||  listList[c-1].first() == "ცხრა"){
                            show.setText(listList[c-1].first() + onehundred)
                        }
                        else {
                        show.setText(listList[c-1].first().dropLast(1) + onehundred)
                        }
                    }
                    else if (x==100){
                        show.setText("ათასი")
                    }

                }
            }
    }
}


