export default {
    name: "TodoList",
    template: `
    <tbody>
        <tr v-for="item in items">
            <td>{{ item.no }}</td>
            <td>{{ item.title }}</td>
            <td>{{ item.date }}</td>
            <td><span v-html="completedLabel(item.completed)"></span></td>
            <td>
                <button class="btn btn-danger btn-xs" @click="removeTodo(item.no)" v-bind:disabled="isDisabled(item)">삭제</button>
                <button class="btn btn-primary btn-xs" @click="completeTodo(item.no)" v-bind:disabled="canComplete(item)">완료</button>
            </td>
        </tr>
    </tbody>   
    `,
    props: {
        items: {
            type: Array,
            required: true
        },
    },
    methods: {
        removeTodo(no) {
            this.$emit('delete', no);
        },
        completeTodo(no) {
            this.$emit('done', no);
        },
        completedLabel: function(value) {
            return value ? '<span class="label label-success">처리완료</span>' : '<span class="label label-default">대기중</span>'
        },
        isDisabled: function (todo) {
            return !todo.completed;
        },
        canComplete: function (todo) {
            return todo.completed;
        }
    }
} 