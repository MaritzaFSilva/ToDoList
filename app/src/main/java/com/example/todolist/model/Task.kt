package com.example.todolist.model


data class Task(var id : Int,var title: String, var description: String,var status: Boolean ) {
    companion object{
        fun example():MutableList<Task>{
            return mutableListOf(
                Task(1,"Lavar Louça","Lavar a louça do almoço",true),
                Task(2,"Limpa a casa","Começar pela sala e limpar todos os quartos, lavar o banheiro",true),
                Task(3,"Lavar Roupa","Lavar as roupas, primeiro as coloridas",false))
        }
    }
}