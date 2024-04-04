package np.com.bimalkafle.todoapp

import java.time.Instant
import java.util.Date

object TodoManager {

    private val todoList = mutableListOf(
        Todo(1, "Prepare presentation for meeting", Date.from(Instant.now())),
        Todo(2, "Finish report on project progress", Date.from(Instant.now())),
        Todo(3, "Schedule follow-up call with client", Date.from(Instant.now())),
        Todo(4, "Review and update project timeline", Date.from(Instant.now())),
        Todo(5, "Prepare agenda for team meeting", Date.from(Instant.now())),
        Todo(6, "Research new software tools for development", Date.from(Instant.now())),
        Todo(7, "Send feedback to team members on recent work", Date.from(Instant.now())),
        Todo(8, "Draft proposal for new project", Date.from(Instant.now())),
        Todo(9, "Attend training session on agile methodologies", Date.from(Instant.now())),
        Todo(10, "Plan and organize team building activity", Date.from(Instant.now())),
        Todo(11, "Review and finalize budget for next quarter", Date.from(Instant.now())),
        Todo(12, "Update documentation for software release", Date.from(Instant.now()))
    )


    fun getAllTodo() : List<Todo>{
        return todoList
    }

    fun addTodo(title : String){
        todoList.add(Todo(System.currentTimeMillis().toInt(),title, Date.from(Instant.now())))
    }

    fun deleteTodo(id : Int){
        todoList.removeIf{
            it.id==id
        }
    }

}