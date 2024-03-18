<template>
<div>
<nav class="navbar bg-primary">
  <div class="header-content">
        <v-app-bar-nav-icon
          variant="text"
          @mousemove="showNavigation(true)"
          @mouseleave="showNavigation(false)"
          
        ></v-app-bar-nav-icon>

        <div class="title">Các khóa học</div>
        <div class="form-search">
          <input type="text" class="search">
          <v-btn variant="text" icon="mdi-magnify" color="green"></v-btn>
        </div>

        <v-spacer></v-spacer>
        <div class="form-login-signup">
          <ul>
            <router-link to="/login"><li><a href="">Đăng nhập</a></li></router-link>
            <router-link to="/signup"><li style="background:#f68b20;"><a href="">Đăng ký</a></li></router-link>
          </ul>
        </div>
        </div>
</nav>
      <div v-show="drawer" class="navigation" 
          @mouseover="showNavigation(true)" 
          @mouseleave="showNavigation(false)">
        <v-list :items="items"></v-list>
      </div>
</div>      
</template>

<script setup>
import { ref } from 'vue';

const drawer = ref(false);

const items = [
  {
    title: 'Foo',
    value: 'foo',
  },
  {
    title: 'Bar',
    value: 'bar',
  },
  {
    title: 'Fizz',
    value: 'fizz',
  },
  {
    title: 'Buzz',
    value: 'buzz',
  },
   {
    title: 'Buzz',
    value: 'buzz',
  },
];

const showNavigation = (value) => {
  drawer.value = value;
};
</script>


<style scoped >

.header-content{
  padding:0 248px;
  width:100%; 
  height:100%;
  display:flex; 
  align-items: center;
}

.title{
  width: 100px;
 
}
.form-search{
  display: flex;
  align-items: center;
  background: white;
  border-radius: 10px;
  border: none;
  width: 258px;
  height: 36px;
}
.search{
  width: 255px;
  height: 36px;
  border-radius: 10px;
  padding: 5px 10px;
}
.form-login-signup{
  height: 100%;
  width: 203px;
  display: flex;
  align-items: center;
}
.form-login-signup ul{
  align-items: center;
  margin-bottom: 0;
  padding: 0;
}
.form-login-signup li {
  list-style-type: none;
  display: inline-block;
  border-radius: 3px;
}
.form-login-signup li a {
  line-height: 32px;
  color: white;
  text-decoration: none;
  margin-right: 10px;
}
.navigation{
  border: 1px solid black;
  width: 300px;
  height: 400px;
  top: 55px;
  position: absolute;
  left: 260px;
  z-index: 1;
}



</style>