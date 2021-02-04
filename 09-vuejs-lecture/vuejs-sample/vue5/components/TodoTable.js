import TodoList from './TodoList.js'

export default {
    name: "TodoTable",
    template: `
        <table class="table" id="todos-table">
            <thead>
                <tr>
                    <th>순번</th>
                    <th>제목</th>
                    <th>예정일자</th>
                    <th>처리여부</th>
                    <th></th>
                </tr>
            </thead>
            <todo-list :items="todos" @delete="deleteTodo" @done="doneTodo"></todo-list>
        </table>
    `,
    beforeCreate: function() {
        var _this = this;
        axios.get('../resources/data/todos.json')
            .then(function(response) {
                _this.todos = response.data;
            });
    },
    data: function() {
        var data = {};
        data.todos = [];
        return data;
    },
    methods: {
        deleteTodo: function(no) {
            this.todos = this.todos.filter(function(todo, index) {
                return todo.no != no;
            });
        }, 
        doneTodo: function(no) {
            this.todos.forEach(function(todo, index) {
                if (todo.no == no) {
                    todo.completed = true;
                }
            });
        }
    },
    computed: {
        
    },
    components: {
        'todo-list': TodoList
    }
}