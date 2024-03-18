<template>
<div>

      <div class="container-fluid text-white text-center" style="background: #f7f8fa;">
        <div class="logo-home" >
          <img src="https://insight.lotusacademy.edu.vn/static/img/logo_new.png" alt="">     
        </div>
        <div style="width: 100%; height: 63%; padding: 0 100px;">
          <div class="header-content">
            <div class="content-left">
              <div class="form-search">
                <input type="text" class="search" style="background:white; border-radius:6px">
                <v-btn variant="text" icon="mdi-magnify" color="green"></v-btn>
              </div>
            </div>
            <div v-if="currentUser" class="content-right-user">
              <div class="hottime">
                  <font-awesome-icon :icon="['fas', 'phone']" style="width:20px;height:20px;color:#ff9800"/>
                  <span style="color:#ff9800; margin-left:13px;font-size:14px;font-weight:600; font-family:Montserrat,sans-serif">1900 6933</span>
              </div>
              <div v-if="currentUser['roles'].includes('ROLE_USER')">
                <router-link to="/my-course">
                  <v-chip style="color: #ff9800;"
                  prepend-icon="mdi-marker"
                  @click="showMyCourse"
                  >
                  Khóa học của tôi
                </v-chip>
              </router-link>
              </div>
              <div v-else>
                <router-link to="/admin">
                  <v-chip style="color: #ff9800;"
                  prepend-icon="mdi-marker"
                  @click="showAdminPage"
                  >
                  Quản trị
                </v-chip>
               </router-link>
              </div>

              <div>
                    <Notification
                    icon = "md-notifications"
                    style="color: red;"
                    auto-count
                 
                    @on-load-more="handleLoadMore"
                    @on-clear="handleClear"
                    >
                    <NotificationTab
                        title="Thông báo"
                        name="message"
                        :count="unreadMessage"
                        :loading="messageLoading"
                    >
                        <NotificationItem
                            v-for="(item, index) in messageList"
                            :key="index"
                            :title="item.title"
                            :icon="item.icon"
                            :icon-color="item.iconColor"
                            :time="item.time"
                            :read="item.read"
                        />
                    </NotificationTab>
                  </Notification>
              </div>
              <div class="form-menu-user">
                <v-menu class="menu-user" offset-y open-on-hover :open-delay="1">
                    <template v-slot:activator="{ props, on }">
                      <span style="cursor: pointer; " v-bind="props" v-on="on">
                        <v-chip link pill ripple>
                          <v-badge dot bottom color="green" offset-y="10" offset-x="10">
                            <vs-avatar badge-position="top-right" badge badge-color="#7d33ff" class="avatar-right">
                              <img src="https://cafefcdn.com/203337114487263232/2023/9/14/rose-1076012-1694666708340-1694666708455955673763.jpg" alt="">
                            </vs-avatar>
                          </v-badge>
                          
                        </v-chip>
                      </span>
                    </template>
                      <v-card
                      class="mx-auto"
                      width="256"
                      >
                      <v-layout>
                        <v-navigation-drawer permanent absolute>
                          <v-list>
                            <v-list-item
                              prepend-avatar="https://cafefcdn.com/203337114487263232/2023/9/14/rose-1076012-1694666708340-1694666708455955673763.jpg"
                              :title="currentUser.userName"
                              :subtitle="currentUser.email"
                            >
                              <template v-slot:append>
                                <v-btn
                                  size="small"
                                  variant="text"
                                  icon="mdi-menu-down"
                                ></v-btn>
                              </template>
                            </v-list-item>
                          </v-list>

                          <v-divider></v-divider>

                          <v-list
                            :lines="false"
                            density="compact"
                            nav
                          >
                            <v-list-item
                              v-for="(menu, i) in menusUser" @click="handleMenuItemClick(menu)"
                              :key="i"
                              :value="menu"
                              color="primary"
                            >
                              <template v-slot:prepend>
                                <v-icon :icon="menu.icon"></v-icon>
                              </template>

                              <v-list-item-title v-text="menu.text"></v-list-item-title>
                            </v-list-item>
                          </v-list>
                        </v-navigation-drawer>
                        <v-main style="height: 200px;"></v-main>
                      </v-layout>
                    </v-card>
                  </v-menu>
              </div>
            </div>
            <div v-if="!currentUser" class="content-right-public">
              <div class="hottime">
                  <font-awesome-icon :icon="['fas', 'phone']" style="width:20px;height:20px;color:#ff9800"/>
                  <span style="color:#ff9800; margin-left:13px;font-size:14px;font-weight:600; font-family:Montserrat,sans-serif">1900 6933</span>
              </div>
              <div  class="form-login-signup">
                <v-toolbar-items>
                  <router-link to="/login"><v-btn @click="showLogin" class="button" style="margin-right:20px !important; color:#666" variant="text">Đăng nhập</v-btn></router-link>
                  <v-divider vertical></v-divider>
                  <router-link to="/signup"><v-btn @click="showSignup" class="button" style="color:white;background-color:#ff9800; border:#ff9800" variant="text">Đăng ký</v-btn></router-link>
                </v-toolbar-items>
              </div>
            </div>
          </div>
      </div>
        <div class="header-bot">
          <v-card class="mx-auto"  style="width:100% !important; height:100% !important;background:#f7f8fa;padding-left:1.5%; ">
            <v-tabs style="height:100% !important" 
                          >
            <a style="color:black" href="https://hocmai.vn/gioi-thieu"><v-tab value="one" style="height:100%;padding:0 !important; margin-right:10px">Giới thiệu</v-tab></a>
            <v-tab value="two" style="height:100% "
              @mousemove="showNavigation(true)"
              @mouseleave="showNavigation(false)"
            >Các khóa học</v-tab>
            <router-link to="/post"> <v-tab v-if="currentUser" @click="showPost" value="three" style="height:100% ">Diễn đàn</v-tab> </router-link>
            <a style="color:black" href="https://hocmai.vn/ho-tro/c/huong-dan-dang-ky-khoa-hoc-va-thanh-toan-340.html"><v-tab value="four" style="height:100% ">Hướng dẫn đăng kí học </v-tab></a>
            <a style="color:black" href="https://hocmai.vn/ho-tro/"><v-tab value="five" style="height:100% ">Hỗ trợ</v-tab></a>
            </v-tabs>
          </v-card>
          </div>   
      </div>
      <div v-show="drawer" class="navigation" 
          @mouseover="showNavigation(true)" 
          @mouseleave="showNavigation(false)">
        <v-list :items="items"></v-list>
      </div>
 
    </div>
