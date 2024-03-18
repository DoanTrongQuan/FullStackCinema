<template>
  <h1>This is page Edit User</h1>
</template>

<script setup>
import eventBus from '@/eventBus.js'
import  { onBeforeRouteLeave }  from 'vue-router';
import { useRouter } from 'vue-router'

const router = useRouter();
onBeforeRouteLeave((to, from, next) => {
      eventBus.emit('hiddenAddUser', false)
      router.push("/management/user")
      next();
    });

</script>

<style>

</style>
