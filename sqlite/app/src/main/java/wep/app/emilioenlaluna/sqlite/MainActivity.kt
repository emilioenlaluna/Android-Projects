package wep.app.emilioenlaluna.sqlite


import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

import wep.app.emilioenlaluna.sqlite.db.MyDbHelper
import wep.app.emilioenlaluna.sqlite.db.ToDoTable
import wep.app.emilioenlaluna.sqlite.models.ToDo

class MainActivity : AppCompatActivity() {
    val todos = ArrayList<ToDo>()
    private lateinit var lvTools: ListView
    private lateinit var etNewToDo: EditText
    private lateinit var btnAddToDo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find views by their IDs
        lvTools = findViewById(R.id.lvTools)
        etNewToDo = findViewById(R.id.etNewToDo)
        btnAddToDo = findViewById(R.id.btnAddToDo)

        val todoAdapter = ArrayAdapter<ToDo>(
            this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            todos
        )

        val db= MyDbHelper(this).writableDatabase

        fun refreshTodoList() {
            val todoList = ToDoTable.getAllNodos(db)
            todos.clear()
            todos.addAll(todoList)
            todoAdapter.notifyDataSetChanged()
        }

        refreshTodoList()

        // Set todo adapter to listView
        lvTools.adapter = todoAdapter

        btnAddToDo.setOnClickListener {
            val newToDo = ToDo(
                etNewToDo.text.toString(),
                false
            )
            ToDoTable.insertTodo(db, newToDo)
            refreshTodoList()
        }
    }
}