</template>

<script setup>
import { ref } from 'vue'
import eventBus from '@/eventBus.js'
import { useStore } from 'vuex';
import { useRouter } from 'vue-router';
const store  = useStore();
const router = useRouter();

const currentUser = store.state.auth.user;
// const roles =ref([])
// const getAllRole = () => {
//     roles.value = currentUser.roles;
//     console.log(roles)
// }
// getAllRole();
const menusUser = ref([
        { text: 'Thông tin cá nhân', icon: 'mdi-account '},
        { text: 'Đổi mật khẩu', icon: 'mdi-key' },
        { text: 'Đăng xuất', icon: 'mdi-logout' },
])
const handleMenuItemClick = (menu) =>{
      if (menu.text === "Thông tin cá nhân") {

      }else if (menu.text === "Đổi mật khẩu"){

      } else {
          store.dispatch("auth/logout");
          router.go(0);
      }
}

const showPost = () => {
  eventBus.emit('isShowPost', true)
}

const showLogin = () => {
//   isShowheaderHome.value = false;
     eventBus.emit('isShowheaderHome',false )

}
const showSignup = () => {
//   isShowheaderHome.value = false;
     eventBus.emit('isShowheaderHome', false)
}
const drawer = ref(false);

const showMyCourse = () => {
  eventBus.emit('showMyCourse', true)
}

const showAdminPage = () => {
  eventBus.emit('showAdminPage', true)
}
const showNavigation = (value) => {
  drawer.value = value;
};
</script>

<style lang = "css" scoped>
.header-home {
  position: sticky;
  top: 0;
  width: 100%;
  z-index: 1000;
  background: #f2f3f5; 
}
.container-fluid{
    padding: 0 !important;
    height:103px; 
    /* border-top:1px solid #a9a9a9; 
    border-bottom:1px solid #a9a9a9 */
    
}
.header-content{
    width: 100%;
    height: 100%;
    /* background-color:ghostwhite ; */
    position: relative;
    z-index: 1000;
    display: flex;
    align-items: center;
    justify-content: space-between;
}
.content-left{
  width: 50%;
  height: 100%;
  display: flex;
  align-items: center;
  
}
.logo-home {
  width: 110px;
  height: 102px;
  background-image: url(https://hocmai.vn/assets/front/images/snow.gif), url(https://hocmai.vn/assets/front/images/bg-noel.jpg);
  position: absolute;
  z-index: 10;
  margin-left: 100px;
  background-size: contain;
  background-size: 100% 100%, cover;
  background-position: 10px 15px, center center; 

}
.logo-home img{
  width: 100%;
  height: 100%;

}

.form-search{
  display: flex;
  align-items: center;
  justify-content: space-between;
  background: white;
  border-radius: 6px;
  border: unset;
  border: none;
  width: 300px;
  background-color: #f2f3f5;
  padding-left: 14px;
  padding-right: 0;
  padding-top: 9px;
  padding-bottom: 9px;
  height: 42px;
  margin-left: 130px;
}
.search{
  width: 255px;
  height: 100%;
  border: unset;
}
.v-btn{
  height: 42px;
}
.content-right-user{
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 50%;
  height: 100%;
  padding-left: 8%;
  float: right;
}
.content-right-public {
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 50%;
  height: 100%;
  padding-left: 17%;
  float: right;
}

.hottime{
  width: 162px;
  height: 100%;
  display: flex;
  align-items: center;
  border-left: 1px solid #eeeeee;
  border-right: 1px solid #eeeeee;
  padding: 5px 20px;
}
.form-login-signup   {
    padding: 10px 0;
    padding-left: 30px;
}
.v-toolbar-items{
  display: flex;
  align-items: center;

}
.form-menu-user{
  width: 20%;
  display:flex;
  align-items:center;

}
.form-menu-user > * {
  margin-left: auto;
}
.button{
  width: 110px !important;
  height: 40px !important;
  border: 1px solid #bdbdbd;
  border-radius: 5px ;
}
.itemMenus{
  display:flex;
  justify-content:space-between;
}
span .v-chip {
  width:100%;
  height:45px;
  background:#fff;
  padding: 0;
  border-radius: 15px !important;
}

.menu-user{
  margin-right:-100px !important;
}
.v-list-item {
  display:flex;
  align-items:center;
}
.mx-auto{
  border-radius:15px;
}
.header-bot{
  width: 100%;
  height: 37%;
  padding-left: 13%;
  background:#f7f8fa;
}
.v-tab{
  margin-left: 10px;
}
.navigation{
  border: 1px solid black;
  width: 300px;
  height: 400px;
  top: 105px;
  position: absolute;
  left: 328px;
  z-index: 1001;
}
</style>
