# 컴포넌트 활용과 라우팅

## 슬롯
- vue.js의 컨텐츠 배포 API는 **&lt;slot&gt;** 요소를 컨텐츠 배포 통로로 사용한다.

### 슬롯에 컨텐츠 전달하기
- 단순 텍스트를 배포하는 통로가 되는 슬롯
```html
  <navigation-link url="/profile">
    Your profile
  </navigation-link>

  <script>
    const NavigationLink = {
      template : `
        <a v-bind:href="url" class="nav-link">
          <slot></slot>   <!-- NavigationLink 컴포넌트를 랜더링할 때 <slot></slot>는 <navigation-link>태그 내부의 "Your profie"로 교체된다. -->
        </a>
      `
    }
  </script>

  <!-- 렌더링된 결과 -->
  <a href="/profile">
    Your profile
  </a>
```
- HTML 컨텐츠를 배포하는 통로가 되는 슬롯
```html
  <navigation-link url="/profile">
    <span class="fa fa-user"></span>
    Your profile
  </navigation-link>

  <script>
    const NavigationLink = {
      template : `
        <a v-bind:href="url" class="nav-link">
          <slot></slot>   <!-- NavigationLink 컴포넌트를 랜더링할 때 <slot></slot>는 <navigation-link>태그 내부의 html 컨텐츠로 교체된다. -->
        </a>
      `
    }
  </script>

  <!-- 렌더링된 결과 -->
  <a href="/profile">
    <span class="fa fa-user"></span>
    Your profile
  </a>
```
- 다른 컴포넌트를 배포하는 통로가 되는 슬롯
```html
  <navigation-link url="/profile">
    <font-awesome-icon name="user"></font-awesome-icon>
    Your profile
  </navigation-link>

  <script>
    const NavigationLink = {
      template : `
        <a v-bind:href="url" class="nav-link">
          <slot></slot>   <!-- NavigationLink 컴포넌트를 랜더링할 때 <slot></slot>는 <navigation>태그 내부의 html 컨텐츠로 교체된다. -->
        </a>
      `
    }
  </script>
```

### 이름이 있는 슬롯(Named Slots)
- 이름이 있는 슬롯을 사용하면 여러 개의 슬롯을 사용할 수 있다.
- 이름있는 슬롯에서 &lt;slot&gt; 엘리먼트는 서로 다른 슬롯들을 정의할 때 쓸 수 있는 name이라는 특별한 속성을 가지고 있다.
```html
  <!-- 
    <base-layout> 컴포넌트의 템플릿이다.
   -->
  <div class="container">
    <header>
      <!-- 헤더를 여기에 넣는다. -->
      <slot name="header"></slot>
    </header>
    <main>
      <!-- 본문을 여기에 넣는다. -->
      <slot></slot>
    </main>
    <footer>
      <!-- 푸터는 여기에 넣는다. -->
      <slot name="footer"></slot>
    </footer>
  </div>
```
- 이름있는 슬롯에게 내용을 전달하려면 &lt;template&gt;에 v-slot 디렉티브를 쓰고 그 속성에 
  * &lt;template&gt; 엘리먼트의 모든 내용물은 지정된 슬롯으로 전달된다.
```html
  <base-layout>
    <!-- 
      <slot name="header"></slot>에 전달된 내용이다. 
    -->
    <template v-slot:header>
      <h1>헤더부</h1>
    </template>

    <!-- 
      <slot name="main"></slot>에 전달된 내용이다. 
    -->
    <template v-slot:main>
      <p>본문의 내용</p>
    </template>
    
    <!-- 
      <slot name="footer"></slot>에 전달된 내용이다. 
    -->
    <template v-slot:footer>
      <p>푸터의 내용</p>
    </template>
  </base-layout>
```

### 범위가 있는 슬롯(Scoped Slots)
- 자식 컴포넌트에서만 접근할 수 있는 데이터에서 슬롯에 필요한 내용을 가져와야할 때 사용된다.
  * 슬롯에서 제공되는 내용들은 부모 컴포넌트에서 렌더링되기 때문이다.
- 부모 컴포넌트의 슬롯에서 자식 컴포넌트에서만 접근할 수 있는 속성을 사용하기 위해서는 해당 속성을 &lt;slot&gt; 엘리먼트의 속성으로 연결해야 한다.
- &lt;slot&gt; 엘리먼트에 연결된 속성을 **슬롯속성(slot props)**라고 한다.
- 부모 컴포넌트의 범위(scope)에서 v-slot에 연결된 '슬롯속성'을 사용할 수 있다.
- 범위가 있는 슬롯 사용하기
```html
  <book-component :books="books">
    <template v-slot:header>    <!-- BookComponent의 header 슬롯에 전달될 내용을 포함하고 있음 -->
      <h1>{{header}}</h1>
    </template>
    <template v-slot:main="slotProps">  <!-- BookComponent의 main 슬롯에 전달될 내용을 포함하고 있음  slotProps는 슬롯속성으로 전달된 데이터를 참조하는 이름이다.-->
      <div><strong>{{slotProps.book.title}}</strong> <small>{{slotProps.book.author}}</small></div>
    </template>
  </book-component>

  <script>
    const BookComponent = {
      template: `
        <div>
          <slot name="header"></slot>   <!-- 부모 컴포넌트의 <template v-slot:header>의 컨텐츠가 렌더링된다.  -->
          <slot name="main"             <!-- 부모 컴포넌트의 <template v-slot:main>의 컨텐츠가 렌더링된다.  -->
            v-for="item in books"       <!-- books 배열의 각 요소를 순회한다. books배열의 각 요소들은 순서대로 item에 담긴다.  -->
            :book="item">               <!-- item변수에 저장된 배열의 각 요소를 슬롯속성으로 지정함. 부모 컴포넌트에서는 book 속성명으로 사용할 수 있음 -->
          </slot>
        </div>
      `,
      props:['books']
    };

    new Vue({
      el: "#app",
      components: {"book-component": BookComponent},
      data() {
        return {
          header: "책 목록",
          books: [
            {author: 'John Smith', title: 'Best of Times'},
            {author: 'Jane Doe', title: 'Go West Young Man'}
          ]
        }
      }
    })
  </script>
```

- 범위가 있는 슬롯 활용하기
```html
   <div id="app">
    <h1>{{title}}</h1>

    <h3>슬롯의 기본값 출력</h3>
    <todo-list v-bind:todos="todos"></todo-list>

    <h3>슬롯속성 제공받기 </h3>
    <todo-list v-bind:todos="todos">
      <template #todo={todo}>
        {{todo.id}} {{todo.text}} {{todo.completed}}
      </template>
    </todo-list>
    
    <h3>슬롯속성 활용하기</h3>
    <todo-list v-bind:todos="todos">
      <template #todo={todo}>
        <span v-if="todo.completed"><i class='fas fa-check'></i></span>
        {{todo.text}}
      </template>
    </todo-list>
  </div>

  <script>
    const TodoList = {
      template: `
        <ul>
          <li v-for="todo in todos" v-bind:key="todo.id">
            <slot name="todo" v-bind:todo="todo">
              <!-- 기본값 -->
              {{todo.text}}
            </slot>
          </li>
        </ul>
      `,
      props: ["todos"]
    }

    new Vue({
      el:"#app",
      data() {
        return {
          title: '일정 리스트',
          todos: [{id:'100', text: '연습1', completed:true}, {id:'200', text: '연습2', completed:false}, {id:'300', text: '연습3', completed:false}]
        }
      },
      components: {"todo-list": TodoList}
    });
  </script>
```