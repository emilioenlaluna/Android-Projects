package wep.app.emilioenlaluna.sqlite.models

data class ToDo(var task:String,var done:Boolean){
    override fun toString(): String {
        return this.task
    }
}
